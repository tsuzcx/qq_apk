package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CaptureDataManager
{
  public static CaptureDataManager BOb;
  public b BOa;
  private Bundle lpM;
  
  static
  {
    AppMethodBeat.i(101494);
    BOb = new CaptureDataManager();
    AppMethodBeat.o(101494);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(101490);
    this.BOa = null;
    this.lpM = new Bundle();
    AppMethodBeat.o(101490);
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(101491);
    if ((this.BOa != null) && (paramContext != null))
    {
      this.BOa.a(paramContext, paramCaptureVideoNormalModel, this.lpM);
      this.lpM.clear();
      AppMethodBeat.o(101491);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", this.lpM);
    localIntent.putExtra("KSEGMENTMEDIAINFO", paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(101491);
  }
  
  public final void a(b paramb)
  {
    this.BOa = paramb;
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(101492);
    if (this.BOa != null)
    {
      boolean bool = this.BOa.a(paramContext, this.lpM, parama);
      AppMethodBeat.o(101492);
      return bool;
    }
    AppMethodBeat.o(101492);
    return false;
  }
  
  public final void d(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(207038);
    if (this.BOa == null)
    {
      AppMethodBeat.o(207038);
      return;
    }
    this.BOa.a(paramRecordMediaReportInfo, this.lpM);
    AppMethodBeat.o(207038);
  }
  
  public final void eJF()
  {
    AppMethodBeat.i(101493);
    this.lpM.clear();
    AppMethodBeat.o(101493);
  }
  
  public final Bundle getExtData()
  {
    return this.lpM;
  }
  
  public static abstract interface a
  {
    public abstract void eJL();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle);
    
    public abstract void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */