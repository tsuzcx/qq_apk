package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$RecommendTinyAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR = new Orders.RecommendTinyAppInfo.1();
  public String qhq;
  public String qhr;
  public String qwr;
  public String qws;
  public String qwt;
  public String qwu;
  public int qwv;
  public long qxK;
  public long qxL;
  public long qxM;
  public int qxN;
  public int qxO;
  public long qxP;
  
  public Orders$RecommendTinyAppInfo() {}
  
  public Orders$RecommendTinyAppInfo(Parcel paramParcel)
  {
    this.qwr = paramParcel.readString();
    this.qws = paramParcel.readString();
    this.qwt = paramParcel.readString();
    this.qhq = paramParcel.readString();
    this.qhr = paramParcel.readString();
    this.qwv = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.qwr);
    paramParcel.writeString(this.qws);
    paramParcel.writeString(this.qwt);
    paramParcel.writeString(this.qhq);
    paramParcel.writeString(this.qhr);
    paramParcel.writeInt(this.qwv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo
 * JD-Core Version:    0.7.0.1
 */