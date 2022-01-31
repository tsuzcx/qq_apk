package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class Orders$Commodity
  implements Parcelable
{
  public static final Parcelable.Creator<Commodity> CREATOR;
  public String cnJ;
  public String desc;
  public double kNS;
  public String poT;
  public String ppb;
  public String ppc;
  public String ppd;
  public String ppe;
  public String ppg;
  public String ppi;
  public String ppj;
  public int ppl;
  public String ppn;
  public String ppp;
  public String ppq;
  public String ppu;
  public double ujM;
  public String ujN;
  public String ujO;
  public List<Orders.DiscountInfo> ujP;
  public String ujQ;
  public String ujR;
  public String ujS;
  public Orders.RecommendTinyAppInfo ujT;
  public Orders.RemarksInfo ujU;
  public List<Orders.Promotions> ujV;
  public boolean ujW;
  public Orders.a ujX;
  public int ujc;
  
  static
  {
    AppMethodBeat.i(46798);
    CREATOR = new Orders.Commodity.1();
    AppMethodBeat.o(46798);
  }
  
  public Orders$Commodity()
  {
    AppMethodBeat.i(46795);
    this.kNS = 0.0D;
    this.ujM = 0.0D;
    this.ujP = new ArrayList();
    this.ujT = null;
    this.ujV = new ArrayList();
    this.ujW = false;
    this.ujX = new Orders.a();
    AppMethodBeat.o(46795);
  }
  
  public Orders$Commodity(Parcel paramParcel)
  {
    AppMethodBeat.i(46796);
    this.kNS = 0.0D;
    this.ujM = 0.0D;
    this.ujP = new ArrayList();
    this.ujT = null;
    this.ujV = new ArrayList();
    this.ujW = false;
    this.ujX = new Orders.a();
    this.ppb = paramParcel.readString();
    this.ppc = paramParcel.readString();
    this.ppd = paramParcel.readString();
    this.ppe = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.ppg = paramParcel.readString();
    this.kNS = paramParcel.readDouble();
    this.ppi = paramParcel.readString();
    this.ppj = paramParcel.readString();
    this.ppl = paramParcel.readInt();
    this.cnJ = paramParcel.readString();
    this.ppn = paramParcel.readString();
    this.ppp = paramParcel.readString();
    this.ppq = paramParcel.readString();
    this.poT = paramParcel.readString();
    this.ujO = paramParcel.readString();
    this.ppu = paramParcel.readString();
    paramParcel.readTypedList(this.ujP, Orders.DiscountInfo.CREATOR);
    this.ujQ = paramParcel.readString();
    this.ujS = paramParcel.readString();
    this.ujT = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
    paramParcel.readTypedList(this.ujV, Orders.Promotions.CREATOR);
    this.ujU = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ujW = bool;
      AppMethodBeat.o(46796);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b = 0;
    AppMethodBeat.i(46797);
    paramParcel.writeString(this.ppb);
    paramParcel.writeString(this.ppc);
    paramParcel.writeString(this.ppd);
    paramParcel.writeString(this.ppe);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.ppg);
    paramParcel.writeDouble(this.kNS);
    paramParcel.writeString(this.ppi);
    paramParcel.writeString(this.ppj);
    paramParcel.writeInt(this.ppl);
    paramParcel.writeString(this.cnJ);
    paramParcel.writeString(this.ppn);
    paramParcel.writeString(this.ppp);
    paramParcel.writeString(this.ppq);
    paramParcel.writeString(this.poT);
    paramParcel.writeString(this.ujO);
    paramParcel.writeString(this.ppu);
    paramParcel.writeTypedList(this.ujP);
    paramParcel.writeString(this.ujQ);
    paramParcel.writeString(this.ujS);
    paramParcel.writeParcelable(this.ujT, 0);
    paramParcel.writeTypedList(this.ujV);
    paramParcel.writeParcelable(this.ujU, 0);
    if (this.ujW) {
      b = 1;
    }
    paramParcel.writeByte(b);
    AppMethodBeat.o(46797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.Commodity
 * JD-Core Version:    0.7.0.1
 */