package com.tencent.mm.vending.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.f.a;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.j.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var>
  implements c<_Var>
{
  com.tencent.mm.vending.h.f HPJ;
  public volatile boolean HPW;
  volatile d HPX;
  boolean HPY;
  private Queue<a> HPZ;
  private volatile com.tencent.mm.vending.h.d HQa;
  private volatile com.tencent.mm.vending.h.d HQb;
  volatile Object HQc;
  volatile boolean HQd;
  volatile Object HQe;
  a HQf;
  a HQg;
  private long HQh;
  private boolean HQi;
  private b HQj;
  private com.tencent.mm.vending.h.d HQk;
  private f.a HQl;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> HQm;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> HQn;
  private boolean HQo;
  boolean HQp;
  private boolean HQq;
  private Object HQr;
  Object HQs;
  private int mRetryCount;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.HPW = false;
    this.HPX = d.HQB;
    this.HPY = false;
    this.HPZ = new LinkedList();
    this.mRetryCount = 0;
    this.HQh = -1L;
    this.HQi = false;
    this.HQj = new b();
    this.HQl = new f.a()
    {
      public final void ed(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.fhp().HQJ.get()).pop();
        synchronized (e.this)
        {
          e.this.HQf = e.this.HQg;
          e.this.HQg = null;
          if (!e.this.HPY)
          {
            e.this.HQc = paramAnonymousObject;
            if (e.this.HPX == e.d.HQF)
            {
              com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
              AppMethodBeat.o(74856);
            }
          }
          else
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
          }
        }
        if (e.this.HPX == e.d.HQE)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
          AppMethodBeat.o(74856);
          return;
        }
        e.this.HPX = e.d.HQC;
        e.this.ec(e.this.eb(paramAnonymousObject));
        AppMethodBeat.o(74856);
      }
      
      public final void fho()
      {
        AppMethodBeat.i(74855);
        f localf = f.fhp();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.HQJ.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.HQJ.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.this.xd(true);
        AppMethodBeat.o(74857);
      }
    };
    this.HQo = false;
    this.HQp = false;
    this.HQq = false;
    this.HQb = g.fhs();
    this.HQa = this.HQb;
    this.HPJ = new com.tencent.mm.vending.h.f(this.HQb, this.HQl);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> F(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.HPX != d.HQB)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.HPX = d.HQC;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      this.HQc = paramVarArgs;
      ec(this.HQc);
      AppMethodBeat.o(177484);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.G(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(74837);
    fhn();
    this.HPZ.add(new a(parama, this.HQa, this.HQh, paramBoolean));
    this.HQh = -1L;
    if (this.HPX == d.HQB)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.HPX != d.HQC)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    ec(this.HQc);
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.HPW = true;
    if (this.HQm == null) {
      this.HQm = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.HQp)
    {
      a(parama, this.HQs);
      AppMethodBeat.o(74842);
      return;
    }
    this.HQm.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.HPW = true;
    ec(this.HQc);
    if (this.HQn == null) {
      this.HQn = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.HQo)
    {
      b(paramb, this.HQr);
      AppMethodBeat.o(74843);
      return;
    }
    this.HQn.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(177486);
    final RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
    {
      private Void aOw()
      {
        AppMethodBeat.i(177476);
        try
        {
          ((d.b)paramPair.first).br(paramObject);
          Void localVoid = HPQ;
          AppMethodBeat.o(177476);
          return localVoid;
        }
        catch (ClassCastException localClassCastException)
        {
          if (localRuntimeException.getCause() == null) {
            localRuntimeException.initCause(localClassCastException);
          }
          RuntimeException localRuntimeException = localRuntimeException;
          AppMethodBeat.o(177476);
          throw localRuntimeException;
        }
      }
    }, null, this.HQi);
    AppMethodBeat.o(177486);
  }
  
  private void fhn()
  {
    AppMethodBeat.i(177485);
    if (this.HPW)
    {
      c localc = new c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  public c<_Var> E(Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(74831);
      paramVarArgs = F(paramVarArgs);
      AppMethodBeat.o(74831);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      AppMethodBeat.i(74830);
      F(new Object[0]);
      a(new com.tencent.mm.vending.c.a()
      {
        public final _Var call(_Var paramAnonymous_Var)
        {
          AppMethodBeat.i(74865);
          paramAnonymous_Var = parama.call();
          AppMethodBeat.o(74865);
          return paramAnonymous_Var;
        }
      }, true);
      AppMethodBeat.o(74830);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final d<_Var> a(d.a parama)
  {
    try
    {
      AppMethodBeat.i(74844);
      a(parama, this.HQb);
      AppMethodBeat.o(74844);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final d<_Var> a(d.b<_Var> paramb)
  {
    try
    {
      AppMethodBeat.i(74846);
      a(paramb, this.HQb);
      AppMethodBeat.o(74846);
      return this;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final d<_Var> a(com.tencent.mm.vending.h.d paramd, d.a parama)
  {
    try
    {
      AppMethodBeat.i(74845);
      a(parama, paramd);
      AppMethodBeat.o(74845);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final d<_Var> a(com.tencent.mm.vending.h.d paramd, d.b<_Var> paramb)
  {
    try
    {
      AppMethodBeat.i(74847);
      a(paramb, paramd);
      AppMethodBeat.o(74847);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  final void a(final Pair<d.a, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(74840);
    com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
    paramPair = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74854);
        ((d.a)paramPair.first).ce(paramObject);
        AppMethodBeat.o(74854);
      }
    };
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.HQb });
      AppMethodBeat.o(74840);
      return;
    }
    locald.v(paramPair);
    AppMethodBeat.o(74840);
  }
  
  public c<_Var> aMx(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.HQa = g.aMz(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.HQa);
    AppMethodBeat.o(74827);
    return this;
  }
  
  public c<_Var> b(com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(74829);
    Assert.assertNotNull("keeper should not be null!", paramb);
    paramb.keep(this);
    AppMethodBeat.o(74829);
    return this;
  }
  
  public c<_Var> b(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74828);
    if (paramd == null)
    {
      Assert.assertNotNull("scheduler should not be null!", paramd);
      AppMethodBeat.o(74828);
      return this;
    }
    this.HQa = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.HQi);
      AppMethodBeat.o(74838);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74835);
    parama = aMx("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    xd(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = aMx("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  final Object eb(Object paramObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177488);
        if (this.HPY)
        {
          this.mRetryCount += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.HQf.gfb.toString(), Integer.valueOf(this.mRetryCount) });
          ((LinkedList)this.HPZ).add(0, this.HQf);
          this.HPY = false;
          paramObject = this.HQc;
          AppMethodBeat.o(177488);
          return paramObject;
        }
        if (this.HQd)
        {
          this.HQc = this.HQe;
          this.HQe = null;
          this.HQd = false;
          this.mRetryCount = 0;
        }
        else
        {
          this.HQc = paramObject;
        }
      }
      finally {}
    }
  }
  
  final void ec(final Object paramObject)
  {
    AppMethodBeat.i(177489);
    if (this.HPX != d.HQC)
    {
      AppMethodBeat.o(177489);
      return;
    }
    this.HPX = d.HQD;
    a locala = (a)this.HPZ.peek();
    if (locala == null)
    {
      if (this.HPW)
      {
        this.HPX = d.HQG;
        this.HQo = true;
        this.HQr = paramObject;
        if (this.HQn != null)
        {
          paramObject = this.HQn.iterator();
          while (paramObject.hasNext()) {
            b((Pair)paramObject.next(), this.HQr);
          }
          AppMethodBeat.o(177489);
        }
      }
      else
      {
        this.HPX = d.HQC;
      }
      AppMethodBeat.o(177489);
      return;
    }
    final com.tencent.mm.vending.c.a locala1 = locala.gfb;
    com.tencent.mm.vending.h.d locald = locala.cLA;
    long l = locala.mInterval;
    final boolean bool = locala.HQA;
    if (this.HPX == d.HQE)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(177489);
      return;
    }
    this.HQg = ((a)this.HPZ.poll());
    this.HPJ.c(locald);
    if (l < 0L)
    {
      this.HPJ.a(locala1, paramObject, bool);
      AppMethodBeat.o(177489);
      return;
    }
    this.HQk = g.fhs();
    this.HQk.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74862);
        e.this.HPJ.a(locala1, paramObject, bool);
        AppMethodBeat.o(74862);
      }
    }, l);
    AppMethodBeat.o(177489);
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = aMx("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  public final b fhl()
  {
    return this.HQj;
  }
  
  public final d<_Var> fhm()
  {
    try
    {
      this.HPW = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> wY(long paramLong)
  {
    try
    {
      this.HQh = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> xc(boolean paramBoolean)
  {
    try
    {
      this.HQi = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void xd(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 438
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 87	com/tencent/mm/vending/g/e:HPX	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 441	com/tencent/mm/vending/g/e$d:HQF	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 87	com/tencent/mm/vending/g/e:HPX	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 383	com/tencent/mm/vending/g/e$d:HQG	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 438
    //   31: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +43 -> 81
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/vending/g/e:HPZ	Ljava/util/Queue;
    //   45: invokeinterface 445 1 0
    //   50: ifle +31 -> 81
    //   53: ldc_w 277
    //   56: ldc_w 447
    //   59: iconst_1
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/vending/g/e:HPZ	Ljava/util/Queue;
    //   69: invokeinterface 445 1 0
    //   74: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 450	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getstatic 441	com/tencent/mm/vending/g/e$d:HQF	Lcom/tencent/mm/vending/g/e$d;
    //   85: putfield 87	com/tencent/mm/vending/g/e:HPX	Lcom/tencent/mm/vending/g/e$d;
    //   88: aload_0
    //   89: getfield 94	com/tencent/mm/vending/g/e:HPZ	Ljava/util/Queue;
    //   92: invokeinterface 453 1 0
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 145	com/tencent/mm/vending/g/e:HQc	Ljava/lang/Object;
    //   102: aload_0
    //   103: getfield 418	com/tencent/mm/vending/g/e:HQk	Lcom/tencent/mm/vending/h/d;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 418	com/tencent/mm/vending/g/e:HQk	Lcom/tencent/mm/vending/h/d;
    //   113: invokevirtual 456	com/tencent/mm/vending/h/d:cancel	()V
    //   116: ldc_w 438
    //   119: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: goto -88 -> 34
    //   125: astore_2
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	e
    //   0	130	1	paramBoolean	boolean
    //   125	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	125	finally
    //   28	34	125	finally
    //   41	81	125	finally
    //   81	116	125	finally
    //   116	122	125	finally
  }
  
  static final class a
  {
    public boolean HQA;
    public com.tencent.mm.vending.h.d cLA;
    public com.tencent.mm.vending.c.a gfb;
    public long mInterval;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.gfb = parama;
      this.cLA = paramd;
      this.mInterval = paramLong;
      this.HQA = paramBoolean;
    }
  }
  
  final class b
    implements b
  {
    b() {}
    
    public final void D(Object... paramVarArgs)
    {
      AppMethodBeat.i(177479);
      synchronized (e.this)
      {
        if (e.this.HPX != e.d.HQE)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.HPX });
          AppMethodBeat.o(177479);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.HQe = paramVarArgs;
          e.this.HQd = true;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
          resume();
          AppMethodBeat.o(177479);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.G(paramVarArgs);
      }
    }
    
    public final void ea(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.this.HPX == e.d.HQF)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.a(e.this)) && (e.this.HPX != e.d.HQE))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.xd(false);
        e.this.HQp = true;
        e.this.HQs = paramObject;
        if (e.this.HQm != null)
        {
          Iterator localIterator = e.this.HQm.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(177477);
    }
    
    public final void fhk()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.HPX == e.d.HQF) || (e.this.HPX == e.d.HQB))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.HPX });
              AppMethodBeat.o(177478);
              return;
            }
            if (!e.a(e.this)) {
              com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", new Object[] { e.this });
            }
          }
        }
        if (!e.b(e.this)) {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", new Object[] { e.this });
        } else {
          e.this.HPX = e.d.HQE;
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.this.HPX != e.d.HQE)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.a(e.this))
        {
          e.this.HPX = e.d.HQC;
          if (!e.b(e.this)) {
            e.this.ec(e.this.eb(e.this.HQc));
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.this.HPX = e.d.HQD;
      }
    }
  }
  
  public static final class c
    extends Error
  {
    public c(String paramString, Object... paramVarArgs)
    {
      super();
      AppMethodBeat.i(74804);
      AppMethodBeat.o(74804);
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(177483);
      HQB = new d("Idle", 0);
      HQC = new d("Resolved", 1);
      HQD = new d("Invoking", 2);
      HQE = new d("Pausing", 3);
      HQF = new d("Interrupted", 4);
      HQG = new d("AllDone", 5);
      HQH = new d[] { HQB, HQC, HQD, HQE, HQF, HQG };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */