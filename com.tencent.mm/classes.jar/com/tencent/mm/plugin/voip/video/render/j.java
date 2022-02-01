package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.i.a;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.e;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "decMode", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "Ljava/nio/ByteBuffer;", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastHWDecH", "mLastHWDecW", "mLocalIsMirror", "mLocalRotateAngle", "mLocalWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/LocalWindowsSurfaceRenderer;", "mPauseTransVideo", "mRemoteWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mUseLastBeautyCnt", "newCaptureRender", "Lcom/tencent/mm/plugin/voip/video/NewCaptureRender;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "initLocalRendererEnvironment", "initRemoteRendererEnvironment", "isLocalUseFaceBeauty", "onHWDecModeSet", "isSmallViewShowSelf", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", "setHWDecMode", "mode", "setLocalRenderOrientation", "setRemoteVideoData", "outData", "", "setVoipBeauty", "cmd", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class j
{
  public static final j.a CKf;
  public com.tencent.mm.plugin.voip.video.h CJQ;
  private boolean CJR;
  public boolean CJS;
  public e CJT;
  public m CJU;
  private com.tencent.mm.plugin.voip.video.b.a CJV;
  private boolean CJW;
  private final int CJX;
  public boolean CJY;
  private i CJZ;
  private int CKa;
  private int CKb;
  private int CKc;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> CKd;
  b CKe;
  public int CqK;
  private int CqV;
  private int CqW;
  boolean Cqi;
  public boolean Cqs;
  public boolean Cqy;
  public int Cqz;
  private int Crf;
  aq CuA;
  private byte[] Cut;
  private ByteBuffer Cuu;
  private int Cuv;
  public boolean Cuw;
  private com.tencent.mm.plugin.voip.b.a Cuz;
  public boolean CzO;
  public int CzS;
  public boolean mIsStarted;
  long wbm;
  
  static
  {
    AppMethodBeat.i(210610);
    CKf = new j.a((byte)0);
    AppMethodBeat.o(210610);
  }
  
  public j(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(210609);
    this.CKe = paramb;
    this.Cqi = paramBoolean;
    this.Cuw = true;
    this.mIsStarted = true;
    this.CJV = new com.tencent.mm.plugin.voip.video.b.a();
    paramb = com.tencent.mm.plugin.voip.b.h.CCW;
    if (com.tencent.mm.plugin.voip.b.h.eDp())
    {
      i = 33;
      this.CJX = i;
      this.CuA = new aq("encodeVoipHandler");
      this.Cuz = new com.tencent.mm.plugin.voip.b.a();
      paramb = this.Cuz;
      if ((this.CzS & 0x1) == 0) {
        break label654;
      }
    }
    label654:
    for (int i = 1;; i = 0)
    {
      paramb.W(true, i);
      this.Cuz.eCT();
      i = 320;
      int j = 240;
      if (v2protocal.CwB)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.CwC)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      paramb = com.tencent.mm.plugin.voip.b.i.CDi;
      long l1 = i;
      long l2 = j;
      paramb = k.CDm;
      k.Cr(l1);
      paramb = k.CDm;
      k.Cs(l2);
      paramb = new ac(j, i);
      this.CJT = new e();
      Object localObject1 = this.CJT;
      if (localObject1 != null)
      {
        ((e)localObject1).CJq = new g(paramb.width, paramb.height);
        ((e)localObject1).CJr = new m(true);
      }
      paramb = this.CJT;
      if (paramb != null) {
        paramb.VD(this.CqK);
      }
      paramb = this.CJT;
      if (paramb != null)
      {
        d.g.a.b localb = (d.g.a.b)new k(this);
        localObject1 = new y.e();
        ((y.e)localObject1).NiX = -1L;
        Object localObject2 = paramb.CJq;
        if (localObject2 != null)
        {
          localb = (d.g.a.b)new e.b(paramb, localb);
          if ((((g)localObject2).hxc != null) || (((g)localObject2).CJB)) {
            localb.invoke(localObject2);
          }
          ((g)localObject2).j((d.g.a.a)new g.b((g)localObject2, localb));
        }
        localObject2 = paramb.CJq;
        if (localObject2 != null) {
          ((g)localObject2).CIZ = ((d.g.a.b)new e.c(paramb, (y.e)localObject1));
        }
        localObject2 = paramb.CJr;
        if (localObject2 != null) {
          ((c)localObject2).CIZ = ((d.g.a.b)new e.d(paramb, (y.e)localObject1));
        }
        paramb = paramb.CJq;
        if (paramb != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PboSurfaceRender", "start");
          paramb.j((d.g.a.a)new g.k(paramb));
        }
      }
      paramb = this.CJT;
      if (paramb != null) {
        paramb.CJs = this.CKe;
      }
      this.CJU = new m(false);
      paramb = this.CJU;
      if (paramb != null) {
        c.a(paramb, (d.g.a.b)l.CKr, null, 2);
      }
      paramb = this.CJU;
      if (paramb != null) {
        paramb.eEK();
      }
      paramb = this.CJU;
      if (paramb != null) {
        paramb.CIZ = ((d.g.a.b)new m(this));
      }
      paramb = this.CJU;
      if (paramb != null) {
        paramb.CJa = ((d.g.a.b)new n(this));
      }
      paramb = i.CJN;
      i.reset();
      paramb = d.CCN;
      d.clear();
      this.CJZ = new i(this);
      AppMethodBeat.o(210609);
      return;
      paramb = com.tencent.mm.plugin.voip.b.h.CCW;
      if (com.tencent.mm.plugin.voip.b.h.eDo())
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
    AppMethodBeat.i(210601);
    int i;
    if (this.CJQ != null)
    {
      com.tencent.mm.plugin.voip.video.h localh = this.CJQ;
      if ((localh == null) || (localh.a((com.tencent.mm.plugin.voip.video.f)this.CJZ, paramBoolean) != 1)) {
        break label241;
      }
      paramBoolean = true;
      this.Cuw = paramBoolean;
      if (this.Cuw)
      {
        localh = this.CJQ;
        if (localh != null) {
          localh.o(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.eys();
        localh = this.CJQ;
        if (localh == null) {
          break label246;
        }
        i = localh.eDW();
        label96:
        paramSurfaceTexture.UT(i);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.CJQ);
        if (this.CJQ != null)
        {
          paramSurfaceTexture = this.CJQ;
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.eDZ();
          }
          this.Crf = 0;
          this.CJR = true;
          paramSurfaceTexture = this.CJQ;
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
          paramSurfaceTexture = paramSurfaceTexture.eEa();
          p.g(paramSurfaceTexture, "newCaptureRender!!.previewSize");
          localh = this.CJQ;
          if (localh == null) {
            p.gkB();
          }
          i = localh.eEb();
          localh = this.CJQ;
          if (localh == null) {
            p.gkB();
          }
          if (localh.eEc()) {
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
      AppMethodBeat.o(210601);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void eES()
  {
    AppMethodBeat.i(210600);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.CJQ != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.h localh = this.CJQ;
      if (localh != null) {
        localh.eDT();
      }
      localh = this.CJQ;
      if (localh != null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.CJQ = null;
    AppMethodBeat.o(210600);
  }
  
  private void ts(boolean paramBoolean)
  {
    AppMethodBeat.i(210602);
    if (!this.CJR)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = 320;
      int j = 240;
      if (v2protocal.CwB)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "steve: 640 capture!");
        i = 640;
        j = 480;
      }
      if (v2protocal.CwC)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
        i = 1280;
        j = 720;
      }
      if (this.CJQ == null) {
        this.CJQ = new com.tencent.mm.plugin.voip.video.h(i, j);
      }
    }
    AppMethodBeat.o(210602);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a VE(final int paramInt)
  {
    AppMethodBeat.i(210607);
    if (this.CKd == null)
    {
      this.CKd = ((r)new j(this, paramInt));
      Object localObject2 = this.CJT;
      if (localObject2 != null)
      {
        localObject1 = this.CKd;
        localObject2 = ((e)localObject2).CJq;
        if ((localObject2 != null) && (localObject1 != null) && (!((g)localObject2).CJE.contains(localObject1))) {
          ((g)localObject2).CJE.add(localObject1);
        }
      }
    }
    Object localObject1 = this.CJV;
    AppMethodBeat.o(210607);
    return localObject1;
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(210604);
    e locale = this.CJT;
    if (locale != null)
    {
      locale.a(paramac, paramInt, paramBoolean);
      AppMethodBeat.o(210604);
      return;
    }
    AppMethodBeat.o(210604);
  }
  
  public final void d(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(210599);
    ts(paramBoolean);
    paramg = paramg.surfaceTexture;
    if (paramg == null) {
      p.gkB();
    }
    b(paramg, paramBoolean);
    AppMethodBeat.o(210599);
  }
  
  public final void eET()
  {
    AppMethodBeat.i(210603);
    Object localObject;
    if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) && (this.CJT != null))
    {
      localObject = this.CJT;
      if (localObject == null) {
        p.gkB();
      }
      if (((e)localObject).CJq != null)
      {
        localObject = this.CJT;
        if (localObject == null) {
          p.gkB();
        }
        localObject = ((e)localObject).CJq;
        if (localObject == null) {
          p.gkB();
        }
        d((g)localObject, true);
      }
    }
    if ((!this.Cuw) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gal == 1)) {
      if (this.CJQ != null)
      {
        localObject = this.CJQ;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.h)localObject).eDU();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.CJT != null)
      {
        localObject = this.CJT;
        if (localObject == null) {
          p.gkB();
        }
        if (((e)localObject).CJq != null)
        {
          localObject = this.CJT;
          if (localObject == null) {
            p.gkB();
          }
          localObject = ((e)localObject).CJq;
          if (localObject == null) {
            p.gkB();
          }
          d((g)localObject, bool);
        }
      }
      this.Cuw = true;
      AppMethodBeat.o(210603);
      return;
      bool = true;
      break;
    }
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210606);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(210606);
      return;
    }
    if (this.CJW)
    {
      AppMethodBeat.o(210606);
      return;
    }
    this.CqV = paramInt2;
    this.CqW = paramInt1;
    if ((this.mIsStarted) && (this.CJU != null))
    {
      this.CJW = true;
      m localm = this.CJU;
      if (localm != null)
      {
        c.a(localm, new ac(paramInt2, paramInt1), Integer.valueOf(270));
        AppMethodBeat.o(210606);
        return;
      }
    }
    AppMethodBeat.o(210606);
  }
  
  public final void release()
  {
    AppMethodBeat.i(210608);
    Object localObject = i.CJN;
    i.report();
    localObject = d.CCN;
    d.clear();
    localObject = this.CuA;
    if (localObject != null) {
      ((aq)localObject).removeCallbacksAndMessages(null);
    }
    this.CuA = null;
    eES();
    localObject = this.CJT;
    if (localObject != null) {
      ((e)localObject).release();
    }
    localObject = this.CJU;
    if (localObject != null) {
      c.h((c)localObject);
    }
    localObject = this.CJU;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.Cuz;
    if ((this.CzS & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).W(true, i);
      this.Cuz.eCU();
      this.Cut = null;
      this.Cuv = 0;
      AppMethodBeat.o(210608);
      return;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(210605);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.CzS) });
    if (this.CzS != paramInt)
    {
      this.CzS = paramInt;
      localObject = this.Cuz;
      if ((this.CzS & 0x1) == 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).W(true, paramInt);
      this.Cuz.eCT();
      if ((this.CzS & 0x1) == 0) {
        break label120;
      }
      localObject = this.CJU;
      if (localObject == null) {
        break;
      }
      ((m)localObject).VA(1);
      AppMethodBeat.o(210605);
      return;
    }
    AppMethodBeat.o(210605);
    return;
    label120:
    Object localObject = this.CJU;
    if (localObject != null)
    {
      ((m)localObject).VA(0);
      AppMethodBeat.o(210605);
      return;
    }
    AppMethodBeat.o(210605);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements d.g.a.a<z>
  {
    public d(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$3", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class e
    implements j.b
  {
    private f CKh;
    
    public final void VF(int paramInt)
    {
      AppMethodBeat.i(210582);
      Object localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).c(this.CKh, paramInt);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).c(this.CKh, paramInt);
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).b(this.CKh);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).b(this.CKh);
      }
      this.CKh = null;
      AppMethodBeat.o(210582);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(210581);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.CKh = paramSurface;
          paramSurface = j.c(this.CKg);
          if (paramSurface != null) {
            paramSurface.b(this.CKh, paramInt);
          }
          paramSurface = j.d(this.CKg);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.CKh, paramInt);
          AppMethodBeat.o(210581);
          return;
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
        }
      }
      AppMethodBeat.o(210581);
    }
    
    public final void az(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210583);
      Object localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).a(this.CKh, paramInt3);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).a(this.CKh, paramInt3);
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).eEK();
      }
      localObject = j.d(this.CKg);
      if (localObject != null)
      {
        ((m)localObject).eEK();
        AppMethodBeat.o(210583);
        return;
      }
      AppMethodBeat.o(210583);
    }
    
    public final void eEU()
    {
      AppMethodBeat.i(210580);
      Object localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).eEN();
      }
      localObject = j.d(this.CKg);
      if (localObject != null)
      {
        ((m)localObject).tS(false);
        AppMethodBeat.o(210580);
        return;
      }
      AppMethodBeat.o(210580);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class f
    extends q
    implements d.g.a.a<z>
  {
    public f(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class g
    extends q
    implements d.g.a.a<z>
  {
    public g(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$6", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class h
    implements j.b
  {
    private f CKh;
    
    public final void VF(int paramInt)
    {
      AppMethodBeat.i(210588);
      Object localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).c(this.CKh, paramInt);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).c(this.CKh, paramInt);
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).b(this.CKh);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).b(this.CKh);
      }
      this.CKh = null;
      AppMethodBeat.o(210588);
    }
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(210587);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.CKh = paramSurface;
          paramSurface = j.c(this.CKg);
          if (paramSurface != null) {
            paramSurface.b(this.CKh, paramInt);
          }
          paramSurface = j.d(this.CKg);
          if (paramSurface == null) {
            break;
          }
          paramSurface.b(this.CKh, paramInt);
          AppMethodBeat.o(210587);
          return;
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
        }
      }
      AppMethodBeat.o(210587);
    }
    
    public final void az(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210589);
      Object localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.CKh;
      if (localObject != null)
      {
        localObject = ((f)localObject).CJx;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).a(this.CKh, paramInt3);
      }
      localObject = j.d(this.CKg);
      if (localObject != null) {
        ((m)localObject).a(this.CKh, paramInt3);
      }
      localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).eEK();
      }
      localObject = j.d(this.CKg);
      if (localObject != null)
      {
        ((m)localObject).eEK();
        AppMethodBeat.o(210589);
        return;
      }
      AppMethodBeat.o(210589);
    }
    
    public final void eEU()
    {
      AppMethodBeat.i(210586);
      Object localObject = j.c(this.CKg);
      if (localObject != null) {
        ((e)localObject).eEN();
      }
      localObject = j.d(this.CKg);
      if (localObject != null)
      {
        ((m)localObject).tS(false);
        AppMethodBeat.o(210586);
        return;
      }
      AppMethodBeat.o(210586);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/ICaptureRenderListener;", "onCameraError", "", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "plugin-voip_release"})
  public static final class i
    implements com.tencent.mm.plugin.voip.video.f
  {
    public final void a(final byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(210591);
      if (this.CKg.Cqs)
      {
        AppMethodBeat.o(210591);
        return;
      }
      if (this.CKg.CJQ == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady, captureRender is null!");
        AppMethodBeat.o(210591);
        return;
      }
      Object localObject1 = this.CKg.CJQ;
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
      if ((localObject1 != null) && (((com.tencent.mm.plugin.voip.video.h)localObject1).eDU() == true))
      {
        k = OpenGlRender.FLAG_Mirror;
        localObject1 = this.CKg.CJQ;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject1).eDV() != true)) {
          break label426;
        }
        m = OpenGlRender.FLAG_Angle270;
        localObject1 = null;
        locald1 = null;
        if ((OpenGlRender.getGLVersion() != 2) || (j.f(this.CKg) == 0)) {
          break label434;
        }
        j = 1;
        if ((j.f(this.CKg) & 0x8) == 0) {
          break label440;
        }
        i = 1;
        locald2 = new y.d();
        locald2.NiW = 0;
        if (j == 0) {
          break label531;
        }
        if ((i != 0) || (this.CKg.VE(2) == null)) {
          break label446;
        }
        i = 1;
        j.a(this.CKg, 0);
        localObject2 = this.CKg.CJQ;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.voip.video.h)localObject2).eDU() != true) || (j == 0) || (i == 0)) {
          break label846;
        }
        if (i != 1) {
          break label555;
        }
        localObject2 = this.CKg.VE(2);
        if (localObject2 == null) {
          break label537;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hKa;
        if (paramArrayOfByte == null) {
          break label1114;
        }
        paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hKa;
        locald2.NiW = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
        switch (locald2.NiW)
        {
        default: 
          paramInt3 = j.i(this.CKg);
          label305:
          if (paramArrayOfByte == null) {
            p.gkB();
          }
          paramLong = paramArrayOfByte.capacity();
          paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
          n = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
          j.a(this.CKg, paramArrayOfByte);
          j = paramInt3;
          paramInt3 = n;
        }
      }
      for (;;)
      {
        j.d(this.CKg, paramInt3);
        j.c(this.CKg, paramInt4);
        j.b(this.CKg, locald2.NiW);
        n = j;
        j = paramInt3;
        paramInt3 = n;
        for (;;)
        {
          if ((localObject1 != null) || (paramArrayOfByte != null)) {
            break label873;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
          paramArrayOfByte = com.tencent.mm.plugin.voip.b.i.CDi;
          i.a.Vq(0);
          AppMethodBeat.o(210591);
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
          if ((i != 0) && (this.CKg.VE(1) != null))
          {
            i = 2;
            j.a(this.CKg, 0);
            break label189;
          }
          if ((j.h(this.CKg) != null) && (j.g(this.CKg) <= 10))
          {
            i = 3;
            localObject2 = this.CKg;
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
            localObject2 = this.CKg.VE(1);
            if (localObject2 != null)
            {
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hKa;
              label582:
              if (paramArrayOfByte == null) {
                break label1114;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).hKa;
              locald2.NiW = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
              switch (locald2.NiW)
              {
              default: 
                paramInt3 = j.i(this.CKg);
              }
            }
            for (;;)
            {
              if (paramArrayOfByte == null) {
                p.gkB();
              }
              paramLong = paramArrayOfByte.capacity();
              j = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
              paramInt4 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
              j.a(this.CKg, paramArrayOfByte);
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
          if ((i != 3) || (j.h(this.CKg) == null)) {
            break label1114;
          }
          paramArrayOfByte = j.j(this.CKg);
          switch (j.k(this.CKg))
          {
          default: 
            paramInt3 = j.i(this.CKg);
          }
          for (;;)
          {
            p.gkB();
            paramLong = null.length;
            n = j.l(this.CKg);
            paramInt4 = j.m(this.CKg);
            locald2.NiW = j.k(this.CKg);
            j.a(this.CKg, paramArrayOfByte);
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
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + paramInt4 + "vh=" + j + ", bm=" + i);
        locald1 = new y.d();
        locald1.NiW = 0;
        i = (int)paramLong;
        localObject2 = this.CKg.CuA;
        if (localObject2 != null) {
          ((aq)localObject2).post((Runnable)new a(this, paramArrayOfByte, locald1, i, paramInt3, paramInt4, j, locald2, (byte[])localObject1));
        }
        this.CKg.CKe.aw(locald1.NiW, paramInt1, paramInt2);
        j.a(this.CKg, (byte[])localObject1, paramInt1, paramInt2);
        paramArrayOfByte = this.CKg;
        j.e(paramArrayOfByte, j.n(paramArrayOfByte) + 1);
        paramArrayOfByte = this.CKg;
        boolean bool;
        if (k == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          paramArrayOfByte.Cqy = bool;
          paramArrayOfByte = this.CKg;
          if (m != OpenGlRender.FLAG_Angle270) {
            break label1107;
          }
        }
        label1107:
        for (paramInt1 = 270;; paramInt1 = 90)
        {
          paramArrayOfByte.Cqz = paramInt1;
          AppMethodBeat.o(210591);
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
    
    public final void cbl()
    {
      AppMethodBeat.i(210592);
      this.CKg.CKe.eyO();
      AppMethodBeat.o(210592);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.i parami, ByteBuffer paramByteBuffer, y.d paramd1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, y.d paramd2, byte[] paramArrayOfByte) {}
      
      public final void run()
      {
        AppMethodBeat.i(210590);
        if (paramArrayOfByte != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPRenderMgr", "encode tick " + bu.aO(this.CKi.CKg.wbm));
          this.CKi.CKg.wbm = bu.HQ();
          locald1.NiW = com.tencent.mm.plugin.voip.c.eys().c(paramArrayOfByte, i, paramInt3, paramInt4, j, locald2.NiW);
          AppMethodBeat.o(210590);
          return;
        }
        if (this.CKp != null)
        {
          y.d locald = locald1;
          u localu = com.tencent.mm.plugin.voip.c.eys();
          byte[] arrayOfByte = this.CKp;
          int i = i;
          int j = paramInt3;
          int k = paramInt4;
          int m = j;
          new Point(0, 0);
          locald.NiW = localu.c(arrayOfByte, i, j, k, m);
        }
        AppMethodBeat.o(210590);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class j
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, z>
  {
    j(j paramj, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<g, z>
  {
    k(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<c, z>
  {
    public static final l CKr;
    
    static
    {
      AppMethodBeat.i(210596);
      CKr = new l();
      AppMethodBeat.o(210596);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<Long, z>
  {
    m(j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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