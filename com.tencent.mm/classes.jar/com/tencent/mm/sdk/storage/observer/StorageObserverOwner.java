package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.observer.LifecycleObserverOwner;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx.Event;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "()V", "locks", "", "doNotify", "", "originEvent", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Lcom/tencent/mm/sdk/storage/MStorageEx$Event;", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "getDefaultThreadTag", "", "getLogTag", "lock", "unlock", "Companion", "wechat-sdk_release"})
public class StorageObserverOwner<T>
  extends LifecycleObserverOwner<IStorageObserver<T>, StorageObserverEvent<T>>
{
  public static final StorageObserverOwner.Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.StorageObserverOwner";
  public static final String THREAD_TAG = "Mvvm.StorageObserver";
  private int locks;
  
  static
  {
    AppMethodBeat.i(190186);
    Companion = new StorageObserverOwner.Companion(null);
    AppMethodBeat.o(190186);
  }
  
  public final void doNotify(MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(190174);
    p.k(paramMStorageEventData, "originEvent");
    if (this.locks > 0)
    {
      AppMethodBeat.o(190174);
      return;
    }
    Object localObject;
    switch (paramMStorageEventData.eventId)
    {
    default: 
      localObject = StorageEventId.Companion.getUNKNOWN();
    }
    for (;;)
    {
      StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent((StorageEventId)localObject, getLogTag());
      localStorageObserverEvent.setEvent(paramMStorageEventData.event);
      localObject = paramMStorageEventData.obj;
      paramMStorageEventData = (MStorageEventData)localObject;
      if (!(localObject instanceof Object)) {
        paramMStorageEventData = null;
      }
      localStorageObserverEvent.setObj(paramMStorageEventData);
      notify(localStorageObserverEvent);
      AppMethodBeat.o(190174);
      return;
      localObject = StorageEventId.Companion.getINSERT();
      continue;
      localObject = StorageEventId.Companion.getUPDATE();
      continue;
      localObject = StorageEventId.Companion.getUPDATE();
      continue;
      localObject = StorageEventId.Companion.getDELETE();
    }
  }
  
  public final void doNotify(MStorageEx.Event paramEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190180);
    p.k(paramEvent, "originEvent");
    Object localObject1;
    switch (paramEvent.event)
    {
    default: 
      localObject1 = StorageEventId.Companion.getUNKNOWN();
    }
    StorageObserverEvent localStorageObserverEvent;
    for (;;)
    {
      localStorageObserverEvent = new StorageObserverEvent((StorageEventId)localObject1, getLogTag());
      localObject1 = paramEvent.extraObj;
      if (localObject1 == null) {
        break;
      }
      paramEvent = (MStorageEx.Event)localObject1;
      if (!(localObject1 instanceof Object)) {
        paramEvent = null;
      }
      localStorageObserverEvent.setObj(paramEvent);
      notify(localStorageObserverEvent);
      AppMethodBeat.o(190180);
      return;
      localObject1 = StorageEventId.Companion.getINSERT();
      continue;
      localObject1 = StorageEventId.Companion.getUPDATE();
      continue;
      localObject1 = StorageEventId.Companion.getUPDATE();
      continue;
      localObject1 = StorageEventId.Companion.getDELETE();
    }
    paramEvent = paramEvent.obj;
    if (!(paramEvent instanceof Object)) {
      paramEvent = localObject2;
    }
    for (;;)
    {
      localStorageObserverEvent.setObj(paramEvent);
      break;
    }
  }
  
  public String getDefaultThreadTag()
  {
    return "Mvvm.StorageObserver";
  }
  
  public String getLogTag()
  {
    return "MicroMsg.Mvvm.StorageObserverOwner";
  }
  
  public final void lock()
  {
    this.locks += 1;
  }
  
  public final void unlock()
  {
    this.locks -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageObserverOwner
 * JD-Core Version:    0.7.0.1
 */