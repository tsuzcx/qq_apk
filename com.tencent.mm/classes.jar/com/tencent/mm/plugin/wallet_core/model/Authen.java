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
  public int AaB;
  public String AaC;
  public String AaG;
  public String Aar;
  public int Abf;
  public String Abg;
  public String Abh;
  public int Abi;
  public String Abj;
  public String Abk;
  public String Abl;
  public String Abm;
  public String Abn;
  public String Abo;
  public String Abp;
  public String Abq;
  public String Abr;
  public String Abs;
  public String Abt;
  public String Abu;
  public String Abv;
  public int Abw;
  public String Abx;
  public String country;
  public String dca;
  public int dtM;
  public String evA;
  public String evs;
  public String evz;
  public String hdQ;
  public String iyB;
  public String sqX;
  public String szk;
  public String token;
  public PayInfo uXi;
  public String uns;
  public String zMD;
  public String zWG;
  public String zWw;
  
  static
  {
    AppMethodBeat.i(70210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70210);
  }
  
  public Authen()
  {
    AppMethodBeat.i(70208);
    this.Abf = 0;
    this.uXi = new PayInfo();
    AppMethodBeat.o(70208);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(70209);
    this.Abf = 0;
    this.uXi = new PayInfo();
    this.dtM = paramParcel.readInt();
    this.Abg = paramParcel.readString();
    this.dca = paramParcel.readString();
    this.uns = paramParcel.readString();
    this.Aar = paramParcel.readString();
    this.Abh = paramParcel.readString();
    this.Abi = paramParcel.readInt();
    this.zWw = paramParcel.readString();
    this.Abj = paramParcel.readString();
    this.Abk = paramParcel.readString();
    this.Abl = paramParcel.readString();
    this.token = paramParcel.readString();
    this.Abn = paramParcel.readString();
    this.Abo = paramParcel.readString();
    this.country = paramParcel.readString();
    this.evz = paramParcel.readString();
    this.evA = paramParcel.readString();
    this.hdQ = paramParcel.readString();
    this.szk = paramParcel.readString();
    this.iyB = paramParcel.readString();
    this.evs = paramParcel.readString();
    this.zMD = paramParcel.readString();
    this.Abp = paramParcel.readString();
    this.Abq = paramParcel.readString();
    this.Abm = paramParcel.readString();
    this.Abr = paramParcel.readString();
    this.Abs = paramParcel.readString();
    this.Abt = paramParcel.readString();
    this.Abu = paramParcel.readString();
    this.Abv = paramParcel.readString();
    this.AaB = paramParcel.readInt();
    this.AaG = paramParcel.readString();
    this.AaC = paramParcel.readString();
    this.Abw = paramParcel.readInt();
    this.zWG = paramParcel.readString();
    this.Abx = paramParcel.readString();
    AppMethodBeat.o(70209);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70207);
    paramParcel.writeInt(this.dtM);
    paramParcel.writeString(bt.by(this.Abg, ""));
    paramParcel.writeString(bt.by(this.dca, ""));
    paramParcel.writeString(bt.by(this.uns, ""));
    paramParcel.writeString(bt.by(this.Aar, ""));
    paramParcel.writeString(bt.by(this.Abh, ""));
    paramParcel.writeInt(this.Abi);
    paramParcel.writeString(bt.by(this.zWw, ""));
    paramParcel.writeString(bt.by(this.Abj, ""));
    paramParcel.writeString(bt.by(this.Abk, ""));
    paramParcel.writeString(bt.by(this.Abl, ""));
    paramParcel.writeString(bt.by(this.token, ""));
    paramParcel.writeString(bt.by(this.Abn, ""));
    paramParcel.writeString(bt.by(this.Abo, ""));
    paramParcel.writeString(bt.by(this.country, ""));
    paramParcel.writeString(bt.by(this.evz, ""));
    paramParcel.writeString(bt.by(this.evA, ""));
    paramParcel.writeString(bt.by(this.hdQ, ""));
    paramParcel.writeString(bt.by(this.szk, ""));
    paramParcel.writeString(bt.by(this.iyB, ""));
    paramParcel.writeString(bt.by(this.evs, ""));
    paramParcel.writeString(bt.by(this.zMD, ""));
    paramParcel.writeString(bt.by(this.Abp, ""));
    paramParcel.writeString(bt.by(this.Abq, ""));
    paramParcel.writeString(bt.by(this.Abm, ""));
    paramParcel.writeString(bt.by(this.Abr, ""));
    paramParcel.writeString(bt.by(this.Abs, ""));
    paramParcel.writeString(bt.by(this.Abt, ""));
    paramParcel.writeString(bt.by(this.Abu, ""));
    paramParcel.writeString(bt.by(this.Abv, ""));
    paramParcel.writeInt(bt.a(Integer.valueOf(this.AaB), 0));
    paramParcel.writeString(bt.by(this.AaG, ""));
    paramParcel.writeString(bt.by(this.AaC, ""));
    paramParcel.writeInt(bt.a(Integer.valueOf(this.Abw), 0));
    paramParcel.writeString(bt.by(this.zWG, ""));
    paramParcel.writeString(bt.by(this.Abx, ""));
    AppMethodBeat.o(70207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */