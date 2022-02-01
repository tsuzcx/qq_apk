package com.tencent.mm.pluginsdk.j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.v;

public final class b
{
  public g Dmq;
  public int Dmr;
  private final int Dms;
  private b.a Dmt;
  public Context context;
  public int fileSize;
  public String filename;
  private boolean gXp;
  public int hYQ;
  public MediaRecorder uMS;
  public a xGx;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.Dmr = 0;
    this.Dms = 5;
    this.gXp = false;
    this.Dmt = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public final int b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.Dmq.a(paramActivity, this.xGx, paramBoolean);
    if (i != 0)
    {
      AppMethodBeat.o(31169);
      return i;
    }
    AppMethodBeat.o(31169);
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31171);
    int i = this.Dmq.b(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int eMn()
  {
    AppMethodBeat.i(31170);
    this.Dmq.ddo();
    AppMethodBeat.o(31170);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.Dmq.fFt.fHC == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.Dmq.fFt.fHC.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.Dmq.fFt.fHC == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.Dmq.fFt.fHC.getParameters().getPreviewSize().width;
    AppMethodBeat.o(31172);
    return i;
  }
  
  @TargetApi(9)
  public final void setOrientationHint(final int paramInt)
  {
    AppMethodBeat.i(31168);
    com.tencent.mm.compatible.a.a.a(9, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(31165);
        if (b.this.uMS != null) {
          b.this.uMS.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.b
 * JD-Core Version:    0.7.0.1
 */