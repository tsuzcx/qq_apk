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
  ArrayList<KVReportDataInfo> OzA;
  ArrayList<StIDKeyDataInfo> OzB;
  ArrayList<GroupIDKeyDataInfo> OzC;
  
  static
  {
    AppMethodBeat.i(143810);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143810);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(143806);
    this.OzA = new ArrayList();
    this.OzB = new ArrayList();
    this.OzC = new ArrayList();
    AppMethodBeat.o(143806);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(143808);
    this.OzA = new ArrayList();
    this.OzB = new ArrayList();
    this.OzC = new ArrayList();
    paramParcel.readTypedList(this.OzA, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.OzB, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.OzC, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(143808);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(143807);
    this.OzA = new ArrayList();
    this.OzB = new ArrayList();
    this.OzC = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(143807);
      return;
    }
    this.OzA = new ArrayList(paramBroadCastData.OzA);
    this.OzB = new ArrayList(paramBroadCastData.OzB);
    this.OzC = new ArrayList(paramBroadCastData.OzC);
    AppMethodBeat.o(143807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143809);
    paramParcel.writeTypedList(this.OzA);
    paramParcel.writeTypedList(this.OzB);
    paramParcel.writeTypedList(this.OzC);
    AppMethodBeat.o(143809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */