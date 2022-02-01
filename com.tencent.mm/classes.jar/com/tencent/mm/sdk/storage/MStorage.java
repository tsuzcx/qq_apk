package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;

public abstract class MStorage
  extends ObservableStorage<Object>
  implements IStorage
{
  private final MStorageEvent<IOnStorageChange, MStorageEventData> defaults = new MStorageEvent()
  {
    protected void processEvent(MStorage.IOnStorageChange paramAnonymousIOnStorageChange, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(192915);
      MStorage.this.processEvent(paramAnonymousIOnStorageChange, paramAnonymousMStorageEventData);
      AppMethodBeat.o(192915);
    }
  };
  private final MStorageEvent<IOnStorageLoaded, String> loadedListener = new MStorageEvent()
  {
    protected void processEvent(MStorage.IOnStorageLoaded paramAnonymousIOnStorageLoaded, String paramAnonymousString)
    {
      AppMethodBeat.i(193769);
      MStorage.this.processLoaded(paramAnonymousIOnStorageLoaded, paramAnonymousString);
      AppMethodBeat.o(193769);
    }
  };
  
  private void processEvent(IOnStorageChange paramIOnStorageChange, MStorageEventData paramMStorageEventData)
  {
    paramIOnStorageChange.onNotifyChange(paramMStorageEventData.event, paramMStorageEventData);
  }
  
  private void processLoaded(IOnStorageLoaded paramIOnStorageLoaded, String paramString)
  {
    paramIOnStorageLoaded.onNotifyLoaded();
  }
  
  public void add(a parama, IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, parama);
  }
  
  public void add(IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, Looper.getMainLooper());
  }
  
  public void add(IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    this.defaults.add(paramIOnStorageChange, paramLooper);
  }
  
  public void add(String paramString, IOnStorageChange paramIOnStorageChange)
  {
    this.defaults.add(paramIOnStorageChange, a.bDn(paramString));
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
    getOwner().doNotify(localMStorageEventData);
  }
  
  public void doNotify(String paramString)
  {
    paramString = new MStorageEventData(paramString);
    this.defaults.event(paramString);
    this.defaults.doNotify();
    getOwner().doNotify(paramString);
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
    getOwner().doNotify(localMStorageEventData);
  }
  
  public void lock()
  {
    this.defaults.lock();
    getOwner().lock();
  }
  
  public int lockCount()
  {
    return this.defaults.lockCount();
  }
  
  public void remove(IOnStorageChange paramIOnStorageChange)
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
    getOwner().unlock();
  }
  
  public static abstract interface IOnStorageChange
  {
    public abstract void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData);
  }
  
  public static abstract interface IOnStorageLoaded
  {
    public abstract void onNotifyLoaded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorage
 * JD-Core Version:    0.7.0.1
 */