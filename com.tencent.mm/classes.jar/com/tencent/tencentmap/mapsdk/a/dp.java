package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dp
  implements dm
{
  private boolean a = false;
  private List<dn> b;
  private Context c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      try
      {
        dp.this.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        cy.a(localThrowable);
      }
    }
  };
  private Runnable e = new dp.2(this);
  
  public dp(Context paramContext)
  {
    this.c = paramContext;
    this.b = Collections.synchronizedList(new ArrayList(25));
  }
  
  /* Error */
  private List<dn> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/tencentmap/mapsdk/a/dp:b	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 52	com/tencent/tencentmap/mapsdk/a/dp:b	Ljava/util/List;
    //   13: invokeinterface 62 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 65	com/tencent/tencentmap/mapsdk/a/dp:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 41	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 66	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 52	com/tencent/tencentmap/mapsdk/a/dp:b	Ljava/util/List;
    //   49: invokeinterface 70 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 52	com/tencent/tencentmap/mapsdk/a/dp:b	Ljava/util/List;
    //   59: invokeinterface 73 1 0
    //   64: new 75	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 77
    //   70: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 62 1 0
    //   79: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 93	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -60 -> 32
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	dp
    //   25	2	1	bool	boolean
    //   31	43	2	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	95	finally
    //   36	92	95	finally
  }
  
  private boolean c()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    List localList = b();
    if ((localList != null) && (localList.size() > 0))
    {
      cy.f(" dsb real events 2 db" + localList.size(), new Object[0]);
      e.a(this.c, localList);
    }
  }
  
  protected final void a()
  {
    if (!c()) {
      cy.c(" err su 1R", new Object[0]);
    }
    List localList;
    do
    {
      return;
      localList = b();
    } while ((localList == null) || (localList.size() <= 0));
    dx localdx = dq.d().f();
    if ((!e.m(this.c)) || (localdx == null))
    {
      cy.f(" dsu real events 2 db" + localList.size(), new Object[0]);
      e.a(this.c, localList);
      return;
    }
    cy.f(" dsu real events 2 up " + localList.size(), new Object[0]);
    localdx.a(new dp.a(this.c, localList));
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/tencentmap/mapsdk/a/dp:a	Z
    //   6: iload_1
    //   7: if_icmpeq +43 -> 50
    //   10: iload_1
    //   11: ifeq +42 -> 53
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 27	com/tencent/tencentmap/mapsdk/a/dp:a	Z
    //   19: invokestatic 116	com/tencent/tencentmap/mapsdk/a/dq:d	()Lcom/tencent/tencentmap/mapsdk/a/dq;
    //   22: invokevirtual 140	com/tencent/tencentmap/mapsdk/a/dq:g	()Lcom/tencent/tencentmap/mapsdk/a/dk;
    //   25: invokevirtual 144	com/tencent/tencentmap/mapsdk/a/dk:b	()I
    //   28: sipush 1000
    //   31: imul
    //   32: i2l
    //   33: lstore_2
    //   34: invokestatic 149	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   37: bipush 103
    //   39: aload_0
    //   40: getfield 32	com/tencent/tencentmap/mapsdk/a/dp:d	Ljava/lang/Runnable;
    //   43: ldc2_w 150
    //   46: lload_2
    //   47: invokevirtual 154	com/tencent/tencentmap/mapsdk/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 149	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   56: bipush 103
    //   58: invokevirtual 156	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   61: aload_0
    //   62: iconst_1
    //   63: invokevirtual 158	com/tencent/tencentmap/mapsdk/a/dp:b	(Z)V
    //   66: aload_0
    //   67: iload_1
    //   68: putfield 27	com/tencent/tencentmap/mapsdk/a/dp:a	Z
    //   71: goto -21 -> 50
    //   74: astore 4
    //   76: aload_0
    //   77: monitorexit
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	dp
    //   0	81	1	paramBoolean	boolean
    //   33	14	2	l	long
    //   74	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	74	finally
    //   14	50	74	finally
    //   53	71	74	finally
  }
  
  public final boolean a(dn paramdn)
  {
    boolean bool = false;
    Object localObject;
    if (paramdn == null) {
      localObject = "null";
    }
    for (;;)
    {
      try
      {
        cy.f(" BF eN:%s   isRT:%b", new Object[] { localObject, Boolean.valueOf(true) });
        if ((this.c == null) || (paramdn == null))
        {
          cy.c("processUA return false, context is null or bean is null !", new Object[0]);
          return bool;
          localObject = paramdn.d();
          continue;
        }
        if (!c())
        {
          cy.c("processUA return false, isEnable is false !", new Object[0]);
          continue;
        }
        localObject = dq.d().g();
      }
      finally {}
      int i = ((dk)localObject).a();
      long l = ((dk)localObject).b() * 1000;
      if ((this.b.size() >= i) || (paramdn.f()))
      {
        cy.f(" BF mN!", new Object[0]);
        b.a().a(this.d);
        b.a().a(103, this.d, l, l);
      }
      this.b.add(paramdn);
      if (this.b.size() >= i) {
        cy.c(" err BF 3R! num:" + this.b.size(), new Object[0]);
      }
      if ("rqd_applaunched".equals(paramdn.d())) {
        b.a().a(this.d);
      }
      cy.a("processUA:true!", new Object[0]);
      bool = true;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 207	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokespecial 55	com/tencent/tencentmap/mapsdk/a/dp:d	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 149	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   25: aload_0
    //   26: getfield 37	com/tencent/tencentmap/mapsdk/a/dp:e	Ljava/lang/Runnable;
    //   29: invokevirtual 186	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/lang/Runnable;)V
    //   32: goto -13 -> 19
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	dp
    //   0	40	1	paramBoolean	boolean
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
    //   15	19	35	finally
    //   22	32	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dp
 * JD-Core Version:    0.7.0.1
 */