package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.cn.j;
import com.tencent.mm.hellhoundlib.b.c;
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

public final class au
  implements Thread.UncaughtExceptionHandler
{
  private static au IdU = null;
  private d IdV = null;
  private com.tencent.mm.sdk.a.a IdW = null;
  public a IdX = null;
  private Map<String, b> IdY = new HashMap();
  private boolean IdZ = false;
  private List<c> Iea = new LinkedList();
  private Thread.UncaughtExceptionHandler ueh = null;
  
  private au()
  {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
  }
  
  public static void D(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, new b()
      {
        public final String fkX()
        {
          return "subinfo=" + this.Ieb;
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
  
  public static void a(com.tencent.mm.sdk.a.a parama)
  {
    try
    {
      if (IdU == null) {
        IdU = new au();
      }
      IdU.IdW = parama;
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      if (IdU == null) {
        IdU = new au();
      }
      IdU.IdX = parama;
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
        if (IdU == null) {
          IdU = new au();
        }
        IdU.Iea.add(paramc);
      }
      finally {}
    }
  }
  
  public static void a(d paramd)
  {
    try
    {
      if (IdU == null) {
        IdU = new au();
      }
      IdU.IdV = paramd;
      return;
    }
    finally {}
  }
  
  private static void a(String paramString, b paramb)
  {
    try
    {
      if (IdU == null) {
        IdU = new au();
      }
      IdU.IdY.put(paramString, paramb);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static String getExceptionCauseString(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 120	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 123	java/io/PrintStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 126	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 132	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   21: ifnull +11 -> 32
    //   24: aload_0
    //   25: invokevirtual 132	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   28: astore_0
    //   29: goto -12 -> 17
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 136	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   37: aload_1
    //   38: invokevirtual 140	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   41: invokestatic 144	com/tencent/mm/sdk/platformtools/au:toVisualString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
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
  
  public final String aQx(String paramString)
  {
    Iterator localIterator = this.IdY.entrySet().iterator();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str))) {
        return ((b)localEntry.getValue()).fkX();
      }
    }
    return "";
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.IdZ) {
      return;
    }
    this.IdZ = true;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject2 = new PrintStream(localByteArrayOutputStream);
      for (Object localObject1 = paramThrowable; ((Throwable)localObject1).getCause() != null; localObject1 = ((Throwable)localObject1).getCause()) {}
      ((Throwable)localObject1).printStackTrace((PrintStream)localObject2);
      localObject1 = toVisualString(localByteArrayOutputStream.toString());
      if ((this.IdW != null) && (localObject1 != null))
      {
        localObject2 = new j();
        new ap("close-db-while-crash").post(new Runnable()
        {
          public final void run()
          {
            au.a(au.this).wT(this.Iec);
            j localj = this.Ied;
            synchronized (localj.mLock)
            {
              if (localj.mLock[0] == 0)
              {
                localj.mLock[0] = 1;
                localj.mLock.notifyAll();
                ad.i("MicroMsg.WxTimeoutLock", "notify done %s", new Object[] { localj });
              }
              return;
            }
          }
        });
        ((j)localObject2).fSn();
      }
      if ((this.IdV != null) && (localObject1 != null))
      {
        this.IdV.b(this, (String)localObject1, paramThrowable);
        if (this.IdX != null) {
          this.IdX.LU();
        }
      }
      localObject2 = this.Iea.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        c localc = (c)((Iterator)localObject2).next();
        if (localc != null) {
          try
          {
            localc.a(this, (String)localObject1, paramThrowable);
          }
          catch (Exception localException2) {}
        }
      }
      localByteArrayOutputStream.close();
      label214:
      ad.appenderClose();
    }
    catch (Exception localException1)
    {
      break label214;
    }
    if (i.DEBUG)
    {
      this.ueh.uncaughtException(paramThread, paramThrowable);
      return;
    }
    paramThread = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramThrowable = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, paramThread.ahp(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramThread.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    paramThread = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramThrowable = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, paramThread.ahp(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramThread.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramThrowable, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
  }
  
  public static abstract interface a
  {
    public abstract void LU();
  }
  
  public static abstract interface b
  {
    public abstract String fkX();
  }
  
  public static abstract interface c
  {
    public abstract void a(au paramau, String paramString, Throwable paramThrowable);
  }
  
  public static abstract interface d
  {
    public abstract void b(au paramau, String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.au
 * JD-Core Version:    0.7.0.1
 */