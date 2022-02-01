package com.tencent.mm.plugin.voip.video.render;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.e;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "", "()V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "", "getFaceBeautyType", "initLocalPboSurfaceRenderer", "width", "height", "isUseFaceBeauty", "release", "removeSurface", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mirror", "setLocalRenderOrientation", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setVoIPBeauty", "cmd", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "Companion", "plugin-voip_release"})
public final class e
{
  public static final e.a CJt;
  public g CJq;
  public m CJr;
  b CJs;
  
  static
  {
    AppMethodBeat.i(210541);
    CJt = new e.a((byte)0);
    AppMethodBeat.o(210541);
  }
  
  private final boolean eEO()
  {
    AppMethodBeat.i(210535);
    g localg = this.CJq;
    if ((localg == null) || (localg.eEM() != 0))
    {
      AppMethodBeat.o(210535);
      return true;
    }
    AppMethodBeat.o(210535);
    return false;
  }
  
  public final void K(a<z> parama)
  {
    Object localObject = this.CJr;
    if (localObject != null) {
      ((c)localObject).CIY = parama;
    }
    localObject = this.CJq;
    if (localObject != null) {
      ((g)localObject).CIY = parama;
    }
  }
  
  public final void VD(int paramInt)
  {
    AppMethodBeat.i(210530);
    g localg = this.CJq;
    if (localg != null)
    {
      localg.VD(paramInt);
      AppMethodBeat.o(210530);
      return;
    }
    AppMethodBeat.o(210530);
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(210532);
    p.h(paramac, "size");
    g localg = this.CJq;
    if (localg != null)
    {
      m localm = this.CJr;
      if (localm != null)
      {
        localm.a(localg, paramac, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(210532);
        return;
      }
      AppMethodBeat.o(210532);
      return;
    }
    AppMethodBeat.o(210532);
  }
  
  public final void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(210539);
    Object localObject = this.CJr;
    if (localObject != null) {
      ((m)localObject).a(paramf, paramInt);
    }
    localObject = this.CJq;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((g)localObject).CJd = paramf;
        AppMethodBeat.o(210539);
        return;
      }
      ((g)localObject).CJe = paramf;
      AppMethodBeat.o(210539);
      return;
    }
    AppMethodBeat.o(210539);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(224121);
    if (eEO())
    {
      m localm = this.CJr;
      if (localm != null)
      {
        localm.b(paramf);
        AppMethodBeat.o(224121);
        return;
      }
    }
    AppMethodBeat.o(224121);
  }
  
  public final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(210534);
    if (paramf != null)
    {
      ae.m("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      Object localObject = this.CJr;
      if (localObject != null) {
        ((m)localObject).b(paramf, paramInt);
      }
      localObject = this.CJq;
      if (localObject != null)
      {
        if (paramf != null)
        {
          ae.m("MicroMsg.PboSurfaceRender", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
          if (paramInt == 0)
          {
            ((g)localObject).CJd = paramf;
            AppMethodBeat.o(210534);
            return;
          }
          ((g)localObject).CJe = paramf;
          AppMethodBeat.o(210534);
          return;
        }
        ae.e("MicroMsg.PboSurfaceRender", "add a null surface");
        AppMethodBeat.o(210534);
        return;
      }
      AppMethodBeat.o(210534);
      return;
    }
    ae.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(210534);
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(210536);
    if (paramf != null)
    {
      Object localObject = this.CJr;
      if (localObject != null) {
        ((m)localObject).c(paramf, paramInt);
      }
      g localg = this.CJq;
      if (localg != null)
      {
        if (paramf != null)
        {
          ae.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(paramf)));
          localObject = localg.hxc;
          if (localObject != null)
          {
            localObject = ((c.b)localObject).hrE;
            if ((localObject != null) && ((p.i(paramf.eEQ(), EGL14.EGL_NO_SURFACE) ^ true)))
            {
              localObject = localg.hxc;
              if (localObject == null) {
                break label132;
              }
            }
          }
          label132:
          for (localObject = ((c.b)localObject).hrE;; localObject = null)
          {
            EGL14.eglDestroySurface((EGLDisplay)localObject, paramf.eEQ());
            if (paramInt != 0) {
              break label137;
            }
            localg.CJd = null;
            AppMethodBeat.o(210536);
            return;
            localObject = null;
            break;
          }
          label137:
          localg.CJe = null;
          AppMethodBeat.o(210536);
          return;
        }
        ae.e("MicroMsg.PboSurfaceRender", "remove a null surface");
        AppMethodBeat.o(210536);
        return;
      }
      AppMethodBeat.o(210536);
      return;
    }
    ae.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(210536);
  }
  
  public final void eEK()
  {
    AppMethodBeat.i(210538);
    if (eEO())
    {
      m localm = this.CJr;
      if (localm != null)
      {
        localm.eEK();
        AppMethodBeat.o(210538);
        return;
      }
    }
    AppMethodBeat.o(210538);
  }
  
  public final int eEM()
  {
    AppMethodBeat.i(210531);
    g localg = this.CJq;
    if (localg != null)
    {
      int i = localg.eEM();
      AppMethodBeat.o(210531);
      return i;
    }
    AppMethodBeat.o(210531);
    return 0;
  }
  
  public final void eEN()
  {
    AppMethodBeat.i(210533);
    Object localObject = this.CJr;
    if (localObject != null) {
      ((m)localObject).tS(true);
    }
    localObject = this.CJq;
    if (localObject != null)
    {
      ((g)localObject).j((a)new g.c((g)localObject));
      AppMethodBeat.o(210533);
      return;
    }
    AppMethodBeat.o(210533);
  }
  
  public final void release()
  {
    AppMethodBeat.i(210540);
    Object localObject = this.CJq;
    aq localaq;
    if (localObject != null)
    {
      ae.i("MicroMsg.PboSurfaceRender", "stop");
      localaq = ((g)localObject).handler;
      if (localaq != null) {
        localaq.removeCallbacksAndMessages(null);
      }
      ((g)localObject).j((a)new g.l((g)localObject));
    }
    localObject = this.CJq;
    if (localObject != null)
    {
      ae.i("MicroMsg.PboSurfaceRender", "destroy");
      localaq = ((g)localObject).handler;
      if (localaq != null) {
        localaq.removeCallbacksAndMessages(null);
      }
      ((g)localObject).CJE.clear();
      ((g)localObject).CJF.clear();
      ((g)localObject).j((a)new g.h((g)localObject));
    }
    localObject = this.CJr;
    if (localObject != null) {
      c.h((c)localObject);
    }
    localObject = this.CJr;
    if (localObject != null)
    {
      ((m)localObject).release();
      AppMethodBeat.o(210540);
      return;
    }
    AppMethodBeat.o(210540);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<g, z>
  {
    b(e parame, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b
  {
    c(e parame, y.e parame1)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
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