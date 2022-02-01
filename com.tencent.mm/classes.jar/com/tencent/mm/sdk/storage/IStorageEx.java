package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.threadpool.j.a;

public abstract interface IStorageEx
{
  public abstract void add(MStorageEx.IOnStorageChange paramIOnStorageChange);
  
  public abstract void add(MStorageEx.IOnStorageChange paramIOnStorageChange, Looper paramLooper);
  
  public abstract void add(MStorageEx.IOnStorageChange paramIOnStorageChange, a parama);
  
  public abstract void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject);
  
  public abstract void remove(MStorageEx.IOnStorageChange paramIOnStorageChange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IStorageEx
 * JD-Core Version:    0.7.0.1
 */