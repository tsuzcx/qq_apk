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
  public Boolean BOc;
  public Long BOd;
  public Boolean BOe;
  private RecordMediaReportInfo BOf;
  private List<String> BOg;
  public String thumbPath;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(101489);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101489);
  }
  
  protected CaptureDataManager$CaptureVideoNormalModel(Parcel paramParcel)
  {
    AppMethodBeat.i(101488);
    this.BOg = new ArrayList();
    this.BOc = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.videoPath = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.BOd = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.BOe = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.BOf = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
    this.BOg = paramParcel.readArrayList(ArrayList.class.getClassLoader());
    AppMethodBeat.o(101488);
  }
  
  public CaptureDataManager$CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(207036);
    this.BOg = new ArrayList();
    this.BOc = paramBoolean1;
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    this.BOd = paramLong;
    this.BOe = paramBoolean2;
    this.BOf = paramRecordMediaReportInfo;
    AppMethodBeat.o(207036);
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Boolean eJG()
  {
    return this.BOc;
  }
  
  public final Long eJH()
  {
    return this.BOd;
  }
  
  public final Boolean eJI()
  {
    return this.BOe;
  }
  
  public final RecordMediaReportInfo eJJ()
  {
    AppMethodBeat.i(101486);
    if (this.BOf == null)
    {
      localRecordMediaReportInfo = new RecordMediaReportInfo();
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    RecordMediaReportInfo localRecordMediaReportInfo = this.BOf;
    AppMethodBeat.o(101486);
    return localRecordMediaReportInfo;
  }
  
  public final List<String> eJK()
  {
    return this.BOg;
  }
  
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final void gf(List<String> paramList)
  {
    AppMethodBeat.i(207037);
    if (paramList != null) {
      this.BOg.addAll(paramList);
    }
    AppMethodBeat.o(207037);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101487);
    paramParcel.writeValue(this.BOc);
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeValue(this.BOd);
    paramParcel.writeValue(this.BOe);
    paramParcel.writeParcelable(this.BOf, paramInt);
    paramParcel.writeList(this.BOg);
    AppMethodBeat.o(101487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel
 * JD-Core Version:    0.7.0.1
 */