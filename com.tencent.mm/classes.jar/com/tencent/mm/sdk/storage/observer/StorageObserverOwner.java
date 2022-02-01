package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx.Event;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "()V", "locks", "", "doNotify", "", "originEvent", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Lcom/tencent/mm/sdk/storage/MStorageEx$Event;", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "getLogTag", "", "lock", "unlock", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class StorageObserverOwner<T extends IAutoDBItem>
  extends MvvmObserverOwner<IStorageObserver<T>, StorageObserverEvent<T>>
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.StorageObserverOwner";
  public static final String THREAD_TAG = "Mvvm.StorageObserver";
  private int locks;
  
  static
  {
    AppMethodBeat.i(244264);
    Companion = new Companion(null);
    AppMethodBeat.o(244264);
  }
  
  public final void doNotify(MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(244276);
    s.u(paramMStorageEventData, "originEvent");
    if (this.locks > 0)
    {
      AppMethodBeat.o(244276);
      return;
    }
    Object localObject;
    switch (paramMStorageEventData.eventId)
    {
    default: 
      localObject = StorageEventId.Companion.getUNKNOWN();
      localObject = new StorageObserverEvent((StorageEventId)localObject, getLogTag());
      ((StorageObserverEvent)localObject).setEvent(paramMStorageEventData.event);
      paramMStorageEventData = paramMStorageEventData.obj;
      if (!(paramMStorageEventData instanceof IAutoDBItem)) {
        break;
      }
    }
    for (paramMStorageEventData = (IAutoDBItem)paramMStorageEventData;; paramMStorageEventData = null)
    {
      ((StorageObserverEvent)localObject).setObj(paramMStorageEventData);
      notify(localObject);
      AppMethodBeat.o(244276);
      return;
      localObject = StorageEventId.Companion.getINSERT();
      break;
      localObject = StorageEventId.Companion.getUPDATE();
      break;
      localObject = StorageEventId.Companion.getUPDATE();
      break;
      localObject = StorageEventId.Companion.getDELETE();
      break;
    }
  }
  
  public final void doNotify(MStorageEx.Event paramEvent)
  {
    AppMethodBeat.i(244282);
    s.u(paramEvent, "originEvent");
    Object localObject;
    StorageObserverEvent localStorageObserverEvent;
    switch (paramEvent.event)
    {
    default: 
      localObject = StorageEventId.Companion.getUNKNOWN();
      localStorageObserverEvent = new StorageObserverEvent((StorageEventId)localObject, getLogTag());
      localObject = paramEvent.extraObj;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null)
        {
          paramEvent = paramEvent.obj;
          if (!(paramEvent instanceof IAutoDBItem)) {
            break label181;
          }
        }
      }
      break;
    }
    label181:
    for (paramEvent = (IAutoDBItem)paramEvent;; paramEvent = null)
    {
      localStorageObserverEvent.setObj(paramEvent);
      notify(localStorageObserverEvent);
      AppMethodBeat.o(244282);
      return;
      localObject = StorageEventId.Companion.getINSERT();
      break;
      localObject = StorageEventId.Companion.getUPDATE();
      break;
      localObject = StorageEventId.Companion.getUPDATE();
      break;
      localObject = StorageEventId.Companion.getDELETE();
      break;
      if ((localObject instanceof IAutoDBItem)) {}
      for (localObject = (IAutoDBItem)localObject;; localObject = null)
      {
        localStorageObserverEvent.setObj((IAutoDBItem)localObject);
        localObject = ah.aiuX;
        break;
      }
    }
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner$Companion;", "", "()V", "TAG", "", "THREAD_TAG", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageObserverOwner
 * JD-Core Version:    0.7.0.1
 */