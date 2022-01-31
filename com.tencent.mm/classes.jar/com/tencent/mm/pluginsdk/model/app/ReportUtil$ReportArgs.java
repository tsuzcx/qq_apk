package com.tencent.mm.pluginsdk.model.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportUtil$ReportArgs
  implements Parcelable
{
  public static final Parcelable.Creator<ReportArgs> CREATOR = new ReportUtil.ReportArgs.1();
  public String Bo;
  public int errCode;
  public String openId;
  public String transaction;
  public int uC;
  
  public ReportUtil$ReportArgs() {}
  
  private ReportUtil$ReportArgs(Parcel paramParcel)
  {
    this.Bo = paramParcel.readString();
    this.errCode = paramParcel.readInt();
    this.transaction = paramParcel.readString();
    this.openId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.Bo);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.transaction);
    paramParcel.writeString(this.openId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs
 * JD-Core Version:    0.7.0.1
 */