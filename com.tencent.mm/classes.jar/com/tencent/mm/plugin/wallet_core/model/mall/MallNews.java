package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public int DrO;
  public String FJm;
  public String Icl;
  public String Icm;
  public String Icn;
  public String Ico;
  public String Icp;
  public String Icq;
  public int Icr;
  public String Ics;
  public String Ict;
  public int dDG;
  public String dHx;
  public String iLU;
  public int trD;
  public String type;
  
  static
  {
    AppMethodBeat.i(70552);
    CREATOR = new MallNews.1();
    AppMethodBeat.o(70552);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(70549);
    this.Icl = "0";
    this.Icm = "0";
    this.iLU = paramParcel.readString();
    this.FJm = paramParcel.readString();
    this.dHx = paramParcel.readString();
    this.Icn = paramParcel.readString();
    this.Ico = paramParcel.readString();
    this.Icp = paramParcel.readString();
    this.DrO = paramParcel.readInt();
    this.Icq = paramParcel.readString();
    this.Icl = paramParcel.readString();
    this.Icm = paramParcel.readString();
    this.dDG = paramParcel.readInt();
    this.Ics = paramParcel.readString();
    this.trD = paramParcel.readInt();
    this.Ict = paramParcel.readString();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.Icl = "0";
    this.Icm = "0";
    this.iLU = paramString;
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
      if ((this.iLU == null) || (!this.iLU.equals(paramObject.iLU)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.FJm == null) || (!this.FJm.equals(paramObject.FJm)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.iLU, this.FJm, this.dHx, this.Icn, this.Ico, this.Icp, this.Icl, this.Ics, this.Icq, Integer.valueOf(this.trD), this.Ict });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.iLU);
    paramParcel.writeString(this.FJm);
    paramParcel.writeString(this.dHx);
    paramParcel.writeString(this.Icn);
    paramParcel.writeString(this.Ico);
    paramParcel.writeString(this.Icp);
    paramParcel.writeInt(this.DrO);
    paramParcel.writeString(this.Icq);
    paramParcel.writeString(this.Icl);
    paramParcel.writeString(this.Icm);
    paramParcel.writeInt(this.dDG);
    paramParcel.writeString(this.Ics);
    paramParcel.writeInt(this.trD);
    paramParcel.writeString(this.Ict);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */