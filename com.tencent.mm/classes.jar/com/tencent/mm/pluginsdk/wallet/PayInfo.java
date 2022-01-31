package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PayInfo> CREATOR;
  public String appId;
  public boolean axV;
  public int cCD;
  public int cCE;
  public String cCf;
  public int cCy;
  public String cLA;
  public String cnI;
  public String cqx;
  public int cwj;
  public String cwl;
  public String cwm;
  public String eAx;
  public String errMsg;
  public String hKa;
  public String kmA;
  public boolean nnQ;
  public String partnerId;
  public String qjK;
  public int qkj;
  public String uAe;
  public int utc;
  public int utd;
  public String wgA;
  public int wgB;
  public double wgC;
  public String wgD;
  public int wgs;
  public boolean wgt;
  public String wgu;
  public Bundle wgv;
  public int wgw;
  public long wgx;
  public int wgy;
  public String wgz;
  
  static
  {
    AppMethodBeat.i(70468);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70468);
  }
  
  public PayInfo()
  {
    this.cCE = -1;
    this.cCD = 0;
    this.wgs = 0;
    this.nnQ = false;
    this.wgt = true;
    this.utc = 0;
    this.utd = 0;
    this.wgx = 0L;
    this.cCf = "";
    this.wgy = -1;
    this.wgB = 1;
    this.qkj = 0;
    this.wgC = 0.0D;
    this.wgD = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70465);
    this.cCE = -1;
    this.cCD = 0;
    this.wgs = 0;
    this.nnQ = false;
    this.wgt = true;
    this.utc = 0;
    this.utd = 0;
    this.wgx = 0L;
    this.cCf = "";
    this.wgy = -1;
    this.wgB = 1;
    this.qkj = 0;
    this.wgC = 0.0D;
    this.wgD = "";
    this.cCD = paramParcel.readInt();
    this.wgs = paramParcel.readInt();
    this.cnI = paramParcel.readString();
    this.eAx = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.uAe = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.cLA = paramParcel.readString();
    this.cqx = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.cCy = paramParcel.readInt();
    this.cCE = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.nnQ = bool1;
      if (paramParcel.readInt() != 1) {
        break label376;
      }
      bool1 = true;
      label204:
      this.wgt = bool1;
      this.wgv = paramParcel.readBundle();
      this.utc = paramParcel.readInt();
      this.cwl = paramParcel.readString();
      this.cwm = paramParcel.readString();
      this.cwj = paramParcel.readInt();
      this.wgx = paramParcel.readLong();
      this.cCf = paramParcel.readString();
      this.wgz = paramParcel.readString();
      this.wgA = paramParcel.readString();
      this.wgB = paramParcel.readInt();
      this.kmA = paramParcel.readString();
      this.hKa = paramParcel.readString();
      this.qkj = paramParcel.readInt();
      this.wgC = paramParcel.readDouble();
      this.wgD = paramParcel.readString();
      if (this.wgD == null) {
        this.wgD = "";
      }
      if (paramParcel.readInt() != 1) {
        break label381;
      }
    }
    label376:
    label381:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.axV = bool1;
      this.qjK = paramParcel.readString();
      AppMethodBeat.o(70465);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label204;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70467);
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.cCD), this.cnI, this.eAx, this.appId, this.uAe, this.partnerId, this.cLA, this.cqx, this.cCf });
    AppMethodBeat.o(70467);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70466);
    paramParcel.writeInt(this.cCD);
    paramParcel.writeInt(this.wgs);
    paramParcel.writeString(this.cnI);
    paramParcel.writeString(this.eAx);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.uAe);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.cLA);
    paramParcel.writeString(this.cqx);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.cCy);
    paramParcel.writeInt(this.cCE);
    if (this.nnQ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.wgt) {
        break label284;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.wgv);
      paramParcel.writeInt(this.utc);
      paramParcel.writeString(this.cwl);
      paramParcel.writeString(this.cwm);
      paramParcel.writeInt(this.cwj);
      paramParcel.writeLong(this.wgx);
      paramParcel.writeString(this.cCf);
      paramParcel.writeString(this.wgz);
      paramParcel.writeString(this.wgA);
      paramParcel.writeInt(this.wgB);
      paramParcel.writeString(this.kmA);
      paramParcel.writeString(this.hKa);
      paramParcel.writeInt(this.qkj);
      paramParcel.writeDouble(this.wgC);
      paramParcel.writeString(this.wgD);
      if (!this.axV) {
        break label289;
      }
    }
    label284:
    label289:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qjK);
      AppMethodBeat.o(70466);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.PayInfo
 * JD-Core Version:    0.7.0.1
 */