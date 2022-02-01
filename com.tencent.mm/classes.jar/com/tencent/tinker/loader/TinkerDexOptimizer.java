package com.tencent.tinker.loader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.DexModuleRegisterCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.SystemClock;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
  
  public static boolean optimizeAll(Context paramContext, Collection<File> paramCollection, File paramFile, boolean paramBoolean, ResultCallback paramResultCallback)
  {
    return optimizeAll(paramContext, paramCollection, paramFile, false, paramBoolean, null, paramResultCallback);
  }
  
  public static boolean optimizeAll(Context paramContext, Collection<File> paramCollection, File paramFile, boolean paramBoolean1, boolean paramBoolean2, String paramString, ResultCallback paramResultCallback)
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
      if (!new OptimizeWorker(paramContext, (File)paramCollection.next(), paramFile, paramBoolean1, paramBoolean2, paramString, paramResultCallback).run()) {
        return false;
      }
    }
    return true;
  }
  
  static class OptimizeWorker
  {
    private static final PackageManager[] CACHED_SYNC_PM = { null };
    private static final String PM_INTERFACE_DESCRIPTOR = "android.content.pm.IPackageManager";
    private static String targetISA = null;
    private final TinkerDexOptimizer.ResultCallback callback;
    private final Context context;
    private final File dexFile;
    private final File optimizedDir;
    private final boolean useDLC;
    private final boolean useInterpretMode;
    
    OptimizeWorker(Context paramContext, File paramFile1, File paramFile2, boolean paramBoolean1, boolean paramBoolean2, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
    {
      this.context = paramContext;
      this.dexFile = paramFile1;
      this.optimizedDir = paramFile2;
      this.useInterpretMode = paramBoolean1;
      this.useDLC = paramBoolean2;
      this.callback = paramResultCallback;
      targetISA = paramString;
    }
    
    private static PackageManager getSynchronizedPackageManager(Context paramContext)
    {
      synchronized (CACHED_SYNC_PM)
      {
        if (CACHED_SYNC_PM[0] != null)
        {
          paramContext = CACHED_SYNC_PM[0];
          return paramContext;
        }
        Object localObject = (IBinder)ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", new Class[] { String.class }).invoke(null, new Object[] { "package" });
        localObject = (IBinder)Proxy.newProxyInstance(paramContext.getClassLoader(), localObject.getClass().getInterfaces(), new InvocationHandler()
        {
          public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            if ("transact".equals(paramAnonymousMethod.getName())) {
              paramAnonymousArrayOfObject[3] = Integer.valueOf(0);
            }
            return paramAnonymousMethod.invoke(this.val$pmBinder, paramAnonymousArrayOfObject);
          }
        });
        IInterface localIInterface = (IInterface)ShareReflectUtil.findMethod(Class.forName("android.content.pm.IPackageManager$Stub"), "asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { localObject });
        localObject = paramContext;
        if ((paramContext instanceof ContextWrapper)) {
          localObject = ((ContextWrapper)paramContext).getBaseContext();
        }
        paramContext = (PackageManager)Class.forName("android.app.ApplicationPackageManager").getDeclaredConstructor(new Class[] { localObject.getClass(), localIInterface.getClass().getInterfaces()[0] }).newInstance(new Object[] { localObject, localIInterface });
        CACHED_SYNC_PM[0] = paramContext;
        return paramContext;
      }
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
    
    public static void performDexOptSecondary(Context paramContext, String paramString)
    {
      int i;
      label189:
      label207:
      for (;;)
      {
        try
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Start trigger secondary dexopt.", new Object[0]);
          paramString = new File(paramString);
          j = queryPerformDexOptSecondaryTransactionCode();
          str = paramContext.getPackageName();
          localIBinder = (IBinder)ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", new Class[] { String.class }).invoke(null, new Object[] { "package" });
          if (localIBinder == null) {
            throw new IllegalStateException("Fail to get pm binder.");
          }
        }
        catch (IllegalStateException paramContext)
        {
          int j;
          String str;
          IBinder localIBinder;
          throw paramContext;
          i = 0;
          if (i >= 20) {
            break label189;
          }
          try
          {
            performDexOptSecondaryImpl(localIBinder, j, str, "quicken", false);
            paramContext = null;
          }
          catch (Throwable paramContext)
          {
            continue;
            i += 1;
          }
          SystemClock.sleep(3000L);
          if (paramString.exists()) {
            break label189;
          }
          if (i != 19) {
            break label207;
          }
          if (paramContext != null) {
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          throw new IllegalStateException("Failure on triggering secondary dexopt", paramContext);
        }
        if (!paramString.exists())
        {
          throw new IllegalStateException("Expected oat file: " + paramString.getAbsolutePath() + " does not exist.");
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Secondary dexopt done.", new Object[0]);
          return;
        }
      }
    }
    
    /* Error */
    private static void performDexOptSecondaryImpl(IBinder paramIBinder, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: invokestatic 328	android/os/Binder:clearCallingIdentity	()J
      //   6: lstore 7
      //   8: invokestatic 334	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 9
      //   13: invokestatic 334	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 10
      //   18: aload 9
      //   20: ldc 17
      //   22: invokevirtual 337	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 9
      //   27: aload_2
      //   28: invokevirtual 340	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   31: aload 9
      //   33: aload_3
      //   34: invokevirtual 340	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   37: iload 4
      //   39: ifeq +78 -> 117
      //   42: iconst_1
      //   43: istore 5
      //   45: aload 9
      //   47: iload 5
      //   49: invokevirtual 344	android/os/Parcel:writeInt	(I)V
      //   52: aload_0
      //   53: iload_1
      //   54: aload 9
      //   56: aload 10
      //   58: iconst_0
      //   59: invokeinterface 348 5 0
      //   64: ifne +59 -> 123
      //   67: new 278	java/lang/IllegalStateException
      //   70: dup
      //   71: ldc_w 350
      //   74: invokespecial 294	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   77: athrow
      //   78: astore_0
      //   79: new 278	java/lang/IllegalStateException
      //   82: dup
      //   83: aload_0
      //   84: invokespecial 353	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   87: athrow
      //   88: astore_0
      //   89: aload 10
      //   91: astore_2
      //   92: lload 7
      //   94: invokestatic 356	android/os/Binder:restoreCallingIdentity	(J)V
      //   97: aload_2
      //   98: ifnull +7 -> 105
      //   101: aload_2
      //   102: invokevirtual 359	android/os/Parcel:recycle	()V
      //   105: aload 9
      //   107: ifnull +8 -> 115
      //   110: aload 9
      //   112: invokevirtual 359	android/os/Parcel:recycle	()V
      //   115: aload_0
      //   116: athrow
      //   117: iconst_0
      //   118: istore 5
      //   120: goto -75 -> 45
      //   123: aload 10
      //   125: invokevirtual 362	android/os/Parcel:readException	()V
      //   128: aload 10
      //   130: invokevirtual 365	android/os/Parcel:readInt	()I
      //   133: ifeq +59 -> 192
      //   136: iload 6
      //   138: istore_1
      //   139: iload_1
      //   140: ifne +16 -> 156
      //   143: ldc_w 266
      //   146: ldc_w 367
      //   149: iconst_0
      //   150: anewarray 4	java/lang/Object
      //   153: invokestatic 274	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   156: lload 7
      //   158: invokestatic 356	android/os/Binder:restoreCallingIdentity	(J)V
      //   161: aload 10
      //   163: ifnull +8 -> 171
      //   166: aload 10
      //   168: invokevirtual 359	android/os/Parcel:recycle	()V
      //   171: aload 9
      //   173: ifnull +8 -> 181
      //   176: aload 9
      //   178: invokevirtual 359	android/os/Parcel:recycle	()V
      //   181: return
      //   182: astore_0
      //   183: new 278	java/lang/IllegalStateException
      //   186: dup
      //   187: aload_0
      //   188: invokespecial 353	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   191: athrow
      //   192: iconst_0
      //   193: istore_1
      //   194: goto -55 -> 139
      //   197: astore_0
      //   198: aconst_null
      //   199: astore_2
      //   200: aconst_null
      //   201: astore 9
      //   203: goto -111 -> 92
      //   206: astore_0
      //   207: aconst_null
      //   208: astore_2
      //   209: goto -117 -> 92
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	212	0	paramIBinder	IBinder
      //   0	212	1	paramInt	int
      //   0	212	2	paramString1	String
      //   0	212	3	paramString2	String
      //   0	212	4	paramBoolean	boolean
      //   43	76	5	i	int
      //   1	136	6	j	int
      //   6	151	7	l	long
      //   11	191	9	localParcel1	android.os.Parcel
      //   16	151	10	localParcel2	android.os.Parcel
      // Exception table:
      //   from	to	target	type
      //   52	78	78	android/os/RemoteException
      //   18	37	88	finally
      //   45	52	88	finally
      //   52	78	88	finally
      //   79	88	88	finally
      //   123	128	88	finally
      //   128	136	88	finally
      //   143	156	88	finally
      //   183	192	88	finally
      //   123	128	182	java/lang/Throwable
      //   8	13	197	finally
      //   13	18	206	finally
    }
    
    private static int queryPerformDexOptSecondaryTransactionCode()
    {
      try
      {
        Object localObject = ShareReflectUtil.findMethod(Class.class, "getDeclaredField", new Class[] { String.class });
        ((Method)localObject).setAccessible(true);
        localObject = (Field)((Method)localObject).invoke(Class.forName("android.content.pm.IPackageManager$Stub"), new Object[] { "TRANSACTION_performDexOptSecondary" });
        ((Field)localObject).setAccessible(true);
        int i = ((Integer)((Field)localObject).get(null)).intValue();
        return i;
      }
      catch (Throwable localThrowable)
      {
        throw new UnsupportedOperationException("Cannot query transaction code of performDexOptSecondary.", localThrowable);
      }
    }
    
    /* Error */
    private static void registerDexModule(Context paramContext, String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 396	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:getSynchronizedPackageManager	(Landroid/content/Context;)Landroid/content/pm/PackageManager;
      //   4: astore 4
      //   6: aload 4
      //   8: invokevirtual 93	java/lang/Object:getClass	()Ljava/lang/Class;
      //   11: ldc_w 397
      //   14: iconst_2
      //   15: anewarray 59	java/lang/Class
      //   18: dup
      //   19: iconst_0
      //   20: ldc 67
      //   22: aastore
      //   23: dup
      //   24: iconst_1
      //   25: ldc_w 399
      //   28: aastore
      //   29: invokestatic 73	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   32: astore 5
      //   34: new 138	java/io/File
      //   37: dup
      //   38: aload_2
      //   39: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
      //   42: astore_2
      //   43: iconst_0
      //   44: istore_3
      //   45: iload_3
      //   46: iconst_2
      //   47: if_icmpge +119 -> 166
      //   50: aconst_null
      //   51: astore_0
      //   52: aload 5
      //   54: aload 4
      //   56: iconst_2
      //   57: anewarray 4	java/lang/Object
      //   60: dup
      //   61: iconst_0
      //   62: aload_1
      //   63: aastore
      //   64: dup
      //   65: iconst_1
      //   66: new 9	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker$1
      //   69: dup
      //   70: invokespecial 400	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker$1:<init>	()V
      //   73: aastore
      //   74: invokevirtual 81	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   77: pop
      //   78: ldc2_w 301
      //   81: invokestatic 308	android/os/SystemClock:sleep	(J)V
      //   84: aload_2
      //   85: invokevirtual 145	java/io/File:exists	()Z
      //   88: ifne +78 -> 166
      //   91: iload_3
      //   92: iconst_1
      //   93: if_icmpne +66 -> 159
      //   96: aload_0
      //   97: ifnull +8 -> 105
      //   100: aload_0
      //   101: athrow
      //   102: astore_0
      //   103: aload_0
      //   104: athrow
      //   105: aload_2
      //   106: invokevirtual 145	java/io/File:exists	()Z
      //   109: ifne +50 -> 159
      //   112: new 278	java/lang/IllegalStateException
      //   115: dup
      //   116: new 200	java/lang/StringBuilder
      //   119: dup
      //   120: ldc_w 313
      //   123: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   126: aload_2
      //   127: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   130: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   133: ldc_w 318
      //   136: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   142: invokespecial 294	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   145: athrow
      //   146: astore_0
      //   147: new 278	java/lang/IllegalStateException
      //   150: dup
      //   151: ldc_w 402
      //   154: aload_0
      //   155: invokespecial 311	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   158: athrow
      //   159: iload_3
      //   160: iconst_1
      //   161: iadd
      //   162: istore_3
      //   163: goto -118 -> 45
      //   166: return
      //   167: astore_0
      //   168: goto -90 -> 78
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	171	0	paramContext	Context
      //   0	171	1	paramString1	String
      //   0	171	2	paramString2	String
      //   44	119	3	i	int
      //   4	51	4	localPackageManager	PackageManager
      //   32	21	5	localMethod	Method
      // Exception table:
      //   from	to	target	type
      //   0	43	102	java/lang/IllegalStateException
      //   52	78	102	java/lang/IllegalStateException
      //   78	91	102	java/lang/IllegalStateException
      //   100	102	102	java/lang/IllegalStateException
      //   105	146	102	java/lang/IllegalStateException
      //   0	43	146	java/lang/Throwable
      //   78	91	146	java/lang/Throwable
      //   100	102	146	java/lang/Throwable
      //   105	146	146	java/lang/Throwable
      //   52	78	167	java/lang/Throwable
    }
    
    private static void triggerPMDexOptOnDemand(Context paramContext, String paramString1, String paramString2)
    {
      if (Build.VERSION.SDK_INT != 29)
      {
        ShareTinkerLog.w("Tinker.ParallelDex", "[+] Not API 29 device, skip fixing.", new Object[0]);
        return;
      }
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Hit target device, do fix logic now.", new Object[0]);
      File localFile;
      try
      {
        localFile = new File(paramString2);
        if (localFile.exists())
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Odex file exists, skip bg-dexopt triggering.", new Object[0]);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        ShareTinkerLog.printErrStackTrace("Tinker.ParallelDex", paramContext, "[-] Fail to call triggerPMDexOptAsyncOnDemand.", new Object[0]);
        return;
      }
      int i = 1;
      try
      {
        performDexOptSecondary(paramContext, paramString2);
        SystemClock.sleep(1000L);
        if (((i == 0) || (!localFile.exists())) && (("huawei".equalsIgnoreCase(Build.MANUFACTURER)) || ("honor".equalsIgnoreCase(Build.MANUFACTURER)))) {
          registerDexModule(paramContext, paramString1, paramString2);
        }
        if (localFile.exists())
        {
          ShareTinkerLog.i("Tinker.ParallelDex", "[+] Bg-dexopt was triggered successfully.", new Object[0]);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ShareTinkerLog.printErrStackTrace("Tinker.ParallelDex", localThrowable, "[-] Fail to call performDexOptSecondary.", new Object[0]);
          i = 0;
        }
        throw new IllegalStateException("Bg-dexopt was triggered, but no odex file was generated.");
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
            break label318;
          }
          this.callback.onFailed(this.dexFile, this.optimizedDir, localThrowable);
          return false;
          DexFile.loadDex(this.dexFile.getAbsolutePath(), localThrowable, 0);
          continue;
        }
        if (this.callback == null) {
          break label318;
        }
        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(str));
        break label318;
        if ((Build.VERSION.SDK_INT < 26) && ((Build.VERSION.SDK_INT < 25) || (Build.VERSION.PREVIEW_SDK_INT == 0))) {
          continue;
        }
        NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, this.useDLC, new String[] { this.dexFile.getAbsolutePath() });
        triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), str);
      }
      label318:
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