package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR;
  public int HUM;
  public String lHA;
  public String lHB;
  public String yXJ;
  
  static
  {
    AppMethodBeat.i(70204);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70204);
  }
  
  public SetPwdInfo()
  {
    this.lHA = "";
    this.lHB = "";
  }
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70202);
    this.lHA = "";
    this.lHB = "";
    this.HUM = paramParcel.readInt();
    this.yXJ = paramParcel.readString();
    this.lHA = paramParcel.readString();
    this.lHB = paramParcel.readString();
    AppMethodBeat.o(70202);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70203);
    paramParcel.writeInt(this.HUM);
    paramParcel.writeString(this.yXJ);
    paramParcel.writeString(this.lHA);
    paramParcel.writeString(this.lHB);
    AppMethodBeat.o(70203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */