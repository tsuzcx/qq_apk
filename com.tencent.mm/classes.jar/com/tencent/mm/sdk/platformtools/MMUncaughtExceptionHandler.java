package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.co.j;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class MMUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private static MMUncaughtExceptionHandler thiz = null;
  private byte _hellAccFlag_;
  public IAfterReport after = null;
  private Map<String, IAssertFailedReporter> assertFailedReporter = new HashMap();
  private CallbackForReset callbackReset = null;
  private boolean hasBeenReport = false;
  private List<IOnUncaughtExceptionListener> mOnUncaughtExceptionListenerList = new LinkedList();
  private IReporter reporter = null;
  private Thread.UncaughtExceptionHandler ueh = null;
  
  private MMUncaughtExceptionHandler()
  {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
  }
  
  public static void addAssertFailedReporter(String paramString, IAssertFailedReporter paramIAssertFailedReporter)
  {
    try
    {
      if (thiz == null) {
        thiz = new MMUncaughtExceptionHandler();
      }
      thiz.assertFailedReporter.put(paramString, paramIAssertFailedReporter);
      return;
    }
    finally {}
  }
  
  public static void addOnUncaughtExceptionListener(IOnUncaughtExceptionListener paramIOnUncaughtExceptionListener)
  {
    if (paramIOnUncaughtExceptionListener == null) {}
    for (;;)
    {
      return;
      try
      {
        if (thiz == null) {
          thiz = new MMUncaughtExceptionHandler();
        }
        thiz.mOnUncaughtExceptionListenerList.add(paramIOnUncaughtExceptionListener);
      }
      finally {}
    }
  }
  
  public static void assertTrue(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      addAssertFailedReporter(paramString1, new IAssertFailedReporter()
      {
        public final String getReport()
        {
          return "subinfo=" + this.val$subHeaderInfo;
        }
      });
      Assert.assertTrue(paramString1, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static String getExceptionCauseString(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 121	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 122	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 124	java/io/PrintStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 127	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 133	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   21: ifnull +11 -> 32
    //   24: aload_0
    //   25: invokevirtual 133	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   28: astore_0
    //   29: goto -12 -> 17
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 137	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   37: aload_1
    //   38: invokevirtual 141	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   41: invokestatic 145	com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler:toVisualString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 148	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 148	java/io/ByteArrayOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: areturn
    //   61: astore_1
    //   62: goto -6 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramThrowable	Throwable
    //   7	46	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   58	1	1	localIOException1	java.io.IOException
    //   61	1	1	localIOException2	java.io.IOException
    //   16	18	2	localPrintStream	PrintStream
    // Exception table:
    //   from	to	target	type
    //   17	29	51	finally
    //   32	45	51	finally
    //   45	49	58	java/io/IOException
    //   52	56	61	java/io/IOException
  }
  
  public static void setAfterReport(IAfterReport paramIAfterReport)
  {
    try
    {
      if (thiz == null) {
        thiz = new MMUncaughtExceptionHandler();
      }
      thiz.after = paramIAfterReport;
      return;
    }
    finally {}
  }
  
  public static void setCallbackForReset(CallbackForReset paramCallbackForReset)
  {
    try
    {
      if (thiz == null) {
        thiz = new MMUncaughtExceptionHandler();
      }
      thiz.callbackReset = paramCallbackForReset;
      return;
    }
    finally {}
  }
  
  public static void setReporter(IReporter paramIReporter)
  {
    try
    {
      if (thiz == null) {
        thiz = new MMUncaughtExceptionHandler();
      }
      thiz.reporter = paramIReporter;
      return;
    }
    finally {}
  }
  
  private static String toVisualString(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    label66:
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      if (arrayOfChar == null) {
        return null;
      }
      int i = 0;
      if (i < arrayOfChar.length) {
        if (arrayOfChar[i] > '') {
          arrayOfChar[i] = '\000';
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label66;
        }
        return new String(arrayOfChar, 0, i);
        i += 1;
        break;
      }
    }
  }
  
  public final String getReportByAssertPrefix(String paramString)
  {
    Iterator localIterator = this.assertFailedReporter.entrySet().iterator();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str))) {
        return ((IAssertFailedReporter)localEntry.getValue()).getReport();
      }
    }
    return "";
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.hasBeenReport) {
      return;
    }
    this.hasBeenReport = true;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject2 = new PrintStream(localByteArrayOutputStream);
      for (Object localObject1 = paramThrowable; ((Throwable)localObject1).getCause() != null; localObject1 = ((Throwable)localObject1).getCause()) {}
      ((Throwable)localObject1).printStackTrace((PrintStream)localObject2);
      localObject1 = toVisualString(localByteArrayOutputStream.toString());
      if ((this.callbackReset != null) && (localObject1 != null))
      {
        localObject2 = new j();
        new MMHandler("close-db-while-crash").post(new Runnable()
        {
          public void run()
          {
            MMUncaughtExceptionHandler.this.callbackReset.callbackForReset(this.val$toReport);
            j localj = this.val$timeoutLock;
            synchronized (localj.mLock)
            {
              if (localj.mLock[0] == 0)
              {
                localj.mLock[0] = 1;
                localj.mLock.notifyAll();
                Log.i("MicroMsg.WxTimeoutLock", "notify done %s", new Object[] { localj });
              }
              return;
            }
          }
        });
        ((j)localObject2).hip();
      }
      if ((this.reporter != null) && (localObject1 != null))
      {
        this.reporter.reportException(this, (String)localObject1, paramThrowable);
        if (this.after != null) {
          this.after.afterReport();
        }
      }
      localObject2 = this.mOnUncaughtExceptionListenerList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        IOnUncaughtExceptionListener localIOnUncaughtExceptionListener = (IOnUncaughtExceptionListener)((Iterator)localObject2).next();
        if (localIOnUncaughtExceptionListener != null) {
          try
          {
            localIOnUncaughtExceptionListener.uncaughtException(this, (String)localObject1, paramThrowable);
          }
          catch (Exception localException2) {}
        }
      }
      localByteArrayOutputStream.close();
      label214:
      Log.appenderClose();
    }
    catch (Exception localException1)
    {
      break label214;
    }
    if (BuildInfo.DEBUG)
    {
      this.ueh.uncaughtException(paramThread, paramThrowable);
      return;
    }
    paramThread = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramThrowable = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, paramThread.axQ(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramThread.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    paramThread = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramThrowable = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, paramThread.axQ(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramThread.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
  }
  
  public static abstract interface IAfterReport
  {
    public abstract void afterReport();
  }
  
  public static abstract interface IAssertFailedReporter
  {
    public abstract String getReport();
  }
  
  public static abstract interface IOnUncaughtExceptionListener
  {
    public abstract void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable);
  }
  
  public static abstract interface IReporter
  {
    public abstract void reportException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */