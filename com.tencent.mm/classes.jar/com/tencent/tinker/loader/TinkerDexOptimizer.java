package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
  private static final int SHELL_COMMAND_TRANSACTION = 1598246212;
  private static final String TAG = "Tinker.ParallelDex";
  private static final ResultReceiver sEmptyResultReceiver = new ResultReceiver(sHandler);
  private static final Handler sHandler;
  private static final IBinder[] sPMSBinderProxy = { null };
  private static final PackageManager[] sSynchronizedPMCache = { null };
  
  static
  {
    sHandler = new Handler(Looper.getMainLooper());
  }
  
  private static boolean checkAndMarkIfOatExists(File paramFile1, File paramFile2, String paramString)
  {
    if (paramFile1.exists())
    {
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Oat file %s is found after %s", new Object[] { paramFile1.getPath(), paramString });
      try
      {
        paramFile2.createNewFile();
        return true;
      }
      finally
      {
        ShareTinkerLog.printErrStackTrace("Tinker.ParallelDex", paramFile1, "[-] Fail to create marker file %s after %s.", new Object[] { paramFile2.getPath(), paramString });
        return true;
      }
    }
    ShareTinkerLog.e("Tinker.ParallelDex", "[-] Oat file %s does not exist after %s.", new Object[] { paramFile1.getPath(), paramString });
    return false;
  }
  
  /* Error */
  private static void executePMSShellCommand(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 124	com/tencent/tinker/loader/TinkerDexOptimizer:getPMSBinderProxy	(Landroid/content/Context;)Landroid/os/IBinder;
    //   4: astore_0
    //   5: invokestatic 130	android/os/Binder:clearCallingIdentity	()J
    //   8: lstore_2
    //   9: ldc 27
    //   11: ldc 132
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: invokestatic 138	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 104	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: invokestatic 144	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   30: astore 4
    //   32: invokestatic 144	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   35: astore 5
    //   37: aload 4
    //   39: getstatic 150	java/io/FileDescriptor:in	Ljava/io/FileDescriptor;
    //   42: invokevirtual 154	android/os/Parcel:writeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   45: aload 4
    //   47: getstatic 157	java/io/FileDescriptor:out	Ljava/io/FileDescriptor;
    //   50: invokevirtual 154	android/os/Parcel:writeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   53: aload 4
    //   55: getstatic 160	java/io/FileDescriptor:err	Ljava/io/FileDescriptor;
    //   58: invokevirtual 154	android/os/Parcel:writeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   61: aload 4
    //   63: aload_1
    //   64: invokevirtual 164	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
    //   67: aload 4
    //   69: aconst_null
    //   70: invokevirtual 168	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   73: getstatic 66	com/tencent/tinker/loader/TinkerDexOptimizer:sEmptyResultReceiver	Landroid/os/ResultReceiver;
    //   76: aload 4
    //   78: iconst_0
    //   79: invokevirtual 172	android/os/ResultReceiver:writeToParcel	(Landroid/os/Parcel;I)V
    //   82: aload_0
    //   83: ldc 24
    //   85: aload 4
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 176 5 0
    //   95: pop
    //   96: aload 5
    //   98: invokevirtual 179	android/os/Parcel:readException	()V
    //   101: ldc 27
    //   103: ldc 181
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 104	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload 5
    //   114: ifnull +8 -> 122
    //   117: aload 5
    //   119: invokevirtual 184	android/os/Parcel:recycle	()V
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 184	android/os/Parcel:recycle	()V
    //   132: lload_2
    //   133: invokestatic 188	android/os/Binder:restoreCallingIdentity	(J)V
    //   136: return
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore 4
    //   143: new 190	java/lang/IllegalStateException
    //   146: dup
    //   147: ldc 192
    //   149: aload_0
    //   150: invokespecial 195	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: athrow
    //   154: astore_0
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 184	android/os/Parcel:recycle	()V
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 184	android/os/Parcel:recycle	()V
    //   173: lload_2
    //   174: invokestatic 188	android/os/Binder:restoreCallingIdentity	(J)V
    //   177: aload_0
    //   178: athrow
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: goto -39 -> 143
    //   185: astore_0
    //   186: aload 5
    //   188: astore_1
    //   189: goto -46 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramArrayOfString	String[]
    //   8	166	2	l	long
    //   30	139	4	localParcel1	android.os.Parcel
    //   35	152	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	32	137	finally
    //   143	154	154	finally
    //   32	37	179	finally
    //   37	112	185	finally
  }
  
  private static File getOatFinishedMarkerFile(String paramString)
  {
    return new File(paramString + ".oat_fine");
  }
  
  private static IBinder getPMSBinderProxy(Context arg0)
  {
    Object localObject1;
    synchronized (sPMSBinderProxy)
    {
      localObject1 = sPMSBinderProxy[0];
      if ((localObject1 != null) && (((IBinder)localObject1).isBinderAlive())) {
        return localObject1;
      }
    }
  }
  
  /* Error */
  private static final PackageManager getSynchronizedPackageManager(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 45	com/tencent/tinker/loader/TinkerDexOptimizer:sSynchronizedPMCache	[Landroid/content/pm/PackageManager;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 45	com/tencent/tinker/loader/TinkerDexOptimizer:sSynchronizedPMCache	[Landroid/content/pm/PackageManager;
    //   9: iconst_0
    //   10: aaload
    //   11: ifnull +44 -> 55
    //   14: getstatic 41	com/tencent/tinker/loader/TinkerDexOptimizer:sPMSBinderProxy	[Landroid/os/IBinder;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: getstatic 41	com/tencent/tinker/loader/TinkerDexOptimizer:sPMSBinderProxy	[Landroid/os/IBinder;
    //   23: iconst_0
    //   24: aaload
    //   25: ifnull +28 -> 53
    //   28: getstatic 41	com/tencent/tinker/loader/TinkerDexOptimizer:sPMSBinderProxy	[Landroid/os/IBinder;
    //   31: iconst_0
    //   32: aaload
    //   33: invokeinterface 214 1 0
    //   38: ifeq +15 -> 53
    //   41: getstatic 45	com/tencent/tinker/loader/TinkerDexOptimizer:sSynchronizedPMCache	[Landroid/content/pm/PackageManager;
    //   44: iconst_0
    //   45: aaload
    //   46: astore_0
    //   47: aload_1
    //   48: monitorexit
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_0
    //   52: areturn
    //   53: aload_1
    //   54: monitorexit
    //   55: aload_0
    //   56: invokestatic 124	com/tencent/tinker/loader/TinkerDexOptimizer:getPMSBinderProxy	(Landroid/content/Context;)Landroid/os/IBinder;
    //   59: astore_1
    //   60: aload_0
    //   61: invokevirtual 257	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   64: aload_1
    //   65: invokevirtual 261	java/lang/Object:getClass	()Ljava/lang/Class;
    //   68: invokevirtual 265	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   71: new 267	com/tencent/tinker/loader/TinkerDexOptimizer$2
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 269	com/tencent/tinker/loader/TinkerDexOptimizer$2:<init>	(Landroid/os/IBinder;)V
    //   79: invokestatic 275	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   82: checkcast 39	android/os/IBinder
    //   85: astore_1
    //   86: ldc_w 277
    //   89: invokestatic 222	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   92: ldc_w 279
    //   95: iconst_1
    //   96: anewarray 218	java/lang/Class
    //   99: dup
    //   100: iconst_0
    //   101: ldc 39
    //   103: aastore
    //   104: invokestatic 232	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   107: aconst_null
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: invokevirtual 240	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore_3
    //   120: ldc_w 281
    //   123: invokestatic 222	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   126: astore 4
    //   128: aload_0
    //   129: astore_1
    //   130: aload_0
    //   131: instanceof 283
    //   134: ifeq +11 -> 145
    //   137: aload_0
    //   138: checkcast 283	android/content/ContextWrapper
    //   141: invokevirtual 287	android/content/ContextWrapper:getBaseContext	()Landroid/content/Context;
    //   144: astore_1
    //   145: ldc_w 289
    //   148: invokestatic 222	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   151: astore_0
    //   152: aload 4
    //   154: iconst_2
    //   155: anewarray 218	java/lang/Class
    //   158: dup
    //   159: iconst_0
    //   160: aload_1
    //   161: invokevirtual 261	java/lang/Object:getClass	()Ljava/lang/Class;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_0
    //   168: aastore
    //   169: invokestatic 293	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findConstructor	(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_1
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload_3
    //   183: aastore
    //   184: invokevirtual 299	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 43	android/content/pm/PackageManager
    //   190: astore_0
    //   191: getstatic 45	com/tencent/tinker/loader/TinkerDexOptimizer:sSynchronizedPMCache	[Landroid/content/pm/PackageManager;
    //   194: iconst_0
    //   195: aload_0
    //   196: aastore
    //   197: aload_2
    //   198: monitorexit
    //   199: aload_0
    //   200: areturn
    //   201: astore_0
    //   202: aload_2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: aload_1
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: new 190	java/lang/IllegalStateException
    //   215: dup
    //   216: aload_0
    //   217: invokevirtual 246	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   220: invokespecial 249	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   223: athrow
    //   224: astore_0
    //   225: aload_0
    //   226: instanceof 190
    //   229: ifeq +8 -> 237
    //   232: aload_0
    //   233: checkcast 190	java/lang/IllegalStateException
    //   236: athrow
    //   237: new 190	java/lang/IllegalStateException
    //   240: dup
    //   241: aload_0
    //   242: invokespecial 249	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   17	191	1	localObject1	Object
    //   3	200	2	arrayOfPackageManager	PackageManager[]
    //   119	64	3	localObject2	Object
    //   126	27	4	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   49	51	201	finally
    //   197	199	201	finally
    //   202	204	201	finally
    //   212	224	201	finally
    //   225	237	201	finally
    //   237	246	201	finally
    //   20	49	206	finally
    //   6	20	211	java/lang/reflect/InvocationTargetException
    //   53	55	211	java/lang/reflect/InvocationTargetException
    //   55	128	211	java/lang/reflect/InvocationTargetException
    //   130	145	211	java/lang/reflect/InvocationTargetException
    //   145	197	211	java/lang/reflect/InvocationTargetException
    //   207	211	211	java/lang/reflect/InvocationTargetException
    //   6	20	224	finally
    //   53	55	224	finally
    //   55	128	224	finally
    //   130	145	224	finally
    //   145	197	224	finally
    //   207	211	224	finally
  }
  
  private static void interpretDex2Oat(String paramString1, String paramString2, String paramString3)
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
      localArrayList.add("--instruction-set=".concat(String.valueOf(paramString3)));
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
        StreamConsumer.consumeInputStream(paramString1.getInputStream());
        localObject1 = localObject2;
        StreamConsumer.consumeInputStream(paramString1.getErrorStream());
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
  
  private static void performDexOptSecondary(Context paramContext)
  {
    if (ShareTinkerInternals.isNewerOrEqualThanVersion(31, true)) {}
    for (String str = "verify";; str = "speed-profile")
    {
      executePMSShellCommand(paramContext, new String[] { "compile", "-f", "--secondary-dex", "-m", str, paramContext.getPackageName() });
      return;
    }
  }
  
  private static void reconcileSecondaryDexFiles(Context paramContext)
  {
    executePMSShellCommand(paramContext, new String[] { "reconcile-secondary-dex-files", paramContext.getPackageName() });
  }
  
  /* Error */
  private static void registerDexModule(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 478	com/tencent/tinker/loader/TinkerDexOptimizer:getSynchronizedPackageManager	(Landroid/content/Context;)Landroid/content/pm/PackageManager;
    //   4: astore_0
    //   5: aload_0
    //   6: ldc_w 479
    //   9: iconst_2
    //   10: anewarray 218	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 226
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc_w 481
    //   23: invokestatic 222	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   26: aastore
    //   27: invokestatic 484	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: aload_0
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aconst_null
    //   42: aastore
    //   43: invokevirtual 240	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: return
    //   48: astore_0
    //   49: new 190	java/lang/IllegalStateException
    //   52: dup
    //   53: aload_0
    //   54: invokevirtual 246	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   57: invokespecial 249	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   60: athrow
    //   61: astore_0
    //   62: aload_0
    //   63: instanceof 190
    //   66: ifeq +8 -> 74
    //   69: aload_0
    //   70: checkcast 190	java/lang/IllegalStateException
    //   73: athrow
    //   74: new 190	java/lang/IllegalStateException
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 249	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    //   0	83	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   5	47	48	java/lang/reflect/InvocationTargetException
    //   5	47	61	finally
  }
  
  /* Error */
  private static void triggerPMDexOptOnDemand(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 335	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 29
    //   5: if_icmpge +16 -> 21
    //   8: ldc 27
    //   10: ldc_w 486
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 410	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: return
    //   21: ldc 27
    //   23: ldc_w 488
    //   26: iconst_0
    //   27: anewarray 4	java/lang/Object
    //   30: invokestatic 104	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: new 88	java/io/File
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 5
    //   43: aload_1
    //   44: invokestatic 490	com/tencent/tinker/loader/TinkerDexOptimizer:getOatFinishedMarkerFile	(Ljava/lang/String;)Ljava/io/File;
    //   47: astore 6
    //   49: aload 5
    //   51: invokevirtual 92	java/io/File:exists	()Z
    //   54: ifne +176 -> 230
    //   57: aload 6
    //   59: invokevirtual 92	java/io/File:exists	()Z
    //   62: ifeq +9 -> 71
    //   65: aload 6
    //   67: invokevirtual 493	java/io/File:delete	()Z
    //   70: pop
    //   71: iconst_0
    //   72: istore_3
    //   73: aload_0
    //   74: invokestatic 495	com/tencent/tinker/loader/TinkerDexOptimizer:reconcileSecondaryDexFiles	(Landroid/content/Context;)V
    //   77: aload 5
    //   79: invokevirtual 307	java/io/File:getParentFile	()Ljava/io/File;
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 92	java/io/File:exists	()Z
    //   87: ifne +8 -> 95
    //   90: aload_2
    //   91: invokevirtual 310	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 5
    //   97: invokevirtual 107	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: bipush 31
    //   103: iconst_1
    //   104: invokestatic 455	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNewerOrEqualThanVersion	(IZ)Z
    //   107: istore 4
    //   109: iload 4
    //   111: ifeq +25 -> 136
    //   114: aload_0
    //   115: aload_1
    //   116: invokestatic 497	com/tencent/tinker/loader/TinkerDexOptimizer:registerDexModule	(Landroid/content/Context;Ljava/lang/String;)V
    //   119: aload 5
    //   121: aload 6
    //   123: ldc_w 479
    //   126: invokestatic 499	com/tencent/tinker/loader/TinkerDexOptimizer:checkAndMarkIfOatExists	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Z
    //   129: istore 4
    //   131: iload 4
    //   133: ifne -113 -> 20
    //   136: aload_0
    //   137: invokestatic 501	com/tencent/tinker/loader/TinkerDexOptimizer:performDexOptSecondary	(Landroid/content/Context;)V
    //   140: aload 5
    //   142: aload 6
    //   144: ldc_w 502
    //   147: invokestatic 499	com/tencent/tinker/loader/TinkerDexOptimizer:checkAndMarkIfOatExists	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Z
    //   150: ifne -130 -> 20
    //   153: ldc_w 504
    //   156: getstatic 509	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   159: invokevirtual 513	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   162: ifne +19 -> 181
    //   165: ldc_w 515
    //   168: getstatic 509	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   171: invokevirtual 513	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: istore 4
    //   176: iload 4
    //   178: ifeq +21 -> 199
    //   181: aload_0
    //   182: aload_1
    //   183: invokestatic 497	com/tencent/tinker/loader/TinkerDexOptimizer:registerDexModule	(Landroid/content/Context;Ljava/lang/String;)V
    //   186: aload 5
    //   188: aload 6
    //   190: ldc_w 517
    //   193: invokestatic 499	com/tencent/tinker/loader/TinkerDexOptimizer:checkAndMarkIfOatExists	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Z
    //   196: ifne -176 -> 20
    //   199: iload_3
    //   200: iconst_3
    //   201: if_icmplt +148 -> 349
    //   204: new 190	java/lang/IllegalStateException
    //   207: dup
    //   208: ldc_w 519
    //   211: invokespecial 520	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   214: athrow
    //   215: astore_0
    //   216: ldc 27
    //   218: aload_0
    //   219: ldc_w 522
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: return
    //   230: aload 6
    //   232: invokevirtual 92	java/io/File:exists	()Z
    //   235: ifne +12 -> 247
    //   238: aload 5
    //   240: invokevirtual 493	java/io/File:delete	()Z
    //   243: pop
    //   244: goto -173 -> 71
    //   247: ldc 27
    //   249: ldc_w 524
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_2
    //   259: aastore
    //   260: invokestatic 104	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: return
    //   264: astore_2
    //   265: ldc 27
    //   267: aload_2
    //   268: ldc_w 526
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -201 -> 77
    //   281: astore_2
    //   282: ldc 27
    //   284: aload_2
    //   285: ldc_w 528
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: goto -194 -> 101
    //   298: astore_2
    //   299: ldc 27
    //   301: aload_2
    //   302: ldc_w 530
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: goto -193 -> 119
    //   315: astore_2
    //   316: ldc 27
    //   318: aload_2
    //   319: ldc_w 532
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: goto -189 -> 140
    //   332: astore_2
    //   333: ldc 27
    //   335: aload_2
    //   336: ldc_w 530
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 113	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: goto -160 -> 186
    //   349: ldc 27
    //   351: ldc_w 534
    //   354: iconst_0
    //   355: anewarray 4	java/lang/Object
    //   358: invokestatic 410	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: ldc2_w 535
    //   364: invokestatic 541	android/os/SystemClock:sleep	(J)V
    //   367: iload_3
    //   368: iconst_1
    //   369: iadd
    //   370: istore_3
    //   371: goto -298 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramContext	Context
    //   0	374	1	paramString1	String
    //   0	374	2	paramString2	String
    //   72	299	3	i	int
    //   107	70	4	bool	boolean
    //   41	198	5	localFile1	File
    //   47	184	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   33	71	215	finally
    //   101	109	215	finally
    //   119	131	215	finally
    //   140	176	215	finally
    //   186	199	215	finally
    //   204	215	215	finally
    //   230	244	215	finally
    //   247	263	215	finally
    //   265	278	215	finally
    //   282	295	215	finally
    //   299	312	215	finally
    //   316	329	215	finally
    //   333	346	215	finally
    //   349	367	215	finally
    //   73	77	264	finally
    //   77	95	281	finally
    //   95	101	281	finally
    //   114	119	298	finally
    //   136	140	315	finally
    //   181	186	332	finally
  }
  
  private static void waitUntilVdexGeneratedOrTimeout(Context paramContext, String paramString)
  {
    paramContext = new File(paramString);
    int j;
    for (int i = 0; (!paramContext.exists()) && (i < 6); i = j)
    {
      j = i + 1;
      SystemClock.sleep(new long[] { 1000L, 2000L, 4000L, 8000L, 16000L, 32000L }[i]);
      ShareTinkerLog.w("Tinker.ParallelDex", "[!] Vdex %s does not exist after waiting %s time(s), wait again.", new Object[] { paramString, Integer.valueOf(j) });
    }
    if (paramContext.exists())
    {
      ShareTinkerLog.i("Tinker.ParallelDex", "[+] Vdex %s was found.", new Object[] { paramString });
      return;
    }
    ShareTinkerLog.e("Tinker.ParallelDex", "[-] Vdex %s does not exist after waiting for %s times.", new Object[] { paramString, Integer.valueOf(6) });
  }
  
  static class OptimizeWorker
  {
    private static ClassLoader patchClassLoaderStrongRef = null;
    private final TinkerDexOptimizer.ResultCallback callback;
    private final Context context;
    private final File dexFile;
    private final File optimizedDir;
    private final String targetISA;
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
      this.targetISA = paramString;
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
          str1 = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
          if (!ShareTinkerInternals.isArkHotRuning())
          {
            if (!this.useInterpretMode) {
              continue;
            }
            TinkerDexOptimizer.interpretDex2Oat(this.dexFile.getAbsolutePath(), str1, this.targetISA);
          }
        }
        finally
        {
          String str1;
          ShareTinkerLog.e("Tinker.ParallelDex", "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), new Object[] { localThrowable });
          if (this.callback == null) {
            break label398;
          }
          this.callback.onFailed(this.dexFile, this.optimizedDir, localThrowable);
          return false;
          TinkerDexOptimizer.triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), localThrowable);
          String str2 = localThrowable.substring(0, localThrowable.lastIndexOf(".odex")) + ".vdex";
          TinkerDexOptimizer.waitUntilVdexGeneratedOrTimeout(this.context, str2);
          continue;
          DexFile.loadDex(this.dexFile.getAbsolutePath(), localThrowable, 0);
          continue;
        }
        if (this.callback == null) {
          break label398;
        }
        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(str1));
        break label398;
        if ((Build.VERSION.SDK_INT < 26) && ((Build.VERSION.SDK_INT < 25) || (Build.VERSION.PREVIEW_SDK_INT == 0))) {
          continue;
        }
        patchClassLoaderStrongRef = NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, this.useDLC, new String[] { this.dexFile.getAbsolutePath() });
        if ((Build.VERSION.SDK_INT >= 31) || ((Build.VERSION.SDK_INT == 30) && (Build.VERSION.PREVIEW_SDK_INT != 0))) {
          continue;
        }
        TinkerDexOptimizer.triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), str1);
      }
      label398:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer
 * JD-Core Version:    0.7.0.1
 */