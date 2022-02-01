package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NfcAID
  implements Parcelable
{
  public static final Parcelable.Creator<NfcAID> CREATOR;
  public String BRd;
  public String mURL;
  
  static
  {
    AppMethodBeat.i(31138);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(31138);
  }
  
  public NfcAID(Parcel paramParcel)
  {
    AppMethodBeat.i(31136);
    this.BRd = null;
    this.mURL = null;
    this.BRd = paramParcel.readString();
    this.mURL = paramParcel.readString();
    AppMethodBeat.o(31136);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(31137);
    paramParcel.writeString(this.BRd);
    paramParcel.writeString(this.mURL);
    AppMethodBeat.o(31137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.nfc.NfcAID
 * JD-Core Version:    0.7.0.1
 */