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
  public String KKg;
  public String KKh;
  public String VKG;
  public ArrayList<String> VKH;
  public MallNews VKI;
  public String VKJ;
  public int VKK;
  public String h5Url;
  public String idA;
  public String ihx;
  public String qBb;
  public int type;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.VKK = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.VKK = 0;
    this.qBb = paramParcel.readString();
    this.idA = paramParcel.readString();
    this.VKG = paramParcel.readString();
    this.KKg = paramParcel.readString();
    this.KKh = paramParcel.readString();
    this.ihx = paramParcel.readString();
    this.h5Url = paramParcel.readString();
    this.VKH = new ArrayList();
    paramParcel.readStringList(this.VKH);
    this.VKI = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.VKJ = paramParcel.readString();
    this.VKK = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.qBb);
    paramParcel.writeString(this.idA);
    paramParcel.writeString(this.VKG);
    paramParcel.writeString(this.KKg);
    paramParcel.writeString(this.KKh);
    paramParcel.writeString(this.ihx);
    paramParcel.writeString(this.h5Url);
    paramParcel.writeStringList(this.VKH);
    paramParcel.writeParcelable(this.VKI, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.VKJ);
    paramParcel.writeInt(this.VKK);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */