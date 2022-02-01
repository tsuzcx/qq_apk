package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$DeductShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeductShowInfo> CREATOR;
  public String HZV;
  public String HZW;
  public String HZX;
  public int gTx;
  public String name;
  public String value;
  
  static
  {
    AppMethodBeat.i(70326);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70326);
  }
  
  public Orders$DeductShowInfo() {}
  
  protected Orders$DeductShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70324);
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.gTx = paramParcel.readInt();
    this.HZV = paramParcel.readString();
    this.HZW = paramParcel.readString();
    this.HZX = paramParcel.readString();
    AppMethodBeat.o(70324);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70325);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.gTx);
    paramParcel.writeString(this.HZV);
    paramParcel.writeString(this.HZW);
    paramParcel.writeString(this.HZX);
    AppMethodBeat.o(70325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo
 * JD-Core Version:    0.7.0.1
 */