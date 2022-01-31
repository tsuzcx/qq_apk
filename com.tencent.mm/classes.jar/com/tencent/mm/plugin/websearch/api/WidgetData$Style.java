package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class WidgetData$Style
  implements Parcelable
{
  public static final Parcelable.Creator<Style> CREATOR = new WidgetData.Style.1();
  public String fNR;
  public int height;
  public int offsetX;
  public int offsetY;
  public double qVD = 65.0D;
  public int qVE;
  public boolean qVF = true;
  public int width;
  
  public WidgetData$Style() {}
  
  protected WidgetData$Style(Parcel paramParcel)
  {
    this.qVD = paramParcel.readDouble();
    this.qVE = paramParcel.readInt();
    this.offsetX = paramParcel.readInt();
    this.offsetY = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fNR = paramParcel.readString();
    this.width = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.qVF = bool;
      return;
      bool = false;
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
      if (!(paramObject instanceof Style)) {
        return false;
      }
      paramObject = (Style)paramObject;
    } while ((Double.compare(paramObject.qVD, this.qVD) == 0) && (this.qVE == paramObject.qVE) && (this.offsetX == paramObject.offsetX) && (this.offsetY == paramObject.offsetY) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.qVF == paramObject.qVF) && (Objects.equals(this.fNR, paramObject.fNR)));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Double.valueOf(this.qVD), Integer.valueOf(this.qVE), Integer.valueOf(this.offsetX), Integer.valueOf(this.offsetY), Integer.valueOf(this.height), this.fNR, Integer.valueOf(this.width), Boolean.valueOf(this.qVF) });
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.qVD);
    paramParcel.writeInt(this.qVE);
    paramParcel.writeInt(this.offsetX);
    paramParcel.writeInt(this.offsetY);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.fNR);
    paramParcel.writeInt(this.width);
    if (this.qVF) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.Style
 * JD-Core Version:    0.7.0.1
 */