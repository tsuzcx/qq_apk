package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KVReportDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KVReportDataInfo> CREATOR;
  public long cnw;
  public long qsF;
  public boolean qsG;
  public boolean qsH;
  public boolean qsi;
  public String value;
  
  static
  {
    AppMethodBeat.i(72732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(72732);
  }
  
  public KVReportDataInfo()
  {
    this.cnw = 0L;
  }
  
  protected KVReportDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(72731);
    this.cnw = 0L;
    this.qsF = paramParcel.readLong();
    this.cnw = paramParcel.readLong();
    this.value = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.qsG = bool1;
      if (paramParcel.readInt() != 1) {
        break label96;
      }
      bool1 = true;
      label65:
      this.qsi = bool1;
      if (paramParcel.readInt() != 1) {
        break label101;
      }
    }
    label96:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qsH = bool1;
      AppMethodBeat.o(72731);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label65;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(72730);
    paramParcel.writeLong(this.qsF);
    paramParcel.writeLong(this.cnw);
    paramParcel.writeString(this.value);
    if (this.qsG)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.qsi) {
        break label84;
      }
      paramInt = 1;
      label54:
      paramParcel.writeInt(paramInt);
      if (!this.qsH) {
        break label89;
      }
    }
    label84:
    label89:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(72730);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVReportDataInfo
 * JD-Core Version:    0.7.0.1
 */