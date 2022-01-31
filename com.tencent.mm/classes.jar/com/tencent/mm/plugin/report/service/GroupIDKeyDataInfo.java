package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class GroupIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupIDKeyDataInfo> CREATOR;
  ArrayList<IDKey> qsh;
  public boolean qsi;
  
  static
  {
    AppMethodBeat.i(72699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(72699);
  }
  
  protected GroupIDKeyDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(72698);
    this.qsh = new ArrayList();
    paramParcel.readTypedList(this.qsh, IDKey.CREATOR);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.qsi = bool;
      AppMethodBeat.o(72698);
      return;
      bool = false;
    }
  }
  
  GroupIDKeyDataInfo(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(72696);
    this.qsh = new ArrayList();
    this.qsh = paramArrayList;
    this.qsi = false;
    AppMethodBeat.o(72696);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(72697);
    paramParcel.writeTypedList(this.qsh);
    if (this.qsi) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(72697);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */