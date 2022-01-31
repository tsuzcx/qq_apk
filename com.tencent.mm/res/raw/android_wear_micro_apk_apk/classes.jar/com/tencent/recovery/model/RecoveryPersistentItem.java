package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem
  implements Parcelable
{
  public abstract String nO();
  
  public String toString()
  {
    return nO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryPersistentItem
 * JD-Core Version:    0.7.0.1
 */