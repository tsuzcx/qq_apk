package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public boolean vij;
  public boolean vik;
  public int vil;
  public int vim;
  public int vin;
  public int vio;
  public int vip;
  
  static
  {
    AppMethodBeat.i(182593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182593);
  }
  
  public XEffectConfig()
  {
    this.vij = false;
    this.vik = false;
    this.vil = -1;
    this.vim = -1;
    this.vin = -1;
    this.vio = -1;
    this.vip = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(182591);
    this.vij = false;
    this.vik = false;
    this.vil = -1;
    this.vim = -1;
    this.vin = -1;
    this.vio = -1;
    this.vip = -1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.vij = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vik = bool1;
      this.vil = paramParcel.readInt();
      this.vim = paramParcel.readInt();
      this.vin = paramParcel.readInt();
      this.vio = paramParcel.readInt();
      this.vip = paramParcel.readInt();
      AppMethodBeat.o(182591);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(182592);
    if (this.vij)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.vik) {
        break label88;
      }
    }
    label88:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.vil);
      paramParcel.writeInt(this.vim);
      paramParcel.writeInt(this.vin);
      paramParcel.writeInt(this.vio);
      paramParcel.writeInt(this.vip);
      AppMethodBeat.o(182592);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */