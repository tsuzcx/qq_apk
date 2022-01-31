package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$RecommendTinyAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
  public String uaK;
  public String uaL;
  public String ugl;
  public String uiQ;
  public String uiR;
  public String uiS;
  public int uiT;
  public long uks;
  public long ukt;
  public long uku;
  public int ukv;
  public int ukw;
  public long ukx;
  
  static
  {
    AppMethodBeat.i(46819);
    CREATOR = new Orders.RecommendTinyAppInfo.1();
    AppMethodBeat.o(46819);
  }
  
  public Orders$RecommendTinyAppInfo() {}
  
  public Orders$RecommendTinyAppInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46817);
    this.uaK = paramParcel.readString();
    this.uiQ = paramParcel.readString();
    this.uiR = paramParcel.readString();
    this.ugl = paramParcel.readString();
    this.uaL = paramParcel.readString();
    this.uiT = paramParcel.readInt();
    AppMethodBeat.o(46817);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46818);
    paramParcel.writeString(this.uaK);
    paramParcel.writeString(this.uiQ);
    paramParcel.writeString(this.uiR);
    paramParcel.writeString(this.ugl);
    paramParcel.writeString(this.uaL);
    paramParcel.writeInt(this.uiT);
    AppMethodBeat.o(46818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo
 * JD-Core Version:    0.7.0.1
 */