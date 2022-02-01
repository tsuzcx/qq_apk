package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a CsT;
  public j.b CsP;
  public int CsQ;
  private boolean mXd;
  
  static
  {
    AppMethodBeat.i(216208);
    CsT = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(216208);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216206);
    AppMethodBeat.o(216206);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216207);
    AppMethodBeat.o(216207);
  }
  
  public final void eBo()
  {
    AppMethodBeat.i(216205);
    j.b localb = this.CsP;
    if (localb != null)
    {
      localb.eBm();
      AppMethodBeat.o(216205);
      return;
    }
    AppMethodBeat.o(216205);
  }
  
  public final j.b getEventListner()
  {
    return this.CsP;
  }
  
  public final int getRemoteMode()
  {
    return this.CsQ;
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
  
  public final void tG(boolean paramBoolean)
  {
    AppMethodBeat.i(216204);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(216204);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(216204);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216203);
      if (paramSurfaceTexture != null)
      {
        j.b localb = this.CsU.getEventListner();
        if (localb != null) {
          localb.a(this.CsU.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.CsU.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.ay(paramInt1, paramInt2, this.CsU.getRemoteMode());
          AppMethodBeat.o(216203);
          return;
        }
      }
      AppMethodBeat.o(216203);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216202);
      paramSurfaceTexture = this.CsU.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.UY(this.CsU.getRemoteMode());
      }
      AppMethodBeat.o(216202);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216201);
      paramSurfaceTexture = this.CsU.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.ay(paramInt1, paramInt2, this.CsU.getRemoteMode());
        AppMethodBeat.o(216201);
        return;
      }
      AppMethodBeat.o(216201);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */