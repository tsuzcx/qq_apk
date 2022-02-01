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
  public static CaptureDataManager xxY;
  private Bundle kiL;
  public b xxX;
  
  static
  {
    AppMethodBeat.i(101494);
    xxY = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.xxX = null;
    this.kiL = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.xxX == null) || (paramContext == null))
    {
      AppMethodBeat.o(101491);
      return;
    }
    this.xxX.a(paramContext, paramCaptureVideoNormalModel, this.kiL);
    this.kiL.clear();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.xxX = paramb;
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(101492);
    if (this.xxX != null)
    {
      boolean bool = this.xxX.a(paramContext, this.kiL, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void d(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(209008);
    if (this.xxX == null)
    {
      AppMethodBeat.o(209008);
      return;
    }
    this.xxX.a(paramRecordMediaReportInfo, this.kiL);
    AppMethodBeat.o(209008);
  }
  
  public final void dFB()
  {
    AppMethodBeat.i(101493);
    this.kiL.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.kiL;
  }
  
  public static class CaptureVideoNormalModel
    implements Parcelable
  {
    public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
    public String thumbPath;
    public String videoPath;
    public Boolean xxZ;
    public Long xya;
    public Boolean xyb;
    private RecordMediaReportInfo xyc;
    private List<String> xyd;
    
    static
    {
      AppMethodBeat.i(101489);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(101489);
    }
    
    protected CaptureVideoNormalModel(Parcel paramParcel)
    {
      AppMethodBeat.i(101488);
      this.xyd = new ArrayList();
      this.xxZ = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.videoPath = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.xya = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.xyb = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyc = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
      this.xyd = paramParcel.readArrayList(ArrayList.class.getClassLoader());
      AppMethodBeat.o(101488);
    }
    
    public CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
    {
      AppMethodBeat.i(209006);
      this.xyd = new ArrayList();
      this.xxZ = paramBoolean1;
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      this.xya = paramLong;
      this.xyb = paramBoolean2;
      this.xyc = paramRecordMediaReportInfo;
      AppMethodBeat.o(209006);
    }
    
    public final String axA()
    {
      return this.thumbPath;
    }
    
    public final Boolean dFC()
    {
      return this.xxZ;
    }
    
    public final Long dFD()
    {
      return this.xya;
    }
    
    public final Boolean dFE()
    {
      return this.xyb;
    }
    
    public final RecordMediaReportInfo dFF()
    {
      AppMethodBeat.i(101486);
      if (this.xyc == null)
      {
        localRecordMediaReportInfo = new RecordMediaReportInfo();
        AppMethodBeat.o(101486);
        return localRecordMediaReportInfo;
      }
      RecordMediaReportInfo localRecordMediaReportInfo = this.xyc;
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    
    public final List<String> dFG()
    {
      return this.xyd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void fb(List<String> paramList)
    {
      AppMethodBeat.i(209007);
      if (paramList != null) {
        this.xyd.addAll(paramList);
      }
      AppMethodBeat.o(209007);
    }
    
    public final String getVideoPath()
    {
      return this.videoPath;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101487);
      paramParcel.writeValue(this.xxZ);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeValue(this.xya);
      paramParcel.writeValue(this.xyb);
      paramParcel.writeParcelable(this.xyc, paramInt);
      paramParcel.writeList(this.xyd);
      AppMethodBeat.o(101487);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dFH();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */