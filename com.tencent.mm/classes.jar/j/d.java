package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k=1, mv={1, 4, 1})
public class d
  extends ab
{
  private static final long ajSU;
  private static final long ajSV;
  private static d ajSW;
  public static final a ajSX;
  private boolean ajSR;
  private d ajSS;
  private long ajST;
  
  static
  {
    AppMethodBeat.i(186493);
    ajSX = new a((byte)0);
    ajSU = TimeUnit.SECONDS.toMillis(60L);
    ajSV = TimeUnit.MILLISECONDS.toNanos(ajSU);
    AppMethodBeat.o(186493);
  }
  
  public final void enter()
  {
    AppMethodBeat.i(186509);
    long l = kIQ();
    boolean bool = kIR();
    if ((l == 0L) && (!bool))
    {
      AppMethodBeat.o(186509);
      return;
    }
    a.a(this, l, bool);
    AppMethodBeat.o(186509);
  }
  
  protected IOException g(IOException paramIOException)
  {
    AppMethodBeat.i(186513);
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause((Throwable)paramIOException);
    }
    paramIOException = (IOException)localInterruptedIOException;
    AppMethodBeat.o(186513);
    return paramIOException;
  }
  
  public final IOException h(IOException paramIOException)
  {
    AppMethodBeat.i(186511);
    paramIOException = g(paramIOException);
    AppMethodBeat.o(186511);
    return paramIOException;
  }
  
  protected void kHd() {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k=1, mv={1, 4, 1})
  public static final class a
  {
    static void a(d paramd, long paramLong, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(186436);
      for (;;)
      {
        try
        {
          if (!d.b(paramd))
          {
            if (i != 0) {
              break;
            }
            paramd = (Throwable)new IllegalStateException("Unbalanced enter/exit".toString());
            AppMethodBeat.o(186436);
            throw paramd;
          }
        }
        finally
        {
          AppMethodBeat.o(186436);
        }
        i = 0;
      }
      d.a(paramd, true);
      if (d.kIs() == null)
      {
        d.a(new d());
        new d.b().start();
      }
      long l = System.nanoTime();
      d locald1;
      if ((paramLong != 0L) && (paramBoolean))
      {
        d.a(paramd, Math.min(paramLong, paramd.kIS() - l) + l);
        paramLong = d.b(paramd, l);
        locald1 = d.kIs();
        s.checkNotNull(locald1);
      }
      for (;;)
      {
        if (d.c(locald1) != null)
        {
          d locald2 = d.c(locald1);
          s.checkNotNull(locald2);
          if (paramLong >= d.b(locald2, l)) {}
        }
        else
        {
          d.a(paramd, d.c(locald1));
          d.a(locald1, paramd);
          if (locald1 == d.kIs()) {
            ((Object)d.class).notify();
          }
          paramd = ah.aiuX;
          AppMethodBeat.o(186436);
          return;
          if (paramLong != 0L)
          {
            d.a(paramd, l + paramLong);
            break;
          }
          if (paramBoolean)
          {
            d.a(paramd, paramd.kIS());
            break;
          }
          paramd = (Throwable)new AssertionError();
          AppMethodBeat.o(186436);
          throw paramd;
        }
        locald1 = d.c(locald1);
        s.checkNotNull(locald1);
      }
    }
    
    public static boolean d(d paramd)
    {
      AppMethodBeat.i(186447);
      try
      {
        boolean bool = d.b(paramd);
        if (!bool) {
          return false;
        }
        d.a(paramd, false);
        for (d locald = d.kIs(); locald != null; locald = d.c(locald)) {
          if (d.c(locald) == paramd)
          {
            d.a(locald, d.c(paramd));
            d.a(paramd, null);
            return false;
          }
        }
        return true;
      }
      finally
      {
        AppMethodBeat.o(186447);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k=1, mv={1, 4, 1})
  static final class b
    extends Thread
  {
    public b()
    {
      super();
      AppMethodBeat.i(186423);
      setDaemon(true);
      AppMethodBeat.o(186423);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 48
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 6
      //   7: monitorenter
      //   8: getstatic 52	j/d:ajSX	Lj/d$a;
      //   11: astore 5
      //   13: invokestatic 56	j/d:kIs	()Lj/d;
      //   16: astore 5
      //   18: aload 5
      //   20: invokestatic 62	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   23: aload 5
      //   25: invokestatic 66	j/d:c	(Lj/d;)Lj/d;
      //   28: astore 5
      //   30: aload 5
      //   32: ifnonnull +80 -> 112
      //   35: invokestatic 72	java/lang/System:nanoTime	()J
      //   38: lstore_1
      //   39: ldc 6
      //   41: checkcast 74	java/lang/Object
      //   44: invokestatic 77	j/d:kIt	()J
      //   47: invokevirtual 81	java/lang/Object:wait	(J)V
      //   50: invokestatic 56	j/d:kIs	()Lj/d;
      //   53: astore 5
      //   55: aload 5
      //   57: invokestatic 62	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   60: aload 5
      //   62: invokestatic 66	j/d:c	(Lj/d;)Lj/d;
      //   65: ifnonnull +41 -> 106
      //   68: invokestatic 72	java/lang/System:nanoTime	()J
      //   71: lload_1
      //   72: lsub
      //   73: invokestatic 84	j/d:kIu	()J
      //   76: lcmp
      //   77: iflt +29 -> 106
      //   80: invokestatic 56	j/d:kIs	()Lj/d;
      //   83: astore 5
      //   85: aload 5
      //   87: invokestatic 56	j/d:kIs	()Lj/d;
      //   90: if_acmpne +113 -> 203
      //   93: aconst_null
      //   94: invokestatic 88	j/d:a	(Lj/d;)V
      //   97: ldc 6
      //   99: monitorexit
      //   100: ldc 48
      //   102: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: return
      //   106: aconst_null
      //   107: astore 5
      //   109: goto -24 -> 85
      //   112: aload 5
      //   114: invokestatic 72	java/lang/System:nanoTime	()J
      //   117: invokestatic 91	j/d:b	(Lj/d;J)J
      //   120: lstore_1
      //   121: lload_1
      //   122: lconst_0
      //   123: lcmp
      //   124: ifle +32 -> 156
      //   127: lload_1
      //   128: ldc2_w 92
      //   131: ldiv
      //   132: lstore_3
      //   133: ldc 6
      //   135: checkcast 74	java/lang/Object
      //   138: lload_3
      //   139: lload_1
      //   140: lload_3
      //   141: ldc2_w 92
      //   144: lmul
      //   145: lsub
      //   146: l2i
      //   147: invokevirtual 96	java/lang/Object:wait	(JI)V
      //   150: aconst_null
      //   151: astore 5
      //   153: goto -68 -> 85
      //   156: invokestatic 56	j/d:kIs	()Lj/d;
      //   159: astore 6
      //   161: aload 6
      //   163: invokestatic 62	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   166: aload 6
      //   168: aload 5
      //   170: invokestatic 66	j/d:c	(Lj/d;)Lj/d;
      //   173: invokestatic 99	j/d:a	(Lj/d;Lj/d;)V
      //   176: aload 5
      //   178: aconst_null
      //   179: invokestatic 99	j/d:a	(Lj/d;Lj/d;)V
      //   182: goto -97 -> 85
      //   185: astore 5
      //   187: ldc 6
      //   189: monitorexit
      //   190: ldc 48
      //   192: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   195: aload 5
      //   197: athrow
      //   198: astore 5
      //   200: goto -195 -> 5
      //   203: getstatic 105	kotlin/ah:aiuX	Lkotlin/ah;
      //   206: astore 6
      //   208: ldc 6
      //   210: monitorexit
      //   211: aload 5
      //   213: ifnull -208 -> 5
      //   216: aload 5
      //   218: invokevirtual 108	j/d:kHd	()V
      //   221: goto -216 -> 5
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	224	0	this	b
      //   38	102	1	l1	long
      //   132	9	3	l2	long
      //   11	166	5	localObject1	Object
      //   185	11	5	localObject2	Object
      //   198	19	5	localInterruptedException	java.lang.InterruptedException
      //   159	48	6	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   8	30	185	finally
      //   35	85	185	finally
      //   85	97	185	finally
      //   112	121	185	finally
      //   127	150	185	finally
      //   156	182	185	finally
      //   203	208	185	finally
      //   5	8	198	java/lang/InterruptedException
      //   97	105	198	java/lang/InterruptedException
      //   187	198	198	java/lang/InterruptedException
      //   208	211	198	java/lang/InterruptedException
      //   216	221	198	java/lang/InterruptedException
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 4, 1})
  public static final class c
    implements y
  {
    c(y paramy) {}
    
    public final void b(f paramf, long paramLong)
    {
      AppMethodBeat.i(186431);
      s.u(paramf, "source");
      c.C(paramf.size, 0L, paramLong);
      while (paramLong > 0L)
      {
        Object localObject = paramf.ajTb;
        s.checkNotNull(localObject);
        long l1 = 0L;
        long l2;
        for (;;)
        {
          l2 = l1;
          if (l1 < 65536L)
          {
            l1 += ((v)localObject).limit - ((v)localObject).pos;
            if (l1 >= paramLong) {
              l2 = paramLong;
            }
          }
          else
          {
            localObject = this.ajSY;
            ((d)localObject).enter();
          }
          try
          {
            this.ajSZ.b(paramf, l2);
            ah localah = ah.aiuX;
            if (!d.a.d((d)localObject)) {
              break label196;
            }
            paramf = (Throwable)((d)localObject).h(null);
            AppMethodBeat.o(186431);
            throw paramf;
          }
          catch (IOException paramf)
          {
            if (d.a.d((d)localObject)) {
              break;
            }
            paramf = (Throwable)paramf;
            AppMethodBeat.o(186431);
            throw paramf;
          }
          finally
          {
            d.a.d((d)localObject);
            AppMethodBeat.o(186431);
          }
          localObject = ((v)localObject).ajTx;
          s.checkNotNull(localObject);
        }
        for (;;)
        {
          paramf = (Throwable)((d)localObject).h(paramf);
        }
        label196:
        paramLong -= l2;
      }
      AppMethodBeat.o(186431);
    }
    
    public final void close()
    {
      AppMethodBeat.i(186446);
      d locald = this.ajSY;
      locald.enter();
      for (;;)
      {
        try
        {
          this.ajSZ.close();
          Object localObject = ah.aiuX;
          if (d.a.d(locald))
          {
            localObject = (Throwable)locald.h(null);
            AppMethodBeat.o(186446);
            throw ((Throwable)localObject);
          }
          AppMethodBeat.o(186446);
          return;
        }
        catch (IOException localIOException1)
        {
          if (!d.a.d(locald))
          {
            Throwable localThrowable1 = (Throwable)localIOException1;
            AppMethodBeat.o(186446);
            throw localThrowable1;
          }
        }
        finally
        {
          d.a.d(locald);
          AppMethodBeat.o(186446);
        }
        Throwable localThrowable2 = (Throwable)locald.h(localIOException2);
      }
    }
    
    public final void flush()
    {
      AppMethodBeat.i(186439);
      d locald = this.ajSY;
      locald.enter();
      for (;;)
      {
        try
        {
          this.ajSZ.flush();
          Object localObject = ah.aiuX;
          if (d.a.d(locald))
          {
            localObject = (Throwable)locald.h(null);
            AppMethodBeat.o(186439);
            throw ((Throwable)localObject);
          }
          AppMethodBeat.o(186439);
          return;
        }
        catch (IOException localIOException1)
        {
          if (!d.a.d(locald))
          {
            Throwable localThrowable1 = (Throwable)localIOException1;
            AppMethodBeat.o(186439);
            throw localThrowable1;
          }
        }
        finally
        {
          d.a.d(locald);
          AppMethodBeat.o(186439);
        }
        Throwable localThrowable2 = (Throwable)locald.h(localIOException2);
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186452);
      String str = "AsyncTimeout.sink(" + this.ajSZ + ')';
      AppMethodBeat.o(186452);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "okio"}, k=1, mv={1, 4, 1})
  public static final class d
    implements aa
  {
    d(aa paramaa) {}
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(186428);
      s.u(paramf, "sink");
      d locald = this.ajSY;
      locald.enter();
      for (;;)
      {
        try
        {
          paramLong = this.ajTa.a(paramf, paramLong);
          if (d.a.d(locald))
          {
            paramf = (Throwable)locald.h(null);
            AppMethodBeat.o(186428);
            throw paramf;
          }
          AppMethodBeat.o(186428);
          return paramLong;
        }
        catch (IOException paramf)
        {
          if (!d.a.d(locald))
          {
            paramf = (Throwable)paramf;
            AppMethodBeat.o(186428);
            throw paramf;
          }
        }
        finally
        {
          d.a.d(locald);
          AppMethodBeat.o(186428);
        }
        paramf = (Throwable)locald.h(paramf);
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(186434);
      d locald = this.ajSY;
      locald.enter();
      for (;;)
      {
        try
        {
          this.ajTa.close();
          Object localObject = ah.aiuX;
          if (d.a.d(locald))
          {
            localObject = (Throwable)locald.h(null);
            AppMethodBeat.o(186434);
            throw ((Throwable)localObject);
          }
          AppMethodBeat.o(186434);
          return;
        }
        catch (IOException localIOException1)
        {
          if (!d.a.d(locald))
          {
            Throwable localThrowable1 = (Throwable)localIOException1;
            AppMethodBeat.o(186434);
            throw localThrowable1;
          }
        }
        finally
        {
          d.a.d(locald);
          AppMethodBeat.o(186434);
        }
        Throwable localThrowable2 = (Throwable)locald.h(localIOException2);
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186442);
      String str = "AsyncTimeout.source(" + this.ajTa + ')';
      AppMethodBeat.o(186442);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.d
 * JD-Core Version:    0.7.0.1
 */