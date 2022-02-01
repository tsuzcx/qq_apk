package com.tencent.mm.pluginsdk.l;

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
  public g ERs;
  public int ERt;
  private final int ERu;
  private b.a ERv;
  public Context context;
  public int fileSize;
  public String filename;
  private boolean hpv;
  public int ism;
  public MediaRecorder vPZ;
  public a yVh;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.ERt = 0;
    this.ERu = 5;
    this.hpv = false;
    this.ERv = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public final int b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.ERs.a(paramActivity, this.yVh, paramBoolean);
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
    int i = this.ERs.b(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int fbk()
  {
    AppMethodBeat.i(31170);
    this.ERs.dmK();
    AppMethodBeat.o(31170);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.ERs.fYS.gbc == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.ERs.fYS.gbc.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.ERs.fYS.gbc == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.ERs.fYS.gbc.getParameters().getPreviewSize().width;
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
        if (b.this.vPZ != null) {
          b.this.vPZ.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.b
 * JD-Core Version:    0.7.0.1
 */