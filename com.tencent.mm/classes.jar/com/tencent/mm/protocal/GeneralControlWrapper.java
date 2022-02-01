package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.sdk.platformtools.ac;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper DIs;
  public static final GeneralControlWrapper DIt;
  private static Boolean DIv;
  public int DIu;
  
  static
  {
    AppMethodBeat.i(152449);
    DIs = new GeneralControlWrapper(10);
    DIt = new GeneralControlWrapper(1);
    DIv = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.DIu = paramInt;
    ac.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.DIu = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(aqx paramaqx)
  {
    AppMethodBeat.i(152438);
    if (paramaqx == null) {}
    for (this.DIu = 0;; this.DIu = paramaqx.EJW)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
      AppMethodBeat.o(152438);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eRg()
  {
    AppMethodBeat.i(192703);
    if ((this.DIu & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(192703);
      return bool;
    }
  }
  
  public final boolean eRh()
  {
    AppMethodBeat.i(152441);
    if ((this.DIu & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean eRi()
  {
    AppMethodBeat.i(152442);
    if ((this.DIu & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean eRj()
  {
    AppMethodBeat.i(192704);
    if ((this.DIu & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(192704);
      return bool;
    }
  }
  
  public final boolean eRk()
  {
    AppMethodBeat.i(192705);
    if ((this.DIu & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(192705);
      return bool;
    }
  }
  
  public final boolean eRl()
  {
    AppMethodBeat.i(152443);
    if ((this.DIu & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean eRm()
  {
    AppMethodBeat.i(152444);
    if ((this.DIu & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean eRn()
  {
    AppMethodBeat.i(152445);
    if ((this.DIu & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152445);
      return bool;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(152446);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.DIu));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.DIu);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */