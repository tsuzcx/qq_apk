package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews
  implements Parcelable
{
  public static final Parcelable.Creator<MallNews> CREATOR;
  public int Agu;
  public String AiI;
  public String AiJ;
  public String AiK;
  public String AiL;
  public String AiM;
  public int AiN;
  public String AiO;
  public int AiP;
  public String AiQ;
  public String AiR;
  public int dcz;
  public String dgo;
  public String gVf;
  public String type;
  public String yCo;
  
  static
  {
    AppMethodBeat.i(70552);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70552);
  }
  
  public MallNews(Parcel paramParcel)
  {
    AppMethodBeat.i(70549);
    this.AiI = "0";
    this.AiJ = "0";
    this.gVf = paramParcel.readString();
    this.yCo = paramParcel.readString();
    this.dgo = paramParcel.readString();
    this.AiK = paramParcel.readString();
    this.AiL = paramParcel.readString();
    this.AiM = paramParcel.readString();
    this.AiN = paramParcel.readInt();
    this.AiO = paramParcel.readString();
    this.AiI = paramParcel.readString();
    this.AiJ = paramParcel.readString();
    this.dcz = paramParcel.readInt();
    this.AiQ = paramParcel.readString();
    this.Agu = paramParcel.readInt();
    this.AiR = paramParcel.readString();
    AppMethodBeat.o(70549);
  }
  
  public MallNews(String paramString)
  {
    this.AiI = "0";
    this.AiJ = "0";
    this.gVf = paramString;
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
      if ((this.gVf == null) || (!this.gVf.equals(paramObject.gVf)))
      {
        AppMethodBeat.o(70548);
        return false;
      }
      if ((this.yCo == null) || (!this.yCo.equals(paramObject.yCo)))
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
    String str = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[] { this.gVf, this.yCo, this.dgo, this.AiK, this.AiL, this.AiM, this.AiI, this.AiQ, this.AiO, Integer.valueOf(this.Agu), this.AiR });
    AppMethodBeat.o(70551);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70550);
    paramParcel.writeString(this.gVf);
    paramParcel.writeString(this.yCo);
    paramParcel.writeString(this.dgo);
    paramParcel.writeString(this.AiK);
    paramParcel.writeString(this.AiL);
    paramParcel.writeString(this.AiM);
    paramParcel.writeInt(this.AiN);
    paramParcel.writeString(this.AiO);
    paramParcel.writeString(this.AiI);
    paramParcel.writeString(this.AiJ);
    paramParcel.writeInt(this.dcz);
    paramParcel.writeString(this.AiQ);
    paramParcel.writeInt(this.Agu);
    paramParcel.writeString(this.AiR);
    AppMethodBeat.o(70550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallNews
 * JD-Core Version:    0.7.0.1
 */