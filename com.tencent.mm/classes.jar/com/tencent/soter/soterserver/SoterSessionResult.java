package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSessionResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSessionResult> CREATOR;
  public long BmR;
  public int bpE;
  
  static
  {
    AppMethodBeat.i(73114);
    CREATOR = new SoterSessionResult.1();
    AppMethodBeat.o(73114);
  }
  
  public SoterSessionResult() {}
  
  protected SoterSessionResult(Parcel paramParcel)
  {
    AppMethodBeat.i(73112);
    this.BmR = paramParcel.readLong();
    this.bpE = paramParcel.readInt();
    AppMethodBeat.o(73112);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73113);
    paramParcel.writeLong(this.BmR);
    paramParcel.writeInt(this.bpE);
    AppMethodBeat.o(73113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSessionResult
 * JD-Core Version:    0.7.0.1
 */