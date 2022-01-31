package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR = new Orders.ShowInfo.1();
  public String kOn;
  public String name;
  public String qxS;
  public int qxT;
  public String qxU;
  public String qxV;
  public String qxW;
  public int qxX;
  public String value;
  
  public Orders$ShowInfo() {}
  
  protected Orders$ShowInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.kOn = paramParcel.readString();
    this.qxS = paramParcel.readString();
    this.qxT = paramParcel.readInt();
    this.qxU = paramParcel.readString();
    this.qxV = paramParcel.readString();
    this.qxW = paramParcel.readString();
    this.qxX = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.kOn, this.qxS, Integer.valueOf(this.qxT), this.qxU, this.qxV, this.qxW, Integer.valueOf(this.qxX) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeString(this.kOn);
    paramParcel.writeString(this.qxS);
    paramParcel.writeInt(this.qxT);
    paramParcel.writeString(this.qxU);
    paramParcel.writeString(this.qxV);
    paramParcel.writeString(this.qxW);
    paramParcel.writeInt(this.qxX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo
 * JD-Core Version:    0.7.0.1
 */