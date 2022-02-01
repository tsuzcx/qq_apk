package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSignResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSignResult> CREATOR;
  public byte[] MnQ;
  public int MnR;
  public int bZU;
  
  static
  {
    AppMethodBeat.i(88754);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88754);
  }
  
  public SoterSignResult() {}
  
  protected SoterSignResult(Parcel paramParcel)
  {
    AppMethodBeat.i(88752);
    this.bZU = paramParcel.readInt();
    this.MnQ = paramParcel.createByteArray();
    this.MnR = paramParcel.readInt();
    AppMethodBeat.o(88752);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88753);
    paramParcel.writeInt(this.bZU);
    paramParcel.writeByteArray(this.MnQ);
    paramParcel.writeInt(this.MnR);
    AppMethodBeat.o(88753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSignResult
 * JD-Core Version:    0.7.0.1
 */