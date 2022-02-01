package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public boolean wqT;
  public boolean wqU;
  public int wqV;
  public int wqW;
  public int wqX;
  public int wqY;
  public int wqZ;
  
  static
  {
    AppMethodBeat.i(182593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182593);
  }
  
  public XEffectConfig()
  {
    this.wqT = false;
    this.wqU = false;
    this.wqV = -1;
    this.wqW = -1;
    this.wqX = -1;
    this.wqY = -1;
    this.wqZ = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(182591);
    this.wqT = false;
    this.wqU = false;
    this.wqV = -1;
    this.wqW = -1;
    this.wqX = -1;
    this.wqY = -1;
    this.wqZ = -1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.wqT = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wqU = bool1;
      this.wqV = paramParcel.readInt();
      this.wqW = paramParcel.readInt();
      this.wqX = paramParcel.readInt();
      this.wqY = paramParcel.readInt();
      this.wqZ = paramParcel.readInt();
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
    if (this.wqT)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.wqU) {
        break label88;
      }
    }
    label88:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.wqV);
      paramParcel.writeInt(this.wqW);
      paramParcel.writeInt(this.wqX);
      paramParcel.writeInt(this.wqY);
      paramParcel.writeInt(this.wqZ);
      AppMethodBeat.o(182592);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */