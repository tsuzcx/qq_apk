package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.f.a;
import com.tencent.mm.vending.h.h;
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
  private f.a AOA;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> AOB;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> AOC;
  private Object AOD;
  Object AOE;
  volatile d AOr;
  private Queue<b> AOs;
  private volatile com.tencent.mm.vending.h.d AOt;
  private volatile com.tencent.mm.vending.h.d AOu;
  b AOv;
  b AOw;
  private b AOx;
  private com.tencent.mm.vending.h.d AOy;
  f AOz;
  private volatile boolean b;
  boolean d;
  volatile Object h;
  volatile boolean i;
  volatile Object j;
  private int m;
  private long n;
  private boolean o;
  private boolean v;
  boolean w;
  private boolean x;
  
  public e()
  {
    AppMethodBeat.i(126034);
    this.b = false;
    this.AOr = d.AON;
    this.d = false;
    this.AOs = new LinkedList();
    this.m = 0;
    this.n = -1L;
    this.o = false;
    this.AOx = new c();
    this.AOA = new f.a()
    {
      public final void cM(Object paramAnonymousObject)
      {
        AppMethodBeat.i(126062);
        ((Stack)g.dQt().b.get()).pop();
        synchronized (e.this)
        {
          e.this.AOv = e.this.AOw;
          e.this.AOw = null;
          if (!e.this.d)
          {
            e.this.h = paramAnonymousObject;
            if (e.this.AOr == e.d.AOQ)
            {
              com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
              AppMethodBeat.o(126062);
            }
          }
          else
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
          }
        }
        if (e.this.AOr == e.d.AOP)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
          AppMethodBeat.o(126062);
          return;
        }
        e.this.AOr = e.d.AOO;
        e.this.cL(e.this.a(paramAnonymousObject));
        AppMethodBeat.o(126062);
      }
      
      public final void dQp()
      {
        AppMethodBeat.i(126061);
        g localg = g.dQt();
        e locale = e.this;
        Stack localStack2 = (Stack)localg.b.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localg.b.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(126061);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(126063);
        e.this.a(true);
        AppMethodBeat.o(126063);
      }
    };
    this.v = false;
    this.w = false;
    this.x = false;
    this.AOu = com.tencent.mm.vending.h.g.dQu();
    this.AOt = this.AOu;
    this.AOz = new f(this.AOu, this.AOA);
    AppMethodBeat.o(126034);
  }
  
  private c<_Var> E(Object... paramVarArgs)
  {
    AppMethodBeat.i(126040);
    if (this.AOr != d.AON)
    {
      AppMethodBeat.o(126040);
      return this;
    }
    this.AOr = d.AOO;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      this.h = paramVarArgs;
      cL(this.h);
      AppMethodBeat.o(126040);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.F(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(126045);
    a();
    this.AOs.add(new b(parama, this.AOt, this.n, paramBoolean));
    this.n = -1L;
    if (this.AOr == d.AON)
    {
      AppMethodBeat.o(126045);
      return this;
    }
    if (this.AOr != d.AOO)
    {
      AppMethodBeat.o(126045);
      return this;
    }
    cL(this.h);
    AppMethodBeat.o(126045);
    return this;
  }
  
  private void a()
  {
    AppMethodBeat.i(126047);
    if (this.b)
    {
      a locala = new a("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(126047);
      throw locala;
    }
    AppMethodBeat.o(126047);
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(146043);
    this.b = true;
    if (this.AOB == null) {
      this.AOB = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.w)
    {
      a(parama, this.AOE);
      AppMethodBeat.o(146043);
      return;
    }
    this.AOB.add(parama);
    AppMethodBeat.o(146043);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(126050);
    this.b = true;
    cL(this.h);
    if (this.AOC == null) {
      this.AOC = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.v)
    {
      b(paramb, this.AOD);
      AppMethodBeat.o(126050);
      return;
    }
    this.AOC.add(paramb);
    AppMethodBeat.o(126050);
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(126049);
    final RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
    {
      private Void dQq()
      {
        AppMethodBeat.i(126058);
        try
        {
          ((d.b)paramPair.first).ap(paramObject);
          Void localVoid = AOo;
          AppMethodBeat.o(126058);
          return localVoid;
        }
        catch (ClassCastException localClassCastException)
        {
          if (localRuntimeException.getCause() == null) {
            localRuntimeException.initCause(localClassCastException);
          }
          RuntimeException localRuntimeException = localRuntimeException;
          AppMethodBeat.o(126058);
          throw localRuntimeException;
        }
      }
    }, null, this.o);
    AppMethodBeat.o(126049);
  }
  
  public c<_Var> D(Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(126039);
      paramVarArgs = E(paramVarArgs);
      AppMethodBeat.o(126039);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  public c<_Var> a(com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(126037);
    Assert.assertNotNull("keeper should not be null!", paramb);
    paramb.keep(this);
    AppMethodBeat.o(126037);
    return this;
  }
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      AppMethodBeat.i(126038);
      E(new Object[0]);
      a(new com.tencent.mm.vending.c.a()
      {
        public final _Var call(_Var paramAnonymous_Var)
        {
          AppMethodBeat.i(126071);
          paramAnonymous_Var = parama.call();
          AppMethodBeat.o(126071);
          return paramAnonymous_Var;
        }
      }, true);
      AppMethodBeat.o(126038);
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
      AppMethodBeat.i(126051);
      a(parama, this.AOu);
      AppMethodBeat.o(126051);
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
      AppMethodBeat.i(126052);
      a(paramb, this.AOu);
      AppMethodBeat.o(126052);
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
      AppMethodBeat.i(146044);
      a(parama, paramd);
      AppMethodBeat.o(146044);
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
      AppMethodBeat.i(126053);
      a(paramb, paramd);
      AppMethodBeat.o(126053);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  final Object a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(126055);
        if (this.d)
        {
          this.m += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.AOv.AOM.toString(), Integer.valueOf(this.m) });
          ((LinkedList)this.AOs).add(0, this.AOv);
          this.d = false;
          paramObject = this.h;
          AppMethodBeat.o(126055);
          return paramObject;
        }
        if (this.i)
        {
          this.h = this.j;
          this.j = null;
          this.i = false;
          this.m = 0;
        }
        else
        {
          this.h = paramObject;
        }
      }
      finally {}
    }
  }
  
  final void a(final Pair<d.a, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(126048);
    com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
    paramPair = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126060);
        ((d.a)paramPair.first).aX(paramObject);
        AppMethodBeat.o(126060);
      }
    };
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.AOu });
      AppMethodBeat.o(126048);
      return;
    }
    locald.o(paramPair);
    AppMethodBeat.o(126048);
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 331
    //   5: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 84	com/tencent/mm/vending/g/e:AOr	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 334	com/tencent/mm/vending/g/e$d:AOQ	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 84	com/tencent/mm/vending/g/e:AOr	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 337	com/tencent/mm/vending/g/e$d:AOR	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 331
    //   31: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +43 -> 81
    //   41: aload_0
    //   42: getfield 91	com/tencent/mm/vending/g/e:AOs	Ljava/util/Queue;
    //   45: invokeinterface 341 1 0
    //   50: ifle +31 -> 81
    //   53: ldc_w 287
    //   56: ldc_w 343
    //   59: iconst_1
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 91	com/tencent/mm/vending/g/e:AOs	Ljava/util/Queue;
    //   69: invokeinterface 341 1 0
    //   74: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 345	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getstatic 334	com/tencent/mm/vending/g/e$d:AOQ	Lcom/tencent/mm/vending/g/e$d;
    //   85: putfield 84	com/tencent/mm/vending/g/e:AOr	Lcom/tencent/mm/vending/g/e$d;
    //   88: aload_0
    //   89: getfield 91	com/tencent/mm/vending/g/e:AOs	Ljava/util/Queue;
    //   92: invokeinterface 348 1 0
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 141	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   102: aload_0
    //   103: getfield 350	com/tencent/mm/vending/g/e:AOy	Lcom/tencent/mm/vending/h/d;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 350	com/tencent/mm/vending/g/e:AOy	Lcom/tencent/mm/vending/h/d;
    //   113: invokevirtual 353	com/tencent/mm/vending/h/d:cancel	()V
    //   116: ldc_w 331
    //   119: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public c<_Var> avB(String paramString)
  {
    AppMethodBeat.i(126035);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(126035);
      return this;
    }
    this.AOt = com.tencent.mm.vending.h.g.avD(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.AOt);
    AppMethodBeat.o(126035);
    return this;
  }
  
  public c<_Var> b(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(126036);
    if (paramd == null)
    {
      Assert.assertNotNull("scheduler should not be null!", paramd);
      AppMethodBeat.o(126036);
      return this;
    }
    this.AOt = paramd;
    AppMethodBeat.o(126036);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(126046);
      parama = a(parama, this.o);
      AppMethodBeat.o(126046);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  final void cL(final Object paramObject)
  {
    AppMethodBeat.i(126056);
    if (this.AOr != d.AOO)
    {
      AppMethodBeat.o(126056);
      return;
    }
    this.AOr = d.AOr;
    b localb = (b)this.AOs.peek();
    if (localb == null)
    {
      if (this.b)
      {
        this.AOr = d.AOR;
        this.v = true;
        this.AOD = paramObject;
        if (this.AOC != null)
        {
          paramObject = this.AOC.iterator();
          while (paramObject.hasNext()) {
            b((Pair)paramObject.next(), this.AOD);
          }
          AppMethodBeat.o(126056);
        }
      }
      else
      {
        this.AOr = d.AOO;
      }
      AppMethodBeat.o(126056);
      return;
    }
    final com.tencent.mm.vending.c.a locala = localb.AOM;
    com.tencent.mm.vending.h.d locald = localb.AOk;
    long l = localb.c;
    final boolean bool = localb.d;
    if (this.AOr == d.AOP)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(126056);
      return;
    }
    this.AOw = ((b)this.AOs.poll());
    this.AOz.c(locald);
    if (l < 0L)
    {
      this.AOz.a(locala, paramObject, bool);
      AppMethodBeat.o(126056);
      return;
    }
    if (Looper.myLooper() == null) {}
    for (this.AOy = new com.tencent.mm.vending.h.c();; this.AOy = new h(Looper.myLooper(), Looper.myLooper().toString()))
    {
      this.AOy.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126068);
          e.this.AOz.a(locala, paramObject, bool);
          AppMethodBeat.o(126068);
        }
      }, l);
      AppMethodBeat.o(126056);
      return;
    }
  }
  
  public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(126043);
    parama = avB("Vending.LOGIC").c(parama);
    AppMethodBeat.o(126043);
    return parama;
  }
  
  public final b dQn()
  {
    return this.AOx;
  }
  
  public final d<_Var> dQo()
  {
    try
    {
      this.b = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void dead()
  {
    AppMethodBeat.i(126041);
    a(true);
    AppMethodBeat.o(126041);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(126044);
    parama = avB("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(126044);
    return parama;
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(126042);
    parama = avB("Vending.UI").c(parama);
    AppMethodBeat.o(126042);
    return parama;
  }
  
  public c<_Var> oV(long paramLong)
  {
    try
    {
      this.n = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> rK(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
    extends Error
  {
    public a(String paramString, Object... paramVarArgs)
    {
      super();
      AppMethodBeat.i(126013);
      AppMethodBeat.o(126013);
    }
  }
  
  static final class b
  {
    public com.tencent.mm.vending.c.a AOM;
    public com.tencent.mm.vending.h.d AOk;
    public long c;
    public boolean d;
    
    public b(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.AOM = parama;
      this.AOk = paramd;
      this.c = paramLong;
      this.d = paramBoolean;
    }
  }
  
  final class c
    implements b
  {
    c() {}
    
    public final void C(Object... paramVarArgs)
    {
      AppMethodBeat.i(126066);
      synchronized (e.this)
      {
        if (e.this.AOr != e.d.AOP)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.AOr });
          AppMethodBeat.o(126066);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.j = paramVarArgs;
          e.this.i = true;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
          resume();
          AppMethodBeat.o(126066);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.F(paramVarArgs);
      }
    }
    
    public final void cK(Object paramObject)
    {
      AppMethodBeat.i(126064);
      synchronized (e.this)
      {
        if (e.this.AOr == e.d.AOQ)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(126064);
          return;
        }
        if ((!e.a(e.this)) && (e.this.AOr != e.d.AOP))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(126064);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.a(false);
        e.this.w = true;
        e.this.AOE = paramObject;
        if (e.this.AOB != null)
        {
          Iterator localIterator = e.this.AOB.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(126064);
    }
    
    public final void dQm()
    {
      AppMethodBeat.i(126065);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.AOr == e.d.AOQ) || (e.this.AOr == e.d.AON))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.AOr });
              AppMethodBeat.o(126065);
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
          e.this.AOr = e.d.AOP;
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(126067);
      synchronized (e.this)
      {
        if (e.this.AOr != e.d.AOP)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(126067);
          return;
        }
        if (!e.a(e.this))
        {
          e.this.AOr = e.d.AOO;
          if (!e.b(e.this)) {
            e.this.cL(e.this.a(e.this.h));
          }
          AppMethodBeat.o(126067);
          return;
        }
        e.this.AOr = e.d.AOr;
      }
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(126016);
      AON = new d("Idle", 0);
      AOO = new d("Resolved", 1);
      AOr = new d("Invoking", 2);
      AOP = new d("Pausing", 3);
      AOQ = new d("Interrupted", 4);
      AOR = new d("AllDone", 5);
      AOS = new d[] { AON, AOO, AOr, AOP, AOQ, AOR };
      AppMethodBeat.o(126016);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */