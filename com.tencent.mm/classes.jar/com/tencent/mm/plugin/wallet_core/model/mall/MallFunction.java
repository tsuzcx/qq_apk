package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction
  implements Parcelable
{
  public static final Parcelable.Creator<MallFunction> CREATOR = new Parcelable.Creator() {};
  public String caU;
  public String ceb;
  public String lZc;
  public String lZd;
  public String lfj;
  public String npy;
  public String qzv;
  public ArrayList<String> qzw;
  public MallNews qzx;
  public String qzy;
  public int qzz = 0;
  public int type;
  
  public MallFunction() {}
  
  public MallFunction(Parcel paramParcel)
  {
    this.npy = paramParcel.readString();
    this.caU = paramParcel.readString();
    this.qzv = paramParcel.readString();
    this.lZc = paramParcel.readString();
    this.lZd = paramParcel.readString();
    this.ceb = paramParcel.readString();
    this.lfj = paramParcel.readString();
    this.qzw = new ArrayList();
    paramParcel.readStringList(this.qzw);
    this.qzx = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.qzy = paramParcel.readString();
    this.qzz = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.npy);
    paramParcel.writeString(this.caU);
    paramParcel.writeString(this.qzv);
    paramParcel.writeString(this.lZc);
    paramParcel.writeString(this.lZd);
    paramParcel.writeString(this.ceb);
    paramParcel.writeString(this.lfj);
    paramParcel.writeStringList(this.qzw);
    paramParcel.writeParcelable(this.qzx, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.qzy);
    paramParcel.writeInt(this.qzz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */