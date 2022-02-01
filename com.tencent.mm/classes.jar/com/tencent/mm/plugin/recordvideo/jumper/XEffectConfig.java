package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public boolean xOG;
  public boolean xOH;
  public int xOI;
  public int xOJ;
  public int xOK;
  public int xOL;
  public int xOM;
  
  static
  {
    AppMethodBeat.i(182593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182593);
  }
  
  public XEffectConfig()
  {
    this.xOG = false;
    this.xOH = false;
    this.xOI = -1;
    this.xOJ = -1;
    this.xOK = -1;
    this.xOL = -1;
    this.xOM = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(182591);
    this.xOG = false;
    this.xOH = false;
    this.xOI = -1;
    this.xOJ = -1;
    this.xOK = -1;
    this.xOL = -1;
    this.xOM = -1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.xOG = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.xOH = bool1;
      this.xOI = paramParcel.readInt();
      this.xOJ = paramParcel.readInt();
      this.xOK = paramParcel.readInt();
      this.xOL = paramParcel.readInt();
      this.xOM = paramParcel.readInt();
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
    if (this.xOG)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.xOH) {
        break label88;
      }
    }
    label88:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.xOI);
      paramParcel.writeInt(this.xOJ);
      paramParcel.writeInt(this.xOK);
      paramParcel.writeInt(this.xOL);
      paramParcel.writeInt(this.xOM);
      AppMethodBeat.o(182592);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */