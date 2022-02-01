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
  public String ByB;
  public int ImU;
  public String Imv;
  public boolean ORb;
  public int PbP;
  public int PbQ;
  public String Pjv;
  public int Rzf;
  public boolean Rzg;
  public String Rzh;
  public int Rzi;
  public long Rzj;
  public int Rzk;
  public String Rzl;
  public String Rzm;
  public int Rzn;
  public double Rzo;
  public String Rzp;
  public boolean aNY;
  public String appId;
  public int channel;
  public boolean cpf;
  public String errMsg;
  public int fHa;
  public String fHc;
  public String fHd;
  public String fJB;
  public int fOY;
  public int fOZ;
  public String fOx;
  public String fwv;
  public Bundle lfu;
  public String partnerId;
  public String productId;
  public String remark;
  public String tol;
  public String uuid;
  
  static
  {
    AppMethodBeat.i(116322);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(116322);
  }
  
  public PayInfo()
  {
    this.fOZ = -1;
    this.fOY = 0;
    this.Rzf = 0;
    this.cpf = false;
    this.Rzg = true;
    this.PbP = 0;
    this.PbQ = 0;
    this.Rzj = 0L;
    this.fOx = "";
    this.Rzk = -1;
    this.Rzn = 1;
    this.ImU = 0;
    this.Rzo = 0.0D;
    this.Rzp = "";
  }
  
  public PayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(116319);
    this.fOZ = -1;
    this.fOY = 0;
    this.Rzf = 0;
    this.cpf = false;
    this.Rzg = true;
    this.PbP = 0;
    this.PbQ = 0;
    this.Rzj = 0L;
    this.fOx = "";
    this.Rzk = -1;
    this.Rzn = 1;
    this.ImU = 0;
    this.Rzo = 0.0D;
    this.Rzp = "";
    this.fOY = paramParcel.readInt();
    this.Rzf = paramParcel.readInt();
    this.fwv = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.Pjv = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.fJB = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.channel = paramParcel.readInt();
    this.fOZ = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.cpf = bool1;
      if (paramParcel.readInt() != 1) {
        break label399;
      }
      bool1 = true;
      label204:
      this.Rzg = bool1;
      this.lfu = paramParcel.readBundle();
      this.PbP = paramParcel.readInt();
      this.fHc = paramParcel.readString();
      this.fHd = paramParcel.readString();
      this.fHa = paramParcel.readInt();
      this.Rzj = paramParcel.readLong();
      this.fOx = paramParcel.readString();
      this.Rzl = paramParcel.readString();
      this.Rzm = paramParcel.readString();
      this.Rzn = paramParcel.readInt();
      this.tol = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.ImU = paramParcel.readInt();
      this.Rzo = paramParcel.readDouble();
      this.Rzp = paramParcel.readString();
      if (this.Rzp == null) {
        this.Rzp = "";
      }
      if (paramParcel.readInt() != 1) {
        break label404;
      }
      bool1 = true;
      label352:
      this.aNY = bool1;
      this.Imv = paramParcel.readString();
      this.ByB = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label409;
      }
    }
    label399:
    label404:
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ORb = bool1;
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
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.fOY), this.fwv, this.uuid, this.appId, this.Pjv, this.partnerId, this.fJB, this.productId, this.fOx });
    AppMethodBeat.o(116321);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(116320);
    paramParcel.writeInt(this.fOY);
    paramParcel.writeInt(this.Rzf);
    paramParcel.writeString(this.fwv);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.Pjv);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.fJB);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.fOZ);
    if (this.cpf)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.Rzg) {
        break label306;
      }
      paramInt = 1;
      label126:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.lfu);
      paramParcel.writeInt(this.PbP);
      paramParcel.writeString(this.fHc);
      paramParcel.writeString(this.fHd);
      paramParcel.writeInt(this.fHa);
      paramParcel.writeLong(this.Rzj);
      paramParcel.writeString(this.fOx);
      paramParcel.writeString(this.Rzl);
      paramParcel.writeString(this.Rzm);
      paramParcel.writeInt(this.Rzn);
      paramParcel.writeString(this.tol);
      paramParcel.writeString(this.remark);
      paramParcel.writeInt(this.ImU);
      paramParcel.writeDouble(this.Rzo);
      paramParcel.writeString(this.Rzp);
      if (!this.aNY) {
        break label311;
      }
      paramInt = 1;
      label260:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.Imv);
      paramParcel.writeString(this.ByB);
      if (!this.ORb) {
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