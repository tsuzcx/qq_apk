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
  public boolean Afv;
  public int ApW;
  public int ApX;
  public String Axg;
  public String CoA;
  public int Cop;
  public boolean Coq;
  public String Cor;
  public Bundle Cos;
  public int Cot;
  public long Cou;
  public int Cov;
  public String Cow;
  public String Cox;
  public int Coy;
  public double Coz;
  public boolean aTo;
  public String appId;
  public int channel;
  public String dCx;
  public String dcE;
  public String dft;
  public int dlI;
  public String dlK;
  public String dlL;
  public String dsE;
  public int dtb;
  public int dtc;
  public String errMsg;
  public String iaz;
  public String nrG;
  public String partnerId;
  public boolean rWX;
  public String rcj;
  public String uuid;
  public String vAM;
  public int vBl;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.dtc = -1;
    this.dtb = 0;
    this.Cop = 0;
    this.rWX = false;
    this.Coq = true;
    this.ApW = 0;
    this.ApX = 0;
    this.Cou = 0L;
    this.dsE = "";
    this.Cov = -1;
    this.Coy = 1;
    this.vBl = 0;
    this.Coz = 0.0D;
    this.CoA = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.dtc = -1;
    this.dtb = 0;
    this.Cop = 0;
    this.rWX = false;
    this.Coq = true;
    this.ApW = 0;
    this.ApX = 0;
    this.Cou = 0L;
    this.dsE = "";
    this.Cov = -1;
    this.Coy = 1;
    this.vBl = 0;
    this.Coz = 0.0D;
    this.CoA = "";
    this.dtb = paramParcel.readInt();
    this.Cop = paramParcel.readInt();
    this.dcE = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.Axg = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.dCx = paramParcel.readString();
    this.dft = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.dtc = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.rWX = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.Coq = bool1;
      this.Cos = paramParcel.readBundle();
      this.ApW = paramParcel.readInt();
      this.dlK = paramParcel.readString();
      this.dlL = paramParcel.readString();
      this.dlI = paramParcel.readInt();
      this.Cou = paramParcel.readLong();
      this.dsE = paramParcel.readString();
      this.Cow = paramParcel.readString();
      this.Cox = paramParcel.readString();
      this.Coy = paramParcel.readInt();
      this.nrG = paramParcel.readString();
      this.iaz = paramParcel.readString();
      this.vBl = paramParcel.readInt();
      this.Coz = paramParcel.readDouble();
      this.CoA = paramParcel.readString();
      if (this.CoA == null) {
        this.CoA = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.aTo = bool1;
      this.vAM = paramParcel.readString();
      this.rcj = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Afv = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.dtb), this.dcE, this.uuid, this.appId, this.Axg, this.partnerId, this.dCx, this.dft, this.dsE });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.dtb);
    paramParcel.writeInt(this.Cop);
    paramParcel.writeString(this.dcE);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.Axg);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.dCx);
    paramParcel.writeString(this.dft);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.dtc);
    if (this.rWX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.Coq) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.Cos);
      paramParcel.writeInt(this.ApW);
      paramParcel.writeString(this.dlK);
      paramParcel.writeString(this.dlL);
      paramParcel.writeInt(this.dlI);
      paramParcel.writeLong(this.Cou);
      paramParcel.writeString(this.dsE);
      paramParcel.writeString(this.Cow);
      paramParcel.writeString(this.Cox);
      paramParcel.writeInt(this.Coy);
      paramParcel.writeString(this.nrG);
      paramParcel.writeString(this.iaz);
      paramParcel.writeInt(this.vBl);
      paramParcel.writeDouble(this.Coz);
      paramParcel.writeString(this.CoA);
      if (!this.aTo) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.vAM);
      paramParcel.writeString(this.rcj);
      if (!this.Afv) {
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