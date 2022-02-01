package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@Keep
public class MediaEditReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaEditReportInfo> CREATOR;
  public int cropSizeCnt;
  public ArrayList<MediaEditReportInfo.EditItem> editList;
  public int seekBarDragCnt;
  
  static
  {
    AppMethodBeat.i(207047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(207047);
  }
  
  public MediaEditReportInfo()
  {
    AppMethodBeat.i(207044);
    this.editList = new ArrayList();
    AppMethodBeat.o(207044);
  }
  
  protected MediaEditReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(207045);
    this.editList = new ArrayList();
    this.seekBarDragCnt = paramParcel.readInt();
    this.cropSizeCnt = paramParcel.readInt();
    paramParcel.readList(this.editList, MediaEditReportInfo.EditItem.class.getClassLoader());
    AppMethodBeat.o(207045);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(207046);
    paramParcel.writeInt(this.seekBarDragCnt);
    paramParcel.writeInt(this.cropSizeCnt);
    paramParcel.writeList(this.editList);
    AppMethodBeat.o(207046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo
 * JD-Core Version:    0.7.0.1
 */