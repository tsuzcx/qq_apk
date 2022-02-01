package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR;
  public long NIs;
  public int xYX;
  public int ybL;
  
  static
  {
    AppMethodBeat.i(101526);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101526);
  }
  
  public VideoCaptureReportInfo()
  {
    this.ybL = -1;
    this.xYX = -1;
    this.NIs = -1L;
  }
  
  public VideoCaptureReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101524);
    this.ybL = -1;
    this.xYX = -1;
    this.NIs = -1L;
    this.ybL = paramParcel.readInt();
    this.xYX = paramParcel.readInt();
    this.NIs = paramParcel.readLong();
    AppMethodBeat.o(101524);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101525);
    paramParcel.writeInt(this.ybL);
    paramParcel.writeInt(this.xYX);
    paramParcel.writeLong(this.NIs);
    AppMethodBeat.o(101525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo
 * JD-Core Version:    0.7.0.1
 */