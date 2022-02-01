package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData
  implements Parcelable
{
  public static final Parcelable.Creator<RecoveryData> CREATOR = new Parcelable.Creator()
  {
    public final RecoveryData createFromParcel(Parcel paramAnonymousParcel)
    {
      RecoveryData localRecoveryData = new RecoveryData();
      localRecoveryData.processName = paramAnonymousParcel.readString();
      localRecoveryData.uuid = paramAnonymousParcel.readString();
      localRecoveryData.clientVersion = paramAnonymousParcel.readString();
      localRecoveryData.configUrl = paramAnonymousParcel.readString();
      localRecoveryData.exceptionItemList = paramAnonymousParcel.readArrayList(RecoveryData.class.getClassLoader());
      return localRecoveryData;
    }
    
    public final RecoveryData[] newArray(int paramAnonymousInt)
    {
      return new RecoveryData[paramAnonymousInt];
    }
  };
  public String clientVersion;
  public String configUrl;
  public List<RecoveryStatusItem> exceptionItemList;
  public String processName;
  public String uuid;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.configUrl);
    paramParcel.writeList(this.exceptionItemList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryData
 * JD-Core Version:    0.7.0.1
 */