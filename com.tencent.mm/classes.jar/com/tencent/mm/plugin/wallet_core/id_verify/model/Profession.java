package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Profession
  implements Parcelable
{
  public static final Parcelable.Creator<Profession> CREATOR;
  public String VBJ;
  public int VBK;
  
  static
  {
    AppMethodBeat.i(70163);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70163);
  }
  
  protected Profession(Parcel paramParcel)
  {
    AppMethodBeat.i(70161);
    this.VBJ = paramParcel.readString();
    this.VBK = paramParcel.readInt();
    AppMethodBeat.o(70161);
  }
  
  public Profession(String paramString, int paramInt)
  {
    this.VBJ = paramString;
    this.VBK = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70162);
    paramParcel.writeString(this.VBJ);
    paramParcel.writeInt(this.VBK);
    AppMethodBeat.o(70162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.Profession
 * JD-Core Version:    0.7.0.1
 */