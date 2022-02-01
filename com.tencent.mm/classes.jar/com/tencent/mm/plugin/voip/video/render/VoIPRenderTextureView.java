package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a HoK;
  public j.b HoG;
  public int HoH;
  private boolean onr;
  
  static
  {
    AppMethodBeat.i(236312);
    HoK = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(236312);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(236310);
    AppMethodBeat.o(236310);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236311);
    AppMethodBeat.o(236311);
  }
  
  public final void fMa()
  {
    AppMethodBeat.i(236309);
    j.b localb = this.HoG;
    if (localb != null)
    {
      localb.fLY();
      AppMethodBeat.o(236309);
      return;
    }
    AppMethodBeat.o(236309);
  }
  
  public final j.b getEventListner()
  {
    return this.HoG;
  }
  
  public final int getRemoteMode()
  {
    return this.HoH;
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
  
  public final void xv(boolean paramBoolean)
  {
    AppMethodBeat.i(236308);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(236308);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(236308);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(236307);
      if (paramSurfaceTexture != null)
      {
        j.b localb = this.HoL.getEventListner();
        if (localb != null) {
          localb.a(this.HoL.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.HoL.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.aG(paramInt1, paramInt2, this.HoL.getRemoteMode());
          AppMethodBeat.o(236307);
          return;
        }
      }
      AppMethodBeat.o(236307);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(236306);
      paramSurfaceTexture = this.HoL.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.aed(this.HoL.getRemoteMode());
      }
      AppMethodBeat.o(236306);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(236305);
      paramSurfaceTexture = this.HoL.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.aG(paramInt1, paramInt2, this.HoL.getRemoteMode());
        AppMethodBeat.o(236305);
        return;
      }
      AppMethodBeat.o(236305);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */