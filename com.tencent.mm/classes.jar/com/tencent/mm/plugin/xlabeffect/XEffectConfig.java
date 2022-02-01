package com.tencent.mm.plugin.xlabeffect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<XEffectConfig> CREATOR;
  public int DpI;
  public int XKA;
  public int XKB;
  public int XKC;
  public int XKD;
  public int XKE;
  public int XKF;
  public int XKG;
  public int XKH;
  public int XKI;
  public int XKJ;
  public int XKK;
  public int XKL;
  public int XKM;
  public int XKN;
  public int XKO;
  public int XKp;
  public boolean XKq;
  public boolean XKr;
  public int XKs;
  public int XKt;
  public int XKu;
  public int XKv;
  public int XKw;
  public int XKx;
  public int XKy;
  public int XKz;
  public String mxQ;
  
  static
  {
    AppMethodBeat.i(261663);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(261663);
  }
  
  public XEffectConfig()
  {
    this.XKp = -1;
    this.XKq = false;
    this.XKr = false;
    this.XKs = -1;
    this.XKt = -1;
    this.XKu = -1;
    this.XKv = -1;
    this.XKw = -1;
    this.DpI = -1;
    this.XKx = -1;
    this.XKy = -1;
    this.XKz = -1;
    this.XKA = -1;
    this.XKB = -1;
    this.XKC = -1;
    this.XKD = -1;
    this.XKE = -1;
    this.XKF = -1;
    this.XKG = -1;
    this.XKH = -1;
    this.XKI = -1;
    this.XKJ = -1;
    this.XKK = -1;
    this.XKL = -1;
    this.XKM = -1;
    this.XKN = -1;
    this.XKO = -1;
  }
  
  protected XEffectConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(261659);
    this.XKp = -1;
    this.XKq = false;
    this.XKr = false;
    this.XKs = -1;
    this.XKt = -1;
    this.XKu = -1;
    this.XKv = -1;
    this.XKw = -1;
    this.DpI = -1;
    this.XKx = -1;
    this.XKy = -1;
    this.XKz = -1;
    this.XKA = -1;
    this.XKB = -1;
    this.XKC = -1;
    this.XKD = -1;
    this.XKE = -1;
    this.XKF = -1;
    this.XKG = -1;
    this.XKH = -1;
    this.XKI = -1;
    this.XKJ = -1;
    this.XKK = -1;
    this.XKL = -1;
    this.XKM = -1;
    this.XKN = -1;
    this.XKO = -1;
    this.XKp = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.XKq = bool1;
      if (paramParcel.readByte() == 0) {
        break label377;
      }
    }
    label377:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.XKr = bool1;
      this.XKs = paramParcel.readInt();
      this.XKt = paramParcel.readInt();
      this.XKu = paramParcel.readInt();
      this.XKv = paramParcel.readInt();
      this.XKw = paramParcel.readInt();
      this.DpI = paramParcel.readInt();
      this.XKx = paramParcel.readInt();
      this.XKy = paramParcel.readInt();
      this.XKz = paramParcel.readInt();
      this.XKA = paramParcel.readInt();
      this.XKB = paramParcel.readInt();
      this.XKC = paramParcel.readInt();
      this.XKD = paramParcel.readInt();
      this.XKE = paramParcel.readInt();
      this.XKF = paramParcel.readInt();
      this.XKG = paramParcel.readInt();
      this.XKH = paramParcel.readInt();
      this.XKI = paramParcel.readInt();
      this.XKJ = paramParcel.readInt();
      this.XKK = paramParcel.readInt();
      this.XKL = paramParcel.readInt();
      this.XKM = paramParcel.readInt();
      this.mxQ = paramParcel.readString();
      AppMethodBeat.o(261659);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void avl(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.XKH = 0;
      this.XKI = (-paramInt);
      return;
    }
    this.XKI = 0;
    this.XKH = paramInt;
  }
  
  public final void avm(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.XKG = 0;
      this.XKF = (-paramInt);
      return;
    }
    this.XKF = 0;
    this.XKG = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(261668);
    paramParcel.writeInt(this.XKp);
    if (this.XKq)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.XKr) {
        break label240;
      }
    }
    label240:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.XKs);
      paramParcel.writeInt(this.XKt);
      paramParcel.writeInt(this.XKu);
      paramParcel.writeInt(this.XKv);
      paramParcel.writeInt(this.XKw);
      paramParcel.writeInt(this.DpI);
      paramParcel.writeInt(this.XKx);
      paramParcel.writeInt(this.XKy);
      paramParcel.writeInt(this.XKz);
      paramParcel.writeInt(this.XKA);
      paramParcel.writeInt(this.XKB);
      paramParcel.writeInt(this.XKC);
      paramParcel.writeInt(this.XKD);
      paramParcel.writeInt(this.XKE);
      paramParcel.writeInt(this.XKF);
      paramParcel.writeInt(this.XKG);
      paramParcel.writeInt(this.XKH);
      paramParcel.writeInt(this.XKI);
      paramParcel.writeInt(this.XKJ);
      paramParcel.writeInt(this.XKK);
      paramParcel.writeInt(this.XKL);
      paramParcel.writeInt(this.XKM);
      paramParcel.writeString(this.mxQ);
      AppMethodBeat.o(261668);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.XEffectConfig
 * JD-Core Version:    0.7.0.1
 */