package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterDeviceResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterDeviceResult> CREATOR;
  public byte[] MnQ;
  public int MnR;
  public int bZU;
  
  static
  {
    AppMethodBeat.i(88742);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88742);
  }
  
  public SoterDeviceResult() {}
  
  protected SoterDeviceResult(Parcel paramParcel)
  {
    AppMethodBeat.i(88740);
    this.bZU = paramParcel.readInt();
    this.MnQ = paramParcel.createByteArray();
    this.MnR = paramParcel.readInt();
    AppMethodBeat.o(88740);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88741);
    paramParcel.writeInt(this.bZU);
    paramParcel.writeByteArray(this.MnQ);
    paramParcel.writeInt(this.MnR);
    AppMethodBeat.o(88741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterDeviceResult
 * JD-Core Version:    0.7.0.1
 */