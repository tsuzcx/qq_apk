package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Orders$DeductInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeductInfo> CREATOR = new Orders.DeductInfo.1();
  public String desc;
  public String imZ;
  public int qnO;
  public int qne;
  public String qnf;
  public String qxq;
  public List<Orders.DeductShowInfo> qxr = new ArrayList();
  public int qxs;
  public String qxt;
  public String qxu;
  public String title;
  
  public Orders$DeductInfo() {}
  
  public Orders$DeductInfo(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.qnO = paramParcel.readInt();
    this.qxq = paramParcel.readString();
    this.qxs = paramParcel.readInt();
    paramParcel.readTypedList(this.qxr, Orders.DeductShowInfo.CREATOR);
    this.qne = paramParcel.readInt();
    this.imZ = paramParcel.readString();
    this.qnf = paramParcel.readString();
    this.qxt = paramParcel.readString();
    this.qxu = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.qnO);
    paramParcel.writeString(this.qxq);
    paramParcel.writeInt(this.qxs);
    paramParcel.writeTypedList(this.qxr);
    paramParcel.writeInt(this.qne);
    paramParcel.writeString(this.imZ);
    paramParcel.writeString(this.qnf);
    paramParcel.writeString(this.qxt);
    paramParcel.writeString(this.qxu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo
 * JD-Core Version:    0.7.0.1
 */