package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a OfC;
  private boolean AJP;
  public k.b Ofy;
  public int Ofz;
  
  static
  {
    AppMethodBeat.i(239377);
    OfC = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(239377);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(239372);
    AppMethodBeat.o(239372);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(239374);
    AppMethodBeat.o(239374);
  }
  
  public final void Bn(boolean paramBoolean)
  {
    AppMethodBeat.i(239359);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(239359);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(239359);
  }
  
  public final void gEB()
  {
    AppMethodBeat.i(239368);
    k.b localb = this.Ofy;
    if (localb != null)
    {
      localb.gEz();
      AppMethodBeat.o(239368);
      return;
    }
    AppMethodBeat.o(239368);
  }
  
  public final k.b getEventListner()
  {
    return this.Ofy;
  }
  
  public final int getRemoteMode()
  {
    return this.Ofz;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243418);
      if (paramSurfaceTexture != null)
      {
        k.b localb = this.OfD.getEventListner();
        if (localb != null) {
          localb.a(this.OfD.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.OfD.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.aK(paramInt1, paramInt2, this.OfD.getRemoteMode());
          AppMethodBeat.o(243418);
          return;
        }
      }
      AppMethodBeat.o(243418);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(243416);
      paramSurfaceTexture = this.OfD.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.alQ(this.OfD.getRemoteMode());
      }
      AppMethodBeat.o(243416);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243412);
      paramSurfaceTexture = this.OfD.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.aK(paramInt1, paramInt2, this.OfD.getRemoteMode());
        AppMethodBeat.o(243412);
        return;
      }
      AppMethodBeat.o(243412);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */