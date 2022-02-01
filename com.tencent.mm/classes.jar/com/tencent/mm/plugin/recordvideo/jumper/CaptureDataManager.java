package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;

public final class CaptureDataManager
{
  public static CaptureDataManager NHH;
  public b NHG;
  public Bundle rnY;
  
  static
  {
    AppMethodBeat.i(101494);
    NHH = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.NHG = null;
    this.rnY = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, int paramInt, MediaResultInfo paramMediaResultInfo)
  {
    AppMethodBeat.i(279618);
    Intent localIntent = new Intent();
    localIntent.putExtra("media_basic_extra_bundle", this.rnY);
    localIntent.putExtra("media_basic_out_model", paramMediaResultInfo);
    ((Activity)paramContext).setResult(paramInt, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(279618);
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.NHG != null) && (paramContext != null))
    {
      this.NHG.a(paramContext, paramCaptureVideoNormalModel, this.rnY);
      this.rnY.clear();
      AppMethodBeat.o(101491);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", this.rnY);
    localIntent.putExtra("KSEGMENTMEDIAINFO", paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(101491);
  }
  
  public final boolean a(Context paramContext, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(101492);
    if (this.NHG != null)
    {
      boolean bool = this.NHG.a(paramContext, this.rnY, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void d(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(279625);
    if (this.NHG == null)
    {
      AppMethodBeat.o(279625);
      return;
    }
    this.NHG.a(paramRecordMediaReportInfo, this.rnY);
    AppMethodBeat.o(279625);
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
  
  public static class c
    implements CaptureDataManager.b
  {
    public void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle) {}
    
    public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
    
    public boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */