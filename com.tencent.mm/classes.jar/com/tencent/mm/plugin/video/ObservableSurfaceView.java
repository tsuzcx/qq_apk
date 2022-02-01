package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private a AmE;
  protected boolean AmF;
  protected boolean AmG;
  protected boolean AmH;
  protected SurfaceHolder jAB;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127126);
    this.AmE = null;
    this.AmF = false;
    this.AmG = false;
    this.AmH = false;
    init();
    AppMethodBeat.o(127126);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127127);
    this.AmE = null;
    this.AmF = false;
    this.AmG = false;
    this.AmH = false;
    init();
    AppMethodBeat.o(127127);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127128);
    this.AmE = null;
    this.AmF = false;
    this.AmG = false;
    this.AmH = false;
    init();
    AppMethodBeat.o(127128);
  }
  
  private void init()
  {
    AppMethodBeat.i(127129);
    this.jAB = getHolder();
    this.jAB.addCallback(this);
    AppMethodBeat.o(127129);
  }
  
  public final boolean efs()
  {
    return this.AmF;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.jAB;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    this.AmH = paramBoolean;
    if (this.AmH) {
      this.jAB.setType(3);
    }
    AppMethodBeat.o(127130);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(127131);
    this.AmE = parama;
    if (this.AmH) {
      this.jAB.setType(3);
    }
    AppMethodBeat.o(127131);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127132);
    ac.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.AmG = true;
    try
    {
      this.jAB.removeCallback(this);
      label27:
      this.jAB = paramSurfaceHolder;
      this.jAB.addCallback(this);
      if (this.AmE != null) {
        this.AmE.a(this.jAB);
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
    this.AmF = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.AmF = false;
    this.AmG = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */