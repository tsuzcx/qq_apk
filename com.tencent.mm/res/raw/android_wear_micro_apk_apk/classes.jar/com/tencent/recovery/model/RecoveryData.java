package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData
  implements Parcelable
{
  public static final Parcelable.Creator<RecoveryData> CREATOR = new Parcelable.Creator() {};
  public String amT;
  public String amU;
  public String amV;
  public List<RecoveryStatusItem> amW;
  public String processName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.amT);
    paramParcel.writeString(this.amU);
    paramParcel.writeString(this.amV);
    paramParcel.writeList(this.amW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryData
 * JD-Core Version:    0.7.0.1
 */