package com.tencent.mm.plugin.voip.video.render;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.e;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "", "()V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "", "getFaceBeautyType", "initLocalPboSurfaceRenderer", "width", "height", "isUseFaceBeauty", "release", "removeSurface", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mirror", "setLocalRenderOrientation", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setVoIPBeauty", "cmd", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "Companion", "plugin-voip_release"})
public final class e
{
  public static final e.a CrP;
  public g CrM;
  public m CrN;
  b CrO;
  
  static
  {
    AppMethodBeat.i(216120);
    CrP = new e.a((byte)0);
    AppMethodBeat.o(216120);
  }
  
  private final boolean eBg()
  {
    AppMethodBeat.i(216114);
    g localg = this.CrM;
    if ((localg == null) || (localg.eBe() != 0))
    {
      AppMethodBeat.o(216114);
      return true;
    }
    AppMethodBeat.o(216114);
    return false;
  }
  
  public final void K(a<z> parama)
  {
    Object localObject = this.CrN;
    if (localObject != null) {
      ((c)localObject).Cru = parama;
    }
    localObject = this.CrM;
    if (localObject != null) {
      ((g)localObject).Cru = parama;
    }
  }
  
  public final void UW(int paramInt)
  {
    AppMethodBeat.i(216109);
    g localg = this.CrM;
    if (localg != null)
    {
      localg.UW(paramInt);
      AppMethodBeat.o(216109);
      return;
    }
    AppMethodBeat.o(216109);
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216111);
    p.h(paramac, "size");
    g localg = this.CrM;
    if (localg != null)
    {
      m localm = this.CrN;
      if (localm != null)
      {
        localm.a(localg, paramac, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(216111);
        return;
      }
      AppMethodBeat.o(216111);
      return;
    }
    AppMethodBeat.o(216111);
  }
  
  public final void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(216118);
    Object localObject = this.CrN;
    if (localObject != null) {
      ((m)localObject).a(paramf, paramInt);
    }
    localObject = this.CrM;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((g)localObject).Crz = paramf;
        AppMethodBeat.o(216118);
        return;
      }
      ((g)localObject).CrA = paramf;
      AppMethodBeat.o(216118);
      return;
    }
    AppMethodBeat.o(216118);
  }
  
  public final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(216113);
    if (paramf != null)
    {
      ad.m("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      Object localObject = this.CrN;
      if (localObject != null) {
        ((m)localObject).b(paramf, paramInt);
      }
      localObject = this.CrM;
      if (localObject != null)
      {
        if (paramf != null)
        {
          ad.m("MicroMsg.PboSurfaceRender", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
          if (paramInt == 0)
          {
            ((g)localObject).Crz = paramf;
            AppMethodBeat.o(216113);
            return;
          }
          ((g)localObject).CrA = paramf;
          AppMethodBeat.o(216113);
          return;
        }
        ad.e("MicroMsg.PboSurfaceRender", "add a null surface");
        AppMethodBeat.o(216113);
        return;
      }
      AppMethodBeat.o(216113);
      return;
    }
    ad.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(216113);
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(216115);
    if (paramf != null)
    {
      Object localObject = this.CrN;
      if (localObject != null) {
        ((m)localObject).c(paramf, paramInt);
      }
      g localg = this.CrM;
      if (localg != null)
      {
        if (paramf != null)
        {
          ad.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(paramf)));
          localObject = localg.huo;
          if (localObject != null)
          {
            localObject = ((c.b)localObject).hoQ;
            if ((localObject != null) && ((p.i(paramf.eBi(), EGL14.EGL_NO_SURFACE) ^ true)))
            {
              localObject = localg.huo;
              if (localObject == null) {
                break label132;
              }
            }
          }
          label132:
          for (localObject = ((c.b)localObject).hoQ;; localObject = null)
          {
            EGL14.eglDestroySurface((EGLDisplay)localObject, paramf.eBi());
            if (paramInt != 0) {
              break label137;
            }
            localg.Crz = null;
            AppMethodBeat.o(216115);
            return;
            localObject = null;
            break;
          }
          label137:
          localg.CrA = null;
          AppMethodBeat.o(216115);
          return;
        }
        ad.e("MicroMsg.PboSurfaceRender", "remove a null surface");
        AppMethodBeat.o(216115);
        return;
      }
      AppMethodBeat.o(216115);
      return;
    }
    ad.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(216115);
  }
  
  public final void eBc()
  {
    AppMethodBeat.i(216117);
    if (eBg())
    {
      m localm = this.CrN;
      if (localm != null)
      {
        localm.eBc();
        AppMethodBeat.o(216117);
        return;
      }
    }
    AppMethodBeat.o(216117);
  }
  
  public final void eBd()
  {
    AppMethodBeat.i(216116);
    if (eBg())
    {
      m localm = this.CrN;
      if (localm != null)
      {
        localm.eBd();
        AppMethodBeat.o(216116);
        return;
      }
    }
    AppMethodBeat.o(216116);
  }
  
  public final int eBe()
  {
    AppMethodBeat.i(216110);
    g localg = this.CrM;
    if (localg != null)
    {
      int i = localg.eBe();
      AppMethodBeat.o(216110);
      return i;
    }
    AppMethodBeat.o(216110);
    return 0;
  }
  
  public final void eBf()
  {
    AppMethodBeat.i(216112);
    Object localObject = this.CrN;
    if (localObject != null) {
      ((m)localObject).tL(true);
    }
    localObject = this.CrM;
    if (localObject != null)
    {
      ((g)localObject).i((a)new g.c((g)localObject));
      AppMethodBeat.o(216112);
      return;
    }
    AppMethodBeat.o(216112);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216119);
    Object localObject = this.CrM;
    ap localap;
    if (localObject != null)
    {
      ad.i("MicroMsg.PboSurfaceRender", "stop");
      localap = ((g)localObject).handler;
      if (localap != null) {
        localap.removeCallbacksAndMessages(null);
      }
      ((g)localObject).i((a)new g.l((g)localObject));
    }
    localObject = this.CrM;
    if (localObject != null)
    {
      ad.i("MicroMsg.PboSurfaceRender", "destroy");
      localap = ((g)localObject).handler;
      if (localap != null) {
        localap.removeCallbacksAndMessages(null);
      }
      ((g)localObject).Csa.clear();
      ((g)localObject).Csb.clear();
      ((g)localObject).i((a)new g.h((g)localObject));
    }
    localObject = this.CrN;
    if (localObject != null) {
      ((m)localObject).eBd();
    }
    localObject = this.CrN;
    if (localObject != null)
    {
      ((m)localObject).release();
      AppMethodBeat.o(216119);
      return;
    }
    AppMethodBeat.o(216119);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<g, z>
  {
    b(e parame, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b
  {
    c(e parame, y.e parame1)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class d
    extends q
    implements d.g.a.b<Long, z>
  {
    d(e parame, y.e parame1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.e
 * JD-Core Version:    0.7.0.1
 */