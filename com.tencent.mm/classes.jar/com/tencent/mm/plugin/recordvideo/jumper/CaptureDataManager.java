package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class CaptureDataManager
{
  public static CaptureDataManager HKJ;
  public b HKI;
  private Bundle okw;
  
  static
  {
    AppMethodBeat.i(101494);
    HKJ = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.HKI = null;
    this.okw = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.HKI != null) && (paramContext != null))
    {
      this.HKI.a(paramContext, paramCaptureVideoNormalModel, this.okw);
      this.okw.clear();
      AppMethodBeat.o(101491);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", this.okw);
    localIntent.putExtra("KSEGMENTMEDIAINFO", paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.HKI = paramb;
  }
  
  public final boolean a(Context paramContext, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(101492);
    if (this.HKI != null)
    {
      boolean bool = this.HKI.a(paramContext, this.okw, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void d(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(191427);
    if (this.HKI == null)
    {
      AppMethodBeat.o(191427);
      return;
    }
    this.HKI.a(paramRecordMediaReportInfo, this.okw);
    AppMethodBeat.o(191427);
  }
  
  public final b fvP()
  {
    return this.HKI;
  }
  
  public final void fvQ()
  {
    AppMethodBeat.i(101493);
    this.okw.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.okw;
  }
  
  public static class CaptureVideoNormalModel
    implements Parcelable
  {
    public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR;
    public Boolean HKK;
    public Long HKL;
    public Boolean HKM;
    private RecordMediaReportInfo HKN;
    private List<String> HKO;
    public String thumbPath;
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
      this.HKO = new ArrayList();
      this.HKK = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.videoPath = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.HKL = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.HKM = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HKN = ((RecordMediaReportInfo)paramParcel.readParcelable(RecordMediaReportInfo.class.getClassLoader()));
      this.HKO = paramParcel.readArrayList(ArrayList.class.getClassLoader());
      AppMethodBeat.o(101488);
    }
    
    public CaptureVideoNormalModel(Boolean paramBoolean1, String paramString1, String paramString2, Long paramLong, Boolean paramBoolean2, RecordMediaReportInfo paramRecordMediaReportInfo)
    {
      AppMethodBeat.i(191408);
      this.HKO = new ArrayList();
      this.HKK = paramBoolean1;
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      this.HKL = paramLong;
      this.HKM = paramBoolean2;
      this.HKN = paramRecordMediaReportInfo;
      AppMethodBeat.o(191408);
    }
    
    public final String aZe()
    {
      return this.thumbPath;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final Boolean fvR()
    {
      return this.HKK;
    }
    
    public final Long fvS()
    {
      return this.HKL;
    }
    
    public final Boolean fvT()
    {
      return this.HKM;
    }
    
    public final RecordMediaReportInfo fvU()
    {
      AppMethodBeat.i(101486);
      if (this.HKN == null)
      {
        localRecordMediaReportInfo = new RecordMediaReportInfo();
        AppMethodBeat.o(101486);
        return localRecordMediaReportInfo;
      }
      RecordMediaReportInfo localRecordMediaReportInfo = this.HKN;
      AppMethodBeat.o(101486);
      return localRecordMediaReportInfo;
    }
    
    public final List<String> fvV()
    {
      return this.HKO;
    }
    
    public final void gJ(List<String> paramList)
    {
      AppMethodBeat.i(191417);
      if (paramList != null) {
        this.HKO.addAll(paramList);
      }
      AppMethodBeat.o(191417);
    }
    
    public final String getVideoPath()
    {
      return this.videoPath;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101487);
      paramParcel.writeValue(this.HKK);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeValue(this.HKL);
      paramParcel.writeValue(this.HKM);
      paramParcel.writeParcelable(this.HKN, paramInt);
      paramParcel.writeList(this.HKO);
      AppMethodBeat.o(101487);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */