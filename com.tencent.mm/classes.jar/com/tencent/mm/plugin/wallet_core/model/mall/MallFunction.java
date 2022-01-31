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
  public String cJt;
  public String cMO;
  public String nDe;
  public String oyK;
  public String oyL;
  public String pUM;
  public int type;
  public String umf;
  public ArrayList<String> umg;
  public MallNews umh;
  public String umi;
  public int umj;
  
  static
  {
    AppMethodBeat.i(47006);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47006);
  }
  
  public MallFunction()
  {
    this.umj = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(47004);
    this.umj = 0;
    this.pUM = paramParcel.readString();
    this.cJt = paramParcel.readString();
    this.umf = paramParcel.readString();
    this.oyK = paramParcel.readString();
    this.oyL = paramParcel.readString();
    this.cMO = paramParcel.readString();
    this.nDe = paramParcel.readString();
    this.umg = new ArrayList();
    paramParcel.readStringList(this.umg);
    this.umh = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.umi = paramParcel.readString();
    this.umj = paramParcel.readInt();
    AppMethodBeat.o(47004);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47005);
    paramParcel.writeString(this.pUM);
    paramParcel.writeString(this.cJt);
    paramParcel.writeString(this.umf);
    paramParcel.writeString(this.oyK);
    paramParcel.writeString(this.oyL);
    paramParcel.writeString(this.cMO);
    paramParcel.writeString(this.nDe);
    paramParcel.writeStringList(this.umg);
    paramParcel.writeParcelable(this.umh, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.umi);
    paramParcel.writeInt(this.umj);
    AppMethodBeat.o(47005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */