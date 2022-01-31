package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CaptureDataManager$CaptureVideoNormalModel
  implements Parcelable
{
  public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
  public Boolean qbi;
  public Long qbj;
  public Boolean qbk;
  public RecordMediaReportInfo qbl;
  public String thumbPath;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(141858);
    CREATOR = new CaptureDataManager.CaptureVideoNormalModel.1();
    AppMethodBeat.o(141858);
  }
  
  protected CaptureDataManager$CaptureVideoNormalModel(Parcel paramParcel)
  {
    AppMethodBeat.i(141857);
    this.qbi = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.videoPath = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.qbj = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.qbk = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.qbl = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
    AppMethodBeat.o(141857);
  }
  
  public CaptureDataManager$CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    this.qbi = paramBoolean1;
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    this.qbj = paramLong;
    this.qbk = paramBoolean2;
    this.qbl = paramRecordMediaReportInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(141856);
    paramParcel.writeValue(this.qbi);
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeValue(this.qbj);
    paramParcel.writeValue(this.qbk);
    paramParcel.writeParcelable(this.qbl, paramInt);
    AppMethodBeat.o(141856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel
 * JD-Core Version:    0.7.0.1
 */