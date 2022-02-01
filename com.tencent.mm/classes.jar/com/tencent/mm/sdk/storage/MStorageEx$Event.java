package com.tencent.mm.sdk.storage;

public class MStorageEx$Event
{
  public int event;
  public Object extraObj;
  public MStorageEx mstorage;
  public Object obj;
  
  public MStorageEx$Event(MStorageEx paramMStorageEx1, int paramInt, MStorageEx paramMStorageEx2, Object paramObject1, Object paramObject2)
  {
    this.event = paramInt;
    this.obj = paramObject1;
    this.mstorage = paramMStorageEx2;
    this.extraObj = paramObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEx.Event
 * JD-Core Version:    0.7.0.1
 */