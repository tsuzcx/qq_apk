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
  ArrayList<IDKey> OzD;
  public boolean OzE;
  
  static
  {
    AppMethodBeat.i(143815);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143815);
  }
  
  protected GroupIDKeyDataInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(143814);
    this.OzD = new ArrayList();
    paramParcel.readTypedList(this.OzD, IDKey.CREATOR);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.OzE = bool;
      AppMethodBeat.o(143814);
      return;
      bool = false;
    }
  }
  
  GroupIDKeyDataInfo(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143812);
    this.OzD = new ArrayList();
    this.OzD = paramArrayList;
    this.OzE = false;
    AppMethodBeat.o(143812);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143813);
    paramParcel.writeTypedList(this.OzD);
    if (this.OzE) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(143813);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo
 * JD-Core Version:    0.7.0.1
 */