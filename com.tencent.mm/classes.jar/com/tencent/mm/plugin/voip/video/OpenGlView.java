package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLTextureView
{
  public static String TAG = "OpenGlView";
  public boolean CFJ;
  public boolean CFK;
  public int CFL;
  private int CFM;
  private int CFN;
  public boolean CFO;
  WeakReference<OpenGlRender> CFP;
  public boolean ncj;
  
  public OpenGlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(210245);
    this.CFJ = false;
    this.CFK = true;
    this.ncj = false;
    this.CFL = 1;
    this.CFM = 0;
    this.CFN = 0;
    this.CFO = false;
    this.CFL = OpenGlRender.getGLVersion();
    eEm();
    AppMethodBeat.o(210245);
  }
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115670);
    this.CFJ = false;
    this.CFK = true;
    this.ncj = false;
    this.CFL = 1;
    this.CFM = 0;
    this.CFN = 0;
    this.CFO = false;
    this.CFL = OpenGlRender.getGLVersion();
    eEm();
    AppMethodBeat.o(115670);
  }
  
  private void eEm()
  {
    AppMethodBeat.i(210246);
    if (this.CFL == 2)
    {
      setEGLContextFactory(new c());
      setEGLConfigChooser(new b());
    }
    AppMethodBeat.o(210246);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115674);
    super.a(paramSurfaceTexture, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115674);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(115675);
    this.CFJ = true;
    this.CEn.requestRender();
    AppMethodBeat.o(115675);
  }
  
  public void iB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115669);
    this.CFM = paramInt1;
    this.CFN = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (al.fBP())
    {
      paramInt1 = paramInt2 * 9 / 16;
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      localLayoutParams.addRule(13);
      this.CFM = paramInt1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(115669);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public void iC(int paramInt1, int paramInt2) {}
  
  public final void m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115672);
    ae.i(TAG, "surfaceCreated");
    super.m(paramSurfaceTexture);
    paramSurfaceTexture = (OpenGlRender)this.CFP.get();
    ae.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceTexture.CES = true;
    paramSurfaceTexture.CEO = true;
    AppMethodBeat.o(115672);
  }
  
  public final void n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115673);
    ae.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.CFP.get();
    ae.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.CFh != null)
    {
      localOpenGlRender.CFG = true;
      ae.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.eEh();
    }
    localOpenGlRender.CEO = false;
    ae.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.CEM = 0;
    localOpenGlRender.CET = 0;
    localOpenGlRender.CEU = 0;
    if (localOpenGlRender.CEV != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.CEV.get();
      if (localOpenGlView != null)
      {
        ae.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
        localOpenGlView.queueEvent(new OpenGlRender.3(localOpenGlRender));
      }
    }
    super.n(paramSurfaceTexture);
    AppMethodBeat.o(115673);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(115671);
    this.CFP = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(115671);
  }
  
  public final void tN(boolean paramBoolean)
  {
    AppMethodBeat.i(115676);
    this.CFO = paramBoolean;
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