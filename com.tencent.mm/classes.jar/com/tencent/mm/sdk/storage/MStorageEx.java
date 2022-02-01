package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class MStorageEx
  implements IStorageEx
{
  public static final int EVENT_CREATE = 1;
  public static final int EVENT_DELETE = 5;
  public static final int EVENT_DROP = 6;
  public static final int EVENT_INSERT = 2;
  public static final int EVENT_QUERY = 7;
  public static final int EVENT_REPLACE = 4;
  public static final int EVENT_UPDATE = 3;
  private final MStorageEvent<IOnStorageChange, Event> defaults = new MStorageEvent()
  {
    protected void processEvent(MStorageEx.IOnStorageChange paramAnonymousIOnStorageChange, MStorageEx.Event paramAnonymousEvent)
    {
      AppMethodBeat.i(230536);
      if (!MStorageEx.this.shouldProcessEvent())
      {
        AppMethodBeat.o(230536);
        return;
      }
      MStorageEx.this.processEvent(paramAnonymousIOnStorageChange, paramAnonymousEvent);
      AppMethodBeat.o(230536);
    }
  };
  
  private void processEvent(IOnStorageChange paramIOnStorageChange, Event paramEvent)
  {
    paramIOnStorageChange.onNotifyChange(paramEvent.event, paramEvent.mstorage, paramEvent.obj);
  }
  
  public void add(IOnStorageChange paramIOnStorageChange)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, Looper.getMainLooper());
    }
  }
  
  public void add(IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, paramLooper);
    }
  }
  
  public void add(IOnStorageChange paramIOnStorageChange, a parama)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.add(paramIOnStorageChange, parama);
    }
  }
  
  public void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    this.defaults.event(new Event(paramInt, paramMStorageEx, paramObject));
    this.defaults.doNotify();
  }
  
  public void remove(IOnStorageChange paramIOnStorageChange)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.remove(paramIOnStorageChange);
    }
  }
  
  protected abstract boolean shouldProcessEvent();
  
  class Event
  {
    int event;
    MStorageEx mstorage;
    Object obj;
    
    Event(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      this.event = paramInt;
      this.obj = paramObject;
      this.mstorage = paramMStorageEx;
    }
  }
  
  public static abstract interface IOnStorageChange
  {
    public abstract void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEx
 * JD-Core Version:    0.7.0.1
 */