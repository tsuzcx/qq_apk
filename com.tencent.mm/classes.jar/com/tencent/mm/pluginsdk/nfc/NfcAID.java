package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NfcAID
  implements Parcelable
{
  public static final Parcelable.Creator<NfcAID> CREATOR;
  public String mURL;
  public String vMq;
  
  static
  {
    AppMethodBeat.i(27436);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(27436);
  }
  
  public NfcAID(Parcel paramParcel)
  {
    AppMethodBeat.i(27434);
    this.vMq = null;
    this.mURL = null;
    this.vMq = paramParcel.readString();
    this.mURL = paramParcel.readString();
    AppMethodBeat.o(27434);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(27435);
    paramParcel.writeString(this.vMq);
    paramParcel.writeString(this.mURL);
    AppMethodBeat.o(27435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.nfc.NfcAID
 * JD-Core Version:    0.7.0.1
 */