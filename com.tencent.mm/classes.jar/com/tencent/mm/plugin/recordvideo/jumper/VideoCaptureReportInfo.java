package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR;
  public int oIw;
  public int pOf;
  public long vii;
  
  static
  {
    AppMethodBeat.i(101526);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101526);
  }
  
  public VideoCaptureReportInfo()
  {
    this.pOf = -1;
    this.oIw = -1;
    this.vii = -1L;
  }
  
  public VideoCaptureReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101524);
    this.pOf = -1;
    this.oIw = -1;
    this.vii = -1L;
    this.pOf = paramParcel.readInt();
    this.oIw = paramParcel.readInt();
    this.vii = paramParcel.readLong();
    AppMethodBeat.o(101524);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101525);
    paramParcel.writeInt(this.pOf);
    paramParcel.writeInt(this.oIw);
    paramParcel.writeLong(this.vii);
    AppMethodBeat.o(101525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo
 * JD-Core Version:    0.7.0.1
 */