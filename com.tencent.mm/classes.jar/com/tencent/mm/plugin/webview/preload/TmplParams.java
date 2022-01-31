package com.tencent.mm.plugin.webview.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TmplParams
  implements Parcelable
{
  public static final Parcelable.Creator<TmplParams> CREATOR = new TmplParams.1();
  public String bIW;
  public long ouU;
  public String rfY;
  public String rjA;
  public String rjB;
  public int rjC;
  public int rjv;
  public int version;
  
  public TmplParams() {}
  
  public TmplParams(Parcel paramParcel)
  {
    this.rjv = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.rfY = paramParcel.readString();
    this.rjA = paramParcel.readString();
    this.bIW = paramParcel.readString();
    this.rjC = paramParcel.readInt();
    this.ouU = paramParcel.readLong();
    this.rjB = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TmplParams{version=" + this.version + ", initUrl='" + this.rfY + '\'' + ", initFilePath='" + this.rjA + '\'' + ", reportId=" + this.rjC + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.rjv);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.rfY);
    paramParcel.writeString(this.rjA);
    paramParcel.writeString(this.bIW);
    paramParcel.writeInt(this.rjC);
    paramParcel.writeLong(this.ouU);
    paramParcel.writeString(this.rjB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.TmplParams
 * JD-Core Version:    0.7.0.1
 */