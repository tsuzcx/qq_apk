package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR;
  public String opB;
  public String opC;
  public String opD;
  public int ueS;
  
  static
  {
    AppMethodBeat.i(46693);
    CREATOR = new SetPwdInfo.1();
    AppMethodBeat.o(46693);
  }
  
  public SetPwdInfo()
  {
    this.opC = "";
    this.opD = "";
  }
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46691);
    this.opC = "";
    this.opD = "";
    this.ueS = paramParcel.readInt();
    this.opB = paramParcel.readString();
    this.opC = paramParcel.readString();
    this.opD = paramParcel.readString();
    AppMethodBeat.o(46691);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46692);
    paramParcel.writeInt(this.ueS);
    paramParcel.writeString(this.opB);
    paramParcel.writeString(this.opC);
    paramParcel.writeString(this.opD);
    AppMethodBeat.o(46692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */