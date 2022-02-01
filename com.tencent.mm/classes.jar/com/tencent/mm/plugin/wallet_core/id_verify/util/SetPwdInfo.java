package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR;
  public String KuO;
  public int VCy;
  public String rGU;
  public String right_button_wording;
  
  static
  {
    AppMethodBeat.i(70204);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70204);
  }
  
  public SetPwdInfo()
  {
    this.rGU = "";
    this.right_button_wording = "";
  }
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70202);
    this.rGU = "";
    this.right_button_wording = "";
    this.VCy = paramParcel.readInt();
    this.KuO = paramParcel.readString();
    this.rGU = paramParcel.readString();
    this.right_button_wording = paramParcel.readString();
    AppMethodBeat.o(70202);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70203);
    paramParcel.writeInt(this.VCy);
    paramParcel.writeString(this.KuO);
    paramParcel.writeString(this.rGU);
    paramParcel.writeString(this.right_button_wording);
    AppMethodBeat.o(70203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */