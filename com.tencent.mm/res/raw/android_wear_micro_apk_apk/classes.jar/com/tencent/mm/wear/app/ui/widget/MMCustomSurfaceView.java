package com.tencent.mm.wear.app.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.wear.a.c.d;

public abstract class MMCustomSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private c alz;
  
  public MMCustomSurfaceView(Context paramContext)
  {
    super(paramContext);
    op();
  }
  
  public MMCustomSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    op();
  }
  
  public MMCustomSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    op();
  }
  
  private void op()
  {
    SurfaceHolder localSurfaceHolder = getHolder();
    localSurfaceHolder.addCallback(this);
    setZOrderOnTop(true);
    localSurfaceHolder.setFormat(-3);
    this.alz = new c(this, localSurfaceHolder);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    d.d("MicroMsg.MMCustomSurfaceView", "surfaceChanged: format=%d, width=%d, height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.alz.start();
    d.c("MicroMsg.MMCustomSurfaceView", "surfaceCreated", new Object[0]);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.alz.oq();
    d.c("MicroMsg.MMCustomSurfaceView", "surfaceDestroyed", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.MMCustomSurfaceView
 * JD-Core Version:    0.7.0.1
 */