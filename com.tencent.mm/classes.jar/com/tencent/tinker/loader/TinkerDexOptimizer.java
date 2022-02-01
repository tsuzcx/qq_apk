package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
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
            catch (IOException paramString1) {}
          }
          catch (IOException paramString2)
          {
            break label379;
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
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
          new StringBuilder("Failed to optimize dex: ").append(this.dexFile.getAbsolutePath());
          if (this.callback == null) {
            break label280;
          }
          this.callback.onFailed(this.dexFile, this.optimizedDir, localThrowable);
          return false;
          DexFile.loadDex(this.dexFile.getAbsolutePath(), localThrowable, 0);
          continue;
        }
        if (this.callback == null) {
          break label280;
        }
        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(str));
        break label280;
        if ((Build.VERSION.SDK_INT < 26) && ((Build.VERSION.SDK_INT < 25) || (Build.VERSION.PREVIEW_SDK_INT == 0))) {
          continue;
        }
        NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, new String[] { this.dexFile.getAbsolutePath() });
      }
      label280:
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