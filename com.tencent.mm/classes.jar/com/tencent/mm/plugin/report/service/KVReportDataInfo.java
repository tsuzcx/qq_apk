package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KVReportDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KVReportDataInfo> CREATOR;
  public long cZM;
  public long dml;
  public String value;
  public boolean wTB;
  public boolean wTX;
  public boolean wTY;
  
  static
  {
    AppMethodBeat.i(143845);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143845);
  }
  
  public KVReportDataInfo()
  {
    this.cZM = 0L;
  }
  
  protected KVReportDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(143844);
    this.cZM = 0L;
    this.dml = paramParcel.readLong();
    this.cZM = paramParcel.readLong();
    this.value = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.wTX = bool1;
      if (paramParcel.readInt() != 1) {
        break label96;
      }
      bool1 = true;
      label65:
      this.wTB = bool1;
      if (paramParcel.readInt() != 1) {
        break label101;
      }
    }
    label96:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wTY = bool1;
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
    paramParcel.writeLong(this.dml);
    paramParcel.writeLong(this.cZM);
    paramParcel.writeString(this.value);
    if (this.wTX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.wTB) {
        break label84;
      }
      paramInt = 1;
      label54:
      paramParcel.writeInt(paramInt);
      if (!this.wTY) {
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