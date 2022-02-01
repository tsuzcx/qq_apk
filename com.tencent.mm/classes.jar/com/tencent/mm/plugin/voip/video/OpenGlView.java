package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean HiX;
  public boolean HiY;
  public int HiZ;
  public int Hja;
  public int Hjb;
  public boolean Hjc;
  WeakReference<OpenGlRender> Hjd;
  public boolean onr;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(235832);
    this.HiX = false;
    this.HiY = true;
    this.onr = false;
    this.HiZ = 1;
    this.Hja = 0;
    this.Hjb = 0;
    this.Hjc = false;
    this.HiZ = OpenGlRender.getGLVersion();
    fKU();
    AppMethodBeat.o(235832);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.HiX = false;
    this.HiY = true;
    this.onr = false;
    this.HiZ = 1;
    this.Hja = 0;
    this.Hjb = 0;
    this.Hjc = false;
    this.HiZ = OpenGlRender.getGLVersion();
    fKU();
    AppMethodBeat.o(115670);
  }
  
  private void fKU()
  {
    AppMethodBeat.i(235833);
    if (this.HiZ == 2)
    {
      setEGLContextFactory(new b());
      setEGLConfigChooser(new a());
    }
    AppMethodBeat.o(235833);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void fKT()
  {
    AppMethodBeat.i(115675);
    this.HiX = true;
    this.HhI.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.Hja = paramInt1;
    this.Hjb = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (ao.gJI())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.Hja = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void jH(int paramInt1, int paramInt2) {}
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    Log.i(TAG, "surfaceCreated");
    super.o(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.Hjd.get();
    Log.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.Hie = true;
    paramSurfaceTexture.Hia = true;
    AppMethodBeat.o(115672);
  }
  
  public final void p(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    Log.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.Hjd.get();
    Log.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.Hiu != null)
    {
      localOpenGlRender.HiU = true;
      Log.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.fKP();
    }
    localOpenGlRender.Hia = false;
    Log.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.HhY = 0;
    localOpenGlRender.Hif = 0;
    localOpenGlRender.Hig = 0;
    if (localOpenGlRender.Hih != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.Hih.get();
      if (localOpenGlView != null)
      {
        Log.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.queueEvent(new OpenGlRender.4(localOpenGlRender));
      }
    }
    super.p(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.Hjd = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
  
  public final void xv(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.Hjc = paramBoolean;
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(115676);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(115676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */