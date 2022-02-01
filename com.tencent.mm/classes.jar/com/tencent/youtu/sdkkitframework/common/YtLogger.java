package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class YtLogger
{
  public static final int DEBUG_LEVEL = 4;
  public static final int ERROR_LEVEL = 0;
  public static final int INFO_LEVEL = 2;
  public static final int VERB_LEVEL = 5;
  public static final int WARN_LEVEL = 1;
  private static int currentLogLevel;
  @SuppressLint({"SimpleDateFormat"})
  private static DateFormat dateFormat;
  private static File localFile;
  private static String localLogName;
  private static IYtLoggerListener loggerListener;
  private static ExecutorService mExecutorService;
  private static boolean needLogFile;
  
  static
  {
    AppMethodBeat.i(192587);
    loggerListener = null;
    needLogFile = false;
    dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
    localLogName = "youtu_log";
    localFile = null;
    currentLogLevel = 0;
    mExecutorService = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(192587);
  }
  
  private static String buildMessage(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(192583);
    if ((localLogName != null) && (!"".equals(localLogName)) && (needLogFile))
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(paramString2);
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(dateFormat.format(new Date()));
      localStringBuffer2.append("    ");
      localStringBuffer2.append("    ");
      localStringBuffer2.append(paramString1);
      localStringBuffer2.append("    ");
      localStringBuffer2.append(localStringBuffer1);
      if (paramThrowable != null)
      {
        localStringBuffer2.append(System.getProperty("line.separator"));
        localStringBuffer2.append(Log.getStackTraceString(paramThrowable));
      }
      save2File(localStringBuffer2.toString());
    }
    AppMethodBeat.o(192583);
    return paramString2;
  }
  
  public static void d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(192580);
    if (currentLogLevel >= 4) {
      showLog(paramString, "[YoutuLog]-[DEBUG]-".concat(String.valueOf(paramObject)));
    }
    AppMethodBeat.o(192580);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192577);
    if (currentLogLevel >= 0) {
      showLog(paramString1, "[YoutuLog]-[ERROR]-".concat(String.valueOf(paramString2)));
    }
    AppMethodBeat.o(192577);
  }
  
  private static File getLogFile(String paramString)
  {
    AppMethodBeat.i(192585);
    paramString = new File(Environment.getExternalStorageDirectory() + File.separator + "youtulog" + File.separator + paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs()))
    {
      AppMethodBeat.o(192585);
      return null;
    }
    String str = dateFormat.format(new Date()) + ".log";
    paramString = new File(paramString.getPath() + File.separator + str);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      label150:
      AppMethodBeat.o(192585);
      return paramString;
    }
    catch (Exception localException)
    {
      break label150;
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192579);
    if (currentLogLevel >= 2) {
      showLog(paramString1, "[YoutuLog]-[INFO]-".concat(String.valueOf(paramString2)));
    }
    AppMethodBeat.o(192579);
  }
  
  private static void save2File(String paramString)
  {
    AppMethodBeat.i(192584);
    if (localFile != null) {
      writeFile(localFile, paramString);
    }
    AppMethodBeat.o(192584);
  }
  
  public static void setLogLevel(int paramInt)
  {
    AppMethodBeat.i(192575);
    currentLogLevel = Math.min(paramInt, Math.max(paramInt, 0));
    AppMethodBeat.o(192575);
  }
  
  public static void setLoggerListener(IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static void setNeedLogFile(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(192576);
    needLogFile = paramBoolean;
    if (paramBoolean)
    {
      localLogName = paramString;
      localFile = getLogFile(paramString);
    }
    AppMethodBeat.o(192576);
  }
  
  private static void showLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192582);
    if (loggerListener != null) {
      loggerListener.log(paramString1, paramString2);
    }
    buildMessage(paramString1, paramString2, null);
    AppMethodBeat.o(192582);
  }
  
  public static void v(String paramString, Object paramObject)
  {
    AppMethodBeat.i(192581);
    if (currentLogLevel >= 5) {
      showLog(paramString, "[YoutuLog]-[VERB]-".concat(String.valueOf(paramObject)));
    }
    AppMethodBeat.o(192581);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192578);
    if (currentLogLevel > 0) {
      showLog(paramString1, "[YoutuLog]-[WARN]-".concat(String.valueOf(paramString2)));
    }
    AppMethodBeat.o(192578);
  }
  
  private static void writeFile(File paramFile, final String paramString)
  {
    AppMethodBeat.i(192586);
    mExecutorService.submit(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 28
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 36	java/io/PrintWriter
        //   8: dup
        //   9: new 38	java/io/BufferedWriter
        //   12: dup
        //   13: new 40	java/io/FileWriter
        //   16: dup
        //   17: aload_0
        //   18: getfield 18	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$file	Ljava/io/File;
        //   21: iconst_1
        //   22: invokespecial 43	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
        //   25: invokespecial 46	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   28: invokespecial 47	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
        //   31: astore_1
        //   32: aload_1
        //   33: aload_0
        //   34: getfield 20	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$content	Ljava/lang/String;
        //   37: invokevirtual 51	java/io/PrintWriter:println	(Ljava/lang/String;)V
        //   40: aload_1
        //   41: invokevirtual 54	java/io/PrintWriter:flush	()V
        //   44: aload_1
        //   45: invokevirtual 57	java/io/PrintWriter:close	()V
        //   48: ldc 28
        //   50: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   53: return
        //   54: astore_1
        //   55: aconst_null
        //   56: astore_1
        //   57: aload_1
        //   58: ifnull +31 -> 89
        //   61: aload_1
        //   62: invokevirtual 57	java/io/PrintWriter:close	()V
        //   65: ldc 28
        //   67: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   70: return
        //   71: astore_1
        //   72: aconst_null
        //   73: astore_2
        //   74: aload_2
        //   75: ifnull +7 -> 82
        //   78: aload_2
        //   79: invokevirtual 57	java/io/PrintWriter:close	()V
        //   82: ldc 28
        //   84: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: aload_1
        //   88: athrow
        //   89: ldc 28
        //   91: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   94: return
        //   95: astore_2
        //   96: aload_1
        //   97: astore_3
        //   98: aload_2
        //   99: astore_1
        //   100: aload_3
        //   101: astore_2
        //   102: goto -28 -> 74
        //   105: astore_2
        //   106: goto -49 -> 57
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	this	1
        //   31	14	1	localPrintWriter	java.io.PrintWriter
        //   54	1	1	localException1	Exception
        //   56	6	1	localObject1	Object
        //   71	26	1	localObject2	Object
        //   99	1	1	localObject3	Object
        //   73	6	2	localObject4	Object
        //   95	4	2	localObject5	Object
        //   101	1	2	localObject6	Object
        //   105	1	2	localException2	Exception
        //   97	4	3	localObject7	Object
        // Exception table:
        //   from	to	target	type
        //   5	32	54	java/lang/Exception
        //   5	32	71	finally
        //   32	44	95	finally
        //   32	44	105	java/lang/Exception
      }
    });
    AppMethodBeat.o(192586);
  }
  
  public static abstract interface IYtLoggerListener
  {
    public abstract void log(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger
 * JD-Core Version:    0.7.0.1
 */