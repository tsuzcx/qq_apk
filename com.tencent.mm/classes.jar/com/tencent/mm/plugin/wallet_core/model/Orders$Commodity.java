package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Orders$Commodity
  implements Parcelable
{
  public static final Parcelable.Creator<Commodity> CREATOR = new Orders.Commodity.1();
  public String bMY;
  public String desc;
  public double iHP = 0.0D;
  public String mOD;
  public String mOL;
  public String mOM;
  public String mON;
  public String mOO;
  public String mOQ;
  public String mOS;
  public String mOT;
  public int mOV;
  public String mOX;
  public String mOZ;
  public String mPa;
  public String mPe;
  public int qwE;
  public double qxe = 0.0D;
  public String qxf;
  public String qxg;
  public List<Orders.DiscountInfo> qxh = new ArrayList();
  public String qxi;
  public String qxj;
  public String qxk;
  public Orders.RecommendTinyAppInfo qxl = null;
  public Orders.RemarksInfo qxm;
  public List<Orders.Promotions> qxn = new ArrayList();
  public boolean qxo = false;
  public Orders.a qxp = new Orders.a();
  
  public Orders$Commodity() {}
  
  public Orders$Commodity(Parcel paramParcel)
  {
    this.mOL = paramParcel.readString();
    this.mOM = paramParcel.readString();
    this.mON = paramParcel.readString();
    this.mOO = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.mOQ = paramParcel.readString();
    this.iHP = paramParcel.readDouble();
    this.mOS = paramParcel.readString();
    this.mOT = paramParcel.readString();
    this.mOV = paramParcel.readInt();
    this.bMY = paramParcel.readString();
    this.mOX = paramParcel.readString();
    this.mOZ = paramParcel.readString();
    this.mPa = paramParcel.readString();
    this.mOD = paramParcel.readString();
    this.qxg = paramParcel.readString();
    this.mPe = paramParcel.readString();
    paramParcel.readTypedList(this.qxh, Orders.DiscountInfo.CREATOR);
    this.qxi = paramParcel.readString();
    this.qxk = paramParcel.readString();
    this.qxl = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
    paramParcel.readTypedList(this.qxn, Orders.Promotions.CREATOR);
    this.qxm = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mOL);
    paramParcel.writeString(this.mOM);
    paramParcel.writeString(this.mON);
    paramParcel.writeString(this.mOO);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.mOQ);
    paramParcel.writeDouble(this.iHP);
    paramParcel.writeString(this.mOS);
    paramParcel.writeString(this.mOT);
    paramParcel.writeInt(this.mOV);
    paramParcel.writeString(this.bMY);
    paramParcel.writeString(this.mOX);
    paramParcel.writeString(this.mOZ);
    paramParcel.writeString(this.mPa);
    paramParcel.writeString(this.mOD);
    paramParcel.writeString(this.qxg);
    paramParcel.writeString(this.mPe);
    paramParcel.writeTypedList(this.qxh);
    paramParcel.writeString(this.qxi);
    paramParcel.writeString(this.qxk);
    paramParcel.writeParcelable(this.qxl, 0);
    paramParcel.writeTypedList(this.qxn);
    paramParcel.writeParcelable(this.qxm, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.Commodity
 * JD-Core Version:    0.7.0.1
 */