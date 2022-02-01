package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.ab;
import j.d;
import j.d.a;
import j.f;
import j.h;
import j.y;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import okhttp3.q;

public final class i
{
  final g ajQN;
  final Deque<q> ajRI;
  private c.a ajRJ;
  boolean ajRK;
  final b ajRL;
  final a ajRM;
  final c ajRN;
  final c ajRO;
  b ajRP;
  long ajRg;
  long ajRh;
  final int id;
  
  static
  {
    AppMethodBeat.i(186898);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(186898);
      return;
    }
  }
  
  i(int paramInt, g paramg, boolean paramBoolean1, boolean paramBoolean2, q paramq)
  {
    AppMethodBeat.i(186883);
    this.ajRg = 0L;
    this.ajRI = new ArrayDeque();
    this.ajRN = new c();
    this.ajRO = new c();
    this.ajRP = null;
    if (paramg == null)
    {
      paramg = new NullPointerException("connection == null");
      AppMethodBeat.o(186883);
      throw paramg;
    }
    this.id = paramInt;
    this.ajQN = paramg;
    this.ajRh = paramg.ajRj.kIh();
    this.ajRL = new b(paramg.ajRi.kIh());
    this.ajRM = new a();
    this.ajRL.mhq = paramBoolean2;
    this.ajRM.mhq = paramBoolean1;
    if (paramq != null) {
      this.ajRI.add(paramq);
    }
    if ((kHT()) && (paramq != null))
    {
      paramg = new IllegalStateException("locally-initiated streams shouldn't have headers yet");
      AppMethodBeat.o(186883);
      throw paramg;
    }
    if ((!kHT()) && (paramq == null))
    {
      paramg = new IllegalStateException("remotely-initiated streams should have headers");
      AppMethodBeat.o(186883);
      throw paramg;
    }
    AppMethodBeat.o(186883);
  }
  
  private boolean d(b paramb)
  {
    AppMethodBeat.i(186892);
    if ((!$assertionsDisabled) && (Thread.holdsLock(this)))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(186892);
      throw paramb;
    }
    try
    {
      if (this.ajRP != null) {
        return false;
      }
      if ((this.ajRL.mhq) && (this.ajRM.mhq)) {
        return false;
      }
      this.ajRP = paramb;
      notifyAll();
      this.ajQN.aNd(this.id);
      AppMethodBeat.o(186892);
      return true;
    }
    finally
    {
      AppMethodBeat.o(186892);
    }
  }
  
  final void Cb(long paramLong)
  {
    AppMethodBeat.i(186987);
    this.ajRh += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
    AppMethodBeat.o(186987);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(186932);
    if (!d(paramb))
    {
      AppMethodBeat.o(186932);
      return;
    }
    this.ajQN.b(this.id, paramb);
    AppMethodBeat.o(186932);
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(186939);
    if (!d(paramb))
    {
      AppMethodBeat.o(186939);
      return;
    }
    this.ajQN.a(this.id, paramb);
    AppMethodBeat.o(186939);
  }
  
  final void e(b paramb)
  {
    try
    {
      AppMethodBeat.i(186963);
      if (this.ajRP == null)
      {
        this.ajRP = paramb;
        notifyAll();
      }
      AppMethodBeat.o(186963);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 79	okhttp3/internal/e/i:ajRP	Lokhttp3/internal/e/b;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 112	okhttp3/internal/e/i:ajRL	Lokhttp3/internal/e/i$b;
    //   21: getfield 118	okhttp3/internal/e/i$b:mhq	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 112	okhttp3/internal/e/i:ajRL	Lokhttp3/internal/e/i$b;
    //   31: getfield 176	okhttp3/internal/e/i$b:closed	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 115	okhttp3/internal/e/i:ajRM	Lokhttp3/internal/e/i$a;
    //   41: getfield 119	okhttp3/internal/e/i$a:mhq	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 115	okhttp3/internal/e/i:ajRM	Lokhttp3/internal/e/i$a;
    //   51: getfield 177	okhttp3/internal/e/i$a:closed	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 179	okhttp3/internal/e/i:ajRK	Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	i
    //   1	67	1	bool1	boolean
    //   61	2	2	bool2	boolean
    //   8	2	3	localb	b
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public final boolean kHT()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.ajQN.ajQR == i; i = 0) {
      return true;
    }
    return false;
  }
  
  public final q kHU()
  {
    try
    {
      AppMethodBeat.i(186917);
      this.ajRN.enter();
    }
    finally
    {
      try
      {
        while ((this.ajRI.isEmpty()) && (this.ajRP == null))
        {
          kHZ();
          continue;
          throw localObject2;
        }
      }
      finally
      {
        this.ajRN.kIa();
        AppMethodBeat.o(186917);
      }
    }
    this.ajRN.kIa();
    if (!this.ajRI.isEmpty())
    {
      localObject3 = (q)this.ajRI.removeFirst();
      AppMethodBeat.o(186917);
      return localObject3;
    }
    Object localObject3 = new n(this.ajRP);
    AppMethodBeat.o(186917);
    throw ((Throwable)localObject3);
  }
  
  public final y kHV()
  {
    AppMethodBeat.i(186927);
    try
    {
      if ((!this.ajRK) && (!kHT()))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("reply before requesting the sink");
        AppMethodBeat.o(186927);
        throw localIllegalStateException;
      }
    }
    finally
    {
      AppMethodBeat.o(186927);
    }
    a locala = this.ajRM;
    AppMethodBeat.o(186927);
    return locala;
  }
  
  final void kHW()
  {
    AppMethodBeat.i(186957);
    if ((!$assertionsDisabled) && (Thread.holdsLock(this)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(186957);
      throw localAssertionError;
    }
    try
    {
      this.ajRL.mhq = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.ajQN.aNd(this.id);
      }
      AppMethodBeat.o(186957);
      return;
    }
    finally
    {
      AppMethodBeat.o(186957);
    }
  }
  
  final void kHX()
  {
    AppMethodBeat.i(186981);
    if ((!$assertionsDisabled) && (Thread.holdsLock(this)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(186981);
      throw localAssertionError;
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.ajRL.mhq) && (this.ajRL.closed))
        {
          if (this.ajRM.mhq) {
            break label139;
          }
          if (this.ajRM.closed)
          {
            break label139;
            bool = isOpen();
            if (i == 0) {
              break label117;
            }
            b(b.ajQd);
            AppMethodBeat.o(186981);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          break label133;
        }
      }
      finally
      {
        AppMethodBeat.o(186981);
      }
      label117:
      this.ajQN.aNd(this.id);
      label133:
      AppMethodBeat.o(186981);
      return;
      label139:
      int i = 1;
    }
  }
  
  final void kHY()
  {
    AppMethodBeat.i(186995);
    Object localObject;
    if (this.ajRM.closed)
    {
      localObject = new IOException("stream closed");
      AppMethodBeat.o(186995);
      throw ((Throwable)localObject);
    }
    if (this.ajRM.mhq)
    {
      localObject = new IOException("stream finished");
      AppMethodBeat.o(186995);
      throw ((Throwable)localObject);
    }
    if (this.ajRP != null)
    {
      localObject = new n(this.ajRP);
      AppMethodBeat.o(186995);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(186995);
  }
  
  final void kHZ()
  {
    AppMethodBeat.i(187002);
    try
    {
      wait();
      AppMethodBeat.o(187002);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      InterruptedIOException localInterruptedIOException = new InterruptedIOException();
      AppMethodBeat.o(187002);
      throw localInterruptedIOException;
    }
  }
  
  final class a
    implements y
  {
    private final f ajRQ;
    boolean closed;
    boolean mhq;
    
    static
    {
      AppMethodBeat.i(187019);
      if (!i.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(187019);
        return;
      }
    }
    
    a()
    {
      AppMethodBeat.i(186986);
      this.ajRQ = new f();
      AppMethodBeat.o(186986);
    }
    
    /* Error */
    private void PU(boolean paramBoolean)
    {
      // Byte code:
      //   0: ldc 53
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   9: astore 5
      //   11: aload 5
      //   13: monitorenter
      //   14: aload_0
      //   15: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   18: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   21: invokevirtual 62	okhttp3/internal/e/i$c:enter	()V
      //   24: aload_0
      //   25: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   28: getfield 66	okhttp3/internal/e/i:ajRh	J
      //   31: lconst_0
      //   32: lcmp
      //   33: ifgt +70 -> 103
      //   36: aload_0
      //   37: getfield 68	okhttp3/internal/e/i$a:mhq	Z
      //   40: ifne +63 -> 103
      //   43: aload_0
      //   44: getfield 70	okhttp3/internal/e/i$a:closed	Z
      //   47: ifne +56 -> 103
      //   50: aload_0
      //   51: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   54: getfield 74	okhttp3/internal/e/i:ajRP	Lokhttp3/internal/e/b;
      //   57: ifnonnull +46 -> 103
      //   60: aload_0
      //   61: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   64: invokevirtual 77	okhttp3/internal/e/i:kHZ	()V
      //   67: goto -43 -> 24
      //   70: astore 6
      //   72: aload_0
      //   73: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   76: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   79: invokevirtual 80	okhttp3/internal/e/i$c:kIa	()V
      //   82: ldc 53
      //   84: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload 6
      //   89: athrow
      //   90: astore 6
      //   92: aload 5
      //   94: monitorexit
      //   95: ldc 53
      //   97: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   100: aload 6
      //   102: athrow
      //   103: aload_0
      //   104: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   107: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   110: invokevirtual 80	okhttp3/internal/e/i$c:kIa	()V
      //   113: aload_0
      //   114: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   117: invokevirtual 83	okhttp3/internal/e/i:kHY	()V
      //   120: aload_0
      //   121: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   124: getfield 66	okhttp3/internal/e/i:ajRh	J
      //   127: aload_0
      //   128: getfield 50	okhttp3/internal/e/i$a:ajRQ	Lj/f;
      //   131: getfield 86	j/f:size	J
      //   134: invokestatic 92	java/lang/Math:min	(JJ)J
      //   137: lstore_3
      //   138: aload_0
      //   139: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   142: astore 6
      //   144: aload 6
      //   146: aload 6
      //   148: getfield 66	okhttp3/internal/e/i:ajRh	J
      //   151: lload_3
      //   152: lsub
      //   153: putfield 66	okhttp3/internal/e/i:ajRh	J
      //   156: aload 5
      //   158: monitorexit
      //   159: aload_0
      //   160: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   163: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   166: invokevirtual 62	okhttp3/internal/e/i$c:enter	()V
      //   169: aload_0
      //   170: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   173: getfield 96	okhttp3/internal/e/i:ajQN	Lokhttp3/internal/e/g;
      //   176: astore 5
      //   178: aload_0
      //   179: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   182: getfield 100	okhttp3/internal/e/i:id	I
      //   185: istore_2
      //   186: iload_1
      //   187: ifeq +45 -> 232
      //   190: lload_3
      //   191: aload_0
      //   192: getfield 50	okhttp3/internal/e/i$a:ajRQ	Lj/f;
      //   195: getfield 86	j/f:size	J
      //   198: lcmp
      //   199: ifne +33 -> 232
      //   202: iconst_1
      //   203: istore_1
      //   204: aload 5
      //   206: iload_2
      //   207: iload_1
      //   208: aload_0
      //   209: getfield 50	okhttp3/internal/e/i$a:ajRQ	Lj/f;
      //   212: lload_3
      //   213: invokevirtual 105	okhttp3/internal/e/g:a	(IZLj/f;J)V
      //   216: aload_0
      //   217: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   220: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   223: invokevirtual 80	okhttp3/internal/e/i$c:kIa	()V
      //   226: ldc 53
      //   228: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   231: return
      //   232: iconst_0
      //   233: istore_1
      //   234: goto -30 -> 204
      //   237: astore 5
      //   239: aload_0
      //   240: getfield 42	okhttp3/internal/e/i$a:ajRR	Lokhttp3/internal/e/i;
      //   243: getfield 57	okhttp3/internal/e/i:ajRO	Lokhttp3/internal/e/i$c;
      //   246: invokevirtual 80	okhttp3/internal/e/i$c:kIa	()V
      //   249: ldc 53
      //   251: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   254: aload 5
      //   256: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	257	0	this	a
      //   0	257	1	paramBoolean	boolean
      //   185	22	2	i	int
      //   137	76	3	l	long
      //   9	196	5	localObject1	Object
      //   237	18	5	localObject2	Object
      //   70	18	6	localObject3	Object
      //   90	11	6	localObject4	Object
      //   142	5	6	locali	i
      // Exception table:
      //   from	to	target	type
      //   24	67	70	finally
      //   14	24	90	finally
      //   72	90	90	finally
      //   103	159	90	finally
      //   169	186	237	finally
      //   190	202	237	finally
      //   204	216	237	finally
    }
    
    public final void b(f paramf, long paramLong)
    {
      AppMethodBeat.i(187026);
      if ((!$assertionsDisabled) && (Thread.holdsLock(i.this)))
      {
        paramf = new AssertionError();
        AppMethodBeat.o(187026);
        throw paramf;
      }
      this.ajRQ.b(paramf, paramLong);
      while (this.ajRQ.size >= 16384L) {
        PU(false);
      }
      AppMethodBeat.o(187026);
    }
    
    public final void close()
    {
      AppMethodBeat.i(187063);
      if ((!$assertionsDisabled) && (Thread.holdsLock(i.this)))
      {
        ??? = new AssertionError();
        AppMethodBeat.o(187063);
        throw ((Throwable)???);
      }
      synchronized (i.this)
      {
        if (this.closed)
        {
          AppMethodBeat.o(187063);
          return;
        }
        if (!i.this.ajRM.mhq) {
          if (this.ajRQ.size > 0L)
          {
            if (this.ajRQ.size <= 0L) {
              break label135;
            }
            PU(true);
          }
        }
      }
      label135:
      synchronized (i.this)
      {
        this.closed = true;
        i.this.ajQN.ajRk.flush();
        i.this.kHX();
        AppMethodBeat.o(187063);
        return;
      }
    }
    
    public final void flush()
    {
      AppMethodBeat.i(187041);
      if ((!$assertionsDisabled) && (Thread.holdsLock(i.this)))
      {
        ??? = new AssertionError();
        AppMethodBeat.o(187041);
        throw ((Throwable)???);
      }
      synchronized (i.this)
      {
        i.this.kHY();
        if (this.ajRQ.size > 0L)
        {
          PU(false);
          i.this.ajQN.ajRk.flush();
        }
      }
    }
    
    public final ab kHm()
    {
      return i.this.ajRO;
    }
  }
  
  final class b
    implements aa
  {
    private final f ajRS;
    private final f ajRT;
    private final long ajRU;
    boolean closed;
    boolean mhq;
    
    static
    {
      AppMethodBeat.i(186999);
      if (!i.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(186999);
        return;
      }
    }
    
    b(long paramLong)
    {
      AppMethodBeat.i(186992);
      this.ajRS = new f();
      this.ajRT = new f();
      this.ajRU = paramLong;
      AppMethodBeat.o(186992);
    }
    
    private void BZ(long paramLong)
    {
      AppMethodBeat.i(186994);
      if ((!$assertionsDisabled) && (Thread.holdsLock(i.this)))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(186994);
        throw localAssertionError;
      }
      i.this.ajQN.BZ(paramLong);
      AppMethodBeat.o(186994);
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(187031);
      Object localObject1;
      long l1;
      if (paramLong < 0L)
      {
        paramf = new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(187031);
        throw paramf;
        l1 = localObject1;
      }
      for (;;)
      {
        i locali;
        label75:
        q localq;
        long l2;
        try
        {
          if (this.mhq) {
            break label440;
          }
          l1 = localObject1;
          if (localb != null) {
            break label440;
          }
          i.this.kHZ();
          if (i.b(i.this).isEmpty()) {
            break label275;
          }
        }
        finally
        {
          try
          {
            i.this.ajRN.kIa();
            localq = null;
            l2 = -1L;
            locali = i.this;
            i.this.ajRN.enter();
            if (i.this.ajRP == null) {
              break label446;
            }
            localb = i.this.ajRP;
            if (!this.closed) {
              break label174;
            }
            paramf = new IOException("stream closed");
            AppMethodBeat.o(187031);
            throw paramf;
          }
          finally
          {
            AppMethodBeat.o(187031);
          }
          paramf = finally;
          i.this.ajRN.kIa();
          AppMethodBeat.o(187031);
        }
        label174:
        Object localObject2;
        if (i.c(i.this) != null)
        {
          localq = (q)i.b(i.this).removeFirst();
          localObject2 = i.c(i.this);
          l1 = l2;
        }
        for (;;)
        {
          i.this.ajRN.kIa();
          if ((localq != null) && (localObject2 != null)) {
            break label75;
          }
          if (l1 != -1L)
          {
            BZ(l1);
            AppMethodBeat.o(187031);
            return l1;
            label275:
            if (this.ajRT.size <= 0L) {
              break;
            }
            l2 = this.ajRT.a(paramf, Math.min(paramLong, this.ajRT.size));
            localObject2 = i.this;
            ((i)localObject2).ajRg += l2;
            l1 = l2;
            if (localb != null) {
              break label440;
            }
            l1 = l2;
            if (i.this.ajRg < i.this.ajQN.ajRi.kIh() / 2) {
              break label440;
            }
            i.this.ajQN.bw(i.this.id, i.this.ajRg);
            i.this.ajRg = 0L;
            localObject2 = null;
            l1 = l2;
            continue;
          }
          if (localb != null)
          {
            paramf = new n(localb);
            AppMethodBeat.o(187031);
            throw paramf;
          }
          AppMethodBeat.o(187031);
          return -1L;
          label440:
          localObject2 = null;
        }
        label446:
        b localb = null;
      }
    }
    
    final void a(h paramh, long paramLong)
    {
      AppMethodBeat.i(187056);
      long l1 = paramLong;
      long l2;
      if (!$assertionsDisabled)
      {
        l1 = paramLong;
        if (Thread.holdsLock(i.this))
        {
          paramh = new AssertionError();
          AppMethodBeat.o(187056);
          throw paramh;
          l2 = l1 - paramLong;
          l1 = 0L;
        }
      }
      for (;;)
      {
        synchronized (i.this)
        {
          if (this.closed)
          {
            paramLong = this.ajRS.size;
            this.ajRS.clear();
            l1 = l2;
            if (paramLong > 0L)
            {
              BZ(paramLong);
              l1 = l2;
            }
            if (l1 <= 0L) {
              break label316;
            }
            boolean bool;
            synchronized (i.this)
            {
              bool = this.mhq;
              if (this.ajRT.size + l1 > this.ajRU)
              {
                i = 1;
                if (i != 0)
                {
                  paramh.Ci(l1);
                  i.this.c(b.ajQb);
                  AppMethodBeat.o(187056);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramh.Ci(l1);
              AppMethodBeat.o(187056);
              return;
            }
            paramLong = paramh.a(this.ajRS, l1);
            if (paramLong != -1L) {
              break;
            }
            paramh = new EOFException();
            AppMethodBeat.o(187056);
            throw paramh;
          }
          if (this.ajRT.size == 0L)
          {
            i = 1;
            this.ajRT.a(this.ajRS);
            paramLong = l1;
            if (i == 0) {
              continue;
            }
            i.this.notifyAll();
            paramLong = l1;
          }
        }
        int i = 0;
      }
      label316:
      AppMethodBeat.o(187056);
    }
    
    public final void close()
    {
      AppMethodBeat.i(187080);
      for (;;)
      {
        synchronized (i.this)
        {
          this.closed = true;
          long l = this.ajRT.size;
          this.ajRT.clear();
          if ((i.b(i.this).isEmpty()) || (i.c(i.this) == null)) {
            break label171;
          }
          localArrayList = new ArrayList(i.b(i.this));
          i.b(i.this).clear();
          Object localObject1 = i.c(i.this);
          i.this.notifyAll();
          if (l > 0L) {
            BZ(l);
          }
          i.this.kHX();
          if (localObject1 != null)
          {
            localObject1 = localArrayList.iterator();
            if (((Iterator)localObject1).hasNext()) {
              ((Iterator)localObject1).next();
            }
          }
        }
        AppMethodBeat.o(187080);
        return;
        label171:
        Object localObject3 = null;
        ArrayList localArrayList = null;
      }
    }
    
    public final ab kHm()
    {
      return i.this.ajRN;
    }
  }
  
  final class c
    extends d
  {
    c() {}
    
    public final IOException g(IOException paramIOException)
    {
      AppMethodBeat.i(187004);
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      AppMethodBeat.o(187004);
      return localSocketTimeoutException;
    }
    
    public final void kHd()
    {
      AppMethodBeat.i(186997);
      i.this.c(b.ajQd);
      synchronized (i.this.ajQN)
      {
        if (???.ajRc < ???.ajRb)
        {
          AppMethodBeat.o(186997);
          return;
        }
        ???.ajRb += 1L;
        ???.ajRf = (System.nanoTime() + 1000000000L);
      }
    }
    
    public final void kIa()
    {
      AppMethodBeat.i(187013);
      if (d.a.d(this))
      {
        IOException localIOException = g(null);
        AppMethodBeat.o(187013);
        throw localIOException;
      }
      AppMethodBeat.o(187013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.i
 * JD-Core Version:    0.7.0.1
 */