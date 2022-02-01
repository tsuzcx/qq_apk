package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a CsR;
  public SurfaceHolder.Callback CsO;
  public j.b CsP;
  public int CsQ;
  private boolean mXd;
  
  static
  {
    AppMethodBeat.i(216200);
    CsR = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(216200);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216199);
    this.CsO = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(216199);
  }
  
  public final void eBn()
  {
    AppMethodBeat.i(216197);
    getHolder().removeCallback(this.CsO);
    j.b localb = this.CsP;
    if (localb != null) {
      localb.UY(this.CsQ);
    }
    this.CsP = null;
    AppMethodBeat.o(216197);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.CsO;
  }
  
  public final j.b getEventListner()
  {
    return this.CsP;
  }
  
  public final int getRemoteMode()
  {
    return this.CsQ;
  }
  
  public void iy(int paramInt1, int paramInt2) {}
  
  public void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216195);
    RelativeLayout.LayoutParams localLayoutParams;
    if (al.fxN())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(216195);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(216198);
    j.b localb = this.CsP;
    if (localb != null) {
      localb.UY(this.CsQ);
    }
    eBn();
    AppMethodBeat.o(216198);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(216196);
    p.h(paramCallback, "<set-?>");
    this.CsO = paramCallback;
    AppMethodBeat.o(216196);
  }
  
  public final void setEventListner(j.b paramb)
  {
    this.CsP = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.mXd = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.CsQ = paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(216192);
      paramSurfaceHolder = this.CsS.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.ay(paramInt2, paramInt3, this.CsS.getRemoteMode());
        AppMethodBeat.o(216192);
        return;
      }
      AppMethodBeat.o(216192);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(216194);
      if (paramSurfaceHolder != null)
      {
        j.b localb = this.CsS.getEventListner();
        if (localb != null)
        {
          localb.a(this.CsS.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(216194);
          return;
        }
      }
      AppMethodBeat.o(216194);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(216193);
      paramSurfaceHolder = this.CsS.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.UY(this.CsS.getRemoteMode());
        AppMethodBeat.o(216193);
        return;
      }
      AppMethodBeat.o(216193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */