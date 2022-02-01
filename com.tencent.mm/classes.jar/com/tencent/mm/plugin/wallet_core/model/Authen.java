package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bs;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR;
  public String BeX;
  public String BoQ;
  public String Bpa;
  public String BsL;
  public int BsV;
  public String BsW;
  public String BtA;
  public String BtB;
  public int BtC;
  public String BtD;
  public String BtE;
  public String BtF;
  public String BtG;
  public String BtH;
  public String BtI;
  public String BtJ;
  public String BtK;
  public String BtL;
  public String BtM;
  public String BtN;
  public String BtO;
  public String BtP;
  public int BtQ;
  public String BtR;
  public String Bta;
  public int Btz;
  public String cZz;
  public String country;
  public int drx;
  public String exO;
  public String exV;
  public String exW;
  public String hEt;
  public String iYE;
  public String tGU;
  public String token;
  public String tyP;
  public String vwo;
  public PayInfo wfX;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.Btz = 0;
    this.wfX = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.Btz = 0;
    this.wfX = new PayInfo();
    this.drx = paramParcel.readInt();
    this.BtA = paramParcel.readString();
    this.cZz = paramParcel.readString();
    this.vwo = paramParcel.readString();
    this.BsL = paramParcel.readString();
    this.BtB = paramParcel.readString();
    this.BtC = paramParcel.readInt();
    this.BoQ = paramParcel.readString();
    this.BtD = paramParcel.readString();
    this.BtE = paramParcel.readString();
    this.BtF = paramParcel.readString();
    this.token = paramParcel.readString();
    this.BtH = paramParcel.readString();
    this.BtI = paramParcel.readString();
    this.country = paramParcel.readString();
    this.exV = paramParcel.readString();
    this.exW = paramParcel.readString();
    this.hEt = paramParcel.readString();
    this.tGU = paramParcel.readString();
    this.iYE = paramParcel.readString();
    this.exO = paramParcel.readString();
    this.BeX = paramParcel.readString();
    this.BtJ = paramParcel.readString();
    this.BtK = paramParcel.readString();
    this.BtG = paramParcel.readString();
    this.BtL = paramParcel.readString();
    this.BtM = paramParcel.readString();
    this.BtN = paramParcel.readString();
    this.BtO = paramParcel.readString();
    this.BtP = paramParcel.readString();
    this.BsV = paramParcel.readInt();
    this.Bta = paramParcel.readString();
    this.BsW = paramParcel.readString();
    this.BtQ = paramParcel.readInt();
    this.Bpa = paramParcel.readString();
    this.BtR = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.drx);
    paramParcel.writeString(bs.bG(this.BtA, ""));
    paramParcel.writeString(bs.bG(this.cZz, ""));
    paramParcel.writeString(bs.bG(this.vwo, ""));
    paramParcel.writeString(bs.bG(this.BsL, ""));
    paramParcel.writeString(bs.bG(this.BtB, ""));
    paramParcel.writeInt(this.BtC);
    paramParcel.writeString(bs.bG(this.BoQ, ""));
    paramParcel.writeString(bs.bG(this.BtD, ""));
    paramParcel.writeString(bs.bG(this.BtE, ""));
    paramParcel.writeString(bs.bG(this.BtF, ""));
    paramParcel.writeString(bs.bG(this.token, ""));
    paramParcel.writeString(bs.bG(this.BtH, ""));
    paramParcel.writeString(bs.bG(this.BtI, ""));
    paramParcel.writeString(bs.bG(this.country, ""));
    paramParcel.writeString(bs.bG(this.exV, ""));
    paramParcel.writeString(bs.bG(this.exW, ""));
    paramParcel.writeString(bs.bG(this.hEt, ""));
    paramParcel.writeString(bs.bG(this.tGU, ""));
    paramParcel.writeString(bs.bG(this.iYE, ""));
    paramParcel.writeString(bs.bG(this.exO, ""));
    paramParcel.writeString(bs.bG(this.BeX, ""));
    paramParcel.writeString(bs.bG(this.BtJ, ""));
    paramParcel.writeString(bs.bG(this.BtK, ""));
    paramParcel.writeString(bs.bG(this.BtG, ""));
    paramParcel.writeString(bs.bG(this.BtL, ""));
    paramParcel.writeString(bs.bG(this.BtM, ""));
    paramParcel.writeString(bs.bG(this.BtN, ""));
    paramParcel.writeString(bs.bG(this.BtO, ""));
    paramParcel.writeString(bs.bG(this.BtP, ""));
    paramParcel.writeInt(bs.a(Integer.valueOf(this.BsV), 0));
    paramParcel.writeString(bs.bG(this.Bta, ""));
    paramParcel.writeString(bs.bG(this.BsW, ""));
    paramParcel.writeInt(bs.a(Integer.valueOf(this.BtQ), 0));
    paramParcel.writeString(bs.bG(this.Bpa, ""));
    paramParcel.writeString(bs.bG(this.BtR, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */