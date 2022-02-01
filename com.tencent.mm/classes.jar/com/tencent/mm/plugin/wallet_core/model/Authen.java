package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bu;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR;
  public String CWS;
  public String DgJ;
  public String DgT;
  public String DkG;
  public int DkQ;
  public String DkR;
  public String DkV;
  public String DlA;
  public String DlB;
  public String DlC;
  public String DlD;
  public String DlE;
  public String DlF;
  public String DlG;
  public String DlH;
  public String DlI;
  public String DlJ;
  public String DlK;
  public int DlL;
  public String DlM;
  public int Dlu;
  public String Dlv;
  public String Dlw;
  public int Dlx;
  public String Dly;
  public String Dlz;
  public String country;
  public int dEu;
  public String dlT;
  public String eQY;
  public String eRf;
  public String eRg;
  public String hZQ;
  public String juG;
  public String token;
  public String uVu;
  public String ufC;
  public String wRt;
  public PayInfo xDC;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.Dlu = 0;
    this.xDC = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.Dlu = 0;
    this.xDC = new PayInfo();
    this.dEu = paramParcel.readInt();
    this.Dlv = paramParcel.readString();
    this.dlT = paramParcel.readString();
    this.wRt = paramParcel.readString();
    this.DkG = paramParcel.readString();
    this.Dlw = paramParcel.readString();
    this.Dlx = paramParcel.readInt();
    this.DgJ = paramParcel.readString();
    this.Dly = paramParcel.readString();
    this.Dlz = paramParcel.readString();
    this.DlA = paramParcel.readString();
    this.token = paramParcel.readString();
    this.DlC = paramParcel.readString();
    this.DlD = paramParcel.readString();
    this.country = paramParcel.readString();
    this.eRf = paramParcel.readString();
    this.eRg = paramParcel.readString();
    this.hZQ = paramParcel.readString();
    this.uVu = paramParcel.readString();
    this.juG = paramParcel.readString();
    this.eQY = paramParcel.readString();
    this.CWS = paramParcel.readString();
    this.DlE = paramParcel.readString();
    this.DlF = paramParcel.readString();
    this.DlB = paramParcel.readString();
    this.DlG = paramParcel.readString();
    this.DlH = paramParcel.readString();
    this.DlI = paramParcel.readString();
    this.DlJ = paramParcel.readString();
    this.DlK = paramParcel.readString();
    this.DkQ = paramParcel.readInt();
    this.DkV = paramParcel.readString();
    this.DkR = paramParcel.readString();
    this.DlL = paramParcel.readInt();
    this.DgT = paramParcel.readString();
    this.DlM = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.dEu);
    paramParcel.writeString(bu.bI(this.Dlv, ""));
    paramParcel.writeString(bu.bI(this.dlT, ""));
    paramParcel.writeString(bu.bI(this.wRt, ""));
    paramParcel.writeString(bu.bI(this.DkG, ""));
    paramParcel.writeString(bu.bI(this.Dlw, ""));
    paramParcel.writeInt(this.Dlx);
    paramParcel.writeString(bu.bI(this.DgJ, ""));
    paramParcel.writeString(bu.bI(this.Dly, ""));
    paramParcel.writeString(bu.bI(this.Dlz, ""));
    paramParcel.writeString(bu.bI(this.DlA, ""));
    paramParcel.writeString(bu.bI(this.token, ""));
    paramParcel.writeString(bu.bI(this.DlC, ""));
    paramParcel.writeString(bu.bI(this.DlD, ""));
    paramParcel.writeString(bu.bI(this.country, ""));
    paramParcel.writeString(bu.bI(this.eRf, ""));
    paramParcel.writeString(bu.bI(this.eRg, ""));
    paramParcel.writeString(bu.bI(this.hZQ, ""));
    paramParcel.writeString(bu.bI(this.uVu, ""));
    paramParcel.writeString(bu.bI(this.juG, ""));
    paramParcel.writeString(bu.bI(this.eQY, ""));
    paramParcel.writeString(bu.bI(this.CWS, ""));
    paramParcel.writeString(bu.bI(this.DlE, ""));
    paramParcel.writeString(bu.bI(this.DlF, ""));
    paramParcel.writeString(bu.bI(this.DlB, ""));
    paramParcel.writeString(bu.bI(this.DlG, ""));
    paramParcel.writeString(bu.bI(this.DlH, ""));
    paramParcel.writeString(bu.bI(this.DlI, ""));
    paramParcel.writeString(bu.bI(this.DlJ, ""));
    paramParcel.writeString(bu.bI(this.DlK, ""));
    paramParcel.writeInt(bu.a(Integer.valueOf(this.DkQ), 0));
    paramParcel.writeString(bu.bI(this.DkV, ""));
    paramParcel.writeString(bu.bI(this.DkR, ""));
    paramParcel.writeInt(bu.a(Integer.valueOf(this.DlL), 0));
    paramParcel.writeString(bu.bI(this.DgT, ""));
    paramParcel.writeString(bu.bI(this.DlM, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */