package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class BroadCastData
  implements Parcelable
{
  public static final Parcelable.Creator<BroadCastData> CREATOR;
  ArrayList<KVReportDataInfo> wTx;
  ArrayList<StIDKeyDataInfo> wTy;
  ArrayList<GroupIDKeyDataInfo> wTz;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.wTx = new ArrayList();
    this.wTy = new ArrayList();
    this.wTz = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.wTx = new ArrayList();
    this.wTy = new ArrayList();
    this.wTz = new ArrayList();
    paramParcel.readTypedList(this.wTx, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.wTy, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.wTz, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.wTx = new ArrayList();
    this.wTy = new ArrayList();
    this.wTz = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.wTx = new ArrayList(paramBroadCastData.wTx);
    this.wTy = new ArrayList(paramBroadCastData.wTy);
    this.wTz = new ArrayList(paramBroadCastData.wTz);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.wTx);
    paramParcel.writeTypedList(this.wTy);
    paramParcel.writeTypedList(this.wTz);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */