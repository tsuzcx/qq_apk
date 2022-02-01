package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MediaEditReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaEditReportInfo> CREATOR;
  public int cropSizeCnt;
  public ArrayList<MediaEditReportInfo.EditItem> editList;
  public int seekBarDragCnt;
  
  static
  {
    AppMethodBeat.i(279616);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(279616);
  }
  
  public MediaEditReportInfo()
  {
    AppMethodBeat.i(279611);
    this.editList = new ArrayList();
    AppMethodBeat.o(279611);
  }
  
  protected MediaEditReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(279613);
    this.editList = new ArrayList();
    this.seekBarDragCnt = paramParcel.readInt();
    this.cropSizeCnt = paramParcel.readInt();
    paramParcel.readList(this.editList, MediaEditReportInfo.EditItem.class.getClassLoader());
    AppMethodBeat.o(279613);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(279621);
    paramParcel.writeInt(this.seekBarDragCnt);
    paramParcel.writeInt(this.cropSizeCnt);
    paramParcel.writeList(this.editList);
    AppMethodBeat.o(279621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo
 * JD-Core Version:    0.7.0.1
 */