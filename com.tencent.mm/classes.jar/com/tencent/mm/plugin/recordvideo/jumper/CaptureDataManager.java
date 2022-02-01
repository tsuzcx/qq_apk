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
  public static CaptureDataManager wqi;
  private Bundle jOA;
  public b wqh;
  
  static
  {
    AppMethodBeat.i(101494);
    wqi = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.wqh = null;
    this.jOA = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.wqh == null) || (paramContext == null))
    {
      AppMethodBeat.o(101491);
      return;
    }
    this.wqh.a(paramContext, paramCaptureVideoNormalModel, this.jOA);
    this.jOA.clear();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.wqh = paramb;
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(101492);
    if (this.wqh != null)
    {
      boolean bool = this.wqh.a(paramContext, this.jOA, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void dvg()
  {
    AppMethodBeat.i(101493);
    this.jOA.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.jOA;
  }
  
  public static class CaptureVideoNormalModel
    implements Parcelable
  {
    public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
    public String thumbPath;
    public String videoPath;
    public Boolean wqj;
    public Long wqk;
    public Boolean wql;
    private RecordMediaReportInfo wqm;
    private List<String> wqn;
    
    static
    {
      AppMethodBeat.i(101489);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(101489);
    }
    
    protected CaptureVideoNormalModel(Parcel paramParcel)
    {
      AppMethodBeat.i(101488);
      this.wqn = new ArrayList();
      this.wqj = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.videoPath = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.wqk = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.wql = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqm = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
      this.wqn = paramParcel.readArrayList(ArrayList.class.getClassLoader());
      AppMethodBeat.o(101488);
    }
    
    public CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
    {
      AppMethodBeat.i(199484);
      this.wqn = new ArrayList();
      this.wqj = paramBoolean1;
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      this.wqk = paramLong;
      this.wql = paramBoolean2;
      this.wqm = paramRecordMediaReportInfo;
      AppMethodBeat.o(199484);
    }
    
    public final String auN()
    {
      return this.thumbPath;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final Boolean dvh()
    {
      return this.wqj;
    }
    
    public final Long dvi()
    {
      return this.wqk;
    }
    
    public final Boolean dvj()
    {
      return this.wql;
    }
    
    public final RecordMediaReportInfo dvk()
    {
      AppMethodBeat.i(101486);
      if (this.wqm == null)
      {
        localRecordMediaReportInfo = new RecordMediaReportInfo();
        AppMethodBeat.o(101486);
        return localRecordMediaReportInfo;
      }
      RecordMediaReportInfo localRecordMediaReportInfo = this.wqm;
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    
    public final List<String> dvl()
    {
      return this.wqn;
    }
    
    public final void eM(List<String> paramList)
    {
      AppMethodBeat.i(199485);
      if (paramList != null) {
        this.wqn.addAll(paramList);
      }
      AppMethodBeat.o(199485);
    }
    
    public final String getVideoPath()
    {
      return this.videoPath;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101487);
      paramParcel.writeValue(this.wqj);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeValue(this.wqk);
      paramParcel.writeValue(this.wql);
      paramParcel.writeParcelable(this.wqm, paramInt);
      paramParcel.writeList(this.wqn);
      AppMethodBeat.o(101487);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dvm();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */