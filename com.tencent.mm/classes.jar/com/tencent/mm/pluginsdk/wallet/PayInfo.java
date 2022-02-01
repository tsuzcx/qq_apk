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
  public boolean CYi;
  public int DiI;
  public int DiJ;
  public String DpS;
  public int FlP;
  public boolean FlQ;
  public String FlR;
  public int FlS;
  public long FlT;
  public int FlU;
  public String FlV;
  public String FlW;
  public int FlX;
  public double FlY;
  public String FlZ;
  public String appId;
  public boolean beA;
  public int channel;
  public int dCC;
  public int dCD;
  public String dCb;
  public String dMw;
  public String dlu;
  public String dok;
  public int dvd;
  public String dvf;
  public String dvg;
  public String errMsg;
  public Bundle htZ;
  public String iTM;
  public String oyb;
  public String partnerId;
  public String thf;
  public boolean ucG;
  public String uuid;
  public int xYX;
  public String xYy;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.dCD = -1;
    this.dCC = 0;
    this.FlP = 0;
    this.ucG = false;
    this.FlQ = true;
    this.DiI = 0;
    this.DiJ = 0;
    this.FlT = 0L;
    this.dCb = "";
    this.FlU = -1;
    this.FlX = 1;
    this.xYX = 0;
    this.FlY = 0.0D;
    this.FlZ = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.dCD = -1;
    this.dCC = 0;
    this.FlP = 0;
    this.ucG = false;
    this.FlQ = true;
    this.DiI = 0;
    this.DiJ = 0;
    this.FlT = 0L;
    this.dCb = "";
    this.FlU = -1;
    this.FlX = 1;
    this.xYX = 0;
    this.FlY = 0.0D;
    this.FlZ = "";
    this.dCC = paramParcel.readInt();
    this.FlP = paramParcel.readInt();
    this.dlu = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.DpS = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.dMw = paramParcel.readString();
    this.dok = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.dCD = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.ucG = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.FlQ = bool1;
      this.htZ = paramParcel.readBundle();
      this.DiI = paramParcel.readInt();
      this.dvf = paramParcel.readString();
      this.dvg = paramParcel.readString();
      this.dvd = paramParcel.readInt();
      this.FlT = paramParcel.readLong();
      this.dCb = paramParcel.readString();
      this.FlV = paramParcel.readString();
      this.FlW = paramParcel.readString();
      this.FlX = paramParcel.readInt();
      this.oyb = paramParcel.readString();
      this.iTM = paramParcel.readString();
      this.xYX = paramParcel.readInt();
      this.FlY = paramParcel.readDouble();
      this.FlZ = paramParcel.readString();
      if (this.FlZ == null) {
        this.FlZ = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.beA = bool1;
      this.xYy = paramParcel.readString();
      this.thf = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CYi = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.dCC), this.dlu, this.uuid, this.appId, this.DpS, this.partnerId, this.dMw, this.dok, this.dCb });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.dCC);
    paramParcel.writeInt(this.FlP);
    paramParcel.writeString(this.dlu);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.DpS);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.dMw);
    paramParcel.writeString(this.dok);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.dCD);
    if (this.ucG)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.FlQ) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.htZ);
      paramParcel.writeInt(this.DiI);
      paramParcel.writeString(this.dvf);
      paramParcel.writeString(this.dvg);
      paramParcel.writeInt(this.dvd);
      paramParcel.writeLong(this.FlT);
      paramParcel.writeString(this.dCb);
      paramParcel.writeString(this.FlV);
      paramParcel.writeString(this.FlW);
      paramParcel.writeInt(this.FlX);
      paramParcel.writeString(this.oyb);
      paramParcel.writeString(this.iTM);
      paramParcel.writeInt(this.xYX);
      paramParcel.writeDouble(this.FlY);
      paramParcel.writeString(this.FlZ);
      if (!this.beA) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.xYy);
      paramParcel.writeString(this.thf);
      if (!this.CYi) {
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