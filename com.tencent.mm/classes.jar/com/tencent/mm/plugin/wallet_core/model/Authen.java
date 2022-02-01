package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Util;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR;
  public String CBX;
  public String DNX;
  public String GGC;
  public PayInfo HzF;
  public String OIl;
  public String OIv;
  public int OMO;
  public String OMP;
  public String OMQ;
  public int OMR;
  public String OMS;
  public String OMT;
  public String OMU;
  public String OMV;
  public String OMW;
  public String OMX;
  public String OMY;
  public String OMZ;
  public String OMa;
  public int OMk;
  public String OMl;
  public String OMp;
  public String ONa;
  public String ONb;
  public String ONc;
  public String ONd;
  public String ONe;
  public int ONf;
  public String ONg;
  public String Our;
  public int cUP;
  public String city;
  public String country;
  public String fvP;
  public String hDf;
  public String lLg;
  public String nkC;
  public String province;
  public String token;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.OMO = 0;
    this.HzF = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.OMO = 0;
    this.HzF = new PayInfo();
    this.cUP = paramParcel.readInt();
    this.OMP = paramParcel.readString();
    this.fvP = paramParcel.readString();
    this.GGC = paramParcel.readString();
    this.OMa = paramParcel.readString();
    this.OMQ = paramParcel.readString();
    this.OMR = paramParcel.readInt();
    this.OIl = paramParcel.readString();
    this.OMS = paramParcel.readString();
    this.OMT = paramParcel.readString();
    this.OMU = paramParcel.readString();
    this.token = paramParcel.readString();
    this.OMW = paramParcel.readString();
    this.OMX = paramParcel.readString();
    this.country = paramParcel.readString();
    this.province = paramParcel.readString();
    this.city = paramParcel.readString();
    this.lLg = paramParcel.readString();
    this.DNX = paramParcel.readString();
    this.nkC = paramParcel.readString();
    this.hDf = paramParcel.readString();
    this.Our = paramParcel.readString();
    this.OMY = paramParcel.readString();
    this.OMZ = paramParcel.readString();
    this.OMV = paramParcel.readString();
    this.ONa = paramParcel.readString();
    this.ONb = paramParcel.readString();
    this.ONc = paramParcel.readString();
    this.ONd = paramParcel.readString();
    this.ONe = paramParcel.readString();
    this.OMk = paramParcel.readInt();
    this.OMp = paramParcel.readString();
    this.OMl = paramParcel.readString();
    this.ONf = paramParcel.readInt();
    this.OIv = paramParcel.readString();
    this.ONg = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.cUP);
    paramParcel.writeString(Util.nullAs(this.OMP, ""));
    paramParcel.writeString(Util.nullAs(this.fvP, ""));
    paramParcel.writeString(Util.nullAs(this.GGC, ""));
    paramParcel.writeString(Util.nullAs(this.OMa, ""));
    paramParcel.writeString(Util.nullAs(this.OMQ, ""));
    paramParcel.writeInt(this.OMR);
    paramParcel.writeString(Util.nullAs(this.OIl, ""));
    paramParcel.writeString(Util.nullAs(this.OMS, ""));
    paramParcel.writeString(Util.nullAs(this.OMT, ""));
    paramParcel.writeString(Util.nullAs(this.OMU, ""));
    paramParcel.writeString(Util.nullAs(this.token, ""));
    paramParcel.writeString(Util.nullAs(this.OMW, ""));
    paramParcel.writeString(Util.nullAs(this.OMX, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.province, ""));
    paramParcel.writeString(Util.nullAs(this.city, ""));
    paramParcel.writeString(Util.nullAs(this.lLg, ""));
    paramParcel.writeString(Util.nullAs(this.DNX, ""));
    paramParcel.writeString(Util.nullAs(this.nkC, ""));
    paramParcel.writeString(Util.nullAs(this.hDf, ""));
    paramParcel.writeString(Util.nullAs(this.Our, ""));
    paramParcel.writeString(Util.nullAs(this.OMY, ""));
    paramParcel.writeString(Util.nullAs(this.OMZ, ""));
    paramParcel.writeString(Util.nullAs(this.OMV, ""));
    paramParcel.writeString(Util.nullAs(this.ONa, ""));
    paramParcel.writeString(Util.nullAs(this.ONb, ""));
    paramParcel.writeString(Util.nullAs(this.ONc, ""));
    paramParcel.writeString(Util.nullAs(this.ONd, ""));
    paramParcel.writeString(Util.nullAs(this.ONe, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.OMk), 0));
    paramParcel.writeString(Util.nullAs(this.OMp, ""));
    paramParcel.writeString(Util.nullAs(this.OMl, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.ONf), 0));
    paramParcel.writeString(Util.nullAs(this.OIv, ""));
    paramParcel.writeString(Util.nullAs(this.ONg, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */