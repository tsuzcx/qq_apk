package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public String crs;
  public String ftd;
  public String sWB;
  public int showType;
  public String type;
  public int uki;
  public String umn;
  public String umo;
  public String ump;
  public String umq;
  public String umr;
  public int ums;
  public String umt;
  public int umu;
  public String umv;
  public String umw;
  
  static
  {
    AppMethodBeat.i(47020);
    CREATOR = new MallNews.1();
    AppMethodBeat.o(47020);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(47017);
    this.umn = "0";
    this.umo = "0";
    this.ftd = paramParcel.readString();
    this.sWB = paramParcel.readString();
    this.crs = paramParcel.readString();
    this.ump = paramParcel.readString();
    this.umq = paramParcel.readString();
    this.umr = paramParcel.readString();
    this.ums = paramParcel.readInt();
    this.umt = paramParcel.readString();
    this.umn = paramParcel.readString();
    this.umo = paramParcel.readString();
    this.showType = paramParcel.readInt();
    this.umv = paramParcel.readString();
    this.uki = paramParcel.readInt();
    this.umw = paramParcel.readString();
    AppMethodBeat.o(47017);
  }
  
  public MallNews(String paramString)
  {
    this.umn = "0";
    this.umo = "0";
    this.ftd = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47016);
    if ((paramObject instanceof MallNews))
    {
      paramObject = (MallNews)paramObject;
      if ((this.ftd == null) || (!this.ftd.equals(paramObject.ftd)))
      {
        AppMethodBeat.o(47016);
        return false;
      }
      if ((this.sWB == null) || (!this.sWB.equals(paramObject.sWB)))
      {
        AppMethodBeat.o(47016);
        return false;
      }
      AppMethodBeat.o(47016);
      return true;
    }
    AppMethodBeat.o(47016);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(47019);
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.ftd, this.sWB, this.crs, this.ump, this.umq, this.umr, this.umn, this.umv, this.umt, Integer.valueOf(this.uki), this.umw });
    AppMethodBeat.o(47019);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47018);
    paramParcel.writeString(this.ftd);
    paramParcel.writeString(this.sWB);
    paramParcel.writeString(this.crs);
    paramParcel.writeString(this.ump);
    paramParcel.writeString(this.umq);
    paramParcel.writeString(this.umr);
    paramParcel.writeInt(this.ums);
    paramParcel.writeString(this.umt);
    paramParcel.writeString(this.umn);
    paramParcel.writeString(this.umo);
    paramParcel.writeInt(this.showType);
    paramParcel.writeString(this.umv);
    paramParcel.writeInt(this.uki);
    paramParcel.writeString(this.umw);
    AppMethodBeat.o(47018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */