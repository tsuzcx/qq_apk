package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.g.a;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.q;
import d.g.b.v.e;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "decMode", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "Ljava/nio/ByteBuffer;", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function3;", "", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastHWDecH", "mLastHWDecW", "mLocalIsMirror", "mLocalRotateAngle", "mLocalWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "mPauseTransVideo", "mRemoteWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mUseLastBeautyCnt", "newCaptureRender", "Lcom/tencent/mm/plugin/voip/video/NewCaptureRender;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "initLocalRendererEnvironment", "initRemoteRendererEnvironment", "isLocalUseFaceBeauty", "onHWDecModeSet", "isSmallViewShowSelf", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", "setHWDecMode", "mode", "setLocalRenderOrientation", "setRemoteVideoData", "outData", "", "setVoipBeauty", "cmd", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class h
{
  public static final h.a ASv;
  private int AAF;
  public int AAj;
  private int AAu;
  private int AAv;
  private byte[] ADS;
  private ByteBuffer ADT;
  private int ADU;
  public boolean ADV;
  private com.tencent.mm.plugin.voip.b.a ADY;
  ao ADZ;
  public boolean AJj;
  public int AJn;
  public com.tencent.mm.plugin.voip.video.h ASi;
  private boolean ASj;
  public boolean ASk;
  public d ASl;
  public k ASm;
  private com.tencent.mm.plugin.voip.video.b.a ASn;
  private boolean ASo;
  public boolean ASp;
  private i ASq;
  private int ASr;
  private int ASs;
  private q<? super ByteBuffer, ? super Integer, ? super Integer, y> ASt;
  a ASu;
  boolean AzH;
  public boolean AzR;
  public boolean AzX;
  public int AzY;
  public boolean mIsStarted;
  
  static
  {
    AppMethodBeat.i(208825);
    ASv = new h.a((byte)0);
    AppMethodBeat.o(208825);
  }
  
  public h(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(208824);
    this.ASu = parama;
    this.AzH = paramBoolean;
    this.ADV = true;
    this.mIsStarted = true;
    this.ASn = new com.tencent.mm.plugin.voip.video.b.a(0, 0, -1, null);
    this.ADZ = new ao("encodeVoipHandler");
    this.ADY = new com.tencent.mm.plugin.voip.b.a();
    parama = this.ADY;
    if ((this.AJn & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      parama.S(true, i);
      this.ADY.elB();
      i = 320;
      int j = 240;
      if (v2protocal.AGa)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.AGb)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      parama = g.AMq;
      long l1 = i;
      long l2 = j;
      parama = i.AMu;
      i.zm(l1);
      parama = i.AMu;
      i.zn(l2);
      parama = new com.tencent.mm.compatible.deviceinfo.ac(j, i);
      this.ASl = new d();
      Object localObject1 = this.ASl;
      if (localObject1 != null)
      {
        ((d)localObject1).ARM = new f(parama.width, parama.height);
        ((d)localObject1).ARN = new k(true);
      }
      parama = this.ASl;
      if (parama != null) {
        parama.Td(this.AAj);
      }
      parama = this.ASl;
      if (parama != null)
      {
        d.g.a.b localb = (d.g.a.b)new k(this);
        localObject1 = new v.e();
        ((v.e)localObject1).KUP = -1L;
        Object localObject2 = parama.ARM;
        if (localObject2 != null)
        {
          localb = (d.g.a.b)new d.b(parama, localb);
          if ((((f)localObject2).hcg != null) || (((f)localObject2).ARX)) {
            localb.ay(localObject2);
          }
          ((f)localObject2).i((d.g.a.a)new f.b((f)localObject2, localb));
        }
        localObject2 = parama.ARM;
        if (localObject2 != null) {
          ((f)localObject2).ARx = ((d.g.a.b)new d.c(parama, (v.e)localObject1));
        }
        localObject2 = parama.ARN;
        if (localObject2 != null) {
          ((b)localObject2).ARx = ((d.g.a.b)new d.d(parama, (v.e)localObject1));
        }
        parama = parama.ARM;
        if (parama != null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PboSurfaceRender", "start");
          parama.i((d.g.a.a)new f.k(parama));
        }
      }
      parama = this.ASl;
      if (parama != null) {
        parama.ARO = this.ASu;
      }
      this.ASm = new k(false);
      parama = this.ASm;
      if (parama != null) {
        b.a(parama, (d.g.a.b)h.l.ASF, null, 2);
      }
      parama = this.ASm;
      if (parama != null) {
        parama.ene();
      }
      parama = this.ASm;
      if (parama != null) {
        parama.ARx = ((d.g.a.b)new m(this));
      }
      parama = this.ASm;
      if (parama != null) {
        parama.ARy = ((d.g.a.b)new n(this));
      }
      this.ASq = new i(this);
      AppMethodBeat.o(208824);
      return;
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(208816);
    int i;
    if (this.ASi != null)
    {
      com.tencent.mm.plugin.voip.video.h localh = this.ASi;
      if ((localh == null) || (localh.a((com.tencent.mm.plugin.voip.video.f)this.ASq, paramBoolean) != 1)) {
        break label241;
      }
      paramBoolean = true;
      this.ADV = paramBoolean;
      if (this.ADV)
      {
        localh = this.ASi;
        if (localh != null) {
          localh.o(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.ehb();
        localh = this.ASi;
        if (localh == null) {
          break label246;
        }
        i = localh.ems();
        label96:
        paramSurfaceTexture.Su(i);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.ASi);
        if (this.ASi != null)
        {
          paramSurfaceTexture = this.ASi;
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.emv();
          }
          this.AAF = 0;
          this.ASj = true;
          paramSurfaceTexture = this.ASi;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fOy();
          }
          paramSurfaceTexture = paramSurfaceTexture.emw();
          d.g.b.k.g(paramSurfaceTexture, "newCaptureRender!!.previewSize");
          localh = this.ASi;
          if (localh == null) {
            d.g.b.k.fOy();
          }
          i = localh.emx();
          localh = this.ASi;
          if (localh == null) {
            d.g.b.k.fOy();
          }
          if (localh.emy()) {
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
      AppMethodBeat.o(208816);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void enl()
  {
    AppMethodBeat.i(208815);
    com.tencent.mm.sdk.platformtools.ac.l("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.ASi != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.h localh = this.ASi;
      if (localh != null) {
        localh.emp();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.ASi = null;
    AppMethodBeat.o(208815);
  }
  
  private void sC(boolean paramBoolean)
  {
    AppMethodBeat.i(208817);
    if (!this.ASj)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = 320;
      int j = 240;
      if (v2protocal.AGa)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.AGb)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      if (this.ASi == null) {
        this.ASi = new com.tencent.mm.plugin.voip.video.h(i, j);
      }
    }
    AppMethodBeat.o(208817);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Te(int paramInt)
  {
    AppMethodBeat.i(208822);
    if (this.ASt == null)
    {
      this.ASt = ((q)new h.j(this, paramInt));
      Object localObject2 = this.ASl;
      if (localObject2 != null)
      {
        localObject1 = this.ASt;
        localObject2 = ((d)localObject2).ARM;
        if ((localObject2 != null) && (localObject1 != null) && (!((f)localObject2).ASa.contains(localObject1))) {
          ((f)localObject2).ASa.add(localObject1);
        }
      }
    }
    Object localObject1 = this.ASn;
    AppMethodBeat.o(208822);
    return localObject1;
  }
  
  public final void a(com.tencent.mm.compatible.deviceinfo.ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(208819);
    d locald = this.ASl;
    if (locald != null)
    {
      locald.a(paramac, paramInt, paramBoolean);
      AppMethodBeat.o(208819);
      return;
    }
    AppMethodBeat.o(208819);
  }
  
  public final void d(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(208814);
    sC(paramBoolean);
    paramf = paramf.surfaceTexture;
    if (paramf == null) {
      d.g.b.k.fOy();
    }
    b(paramf, paramBoolean);
    AppMethodBeat.o(208814);
  }
  
  public final void enm()
  {
    AppMethodBeat.i(208818);
    Object localObject;
    if ((ae.fJd.fEF == 1) && (this.ASl != null))
    {
      localObject = this.ASl;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((d)localObject).ARM != null)
      {
        localObject = this.ASl;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localObject = ((d)localObject).ARM;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        d((f)localObject, true);
      }
    }
    if ((!this.ADV) || (ae.fJd.fEF == 1) || (ae.fJd.fEG == 1)) {
      if (this.ASi != null)
      {
        localObject = this.ASi;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.h)localObject).emq();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.ASl != null)
      {
        localObject = this.ASl;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((d)localObject).ARM != null)
        {
          localObject = this.ASl;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          localObject = ((d)localObject).ARM;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          d((f)localObject, bool);
        }
      }
      this.ADV = true;
      AppMethodBeat.o(208818);
      return;
      bool = true;
      break;
    }
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208821);
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(208821);
      return;
    }
    if (this.ASo)
    {
      AppMethodBeat.o(208821);
      return;
    }
    this.AAu = paramInt2;
    this.AAv = paramInt1;
    if ((this.mIsStarted) && (this.ASm != null))
    {
      this.ASo = true;
      k localk = this.ASm;
      if (localk != null)
      {
        b.a(localk, new com.tencent.mm.compatible.deviceinfo.ac(paramInt2, paramInt1), Integer.valueOf(270));
        AppMethodBeat.o(208821);
        return;
      }
    }
    AppMethodBeat.o(208821);
  }
  
  public final void release()
  {
    AppMethodBeat.i(208823);
    Object localObject = this.ADZ;
    if (localObject != null) {
      ((ao)localObject).removeCallbacksAndMessages(null);
    }
    this.ADZ = null;
    enl();
    localObject = this.ASl;
    if (localObject != null) {
      ((d)localObject).release();
    }
    localObject = this.ASm;
    if (localObject != null) {
      ((k)localObject).enf();
    }
    localObject = this.ASm;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = this.ADY;
    if ((this.AJn & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).S(true, i);
      this.ADY.elC();
      this.ADS = null;
      this.ADU = 0;
      AppMethodBeat.o(208823);
      return;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(208820);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.AJn) });
    if (this.AJn != paramInt)
    {
      this.AJn = paramInt;
      localObject = this.ADY;
      if ((this.AJn & 0x1) == 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).S(true, paramInt);
      this.ADY.elB();
      if ((this.AJn & 0x1) == 0) {
        break label120;
      }
      localObject = this.ASm;
      if (localObject == null) {
        break;
      }
      ((k)localObject).Ta(1);
      AppMethodBeat.o(208820);
      return;
    }
    AppMethodBeat.o(208820);
    return;
    label120:
    Object localObject = this.ASm;
    if (localObject != null)
    {
      ((k)localObject).Ta(0);
      AppMethodBeat.o(208820);
      return;
    }
    AppMethodBeat.o(208820);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void Tf(int paramInt);
    
    public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
    
    public abstract void aw(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void enn();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public d(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$3", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class e
    implements h.b
  {
    private e ASx;
    
    public final void Tf(int paramInt)
    {
      AppMethodBeat.i(208797);
      Object localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).c(this.ASx, paramInt);
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).c(this.ASx, paramInt);
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).enf();
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).enf();
      }
      this.ASx = null;
      AppMethodBeat.o(208797);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(208796);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new e(paramSurface, (byte)0);; paramSurface = new e(paramSurfaceTexture, (byte)0))
        {
          this.ASx = paramSurface;
          paramSurface = h.c(this.ASw);
          if (paramSurface != null) {
            paramSurface.b(this.ASx, paramInt);
          }
          paramSurface = h.d(this.ASw);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.ASx, paramInt);
          AppMethodBeat.o(208796);
          return;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fOy();
          }
        }
      }
      AppMethodBeat.o(208796);
    }
    
    public final void aw(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(208798);
      Object localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).x = 0;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).y = 0;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).width = paramInt1;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).height = paramInt2;
        }
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).a(this.ASx, paramInt3);
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).a(this.ASx, paramInt3);
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).ene();
      }
      localObject = h.d(this.ASw);
      if (localObject != null)
      {
        ((k)localObject).ene();
        AppMethodBeat.o(208798);
        return;
      }
      AppMethodBeat.o(208798);
    }
    
    public final void enn()
    {
      AppMethodBeat.i(208795);
      Object localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).enh();
      }
      localObject = h.d(this.ASw);
      if (localObject != null)
      {
        ((k)localObject).tb(false);
        AppMethodBeat.o(208795);
        return;
      }
      AppMethodBeat.o(208795);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public f(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public g(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$6", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class h
    implements h.b
  {
    private e ASx;
    
    public final void Tf(int paramInt)
    {
      AppMethodBeat.i(208803);
      Object localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).c(this.ASx, paramInt);
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).c(this.ASx, paramInt);
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).enf();
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).enf();
      }
      this.ASx = null;
      AppMethodBeat.o(208803);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(208802);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new e(paramSurface, (byte)0);; paramSurface = new e(paramSurfaceTexture, (byte)0))
        {
          this.ASx = paramSurface;
          paramSurface = h.c(this.ASw);
          if (paramSurface != null) {
            paramSurface.b(this.ASx, paramInt);
          }
          paramSurface = h.d(this.ASw);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.ASx, paramInt);
          AppMethodBeat.o(208802);
          return;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fOy();
          }
        }
      }
      AppMethodBeat.o(208802);
    }
    
    public final void aw(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(208804);
      Object localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).x = 0;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).y = 0;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).width = paramInt1;
        }
      }
      localObject = this.ASx;
      if (localObject != null)
      {
        localObject = ((e)localObject).ART;
        if (localObject != null) {
          ((e.b)localObject).height = paramInt2;
        }
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).a(this.ASx, paramInt3);
      }
      localObject = h.d(this.ASw);
      if (localObject != null) {
        ((k)localObject).a(this.ASx, paramInt3);
      }
      localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).ene();
      }
      localObject = h.d(this.ASw);
      if (localObject != null)
      {
        ((k)localObject).ene();
        AppMethodBeat.o(208804);
        return;
      }
      AppMethodBeat.o(208804);
    }
    
    public final void enn()
    {
      AppMethodBeat.i(208801);
      Object localObject = h.c(this.ASw);
      if (localObject != null) {
        ((d)localObject).enh();
      }
      localObject = h.d(this.ASw);
      if (localObject != null)
      {
        ((k)localObject).tb(false);
        AppMethodBeat.o(208801);
        return;
      }
      AppMethodBeat.o(208801);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/ICaptureRenderListener;", "onCameraError", "", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "plugin-voip_release"})
  public static final class i
    implements com.tencent.mm.plugin.voip.video.f
  {
    public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(208806);
      if (this.ASw.AzR)
      {
        AppMethodBeat.o(208806);
        return;
      }
      if (this.ASw.ASi == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady, captureRender is null!");
        AppMethodBeat.o(208806);
        return;
      }
      Object localObject1 = this.ASw.ASi;
      int k;
      int m;
      label100:
      ao localao;
      final int j;
      label126:
      final int i;
      label142:
      label174:
      Object localObject2;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.voip.video.h)localObject1).emq() == true))
      {
        k = OpenGlRender.FLAG_Mirror;
        localObject1 = this.ASw.ASi;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject1).emr() != true)) {
          break label352;
        }
        m = OpenGlRender.FLAG_Angle270;
        localObject1 = null;
        localao = null;
        if ((OpenGlRender.getGLVersion() != 2) || (h.f(this.ASw) == 0)) {
          break label360;
        }
        j = 1;
        if ((h.f(this.ASw) & 0x8) == 0) {
          break label366;
        }
        i = 1;
        if (j == 0) {
          break label457;
        }
        if ((i != 0) || (this.ASw.Te(2) == null)) {
          break label372;
        }
        h.a(this.ASw, 0);
        i = 1;
        localObject2 = this.ASw.ASi;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject2).emq() != true) || (j == 0) || (i == 0)) {
          break label614;
        }
        if (i != 1) {
          break label468;
        }
        localObject2 = this.ASw.Te(2);
        if (localObject2 == null) {
          break label463;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hoQ;
        label234:
        if (paramArrayOfByte == null) {
          break label857;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hoQ;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramLong = paramArrayOfByte.capacity();
        paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
        paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
        h.a(this.ASw, paramArrayOfByte);
        j = 4;
      }
      for (;;)
      {
        label282:
        h.c(this.ASw, paramInt4);
        h.b(this.ASw, paramInt3);
        int n = j;
        j = paramInt4;
        paramInt4 = paramInt3;
        paramInt3 = n;
        for (;;)
        {
          if ((localObject1 != null) || (paramArrayOfByte != null)) {
            break label641;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
          paramArrayOfByte = g.AMq;
          g.a.SQ(0);
          AppMethodBeat.o(208806);
          return;
          k = 0;
          break;
          label352:
          m = OpenGlRender.FLAG_Angle90;
          break label100;
          label360:
          j = 0;
          break label126;
          label366:
          i = 0;
          break label142;
          label372:
          if ((i != 0) && (this.ASw.Te(1) != null))
          {
            h.a(this.ASw, 0);
            i = 2;
            break label174;
          }
          if ((h.h(this.ASw) != null) && (h.g(this.ASw) <= 10))
          {
            localObject2 = this.ASw;
            h.a((h)localObject2, h.g((h)localObject2) + 1);
            i = 3;
            break label174;
          }
          j = 0;
          i = 0;
          break label174;
          label457:
          i = 0;
          break label174;
          label463:
          paramArrayOfByte = null;
          break label234;
          label468:
          if (i == 2)
          {
            localObject2 = this.ASw.Te(1);
            if (localObject2 != null) {}
            for (paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hoQ;; paramArrayOfByte = null)
            {
              if (paramArrayOfByte == null) {
                break label857;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hoQ;
              if (paramArrayOfByte == null) {
                d.g.b.k.fOy();
              }
              paramLong = paramArrayOfByte.capacity();
              paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
              paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
              h.a(this.ASw, paramArrayOfByte);
              j = 4;
              break;
            }
          }
          if ((i != 3) || (h.h(this.ASw) == null)) {
            break label857;
          }
          paramArrayOfByte = h.i(this.ASw);
          d.g.b.k.fOy();
          paramLong = null.length;
          paramInt3 = h.j(this.ASw);
          paramInt4 = h.k(this.ASw);
          h.a(this.ASw, paramArrayOfByte);
          j = 4;
          break label282;
          label614:
          paramInt3 += paramInt4;
          j = paramInt2;
          paramInt4 = paramInt1;
          localao = null;
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = localao;
        }
        label641:
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + paramInt4 + "vh=" + j + ", bm=" + i);
        i = (int)paramLong;
        localao = this.ASw.ADZ;
        if (localao != null) {
          localao.post((Runnable)new a(paramArrayOfByte, i, paramInt3, paramInt4, j, (byte[])localObject1));
        }
        this.ASw.ASu.id(paramInt1, paramInt2);
        h.a(this.ASw, (byte[])localObject1, paramInt1, paramInt2);
        paramArrayOfByte = this.ASw;
        h.d(paramArrayOfByte, h.l(paramArrayOfByte) + 1);
        paramArrayOfByte = this.ASw;
        boolean bool;
        if (k == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          paramArrayOfByte.AzX = bool;
          paramArrayOfByte = this.ASw;
          if (m != OpenGlRender.FLAG_Angle270) {
            break label850;
          }
        }
        label850:
        for (paramInt1 = 270;; paramInt1 = 90)
        {
          paramArrayOfByte.AzY = paramInt1;
          AppMethodBeat.o(208806);
          return;
          bool = false;
          break;
        }
        label857:
        n = paramInt2;
        j = paramInt1;
        int i1 = paramInt3 + paramInt4;
        paramInt4 = n;
        paramInt3 = j;
        paramArrayOfByte = localao;
        j = i1;
      }
    }
    
    public final void bVs()
    {
      AppMethodBeat.i(208807);
      this.ASw.ASu.ehx();
      AppMethodBeat.o(208807);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte) {}
      
      public final void run()
      {
        AppMethodBeat.i(208805);
        u localu;
        Object localObject;
        int i;
        int j;
        int k;
        int m;
        if (this.ASy != null)
        {
          localu = com.tencent.mm.plugin.voip.c.ehb();
          localObject = this.ASy;
          i = i;
          j = paramInt3;
          k = paramInt4;
          m = j;
          new Point(0, 0);
          localu.b((ByteBuffer)localObject, i, j, k, m);
          AppMethodBeat.o(208805);
          return;
        }
        if (this.ASz != null)
        {
          localu = com.tencent.mm.plugin.voip.c.ehb();
          localObject = this.ASz;
          i = i;
          j = paramInt3;
          k = paramInt4;
          m = j;
          new Point(0, 0);
          localu.c((byte[])localObject, i, j, k, m);
        }
        AppMethodBeat.o(208805);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<f, y>
  {
    k(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    m(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h
 * JD-Core Version:    0.7.0.1
 */