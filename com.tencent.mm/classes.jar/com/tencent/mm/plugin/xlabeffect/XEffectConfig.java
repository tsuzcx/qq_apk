package com.tencent.mm.plugin.xlabeffect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public int QPA;
  public int QPB;
  public int QPC;
  public int QPD;
  public int QPE;
  public int QPF;
  public int QPq;
  public boolean QPr;
  public boolean QPs;
  public int QPt;
  public int QPu;
  public int QPv;
  public int QPw;
  public int QPx;
  public int QPy;
  public int QPz;
  public String jXW;
  public int yCP;
  
  static
  {
    AppMethodBeat.i(256778);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(256778);
  }
  
  public XEffectConfig()
  {
    this.QPq = -1;
    this.QPr = false;
    this.QPs = false;
    this.QPt = -1;
    this.QPu = -1;
    this.QPv = -1;
    this.QPw = -1;
    this.QPx = -1;
    this.yCP = -1;
    this.QPy = -1;
    this.QPz = -1;
    this.QPA = -1;
    this.QPB = -1;
    this.QPC = -1;
    this.QPD = -1;
    this.QPE = -1;
    this.QPF = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(256774);
    this.QPq = -1;
    this.QPr = false;
    this.QPs = false;
    this.QPt = -1;
    this.QPu = -1;
    this.QPv = -1;
    this.QPw = -1;
    this.QPx = -1;
    this.yCP = -1;
    this.QPy = -1;
    this.QPz = -1;
    this.QPA = -1;
    this.QPB = -1;
    this.QPC = -1;
    this.QPD = -1;
    this.QPE = -1;
    this.QPF = -1;
    this.QPq = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.QPr = bool1;
      if (paramParcel.readByte() == 0) {
        break label263;
      }
    }
    label263:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.QPs = bool1;
      this.QPt = paramParcel.readInt();
      this.QPu = paramParcel.readInt();
      this.QPv = paramParcel.readInt();
      this.QPw = paramParcel.readInt();
      this.QPx = paramParcel.readInt();
      this.yCP = paramParcel.readInt();
      this.QPy = paramParcel.readInt();
      this.QPz = paramParcel.readInt();
      this.QPA = paramParcel.readInt();
      this.QPB = paramParcel.readInt();
      this.QPC = paramParcel.readInt();
      this.QPD = paramParcel.readInt();
      this.QPE = paramParcel.readInt();
      this.QPF = paramParcel.readInt();
      this.jXW = paramParcel.readString();
      AppMethodBeat.o(256774);
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
    int i = 1;
    AppMethodBeat.i(256776);
    paramParcel.writeInt(this.QPq);
    if (this.QPr)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.QPs) {
        break label176;
      }
    }
    label176:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.QPt);
      paramParcel.writeInt(this.QPu);
      paramParcel.writeInt(this.QPv);
      paramParcel.writeInt(this.QPw);
      paramParcel.writeInt(this.QPx);
      paramParcel.writeInt(this.yCP);
      paramParcel.writeInt(this.QPy);
      paramParcel.writeInt(this.QPz);
      paramParcel.writeInt(this.QPA);
      paramParcel.writeInt(this.QPB);
      paramParcel.writeInt(this.QPC);
      paramParcel.writeInt(this.QPD);
      paramParcel.writeInt(this.QPE);
      paramParcel.writeInt(this.QPF);
      paramParcel.writeString(this.jXW);
      AppMethodBeat.o(256776);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */