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
  public static CaptureDataManager vhw;
  private Bundle joo;
  public b vhv;
  
  static
  {
    AppMethodBeat.i(101494);
    vhw = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.vhv = null;
    this.joo = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.vhv == null) || (paramContext == null))
    {
      AppMethodBeat.o(101491);
      return;
    }
    this.vhv.a(paramContext, paramCaptureVideoNormalModel, this.joo);
    this.joo.clear();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.vhv = paramb;
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(101492);
    if (this.vhv != null)
    {
      boolean bool = this.vhv.a(paramContext, this.joo, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void dhz()
  {
    AppMethodBeat.i(101493);
    this.joo.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.joo;
  }
  
  public static class CaptureVideoNormalModel
    implements Parcelable
  {
    public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
    private List<String> Lnb;
    public String thumbPath;
    private RecordMediaReportInfo vhA;
    public Boolean vhx;
    public Long vhy;
    public Boolean vhz;
    public String videoPath;
    
    static
    {
      AppMethodBeat.i(101489);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(101489);
    }
    
    protected CaptureVideoNormalModel(Parcel paramParcel)
    {
      AppMethodBeat.i(101488);
      this.Lnb = new ArrayList();
      this.vhx = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.videoPath = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.vhy = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.vhz = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhA = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
      this.Lnb = paramParcel.readArrayList(ArrayList.class.getClassLoader());
      AppMethodBeat.o(101488);
    }
    
    public CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
    {
      AppMethodBeat.i(204041);
      this.Lnb = new ArrayList();
      this.vhx = paramBoolean1;
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      this.vhy = paramLong;
      this.vhz = paramBoolean2;
      this.vhA = paramRecordMediaReportInfo;
      AppMethodBeat.o(204041);
    }
    
    public final String anX()
    {
      return this.thumbPath;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final Boolean dhA()
    {
      return this.vhx;
    }
    
    public final Long dhB()
    {
      return this.vhy;
    }
    
    public final Boolean dhC()
    {
      return this.vhz;
    }
    
    public final RecordMediaReportInfo dhD()
    {
      AppMethodBeat.i(101486);
      if (this.vhA == null)
      {
        localRecordMediaReportInfo = new RecordMediaReportInfo();
        AppMethodBeat.o(101486);
        return localRecordMediaReportInfo;
      }
      RecordMediaReportInfo localRecordMediaReportInfo = this.vhA;
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    
    public final List<String> fYa()
    {
      return this.Lnb;
    }
    
    public final String getVideoPath()
    {
      return this.videoPath;
    }
    
    public final void iX(List<String> paramList)
    {
      AppMethodBeat.i(204042);
      if (paramList != null) {
        this.Lnb.addAll(paramList);
      }
      AppMethodBeat.o(204042);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101487);
      paramParcel.writeValue(this.vhx);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeValue(this.vhy);
      paramParcel.writeValue(this.vhz);
      paramParcel.writeParcelable(this.vhA, paramInt);
      paramParcel.writeList(this.Lnb);
      AppMethodBeat.o(101487);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dhE();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */