package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.ad;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper Cqa;
  public static final GeneralControlWrapper Cqb;
  private static Boolean Cqd;
  public int Cqc;
  
  static
  {
    AppMethodBeat.i(152449);
    Cqa = new GeneralControlWrapper(10);
    Cqb = new GeneralControlWrapper(1);
    Cqd = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152449);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    AppMethodBeat.i(152439);
    this.Cqc = paramInt;
    ad.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
    AppMethodBeat.o(152439);
  }
  
  private GeneralControlWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152448);
    this.Cqc = paramParcel.readInt();
    AppMethodBeat.o(152448);
  }
  
  public GeneralControlWrapper(ant paramant)
  {
    AppMethodBeat.i(152438);
    if (paramant == null) {}
    for (this.Cqc = 0;; this.Cqc = paramant.DoW)
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
  
  public final boolean eBL()
  {
    AppMethodBeat.i(190795);
    if ((this.Cqc & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(190795);
      return bool;
    }
  }
  
  public final boolean eBM()
  {
    AppMethodBeat.i(152441);
    if ((this.Cqc & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152441);
      return bool;
    }
  }
  
  public final boolean eBN()
  {
    AppMethodBeat.i(152442);
    if ((this.Cqc & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152442);
      return bool;
    }
  }
  
  public final boolean eBO()
  {
    AppMethodBeat.i(190796);
    if ((this.Cqc & 0x200) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(190796);
      return bool;
    }
  }
  
  public final boolean eBP()
  {
    AppMethodBeat.i(190797);
    if ((this.Cqc & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(190797);
      return bool;
    }
  }
  
  public final boolean eBQ()
  {
    AppMethodBeat.i(152443);
    if ((this.Cqc & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152443);
      return bool;
    }
  }
  
  public final boolean eBR()
  {
    AppMethodBeat.i(152444);
    if ((this.Cqc & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(152444);
      return bool;
    }
  }
  
  public final boolean eBS()
  {
    AppMethodBeat.i(152445);
    if ((this.Cqc & 0x8000) > 0) {}
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
    ((StringBuilder)localObject).append(Integer.toHexString(this.Cqc));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(152446);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152447);
    paramParcel.writeInt(this.Cqc);
    AppMethodBeat.o(152447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.GeneralControlWrapper
 * JD-Core Version:    0.7.0.1
 */