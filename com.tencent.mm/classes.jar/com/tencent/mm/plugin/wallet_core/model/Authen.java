package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR = new Authen.1();
  public int bcw;
  public String cCA;
  public String cCB;
  public String cCt;
  public String country;
  public String ekZ;
  public String ftq;
  public String lnV;
  public String mOb;
  public String mOc;
  public PayInfo nqa = new PayInfo();
  public String qjv;
  public String qqU;
  public int qsH = 0;
  public String qsI;
  public String qsJ;
  public String qsK;
  public int qsL;
  public String qsM;
  public String qsN;
  public String qsO;
  public String qsP;
  public String qsQ;
  public String qsR;
  public String qsS;
  public String qsT;
  public String qsU;
  public String qsV;
  public String qsW;
  public String qsX;
  public String qsY;
  public String qsZ;
  public int qta;
  public String qtb;
  public String qtc;
  public String token;
  
  public Authen() {}
  
  public Authen(Parcel paramParcel)
  {
    this.bcw = paramParcel.readInt();
    this.qsI = paramParcel.readString();
    this.mOb = paramParcel.readString();
    this.mOc = paramParcel.readString();
    this.qsJ = paramParcel.readString();
    this.qsK = paramParcel.readString();
    this.qsL = paramParcel.readInt();
    this.qqU = paramParcel.readString();
    this.qsM = paramParcel.readString();
    this.qsN = paramParcel.readString();
    this.qsO = paramParcel.readString();
    this.token = paramParcel.readString();
    this.qsR = paramParcel.readString();
    this.qsS = paramParcel.readString();
    this.country = paramParcel.readString();
    this.cCA = paramParcel.readString();
    this.cCB = paramParcel.readString();
    this.ekZ = paramParcel.readString();
    this.lnV = paramParcel.readString();
    this.ftq = paramParcel.readString();
    this.cCt = paramParcel.readString();
    this.qjv = paramParcel.readString();
    this.qsT = paramParcel.readString();
    this.qsU = paramParcel.readString();
    this.qsQ = paramParcel.readString();
    this.qsV = paramParcel.readString();
    this.qsW = paramParcel.readString();
    this.qsX = paramParcel.readString();
    this.qsY = paramParcel.readString();
    this.qsZ = paramParcel.readString();
    this.qta = paramParcel.readInt();
    this.qtb = paramParcel.readString();
    this.qtc = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.bcw);
    paramParcel.writeString(bk.aM(this.qsI, ""));
    paramParcel.writeString(bk.aM(this.mOb, ""));
    paramParcel.writeString(bk.aM(this.mOc, ""));
    paramParcel.writeString(bk.aM(this.qsJ, ""));
    paramParcel.writeString(bk.aM(this.qsK, ""));
    paramParcel.writeInt(this.qsL);
    paramParcel.writeString(bk.aM(this.qqU, ""));
    paramParcel.writeString(bk.aM(this.qsM, ""));
    paramParcel.writeString(bk.aM(this.qsN, ""));
    paramParcel.writeString(bk.aM(this.qsO, ""));
    paramParcel.writeString(bk.aM(this.token, ""));
    paramParcel.writeString(bk.aM(this.qsR, ""));
    paramParcel.writeString(bk.aM(this.qsS, ""));
    paramParcel.writeString(bk.aM(this.country, ""));
    paramParcel.writeString(bk.aM(this.cCA, ""));
    paramParcel.writeString(bk.aM(this.cCB, ""));
    paramParcel.writeString(bk.aM(this.ekZ, ""));
    paramParcel.writeString(bk.aM(this.lnV, ""));
    paramParcel.writeString(bk.aM(this.ftq, ""));
    paramParcel.writeString(bk.aM(this.cCt, ""));
    paramParcel.writeString(bk.aM(this.qjv, ""));
    paramParcel.writeString(bk.aM(this.qsT, ""));
    paramParcel.writeString(bk.aM(this.qsU, ""));
    paramParcel.writeString(bk.aM(this.qsQ, ""));
    paramParcel.writeString(bk.aM(this.qsV, ""));
    paramParcel.writeString(bk.aM(this.qsW, ""));
    paramParcel.writeString(bk.aM(this.qsX, ""));
    paramParcel.writeString(bk.aM(this.qsY, ""));
    paramParcel.writeString(bk.aM(this.qsZ, ""));
    paramParcel.writeInt(bk.a(Integer.valueOf(this.qta), 0));
    paramParcel.writeString(bk.aM(this.qtb, ""));
    paramParcel.writeString(bk.aM(this.qtc, ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */