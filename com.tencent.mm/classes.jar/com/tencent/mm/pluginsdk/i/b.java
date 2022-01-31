package com.tencent.mm.pluginsdk.i;

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
import com.tencent.mm.compatible.e.u;

public final class b
{
  public Context context;
  private boolean eZZ;
  public int fVF;
  public int fileSize;
  public String filename;
  public MediaRecorder oJm;
  public a qWJ;
  public g vPa;
  public int vPb;
  private final int vPc;
  private b.a vPd;
  
  public b()
  {
    AppMethodBeat.i(27465);
    this.vPb = 0;
    this.vPc = 5;
    this.eZZ = false;
    this.vPd = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(27465);
  }
  
  public final int b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(27467);
    this.context = paramActivity;
    int i = this.vPa.a(paramActivity, this.qWJ, paramBoolean);
    if (i != 0)
    {
      AppMethodBeat.o(27467);
      return i;
    }
    AppMethodBeat.o(27467);
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(27469);
    int i = this.vPa.b(paramSurfaceHolder);
    AppMethodBeat.o(27469);
    return i;
  }
  
  public final int dmH()
  {
    AppMethodBeat.i(27468);
    this.vPa.bQK();
    AppMethodBeat.o(27468);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(27471);
    if (this.vPa.eoH.eqF == null)
    {
      AppMethodBeat.o(27471);
      return 0;
    }
    int i = this.vPa.eoH.eqF.getParameters().getPreviewSize().height;
    AppMethodBeat.o(27471);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(27470);
    if (this.vPa.eoH.eqF == null)
    {
      AppMethodBeat.o(27470);
      return 0;
    }
    int i = this.vPa.eoH.eqF.getParameters().getPreviewSize().width;
    AppMethodBeat.o(27470);
    return i;
  }
  
  @TargetApi(9)
  public final void setOrientationHint(int paramInt)
  {
    AppMethodBeat.i(27466);
    com.tencent.mm.compatible.a.a.a(9, new b.1(this, paramInt));
    AppMethodBeat.o(27466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b
 * JD-Core Version:    0.7.0.1
 */