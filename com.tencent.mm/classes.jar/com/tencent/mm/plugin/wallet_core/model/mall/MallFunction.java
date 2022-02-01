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
  public String EPJ;
  public String EPK;
  public String OUp;
  public ArrayList<String> OUq;
  public MallNews OUr;
  public String OUs;
  public int OUt;
  public String fXz;
  public String gbn;
  public String h5Url;
  public String nBK;
  public int type;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.OUt = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.OUt = 0;
    this.nBK = paramParcel.readString();
    this.fXz = paramParcel.readString();
    this.OUp = paramParcel.readString();
    this.EPJ = paramParcel.readString();
    this.EPK = paramParcel.readString();
    this.gbn = paramParcel.readString();
    this.h5Url = paramParcel.readString();
    this.OUq = new ArrayList();
    paramParcel.readStringList(this.OUq);
    this.OUr = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.OUs = paramParcel.readString();
    this.OUt = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.nBK);
    paramParcel.writeString(this.fXz);
    paramParcel.writeString(this.OUp);
    paramParcel.writeString(this.EPJ);
    paramParcel.writeString(this.EPK);
    paramParcel.writeString(this.gbn);
    paramParcel.writeString(this.h5Url);
    paramParcel.writeStringList(this.OUq);
    paramParcel.writeParcelable(this.OUr, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.OUs);
    paramParcel.writeInt(this.OUt);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */