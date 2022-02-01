package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.j.a;

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
  public static final int EVENT_UPDATE_WITHOUT_DELAY = 8;
  private final MStorageEvent<MStorageEx.IOnStorageChange, MStorageEx.Event> defaults = new MStorageEvent()
  {
    protected void processEvent(MStorageEx.IOnStorageChange paramAnonymousIOnStorageChange, MStorageEx.Event paramAnonymousEvent)
    {
      AppMethodBeat.i(244241);
      if (!MStorageEx.this.shouldProcessEvent())
      {
        AppMethodBeat.o(244241);
        return;
      }
      MStorageEx.this.processEvent(paramAnonymousIOnStorageChange, paramAnonymousEvent);
      AppMethodBeat.o(244241);
    }
  };
  
  private void processEvent(MStorageEx.IOnStorageChange paramIOnStorageChange, MStorageEx.Event paramEvent)
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
    paramMStorageEx = new MStorageEx.Event(this, paramInt, paramMStorageEx, paramObject, null);
    this.defaults.event(paramMStorageEx);
    this.defaults.doNotify();
  }
  
  public void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject1, Object paramObject2)
  {
    paramMStorageEx = new MStorageEx.Event(this, paramInt, paramMStorageEx, paramObject1, paramObject2);
    this.defaults.event(paramMStorageEx);
    this.defaults.doNotify();
  }
  
  public void doNotify(MStorageEx.Event paramEvent)
  {
    this.defaults.event(paramEvent);
    this.defaults.doNotify();
  }
  
  public void remove(MStorageEx.IOnStorageChange paramIOnStorageChange)
  {
    if (paramIOnStorageChange != null) {
      this.defaults.remove(paramIOnStorageChange);
    }
  }
  
  protected abstract boolean shouldProcessEvent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEx
 * JD-Core Version:    0.7.0.1
 */