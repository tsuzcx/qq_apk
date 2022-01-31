package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterExportResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterExportResult> CREATOR;
  public byte[] BmP;
  public int BmQ;
  public int bpE;
  
  static
  {
    AppMethodBeat.i(73110);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73110);
  }
  
  public SoterExportResult() {}
  
  public SoterExportResult(Parcel paramParcel)
  {
    AppMethodBeat.i(73108);
    this.bpE = paramParcel.readInt();
    this.BmP = paramParcel.createByteArray();
    this.BmQ = paramParcel.readInt();
    AppMethodBeat.o(73108);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73109);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeByteArray(this.BmP);
    paramParcel.writeInt(this.BmQ);
    AppMethodBeat.o(73109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterExportResult
 * JD-Core Version:    0.7.0.1
 */