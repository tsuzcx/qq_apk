package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private a GwQ;
  protected boolean GwR;
  protected boolean GwS;
  protected boolean GwT;
  protected SurfaceHolder laL;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.GwQ = null;
    this.GwR = false;
    this.GwS = false;
    this.GwT = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.GwQ = null;
    this.GwR = false;
    this.GwS = false;
    this.GwT = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.GwQ = null;
    this.GwR = false;
    this.GwS = false;
    this.GwT = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.laL = getHolder();
    this.laL.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public final boolean fAP()
  {
    return this.GwR;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.laL;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.GwT = paramBoolean;
    if (this.GwT) {
      this.laL.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.GwQ = parama;
    if (this.GwT) {
      this.laL.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    Log.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.GwS = true;
    try
    {
      this.laL.removeCallback(this);
      label27:
      this.laL = paramSurfaceHolder;
      this.laL.addCallback(this);
      if (this.GwQ != null) {
        this.GwQ.a(this.laL);
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
    this.GwR = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.GwR = false;
    this.GwS = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */