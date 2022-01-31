package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR = new MallNews.1();
  public String bJY;
  public String ecR;
  public String pva;
  public int qxA;
  public String qzD = "0";
  public String qzE = "0";
  public String qzF;
  public String qzG;
  public String qzH;
  public int qzI;
  public String qzJ;
  public int qzK;
  public String qzL;
  public String qzM;
  public int showType;
  public String type;
  
  public MallNews(Parcel paramParcel)
  {
    this.ecR = paramParcel.readString();
    this.pva = paramParcel.readString();
    this.bJY = paramParcel.readString();
    this.qzF = paramParcel.readString();
    this.qzG = paramParcel.readString();
    this.qzH = paramParcel.readString();
    this.qzI = paramParcel.readInt();
    this.qzJ = paramParcel.readString();
    this.qzD = paramParcel.readString();
    this.qzE = paramParcel.readString();
    this.showType = paramParcel.readInt();
    this.qzL = paramParcel.readString();
    this.qxA = paramParcel.readInt();
    this.qzM = paramParcel.readString();
  }
  
  public MallNews(String paramString)
  {
    this.ecR = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MallNews))
    {
      paramObject = (MallNews)paramObject;
      if ((this.ecR != null) && (this.ecR.equals(paramObject.ecR))) {
        break label35;
      }
    }
    label35:
    while ((this.pva == null) || (!this.pva.equals(paramObject.pva))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.ecR, this.pva, this.bJY, this.qzF, this.qzG, this.qzH, this.qzD, this.qzL, this.qzJ, Integer.valueOf(this.qxA), this.qzM });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ecR);
    paramParcel.writeString(this.pva);
    paramParcel.writeString(this.bJY);
    paramParcel.writeString(this.qzF);
    paramParcel.writeString(this.qzG);
    paramParcel.writeString(this.qzH);
    paramParcel.writeInt(this.qzI);
    paramParcel.writeString(this.qzJ);
    paramParcel.writeString(this.qzD);
    paramParcel.writeString(this.qzE);
    paramParcel.writeInt(this.showType);
    paramParcel.writeString(this.qzL);
    paramParcel.writeInt(this.qxA);
    paramParcel.writeString(this.qzM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */