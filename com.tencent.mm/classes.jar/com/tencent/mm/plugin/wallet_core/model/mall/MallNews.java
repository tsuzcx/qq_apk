package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public String Bhd;
  public int CZh;
  public int DbA;
  public String DbB;
  public int DbC;
  public String DbD;
  public String DbE;
  public String Dbv;
  public String Dbw;
  public String Dbx;
  public String Dby;
  public String Dbz;
  public int dlp;
  public String dpf;
  public String hNT;
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
    this.Dbv = "0";
    this.Dbw = "0";
    this.hNT = paramParcel.readString();
    this.Bhd = paramParcel.readString();
    this.dpf = paramParcel.readString();
    this.Dbx = paramParcel.readString();
    this.Dby = paramParcel.readString();
    this.Dbz = paramParcel.readString();
    this.DbA = paramParcel.readInt();
    this.DbB = paramParcel.readString();
    this.Dbv = paramParcel.readString();
    this.Dbw = paramParcel.readString();
    this.dlp = paramParcel.readInt();
    this.DbD = paramParcel.readString();
    this.CZh = paramParcel.readInt();
    this.DbE = paramParcel.readString();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.Dbv = "0";
    this.Dbw = "0";
    this.hNT = paramString;
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
      if ((this.hNT == null) || (!this.hNT.equals(paramObject.hNT)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.Bhd == null) || (!this.Bhd.equals(paramObject.Bhd)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.hNT, this.Bhd, this.dpf, this.Dbx, this.Dby, this.Dbz, this.Dbv, this.DbD, this.DbB, Integer.valueOf(this.CZh), this.DbE });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.hNT);
    paramParcel.writeString(this.Bhd);
    paramParcel.writeString(this.dpf);
    paramParcel.writeString(this.Dbx);
    paramParcel.writeString(this.Dby);
    paramParcel.writeString(this.Dbz);
    paramParcel.writeInt(this.DbA);
    paramParcel.writeString(this.DbB);
    paramParcel.writeString(this.Dbv);
    paramParcel.writeString(this.Dbw);
    paramParcel.writeInt(this.dlp);
    paramParcel.writeString(this.DbD);
    paramParcel.writeInt(this.CZh);
    paramParcel.writeString(this.DbE);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */