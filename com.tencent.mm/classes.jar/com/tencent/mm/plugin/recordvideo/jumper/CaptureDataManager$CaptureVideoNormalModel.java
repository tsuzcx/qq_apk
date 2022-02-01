package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class CaptureDataManager$CaptureVideoNormalModel
  implements Parcelable
{
  public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
  public Boolean NHI;
  public Long NHJ;
  public Boolean NHK;
  private RecordMediaReportInfo NHL;
  public List<String> NHM;
  public String thumbPath;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(101489);
    CREATOR = new CaptureDataManager.CaptureVideoNormalModel.1();
    AppMethodBeat.o(101489);
  }
  
  protected CaptureDataManager$CaptureVideoNormalModel(Parcel paramParcel)
  {
    AppMethodBeat.i(101488);
    this.NHM = new ArrayList();
    this.NHI = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.videoPath = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.NHJ = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.NHK = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.NHL = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
    this.NHM = paramParcel.readArrayList(ArrayList.class.getClassLoader());
    AppMethodBeat.o(101488);
  }
  
  public CaptureDataManager$CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(279610);
    this.NHM = new ArrayList();
    this.NHI = paramBoolean1;
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    this.NHJ = paramLong;
    this.NHK = paramBoolean2;
    this.NHL = paramRecordMediaReportInfo;
    AppMethodBeat.o(279610);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final RecordMediaReportInfo gHE()
  {
    AppMethodBeat.i(101486);
    if (this.NHL == null)
    {
      localRecordMediaReportInfo = new RecordMediaReportInfo();
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    RecordMediaReportInfo localRecordMediaReportInfo = this.NHL;
    AppMethodBeat.o(101486);
    return localRecordMediaReportInfo;
  }
  
  public final void jJ(List<String> paramList)
  {
    AppMethodBeat.i(279617);
    if (paramList != null) {
      this.NHM.addAll(paramList);
    }
    AppMethodBeat.o(279617);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101487);
    paramParcel.writeValue(this.NHI);
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeValue(this.NHJ);
    paramParcel.writeValue(this.NHK);
    paramParcel.writeParcelable(this.NHL, paramInt);
    paramParcel.writeList(this.NHM);
    AppMethodBeat.o(101487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel
 * JD-Core Version:    0.7.0.1
 */