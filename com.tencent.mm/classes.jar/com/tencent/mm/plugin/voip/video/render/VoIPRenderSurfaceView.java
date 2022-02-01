package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "screenSize", "Landroid/graphics/Point;", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a OfA;
  private boolean AJP;
  public SurfaceHolder.Callback Ofx;
  public k.b Ofy;
  public int Ofz;
  
  static
  {
    AppMethodBeat.i(236069);
    OfA = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(236069);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236067);
    this.Ofx = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(236067);
  }
  
  public final void gEA()
  {
    AppMethodBeat.i(236061);
    getHolder().removeCallback(this.Ofx);
    k.b localb = this.Ofy;
    if (localb != null) {
      localb.alQ(this.Ofz);
    }
    this.Ofy = null;
    AppMethodBeat.o(236061);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.Ofx;
  }
  
  public final k.b getEventListner()
  {
    return this.Ofy;
  }
  
  public final int getRemoteMode()
  {
    return this.Ofz;
  }
  
  public void kW(int paramInt1, int paramInt2) {}
  
  public void kX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236051);
    RelativeLayout.LayoutParams localLayoutParams;
    if (ar.hIF())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(236051);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(236065);
    k.b localb = this.Ofy;
    if (localb != null) {
      localb.alQ(this.Ofz);
    }
    gEA();
    AppMethodBeat.o(236065);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(236054);
    p.k(paramCallback, "<set-?>");
    this.Ofx = paramCallback;
    AppMethodBeat.o(236054);
  }
  
  public final void setEventListner(k.b paramb)
  {
    this.Ofy = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.Ofz = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(236351);
      paramSurfaceHolder = this.OfB.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.aK(paramInt2, paramInt3, this.OfB.getRemoteMode());
        AppMethodBeat.o(236351);
        return;
      }
      AppMethodBeat.o(236351);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(236356);
      if (paramSurfaceHolder != null)
      {
        k.b localb = this.OfB.getEventListner();
        if (localb != null)
        {
          localb.a(this.OfB.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(236356);
          return;
        }
      }
      AppMethodBeat.o(236356);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(236354);
      paramSurfaceHolder = this.OfB.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.alQ(this.OfB.getRemoteMode());
        AppMethodBeat.o(236354);
        return;
      }
      AppMethodBeat.o(236354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */