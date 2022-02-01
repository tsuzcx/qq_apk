package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.j.a;

public abstract class MStorage
  implements IStorage
{
  private final MStorageEvent<MStorage.IOnStorageChange, MStorageEventData> defaults = new MStorageEvent()
  {
    protected void processEvent(MStorage.IOnStorageChange paramAnonymousIOnStorageChange, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(244218);
      MStorage.this.processEvent(paramAnonymousIOnStorageChange, paramAnonymousMStorageEventData);
      AppMethodBeat.o(244218);
    }
  };
  private final MStorageEvent<IOnStorageLoaded, String> loadedListener = new MStorageEvent()
  {
    protected void processEvent(MStorage.IOnStorageLoaded paramAnonymousIOnStorageLoaded, String paramAnonymousString)
    {
      AppMethodBeat.i(244219);
      MStorage.this.processLoaded(paramAnonymousIOnStorageLoaded, paramAnonymousString);
      AppMethodBeat.o(244219);
    }
  };
  
  private void processEvent(MStorage.IOnStorageChange paramIOnStorageChange, MStorageEventData paramMStorageEventData)
  {
    paramIOnStorageChange.onNotifyChange(paramMStorageEventData.event, paramMStorageEventData);
  }
  
  private void processLoaded(IOnStorageLoaded paramIOnStorageLoaded, String paramString)
  {
    paramIOnStorageLoaded.onNotifyLoaded();
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, Looper.getMainLooper());
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    this.defaults.add(paramIOnStorageChange, paramLooper);
  }
  
  public void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, parama);
  }
  
  public void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, a.bFV(paramString));
  }
  
  public void addLoadedListener(IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.loadedListener.add(paramIOnStorageLoaded, Looper.getMainLooper());
  }
  
  public void doNotify()
  {
    MStorageEventData localMStorageEventData = new MStorageEventData("*");
    this.defaults.event(localMStorageEventData);
    this.defaults.doNotify();
  }
  
  public void doNotify(String paramString)
  {
    paramString = new MStorageEventData(paramString);
    this.defaults.event(paramString);
    this.defaults.doNotify();
  }
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    MStorageEventData localMStorageEventData = new MStorageEventData();
    localMStorageEventData.event = paramString;
    localMStorageEventData.eventId = paramInt;
    localMStorageEventData.obj = paramObject;
    localMStorageEventData.stg = this;
    this.defaults.event(localMStorageEventData);
    this.defaults.doNotify();
  }
  
  public void lock()
  {
    this.defaults.lock();
  }
  
  public int lockCount()
  {
    return this.defaults.lockCount();
  }
  
  public void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.remove(paramIOnStorageChange);
  }
  
  public void removeLoadedListener(IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.loadedListener.remove(paramIOnStorageLoaded);
  }
  
  public void unlock()
  {
    this.defaults.unlock();
  }
  
  public static abstract interface IOnStorageLoaded
  {
    public abstract void onNotifyLoaded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorage
 * JD-Core Version:    0.7.0.1
 */