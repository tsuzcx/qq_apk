package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a ASJ;
  public SurfaceHolder.Callback ASG;
  public h.b ASH;
  public int ASI;
  private boolean mwy;
  
  static
  {
    AppMethodBeat.i(208836);
    ASJ = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(208836);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208835);
    this.ASG = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(208835);
  }
  
  public final void eno()
  {
    AppMethodBeat.i(208833);
    getHolder().removeCallback(this.ASG);
    h.b localb = this.ASH;
    if (localb != null) {
      localb.Tf(this.ASI);
    }
    this.ASH = null;
    AppMethodBeat.o(208833);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.ASG;
  }
  
  public final h.b getEventListner()
  {
    return this.ASH;
  }
  
  public final int getRemoteMode()
  {
    return this.ASI;
  }
  
  public void il(int paramInt1, int paramInt2) {}
  
  public void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208831);
    RelativeLayout.LayoutParams localLayoutParams;
    if (aj.fhA())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(208831);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(208834);
    h.b localb = this.ASH;
    if (localb != null) {
      localb.Tf(this.ASI);
    }
    eno();
    AppMethodBeat.o(208834);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(208832);
    k.h(paramCallback, "<set-?>");
    this.ASG = paramCallback;
    AppMethodBeat.o(208832);
  }
  
  public final void setEventListner(h.b paramb)
  {
    this.ASH = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.mwy = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.ASI = paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(208828);
      paramSurfaceHolder = this.ASK.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.aw(paramInt2, paramInt3, this.ASK.getRemoteMode());
        AppMethodBeat.o(208828);
        return;
      }
      AppMethodBeat.o(208828);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(208830);
      if (paramSurfaceHolder != null)
      {
        h.b localb = this.ASK.getEventListner();
        if (localb != null)
        {
          localb.a(this.ASK.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(208830);
          return;
        }
      }
      AppMethodBeat.o(208830);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(208829);
      paramSurfaceHolder = this.ASK.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.Tf(this.ASK.getRemoteMode());
        AppMethodBeat.o(208829);
        return;
      }
      AppMethodBeat.o(208829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */