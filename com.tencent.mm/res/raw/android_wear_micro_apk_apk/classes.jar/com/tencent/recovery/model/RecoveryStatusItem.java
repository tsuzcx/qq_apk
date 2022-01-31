package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator() {};
  public int ajA;
  public int ajn;
  public String ajr;
  public String ajs;
  public int ajz;
  public String processName;
  public long timestamp;
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String nO()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajr);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajs);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajn);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajz);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajA);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.ajr);
    paramParcel.writeString(this.ajs);
    paramParcel.writeInt(this.ajn);
    paramParcel.writeInt(this.ajz);
    paramParcel.writeInt(this.ajA);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryStatusItem
 * JD-Core Version:    0.7.0.1
 */