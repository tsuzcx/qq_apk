package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class KVReportDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KVReportDataInfo> CREATOR = new Parcelable.Creator() {};
  public long bGn = 0L;
  public long nFC;
  public boolean nFD;
  public boolean nFg;
  public String value;
  
  public KVReportDataInfo() {}
  
  protected KVReportDataInfo(Parcel paramParcel)
  {
    this.nFC = paramParcel.readLong();
    this.bGn = paramParcel.readLong();
    this.value = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.nFD = bool1;
      if (paramParcel.readInt() != 1) {
        break label71;
      }
    }
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nFg = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.nFC);
    paramParcel.writeLong(this.bGn);
    paramParcel.writeString(this.value);
    if (this.nFD)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.nFg) {
        break label60;
      }
    }
    label60:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVReportDataInfo
 * JD-Core Version:    0.7.0.1
 */