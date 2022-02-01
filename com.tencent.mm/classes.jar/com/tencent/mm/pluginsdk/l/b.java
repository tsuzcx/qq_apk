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
  public g FjN;
  public int FjO;
  private final int FjP;
  private b.a FjQ;
  public Context context;
  public int fileSize;
  public String filename;
  private boolean hsj;
  public int ivg;
  public MediaRecorder wcd;
  public a zlr;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.FjO = 0;
    this.FjP = 5;
    this.hsj = false;
    this.FjQ = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public final int b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.FjN.a(paramActivity, this.zlr, paramBoolean);
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
    int i = this.FjN.b(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int feY()
  {
    AppMethodBeat.i(31170);
    this.FjN.dpI();
    AppMethodBeat.o(31170);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.FjN.gaZ.gdk == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.FjN.gaZ.gdk.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.FjN.gaZ.gdk == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.FjN.gaZ.gdk.getParameters().getPreviewSize().width;
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
        if (b.this.wcd != null) {
          b.this.wcd.setOrientationHint(paramInt);
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