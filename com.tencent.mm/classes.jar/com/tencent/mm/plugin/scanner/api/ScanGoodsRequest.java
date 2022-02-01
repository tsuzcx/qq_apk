package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public String extInfo;
  public int jdX;
  public int mode;
  public int requestType;
  public int yzG;
  public String yzH;
  public String yzI;
  public String yzJ;
  public String yzK;
  public boolean yzL;
  public boolean yzM;
  
  static
  {
    AppMethodBeat.i(210676);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(210676);
  }
  
  public ScanGoodsRequest()
  {
    this.jdX = 0;
    this.yzL = true;
    this.yzM = false;
    this.yzA = true;
    this.yzB = true;
    this.yzC = true;
    this.yzD = true;
    this.yzE = true;
    this.yzL = true;
    this.yzM = false;
    this.yzG = 0;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(210672);
    this.jdX = 0;
    this.yzL = true;
    this.yzM = false;
    this.mode = paramParcel.readInt();
    this.requestType = paramParcel.readInt();
    this.yzG = paramParcel.readInt();
    this.yzH = paramParcel.readString();
    this.yzI = paramParcel.readString();
    this.yzJ = paramParcel.readString();
    this.yzK = paramParcel.readString();
    this.jdX = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.yzL = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yzM = bool1;
      this.extInfo = paramParcel.readString();
      AppMethodBeat.o(210672);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest dNS()
  {
    AppMethodBeat.i(210675);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.yzA = true;
    localScanGoodsRequest.yzB = true;
    localScanGoodsRequest.yzC = true;
    localScanGoodsRequest.yzD = true;
    localScanGoodsRequest.yzE = true;
    localScanGoodsRequest.yzL = false;
    localScanGoodsRequest.yzM = true;
    localScanGoodsRequest.jdX = a.fromDPToPix(ak.getContext(), 450);
    AppMethodBeat.o(210675);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(210673);
    if ((o.fB(this.yzH)) && (o.fB(this.yzI)) && (o.fB(this.yzJ)))
    {
      AppMethodBeat.o(210673);
      return true;
    }
    AppMethodBeat.o(210673);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(210674);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.requestType);
    paramParcel.writeInt(this.yzG);
    paramParcel.writeString(this.yzH);
    paramParcel.writeString(this.yzI);
    paramParcel.writeString(this.yzJ);
    paramParcel.writeString(this.yzK);
    paramParcel.writeInt(this.jdX);
    if (this.yzL)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.yzM) {
        break label126;
      }
    }
    label126:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(210674);
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