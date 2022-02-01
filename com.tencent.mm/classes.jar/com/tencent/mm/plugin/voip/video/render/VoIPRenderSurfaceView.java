package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "screenSize", "Landroid/graphics/Point;", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a HoI;
  public SurfaceHolder.Callback HoF;
  public j.b HoG;
  public int HoH;
  private boolean onr;
  
  static
  {
    AppMethodBeat.i(236304);
    HoI = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(236304);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236303);
    this.HoF = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(236303);
  }
  
  public final void fLZ()
  {
    AppMethodBeat.i(236301);
    getHolder().removeCallback(this.HoF);
    j.b localb = this.HoG;
    if (localb != null) {
      localb.aed(this.HoH);
    }
    this.HoG = null;
    AppMethodBeat.o(236301);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.HoF;
  }
  
  public final j.b getEventListner()
  {
    return this.HoG;
  }
  
  public final int getRemoteMode()
  {
    return this.HoH;
  }
  
  public void jH(int paramInt1, int paramInt2) {}
  
  public void jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236299);
    RelativeLayout.LayoutParams localLayoutParams;
    if (ao.gJI())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(236299);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(236302);
    j.b localb = this.HoG;
    if (localb != null) {
      localb.aed(this.HoH);
    }
    fLZ();
    AppMethodBeat.o(236302);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(236300);
    p.h(paramCallback, "<set-?>");
    this.HoF = paramCallback;
    AppMethodBeat.o(236300);
  }
  
  public final void setEventListner(j.b paramb)
  {
    this.HoG = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.onr = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.HoH = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(236296);
      paramSurfaceHolder = this.HoJ.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.aG(paramInt2, paramInt3, this.HoJ.getRemoteMode());
        AppMethodBeat.o(236296);
        return;
      }
      AppMethodBeat.o(236296);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(236298);
      if (paramSurfaceHolder != null)
      {
        j.b localb = this.HoJ.getEventListner();
        if (localb != null)
        {
          localb.a(this.HoJ.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(236298);
          return;
        }
      }
      AppMethodBeat.o(236298);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(236297);
      paramSurfaceHolder = this.HoJ.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.aed(this.HoJ.getRemoteMode());
        AppMethodBeat.o(236297);
        return;
      }
      AppMethodBeat.o(236297);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */