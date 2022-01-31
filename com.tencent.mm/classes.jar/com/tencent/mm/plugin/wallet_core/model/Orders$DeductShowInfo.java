package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$DeductShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeductShowInfo> CREATOR;
  public String name;
  public int ukd;
  public String uke;
  public String ukf;
  public String ukg;
  public String value;
  
  static
  {
    AppMethodBeat.i(46807);
    CREATOR = new Orders.DeductShowInfo.1();
    AppMethodBeat.o(46807);
  }
  
  public Orders$DeductShowInfo() {}
  
  protected Orders$DeductShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46805);
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.ukd = paramParcel.readInt();
    this.uke = paramParcel.readString();
    this.ukf = paramParcel.readString();
    this.ukg = paramParcel.readString();
    AppMethodBeat.o(46805);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46806);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.ukd);
    paramParcel.writeString(this.uke);
    paramParcel.writeString(this.ukf);
    paramParcel.writeString(this.ukg);
    AppMethodBeat.o(46806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo
 * JD-Core Version:    0.7.0.1
 */