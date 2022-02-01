package com.tencent.mm.pluginsdk.l;

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
import com.tencent.mm.compatible.deviceinfo.w;

public final class b
{
  private boolean KUV;
  public MediaRecorder KXn;
  public a PJl;
  public g XXo;
  public int XXp;
  private final int XXq;
  private b.a XXr;
  public Context context;
  public int fileSize;
  public String filename;
  public int oYP;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.XXp = 0;
    this.XXq = 5;
    this.KUV = false;
    this.XXr = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public void awe(final int paramInt)
  {
    AppMethodBeat.i(31168);
    com.tencent.mm.compatible.a.a.a(9, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(31165);
        if (b.this.KXn != null) {
          b.this.KXn.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
  
  public final int e(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31171);
    int i = this.XXo.e(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int f(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.XXo.a(paramActivity, this.PJl, paramBoolean);
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
    if (this.XXo.lTN.lWs == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.XXo.lTN.lWs.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.XXo.lTN.lWs == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.XXo.lTN.lWs.getParameters().getPreviewSize().width;
    AppMethodBeat.o(31172);
    return i;
  }
  
  public final int iJS()
  {
    AppMethodBeat.i(31170);
    this.XXo.gbX();
    AppMethodBeat.o(31170);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.b
 * JD-Core Version:    0.7.0.1
 */