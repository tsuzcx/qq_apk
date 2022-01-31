package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class WidgetData$Style
  implements Parcelable
{
  public static final Parcelable.Creator<Style> CREATOR;
  public boolean cIy;
  public int height;
  public String hhh;
  public int offsetX;
  public int offsetY;
  public double uKP;
  public int uKQ;
  public int width;
  
  static
  {
    AppMethodBeat.i(124278);
    CREATOR = new WidgetData.Style.1();
    AppMethodBeat.o(124278);
  }
  
  public WidgetData$Style()
  {
    this.uKP = 65.0D;
    this.cIy = true;
  }
  
  protected WidgetData$Style(Parcel paramParcel)
  {
    AppMethodBeat.i(124275);
    this.uKP = 65.0D;
    this.cIy = true;
    this.uKP = paramParcel.readDouble();
    this.uKQ = paramParcel.readInt();
    this.offsetX = paramParcel.readInt();
    this.offsetY = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.hhh = paramParcel.readString();
    this.width = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.cIy = bool;
      AppMethodBeat.o(124275);
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
    AppMethodBeat.i(124276);
    if (this == paramObject)
    {
      AppMethodBeat.o(124276);
      return true;
    }
    if (!(paramObject instanceof Style))
    {
      AppMethodBeat.o(124276);
      return false;
    }
    paramObject = (Style)paramObject;
    if ((Double.compare(paramObject.uKP, this.uKP) == 0) && (this.uKQ == paramObject.uKQ) && (this.offsetX == paramObject.offsetX) && (this.offsetY == paramObject.offsetY) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.cIy == paramObject.cIy) && (Objects.equals(this.hhh, paramObject.hhh)))
    {
      AppMethodBeat.o(124276);
      return true;
    }
    AppMethodBeat.o(124276);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(124277);
    int i = Objects.hash(new Object[] { Double.valueOf(this.uKP), Integer.valueOf(this.uKQ), Integer.valueOf(this.offsetX), Integer.valueOf(this.offsetY), Integer.valueOf(this.height), this.hhh, Integer.valueOf(this.width), Boolean.valueOf(this.cIy) });
    AppMethodBeat.o(124277);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124273);
    String str = super.toString();
    AppMethodBeat.o(124273);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124274);
    paramParcel.writeDouble(this.uKP);
    paramParcel.writeInt(this.uKQ);
    paramParcel.writeInt(this.offsetX);
    paramParcel.writeInt(this.offsetY);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.hhh);
    paramParcel.writeInt(this.width);
    if (this.cIy) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(124274);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.Style
 * JD-Core Version:    0.7.0.1
 */