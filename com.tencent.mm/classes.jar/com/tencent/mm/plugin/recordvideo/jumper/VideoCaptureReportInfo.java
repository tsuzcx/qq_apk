package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR;
  public int mhr;
  
  static
  {
    AppMethodBeat.i(156033);
    CREATOR = new VideoCaptureReportInfo.1();
    AppMethodBeat.o(156033);
  }
  
  public VideoCaptureReportInfo()
  {
    this.mhr = -1;
  }
  
  public VideoCaptureReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(156031);
    this.mhr = -1;
    this.mhr = paramParcel.readInt();
    AppMethodBeat.o(156031);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(156032);
    paramParcel.writeInt(this.mhr);
    AppMethodBeat.o(156032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo
 * JD-Core Version:    0.7.0.1
 */