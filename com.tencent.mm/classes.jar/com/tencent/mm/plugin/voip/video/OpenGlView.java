package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class OpenGlView
  extends GLSurfaceView
{
  private static String TAG = "OpenGlView";
  public boolean hqp = false;
  WeakReference<OpenGlRender> qbA;
  public boolean qbw = false;
  public boolean qbx = true;
  public int qby = 1;
  public boolean qbz = false;
  
  public OpenGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      if (this.qby == 2)
      {
        setEGLContextFactory(new c());
        setEGLConfigChooser(new b(5, 6, 5, 0));
      }
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
  
  public void ep(int paramInt1, int paramInt2)
  {
    setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  public void eq(int paramInt1, int paramInt2) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void setRenderer(OpenGlRender paramOpenGlRender)
  {
    this.qbA = new WeakReference(paramOpenGlRender);
    super.setRenderer(paramOpenGlRender);
    setRenderMode(0);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    y.i(TAG, "surfaceCreated");
    super.surfaceCreated(paramSurfaceHolder);
    paramSurfaceHolder = (OpenGlRender)this.qbA.get();
    y.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[] { Integer.valueOf(paramSurfaceHolder.hashCode()) });
    paramSurfaceHolder.Init(OpenGlRender.getGLVersion(), new WeakReference(paramSurfaceHolder), paramSurfaceHolder.mRenderMode);
    paramSurfaceHolder.setParam(paramSurfaceHolder.mBrightness, paramSurfaceHolder.mContrast, paramSurfaceHolder.mSaturation, paramSurfaceHolder.mRenderMode);
    paramSurfaceHolder.setMode(((OpenGlView)paramSurfaceHolder.qbd.get()).getWidth(), ((OpenGlView)paramSurfaceHolder.qbd.get()).getHeight(), 0, paramSurfaceHolder.mRenderMode);
    paramSurfaceHolder.qba = true;
    paramSurfaceHolder.qaW = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    y.i(TAG, "surfaceDestroyed");
    OpenGlRender localOpenGlRender = (OpenGlRender)this.qbA.get();
    y.i(OpenGlRender.TAG, "onSurfaceDestroyed");
    localOpenGlRender.qaW = false;
    localOpenGlRender.Uninit(localOpenGlRender.mRenderMode);
    y.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
    localOpenGlRender.qaU = 0;
    localOpenGlRender.qbb = 0;
    localOpenGlRender.qbc = 0;
    if (localOpenGlRender.qbo != null) {
      localOpenGlRender.qbo.destroy();
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlView
 * JD-Core Version:    0.7.0.1
 */