package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator() {};
  public String amT;
  public String amU;
  public String amX;
  public String amY;
  public String processName;
  public long timestamp;
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String oC()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.amT);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amU);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amY);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.amT);
    paramParcel.writeString(this.amU);
    paramParcel.writeString(this.amX);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.amY);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryHandleItem
 * JD-Core Version:    0.7.0.1
 */