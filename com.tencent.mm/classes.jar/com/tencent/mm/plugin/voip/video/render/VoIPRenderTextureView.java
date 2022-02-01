package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public class VoIPRenderTextureView
  extends TextureView
{
  public static final VoIPRenderTextureView.a UTU;
  private boolean Flq;
  public int UTR;
  public j.b UTV;
  
  static
  {
    AppMethodBeat.i(293129);
    UTU = new VoIPRenderTextureView.a((byte)0);
    AppMethodBeat.o(293129);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(293117);
    AppMethodBeat.o(293117);
  }
  
  public VoIPRenderTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(293123);
    AppMethodBeat.o(293123);
  }
  
  public final void GR(boolean paramBoolean)
  {
    AppMethodBeat.i(293137);
    if (paramBoolean)
    {
      setAlpha(0.0F);
      AppMethodBeat.o(293137);
      return;
    }
    setAlpha(1.0F);
    AppMethodBeat.o(293137);
  }
  
  public final j.b getEventListner()
  {
    return this.UTV;
  }
  
  public final int getRemoteMode()
  {
    return this.UTR;
  }
  
  public final void idA()
  {
    AppMethodBeat.i(293162);
    j.b localb = this.UTV;
    if (localb != null) {
      localb.idx();
    }
    AppMethodBeat.o(293162);
  }
  
  public final void idB()
  {
    AppMethodBeat.i(293166);
    setSurfaceTextureListener(null);
    j.b localb = this.UTV;
    if (localb != null) {
      localb.ary(this.UTR);
    }
    this.UTV = null;
    AppMethodBeat.o(293166);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293172);
    j.b localb = this.UTV;
    if (localb != null) {
      localb.ary(this.UTR);
    }
    idB();
    AppMethodBeat.o(293172);
  }
  
  public final void setEventListner(j.b paramb)
  {
    this.UTV = paramb;
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public final void setRemoteMode(int paramInt)
  {
    this.UTR = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public b(VoIPRenderTextureView paramVoIPRenderTextureView) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(293014);
      s.u(paramSurfaceTexture, "surface");
      j.b localb = this.UTW.getEventListner();
      if (localb != null) {
        localb.a(this.UTW.getRemoteMode(), null, paramSurfaceTexture);
      }
      paramSurfaceTexture = this.UTW.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.bm(paramInt1, paramInt2, this.UTW.getRemoteMode());
      }
      AppMethodBeat.o(293014);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(293001);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = this.UTW.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.ary(this.UTW.getRemoteMode());
      }
      AppMethodBeat.o(293001);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(292985);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = this.UTW.getEventListner();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.bm(paramInt1, paramInt2, this.UTW.getRemoteMode());
      }
      AppMethodBeat.o(292985);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(292993);
      s.u(paramSurfaceTexture, "surface");
      AppMethodBeat.o(292993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView
 * JD-Core Version:    0.7.0.1
 */