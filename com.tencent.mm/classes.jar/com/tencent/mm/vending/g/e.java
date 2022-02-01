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
  private boolean YAA;
  private boolean YAB;
  private Object YAC;
  private Object YAD;
  public volatile boolean YAh;
  private volatile d YAi;
  private boolean YAj;
  private Queue<a> YAk;
  private volatile com.tencent.mm.vending.h.d YAl;
  private volatile com.tencent.mm.vending.h.d YAm;
  private volatile boolean YAn;
  private volatile Object YAo;
  private volatile Object YAp;
  private a YAq;
  private a YAr;
  private long YAs;
  private boolean YAt;
  private b YAu;
  private com.tencent.mm.vending.h.d YAv;
  private f.a YAw;
  private List<Pair<d.a, com.tencent.mm.vending.h.d>> YAx;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> YAy;
  private boolean YAz;
  private int mRetryCount;
  com.tencent.mm.vending.h.f mSchedulerInvoker;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.YAh = false;
    this.YAi = d.YAM;
    this.YAj = false;
    this.YAk = new LinkedList();
    this.mRetryCount = 0;
    this.YAs = -1L;
    this.YAt = false;
    this.YAu = new b();
    this.YAw = new f.a()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.ieM().YAU.get()).pop();
        synchronized (e.this)
        {
          e.a(e.this, e.a(e.this));
          e.b(e.this);
          if (!e.c(e.this)) {
            e.a(e.this, paramAnonymousObject);
          }
          if (e.d(e.this)) {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
          }
          if (e.e(e.this) == e.d.YAQ)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          if (e.e(e.this) == e.d.YAP)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
          e.a(e.this, e.d.YAN);
          e.f(e.this);
          e.g(e.this);
          AppMethodBeat.o(74856);
          return;
        }
      }
      
      public final void ieL()
      {
        AppMethodBeat.i(74855);
        f localf = f.ieM();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.YAU.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.YAU.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.a(e.this, true);
        AppMethodBeat.o(74857);
      }
    };
    this.YAz = false;
    this.YAA = false;
    this.YAB = false;
    this.YAm = g.current();
    this.YAl = this.YAm;
    this.mSchedulerInvoker = new com.tencent.mm.vending.h.f(this.YAm, this.YAw);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> I(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.YAi != d.YAM)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.YAi = d.YAN;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      eq(paramVarArgs);
      ieK();
      AppMethodBeat.o(177484);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.K(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(74837);
    ieG();
    this.YAk.add(new a(parama, this.YAl, this.YAs, paramBoolean));
    this.YAs = -1L;
    if (this.YAi == d.YAM)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.YAi != d.YAN)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    ieK();
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(Pair<d.a, com.tencent.mm.vending.h.d> paramPair, Object paramObject)
  {
    AppMethodBeat.i(74840);
    com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
    paramPair = new e.3(this, paramPair, paramObject);
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.YAm });
      AppMethodBeat.o(74840);
      return;
    }
    locald.arrange(paramPair);
    AppMethodBeat.o(74840);
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.YAh = true;
    if (this.YAx == null) {
      this.YAx = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.YAA)
    {
      a(parama, this.YAD);
      AppMethodBeat.o(74842);
      return;
    }
    this.YAx.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.YAh = true;
    ieK();
    if (this.YAy == null) {
      this.YAy = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.YAz)
    {
      b(paramb, this.YAC);
      AppMethodBeat.o(74843);
      return;
    }
    this.YAy.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(Pair<d.b, com.tencent.mm.vending.h.d> paramPair, Object paramObject)
  {
    AppMethodBeat.i(177486);
    RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new e.4(this, paramPair, paramObject, localRuntimeException), null, this.YAt);
    AppMethodBeat.o(177486);
  }
  
  private static String ep(Object paramObject)
  {
    AppMethodBeat.i(247622);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(247622);
      return String.valueOf(i);
    }
    AppMethodBeat.o(247622);
    return null;
  }
  
  private void eq(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(247624);
      this.YAo = paramObject;
      this.YAn = true;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "set input(%s)", new Object[] { ep(paramObject) });
      AppMethodBeat.o(247624);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  private void ieG()
  {
    AppMethodBeat.i(177485);
    if (this.YAh)
    {
      e.c localc = new e.c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  /* Error */
  private void ieH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 301
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/vending/g/e:YAj	Z
    //   12: ifeq +85 -> 97
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 89	com/tencent/mm/vending/g/e:mRetryCount	I
    //   20: iconst_1
    //   21: iadd
    //   22: putfield 89	com/tencent/mm/vending/g/e:mRetryCount	I
    //   25: ldc 188
    //   27: ldc_w 303
    //   30: iconst_2
    //   31: anewarray 5	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield 171	com/tencent/mm/vending/g/e:YAq	Lcom/tencent/mm/vending/g/e$a;
    //   40: getfield 307	com/tencent/mm/vending/g/e$a:keH	Lcom/tencent/mm/vending/c/a;
    //   43: invokevirtual 311	java/lang/Object:toString	()Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 89	com/tencent/mm/vending/g/e:mRetryCount	I
    //   53: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 318	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 82	com/tencent/mm/vending/g/e:YAj	Z
    //   65: aload_0
    //   66: getfield 87	com/tencent/mm/vending/g/e:YAk	Ljava/util/Queue;
    //   69: checkcast 84	java/util/LinkedList
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield 171	com/tencent/mm/vending/g/e:YAq	Lcom/tencent/mm/vending/g/e$a;
    //   77: invokevirtual 321	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 323	com/tencent/mm/vending/g/e:YAp	Ljava/lang/Object;
    //   85: invokespecial 139	com/tencent/mm/vending/g/e:eq	(Ljava/lang/Object;)V
    //   88: ldc_w 301
    //   91: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 89	com/tencent/mm/vending/g/e:mRetryCount	I
    //   102: ldc_w 301
    //   105: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: goto -14 -> 94
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	e
    //   111	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	94	111	finally
    //   97	108	111	finally
  }
  
  private Object ieI()
  {
    try
    {
      AppMethodBeat.i(247620);
      Object localObject1 = this.YAo;
      this.YAp = this.YAo;
      this.YAo = null;
      this.YAn = false;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "pop input(%s)", new Object[] { ep(localObject1) });
      AppMethodBeat.o(247620);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private Object ieJ()
  {
    try
    {
      Object localObject1 = this.YAo;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void ieK()
  {
    AppMethodBeat.i(247626);
    if (this.YAi != d.YAN)
    {
      AppMethodBeat.o(247626);
      return;
    }
    this.YAi = d.YAO;
    Object localObject2 = (a)this.YAk.peek();
    if (localObject2 == null)
    {
      if (this.YAh)
      {
        this.YAi = d.YAR;
        this.YAC = ieI();
        this.YAz = true;
        if (this.YAy != null)
        {
          localObject1 = this.YAy.iterator();
          while (((Iterator)localObject1).hasNext()) {
            b((Pair)((Iterator)localObject1).next(), this.YAC);
          }
          AppMethodBeat.o(247626);
        }
      }
      else
      {
        this.YAi = d.YAN;
      }
      AppMethodBeat.o(247626);
      return;
    }
    Object localObject1 = ((a)localObject2).keH;
    com.tencent.mm.vending.h.d locald = ((a)localObject2).mScheduler;
    long l = ((a)localObject2).mInterval;
    boolean bool = ((a)localObject2).YAL;
    if (this.YAi == d.YAP)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(247626);
      return;
    }
    this.YAr = ((a)this.YAk.poll());
    this.mSchedulerInvoker.c(locald);
    localObject2 = ieI();
    if (l < 0L)
    {
      this.mSchedulerInvoker.a((com.tencent.mm.vending.c.a)localObject1, localObject2, bool);
      AppMethodBeat.o(247626);
      return;
    }
    this.YAv = g.current();
    this.YAv.arrangeInterval(new e.5(this, (com.tencent.mm.vending.c.a)localObject1, localObject2, bool), l);
    AppMethodBeat.o(247626);
  }
  
  public c<_Var> H(Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(74831);
      paramVarArgs = I(paramVarArgs);
      AppMethodBeat.o(74831);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  public c<_Var> HR(boolean paramBoolean)
  {
    try
    {
      this.YAt = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void HS(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 408
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 80	com/tencent/mm/vending/g/e:YAi	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 411	com/tencent/mm/vending/g/e$d:YAQ	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 80	com/tencent/mm/vending/g/e:YAi	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 339	com/tencent/mm/vending/g/e$d:YAR	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 408
    //   31: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +42 -> 80
    //   41: aload_0
    //   42: getfield 87	com/tencent/mm/vending/g/e:YAk	Ljava/util/Queue;
    //   45: invokeinterface 414 1 0
    //   50: ifle +30 -> 80
    //   53: ldc 188
    //   55: ldc_w 416
    //   58: iconst_1
    //   59: anewarray 5	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: getfield 87	com/tencent/mm/vending/g/e:YAk	Ljava/util/Queue;
    //   68: invokeinterface 414 1 0
    //   73: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 419	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: getstatic 411	com/tencent/mm/vending/g/e$d:YAQ	Lcom/tencent/mm/vending/g/e$d;
    //   84: putfield 80	com/tencent/mm/vending/g/e:YAi	Lcom/tencent/mm/vending/g/e$d;
    //   87: aload_0
    //   88: getfield 87	com/tencent/mm/vending/g/e:YAk	Ljava/util/Queue;
    //   91: invokeinterface 422 1 0
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 139	com/tencent/mm/vending/g/e:eq	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: getfield 376	com/tencent/mm/vending/g/e:YAv	Lcom/tencent/mm/vending/h/d;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 376	com/tencent/mm/vending/g/e:YAv	Lcom/tencent/mm/vending/h/d;
    //   112: invokevirtual 425	com/tencent/mm/vending/h/d:cancel	()V
    //   115: ldc_w 408
    //   118: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -87 -> 34
    //   124: astore_2
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	e
    //   0	129	1	paramBoolean	boolean
    //   124	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	124	finally
    //   28	34	124	finally
    //   41	80	124	finally
    //   80	115	124	finally
    //   115	121	124	finally
  }
  
  public c<_Var> Wo(long paramLong)
  {
    try
    {
      this.YAs = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      AppMethodBeat.i(74830);
      I(new Object[0]);
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
      a(parama, this.YAm);
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
      a(paramb, this.YAm);
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
    this.YAl = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public c<_Var> bBv(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.YAl = g.bBx(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.YAl);
    AppMethodBeat.o(74827);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.YAt);
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
    parama = bBv("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    HS(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = bBv("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = bBv("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  public final b ieE()
  {
    return this.YAu;
  }
  
  public final d<_Var> ieF()
  {
    try
    {
      this.YAh = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(292711);
    HS(true);
    AppMethodBeat.o(292711);
  }
  
  static final class a
  {
    public boolean YAL;
    public com.tencent.mm.vending.c.a keH;
    public long mInterval;
    public com.tencent.mm.vending.h.d mScheduler;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.keH = parama;
      this.mScheduler = paramd;
      this.mInterval = paramLong;
      this.YAL = paramBoolean;
    }
  }
  
  final class b
    implements b
  {
    b() {}
    
    public final void G(Object... paramVarArgs)
    {
      AppMethodBeat.i(177479);
      synchronized (e.this)
      {
        if (e.e(e.this) != e.d.YAP)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.e(e.this) });
          AppMethodBeat.o(177479);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          e.a(locale2, paramVarArgs);
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole(%s).", new Object[] { e.this, e.er(e.k(e.this)) });
          resume();
          AppMethodBeat.o(177479);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.K(paramVarArgs);
      }
    }
    
    public final void eo(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.e(e.this) == e.d.YAQ)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.h(e.this)) && (e.e(e.this) != e.d.YAP))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.a(e.this, false);
        e.i(e.this);
        e.b(e.this, paramObject);
        if (e.j(e.this) != null)
        {
          Iterator localIterator = e.j(e.this).iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.a(e.this, localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(177477);
    }
    
    public final void ieD()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.e(e.this) == e.d.YAQ) || (e.e(e.this) == e.d.YAM))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.e(e.this) });
              AppMethodBeat.o(177478);
              return;
            }
            if (!e.h(e.this)) {
              com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", new Object[] { e.this });
            }
          }
        }
        if (!e.l(e.this)) {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", new Object[] { e.this });
        } else {
          e.a(e.this, e.d.YAP);
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.e(e.this) != e.d.YAP)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.h(e.this))
        {
          e.a(e.this, e.d.YAN);
          e.f(e.this);
          if (!e.l(e.this)) {
            e.g(e.this);
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.a(e.this, e.d.YAO);
      }
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(177483);
      YAM = new d("Idle", 0);
      YAN = new d("Resolved", 1);
      YAO = new d("Invoking", 2);
      YAP = new d("Pausing", 3);
      YAQ = new d("Interrupted", 4);
      YAR = new d("AllDone", 5);
      YAS = new d[] { YAM, YAN, YAO, YAP, YAQ, YAR };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */