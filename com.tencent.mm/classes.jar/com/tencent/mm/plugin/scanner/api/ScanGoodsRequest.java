package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public int IGr;
  public String IGs;
  public String IGt;
  public String IGu;
  public String IGv;
  public boolean IGw;
  public boolean IGx;
  public String extInfo;
  public int mTz;
  public int mode;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(210463);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(210463);
  }
  
  public ScanGoodsRequest()
  {
    this.mTz = 0;
    this.IGw = true;
    this.IGx = false;
    this.IGk = true;
    this.IGl = true;
    this.IGm = true;
    this.IGn = true;
    this.IGo = true;
    this.IGw = true;
    this.IGx = false;
    this.IGr = 0;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(210458);
    this.mTz = 0;
    this.IGw = true;
    this.IGx = false;
    this.mode = paramParcel.readInt();
    this.requestType = paramParcel.readInt();
    this.IGr = paramParcel.readInt();
    this.IGs = paramParcel.readString();
    this.IGt = paramParcel.readString();
    this.IGu = paramParcel.readString();
    this.IGv = paramParcel.readString();
    this.mTz = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.IGw = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.IGx = bool1;
      this.extInfo = paramParcel.readString();
      AppMethodBeat.o(210458);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest fBW()
  {
    AppMethodBeat.i(210461);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.requestType = 1;
    localScanGoodsRequest.IGk = true;
    localScanGoodsRequest.IGl = true;
    localScanGoodsRequest.IGm = true;
    localScanGoodsRequest.IGn = true;
    localScanGoodsRequest.IGo = true;
    localScanGoodsRequest.IGw = false;
    localScanGoodsRequest.IGx = true;
    localScanGoodsRequest.mTz = a.fromDPToPix(MMApplicationContext.getContext(), 514);
    AppMethodBeat.o(210461);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(210459);
    if ((u.agG(this.IGs)) && (u.agG(this.IGt)) && (u.agG(this.IGu)))
    {
      AppMethodBeat.o(210459);
      return true;
    }
    AppMethodBeat.o(210459);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(210460);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.requestType);
    paramParcel.writeInt(this.IGr);
    paramParcel.writeString(this.IGs);
    paramParcel.writeString(this.IGt);
    paramParcel.writeString(this.IGu);
    paramParcel.writeString(this.IGv);
    paramParcel.writeInt(this.mTz);
    if (this.IGw)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.IGx) {
        break label126;
      }
    }
    label126:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(210460);
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