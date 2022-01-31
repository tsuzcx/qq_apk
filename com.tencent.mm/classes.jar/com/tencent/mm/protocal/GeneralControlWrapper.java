package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.sdk.platformtools.y;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR = new GeneralControlWrapper.1();
  public static final GeneralControlWrapper spj = new GeneralControlWrapper(10);
  public static final GeneralControlWrapper spk = new GeneralControlWrapper(1);
  public int spl;
  
  public GeneralControlWrapper(int paramInt)
  {
    this.spl = paramInt;
    y.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    this.spl = paramParcel.readInt();
  }
  
  public GeneralControlWrapper(aak paramaak)
  {
    if (paramaak == null) {}
    for (this.spl = 0;; this.spl = paramaak.sZE)
    {
      y.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
      return;
    }
  }
  
  public final boolean coV()
  {
    if ((this.spl & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean coW()
  {
    if ((this.spl & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean coX()
  {
    if ((this.spl & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean coY()
  {
    if ((this.spl & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean coZ()
  {
    if ((this.spl & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = " + bool);
      return bool;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[bitset=0x");
    localStringBuilder.append(Integer.toHexString(this.spl));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.spl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */