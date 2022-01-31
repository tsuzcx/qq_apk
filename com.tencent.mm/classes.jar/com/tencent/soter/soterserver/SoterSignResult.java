package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSignResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSignResult> CREATOR;
  public byte[] BmP;
  public int BmQ;
  public int bpE;
  
  static
  {
    AppMethodBeat.i(73118);
    CREATOR = new SoterSignResult.1();
    AppMethodBeat.o(73118);
  }
  
  public SoterSignResult() {}
  
  protected SoterSignResult(Parcel paramParcel)
  {
    AppMethodBeat.i(73116);
    this.bpE = paramParcel.readInt();
    this.BmP = paramParcel.createByteArray();
    this.BmQ = paramParcel.readInt();
    AppMethodBeat.o(73116);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73117);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeByteArray(this.BmP);
    paramParcel.writeInt(this.BmQ);
    AppMethodBeat.o(73117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSignResult
 * JD-Core Version:    0.7.0.1
 */