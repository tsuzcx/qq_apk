package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer
{
  private static final String INTERPRET_LOCK_FILE_NAME = "interpret.lock";
  private static final String TAG = "Tinker.ParallelDex";
  
  public static boolean optimizeAll(Context paramContext, Collection<File> paramCollection, File paramFile, ResultCallback paramResultCallback)
  {
    return optimizeAll(paramContext, paramCollection, paramFile, false, null, paramResultCallback);
  }
  
  public static boolean optimizeAll(Context paramContext, Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, ResultCallback paramResultCallback)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, new Comparator()
    {
      public final int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        long l1 = paramAnonymousFile1.length();
        long l2 = paramAnonymousFile2.length();
        if (l1 < l2) {
          return 1;
        }
        if (l1 == l2) {
          return 0;
        }
        return -1;
      }
    });
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!new OptimizeWorker(paramContext, (File)paramCollection.next(), paramFile, paramBoolean, paramString, paramResultCallback).run()) {
        return false;
      }
    }
    return true;
  }
  
  static class OptimizeWorker
  {
    private static final String PM_INTERFACE_DESCRIPTOR = "android.content.pm.IPackageManager";
    private static String targetISA = null;
    private final TinkerDexOptimizer.ResultCallback callback;
    private final Context context;
    private final File dexFile;
    private final File optimizedDir;
    private final boolean useInterpretMode;
    
    OptimizeWorker(Context paramContext, File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
    {
      this.context = paramContext;
      this.dexFile = paramFile1;
      this.optimizedDir = paramFile2;
      this.useInterpretMode = paramBoolean;
      this.callback = paramResultCallback;
      targetISA = paramString;
    }
    
    private void interpretDex2Oat(String paramString1, String paramString2)
    {
      localObject1 = new File(paramString2);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).getParentFile().mkdirs();
      }
      localObject2 = new File(((File)localObject1).getParentFile(), "interpret.lock");
      localObject1 = null;
      try
      {
        localObject2 = ShareFileLockHelper.getFileLock((File)localObject2);
        localObject1 = localObject2;
        ArrayList localArrayList = new ArrayList();
        localObject1 = localObject2;
        localArrayList.add("dex2oat");
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject1 = localObject2;
          localArrayList.add("--runtime-arg");
          localObject1 = localObject2;
          localArrayList.add("-classpath");
          localObject1 = localObject2;
          localArrayList.add("--runtime-arg");
          localObject1 = localObject2;
          localArrayList.add("&");
        }
        localObject1 = localObject2;
        localArrayList.add("--dex-file=".concat(String.valueOf(paramString1)));
        localObject1 = localObject2;
        localArrayList.add("--oat-file=".concat(String.valueOf(paramString2)));
        localObject1 = localObject2;
        localArrayList.add("--instruction-set=" + targetISA);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT > 25)
        {
          localObject1 = localObject2;
          localArrayList.add("--compiler-filter=quicken");
        }
        for (;;)
        {
          localObject1 = localObject2;
          paramString1 = new ProcessBuilder(localArrayList);
          localObject1 = localObject2;
          paramString1.redirectErrorStream(true);
          localObject1 = localObject2;
          paramString1 = paramString1.start();
          localObject1 = localObject2;
          TinkerDexOptimizer.StreamConsumer.consumeInputStream(paramString1.getInputStream());
          localObject1 = localObject2;
          TinkerDexOptimizer.StreamConsumer.consumeInputStream(paramString1.getErrorStream());
          localObject1 = localObject2;
          try
          {
            int i = paramString1.waitFor();
            if (i != 0)
            {
              localObject1 = localObject2;
              throw new IOException("dex2oat works unsuccessfully, exit code: ".concat(String.valueOf(i)));
            }
          }
          catch (InterruptedException paramString1)
          {
            localObject1 = localObject2;
            throw new IOException("dex2oat is interrupted, msg: " + paramString1.getMessage(), paramString1);
          }
          try
          {
            ((ShareFileLockHelper)localObject1).close();
            throw paramString1;
            localObject1 = localObject2;
            localArrayList.add("--compiler-filter=interpret-only");
            continue;
            if (localObject2 != null) {}
            try
            {
              ((ShareFileLockHelper)localObject2).close();
              return;
            }
            catch (IOException paramString1)
            {
              ShareTinkerLog.w("Tinker.ParallelDex", "release interpret Lock error", new Object[] { paramString1 });
              return;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              ShareTinkerLog.w("Tinker.ParallelDex", "release interpret Lock error", new Object[] { paramString2 });
            }
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    
    private static void loadDexByPathClassLoader(String paramString)
    {
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Load patch by PathClassLoader start.", new Object[0]);
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Load patch by PathClassLoader [%s] done.", new Object[] { new PathClassLoader(paramString, ClassLoader.getSystemClassLoader()) });
    }
    
    private static void triggerPMDexOpt(Context paramContext)
    {
      try
      {
        ShareTinkerLog.i("Tinker.ParallelDex", "[+] Start trigger secondary dexopt.", new Object[0]);
        if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
          break label84;
        }
        i = 121;
      }
      catch (IllegalStateException paramContext)
      {
        int i;
        IBinder localIBinder;
        for (;;)
        {
          throw paramContext;
          i = 120;
        }
        try
        {
          triggerPMDexOptImpl(localIBinder, i, paramContext, "speed", true);
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Secondary dexopt done.", new Object[0]);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            triggerPMDexOptImpl(localIBinder, i, paramContext, "speed", true);
          }
        }
      }
      catch (Throwable paramContext)
      {
        label84:
        throw new IllegalStateException("Failure on triggering secondary dexopt", paramContext);
      }
      paramContext = paramContext.getPackageName();
      localIBinder = (IBinder)ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", new Class[] { String.class }).invoke(null, new Object[] { "package" });
      if (localIBinder == null) {
        throw new IllegalStateException("Fail to get pm binder.");
      }
    }
    
    private static void triggerPMDexOpt2(Context paramContext, String paramString)
    {
      try
      {
        ShareTinkerLog.i("Tinker.ParallelDex", "[+] Start trigger secondary dexopt by registerDexModule.", new Object[0]);
        if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
          break label85;
        }
        i = 119;
      }
      catch (IllegalStateException paramContext)
      {
        int i;
        IBinder localIBinder;
        for (;;)
        {
          throw paramContext;
          i = 118;
        }
        try
        {
          triggerPMDexOptImpl2(localIBinder, i, paramContext, paramString);
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Secondary dexopt by registerDexModule done.", new Object[0]);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            triggerPMDexOptImpl2(localIBinder, i, paramContext, paramString);
          }
        }
      }
      catch (Throwable paramContext)
      {
        label85:
        throw new IllegalStateException("Failure on triggering secondary dexopt by registerDexModule.", paramContext);
      }
      paramContext = paramContext.getPackageName();
      localIBinder = (IBinder)ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", new Class[] { String.class }).invoke(null, new Object[] { "package" });
      if (localIBinder == null) {
        throw new IllegalStateException("Fail to get pm binder.");
      }
    }
    
    /* Error */
    private static void triggerPMDexOptImpl(IBinder paramIBinder, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: invokestatic 289	android/os/Binder:clearCallingIdentity	()J
      //   6: lstore 7
      //   8: invokestatic 295	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 9
      //   13: invokestatic 295	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 10
      //   18: aload 9
      //   20: ldc 11
      //   22: invokevirtual 298	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 9
      //   27: aload_2
      //   28: invokevirtual 301	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   31: aload 9
      //   33: aload_3
      //   34: invokevirtual 301	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   37: iload 4
      //   39: ifeq +78 -> 117
      //   42: iconst_1
      //   43: istore 5
      //   45: aload 9
      //   47: iload 5
      //   49: invokevirtual 305	android/os/Parcel:writeInt	(I)V
      //   52: aload_0
      //   53: iload_1
      //   54: aload 9
      //   56: aload 10
      //   58: iconst_0
      //   59: invokeinterface 309 5 0
      //   64: ifne +59 -> 123
      //   67: new 209	java/lang/IllegalStateException
      //   70: dup
      //   71: ldc_w 311
      //   74: invokespecial 258	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   77: athrow
      //   78: astore_0
      //   79: new 209	java/lang/IllegalStateException
      //   82: dup
      //   83: aload_0
      //   84: invokespecial 314	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   87: athrow
      //   88: astore_0
      //   89: aload 10
      //   91: astore_2
      //   92: lload 7
      //   94: invokestatic 318	android/os/Binder:restoreCallingIdentity	(J)V
      //   97: aload_2
      //   98: ifnull +7 -> 105
      //   101: aload_2
      //   102: invokevirtual 321	android/os/Parcel:recycle	()V
      //   105: aload 9
      //   107: ifnull +8 -> 115
      //   110: aload 9
      //   112: invokevirtual 321	android/os/Parcel:recycle	()V
      //   115: aload_0
      //   116: athrow
      //   117: iconst_0
      //   118: istore 5
      //   120: goto -75 -> 45
      //   123: aload 10
      //   125: invokevirtual 324	android/os/Parcel:readException	()V
      //   128: aload 10
      //   130: invokevirtual 327	android/os/Parcel:readInt	()I
      //   133: ifeq +58 -> 191
      //   136: iload 6
      //   138: istore_1
      //   139: iload_1
      //   140: ifne +15 -> 155
      //   143: ldc 178
      //   145: ldc_w 329
      //   148: iconst_0
      //   149: anewarray 4	java/lang/Object
      //   152: invokestatic 186	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: lload 7
      //   157: invokestatic 318	android/os/Binder:restoreCallingIdentity	(J)V
      //   160: aload 10
      //   162: ifnull +8 -> 170
      //   165: aload 10
      //   167: invokevirtual 321	android/os/Parcel:recycle	()V
      //   170: aload 9
      //   172: ifnull +8 -> 180
      //   175: aload 9
      //   177: invokevirtual 321	android/os/Parcel:recycle	()V
      //   180: return
      //   181: astore_0
      //   182: new 209	java/lang/IllegalStateException
      //   185: dup
      //   186: aload_0
      //   187: invokespecial 314	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   190: athrow
      //   191: iconst_0
      //   192: istore_1
      //   193: goto -54 -> 139
      //   196: astore_0
      //   197: aconst_null
      //   198: astore_2
      //   199: aconst_null
      //   200: astore 9
      //   202: goto -110 -> 92
      //   205: astore_0
      //   206: aconst_null
      //   207: astore_2
      //   208: goto -116 -> 92
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	211	0	paramIBinder	IBinder
      //   0	211	1	paramInt	int
      //   0	211	2	paramString1	String
      //   0	211	3	paramString2	String
      //   0	211	4	paramBoolean	boolean
      //   43	76	5	i	int
      //   1	136	6	j	int
      //   6	150	7	l	long
      //   11	190	9	localParcel1	android.os.Parcel
      //   16	150	10	localParcel2	android.os.Parcel
      // Exception table:
      //   from	to	target	type
      //   52	78	78	android/os/RemoteException
      //   18	37	88	finally
      //   45	52	88	finally
      //   52	78	88	finally
      //   79	88	88	finally
      //   123	128	88	finally
      //   128	136	88	finally
      //   143	155	88	finally
      //   182	191	88	finally
      //   123	128	181	java/lang/Throwable
      //   8	13	196	finally
      //   13	18	205	finally
    }
    
    /* Error */
    private static void triggerPMDexOptImpl2(IBinder paramIBinder, int paramInt, String paramString1, String paramString2)
    {
      // Byte code:
      //   0: invokestatic 289	android/os/Binder:clearCallingIdentity	()J
      //   3: lstore 4
      //   5: invokestatic 295	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 6
      //   10: invokestatic 295	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore 7
      //   15: aload 6
      //   17: ldc 11
      //   19: invokevirtual 298	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload 6
      //   24: aload_2
      //   25: invokevirtual 301	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   28: aload 6
      //   30: aload_3
      //   31: invokevirtual 301	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   34: aload 6
      //   36: iconst_0
      //   37: invokevirtual 305	android/os/Parcel:writeInt	(I)V
      //   40: aload 6
      //   42: iconst_0
      //   43: invokevirtual 305	android/os/Parcel:writeInt	(I)V
      //   46: aload_0
      //   47: iload_1
      //   48: aload 6
      //   50: aload 7
      //   52: iconst_0
      //   53: invokeinterface 309 5 0
      //   58: ifne +53 -> 111
      //   61: new 209	java/lang/IllegalStateException
      //   64: dup
      //   65: ldc_w 311
      //   68: invokespecial 258	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   71: athrow
      //   72: astore_0
      //   73: new 209	java/lang/IllegalStateException
      //   76: dup
      //   77: aload_0
      //   78: invokespecial 314	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   81: athrow
      //   82: astore_0
      //   83: aload 7
      //   85: astore_2
      //   86: lload 4
      //   88: invokestatic 318	android/os/Binder:restoreCallingIdentity	(J)V
      //   91: aload_2
      //   92: ifnull +7 -> 99
      //   95: aload_2
      //   96: invokevirtual 321	android/os/Parcel:recycle	()V
      //   99: aload 6
      //   101: ifnull +8 -> 109
      //   104: aload 6
      //   106: invokevirtual 321	android/os/Parcel:recycle	()V
      //   109: aload_0
      //   110: athrow
      //   111: aload 7
      //   113: invokevirtual 324	android/os/Parcel:readException	()V
      //   116: lload 4
      //   118: invokestatic 318	android/os/Binder:restoreCallingIdentity	(J)V
      //   121: aload 7
      //   123: ifnull +8 -> 131
      //   126: aload 7
      //   128: invokevirtual 321	android/os/Parcel:recycle	()V
      //   131: aload 6
      //   133: ifnull +8 -> 141
      //   136: aload 6
      //   138: invokevirtual 321	android/os/Parcel:recycle	()V
      //   141: return
      //   142: astore_0
      //   143: new 209	java/lang/IllegalStateException
      //   146: dup
      //   147: aload_0
      //   148: invokespecial 314	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   151: athrow
      //   152: astore_0
      //   153: aconst_null
      //   154: astore_2
      //   155: aconst_null
      //   156: astore 6
      //   158: goto -72 -> 86
      //   161: astore_0
      //   162: aconst_null
      //   163: astore_2
      //   164: goto -78 -> 86
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	167	0	paramIBinder	IBinder
      //   0	167	1	paramInt	int
      //   0	167	2	paramString1	String
      //   0	167	3	paramString2	String
      //   3	114	4	l	long
      //   8	149	6	localParcel1	android.os.Parcel
      //   13	114	7	localParcel2	android.os.Parcel
      // Exception table:
      //   from	to	target	type
      //   46	72	72	android/os/RemoteException
      //   15	46	82	finally
      //   46	72	82	finally
      //   73	82	82	finally
      //   111	116	82	finally
      //   143	152	82	finally
      //   111	116	142	java/lang/Throwable
      //   5	10	152	finally
      //   10	15	161	finally
    }
    
    private static void triggerPMDexOptOnDemand(Context paramContext, String paramString1, String paramString2)
    {
      if (Build.VERSION.SDK_INT != 29)
      {
        ShareTinkerLog.w("Tinker.ParallelDex", "[+] Not API 29 device, skip fixing.", new Object[0]);
        return;
      }
      if (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))
      {
        ShareTinkerLog.w("Tinker.ParallelDex", "[!] Not Huawei device, skip fixing.", new Object[0]);
        return;
      }
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Hit target device, do fix logic now.", new Object[0]);
      try
      {
        paramString2 = new File(paramString2);
        loadDexByPathClassLoader(paramString1);
        if (paramString2.exists())
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] PathClassLoader generated odex file, skip bg-dexopt triggering.", new Object[0]);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        ShareTinkerLog.printErrStackTrace("Tinker.ParallelDex", paramContext, "[-] Fail to call triggerPMDexOptAsyncOnDemand.", new Object[0]);
        return;
      }
      try
      {
        triggerPMDexOpt(paramContext);
        if (paramString2.exists())
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Bg-dexopt was triggered successfully.", new Object[0]);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))
        {
          throw localThrowable;
          throw new IllegalStateException("Bg-dexopt was triggered, but no odex file was generated.");
        }
        triggerPMDexOpt2(paramContext, paramString1);
        if (paramString2.exists())
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Bg-dexopt was triggered by registerDexModule successfully.", new Object[0]);
          return;
        }
        throw new IllegalStateException("Bg-dexopt was triggered by registerDexModule, but no odex file was generated.");
      }
    }
    
    boolean run()
    {
      for (;;)
      {
        try
        {
          if ((!SharePatchFileUtil.isLegalFile(this.dexFile)) && (this.callback != null))
          {
            this.callback.onFailed(this.dexFile, this.optimizedDir, new IOException("dex file " + this.dexFile.getAbsolutePath() + " is not exist!"));
            return false;
          }
          if (this.callback != null) {
            this.callback.onStart(this.dexFile, this.optimizedDir);
          }
          str = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
          if (!ShareTinkerInternals.isArkHotRuning())
          {
            if (!this.useInterpretMode) {
              continue;
            }
            interpretDex2Oat(this.dexFile.getAbsolutePath(), str);
          }
        }
        catch (Throwable localThrowable)
        {
          String str;
          ShareTinkerLog.e("Tinker.ParallelDex", "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), new Object[] { localThrowable });
          if (this.callback == null) {
            break label313;
          }
          this.callback.onFailed(this.dexFile, this.optimizedDir, localThrowable);
          return false;
          DexFile.loadDex(this.dexFile.getAbsolutePath(), localThrowable, 0);
          continue;
        }
        if (this.callback == null) {
          break label313;
        }
        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(str));
        break label313;
        if ((Build.VERSION.SDK_INT < 26) && ((Build.VERSION.SDK_INT < 25) || (Build.VERSION.PREVIEW_SDK_INT == 0))) {
          continue;
        }
        NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, new String[] { this.dexFile.getAbsolutePath() });
        triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), str);
      }
      label313:
      return true;
    }
  }
  
  public static abstract interface ResultCallback
  {
    public abstract void onFailed(File paramFile1, File paramFile2, Throwable paramThrowable);
    
    public abstract void onStart(File paramFile1, File paramFile2);
    
    public abstract void onSuccess(File paramFile1, File paramFile2, File paramFile3);
  }
  
  static class StreamConsumer
  {
    static final Executor STREAM_CONSUMER = ;
    
    static void consumeInputStream(InputStream paramInputStream)
    {
      STREAM_CONSUMER.execute(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:val$is	Ljava/io/InputStream;
          //   4: ifnonnull +4 -> 8
          //   7: return
          //   8: sipush 256
          //   11: newarray byte
          //   13: astore_2
          //   14: aload_0
          //   15: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:val$is	Ljava/io/InputStream;
          //   18: aload_2
          //   19: invokevirtual 34	java/io/InputStream:read	([B)I
          //   22: istore_1
          //   23: iload_1
          //   24: ifgt -10 -> 14
          //   27: aload_0
          //   28: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:val$is	Ljava/io/InputStream;
          //   31: invokevirtual 37	java/io/InputStream:close	()V
          //   34: return
          //   35: astore_2
          //   36: return
          //   37: astore_2
          //   38: aload_0
          //   39: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:val$is	Ljava/io/InputStream;
          //   42: invokevirtual 37	java/io/InputStream:close	()V
          //   45: return
          //   46: astore_2
          //   47: return
          //   48: astore_2
          //   49: aload_0
          //   50: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:val$is	Ljava/io/InputStream;
          //   53: invokevirtual 37	java/io/InputStream:close	()V
          //   56: aload_2
          //   57: athrow
          //   58: astore_3
          //   59: goto -3 -> 56
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	62	0	this	1
          //   22	2	1	i	int
          //   13	6	2	arrayOfByte	byte[]
          //   35	1	2	localException1	java.lang.Exception
          //   37	1	2	localIOException	IOException
          //   46	1	2	localException2	java.lang.Exception
          //   48	9	2	localObject	Object
          //   58	1	3	localException3	java.lang.Exception
          // Exception table:
          //   from	to	target	type
          //   27	34	35	java/lang/Exception
          //   14	23	37	java/io/IOException
          //   38	45	46	java/lang/Exception
          //   14	23	48	finally
          //   49	56	58	java/lang/Exception
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer
 * JD-Core Version:    0.7.0.1
 */