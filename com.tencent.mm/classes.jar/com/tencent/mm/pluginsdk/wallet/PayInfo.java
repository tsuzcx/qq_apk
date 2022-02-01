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
  public int BIq;
  public int BIr;
  public String BPA;
  public boolean BxP;
  public int DGI;
  public boolean DGJ;
  public String DGK;
  public int DGL;
  public long DGM;
  public int DGN;
  public String DGO;
  public String DGP;
  public int DGQ;
  public double DGR;
  public String DGS;
  public boolean aUg;
  public String appId;
  public int channel;
  public String dAj;
  public String dac;
  public String dcO;
  public int djq;
  public String djs;
  public String djt;
  public int dqL;
  public int dqM;
  public String dqo;
  public String errMsg;
  public Bundle hbR;
  public String iAC;
  public String nUG;
  public String partnerId;
  public String skD;
  public boolean teP;
  public String uuid;
  public String wKR;
  public int wLq;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.dqM = -1;
    this.dqL = 0;
    this.DGI = 0;
    this.teP = false;
    this.DGJ = true;
    this.BIq = 0;
    this.BIr = 0;
    this.DGM = 0L;
    this.dqo = "";
    this.DGN = -1;
    this.DGQ = 1;
    this.wLq = 0;
    this.DGR = 0.0D;
    this.DGS = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.dqM = -1;
    this.dqL = 0;
    this.DGI = 0;
    this.teP = false;
    this.DGJ = true;
    this.BIq = 0;
    this.BIr = 0;
    this.DGM = 0L;
    this.dqo = "";
    this.DGN = -1;
    this.DGQ = 1;
    this.wLq = 0;
    this.DGR = 0.0D;
    this.DGS = "";
    this.dqL = paramParcel.readInt();
    this.DGI = paramParcel.readInt();
    this.dac = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.BPA = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.dAj = paramParcel.readString();
    this.dcO = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.dqM = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.teP = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.DGJ = bool1;
      this.hbR = paramParcel.readBundle();
      this.BIq = paramParcel.readInt();
      this.djs = paramParcel.readString();
      this.djt = paramParcel.readString();
      this.djq = paramParcel.readInt();
      this.DGM = paramParcel.readLong();
      this.dqo = paramParcel.readString();
      this.DGO = paramParcel.readString();
      this.DGP = paramParcel.readString();
      this.DGQ = paramParcel.readInt();
      this.nUG = paramParcel.readString();
      this.iAC = paramParcel.readString();
      this.wLq = paramParcel.readInt();
      this.DGR = paramParcel.readDouble();
      this.DGS = paramParcel.readString();
      if (this.DGS == null) {
        this.DGS = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.aUg = bool1;
      this.wKR = paramParcel.readString();
      this.skD = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BxP = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.dqL), this.dac, this.uuid, this.appId, this.BPA, this.partnerId, this.dAj, this.dcO, this.dqo });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.dqL);
    paramParcel.writeInt(this.DGI);
    paramParcel.writeString(this.dac);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.BPA);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.dAj);
    paramParcel.writeString(this.dcO);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.dqM);
    if (this.teP)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.DGJ) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.hbR);
      paramParcel.writeInt(this.BIq);
      paramParcel.writeString(this.djs);
      paramParcel.writeString(this.djt);
      paramParcel.writeInt(this.djq);
      paramParcel.writeLong(this.DGM);
      paramParcel.writeString(this.dqo);
      paramParcel.writeString(this.DGO);
      paramParcel.writeString(this.DGP);
      paramParcel.writeInt(this.DGQ);
      paramParcel.writeString(this.nUG);
      paramParcel.writeString(this.iAC);
      paramParcel.writeInt(this.wLq);
      paramParcel.writeDouble(this.DGR);
      paramParcel.writeString(this.DGS);
      if (!this.aUg) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.wKR);
      paramParcel.writeString(this.skD);
      if (!this.BxP) {
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