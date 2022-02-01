package com.tencent.tbs.a.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.a.d;
import com.tencent.tbs.a.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
  implements d
{
  private boolean a;
  private b ahzt;
  private volatile a ahzu;
  private com.tencent.tbs.a.a.c.b ahzv;
  private com.tencent.tbs.a.a.b.a ahzw;
  private com.tencent.tbs.a.a.a.a ahzx;
  boolean b;
  private Context h;
  
  public b(Context paramContext, com.tencent.tbs.a.a.c.b paramb, com.tencent.tbs.a.a.b.a parama, com.tencent.tbs.a.a.a.a parama1)
  {
    AppMethodBeat.i(53067);
    this.ahzt = new b((byte)0);
    this.ahzu = new a((byte)0);
    this.a = true;
    this.b = true;
    this.ahzv = paramb;
    this.ahzw = parama;
    this.ahzx = parama1;
    this.h = paramContext;
    AppMethodBeat.o(53067);
  }
  
  private String a()
  {
    AppMethodBeat.i(174283);
    Object localObject = ((ActivityManager)this.h.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == Process.myPid())
      {
        localObject = localRunningAppProcessInfo.processName.toLowerCase().replace(".", "_");
        localObject = new File(e.a(), (String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = ((File)localObject).getAbsolutePath();
        AppMethodBeat.o(174283);
        return localObject;
      }
    }
    localObject = e.a();
    AppMethodBeat.o(174283);
    return localObject;
  }
  
  private boolean c(com.tencent.tbs.a.b paramb)
  {
    AppMethodBeat.i(174286);
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = this.ahzt.d;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!this.ahzv.a()) {
          break label202;
        }
      }
      localObject1 = this.ahzv.d(paramb);
      if ((localObject1 == null) || (((String)localObject1).trim().length() == 0))
      {
        paramb = new IllegalArgumentException("File name should not be empty.");
        AppMethodBeat.o(174286);
        throw paramb;
      }
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(174286);
      return false;
    }
    if (!((String)localObject1).equals(localObject2)) {
      if (this.ahzt.ahzA == null) {
        break label332;
      }
    }
    label202:
    label332:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.ahzt.d();
      }
      paramb = new File(a()).listFiles();
      int j;
      if (paramb != null)
      {
        j = paramb.length;
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          localObject2 = paramb[i];
          if (this.ahzw.a((File)localObject2)) {
            ((File)localObject2).delete();
          }
        }
        else
        {
          boolean bool = this.ahzt.a((String)localObject1);
          if (!bool)
          {
            AppMethodBeat.o(174286);
            return false;
          }
          paramb = this.ahzt.b;
          if ((paramb != null) && (this.ahzx.a(paramb)))
          {
            this.ahzt.d();
            localObject2 = new File(a(), (String)localObject1 + "-" + System.currentTimeMillis() % 86400000L);
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            paramb.renameTo((File)localObject2);
            bool = this.ahzt.a((String)localObject1);
            AppMethodBeat.o(174286);
            return bool;
          }
          AppMethodBeat.o(174286);
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void a(com.tencent.tbs.a.b paramb)
  {
    AppMethodBeat.i(174284);
    if ((!this.a) || (!this.ahzu.a())) {}
    try
    {
      synchronized (this.ahzu)
      {
        new Thread(???).start();
        ???.c = true;
        label45:
        ??? = this.ahzu;
      }
      try
      {
        ???.ahzy.put(paramb);
        AppMethodBeat.o(174284);
        return;
      }
      catch (InterruptedException paramb)
      {
        AppMethodBeat.o(174284);
        return;
      }
      paramb = finally;
      AppMethodBeat.o(174284);
      throw paramb;
      b(paramb);
      AppMethodBeat.o(174284);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
  
  final void b(com.tencent.tbs.a.b paramb)
  {
    AppMethodBeat.i(174285);
    if (!c(paramb))
    {
      new Throwable("log file open failed!");
      AppMethodBeat.o(174285);
      return;
    }
    this.ahzt.b(com.tencent.tbs.a.a.d(paramb));
    AppMethodBeat.o(174285);
  }
  
  final class a
    implements Runnable
  {
    BlockingQueue<com.tencent.tbs.a.b> ahzy;
    volatile boolean c;
    
    private a()
    {
      AppMethodBeat.i(53062);
      this.ahzy = new LinkedBlockingQueue();
      AppMethodBeat.o(53062);
    }
    
    final boolean a()
    {
      try
      {
        boolean bool = this.c;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 49
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 35	com/tencent/tbs/a/a/b$a:ahzy	Ljava/util/concurrent/BlockingQueue;
      //   9: invokeinterface 55 1 0
      //   14: checkcast 57	com/tencent/tbs/a/b
      //   17: astore_1
      //   18: aload_1
      //   19: ifnull +30 -> 49
      //   22: aload_0
      //   23: getfield 20	com/tencent/tbs/a/a/b$a:ahzz	Lcom/tencent/tbs/a/a/b;
      //   26: aload_1
      //   27: invokevirtual 61	com/tencent/tbs/a/a/b:b	(Lcom/tencent/tbs/a/b;)V
      //   30: goto -25 -> 5
      //   33: astore_1
      //   34: aload_0
      //   35: monitorenter
      //   36: aload_0
      //   37: iconst_0
      //   38: putfield 45	com/tencent/tbs/a/a/b$a:c	Z
      //   41: aload_0
      //   42: monitorexit
      //   43: ldc 49
      //   45: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: return
      //   49: ldc 49
      //   51: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: return
      //   55: astore_1
      //   56: aload_0
      //   57: monitorexit
      //   58: ldc 49
      //   60: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: aload_1
      //   64: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	65	0	this	a
      //   17	10	1	localb	com.tencent.tbs.a.b
      //   33	1	1	localInterruptedException	InterruptedException
      //   55	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	18	33	java/lang/InterruptedException
      //   22	30	33	java/lang/InterruptedException
      //   36	43	55	finally
    }
  }
  
  final class b
  {
    OutputStream ahzA;
    File b;
    String d;
    
    private b() {}
    
    final boolean a(String paramString)
    {
      AppMethodBeat.i(53064);
      this.d = paramString;
      this.b = new File(b.a(b.this), paramString);
      if (!this.b.exists()) {}
      try
      {
        paramString = this.b.getParentFile();
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        this.b.createNewFile();
        return false;
      }
      catch (IOException paramString)
      {
        try
        {
          this.ahzA = new BufferedOutputStream(new FileOutputStream(this.b, true));
          AppMethodBeat.o(53064);
          return true;
        }
        catch (Exception paramString)
        {
          this.b = null;
          AppMethodBeat.o(53064);
        }
        paramString = paramString;
        this.b = null;
        AppMethodBeat.o(53064);
        return false;
      }
    }
    
    /* Error */
    final void b(String paramString)
    {
      // Byte code:
      //   0: ldc 81
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   9: ifnull +148 -> 157
      //   12: aload_0
      //   13: getfield 18	com/tencent/tbs/a/a/b$b:ahzz	Lcom/tencent/tbs/a/a/b;
      //   16: getfield 84	com/tencent/tbs/a/a/b:b	Z
      //   19: ifeq +60 -> 79
      //   22: invokestatic 90	java/lang/System:currentTimeMillis	()J
      //   25: invokestatic 96	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   28: astore_2
      //   29: ldc 98
      //   31: aload_2
      //   32: invokestatic 104	com/tencent/tbs/a/a/a:qF	(Ljava/lang/String;Ljava/lang/String;)[B
      //   35: astore_3
      //   36: aload_3
      //   37: ifnull +22 -> 59
      //   40: aload_2
      //   41: aload_1
      //   42: aload_3
      //   43: invokestatic 108	com/tencent/tbs/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[B)[B
      //   46: astore_1
      //   47: aload_1
      //   48: ifnull +11 -> 59
      //   51: aload_0
      //   52: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   55: aload_1
      //   56: invokevirtual 114	java/io/OutputStream:write	([B)V
      //   59: aload_0
      //   60: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   63: ifnull +94 -> 157
      //   66: aload_0
      //   67: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   70: invokevirtual 117	java/io/OutputStream:flush	()V
      //   73: ldc 81
      //   75: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   78: return
      //   79: aload_1
      //   80: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   83: ifne -24 -> 59
      //   86: aload_0
      //   87: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   90: aload_1
      //   91: invokevirtual 127	java/lang/String:getBytes	()[B
      //   94: invokevirtual 114	java/io/OutputStream:write	([B)V
      //   97: goto -38 -> 59
      //   100: astore_1
      //   101: aload_0
      //   102: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   105: ifnull +52 -> 157
      //   108: aload_0
      //   109: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   112: invokevirtual 117	java/io/OutputStream:flush	()V
      //   115: ldc 81
      //   117: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   120: return
      //   121: astore_1
      //   122: ldc 81
      //   124: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   127: return
      //   128: astore_1
      //   129: ldc 81
      //   131: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: return
      //   135: astore_1
      //   136: aload_0
      //   137: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   140: ifnull +10 -> 150
      //   143: aload_0
      //   144: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   147: invokevirtual 117	java/io/OutputStream:flush	()V
      //   150: ldc 81
      //   152: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: aload_1
      //   156: athrow
      //   157: ldc 81
      //   159: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   162: return
      //   163: astore_2
      //   164: goto -14 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	167	0	this	b
      //   0	167	1	paramString	String
      //   28	13	2	str	String
      //   163	1	2	localIOException	IOException
      //   35	8	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   12	36	100	java/lang/Exception
      //   40	47	100	java/lang/Exception
      //   51	59	100	java/lang/Exception
      //   79	97	100	java/lang/Exception
      //   66	73	121	java/io/IOException
      //   108	115	128	java/io/IOException
      //   12	36	135	finally
      //   40	47	135	finally
      //   51	59	135	finally
      //   79	97	135	finally
      //   143	150	163	java/io/IOException
    }
    
    /* Error */
    final boolean d()
    {
      // Byte code:
      //   0: ldc 128
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   9: ifnull +20 -> 29
      //   12: aload_0
      //   13: getfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   16: invokevirtual 131	java/io/OutputStream:close	()V
      //   19: aload_0
      //   20: aconst_null
      //   21: putfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   24: aload_0
      //   25: aconst_null
      //   26: putfield 50	com/tencent/tbs/a/a/b$b:b	Ljava/io/File;
      //   29: ldc 128
      //   31: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: iconst_1
      //   35: ireturn
      //   36: astore_1
      //   37: aload_0
      //   38: aconst_null
      //   39: putfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 50	com/tencent/tbs/a/a/b$b:b	Ljava/io/File;
      //   47: ldc 128
      //   49: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: iconst_0
      //   53: ireturn
      //   54: astore_1
      //   55: aload_0
      //   56: aconst_null
      //   57: putfield 76	com/tencent/tbs/a/a/b$b:ahzA	Ljava/io/OutputStream;
      //   60: aload_0
      //   61: aconst_null
      //   62: putfield 50	com/tencent/tbs/a/a/b$b:b	Ljava/io/File;
      //   65: ldc 128
      //   67: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	this	b
      //   36	1	1	localIOException	IOException
      //   54	17	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	19	36	java/io/IOException
      //   12	19	54	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.a.a.b
 * JD-Core Version:    0.7.0.1
 */