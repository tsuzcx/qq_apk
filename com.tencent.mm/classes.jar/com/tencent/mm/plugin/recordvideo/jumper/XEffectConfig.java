package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public boolean BOM;
  public boolean BON;
  public int hDb;
  public int hDc;
  public int hDd;
  public int hDe;
  public int hDf;
  
  static
  {
    AppMethodBeat.i(182593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182593);
  }
  
  public XEffectConfig()
  {
    this.BOM = false;
    this.BON = false;
    this.hDb = -1;
    this.hDc = -1;
    this.hDd = -1;
    this.hDe = -1;
    this.hDf = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(182591);
    this.BOM = false;
    this.BON = false;
    this.hDb = -1;
    this.hDc = -1;
    this.hDd = -1;
    this.hDe = -1;
    this.hDf = -1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.BOM = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BON = bool1;
      this.hDb = paramParcel.readInt();
      this.hDc = paramParcel.readInt();
      this.hDd = paramParcel.readInt();
      this.hDe = paramParcel.readInt();
      this.hDf = paramParcel.readInt();
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
    if (this.BOM)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.BON) {
        break label88;
      }
    }
    label88:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.hDb);
      paramParcel.writeInt(this.hDc);
      paramParcel.writeInt(this.hDd);
      paramParcel.writeInt(this.hDe);
      paramParcel.writeInt(this.hDf);
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