package com.tencent.mm.plugin.recordvideo.jumper;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CaptureDataManager
{
  public static CaptureDataManager qbh;
  private Bundle hrf;
  public CaptureDataManager.b qbg;
  
  static
  {
    AppMethodBeat.i(141866);
    qbh = new CaptureDataManager();
    AppMethodBeat.o(141866);
  }
  
  private CaptureDataManager()
  {
    AppMethodBeat.i(141863);
    this.qbg = null;
    this.hrf = new Bundle();
    AppMethodBeat.o(141863);
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(141864);
    if (this.qbg == null)
    {
      AppMethodBeat.o(141864);
      return;
    }
    this.qbg.a(paramContext, paramCaptureVideoNormalModel, this.hrf);
    AppMethodBeat.o(141864);
  }
  
  public final void a(CaptureDataManager.b paramb)
  {
    this.qbg = paramb;
  }
  
  public final boolean a(Context paramContext, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(141865);
    if (this.qbg != null)
    {
      boolean bool = this.qbg.a(paramContext, this.hrf, parama);
      AppMethodBeat.o(141865);
      return bool;
    }
    AppMethodBeat.o(141865);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager
 * JD-Core Version:    0.7.0.1
 */