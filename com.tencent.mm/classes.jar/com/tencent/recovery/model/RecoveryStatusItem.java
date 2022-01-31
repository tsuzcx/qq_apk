package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator() {};
  public String clientVersion;
  public String dCX;
  public String processName;
  public long timestamp;
  public int wKI;
  public int wKK;
  public int wKL;
  
  public final boolean afz(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.processName = paramString[0];
      this.dCX = paramString[1];
      this.clientVersion = paramString[2];
      this.wKI = Integer.valueOf(paramString[3]).intValue();
      this.wKL = Integer.valueOf(paramString[4]).intValue();
      this.wKK = Integer.valueOf(paramString[5]).intValue();
      this.timestamp = Long.valueOf(paramString[6]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final String cOC()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.dCX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wKI);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wKL);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wKK);
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
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.dCX);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeInt(this.wKI);
    paramParcel.writeInt(this.wKL);
    paramParcel.writeInt(this.wKK);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryStatusItem
 * JD-Core Version:    0.7.0.1
 */