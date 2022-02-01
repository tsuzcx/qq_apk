package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KVReportDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KVReportDataInfo> CREATOR;
  public long dcn;
  public long doC;
  public boolean vJT;
  public boolean vJU;
  public boolean vJx;
  public String value;
  
  static
  {
    AppMethodBeat.i(143845);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143845);
  }
  
  public KVReportDataInfo()
  {
    this.dcn = 0L;
  }
  
  protected KVReportDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(143844);
    this.dcn = 0L;
    this.doC = paramParcel.readLong();
    this.dcn = paramParcel.readLong();
    this.value = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.vJT = bool1;
      if (paramParcel.readInt() != 1) {
        break label96;
      }
      bool1 = true;
      label65:
      this.vJx = bool1;
      if (paramParcel.readInt() != 1) {
        break label101;
      }
    }
    label96:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vJU = bool1;
      AppMethodBeat.o(143844);
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
    AppMethodBeat.i(143843);
    paramParcel.writeLong(this.doC);
    paramParcel.writeLong(this.dcn);
    paramParcel.writeString(this.value);
    if (this.vJT)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.vJx) {
        break label84;
      }
      paramInt = 1;
      label54:
      paramParcel.writeInt(paramInt);
      if (!this.vJU) {
        break label89;
      }
    }
    label84:
    label89:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(143843);
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