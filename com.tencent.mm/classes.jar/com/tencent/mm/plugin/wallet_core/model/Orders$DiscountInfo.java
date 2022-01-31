package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$DiscountInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscountInfo> CREATOR;
  public String qiO;
  public double ukh;
  
  static
  {
    AppMethodBeat.i(46811);
    CREATOR = new Orders.DiscountInfo.1();
    AppMethodBeat.o(46811);
  }
  
  public Orders$DiscountInfo() {}
  
  public Orders$DiscountInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46809);
    this.ukh = paramParcel.readDouble();
    this.qiO = paramParcel.readString();
    AppMethodBeat.o(46809);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46810);
    paramParcel.writeDouble(this.ukh);
    paramParcel.writeString(this.qiO);
    AppMethodBeat.o(46810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo
 * JD-Core Version:    0.7.0.1
 */