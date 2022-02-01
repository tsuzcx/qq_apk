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
  public String Hgd;
  public String OiN;
  public int Okk;
  public boolean VGV;
  public int VSv;
  public int VSw;
  public String Wan;
  public int YvD;
  public boolean YvE;
  public String YvF;
  public int YvG;
  public long YvH;
  public int YvI;
  public String YvJ;
  public String YvK;
  public int YvL;
  public double YvM;
  public String YvN;
  public String appId;
  public boolean cHU;
  public int channel;
  public boolean egT;
  public String errMsg;
  public String hAT;
  public String hMA;
  public int hMx;
  public String hMz;
  public String hPe;
  public int hUR;
  public int hUS;
  public String hUq;
  public Bundle nKf;
  public String partnerId;
  public String productId;
  public String remark;
  public String uuid;
  public String wsM;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.hUS = -1;
    this.hUR = 0;
    this.YvD = 0;
    this.egT = false;
    this.YvE = true;
    this.VSv = 0;
    this.VSw = 0;
    this.YvH = 0L;
    this.hUq = "";
    this.YvI = -1;
    this.YvL = 1;
    this.Okk = 0;
    this.YvM = 0.0D;
    this.YvN = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.hUS = -1;
    this.hUR = 0;
    this.YvD = 0;
    this.egT = false;
    this.YvE = true;
    this.VSv = 0;
    this.VSw = 0;
    this.YvH = 0L;
    this.hUq = "";
    this.YvI = -1;
    this.YvL = 1;
    this.Okk = 0;
    this.YvM = 0.0D;
    this.YvN = "";
    this.hUR = paramParcel.readInt();
    this.YvD = paramParcel.readInt();
    this.hAT = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.Wan = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.hPe = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.hUS = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.egT = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.YvE = bool1;
      this.nKf = paramParcel.readBundle();
      this.VSv = paramParcel.readInt();
      this.hMz = paramParcel.readString();
      this.hMA = paramParcel.readString();
      this.hMx = paramParcel.readInt();
      this.YvH = paramParcel.readLong();
      this.hUq = paramParcel.readString();
      this.YvJ = paramParcel.readString();
      this.YvK = paramParcel.readString();
      this.YvL = paramParcel.readInt();
      this.wsM = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.Okk = paramParcel.readInt();
      this.YvM = paramParcel.readDouble();
      this.YvN = paramParcel.readString();
      if (this.YvN == null) {
        this.YvN = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.cHU = bool1;
      this.OiN = paramParcel.readString();
      this.Hgd = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.VGV = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.hUR), this.hAT, this.uuid, this.appId, this.Wan, this.partnerId, this.hPe, this.productId, this.hUq });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.hUR);
    paramParcel.writeInt(this.YvD);
    paramParcel.writeString(this.hAT);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.Wan);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.hPe);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.hUS);
    if (this.egT)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.YvE) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.nKf);
      paramParcel.writeInt(this.VSv);
      paramParcel.writeString(this.hMz);
      paramParcel.writeString(this.hMA);
      paramParcel.writeInt(this.hMx);
      paramParcel.writeLong(this.YvH);
      paramParcel.writeString(this.hUq);
      paramParcel.writeString(this.YvJ);
      paramParcel.writeString(this.YvK);
      paramParcel.writeInt(this.YvL);
      paramParcel.writeString(this.wsM);
      paramParcel.writeString(this.remark);
      paramParcel.writeInt(this.Okk);
      paramParcel.writeDouble(this.YvM);
      paramParcel.writeString(this.YvN);
      if (!this.cHU) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.OiN);
      paramParcel.writeString(this.Hgd);
      if (!this.VGV) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.PayInfo
 * JD-Core Version:    0.7.0.1
 */