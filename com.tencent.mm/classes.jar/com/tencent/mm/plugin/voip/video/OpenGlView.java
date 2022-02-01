package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean AJP;
  public boolean NZL;
  public boolean NZM;
  public int NZN;
  public int NZO;
  public int NZP;
  public boolean NZQ;
  WeakReference<OpenGlRender> NZR;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(242018);
    this.NZL = false;
    this.NZM = true;
    this.AJP = false;
    this.NZN = 1;
    this.NZO = 0;
    this.NZP = 0;
    this.NZQ = false;
    this.NZN = OpenGlRender.getGLVersion();
    gDu();
    AppMethodBeat.o(242018);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.NZL = false;
    this.NZM = true;
    this.AJP = false;
    this.NZN = 1;
    this.NZO = 0;
    this.NZP = 0;
    this.NZQ = false;
    this.NZN = OpenGlRender.getGLVersion();
    gDu();
    AppMethodBeat.o(115670);
  }
  
  private void gDu()
  {
    AppMethodBeat.i(242020);
    if (this.NZN == 2)
    {
      setEGLContextFactory(new b());
      setEGLConfigChooser(new a());
    }
    AppMethodBeat.o(242020);
  }
  
  public final void Bn(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.NZQ = paramBoolean;
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
  
  public final void gDt()
  {
    AppMethodBeat.i(115675);
    this.NZL = true;
    this.NYx.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.NZO = paramInt1;
    this.NZP = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (ar.hIF())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.NZO = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void kW(int paramInt1, int paramInt2) {}
  
  public final void r(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    Log.i(TAG, "surfaceCreated");
    super.r(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.NZR.get();
    Log.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.NYT = true;
    paramSurfaceTexture.NYP = true;
    AppMethodBeat.o(115672);
  }
  
  public final void s(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    Log.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.NZR.get();
    Log.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.NZj != null)
    {
      localOpenGlRender.NZI = true;
      Log.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.gDp();
    }
    localOpenGlRender.NYP = false;
    Log.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.NYN = 0;
    localOpenGlRender.NYU = 0;
    localOpenGlRender.NYV = 0;
    if (localOpenGlRender.NYW != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.NYW.get();
      if (localOpenGlView != null)
      {
        Log.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.aa(new OpenGlRender.4(localOpenGlRender));
      }
    }
    super.s(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.NZR = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */