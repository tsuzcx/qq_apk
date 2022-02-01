package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.Log;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper Kzg;
  public static final GeneralControlWrapper Kzh;
  private static Boolean Kzj;
  public int Kzi;
  
  static
  {
    AppMethodBeat.i(152449);
    Kzg = new GeneralControlWrapper(10);
    Kzh = new GeneralControlWrapper(1);
    Kzj = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.Kzi = paramInt;
    Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.Kzi = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(bgt parambgt)
  {
    AppMethodBeat.i(152438);
    if (parambgt == null) {}
    for (this.Kzi = 0;; this.Kzi = parambgt.LQC)
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
  
  public final boolean gtB()
  {
    AppMethodBeat.i(223874);
    if ((this.Kzi & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(223874);
      return bool;
    }
  }
  
  public final boolean gtC()
  {
    AppMethodBeat.i(152441);
    if ((this.Kzi & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean gtD()
  {
    AppMethodBeat.i(152442);
    if ((this.Kzi & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean gtE()
  {
    AppMethodBeat.i(223875);
    if ((this.Kzi & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(223875);
      return bool;
    }
  }
  
  public final boolean gtF()
  {
    AppMethodBeat.i(223876);
    if ((this.Kzi & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(223876);
      return bool;
    }
  }
  
  public final boolean gtG()
  {
    AppMethodBeat.i(152443);
    if ((this.Kzi & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean gtH()
  {
    AppMethodBeat.i(152444);
    if ((this.Kzi & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean gtI()
  {
    AppMethodBeat.i(152445);
    if ((this.Kzi & 0x8000) > 0) {}
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
    ((StringBuilder)localObject).append(Integer.toHexString(this.Kzi));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.Kzi);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */