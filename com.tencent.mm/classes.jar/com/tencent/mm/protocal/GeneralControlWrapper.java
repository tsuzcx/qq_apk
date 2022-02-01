package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.ad;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper FnA;
  private static Boolean FnC;
  public static final GeneralControlWrapper Fnz;
  public int FnB;
  
  static
  {
    AppMethodBeat.i(152449);
    Fnz = new GeneralControlWrapper(10);
    FnA = new GeneralControlWrapper(1);
    FnC = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.FnB = paramInt;
    ad.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.FnB = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(aut paramaut)
  {
    AppMethodBeat.i(152438);
    if (paramaut == null) {}
    for (this.FnB = 0;; this.FnB = paramaut.GsY)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
      AppMethodBeat.o(152438);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fgk()
  {
    AppMethodBeat.i(195456);
    if ((this.FnB & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195456);
      return bool;
    }
  }
  
  public final boolean fgl()
  {
    AppMethodBeat.i(152441);
    if ((this.FnB & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean fgm()
  {
    AppMethodBeat.i(152442);
    if ((this.FnB & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean fgn()
  {
    AppMethodBeat.i(195457);
    if ((this.FnB & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195457);
      return bool;
    }
  }
  
  public final boolean fgo()
  {
    AppMethodBeat.i(195458);
    if ((this.FnB & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(195458);
      return bool;
    }
  }
  
  public final boolean fgp()
  {
    AppMethodBeat.i(152443);
    if ((this.FnB & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean fgq()
  {
    AppMethodBeat.i(152444);
    if ((this.FnB & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean fgr()
  {
    AppMethodBeat.i(152445);
    if ((this.FnB & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152445);
      return bool;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(152446);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.FnB));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.FnB);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */