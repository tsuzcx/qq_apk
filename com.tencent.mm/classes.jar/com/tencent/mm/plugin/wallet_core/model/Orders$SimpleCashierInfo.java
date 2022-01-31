package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$SimpleCashierInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
  public String poq;
  public String por;
  public int ukG;
  
  static
  {
    AppMethodBeat.i(46832);
    CREATOR = new Orders.SimpleCashierInfo.1();
    AppMethodBeat.o(46832);
  }
  
  public Orders$SimpleCashierInfo() {}
  
  protected Orders$SimpleCashierInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46830);
    this.ukG = paramParcel.readInt();
    this.poq = paramParcel.readString();
    this.por = paramParcel.readString();
    AppMethodBeat.o(46830);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46831);
    paramParcel.writeInt(this.ukG);
    paramParcel.writeString(this.poq);
    paramParcel.writeString(this.por);
    AppMethodBeat.o(46831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo
 * JD-Core Version:    0.7.0.1
 */