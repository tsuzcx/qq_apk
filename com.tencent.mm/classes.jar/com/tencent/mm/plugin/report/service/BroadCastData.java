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
  ArrayList<KVReportDataInfo> yhh;
  ArrayList<StIDKeyDataInfo> yhi;
  ArrayList<GroupIDKeyDataInfo> yhj;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.yhh = new ArrayList();
    this.yhi = new ArrayList();
    this.yhj = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.yhh = new ArrayList();
    this.yhi = new ArrayList();
    this.yhj = new ArrayList();
    paramParcel.readTypedList(this.yhh, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.yhi, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.yhj, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.yhh = new ArrayList();
    this.yhi = new ArrayList();
    this.yhj = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.yhh = new ArrayList(paramBroadCastData.yhh);
    this.yhi = new ArrayList(paramBroadCastData.yhi);
    this.yhj = new ArrayList(paramBroadCastData.yhj);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.yhh);
    paramParcel.writeTypedList(this.yhi);
    paramParcel.writeTypedList(this.yhj);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */