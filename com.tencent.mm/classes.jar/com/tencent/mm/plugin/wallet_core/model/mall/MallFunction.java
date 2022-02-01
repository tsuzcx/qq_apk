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
  public String Icd;
  public ArrayList<String> Ice;
  public MallNews Icf;
  public String Icg;
  public int Ich;
  public String edq;
  public String egX;
  public String h5Url;
  public String kHR;
  public int type;
  public String zkt;
  public String zku;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new MallFunction.1();
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.Ich = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.Ich = 0;
    this.kHR = paramParcel.readString();
    this.edq = paramParcel.readString();
    this.Icd = paramParcel.readString();
    this.zkt = paramParcel.readString();
    this.zku = paramParcel.readString();
    this.egX = paramParcel.readString();
    this.h5Url = paramParcel.readString();
    this.Ice = new ArrayList();
    paramParcel.readStringList(this.Ice);
    this.Icf = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.Icg = paramParcel.readString();
    this.Ich = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.kHR);
    paramParcel.writeString(this.edq);
    paramParcel.writeString(this.Icd);
    paramParcel.writeString(this.zkt);
    paramParcel.writeString(this.zku);
    paramParcel.writeString(this.egX);
    paramParcel.writeString(this.h5Url);
    paramParcel.writeStringList(this.Ice);
    paramParcel.writeParcelable(this.Icf, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.Icg);
    paramParcel.writeInt(this.Ich);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */