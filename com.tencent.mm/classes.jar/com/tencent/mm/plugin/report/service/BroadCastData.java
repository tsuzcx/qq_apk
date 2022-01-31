package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData
  implements Parcelable
{
  public static final Parcelable.Creator<BroadCastData> CREATOR = new Parcelable.Creator() {};
  ArrayList<KVReportDataInfo> nFc = new ArrayList();
  ArrayList<StIDKeyDataInfo> nFd = new ArrayList();
  ArrayList<GroupIDKeyDataInfo> nFe = new ArrayList();
  
  public BroadCastData() {}
  
  protected BroadCastData(Parcel paramParcel)
  {
    paramParcel.readTypedList(this.nFc, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.nFd, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.nFe, GroupIDKeyDataInfo.CREATOR);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    if (paramBroadCastData == null) {
      return;
    }
    this.nFc = new ArrayList(paramBroadCastData.nFc);
    this.nFd = new ArrayList(paramBroadCastData.nFd);
    this.nFe = new ArrayList(paramBroadCastData.nFe);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.nFc);
    paramParcel.writeTypedList(this.nFd);
    paramParcel.writeTypedList(this.nFe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.BroadCastData
 * JD-Core Version:    0.7.0.1
 */