package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(279615);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(279615);
  }
  
  public MediaEditReportInfo$EditItem() {}
  
  protected MediaEditReportInfo$EditItem(Parcel paramParcel)
  {
    AppMethodBeat.i(279612);
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
      AppMethodBeat.o(279612);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(279620);
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
      AppMethodBeat.o(279620);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem
 * JD-Core Version:    0.7.0.1
 */