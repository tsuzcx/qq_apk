package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$DiscountInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscountInfo> CREATOR = new Orders.DiscountInfo.1();
  public String nxN;
  public double qxz;
  
  public Orders$DiscountInfo() {}
  
  public Orders$DiscountInfo(Parcel paramParcel)
  {
    this.qxz = paramParcel.readDouble();
    this.nxN = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.qxz);
    paramParcel.writeString(this.nxN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo
 * JD-Core Version:    0.7.0.1
 */