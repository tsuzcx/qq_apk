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
  a JqA;
  a JqB;
  private long JqC;
  private boolean JqD;
  private b JqE;
  private com.tencent.mm.vending.h.d JqF;
  private f.a JqG;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> JqH;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> JqI;
  private boolean JqJ;
  boolean JqK;
  private boolean JqL;
  private Object JqM;
  Object JqN;
  com.tencent.mm.vending.h.f Jqe;
  public volatile boolean Jqr;
  volatile d Jqs;
  boolean Jqt;
  private Queue<a> Jqu;
  private volatile com.tencent.mm.vending.h.d Jqv;
  private volatile com.tencent.mm.vending.h.d Jqw;
  volatile Object Jqx;
  volatile boolean Jqy;
  volatile Object Jqz;
  private int mRetryCount;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.Jqr = false;
    this.Jqs = d.JqW;
    this.Jqt = false;
    this.Jqu = new LinkedList();
    this.mRetryCount = 0;
    this.JqC = -1L;
    this.JqD = false;
    this.JqE = new b();
    this.JqG = new f.a()
    {
      public final void ee(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.fxr().Jre.get()).pop();
        synchronized (e.this)
        {
          e.this.JqA = e.this.JqB;
          e.this.JqB = null;
          if (!e.this.Jqt)
          {
            e.this.Jqx = paramAnonymousObject;
            if (e.this.Jqs == e.d.Jra)
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
        if (e.this.Jqs == e.d.JqZ)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
          AppMethodBeat.o(74856);
          return;
        }
        e.this.Jqs = e.d.JqX;
        e.this.ed(e.this.ec(paramAnonymousObject));
        AppMethodBeat.o(74856);
      }
      
      public final void fxq()
      {
        AppMethodBeat.i(74855);
        f localf = f.fxr();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.Jre.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.Jre.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.this.ym(true);
        AppMethodBeat.o(74857);
      }
    };
    this.JqJ = false;
    this.JqK = false;
    this.JqL = false;
    this.Jqw = g.fxu();
    this.Jqv = this.Jqw;
    this.Jqe = new com.tencent.mm.vending.h.f(this.Jqw, this.JqG);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> H(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.Jqs != d.JqW)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.Jqs = d.JqX;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      this.Jqx = paramVarArgs;
      ed(this.Jqx);
      AppMethodBeat.o(177484);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.I(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(74837);
    fxp();
    this.Jqu.add(new a(parama, this.Jqv, this.JqC, paramBoolean));
    this.JqC = -1L;
    if (this.Jqs == d.JqW)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.Jqs != d.JqX)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    ed(this.Jqx);
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.Jqr = true;
    if (this.JqH == null) {
      this.JqH = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.JqK)
    {
      a(parama, this.JqN);
      AppMethodBeat.o(74842);
      return;
    }
    this.JqH.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.Jqr = true;
    ed(this.Jqx);
    if (this.JqI == null) {
      this.JqI = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.JqJ)
    {
      b(paramb, this.JqM);
      AppMethodBeat.o(74843);
      return;
    }
    this.JqI.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(177486);
    final RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
    {
      private Void aVo()
      {
        AppMethodBeat.i(177476);
        try
        {
          ((d.b)paramPair.first).bo(paramObject);
          Void localVoid = Jql;
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
    }, null, this.JqD);
    AppMethodBeat.o(177486);
  }
  
  private void fxp()
  {
    AppMethodBeat.i(177485);
    if (this.Jqr)
    {
      c localc = new c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  public c<_Var> BB(long paramLong)
  {
    try
    {
      this.JqC = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> G(Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(74831);
      paramVarArgs = H(paramVarArgs);
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
      H(new Object[0]);
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
      a(parama, this.Jqw);
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
      a(paramb, this.Jqw);
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
        ((d.a)paramPair.first).cc(paramObject);
        AppMethodBeat.o(74854);
      }
    };
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.Jqw });
      AppMethodBeat.o(74840);
      return;
    }
    locald.w(paramPair);
    AppMethodBeat.o(74840);
  }
  
  public c<_Var> aRZ(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.Jqv = g.aSb(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.Jqv);
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
    this.Jqv = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.JqD);
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
    parama = aRZ("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    ym(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = aRZ("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  final Object ec(Object paramObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177488);
        if (this.Jqt)
        {
          this.mRetryCount += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.JqA.gjH.toString(), Integer.valueOf(this.mRetryCount) });
          ((LinkedList)this.Jqu).add(0, this.JqA);
          this.Jqt = false;
          paramObject = this.Jqx;
          AppMethodBeat.o(177488);
          return paramObject;
        }
        if (this.Jqy)
        {
          this.Jqx = this.Jqz;
          this.Jqz = null;
          this.Jqy = false;
          this.mRetryCount = 0;
        }
        else
        {
          this.Jqx = paramObject;
        }
      }
      finally {}
    }
  }
  
  final void ed(final Object paramObject)
  {
    AppMethodBeat.i(177489);
    if (this.Jqs != d.JqX)
    {
      AppMethodBeat.o(177489);
      return;
    }
    this.Jqs = d.JqY;
    a locala = (a)this.Jqu.peek();
    if (locala == null)
    {
      if (this.Jqr)
      {
        this.Jqs = d.Jrb;
        this.JqJ = true;
        this.JqM = paramObject;
        if (this.JqI != null)
        {
          paramObject = this.JqI.iterator();
          while (paramObject.hasNext()) {
            b((Pair)paramObject.next(), this.JqM);
          }
          AppMethodBeat.o(177489);
        }
      }
      else
      {
        this.Jqs = d.JqX;
      }
      AppMethodBeat.o(177489);
      return;
    }
    final com.tencent.mm.vending.c.a locala1 = locala.gjH;
    com.tencent.mm.vending.h.d locald = locala.cII;
    long l = locala.mInterval;
    final boolean bool = locala.JqV;
    if (this.Jqs == d.JqZ)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(177489);
      return;
    }
    this.JqB = ((a)this.Jqu.poll());
    this.Jqe.c(locald);
    if (l < 0L)
    {
      this.Jqe.a(locala1, paramObject, bool);
      AppMethodBeat.o(177489);
      return;
    }
    this.JqF = g.fxu();
    this.JqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74862);
        e.this.Jqe.a(locala1, paramObject, bool);
        AppMethodBeat.o(74862);
      }
    }, l);
    AppMethodBeat.o(177489);
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = aRZ("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  public final b fxn()
  {
    return this.JqE;
  }
  
  public final d<_Var> fxo()
  {
    try
    {
      this.Jqr = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> yl(boolean paramBoolean)
  {
    try
    {
      this.JqD = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void ym(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 437
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 87	com/tencent/mm/vending/g/e:Jqs	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 440	com/tencent/mm/vending/g/e$d:Jra	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 87	com/tencent/mm/vending/g/e:Jqs	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 385	com/tencent/mm/vending/g/e$d:Jrb	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 437
    //   31: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +43 -> 81
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/vending/g/e:Jqu	Ljava/util/Queue;
    //   45: invokeinterface 444 1 0
    //   50: ifle +31 -> 81
    //   53: ldc_w 279
    //   56: ldc_w 446
    //   59: iconst_1
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/vending/g/e:Jqu	Ljava/util/Queue;
    //   69: invokeinterface 444 1 0
    //   74: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 448	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getstatic 440	com/tencent/mm/vending/g/e$d:Jra	Lcom/tencent/mm/vending/g/e$d;
    //   85: putfield 87	com/tencent/mm/vending/g/e:Jqs	Lcom/tencent/mm/vending/g/e$d;
    //   88: aload_0
    //   89: getfield 94	com/tencent/mm/vending/g/e:Jqu	Ljava/util/Queue;
    //   92: invokeinterface 451 1 0
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 145	com/tencent/mm/vending/g/e:Jqx	Ljava/lang/Object;
    //   102: aload_0
    //   103: getfield 420	com/tencent/mm/vending/g/e:JqF	Lcom/tencent/mm/vending/h/d;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 420	com/tencent/mm/vending/g/e:JqF	Lcom/tencent/mm/vending/h/d;
    //   113: invokevirtual 454	com/tencent/mm/vending/h/d:cancel	()V
    //   116: ldc_w 437
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
    public boolean JqV;
    public com.tencent.mm.vending.h.d cII;
    public com.tencent.mm.vending.c.a gjH;
    public long mInterval;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.gjH = parama;
      this.cII = paramd;
      this.mInterval = paramLong;
      this.JqV = paramBoolean;
    }
  }
  
  final class b
    implements b
  {
    b() {}
    
    public final void F(Object... paramVarArgs)
    {
      AppMethodBeat.i(177479);
      synchronized (e.this)
      {
        if (e.this.Jqs != e.d.JqZ)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.Jqs });
          AppMethodBeat.o(177479);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.Jqz = paramVarArgs;
          e.this.Jqy = true;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
          resume();
          AppMethodBeat.o(177479);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.I(paramVarArgs);
      }
    }
    
    public final void eb(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.this.Jqs == e.d.Jra)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.a(e.this)) && (e.this.Jqs != e.d.JqZ))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.ym(false);
        e.this.JqK = true;
        e.this.JqN = paramObject;
        if (e.this.JqH != null)
        {
          Iterator localIterator = e.this.JqH.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(177477);
    }
    
    public final void fxm()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.Jqs == e.d.Jra) || (e.this.Jqs == e.d.JqW))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.Jqs });
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
          e.this.Jqs = e.d.JqZ;
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.this.Jqs != e.d.JqZ)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.a(e.this))
        {
          e.this.Jqs = e.d.JqX;
          if (!e.b(e.this)) {
            e.this.ed(e.this.ec(e.this.Jqx));
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.this.Jqs = e.d.JqY;
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
      JqW = new d("Idle", 0);
      JqX = new d("Resolved", 1);
      JqY = new d("Invoking", 2);
      JqZ = new d("Pausing", 3);
      Jra = new d("Interrupted", 4);
      Jrb = new d("AllDone", 5);
      Jrc = new d[] { JqW, JqX, JqY, JqZ, Jra, Jrb };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */