package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a zAr;
  private boolean lUw;
  public SurfaceHolder.Callback zAo;
  public h.b zAp;
  public int zAq;
  
  static
  {
    AppMethodBeat.i(192485);
    zAr = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(192485);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192484);
    this.zAo = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(192484);
  }
  
  public final void dXS()
  {
    AppMethodBeat.i(192482);
    getHolder().removeCallback(this.zAo);
    h.b localb = this.zAp;
    if (localb != null) {
      localb.QW(this.zAq);
    }
    this.zAp = null;
    AppMethodBeat.o(192482);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.zAo;
  }
  
  public final h.b getEventListner()
  {
    return this.zAp;
  }
  
  public final int getRemoteMode()
  {
    return this.zAq;
  }
  
  public void hW(int paramInt1, int paramInt2) {}
  
  public void hX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192480);
    RelativeLayout.LayoutParams localLayoutParams;
    if (ai.eRQ())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(192480);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(192483);
    h.b localb = this.zAp;
    if (localb != null) {
      localb.QW(this.zAq);
    }
    dXS();
    AppMethodBeat.o(192483);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(192481);
    k.h(paramCallback, "<set-?>");
    this.zAo = paramCallback;
    AppMethodBeat.o(192481);
  }
  
  public final void setEventListner(h.b paramb)
  {
    this.zAp = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.lUw = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.zAq = paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(192477);
      paramSurfaceHolder = this.zAs.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.av(paramInt2, paramInt3, this.zAs.getRemoteMode());
        AppMethodBeat.o(192477);
        return;
      }
      AppMethodBeat.o(192477);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(192479);
      if (paramSurfaceHolder != null)
      {
        h.b localb = this.zAs.getEventListner();
        if (localb != null)
        {
          localb.a(this.zAs.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(192479);
          return;
        }
      }
      AppMethodBeat.o(192479);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(192478);
      paramSurfaceHolder = this.zAs.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.QW(this.zAs.getRemoteMode());
        AppMethodBeat.o(192478);
        return;
      }
      AppMethodBeat.o(192478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */