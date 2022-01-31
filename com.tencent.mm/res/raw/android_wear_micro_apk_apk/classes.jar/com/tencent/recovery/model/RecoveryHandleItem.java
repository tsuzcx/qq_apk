package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator() {};
  public String ajr;
  public String ajs;
  public String ajv;
  public String ajw;
  public String processName;
  public long timestamp;
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String nO()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.ajr);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajs);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajv);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ajw);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ajr);
    paramParcel.writeString(this.ajs);
    paramParcel.writeString(this.ajv);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.ajw);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryHandleItem
 * JD-Core Version:    0.7.0.1
 */