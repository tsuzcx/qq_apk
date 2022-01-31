package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ck
{
  private static ck c = null;
  protected cm a = null;
  protected Context b = null;
  private boolean d = false;
  private int e = 0;
  private dw f = null;
  private Runnable g = null;
  private List<cj> h = new ArrayList(5);
  private SparseArray<dx> i = new SparseArray(5);
  private List<co> j = new ArrayList(5);
  private SparseArray<cp> k = new SparseArray(2);
  private boolean l = false;
  private Runnable m = new ck.1(this);
  
  private ck(Context paramContext)
  {
    this.b = paramContext;
    this.a = cm.a();
    b.a().a(this.m);
    this.f = new dw(paramContext);
    this.g = new cl(paramContext);
    b.a().a(this.g);
  }
  
  public static ck a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new ck(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static dx c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/tencentmap/mapsdk/a/ck:c	Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   6: ifnull +15 -> 21
    //   9: getstatic 34	com/tencent/tencentmap/mapsdk/a/ck:c	Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   12: invokespecial 101	com/tencent/tencentmap/mapsdk/a/ck:k	()Lcom/tencent/tencentmap/mapsdk/a/dx;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aconst_null
    //   22: astore_0
    //   23: goto -7 -> 16
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	8	0	localdx	dx
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  /* Error */
  private dx k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   13: invokevirtual 105	android/util/SparseArray:size	()I
    //   16: ifle +19 -> 35
    //   19: aload_0
    //   20: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   23: iconst_0
    //   24: invokevirtual 109	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   27: checkcast 111	com/tencent/tencentmap/mapsdk/a/dx
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aconst_null
    //   36: astore_1
    //   37: goto -6 -> 31
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ck
    //   30	7	1	localdx	dx
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	40	finally
  }
  
  /* Error */
  private co[] l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/tencentmap/mapsdk/a/ck:j	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 65	com/tencent/tencentmap/mapsdk/a/ck:j	Ljava/util/List;
    //   13: invokeinterface 115 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 65	com/tencent/tencentmap/mapsdk/a/ck:j	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 117	com/tencent/tencentmap/mapsdk/a/co
    //   29: invokeinterface 121 2 0
    //   34: checkcast 123	[Lcom/tencent/tencentmap/mapsdk/a/co;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ck
    //   37	7	1	arrayOfco	co[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private SparseArray<cp> m()
  {
    try
    {
      SparseArray localSparseArray = this.k;
      return localSparseArray;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.e = paramInt;
      cy.f("step:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(int paramInt, dx paramdx)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   6: ifnull +15 -> 21
    //   9: aload_2
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   17: iload_1
    //   18: invokevirtual 143	android/util/SparseArray:remove	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 63	com/tencent/tencentmap/mapsdk/a/ck:i	Landroid/util/SparseArray;
    //   28: iload_1
    //   29: aload_2
    //   30: invokevirtual 147	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   33: aload_2
    //   34: aload_0
    //   35: invokevirtual 150	com/tencent/tencentmap/mapsdk/a/ck:f	()Lcom/tencent/tencentmap/mapsdk/a/dw;
    //   38: invokeinterface 153 2 0
    //   43: pop
    //   44: goto -23 -> 21
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ck
    //   0	52	1	paramInt	int
    //   0	52	2	paramdx	dx
    // Exception table:
    //   from	to	target	type
    //   2	9	47	finally
    //   13	21	47	finally
    //   24	44	47	finally
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    Object localObject = m();
    if (localObject != null)
    {
      localObject = (cp)((SparseArray)localObject).get(paramInt);
      if (localObject != null) {
        ((cp)localObject).a(paramMap);
      }
    }
  }
  
  public final void a(cj paramcj)
  {
    if (paramcj == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.h == null) {
          this.h = new ArrayList();
        }
        if (this.h.contains(paramcj)) {
          continue;
        }
        this.h.add(paramcj);
        int n = j();
        if (g())
        {
          cy.e("add listener should notify app first run! %s", new Object[] { paramcj.toString() });
          b.a().a(new ck.2(paramcj));
        }
        if (n < 2) {
          continue;
        }
        cy.e("add listener should notify app start query! %s", new Object[] { paramcj.toString() });
        b.a().a(new ck.3(paramcj, n));
      }
      finally {}
    }
  }
  
  public final void a(cm paramcm)
  {
    co[] arrayOfco = l();
    if (arrayOfco != null)
    {
      int i1 = arrayOfco.length;
      int n = 0;
      for (;;)
      {
        if (n < i1)
        {
          co localco = arrayOfco[n];
          try
          {
            localco.a(paramcm);
            n += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              cy.a(localThrowable);
              cy.d("com strategy changed error %s", new Object[] { localThrowable.toString() });
            }
          }
        }
      }
    }
  }
  
  public final void a(co paramco)
  {
    if (paramco != null) {}
    try
    {
      if ((this.j != null) && (!this.j.contains(paramco))) {
        this.j.add(paramco);
      }
      return;
    }
    finally
    {
      paramco = finally;
      throw paramco;
    }
  }
  
  public final void a(cp paramcp)
  {
    if (paramcp != null) {}
    try
    {
      if (this.k != null) {
        this.k.put(1, paramcp);
      }
      return;
    }
    finally
    {
      paramcp = finally;
      throw paramcp;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      this.l = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Runnable d()
  {
    try
    {
      Runnable localRunnable = this.g;
      return localRunnable;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final cm e()
  {
    try
    {
      cm localcm = this.a;
      return localcm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final dw f()
  {
    try
    {
      dw localdw = this.f;
      return localdw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean g()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void h()
  {
    try
    {
      this.d = true;
      cy.f("isFirst }%b", new Object[] { Boolean.valueOf(true) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final cj[] i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/tencentmap/mapsdk/a/ck:h	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 58	com/tencent/tencentmap/mapsdk/a/ck:h	Ljava/util/List;
    //   13: invokeinterface 115 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 58	com/tencent/tencentmap/mapsdk/a/ck:h	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 223	com/tencent/tencentmap/mapsdk/a/cj
    //   29: invokeinterface 121 2 0
    //   34: checkcast 225	[Lcom/tencent/tencentmap/mapsdk/a/cj;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ck
    //   37	7	1	arrayOfcj	cj[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public final int j()
  {
    try
    {
      int n = this.e;
      return n;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ck
 * JD-Core Version:    0.7.0.1
 */