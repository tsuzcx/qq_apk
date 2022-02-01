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
  private a TWW;
  protected boolean TWX;
  protected boolean TWY;
  protected boolean TWZ;
  protected SurfaceHolder qUE;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.TWW = null;
    this.TWX = false;
    this.TWY = false;
    this.TWZ = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.TWW = null;
    this.TWX = false;
    this.TWY = false;
    this.TWZ = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.TWW = null;
    this.TWX = false;
    this.TWY = false;
    this.TWZ = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.qUE = getHolder();
    this.qUE.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.qUE;
  }
  
  public final boolean hQj()
  {
    return this.TWX;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.TWZ = paramBoolean;
    if (this.TWZ) {
      this.qUE.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.TWW = parama;
    if (this.TWZ) {
      this.qUE.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    Log.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.TWY = true;
    try
    {
      this.qUE.removeCallback(this);
      label27:
      this.qUE = paramSurfaceHolder;
      this.qUE.addCallback(this);
      if (this.TWW != null) {
        this.TWW.d(this.qUE);
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
    this.TWX = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.TWX = false;
    this.TWY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */