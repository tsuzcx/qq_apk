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
  ArrayList<KVReportDataInfo> qse;
  ArrayList<StIDKeyDataInfo> qsf;
  ArrayList<GroupIDKeyDataInfo> qsg;
  
  static
  {
    AppMethodBeat.i(72694);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(72694);
  }
  
  public BroadCastData()
  {
    AppMethodBeat.i(72690);
    this.qse = new ArrayList();
    this.qsf = new ArrayList();
    this.qsg = new ArrayList();
    AppMethodBeat.o(72690);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    AppMethodBeat.i(72692);
    this.qse = new ArrayList();
    this.qsf = new ArrayList();
    this.qsg = new ArrayList();
    paramParcel.readTypedList(this.qse, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.qsf, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.qsg, GroupIDKeyDataInfo.CREATOR);
    AppMethodBeat.o(72692);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    AppMethodBeat.i(72691);
    this.qse = new ArrayList();
    this.qsf = new ArrayList();
    this.qsg = new ArrayList();
    if (paramBroadCastData == null)
    {
      AppMethodBeat.o(72691);
      return;
    }
    this.qse = new ArrayList(paramBroadCastData.qse);
    this.qsf = new ArrayList(paramBroadCastData.qsf);
    this.qsg = new ArrayList(paramBroadCastData.qsg);
    AppMethodBeat.o(72691);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(72693);
    paramParcel.writeTypedList(this.qse);
    paramParcel.writeTypedList(this.qsf);
    paramParcel.writeTypedList(this.qsg);
    AppMethodBeat.o(72693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */