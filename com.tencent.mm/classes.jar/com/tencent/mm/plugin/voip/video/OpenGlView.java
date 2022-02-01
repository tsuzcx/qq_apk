package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean AOK;
  public boolean AOL;
  public int AOM;
  private int AON;
  private int AOO;
  public boolean AOP;
  WeakReference<OpenGlRender> AOQ;
  public boolean mwy;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(208518);
    this.AOK = false;
    this.AOL = true;
    this.mwy = false;
    this.AOM = 1;
    this.AON = 0;
    this.AOO = 0;
    this.AOP = false;
    this.AOM = OpenGlRender.getGLVersion();
    emG();
    AppMethodBeat.o(208518);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.AOK = false;
    this.AOL = true;
    this.mwy = false;
    this.AOM = 1;
    this.AON = 0;
    this.AOO = 0;
    this.AOP = false;
    this.AOM = OpenGlRender.getGLVersion();
    emG();
    AppMethodBeat.o(115670);
  }
  
  private void emG()
  {
    AppMethodBeat.i(208519);
    if (this.AOM == 2)
    {
      setEGLContextFactory(new c());
      setEGLConfigChooser(new b());
    }
    AppMethodBeat.o(208519);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void emF()
  {
    AppMethodBeat.i(115675);
    this.AOK = true;
    this.ANw.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.AON = paramInt1;
    this.AOO = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (aj.fhA())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.AON = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void il(int paramInt1, int paramInt2) {}
  
  public final void m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    ac.i(TAG, "surfaceCreated");
    super.m(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.AOQ.get();
    ac.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.AOb = true;
    paramSurfaceTexture.ANX = true;
    AppMethodBeat.o(115672);
  }
  
  public final void n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    ac.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.AOQ.get();
    ac.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.AOq != null)
    {
      localOpenGlRender.AOI = true;
      ac.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.emD();
    }
    localOpenGlRender.ANX = false;
    ac.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.ANV = 0;
    localOpenGlRender.AOc = 0;
    localOpenGlRender.AOd = 0;
    if (localOpenGlRender.AOe != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.AOe.get();
      if (localOpenGlView != null)
      {
        ac.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.queueEvent(new OpenGlRender.2(localOpenGlRender));
      }
    }
    super.n(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public final void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.AOP = paramBoolean;
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
    this.AOQ = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */