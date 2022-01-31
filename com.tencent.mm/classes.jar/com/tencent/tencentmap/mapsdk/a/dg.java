package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class dg
  implements dm
{
  private Context a;
  private boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private Object e = new Object();
  private List<dn> f;
  private long g = 60000L;
  private Runnable h = new dg.1(this);
  private Runnable i = new dg.2(this);
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      cy.f(" db events to up", new Object[0]);
      try
      {
        dq.a(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        cy.a(localThrowable);
      }
    }
  };
  
  public dg(Context paramContext)
  {
    this.a = paramContext;
    this.f = new ArrayList(25);
  }
  
  /* Error */
  private List<dn> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/tencentmap/mapsdk/a/dg:f	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 66	com/tencent/tencentmap/mapsdk/a/dg:f	Ljava/util/List;
    //   13: invokeinterface 76 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 79	com/tencent/tencentmap/mapsdk/a/dg:d	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 61	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 80	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 66	com/tencent/tencentmap/mapsdk/a/dg:f	Ljava/util/List;
    //   49: invokeinterface 84 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 66	com/tencent/tencentmap/mapsdk/a/dg:f	Ljava/util/List;
    //   59: invokeinterface 87 1 0
    //   64: new 89	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 91
    //   70: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 76 1 0
    //   79: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 107	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -60 -> 32
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	dg
    //   25	2	1	bool	boolean
    //   31	43	2	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	95	finally
    //   36	92	95	finally
  }
  
  private void c()
  {
    synchronized (this.e)
    {
      if (!d())
      {
        cy.c(" err su 1R", new Object[0]);
        return;
      }
      List localList = b();
      if ((localList != null) && (localList.size() > 0)) {
        e.a(this.a, localList);
      }
      return;
    }
  }
  
  private boolean d()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    boolean bool = false;
    int k = 0;
    for (;;)
    {
      synchronized (this.d)
      {
        if (!d())
        {
          cy.c(" err su 1R", new Object[0]);
          return;
        }
        Object localObject2 = b();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = e.a(this.a, (List)localObject2);
          dy localdy = dy.a(this.a);
          if (localObject2 != null)
          {
            long l2 = dq.d().g().e();
            long l1 = l2;
            if (e.l(this.a))
            {
              cy.e(" onwifi, so half mSZ " + l2, new Object[0]);
              l1 = l2 / 2L;
            }
            int m = e.j(this.a);
            cy.b("countCommomRecordNum: " + m, new Object[0]);
            if (m >= l1) {
              k = 1;
            }
            if ((k != 0) && (localdy.a()) && (localdy.b()))
            {
              this.j.run();
              cy.e(" common max up", new Object[0]);
            }
          }
          return;
        }
      }
      dk localdk = dq.d().g();
      if (localdk != null) {
        bool = localdk.g();
      }
      if (bool)
      {
        this.j.run();
        cy.e(" common polling up", new Object[0]);
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/tencentmap/mapsdk/a/dg:b	Z
    //   6: iload_1
    //   7: if_icmpeq +50 -> 57
    //   10: iload_1
    //   11: ifeq +49 -> 60
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 32	com/tencent/tencentmap/mapsdk/a/dg:b	Z
    //   19: aload_0
    //   20: invokestatic 130	com/tencent/tencentmap/mapsdk/a/dq:d	()Lcom/tencent/tencentmap/mapsdk/a/dq;
    //   23: invokevirtual 133	com/tencent/tencentmap/mapsdk/a/dq:g	()Lcom/tencent/tencentmap/mapsdk/a/dk;
    //   26: invokevirtual 173	com/tencent/tencentmap/mapsdk/a/dk:d	()I
    //   29: sipush 1000
    //   32: imul
    //   33: i2l
    //   34: putfield 42	com/tencent/tencentmap/mapsdk/a/dg:g	J
    //   37: invokestatic 178	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   40: bipush 102
    //   42: aload_0
    //   43: getfield 49	com/tencent/tencentmap/mapsdk/a/dg:h	Ljava/lang/Runnable;
    //   46: aload_0
    //   47: getfield 42	com/tencent/tencentmap/mapsdk/a/dg:g	J
    //   50: aload_0
    //   51: getfield 42	com/tencent/tencentmap/mapsdk/a/dg:g	J
    //   54: invokevirtual 181	com/tencent/tencentmap/mapsdk/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: invokestatic 178	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   63: bipush 102
    //   65: invokevirtual 183	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   68: invokestatic 178	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   71: bipush 112
    //   73: invokevirtual 183	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   76: aload_0
    //   77: iconst_1
    //   78: invokevirtual 185	com/tencent/tencentmap/mapsdk/a/dg:b	(Z)V
    //   81: aload_0
    //   82: iload_1
    //   83: putfield 32	com/tencent/tencentmap/mapsdk/a/dg:b	Z
    //   86: goto -29 -> 57
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	dg
    //   0	94	1	paramBoolean	boolean
    //   89	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	89	finally
    //   14	57	89	finally
    //   60	86	89	finally
  }
  
  public final boolean a(dn paramdn)
  {
    Object localObject2 = this.c;
    if (paramdn == null) {
      localObject1 = "null";
    }
    try
    {
      for (;;)
      {
        cy.f(" BF eN:%s   isRT:%b ", new Object[] { localObject1, Boolean.valueOf(false) });
        if ((this.a != null) && (paramdn != null) && (this.b)) {
          break;
        }
        cy.d(" err BF 1R", new Object[0]);
        return false;
        localObject1 = paramdn.d();
      }
      if (!d())
      {
        cy.d(" CommonProcess processUA return false, isEnable is false !", new Object[0]);
        return false;
      }
    }
    finally {}
    Object localObject1 = dq.d().g();
    int k = ((dk)localObject1).c();
    this.g = (((dk)localObject1).d() * 1000);
    int m = this.f.size();
    if (m >= k)
    {
      cy.f(" BF mN!", new Object[0]);
      b.a().a(this.h);
      b.a().a(102, this.h, this.g, this.g);
    }
    this.f.add(paramdn);
    if (this.f.size() >= k) {
      cy.c(" err BF 3R! list size:" + m, new Object[0]);
    }
    cy.a("CommonprocessUA:true!", new Object[0]);
    return true;
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 227
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 148	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokespecial 69	com/tencent/tencentmap/mapsdk/a/dg:c	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 178	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   25: aload_0
    //   26: getfield 54	com/tencent/tencentmap/mapsdk/a/dg:i	Ljava/lang/Runnable;
    //   29: invokevirtual 215	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/lang/Runnable;)V
    //   32: goto -13 -> 19
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	dg
    //   0	40	1	paramBoolean	boolean
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
    //   15	19	35	finally
    //   22	32	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dg
 * JD-Core Version:    0.7.0.1
 */