package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.e;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "", "()V", "mCameraOrientation", "", "getMCameraOrientation", "()I", "setMCameraOrientation", "(I)V", "mIsMirror", "", "getMIsMirror", "()Z", "setMIsMirror", "(Z)V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRemoteWindowsSurfaceRenderer", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "createSurface", "glSurface", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getFaceBeautyType", "initLocalSurfaceRenderer", "pboSurfaceRender", "initPboSurfaceRenderer", "width", "height", "initRemoteSurfaceRenderer", "isUseFaceBeauty", "onCameraPreviewApply", "release", "removeSurface", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "setLocalRenderOrientation", "setLocalVideoSize", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameAvailableCallback", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setSTFilterMotionNoiseData", "motion", "noise", "", "setShowMode", "mode", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateLocalRenderSize", "renderSize", "updateRendererSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;)V", "Companion", "plugin-voip_release"})
public final class m
{
  public static final m.a Hpn;
  boolean HhF;
  public g Hpj;
  public n Hpk;
  public n Hpl;
  c Hpm;
  private int sUv;
  
  static
  {
    AppMethodBeat.i(236358);
    Hpn = new m.a((byte)0);
    AppMethodBeat.o(236358);
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(236344);
    p.h(paramac, "size");
    g localg = this.Hpj;
    if (localg != null)
    {
      n localn = this.Hpk;
      if (localn != null)
      {
        localn.a(localg, paramac, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(236344);
        return;
      }
      AppMethodBeat.o(236344);
      return;
    }
    AppMethodBeat.o(236344);
  }
  
  public final void a(ac paramac, Integer paramInteger)
  {
    AppMethodBeat.i(236356);
    p.h(paramac, "renderSize");
    n localn = this.Hpl;
    if (localn != null)
    {
      d.a(localn, paramac, paramInteger);
      AppMethodBeat.o(236356);
      return;
    }
    AppMethodBeat.o(236356);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(236350);
    if (fMe())
    {
      n localn = this.Hpk;
      if (localn != null) {
        localn.a(paramf);
      }
    }
    paramf = this.Hpl;
    if (paramf != null)
    {
      d.a(paramf);
      AppMethodBeat.o(236350);
      return;
    }
    AppMethodBeat.o(236350);
  }
  
  public final void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(236353);
    Object localObject = this.Hpk;
    if (localObject != null) {
      ((n)localObject).a(paramf, paramInt);
    }
    localObject = this.Hpj;
    if (localObject != null) {
      ((g)localObject).a(paramf, paramInt);
    }
    localObject = this.Hpl;
    if (localObject != null)
    {
      ((n)localObject).a(paramf, paramInt);
      AppMethodBeat.o(236353);
      return;
    }
    AppMethodBeat.o(236353);
  }
  
  public final void a(f paramf, b<? super f, x> paramb)
  {
    AppMethodBeat.i(236354);
    p.h(paramf, "glSurface");
    g localg = this.Hpj;
    if (localg != null)
    {
      localg.a(paramf, paramb);
      AppMethodBeat.o(236354);
      return;
    }
    AppMethodBeat.o(236354);
  }
  
  public final void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(236342);
    g localg = this.Hpj;
    if (localg != null)
    {
      localg.aF(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(236342);
      return;
    }
    AppMethodBeat.o(236342);
  }
  
  public final void ad(a<x> parama)
  {
    Object localObject = this.Hpk;
    if (localObject != null) {
      ((d)localObject).Hnc = parama;
    }
    localObject = this.Hpj;
    if (localObject != null) {
      ((g)localObject).Hnc = parama;
    }
    localObject = this.Hpl;
    if (localObject != null) {
      ((d)localObject).Hnc = parama;
    }
  }
  
  public final void aeb(int paramInt)
  {
    AppMethodBeat.i(236345);
    Object localObject;
    if (!this.HhF)
    {
      if ((paramInt == 180) || (paramInt == 0))
      {
        localObject = this.Hpk;
        if (localObject != null) {
          ((n)localObject).aeb(180);
        }
      }
      for (;;)
      {
        localObject = this.Hpk;
        if (localObject != null) {
          ((n)localObject).setMirror(true);
        }
        localObject = this.Hpj;
        if (localObject != null) {
          ((g)localObject).HhF = this.HhF;
        }
        localObject = this.Hpj;
        if (localObject == null) {
          break;
        }
        ((g)localObject).jN(paramInt, this.sUv);
        AppMethodBeat.o(236345);
        return;
        localObject = this.Hpk;
        if (localObject != null) {
          ((n)localObject).aeb((paramInt + 180) % 360);
        }
      }
    }
    if ((paramInt == 180) || (paramInt == 0))
    {
      localObject = this.Hpk;
      if (localObject != null) {
        ((n)localObject).aeb(0);
      }
    }
    for (;;)
    {
      localObject = this.Hpk;
      if (localObject == null) {
        break;
      }
      ((n)localObject).setMirror(false);
      break;
      localObject = this.Hpk;
      if (localObject != null) {
        ((n)localObject).aeb(paramInt % 360);
      }
    }
    AppMethodBeat.o(236345);
  }
  
  public final void aee(int paramInt)
  {
    this.sUv = paramInt;
    g localg = this.Hpj;
    if (localg != null) {
      localg.sUv = paramInt;
    }
  }
  
  public final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(236348);
    if (paramf != null)
    {
      Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      Object localObject = this.Hpk;
      if (localObject != null) {
        ((n)localObject).b(paramf, paramInt);
      }
      localObject = this.Hpj;
      if (localObject != null) {
        ((g)localObject).b(paramf, paramInt);
      }
      localObject = this.Hpl;
      if (localObject != null)
      {
        ((n)localObject).b(paramf, paramInt);
        AppMethodBeat.o(236348);
        return;
      }
      AppMethodBeat.o(236348);
      return;
    }
    Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(236348);
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(236349);
    if (paramf != null)
    {
      Object localObject = this.Hpk;
      if (localObject != null) {
        ((n)localObject).c(paramf, paramInt);
      }
      localObject = this.Hpj;
      if (localObject != null) {
        ((g)localObject).c(paramf, paramInt);
      }
      localObject = this.Hpl;
      if (localObject != null)
      {
        ((n)localObject).c(paramf, paramInt);
        AppMethodBeat.o(236349);
        return;
      }
      AppMethodBeat.o(236349);
      return;
    }
    Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(236349);
  }
  
  public final void fLR()
  {
    AppMethodBeat.i(236352);
    if (fMe())
    {
      localn = this.Hpk;
      if (localn != null) {
        localn.fLR();
      }
    }
    n localn = this.Hpl;
    if (localn != null)
    {
      localn.fLR();
      AppMethodBeat.o(236352);
      return;
    }
    AppMethodBeat.o(236352);
  }
  
  public final void fLT()
  {
    AppMethodBeat.i(236347);
    Object localObject = this.Hpk;
    if (localObject != null) {
      ((n)localObject).xA(true);
    }
    localObject = this.Hpj;
    if (localObject != null) {
      ((g)localObject).fLT();
    }
    localObject = this.Hpl;
    if (localObject != null)
    {
      ((n)localObject).xA(false);
      AppMethodBeat.o(236347);
      return;
    }
    AppMethodBeat.o(236347);
  }
  
  public final int fMd()
  {
    g localg = this.Hpj;
    if (localg != null) {
      return localg.HnF;
    }
    return 0;
  }
  
  final boolean fMe()
  {
    g localg = this.Hpj;
    return (localg == null) || (localg.HnF != 0);
  }
  
  public final void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(236346);
    g localg = this.Hpj;
    if (localg != null)
    {
      localg.h(paramr);
      AppMethodBeat.o(236346);
      return;
    }
    AppMethodBeat.o(236346);
  }
  
  public final void release()
  {
    AppMethodBeat.i(236357);
    Object localObject = this.Hpj;
    if (localObject != null) {
      ((g)localObject).stop();
    }
    localObject = this.Hpj;
    if (localObject != null) {
      ((g)localObject).destroy();
    }
    localObject = this.Hpk;
    if (localObject != null) {
      d.a((d)localObject);
    }
    localObject = this.Hpk;
    if (localObject != null) {
      ((n)localObject).release();
    }
    localObject = this.Hpl;
    if (localObject != null) {
      d.a((d)localObject);
    }
    localObject = this.Hpl;
    if (localObject != null)
    {
      ((n)localObject).release();
      AppMethodBeat.o(236357);
      return;
    }
    AppMethodBeat.o(236357);
  }
  
  public final void setShowMode(int paramInt)
  {
    AppMethodBeat.i(236355);
    n localn = this.Hpl;
    if (localn != null)
    {
      localn.setShowMode(paramInt);
      AppMethodBeat.o(236355);
      return;
    }
    AppMethodBeat.o(236355);
  }
  
  public final void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(236343);
    g localg = this.Hpj;
    if (localg != null)
    {
      localg.x(paramInt, paramFloat);
      AppMethodBeat.o(236343);
      return;
    }
    AppMethodBeat.o(236343);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends q
    implements b<g, x>
  {
    b(m paramm, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements b
  {
    c(m paramm, z.e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class d
    extends q
    implements b<Long, x>
  {
    d(m paramm, z.e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
  static final class e
    extends q
    implements b<d, x>
  {
    public static final e Hpq;
    
    static
    {
      AppMethodBeat.i(236339);
      Hpq = new e();
      AppMethodBeat.o(236339);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements b<Long, x>
  {
    f(m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class g
    extends q
    implements b<Long, x>
  {
    g(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.m
 * JD-Core Version:    0.7.0.1
 */