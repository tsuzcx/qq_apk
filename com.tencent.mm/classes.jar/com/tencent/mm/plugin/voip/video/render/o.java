package com.tencent.mm.plugin.voip.video.render;

import android.util.Size;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "", "()V", "mEncoderWindowSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/EncodeWindowSurfaceRenderer;", "mGLContextOpt", "", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRemoteWindowsSurfaceRenderer", "value", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mRenderEventListener", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "createSurface", "glSurface", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getFaceBeautyType", "initEncodeRenderSurface", "pboSurfaceRender", "initLocalSurfaceRenderer", "initPboSurfaceRenderer", "width", "height", "initRemoteSurfaceRenderer", "isUseFaceBeauty", "isUseSTFilter", "onCameraPreviewApply", "pauseRender", "recreateSurface", "refreshFrame", "release", "removeSurface", "setCameraPreviewSize", "size", "Landroid/util/Size;", "setLocalRenderOrientation", "rotateDegree", "mIsMirror", "encoderDegree", "setLocalVideoSize", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameAvailableCallback", "Lkotlin/Function3;", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setSTFilterMotionNoiseData", "motion", "noise", "", "setShowMode", "mode", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "setVoipFaceBeauty", "beauty", "setVoipSTFilter", "stFilter", "startRender", "stopEncoder", "stop", "stopRender", "switchCameraWithResumeSurface", "Landroid/graphics/SurfaceTexture;", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateLocalRenderSize", "renderSize", "updateRendererSize", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o.a UUr;
  e USr;
  public h UUs;
  public p UUt;
  public p UUu;
  public b UUv;
  public final boolean UUw;
  
  static
  {
    AppMethodBeat.i(293167);
    UUr = new o.a((byte)0);
    AppMethodBeat.o(293167);
  }
  
  public o()
  {
    AppMethodBeat.i(293120);
    this.UUw = com.tencent.mm.plugin.voip.f.h.ibx();
    AppMethodBeat.o(293120);
  }
  
  public final void Ha(boolean paramBoolean)
  {
    AppMethodBeat.i(293174);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.UUs;
      if (localObject != null) {
        ((h)localObject).USj = false;
      }
      localObject = this.UUv;
      if (localObject != null)
      {
        f.a((f)localObject);
        AppMethodBeat.o(293174);
      }
    }
    else
    {
      localObject = this.UUs;
      if (localObject != null) {
        ((h)localObject).USj = true;
      }
      localObject = this.UUv;
      if (localObject != null) {
        ((b)localObject).idi();
      }
    }
    AppMethodBeat.o(293174);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(293216);
    p localp = this.UUt;
    if (localp != null) {
      localp.a(paramg);
    }
    paramg = this.UUu;
    if (paramg != null) {
      f.a((f)paramg);
    }
    AppMethodBeat.o(293216);
  }
  
  public final void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(293223);
    p localp = this.UUt;
    if (localp != null) {
      localp.a(paramg, paramInt);
    }
    localp = this.UUu;
    if (localp != null) {
      localp.a(paramg, paramInt);
    }
    AppMethodBeat.o(293223);
  }
  
  public final void a(g paramg, kotlin.g.a.b<? super g, ah> paramb)
  {
    AppMethodBeat.i(293234);
    s.u(paramg, "glSurface");
    h localh = this.UUs;
    if (localh != null) {
      localh.a(paramg, paramb);
    }
    AppMethodBeat.o(293234);
  }
  
  public final void b(g paramg, int paramInt)
  {
    AppMethodBeat.i(293207);
    if (paramg != null)
    {
      Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramg, new Object[0]);
      p localp = this.UUt;
      if (localp != null) {
        localp.b(paramg, paramInt);
      }
      localp = this.UUu;
      if (localp != null)
      {
        localp.b(paramg, paramInt);
        AppMethodBeat.o(293207);
      }
    }
    else
    {
      Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
    }
    AppMethodBeat.o(293207);
  }
  
  public final boolean b(g paramg)
  {
    AppMethodBeat.i(293239);
    s.u(paramg, "glSurface");
    h localh = this.UUs;
    if (localh == null)
    {
      AppMethodBeat.o(293239);
      return false;
    }
    boolean bool = localh.b(paramg);
    AppMethodBeat.o(293239);
    return bool;
  }
  
  public final void bZ(kotlin.g.a.a<ah> parama)
  {
    Object localObject = this.UUt;
    if (localObject != null) {
      ((f)localObject).USg = parama;
    }
    localObject = this.UUs;
    if (localObject != null) {
      ((h)localObject).USg = parama;
    }
    localObject = this.UUu;
    if (localObject != null) {
      ((f)localObject).USg = parama;
    }
  }
  
  public final void bl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293182);
    Object localObject;
    if (!this.UUw)
    {
      localObject = this.UUv;
      if (localObject != null)
      {
        ((b)localObject).bl(paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(293182);
      }
    }
    else
    {
      localObject = this.UUs;
      if (localObject != null)
      {
        localObject = ((h)localObject).USM;
        if (localObject != null) {
          ((a)localObject).bl(paramInt1, paramInt2, paramInt3);
        }
      }
    }
    AppMethodBeat.o(293182);
  }
  
  public final void c(g paramg, int paramInt)
  {
    AppMethodBeat.i(293211);
    if (paramg != null)
    {
      p localp = this.UUt;
      if (localp != null) {
        localp.c(paramg, paramInt);
      }
      localp = this.UUu;
      if (localp != null)
      {
        localp.c(paramg, paramInt);
        AppMethodBeat.o(293211);
      }
    }
    else
    {
      Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
    }
    AppMethodBeat.o(293211);
  }
  
  public final void i(Size paramSize)
  {
    AppMethodBeat.i(293251);
    s.u(paramSize, "renderSize");
    p localp = this.UUu;
    if (localp != null) {
      localp.i(paramSize);
    }
    AppMethodBeat.o(293251);
  }
  
  public final int idG()
  {
    h localh = this.UUs;
    if (localh == null) {
      return 0;
    }
    return localh.USN;
  }
  
  public final void idH()
  {
    AppMethodBeat.i(293202);
    p localp = this.UUt;
    if (localp != null) {
      localp.GW(true);
    }
    localp = this.UUu;
    if (localp != null) {
      localp.GW(false);
    }
    AppMethodBeat.o(293202);
  }
  
  public final void idi()
  {
    AppMethodBeat.i(293220);
    Object localObject = this.UUt;
    if (localObject != null) {
      ((p)localObject).idi();
    }
    localObject = this.UUu;
    if (localObject != null) {
      ((p)localObject).idi();
    }
    if (!this.UUw)
    {
      localObject = this.UUv;
      if (localObject != null) {
        ((b)localObject).idi();
      }
    }
    AppMethodBeat.o(293220);
  }
  
  public final void k(Size paramSize)
  {
    AppMethodBeat.i(293192);
    s.u(paramSize, "size");
    h localh = this.UUs;
    if (localh != null)
    {
      localh.j(paramSize);
      Object localObject = this.UUt;
      if (localObject != null) {
        ((p)localObject).i(paramSize);
      }
      localObject = this.UUv;
      if (localObject != null) {
        ((b)localObject).i(paramSize);
      }
      localObject = this.UUs;
      if (localObject != null)
      {
        localObject = ((h)localObject).USM;
        if (localObject != null) {
          ((a)localObject).i(paramSize);
        }
      }
      paramSize = this.UUt;
      if (paramSize != null) {
        paramSize.b(localh.idp());
      }
    }
    AppMethodBeat.o(293192);
  }
  
  public final void q(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(293198);
    Object localObject = this.UUt;
    if (localObject != null) {
      ((p)localObject).aru(paramInt1);
    }
    localObject = this.UUt;
    if (localObject != null) {
      ((p)localObject).setMirror(paramBoolean);
    }
    localObject = this.UUs;
    if (localObject != null)
    {
      localObject = ((h)localObject).USF;
      if (localObject != null) {
        ((m)localObject).akjo = paramInt1;
      }
    }
    if (this.UUw)
    {
      localObject = this.UUs;
      if (localObject != null)
      {
        localObject = ((h)localObject).USM;
        if (localObject != null) {
          ((a)localObject).idf();
        }
      }
      localObject = this.UUs;
      if (localObject != null)
      {
        localObject = ((h)localObject).USM;
        if (localObject != null) {
          ((a)localObject).aru(paramInt2);
        }
      }
    }
    for (;;)
    {
      localObject = this.UUu;
      if (localObject != null) {
        ((p)localObject).aru(90);
      }
      AppMethodBeat.o(293198);
      return;
      localObject = this.UUv;
      if (localObject != null) {
        ((b)localObject).setMirror(true);
      }
      localObject = this.UUv;
      if (localObject != null) {
        ((b)localObject).aru(paramInt2);
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(293255);
    h localh = this.UUs;
    if (localh != null) {
      localh.K((kotlin.g.a.a)new j(this));
    }
    AppMethodBeat.o(293255);
  }
  
  public final void setShowMode(int paramInt)
  {
    AppMethodBeat.i(293244);
    p localp = this.UUu;
    if (localp != null) {
      localp.setShowMode(paramInt);
    }
    AppMethodBeat.o(293244);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<h, ah>
  {
    b(o paramo, kotlin.g.a.b<? super h, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    d(o paramo, ah.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer$initEncodeRenderSurface$1", "Lcom/tencent/mm/plugin/voip/model/AvcEncoder$onEncoderSurfaceReady;", "onEncoderSurfaceReady", "", "encoderSurface", "Landroid/view/Surface;", "w", "", "h", "onEncoderSurfaceRelease", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e.a
  {
    e(o paramo) {}
    
    public final void f(Surface paramSurface, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(293187);
      s.u(paramSurface, "encoderSurface");
      Log.i("MicroMsg.LocalWindowsSurfaceRenderer", "onEncoderSurfaceReady:" + paramSurface.hashCode() + ", size:[" + paramInt1 + ',' + paramInt2 + ']');
      if (paramSurface.isValid())
      {
        paramSurface = new g(paramSurface, paramInt1, paramInt2, (byte)0);
        if (this.UUx.b(paramSurface))
        {
          Object localObject = this.UUx.UUs;
          if (localObject != null)
          {
            localObject = ((h)localObject).USM;
            if (localObject != null)
            {
              s.u(paramSurface, "surface");
              ((a)localObject).URC = paramSurface;
            }
          }
        }
      }
      AppMethodBeat.o(293187);
    }
    
    public final void u(Surface paramSurface)
    {
      g localg = null;
      AppMethodBeat.i(293191);
      s.u(paramSurface, "encoderSurface");
      Log.i("MicroMsg.LocalWindowsSurfaceRenderer", s.X("onEncoderSurfaceRelease:", Integer.valueOf(paramSurface.hashCode())));
      Object localObject = this.UUx.UUs;
      if (localObject == null) {}
      while (localg == null)
      {
        AppMethodBeat.o(293191);
        return;
        localObject = ((h)localObject).USM;
        if (localObject != null) {
          localg = ((a)localObject).URC;
        }
      }
      localObject = localg.USz;
      if (localObject == null)
      {
        AppMethodBeat.o(293191);
        return;
      }
      if (s.p(localObject, paramSurface))
      {
        paramSurface = this.UUx.UUs;
        if (paramSurface != null) {
          h.a(paramSurface, localg);
        }
      }
      AppMethodBeat.o(293191);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer$initEncodeRenderSurface$2$1", "Lcom/tencent/mm/plugin/voip/model/AvcEncoder$onEncoderSurfaceReady;", "onEncoderSurfaceReady", "", "encoderSurface", "Landroid/view/Surface;", "w", "", "h", "onEncoderSurfaceRelease", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements e.a
  {
    f(o paramo) {}
    
    public final void f(Surface paramSurface, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(293190);
      s.u(paramSurface, "encoderSurface");
      Log.i("MicroMsg.LocalWindowsSurfaceRenderer", "onEncoderSurfaceReady:" + paramSurface.hashCode() + ", size:[" + paramInt1 + ',' + paramInt2 + ']');
      if (paramSurface.isValid())
      {
        paramSurface = new g(paramSurface, paramInt1, paramInt2, (byte)0);
        if (this.UUx.b(paramSurface))
        {
          b localb = o.f(this.UUx);
          if (localb != null)
          {
            s.u(paramSurface, "surface");
            localb.URC = paramSurface;
          }
        }
      }
      AppMethodBeat.o(293190);
    }
    
    public final void u(Surface paramSurface)
    {
      AppMethodBeat.i(293197);
      s.u(paramSurface, "encoderSurface");
      Log.i("MicroMsg.LocalWindowsSurfaceRenderer", s.X("onEncoderSurfaceRelease:", Integer.valueOf(paramSurface.hashCode())));
      Object localObject1 = o.f(this.UUx);
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((f)localObject1).URC)
      {
        AppMethodBeat.o(293197);
        return;
      }
      Object localObject2 = ((g)localObject1).USz;
      if (localObject2 == null)
      {
        AppMethodBeat.o(293197);
        return;
      }
      if (s.p(localObject2, paramSurface))
      {
        paramSurface = this.UUx.UUs;
        if (paramSurface != null) {
          h.a(paramSurface, (g)localObject1);
        }
      }
      AppMethodBeat.o(293197);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<f, ah>
  {
    public static final g UUz;
    
    static
    {
      AppMethodBeat.i(293173);
      UUz = new g();
      AppMethodBeat.o(293173);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    h(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    i(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.o
 * JD-Core Version:    0.7.0.1
 */