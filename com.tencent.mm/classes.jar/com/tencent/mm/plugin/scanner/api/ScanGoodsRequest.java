package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;

public class ScanGoodsRequest
  extends BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ScanGoodsRequest> CREATOR;
  public int CAM;
  public String CAN;
  public String CAO;
  public String CAP;
  public String CAQ;
  public boolean CAR;
  public boolean CAS;
  public String extInfo;
  public int kca;
  public int mode;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(224198);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(224198);
  }
  
  public ScanGoodsRequest()
  {
    this.kca = 0;
    this.CAR = true;
    this.CAS = false;
    this.CAE = true;
    this.CAF = true;
    this.CAG = true;
    this.CAH = true;
    this.CAI = true;
    this.CAR = true;
    this.CAS = false;
    this.CAM = 0;
  }
  
  public ScanGoodsRequest(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(224194);
    this.kca = 0;
    this.CAR = true;
    this.CAS = false;
    this.mode = paramParcel.readInt();
    this.requestType = paramParcel.readInt();
    this.CAM = paramParcel.readInt();
    this.CAN = paramParcel.readString();
    this.CAO = paramParcel.readString();
    this.CAP = paramParcel.readString();
    this.CAQ = paramParcel.readString();
    this.kca = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.CAR = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CAS = bool1;
      this.extInfo = paramParcel.readString();
      AppMethodBeat.o(224194);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ScanGoodsRequest eOU()
  {
    AppMethodBeat.i(224197);
    ScanGoodsRequest localScanGoodsRequest = new ScanGoodsRequest();
    localScanGoodsRequest.mode = 5;
    localScanGoodsRequest.requestType = 1;
    localScanGoodsRequest.CAE = true;
    localScanGoodsRequest.CAF = true;
    localScanGoodsRequest.CAG = true;
    localScanGoodsRequest.CAH = true;
    localScanGoodsRequest.CAI = true;
    localScanGoodsRequest.CAR = false;
    localScanGoodsRequest.CAS = true;
    localScanGoodsRequest.kca = a.fromDPToPix(MMApplicationContext.getContext(), 514);
    AppMethodBeat.o(224197);
    return localScanGoodsRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(224195);
    if ((s.YS(this.CAN)) && (s.YS(this.CAO)) && (s.YS(this.CAP)))
    {
      AppMethodBeat.o(224195);
      return true;
    }
    AppMethodBeat.o(224195);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(224196);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.requestType);
    paramParcel.writeInt(this.CAM);
    paramParcel.writeString(this.CAN);
    paramParcel.writeString(this.CAO);
    paramParcel.writeString(this.CAP);
    paramParcel.writeString(this.CAQ);
    paramParcel.writeInt(this.kca);
    if (this.CAR)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.CAS) {
        break label126;
      }
    }
    label126:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(224196);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.ScanGoodsRequest
 * JD-Core Version:    0.7.0.1
 */