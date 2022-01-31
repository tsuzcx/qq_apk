package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class WidgetData$Info
  implements Parcelable
{
  public static final Parcelable.Creator<Info> CREATOR;
  public String blZ;
  public String cmG;
  public String cwc;
  public String downloadUrl;
  public int fmF;
  public String fqf;
  public String hng;
  public String iconUrl;
  public String kmN;
  public String label;
  public String uKE;
  public String uKF;
  public String uKG;
  public int uKH;
  public String uKI;
  public String uKJ;
  public long uKK;
  public String uKL;
  public boolean uKM;
  public String userName;
  public int version;
  
  static
  {
    AppMethodBeat.i(124265);
    CREATOR = new WidgetData.Info.1();
    AppMethodBeat.o(124265);
  }
  
  public WidgetData$Info() {}
  
  protected WidgetData$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(124264);
    this.fmF = paramParcel.readInt();
    this.uKE = paramParcel.readString();
    this.blZ = paramParcel.readString();
    this.uKF = paramParcel.readString();
    this.uKG = paramParcel.readString();
    this.cmG = paramParcel.readString();
    this.cwc = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.uKH = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.uKI = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.uKJ = paramParcel.readString();
    this.hng = paramParcel.readString();
    this.label = paramParcel.readString();
    this.uKK = paramParcel.readLong();
    this.fqf = paramParcel.readString();
    this.uKL = paramParcel.readString();
    this.kmN = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uKM = bool;
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(124261);
    if (this == paramObject)
    {
      AppMethodBeat.o(124261);
      return true;
    }
    if (!(paramObject instanceof Info))
    {
      AppMethodBeat.o(124261);
      return false;
    }
    paramObject = (Info)paramObject;
    if ((this.fmF == paramObject.fmF) && (this.uKH == paramObject.uKH) && (this.version == paramObject.version) && (this.uKK == paramObject.uKK) && (this.uKM == paramObject.uKM) && (Objects.equals(this.uKE, paramObject.uKE)) && (Objects.equals(this.blZ, paramObject.blZ)) && (Objects.equals(this.uKF, paramObject.uKF)) && (Objects.equals(this.uKG, paramObject.uKG)) && (Objects.equals(this.cmG, paramObject.cmG)) && (Objects.equals(this.cwc, paramObject.cwc)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.uKI, paramObject.uKI)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.uKJ, paramObject.uKJ)) && (Objects.equals(this.hng, paramObject.hng)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.fqf, paramObject.fqf)) && (Objects.equals(this.uKL, paramObject.uKL)) && (Objects.equals(this.kmN, paramObject.kmN)))
    {
      AppMethodBeat.o(124261);
      return true;
    }
    AppMethodBeat.o(124261);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(124262);
    int i = Objects.hash(new Object[] { Integer.valueOf(this.fmF), this.uKE, this.blZ, this.uKF, this.uKG, this.cmG, this.cwc, this.userName, Integer.valueOf(this.uKH), Integer.valueOf(this.version), this.uKI, this.iconUrl, this.downloadUrl, this.uKJ, this.hng, this.label, Long.valueOf(this.uKK), this.fqf, this.uKL, this.kmN, Boolean.valueOf(this.uKM) });
    AppMethodBeat.o(124262);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124260);
    String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.cwc, this.fqf, Long.valueOf(this.uKK), this.cmG });
    AppMethodBeat.o(124260);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124263);
    paramParcel.writeInt(this.fmF);
    paramParcel.writeString(this.uKE);
    paramParcel.writeString(this.blZ);
    paramParcel.writeString(this.uKF);
    paramParcel.writeString(this.uKG);
    paramParcel.writeString(this.cmG);
    paramParcel.writeString(this.cwc);
    paramParcel.writeString(this.userName);
    paramParcel.writeInt(this.uKH);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.uKI);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeString(this.uKJ);
    paramParcel.writeString(this.hng);
    paramParcel.writeString(this.label);
    paramParcel.writeLong(this.uKK);
    paramParcel.writeString(this.fqf);
    paramParcel.writeString(this.uKL);
    paramParcel.writeString(this.kmN);
    if (this.uKM) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(124263);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.Info
 * JD-Core Version:    0.7.0.1
 */