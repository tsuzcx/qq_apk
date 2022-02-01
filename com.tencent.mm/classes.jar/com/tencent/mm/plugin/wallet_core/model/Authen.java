package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bt;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR;
  public String CFm;
  public String CPf;
  public String CPp;
  public int CTO;
  public String CTP;
  public String CTQ;
  public int CTR;
  public String CTS;
  public String CTT;
  public String CTU;
  public String CTV;
  public String CTW;
  public String CTX;
  public String CTY;
  public String CTZ;
  public String CTa;
  public int CTk;
  public String CTl;
  public String CTp;
  public String CUa;
  public String CUb;
  public String CUc;
  public String CUd;
  public String CUe;
  public int CUf;
  public String CUg;
  public String country;
  public int dDp;
  public String dkR;
  public String ePn;
  public String ePu;
  public String ePv;
  public String hWY;
  public String jrN;
  public String tUK;
  public String token;
  public String uJH;
  public String wBI;
  public PayInfo xnF;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.CTO = 0;
    this.xnF = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.CTO = 0;
    this.xnF = new PayInfo();
    this.dDp = paramParcel.readInt();
    this.CTP = paramParcel.readString();
    this.dkR = paramParcel.readString();
    this.wBI = paramParcel.readString();
    this.CTa = paramParcel.readString();
    this.CTQ = paramParcel.readString();
    this.CTR = paramParcel.readInt();
    this.CPf = paramParcel.readString();
    this.CTS = paramParcel.readString();
    this.CTT = paramParcel.readString();
    this.CTU = paramParcel.readString();
    this.token = paramParcel.readString();
    this.CTW = paramParcel.readString();
    this.CTX = paramParcel.readString();
    this.country = paramParcel.readString();
    this.ePu = paramParcel.readString();
    this.ePv = paramParcel.readString();
    this.hWY = paramParcel.readString();
    this.uJH = paramParcel.readString();
    this.jrN = paramParcel.readString();
    this.ePn = paramParcel.readString();
    this.CFm = paramParcel.readString();
    this.CTY = paramParcel.readString();
    this.CTZ = paramParcel.readString();
    this.CTV = paramParcel.readString();
    this.CUa = paramParcel.readString();
    this.CUb = paramParcel.readString();
    this.CUc = paramParcel.readString();
    this.CUd = paramParcel.readString();
    this.CUe = paramParcel.readString();
    this.CTk = paramParcel.readInt();
    this.CTp = paramParcel.readString();
    this.CTl = paramParcel.readString();
    this.CUf = paramParcel.readInt();
    this.CPp = paramParcel.readString();
    this.CUg = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.dDp);
    paramParcel.writeString(bt.bI(this.CTP, ""));
    paramParcel.writeString(bt.bI(this.dkR, ""));
    paramParcel.writeString(bt.bI(this.wBI, ""));
    paramParcel.writeString(bt.bI(this.CTa, ""));
    paramParcel.writeString(bt.bI(this.CTQ, ""));
    paramParcel.writeInt(this.CTR);
    paramParcel.writeString(bt.bI(this.CPf, ""));
    paramParcel.writeString(bt.bI(this.CTS, ""));
    paramParcel.writeString(bt.bI(this.CTT, ""));
    paramParcel.writeString(bt.bI(this.CTU, ""));
    paramParcel.writeString(bt.bI(this.token, ""));
    paramParcel.writeString(bt.bI(this.CTW, ""));
    paramParcel.writeString(bt.bI(this.CTX, ""));
    paramParcel.writeString(bt.bI(this.country, ""));
    paramParcel.writeString(bt.bI(this.ePu, ""));
    paramParcel.writeString(bt.bI(this.ePv, ""));
    paramParcel.writeString(bt.bI(this.hWY, ""));
    paramParcel.writeString(bt.bI(this.uJH, ""));
    paramParcel.writeString(bt.bI(this.jrN, ""));
    paramParcel.writeString(bt.bI(this.ePn, ""));
    paramParcel.writeString(bt.bI(this.CFm, ""));
    paramParcel.writeString(bt.bI(this.CTY, ""));
    paramParcel.writeString(bt.bI(this.CTZ, ""));
    paramParcel.writeString(bt.bI(this.CTV, ""));
    paramParcel.writeString(bt.bI(this.CUa, ""));
    paramParcel.writeString(bt.bI(this.CUb, ""));
    paramParcel.writeString(bt.bI(this.CUc, ""));
    paramParcel.writeString(bt.bI(this.CUd, ""));
    paramParcel.writeString(bt.bI(this.CUe, ""));
    paramParcel.writeInt(bt.a(Integer.valueOf(this.CTk), 0));
    paramParcel.writeString(bt.bI(this.CTp, ""));
    paramParcel.writeString(bt.bI(this.CTl, ""));
    paramParcel.writeInt(bt.a(Integer.valueOf(this.CUf), 0));
    paramParcel.writeString(bt.bI(this.CPp, ""));
    paramParcel.writeString(bt.bI(this.CUg, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */