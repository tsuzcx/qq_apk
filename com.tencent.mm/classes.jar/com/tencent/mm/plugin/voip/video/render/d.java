package com.tencent.mm.plugin.voip.video.render;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.v.e;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "", "()V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "", "getFaceBeautyType", "initLocalPboSurfaceRenderer", "width", "height", "isUseFaceBeauty", "release", "removeSurface", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mirror", "setLocalRenderOrientation", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setVoIPBeauty", "cmd", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "Companion", "plugin-voip_release"})
public final class d
{
  public static final d.a ARP;
  public f ARM;
  public k ARN;
  a ARO;
  
  static
  {
    AppMethodBeat.i(208758);
    ARP = new d.a((byte)0);
    AppMethodBeat.o(208758);
  }
  
  private final boolean eni()
  {
    AppMethodBeat.i(208752);
    f localf = this.ARM;
    if ((localf == null) || (localf.eng() != 0))
    {
      AppMethodBeat.o(208752);
      return true;
    }
    AppMethodBeat.o(208752);
    return false;
  }
  
  public final void G(d.g.a.a<y> parama)
  {
    Object localObject = this.ARN;
    if (localObject != null) {
      ((b)localObject).ARw = parama;
    }
    localObject = this.ARM;
    if (localObject != null) {
      ((f)localObject).ARw = parama;
    }
  }
  
  public final void Td(int paramInt)
  {
    AppMethodBeat.i(208747);
    f localf = this.ARM;
    if (localf != null)
    {
      localf.Td(paramInt);
      AppMethodBeat.o(208747);
      return;
    }
    AppMethodBeat.o(208747);
  }
  
  public final void a(com.tencent.mm.compatible.deviceinfo.ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(208749);
    d.g.b.k.h(paramac, "size");
    f localf = this.ARM;
    if (localf != null)
    {
      k localk = this.ARN;
      if (localk != null)
      {
        localk.a(localf, paramac, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(208749);
        return;
      }
      AppMethodBeat.o(208749);
      return;
    }
    AppMethodBeat.o(208749);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(208756);
    Object localObject = this.ARN;
    if (localObject != null) {
      ((k)localObject).a(parame, paramInt);
    }
    localObject = this.ARM;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((f)localObject).ARB = parame;
        AppMethodBeat.o(208756);
        return;
      }
      ((f)localObject).ARC = parame;
      AppMethodBeat.o(208756);
      return;
    }
    AppMethodBeat.o(208756);
  }
  
  public final void b(e parame, int paramInt)
  {
    AppMethodBeat.i(208751);
    if (parame != null)
    {
      com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
      Object localObject = this.ARN;
      if (localObject != null) {
        ((k)localObject).b(parame, paramInt);
      }
      localObject = this.ARM;
      if (localObject != null)
      {
        if (parame != null)
        {
          com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.PboSurfaceRender", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
          if (paramInt == 0)
          {
            ((f)localObject).ARB = parame;
            AppMethodBeat.o(208751);
            return;
          }
          ((f)localObject).ARC = parame;
          AppMethodBeat.o(208751);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.PboSurfaceRender", "add a null surface");
        AppMethodBeat.o(208751);
        return;
      }
      AppMethodBeat.o(208751);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(208751);
  }
  
  public final void c(e parame, int paramInt)
  {
    AppMethodBeat.i(208753);
    if (parame != null)
    {
      Object localObject = this.ARN;
      if (localObject != null) {
        ((k)localObject).c(parame, paramInt);
      }
      f localf = this.ARM;
      if (localf != null)
      {
        if (parame != null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(parame)));
          localObject = localf.hcg;
          if (localObject != null)
          {
            localObject = ((c.b)localObject).gWK;
            if ((localObject != null) && ((d.g.b.k.g(parame.enk(), EGL14.EGL_NO_SURFACE) ^ true)))
            {
              localObject = localf.hcg;
              if (localObject == null) {
                break label132;
              }
            }
          }
          label132:
          for (localObject = ((c.b)localObject).gWK;; localObject = null)
          {
            EGL14.eglDestroySurface((EGLDisplay)localObject, parame.enk());
            if (paramInt != 0) {
              break label137;
            }
            localf.ARB = null;
            AppMethodBeat.o(208753);
            return;
            localObject = null;
            break;
          }
          label137:
          localf.ARC = null;
          AppMethodBeat.o(208753);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.PboSurfaceRender", "remove a null surface");
        AppMethodBeat.o(208753);
        return;
      }
      AppMethodBeat.o(208753);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(208753);
  }
  
  public final void ene()
  {
    AppMethodBeat.i(208755);
    if (eni())
    {
      k localk = this.ARN;
      if (localk != null)
      {
        localk.ene();
        AppMethodBeat.o(208755);
        return;
      }
    }
    AppMethodBeat.o(208755);
  }
  
  public final void enf()
  {
    AppMethodBeat.i(208754);
    if (eni())
    {
      k localk = this.ARN;
      if (localk != null)
      {
        localk.enf();
        AppMethodBeat.o(208754);
        return;
      }
    }
    AppMethodBeat.o(208754);
  }
  
  public final int eng()
  {
    AppMethodBeat.i(208748);
    f localf = this.ARM;
    if (localf != null)
    {
      int i = localf.eng();
      AppMethodBeat.o(208748);
      return i;
    }
    AppMethodBeat.o(208748);
    return 0;
  }
  
  public final void enh()
  {
    AppMethodBeat.i(208750);
    Object localObject = this.ARN;
    if (localObject != null) {
      ((k)localObject).tb(true);
    }
    localObject = this.ARM;
    if (localObject != null)
    {
      ((f)localObject).i((d.g.a.a)new f.c((f)localObject));
      AppMethodBeat.o(208750);
      return;
    }
    AppMethodBeat.o(208750);
  }
  
  public final void release()
  {
    AppMethodBeat.i(208757);
    Object localObject = this.ARM;
    ao localao;
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PboSurfaceRender", "stop");
      localao = ((f)localObject).handler;
      if (localao != null) {
        localao.removeCallbacksAndMessages(null);
      }
      ((f)localObject).i((d.g.a.a)new f.l((f)localObject));
    }
    localObject = this.ARM;
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PboSurfaceRender", "destroy");
      localao = ((f)localObject).handler;
      if (localao != null) {
        localao.removeCallbacksAndMessages(null);
      }
      ((f)localObject).ASa.clear();
      ((f)localObject).ASb.clear();
      ((f)localObject).i((d.g.a.a)new f.h((f)localObject));
    }
    localObject = this.ARN;
    if (localObject != null) {
      ((k)localObject).enf();
    }
    localObject = this.ARN;
    if (localObject != null)
    {
      ((k)localObject).release();
      AppMethodBeat.o(208757);
      return;
    }
    AppMethodBeat.o(208757);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<f, y>
  {
    b(d paramd, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b
  {
    c(d paramd, v.e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    d(d paramd, v.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.d
 * JD-Core Version:    0.7.0.1
 */