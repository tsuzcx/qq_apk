package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class StIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StIDKeyDataInfo> CREATOR;
  public long ID;
  public boolean OzE;
  public long key;
  public long value;
  
  static
  {
    AppMethodBeat.i(143930);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143930);
  }
  
  public StIDKeyDataInfo() {}
  
  protected StIDKeyDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(143929);
    this.ID = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.OzE = bool;
      AppMethodBeat.o(143929);
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
    AppMethodBeat.i(143928);
    paramParcel.writeLong(this.ID);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
    if (this.OzE) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(143928);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.StIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */