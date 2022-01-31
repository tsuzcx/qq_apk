package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
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
  private volatile boolean b = false;
  boolean d = false;
  volatile Object h;
  volatile boolean i;
  volatile Object j;
  private int m = 0;
  private long n = -1L;
  private boolean o = false;
  List<Pair<d.a, com.tencent.mm.vending.h.d>> t;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> u;
  private boolean v = false;
  boolean w = false;
  b wtA;
  b wtB;
  private b wtC = new c();
  private com.tencent.mm.vending.h.d wtD;
  f wtE = new f(this.wtz, this.wtF);
  private f.a wtF = new f.a()
  {
    public final void cKZ()
    {
      g localg = g.cLd();
      e locale = e.this;
      Stack localStack2 = (Stack)localg.b.get();
      Stack localStack1 = localStack2;
      if (localStack2 == null)
      {
        localStack1 = new Stack();
        localg.b.set(localStack1);
      }
      localStack1.push(locale);
    }
    
    public final void ch(Object paramAnonymousObject)
    {
      ((Stack)g.cLd().b.get()).pop();
      synchronized (e.this)
      {
        e.this.wtA = e.this.wtB;
        e.this.wtB = null;
        if (!e.this.d)
        {
          e.this.h = paramAnonymousObject;
          if (e.this.wtw == e.d.wtS) {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
          }
        }
        else
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
        }
      }
      if (e.this.wtw == e.d.wtR)
      {
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
        return;
      }
      e.this.wtw = e.d.wtQ;
      e.this.b(e.this.a(paramAnonymousObject));
    }
    
    public final void interrupt()
    {
      e.this.a(true);
    }
  };
  Object wtG;
  volatile d wtw = d.wtP;
  private Queue<b> wtx = new LinkedList();
  private volatile com.tencent.mm.vending.h.d wty = this.wtz;
  private volatile com.tencent.mm.vending.h.d wtz = com.tencent.mm.vending.h.g.cLe();
  private boolean x = false;
  private Object y;
  
  /* Error */
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 128	com/tencent/mm/vending/g/e:a	()V
    //   6: aload_0
    //   7: getfield 85	com/tencent/mm/vending/g/e:wtx	Ljava/util/Queue;
    //   10: new 22	com/tencent/mm/vending/g/e$b
    //   13: dup
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 117	com/tencent/mm/vending/g/e:wty	Lcom/tencent/mm/vending/h/d;
    //   19: aload_0
    //   20: getfield 91	com/tencent/mm/vending/g/e:n	J
    //   23: iload_2
    //   24: invokespecial 131	com/tencent/mm/vending/g/e$b:<init>	(Lcom/tencent/mm/vending/c/a;Lcom/tencent/mm/vending/h/d;JZ)V
    //   27: invokeinterface 137 2 0
    //   32: pop
    //   33: aload_0
    //   34: ldc2_w 88
    //   37: putfield 91	com/tencent/mm/vending/g/e:n	J
    //   40: aload_0
    //   41: getfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   44: astore_1
    //   45: getstatic 76	com/tencent/mm/vending/g/e$d:wtP	Lcom/tencent/mm/vending/g/e$d;
    //   48: astore_3
    //   49: aload_1
    //   50: aload_3
    //   51: if_acmpne +7 -> 58
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: aload_0
    //   59: getfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   62: getstatic 140	com/tencent/mm/vending/g/e$d:wtQ	Lcom/tencent/mm/vending/g/e$d;
    //   65: if_acmpeq +6 -> 71
    //   68: goto -14 -> 54
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 142	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   76: invokevirtual 145	com/tencent/mm/vending/g/e:b	(Ljava/lang/Object;)V
    //   79: goto -25 -> 54
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	e
    //   0	87	1	parama	com.tencent.mm.vending.c.a<_Ret, _Var>
    //   0	87	2	paramBoolean	boolean
    //   48	3	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	49	82	finally
    //   58	68	82	finally
    //   71	79	82	finally
  }
  
  private void a()
  {
    try
    {
      if (this.b) {
        throw new a("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      }
    }
    finally {}
  }
  
  /* Error */
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 157	com/tencent/mm/vending/g/e:cKY	()Lcom/tencent/mm/vending/g/d;
    //   6: pop
    //   7: aload_0
    //   8: getfield 159	com/tencent/mm/vending/g/e:t	Ljava/util/List;
    //   11: ifnonnull +14 -> 25
    //   14: aload_0
    //   15: new 82	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 83	java/util/LinkedList:<init>	()V
    //   22: putfield 159	com/tencent/mm/vending/g/e:t	Ljava/util/List;
    //   25: new 161	android/util/Pair
    //   28: dup
    //   29: aload_1
    //   30: aload_2
    //   31: invokespecial 164	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   34: astore_1
    //   35: aload_0
    //   36: getfield 105	com/tencent/mm/vending/g/e:w	Z
    //   39: ifeq +15 -> 54
    //   42: aload_0
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 166	com/tencent/mm/vending/g/e:wtG	Ljava/lang/Object;
    //   48: invokevirtual 169	com/tencent/mm/vending/g/e:a	(Landroid/util/Pair;Ljava/lang/Object;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 159	com/tencent/mm/vending/g/e:t	Ljava/util/List;
    //   58: aload_1
    //   59: invokeinterface 172 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	e
    //   0	73	1	parama	d.a
    //   0	73	2	paramd	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	25	68	finally
    //   25	51	68	finally
    //   54	65	68	finally
  }
  
  /* Error */
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 157	com/tencent/mm/vending/g/e:cKY	()Lcom/tencent/mm/vending/g/d;
    //   6: pop
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 142	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   12: invokevirtual 145	com/tencent/mm/vending/g/e:b	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: getfield 175	com/tencent/mm/vending/g/e:u	Ljava/util/List;
    //   19: ifnonnull +14 -> 33
    //   22: aload_0
    //   23: new 82	java/util/LinkedList
    //   26: dup
    //   27: invokespecial 83	java/util/LinkedList:<init>	()V
    //   30: putfield 175	com/tencent/mm/vending/g/e:u	Ljava/util/List;
    //   33: new 161	android/util/Pair
    //   36: dup
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial 164	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 103	com/tencent/mm/vending/g/e:v	Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 177	com/tencent/mm/vending/g/e:y	Ljava/lang/Object;
    //   56: invokespecial 179	com/tencent/mm/vending/g/e:b	(Landroid/util/Pair;Ljava/lang/Object;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 175	com/tencent/mm/vending/g/e:u	Ljava/util/List;
    //   66: aload_1
    //   67: invokeinterface 172 2 0
    //   72: pop
    //   73: goto -14 -> 59
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	e
    //   0	81	1	paramb	d.b
    //   0	81	2	paramd	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	33	76	finally
    //   33	59	76	finally
    //   62	73	76	finally
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    try
    {
      final RuntimeException localRuntimeException = new RuntimeException("object is not right: " + paramObject);
      new f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
      {
        private Void cLa()
        {
          try
          {
            ((d.b)paramPair.first).ag(paramObject);
            return wtt;
          }
          catch (ClassCastException localClassCastException)
          {
            if (localRuntimeException.getCause() == null) {
              localRuntimeException.initCause(localClassCastException);
            }
            throw localRuntimeException;
          }
        }
      }, null, this.o);
      return;
    }
    finally
    {
      paramPair = finally;
      throw paramPair;
    }
  }
  
  public c<_Var> a(com.tencent.mm.vending.e.b paramb)
  {
    Assert.assertNotNull("keeper should not be null!", paramb);
    paramb.keep(this);
    return this;
  }
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      y(new Object[0]);
      a(new com.tencent.mm.vending.c.a()
      {
        public final _Var call(_Var paramAnonymous_Var)
        {
          return parama.call();
        }
      }, true);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public c<_Var> a(com.tencent.mm.vending.h.d paramd)
  {
    if (paramd == null)
    {
      Assert.assertNotNull("scheduler should not be null!", paramd);
      return this;
    }
    this.wty = paramd;
    return this;
  }
  
  public final d<_Var> a(d.a parama)
  {
    try
    {
      a(parama, this.wtz);
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
      a(paramb, this.wtz);
      return this;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final d<_Var> a(com.tencent.mm.vending.h.d paramd, d.b<_Var> paramb)
  {
    try
    {
      a(paramb, paramd);
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
        if (this.d)
        {
          this.m += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.wtA.wtO.toString(), Integer.valueOf(this.m) });
          ((LinkedList)this.wtx).add(0, this.wtA);
          this.d = false;
          paramObject = this.h;
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
    try
    {
      com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
      paramPair = new Runnable()
      {
        public final void run()
        {
          ((d.a)paramPair.first).aE(paramObject);
        }
      };
      if (locald == null) {
        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.wtz });
      }
      locald.k(paramPair);
      return;
    }
    finally {}
  }
  
  /* Error */
  final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   6: getstatic 305	com/tencent/mm/vending/g/e$d:wtS	Lcom/tencent/mm/vending/g/e$d;
    //   9: if_acmpeq +17 -> 26
    //   12: aload_0
    //   13: getfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   16: astore_2
    //   17: getstatic 308	com/tencent/mm/vending/g/e$d:wtT	Lcom/tencent/mm/vending/g/e$d;
    //   20: astore_3
    //   21: aload_2
    //   22: aload_3
    //   23: if_acmpne +6 -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: iload_1
    //   30: ifeq +43 -> 73
    //   33: aload_0
    //   34: getfield 85	com/tencent/mm/vending/g/e:wtx	Ljava/util/Queue;
    //   37: invokeinterface 312 1 0
    //   42: ifle +31 -> 73
    //   45: ldc_w 261
    //   48: ldc_w 314
    //   51: iconst_1
    //   52: anewarray 5	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 85	com/tencent/mm/vending/g/e:wtx	Ljava/util/Queue;
    //   61: invokeinterface 312 1 0
    //   66: invokestatic 276	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: invokestatic 316	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getstatic 305	com/tencent/mm/vending/g/e$d:wtS	Lcom/tencent/mm/vending/g/e$d;
    //   77: putfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   80: aload_0
    //   81: getfield 85	com/tencent/mm/vending/g/e:wtx	Ljava/util/Queue;
    //   84: invokeinterface 319 1 0
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 142	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   94: aload_0
    //   95: getfield 321	com/tencent/mm/vending/g/e:wtD	Lcom/tencent/mm/vending/h/d;
    //   98: ifnull -72 -> 26
    //   101: aload_0
    //   102: getfield 321	com/tencent/mm/vending/g/e:wtD	Lcom/tencent/mm/vending/h/d;
    //   105: invokevirtual 324	com/tencent/mm/vending/h/d:cancel	()V
    //   108: goto -82 -> 26
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	e
    //   0	116	1	paramBoolean	boolean
    //   16	6	2	locald1	d
    //   111	4	2	localObject	Object
    //   20	3	3	locald2	d
    // Exception table:
    //   from	to	target	type
    //   2	21	111	finally
    //   33	73	111	finally
    //   73	108	111	finally
  }
  
  public c<_Var> aeJ(String paramString)
  {
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      return this;
    }
    this.wty = com.tencent.mm.vending.h.g.aeL(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.wty);
    return this;
  }
  
  final void b(final Object paramObject)
  {
    Object localObject2;
    label134:
    long l;
    final boolean bool;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = this.wtw;
        localObject2 = d.wtQ;
        if (localObject1 != localObject2) {
          return;
        }
        this.wtw = d.wtw;
        localObject1 = (b)this.wtx.peek();
        if (localObject1 != null) {
          break label134;
        }
        if (this.b)
        {
          this.wtw = d.wtT;
          this.v = true;
          this.y = paramObject;
          if (this.u == null) {
            continue;
          }
          paramObject = this.u.iterator();
          if (paramObject.hasNext())
          {
            b((Pair)paramObject.next(), this.y);
            continue;
          }
          continue;
        }
        this.wtw = d.wtQ;
      }
      finally {}
      continue;
      localObject2 = ((b)localObject1).wtO;
      com.tencent.mm.vending.h.d locald = ((b)localObject1).wtp;
      l = ((b)localObject1).c;
      bool = ((b)localObject1).d;
      if (this.wtw == d.wtR)
      {
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
      }
      else
      {
        this.wtB = ((b)this.wtx.poll());
        this.wtE.b(locald);
        if (l >= 0L) {
          break;
        }
        this.wtE.a((com.tencent.mm.vending.c.a)localObject2, paramObject, bool);
      }
    }
    if (Looper.myLooper() == null) {}
    for (this.wtD = new com.tencent.mm.vending.h.c();; this.wtD = new h(Looper.myLooper(), Looper.myLooper().toString()))
    {
      this.wtD.j(new Runnable()
      {
        public final void run()
        {
          e.this.wtE.a(this.wtO, paramObject, bool);
        }
      }, l);
      break;
    }
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      parama = a(parama, this.o);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final b cKX()
  {
    return this.wtC;
  }
  
  public final d<_Var> cKY()
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
  
  public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    return aeJ("Vending.LOGIC").c(parama);
  }
  
  public void dead()
  {
    a(true);
  }
  
  public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    return aeJ("Vending.HEAVY_WORK").c(parama);
  }
  
  public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    return aeJ("Vending.UI").c(parama);
  }
  
  public c<_Var> ij(long paramLong)
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
  
  public c<_Var> oa(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  /* Error */
  public c<_Var> y(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   6: astore_2
    //   7: getstatic 76	com/tencent/mm/vending/g/e$d:wtP	Lcom/tencent/mm/vending/g/e$d;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpeq +7 -> 20
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: areturn
    //   20: aload_0
    //   21: getstatic 140	com/tencent/mm/vending/g/e$d:wtQ	Lcom/tencent/mm/vending/g/e$d;
    //   24: putfield 78	com/tencent/mm/vending/g/e:wtw	Lcom/tencent/mm/vending/g/e$d;
    //   27: aload_1
    //   28: arraylength
    //   29: ifne +21 -> 50
    //   32: aconst_null
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 142	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 142	com/tencent/mm/vending/g/e:h	Ljava/lang/Object;
    //   44: invokevirtual 145	com/tencent/mm/vending/g/e:b	(Ljava/lang/Object;)V
    //   47: goto -31 -> 16
    //   50: aload_1
    //   51: arraylength
    //   52: iconst_1
    //   53: if_icmpne +10 -> 63
    //   56: aload_1
    //   57: iconst_0
    //   58: aaload
    //   59: astore_1
    //   60: goto -26 -> 34
    //   63: aload_1
    //   64: invokestatic 420	com/tencent/mm/vending/j/k:z	([Ljava/lang/Object;)Lcom/tencent/mm/vending/j/k;
    //   67: astore_1
    //   68: goto -34 -> 34
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	e
    //   0	76	1	paramVarArgs	Object[]
    //   6	6	2	locald1	d
    //   10	3	3	locald2	d
    // Exception table:
    //   from	to	target	type
    //   2	11	71	finally
    //   20	32	71	finally
    //   34	47	71	finally
    //   50	56	71	finally
    //   63	68	71	finally
  }
  
  public static final class a
    extends Error
  {
    public a(String paramString, Object... paramVarArgs)
    {
      super();
    }
  }
  
  private static final class b
  {
    public long c;
    public boolean d;
    public com.tencent.mm.vending.c.a wtO;
    public com.tencent.mm.vending.h.d wtp;
    
    public b(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      this.wtO = parama;
      this.wtp = paramd;
      this.c = paramLong;
      this.d = paramBoolean;
    }
  }
  
  final class c
    implements b
  {
    c() {}
    
    public final void cKW()
    {
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.wtw == e.d.wtS) || (e.this.wtw == e.d.wtP))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.wtw });
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
          e.this.wtw = e.d.wtR;
        }
      }
    }
    
    public final void cg(Object paramObject)
    {
      synchronized (e.this)
      {
        if (e.this.wtw == e.d.wtS)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          return;
        }
        if ((!e.a(e.this)) && (e.this.wtw != e.d.wtR))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          return;
        }
      }
      com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
      e.this.a(false);
      e.this.w = true;
      e.this.wtG = paramObject;
      if (e.this.t != null)
      {
        Iterator localIterator = e.this.t.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          e.this.a(localPair, paramObject);
        }
      }
    }
    
    public final void resume()
    {
      for (;;)
      {
        synchronized (e.this)
        {
          if (e.this.wtw != e.d.wtR)
          {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
            return;
          }
          if (!e.a(e.this))
          {
            e.this.wtw = e.d.wtQ;
            if (!e.b(e.this)) {
              e.this.b(e.this.a(e.this.h));
            }
            return;
          }
        }
        e.this.wtw = e.d.wtw;
      }
    }
    
    public final void x(Object... paramVarArgs)
    {
      for (;;)
      {
        synchronized (e.this)
        {
          if (e.this.wtw != e.d.wtR)
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.wtw });
            return;
          }
          e locale2 = e.this;
          if (paramVarArgs.length == 0)
          {
            paramVarArgs = null;
            locale2.j = paramVarArgs;
            e.this.i = true;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
            resume();
            return;
          }
        }
        if (paramVarArgs.length == 1) {
          paramVarArgs = paramVarArgs[0];
        } else {
          paramVarArgs = k.z(paramVarArgs);
        }
      }
    }
  }
  
  private static enum d
  {
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.e
 * JD-Core Version:    0.7.0.1
 */