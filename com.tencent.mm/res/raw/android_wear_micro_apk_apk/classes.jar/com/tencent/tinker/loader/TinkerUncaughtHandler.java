package com.tencent.tinker.loader;

import android.content.Context;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public class TinkerUncaughtHandler
  implements Thread.UncaughtExceptionHandler
{
  private final File aow;
  private final Thread.UncaughtExceptionHandler aox;
  private final Context context;
  
  public TinkerUncaughtHandler(Context paramContext)
  {
    this.context = paramContext;
    this.aox = Thread.getDefaultUncaughtExceptionHandler();
    this.aow = f.P(paramContext);
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 42
    //   2: new 44	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 46
    //   8: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_2
    //   12: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   15: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 67	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: getfield 27	com/tencent/tinker/loader/TinkerUncaughtHandler:aox	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   29: aload_1
    //   30: aload_2
    //   31: invokeinterface 69 3 0
    //   36: aload_0
    //   37: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:aow	Ljava/io/File;
    //   40: ifnull +42 -> 82
    //   43: invokestatic 25	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   46: instanceof 2
    //   49: ifeq +33 -> 82
    //   52: aload_0
    //   53: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:aow	Ljava/io/File;
    //   56: invokevirtual 75	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 79	java/io/File:exists	()Z
    //   64: ifne +19 -> 83
    //   67: aload_1
    //   68: invokevirtual 82	java/io/File:mkdirs	()Z
    //   71: ifne +12 -> 83
    //   74: ldc 42
    //   76: ldc 84
    //   78: invokestatic 67	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: return
    //   83: new 86	java/io/PrintWriter
    //   86: dup
    //   87: new 88	java/io/FileWriter
    //   90: dup
    //   91: aload_0
    //   92: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:aow	Ljava/io/File;
    //   95: iconst_0
    //   96: invokespecial 91	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   99: invokespecial 94	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   102: astore_3
    //   103: aload_3
    //   104: astore_1
    //   105: aload_3
    //   106: new 44	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 96
    //   112: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 19	com/tencent/tinker/loader/TinkerUncaughtHandler:context	Landroid/content/Context;
    //   119: invokestatic 102	com/tencent/tinker/loader/a/k:V	(Landroid/content/Context;)Ljava/lang/String;
    //   122: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 105	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   131: aload_3
    //   132: astore_1
    //   133: aload_3
    //   134: aload_2
    //   135: invokestatic 108	com/tencent/tinker/loader/a/k:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   138: invokevirtual 105	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   141: aload_3
    //   142: invokestatic 112	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   145: invokestatic 118	android/os/Process:myPid	()I
    //   148: invokestatic 122	android/os/Process:killProcess	(I)V
    //   151: return
    //   152: astore 4
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: astore_1
    //   158: ldc 42
    //   160: new 44	java/lang/StringBuilder
    //   163: dup
    //   164: ldc 124
    //   166: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload 4
    //   171: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 67	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload_2
    //   185: invokestatic 112	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   188: goto -43 -> 145
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: invokestatic 112	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: goto -7 -> 194
    //   204: astore 4
    //   206: aload_3
    //   207: astore_2
    //   208: goto -52 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	TinkerUncaughtHandler
    //   0	211	1	paramThread	Thread
    //   0	211	2	paramThrowable	java.lang.Throwable
    //   102	105	3	localPrintWriter	java.io.PrintWriter
    //   152	18	4	localIOException1	java.io.IOException
    //   204	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   83	103	152	java/io/IOException
    //   83	103	191	finally
    //   105	131	200	finally
    //   133	141	200	finally
    //   158	184	200	finally
    //   105	131	204	java/io/IOException
    //   133	141	204	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerUncaughtHandler
 * JD-Core Version:    0.7.0.1
 */