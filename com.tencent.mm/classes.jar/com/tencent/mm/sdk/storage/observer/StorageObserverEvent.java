package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.pending.IPendingEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "eventId", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/observer/StorageEventId;Ljava/lang/String;)V", "event", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getEventId", "()Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "getLogTag", "obj", "getObj", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "setObj", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)V", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "pendingKey", "getPendingKey", "setPendingKey", "getKey", "mergeEvent", "newEvent", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class StorageObserverEvent<T extends IAutoDBItem>
  implements IPendingEvent
{
  private String event;
  private final StorageEventId eventId;
  private final String logTag;
  private T obj;
  private String pendingKey;
  
  public StorageObserverEvent(StorageEventId paramStorageEventId, String paramString)
  {
    AppMethodBeat.i(244263);
    this.eventId = paramStorageEventId;
    this.logTag = paramString;
    this.pendingKey = "StorageObserverEvent";
    AppMethodBeat.o(244263);
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
    AppMethodBeat.i(244285);
    s.u(paramIPendingEvent, "newEvent");
    Object localObject1;
    if ((paramIPendingEvent instanceof StorageObserverEvent))
    {
      localObject1 = ((StorageObserverEvent)paramIPendingEvent).eventId;
      Log.i(this.logTag, "oldEvent:[" + this.eventId + ", " + getKey() + "] newEvent:[" + ((StorageObserverEvent)paramIPendingEvent).eventId + ", " + paramIPendingEvent.getKey() + ']');
      if ((s.p(this.eventId, ((StorageObserverEvent)paramIPendingEvent).eventId)) || (s.p(this.eventId, StorageEventId.Companion.getUNKNOWN()))) {
        localObject1 = ((StorageObserverEvent)paramIPendingEvent).eventId;
      }
    }
    label423:
    for (;;)
    {
      Object localObject2 = new StorageObserverEvent((StorageEventId)localObject1, this.logTag);
      ((StorageObserverEvent)localObject2).setEvent(((StorageObserverEvent)paramIPendingEvent).getEvent());
      localObject1 = ((StorageObserverEvent)paramIPendingEvent).getObj();
      if ((localObject1 instanceof IAutoDBItem)) {}
      for (;;)
      {
        ((StorageObserverEvent)localObject2).setObj((IAutoDBItem)localObject1);
        ((StorageObserverEvent)localObject2).setPendingKey(((StorageObserverEvent)paramIPendingEvent).getPendingKey());
        paramIPendingEvent = (IPendingEvent)localObject2;
        AppMethodBeat.o(244285);
        return paramIPendingEvent;
        localObject2 = ((StorageObserverEvent)paramIPendingEvent).eventId;
        if (s.p(localObject2, StorageEventId.Companion.getDELETE()))
        {
          localObject2 = this.eventId;
          if (s.p(localObject2, StorageEventId.Companion.getUPDATE()))
          {
            localObject1 = StorageEventId.Companion.getDELETE();
            break;
          }
          if (!s.p(localObject2, StorageEventId.Companion.getINSERT())) {
            break label423;
          }
          localObject1 = StorageEventId.Companion.getUNKNOWN();
          break;
        }
        if (s.p(localObject2, StorageEventId.Companion.getINSERT()))
        {
          localObject2 = this.eventId;
          if (s.p(localObject2, StorageEventId.Companion.getDELETE()))
          {
            localObject1 = StorageEventId.Companion.getUPDATE();
            break;
          }
          if (!s.p(localObject2, StorageEventId.Companion.getUPDATE())) {
            break label423;
          }
          localObject1 = StorageEventId.Companion.getINSERT();
          break;
        }
        if (!s.p(localObject2, StorageEventId.Companion.getUPDATE())) {
          break label423;
        }
        localObject2 = this.eventId;
        if (s.p(localObject2, StorageEventId.Companion.getDELETE()))
        {
          localObject1 = StorageEventId.Companion.getDELETE();
          break;
        }
        if (!s.p(localObject2, StorageEventId.Companion.getINSERT())) {
          break label423;
        }
        localObject1 = StorageEventId.Companion.getINSERT();
        break;
        localObject1 = null;
      }
      paramIPendingEvent = (IPendingEvent)this;
      AppMethodBeat.o(244285);
      return paramIPendingEvent;
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
    AppMethodBeat.i(244310);
    s.u(paramString, "<set-?>");
    this.pendingKey = paramString;
    AppMethodBeat.o(244310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageObserverEvent
 * JD-Core Version:    0.7.0.1
 */