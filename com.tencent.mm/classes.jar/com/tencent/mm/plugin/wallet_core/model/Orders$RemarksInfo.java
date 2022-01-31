package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$RemarksInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RemarksInfo> CREATOR;
  public String uky;
  public String ukz;
  
  static
  {
    AppMethodBeat.i(46823);
    CREATOR = new Orders.RemarksInfo.1();
    AppMethodBeat.o(46823);
  }
  
  public Orders$RemarksInfo() {}
  
  protected Orders$RemarksInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46821);
    this.uky = paramParcel.readString();
    this.ukz = paramParcel.readString();
    AppMethodBeat.o(46821);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46822);
    paramParcel.writeString(this.uky);
    paramParcel.writeString(this.ukz);
    AppMethodBeat.o(46822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo
 * JD-Core Version:    0.7.0.1
 */