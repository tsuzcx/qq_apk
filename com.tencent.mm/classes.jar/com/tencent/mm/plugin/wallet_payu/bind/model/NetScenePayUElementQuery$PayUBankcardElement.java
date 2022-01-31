package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NetScenePayUElementQuery$PayUBankcardElement
  implements Parcelable
{
  public String bRP = "";
  public String cardType = "";
  public String mOX = "";
  public String qMI = "";
  public String qMJ = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.qMI);
    paramParcel.writeString(this.mOX);
    paramParcel.writeString(this.qMJ);
    paramParcel.writeString(this.cardType);
    paramParcel.writeString(this.bRP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement
 * JD-Core Version:    0.7.0.1
 */