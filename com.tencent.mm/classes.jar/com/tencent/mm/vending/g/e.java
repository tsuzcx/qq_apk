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
  public volatile boolean aguF;
  private volatile d aguG;
  private boolean aguH;
  private Queue<a> aguI;
  private volatile com.tencent.mm.vending.h.d aguJ;
  private volatile com.tencent.mm.vending.h.d aguK;
  private volatile boolean aguL;
  private volatile Object aguM;
  private volatile Object aguN;
  private a aguO;
  private a aguP;
  private long aguQ;
  private boolean aguR;
  private b aguS;
  private com.tencent.mm.vending.h.d aguT;
  private f.a aguU;
  private List<Pair<d.a, com.tencent.mm.vending.h.d>> aguV;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> aguW;
  private boolean aguX;
  private boolean aguY;
  private boolean aguZ;
  private Object agva;
  private Object agvb;
  private int mRetryCount;
  com.tencent.mm.vending.h.f mSchedulerInvoker;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.aguF = false;
    this.aguG = d.agvj;
    this.aguH = false;
    this.aguI = new LinkedList();
    this.mRetryCount = 0;
    this.aguQ = -1L;
    this.aguR = false;
    this.aguS = new b();
    this.aguU = new f.a()
    {
      public final void gQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.jJT().agvr.get()).pop();
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
          if (e.e(e.this) == e.d.agvn)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          if (e.e(e.this) == e.d.agvm)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
          e.a(e.this, e.d.agvk);
          e.f(e.this);
          e.g(e.this);
          AppMethodBeat.o(74856);
          return;
        }
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.a(e.this, true);
        AppMethodBeat.o(74857);
      }
      
      public final void jJS()
      {
        AppMethodBeat.i(74855);
        f localf = f.jJT();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.agvr.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.agvr.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
    };
    this.aguX = false;
    this.aguY = false;
    this.aguZ = false;
    this.aguK = g.current();
    this.aguJ = this.aguK;
    this.mSchedulerInvoker = new com.tencent.mm.vending.h.f(this.aguK, this.aguU);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> M(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.aguG != d.agvj)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.aguG = d.agvk;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      gO(paramVarArgs);
      jJR();
      AppMethodBeat.o(177484);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.O(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(74837);
    jJN();
    this.aguI.add(new a(parama, this.aguJ, this.aguQ, paramBoolean));
    this.aguQ = -1L;
    if (this.aguG == d.agvj)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.aguG != d.agvk)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    jJR();
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(final Pair<d.a, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(74840);
    com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
    paramPair = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74854);
        ((d.a)paramPair.first).onInterrupt(paramObject);
        AppMethodBeat.o(74854);
      }
    };
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.aguK });
      AppMethodBeat.o(74840);
      return;
    }
    locald.arrange(paramPair);
    AppMethodBeat.o(74840);
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.aguF = true;
    if (this.aguV == null) {
      this.aguV = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.aguY)
    {
      a(parama, this.agvb);
      AppMethodBeat.o(74842);
      return;
    }
    this.aguV.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.aguF = true;
    jJR();
    if (this.aguW == null) {
      this.aguW = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.aguX)
    {
      b(paramb, this.agva);
      AppMethodBeat.o(74843);
      return;
    }
    this.aguW.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(Pair<d.b, com.tencent.mm.vending.h.d> paramPair, Object paramObject)
  {
    AppMethodBeat.i(177486);
    RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new e.4(this, paramPair, paramObject, localRuntimeException), null, this.aguR);
    AppMethodBeat.o(177486);
  }
  
  private static String gN(Object paramObject)
  {
    AppMethodBeat.i(235645);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(235645);
      return String.valueOf(i);
    }
    AppMethodBeat.o(235645);
    return null;
  }
  
  private void gO(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(235646);
      this.aguM = paramObject;
      this.aguL = true;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "set input(%s)", new Object[] { gN(paramObject) });
      AppMethodBeat.o(235646);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  private void jJN()
  {
    AppMethodBeat.i(177485);
    if (this.aguF)
    {
      e.c localc = new e.c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  /* Error */
  private void jJO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 304
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 84	com/tencent/mm/vending/g/e:aguH	Z
    //   12: ifeq +85 -> 97
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 91	com/tencent/mm/vending/g/e:mRetryCount	I
    //   20: iconst_1
    //   21: iadd
    //   22: putfield 91	com/tencent/mm/vending/g/e:mRetryCount	I
    //   25: ldc 189
    //   27: ldc_w 306
    //   30: iconst_2
    //   31: anewarray 5	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield 174	com/tencent/mm/vending/g/e:aguO	Lcom/tencent/mm/vending/g/e$a;
    //   40: getfield 310	com/tencent/mm/vending/g/e$a:mEQ	Lcom/tencent/mm/vending/c/a;
    //   43: invokevirtual 314	java/lang/Object:toString	()Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 91	com/tencent/mm/vending/g/e:mRetryCount	I
    //   53: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 321	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 84	com/tencent/mm/vending/g/e:aguH	Z
    //   65: aload_0
    //   66: getfield 89	com/tencent/mm/vending/g/e:aguI	Ljava/util/Queue;
    //   69: checkcast 86	java/util/LinkedList
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield 174	com/tencent/mm/vending/g/e:aguO	Lcom/tencent/mm/vending/g/e$a;
    //   77: invokevirtual 324	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 326	com/tencent/mm/vending/g/e:aguN	Ljava/lang/Object;
    //   85: invokespecial 142	com/tencent/mm/vending/g/e:gO	(Ljava/lang/Object;)V
    //   88: ldc_w 304
    //   91: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 91	com/tencent/mm/vending/g/e:mRetryCount	I
    //   102: ldc_w 304
    //   105: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private Object jJP()
  {
    try
    {
      AppMethodBeat.i(235644);
      Object localObject1 = this.aguM;
      this.aguN = this.aguM;
      this.aguM = null;
      this.aguL = false;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "pop input(%s)", new Object[] { gN(localObject1) });
      AppMethodBeat.o(235644);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private Object jJQ()
  {
    try
    {
      Object localObject1 = this.aguM;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void jJR()
  {
    AppMethodBeat.i(235647);
    if (this.aguG != d.agvk)
    {
      AppMethodBeat.o(235647);
      return;
    }
    this.aguG = d.agvl;
    Object localObject2 = (a)this.aguI.peek();
    if (localObject2 == null)
    {
      if (this.aguF)
      {
        this.aguG = d.agvo;
        this.agva = jJP();
        this.aguX = true;
        if (this.aguW != null)
        {
          localObject1 = this.aguW.iterator();
          while (((Iterator)localObject1).hasNext()) {
            b((Pair)((Iterator)localObject1).next(), this.agva);
          }
          AppMethodBeat.o(235647);
        }
      }
      else
      {
        this.aguG = d.agvk;
      }
      AppMethodBeat.o(235647);
      return;
    }
    Object localObject1 = ((a)localObject2).mEQ;
    com.tencent.mm.vending.h.d locald = ((a)localObject2).mScheduler;
    long l = ((a)localObject2).mInterval;
    boolean bool = ((a)localObject2).agvi;
    if (this.aguG == d.agvm)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(235647);
      return;
    }
    this.aguP = ((a)this.aguI.poll());
    this.mSchedulerInvoker.c(locald);
    localObject2 = jJP();
    if (l < 0L)
    {
      this.mSchedulerInvoker.a((com.tencent.mm.vending.c.a)localObject1, localObject2, bool);
      AppMethodBeat.o(235647);
      return;
    }
    this.aguT = g.current();
    this.aguT.arrangeInterval(new e.5(this, (com.tencent.mm.vending.c.a)localObject1, localObject2, bool), l);
    AppMethodBeat.o(235647);
  }
  
  public c<_Var> AA(long paramLong)
  {
    try
    {
      this.aguQ = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> L(Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(74831);
      paramVarArgs = M(paramVarArgs);
      AppMethodBeat.o(74831);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  public c<_Var> NM(boolean paramBoolean)
  {
    try
    {
      this.aguR = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void NN(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 412
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/vending/g/e:aguG	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 415	com/tencent/mm/vending/g/e$d:agvn	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 82	com/tencent/mm/vending/g/e:aguG	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 342	com/tencent/mm/vending/g/e$d:agvo	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 412
    //   31: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +42 -> 80
    //   41: aload_0
    //   42: getfield 89	com/tencent/mm/vending/g/e:aguI	Ljava/util/Queue;
    //   45: invokeinterface 418 1 0
    //   50: ifle +30 -> 80
    //   53: ldc 189
    //   55: ldc_w 420
    //   58: iconst_1
    //   59: anewarray 5	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: getfield 89	com/tencent/mm/vending/g/e:aguI	Ljava/util/Queue;
    //   68: invokeinterface 418 1 0
    //   73: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 423	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: getstatic 415	com/tencent/mm/vending/g/e$d:agvn	Lcom/tencent/mm/vending/g/e$d;
    //   84: putfield 82	com/tencent/mm/vending/g/e:aguG	Lcom/tencent/mm/vending/g/e$d;
    //   87: aload_0
    //   88: getfield 89	com/tencent/mm/vending/g/e:aguI	Ljava/util/Queue;
    //   91: invokeinterface 426 1 0
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 142	com/tencent/mm/vending/g/e:gO	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: getfield 379	com/tencent/mm/vending/g/e:aguT	Lcom/tencent/mm/vending/h/d;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 379	com/tencent/mm/vending/g/e:aguT	Lcom/tencent/mm/vending/h/d;
    //   112: invokevirtual 429	com/tencent/mm/vending/h/d:cancel	()V
    //   115: ldc_w 412
    //   118: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      AppMethodBeat.i(74830);
      M(new Object[0]);
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
      a(parama, this.aguK);
      AppMethodBeat.o(74844);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public d<_Var> a(d.b<_Var> paramb)
  {
    try
    {
      AppMethodBeat.i(74846);
      a(paramb, this.aguK);
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
  
  public d<_Var> a(com.tencent.mm.vending.h.d paramd, d.b<_Var> paramb)
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
    this.aguJ = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public c<_Var> bDP(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.aguJ = g.bDR(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.aguJ);
    AppMethodBeat.o(74827);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.aguR);
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
    parama = bDP("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    NN(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = bDP("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = bDP("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  public final b jJL()
  {
    return this.aguS;
  }
  
  public final d<_Var> jJM()
  {
    try
    {
      this.aguF = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
  {
    public boolean agvi;
    public com.tencent.mm.vending.c.a mEQ;
    public long mInterval;
    public com.tencent.mm.vending.h.d mScheduler;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.mEQ = parama;
      this.mScheduler = paramd;
      this.mInterval = paramLong;
      this.agvi = paramBoolean;
    }
  }
  
  final class b
    implements b
  {
    b() {}
    
    public final void K(Object... paramVarArgs)
    {
      AppMethodBeat.i(177479);
      synchronized (e.this)
      {
        if (e.e(e.this) != e.d.agvm)
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
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole(%s).", new Object[] { e.this, e.gP(e.k(e.this)) });
          resume();
          AppMethodBeat.o(177479);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.O(paramVarArgs);
      }
    }
    
    public final void gM(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.e(e.this) == e.d.agvn)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.h(e.this)) && (e.e(e.this) != e.d.agvm))
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
    
    public final void jJK()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.e(e.this) == e.d.agvn) || (e.e(e.this) == e.d.agvj))
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
          e.a(e.this, e.d.agvm);
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.e(e.this) != e.d.agvm)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.h(e.this))
        {
          e.a(e.this, e.d.agvk);
          e.f(e.this);
          if (!e.l(e.this)) {
            e.g(e.this);
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.a(e.this, e.d.agvl);
      }
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(177483);
      agvj = new d("Idle", 0);
      agvk = new d("Resolved", 1);
      agvl = new d("Invoking", 2);
      agvm = new d("Pausing", 3);
      agvn = new d("Interrupted", 4);
      agvo = new d("AllDone", 5);
      agvp = new d[] { agvj, agvk, agvl, agvm, agvn, agvo };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */