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
  public String BAV;
  public ArrayList<String> BAW;
  public MallNews BAX;
  public String BAY;
  public int BAZ;
  public String dBy;
  public String dxZ;
  public String tuw;
  public int type;
  public String uBE;
  public String uBF;
  public String wfu;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.BAZ = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.BAZ = 0;
    this.wfu = paramParcel.readString();
    this.dxZ = paramParcel.readString();
    this.BAV = paramParcel.readString();
    this.uBE = paramParcel.readString();
    this.uBF = paramParcel.readString();
    this.dBy = paramParcel.readString();
    this.tuw = paramParcel.readString();
    this.BAW = new ArrayList();
    paramParcel.readStringList(this.BAW);
    this.BAX = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.BAY = paramParcel.readString();
    this.BAZ = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.wfu);
    paramParcel.writeString(this.dxZ);
    paramParcel.writeString(this.BAV);
    paramParcel.writeString(this.uBE);
    paramParcel.writeString(this.uBF);
    paramParcel.writeString(this.dBy);
    paramParcel.writeString(this.tuw);
    paramParcel.writeStringList(this.BAW);
    paramParcel.writeParcelable(this.BAX, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.BAY);
    paramParcel.writeInt(this.BAZ);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */