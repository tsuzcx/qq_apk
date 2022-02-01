package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.i.a;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.e;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "decMode", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "Ljava/nio/ByteBuffer;", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastHWDecH", "mLastHWDecW", "mLocalIsMirror", "mLocalRotateAngle", "mLocalWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "mPauseTransVideo", "mRemoteWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mUseLastBeautyCnt", "newCaptureRender", "Lcom/tencent/mm/plugin/voip/video/NewCaptureRender;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "initLocalRendererEnvironment", "initRemoteRendererEnvironment", "isLocalUseFaceBeauty", "onHWDecModeSet", "isSmallViewShowSelf", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", "setHWDecMode", "mode", "setLocalRenderOrientation", "setRemoteVideoData", "outData", "", "setVoipBeauty", "cmd", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class j
{
  public static final j.a CsB;
  boolean BYH;
  public boolean BYR;
  public boolean BYX;
  public int BYY;
  private int BZE;
  public int BZj;
  private int BZu;
  private int BZv;
  private byte[] CcS;
  private ByteBuffer CcT;
  private int CcU;
  public boolean CcV;
  private com.tencent.mm.plugin.voip.b.a CcY;
  ap CcZ;
  public boolean Cik;
  public int Cio;
  b CsA;
  public com.tencent.mm.plugin.voip.video.h Csm;
  private boolean Csn;
  public boolean Cso;
  public e Csp;
  public m Csq;
  private com.tencent.mm.plugin.voip.video.b.a Csr;
  private boolean Css;
  private final int Cst;
  public boolean Csu;
  private i Csv;
  private int Csw;
  private int Csx;
  private int Csy;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> Csz;
  public boolean mIsStarted;
  long vPj;
  
  static
  {
    AppMethodBeat.i(216189);
    CsB = new j.a((byte)0);
    AppMethodBeat.o(216189);
  }
  
  public j(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(216188);
    this.CsA = paramb;
    this.BYH = paramBoolean;
    this.CcV = true;
    this.mIsStarted = true;
    this.Csr = new com.tencent.mm.plugin.voip.video.b.a();
    paramb = com.tencent.mm.plugin.voip.b.h.Cls;
    if (com.tencent.mm.plugin.voip.b.h.ezH())
    {
      i = 33;
      this.Cst = i;
      this.CcZ = new ap("encodeVoipHandler");
      this.CcY = new com.tencent.mm.plugin.voip.b.a();
      paramb = this.CcY;
      if ((this.Cio & 0x1) == 0) {
        break label654;
      }
    }
    label654:
    for (int i = 1;; i = 0)
    {
      paramb.T(true, i);
      this.CcY.ezl();
      i = 320;
      int j = 240;
      if (v2protocal.Cfa)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.Cfb)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      paramb = com.tencent.mm.plugin.voip.b.i.ClE;
      long l1 = i;
      long l2 = j;
      paramb = k.ClI;
      k.BT(l1);
      paramb = k.ClI;
      k.BU(l2);
      paramb = new ac(j, i);
      this.Csp = new e();
      Object localObject1 = this.Csp;
      if (localObject1 != null)
      {
        ((e)localObject1).CrM = new g(paramb.width, paramb.height);
        ((e)localObject1).CrN = new m(true);
      }
      paramb = this.Csp;
      if (paramb != null) {
        paramb.UW(this.BZj);
      }
      paramb = this.Csp;
      if (paramb != null)
      {
        d.g.a.b localb = (d.g.a.b)new k(this);
        localObject1 = new y.e();
        ((y.e)localObject1).MLU = -1L;
        Object localObject2 = paramb.CrM;
        if (localObject2 != null)
        {
          localb = (d.g.a.b)new e.b(paramb, localb);
          if ((((g)localObject2).huo != null) || (((g)localObject2).CrX)) {
            localb.invoke(localObject2);
          }
          ((g)localObject2).i((d.g.a.a)new g.b((g)localObject2, localb));
        }
        localObject2 = paramb.CrM;
        if (localObject2 != null) {
          ((g)localObject2).Crv = ((d.g.a.b)new e.c(paramb, (y.e)localObject1));
        }
        localObject2 = paramb.CrN;
        if (localObject2 != null) {
          ((c)localObject2).Crv = ((d.g.a.b)new e.d(paramb, (y.e)localObject1));
        }
        paramb = paramb.CrM;
        if (paramb != null)
        {
          ad.i("MicroMsg.PboSurfaceRender", "start");
          paramb.i((d.g.a.a)new g.k(paramb));
        }
      }
      paramb = this.Csp;
      if (paramb != null) {
        paramb.CrO = this.CsA;
      }
      this.Csq = new m(false);
      paramb = this.Csq;
      if (paramb != null) {
        c.a(paramb, (d.g.a.b)l.CsN, null, 2);
      }
      paramb = this.Csq;
      if (paramb != null) {
        paramb.eBc();
      }
      paramb = this.Csq;
      if (paramb != null) {
        paramb.Crv = ((d.g.a.b)new m(this));
      }
      paramb = this.Csq;
      if (paramb != null) {
        paramb.Crw = ((d.g.a.b)new n(this));
      }
      paramb = i.Csj;
      i.reset();
      paramb = d.Clj;
      d.clear();
      this.Csv = new i(this);
      AppMethodBeat.o(216188);
      return;
      paramb = com.tencent.mm.plugin.voip.b.h.Cls;
      if (com.tencent.mm.plugin.voip.b.h.ezG())
      {
        i = 39;
        break;
      }
      i = 4;
      break;
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(216180);
    int i;
    if (this.Csm != null)
    {
      com.tencent.mm.plugin.voip.video.h localh = this.Csm;
      if ((localh == null) || (localh.a((com.tencent.mm.plugin.voip.video.f)this.Csv, paramBoolean) != 1)) {
        break label241;
      }
      paramBoolean = true;
      this.CcV = paramBoolean;
      if (this.CcV)
      {
        localh = this.Csm;
        if (localh != null) {
          localh.o(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.euM();
        localh = this.Csm;
        if (localh == null) {
          break label246;
        }
        i = localh.eAo();
        label96:
        paramSurfaceTexture.Um(i);
        ad.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.Csm);
        if (this.Csm != null)
        {
          paramSurfaceTexture = this.Csm;
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.eAr();
          }
          this.BZE = 0;
          this.Csn = true;
          paramSurfaceTexture = this.Csm;
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
          paramSurfaceTexture = paramSurfaceTexture.eAs();
          p.g(paramSurfaceTexture, "newCaptureRender!!.previewSize");
          localh = this.Csm;
          if (localh == null) {
            p.gfZ();
          }
          i = localh.eAt();
          localh = this.Csm;
          if (localh == null) {
            p.gfZ();
          }
          if (localh.eAu()) {
            break label251;
          }
        }
      }
    }
    label241:
    label246:
    label251:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(paramSurfaceTexture, i, paramBoolean);
      AppMethodBeat.o(216180);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void eBk()
  {
    AppMethodBeat.i(216179);
    ad.l("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.Csm != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.h localh = this.Csm;
      if (localh != null) {
        localh.eAl();
      }
      localh = this.Csm;
      if (localh != null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.Csm = null;
    AppMethodBeat.o(216179);
  }
  
  private void tl(boolean paramBoolean)
  {
    AppMethodBeat.i(216181);
    if (!this.Csn)
    {
      ad.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = 320;
      int j = 240;
      if (v2protocal.Cfa)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.Cfb)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      if (this.Csm == null) {
        this.Csm = new com.tencent.mm.plugin.voip.video.h(i, j);
      }
    }
    AppMethodBeat.o(216181);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a UX(final int paramInt)
  {
    AppMethodBeat.i(216186);
    if (this.Csz == null)
    {
      this.Csz = ((r)new j(this, paramInt));
      Object localObject2 = this.Csp;
      if (localObject2 != null)
      {
        localObject1 = this.Csz;
        localObject2 = ((e)localObject2).CrM;
        if ((localObject2 != null) && (localObject1 != null) && (!((g)localObject2).Csa.contains(localObject1))) {
          ((g)localObject2).Csa.add(localObject1);
        }
      }
    }
    Object localObject1 = this.Csr;
    AppMethodBeat.o(216186);
    return localObject1;
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216183);
    e locale = this.Csp;
    if (locale != null)
    {
      locale.a(paramac, paramInt, paramBoolean);
      AppMethodBeat.o(216183);
      return;
    }
    AppMethodBeat.o(216183);
  }
  
  public final void d(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(216178);
    tl(paramBoolean);
    paramg = paramg.surfaceTexture;
    if (paramg == null) {
      p.gfZ();
    }
    b(paramg, paramBoolean);
    AppMethodBeat.o(216178);
  }
  
  public final void eBl()
  {
    AppMethodBeat.i(216182);
    Object localObject;
    if ((ae.gcE.fYe == 1) && (this.Csp != null))
    {
      localObject = this.Csp;
      if (localObject == null) {
        p.gfZ();
      }
      if (((e)localObject).CrM != null)
      {
        localObject = this.Csp;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((e)localObject).CrM;
        if (localObject == null) {
          p.gfZ();
        }
        d((g)localObject, true);
      }
    }
    if ((!this.CcV) || (ae.gcE.fYe == 1) || (ae.gcE.fYf == 1)) {
      if (this.Csm != null)
      {
        localObject = this.Csm;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.h)localObject).eAm();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.Csp != null)
      {
        localObject = this.Csp;
        if (localObject == null) {
          p.gfZ();
        }
        if (((e)localObject).CrM != null)
        {
          localObject = this.Csp;
          if (localObject == null) {
            p.gfZ();
          }
          localObject = ((e)localObject).CrM;
          if (localObject == null) {
            p.gfZ();
          }
          d((g)localObject, bool);
        }
      }
      this.CcV = true;
      AppMethodBeat.o(216182);
      return;
      bool = true;
      break;
    }
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216185);
    ad.m("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(216185);
      return;
    }
    if (this.Css)
    {
      AppMethodBeat.o(216185);
      return;
    }
    this.BZu = paramInt2;
    this.BZv = paramInt1;
    if ((this.mIsStarted) && (this.Csq != null))
    {
      this.Css = true;
      m localm = this.Csq;
      if (localm != null)
      {
        c.a(localm, new ac(paramInt2, paramInt1), Integer.valueOf(270));
        AppMethodBeat.o(216185);
        return;
      }
    }
    AppMethodBeat.o(216185);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216187);
    Object localObject = i.Csj;
    i.report();
    localObject = d.Clj;
    d.clear();
    localObject = this.CcZ;
    if (localObject != null) {
      ((ap)localObject).removeCallbacksAndMessages(null);
    }
    this.CcZ = null;
    eBk();
    localObject = this.Csp;
    if (localObject != null) {
      ((e)localObject).release();
    }
    localObject = this.Csq;
    if (localObject != null) {
      ((m)localObject).eBd();
    }
    localObject = this.Csq;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.CcY;
    if ((this.Cio & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).T(true, i);
      this.CcY.ezm();
      this.CcS = null;
      this.CcU = 0;
      AppMethodBeat.o(216187);
      return;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(216184);
    ad.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Cio) });
    if (this.Cio != paramInt)
    {
      this.Cio = paramInt;
      localObject = this.CcY;
      if ((this.Cio & 0x1) == 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).T(true, paramInt);
      this.CcY.ezl();
      if ((this.Cio & 0x1) == 0) {
        break label120;
      }
      localObject = this.Csq;
      if (localObject == null) {
        break;
      }
      ((m)localObject).UT(1);
      AppMethodBeat.o(216184);
      return;
    }
    AppMethodBeat.o(216184);
    return;
    label120:
    Object localObject = this.Csq;
    if (localObject != null)
    {
      ((m)localObject).UT(0);
      AppMethodBeat.o(216184);
      return;
    }
    AppMethodBeat.o(216184);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void UY(int paramInt);
    
    public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
    
    public abstract void ay(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void eBm();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements d.g.a.a<z>
  {
    public d(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$3", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class e
    implements j.b
  {
    private f CsD;
    
    public final void UY(int paramInt)
    {
      AppMethodBeat.i(216161);
      Object localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).c(this.CsD, paramInt);
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).c(this.CsD, paramInt);
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBd();
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).eBd();
      }
      this.CsD = null;
      AppMethodBeat.o(216161);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216160);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.CsD = paramSurface;
          paramSurface = j.c(this.CsC);
          if (paramSurface != null) {
            paramSurface.b(this.CsD, paramInt);
          }
          paramSurface = j.d(this.CsC);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.CsD, paramInt);
          AppMethodBeat.o(216160);
          return;
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
        }
      }
      AppMethodBeat.o(216160);
    }
    
    public final void ay(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(216162);
      Object localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).a(this.CsD, paramInt3);
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).a(this.CsD, paramInt3);
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBc();
      }
      localObject = j.d(this.CsC);
      if (localObject != null)
      {
        ((m)localObject).eBc();
        AppMethodBeat.o(216162);
        return;
      }
      AppMethodBeat.o(216162);
    }
    
    public final void eBm()
    {
      AppMethodBeat.i(216159);
      Object localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBf();
      }
      localObject = j.d(this.CsC);
      if (localObject != null)
      {
        ((m)localObject).tL(false);
        AppMethodBeat.o(216159);
        return;
      }
      AppMethodBeat.o(216159);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class f
    extends q
    implements d.g.a.a<z>
  {
    public f(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class g
    extends q
    implements d.g.a.a<z>
  {
    public g(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$6", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class h
    implements j.b
  {
    private f CsD;
    
    public final void UY(int paramInt)
    {
      AppMethodBeat.i(216167);
      Object localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).c(this.CsD, paramInt);
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).c(this.CsD, paramInt);
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBd();
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).eBd();
      }
      this.CsD = null;
      AppMethodBeat.o(216167);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216166);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.CsD = paramSurface;
          paramSurface = j.c(this.CsC);
          if (paramSurface != null) {
            paramSurface.b(this.CsD, paramInt);
          }
          paramSurface = j.d(this.CsC);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.CsD, paramInt);
          AppMethodBeat.o(216166);
          return;
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
        }
      }
      AppMethodBeat.o(216166);
    }
    
    public final void ay(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(216168);
      Object localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.CsD;
      if (localObject != null)
      {
        localObject = ((f)localObject).CrT;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).a(this.CsD, paramInt3);
      }
      localObject = j.d(this.CsC);
      if (localObject != null) {
        ((m)localObject).a(this.CsD, paramInt3);
      }
      localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBc();
      }
      localObject = j.d(this.CsC);
      if (localObject != null)
      {
        ((m)localObject).eBc();
        AppMethodBeat.o(216168);
        return;
      }
      AppMethodBeat.o(216168);
    }
    
    public final void eBm()
    {
      AppMethodBeat.i(216165);
      Object localObject = j.c(this.CsC);
      if (localObject != null) {
        ((e)localObject).eBf();
      }
      localObject = j.d(this.CsC);
      if (localObject != null)
      {
        ((m)localObject).tL(false);
        AppMethodBeat.o(216165);
        return;
      }
      AppMethodBeat.o(216165);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/ICaptureRenderListener;", "onCameraError", "", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "plugin-voip_release"})
  public static final class i
    implements com.tencent.mm.plugin.voip.video.f
  {
    public final void a(final byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(216170);
      if (this.CsC.BYR)
      {
        AppMethodBeat.o(216170);
        return;
      }
      if (this.CsC.Csm == null)
      {
        ad.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady, captureRender is null!");
        AppMethodBeat.o(216170);
        return;
      }
      Object localObject1 = this.CsC.Csm;
      int k;
      int m;
      label100:
      final y.d locald1;
      final int j;
      label126:
      final int i;
      label142:
      final y.d locald2;
      label189:
      Object localObject2;
      label249:
      int n;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.voip.video.h)localObject1).eAm() == true))
      {
        k = OpenGlRender.FLAG_Mirror;
        localObject1 = this.CsC.Csm;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject1).eAn() != true)) {
          break label426;
        }
        m = OpenGlRender.FLAG_Angle270;
        localObject1 = null;
        locald1 = null;
        if ((OpenGlRender.getGLVersion() != 2) || (j.f(this.CsC) == 0)) {
          break label434;
        }
        j = 1;
        if ((j.f(this.CsC) & 0x8) == 0) {
          break label440;
        }
        i = 1;
        locald2 = new y.d();
        locald2.MLT = 0;
        if (j == 0) {
          break label531;
        }
        if ((i != 0) || (this.CsC.UX(2) == null)) {
          break label446;
        }
        i = 1;
        j.a(this.CsC, 0);
        localObject2 = this.CsC.Csm;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject2).eAm() != true) || (j == 0) || (i == 0)) {
          break label846;
        }
        if (i != 1) {
          break label555;
        }
        localObject2 = this.CsC.UX(2);
        if (localObject2 == null) {
          break label537;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hHi;
        if (paramArrayOfByte == null) {
          break label1114;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hHi;
        locald2.MLT = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
        switch (locald2.MLT)
        {
        default: 
          paramInt3 = j.i(this.CsC);
          label305:
          if (paramArrayOfByte == null) {
            p.gfZ();
          }
          paramLong = paramArrayOfByte.capacity();
          paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
          n = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
          j.a(this.CsC, paramArrayOfByte);
          j = paramInt3;
          paramInt3 = n;
        }
      }
      for (;;)
      {
        j.d(this.CsC, paramInt3);
        j.c(this.CsC, paramInt4);
        j.b(this.CsC, locald2.MLT);
        n = j;
        j = paramInt3;
        paramInt3 = n;
        for (;;)
        {
          if ((localObject1 != null) || (paramArrayOfByte != null)) {
            break label873;
          }
          ad.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
          paramArrayOfByte = com.tencent.mm.plugin.voip.b.i.ClE;
          i.a.UJ(0);
          AppMethodBeat.o(216170);
          return;
          k = 0;
          break;
          label426:
          m = OpenGlRender.FLAG_Angle90;
          break label100;
          label434:
          j = 0;
          break label126;
          label440:
          i = 0;
          break label142;
          label446:
          if ((i != 0) && (this.CsC.UX(1) != null))
          {
            i = 2;
            j.a(this.CsC, 0);
            break label189;
          }
          if ((j.h(this.CsC) != null) && (j.g(this.CsC) <= 10))
          {
            i = 3;
            localObject2 = this.CsC;
            j.a((j)localObject2, j.g((j)localObject2) + 1);
            break label189;
          }
          j = 0;
          i = 0;
          break label189;
          label531:
          i = 0;
          break label189;
          label537:
          paramArrayOfByte = null;
          break label249;
          paramInt3 = 10;
          break label305;
          paramInt3 = 1;
          break label305;
          label555:
          if (i == 2)
          {
            localObject2 = this.CsC.UX(1);
            if (localObject2 != null)
            {
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hHi;
              label582:
              if (paramArrayOfByte == null) {
                break label1114;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hHi;
              locald2.MLT = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
              switch (locald2.MLT)
              {
              default: 
                paramInt3 = j.i(this.CsC);
              }
            }
            for (;;)
            {
              if (paramArrayOfByte == null) {
                p.gfZ();
              }
              paramLong = paramArrayOfByte.capacity();
              j = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
              paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
              j.a(this.CsC, paramArrayOfByte);
              n = paramInt3;
              paramInt3 = paramInt4;
              paramInt4 = j;
              j = n;
              break;
              paramArrayOfByte = null;
              break label582;
              paramInt3 = 10;
              continue;
              paramInt3 = 1;
            }
          }
          if ((i != 3) || (j.h(this.CsC) == null)) {
            break label1114;
          }
          paramArrayOfByte = j.j(this.CsC);
          switch (j.k(this.CsC))
          {
          default: 
            paramInt3 = j.i(this.CsC);
          }
          for (;;)
          {
            p.gfZ();
            paramLong = null.length;
            n = j.l(this.CsC);
            paramInt4 = j.m(this.CsC);
            locald2.MLT = j.k(this.CsC);
            j.a(this.CsC, paramArrayOfByte);
            j = paramInt3;
            paramInt3 = paramInt4;
            paramInt4 = n;
            break;
            paramInt3 = 10;
            continue;
            paramInt3 = 1;
          }
          label846:
          paramInt3 += paramInt4;
          j = paramInt2;
          paramInt4 = paramInt1;
          locald1 = null;
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = locald1;
        }
        label873:
        ad.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + paramInt4 + "vh=" + j + ", bm=" + i);
        locald1 = new y.d();
        locald1.MLT = 0;
        i = (int)paramLong;
        localObject2 = this.CsC.CcZ;
        if (localObject2 != null) {
          ((ap)localObject2).post((Runnable)new a(this, paramArrayOfByte, locald1, i, paramInt3, paramInt4, j, locald2, (byte[])localObject1));
        }
        this.CsC.CsA.av(locald1.MLT, paramInt1, paramInt2);
        j.a(this.CsC, (byte[])localObject1, paramInt1, paramInt2);
        paramArrayOfByte = this.CsC;
        j.e(paramArrayOfByte, j.n(paramArrayOfByte) + 1);
        paramArrayOfByte = this.CsC;
        boolean bool;
        if (k == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          paramArrayOfByte.BYX = bool;
          paramArrayOfByte = this.CsC;
          if (m != OpenGlRender.FLAG_Angle270) {
            break label1107;
          }
        }
        label1107:
        for (paramInt1 = 270;; paramInt1 = 90)
        {
          paramArrayOfByte.BYY = paramInt1;
          AppMethodBeat.o(216170);
          return;
          bool = false;
          break;
        }
        label1114:
        n = paramInt2;
        j = paramInt1;
        int i1 = paramInt3 + paramInt4;
        paramInt3 = n;
        paramInt4 = j;
        paramArrayOfByte = locald1;
        j = i1;
      }
    }
    
    public final void bZW()
    {
      AppMethodBeat.i(216171);
      this.CsC.CsA.evh();
      AppMethodBeat.o(216171);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.i parami, ByteBuffer paramByteBuffer, y.d paramd1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, y.d paramd2, byte[] paramArrayOfByte) {}
      
      public final void run()
      {
        AppMethodBeat.i(216169);
        if (paramArrayOfByte != null)
        {
          ad.i("MicroMsg.VoIPRenderMgr", "encode tick " + bt.aO(this.CsE.CsC.vPj));
          this.CsE.CsC.vPj = bt.HI();
          locald1.MLT = com.tencent.mm.plugin.voip.c.euM().c(paramArrayOfByte, i, paramInt3, paramInt4, j, locald2.MLT);
          AppMethodBeat.o(216169);
          return;
        }
        if (this.CsL != null)
        {
          y.d locald = locald1;
          u localu = com.tencent.mm.plugin.voip.c.euM();
          byte[] arrayOfByte = this.CsL;
          int i = i;
          int j = paramInt3;
          int k = paramInt4;
          int m = j;
          new Point(0, 0);
          locald.MLT = localu.c(arrayOfByte, i, j, k, m);
        }
        AppMethodBeat.o(216169);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class j
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, z>
  {
    j(j paramj, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<g, z>
  {
    k(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<c, z>
  {
    public static final l CsN;
    
    static
    {
      AppMethodBeat.i(216175);
      CsN = new l();
      AppMethodBeat.o(216175);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<Long, z>
  {
    m(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<Long, z>
  {
    n(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.j
 * JD-Core Version:    0.7.0.1
 */