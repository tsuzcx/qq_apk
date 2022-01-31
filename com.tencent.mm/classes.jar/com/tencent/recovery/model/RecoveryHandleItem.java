package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator() {};
  public String clientVersion;
  public String dCX;
  public String key;
  public String processName;
  public long timestamp;
  public String wKW;
  
  public final boolean afz(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.dCX = paramString[0];
      this.clientVersion = paramString[1];
      this.key = paramString[2];
      this.processName = paramString[3];
      this.wKW = paramString[4];
      this.timestamp = Long.valueOf(paramString[5]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final String cOC()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dCX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.key);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wKW);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dCX);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.wKW);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryHandleItem
 * JD-Core Version:    0.7.0.1
 */