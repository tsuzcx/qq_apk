package com.tencent.mm.sdk.event;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.g.g;
import com.tencent.threadpool.i;
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
  private EventCenter.SilenceNoLooperScheduler mSilenceNoLooperScheduler;
  
  static
  {
    AppMethodBeat.i(125201);
    instance = new EventCenter();
    AppMethodBeat.o(125201);
  }
  
  private EventCenter()
  {
    AppMethodBeat.i(125191);
    this.mSilenceNoLooperScheduler = new EventCenter.SilenceNoLooperScheduler();
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
          AppMethodBeat.i(243255);
          int i = paramAnonymousIListener2.getPriority();
          int j = paramAnonymousIListener1.getPriority();
          AppMethodBeat.o(243255);
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
  
  protected final b<IListener> add(IListener paramIListener)
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
  
  protected final void asyncPublish(IEvent paramIEvent, Looper paramLooper)
  {
    AppMethodBeat.i(125196);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramIEvent);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    new MMHandler(paramLooper).post(new EventCenter..ExternalSyntheticLambda1(this, paramIEvent));
    AppMethodBeat.o(125196);
  }
  
  protected final void asyncPublish(IEvent paramIEvent, String paramString)
  {
    AppMethodBeat.i(243262);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    com.tencent.threadpool.h.ahAA.g(new EventCenter..ExternalSyntheticLambda0(this, paramIEvent), paramString);
    AppMethodBeat.o(243262);
  }
  
  public final void asyncPublish(final IEvent paramIEvent, Executor paramExecutor)
  {
    AppMethodBeat.i(125197);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramIEvent);
    Assert.assertNotNull("EventPoolImpl.asyncPublish executor", paramExecutor);
    Log.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramIEvent, Integer.valueOf(paramIEvent.__getEventID()) });
    paramExecutor.execute(new com.tencent.threadpool.i.h()
    {
      public String getKey()
      {
        AppMethodBeat.i(243256);
        String str = paramIEvent.getClass().getName();
        AppMethodBeat.o(243256);
        return str;
      }
      
      public void run()
      {
        AppMethodBeat.i(125179);
        EventCenter.this.publish(paramIEvent);
        AppMethodBeat.o(125179);
      }
    });
    AppMethodBeat.o(125197);
  }
  
  /* Error */
  public final boolean hadListened(IListener paramIListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 199
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 201
    //   9: aload_1
    //   10: invokestatic 115	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 56	com/tencent/mm/sdk/event/EventCenter:listenersMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 120	com/tencent/mm/sdk/event/IListener:__getEventID	()I
    //   21: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 80	java/util/LinkedList
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +29 -> 61
    //   35: aload_3
    //   36: invokevirtual 204	java/util/LinkedList:isEmpty	()Z
    //   39: ifne +22 -> 61
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 208	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   47: ifeq +14 -> 61
    //   50: ldc 199
    //   52: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_1
    //   56: istore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 58	com/tencent/mm/sdk/event/EventCenter:mCallbacksMap	Ljava/util/HashMap;
    //   65: aload_1
    //   66: invokevirtual 120	com/tencent/mm/sdk/event/IListener:__getEventID	()I
    //   69: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 12	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +28 -> 108
    //   83: aload_3
    //   84: invokevirtual 209	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:size	()I
    //   87: ifle +21 -> 108
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual 210	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:contains	(Ljava/lang/Object;)Z
    //   95: ifeq +13 -> 108
    //   98: ldc 199
    //   100: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -48 -> 57
    //   108: iconst_0
    //   109: istore_2
    //   110: ldc 199
    //   112: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final boolean hasListener(Class<? extends IEvent> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 213
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 215
    //   9: aload_1
    //   10: invokestatic 115	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 56	com/tencent/mm/sdk/event/EventCenter:listenersMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 221	java/lang/Class:getName	()Ljava/lang/String;
    //   21: invokevirtual 226	java/lang/String:hashCode	()I
    //   24: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 80	java/util/LinkedList
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +21 -> 56
    //   38: aload_3
    //   39: invokevirtual 84	java/util/LinkedList:size	()I
    //   42: ifle +14 -> 56
    //   45: ldc 213
    //   47: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 58	com/tencent/mm/sdk/event/EventCenter:mCallbacksMap	Ljava/util/HashMap;
    //   60: aload_1
    //   61: invokevirtual 221	java/lang/Class:getName	()Ljava/lang/String;
    //   64: invokevirtual 226	java/lang/String:hashCode	()I
    //   67: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 12	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +20 -> 98
    //   81: aload_1
    //   82: invokevirtual 209	com/tencent/mm/sdk/event/EventCenter$WxEventsCallbacks:size	()I
    //   85: ifle +13 -> 98
    //   88: ldc 213
    //   90: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_1
    //   94: istore_2
    //   95: goto -43 -> 52
    //   98: iconst_0
    //   99: istore_2
    //   100: ldc 213
    //   102: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -53 -> 52
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	EventCenter
    //   0	113	1	paramClass	Class<? extends IEvent>
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
  
  protected final boolean publish(IEvent paramIEvent)
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
            ((WxEventsCallbacks)localObject).invoke(g.gS(paramIEvent));
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
            AppMethodBeat.i(243259);
            int i = ((IListener)paramAnonymousb2.aguu).getPriority();
            int j = ((IListener)paramAnonymousb1.aguu).getPriority();
            AppMethodBeat.o(243259);
            return i - j;
          }
        });
      }
      b[] arrayOfb = new b[localLinkedList.size()];
      localLinkedList.toArray(arrayOfb);
      int j = arrayOfb.length;
      int i = 0;
      while ((i < j) && ((!((IListener)arrayOfb[i].aguu).callback(parama)) || (!parama.getOrder()))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventCenter
 * JD-Core Version:    0.7.0.1
 */