package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.pending.IPendingEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "T", "Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "eventId", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/observer/StorageEventId;Ljava/lang/String;)V", "event", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getEventId", "()Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "getLogTag", "obj", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pendingKey", "getPendingKey", "setPendingKey", "getKey", "mergeEvent", "newEvent", "wechat-sdk_release"})
public class StorageObserverEvent<T>
  implements IPendingEvent
{
  private String event;
  private final StorageEventId eventId;
  private final String logTag;
  private T obj;
  private String pendingKey;
  
  public StorageObserverEvent(StorageEventId paramStorageEventId, String paramString)
  {
    AppMethodBeat.i(190772);
    this.eventId = paramStorageEventId;
    this.logTag = paramString;
    this.pendingKey = "StorageObserverEvent";
    AppMethodBeat.o(190772);
  }
  
  public final String getEvent()
  {
    return this.event;
  }
  
  public final StorageEventId getEventId()
  {
    return this.eventId;
  }
  
  public String getKey()
  {
    return this.pendingKey;
  }
  
  public final String getLogTag()
  {
    return this.logTag;
  }
  
  public final T getObj()
  {
    return this.obj;
  }
  
  public final String getPendingKey()
  {
    return this.pendingKey;
  }
  
  public IPendingEvent mergeEvent(IPendingEvent paramIPendingEvent)
  {
    AppMethodBeat.i(190764);
    p.k(paramIPendingEvent, "newEvent");
    Object localObject2;
    Object localObject1;
    if ((paramIPendingEvent instanceof StorageObserverEvent))
    {
      localObject2 = (StorageObserverEvent)this;
      localObject1 = ((StorageObserverEvent)paramIPendingEvent).eventId;
      Log.i(this.logTag, "oldEvent:[" + ((StorageObserverEvent)localObject2).eventId + ", " + ((StorageObserverEvent)localObject2).getKey() + "] newEvent:[" + ((StorageObserverEvent)paramIPendingEvent).eventId + ", " + paramIPendingEvent.getKey() + ']');
      if ((p.h(((StorageObserverEvent)localObject2).eventId, ((StorageObserverEvent)paramIPendingEvent).eventId)) || (p.h(((StorageObserverEvent)localObject2).eventId, StorageEventId.Companion.getUNKNOWN()))) {
        localObject1 = ((StorageObserverEvent)paramIPendingEvent).eventId;
      }
    }
    for (;;)
    {
      Object localObject3 = new StorageObserverEvent((StorageEventId)localObject1, this.logTag);
      ((StorageObserverEvent)localObject3).event = ((StorageObserverEvent)paramIPendingEvent).event;
      localObject2 = ((StorageObserverEvent)paramIPendingEvent).obj;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Object)) {
        localObject1 = null;
      }
      ((StorageObserverEvent)localObject3).obj = localObject1;
      ((StorageObserverEvent)localObject3).pendingKey = ((StorageObserverEvent)paramIPendingEvent).pendingKey;
      paramIPendingEvent = (IPendingEvent)localObject3;
      AppMethodBeat.o(190764);
      return paramIPendingEvent;
      localObject3 = ((StorageObserverEvent)paramIPendingEvent).eventId;
      if (p.h(localObject3, StorageEventId.Companion.getDELETE()))
      {
        localObject2 = ((StorageObserverEvent)localObject2).eventId;
        if (p.h(localObject2, StorageEventId.Companion.getUPDATE())) {
          localObject1 = StorageEventId.Companion.getDELETE();
        } else if (p.h(localObject2, StorageEventId.Companion.getINSERT())) {
          localObject1 = StorageEventId.Companion.getUNKNOWN();
        }
      }
      else if (p.h(localObject3, StorageEventId.Companion.getINSERT()))
      {
        localObject2 = ((StorageObserverEvent)localObject2).eventId;
        if (p.h(localObject2, StorageEventId.Companion.getDELETE())) {
          localObject1 = StorageEventId.Companion.getUPDATE();
        } else if (p.h(localObject2, StorageEventId.Companion.getUPDATE())) {
          localObject1 = StorageEventId.Companion.getINSERT();
        }
      }
      else if (p.h(localObject3, StorageEventId.Companion.getUPDATE()))
      {
        localObject2 = ((StorageObserverEvent)localObject2).eventId;
        if (p.h(localObject2, StorageEventId.Companion.getDELETE()))
        {
          localObject1 = StorageEventId.Companion.getDELETE();
        }
        else if (p.h(localObject2, StorageEventId.Companion.getINSERT()))
        {
          localObject1 = StorageEventId.Companion.getINSERT();
          continue;
          paramIPendingEvent = (IPendingEvent)this;
          AppMethodBeat.o(190764);
          return paramIPendingEvent;
        }
      }
    }
  }
  
  public final void setEvent(String paramString)
  {
    this.event = paramString;
  }
  
  public final void setObj(T paramT)
  {
    this.obj = paramT;
  }
  
  public final void setPendingKey(String paramString)
  {
    AppMethodBeat.i(190771);
    p.k(paramString, "<set-?>");
    this.pendingKey = paramString;
    AppMethodBeat.o(190771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageObserverEvent
 * JD-Core Version:    0.7.0.1
 */