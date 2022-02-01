package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public String OUA;
  public String OUB;
  public String OUC;
  public int OUD;
  public String OUE;
  public String OUF;
  public String OUx;
  public String OUy;
  public String OUz;
  public int expireTime;
  public String fAo;
  public int fZX;
  public int fwp;
  public String lCb;
  public String oym;
  public String type;
  public int wYj;
  
  static
  {
    AppMethodBeat.i(70552);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70552);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(70549);
    this.OUx = "0";
    this.OUy = "0";
    this.lCb = paramParcel.readString();
    this.oym = paramParcel.readString();
    this.fAo = paramParcel.readString();
    this.OUz = paramParcel.readString();
    this.OUA = paramParcel.readString();
    this.OUB = paramParcel.readString();
    this.expireTime = paramParcel.readInt();
    this.OUC = paramParcel.readString();
    this.OUx = paramParcel.readString();
    this.OUy = paramParcel.readString();
    this.fwp = paramParcel.readInt();
    this.OUE = paramParcel.readString();
    this.wYj = paramParcel.readInt();
    this.OUF = paramParcel.readString();
    this.fZX = paramParcel.readInt();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.OUx = "0";
    this.OUy = "0";
    this.lCb = paramString;
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
      if ((this.lCb == null) || (!this.lCb.equals(paramObject.lCb)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.oym == null) || (!this.oym.equals(paramObject.oym)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s, walletRegion: %d", new Object[] { this.lCb, this.oym, this.fAo, this.OUz, this.OUA, this.OUB, this.OUx, this.OUE, this.OUC, Integer.valueOf(this.wYj), this.OUF, Integer.valueOf(this.fZX) });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.lCb);
    paramParcel.writeString(this.oym);
    paramParcel.writeString(this.fAo);
    paramParcel.writeString(this.OUz);
    paramParcel.writeString(this.OUA);
    paramParcel.writeString(this.OUB);
    paramParcel.writeInt(this.expireTime);
    paramParcel.writeString(this.OUC);
    paramParcel.writeString(this.OUx);
    paramParcel.writeString(this.OUy);
    paramParcel.writeInt(this.fwp);
    paramParcel.writeString(this.OUE);
    paramParcel.writeInt(this.wYj);
    paramParcel.writeString(this.OUF);
    paramParcel.writeInt(this.fZX);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */