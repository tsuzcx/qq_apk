package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g
  implements Closeable
{
  private static final ExecutorService ajQQ;
  final Map<Integer, i> Jew;
  final boolean ajQR;
  final c ajQS;
  final String ajQT;
  int ajQU;
  int ajQV;
  final ScheduledExecutorService ajQW;
  private final ExecutorService ajQX;
  final l ajQY;
  private long ajQZ;
  private long ajRa;
  long ajRb;
  long ajRc;
  private long ajRd;
  private long ajRe;
  long ajRf;
  long ajRg;
  long ajRh;
  m ajRi;
  final m ajRj;
  final j ajRk;
  final e ajRl;
  final Set<Integer> ajRm;
  final Socket cBb;
  private boolean shutdown;
  
  static
  {
    AppMethodBeat.i(186959);
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajQQ = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.threadFactory("OkHttp Http2Connection", true));
      AppMethodBeat.o(186959);
      return;
    }
  }
  
  g(a parama)
  {
    AppMethodBeat.i(186893);
    this.Jew = new LinkedHashMap();
    this.ajQZ = 0L;
    this.ajRa = 0L;
    this.ajRb = 0L;
    this.ajRc = 0L;
    this.ajRd = 0L;
    this.ajRe = 0L;
    this.ajRf = 0L;
    this.ajRg = 0L;
    this.ajRi = new m();
    this.ajRj = new m();
    this.ajRm = new LinkedHashSet();
    this.ajQY = parama.ajQY;
    this.ajQR = parama.ajQR;
    this.ajQS = parama.ajQS;
    if (parama.ajQR) {}
    for (int i = 1;; i = 2)
    {
      this.ajQV = i;
      if (parama.ajQR) {
        this.ajQV += 2;
      }
      if (parama.ajQR) {
        this.ajRi.qG(7, 16777216);
      }
      this.ajQT = parama.ajQT;
      this.ajQW = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.threadFactory(okhttp3.internal.c.format("OkHttp %s Writer", new Object[] { this.ajQT }), false));
      if (parama.ajRu != 0) {
        this.ajQW.scheduleAtFixedRate(new b(), parama.ajRu, parama.ajRu, TimeUnit.MILLISECONDS);
      }
      this.ajQX = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.threadFactory(okhttp3.internal.c.format("OkHttp %s Push Observer", new Object[] { this.ajQT }), true));
      this.ajRj.qG(7, 65535);
      this.ajRj.qG(5, 16384);
      this.ajRh = this.ajRj.kIh();
      this.cBb = parama.cBb;
      this.ajRk = new j(parama.ajPn, this.ajQR);
      this.ajRl = new e(new h(parama.cnO, this.ajQR));
      AppMethodBeat.o(186893);
      return;
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(186899);
    synchronized (this.ajRk)
    {
      try
      {
        if (this.shutdown) {
          return;
        }
        this.shutdown = true;
        int i = this.ajQU;
        this.ajRk.a(i, paramb, okhttp3.internal.c.EMPTY_BYTE_ARRAY);
        return;
      }
      finally
      {
        AppMethodBeat.o(186899);
      }
    }
  }
  
  static boolean aNe(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  private void kHO()
  {
    AppMethodBeat.i(186901);
    try
    {
      b localb = b.ajPZ;
      a(localb, localb);
      AppMethodBeat.o(186901);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(186901);
    }
  }
  
  final void BZ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(186989);
      this.ajRg += paramLong;
      if (this.ajRg >= this.ajRi.kIh() / 2)
      {
        bw(0, this.ajRg);
        this.ajRg = 0L;
      }
      AppMethodBeat.o(186989);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean Ca(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 265	okhttp3/internal/e/g:shutdown	Z
    //   9: istore 6
    //   11: iload 6
    //   13: ifeq +8 -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 5
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 152	okhttp3/internal/e/g:ajRc	J
    //   25: aload_0
    //   26: getfield 150	okhttp3/internal/e/g:ajRb	J
    //   29: lcmp
    //   30: ifge +14 -> 44
    //   33: aload_0
    //   34: getfield 158	okhttp3/internal/e/g:ajRf	J
    //   37: lstore_3
    //   38: lload_1
    //   39: lload_3
    //   40: lcmp
    //   41: ifge -25 -> 16
    //   44: iconst_1
    //   45: istore 5
    //   47: goto -31 -> 16
    //   50: astore 7
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 7
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	g
    //   0	57	1	paramLong	long
    //   37	3	3	l	long
    //   1	45	5	bool1	boolean
    //   9	3	6	bool2	boolean
    //   50	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	50	finally
    //   21	38	50	finally
  }
  
  final i T(List<c> paramList, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(187008);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false) {
      synchronized (this.ajRk)
      {
        try
        {
          if (this.ajQV > 1073741823) {
            a(b.ajQc);
          }
          if (!this.shutdown) {
            break;
          }
          paramList = new a();
          AppMethodBeat.o(187008);
          throw paramList;
        }
        finally
        {
          AppMethodBeat.o(187008);
        }
      }
    }
    int j = this.ajQV;
    this.ajQV += 2;
    i locali = new i(j, this, bool, false, null);
    if ((paramBoolean) && (this.ajRh != 0L) && (locali.ajRh != 0L)) {}
    for (;;)
    {
      if (locali.isOpen()) {
        this.Jew.put(Integer.valueOf(j), locali);
      }
      this.ajRk.b(bool, j, paramList);
      if (i != 0) {
        this.ajRk.flush();
      }
      AppMethodBeat.o(187008);
      return locali;
      i = 1;
    }
  }
  
  final void a(final int paramInt, final b paramb)
  {
    AppMethodBeat.i(187034);
    try
    {
      this.ajQW.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[] { this.ajQT, Integer.valueOf(paramInt) })
      {
        public final void execute()
        {
          AppMethodBeat.i(186950);
          try
          {
            g.this.b(paramInt, paramb);
            AppMethodBeat.o(186950);
            return;
          }
          catch (IOException localIOException)
          {
            g.b(g.this);
            AppMethodBeat.o(186950);
          }
        }
      });
      AppMethodBeat.o(187034);
      return;
    }
    catch (RejectedExecutionException paramb)
    {
      AppMethodBeat.o(187034);
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, f paramf, long paramLong)
  {
    AppMethodBeat.i(187029);
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.ajRk.a(paramBoolean, paramInt, paramf, 0);
      AppMethodBeat.o(187029);
      return;
    }
    for (;;)
    {
      try
      {
        int i = Math.min((int)Math.min(l, this.ajRh), this.ajRk.dkq);
        this.ajRh -= i;
        l -= i;
        j localj = this.ajRk;
        if ((!paramBoolean) || (l != 0L)) {
          break label204;
        }
        bool = true;
        localj.a(bool, paramInt, paramf, i);
        if (l <= 0L) {
          break;
        }
        try
        {
          if (this.ajRh > 0L) {
            continue;
          }
          if (!this.Jew.containsKey(Integer.valueOf(paramInt)))
          {
            paramf = new IOException("stream closed");
            AppMethodBeat.o(187029);
            throw paramf;
          }
        }
        catch (InterruptedException paramf)
        {
          Thread.currentThread().interrupt();
          paramf = new InterruptedIOException();
          AppMethodBeat.o(187029);
          throw paramf;
        }
        wait();
      }
      finally
      {
        AppMethodBeat.o(187029);
      }
      continue;
      label204:
      boolean bool = false;
    }
    AppMethodBeat.o(187029);
  }
  
  final void a(okhttp3.internal.b paramb)
  {
    try
    {
      AppMethodBeat.i(187092);
      if (!this.shutdown) {
        this.ajQX.execute(paramb);
      }
      AppMethodBeat.o(187092);
      return;
    }
    finally {}
  }
  
  /* Error */
  final void a(b paramb1, b paramb2)
  {
    // Byte code:
    //   0: ldc_w 414
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 103	okhttp3/internal/e/g:$assertionsDisabled	Z
    //   9: ifne +26 -> 35
    //   12: aload_0
    //   13: invokestatic 417	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   16: ifeq +19 -> 35
    //   19: new 419	java/lang/AssertionError
    //   22: dup
    //   23: invokespecial 420	java/lang/AssertionError:<init>	()V
    //   26: astore_1
    //   27: ldc_w 414
    //   30: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: athrow
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 320	okhttp3/internal/e/g:a	(Lokhttp3/internal/e/b;)V
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 144	okhttp3/internal/e/g:Jew	Ljava/util/Map;
    //   48: invokeinterface 423 1 0
    //   53: ifne +195 -> 248
    //   56: aload_0
    //   57: getfield 144	okhttp3/internal/e/g:Jew	Ljava/util/Map;
    //   60: invokeinterface 427 1 0
    //   65: aload_0
    //   66: getfield 144	okhttp3/internal/e/g:Jew	Ljava/util/Map;
    //   69: invokeinterface 430 1 0
    //   74: anewarray 325	okhttp3/internal/e/i
    //   77: invokeinterface 436 2 0
    //   82: checkcast 438	[Lokhttp3/internal/e/i;
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 144	okhttp3/internal/e/g:Jew	Ljava/util/Map;
    //   91: invokeinterface 441 1 0
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: astore 5
    //   101: aload 6
    //   103: ifnull +71 -> 174
    //   106: aload 6
    //   108: arraylength
    //   109: istore 4
    //   111: iconst_0
    //   112: istore_3
    //   113: iload_3
    //   114: iload 4
    //   116: if_icmpge +55 -> 171
    //   119: aload 6
    //   121: iload_3
    //   122: aaload
    //   123: astore 5
    //   125: aload 5
    //   127: aload_2
    //   128: invokevirtual 443	okhttp3/internal/e/i:b	(Lokhttp3/internal/e/b;)V
    //   131: aload_1
    //   132: astore 5
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: istore_3
    //   138: aload 5
    //   140: astore_1
    //   141: goto -28 -> 113
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: ldc_w 414
    //   150: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_1
    //   154: athrow
    //   155: astore 7
    //   157: aload_1
    //   158: astore 5
    //   160: aload_1
    //   161: ifnull -27 -> 134
    //   164: aload 7
    //   166: astore 5
    //   168: goto -34 -> 134
    //   171: aload_1
    //   172: astore 5
    //   174: aload_0
    //   175: getfield 247	okhttp3/internal/e/g:ajRk	Lokhttp3/internal/e/j;
    //   178: invokevirtual 446	okhttp3/internal/e/j:close	()V
    //   181: aload 5
    //   183: astore_1
    //   184: aload_0
    //   185: getfield 236	okhttp3/internal/e/g:cBb	Ljava/net/Socket;
    //   188: invokevirtual 449	java/net/Socket:close	()V
    //   191: aload_0
    //   192: getfield 204	okhttp3/internal/e/g:ajQW	Ljava/util/concurrent/ScheduledExecutorService;
    //   195: invokeinterface 451 1 0
    //   200: aload_0
    //   201: getfield 226	okhttp3/internal/e/g:ajQX	Ljava/util/concurrent/ExecutorService;
    //   204: invokeinterface 452 1 0
    //   209: aload_1
    //   210: ifnull +23 -> 233
    //   213: ldc_w 414
    //   216: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: aload 5
    //   224: ifnull -40 -> 184
    //   227: aload 5
    //   229: astore_1
    //   230: goto -46 -> 184
    //   233: ldc_w 414
    //   236: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: astore_1
    //   241: goto -199 -> 42
    //   244: astore_1
    //   245: goto -54 -> 191
    //   248: aconst_null
    //   249: astore 6
    //   251: goto -155 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	g
    //   0	254	1	paramb1	b
    //   0	254	2	paramb2	b
    //   112	26	3	i	int
    //   109	8	4	j	int
    //   99	129	5	localObject	Object
    //   85	165	6	arrayOfi	i[]
    //   155	10	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   44	96	144	finally
    //   96	98	144	finally
    //   125	131	155	java/io/IOException
    //   174	181	221	java/io/IOException
    //   35	40	240	java/io/IOException
    //   184	191	244	java/io/IOException
  }
  
  final i aNc(int paramInt)
  {
    try
    {
      AppMethodBeat.i(186965);
      i locali = (i)this.Jew.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(186965);
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final i aNd(int paramInt)
  {
    try
    {
      AppMethodBeat.i(186973);
      i locali = (i)this.Jew.remove(Integer.valueOf(paramInt));
      notifyAll();
      AppMethodBeat.o(186973);
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void b(int paramInt, b paramb)
  {
    AppMethodBeat.i(187037);
    this.ajRk.c(paramInt, paramb);
    AppMethodBeat.o(187037);
  }
  
  final void bw(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(187044);
    try
    {
      this.ajQW.execute(new okhttp3.internal.b("OkHttp Window Update %s stream %d", new Object[] { this.ajQT, Integer.valueOf(paramInt) })
      {
        public final void execute()
        {
          AppMethodBeat.i(186948);
          try
          {
            g.this.ajRk.bx(paramInt, paramLong);
            AppMethodBeat.o(186948);
            return;
          }
          catch (IOException localIOException)
          {
            g.b(g.this);
            AppMethodBeat.o(186948);
          }
        }
      });
      AppMethodBeat.o(187044);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      AppMethodBeat.o(187044);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(187057);
    a(b.ajPY, b.ajQd);
    AppMethodBeat.o(187057);
  }
  
  /* Error */
  public final int kHN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 167	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
    //   6: astore_2
    //   7: aload_2
    //   8: getfield 487	okhttp3/internal/e/m:ajSe	I
    //   11: bipush 16
    //   13: iand
    //   14: ifeq +14 -> 28
    //   17: aload_2
    //   18: getfield 491	okhttp3/internal/e/m:aql	[I
    //   21: iconst_4
    //   22: iaload
    //   23: istore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: ldc 106
    //   30: istore_1
    //   31: goto -7 -> 24
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	g
    //   23	8	1	i	int
    //   6	12	2	localm	m
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	34	finally
  }
  
  public final void kHP()
  {
    AppMethodBeat.i(187084);
    this.ajRk.kIb();
    this.ajRk.c(this.ajRi);
    int i = this.ajRi.kIh();
    if (i != 65535) {
      this.ajRk.bx(0, i - 65535);
    }
    new Thread(this.ajRl).start();
    AppMethodBeat.o(187084);
  }
  
  final void w(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187049);
    try
    {
      this.ajRk.x(paramBoolean, paramInt1, paramInt2);
      AppMethodBeat.o(187049);
      return;
    }
    catch (IOException localIOException)
    {
      kHO();
      AppMethodBeat.o(187049);
    }
  }
  
  public static final class a
  {
    j.g ajPn;
    boolean ajQR = true;
    public g.c ajQS = g.c.ajRv;
    String ajQT;
    l ajQY = l.ajSd;
    public int ajRu;
    Socket cBb;
    j.h cnO;
    
    public final a a(Socket paramSocket, String paramString, j.h paramh, j.g paramg)
    {
      this.cBb = paramSocket;
      this.ajQT = paramString;
      this.cnO = paramh;
      this.ajPn = paramg;
      return this;
    }
    
    public final g kHR()
    {
      AppMethodBeat.i(187005);
      g localg = new g(this);
      AppMethodBeat.o(187005);
      return localg;
    }
  }
  
  final class b
    extends okhttp3.internal.b
  {
    b()
    {
      super(new Object[] { g.this.ajQT });
      AppMethodBeat.i(187015);
      AppMethodBeat.o(187015);
    }
    
    public final void execute()
    {
      AppMethodBeat.i(187027);
      synchronized (g.this)
      {
        int i;
        if (g.c(g.this) < g.d(g.this))
        {
          i = 1;
          if (i != 0)
          {
            g.b(g.this);
            AppMethodBeat.o(187027);
          }
        }
        else
        {
          g.e(g.this);
          i = 0;
        }
      }
      g.this.w(false, 1, 0);
      AppMethodBeat.o(187027);
    }
  }
  
  public static abstract class c
  {
    public static final c ajRv = new c()
    {
      public final void a(i paramAnonymousi)
      {
        AppMethodBeat.i(186985);
        paramAnonymousi.b(b.ajQc);
        AppMethodBeat.o(186985);
      }
    };
    
    public void a(g paramg) {}
    
    public abstract void a(i parami);
  }
  
  final class d
    extends okhttp3.internal.b
  {
    final boolean ajRw;
    final int ajRx;
    final int ajRy;
    
    d(int paramInt1, int paramInt2)
    {
      super(new Object[] { g.this.ajQT, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.i(187022);
      this.ajRw = true;
      this.ajRx = paramInt1;
      this.ajRy = paramInt2;
      AppMethodBeat.o(187022);
    }
    
    public final void execute()
    {
      AppMethodBeat.i(187025);
      g.this.w(this.ajRw, this.ajRx, this.ajRy);
      AppMethodBeat.o(187025);
    }
  }
  
  final class e
    extends okhttp3.internal.b
    implements h.b
  {
    final h ajRz;
    
    e(h paramh)
    {
      super(new Object[] { g.this.ajQT });
      AppMethodBeat.i(187016);
      this.ajRz = paramh;
      AppMethodBeat.o(187016);
    }
    
    public final void Y(int paramInt, List<c> paramList)
    {
      AppMethodBeat.i(187167);
      synchronized (g.this)
      {
        if (???.ajRm.contains(Integer.valueOf(paramInt)))
        {
          ???.a(paramInt, b.ajPZ);
          AppMethodBeat.o(187167);
          return;
        }
        ???.ajRm.add(Integer.valueOf(paramInt));
      }
    }
    
    public final void a(int paramInt, j.i arg2)
    {
      AppMethodBeat.i(187146);
      ???.kIN();
      synchronized (g.this)
      {
        i[] arrayOfi = (i[])g.this.Jew.values().toArray(new i[g.this.Jew.size()]);
        g.k(g.this);
        int j = arrayOfi.length;
        int i = 0;
        if (i < j)
        {
          ??? = arrayOfi[i];
          if ((???.id > paramInt) && (???.kHT()))
          {
            ???.e(b.ajQc);
            g.this.aNd(???.id);
          }
          i += 1;
        }
      }
    }
    
    public final void a(final m paramm)
    {
      AppMethodBeat.i(187117);
      try
      {
        g.g(g.this).execute(new okhttp3.internal.b("OkHttp %s ACK Settings", new Object[] { g.this.ajQT })
        {
          /* Error */
          public final void execute()
          {
            // Byte code:
            //   0: aconst_null
            //   1: astore 6
            //   3: ldc 35
            //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   8: aload_0
            //   9: getfield 22	okhttp3/internal/e/g$e$2:ajRB	Lokhttp3/internal/e/g$e;
            //   12: astore 8
            //   14: aload_0
            //   15: getfield 24	okhttp3/internal/e/g$e$2:ajRC	Z
            //   18: istore_3
            //   19: aload_0
            //   20: getfield 26	okhttp3/internal/e/g$e$2:ajRD	Lokhttp3/internal/e/m;
            //   23: astore 10
            //   25: lconst_0
            //   26: lstore 4
            //   28: aload 8
            //   30: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   33: getfield 49	okhttp3/internal/e/g:ajRk	Lokhttp3/internal/e/j;
            //   36: astore 7
            //   38: aload 7
            //   40: monitorenter
            //   41: aload 8
            //   43: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   46: astore 9
            //   48: aload 9
            //   50: monitorenter
            //   51: aload 8
            //   53: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   56: getfield 52	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
            //   59: invokevirtual 58	okhttp3/internal/e/m:kIh	()I
            //   62: istore_2
            //   63: iload_3
            //   64: ifeq +28 -> 92
            //   67: aload 8
            //   69: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   72: getfield 52	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
            //   75: astore 11
            //   77: aload 11
            //   79: iconst_0
            //   80: putfield 62	okhttp3/internal/e/m:ajSe	I
            //   83: aload 11
            //   85: getfield 66	okhttp3/internal/e/m:aql	[I
            //   88: iconst_0
            //   89: invokestatic 72	java/util/Arrays:fill	([II)V
            //   92: aload 8
            //   94: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   97: getfield 52	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
            //   100: astore 11
            //   102: iconst_0
            //   103: istore_1
            //   104: iload_1
            //   105: bipush 10
            //   107: if_icmpge +29 -> 136
            //   110: aload 10
            //   112: iload_1
            //   113: invokevirtual 76	okhttp3/internal/e/m:hT	(I)Z
            //   116: ifeq +271 -> 387
            //   119: aload 11
            //   121: iload_1
            //   122: aload 10
            //   124: getfield 66	okhttp3/internal/e/m:aql	[I
            //   127: iload_1
            //   128: iaload
            //   129: invokevirtual 80	okhttp3/internal/e/m:qG	(II)Lokhttp3/internal/e/m;
            //   132: pop
            //   133: goto +254 -> 387
            //   136: aload 8
            //   138: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   141: getfield 52	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
            //   144: invokevirtual 58	okhttp3/internal/e/m:kIh	()I
            //   147: istore_1
            //   148: iload_1
            //   149: iconst_m1
            //   150: if_icmpeq +231 -> 381
            //   153: iload_1
            //   154: iload_2
            //   155: if_icmpeq +226 -> 381
            //   158: iload_1
            //   159: iload_2
            //   160: isub
            //   161: i2l
            //   162: lstore 4
            //   164: aload 8
            //   166: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   169: getfield 84	okhttp3/internal/e/g:Jew	Ljava/util/Map;
            //   172: invokeinterface 90 1 0
            //   177: ifne +217 -> 394
            //   180: aload 8
            //   182: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   185: getfield 84	okhttp3/internal/e/g:Jew	Ljava/util/Map;
            //   188: invokeinterface 94 1 0
            //   193: aload 8
            //   195: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   198: getfield 84	okhttp3/internal/e/g:Jew	Ljava/util/Map;
            //   201: invokeinterface 97 1 0
            //   206: anewarray 99	okhttp3/internal/e/i
            //   209: invokeinterface 105 2 0
            //   214: checkcast 107	[Lokhttp3/internal/e/i;
            //   217: astore 6
            //   219: goto +175 -> 394
            //   222: aload 9
            //   224: monitorexit
            //   225: aload 8
            //   227: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   230: getfield 49	okhttp3/internal/e/g:ajRk	Lokhttp3/internal/e/j;
            //   233: aload 8
            //   235: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   238: getfield 52	okhttp3/internal/e/g:ajRj	Lokhttp3/internal/e/m;
            //   241: invokevirtual 112	okhttp3/internal/e/j:b	(Lokhttp3/internal/e/m;)V
            //   244: aload 7
            //   246: monitorexit
            //   247: aload 6
            //   249: ifnull +92 -> 341
            //   252: aload 6
            //   254: arraylength
            //   255: istore_2
            //   256: iconst_0
            //   257: istore_1
            //   258: iload_1
            //   259: iload_2
            //   260: if_icmpge +81 -> 341
            //   263: aload 6
            //   265: iload_1
            //   266: aaload
            //   267: astore 7
            //   269: aload 7
            //   271: monitorenter
            //   272: aload 7
            //   274: lload 4
            //   276: invokevirtual 116	okhttp3/internal/e/i:Cb	(J)V
            //   279: aload 7
            //   281: monitorexit
            //   282: iload_1
            //   283: iconst_1
            //   284: iadd
            //   285: istore_1
            //   286: goto -28 -> 258
            //   289: astore 6
            //   291: aload 9
            //   293: monitorexit
            //   294: ldc 35
            //   296: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   299: aload 6
            //   301: athrow
            //   302: astore 6
            //   304: aload 7
            //   306: monitorexit
            //   307: ldc 35
            //   309: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   312: aload 6
            //   314: athrow
            //   315: astore 9
            //   317: aload 8
            //   319: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   322: invokestatic 122	okhttp3/internal/e/g:b	(Lokhttp3/internal/e/g;)V
            //   325: goto -81 -> 244
            //   328: astore 6
            //   330: aload 7
            //   332: monitorexit
            //   333: ldc 35
            //   335: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   338: aload 6
            //   340: athrow
            //   341: invokestatic 126	okhttp3/internal/e/g:kHQ	()Ljava/util/concurrent/ExecutorService;
            //   344: new 128	okhttp3/internal/e/g$e$3
            //   347: dup
            //   348: aload 8
            //   350: ldc 130
            //   352: iconst_1
            //   353: anewarray 132	java/lang/Object
            //   356: dup
            //   357: iconst_0
            //   358: aload 8
            //   360: getfield 45	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
            //   363: getfield 136	okhttp3/internal/e/g:ajQT	Ljava/lang/String;
            //   366: aastore
            //   367: invokespecial 139	okhttp3/internal/e/g$e$3:<init>	(Lokhttp3/internal/e/g$e;Ljava/lang/String;[Ljava/lang/Object;)V
            //   370: invokeinterface 144 2 0
            //   375: ldc 35
            //   377: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   380: return
            //   381: aconst_null
            //   382: astore 6
            //   384: goto -162 -> 222
            //   387: iload_1
            //   388: iconst_1
            //   389: iadd
            //   390: istore_1
            //   391: goto -287 -> 104
            //   394: goto -172 -> 222
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	397	0	this	2
            //   103	288	1	i	int
            //   62	199	2	j	int
            //   18	46	3	bool	boolean
            //   26	249	4	l	long
            //   1	263	6	arrayOfi	i[]
            //   289	11	6	localObject1	Object
            //   302	11	6	localObject2	Object
            //   328	11	6	localObject3	Object
            //   382	1	6	localObject4	Object
            //   12	347	8	locale	g.e
            //   46	246	9	localg	g
            //   315	1	9	localIOException	IOException
            //   23	100	10	localm1	m
            //   75	45	11	localm2	m
            // Exception table:
            //   from	to	target	type
            //   51	63	289	finally
            //   67	92	289	finally
            //   92	102	289	finally
            //   110	133	289	finally
            //   136	148	289	finally
            //   164	219	289	finally
            //   222	225	289	finally
            //   41	51	302	finally
            //   225	244	302	finally
            //   244	247	302	finally
            //   291	302	302	finally
            //   317	325	302	finally
            //   225	244	315	java/io/IOException
            //   272	282	328	finally
          }
        });
        AppMethodBeat.o(187117);
        return;
      }
      catch (RejectedExecutionException paramm)
      {
        AppMethodBeat.o(187117);
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt1, j.h paramh, int paramInt2)
    {
      AppMethodBeat.i(187062);
      if (g.aNe(paramInt1))
      {
        localObject = g.this;
        f localf = new f();
        paramh.Cc(paramInt2);
        paramh.a(localf, paramInt2);
        if (localf.size != paramInt2)
        {
          paramh = new IOException(localf.size + " != " + paramInt2);
          AppMethodBeat.o(187062);
          throw paramh;
        }
        ((g)localObject).a(new g.6((g)localObject, "OkHttp %s Push Data[%s]", new Object[] { ((g)localObject).ajQT, Integer.valueOf(paramInt1) }, paramInt1, localf, paramInt2, paramBoolean));
        AppMethodBeat.o(187062);
        return;
      }
      Object localObject = g.this.aNc(paramInt1);
      if (localObject == null)
      {
        g.this.a(paramInt1, b.ajPZ);
        g.this.BZ(paramInt2);
        paramh.Ci(paramInt2);
        AppMethodBeat.o(187062);
        return;
      }
      if ((!i.$assertionsDisabled) && (Thread.holdsLock(localObject)))
      {
        paramh = new AssertionError();
        AppMethodBeat.o(187062);
        throw paramh;
      }
      ((i)localObject).ajRL.a(paramh, paramInt2);
      if (paramBoolean) {
        ((i)localObject).kHW();
      }
      AppMethodBeat.o(187062);
    }
    
    public final void a(boolean paramBoolean, int paramInt, final List<c> paramList)
    {
      AppMethodBeat.i(187099);
      if (g.aNe(paramInt))
      {
        ??? = g.this;
        try
        {
          ???.a(new g.5(???, "OkHttp %s Push Headers[%s]", new Object[] { ???.ajQT, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
          AppMethodBeat.o(187099);
          return;
        }
        catch (RejectedExecutionException paramList)
        {
          AppMethodBeat.o(187099);
          return;
        }
      }
      i locali;
      synchronized (g.this)
      {
        locali = g.this.aNc(paramInt);
        if (locali == null)
        {
          if (g.f(g.this))
          {
            AppMethodBeat.o(187099);
            return;
          }
          if (paramInt <= g.this.ajQU)
          {
            AppMethodBeat.o(187099);
            return;
          }
          if (paramInt % 2 == g.this.ajQV % 2)
          {
            AppMethodBeat.o(187099);
            return;
          }
          paramList = okhttp3.internal.c.pk(paramList);
          paramList = new i(paramInt, g.this, false, paramBoolean, paramList);
          g.this.ajQU = paramInt;
          g.this.Jew.put(Integer.valueOf(paramInt), paramList);
          g.kHQ().execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[] { g.this.ajQT, Integer.valueOf(paramInt) })
          {
            public final void execute()
            {
              AppMethodBeat.i(186977);
              try
              {
                g.this.ajQS.a(paramList);
                AppMethodBeat.o(186977);
                return;
              }
              catch (IOException localIOException1)
              {
                okhttp3.internal.g.g.kIq().g(4, "Http2Connection.Listener failure for " + g.this.ajQT, localIOException1);
                try
                {
                  paramList.b(b.ajPZ);
                  AppMethodBeat.o(186977);
                  return;
                }
                catch (IOException localIOException2)
                {
                  AppMethodBeat.o(186977);
                }
              }
            }
          });
          AppMethodBeat.o(187099);
          return;
        }
        if ((!i.$assertionsDisabled) && (Thread.holdsLock(locali)))
        {
          paramList = new AssertionError();
          AppMethodBeat.o(187099);
          throw paramList;
        }
      }
      try
      {
        locali.ajRK = true;
        locali.ajRI.add(okhttp3.internal.c.pk(paramList));
        boolean bool = locali.isOpen();
        locali.notifyAll();
        if (!bool) {
          locali.ajQN.aNd(locali.id);
        }
        if (paramBoolean) {
          locali.kHW();
        }
        AppMethodBeat.o(187099);
        return;
      }
      finally
      {
        AppMethodBeat.o(187099);
      }
    }
    
    public final void bx(int paramInt, long paramLong)
    {
      AppMethodBeat.i(187158);
      if (paramInt == 0) {
        synchronized (g.this)
        {
          g localg = g.this;
          localg.ajRh += paramLong;
          g.this.notifyAll();
          AppMethodBeat.o(187158);
          return;
        }
      }
      ??? = g.this.aNc(paramInt);
      if (??? != null) {
        try
        {
          ((i)???).Cb(paramLong);
          return;
        }
        finally
        {
          AppMethodBeat.o(187158);
        }
      }
      AppMethodBeat.o(187158);
    }
    
    public final void c(int paramInt, b paramb)
    {
      AppMethodBeat.i(187109);
      if (g.aNe(paramInt))
      {
        localObject = g.this;
        ((g)localObject).a(new g.7((g)localObject, "OkHttp %s Push Reset[%s]", new Object[] { ((g)localObject).ajQT, Integer.valueOf(paramInt) }, paramInt, paramb));
        AppMethodBeat.o(187109);
        return;
      }
      Object localObject = g.this.aNd(paramInt);
      if (localObject != null) {
        ((i)localObject).e(paramb);
      }
      AppMethodBeat.o(187109);
    }
    
    /* Error */
    public final void execute()
    {
      // Byte code:
      //   0: ldc_w 332
      //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: getstatic 335	okhttp3/internal/e/b:ajQa	Lokhttp3/internal/e/b;
      //   9: astore_3
      //   10: getstatic 335	okhttp3/internal/e/b:ajQa	Lokhttp3/internal/e/b;
      //   13: astore 4
      //   15: aload_3
      //   16: astore_2
      //   17: aload_3
      //   18: astore_1
      //   19: aload_0
      //   20: getfield 43	okhttp3/internal/e/g$e:ajRz	Lokhttp3/internal/e/h;
      //   23: astore 5
      //   25: aload_3
      //   26: astore_2
      //   27: aload_3
      //   28: astore_1
      //   29: aload 5
      //   31: getfield 340	okhttp3/internal/e/h:ajQR	Z
      //   34: ifeq +84 -> 118
      //   37: aload_3
      //   38: astore_2
      //   39: aload_3
      //   40: astore_1
      //   41: aload 5
      //   43: iconst_1
      //   44: aload_0
      //   45: invokevirtual 343	okhttp3/internal/e/h:a	(ZLokhttp3/internal/e/h$b;)Z
      //   48: ifne +223 -> 271
      //   51: aload_3
      //   52: astore_2
      //   53: aload_3
      //   54: astore_1
      //   55: ldc_w 345
      //   58: iconst_0
      //   59: anewarray 27	java/lang/Object
      //   62: invokestatic 351	okhttp3/internal/e/e:u	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
      //   65: astore 5
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: astore_1
      //   71: ldc_w 332
      //   74: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_3
      //   78: astore_2
      //   79: aload_3
      //   80: astore_1
      //   81: aload 5
      //   83: athrow
      //   84: astore_1
      //   85: aload_2
      //   86: astore_1
      //   87: getstatic 74	okhttp3/internal/e/b:ajPZ	Lokhttp3/internal/e/b;
      //   90: astore_2
      //   91: getstatic 74	okhttp3/internal/e/b:ajPZ	Lokhttp3/internal/e/b;
      //   94: astore_1
      //   95: aload_0
      //   96: getfield 23	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
      //   99: aload_2
      //   100: aload_1
      //   101: invokevirtual 354	okhttp3/internal/e/g:a	(Lokhttp3/internal/e/b;Lokhttp3/internal/e/b;)V
      //   104: aload_0
      //   105: getfield 43	okhttp3/internal/e/g$e:ajRz	Lokhttp3/internal/e/h;
      //   108: invokestatic 358	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
      //   111: ldc_w 332
      //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   117: return
      //   118: aload_3
      //   119: astore_2
      //   120: aload_3
      //   121: astore_1
      //   122: aload 5
      //   124: getfield 362	okhttp3/internal/e/h:cnO	Lj/h;
      //   127: getstatic 366	okhttp3/internal/e/e:ajQG	Lj/i;
      //   130: invokevirtual 101	j/i:kIN	()I
      //   133: i2l
      //   134: invokeinterface 370 3 0
      //   139: astore 5
      //   141: aload_3
      //   142: astore_2
      //   143: aload_3
      //   144: astore_1
      //   145: getstatic 374	okhttp3/internal/e/h:logger	Ljava/util/logging/Logger;
      //   148: getstatic 380	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   151: invokevirtual 386	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
      //   154: ifeq +31 -> 185
      //   157: aload_3
      //   158: astore_2
      //   159: aload_3
      //   160: astore_1
      //   161: getstatic 374	okhttp3/internal/e/h:logger	Ljava/util/logging/Logger;
      //   164: ldc_w 388
      //   167: iconst_1
      //   168: anewarray 27	java/lang/Object
      //   171: dup
      //   172: iconst_0
      //   173: aload 5
      //   175: invokevirtual 391	j/i:kIL	()Ljava/lang/String;
      //   178: aastore
      //   179: invokestatic 395	okhttp3/internal/c:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   182: invokevirtual 398	java/util/logging/Logger:fine	(Ljava/lang/String;)V
      //   185: aload_3
      //   186: astore_2
      //   187: aload_3
      //   188: astore_1
      //   189: getstatic 366	okhttp3/internal/e/e:ajQG	Lj/i;
      //   192: aload 5
      //   194: invokevirtual 401	j/i:equals	(Ljava/lang/Object;)Z
      //   197: ifne +74 -> 271
      //   200: aload_3
      //   201: astore_2
      //   202: aload_3
      //   203: astore_1
      //   204: ldc_w 403
      //   207: iconst_1
      //   208: anewarray 27	java/lang/Object
      //   211: dup
      //   212: iconst_0
      //   213: aload 5
      //   215: invokevirtual 406	j/i:kIJ	()Ljava/lang/String;
      //   218: aastore
      //   219: invokestatic 351	okhttp3/internal/e/e:u	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
      //   222: astore 5
      //   224: aload_3
      //   225: astore_2
      //   226: aload_3
      //   227: astore_1
      //   228: ldc_w 332
      //   231: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   234: aload_3
      //   235: astore_2
      //   236: aload_3
      //   237: astore_1
      //   238: aload 5
      //   240: athrow
      //   241: astore_3
      //   242: aload_1
      //   243: astore_2
      //   244: aload_3
      //   245: astore_1
      //   246: aload_0
      //   247: getfield 23	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
      //   250: aload_2
      //   251: aload 4
      //   253: invokevirtual 354	okhttp3/internal/e/g:a	(Lokhttp3/internal/e/b;Lokhttp3/internal/e/b;)V
      //   256: aload_0
      //   257: getfield 43	okhttp3/internal/e/g$e:ajRz	Lokhttp3/internal/e/h;
      //   260: invokestatic 358	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
      //   263: ldc_w 332
      //   266: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   269: aload_1
      //   270: athrow
      //   271: aload_3
      //   272: astore_2
      //   273: aload_3
      //   274: astore_1
      //   275: aload_0
      //   276: getfield 43	okhttp3/internal/e/g$e:ajRz	Lokhttp3/internal/e/h;
      //   279: iconst_0
      //   280: aload_0
      //   281: invokevirtual 343	okhttp3/internal/e/h:a	(ZLokhttp3/internal/e/h$b;)Z
      //   284: ifne -13 -> 271
      //   287: aload_3
      //   288: astore_2
      //   289: aload_3
      //   290: astore_1
      //   291: getstatic 409	okhttp3/internal/e/b:ajPY	Lokhttp3/internal/e/b;
      //   294: astore_3
      //   295: aload_3
      //   296: astore_2
      //   297: aload_3
      //   298: astore_1
      //   299: getstatic 412	okhttp3/internal/e/b:ajQd	Lokhttp3/internal/e/b;
      //   302: astore 5
      //   304: aload_0
      //   305: getfield 23	okhttp3/internal/e/g$e:ajRp	Lokhttp3/internal/e/g;
      //   308: aload_3
      //   309: aload 5
      //   311: invokevirtual 354	okhttp3/internal/e/g:a	(Lokhttp3/internal/e/b;Lokhttp3/internal/e/b;)V
      //   314: aload_0
      //   315: getfield 43	okhttp3/internal/e/g$e:ajRz	Lokhttp3/internal/e/h;
      //   318: invokestatic 358	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
      //   321: ldc_w 332
      //   324: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   327: return
      //   328: astore_2
      //   329: goto -73 -> 256
      //   332: astore_1
      //   333: goto -87 -> 246
      //   336: astore_1
      //   337: goto -233 -> 104
      //   340: astore_1
      //   341: goto -27 -> 314
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	344	0	this	e
      //   18	63	1	localb1	b
      //   84	1	1	localIOException1	IOException
      //   86	213	1	localObject1	Object
      //   332	1	1	localObject2	Object
      //   336	1	1	localIOException2	IOException
      //   340	1	1	localIOException3	IOException
      //   16	281	2	localObject3	Object
      //   328	1	2	localIOException4	IOException
      //   9	228	3	localb2	b
      //   241	49	3	localObject4	Object
      //   294	15	3	localb3	b
      //   13	239	4	localb4	b
      //   23	287	5	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   19	25	84	java/io/IOException
      //   29	37	84	java/io/IOException
      //   41	51	84	java/io/IOException
      //   55	67	84	java/io/IOException
      //   71	77	84	java/io/IOException
      //   81	84	84	java/io/IOException
      //   122	141	84	java/io/IOException
      //   145	157	84	java/io/IOException
      //   161	185	84	java/io/IOException
      //   189	200	84	java/io/IOException
      //   204	224	84	java/io/IOException
      //   228	234	84	java/io/IOException
      //   238	241	84	java/io/IOException
      //   275	287	84	java/io/IOException
      //   291	295	84	java/io/IOException
      //   299	304	84	java/io/IOException
      //   19	25	241	finally
      //   29	37	241	finally
      //   41	51	241	finally
      //   55	67	241	finally
      //   71	77	241	finally
      //   81	84	241	finally
      //   87	91	241	finally
      //   122	141	241	finally
      //   145	157	241	finally
      //   161	185	241	finally
      //   189	200	241	finally
      //   204	224	241	finally
      //   228	234	241	finally
      //   238	241	241	finally
      //   275	287	241	finally
      //   291	295	241	finally
      //   299	304	241	finally
      //   246	256	328	java/io/IOException
      //   91	95	332	finally
      //   95	104	336	java/io/IOException
      //   304	314	340	java/io/IOException
    }
    
    public final void x(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187134);
      if (paramBoolean)
      {
        g localg = g.this;
        if (paramInt1 == 1) {}
        for (;;)
        {
          try
          {
            g.h(g.this);
            return;
          }
          finally
          {
            AppMethodBeat.o(187134);
          }
          if (paramInt1 == 2)
          {
            g.i(g.this);
          }
          else if (paramInt1 == 3)
          {
            g.j(g.this);
            g.this.notifyAll();
          }
        }
      }
      try
      {
        g.g(g.this).execute(new g.d(g.this, paramInt1, paramInt2));
        AppMethodBeat.o(187134);
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        AppMethodBeat.o(187134);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.g
 * JD-Core Version:    0.7.0.1
 */