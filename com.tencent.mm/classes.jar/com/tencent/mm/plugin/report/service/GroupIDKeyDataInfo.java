package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

class GroupIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupIDKeyDataInfo> CREATOR = new Parcelable.Creator() {};
  ArrayList<IDKey> nFf = new ArrayList();
  public boolean nFg;
  
  protected GroupIDKeyDataInfo(Parcel paramParcel)
  {
    paramParcel.readTypedList(this.nFf, IDKey.CREATOR);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.nFg = bool;
      return;
      bool = false;
    }
  }
  
  GroupIDKeyDataInfo(ArrayList<IDKey> paramArrayList)
  {
    this.nFf = paramArrayList;
    this.nFg = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.nFf);
    if (this.nFg) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */