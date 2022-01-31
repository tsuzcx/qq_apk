package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR = new ECardInfo.1();
  public String bIM;
  public String cdp;
  public int quJ;
  public int quK;
  public int quL;
  public String quM;
  public String quN;
  public String quO;
  public int quP;
  public ArrayList<String> quQ = new ArrayList();
  public String quR;
  public String quS;
  public String quT;
  public String quU;
  public String title;
  
  public ECardInfo() {}
  
  public ECardInfo(Parcel paramParcel)
  {
    this.quJ = paramParcel.readInt();
    this.bIM = paramParcel.readString();
    this.quK = paramParcel.readInt();
    this.quL = paramParcel.readInt();
    this.quM = paramParcel.readString();
    this.quN = paramParcel.readString();
    this.quO = paramParcel.readString();
    this.quP = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.quQ);
    this.quR = paramParcel.readString();
    this.quS = paramParcel.readString();
    this.quT = paramParcel.readString();
    this.quU = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.quJ);
    paramParcel.writeString(this.bIM);
    paramParcel.writeInt(this.quK);
    paramParcel.writeInt(this.quL);
    paramParcel.writeString(this.quM);
    paramParcel.writeString(this.quN);
    paramParcel.writeString(this.quO);
    paramParcel.writeInt(this.quP);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.quQ);
    paramParcel.writeString(this.quR);
    paramParcel.writeString(this.quS);
    paramParcel.writeString(this.quT);
    paramParcel.writeString(this.quU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */