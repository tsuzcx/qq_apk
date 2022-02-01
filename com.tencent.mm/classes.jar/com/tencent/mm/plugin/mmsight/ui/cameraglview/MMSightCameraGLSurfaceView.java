package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  b Ley;
  int nKn;
  int qpD;
  int qpE;
  private int qpO;
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94779);
    this.Ley = null;
    this.qpO = 0;
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new MMSightCameraGLSurfaceView.b(this));
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.Ley = new b();
      setRenderer(this.Ley);
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
  
  public final void aT(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94780);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    this.qpD = paramInt1;
    this.qpE = paramInt2;
    this.nKn = paramInt3;
    AppMethodBeat.o(94780);
  }
  
  public final void bgx()
  {
    AppMethodBeat.i(94782);
    if (this.Ley != null)
    {
      this.Ley.qpJ = true;
      requestRender();
    }
    AppMethodBeat.o(94782);
  }
  
  public final void e(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94781);
    if ((paramArrayOfByte != null) && (this.Ley != null) && (!this.Ley.qpC))
    {
      this.Ley.b(paramArrayOfByte, this.qpD, this.qpE, paramInt, paramBoolean);
      requestRender();
      AppMethodBeat.o(94781);
      return;
    }
    Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
    AppMethodBeat.o(94781);
  }
  
  public int getFrameHeight()
  {
    return this.qpE;
  }
  
  public int getFrameRotate()
  {
    return this.nKn;
  }
  
  public int getFrameWidth()
  {
    return this.qpD;
  }
  
  public b getRenderer()
  {
    return this.Ley;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94785);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(94785);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94783);
    super.surfaceCreated(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    AppMethodBeat.o(94783);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94784);
    super.surfaceDestroyed(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(94784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */