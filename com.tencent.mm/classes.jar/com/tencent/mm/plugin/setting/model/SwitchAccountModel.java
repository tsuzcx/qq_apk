package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR = new Parcelable.Creator() {};
  public final String kgT;
  public final String nQM;
  public final String nQN;
  public final int nQO;
  public final String username;
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.nQM = paramString1;
    this.username = paramString2;
    this.kgT = paramString3;
    this.nQN = paramString4;
    this.nQO = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.nQM);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.kgT);
    paramParcel.writeString(this.nQN);
    paramParcel.writeInt(this.nQO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */