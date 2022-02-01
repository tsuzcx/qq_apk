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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  public static final VoIPRenderSurfaceView.a CKv;
  public SurfaceHolder.Callback CKs;
  public j.b CKt;
  public int CKu;
  private boolean ncj;
  
  static
  {
    AppMethodBeat.i(210621);
    CKv = new VoIPRenderSurfaceView.a((byte)0);
    AppMethodBeat.o(210621);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210620);
    this.CKs = ((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(210620);
  }
  
  public final void eEV()
  {
    AppMethodBeat.i(210618);
    getHolder().removeCallback(this.CKs);
    j.b localb = this.CKt;
    if (localb != null) {
      localb.VF(this.CKu);
    }
    this.CKt = null;
    AppMethodBeat.o(210618);
  }
  
  public final SurfaceHolder.Callback getCallback()
  {
    return this.CKs;
  }
  
  public final j.b getEventListner()
  {
    return this.CKt;
  }
  
  public final int getRemoteMode()
  {
    return this.CKu;
  }
  
  public void iC(int paramInt1, int paramInt2) {}
  
  public void iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210616);
    RelativeLayout.LayoutParams localLayoutParams;
    if (al.fBP())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(210616);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(210619);
    j.b localb = this.CKt;
    if (localb != null) {
      localb.VF(this.CKu);
    }
    eEV();
    AppMethodBeat.o(210619);
  }
  
  public final void setCallback(SurfaceHolder.Callback paramCallback)
  {
    AppMethodBeat.i(210617);
    p.h(paramCallback, "<set-?>");
    this.CKs = paramCallback;
    AppMethodBeat.o(210617);
  }
  
  public final void setEventListner(j.b paramb)
  {
    this.CKt = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.ncj = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.CKu = paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
  public static final class b
    implements SurfaceHolder.Callback
  {
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210613);
      paramSurfaceHolder = this.CKw.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.az(paramInt2, paramInt3, this.CKw.getRemoteMode());
        AppMethodBeat.o(210613);
        return;
      }
      AppMethodBeat.o(210613);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(210615);
      if (paramSurfaceHolder != null)
      {
        j.b localb = this.CKw.getEventListner();
        if (localb != null)
        {
          localb.a(this.CKw.getRemoteMode(), paramSurfaceHolder.getSurface(), null);
          AppMethodBeat.o(210615);
          return;
        }
      }
      AppMethodBeat.o(210615);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(210614);
      paramSurfaceHolder = this.CKw.getEventListner();
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.VF(this.CKw.getRemoteMode());
        AppMethodBeat.o(210614);
        return;
      }
      AppMethodBeat.o(210614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */