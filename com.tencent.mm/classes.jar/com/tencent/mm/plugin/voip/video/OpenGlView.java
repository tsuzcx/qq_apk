package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean Flq;
  public boolean UNI;
  public boolean UNJ;
  public int UNK;
  public int UNL;
  public int UNM;
  public boolean UNN;
  WeakReference<OpenGlRender> UNO;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(292903);
    this.UNI = false;
    this.UNJ = true;
    this.Flq = false;
    this.UNK = 1;
    this.UNL = 0;
    this.UNM = 0;
    this.UNN = false;
    this.UNK = OpenGlRender.getGLVersion();
    icq();
    AppMethodBeat.o(292903);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.UNI = false;
    this.UNJ = true;
    this.Flq = false;
    this.UNK = 1;
    this.UNL = 0;
    this.UNM = 0;
    this.UNN = false;
    this.UNK = OpenGlRender.getGLVersion();
    icq();
    AppMethodBeat.o(115670);
  }
  
  private void icq()
  {
    AppMethodBeat.i(292914);
    if (this.UNK == 2)
    {
      setEGLContextFactory(new b());
      setEGLConfigChooser(new a());
    }
    AppMethodBeat.o(292914);
  }
  
  public final void GR(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.UNN = paramBoolean;
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(115676);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(115676);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void icp()
  {
    AppMethodBeat.i(115675);
    this.UNI = true;
    requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void mH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.UNL = paramInt1;
    this.UNM = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (aw.jkQ())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.UNL = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void mI(int paramInt1, int paramInt2) {}
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.UNO = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
  
  public final void t(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    Log.i(TAG, "surfaceCreated");
    super.t(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.UNO.get();
    Log.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.UMQ = true;
    paramSurfaceTexture.UMM = true;
    AppMethodBeat.o(115672);
  }
  
  public final void u(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    Log.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.UNO.get();
    Log.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.UNg != null)
    {
      localOpenGlRender.UNF = true;
      Log.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.icl();
    }
    localOpenGlRender.UMM = false;
    Log.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.UMK = 0;
    localOpenGlRender.UMR = 0;
    localOpenGlRender.UMS = 0;
    if (localOpenGlRender.UMT != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.UMT.get();
      if (localOpenGlView != null)
      {
        Log.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.ag(new OpenGlRender.4(localOpenGlRender));
      }
    }
    super.u(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */