package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ObservableSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected SurfaceHolder hgd;
  private a tqN;
  protected boolean tqO;
  protected boolean tqP;
  protected boolean tqQ;
  
  public ObservableSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50956);
    this.tqN = null;
    this.tqO = false;
    this.tqP = false;
    this.tqQ = false;
    init();
    AppMethodBeat.o(50956);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(50957);
    this.tqN = null;
    this.tqO = false;
    this.tqP = false;
    this.tqQ = false;
    init();
    AppMethodBeat.o(50957);
  }
  
  public ObservableSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(50958);
    this.tqN = null;
    this.tqO = false;
    this.tqP = false;
    this.tqQ = false;
    init();
    AppMethodBeat.o(50958);
  }
  
  private void init()
  {
    AppMethodBeat.i(50959);
    this.hgd = getHolder();
    this.hgd.addCallback(this);
    AppMethodBeat.o(50959);
  }
  
  public final boolean cLd()
  {
    return this.tqO;
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.hgd;
  }
  
  public void setNeedSetType(boolean paramBoolean)
  {
    AppMethodBeat.i(50960);
    this.tqQ = paramBoolean;
    if (this.tqQ) {
      this.hgd.setType(3);
    }
    AppMethodBeat.o(50960);
  }
  
  public void setSurfaceChangeCallback(a parama)
  {
    AppMethodBeat.i(50961);
    this.tqN = parama;
    if (this.tqQ) {
      this.hgd.setType(3);
    }
    AppMethodBeat.o(50961);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50962);
    ab.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
    this.tqP = true;
    try
    {
      this.hgd.removeCallback(this);
      label27:
      this.hgd = paramSurfaceHolder;
      this.hgd.addCallback(this);
      if (this.tqN != null) {
        this.tqN.a(this.hgd);
      }
      AppMethodBeat.o(50962);
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.tqO = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.tqO = false;
    this.tqP = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableSurfaceView
 * JD-Core Version:    0.7.0.1
 */