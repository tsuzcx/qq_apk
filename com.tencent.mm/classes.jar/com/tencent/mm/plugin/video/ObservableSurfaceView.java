package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private a BWh;
  protected boolean BWi;
  protected boolean BWj;
  protected boolean BWk;
  protected SurfaceHolder jXN;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.BWh = null;
    this.BWi = false;
    this.BWj = false;
    this.BWk = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.BWh = null;
    this.BWi = false;
    this.BWj = false;
    this.BWk = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.BWh = null;
    this.BWi = false;
    this.BWj = false;
    this.BWk = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.jXN = getHolder();
    this.jXN.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public final boolean evw()
  {
    return this.BWi;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.jXN;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.BWk = paramBoolean;
    if (this.BWk) {
      this.jXN.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.BWh = parama;
    if (this.BWk) {
      this.jXN.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    ae.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.BWj = true;
    try
    {
      this.jXN.removeCallback(this);
      label27:
      this.jXN = paramSurfaceHolder;
      this.jXN.addCallback(this);
      if (this.BWh != null) {
        this.BWh.a(this.jXN);
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
    this.BWi = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.BWi = false;
    this.BWj = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */