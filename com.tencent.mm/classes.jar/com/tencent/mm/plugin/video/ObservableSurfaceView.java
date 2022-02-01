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
  private a BEJ;
  protected boolean BEK;
  protected boolean BEL;
  protected boolean BEM;
  protected SurfaceHolder jUw;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.BEJ = null;
    this.BEK = false;
    this.BEL = false;
    this.BEM = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.BEJ = null;
    this.BEK = false;
    this.BEL = false;
    this.BEM = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.BEJ = null;
    this.BEK = false;
    this.BEL = false;
    this.BEM = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.jUw = getHolder();
    this.jUw.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public final boolean erP()
  {
    return this.BEK;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.jUw;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.BEM = paramBoolean;
    if (this.BEM) {
      this.jUw.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.BEJ = parama;
    if (this.BEM) {
      this.jUw.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    ad.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.BEL = true;
    try
    {
      this.jUw.removeCallback(this);
      label27:
      this.jUw = paramSurfaceHolder;
      this.jUw.addCallback(this);
      if (this.BEJ != null) {
        this.BEJ.a(this.jUw);
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
    this.BEK = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.BEK = false;
    this.BEL = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */