package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem
  implements Parcelable
{
  public abstract String getClientVersion();
  
  public abstract long getTimeStamp();
  
  public abstract boolean parseFromString(String paramString);
  
  public abstract String toSaveString();
  
  public String toString()
  {
    return toSaveString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryPersistentItem
 * JD-Core Version:    0.7.0.1
 */