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
  public volatile boolean QZR;
  volatile d QZS;
  boolean QZT;
  private Queue<a> QZU;
  private volatile com.tencent.mm.vending.h.d QZV;
  private volatile com.tencent.mm.vending.h.d QZW;
  volatile boolean QZX;
  private volatile Object QZY;
  private volatile Object QZZ;
  a Raa;
  a Rab;
  private long Rac;
  private boolean Rad;
  private b Rae;
  private com.tencent.mm.vending.h.d Raf;
  private f.a Rag;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> Rah;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> Rai;
  private boolean Raj;
  boolean Rak;
  private boolean Ral;
  private Object Ram;
  Object Ran;
  private int mRetryCount;
  com.tencent.mm.vending.h.f mSchedulerInvoker;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.QZR = false;
    this.QZS = d.Raw;
    this.QZT = false;
    this.QZU = new LinkedList();
    this.mRetryCount = 0;
    this.Rac = -1L;
    this.Rad = false;
    this.Rae = new b();
    this.Rag = new f.a()
    {
      public final void em(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.hdF().RaE.get()).pop();
        synchronized (e.this)
        {
          e.this.Raa = e.this.Rab;
          e.this.Rab = null;
          if (!e.this.QZX) {
            e.this.el(paramAnonymousObject);
          }
          if (e.this.QZT) {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
          }
          if (e.this.QZS == e.d.RaA)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          if (e.this.QZS == e.d.Raz)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
            AppMethodBeat.o(74856);
            return;
          }
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
          e.this.QZS = e.d.Rax;
          e.this.hdA();
          e.this.hdD();
          AppMethodBeat.o(74856);
          return;
        }
      }
      
      public final void hdE()
      {
        AppMethodBeat.i(74855);
        f localf = f.hdF();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.RaE.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.RaE.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.this.Dv(true);
        AppMethodBeat.o(74857);
      }
    };
    this.Raj = false;
    this.Rak = false;
    this.Ral = false;
    this.QZW = g.current();
    this.QZV = this.QZW;
    this.mSchedulerInvoker = new com.tencent.mm.vending.h.f(this.QZW, this.Rag);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> I(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.QZS != d.Raw)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.QZS = d.Rax;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      el(paramVarArgs);
      hdD();
      AppMethodBeat.o(177484);
      return this;
      if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.J(paramVarArgs);
      }
    }
  }
  
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(74837);
    hdz();
    this.QZU.add(new a(parama, this.QZV, this.Rac, paramBoolean));
    this.Rac = -1L;
    if (this.QZS == d.Raw)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.QZS != d.Rax)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    hdD();
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.QZR = true;
    if (this.Rah == null) {
      this.Rah = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.Rak)
    {
      a(parama, this.Ran);
      AppMethodBeat.o(74842);
      return;
    }
    this.Rah.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.QZR = true;
    hdD();
    if (this.Rai == null) {
      this.Rai = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.Raj)
    {
      b(paramb, this.Ram);
      AppMethodBeat.o(74843);
      return;
    }
    this.Rai.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(177486);
    final RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
    {
      private Void buw()
      {
        AppMethodBeat.i(177476);
        try
        {
          ((d.b)paramPair.first).bz(paramObject);
          Void localVoid = QZL;
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
    }, null, this.Rad);
    AppMethodBeat.o(177486);
  }
  
  static String ek(Object paramObject)
  {
    AppMethodBeat.i(201255);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(201255);
      return String.valueOf(i);
    }
    AppMethodBeat.o(201255);
    return null;
  }
  
  private Object hdB()
  {
    try
    {
      AppMethodBeat.i(201254);
      Object localObject1 = this.QZY;
      this.QZZ = this.QZY;
      this.QZY = null;
      this.QZX = false;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "pop input(%s)", new Object[] { ek(localObject1) });
      AppMethodBeat.o(201254);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void hdz()
  {
    AppMethodBeat.i(177485);
    if (this.QZR)
    {
      c localc = new c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  public c<_Var> Du(boolean paramBoolean)
  {
    try
    {
      this.Rad = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void Dv(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 277
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 87	com/tencent/mm/vending/g/e:QZS	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 280	com/tencent/mm/vending/g/e$d:RaA	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 87	com/tencent/mm/vending/g/e:QZS	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 283	com/tencent/mm/vending/g/e$d:RaB	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 277
    //   31: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +43 -> 81
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/vending/g/e:QZU	Ljava/util/Queue;
    //   45: invokeinterface 286 1 0
    //   50: ifle +31 -> 81
    //   53: ldc_w 256
    //   56: ldc_w 288
    //   59: iconst_1
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/vending/g/e:QZU	Ljava/util/Queue;
    //   69: invokeinterface 286 1 0
    //   74: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 296	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getstatic 280	com/tencent/mm/vending/g/e$d:RaA	Lcom/tencent/mm/vending/g/e$d;
    //   85: putfield 87	com/tencent/mm/vending/g/e:QZS	Lcom/tencent/mm/vending/g/e$d;
    //   88: aload_0
    //   89: getfield 94	com/tencent/mm/vending/g/e:QZU	Ljava/util/Queue;
    //   92: invokeinterface 299 1 0
    //   97: aload_0
    //   98: aconst_null
    //   99: invokevirtual 146	com/tencent/mm/vending/g/e:el	(Ljava/lang/Object;)V
    //   102: aload_0
    //   103: getfield 301	com/tencent/mm/vending/g/e:Raf	Lcom/tencent/mm/vending/h/d;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 301	com/tencent/mm/vending/g/e:Raf	Lcom/tencent/mm/vending/h/d;
    //   113: invokevirtual 304	com/tencent/mm/vending/h/d:cancel	()V
    //   116: ldc_w 277
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
  
  public c<_Var> Oc(long paramLong)
  {
    try
    {
      this.Rac = paramLong;
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
      a(parama, this.QZW);
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
      a(paramb, this.QZW);
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
        ((d.a)paramPair.first).cn(paramObject);
        AppMethodBeat.o(74854);
      }
    };
    if (locald == null)
    {
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.QZW });
      AppMethodBeat.o(74840);
      return;
    }
    locald.arrange(paramPair);
    AppMethodBeat.o(74840);
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
    this.QZV = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public c<_Var> boF(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.QZV = g.boH(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.QZV);
    AppMethodBeat.o(74827);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.Rad);
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
    parama = boF("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    Dv(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = boF("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  final void el(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(201256);
      this.QZY = paramObject;
      this.QZX = true;
      com.tencent.mm.vending.f.a.d("Vending.Pipeline", "set input(%s)", new Object[] { ek(paramObject) });
      AppMethodBeat.o(201256);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = boF("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  /* Error */
  final void hdA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 409
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 89	com/tencent/mm/vending/g/e:QZT	Z
    //   12: ifeq +86 -> 98
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 96	com/tencent/mm/vending/g/e:mRetryCount	I
    //   20: iconst_1
    //   21: iadd
    //   22: putfield 96	com/tencent/mm/vending/g/e:mRetryCount	I
    //   25: ldc_w 256
    //   28: ldc_w 411
    //   31: iconst_2
    //   32: anewarray 5	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield 413	com/tencent/mm/vending/g/e:Raa	Lcom/tencent/mm/vending/g/e$a;
    //   41: getfield 417	com/tencent/mm/vending/g/e$a:hsM	Lcom/tencent/mm/vending/c/a;
    //   44: invokevirtual 421	java/lang/Object:toString	()Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_0
    //   51: getfield 96	com/tencent/mm/vending/g/e:mRetryCount	I
    //   54: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 423	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 89	com/tencent/mm/vending/g/e:QZT	Z
    //   66: aload_0
    //   67: getfield 94	com/tencent/mm/vending/g/e:QZU	Ljava/util/Queue;
    //   70: checkcast 91	java/util/LinkedList
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 413	com/tencent/mm/vending/g/e:Raa	Lcom/tencent/mm/vending/g/e$a;
    //   78: invokevirtual 426	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 252	com/tencent/mm/vending/g/e:QZZ	Ljava/lang/Object;
    //   86: invokevirtual 146	com/tencent/mm/vending/g/e:el	(Ljava/lang/Object;)V
    //   89: ldc_w 409
    //   92: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 96	com/tencent/mm/vending/g/e:mRetryCount	I
    //   103: ldc_w 409
    //   106: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: goto -14 -> 95
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	e
    //   112	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	95	112	finally
    //   98	109	112	finally
  }
  
  final Object hdC()
  {
    try
    {
      Object localObject1 = this.QZY;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  final void hdD()
  {
    AppMethodBeat.i(201257);
    if (this.QZS != d.Rax)
    {
      AppMethodBeat.o(201257);
      return;
    }
    this.QZS = d.Ray;
    final Object localObject2 = (a)this.QZU.peek();
    if (localObject2 == null)
    {
      if (this.QZR)
      {
        this.QZS = d.RaB;
        this.Ram = hdB();
        this.Raj = true;
        if (this.Rai != null)
        {
          localObject1 = this.Rai.iterator();
          while (((Iterator)localObject1).hasNext()) {
            b((Pair)((Iterator)localObject1).next(), this.Ram);
          }
          AppMethodBeat.o(201257);
        }
      }
      else
      {
        this.QZS = d.Rax;
      }
      AppMethodBeat.o(201257);
      return;
    }
    Object localObject1 = ((a)localObject2).hsM;
    com.tencent.mm.vending.h.d locald = ((a)localObject2).mScheduler;
    long l = ((a)localObject2).mInterval;
    final boolean bool = ((a)localObject2).Rav;
    if (this.QZS == d.Raz)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(201257);
      return;
    }
    this.Rab = ((a)this.QZU.poll());
    this.mSchedulerInvoker.c(locald);
    localObject2 = hdB();
    if (l < 0L)
    {
      this.mSchedulerInvoker.a((com.tencent.mm.vending.c.a)localObject1, localObject2, bool);
      AppMethodBeat.o(201257);
      return;
    }
    this.Raf = g.current();
    this.Raf.arrangeInterval(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74862);
        e.this.mSchedulerInvoker.a(this.Ras, localObject2, bool);
        AppMethodBeat.o(74862);
      }
    }, l);
    AppMethodBeat.o(201257);
  }
  
  public final b hdx()
  {
    return this.Rae;
  }
  
  public final d<_Var> hdy()
  {
    try
    {
      this.QZR = true;
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
    AppMethodBeat.i(258610);
    Dv(true);
    AppMethodBeat.o(258610);
  }
  
  static final class a
  {
    public boolean Rav;
    public com.tencent.mm.vending.c.a hsM;
    public long mInterval;
    public com.tencent.mm.vending.h.d mScheduler;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.hsM = parama;
      this.mScheduler = paramd;
      this.mInterval = paramLong;
      this.Rav = paramBoolean;
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
        if (e.this.QZS != e.d.Raz)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.QZS });
          AppMethodBeat.o(177479);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.el(paramVarArgs);
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole(%s).", new Object[] { e.this, e.ek(e.this.hdC()) });
          resume();
          AppMethodBeat.o(177479);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.J(paramVarArgs);
      }
    }
    
    public final void ej(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.this.QZS == e.d.RaA)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.a(e.this)) && (e.this.QZS != e.d.Raz))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.Dv(false);
        e.this.Rak = true;
        e.this.Ran = paramObject;
        if (e.this.Rah != null)
        {
          Iterator localIterator = e.this.Rah.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(177477);
    }
    
    public final void hdw()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.QZS == e.d.RaA) || (e.this.QZS == e.d.Raw))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.QZS });
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
          e.this.QZS = e.d.Raz;
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.this.QZS != e.d.Raz)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.a(e.this))
        {
          e.this.QZS = e.d.Rax;
          e.this.hdA();
          if (!e.b(e.this)) {
            e.this.hdD();
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.this.QZS = e.d.Ray;
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
      Raw = new d("Idle", 0);
      Rax = new d("Resolved", 1);
      Ray = new d("Invoking", 2);
      Raz = new d("Pausing", 3);
      RaA = new d("Interrupted", 4);
      RaB = new d("AllDone", 5);
      RaC = new d[] { Raw, Rax, Ray, Raz, RaA, RaB };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */