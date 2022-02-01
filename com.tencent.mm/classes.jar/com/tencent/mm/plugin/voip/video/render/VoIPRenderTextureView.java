package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a CKx;
  public j.b CKt;
  public int CKu;
  private boolean ncj;
  
  static
  {
    AppMethodBeat.i(210629);
    CKx = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(210629);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(210627);
    AppMethodBeat.o(210627);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210628);
    AppMethodBeat.o(210628);
  }
  
  public final void eEW()
  {
    AppMethodBeat.i(210626);
    j.b localb = this.CKt;
    if (localb != null)
    {
      localb.eEU();
      AppMethodBeat.o(210626);
      return;
    }
    AppMethodBeat.o(210626);
  }
  
  public final j.b getEventListner()
  {
    return this.CKt;
  }
  
  public final int getRemoteMode()
  {
    return this.CKu;
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
  
  public final void tN(boolean paramBoolean)
  {
    AppMethodBeat.i(210625);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(210625);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(210625);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210624);
      if (paramSurfaceTexture != null)
      {
        j.b localb = this.CKy.getEventListner();
        if (localb != null) {
          localb.a(this.CKy.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.CKy.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.az(paramInt1, paramInt2, this.CKy.getRemoteMode());
          AppMethodBeat.o(210624);
          return;
        }
      }
      AppMethodBeat.o(210624);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(210623);
      paramSurfaceTexture = this.CKy.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.VF(this.CKy.getRemoteMode());
      }
      AppMethodBeat.o(210623);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210622);
      paramSurfaceTexture = this.CKy.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.az(paramInt1, paramInt2, this.CKy.getRemoteMode());
        AppMethodBeat.o(210622);
        return;
      }
      AppMethodBeat.o(210622);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */