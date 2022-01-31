package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetScenePayUElementQuery$PayUBankcardElement
  implements Parcelable
{
  public String cardType = "";
  public String czq = "";
  public String ppn = "";
  public String uBP = "";
  public String uBQ = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48334);
    paramParcel.writeString(this.uBP);
    paramParcel.writeString(this.ppn);
    paramParcel.writeString(this.uBQ);
    paramParcel.writeString(this.cardType);
    paramParcel.writeString(this.czq);
    AppMethodBeat.o(48334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement
 * JD-Core Version:    0.7.0.1
 */