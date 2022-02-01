package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public boolean xyK;
  public boolean xyL;
  public int xyM;
  public int xyN;
  public int xyO;
  public int xyP;
  public int xyQ;
  
  static
  {
    AppMethodBeat.i(182593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182593);
  }
  
  public XEffectConfig()
  {
    this.xyK = false;
    this.xyL = false;
    this.xyM = -1;
    this.xyN = -1;
    this.xyO = -1;
    this.xyP = -1;
    this.xyQ = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(182591);
    this.xyK = false;
    this.xyL = false;
    this.xyM = -1;
    this.xyN = -1;
    this.xyO = -1;
    this.xyP = -1;
    this.xyQ = -1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.xyK = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.xyL = bool1;
      this.xyM = paramParcel.readInt();
      this.xyN = paramParcel.readInt();
      this.xyO = paramParcel.readInt();
      this.xyP = paramParcel.readInt();
      this.xyQ = paramParcel.readInt();
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
    if (this.xyK)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.xyL) {
        break label88;
      }
    }
    label88:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.xyM);
      paramParcel.writeInt(this.xyN);
      paramParcel.writeInt(this.xyO);
      paramParcel.writeInt(this.xyP);
      paramParcel.writeInt(this.xyQ);
      AppMethodBeat.o(182592);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */