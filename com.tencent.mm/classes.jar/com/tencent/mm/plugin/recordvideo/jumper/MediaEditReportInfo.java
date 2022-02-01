package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@Keep
public class MediaEditReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaEditReportInfo> CREATOR;
  public int cropSizeCnt;
  public ArrayList<EditItem> editList;
  public int seekBarDragCnt;
  
  static
  {
    AppMethodBeat.i(191631);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191631);
  }
  
  public MediaEditReportInfo()
  {
    AppMethodBeat.i(191625);
    this.editList = new ArrayList();
    AppMethodBeat.o(191625);
  }
  
  protected MediaEditReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(191627);
    this.editList = new ArrayList();
    this.seekBarDragCnt = paramParcel.readInt();
    this.cropSizeCnt = paramParcel.readInt();
    paramParcel.readList(this.editList, EditItem.class.getClassLoader());
    AppMethodBeat.o(191627);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(191628);
    paramParcel.writeInt(this.seekBarDragCnt);
    paramParcel.writeInt(this.cropSizeCnt);
    paramParcel.writeList(this.editList);
    AppMethodBeat.o(191628);
  }
  
  @Keep
  public static class EditItem
    implements Parcelable
  {
    public static final Parcelable.Creator<EditItem> CREATOR;
    public int clickEditCount;
    public int dragCount;
    public int durationCutCount;
    public int durationScrollCount;
    public boolean isBeauty;
    public long originDuration;
    public int scaleCount;
    public long targetDuration;
    public int type;
    
    static
    {
      AppMethodBeat.i(191620);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(191620);
    }
    
    public EditItem() {}
    
    protected EditItem(Parcel paramParcel)
    {
      AppMethodBeat.i(191612);
      this.type = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isBeauty = bool;
        this.originDuration = paramParcel.readLong();
        this.targetDuration = paramParcel.readLong();
        this.clickEditCount = paramParcel.readInt();
        this.durationCutCount = paramParcel.readInt();
        this.durationScrollCount = paramParcel.readInt();
        this.dragCount = paramParcel.readInt();
        this.scaleCount = paramParcel.readInt();
        AppMethodBeat.o(191612);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(191617);
      paramParcel.writeInt(this.type);
      if (this.isBeauty) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeLong(this.originDuration);
        paramParcel.writeLong(this.targetDuration);
        paramParcel.writeInt(this.clickEditCount);
        paramParcel.writeInt(this.durationCutCount);
        paramParcel.writeInt(this.durationScrollCount);
        paramParcel.writeInt(this.dragCount);
        paramParcel.writeInt(this.scaleCount);
        AppMethodBeat.o(191617);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo
 * JD-Core Version:    0.7.0.1
 */