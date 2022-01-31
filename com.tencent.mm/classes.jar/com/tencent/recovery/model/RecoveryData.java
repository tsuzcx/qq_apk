package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData
  implements Parcelable
{
  public static final Parcelable.Creator<RecoveryData> CREATOR = new Parcelable.Creator() {};
  public String Biu;
  public List<RecoveryStatusItem> Biv;
  public String clientVersion;
  public String eAx;
  public String processName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.eAx);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.Biu);
    paramParcel.writeList(this.Biv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryData
 * JD-Core Version:    0.7.0.1
 */