package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.b.f.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.q;
import d.g.b.v.d;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "decMode", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastHWDecH", "mLastHWDecW", "mLocalIsMirror", "mLocalRotateAngle", "mLocalWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "mPauseTransVideo", "mRemoteWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mUseLastBeautyCnt", "newCaptureRender", "Lcom/tencent/mm/plugin/voip/video/NewCaptureRender;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "initLocalRendererEnvironment", "initRemoteRendererEnvironment", "isLocalUseFaceBeauty", "onHWDecModeSet", "isSmallViewShowSelf", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", "setHWDecMode", "mode", "setLocalRenderOrientation", "setRemoteVideoData", "outData", "", "setVoipBeauty", "cmd", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class h
{
  public static final h.a zAe;
  public boolean mIsStarted;
  private int zAa;
  private int zAb;
  private q<? super ByteBuffer, ? super Integer, ? super Integer, y> zAc;
  a zAd;
  boolean zgY;
  public int zhA;
  private int zhL;
  private int zhM;
  private int zhV;
  public boolean zhi;
  public boolean zho;
  public int zhp;
  private byte[] zli;
  private int zlj;
  public boolean zlk;
  private com.tencent.mm.plugin.voip.b.a zln;
  ap zlo;
  public boolean zqu;
  public int zqz;
  public com.tencent.mm.plugin.voip.video.h zzR;
  private boolean zzS;
  public boolean zzT;
  public d zzU;
  public k zzV;
  private com.tencent.mm.plugin.voip.video.b.a zzW;
  private boolean zzX;
  public boolean zzY;
  private i zzZ;
  
  static
  {
    AppMethodBeat.i(192474);
    zAe = new h.a((byte)0);
    AppMethodBeat.o(192474);
  }
  
  public h(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(192473);
    this.zAd = parama;
    this.zgY = paramBoolean;
    this.zlk = true;
    this.mIsStarted = true;
    this.zzW = new com.tencent.mm.plugin.voip.video.b.a(0, 0, null, -1);
    this.zlo = new ap("encodeVoipHandler");
    this.zln = new com.tencent.mm.plugin.voip.b.a();
    parama = this.zln;
    if ((this.zqz & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      parama.Q(true, i);
      this.zln.dWp();
      i = 320;
      int j = 240;
      if (v2protocal.znm)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.znn)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      parama = com.tencent.mm.plugin.voip.b.f.ztz;
      long l1 = i;
      long l2 = j;
      parama = com.tencent.mm.plugin.voip.b.h.ztD;
      com.tencent.mm.plugin.voip.b.h.uJ(l1);
      parama = com.tencent.mm.plugin.voip.b.h.ztD;
      com.tencent.mm.plugin.voip.b.h.uK(l2);
      parama = new ac(j, i);
      this.zzU = new d();
      Object localObject1 = this.zzU;
      if (localObject1 != null)
      {
        ((d)localObject1).zyV = new f(parama.width, parama.height);
        ((d)localObject1).zyW = new k(true);
      }
      parama = this.zzU;
      if (parama != null) {
        parama.QU(this.zhA);
      }
      parama = this.zzU;
      if (parama != null)
      {
        d.g.a.b localb = (d.g.a.b)new k(this);
        localObject1 = new v.d();
        ((v.d)localObject1).Jhv = -1L;
        Object localObject2 = parama.zyV;
        if (localObject2 != null)
        {
          localb = (d.g.a.b)new d.b(parama, localb);
          if ((((f)localObject2).gBJ != null) || (((f)localObject2).zzG)) {
            localb.aA(localObject2);
          }
          ((f)localObject2).i((d.g.a.a)new f.b((f)localObject2, localb));
        }
        localObject2 = parama.zyV;
        if (localObject2 != null) {
          ((f)localObject2).zyG = ((d.g.a.b)new d.c(parama, (v.d)localObject1));
        }
        localObject2 = parama.zyW;
        if (localObject2 != null) {
          ((b)localObject2).zyG = ((d.g.a.b)new d.d(parama, (v.d)localObject1));
        }
        parama = parama.zyV;
        if (parama != null)
        {
          ad.i("MicroMsg.PboSurfaceRender", "start");
          parama.i((d.g.a.a)new f.k(parama));
        }
      }
      parama = this.zzU;
      if (parama != null) {
        parama.zyX = this.zAd;
      }
      this.zzV = new k(false);
      parama = this.zzV;
      if (parama != null) {
        b.a(parama, (d.g.a.b)l.zAn, null, 2);
      }
      parama = this.zzV;
      if (parama != null) {
        parama.dXI();
      }
      parama = this.zzV;
      if (parama != null) {
        parama.zyG = ((d.g.a.b)new m(this));
      }
      parama = this.zzV;
      if (parama != null) {
        parama.zyH = ((d.g.a.b)new n(this));
      }
      this.zzZ = new i(this);
      AppMethodBeat.o(192473);
      return;
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(192465);
    int i;
    if (this.zzR != null)
    {
      com.tencent.mm.plugin.voip.video.h localh = this.zzR;
      if ((localh == null) || (localh.a((com.tencent.mm.plugin.voip.video.f)this.zzZ, paramBoolean) != 1)) {
        break label241;
      }
      paramBoolean = true;
      this.zlk = paramBoolean;
      if (this.zlk)
      {
        localh = this.zzR;
        if (localh != null) {
          localh.o(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.dRQ();
        localh = this.zzR;
        if (localh == null) {
          break label246;
        }
        i = localh.dWY();
        label96:
        paramSurfaceTexture.Ql(i);
        ad.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.zzR);
        if (this.zzR != null)
        {
          paramSurfaceTexture = this.zzR;
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.dXb();
          }
          this.zhV = 0;
          this.zzS = true;
          paramSurfaceTexture = this.zzR;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fvU();
          }
          paramSurfaceTexture = paramSurfaceTexture.dXc();
          d.g.b.k.g(paramSurfaceTexture, "newCaptureRender!!.previewSize");
          localh = this.zzR;
          if (localh == null) {
            d.g.b.k.fvU();
          }
          i = localh.dXd();
          localh = this.zzR;
          if (localh == null) {
            d.g.b.k.fvU();
          }
          if (localh.dXe()) {
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
      AppMethodBeat.o(192465);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void dXP()
  {
    AppMethodBeat.i(192464);
    ad.l("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.zzR != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.h localh = this.zzR;
      if (localh != null) {
        localh.dWV();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.zzR = null;
    AppMethodBeat.o(192464);
  }
  
  private void rB(boolean paramBoolean)
  {
    AppMethodBeat.i(192466);
    if (!this.zzS)
    {
      ad.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = 320;
      int j = 240;
      if (v2protocal.znm)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.znn)
      {
        ad.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      if (this.zzR == null) {
        this.zzR = new com.tencent.mm.plugin.voip.video.h(i, j);
      }
    }
    AppMethodBeat.o(192466);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a QV(final int paramInt)
  {
    AppMethodBeat.i(192471);
    if (this.zAc == null)
    {
      this.zAc = ((q)new j(this, paramInt));
      Object localObject2 = this.zzU;
      if (localObject2 != null)
      {
        localObject1 = this.zAc;
        localObject2 = ((d)localObject2).zyV;
        if ((localObject2 != null) && (localObject1 != null) && (!((f)localObject2).zzJ.contains(localObject1))) {
          ((f)localObject2).zzJ.add(localObject1);
        }
      }
    }
    Object localObject1 = this.zzW;
    AppMethodBeat.o(192471);
    return localObject1;
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192468);
    d locald = this.zzU;
    if (locald != null)
    {
      locald.a(paramac, paramInt, paramBoolean);
      AppMethodBeat.o(192468);
      return;
    }
    AppMethodBeat.o(192468);
  }
  
  public final void c(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(192463);
    rB(paramBoolean);
    paramf = paramf.surfaceTexture;
    if (paramf == null) {
      d.g.b.k.fvU();
    }
    b(paramf, paramBoolean);
    AppMethodBeat.o(192463);
  }
  
  public final void dXQ()
  {
    AppMethodBeat.i(192467);
    Object localObject;
    if ((ae.fFw.fAY == 1) && (this.zzU != null))
    {
      localObject = this.zzU;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (((d)localObject).zyV != null)
      {
        localObject = this.zzU;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localObject = ((d)localObject).zyV;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        c((f)localObject, true);
      }
    }
    if ((!this.zlk) || (ae.fFw.fAY == 1) || (ae.fFw.fAZ == 1)) {
      if (this.zzR != null)
      {
        localObject = this.zzR;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.h)localObject).dWW();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.zzU != null)
      {
        localObject = this.zzU;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if (((d)localObject).zyV != null)
        {
          localObject = this.zzU;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          localObject = ((d)localObject).zyV;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          c((f)localObject, bool);
        }
      }
      this.zlk = true;
      AppMethodBeat.o(192467);
      return;
      bool = true;
      break;
    }
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192470);
    ad.m("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(192470);
      return;
    }
    if (this.zzX)
    {
      AppMethodBeat.o(192470);
      return;
    }
    this.zhL = paramInt2;
    this.zhM = paramInt1;
    if ((this.mIsStarted) && (this.zzV != null))
    {
      this.zzX = true;
      k localk = this.zzV;
      if (localk != null)
      {
        b.a(localk, new ac(paramInt2, paramInt1), Integer.valueOf(270));
        AppMethodBeat.o(192470);
        return;
      }
    }
    AppMethodBeat.o(192470);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192472);
    Object localObject = this.zlo;
    if (localObject != null) {
      ((ap)localObject).removeCallbacksAndMessages(null);
    }
    this.zlo = null;
    dXP();
    localObject = this.zzU;
    if (localObject != null) {
      ((d)localObject).release();
    }
    localObject = this.zzV;
    if (localObject != null) {
      ((k)localObject).dXJ();
    }
    localObject = this.zzV;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = this.zln;
    if ((this.zqz & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).Q(true, i);
      this.zln.dWq();
      this.zli = null;
      this.zlj = 0;
      AppMethodBeat.o(192472);
      return;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(192469);
    ad.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zqz) });
    if (this.zqz != paramInt)
    {
      this.zqz = paramInt;
      localObject = this.zln;
      if ((this.zqz & 0x1) == 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).Q(true, paramInt);
      this.zln.dWp();
      if ((this.zqz & 0x1) == 0) {
        break label120;
      }
      localObject = this.zzV;
      if (localObject == null) {
        break;
      }
      ((k)localObject).QR(1);
      AppMethodBeat.o(192469);
      return;
    }
    AppMethodBeat.o(192469);
    return;
    label120:
    Object localObject = this.zzV;
    if (localObject != null)
    {
      ((k)localObject).QR(0);
      AppMethodBeat.o(192469);
      return;
    }
    AppMethodBeat.o(192469);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public d(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$3", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class e
    implements h.b
  {
    private e zAg;
    
    public final void QW(int paramInt)
    {
      AppMethodBeat.i(192446);
      Object localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).c(this.zAg, paramInt);
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).c(this.zAg, paramInt);
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXJ();
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).dXJ();
      }
      this.zAg = null;
      AppMethodBeat.o(192446);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192445);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new e(paramSurface, (byte)0);; paramSurface = new e(paramSurfaceTexture, (byte)0))
        {
          this.zAg = paramSurface;
          paramSurface = h.c(this.zAf);
          if (paramSurface != null) {
            paramSurface.b(this.zAg, paramInt);
          }
          paramSurface = h.d(this.zAf);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.zAg, paramInt);
          AppMethodBeat.o(192445);
          return;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fvU();
          }
        }
      }
      AppMethodBeat.o(192445);
    }
    
    public final void av(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(192447);
      Object localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).x = 0;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).y = 0;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).width = paramInt1;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).height = paramInt2;
        }
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).a(this.zAg, paramInt3);
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).a(this.zAg, paramInt3);
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXI();
      }
      localObject = h.d(this.zAf);
      if (localObject != null)
      {
        ((k)localObject).dXI();
        AppMethodBeat.o(192447);
        return;
      }
      AppMethodBeat.o(192447);
    }
    
    public final void dXR()
    {
      AppMethodBeat.i(192444);
      Object localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXL();
      }
      localObject = h.d(this.zAf);
      if (localObject != null)
      {
        ((k)localObject).sa(false);
        AppMethodBeat.o(192444);
        return;
      }
      AppMethodBeat.o(192444);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public f(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public g(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$6", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class h
    implements h.b
  {
    private e zAg;
    
    public final void QW(int paramInt)
    {
      AppMethodBeat.i(192452);
      Object localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).c(this.zAg, paramInt);
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).c(this.zAg, paramInt);
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXJ();
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).dXJ();
      }
      this.zAg = null;
      AppMethodBeat.o(192452);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192451);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new e(paramSurface, (byte)0);; paramSurface = new e(paramSurfaceTexture, (byte)0))
        {
          this.zAg = paramSurface;
          paramSurface = h.c(this.zAf);
          if (paramSurface != null) {
            paramSurface.b(this.zAg, paramInt);
          }
          paramSurface = h.d(this.zAf);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.zAg, paramInt);
          AppMethodBeat.o(192451);
          return;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fvU();
          }
        }
      }
      AppMethodBeat.o(192451);
    }
    
    public final void av(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(192453);
      Object localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).x = 0;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).y = 0;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).width = paramInt1;
        }
      }
      localObject = this.zAg;
      if (localObject != null)
      {
        localObject = ((e)localObject).zzC;
        if (localObject != null) {
          ((e.b)localObject).height = paramInt2;
        }
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).a(this.zAg, paramInt3);
      }
      localObject = h.d(this.zAf);
      if (localObject != null) {
        ((k)localObject).a(this.zAg, paramInt3);
      }
      localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXI();
      }
      localObject = h.d(this.zAf);
      if (localObject != null)
      {
        ((k)localObject).dXI();
        AppMethodBeat.o(192453);
        return;
      }
      AppMethodBeat.o(192453);
    }
    
    public final void dXR()
    {
      AppMethodBeat.i(192450);
      Object localObject = h.c(this.zAf);
      if (localObject != null) {
        ((d)localObject).dXL();
      }
      localObject = h.d(this.zAf);
      if (localObject != null)
      {
        ((k)localObject).sa(false);
        AppMethodBeat.o(192450);
        return;
      }
      AppMethodBeat.o(192450);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/ICaptureRenderListener;", "onCameraError", "", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "plugin-voip_release"})
  public static final class i
    implements com.tencent.mm.plugin.voip.video.f
  {
    public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(192455);
      if (this.zAf.zhi)
      {
        AppMethodBeat.o(192455);
        return;
      }
      if (this.zAf.zzR == null)
      {
        ad.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady, captureRender is null!");
        AppMethodBeat.o(192455);
        return;
      }
      Object localObject = this.zAf.zzR;
      int k;
      int m;
      label100:
      final int j;
      label120:
      final int i;
      if ((localObject != null) && (((com.tencent.mm.plugin.voip.video.h)localObject).dWW() == true))
      {
        k = OpenGlRender.FLAG_Mirror;
        localObject = this.zAf.zzR;
        if ((localObject == null) || (((com.tencent.mm.plugin.voip.video.h)localObject).dWX() != true)) {
          break label339;
        }
        m = OpenGlRender.FLAG_Angle270;
        if ((OpenGlRender.getGLVersion() != 2) || (h.f(this.zAf) == 0)) {
          break label347;
        }
        j = 1;
        if ((h.f(this.zAf) & 0x8) == 0) {
          break label353;
        }
        i = 1;
        label136:
        if (j == 0) {
          break label444;
        }
        if ((i != 0) || (this.zAf.QV(2) == null)) {
          break label359;
        }
        h.a(this.zAf, 0);
        i = 1;
        label168:
        localObject = this.zAf.zzR;
        if ((localObject == null) || (((com.tencent.mm.plugin.voip.video.h)localObject).dWW() != true) || (j == 0) || (i == 0)) {
          break label603;
        }
        if (i != 1) {
          break label455;
        }
        localObject = this.zAf.QV(2);
        if (localObject == null) {
          break label450;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject).zxj;
        label228:
        if (paramArrayOfByte == null) {
          break label834;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject).zxj;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramLong = paramArrayOfByte.length;
        paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
        paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
        h.a(this.zAf, paramArrayOfByte);
        j = 4;
      }
      for (;;)
      {
        label274:
        h.c(this.zAf, paramInt4);
        h.b(this.zAf, paramInt3);
        int n = j;
        j = paramInt4;
        paramInt4 = paramInt3;
        paramInt3 = n;
        for (;;)
        {
          if (paramArrayOfByte != null) {
            break label621;
          }
          ad.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
          paramArrayOfByte = com.tencent.mm.plugin.voip.b.f.ztz;
          f.a.QH(0);
          AppMethodBeat.o(192455);
          return;
          k = 0;
          break;
          label339:
          m = OpenGlRender.FLAG_Angle90;
          break label100;
          label347:
          j = 0;
          break label120;
          label353:
          i = 0;
          break label136;
          label359:
          if ((i != 0) && (this.zAf.QV(1) != null))
          {
            h.a(this.zAf, 0);
            i = 2;
            break label168;
          }
          if ((h.h(this.zAf) != null) && (h.g(this.zAf) <= 10))
          {
            localObject = this.zAf;
            h.a((h)localObject, h.g((h)localObject) + 1);
            i = 3;
            break label168;
          }
          j = 0;
          i = 0;
          break label168;
          label444:
          i = 0;
          break label168;
          label450:
          paramArrayOfByte = null;
          break label228;
          label455:
          if (i == 2)
          {
            localObject = this.zAf.QV(1);
            if (localObject != null) {}
            for (paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject).zxj;; paramArrayOfByte = null)
            {
              if (paramArrayOfByte == null) {
                break label834;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject).zxj;
              if (paramArrayOfByte == null) {
                d.g.b.k.fvU();
              }
              paramLong = paramArrayOfByte.length;
              paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
              paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
              h.a(this.zAf, paramArrayOfByte);
              j = 4;
              break;
            }
          }
          if ((i != 3) || (h.h(this.zAf) == null)) {
            break label834;
          }
          paramArrayOfByte = h.h(this.zAf);
          if (paramArrayOfByte == null) {
            d.g.b.k.fvU();
          }
          paramLong = paramArrayOfByte.length;
          paramInt3 = h.i(this.zAf);
          paramInt4 = h.j(this.zAf);
          h.a(this.zAf, paramArrayOfByte);
          j = 4;
          break label274;
          label603:
          paramInt3 += paramInt4;
          j = paramInt2;
          paramInt4 = paramInt1;
        }
        label621:
        ad.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + paramInt4 + "vh=" + j + ", bm=" + i);
        i = (int)paramLong;
        localObject = this.zAf.zlo;
        if (localObject != null) {
          ((ap)localObject).post((Runnable)new a(paramArrayOfByte, i, paramInt3, paramInt4, j));
        }
        this.zAf.zAd.hO(paramInt1, paramInt2);
        h.a(this.zAf, paramArrayOfByte, paramInt1, paramInt2);
        paramArrayOfByte = this.zAf;
        h.d(paramArrayOfByte, h.k(paramArrayOfByte) + 1);
        paramArrayOfByte = this.zAf;
        boolean bool;
        if (k == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          paramArrayOfByte.zho = bool;
          paramArrayOfByte = this.zAf;
          if (m != OpenGlRender.FLAG_Angle270) {
            break label827;
          }
        }
        label827:
        for (paramInt1 = 270;; paramInt1 = 90)
        {
          paramArrayOfByte.zhp = paramInt1;
          AppMethodBeat.o(192455);
          return;
          bool = false;
          break;
        }
        label834:
        n = paramInt2;
        j = paramInt1;
        paramArrayOfByte = null;
        int i1 = paramInt3 + paramInt4;
        paramInt4 = n;
        paramInt3 = j;
        j = i1;
      }
    }
    
    public final void bOf()
    {
      AppMethodBeat.i(192456);
      this.zAf.zAd.dSl();
      AppMethodBeat.o(192456);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
      
      public final void run()
      {
        AppMethodBeat.i(192454);
        u localu = com.tencent.mm.plugin.voip.c.dRQ();
        byte[] arrayOfByte = this.zAh;
        int i = i;
        int j = paramInt3;
        int k = paramInt4;
        int m = j;
        new Point(0, 0);
        localu.c(arrayOfByte, i, j, k, m);
        AppMethodBeat.o(192454);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke"})
  static final class j
    extends d.g.b.l
    implements q<ByteBuffer, Integer, Integer, y>
  {
    j(h paramh, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<f, y>
  {
    k(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<b, y>
  {
    public static final l zAn;
    
    static
    {
      AppMethodBeat.i(192460);
      zAn = new l();
      AppMethodBeat.o(192460);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    m(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    n(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h
 * JD-Core Version:    0.7.0.1
 */