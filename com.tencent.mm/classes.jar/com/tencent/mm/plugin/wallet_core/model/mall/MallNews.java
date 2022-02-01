package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public String BBd;
  public String BBe;
  public String BBf;
  public String BBg;
  public String BBh;
  public int BBi;
  public String BBj;
  public int BBk;
  public String BBl;
  public String BBm;
  public int ByO;
  public int cZX;
  public String ddJ;
  public String hvE;
  public String type;
  public String zPC;
  
  static
  {
    AppMethodBeat.i(70552);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70552);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(70549);
    this.BBd = "0";
    this.BBe = "0";
    this.hvE = paramParcel.readString();
    this.zPC = paramParcel.readString();
    this.ddJ = paramParcel.readString();
    this.BBf = paramParcel.readString();
    this.BBg = paramParcel.readString();
    this.BBh = paramParcel.readString();
    this.BBi = paramParcel.readInt();
    this.BBj = paramParcel.readString();
    this.BBd = paramParcel.readString();
    this.BBe = paramParcel.readString();
    this.cZX = paramParcel.readInt();
    this.BBl = paramParcel.readString();
    this.ByO = paramParcel.readInt();
    this.BBm = paramParcel.readString();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.BBd = "0";
    this.BBe = "0";
    this.hvE = paramString;
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
      if ((this.hvE == null) || (!this.hvE.equals(paramObject.hvE)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.zPC == null) || (!this.zPC.equals(paramObject.zPC)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.hvE, this.zPC, this.ddJ, this.BBf, this.BBg, this.BBh, this.BBd, this.BBl, this.BBj, Integer.valueOf(this.ByO), this.BBm });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.hvE);
    paramParcel.writeString(this.zPC);
    paramParcel.writeString(this.ddJ);
    paramParcel.writeString(this.BBf);
    paramParcel.writeString(this.BBg);
    paramParcel.writeString(this.BBh);
    paramParcel.writeInt(this.BBi);
    paramParcel.writeString(this.BBj);
    paramParcel.writeString(this.BBd);
    paramParcel.writeString(this.BBe);
    paramParcel.writeInt(this.cZX);
    paramParcel.writeString(this.BBl);
    paramParcel.writeInt(this.ByO);
    paramParcel.writeString(this.BBm);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */