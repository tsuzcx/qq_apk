package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR;
  public int pPw;
  public int rgD;
  public long xyJ;
  
  static
  {
    AppMethodBeat.i(101526);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101526);
  }
  
  public VideoCaptureReportInfo()
  {
    this.rgD = -1;
    this.pPw = -1;
    this.xyJ = -1L;
  }
  
  public VideoCaptureReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101524);
    this.rgD = -1;
    this.pPw = -1;
    this.xyJ = -1L;
    this.rgD = paramParcel.readInt();
    this.pPw = paramParcel.readInt();
    this.xyJ = paramParcel.readLong();
    AppMethodBeat.o(101524);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101525);
    paramParcel.writeInt(this.rgD);
    paramParcel.writeInt(this.pPw);
    paramParcel.writeLong(this.xyJ);
    AppMethodBeat.o(101525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo
 * JD-Core Version:    0.7.0.1
 */