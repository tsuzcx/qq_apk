package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR;
  public int Abe;
  public String tfG;
  public String tfH;
  public String tfI;
  
  static
  {
    AppMethodBeat.i(70204);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70204);
  }
  
  public SetPwdInfo()
  {
    this.tfH = "";
    this.tfI = "";
  }
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70202);
    this.tfH = "";
    this.tfI = "";
    this.Abe = paramParcel.readInt();
    this.tfG = paramParcel.readString();
    this.tfH = paramParcel.readString();
    this.tfI = paramParcel.readString();
    AppMethodBeat.o(70202);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70203);
    paramParcel.writeInt(this.Abe);
    paramParcel.writeString(this.tfG);
    paramParcel.writeString(this.tfH);
    paramParcel.writeString(this.tfI);
    AppMethodBeat.o(70203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */