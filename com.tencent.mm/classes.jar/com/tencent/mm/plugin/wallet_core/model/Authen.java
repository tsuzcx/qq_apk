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
  public String IvM;
  public String JFm;
  public String MDt;
  public PayInfo Nxi;
  public String VBL;
  public int VBV;
  public String VBW;
  public String VCA;
  public String VCB;
  public int VCC;
  public String VCD;
  public String VCE;
  public String VCF;
  public String VCG;
  public String VCH;
  public String VCI;
  public String VCJ;
  public String VCK;
  public String VCL;
  public String VCM;
  public String VCN;
  public String VCO;
  public String VCP;
  public int VCQ;
  public String VCR;
  public String VCa;
  public int VCz;
  public String VjF;
  public String VxX;
  public String Vyh;
  public String city;
  public String country;
  public int eQp;
  public String hAk;
  public String kab;
  public String oDI;
  public String province;
  public String qhL;
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
    this.VCz = 0;
    this.Nxi = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.VCz = 0;
    this.Nxi = new PayInfo();
    this.eQp = paramParcel.readInt();
    this.VCA = paramParcel.readString();
    this.hAk = paramParcel.readString();
    this.MDt = paramParcel.readString();
    this.VBL = paramParcel.readString();
    this.VCB = paramParcel.readString();
    this.VCC = paramParcel.readInt();
    this.VxX = paramParcel.readString();
    this.VCD = paramParcel.readString();
    this.VCE = paramParcel.readString();
    this.VCF = paramParcel.readString();
    this.token = paramParcel.readString();
    this.VCH = paramParcel.readString();
    this.VCI = paramParcel.readString();
    this.country = paramParcel.readString();
    this.province = paramParcel.readString();
    this.city = paramParcel.readString();
    this.oDI = paramParcel.readString();
    this.JFm = paramParcel.readString();
    this.qhL = paramParcel.readString();
    this.kab = paramParcel.readString();
    this.VjF = paramParcel.readString();
    this.VCJ = paramParcel.readString();
    this.VCK = paramParcel.readString();
    this.VCG = paramParcel.readString();
    this.VCL = paramParcel.readString();
    this.VCM = paramParcel.readString();
    this.VCN = paramParcel.readString();
    this.VCO = paramParcel.readString();
    this.VCP = paramParcel.readString();
    this.VBV = paramParcel.readInt();
    this.VCa = paramParcel.readString();
    this.VBW = paramParcel.readString();
    this.VCQ = paramParcel.readInt();
    this.Vyh = paramParcel.readString();
    this.VCR = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.eQp);
    paramParcel.writeString(Util.nullAs(this.VCA, ""));
    paramParcel.writeString(Util.nullAs(this.hAk, ""));
    paramParcel.writeString(Util.nullAs(this.MDt, ""));
    paramParcel.writeString(Util.nullAs(this.VBL, ""));
    paramParcel.writeString(Util.nullAs(this.VCB, ""));
    paramParcel.writeInt(this.VCC);
    paramParcel.writeString(Util.nullAs(this.VxX, ""));
    paramParcel.writeString(Util.nullAs(this.VCD, ""));
    paramParcel.writeString(Util.nullAs(this.VCE, ""));
    paramParcel.writeString(Util.nullAs(this.VCF, ""));
    paramParcel.writeString(Util.nullAs(this.token, ""));
    paramParcel.writeString(Util.nullAs(this.VCH, ""));
    paramParcel.writeString(Util.nullAs(this.VCI, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.province, ""));
    paramParcel.writeString(Util.nullAs(this.city, ""));
    paramParcel.writeString(Util.nullAs(this.oDI, ""));
    paramParcel.writeString(Util.nullAs(this.JFm, ""));
    paramParcel.writeString(Util.nullAs(this.qhL, ""));
    paramParcel.writeString(Util.nullAs(this.kab, ""));
    paramParcel.writeString(Util.nullAs(this.VjF, ""));
    paramParcel.writeString(Util.nullAs(this.VCJ, ""));
    paramParcel.writeString(Util.nullAs(this.VCK, ""));
    paramParcel.writeString(Util.nullAs(this.VCG, ""));
    paramParcel.writeString(Util.nullAs(this.VCL, ""));
    paramParcel.writeString(Util.nullAs(this.VCM, ""));
    paramParcel.writeString(Util.nullAs(this.VCN, ""));
    paramParcel.writeString(Util.nullAs(this.VCO, ""));
    paramParcel.writeString(Util.nullAs(this.VCP, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.VBV), 0));
    paramParcel.writeString(Util.nullAs(this.VCa, ""));
    paramParcel.writeString(Util.nullAs(this.VBW, ""));
    paramParcel.writeInt(Util.nullAs(Integer.valueOf(this.VCQ), 0));
    paramParcel.writeString(Util.nullAs(this.Vyh, ""));
    paramParcel.writeString(Util.nullAs(this.VCR, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */