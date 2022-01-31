package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;

public class Authen
  implements Parcelable
{
  public static final Parcelable.Creator<Authen> CREATOR;
  public int bsY;
  public String city;
  public String country;
  public String dqF;
  public String fBq;
  public String gKS;
  public String nLs;
  public PayInfo pVo;
  public String poq;
  public String por;
  public String province;
  public String tSv;
  public String token;
  public String ubQ;
  public int ueC;
  public String ueE;
  public int ueV;
  public String ueW;
  public String ueX;
  public int ueY;
  public String ueZ;
  public String ueu;
  public String ufa;
  public String ufb;
  public String ufc;
  public String ufd;
  public String ufe;
  public String uff;
  public String ufg;
  public String ufh;
  public String ufi;
  public String ufj;
  public String ufk;
  public String ufl;
  public String ufm;
  public String ufn;
  
  static
  {
    AppMethodBeat.i(46699);
    CREATOR = new Authen.1();
    AppMethodBeat.o(46699);
  }
  
  public Authen()
  {
    AppMethodBeat.i(46697);
    this.ueV = 0;
    this.pVo = new PayInfo();
    AppMethodBeat.o(46697);
  }
  
  public Authen(Parcel paramParcel)
  {
    AppMethodBeat.i(46698);
    this.ueV = 0;
    this.pVo = new PayInfo();
    this.bsY = paramParcel.readInt();
    this.ueW = paramParcel.readString();
    this.poq = paramParcel.readString();
    this.por = paramParcel.readString();
    this.ueu = paramParcel.readString();
    this.ueX = paramParcel.readString();
    this.ueY = paramParcel.readInt();
    this.ubQ = paramParcel.readString();
    this.ueZ = paramParcel.readString();
    this.ufa = paramParcel.readString();
    this.ufb = paramParcel.readString();
    this.token = paramParcel.readString();
    this.ufe = paramParcel.readString();
    this.uff = paramParcel.readString();
    this.country = paramParcel.readString();
    this.province = paramParcel.readString();
    this.city = paramParcel.readString();
    this.fBq = paramParcel.readString();
    this.nLs = paramParcel.readString();
    this.gKS = paramParcel.readString();
    this.dqF = paramParcel.readString();
    this.tSv = paramParcel.readString();
    this.ufg = paramParcel.readString();
    this.ufh = paramParcel.readString();
    this.ufd = paramParcel.readString();
    this.ufi = paramParcel.readString();
    this.ufj = paramParcel.readString();
    this.ufk = paramParcel.readString();
    this.ufl = paramParcel.readString();
    this.ufm = paramParcel.readString();
    this.ueC = paramParcel.readInt();
    this.ueE = paramParcel.readString();
    this.ufn = paramParcel.readString();
    AppMethodBeat.o(46698);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46696);
    paramParcel.writeInt(this.bsY);
    paramParcel.writeString(bo.bf(this.ueW, ""));
    paramParcel.writeString(bo.bf(this.poq, ""));
    paramParcel.writeString(bo.bf(this.por, ""));
    paramParcel.writeString(bo.bf(this.ueu, ""));
    paramParcel.writeString(bo.bf(this.ueX, ""));
    paramParcel.writeInt(this.ueY);
    paramParcel.writeString(bo.bf(this.ubQ, ""));
    paramParcel.writeString(bo.bf(this.ueZ, ""));
    paramParcel.writeString(bo.bf(this.ufa, ""));
    paramParcel.writeString(bo.bf(this.ufb, ""));
    paramParcel.writeString(bo.bf(this.token, ""));
    paramParcel.writeString(bo.bf(this.ufe, ""));
    paramParcel.writeString(bo.bf(this.uff, ""));
    paramParcel.writeString(bo.bf(this.country, ""));
    paramParcel.writeString(bo.bf(this.province, ""));
    paramParcel.writeString(bo.bf(this.city, ""));
    paramParcel.writeString(bo.bf(this.fBq, ""));
    paramParcel.writeString(bo.bf(this.nLs, ""));
    paramParcel.writeString(bo.bf(this.gKS, ""));
    paramParcel.writeString(bo.bf(this.dqF, ""));
    paramParcel.writeString(bo.bf(this.tSv, ""));
    paramParcel.writeString(bo.bf(this.ufg, ""));
    paramParcel.writeString(bo.bf(this.ufh, ""));
    paramParcel.writeString(bo.bf(this.ufd, ""));
    paramParcel.writeString(bo.bf(this.ufi, ""));
    paramParcel.writeString(bo.bf(this.ufj, ""));
    paramParcel.writeString(bo.bf(this.ufk, ""));
    paramParcel.writeString(bo.bf(this.ufl, ""));
    paramParcel.writeString(bo.bf(this.ufm, ""));
    paramParcel.writeInt(bo.a(Integer.valueOf(this.ueC), 0));
    paramParcel.writeString(bo.bf(this.ueE, ""));
    paramParcel.writeString(bo.bf(this.ufn, ""));
    AppMethodBeat.o(46696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Authen
 * JD-Core Version:    0.7.0.1
 */