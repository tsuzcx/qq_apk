package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PayInfo> CREATOR = new Parcelable.Creator() {};
  public String aox;
  public String appId;
  public String bJd;
  public String bMX;
  public int bOS;
  public String bOU;
  public String bOV;
  public String bUA = "";
  public int bUR;
  public int bUV = 0;
  public int bUW = -1;
  public String ccR;
  public String dCX;
  public String fGK;
  public String ilD;
  public boolean kPR = false;
  public int nzh = 0;
  public String partnerId;
  public int qFX = 0;
  public int qFY = 0;
  public String qLi;
  public int snU = 0;
  public boolean snV = true;
  public String snW;
  public Bundle snX;
  public int snY;
  public long snZ = 0L;
  public int soa = -1;
  public String sob;
  public String soc;
  public int sod = 1;
  public double soe = 0.0D;
  
  public PayInfo() {}
  
  public PayInfo(Parcel paramParcel)
  {
    this.bUV = paramParcel.readInt();
    this.snU = paramParcel.readInt();
    this.bMX = paramParcel.readString();
    this.dCX = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.qLi = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.ccR = paramParcel.readString();
    this.bJd = paramParcel.readString();
    this.aox = paramParcel.readString();
    this.bUR = paramParcel.readInt();
    this.bUW = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.kPR = bool1;
      if (paramParcel.readInt() != 1) {
        break label316;
      }
    }
    label316:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.snV = bool1;
      this.snX = paramParcel.readBundle();
      this.qFX = paramParcel.readInt();
      this.bOU = paramParcel.readString();
      this.bOV = paramParcel.readString();
      this.bOS = paramParcel.readInt();
      this.snZ = paramParcel.readLong();
      this.bUA = paramParcel.readString();
      this.sob = paramParcel.readString();
      this.soc = paramParcel.readString();
      this.sod = paramParcel.readInt();
      this.ilD = paramParcel.readString();
      this.fGK = paramParcel.readString();
      this.nzh = paramParcel.readInt();
      this.soe = paramParcel.readDouble();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.bUV), this.bMX, this.dCX, this.appId, this.qLi, this.partnerId, this.ccR, this.bJd, this.bUA });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.bUV);
    paramParcel.writeInt(this.snU);
    paramParcel.writeString(this.bMX);
    paramParcel.writeString(this.dCX);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.qLi);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.ccR);
    paramParcel.writeString(this.bJd);
    paramParcel.writeString(this.aox);
    paramParcel.writeInt(this.bUR);
    paramParcel.writeInt(this.bUW);
    if (this.kPR)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.snV) {
        break label244;
      }
    }
    label244:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.snX);
      paramParcel.writeInt(this.qFX);
      paramParcel.writeString(this.bOU);
      paramParcel.writeString(this.bOV);
      paramParcel.writeInt(this.bOS);
      paramParcel.writeLong(this.snZ);
      paramParcel.writeString(this.bUA);
      paramParcel.writeString(this.sob);
      paramParcel.writeString(this.soc);
      paramParcel.writeInt(this.sod);
      paramParcel.writeString(this.ilD);
      paramParcel.writeString(this.fGK);
      paramParcel.writeInt(this.nzh);
      paramParcel.writeDouble(this.soe);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.PayInfo
 * JD-Core Version:    0.7.0.1
 */