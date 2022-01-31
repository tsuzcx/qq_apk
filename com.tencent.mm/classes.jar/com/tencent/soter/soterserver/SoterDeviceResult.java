package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterDeviceResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterDeviceResult> CREATOR;
  public byte[] BmP;
  public int BmQ;
  public int bpE;
  
  static
  {
    AppMethodBeat.i(73106);
    CREATOR = new SoterDeviceResult.1();
    AppMethodBeat.o(73106);
  }
  
  public SoterDeviceResult() {}
  
  protected SoterDeviceResult(Parcel paramParcel)
  {
    AppMethodBeat.i(73104);
    this.bpE = paramParcel.readInt();
    this.BmP = paramParcel.createByteArray();
    this.BmQ = paramParcel.readInt();
    AppMethodBeat.o(73104);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73105);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeByteArray(this.BmP);
    paramParcel.writeInt(this.BmQ);
    AppMethodBeat.o(73105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterDeviceResult
 * JD-Core Version:    0.7.0.1
 */