package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "onDetachedFromWindow", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a zAt;
  private boolean lUw;
  public h.b zAp;
  public int zAq;
  
  static
  {
    AppMethodBeat.i(192494);
    zAt = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(192494);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192492);
    AppMethodBeat.o(192492);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192493);
    AppMethodBeat.o(192493);
  }
  
  public final void dXT()
  {
    AppMethodBeat.i(192490);
    h.b localb = this.zAp;
    if (localb != null)
    {
      localb.dXR();
      AppMethodBeat.o(192490);
      return;
    }
    AppMethodBeat.o(192490);
  }
  
  public final h.b getEventListner()
  {
    return this.zAp;
  }
  
  public final int getRemoteMode()
  {
    return this.zAq;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(192491);
    super.onDetachedFromWindow();
    setSurfaceTextureListener(null);
    this.zAp = null;
    AppMethodBeat.o(192491);
  }
  
  public final void rV(boolean paramBoolean)
  {
    AppMethodBeat.i(192489);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(192489);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(192489);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192488);
      if (paramSurfaceTexture != null)
      {
        h.b localb = this.zAu.getEventListner();
        if (localb != null) {
          localb.a(this.zAu.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.zAu.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.av(paramInt1, paramInt2, this.zAu.getRemoteMode());
          AppMethodBeat.o(192488);
          return;
        }
      }
      AppMethodBeat.o(192488);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192487);
      paramSurfaceTexture = this.zAu.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.QW(this.zAu.getRemoteMode());
      }
      AppMethodBeat.o(192487);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192486);
      paramSurfaceTexture = this.zAu.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.av(paramInt1, paramInt2, this.zAu.getRemoteMode());
        AppMethodBeat.o(192486);
        return;
      }
      AppMethodBeat.o(192486);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */