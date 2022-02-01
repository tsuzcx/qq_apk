package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public int Avy;
  public String VKO;
  public String VKP;
  public String VKQ;
  public String VKR;
  public String VKS;
  public String VKT;
  public int VKU;
  public String VKV;
  public String VKW;
  public int expireTime;
  public int hAN;
  public String hFb;
  public int igf;
  public String otL;
  public String rBJ;
  public String type;
  
  static
  {
    AppMethodBeat.i(70552);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70552);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(70549);
    this.VKO = "0";
    this.VKP = "0";
    this.otL = paramParcel.readString();
    this.rBJ = paramParcel.readString();
    this.hFb = paramParcel.readString();
    this.VKQ = paramParcel.readString();
    this.VKR = paramParcel.readString();
    this.VKS = paramParcel.readString();
    this.expireTime = paramParcel.readInt();
    this.VKT = paramParcel.readString();
    this.VKO = paramParcel.readString();
    this.VKP = paramParcel.readString();
    this.hAN = paramParcel.readInt();
    this.VKV = paramParcel.readString();
    this.Avy = paramParcel.readInt();
    this.VKW = paramParcel.readString();
    this.igf = paramParcel.readInt();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.VKO = "0";
    this.VKP = "0";
    this.otL = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70548);
    if ((paramObject instanceof MallNews))
    {
      paramObject = (MallNews)paramObject;
      if ((this.otL == null) || (!this.otL.equals(paramObject.otL)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.rBJ == null) || (!this.rBJ.equals(paramObject.rBJ)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      AppMethodBeat.o(70548);
      return true;
    }
    AppMethodBeat.o(70548);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70551);
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s, walletRegion: %d", new Object[] { this.otL, this.rBJ, this.hFb, this.VKQ, this.VKR, this.VKS, this.VKO, this.VKV, this.VKT, Integer.valueOf(this.Avy), this.VKW, Integer.valueOf(this.igf) });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.otL);
    paramParcel.writeString(this.rBJ);
    paramParcel.writeString(this.hFb);
    paramParcel.writeString(this.VKQ);
    paramParcel.writeString(this.VKR);
    paramParcel.writeString(this.VKS);
    paramParcel.writeInt(this.expireTime);
    paramParcel.writeString(this.VKT);
    paramParcel.writeString(this.VKO);
    paramParcel.writeString(this.VKP);
    paramParcel.writeInt(this.hAN);
    paramParcel.writeString(this.VKV);
    paramParcel.writeInt(this.Avy);
    paramParcel.writeString(this.VKW);
    paramParcel.writeInt(this.igf);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */