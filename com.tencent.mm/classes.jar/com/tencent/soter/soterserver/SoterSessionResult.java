package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSessionResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSessionResult> CREATOR;
  public int bZU;
  public long dmK;
  
  static
  {
    AppMethodBeat.i(88750);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88750);
  }
  
  public SoterSessionResult() {}
  
  protected SoterSessionResult(Parcel paramParcel)
  {
    AppMethodBeat.i(88748);
    this.dmK = paramParcel.readLong();
    this.bZU = paramParcel.readInt();
    AppMethodBeat.o(88748);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88749);
    paramParcel.writeLong(this.dmK);
    paramParcel.writeInt(this.bZU);
    AppMethodBeat.o(88749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSessionResult
 * JD-Core Version:    0.7.0.1
 */