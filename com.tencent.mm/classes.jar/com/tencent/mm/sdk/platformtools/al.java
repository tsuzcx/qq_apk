package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.ck.j;
import com.tencent.mm.sdk.a.a;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class al
  implements Thread.UncaughtExceptionHandler
{
  private static al ufx = null;
  public a ufA = null;
  public Map<String, b> ufB = new HashMap();
  private Thread.UncaughtExceptionHandler ufC = null;
  private boolean ufD = false;
  private List<c> ufE = new LinkedList();
  private d ufy = null;
  private a ufz = null;
  
  private al()
  {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
  }
  
  private static String Zp(String paramString)
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
  
  public static void a(a parama)
  {
    try
    {
      if (ufx == null) {
        ufx = new al();
      }
      ufx.ufz = parama;
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      if (ufx == null) {
        ufx = new al();
      }
      ufx.ufA = parama;
      return;
    }
    finally {}
  }
  
  public static void a(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      try
      {
        if (ufx == null) {
          ufx = new al();
        }
        ufx.ufE.add(paramc);
      }
      finally {}
    }
  }
  
  public static void a(d paramd)
  {
    try
    {
      if (ufx == null) {
        ufx = new al();
      }
      ufx.ufy = paramd;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, b paramb)
  {
    try
    {
      if (ufx == null) {
        ufx = new al();
      }
      ufx.ufB.put(paramString, paramb);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static String k(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 118	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 119	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 121	java/io/PrintStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 124	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 130	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   21: ifnull +11 -> 32
    //   24: aload_0
    //   25: invokevirtual 130	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   28: astore_0
    //   29: goto -12 -> 17
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 134	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   37: aload_1
    //   38: invokevirtual 138	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   41: invokestatic 140	com/tencent/mm/sdk/platformtools/al:Zp	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
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
  
  public static void x(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, new b()
      {
        public final String Jf()
        {
          return "subinfo=" + this.ufF;
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
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.ufD) {
      return;
    }
    this.ufD = true;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ??? = new PrintStream(localByteArrayOutputStream);
      for (Object localObject1 = paramThrowable; ((Throwable)localObject1).getCause() != null; localObject1 = ((Throwable)localObject1).getCause()) {}
      ((Throwable)localObject1).printStackTrace((PrintStream)???);
      localObject1 = Zp(localByteArrayOutputStream.toString());
      Object localObject4;
      if ((this.ufz != null) && (localObject1 != null))
      {
        ??? = new HandlerThread("close-db-while-crash");
        ((HandlerThread)???).start();
        localObject4 = new j();
        new Handler(((HandlerThread)???).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            al.a(al.this).ge(this.ufG);
            j localj = this.ufH;
            synchronized (localj.dIn)
            {
              if (localj.dIn[0] == 0)
              {
                localj.dIn[0] = 1;
                localj.dIn.notifyAll();
                y.i("MicroMsg.WxTimeoutLock", "notify done %s", new Object[] { localj });
              }
              return;
            }
          }
        });
      }
      synchronized (((j)localObject4).dIn)
      {
        if (localObject4.dIn[0] != 0) {
          y.i("MicroMsg.WxTimeoutLock", "no need lock %s", new Object[] { localObject4 });
        }
        for (;;)
        {
          if ((this.ufy != null) && (localObject1 != null))
          {
            this.ufy.a(this, (String)localObject1, paramThrowable);
            this.ufA.sP();
          }
          ??? = this.ufE.iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              localObject4 = (c)((Iterator)???).next();
              if (localObject4 != null)
              {
                try
                {
                  ((c)localObject4).c((String)localObject1, paramThrowable);
                }
                catch (Exception localException2) {}
                continue;
                try
                {
                  localException2.dIn.wait(3000L);
                }
                catch (InterruptedException localInterruptedException)
                {
                  y.printErrStackTrace("MicroMsg.WxTimeoutLock", localInterruptedException, "", new Object[0]);
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.appenderClose();
        if (!d.DEBUG) {
          break;
        }
        this.ufC.uncaughtException(paramThread, paramThrowable);
        return;
        localByteArrayOutputStream.close();
      }
      Process.killProcess(Process.myPid());
      System.exit(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void sP();
  }
  
  public static abstract interface b
  {
    public abstract String Jf();
  }
  
  public static abstract interface c
  {
    public abstract void c(String paramString, Throwable paramThrowable);
  }
  
  public static abstract interface d
  {
    public abstract void a(al paramal, String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.al
 * JD-Core Version:    0.7.0.1
 */