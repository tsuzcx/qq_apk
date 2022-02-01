package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR;
  public int plW;
  public int qwN;
  public long wqS;
  
  static
  {
    AppMethodBeat.i(101526);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101526);
  }
  
  public VideoCaptureReportInfo()
  {
    this.qwN = -1;
    this.plW = -1;
    this.wqS = -1L;
  }
  
  public VideoCaptureReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101524);
    this.qwN = -1;
    this.plW = -1;
    this.wqS = -1L;
    this.qwN = paramParcel.readInt();
    this.plW = paramParcel.readInt();
    this.wqS = paramParcel.readLong();
    AppMethodBeat.o(101524);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101525);
    paramParcel.writeInt(this.qwN);
    paramParcel.writeInt(this.plW);
    paramParcel.writeLong(this.wqS);
    AppMethodBeat.o(101525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo
 * JD-Core Version:    0.7.0.1
 */