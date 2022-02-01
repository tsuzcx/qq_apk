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
  ArrayList<KVReportDataInfo> vJt;
  ArrayList<StIDKeyDataInfo> vJu;
  ArrayList<GroupIDKeyDataInfo> vJv;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.vJt = new ArrayList();
    this.vJu = new ArrayList();
    this.vJv = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.vJt = new ArrayList();
    this.vJu = new ArrayList();
    this.vJv = new ArrayList();
    paramParcel.readTypedList(this.vJt, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.vJu, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.vJv, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.vJt = new ArrayList();
    this.vJu = new ArrayList();
    this.vJv = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.vJt = new ArrayList(paramBroadCastData.vJt);
    this.vJu = new ArrayList(paramBroadCastData.vJu);
    this.vJv = new ArrayList(paramBroadCastData.vJv);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.vJt);
    paramParcel.writeTypedList(this.vJu);
    paramParcel.writeTypedList(this.vJv);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */