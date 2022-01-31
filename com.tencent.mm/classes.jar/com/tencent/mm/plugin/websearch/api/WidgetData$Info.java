package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class WidgetData$Info
  implements Parcelable
{
  public static final Parcelable.Creator<Info> CREATOR = new WidgetData.Info.1();
  public String aVr;
  public String bFw;
  public String bOL;
  public int dWx;
  public String dZY;
  public String downloadUrl;
  public String fTF;
  public String iconUrl;
  public String ilQ;
  public String label;
  public boolean qVA;
  public String qVs;
  public String qVt;
  public String qVu;
  public int qVv;
  public String qVw;
  public String qVx;
  public long qVy;
  public String qVz;
  public String userName;
  public int version;
  
  public WidgetData$Info() {}
  
  protected WidgetData$Info(Parcel paramParcel)
  {
    this.dWx = paramParcel.readInt();
    this.qVs = paramParcel.readString();
    this.aVr = paramParcel.readString();
    this.qVt = paramParcel.readString();
    this.qVu = paramParcel.readString();
    this.bFw = paramParcel.readString();
    this.bOL = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.qVv = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.qVw = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.qVx = paramParcel.readString();
    this.fTF = paramParcel.readString();
    this.label = paramParcel.readString();
    this.qVy = paramParcel.readLong();
    this.dZY = paramParcel.readString();
    this.qVz = paramParcel.readString();
    this.ilQ = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qVA = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Info)) {
        return false;
      }
      paramObject = (Info)paramObject;
    } while ((this.dWx == paramObject.dWx) && (this.qVv == paramObject.qVv) && (this.version == paramObject.version) && (this.qVy == paramObject.qVy) && (this.qVA == paramObject.qVA) && (Objects.equals(this.qVs, paramObject.qVs)) && (Objects.equals(this.aVr, paramObject.aVr)) && (Objects.equals(this.qVt, paramObject.qVt)) && (Objects.equals(this.qVu, paramObject.qVu)) && (Objects.equals(this.bFw, paramObject.bFw)) && (Objects.equals(this.bOL, paramObject.bOL)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.qVw, paramObject.qVw)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.qVx, paramObject.qVx)) && (Objects.equals(this.fTF, paramObject.fTF)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.dZY, paramObject.dZY)) && (Objects.equals(this.qVz, paramObject.qVz)) && (Objects.equals(this.ilQ, paramObject.ilQ)));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.dWx), this.qVs, this.aVr, this.qVt, this.qVu, this.bFw, this.bOL, this.userName, Integer.valueOf(this.qVv), Integer.valueOf(this.version), this.qVw, this.iconUrl, this.downloadUrl, this.qVx, this.fTF, this.label, Long.valueOf(this.qVy), this.dZY, this.qVz, this.ilQ, Boolean.valueOf(this.qVA) });
  }
  
  public String toString()
  {
    return String.format("appid:%s, srcAppid %s, permission %d, widgetData: %s", new Object[] { this.bOL, this.dZY, Long.valueOf(this.qVy), this.qVs });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dWx);
    paramParcel.writeString(this.qVs);
    paramParcel.writeString(this.aVr);
    paramParcel.writeString(this.qVt);
    paramParcel.writeString(this.qVu);
    paramParcel.writeString(this.bFw);
    paramParcel.writeString(this.bOL);
    paramParcel.writeString(this.userName);
    paramParcel.writeInt(this.qVv);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.qVw);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeString(this.qVx);
    paramParcel.writeString(this.fTF);
    paramParcel.writeString(this.label);
    paramParcel.writeLong(this.qVy);
    paramParcel.writeString(this.dZY);
    paramParcel.writeString(this.qVz);
    paramParcel.writeString(this.ilQ);
    if (this.qVA) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.Info
 * JD-Core Version:    0.7.0.1
 */