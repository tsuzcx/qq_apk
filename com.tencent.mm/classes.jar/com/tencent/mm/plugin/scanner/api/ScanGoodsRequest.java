package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public String extInfo;
  public int jbe;
  public int mode;
  public int requestType;
  public int yjK;
  public String yjL;
  public String yjM;
  public String yjN;
  public String yjO;
  public boolean yjP;
  public boolean yjQ;
  
  static
  {
    AppMethodBeat.i(191534);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191534);
  }
  
  public ScanGoodsRequest()
  {
    this.jbe = 0;
    this.yjP = true;
    this.yjQ = false;
    this.yjE = true;
    this.yjF = true;
    this.yjG = true;
    this.yjH = true;
    this.yjI = true;
    this.yjP = true;
    this.yjQ = false;
    this.yjK = 0;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(191530);
    this.jbe = 0;
    this.yjP = true;
    this.yjQ = false;
    this.mode = paramParcel.readInt();
    this.requestType = paramParcel.readInt();
    this.yjK = paramParcel.readInt();
    this.yjL = paramParcel.readString();
    this.yjM = paramParcel.readString();
    this.yjN = paramParcel.readString();
    this.yjO = paramParcel.readString();
    this.jbe = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.yjP = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yjQ = bool1;
      this.extInfo = paramParcel.readString();
      AppMethodBeat.o(191530);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest dKA()
  {
    AppMethodBeat.i(191533);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.yjE = true;
    localScanGoodsRequest.yjF = true;
    localScanGoodsRequest.yjG = true;
    localScanGoodsRequest.yjH = true;
    localScanGoodsRequest.yjI = true;
    localScanGoodsRequest.yjP = false;
    localScanGoodsRequest.yjQ = true;
    localScanGoodsRequest.jbe = a.fromDPToPix(aj.getContext(), 450);
    AppMethodBeat.o(191533);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(191531);
    if ((i.fv(this.yjL)) && (i.fv(this.yjM)) && (i.fv(this.yjN)))
    {
      AppMethodBeat.o(191531);
      return true;
    }
    AppMethodBeat.o(191531);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(191532);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.requestType);
    paramParcel.writeInt(this.yjK);
    paramParcel.writeString(this.yjL);
    paramParcel.writeString(this.yjM);
    paramParcel.writeString(this.yjN);
    paramParcel.writeString(this.yjO);
    paramParcel.writeInt(this.jbe);
    if (this.yjP)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.yjQ) {
        break label126;
      }
    }
    label126:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(191532);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.ScanGoodsRequest
 * JD-Core Version:    0.7.0.1
 */