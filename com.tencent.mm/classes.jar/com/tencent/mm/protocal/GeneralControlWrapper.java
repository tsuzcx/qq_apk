package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ae;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper FFX;
  public static final GeneralControlWrapper FFY;
  private static Boolean FGa;
  public int FFZ;
  
  static
  {
    AppMethodBeat.i(152449);
    FFX = new GeneralControlWrapper(10);
    FFY = new GeneralControlWrapper(1);
    FGa = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.FFZ = paramInt;
    ae.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.FFZ = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(avj paramavj)
  {
    AppMethodBeat.i(152438);
    if (paramavj == null) {}
    for (this.FFZ = 0;; this.FFZ = paramavj.GMw)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
      AppMethodBeat.o(152438);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fka()
  {
    AppMethodBeat.i(218909);
    if ((this.FFZ & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(218909);
      return bool;
    }
  }
  
  public final boolean fkb()
  {
    AppMethodBeat.i(152441);
    if ((this.FFZ & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean fkc()
  {
    AppMethodBeat.i(152442);
    if ((this.FFZ & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean fkd()
  {
    AppMethodBeat.i(218910);
    if ((this.FFZ & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(218910);
      return bool;
    }
  }
  
  public final boolean fke()
  {
    AppMethodBeat.i(218911);
    if ((this.FFZ & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(218911);
      return bool;
    }
  }
  
  public final boolean fkf()
  {
    AppMethodBeat.i(152443);
    if ((this.FFZ & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean fkg()
  {
    AppMethodBeat.i(152444);
    if ((this.FFZ & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean fkh()
  {
    AppMethodBeat.i(152445);
    if ((this.FFZ & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152445);
      return bool;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(152446);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.FFZ));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.FFZ);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */