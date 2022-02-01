package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "onDetachedFromWindow", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a ASL;
  public h.b ASH;
  public int ASI;
  private boolean mwy;
  
  static
  {
    AppMethodBeat.i(208845);
    ASL = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(208845);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208843);
    AppMethodBeat.o(208843);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208844);
    AppMethodBeat.o(208844);
  }
  
  public final void enp()
  {
    AppMethodBeat.i(208841);
    h.b localb = this.ASH;
    if (localb != null)
    {
      localb.enn();
      AppMethodBeat.o(208841);
      return;
    }
    AppMethodBeat.o(208841);
  }
  
  public final h.b getEventListner()
  {
    return this.ASH;
  }
  
  public final int getRemoteMode()
  {
    return this.ASI;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(208842);
    super.onDetachedFromWindow();
    setSurfaceTextureListener(null);
    this.ASH = null;
    AppMethodBeat.o(208842);
  }
  
  public final void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(208840);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(208840);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(208840);
  }
  
  public final void setEventListner(h.b paramb)
  {
    this.ASH = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.mwy = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.ASI = paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208839);
      if (paramSurfaceTexture != null)
      {
        h.b localb = this.ASM.getEventListner();
        if (localb != null) {
          localb.a(this.ASM.getRemoteMode(), null, paramSurfaceTexture);
        }
        paramSurfaceTexture = this.ASM.getEventListner();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.aw(paramInt1, paramInt2, this.ASM.getRemoteMode());
          AppMethodBeat.o(208839);
          return;
        }
      }
      AppMethodBeat.o(208839);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(208838);
      paramSurfaceTexture = this.ASM.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.Tf(this.ASM.getRemoteMode());
      }
      AppMethodBeat.o(208838);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208837);
      paramSurfaceTexture = this.ASM.getEventListner();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.aw(paramInt1, paramInt2, this.ASM.getRemoteMode());
        AppMethodBeat.o(208837);
        return;
      }
      AppMethodBeat.o(208837);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */