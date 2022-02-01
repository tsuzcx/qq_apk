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
  public String DsR;
  public ArrayList<String> DsS;
  public MallNews DsT;
  public String DsU;
  public int DsV;
  public String dLB;
  public String dPb;
  public String jFZ;
  public int type;
  public String uEo;
  public String vQp;
  public String vQq;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.DsV = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.DsV = 0;
    this.jFZ = paramParcel.readString();
    this.dLB = paramParcel.readString();
    this.DsR = paramParcel.readString();
    this.vQp = paramParcel.readString();
    this.vQq = paramParcel.readString();
    this.dPb = paramParcel.readString();
    this.uEo = paramParcel.readString();
    this.DsS = new ArrayList();
    paramParcel.readStringList(this.DsS);
    this.DsT = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.DsU = paramParcel.readString();
    this.DsV = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.jFZ);
    paramParcel.writeString(this.dLB);
    paramParcel.writeString(this.DsR);
    paramParcel.writeString(this.vQp);
    paramParcel.writeString(this.vQq);
    paramParcel.writeString(this.dPb);
    paramParcel.writeString(this.uEo);
    paramParcel.writeStringList(this.DsS);
    paramParcel.writeParcelable(this.DsT, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.DsU);
    paramParcel.writeInt(this.DsV);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */