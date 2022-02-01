package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterExportResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterExportResult> CREATOR;
  public byte[] RQo;
  public int RQp;
  public int resultCode;
  
  static
  {
    AppMethodBeat.i(88746);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88746);
  }
  
  public SoterExportResult() {}
  
  public SoterExportResult(Parcel paramParcel)
  {
    AppMethodBeat.i(88744);
    this.resultCode = paramParcel.readInt();
    this.RQo = paramParcel.createByteArray();
    this.RQp = paramParcel.readInt();
    AppMethodBeat.o(88744);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88745);
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeByteArray(this.RQo);
    paramParcel.writeInt(this.RQp);
    AppMethodBeat.o(88745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterExportResult
 * JD-Core Version:    0.7.0.1
 */