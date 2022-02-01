package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean Cof;
  public boolean Cog;
  public int Coh;
  private int Coi;
  private int Coj;
  public boolean Cok;
  WeakReference<OpenGlRender> Col;
  public boolean mXd;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216566);
    this.Cof = false;
    this.Cog = true;
    this.mXd = false;
    this.Coh = 1;
    this.Coi = 0;
    this.Coj = 0;
    this.Cok = false;
    this.Coh = OpenGlRender.getGLVersion();
    eAE();
    AppMethodBeat.o(216566);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.Cof = false;
    this.Cog = true;
    this.mXd = false;
    this.Coh = 1;
    this.Coi = 0;
    this.Coj = 0;
    this.Cok = false;
    this.Coh = OpenGlRender.getGLVersion();
    eAE();
    AppMethodBeat.o(115670);
  }
  
  private void eAE()
  {
    AppMethodBeat.i(216567);
    if (this.Coh == 2)
    {
      setEGLContextFactory(new c());
      setEGLConfigChooser(new b());
    }
    AppMethodBeat.o(216567);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void eAD()
  {
    AppMethodBeat.i(115675);
    this.Cof = true;
    this.CmJ.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.Coi = paramInt1;
    this.Coj = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (al.fxN())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.Coi = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void iy(int paramInt1, int paramInt2) {}
  
  public final void m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    ad.i(TAG, "surfaceCreated");
    super.m(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.Col.get();
    ad.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.Cno = true;
    paramSurfaceTexture.Cnk = true;
    AppMethodBeat.o(115672);
  }
  
  public final void n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    ad.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.Col.get();
    ad.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.CnD != null)
    {
      localOpenGlRender.Coc = true;
      ad.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.eAz();
    }
    localOpenGlRender.Cnk = false;
    ad.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.Cni = 0;
    localOpenGlRender.Cnp = 0;
    localOpenGlRender.Cnq = 0;
    if (localOpenGlRender.Cnr != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.Cnr.get();
      if (localOpenGlView != null)
      {
        ad.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.queueEvent(new OpenGlRender.3(localOpenGlRender));
      }
    }
    super.n(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.Col = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
  
  public final void tG(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.Cok = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */