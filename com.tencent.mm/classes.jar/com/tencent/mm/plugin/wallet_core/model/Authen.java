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
  public String ANo;
  public PayInfo BDB;
  public String HCy;
  public String HQc;
  public String HQm;
  public String HTZ;
  public int HUN;
  public String HUO;
  public String HUP;
  public int HUQ;
  public String HUR;
  public String HUS;
  public String HUT;
  public String HUU;
  public String HUV;
  public String HUW;
  public String HUX;
  public String HUY;
  public String HUZ;
  public int HUj;
  public String HUk;
  public String HUo;
  public String HVa;
  public String HVb;
  public String HVc;
  public String HVd;
  public int HVe;
  public String HVf;
  public int cSx;
  public String country;
  public String dDj;
  public String fuD;
  public String fuJ;
  public String fuK;
  public String iUO;
  public String ksV;
  public String token;
  public String xxN;
  public String ynV;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.HUN = 0;
    this.BDB = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.HUN = 0;
    this.BDB = new PayInfo();
    this.cSx = paramParcel.readInt();
    this.HUO = paramParcel.readString();
    this.dDj = paramParcel.readString();
    this.ANo = paramParcel.readString();
    this.HTZ = paramParcel.readString();
    this.HUP = paramParcel.readString();
    this.HUQ = paramParcel.readInt();
    this.HQc = paramParcel.readString();
    this.HUR = paramParcel.readString();
    this.HUS = paramParcel.readString();
    this.HUT = paramParcel.readString();
    this.token = paramParcel.readString();
    this.HUV = paramParcel.readString();
    this.HUW = paramParcel.readString();
    this.country = paramParcel.readString();
    this.fuJ = paramParcel.readString();
    this.fuK = paramParcel.readString();
    this.iUO = paramParcel.readString();
    this.ynV = paramParcel.readString();
    this.ksV = paramParcel.readString();
    this.fuD = paramParcel.readString();
    this.HCy = paramParcel.readString();
    this.HUX = paramParcel.readString();
    this.HUY = paramParcel.readString();
    this.HUU = paramParcel.readString();
    this.HUZ = paramParcel.readString();
    this.HVa = paramParcel.readString();
    this.HVb = paramParcel.readString();
    this.HVc = paramParcel.readString();
    this.HVd = paramParcel.readString();
    this.HUj = paramParcel.readInt();
    this.HUo = paramParcel.readString();
    this.HUk = paramParcel.readString();
    this.HVe = paramParcel.readInt();
    this.HQm = paramParcel.readString();
    this.HVf = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.cSx);
    paramParcel.writeString(Util.nullAs(this.HUO, ""));
    paramParcel.writeString(Util.nullAs(this.dDj, ""));
    paramParcel.writeString(Util.nullAs(this.ANo, ""));
    paramParcel.writeString(Util.nullAs(this.HTZ, ""));
    paramParcel.writeString(Util.nullAs(this.HUP, ""));
    paramParcel.writeInt(this.HUQ);
    paramParcel.writeString(Util.nullAs(this.HQc, ""));
    paramParcel.writeString(Util.nullAs(this.HUR, ""));
    paramParcel.writeString(Util.nullAs(this.HUS, ""));
    paramParcel.writeString(Util.nullAs(this.HUT, ""));
    paramParcel.writeString(Util.nullAs(this.token, ""));
    paramParcel.writeString(Util.nullAs(this.HUV, ""));
    paramParcel.writeString(Util.nullAs(this.HUW, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.fuJ, ""));
    paramParcel.writeString(Util.nullAs(this.fuK, ""));
    paramParcel.writeString(Util.nullAs(this.iUO, ""));
    paramParcel.writeString(Util.nullAs(this.ynV, ""));
    paramParcel.writeString(Util.nullAs(this.ksV, ""));
    paramParcel.writeString(Util.nullAs(this.fuD, ""));
    paramParcel.writeString(Util.nullAs(this.HCy, ""));
    paramParcel.writeString(Util.nullAs(this.HUX, ""));
    paramParcel.writeString(Util.nullAs(this.HUY, ""));
    paramParcel.writeString(Util.nullAs(this.HUU, ""));
    paramParcel.writeString(Util.nullAs(this.HUZ, ""));
    paramParcel.writeString(Util.nullAs(this.HVa, ""));
    paramParcel.writeString(Util.nullAs(this.HVb, ""));
    paramParcel.writeString(Util.nullAs(this.HVc, ""));
    paramParcel.writeString(Util.nullAs(this.HVd, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.HUj), 0));
    paramParcel.writeString(Util.nullAs(this.HUo, ""));
    paramParcel.writeString(Util.nullAs(this.HUk, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.HVe), 0));
    paramParcel.writeString(Util.nullAs(this.HQm, ""));
    paramParcel.writeString(Util.nullAs(this.HVf, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */