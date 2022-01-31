package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class Orders$DeductInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeductInfo> CREATOR;
  public String desc;
  public String knU;
  public int tWu;
  public String tWv;
  public int tXg;
  public String title;
  public String ujY;
  public List<Orders.DeductShowInfo> ujZ;
  public int uka;
  public String ukb;
  public String ukc;
  
  static
  {
    AppMethodBeat.i(46803);
    CREATOR = new Orders.DeductInfo.1();
    AppMethodBeat.o(46803);
  }
  
  public Orders$DeductInfo()
  {
    AppMethodBeat.i(46800);
    this.ujZ = new ArrayList();
    AppMethodBeat.o(46800);
  }
  
  public Orders$DeductInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46801);
    this.ujZ = new ArrayList();
    this.title = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.tXg = paramParcel.readInt();
    this.ujY = paramParcel.readString();
    this.uka = paramParcel.readInt();
    paramParcel.readTypedList(this.ujZ, Orders.DeductShowInfo.CREATOR);
    this.tWu = paramParcel.readInt();
    this.knU = paramParcel.readString();
    this.tWv = paramParcel.readString();
    this.ukb = paramParcel.readString();
    this.ukc = paramParcel.readString();
    AppMethodBeat.o(46801);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46802);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.tXg);
    paramParcel.writeString(this.ujY);
    paramParcel.writeInt(this.uka);
    paramParcel.writeTypedList(this.ujZ);
    paramParcel.writeInt(this.tWu);
    paramParcel.writeString(this.knU);
    paramParcel.writeString(this.tWv);
    paramParcel.writeString(this.ukb);
    paramParcel.writeString(this.ukc);
    AppMethodBeat.o(46802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo
 * JD-Core Version:    0.7.0.1
 */