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
  com.tencent.mm.vending.h.f LhJ;
  public volatile boolean LhW;
  volatile d LhX;
  boolean LhY;
  private Queue<a> LhZ;
  private volatile com.tencent.mm.vending.h.d Lia;
  private volatile com.tencent.mm.vending.h.d Lib;
  volatile Object Lic;
  volatile boolean Lid;
  volatile Object Lie;
  a Lif;
  a Lig;
  private long Lih;
  private boolean Lii;
  private b Lij;
  private com.tencent.mm.vending.h.d Lik;
  private f.a Lil;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> Lim;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> Lin;
  private boolean Lio;
  boolean Lip;
  private boolean Liq;
  private Object Lir;
  Object Lis;
  private int mRetryCount;
  
  public e()
  {
    AppMethodBeat.i(74826);
    this.LhW = false;
    this.LhX = d.LiB;
    this.LhY = false;
    this.LhZ = new LinkedList();
    this.mRetryCount = 0;
    this.Lih = -1L;
    this.Lii = false;
    this.Lij = new b();
    this.Lil = new f.a()
    {
      public final void eh(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74856);
        ((Stack)f.fOe().LiJ.get()).pop();
        synchronized (e.this)
        {
          e.this.Lif = e.this.Lig;
          e.this.Lig = null;
          if (!e.this.LhY)
          {
            e.this.Lic = paramAnonymousObject;
            if (e.this.LhX == e.d.LiF)
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
        if (e.this.LhX == e.d.LiE)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
          AppMethodBeat.o(74856);
          return;
        }
        e.this.LhX = e.d.LiC;
        e.this.eg(e.this.ef(paramAnonymousObject));
        AppMethodBeat.o(74856);
      }
      
      public final void fOd()
      {
        AppMethodBeat.i(74855);
        f localf = f.fOe();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.LiJ.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.LiJ.set(localStack1);
        }
        localStack1.push(locale);
        AppMethodBeat.o(74855);
      }
      
      public final void interrupt()
      {
        AppMethodBeat.i(74857);
        e.this.yY(true);
        AppMethodBeat.o(74857);
      }
    };
    this.Lio = false;
    this.Lip = false;
    this.Liq = false;
    this.Lib = g.fOh();
    this.Lia = this.Lib;
    this.LhJ = new com.tencent.mm.vending.h.f(this.Lib, this.Lil);
    AppMethodBeat.o(74826);
  }
  
  private c<_Var> I(Object... paramVarArgs)
  {
    AppMethodBeat.i(177484);
    if (this.LhX != d.LiB)
    {
      AppMethodBeat.o(177484);
      return this;
    }
    this.LhX = d.LiC;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    }
    for (;;)
    {
      this.Lic = paramVarArgs;
      eg(this.Lic);
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
    fOc();
    this.LhZ.add(new a(parama, this.Lia, this.Lih, paramBoolean));
    this.Lih = -1L;
    if (this.LhX == d.LiB)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    if (this.LhX != d.LiC)
    {
      AppMethodBeat.o(74837);
      return this;
    }
    eg(this.Lic);
    AppMethodBeat.o(74837);
    return this;
  }
  
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74842);
    this.LhW = true;
    if (this.Lim == null) {
      this.Lim = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.Lip)
    {
      a(parama, this.Lis);
      AppMethodBeat.o(74842);
      return;
    }
    this.Lim.add(parama);
    AppMethodBeat.o(74842);
  }
  
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(74843);
    this.LhW = true;
    eg(this.Lic);
    if (this.Lin == null) {
      this.Lin = new LinkedList();
    }
    paramb = new Pair(paramb, paramd);
    if (this.Lio)
    {
      b(paramb, this.Lir);
      AppMethodBeat.o(74843);
      return;
    }
    this.Lin.add(paramb);
    AppMethodBeat.o(74843);
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    AppMethodBeat.i(177486);
    final RuntimeException localRuntimeException = new RuntimeException("object is not right: ".concat(String.valueOf(paramObject)));
    new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
    {
      private Void aYJ()
      {
        AppMethodBeat.i(177476);
        try
        {
          ((d.b)paramPair.first).bq(paramObject);
          Void localVoid = LhQ;
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
    }, null, this.Lii);
    AppMethodBeat.o(177486);
  }
  
  private void fOc()
  {
    AppMethodBeat.i(177485);
    if (this.LhW)
    {
      c localc = new c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      AppMethodBeat.o(177485);
      throw localc;
    }
    AppMethodBeat.o(177485);
  }
  
  public c<_Var> Et(long paramLong)
  {
    try
    {
      this.Lih = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      a(parama, this.Lib);
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
      a(paramb, this.Lib);
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
      com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.Lib });
      AppMethodBeat.o(74840);
      return;
    }
    locald.w(paramPair);
    AppMethodBeat.o(74840);
  }
  
  public c<_Var> aXY(String paramString)
  {
    AppMethodBeat.i(74827);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      AppMethodBeat.o(74827);
      return this;
    }
    this.Lia = g.aYa(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.Lia);
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
    this.Lia = paramd;
    AppMethodBeat.o(74828);
    return this;
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      AppMethodBeat.i(74838);
      parama = a(parama, this.Lii);
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
    parama = aXY("Vending.LOGIC").c(parama);
    AppMethodBeat.o(74835);
    return parama;
  }
  
  public void dead()
  {
    AppMethodBeat.i(74833);
    yY(true);
    AppMethodBeat.o(74833);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74836);
    parama = aXY("Vending.HEAVY_WORK").c(parama);
    AppMethodBeat.o(74836);
    return parama;
  }
  
  final Object ef(Object paramObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177488);
        if (this.LhY)
        {
          this.mRetryCount += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.Lif.gDr.toString(), Integer.valueOf(this.mRetryCount) });
          ((LinkedList)this.LhZ).add(0, this.Lif);
          this.LhY = false;
          paramObject = this.Lic;
          AppMethodBeat.o(177488);
          return paramObject;
        }
        if (this.Lid)
        {
          this.Lic = this.Lie;
          this.Lie = null;
          this.Lid = false;
          this.mRetryCount = 0;
        }
        else
        {
          this.Lic = paramObject;
        }
      }
      finally {}
    }
  }
  
  final void eg(final Object paramObject)
  {
    AppMethodBeat.i(177489);
    if (this.LhX != d.LiC)
    {
      AppMethodBeat.o(177489);
      return;
    }
    this.LhX = d.LiD;
    a locala = (a)this.LhZ.peek();
    if (locala == null)
    {
      if (this.LhW)
      {
        this.LhX = d.LiG;
        this.Lio = true;
        this.Lir = paramObject;
        if (this.Lin != null)
        {
          paramObject = this.Lin.iterator();
          while (paramObject.hasNext()) {
            b((Pair)paramObject.next(), this.Lir);
          }
          AppMethodBeat.o(177489);
        }
      }
      else
      {
        this.LhX = d.LiC;
      }
      AppMethodBeat.o(177489);
      return;
    }
    final com.tencent.mm.vending.c.a locala1 = locala.gDr;
    com.tencent.mm.vending.h.d locald = locala.cTQ;
    long l = locala.mInterval;
    final boolean bool = locala.LiA;
    if (this.LhX == d.LiE)
    {
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
      AppMethodBeat.o(177489);
      return;
    }
    this.Lig = ((a)this.LhZ.poll());
    this.LhJ.c(locald);
    if (l < 0L)
    {
      this.LhJ.a(locala1, paramObject, bool);
      AppMethodBeat.o(177489);
      return;
    }
    this.Lik = g.fOh();
    this.Lik.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74862);
        e.this.LhJ.a(locala1, paramObject, bool);
        AppMethodBeat.o(74862);
      }
    }, l);
    AppMethodBeat.o(177489);
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    AppMethodBeat.i(74834);
    parama = aXY("Vending.UI").c(parama);
    AppMethodBeat.o(74834);
    return parama;
  }
  
  public final b fOa()
  {
    return this.Lij;
  }
  
  public final d<_Var> fOb()
  {
    try
    {
      this.LhW = true;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public c<_Var> yX(boolean paramBoolean)
  {
    try
    {
      this.Lii = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void yY(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 437
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 87	com/tencent/mm/vending/g/e:LhX	Lcom/tencent/mm/vending/g/e$d;
    //   12: getstatic 440	com/tencent/mm/vending/g/e$d:LiF	Lcom/tencent/mm/vending/g/e$d;
    //   15: if_acmpeq +13 -> 28
    //   18: aload_0
    //   19: getfield 87	com/tencent/mm/vending/g/e:LhX	Lcom/tencent/mm/vending/g/e$d;
    //   22: getstatic 384	com/tencent/mm/vending/g/e$d:LiG	Lcom/tencent/mm/vending/g/e$d;
    //   25: if_acmpne +12 -> 37
    //   28: ldc_w 437
    //   31: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iload_1
    //   38: ifeq +43 -> 81
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/vending/g/e:LhZ	Ljava/util/Queue;
    //   45: invokeinterface 444 1 0
    //   50: ifle +31 -> 81
    //   53: ldc_w 278
    //   56: ldc_w 446
    //   59: iconst_1
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/vending/g/e:LhZ	Ljava/util/Queue;
    //   69: invokeinterface 444 1 0
    //   74: invokestatic 364	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 448	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getstatic 440	com/tencent/mm/vending/g/e$d:LiF	Lcom/tencent/mm/vending/g/e$d;
    //   85: putfield 87	com/tencent/mm/vending/g/e:LhX	Lcom/tencent/mm/vending/g/e$d;
    //   88: aload_0
    //   89: getfield 94	com/tencent/mm/vending/g/e:LhZ	Ljava/util/Queue;
    //   92: invokeinterface 451 1 0
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 144	com/tencent/mm/vending/g/e:Lic	Ljava/lang/Object;
    //   102: aload_0
    //   103: getfield 419	com/tencent/mm/vending/g/e:Lik	Lcom/tencent/mm/vending/h/d;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 419	com/tencent/mm/vending/g/e:Lik	Lcom/tencent/mm/vending/h/d;
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
    public boolean LiA;
    public com.tencent.mm.vending.h.d cTQ;
    public com.tencent.mm.vending.c.a gDr;
    public long mInterval;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.gDr = parama;
      this.cTQ = paramd;
      this.mInterval = paramLong;
      this.LiA = paramBoolean;
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
        if (e.this.LhX != e.d.LiE)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.LhX });
          AppMethodBeat.o(177479);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.Lie = paramVarArgs;
          e.this.Lid = true;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
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
    
    public final void ee(Object paramObject)
    {
      AppMethodBeat.i(177477);
      synchronized (e.this)
      {
        if (e.this.LhX == e.d.LiF)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        if ((!e.a(e.this)) && (e.this.LhX != e.d.LiE))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          AppMethodBeat.o(177477);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.yY(false);
        e.this.Lip = true;
        e.this.Lis = paramObject;
        if (e.this.Lim != null)
        {
          Iterator localIterator = e.this.Lim.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      AppMethodBeat.o(177477);
    }
    
    public final void fNZ()
    {
      AppMethodBeat.i(177478);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.LhX == e.d.LiF) || (e.this.LhX == e.d.LiB))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.LhX });
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
          e.this.LhX = e.d.LiE;
        }
      }
    }
    
    public final void resume()
    {
      AppMethodBeat.i(177480);
      synchronized (e.this)
      {
        if (e.this.LhX != e.d.LiE)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          AppMethodBeat.o(177480);
          return;
        }
        if (!e.a(e.this))
        {
          e.this.LhX = e.d.LiC;
          if (!e.b(e.this)) {
            e.this.eg(e.this.ef(e.this.Lic));
          }
          AppMethodBeat.o(177480);
          return;
        }
        e.this.LhX = e.d.LiD;
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
      LiB = new d("Idle", 0);
      LiC = new d("Resolved", 1);
      LiD = new d("Invoking", 2);
      LiE = new d("Pausing", 3);
      LiF = new d("Interrupted", 4);
      LiG = new d("AllDone", 5);
      LiH = new d[] { LiB, LiC, LiD, LiE, LiF, LiG };
      AppMethodBeat.o(177483);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */