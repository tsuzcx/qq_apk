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
  public a Dqi;
  public g KaF;
  public int KaG;
  private final int KaH;
  private b.a KaI;
  public Context context;
  public int fileSize;
  public String filename;
  public int jqs;
  private boolean ztI;
  public MediaRecorder zwf;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.KaG = 0;
    this.KaH = 5;
    this.ztI = false;
    this.KaI = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31171);
    int i = this.KaF.b(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int d(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.KaF.a(paramActivity, this.Dqi, paramBoolean);
    if (i != 0)
    {
      AppMethodBeat.o(31169);
      return i;
    }
    AppMethodBeat.o(31169);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.KaF.gGr.gII == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.KaF.gGr.gII.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.KaF.gGr.gII == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.KaF.gGr.gII.getParameters().getPreviewSize().width;
    AppMethodBeat.o(31172);
    return i;
  }
  
  public final int goi()
  {
    AppMethodBeat.i(31170);
    this.KaF.ejx();
    AppMethodBeat.o(31170);
    return 0;
  }
  
  @TargetApi(9)
  public void setOrientationHint(final int paramInt)
  {
    AppMethodBeat.i(31168);
    com.tencent.mm.compatible.a.a.a(9, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(31165);
        if (b.this.zwf != null) {
          b.this.zwf.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.b
 * JD-Core Version:    0.7.0.1
 */