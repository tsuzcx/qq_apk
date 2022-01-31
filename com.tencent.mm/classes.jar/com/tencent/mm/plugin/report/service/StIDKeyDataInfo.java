package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class StIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StIDKeyDataInfo> CREATOR = new Parcelable.Creator() {};
  public long key;
  public boolean nFg;
  public long nGh;
  public long value;
  
  public StIDKeyDataInfo() {}
  
  protected StIDKeyDataInfo(Parcel paramParcel)
  {
    this.nGh = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.nFg = bool;
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.nGh);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
    if (this.nFg) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.StIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */