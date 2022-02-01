package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public int iHV;
  public int mode;
  public String wWd;
  public String wWe;
  public String wWf;
  public String wWg;
  public boolean wWh;
  public boolean wWi;
  
  static
  {
    AppMethodBeat.i(191790);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191790);
  }
  
  public ScanGoodsRequest()
  {
    this.iHV = 0;
    this.wWh = true;
    this.wWi = true;
    this.wVX = true;
    this.wVY = true;
    this.wVZ = true;
    this.wWa = true;
    this.wWb = true;
    this.wWh = true;
    this.wWi = true;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(191786);
    this.iHV = 0;
    this.wWh = true;
    this.wWi = true;
    this.mode = paramParcel.readInt();
    this.wWd = paramParcel.readString();
    this.wWe = paramParcel.readString();
    this.wWf = paramParcel.readString();
    this.wWg = paramParcel.readString();
    this.iHV = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.wWh = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wWi = bool1;
      AppMethodBeat.o(191786);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest dzc()
  {
    AppMethodBeat.i(191789);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.wVX = true;
    localScanGoodsRequest.wVY = true;
    localScanGoodsRequest.wVZ = true;
    localScanGoodsRequest.wWa = true;
    localScanGoodsRequest.wWb = true;
    localScanGoodsRequest.wWh = false;
    localScanGoodsRequest.wWi = true;
    localScanGoodsRequest.iHV = a.fromDPToPix(ai.getContext(), 450);
    AppMethodBeat.o(191789);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(191787);
    if ((i.eA(this.wWd)) && (i.eA(this.wWe)) && (i.eA(this.wWf)))
    {
      AppMethodBeat.o(191787);
      return true;
    }
    AppMethodBeat.o(191787);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(191788);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeString(this.wWd);
    paramParcel.writeString(this.wWe);
    paramParcel.writeString(this.wWf);
    paramParcel.writeString(this.wWg);
    paramParcel.writeInt(this.iHV);
    if (this.wWh)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.wWi) {
        break label102;
      }
    }
    label102:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(191788);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.ScanGoodsRequest
 * JD-Core Version:    0.7.0.1
 */