package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator() {};
  public int amP;
  public String amT;
  public String amU;
  public int anb;
  public int anc;
  public String processName;
  public long timestamp;
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String oC()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amT);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amU);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amP);
    localStringBuffer.append(",");
    localStringBuffer.append(this.anb);
    localStringBuffer.append(",");
    localStringBuffer.append(this.anc);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.amT);
    paramParcel.writeString(this.amU);
    paramParcel.writeInt(this.amP);
    paramParcel.writeInt(this.anb);
    paramParcel.writeInt(this.anc);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryStatusItem
 * JD-Core Version:    0.7.0.1
 */