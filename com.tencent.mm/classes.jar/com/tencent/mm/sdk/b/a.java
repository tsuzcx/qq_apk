package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.d;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
{
  public static a udP = new a();
  private a udO = new a();
  private final HashMap<Integer, LinkedList<c>> udQ = new HashMap();
  private final HashMap<Integer, b> udR = new HashMap();
  
  private void a(LinkedList<c> paramLinkedList, b paramb)
  {
    if (paramb.udV) {
      Collections.sort(paramLinkedList, new Comparator() {});
    }
    c[] arrayOfc = new c[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfc);
    int j = arrayOfc.length;
    int i = 0;
    while ((i < j) && ((!arrayOfc[i].a(paramb)) || (!paramb.udV))) {
      i += 1;
    }
    if (paramb.bFJ != null) {
      paramb.bFJ.run();
    }
  }
  
  /* Error */
  public final boolean T(java.lang.Class<? extends b> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 91
    //   4: aload_1
    //   5: invokestatic 97	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   8: aload_0
    //   9: getfield 42	com/tencent/mm/sdk/b/a:udQ	Ljava/util/HashMap;
    //   12: aload_1
    //   13: invokevirtual 103	java/lang/Class:getName	()Ljava/lang/String;
    //   16: invokevirtual 108	java/lang/String:hashCode	()I
    //   19: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: invokevirtual 118	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 63	java/util/LinkedList
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +19 -> 51
    //   35: aload 4
    //   37: invokevirtual 67	java/util/LinkedList:size	()I
    //   40: istore_2
    //   41: iload_2
    //   42: ifle +9 -> 51
    //   45: iconst_1
    //   46: istore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_3
    //   50: ireturn
    //   51: aload_0
    //   52: getfield 44	com/tencent/mm/sdk/b/a:udR	Ljava/util/HashMap;
    //   55: aload_1
    //   56: invokevirtual 103	java/lang/Class:getName	()Ljava/lang/String;
    //   59: invokevirtual 108	java/lang/String:hashCode	()I
    //   62: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: invokevirtual 118	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 13	com/tencent/mm/sdk/b/a$b
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +17 -> 90
    //   76: aload_1
    //   77: invokevirtual 119	com/tencent/mm/sdk/b/a$b:size	()I
    //   80: istore_2
    //   81: iload_2
    //   82: ifle +8 -> 90
    //   85: iconst_1
    //   86: istore_3
    //   87: goto -40 -> 47
    //   90: iconst_0
    //   91: istore_3
    //   92: goto -45 -> 47
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramClass	java.lang.Class<? extends b>
    //   40	42	2	i	int
    //   46	46	3	bool	boolean
    //   28	8	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	30	95	finally
    //   35	41	95	finally
    //   51	72	95	finally
    //   76	81	95	finally
  }
  
  public final void a(final b paramb, Looper paramLooper)
  {
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramb);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    y.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.cqn()) });
    new ah(paramLooper).post(new Runnable()
    {
      public final void run()
      {
        a.udP.m(paramb);
      }
    });
  }
  
  public final com.tencent.mm.vending.b.b<c> b(c paramc)
  {
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      y.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.cqn()) });
      Object localObject2 = (b)this.udR.get(Integer.valueOf(paramc.cqn()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.udR;
        int i = paramc.cqn();
        localObject1 = new b();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      paramc = ((b)localObject1).a(new com.tencent.mm.vending.b.b(paramc, (com.tencent.mm.vending.b.a)localObject1));
      return paramc;
    }
    finally {}
  }
  
  @Deprecated
  public final boolean c(c paramc)
  {
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      y.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.cqn()) });
      Object localObject2 = (LinkedList)this.udQ.get(Integer.valueOf(paramc.cqn()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.udQ;
        int i = paramc.cqn();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(paramc)) {
        return true;
      }
      ListenerInstanceMonitor.bP(paramc);
      boolean bool = ((LinkedList)localObject1).add(paramc);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public final boolean d(c paramc)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Assert.assertNotNull("EventPoolImpl.remove", paramc);
        y.v("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.cqn()) });
        Object localObject = (LinkedList)this.udQ.get(Integer.valueOf(paramc.cqn()));
        if (localObject != null) {
          bool = ((LinkedList)localObject).remove(paramc);
        }
        localObject = (b)this.udR.get(Integer.valueOf(paramc.cqn()));
        if (localObject != null)
        {
          ((b)localObject).b(new com.tencent.mm.vending.b.b(paramc, (com.tencent.mm.vending.b.a)localObject));
          bool = true;
          ListenerInstanceMonitor.bQ(paramc);
          return bool;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean e(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: aload_1
    //   5: invokestatic 97	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   8: aload_0
    //   9: getfield 42	com/tencent/mm/sdk/b/a:udQ	Ljava/util/HashMap;
    //   12: aload_1
    //   13: invokevirtual 156	com/tencent/mm/sdk/b/c:cqn	()I
    //   16: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: invokevirtual 118	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 63	java/util/LinkedList
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +26 -> 53
    //   30: aload_3
    //   31: invokevirtual 209	java/util/LinkedList:isEmpty	()Z
    //   34: ifne +19 -> 53
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual 178	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq +9 -> 53
    //   47: iconst_1
    //   48: istore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: aload_0
    //   54: getfield 44	com/tencent/mm/sdk/b/a:udR	Ljava/util/HashMap;
    //   57: aload_1
    //   58: invokevirtual 156	com/tencent/mm/sdk/b/c:cqn	()I
    //   61: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: invokevirtual 118	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 13	com/tencent/mm/sdk/b/a$b
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +25 -> 97
    //   75: aload_3
    //   76: invokevirtual 119	com/tencent/mm/sdk/b/a$b:size	()I
    //   79: ifle +18 -> 97
    //   82: aload_3
    //   83: aload_1
    //   84: invokevirtual 210	com/tencent/mm/sdk/b/a$b:contains	(Ljava/lang/Object;)Z
    //   87: istore_2
    //   88: iload_2
    //   89: ifeq +8 -> 97
    //   92: iconst_1
    //   93: istore_2
    //   94: goto -45 -> 49
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -50 -> 49
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	a
    //   0	107	1	paramc	c
    //   42	57	2	bool	boolean
    //   25	58	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	102	finally
    //   30	43	102	finally
    //   53	71	102	finally
    //   75	88	102	finally
  }
  
  public final boolean m(b paramb)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    Assert.assertNotNull("EventPoolImpl.publish", paramb);
    y.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.cqn()) });
    LinkedList localLinkedList = null;
    for (;;)
    {
      try
      {
        int i = paramb.cqn();
        Object localObject = (LinkedList)this.udQ.get(Integer.valueOf(i));
        if (localObject != null)
        {
          localLinkedList = new LinkedList((Collection)localObject);
          bool1 = true;
        }
        localObject = (b)this.udR.get(Integer.valueOf(i));
        if (localObject != null)
        {
          bool1 = bool2;
          if (!bool1) {
            y.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramb, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            a(localLinkedList, paramb);
          }
          if (localObject != null) {
            ((b)localObject).a(f.cj(paramb));
          }
          return bool1;
        }
      }
      finally {}
    }
  }
  
  public static final class a
    extends d
  {
    public final void cancel() {}
    
    public final String getType()
    {
      return Thread.currentThread().toString();
    }
    
    public final void j(Runnable paramRunnable, long paramLong)
    {
      paramRunnable.run();
    }
    
    public final void k(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
  
  private final class b
    extends com.tencent.mm.vending.b.a<c>
  {
    public b()
    {
      super();
    }
    
    public final void a(com.tencent.mm.vending.j.a parama)
    {
      LinkedList localLinkedList = cKT();
      parama = (b)parama.get(0);
      if (parama == null) {
        y.e("MicroMsg.EventCenter", "event is null! fatal!");
      }
      do
      {
        return;
        if (parama.udV) {
          Collections.sort(localLinkedList, new Comparator() {});
        }
        com.tencent.mm.vending.b.b[] arrayOfb = new com.tencent.mm.vending.b.b[localLinkedList.size()];
        localLinkedList.toArray(arrayOfb);
        int j = arrayOfb.length;
        int i = 0;
        while ((i < j) && ((!((c)arrayOfb[i].d).a(parama)) || (!parama.udV))) {
          i += 1;
        }
      } while (parama.bFJ == null);
      parama.bFJ.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */