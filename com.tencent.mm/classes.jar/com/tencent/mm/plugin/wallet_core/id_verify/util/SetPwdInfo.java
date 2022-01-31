package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SetPwdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SetPwdInfo> CREATOR = new SetPwdInfo.1();
  public String lRD;
  public String lRE = "";
  public String lRF = "";
  public int qsG;
  
  public SetPwdInfo() {}
  
  protected SetPwdInfo(Parcel paramParcel)
  {
    this.qsG = paramParcel.readInt();
    this.lRD = paramParcel.readString();
    this.lRE = paramParcel.readString();
    this.lRF = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.qsG);
    paramParcel.writeString(this.lRD);
    paramParcel.writeString(this.lRE);
    paramParcel.writeString(this.lRF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo
 * JD-Core Version:    0.7.0.1
 */