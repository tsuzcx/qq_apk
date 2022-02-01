package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected SurfaceHolder jao;
  private a yYP;
  protected boolean yYQ;
  protected boolean yYR;
  protected boolean yYS;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.yYP = null;
    this.yYQ = false;
    this.yYR = false;
    this.yYS = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.yYP = null;
    this.yYQ = false;
    this.yYR = false;
    this.yYS = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.yYP = null;
    this.yYQ = false;
    this.yYR = false;
    this.yYS = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.jao = getHolder();
    this.jao.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public final boolean dQT()
  {
    return this.yYQ;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.jao;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.yYS = paramBoolean;
    if (this.yYS) {
      this.jao.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.yYP = parama;
    if (this.yYS) {
      this.jao.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    ad.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.yYR = true;
    try
    {
      this.jao.removeCallback(this);
      label27:
      this.jao = paramSurfaceHolder;
      this.jao.addCallback(this);
      if (this.yYP != null) {
        this.yYP.a(this.jao);
      }
      AppMethodBeat.o(127132);
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.yYQ = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.yYQ = false;
    this.yYR = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */