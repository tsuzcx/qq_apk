package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.sdk.platformtools.Log;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper YxA;
  public static final GeneralControlWrapper YxB;
  public int YxC;
  
  static
  {
    AppMethodBeat.i(152449);
    YxA = new GeneralControlWrapper(10);
    YxB = new GeneralControlWrapper(1);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.YxC = paramInt;
    Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.YxC = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(ccm paramccm)
  {
    AppMethodBeat.i(152438);
    if (paramccm == null) {}
    for (this.YxC = 0;; this.YxC = paramccm.aalV)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
      AppMethodBeat.o(152438);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean iPN()
  {
    AppMethodBeat.i(257298);
    if ((this.YxC & 0x80000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(257298);
      return bool;
    }
  }
  
  public final boolean iPO()
  {
    AppMethodBeat.i(152441);
    if ((this.YxC & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean iPP()
  {
    AppMethodBeat.i(152442);
    if ((this.YxC & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean iPQ()
  {
    AppMethodBeat.i(152443);
    if ((this.YxC & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean iPR()
  {
    AppMethodBeat.i(152444);
    if ((this.YxC & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean iPS()
  {
    AppMethodBeat.i(152445);
    if ((this.YxC & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152445);
      return bool;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(152446);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.YxC));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.YxC);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */