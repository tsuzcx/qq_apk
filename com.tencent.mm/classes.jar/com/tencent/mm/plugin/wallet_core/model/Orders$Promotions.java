package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.a.a.c;

public class Orders$Promotions
  implements Parcelable
{
  public static final Parcelable.Creator<Promotions> CREATOR = new Orders.Promotions.1();
  public String mPa;
  public String mTc;
  public String name;
  public long qqG;
  public int qwm;
  public int qwn;
  public long qwo;
  public String qwp;
  public int qxA;
  public int qxB;
  public int qxC;
  public String qxD;
  public String qxE;
  public String qxF;
  public int qxG;
  public String qxH;
  public String qxI;
  public c qxJ;
  public String title;
  public int type;
  public String url;
  
  public Orders$Promotions() {}
  
  public Orders$Promotions(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.mTc = paramParcel.readString();
    this.name = paramParcel.readString();
    this.qwp = paramParcel.readString();
    this.url = paramParcel.readString();
    this.mPa = paramParcel.readString();
    this.title = paramParcel.readString();
    this.qxA = paramParcel.readInt();
    this.qqG = paramParcel.readLong();
    this.qxB = paramParcel.readInt();
    this.qxC = paramParcel.readInt();
    this.qwm = paramParcel.readInt();
    this.qwn = paramParcel.readInt();
    this.qxD = paramParcel.readString();
    this.qxE = paramParcel.readString();
    this.qxF = paramParcel.readString();
    this.qwo = paramParcel.readLong();
    this.qxG = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.mTc);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.qwp);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.mPa);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.qxA);
    paramParcel.writeLong(this.qqG);
    paramParcel.writeInt(this.qxB);
    paramParcel.writeInt(this.qxC);
    paramParcel.writeInt(this.qwm);
    paramParcel.writeInt(this.qwn);
    paramParcel.writeString(this.qxD);
    paramParcel.writeString(this.qxE);
    paramParcel.writeString(this.qxF);
    paramParcel.writeLong(this.qwo);
    paramParcel.writeInt(this.qxG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.Promotions
 * JD-Core Version:    0.7.0.1
 */