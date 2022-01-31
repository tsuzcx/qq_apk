package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profession
  implements Parcelable
{
  public static final Parcelable.Creator<Profession> CREATOR = new Parcelable.Creator() {};
  public String qst;
  public int qsu;
  
  protected Profession(Parcel paramParcel)
  {
    this.qst = paramParcel.readString();
    this.qsu = paramParcel.readInt();
  }
  
  public Profession(String paramString, int paramInt)
  {
    this.qst = paramString;
    this.qsu = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.qst);
    paramParcel.writeInt(this.qsu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.Profession
 * JD-Core Version:    0.7.0.1
 */