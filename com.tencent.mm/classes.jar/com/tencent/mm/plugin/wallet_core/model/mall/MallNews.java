package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public String ByB;
  public int DqM;
  public String DsZ;
  public String Dta;
  public String Dtb;
  public String Dtc;
  public String Dtd;
  public int Dte;
  public String Dtf;
  public int Dtg;
  public String Dth;
  public String Dti;
  public int dmr;
  public String dqk;
  public String hQM;
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
    this.DsZ = "0";
    this.Dta = "0";
    this.hQM = paramParcel.readString();
    this.ByB = paramParcel.readString();
    this.dqk = paramParcel.readString();
    this.Dtb = paramParcel.readString();
    this.Dtc = paramParcel.readString();
    this.Dtd = paramParcel.readString();
    this.Dte = paramParcel.readInt();
    this.Dtf = paramParcel.readString();
    this.DsZ = paramParcel.readString();
    this.Dta = paramParcel.readString();
    this.dmr = paramParcel.readInt();
    this.Dth = paramParcel.readString();
    this.DqM = paramParcel.readInt();
    this.Dti = paramParcel.readString();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.DsZ = "0";
    this.Dta = "0";
    this.hQM = paramString;
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
      if ((this.hQM == null) || (!this.hQM.equals(paramObject.hQM)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.ByB == null) || (!this.ByB.equals(paramObject.ByB)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.hQM, this.ByB, this.dqk, this.Dtb, this.Dtc, this.Dtd, this.DsZ, this.Dth, this.Dtf, Integer.valueOf(this.DqM), this.Dti });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.hQM);
    paramParcel.writeString(this.ByB);
    paramParcel.writeString(this.dqk);
    paramParcel.writeString(this.Dtb);
    paramParcel.writeString(this.Dtc);
    paramParcel.writeString(this.Dtd);
    paramParcel.writeInt(this.Dte);
    paramParcel.writeString(this.Dtf);
    paramParcel.writeString(this.DsZ);
    paramParcel.writeString(this.Dta);
    paramParcel.writeInt(this.dmr);
    paramParcel.writeString(this.Dth);
    paramParcel.writeInt(this.DqM);
    paramParcel.writeString(this.Dti);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */