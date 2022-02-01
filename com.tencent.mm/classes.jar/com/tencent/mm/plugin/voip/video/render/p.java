package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.aa.e;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "", "()V", "mCameraOrientation", "", "getMCameraOrientation", "()I", "setMCameraOrientation", "(I)V", "mIsMirror", "", "getMIsMirror", "()Z", "setMIsMirror", "(Z)V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRemoteWindowsSurfaceRenderer", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "createSurface", "glSurface", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getFaceBeautyType", "initLocalSurfaceRenderer", "pboSurfaceRender", "initPboSurfaceRenderer", "width", "height", "initRemoteSurfaceRenderer", "isUseFaceBeauty", "onCameraPreviewApply", "release", "removeSurface", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "setLocalRenderOrientation", "setLocalVideoSize", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameAvailableCallback", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setSTFilterMotionNoiseData", "motion", "noise", "", "setShowMode", "mode", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateLocalRenderSize", "renderSize", "updateRendererSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;)V", "Companion", "plugin-voip_release"})
public final class p
{
  public static final a Ogf;
  boolean NYu;
  public h Oga;
  public q Ogb;
  public q Ogc;
  d Oge;
  int wAs;
  
  static
  {
    AppMethodBeat.i(239899);
    Ogf = new a((byte)0);
    AppMethodBeat.o(239899);
  }
  
  public final void a(ad paramad, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239869);
    kotlin.g.b.p.k(paramad, "size");
    h localh = this.Oga;
    if (localh != null)
    {
      q localq = this.Ogb;
      if (localq != null)
      {
        localq.a(localh, paramad, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(239869);
        return;
      }
      AppMethodBeat.o(239869);
      return;
    }
    AppMethodBeat.o(239869);
  }
  
  public final void a(ad paramad, Integer paramInteger)
  {
    AppMethodBeat.i(239890);
    kotlin.g.b.p.k(paramad, "renderSize");
    q localq = this.Ogc;
    if (localq != null)
    {
      e.a(localq, paramad, paramInteger);
      AppMethodBeat.o(239890);
      return;
    }
    AppMethodBeat.o(239890);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(239879);
    q localq = this.Ogb;
    if (localq != null) {
      localq.a(paramg);
    }
    paramg = this.Ogc;
    if (paramg != null)
    {
      e.a(paramg);
      AppMethodBeat.o(239879);
      return;
    }
    AppMethodBeat.o(239879);
  }
  
  public final void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(239884);
    q localq = this.Ogb;
    if (localq != null) {
      localq.a(paramg, paramInt);
    }
    localq = this.Ogc;
    if (localq != null)
    {
      localq.a(paramg, paramInt);
      AppMethodBeat.o(239884);
      return;
    }
    AppMethodBeat.o(239884);
  }
  
  public final void a(g paramg, b<? super g, x> paramb)
  {
    AppMethodBeat.i(239885);
    kotlin.g.b.p.k(paramg, "glSurface");
    h localh = this.Oga;
    if (localh != null)
    {
      localh.a(paramg, paramb);
      AppMethodBeat.o(239885);
      return;
    }
    AppMethodBeat.o(239885);
  }
  
  public final void aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(239864);
    h localh = this.Oga;
    if (localh != null)
    {
      localh.aJ(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(239864);
      return;
    }
    AppMethodBeat.o(239864);
  }
  
  public final void alO(int paramInt)
  {
    AppMethodBeat.i(239870);
    Object localObject;
    if (!this.NYu)
    {
      if ((paramInt == 180) || (paramInt == 0))
      {
        localObject = this.Ogb;
        if (localObject != null) {
          ((q)localObject).alO(180);
        }
      }
      for (;;)
      {
        localObject = this.Ogb;
        if (localObject != null) {
          ((q)localObject).setMirror(true);
        }
        localObject = this.Oga;
        if (localObject != null) {
          ((h)localObject).NYu = this.NYu;
        }
        localObject = this.Oga;
        if (localObject == null) {
          break;
        }
        ((h)localObject).lc(paramInt, this.wAs);
        AppMethodBeat.o(239870);
        return;
        localObject = this.Ogb;
        if (localObject != null) {
          ((q)localObject).alO((paramInt + 180) % 360);
        }
      }
    }
    if ((paramInt == 180) || (paramInt == 0))
    {
      localObject = this.Ogb;
      if (localObject != null) {
        ((q)localObject).alO(0);
      }
    }
    for (;;)
    {
      localObject = this.Ogb;
      if (localObject == null) {
        break;
      }
      ((q)localObject).setMirror(false);
      break;
      localObject = this.Ogb;
      if (localObject != null) {
        ((q)localObject).alO(paramInt % 360);
      }
    }
    AppMethodBeat.o(239870);
  }
  
  public final void am(a<x> parama)
  {
    Object localObject = this.Ogb;
    if (localObject != null) {
      ((e)localObject).Oea = parama;
    }
    localObject = this.Oga;
    if (localObject != null) {
      ((h)localObject).Oea = parama;
    }
    localObject = this.Ogc;
    if (localObject != null) {
      ((e)localObject).Oea = parama;
    }
  }
  
  public final void b(g paramg, int paramInt)
  {
    AppMethodBeat.i(239874);
    if (paramg != null)
    {
      Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramg, new Object[0]);
      q localq = this.Ogb;
      if (localq != null) {
        localq.b(paramg, paramInt);
      }
      localq = this.Ogc;
      if (localq != null)
      {
        localq.b(paramg, paramInt);
        AppMethodBeat.o(239874);
        return;
      }
      AppMethodBeat.o(239874);
      return;
    }
    Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    AppMethodBeat.o(239874);
  }
  
  public final void c(g paramg, int paramInt)
  {
    AppMethodBeat.i(239876);
    if (paramg != null)
    {
      q localq = this.Ogb;
      if (localq != null) {
        localq.c(paramg, paramInt);
      }
      localq = this.Ogc;
      if (localq != null)
      {
        localq.c(paramg, paramInt);
        AppMethodBeat.o(239876);
        return;
      }
      AppMethodBeat.o(239876);
      return;
    }
    Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    AppMethodBeat.o(239876);
  }
  
  public final int gEF()
  {
    h localh = this.Oga;
    if (localh != null) {
      return localh.OeC;
    }
    return 0;
  }
  
  public final void gEG()
  {
    AppMethodBeat.i(239872);
    q localq = this.Ogb;
    if (localq != null) {
      localq.Bt(true);
    }
    localq = this.Ogc;
    if (localq != null)
    {
      localq.Bt(false);
      AppMethodBeat.o(239872);
      return;
    }
    AppMethodBeat.o(239872);
  }
  
  public final void gEs()
  {
    AppMethodBeat.i(239883);
    q localq = this.Ogb;
    if (localq != null) {
      localq.gEs();
    }
    localq = this.Ogc;
    if (localq != null)
    {
      localq.gEs();
      AppMethodBeat.o(239883);
      return;
    }
    AppMethodBeat.o(239883);
  }
  
  public final void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(293178);
    h localh = this.Oga;
    if (localh != null)
    {
      localh.h(paramr);
      AppMethodBeat.o(293178);
      return;
    }
    AppMethodBeat.o(293178);
  }
  
  public final void release()
  {
    AppMethodBeat.i(239894);
    h localh = this.Oga;
    if (localh != null)
    {
      localh.j((a)new i(this));
      AppMethodBeat.o(239894);
      return;
    }
    AppMethodBeat.o(239894);
  }
  
  public final void setShowMode(int paramInt)
  {
    AppMethodBeat.i(239887);
    q localq = this.Ogc;
    if (localq != null)
    {
      localq.setShowMode(paramInt);
      AppMethodBeat.o(239887);
      return;
    }
    AppMethodBeat.o(239887);
  }
  
  public final void y(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(239866);
    h localh = this.Oga;
    if (localh != null)
    {
      localh.y(paramInt, paramFloat);
      AppMethodBeat.o(239866);
      return;
    }
    AppMethodBeat.o(239866);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<h, x>
  {
    b(p paramp, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class d
    extends kotlin.g.b.q
    implements b<Long, x>
  {
    d(p paramp, aa.e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<e, x>
  {
    public static final f Ogj;
    
    static
    {
      AppMethodBeat.i(236125);
      Ogj = new f();
      AppMethodBeat.o(236125);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements b<Long, x>
  {
    g(p paramp)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "(J)Lkotlin/Unit;"})
  static final class h
    extends kotlin.g.b.q
    implements b<Long, x>
  {
    h(p paramp)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements a<x>
  {
    i(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.p
 * JD-Core Version:    0.7.0.1
 */