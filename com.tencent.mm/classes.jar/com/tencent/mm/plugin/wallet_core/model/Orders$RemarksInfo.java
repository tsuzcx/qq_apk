package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$RemarksInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RemarksInfo> CREATOR = new Orders.RemarksInfo.1();
  public String qxQ;
  public String qxR;
  
  public Orders$RemarksInfo() {}
  
  protected Orders$RemarksInfo(Parcel paramParcel)
  {
    this.qxQ = paramParcel.readString();
    this.qxR = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.qxQ);
    paramParcel.writeString(this.qxR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo
 * JD-Core Version:    0.7.0.1
 */