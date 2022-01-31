package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.cm.j;
import com.tencent.mm.sdk.a.a;
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

public final class ao
  implements Thread.UncaughtExceptionHandler
{
  private static ao ynX = null;
  private d ynY = null;
  private a ynZ = null;
  public a yoa = null;
  private Map<String, b> yob = new HashMap();
  private Thread.UncaughtExceptionHandler yoc = null;
  private boolean yod = false;
  private List<c> yoe = new LinkedList();
  
  private ao()
  {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
  }
  
  public static void D(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, new b()
      {
        public final String acc()
        {
          return "subinfo=" + this.yof;
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
  
  public static void a(a parama)
  {
    try
    {
      if (ynX == null) {
        ynX = new ao();
      }
      ynX.ynZ = parama;
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      if (ynX == null) {
        ynX = new ao();
      }
      ynX.yoa = parama;
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
        if (ynX == null) {
          ynX = new ao();
        }
        ynX.yoe.add(paramc);
      }
      finally {}
    }
  }
  
  public static void a(d paramd)
  {
    try
    {
      if (ynX == null) {
        ynX = new ao();
      }
      ynX.ynY = paramd;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, b paramb)
  {
    try
    {
      if (ynX == null) {
        ynX = new ao();
      }
      ynX.yob.put(paramString, paramb);
      return;
    }
    finally {}
  }
  
  private static String apn(String paramString)
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
  
  /* Error */
  public static String m(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 131	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 134	java/io/PrintStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 137	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 143	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   21: ifnull +11 -> 32
    //   24: aload_0
    //   25: invokevirtual 143	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   28: astore_0
    //   29: goto -12 -> 17
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 147	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   37: aload_1
    //   38: invokevirtual 151	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   41: invokestatic 153	com/tencent/mm/sdk/platformtools/ao:apn	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
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
  
  public final String apo(String paramString)
  {
    Iterator localIterator = this.yob.entrySet().iterator();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str))) {
        return ((b)localEntry.getValue()).acc();
      }
    }
    return "";
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.yod) {
      return;
    }
    this.yod = true;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject2 = new PrintStream(localByteArrayOutputStream);
      for (Object localObject1 = paramThrowable; ((Throwable)localObject1).getCause() != null; localObject1 = ((Throwable)localObject1).getCause()) {}
      ((Throwable)localObject1).printStackTrace((PrintStream)localObject2);
      localObject1 = apn(localByteArrayOutputStream.toString());
      Object localObject3;
      if ((this.ynZ != null) && (localObject1 != null))
      {
        localObject2 = new HandlerThread("close-db-while-crash");
        ((HandlerThread)localObject2).start();
        localObject3 = new j();
        new Handler(((HandlerThread)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            ao.a(ao.this).my(this.yog);
            j localj = this.yoh;
            synchronized (localj.eFQ)
            {
              if (localj.eFQ[0] == 0)
              {
                localj.eFQ[0] = 1;
                localj.eFQ.notifyAll();
                ab.i("MicroMsg.WxTimeoutLock", "notify done %s", new Object[] { localj });
              }
              return;
            }
          }
        });
        ((j)localObject3).dTh();
      }
      if ((this.ynY != null) && (localObject1 != null))
      {
        this.ynY.a(this, (String)localObject1, paramThrowable);
        this.yoa.Bi();
      }
      localObject2 = this.yoe.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c)((Iterator)localObject2).next();
        if (localObject3 != null) {
          try
          {
            ((c)localObject3).b((String)localObject1, paramThrowable);
          }
          catch (Exception localException2) {}
        }
      }
      localByteArrayOutputStream.close();
      label225:
      ab.appenderClose();
    }
    catch (Exception localException1)
    {
      break label225;
    }
    if (f.DEBUG)
    {
      this.yoc.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Process.killProcess(Process.myPid());
    System.exit(0);
  }
  
  public static abstract interface a
  {
    public abstract void Bi();
  }
  
  public static abstract interface b
  {
    public abstract String acc();
  }
  
  public static abstract interface c
  {
    public abstract void b(String paramString, Throwable paramThrowable);
  }
  
  public static abstract interface d
  {
    public abstract void a(ao paramao, String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ao
 * JD-Core Version:    0.7.0.1
 */