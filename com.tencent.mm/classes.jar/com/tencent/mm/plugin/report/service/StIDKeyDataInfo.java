package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class StIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StIDKeyDataInfo> CREATOR;
  public long key;
  public long ltw;
  public boolean qsi;
  public long value;
  
  static
  {
    AppMethodBeat.i(72803);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(72803);
  }
  
  public StIDKeyDataInfo() {}
  
  protected StIDKeyDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(72802);
    this.ltw = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.qsi = bool;
      AppMethodBeat.o(72802);
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
    AppMethodBeat.i(72801);
    paramParcel.writeLong(this.ltw);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
    if (this.qsi) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(72801);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.StIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */