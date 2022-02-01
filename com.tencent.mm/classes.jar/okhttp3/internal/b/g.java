package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.i;
import okhttp3.internal.e.b;
import okhttp3.internal.e.n;
import okhttp3.o;
import okhttp3.r;

public final class g
{
  public final o ajNE;
  public final okhttp3.a ajNZ;
  public final i ajNn;
  private f.a ajPB;
  private final Object ajPC;
  private final f ajPD;
  private int ajPE;
  public c ajPF;
  private boolean ajPG;
  public okhttp3.internal.c.c ajPH;
  public ab ajPk;
  public final e cqs;
  public boolean oLU;
  private boolean released;
  
  static
  {
    AppMethodBeat.i(186897);
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(186897);
      return;
    }
  }
  
  public g(i parami, okhttp3.a parama, e parame, o paramo, Object paramObject)
  {
    AppMethodBeat.i(186844);
    this.ajNn = parami;
    this.ajNZ = parama;
    this.cqs = parame;
    this.ajNE = paramo;
    this.ajPD = new f(parama, kHz(), parame, paramo);
    this.ajPC = paramObject;
    AppMethodBeat.o(186844);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(186895);
    int j = paramc.ajPq.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramc.ajPq.get(i)).get() == this)
      {
        paramc.ajPq.remove(i);
        AppMethodBeat.o(186895);
        return;
      }
      i += 1;
    }
    paramc = new IllegalStateException();
    AppMethodBeat.o(186895);
    throw paramc;
  }
  
  private c c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186857);
    for (;;)
    {
      c localc1 = d(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.ajNn)
      {
        if ((localc1.successCount == 0) && (!localc1.kHv()))
        {
          AppMethodBeat.o(186857);
          return localc1;
        }
        if (!localc1.PS(paramBoolean2)) {
          kHB();
        }
      }
    }
    return localc2;
  }
  
  private c d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(186887);
    int j = 0;
    ??? = null;
    ArrayList localArrayList = null;
    synchronized (this.ajNn)
    {
      if (this.released)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("released");
        AppMethodBeat.o(186887);
        throw localIllegalStateException;
      }
    }
    if (this.ajPH != null)
    {
      localObject2 = new IllegalStateException("codec != null");
      AppMethodBeat.o(186887);
      throw ((Throwable)localObject2);
    }
    if (this.oLU)
    {
      localObject2 = new IOException("Canceled");
      AppMethodBeat.o(186887);
      throw ((Throwable)localObject2);
    }
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.ajNn)))
    {
      localObject2 = new AssertionError();
      AppMethodBeat.o(186887);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = this.ajPF;
    Object localObject6;
    int i;
    if ((localObject2 != null) && (((c)localObject2).ajPo))
    {
      ??? = u(false, false, true);
      if (this.ajPF != null) {
        ??? = this.ajPF;
      }
      localObject6 = ???;
      localObject2 = localArrayList;
      i = j;
      if (??? == null)
      {
        okhttp3.internal.a.ajOh.a(this.ajNn, this.ajNZ, this, null);
        if (this.ajPF == null) {
          break label280;
        }
        i = 1;
        localObject6 = this.ajPF;
        localObject2 = localArrayList;
      }
    }
    for (;;)
    {
      okhttp3.internal.c.closeQuietly((Socket)???);
      if (localObject6 == null) {
        break label297;
      }
      this.ajPk = this.ajPF.ajPk;
      AppMethodBeat.o(186887);
      return localObject6;
      ??? = null;
      break;
      label280:
      localObject2 = this.ajPk;
      localObject6 = ???;
      i = j;
    }
    label297:
    int k = 0;
    j = k;
    if (localObject2 == null) {
      if (this.ajPB != null)
      {
        j = k;
        if (this.ajPB.hasNext()) {}
      }
      else
      {
        j = 1;
        this.ajPB = this.ajPD.kHw();
      }
    }
    synchronized (this.ajNn)
    {
      if (this.oLU)
      {
        localObject2 = new IOException("Canceled");
        AppMethodBeat.o(186887);
        throw ((Throwable)localObject2);
      }
    }
    if (j != 0)
    {
      localArrayList = new ArrayList(this.ajPB.ajPz);
      k = localArrayList.size();
      j = 0;
    }
    for (;;)
    {
      if (j < k)
      {
        ??? = (ab)localArrayList.get(j);
        okhttp3.internal.a.ajOh.a(this.ajNn, this.ajNZ, this, (ab)???);
        if (this.ajPF != null)
        {
          i = 1;
          localObject6 = this.ajPF;
          this.ajPk = ((ab)???);
        }
      }
      else
      {
        for (;;)
        {
          Object localObject4;
          if (i == 0)
          {
            if (localObject3 != null) {
              break label738;
            }
            localObject4 = this.ajPB;
            if (!((f.a)localObject4).hasNext())
            {
              localObject4 = new NoSuchElementException();
              AppMethodBeat.o(186887);
              throw ((Throwable)localObject4);
            }
            localObject6 = ((f.a)localObject4).ajPz;
            j = ((f.a)localObject4).ajPA;
            ((f.a)localObject4).ajPA = (j + 1);
            localObject4 = (ab)((List)localObject6).get(j);
          }
          label738:
          for (;;)
          {
            this.ajPk = ((ab)localObject4);
            this.ajPE = 0;
            localObject6 = new c(this.ajNn, (ab)localObject4);
            a((c)localObject6, false);
            if (i != 0)
            {
              AppMethodBeat.o(186887);
              return localObject6;
            }
            ((c)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.cqs, this.ajNE);
            kHz().b(((c)localObject6).ajPk);
            ??? = null;
            synchronized (this.ajNn)
            {
              this.ajPG = true;
              okhttp3.internal.a.ajOh.b(this.ajNn, (c)localObject6);
              localObject4 = localObject6;
              if (((c)localObject6).kHv())
              {
                ??? = okhttp3.internal.a.ajOh.a(this.ajNn, this.ajNZ, this);
                localObject4 = this.ajPF;
              }
              okhttp3.internal.c.closeQuietly((Socket)???);
              AppMethodBeat.o(186887);
              return localObject4;
            }
          }
        }
      }
      j += 1;
    }
  }
  
  private d kHz()
  {
    AppMethodBeat.i(186890);
    d locald = okhttp3.internal.a.ajOh.a(this.ajNn);
    AppMethodBeat.o(186890);
    return locald;
  }
  
  /* Error */
  public final okhttp3.internal.c.c a(okhttp3.u paramu, okhttp3.s.a arg2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 242
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokeinterface 247 1 0
    //   11: istore 4
    //   13: aload_2
    //   14: invokeinterface 250 1 0
    //   19: istore 5
    //   21: aload_2
    //   22: invokeinterface 253 1 0
    //   27: istore 6
    //   29: aload_1
    //   30: getfield 258	okhttp3/u:ajNt	I
    //   33: istore 7
    //   35: aload_1
    //   36: getfield 261	okhttp3/u:ajNq	Z
    //   39: istore 8
    //   41: aload_0
    //   42: iload 4
    //   44: iload 5
    //   46: iload 6
    //   48: iload 7
    //   50: iload 8
    //   52: iload_3
    //   53: invokespecial 263	okhttp3/internal/b/g:c	(IIIIZZ)Lokhttp3/internal/b/c;
    //   56: astore 9
    //   58: aload 9
    //   60: getfield 267	okhttp3/internal/b/c:ajPm	Lokhttp3/internal/e/g;
    //   63: ifnull +40 -> 103
    //   66: new 269	okhttp3/internal/e/f
    //   69: dup
    //   70: aload_1
    //   71: aload_2
    //   72: aload_0
    //   73: aload 9
    //   75: getfield 267	okhttp3/internal/b/c:ajPm	Lokhttp3/internal/e/g;
    //   78: invokespecial 272	okhttp3/internal/e/f:<init>	(Lokhttp3/u;Lokhttp3/s$a;Lokhttp3/internal/b/g;Lokhttp3/internal/e/g;)V
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 62	okhttp3/internal/b/g:ajNn	Lokhttp3/i;
    //   86: astore_2
    //   87: aload_2
    //   88: monitorenter
    //   89: aload_0
    //   90: aload_1
    //   91: putfield 139	okhttp3/internal/b/g:ajPH	Lokhttp3/internal/c/c;
    //   94: aload_2
    //   95: monitorexit
    //   96: ldc 242
    //   98: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: areturn
    //   103: aload 9
    //   105: getfield 276	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   108: aload_2
    //   109: invokeinterface 250 1 0
    //   114: invokevirtual 281	java/net/Socket:setSoTimeout	(I)V
    //   117: aload 9
    //   119: getfield 285	okhttp3/internal/b/c:cnO	Lj/h;
    //   122: invokeinterface 291 1 0
    //   127: aload_2
    //   128: invokeinterface 250 1 0
    //   133: i2l
    //   134: getstatic 297	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   137: invokevirtual 302	j/ab:b	(JLjava/util/concurrent/TimeUnit;)Lj/ab;
    //   140: pop
    //   141: aload 9
    //   143: getfield 306	okhttp3/internal/b/c:ajPn	Lj/g;
    //   146: invokeinterface 309 1 0
    //   151: aload_2
    //   152: invokeinterface 253 1 0
    //   157: i2l
    //   158: getstatic 297	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   161: invokevirtual 302	j/ab:b	(JLjava/util/concurrent/TimeUnit;)Lj/ab;
    //   164: pop
    //   165: new 311	okhttp3/internal/d/a
    //   168: dup
    //   169: aload_1
    //   170: aload_0
    //   171: aload 9
    //   173: getfield 285	okhttp3/internal/b/c:cnO	Lj/h;
    //   176: aload 9
    //   178: getfield 306	okhttp3/internal/b/c:ajPn	Lj/g;
    //   181: invokespecial 314	okhttp3/internal/d/a:<init>	(Lokhttp3/u;Lokhttp3/internal/b/g;Lj/h;Lj/g;)V
    //   184: astore_1
    //   185: goto -103 -> 82
    //   188: astore_1
    //   189: new 316	okhttp3/internal/b/e
    //   192: dup
    //   193: aload_1
    //   194: invokespecial 319	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   197: astore_1
    //   198: ldc 242
    //   200: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_2
    //   207: monitorexit
    //   208: ldc 242
    //   210: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	g
    //   0	215	1	paramu	okhttp3.u
    //   0	215	3	paramBoolean	boolean
    //   11	32	4	i	int
    //   19	26	5	j	int
    //   27	20	6	k	int
    //   33	16	7	m	int
    //   39	12	8	bool	boolean
    //   56	121	9	localc	c
    // Exception table:
    //   from	to	target	type
    //   41	82	188	java/io/IOException
    //   82	89	188	java/io/IOException
    //   103	185	188	java/io/IOException
    //   206	215	188	java/io/IOException
    //   89	96	205	finally
  }
  
  public final void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(187001);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.ajNn)))
    {
      paramc = new AssertionError();
      AppMethodBeat.o(187001);
      throw paramc;
    }
    if (this.ajPF != null)
    {
      paramc = new IllegalStateException();
      AppMethodBeat.o(187001);
      throw paramc;
    }
    this.ajPF = paramc;
    this.ajPG = paramBoolean;
    paramc.ajPq.add(new a(this, this.ajPC));
    AppMethodBeat.o(187001);
  }
  
  public final void a(boolean paramBoolean, okhttp3.internal.c.c paramc, IOException paramIOException)
  {
    AppMethodBeat.i(186922);
    i locali = this.ajNn;
    if (paramc != null) {}
    try
    {
      if (paramc != this.ajPH)
      {
        paramc = new IllegalStateException("expected " + this.ajPH + " but was " + paramc);
        AppMethodBeat.o(186922);
        throw paramc;
      }
    }
    finally
    {
      AppMethodBeat.o(186922);
    }
    if (!paramBoolean)
    {
      paramc = this.ajPF;
      paramc.successCount += 1;
    }
    paramc = u(paramBoolean, false, true);
    paramBoolean = this.released;
    okhttp3.internal.c.closeQuietly(paramc);
    if (paramIOException != null)
    {
      okhttp3.internal.a.ajOh.b(this.cqs, paramIOException);
      AppMethodBeat.o(186922);
      return;
    }
    if (paramBoolean) {
      okhttp3.internal.a.ajOh.b(this.cqs, null);
    }
    AppMethodBeat.o(186922);
  }
  
  public final void e(IOException paramIOException)
  {
    boolean bool2 = false;
    AppMethodBeat.i(186991);
    for (;;)
    {
      synchronized (this.ajNn)
      {
        if ((paramIOException instanceof n))
        {
          paramIOException = ((n)paramIOException).ajRP;
          if (paramIOException == b.ajQc)
          {
            this.ajPE += 1;
            bool1 = bool2;
            if (this.ajPE > 1)
            {
              this.ajPk = null;
            }
            else
            {
              paramIOException = u(bool1, false, true);
              okhttp3.internal.c.closeQuietly(paramIOException);
              AppMethodBeat.o(186991);
            }
          }
          else
          {
            bool1 = bool2;
            if (paramIOException == b.ajQd) {
              continue;
            }
            this.ajPk = null;
          }
        }
      }
      boolean bool1 = bool2;
      if (this.ajPF != null) {
        if (this.ajPF.kHv())
        {
          bool1 = bool2;
          if (!(paramIOException instanceof okhttp3.internal.e.a)) {}
        }
        else if (this.ajPF.successCount == 0)
        {
          if ((this.ajPk != null) && (paramIOException != null))
          {
            f localf = this.ajPD;
            ab localab = this.ajPk;
            if ((localab.uuH.type() != Proxy.Type.DIRECT) && (localf.ajNZ.ajIT != null)) {
              localf.ajNZ.ajIT.connectFailed(localf.ajNZ.ajIN.kGN(), localab.uuH.address(), paramIOException);
            }
            localf.ajMj.a(localab);
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public final c kHA()
  {
    try
    {
      c localc = this.ajPF;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void kHB()
  {
    AppMethodBeat.i(186952);
    synchronized (this.ajNn)
    {
      Socket localSocket = u(true, false, false);
      okhttp3.internal.c.closeQuietly(localSocket);
      AppMethodBeat.o(186952);
      return;
    }
  }
  
  public final boolean kHC()
  {
    AppMethodBeat.i(187010);
    if ((this.ajPk != null) || ((this.ajPB != null) && (this.ajPB.hasNext())) || (this.ajPD.hasNext()))
    {
      AppMethodBeat.o(187010);
      return true;
    }
    AppMethodBeat.o(187010);
    return false;
  }
  
  public final okhttp3.internal.c.c kHy()
  {
    synchronized (this.ajNn)
    {
      okhttp3.internal.c.c localc = this.ajPH;
      return localc;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(186945);
    synchronized (this.ajNn)
    {
      c localc = this.ajPF;
      Socket localSocket = u(false, true, false);
      if (this.ajPF != null) {
        localc = null;
      }
      okhttp3.internal.c.closeQuietly(localSocket);
      if (localc != null) {
        okhttp3.internal.a.ajOh.b(this.cqs, null);
      }
      AppMethodBeat.o(186945);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187020);
    Object localObject = kHA();
    if (localObject != null)
    {
      localObject = ((c)localObject).toString();
      AppMethodBeat.o(187020);
      return localObject;
    }
    localObject = this.ajNZ.toString();
    AppMethodBeat.o(187020);
    return localObject;
  }
  
  public final Socket u(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(186967);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.ajNn)))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(186967);
      throw ((Throwable)localObject1);
    }
    if (paramBoolean3) {
      this.ajPH = null;
    }
    if (paramBoolean2) {
      this.released = true;
    }
    Object localObject1 = localObject2;
    if (this.ajPF != null)
    {
      if (paramBoolean1) {
        this.ajPF.ajPo = true;
      }
      localObject1 = localObject2;
      if (this.ajPH == null) {
        if (!this.released)
        {
          localObject1 = localObject2;
          if (!this.ajPF.ajPo) {}
        }
        else
        {
          a(this.ajPF);
          if (!this.ajPF.ajPq.isEmpty()) {
            break label189;
          }
          this.ajPF.ajPr = System.nanoTime();
          if (!okhttp3.internal.a.ajOh.a(this.ajNn, this.ajPF)) {
            break label189;
          }
        }
      }
    }
    label189:
    for (localObject1 = this.ajPF.cBb;; localObject1 = null)
    {
      this.ajPF = null;
      AppMethodBeat.o(186967);
      return localObject1;
    }
  }
  
  public static final class a
    extends WeakReference<g>
  {
    public final Object ajPC;
    
    a(g paramg, Object paramObject)
    {
      super();
      this.ajPC = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.g
 * JD-Core Version:    0.7.0.1
 */