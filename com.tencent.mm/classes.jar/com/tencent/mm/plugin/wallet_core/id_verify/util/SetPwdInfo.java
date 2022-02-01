package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR;
  public int Dlt;
  public String kCZ;
  public String kDa;
  public String vCG;
  
  static
  {
    AppMethodBeat.i(70204);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70204);
  }
  
  public SetPwdInfo()
  {
    this.kCZ = "";
    this.kDa = "";
  }
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70202);
    this.kCZ = "";
    this.kDa = "";
    this.Dlt = paramParcel.readInt();
    this.vCG = paramParcel.readString();
    this.kCZ = paramParcel.readString();
    this.kDa = paramParcel.readString();
    AppMethodBeat.o(70202);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70203);
    paramParcel.writeInt(this.Dlt);
    paramParcel.writeString(this.vCG);
    paramParcel.writeString(this.kCZ);
    paramParcel.writeString(this.kDa);
    AppMethodBeat.o(70203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */