package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MediaEditReportInfo$EditItem
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
    AppMethodBeat.i(199490);
    CREATOR = new MediaEditReportInfo.EditItem.1();
    AppMethodBeat.o(199490);
  }
  
  public MediaEditReportInfo$EditItem() {}
  
  protected MediaEditReportInfo$EditItem(Parcel paramParcel)
  {
    AppMethodBeat.i(199488);
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
      AppMethodBeat.o(199488);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(199489);
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
      AppMethodBeat.o(199489);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem
 * JD-Core Version:    0.7.0.1
 */