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
  ArrayList<KVReportDataInfo> ywY;
  ArrayList<StIDKeyDataInfo> ywZ;
  ArrayList<GroupIDKeyDataInfo> yxa;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.ywY = new ArrayList();
    this.ywZ = new ArrayList();
    this.yxa = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.ywY = new ArrayList();
    this.ywZ = new ArrayList();
    this.yxa = new ArrayList();
    paramParcel.readTypedList(this.ywY, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.ywZ, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.yxa, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.ywY = new ArrayList();
    this.ywZ = new ArrayList();
    this.yxa = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.ywY = new ArrayList(paramBroadCastData.ywY);
    this.ywZ = new ArrayList(paramBroadCastData.ywZ);
    this.yxa = new ArrayList(paramBroadCastData.yxa);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.ywY);
    paramParcel.writeTypedList(this.ywZ);
    paramParcel.writeTypedList(this.yxa);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */