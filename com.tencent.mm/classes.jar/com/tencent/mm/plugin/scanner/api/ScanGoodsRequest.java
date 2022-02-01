package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public String OMA;
  public String OMB;
  public String OMC;
  public String OMD;
  public boolean OME;
  public boolean OMF;
  public int OMz;
  public String extInfo;
  public int mode;
  public int pQg;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(313451);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(313451);
  }
  
  public ScanGoodsRequest()
  {
    this.pQg = 0;
    this.OME = true;
    this.OMF = false;
    this.OMs = true;
    this.OMt = true;
    this.OMu = true;
    this.OMv = true;
    this.OMw = true;
    this.OME = true;
    this.OMF = false;
    this.OMz = 0;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(313443);
    this.pQg = 0;
    this.OME = true;
    this.OMF = false;
    this.mode = paramParcel.readInt();
    this.requestType = paramParcel.readInt();
    this.OMz = paramParcel.readInt();
    this.OMA = paramParcel.readString();
    this.OMB = paramParcel.readString();
    this.OMC = paramParcel.readString();
    this.OMD = paramParcel.readString();
    this.pQg = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.OME = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.OMF = bool1;
      this.extInfo = paramParcel.readString();
      AppMethodBeat.o(313443);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest gPC()
  {
    AppMethodBeat.i(313447);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.requestType = 1;
    localScanGoodsRequest.OMs = true;
    localScanGoodsRequest.OMt = true;
    localScanGoodsRequest.OMu = true;
    localScanGoodsRequest.OMv = true;
    localScanGoodsRequest.OMw = true;
    localScanGoodsRequest.OME = false;
    localScanGoodsRequest.OMF = true;
    localScanGoodsRequest.pQg = a.fromDPToPix(MMApplicationContext.getContext(), 514);
    AppMethodBeat.o(313447);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(313454);
    if ((y.ZC(this.OMA)) && (y.ZC(this.OMB)) && (y.ZC(this.OMC)))
    {
      AppMethodBeat.o(313454);
      return true;
    }
    AppMethodBeat.o(313454);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(313456);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.requestType);
    paramParcel.writeInt(this.OMz);
    paramParcel.writeString(this.OMA);
    paramParcel.writeString(this.OMB);
    paramParcel.writeString(this.OMC);
    paramParcel.writeString(this.OMD);
    paramParcel.writeInt(this.pQg);
    if (this.OME)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.OMF) {
        break label126;
      }
    }
    label126:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(313456);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.ScanGoodsRequest
 * JD-Core Version:    0.7.0.1
 */