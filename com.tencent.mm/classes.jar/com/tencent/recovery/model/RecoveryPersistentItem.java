package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem
  implements Parcelable
{
  public abstract boolean awv(String paramString);
  
  public abstract String dUr();
  
  public String toString()
  {
    return dUr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryPersistentItem
 * JD-Core Version:    0.7.0.1
 */