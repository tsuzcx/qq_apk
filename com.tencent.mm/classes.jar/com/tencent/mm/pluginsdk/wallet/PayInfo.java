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
  public int DAm;
  public int DAn;
  public String DHy;
  public boolean DpN;
  public int FEn;
  public boolean FEo;
  public String FEp;
  public int FEq;
  public long FEr;
  public int FEs;
  public String FEt;
  public String FEu;
  public int FEv;
  public double FEw;
  public String FEx;
  public String appId;
  public boolean beA;
  public int channel;
  public int dDH;
  public int dDI;
  public String dDg;
  public String dNM;
  public String dmw;
  public String dpp;
  public int dwi;
  public String dwk;
  public String dwl;
  public String errMsg;
  public Bundle hwN;
  public String iWF;
  public String oED;
  public String partnerId;
  public String trY;
  public boolean unK;
  public String uuid;
  public int yoP;
  public String yoq;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.dDI = -1;
    this.dDH = 0;
    this.FEn = 0;
    this.unK = false;
    this.FEo = true;
    this.DAm = 0;
    this.DAn = 0;
    this.FEr = 0L;
    this.dDg = "";
    this.FEs = -1;
    this.FEv = 1;
    this.yoP = 0;
    this.FEw = 0.0D;
    this.FEx = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.dDI = -1;
    this.dDH = 0;
    this.FEn = 0;
    this.unK = false;
    this.FEo = true;
    this.DAm = 0;
    this.DAn = 0;
    this.FEr = 0L;
    this.dDg = "";
    this.FEs = -1;
    this.FEv = 1;
    this.yoP = 0;
    this.FEw = 0.0D;
    this.FEx = "";
    this.dDH = paramParcel.readInt();
    this.FEn = paramParcel.readInt();
    this.dmw = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.DHy = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.dNM = paramParcel.readString();
    this.dpp = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.dDI = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.unK = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.FEo = bool1;
      this.hwN = paramParcel.readBundle();
      this.DAm = paramParcel.readInt();
      this.dwk = paramParcel.readString();
      this.dwl = paramParcel.readString();
      this.dwi = paramParcel.readInt();
      this.FEr = paramParcel.readLong();
      this.dDg = paramParcel.readString();
      this.FEt = paramParcel.readString();
      this.FEu = paramParcel.readString();
      this.FEv = paramParcel.readInt();
      this.oED = paramParcel.readString();
      this.iWF = paramParcel.readString();
      this.yoP = paramParcel.readInt();
      this.FEw = paramParcel.readDouble();
      this.FEx = paramParcel.readString();
      if (this.FEx == null) {
        this.FEx = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.beA = bool1;
      this.yoq = paramParcel.readString();
      this.trY = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DpN = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.dDH), this.dmw, this.uuid, this.appId, this.DHy, this.partnerId, this.dNM, this.dpp, this.dDg });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.dDH);
    paramParcel.writeInt(this.FEn);
    paramParcel.writeString(this.dmw);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.DHy);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.dNM);
    paramParcel.writeString(this.dpp);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.dDI);
    if (this.unK)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.FEo) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.hwN);
      paramParcel.writeInt(this.DAm);
      paramParcel.writeString(this.dwk);
      paramParcel.writeString(this.dwl);
      paramParcel.writeInt(this.dwi);
      paramParcel.writeLong(this.FEr);
      paramParcel.writeString(this.dDg);
      paramParcel.writeString(this.FEt);
      paramParcel.writeString(this.FEu);
      paramParcel.writeInt(this.FEv);
      paramParcel.writeString(this.oED);
      paramParcel.writeString(this.iWF);
      paramParcel.writeInt(this.yoP);
      paramParcel.writeDouble(this.FEw);
      paramParcel.writeString(this.FEx);
      if (!this.beA) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.yoq);
      paramParcel.writeString(this.trY);
      if (!this.DpN) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.PayInfo
 * JD-Core Version:    0.7.0.1
 */