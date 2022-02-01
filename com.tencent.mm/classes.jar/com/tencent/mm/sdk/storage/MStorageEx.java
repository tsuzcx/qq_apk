package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;

public abstract class MStorageEx
  extends ObservableStorage<Object>
  implements IStorageEx
{
  public static final int EVENT_CREATE = 1;
  public static final int EVENT_DELETE = 5;
  public static final int EVENT_DROP = 6;
  public static final int EVENT_INSERT = 2;
  public static final int EVENT_QUERY = 7;
  public static final int EVENT_REPLACE = 4;
  public static final int EVENT_UPDATE = 3;
  private final MStorageEvent<MStorageEx.IOnStorageChange, Event> defaults = new MStorageEvent()
  {
    protected void processEvent(MStorageEx.IOnStorageChange paramAnonymousIOnStorageChange, MStorageEx.Event paramAnonymousEvent)
    {
      AppMethodBeat.i(188858);
      if (!MStorageEx.this.shouldProcessEvent())
      {
        AppMethodBeat.o(188858);
        return;
      }
      MStorageEx.this.processEvent(paramAnonymousIOnStorageChange, paramAnonymousEvent);
      AppMethodBeat.o(188858);
    }
  };
  
  private void processEvent(MStorageEx.IOnStorageChange paramIOnStorageChange, Event paramEvent)
  {
    paramIOnStorageChange.onNotifyChange(paramEvent.event, paramEvent.mstorage, paramEvent.obj);
  }
  
  public void add(MStorageEx.IOnStorageChange paramIOnStorageChange)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, Looper.getMainLooper());
    }
  }
  
  public void add(MStorageEx.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, paramLooper);
    }
  }
  
  public void add(MStorageEx.IOnStorageChange paramIOnStorageChange, a parama)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, parama);
    }
  }
  
  public void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    paramMStorageEx = new Event(paramInt, paramMStorageEx, paramObject, null);
    this.defaults.event(paramMStorageEx);
    this.defaults.doNotify();
    getOwner().doNotify(paramMStorageEx);
  }
  
  public void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject1, Object paramObject2)
  {
    paramMStorageEx = new Event(paramInt, paramMStorageEx, paramObject1, paramObject2);
    this.defaults.event(paramMStorageEx);
    this.defaults.doNotify();
    getOwner().doNotify(paramMStorageEx);
  }
  
  public void remove(MStorageEx.IOnStorageChange paramIOnStorageChange)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.remove(paramIOnStorageChange);
    }
  }
  
  protected abstract boolean shouldProcessEvent();
  
  public class Event
  {
    public int event;
    public Object extraObj;
    public MStorageEx mstorage;
    public Object obj;
    
    Event(int paramInt, MStorageEx paramMStorageEx, Object paramObject1, Object paramObject2)
    {
      this.event = paramInt;
      this.obj = paramObject1;
      this.mstorage = paramMStorageEx;
      this.extraObj = paramObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEx
 * JD-Core Version:    0.7.0.1
 */