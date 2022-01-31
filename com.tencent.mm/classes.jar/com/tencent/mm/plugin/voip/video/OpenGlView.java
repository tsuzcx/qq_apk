package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLSurfaceView
{
  private static String TAG = "OpenGlView";
  public boolean jew;
  public boolean tHg;
  public boolean tHh;
  public int tHi;
  private int tHj;
  private int tHk;
  public boolean tHl;
  WeakReference<OpenGlRender> tHm;
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5084);
    this.tHg = false;
    this.tHh = true;
    this.jew = false;
    this.tHi = 1;
    this.tHj = 0;
    this.tHk = 0;
    this.tHl = false;
    this.tHi = OpenGlRender.getGLVersion();
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      if (this.tHi == 2)
      {
        setEGLContextFactory(new c());
        setEGLConfigChooser(new b(5, 6, 5, 0));
      }
      AppMethodBeat.o(5084);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception paramContext)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception paramContext) {}
        }
      }
    }
  }
  
  public final void cPL()
  {
    AppMethodBeat.i(5091);
    this.tHg = true;
    requestRender();
    AppMethodBeat.o(5091);
  }
  
  public void go(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5083);
    setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
    this.tHj = paramInt1;
    this.tHk = paramInt2;
    AppMethodBeat.o(5083);
  }
  
  public void gp(int paramInt1, int paramInt2) {}
  
  public void onPause()
  {
    AppMethodBeat.i(5089);
    super.onPause();
    AppMethodBeat.o(5089);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5090);
    super.onResume();
    AppMethodBeat.o(5090);
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    AppMethodBeat.i(5085);
    this.tHm = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
    AppMethodBeat.o(5085);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5088);
    ab.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(5088);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(5086);
    ab.i(TAG, "surfaceCreated");
    super.surfaceCreated(paramSurfaceHolder);
    paramSurfaceHolder = (OpenGlRender)this.tHm.get();
    ab.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceHolder.hashCode()) });
    OpenGlRender.getGLVersion();
    paramSurfaceHolder.tGB = true;
    paramSurfaceHolder.tGx = true;
    AppMethodBeat.o(5086);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(5087);
    ab.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.tHm.get();
    ab.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", new Object[] { Integer.valueOf(localOpenGlRender.mRenderMode) });
    if (localOpenGlRender.tGQ != null)
    {
      localOpenGlRender.tHe = true;
      ab.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
      localOpenGlRender.cPI();
    }
    localOpenGlRender.tGx = false;
    ab.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.tGv = 0;
    localOpenGlRender.tGC = 0;
    localOpenGlRender.tGD = 0;
    if (localOpenGlRender.tGE != null)
    {
      OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.tGE.get();
      if (localOpenGlView != null) {
        localOpenGlView.queueEvent(new OpenGlRender.2(localOpenGlRender));
      }
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    AppMethodBeat.o(5087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */