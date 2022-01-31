package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Profession
  implements Parcelable
{
  public static final Parcelable.Creator<Profession> CREATOR;
  public String ues;
  public int uet;
  
  static
  {
    AppMethodBeat.i(46657);
    CREATOR = new Profession.1();
    AppMethodBeat.o(46657);
  }
  
  protected Profession(Parcel paramParcel)
  {
    AppMethodBeat.i(46655);
    this.ues = paramParcel.readString();
    this.uet = paramParcel.readInt();
    AppMethodBeat.o(46655);
  }
  
  public Profession(String paramString, int paramInt)
  {
    this.ues = paramString;
    this.uet = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46656);
    paramParcel.writeString(this.ues);
    paramParcel.writeInt(this.uet);
    AppMethodBeat.o(46656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.Profession
 * JD-Core Version:    0.7.0.1
 */