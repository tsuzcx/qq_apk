package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MallFunction
  implements Parcelable
{
  public static final Parcelable.Creator<MallFunction> CREATOR;
  public String AiA;
  public ArrayList<String> AiB;
  public MallNews AiC;
  public String AiD;
  public int AiE;
  public String dAn;
  public String dDM;
  public String smD;
  public String ttl;
  public String ttm;
  public int type;
  public String uWF;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.AiE = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.AiE = 0;
    this.uWF = paramParcel.readString();
    this.dAn = paramParcel.readString();
    this.AiA = paramParcel.readString();
    this.ttl = paramParcel.readString();
    this.ttm = paramParcel.readString();
    this.dDM = paramParcel.readString();
    this.smD = paramParcel.readString();
    this.AiB = new ArrayList();
    paramParcel.readStringList(this.AiB);
    this.AiC = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.AiD = paramParcel.readString();
    this.AiE = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.uWF);
    paramParcel.writeString(this.dAn);
    paramParcel.writeString(this.AiA);
    paramParcel.writeString(this.ttl);
    paramParcel.writeString(this.ttm);
    paramParcel.writeString(this.dDM);
    paramParcel.writeString(this.smD);
    paramParcel.writeStringList(this.AiB);
    paramParcel.writeParcelable(this.AiC, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.AiD);
    paramParcel.writeInt(this.AiE);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */