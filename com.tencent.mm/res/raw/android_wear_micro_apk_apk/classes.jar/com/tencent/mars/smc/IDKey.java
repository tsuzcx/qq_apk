package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IDKey
  implements Parcelable
{
  public static final Parcelable.Creator<IDKey> CREATOR = new Parcelable.Creator() {};
  private long WL;
  private long id;
  private long value;
  
  public IDKey()
  {
    this.id = 0L;
    this.WL = 0L;
    this.value = 0L;
  }
  
  protected IDKey(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.WL = paramParcel.readLong();
    this.value = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.WL);
    paramParcel.writeLong(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mars.smc.IDKey
 * JD-Core Version:    0.7.0.1
 */