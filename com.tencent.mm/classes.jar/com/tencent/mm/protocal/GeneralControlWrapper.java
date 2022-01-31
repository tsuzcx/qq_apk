package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.sdk.platformtools.ab;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper whX;
  public static final GeneralControlWrapper whY;
  private static Boolean wia;
  public int whZ;
  
  static
  {
    AppMethodBeat.i(79976);
    whX = new GeneralControlWrapper(10);
    whY = new GeneralControlWrapper(1);
    wia = null;
    CREATOR = new GeneralControlWrapper.1();
    AppMethodBeat.o(79976);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(79966);
    this.whZ = paramInt;
    ab.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(79966);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(79975);
    this.whZ = paramParcel.readInt();
    AppMethodBeat.o(79975);
  }
  
  public GeneralControlWrapper(afc paramafc)
  {
    AppMethodBeat.i(79965);
    if (paramafc == null) {}
    for (this.whZ = 0;; this.whZ = paramafc.wXX)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
      AppMethodBeat.o(79965);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean dqu()
  {
    AppMethodBeat.i(79967);
    boolean bool1;
    if ((this.whZ & 0x40000) != 0)
    {
      bool1 = true;
      if (wia == null) {
        if (1 != ((a)g.E(a.class)).a(a.a.lUt, 0)) {
          break label102;
        }
      }
    }
    label102:
    for (boolean bool2 = true;; bool2 = false)
    {
      wia = Boolean.valueOf(bool2);
      ab.d("MicroMsg.GeneralControlWrapper", "canCallJsApiBeforeLoad, ret = %b, canCallJsApiBeforeLoaded = %b", new Object[] { Boolean.valueOf(bool1), wia });
      if ((!bool1) && (!wia.booleanValue())) {
        break label107;
      }
      AppMethodBeat.o(79967);
      return true;
      bool1 = false;
      break;
    }
    label107:
    AppMethodBeat.o(79967);
    return false;
  }
  
  public final boolean dqv()
  {
    AppMethodBeat.i(79968);
    if ((this.whZ & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(79968);
      return bool;
    }
  }
  
  public final boolean dqw()
  {
    AppMethodBeat.i(79969);
    if ((this.whZ & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(79969);
      return bool;
    }
  }
  
  public final boolean dqx()
  {
    AppMethodBeat.i(79970);
    if ((this.whZ & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(79970);
      return bool;
    }
  }
  
  public final boolean dqy()
  {
    AppMethodBeat.i(79971);
    if ((this.whZ & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(79971);
      return bool;
    }
  }
  
  public final boolean dqz()
  {
    AppMethodBeat.i(79972);
    if ((this.whZ & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(79972);
      return bool;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(79973);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.whZ));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(79973);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79974);
    paramParcel.writeInt(this.whZ);
    AppMethodBeat.o(79974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */