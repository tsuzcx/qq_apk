package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.y;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected SurfaceHolder fMT;
  private a pKR = null;
  protected boolean pKS = false;
  protected boolean pKT = false;
  protected boolean pKU = false;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.fMT = getHolder();
    this.fMT.addCallback(this);
  }
  
  public final boolean bOY()
  {
    return this.pKS;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.fMT;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    this.pKU = paramBoolean;
    if (this.pKU) {
      this.fMT.setType(3);
    }
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    this.pKR = parama;
    if (this.pKU) {
      this.fMT.setType(3);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.pKT = true;
    try
    {
      this.fMT.removeCallback(this);
      label22:
      this.fMT = paramSurfaceHolder;
      this.fMT.addCallback(this);
      if (this.pKR != null) {
        this.pKR.a(this.fMT);
      }
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.pKS = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.pKS = false;
    this.pKT = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */