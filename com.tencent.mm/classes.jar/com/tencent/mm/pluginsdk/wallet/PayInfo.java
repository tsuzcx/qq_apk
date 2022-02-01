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
  public int CpF;
  public String Cpg;
  public boolean HZb;
  public int Ijy;
  public int Ijz;
  public String IqM;
  public double KxA;
  public String KxB;
  public int Kxr;
  public boolean Kxs;
  public String Kxt;
  public int Kxu;
  public long Kxv;
  public int Kxw;
  public String Kxx;
  public String Kxy;
  public int Kxz;
  public String appId;
  public boolean bex;
  public int channel;
  public boolean crp;
  public String dDL;
  public int dNP;
  public String dNR;
  public String dNS;
  public String dQk;
  public String dUV;
  public int dVv;
  public int dVw;
  public String errMsg;
  public Bundle iqp;
  public String pSm;
  public String partnerId;
  public String productId;
  public String remark;
  public String uuid;
  public String wFE;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.dVw = -1;
    this.dVv = 0;
    this.Kxr = 0;
    this.crp = false;
    this.Kxs = true;
    this.Ijy = 0;
    this.Ijz = 0;
    this.Kxv = 0L;
    this.dUV = "";
    this.Kxw = -1;
    this.Kxz = 1;
    this.CpF = 0;
    this.KxA = 0.0D;
    this.KxB = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.dVw = -1;
    this.dVv = 0;
    this.Kxr = 0;
    this.crp = false;
    this.Kxs = true;
    this.Ijy = 0;
    this.Ijz = 0;
    this.Kxv = 0L;
    this.dUV = "";
    this.Kxw = -1;
    this.Kxz = 1;
    this.CpF = 0;
    this.KxA = 0.0D;
    this.KxB = "";
    this.dVv = paramParcel.readInt();
    this.Kxr = paramParcel.readInt();
    this.dDL = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.IqM = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.dQk = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.dVw = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.crp = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.Kxs = bool1;
      this.iqp = paramParcel.readBundle();
      this.Ijy = paramParcel.readInt();
      this.dNR = paramParcel.readString();
      this.dNS = paramParcel.readString();
      this.dNP = paramParcel.readInt();
      this.Kxv = paramParcel.readLong();
      this.dUV = paramParcel.readString();
      this.Kxx = paramParcel.readString();
      this.Kxy = paramParcel.readString();
      this.Kxz = paramParcel.readInt();
      this.pSm = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.CpF = paramParcel.readInt();
      this.KxA = paramParcel.readDouble();
      this.KxB = paramParcel.readString();
      if (this.KxB == null) {
        this.KxB = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.bex = bool1;
      this.Cpg = paramParcel.readString();
      this.wFE = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HZb = bool1;
      AppMethodBeat.o(116319);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label204;
      bool1 = false;
      break label352;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(116321);
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.dVv), this.dDL, this.uuid, this.appId, this.IqM, this.partnerId, this.dQk, this.productId, this.dUV });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.dVv);
    paramParcel.writeInt(this.Kxr);
    paramParcel.writeString(this.dDL);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.IqM);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.dQk);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.dVw);
    if (this.crp)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.Kxs) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.iqp);
      paramParcel.writeInt(this.Ijy);
      paramParcel.writeString(this.dNR);
      paramParcel.writeString(this.dNS);
      paramParcel.writeInt(this.dNP);
      paramParcel.writeLong(this.Kxv);
      paramParcel.writeString(this.dUV);
      paramParcel.writeString(this.Kxx);
      paramParcel.writeString(this.Kxy);
      paramParcel.writeInt(this.Kxz);
      paramParcel.writeString(this.pSm);
      paramParcel.writeString(this.remark);
      paramParcel.writeInt(this.CpF);
      paramParcel.writeDouble(this.KxA);
      paramParcel.writeString(this.KxB);
      if (!this.bex) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.Cpg);
      paramParcel.writeString(this.wFE);
      if (!this.HZb) {
        break label316;
      }
    }
    label306:
    label311:
    label316:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(116320);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label126;
      paramInt = 0;
      break label260;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.PayInfo
 * JD-Core Version:    0.7.0.1
 */