package com.tencent.mm.plugin.recordvideo.jumper;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class CaptureDataManager
{
  public static CaptureDataManager xNV;
  private Bundle kmb;
  public b xNU;
  
  static
  {
    AppMethodBeat.i(101494);
    xNV = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.xNU = null;
    this.kmb = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.xNU == null) || (paramContext == null))
    {
      AppMethodBeat.o(101491);
      return;
    }
    this.xNU.a(paramContext, paramCaptureVideoNormalModel, this.kmb);
    this.kmb.clear();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.xNU = paramb;
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(101492);
    if (this.xNU != null)
    {
      boolean bool = this.xNU.a(paramContext, this.kmb, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void d(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(218355);
    if (this.xNU == null)
    {
      AppMethodBeat.o(218355);
      return;
    }
    this.xNU.a(paramRecordMediaReportInfo, this.kmb);
    AppMethodBeat.o(218355);
  }
  
  public final void dIS()
  {
    AppMethodBeat.i(101493);
    this.kmb.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.kmb;
  }
  
  public static class CaptureVideoNormalModel
    implements Parcelable
  {
    public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
    public String thumbPath;
    public String videoPath;
    public Boolean xNW;
    public Long xNX;
    public Boolean xNY;
    private RecordMediaReportInfo xNZ;
    private List<String> xOa;
    
    static
    {
      AppMethodBeat.i(101489);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(101489);
    }
    
    protected CaptureVideoNormalModel(Parcel paramParcel)
    {
      AppMethodBeat.i(101488);
      this.xOa = new ArrayList();
      this.xNW = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.videoPath = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.xNX = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.xNY = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xNZ = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
      this.xOa = paramParcel.readArrayList(ArrayList.class.getClassLoader());
      AppMethodBeat.o(101488);
    }
    
    public CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
    {
      AppMethodBeat.i(218353);
      this.xOa = new ArrayList();
      this.xNW = paramBoolean1;
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      this.xNX = paramLong;
      this.xNY = paramBoolean2;
      this.xNZ = paramRecordMediaReportInfo;
      AppMethodBeat.o(218353);
    }
    
    public final String axP()
    {
      return this.thumbPath;
    }
    
    public final Boolean dIT()
    {
      return this.xNW;
    }
    
    public final Long dIU()
    {
      return this.xNX;
    }
    
    public final Boolean dIV()
    {
      return this.xNY;
    }
    
    public final RecordMediaReportInfo dIW()
    {
      AppMethodBeat.i(101486);
      if (this.xNZ == null)
      {
        localRecordMediaReportInfo = new RecordMediaReportInfo();
        AppMethodBeat.o(101486);
        return localRecordMediaReportInfo;
      }
      RecordMediaReportInfo localRecordMediaReportInfo = this.xNZ;
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    
    public final List<String> dIX()
    {
      return this.xOa;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void fj(List<String> paramList)
    {
      AppMethodBeat.i(218354);
      if (paramList != null) {
        this.xOa.addAll(paramList);
      }
      AppMethodBeat.o(218354);
    }
    
    public final String getVideoPath()
    {
      return this.videoPath;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101487);
      paramParcel.writeValue(this.xNW);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeValue(this.xNX);
      paramParcel.writeValue(this.xNY);
      paramParcel.writeParcelable(this.xNZ, paramInt);
      paramParcel.writeList(this.xOa);
      AppMethodBeat.o(101487);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dIY();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */