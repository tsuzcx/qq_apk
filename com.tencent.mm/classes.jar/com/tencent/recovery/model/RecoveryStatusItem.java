package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator()
  {
    public final RecoveryStatusItem createFromParcel(Parcel paramAnonymousParcel)
    {
      RecoveryStatusItem localRecoveryStatusItem = new RecoveryStatusItem();
      localRecoveryStatusItem.processName = paramAnonymousParcel.readString();
      localRecoveryStatusItem.uuid = paramAnonymousParcel.readString();
      localRecoveryStatusItem.clientVersion = paramAnonymousParcel.readString();
      localRecoveryStatusItem.processStartFlag = paramAnonymousParcel.readInt();
      localRecoveryStatusItem.processStatus = paramAnonymousParcel.readInt();
      localRecoveryStatusItem.processStage = paramAnonymousParcel.readInt();
      localRecoveryStatusItem.timestamp = paramAnonymousParcel.readLong();
      return localRecoveryStatusItem;
    }
    
    public final RecoveryStatusItem[] newArray(int paramAnonymousInt)
    {
      return new RecoveryStatusItem[paramAnonymousInt];
    }
  };
  public String clientVersion;
  public String processName;
  public int processStage;
  public int processStartFlag;
  public int processStatus;
  public long timestamp;
  public String uuid;
  
  public static String getStageString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 16: 
      return "ComponentOnCreate";
    }
    return "ApplicationOnCreate";
  }
  
  public static String getStatusString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 1048576: 
      return "Anr";
    case 65536: 
      return "Crash";
    }
    return "TimeOut";
  }
  
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
  
  public boolean isException()
  {
    switch (this.processStatus)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean parseFromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.processName = paramString[0];
      this.uuid = paramString[1];
      this.clientVersion = paramString[2];
      this.processStartFlag = Integer.valueOf(paramString[3]).intValue();
      this.processStatus = Integer.valueOf(paramString[4]).intValue();
      this.processStage = Integer.valueOf(paramString[5]).intValue();
      this.timestamp = Long.valueOf(paramString[6]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public String toSaveString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.uuid);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processStartFlag);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processStatus);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processStage);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeInt(this.processStartFlag);
    paramParcel.writeInt(this.processStatus);
    paramParcel.writeInt(this.processStage);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryStatusItem
 * JD-Core Version:    0.7.0.1
 */