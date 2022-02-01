package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$4", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
public final class k$g
  implements k.b
{
  private g Ofq;
  
  public final void a(final int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(239045);
    if ((paramSurface != null) || (paramSurfaceTexture != null))
    {
      if ((paramSurface != null) && (paramSurface.isValid())) {
        paramSurface = new g(paramSurface, (byte)0);
      }
      for (;;)
      {
        this.Ofq = paramSurface;
        paramSurface = k.c(this.Ofp);
        if (paramSurface == null) {
          break;
        }
        paramSurfaceTexture = this.Ofq;
        if (paramSurfaceTexture == null) {
          kotlin.g.b.p.iCn();
        }
        paramSurface.a(paramSurfaceTexture, (b)new a(this, paramInt));
        AppMethodBeat.o(239045);
        return;
        if (paramSurfaceTexture != null)
        {
          paramSurface = new g(paramSurfaceTexture, (byte)0);
        }
        else
        {
          Log.e("MicroMsg.VoIPRenderMgr", "surface onView create failed cause not valid");
          paramSurface = null;
        }
      }
    }
    AppMethodBeat.o(239045);
  }
  
  public final void aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(239047);
    Object localObject = this.Ofq;
    if (localObject != null)
    {
      ((g)localObject).ld(paramInt1, paramInt2);
      p localp = k.c(this.Ofp);
      if (localp != null) {
        localp.a((g)localObject, paramInt3);
      }
      localObject = k.c(this.Ofp);
      if (localObject != null)
      {
        ((p)localObject).gEs();
        AppMethodBeat.o(239047);
        return;
      }
      AppMethodBeat.o(239047);
      return;
    }
    AppMethodBeat.o(239047);
  }
  
  public final void alQ(int paramInt)
  {
    AppMethodBeat.i(239046);
    g localg = this.Ofq;
    if (localg != null)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "onViewDestroy in VoIPRenderSurfaceView " + this.Ofq);
      p localp = k.c(this.Ofp);
      if (localp != null) {
        localp.a(localg);
      }
      localp = k.c(this.Ofp);
      if (localp != null) {
        localp.c(localg, paramInt);
      }
      this.Ofq = null;
      AppMethodBeat.o(239046);
      return;
    }
    AppMethodBeat.o(239046);
  }
  
  public final void gEz()
  {
    AppMethodBeat.i(239044);
    p localp = k.c(this.Ofp);
    if (localp != null)
    {
      localp.gEG();
      AppMethodBeat.o(239044);
      return;
    }
    AppMethodBeat.o(239044);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "invoke"})
  static final class a
    extends q
    implements b<g, x>
  {
    a(k.g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k.g
 * JD-Core Version:    0.7.0.1
 */