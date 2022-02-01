package com.tencent.mm.plugin.voip.video.render;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.v.d;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "", "()V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "", "getFaceBeautyType", "initLocalPboSurfaceRenderer", "width", "height", "isUseFaceBeauty", "release", "removeSurface", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mirror", "setLocalRenderOrientation", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setVoIPBeauty", "cmd", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "Companion", "plugin-voip_release"})
public final class d
{
  public static final d.a zyY;
  public f zyV;
  public k zyW;
  a zyX;
  
  static
  {
    AppMethodBeat.i(192407);
    zyY = new d.a((byte)0);
    AppMethodBeat.o(192407);
  }
  
  private final boolean dXM()
  {
    AppMethodBeat.i(192401);
    f localf = this.zyV;
    if ((localf == null) || (localf.dXK() != 0))
    {
      AppMethodBeat.o(192401);
      return true;
    }
    AppMethodBeat.o(192401);
    return false;
  }
  
  public final void A(d.g.a.a<y> parama)
  {
    Object localObject = this.zyW;
    if (localObject != null) {
      ((b)localObject).zyF = parama;
    }
    localObject = this.zyV;
    if (localObject != null) {
      ((f)localObject).zyF = parama;
    }
  }
  
  public final void QU(int paramInt)
  {
    AppMethodBeat.i(192396);
    f localf = this.zyV;
    if (localf != null)
    {
      localf.QU(paramInt);
      AppMethodBeat.o(192396);
      return;
    }
    AppMethodBeat.o(192396);
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192398);
    d.g.b.k.h(paramac, "size");
    f localf = this.zyV;
    if (localf != null)
    {
      k localk = this.zyW;
      if (localk != null)
      {
        localk.a(localf, paramac, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(192398);
        return;
      }
      AppMethodBeat.o(192398);
      return;
    }
    AppMethodBeat.o(192398);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(192405);
    Object localObject = this.zyW;
    if (localObject != null) {
      ((k)localObject).a(parame, paramInt);
    }
    localObject = this.zyV;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((f)localObject).zyK = parame;
        AppMethodBeat.o(192405);
        return;
      }
      ((f)localObject).zyL = parame;
      AppMethodBeat.o(192405);
      return;
    }
    AppMethodBeat.o(192405);
  }
  
  public final void b(e parame, int paramInt)
  {
    AppMethodBeat.i(192400);
    if (parame != null)
    {
      ad.m("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
      Object localObject = this.zyW;
      if (localObject != null) {
        ((k)localObject).b(parame, paramInt);
      }
      localObject = this.zyV;
      if (localObject != null)
      {
        if (parame != null)
        {
          ad.m("MicroMsg.PboSurfaceRender", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
          if (paramInt == 0)
          {
            ((f)localObject).zyK = parame;
            AppMethodBeat.o(192400);
            return;
          }
          ((f)localObject).zyL = parame;
          AppMethodBeat.o(192400);
          return;
        }
        ad.e("MicroMsg.PboSurfaceRender", "add a null surface");
        AppMethodBeat.o(192400);
        return;
      }
      AppMethodBeat.o(192400);
      return;
    }
    ad.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(192400);
  }
  
  public final void c(e parame, int paramInt)
  {
    AppMethodBeat.i(192402);
    if (parame != null)
    {
      Object localObject = this.zyW;
      if (localObject != null) {
        ((k)localObject).c(parame, paramInt);
      }
      f localf = this.zyV;
      if (localf != null)
      {
        if (parame != null)
        {
          ad.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(parame)));
          localObject = localf.gBJ;
          if (localObject != null)
          {
            localObject = ((c.b)localObject).gwm;
            if (localObject != null)
            {
              localObject = localf.gBJ;
              if (localObject == null) {
                break label117;
              }
            }
          }
          label117:
          for (localObject = ((c.b)localObject).gwm;; localObject = null)
          {
            EGL14.eglDestroySurface((EGLDisplay)localObject, parame.dXO());
            if (paramInt != 0) {
              break label122;
            }
            localf.zyK = null;
            AppMethodBeat.o(192402);
            return;
            localObject = null;
            break;
          }
          label122:
          localf.zyL = null;
          AppMethodBeat.o(192402);
          return;
        }
        ad.e("MicroMsg.PboSurfaceRender", "remove a null surface");
        AppMethodBeat.o(192402);
        return;
      }
      AppMethodBeat.o(192402);
      return;
    }
    ad.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(192402);
  }
  
  public final void dXI()
  {
    AppMethodBeat.i(192404);
    if (dXM())
    {
      k localk = this.zyW;
      if (localk != null)
      {
        localk.dXI();
        AppMethodBeat.o(192404);
        return;
      }
    }
    AppMethodBeat.o(192404);
  }
  
  public final void dXJ()
  {
    AppMethodBeat.i(192403);
    if (dXM())
    {
      k localk = this.zyW;
      if (localk != null)
      {
        localk.dXJ();
        AppMethodBeat.o(192403);
        return;
      }
    }
    AppMethodBeat.o(192403);
  }
  
  public final int dXK()
  {
    AppMethodBeat.i(192397);
    f localf = this.zyV;
    if (localf != null)
    {
      int i = localf.dXK();
      AppMethodBeat.o(192397);
      return i;
    }
    AppMethodBeat.o(192397);
    return 0;
  }
  
  public final void dXL()
  {
    AppMethodBeat.i(192399);
    Object localObject = this.zyW;
    if (localObject != null) {
      ((k)localObject).sa(true);
    }
    localObject = this.zyV;
    if (localObject != null)
    {
      ((f)localObject).i((d.g.a.a)new f.c((f)localObject));
      AppMethodBeat.o(192399);
      return;
    }
    AppMethodBeat.o(192399);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192406);
    Object localObject = this.zyV;
    ap localap;
    if (localObject != null)
    {
      ad.i("MicroMsg.PboSurfaceRender", "stop");
      localap = ((f)localObject).handler;
      if (localap != null) {
        localap.removeCallbacksAndMessages(null);
      }
      ((f)localObject).i((d.g.a.a)new f.l((f)localObject));
    }
    localObject = this.zyV;
    if (localObject != null)
    {
      ad.i("MicroMsg.PboSurfaceRender", "destroy");
      localap = ((f)localObject).handler;
      if (localap != null) {
        localap.removeCallbacksAndMessages(null);
      }
      ((f)localObject).zzJ.clear();
      ((f)localObject).zzK.clear();
      ((f)localObject).i((d.g.a.a)new f.h((f)localObject));
    }
    localObject = this.zyW;
    if (localObject != null) {
      ((k)localObject).dXJ();
    }
    localObject = this.zyW;
    if (localObject != null)
    {
      ((k)localObject).release();
      AppMethodBeat.o(192406);
      return;
    }
    AppMethodBeat.o(192406);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<f, y>
  {
    b(d paramd, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b
  {
    c(d paramd, v.d paramd1)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    d(d paramd, v.d paramd1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.d
 * JD-Core Version:    0.7.0.1
 */