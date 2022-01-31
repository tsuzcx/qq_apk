package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$DeductShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeductShowInfo> CREATOR = new Orders.DeductShowInfo.1();
  public String name;
  public int qxv;
  public String qxw;
  public String qxx;
  public String qxy;
  public String value;
  
  public Orders$DeductShowInfo() {}
  
  protected Orders$DeductShowInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.qxv = paramParcel.readInt();
    this.qxw = paramParcel.readString();
    this.qxx = paramParcel.readString();
    this.qxy = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.qxv);
    paramParcel.writeString(this.qxw);
    paramParcel.writeString(this.qxx);
    paramParcel.writeString(this.qxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo
 * JD-Core Version:    0.7.0.1
 */