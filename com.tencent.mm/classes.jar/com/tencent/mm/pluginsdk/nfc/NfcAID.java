package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NfcAID
  implements Parcelable
{
  public static final Parcelable.Creator<NfcAID> CREATOR = new NfcAID.1();
  public String mURL = null;
  public String rVC = null;
  
  public NfcAID(Parcel paramParcel)
  {
    this.rVC = paramParcel.readString();
    this.mURL = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.rVC);
    paramParcel.writeString(this.mURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.nfc.NfcAID
 * JD-Core Version:    0.7.0.1
 */