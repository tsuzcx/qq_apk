package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  int huh;
  private int juD;
  int jus;
  int jut;
  b vXz;
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94779);
    this.vXz = null;
    this.juD = 0;
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new MMSightCameraGLSurfaceView.b(this));
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.vXz = new b();
      setRenderer(this.vXz);
      setRenderMode(0);
      AppMethodBeat.o(94779);
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
  
  public final void al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94780);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    this.jus = paramInt1;
    this.jut = paramInt2;
    this.huh = paramInt3;
    AppMethodBeat.o(94780);
  }
  
  public final void amn()
  {
    AppMethodBeat.i(94782);
    if (this.vXz != null)
    {
      this.vXz.juy = true;
      requestRender();
    }
    AppMethodBeat.o(94782);
  }
  
  public final void e(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94781);
    if ((paramArrayOfByte != null) && (this.vXz != null) && (!this.vXz.jur))
    {
      this.vXz.b(paramArrayOfByte, this.jus, this.jut, paramInt, paramBoolean);
      requestRender();
      AppMethodBeat.o(94781);
      return;
    }
    ad.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
    AppMethodBeat.o(94781);
  }
  
  public int getFrameHeight()
  {
    return this.jut;
  }
  
  public int getFrameRotate()
  {
    return this.huh;
  }
  
  public int getFrameWidth()
  {
    return this.jus;
  }
  
  public b getRenderer()
  {
    return this.vXz;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94785);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(94785);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94783);
    super.surfaceCreated(paramSurfaceHolder);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    AppMethodBeat.o(94783);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94784);
    super.surfaceDestroyed(paramSurfaceHolder);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(94784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */