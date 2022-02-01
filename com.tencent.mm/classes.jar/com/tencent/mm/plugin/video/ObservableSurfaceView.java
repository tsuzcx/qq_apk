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
  private a Nkj;
  protected boolean Nkk;
  protected boolean Nkl;
  protected boolean Nkm;
  protected SurfaceHolder nUU;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.Nkj = null;
    this.Nkk = false;
    this.Nkl = false;
    this.Nkm = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.Nkj = null;
    this.Nkk = false;
    this.Nkl = false;
    this.Nkm = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.Nkj = null;
    this.Nkk = false;
    this.Nkl = false;
    this.Nkm = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.nUU = getHolder();
    this.nUU.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.nUU;
  }
  
  public final boolean gsQ()
  {
    return this.Nkk;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.Nkm = paramBoolean;
    if (this.Nkm) {
      this.nUU.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.Nkj = parama;
    if (this.Nkm) {
      this.nUU.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    Log.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.Nkl = true;
    try
    {
      this.nUU.removeCallback(this);
      label27:
      this.nUU = paramSurfaceHolder;
      this.nUU.addCallback(this);
      if (this.Nkj != null) {
        this.Nkj.d(this.nUU);
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
    this.Nkk = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.Nkk = false;
    this.Nkl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */