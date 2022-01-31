package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator() {};
  public int Bij;
  public int Bil;
  public int Bim;
  public String clientVersion;
  public String eAx;
  public String processName;
  public long timestamp;
  
  public final boolean awv(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.processName = paramString[0];
      this.eAx = paramString[1];
      this.clientVersion = paramString[2];
      this.Bij = Integer.valueOf(paramString[3]).intValue();
      this.Bim = Integer.valueOf(paramString[4]).intValue();
      this.Bil = Integer.valueOf(paramString[5]).intValue();
      this.timestamp = Long.valueOf(paramString[6]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final String dUr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.eAx);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.Bij);
    localStringBuffer.append(",");
    localStringBuffer.append(this.Bim);
    localStringBuffer.append(",");
    localStringBuffer.append(this.Bil);
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
    paramParcel.writeString(this.eAx);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeInt(this.Bij);
    paramParcel.writeInt(this.Bim);
    paramParcel.writeInt(this.Bil);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.model.RecoveryStatusItem
 * JD-Core Version:    0.7.0.1
 */