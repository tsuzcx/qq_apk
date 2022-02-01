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
  ArrayList<KVReportDataInfo> IyT;
  ArrayList<StIDKeyDataInfo> IyU;
  ArrayList<GroupIDKeyDataInfo> IyV;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.IyT = new ArrayList();
    this.IyU = new ArrayList();
    this.IyV = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.IyT = new ArrayList();
    this.IyU = new ArrayList();
    this.IyV = new ArrayList();
    paramParcel.readTypedList(this.IyT, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.IyU, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.IyV, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.IyT = new ArrayList();
    this.IyU = new ArrayList();
    this.IyV = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.IyT = new ArrayList(paramBroadCastData.IyT);
    this.IyU = new ArrayList(paramBroadCastData.IyU);
    this.IyV = new ArrayList(paramBroadCastData.IyV);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.IyT);
    paramParcel.writeTypedList(this.IyU);
    paramParcel.writeTypedList(this.IyV);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */