package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.Log;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper RAX;
  public static final GeneralControlWrapper RAY;
  public int RAZ;
  
  static
  {
    AppMethodBeat.i(152449);
    RAX = new GeneralControlWrapper(10);
    RAY = new GeneralControlWrapper(1);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.RAZ = paramInt;
    Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.RAZ = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(bob parambob)
  {
    AppMethodBeat.i(152438);
    if (parambob == null) {}
    for (this.RAZ = 0;; this.RAZ = parambob.SZd)
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
  
  public final boolean hoR()
  {
    AppMethodBeat.i(195651);
    if ((this.RAZ & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195651);
      return bool;
    }
  }
  
  public final boolean hoS()
  {
    AppMethodBeat.i(152441);
    if ((this.RAZ & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean hoT()
  {
    AppMethodBeat.i(152442);
    if ((this.RAZ & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean hoU()
  {
    AppMethodBeat.i(195655);
    if ((this.RAZ & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195655);
      return bool;
    }
  }
  
  public final boolean hoV()
  {
    AppMethodBeat.i(195657);
    if ((this.RAZ & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195657);
      return bool;
    }
  }
  
  public final boolean hoW()
  {
    AppMethodBeat.i(152443);
    if ((this.RAZ & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean hoX()
  {
    AppMethodBeat.i(152444);
    if ((this.RAZ & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean hoY()
  {
    AppMethodBeat.i(152445);
    if ((this.RAZ & 0x8000) > 0) {}
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
    ((StringBuilder)localObject).append(Integer.toHexString(this.RAZ));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.RAZ);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */