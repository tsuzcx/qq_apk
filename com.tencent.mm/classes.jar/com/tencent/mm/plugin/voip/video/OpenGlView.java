package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean lUw;
  public boolean zvT;
  public boolean zvU;
  public int zvV;
  private int zvW;
  private int zvX;
  public boolean zvY;
  WeakReference<OpenGlRender> zvZ;
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.zvT = false;
    this.zvU = true;
    this.lUw = false;
    this.zvV = 1;
    this.zvW = 0;
    this.zvX = 0;
    this.zvY = false;
    this.zvV = OpenGlRender.getGLVersion();
    if (this.zvV == 2)
    {
      setEGLContextFactory(new c());
      setEGLConfigChooser(new b());
    }
    AppMethodBeat.o(115670);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void dXl()
  {
    AppMethodBeat.i(115675);
    this.zvT = true;
    this.zuE.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.zvW = paramInt1;
    this.zvX = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (ai.eRQ())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.zvW = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void hW(int paramInt1, int paramInt2) {}
  
  public final void m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    ad.i(TAG, "surfaceCreated");
    super.m(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.zvZ.get();
    ad.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.zvk = true;
    paramSurfaceTexture.zvg = true;
    AppMethodBeat.o(115672);
  }
  
  public final void n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    ad.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.zvZ.get();
    ad.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.zvz != null)
    {
      localOpenGlRender.zvR = true;
      ad.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.dXj();
    }
    localOpenGlRender.zvg = false;
    ad.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.zve = 0;
    localOpenGlRender.zvl = 0;
    localOpenGlRender.zvm = 0;
    if (localOpenGlRender.zvn != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.zvn.get();
      if (localOpenGlView != null)
      {
        ad.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.queueEvent(new OpenGlRender.2(localOpenGlRender));
      }
    }
    super.n(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public final void rV(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.zvY = paramBoolean;
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(115676);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(115676);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.zvZ = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */