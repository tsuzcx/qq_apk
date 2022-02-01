package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.e.j.a;

public abstract interface IStorage
{
  public abstract void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void add(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper);
  
  public abstract void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded);
  
  public abstract void doNotify();
  
  public abstract void doNotify(String paramString);
  
  public abstract void doNotify(String paramString, int paramInt, Object paramObject);
  
  public abstract void lock();
  
  public abstract int lockCount();
  
  public abstract void remove(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded);
  
  public abstract void unlock();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IStorage
 * JD-Core Version:    0.7.0.1
 */