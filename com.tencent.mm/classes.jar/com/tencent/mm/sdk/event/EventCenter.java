package com.tencent.mm.sdk.event;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public final class EventCenter
{
  private static final String TAG = "MicroMsg.EventCenter";
  public static EventCenter instance;
  private final HashMap<Integer, LinkedList<IListener>> listenersMap;
  private final HashMap<Integer, WxEventsCallbacks> mCallbacksMap;
  private SilenceNoLooperScheduler mSilenceNoLooperScheduler;
  
  static
  {
    AppMethodBeat.i(125201);
    instance = new EventCenter();
    AppMethodBeat.o(125201);
  }
  
  private EventCenter()
  {
    AppMethodBeat.i(125191);
    this.mSilenceNoLooperScheduler = new SilenceNoLooperScheduler();
    this.listenersMap = new HashMap();
    this.mCallbacksMap = new HashMap();
    AppMethodBeat.o(125191);
  }
  
  private void trigger(LinkedList<IListener> paramLinkedList, IEvent paramIEvent)
  {
    AppMethodBeat.i(125200);
    if (paramIEvent.getOrder()) {
      Collections.sort(paramLinkedList, new Comparator()
      {
        public int compare(IListener paramAnonymousIListener1, IListener paramAnonymousIListener2)
        {
          AppMethodBeat.i(248855);
          int i = paramAnonymousIListener2.getPriority();
          int j = paramAnonymousIListener1.getPriority();
          AppMethodBeat.o(248855);
          return i - j;
        }
      });
    }
    IListener[] arrayOfIListener = new IListener[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfIListener);
    int j = arrayOfIListener.length;
    int i = 0;
    while ((i < j) && ((!arrayOfIListener[i].callback(paramIEvent)) || (!paramIEvent.getOrder()))) {
      i += 1;
    }
    if (paramIEvent.callback != null) {
      paramIEvent.callback.run();
    }
    AppMethodBeat.o(125200);
  }
  
  public final b<IListener> add(IListener paramIListener)
  {
    AppMethodBeat.i(125192);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramIListener);
      Log.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramIListener, Integer.valueOf(paramIListener.__getEventID()) });
      Object localObject2 = (WxEventsCallbacks)this.mCallbacksMap.get(Integer.valueOf(paramIListener.__getEventID()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.mCallbacksMap;
        int i = paramIListener.__getEventID();
        localObject1 = new WxEventsCallbacks();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      paramIListener = ((WxEventsCallbacks)localObject1).add(paramIListener);
      return paramIListener;
    }
    finally
    {
      AppMethodBeat.o(125192);
    }
  }
  
  @Deprecated
  public final boolean addListener(IListener paramIListener)
  {
    AppMethodBeat.i(125193);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramIListener);
      Log.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramIListener, Integer.valueOf(paramIListener.__getEventID()) });
      Object localObject2 = (LinkedList)this.listenersMap.get(Integer.valueOf(paramIListener.__getEventID()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.listenersMap;
        int i = paramIListener.__getEventID();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(paramIListener)) {
        return true;
      }
      ListenerInstanceMonitor.markInstanceRegistered(paramIListener);
      boolean bool = ((LinkedList)localObject1).add(paramIListener);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(125193);
    }
  }
  
  public final void asyncPublish(IEvent paramIEvent, Looper paramLooper)
  {
    AppMethodBeat.i(125196);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramIEvent);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    new MMHandler(paramLooper).post(new EventCenter.1(this, paramIEvent));
    AppMethodBeat.o(125196);
  }
  
  public final void asyncPublish(IEvent paramIEvent, Executor paramExecutor)
  {
    AppMethodBeat.i(125197);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramIEvent);
    Assert.assertNotNull("EventPoolImpl.asyncPublish executor", paramExecutor);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    paramExecutor.execute(new EventCenter.2(this, paramIEvent));
    AppMethodBeat.o(125197);
  }
  
  /* Error */
  public final boolean hadListened(IListener paramIListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 200
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 202
    //   9: aload_1
    //   10: invokestatic 114	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/sdk/event/EventCenter:listenersMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 119	com/tencent/mm/sdk/event/IListener:__getEventID	()I
    //   21: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 79	java/util/LinkedList
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +29 -> 61
    //   35: aload_3
    //   36: invokevirtual 205	java/util/LinkedList:isEmpty	()Z
    //   39: ifne +22 -> 61
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 152	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   47: ifeq +14 -> 61
    //   50: ldc 200
    //   52: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_1
    //   56: istore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 57	com/tencent/mm/sdk/event/EventCenter:mCallbacksMap	Ljava/util/HashMap;
    //   65: aload_1
    //   66: invokevirtual 119	com/tencent/mm/sdk/event/IListener:__getEventID	()I
    //   69: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 11	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +28 -> 108
    //   83: aload_3
    //   84: invokevirtual 206	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:size	()I
    //   87: ifle +21 -> 108
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual 207	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:contains	(Ljava/lang/Object;)Z
    //   95: ifeq +13 -> 108
    //   98: ldc 200
    //   100: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -48 -> 57
    //   108: iconst_0
    //   109: istore_2
    //   110: ldc 200
    //   112: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -58 -> 57
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	EventCenter
    //   0	123	1	paramIListener	IListener
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
  
  /* Error */
  public final boolean hasListener(java.lang.Class<? extends IEvent> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 212
    //   9: aload_1
    //   10: invokestatic 114	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/sdk/event/EventCenter:listenersMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 218	java/lang/Class:getName	()Ljava/lang/String;
    //   21: invokevirtual 223	java/lang/String:hashCode	()I
    //   24: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 79	java/util/LinkedList
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +21 -> 56
    //   38: aload_3
    //   39: invokevirtual 83	java/util/LinkedList:size	()I
    //   42: ifle +14 -> 56
    //   45: ldc 210
    //   47: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 57	com/tencent/mm/sdk/event/EventCenter:mCallbacksMap	Ljava/util/HashMap;
    //   60: aload_1
    //   61: invokevirtual 218	java/lang/Class:getName	()Ljava/lang/String;
    //   64: invokevirtual 223	java/lang/String:hashCode	()I
    //   67: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 11	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +20 -> 98
    //   81: aload_1
    //   82: invokevirtual 206	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:size	()I
    //   85: ifle +13 -> 98
    //   88: ldc 210
    //   90: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_1
    //   94: istore_2
    //   95: goto -43 -> 52
    //   98: iconst_0
    //   99: istore_2
    //   100: ldc 210
    //   102: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -53 -> 52
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	EventCenter
    //   0	113	1	paramClass	java.lang.Class<? extends IEvent>
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
  
  public final boolean publish(IEvent paramIEvent)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(125195);
    Assert.assertNotNull("EventPoolImpl.publish", paramIEvent);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    LinkedList localLinkedList = null;
    for (;;)
    {
      try
      {
        int i = paramIEvent.__getEventID();
        Object localObject = (LinkedList)this.listenersMap.get(Integer.valueOf(i));
        if (localObject != null)
        {
          localLinkedList = new LinkedList((Collection)localObject);
          bool1 = true;
        }
        localObject = (WxEventsCallbacks)this.mCallbacksMap.get(Integer.valueOf(i));
        if (localObject != null)
        {
          bool1 = bool2;
          if (!bool1) {
            Log.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramIEvent, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            trigger(localLinkedList, paramIEvent);
          }
          if (localObject != null) {
            ((WxEventsCallbacks)localObject).invoke(g.eu(paramIEvent));
          }
          AppMethodBeat.o(125195);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(125195);
      }
    }
  }
  
  @Deprecated
  public final boolean removeListener(IListener paramIListener)
  {
    boolean bool = false;
    AppMethodBeat.i(125194);
    for (;;)
    {
      try
      {
        Assert.assertNotNull("EventPoolImpl.remove", paramIListener);
        Log.v("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { paramIListener, Integer.valueOf(paramIListener.__getEventID()) });
        Object localObject = (LinkedList)this.listenersMap.get(Integer.valueOf(paramIListener.__getEventID()));
        if (localObject != null) {
          bool = ((LinkedList)localObject).remove(paramIListener);
        }
        localObject = (WxEventsCallbacks)this.mCallbacksMap.get(Integer.valueOf(paramIListener.__getEventID()));
        if (localObject != null)
        {
          ((WxEventsCallbacks)localObject).remove(paramIListener);
          bool = true;
          ListenerInstanceMonitor.markInstanceUnregistered(paramIListener);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(125194);
      }
    }
  }
  
  public static class SilenceNoLooperScheduler
    extends d
  {
    public void arrange(Runnable paramRunnable)
    {
      AppMethodBeat.i(125183);
      paramRunnable.run();
      AppMethodBeat.o(125183);
    }
    
    public void arrangeInterval(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(125184);
      paramRunnable.run();
      AppMethodBeat.o(125184);
    }
    
    public void cancel() {}
    
    public String getType()
    {
      AppMethodBeat.i(125185);
      String str = Thread.currentThread().toString();
      AppMethodBeat.o(125185);
      return str;
    }
  }
  
  class WxEventsCallbacks
    extends com.tencent.mm.vending.b.a<IListener>
  {
    public WxEventsCallbacks()
    {
      super();
      AppMethodBeat.i(125187);
      AppMethodBeat.o(125187);
    }
    
    public b<IListener> add(IListener paramIListener)
    {
      AppMethodBeat.i(125189);
      paramIListener = add(new b(paramIListener, this));
      AppMethodBeat.o(125189);
      return paramIListener;
    }
    
    public void invoke(com.tencent.mm.vending.j.a parama)
    {
      AppMethodBeat.i(125188);
      LinkedList localLinkedList = getQueue();
      parama = (IEvent)parama.get(0);
      if (parama == null)
      {
        Log.e("MicroMsg.EventCenter", "event is null! fatal!");
        AppMethodBeat.o(125188);
        return;
      }
      if (parama.getOrder()) {
        Collections.sort(localLinkedList, new Comparator()
        {
          public int compare(b paramAnonymousb1, b paramAnonymousb2)
          {
            AppMethodBeat.i(248727);
            int i = ((IListener)paramAnonymousb2.YzW).getPriority();
            int j = ((IListener)paramAnonymousb1.YzW).getPriority();
            AppMethodBeat.o(248727);
            return i - j;
          }
        });
      }
      b[] arrayOfb = new b[localLinkedList.size()];
      localLinkedList.toArray(arrayOfb);
      int j = arrayOfb.length;
      int i = 0;
      while ((i < j) && ((!((IListener)arrayOfb[i].YzW).callback(parama)) || (!parama.getOrder()))) {
        i += 1;
      }
      if (parama.callback != null) {
        parama.callback.run();
      }
      AppMethodBeat.o(125188);
    }
    
    public void remove(IListener paramIListener)
    {
      AppMethodBeat.i(125190);
      remove(new b(paramIListener, this));
      AppMethodBeat.o(125190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventCenter
 * JD-Core Version:    0.7.0.1
 */