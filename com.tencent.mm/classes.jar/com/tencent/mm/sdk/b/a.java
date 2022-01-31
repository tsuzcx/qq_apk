package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.d;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public final class a
{
  public static a ymk;
  private a ymj;
  private final HashMap<Integer, LinkedList<c>> yml;
  private final HashMap<Integer, b> ymm;
  
  static
  {
    AppMethodBeat.i(115166);
    ymk = new a();
    AppMethodBeat.o(115166);
  }
  
  private a()
  {
    AppMethodBeat.i(115156);
    this.ymj = new a();
    this.yml = new HashMap();
    this.ymm = new HashMap();
    AppMethodBeat.o(115156);
  }
  
  private void a(LinkedList<c> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(115165);
    if (paramb.dsj()) {
      Collections.sort(paramLinkedList, new Comparator() {});
    }
    c[] arrayOfc = new c[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfc);
    int j = arrayOfc.length;
    int i = 0;
    while ((i < j) && ((!arrayOfc[i].callback(paramb)) || (!paramb.dsj()))) {
      i += 1;
    }
    if (paramb.callback != null) {
      paramb.callback.run();
    }
    AppMethodBeat.o(115165);
  }
  
  public final void a(final b paramb, Looper paramLooper)
  {
    AppMethodBeat.i(115161);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramb);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    ab.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.__getEventID()) });
    new ak(paramLooper).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115146);
        a.ymk.l(paramb);
        AppMethodBeat.o(115146);
      }
    });
    AppMethodBeat.o(115161);
  }
  
  public final void a(final b paramb, Executor paramExecutor)
  {
    AppMethodBeat.i(115162);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramb);
    Assert.assertNotNull("EventPoolImpl.asyncPublish executor", paramExecutor);
    ab.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.__getEventID()) });
    paramExecutor.execute(new com.tencent.mm.sdk.g.d.b()
    {
      public final String getKey()
      {
        AppMethodBeat.i(115147);
        String str = paramb.getClass().getName();
        AppMethodBeat.o(115147);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(115148);
        a.ymk.l(paramb);
        AppMethodBeat.o(115148);
      }
    });
    AppMethodBeat.o(115162);
  }
  
  /* Error */
  public final boolean aq(Class<? extends b> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 158
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 160
    //   9: aload_1
    //   10: invokestatic 111	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/sdk/b/a:yml	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 166	java/lang/Class:getName	()Ljava/lang/String;
    //   21: invokevirtual 171	java/lang/String:hashCode	()I
    //   24: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 77	java/util/LinkedList
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +21 -> 56
    //   38: aload_3
    //   39: invokevirtual 81	java/util/LinkedList:size	()I
    //   42: ifle +14 -> 56
    //   45: ldc 158
    //   47: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 57	com/tencent/mm/sdk/b/a:ymm	Ljava/util/HashMap;
    //   60: aload_1
    //   61: invokevirtual 166	java/lang/Class:getName	()Ljava/lang/String;
    //   64: invokevirtual 171	java/lang/String:hashCode	()I
    //   67: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 15	com/tencent/mm/sdk/b/a$b
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +20 -> 98
    //   81: aload_1
    //   82: invokevirtual 176	com/tencent/mm/sdk/b/a$b:size	()I
    //   85: ifle +13 -> 98
    //   88: ldc 158
    //   90: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_1
    //   94: istore_2
    //   95: goto -43 -> 52
    //   98: iconst_0
    //   99: istore_2
    //   100: ldc 158
    //   102: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -53 -> 52
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	a
    //   0	113	1	paramClass	Class<? extends b>
    //   51	49	2	bool	boolean
    //   33	6	3	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	34	108	finally
    //   38	50	108	finally
    //   56	77	108	finally
    //   81	93	108	finally
    //   100	105	108	finally
  }
  
  public final com.tencent.mm.vending.b.b<c> b(c paramc)
  {
    AppMethodBeat.i(115157);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      ab.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.__getEventID()) });
      Object localObject2 = (b)this.ymm.get(Integer.valueOf(paramc.__getEventID()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.ymm;
        int i = paramc.__getEventID();
        localObject1 = new b();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      paramc = ((b)localObject1).b(paramc);
      return paramc;
    }
    finally
    {
      AppMethodBeat.o(115157);
    }
  }
  
  @Deprecated
  public final boolean c(c paramc)
  {
    AppMethodBeat.i(115158);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      ab.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.__getEventID()) });
      Object localObject2 = (LinkedList)this.yml.get(Integer.valueOf(paramc.__getEventID()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.yml;
        int i = paramc.__getEventID();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(paramc)) {
        return true;
      }
      ListenerInstanceMonitor.ct(paramc);
      boolean bool = ((LinkedList)localObject1).add(paramc);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(115158);
    }
  }
  
  @Deprecated
  public final boolean d(c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(115159);
    for (;;)
    {
      try
      {
        Assert.assertNotNull("EventPoolImpl.remove", paramc);
        ab.v("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.__getEventID()) });
        Object localObject = (LinkedList)this.yml.get(Integer.valueOf(paramc.__getEventID()));
        if (localObject != null) {
          bool = ((LinkedList)localObject).remove(paramc);
        }
        localObject = (b)this.ymm.get(Integer.valueOf(paramc.__getEventID()));
        if (localObject != null)
        {
          ((b)localObject).f(paramc);
          bool = true;
          ListenerInstanceMonitor.cu(paramc);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(115159);
      }
    }
  }
  
  /* Error */
  public final boolean e(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 229
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 231
    //   9: aload_1
    //   10: invokestatic 111	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/sdk/b/a:yml	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 184	com/tencent/mm/sdk/b/c:__getEventID	()I
    //   21: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 77	java/util/LinkedList
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +29 -> 61
    //   35: aload_3
    //   36: invokevirtual 234	java/util/LinkedList:isEmpty	()Z
    //   39: ifne +22 -> 61
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 201	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   47: ifeq +14 -> 61
    //   50: ldc 229
    //   52: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_1
    //   56: istore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 57	com/tencent/mm/sdk/b/a:ymm	Ljava/util/HashMap;
    //   65: aload_1
    //   66: invokevirtual 184	com/tencent/mm/sdk/b/c:__getEventID	()I
    //   69: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 15	com/tencent/mm/sdk/b/a$b
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +28 -> 108
    //   83: aload_3
    //   84: invokevirtual 176	com/tencent/mm/sdk/b/a$b:size	()I
    //   87: ifle +21 -> 108
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual 235	com/tencent/mm/sdk/b/a$b:contains	(Ljava/lang/Object;)Z
    //   95: ifeq +13 -> 108
    //   98: ldc 229
    //   100: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -48 -> 57
    //   108: iconst_0
    //   109: istore_2
    //   110: ldc 229
    //   112: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -58 -> 57
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	a
    //   0	123	1	paramc	c
    //   56	54	2	bool	boolean
    //   30	61	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	118	finally
    //   35	55	118	finally
    //   61	79	118	finally
    //   83	103	118	finally
    //   110	115	118	finally
  }
  
  public final boolean l(b paramb)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(115160);
    Assert.assertNotNull("EventPoolImpl.publish", paramb);
    ab.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.__getEventID()) });
    LinkedList localLinkedList = null;
    for (;;)
    {
      try
      {
        int i = paramb.__getEventID();
        Object localObject = (LinkedList)this.yml.get(Integer.valueOf(i));
        if (localObject != null)
        {
          localLinkedList = new LinkedList((Collection)localObject);
          bool1 = true;
        }
        localObject = (b)this.ymm.get(Integer.valueOf(i));
        if (localObject != null)
        {
          bool1 = bool2;
          if (!bool1) {
            ab.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramb, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            a(localLinkedList, paramb);
          }
          if (localObject != null) {
            ((b)localObject).a(f.cO(paramb));
          }
          AppMethodBeat.o(115160);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(115160);
      }
    }
  }
  
  public static final class a
    extends d
  {
    public final void cancel() {}
    
    public final String getType()
    {
      AppMethodBeat.i(115151);
      String str = Thread.currentThread().toString();
      AppMethodBeat.o(115151);
      return str;
    }
    
    public final void n(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(115150);
      paramRunnable.run();
      AppMethodBeat.o(115150);
    }
    
    public final void o(Runnable paramRunnable)
    {
      AppMethodBeat.i(115149);
      paramRunnable.run();
      AppMethodBeat.o(115149);
    }
  }
  
  final class b
    extends com.tencent.mm.vending.b.a<c>
  {
    public b()
    {
      super();
      AppMethodBeat.i(115152);
      AppMethodBeat.o(115152);
    }
    
    public final void a(com.tencent.mm.vending.j.a parama)
    {
      AppMethodBeat.i(115153);
      LinkedList localLinkedList = dQj();
      parama = (b)parama.get(0);
      if (parama == null)
      {
        ab.e("MicroMsg.EventCenter", "event is null! fatal!");
        AppMethodBeat.o(115153);
        return;
      }
      if (parama.dsj()) {
        Collections.sort(localLinkedList, new Comparator() {});
      }
      com.tencent.mm.vending.b.b[] arrayOfb = new com.tencent.mm.vending.b.b[localLinkedList.size()];
      localLinkedList.toArray(arrayOfb);
      int j = arrayOfb.length;
      int i = 0;
      while ((i < j) && ((!((c)arrayOfb[i].d).callback(parama)) || (!parama.dsj()))) {
        i += 1;
      }
      if (parama.callback != null) {
        parama.callback.run();
      }
      AppMethodBeat.o(115153);
    }
    
    public final com.tencent.mm.vending.b.b<c> b(c paramc)
    {
      AppMethodBeat.i(115154);
      paramc = a(new com.tencent.mm.vending.b.b(paramc, this));
      AppMethodBeat.o(115154);
      return paramc;
    }
    
    public final void f(c paramc)
    {
      AppMethodBeat.i(115155);
      b(new com.tencent.mm.vending.b.b(paramc, this));
      AppMethodBeat.o(115155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */