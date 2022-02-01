package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator()
  {
    public final RecoveryHandleItem createFromParcel(Parcel paramAnonymousParcel)
    {
      RecoveryHandleItem localRecoveryHandleItem = new RecoveryHandleItem();
      localRecoveryHandleItem.uuid = paramAnonymousParcel.readString();
      localRecoveryHandleItem.clientVersion = paramAnonymousParcel.readString();
      localRecoveryHandleItem.key = paramAnonymousParcel.readString();
      localRecoveryHandleItem.processName = paramAnonymousParcel.readString();
      localRecoveryHandleItem.phoneStatus = paramAnonymousParcel.readString();
      localRecoveryHandleItem.timestamp = paramAnonymousParcel.readLong();
      return localRecoveryHandleItem;
    }
    
    public final RecoveryHandleItem[] newArray(int paramAnonymousInt)
    {
      return new RecoveryHandleItem[paramAnonymousInt];
    }
  };
  public String clientVersion;
  public String key;
  public String phoneStatus;
  public String processName;
  public long timestamp;
  public String uuid;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getClientVersion()
  {
    return this.clientVersion;
  }
  
  public long getTimeStamp()
  {
    return this.timestamp;
  }
  
  public boolean parseFromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.uuid = paramString[0];
      this.clientVersion = paramString[1];
      this.key = paramString[2];
      this.processName = paramString[3];
      this.phoneStatus = paramString[4];
      this.timestamp = Long.valueOf(paramString[5]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public String toSaveString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.uuid);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.key);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.phoneStatus);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.phoneStatus);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryHandleItem
 * JD-Core Version:    0.7.0.1
 */