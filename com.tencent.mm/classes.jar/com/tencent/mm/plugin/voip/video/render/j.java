package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.util.Size;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "captureRenderer", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "decMode", "drawHeight", "drawWidth", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isCameraStausChange", "isHasBeenReported", "isInit", "()Z", "setInit", "(Z)V", "isRemoteSizeInit", "lastFrameTick", "", "lastSendFilterBuffer", "lastSendFilterData", "", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "setMIsOutCall", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastEncHeight", "mLastEncWidth", "mLastHWDecH", "mLastHWDecW", "mLastSTFilterCmd", "mLocalIsMirror", "mLocalRotateAngle", "mPauseTransVideo", "mPreviewCounter", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mSTDenosingPreProcess", "Lcom/tencent/mm/video/videoprocessing/SpatiotemproalDenosingPreProcess;", "mUpdateTimes", "mUseLastBeautyCnt", "mVoipWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "onInit", "Lkotlin/Function0;", "getOnInit", "()Lkotlin/jvm/functions/Function0;", "setOnInit", "(Lkotlin/jvm/functions/Function0;)V", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "repairerHwEncodeConfig", "screenRotation", "shouldUpdateRenderSize", "tick", "getTick", "()J", "setTick", "(J)V", "use720pCapture", "addRenderSurfaceTexture", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "remoteMode", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "bFaceFirst", "bindCameraFrameDetect", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "cacheCallbackBuffer", "size", "choiceCameraPboViewSize", "Landroid/util/Size;", "focusOnFace", "forceResumeCamera", "getFaceBeautyData", "fbType", "initRendererEnvironment", "isCameraNeedResume", "isLocalUseFaceBeauty", "onEnterFullscreen", "onFrameDataReady", "width", "height", "useEncodeSurface", "onHWDecModeSet", "isSmallViewShowSelf", "onOrientationChange", "rotation", "onRenderModeChanged", "onSurfaceTextureCallDestroy", "renderGLSurface", "onSurfaceTextureCallSizeChanged", "onSurfaceTextureReady", "onSwitchCamera", "ret", "Lkotlin/Function1;", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "setHWDecMode", "mode", "setLocalRenderOrientation", "rotateDegree", "setLocalVideoSize", "isVoipBeautySupported", "isSTFilterSupport", "setRemoteVideoData", "outData", "", "setScreenRotation", "setSpatiotemporalDenosing", "cmd", "setVoipBeauty", "stopEncoderRender", "stop", "unInitCaptureRender", "Companion", "RendererViewEvent", "VoipRawData", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a UTa;
  private long Lnu;
  public boolean UIF;
  public int UII;
  private com.tencent.mm.cm.a.j UPF;
  private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> URT;
  private int UTA;
  private int UTB;
  private int UTC;
  private kotlin.g.a.r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> UTD;
  e UTb;
  public com.tencent.mm.plugin.voip.video.camera.a.a UTc;
  public boolean UTd;
  private int UTe;
  private boolean UTf;
  private byte[] UTg;
  private ByteBuffer UTh;
  private int UTi;
  public boolean UTj;
  public boolean UTk;
  public o UTl;
  private com.tencent.mm.plugin.voip.video.b.a UTm;
  private boolean UTn;
  private int UTo;
  private int UTp;
  private boolean UTq;
  private int UTr;
  private boolean UTs;
  private final int UTt;
  MMHandler UTu;
  public kotlin.g.a.a<ah> UTv;
  public boolean UTw;
  private final boolean UTx;
  private MTimerHandler UTy;
  private j UTz;
  private final int UwF;
  public int UxA;
  private int UxE;
  private int UxF;
  boolean Uxb;
  public boolean Uxn;
  public int Uxo;
  public int Uxz;
  public boolean isInit;
  public boolean mIsStarted;
  private int mWn;
  private int mWo;
  public int qpM;
  private long tick;
  
  static
  {
    AppMethodBeat.i(293249);
    UTa = new j.a((byte)0);
    AppMethodBeat.o(293249);
  }
  
  public j(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(293115);
    this.UTb = parame;
    this.Uxb = paramBoolean;
    this.UTj = true;
    this.mIsStarted = true;
    this.UTm = new com.tencent.mm.plugin.voip.video.b.a();
    this.UTo = -1;
    this.UTp = -1;
    this.UTr = 3;
    parame = com.tencent.mm.plugin.voip.f.h.ULL;
    Object localObject1;
    if (com.tencent.mm.plugin.voip.f.h.ibC())
    {
      i = 1;
      this.UTt = i;
      this.UTu = new MMHandler("encodeVoipHandler", new j..ExternalSyntheticLambda0(this));
      parame = com.tencent.mm.util.i.agtt;
      this.UwF = com.tencent.mm.util.i.a(b.a.agsJ, 0);
      this.UTx = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySp, true);
      parame = idw();
      localObject1 = com.tencent.mm.plugin.voip.f.i.ULP;
      long l1 = parame.getWidth();
      long l2 = parame.getHeight();
      localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
      com.tencent.mm.plugin.voip.f.j.wY(l1);
      localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
      com.tencent.mm.plugin.voip.f.j.wZ(l2);
      this.UTl = new o();
      localObject1 = this.UTl;
      if (localObject1 != null)
      {
        ((o)localObject1).UUs = new h(parame.getWidth(), parame.getHeight(), ((o)localObject1).UUw);
        ((o)localObject1).UUt = new p(true);
        ((o)localObject1).UUu = new p(false);
        if (!((o)localObject1).UUw) {
          ((o)localObject1).UUv = new b();
        }
      }
      parame = this.UTl;
      if (parame != null) {
        parame.bl(com.tencent.mm.plugin.voip.f.e.ULB, com.tencent.mm.plugin.voip.f.e.ULC, com.tencent.mm.plugin.voip.f.e.ULD);
      }
      parame = this.UTl;
      if (parame != null)
      {
        Object localObject2 = (kotlin.g.a.b)new l(this);
        localObject1 = new ah.e();
        ((ah.e)localObject1).aixc = -1L;
        h localh = parame.UUs;
        if (localh != null) {
          localh.aN((kotlin.g.a.b)new o.b(parame, (kotlin.g.a.b)localObject2));
        }
        localObject2 = parame.UUs;
        if (localObject2 != null) {
          ((h)localObject2).USh = ((kotlin.g.a.b)new o.c((ah.e)localObject1));
        }
        localObject2 = parame.UUt;
        if (localObject2 != null) {
          ((f)localObject2).USh = ((kotlin.g.a.b)new o.d(parame, (ah.e)localObject1));
        }
        parame = parame.UUs;
        if (parame != null) {
          parame.start();
        }
      }
      parame = this.UTl;
      if (parame != null)
      {
        localObject1 = (q)new m(this);
        if (!parame.UUw) {
          break label640;
        }
        parame = parame.UUs;
        if (parame != null) {
          break label632;
        }
        parame = null;
        label478:
        if (parame != null) {
          parame.URA = ((q)localObject1);
        }
      }
      label488:
      parame = this.UTl;
      if (parame != null)
      {
        parame.USr = this.UTb;
        localObject1 = parame.UUt;
        if (localObject1 != null) {
          ((f)localObject1).USr = parame.USr;
        }
        localObject1 = parame.UUu;
        if (localObject1 != null) {
          ((f)localObject1).USr = parame.USr;
        }
      }
      parame = com.tencent.mm.plugin.voip.d.c.UGb;
      if (!com.tencent.mm.plugin.voip.f.h.ibI()) {
        break label658;
      }
    }
    label640:
    label658:
    for (int i = j;; i = 0)
    {
      com.tencent.mm.plugin.voip.d.c.aqF(i);
      parame = i.USW;
      i.reset();
      parame = com.tencent.mm.plugin.voip.f.e.ULA;
      com.tencent.mm.plugin.voip.f.e.clear();
      parame = com.tencent.mm.plugin.voip.d.e.UGU;
      com.tencent.mm.plugin.voip.d.e.hZR();
      parame = this.UTu;
      if (parame != null) {
        parame.setLogging(false);
      }
      this.URT = new HashMap();
      this.UTz = new j(this);
      AppMethodBeat.o(293115);
      return;
      i = 4;
      break;
      label632:
      parame = parame.USM;
      break label478;
      parame = parame.UUv;
      if (parame == null) {
        break label488;
      }
      parame.URA = ((q)localObject1);
      break label488;
    }
  }
  
  private static final boolean a(j paramj)
  {
    AppMethodBeat.i(293189);
    s.u(paramj, "this$0");
    int i;
    Object localObject;
    label94:
    com.tencent.mm.plugin.voip.video.camera.a.a locala;
    if ((paramj.UTc != null) && (paramj.UTb.hVT()))
    {
      long l = com.tencent.mm.plugin.voip.f.h.ibu();
      if ((paramj.Lnu == 0L) || (Util.ticksToNow(paramj.Lnu) <= l)) {
        break label163;
      }
      Log.i("MicroMsg.VoIPRenderMgr", "current camera is open but has no video ");
      i = 1;
      if ((i != 0) && (paramj.UTc != null))
      {
        localObject = paramj.UTl;
        if (localObject != null) {
          break label168;
        }
        localObject = null;
        if (localObject != null)
        {
          locala = paramj.UTc;
          if (locala != null) {
            break label178;
          }
        }
      }
    }
    label163:
    label168:
    label178:
    for (boolean bool = true;; bool = locala.icu())
    {
      paramj.b((h)localObject, bool);
      if ((SubCoreVoip.hVp().Uxh != 0L) && (Util.secondsToNow(SubCoreVoip.hVp().Uxh) >= 360L))
      {
        paramj = com.tencent.mm.plugin.voip.d.e.UGU;
        com.tencent.mm.plugin.voip.d.e.hZS();
      }
      AppMethodBeat.o(293189);
      return true;
      i = 0;
      break;
      localObject = ((o)localObject).UUs;
      break label94;
    }
  }
  
  private static final boolean a(j paramj, Message paramMessage)
  {
    int j = 0;
    AppMethodBeat.i(293185);
    s.u(paramj, "this$0");
    s.u(paramMessage, "it");
    paramMessage = paramMessage.obj;
    Object localObject1;
    int i;
    label142:
    Object localObject2;
    if (paramMessage != null)
    {
      if (!(paramMessage instanceof c)) {
        break label253;
      }
      if (paramMessage != null)
      {
        Log.d("MicroMsg.VoIPRenderMgr", "voip encode in post data ");
        localObject1 = com.tencent.mm.plugin.voip.d.b.UFY;
        com.tencent.mm.plugin.voip.d.b.hZB();
        if (((c)paramMessage).UTF == null) {
          break label280;
        }
        paramj.tick = Util.currentTicks();
        i = SubCoreVoip.hVp().b(((c)paramMessage).UTF, ((c)paramMessage).UTG, ((c)paramMessage).UTH, ((c)paramMessage).UTI, ((c)paramMessage).UTJ, ((c)paramMessage).dataType);
        localObject1 = ((c)paramMessage).UTF;
        if (localObject1 != null) {
          break label258;
        }
        localObject1 = null;
        localObject2 = (LinkedBlockingQueue)((Map)paramj.URT).get(localObject1);
        if (localObject2 != null) {
          break label271;
        }
        label166:
        if (j >= 2) {
          break label379;
        }
        localObject1 = (LinkedBlockingQueue)((Map)paramj.URT).get(localObject1);
        if (localObject1 == null) {
          break label379;
        }
        ((LinkedBlockingQueue)localObject1).add(((c)paramMessage).UTF);
      }
    }
    label258:
    label271:
    label280:
    label379:
    for (;;)
    {
      if (i == 1)
      {
        localObject1 = com.tencent.mm.plugin.voip.d.b.UFY;
        com.tencent.mm.plugin.voip.d.b.hZC();
      }
      paramj.UTb.bh(i, ((c)paramMessage).UTI, ((c)paramMessage).UTJ);
      AppMethodBeat.o(293185);
      return true;
      label253:
      paramMessage = null;
      break;
      localObject1 = Integer.valueOf(((ByteBuffer)localObject1).capacity());
      break label142;
      j = ((LinkedBlockingQueue)localObject2).size();
      break label166;
      if (((c)paramMessage).UTE != null)
      {
        localObject1 = SubCoreVoip.hVp();
        localObject2 = ((c)paramMessage).UTE;
        i = ((c)paramMessage).UTG;
        j = ((c)paramMessage).UTH;
        int k = ((c)paramMessage).UTI;
        int m = ((c)paramMessage).UTJ;
        new Point(0, 0);
        i = ((com.tencent.mm.plugin.voip.model.u)localObject1).UBE.UvO.UyW.b((byte[])localObject2, i, j, k, m);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private com.tencent.mm.plugin.voip.video.b.a arx(final int paramInt)
  {
    AppMethodBeat.i(293170);
    Object localObject2;
    Object localObject1;
    if (this.UTD == null)
    {
      this.UTD = ((kotlin.g.a.r)new k(this, paramInt));
      localObject2 = this.UTl;
      if (localObject2 != null)
      {
        localObject1 = this.UTD;
        if (!((o)localObject2).UUw) {
          break label105;
        }
        localObject2 = ((o)localObject2).UUs;
        if (localObject2 != null)
        {
          localObject2 = ((h)localObject2).USM;
          if ((localObject2 != null) && (localObject1 != null) && (!((a)localObject2).URz.contains(localObject1))) {
            ((a)localObject2).URz.add(localObject1);
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.UTm;
      AppMethodBeat.o(293170);
      return localObject1;
      label105:
      localObject2 = ((o)localObject2).UUv;
      if ((localObject2 != null) && (localObject1 != null) && (!((b)localObject2).URz.contains(localObject1))) {
        ((b)localObject2).URz.add(localObject1);
      }
    }
  }
  
  private final void b(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(293128);
    Log.printInfoStack("MicroMsg.VoIPRenderMgr", "bindCameraRenderer", new Object[0]);
    int j;
    if (!this.UTf)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      j = 640;
      if (!v2protocal.UDp) {
        break label319;
      }
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      j = 1280;
    }
    label314:
    label319:
    for (int i = 720;; i = 480)
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala;
      if (this.UTc == null)
      {
        if (com.tencent.mm.plugin.voip.f.h.ibB())
        {
          locala = (com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.b.a(this.UTb.getContext(), j, i);
          this.UTc = locala;
          aru(this.qpM);
        }
      }
      else
      {
        paramh = paramh.surfaceTexture;
        if (paramh != null)
        {
          locala = this.UTc;
          if (locala != null)
          {
            com.tencent.mm.plugin.voip.d.a locala1 = com.tencent.mm.plugin.voip.d.a.UFW;
            com.tencent.mm.plugin.voip.d.a.hZx();
            if (locala.a((com.tencent.mm.plugin.voip.video.camera.a.c)this.UTz, paramBoolean) != 1) {
              break label314;
            }
          }
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.UTj = paramBoolean;
        if (this.UTj)
        {
          locala.v(paramh);
          SubCoreVoip.hVp().aqt(locala.icw());
          if ((this.UTc != null) && (locala.hq() != null))
          {
            paramh = this.UTc;
            if (paramh != null) {
              paramh.onOrientationChange(this.qpM);
            }
            paramh = this.UTc;
            if (paramh != null) {
              paramh.icx();
            }
            this.UTe = 0;
            this.UTf = true;
            paramh = this.UTc;
            if (paramh != null)
            {
              paramh = paramh.hq();
              if (paramh != null) {
                k(paramh);
              }
            }
            aru(this.qpM);
          }
        }
        AppMethodBeat.o(293128);
        return;
        locala = (com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.prev.c(j, i);
        break;
      }
    }
  }
  
  private final void bx(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(293149);
    Object localObject2 = idw();
    Object localObject1 = this.UTc;
    int i;
    label68:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).hq();
      if (localObject1 != null) {
        if ((((Size)localObject1).getHeight() != ((Size)localObject2).getHeight()) || (((Size)localObject1).getWidth() != ((Size)localObject2).getWidth()))
        {
          i = 1;
          if (i == 0) {
            break label404;
          }
          if (localObject1 == null) {
            break label1273;
          }
          localObject1 = new Size(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
          Log.i("MicroMsg.VoIPRenderMgr", "force update draw size");
          k = 1;
        }
      }
    }
    for (;;)
    {
      localObject2 = SubCoreVoip.hVp().UBE.UvO.UyW;
      int m;
      label206:
      float f;
      if ((((com.tencent.mm.plugin.voip.model.n)localObject2).UvO != null) && (((com.tencent.mm.plugin.voip.model.n)localObject2).UvO.UyU != null))
      {
        byte[] arrayOfByte = new byte[4];
        if (((com.tencent.mm.plugin.voip.model.n)localObject2).UvO.UyU.setAppCmd(com.tencent.mm.plugin.voip.model.n.UzX, arrayOfByte, 4) >= 0)
        {
          i = Util.byteArrayToInt(arrayOfByte);
          j = i >> 16;
          m = i & 0xFFFF;
          if (((com.tencent.mm.plugin.voip.model.n)localObject2).UwF == 0) {
            break label1262;
          }
          if (((com.tencent.mm.plugin.voip.model.n)localObject2).UwF != 1) {
            break label410;
          }
          i = 480;
          f = i;
        }
      }
      for (int j = (int)(m * 1.0F / j * f);; j = m)
      {
        int n = i;
        m = j;
        if (!v2protocal.UDn) {
          if (i < 1280)
          {
            n = i;
            m = j;
            if (j < 1280) {}
          }
          else
          {
            n = ((i >> 1) + 8) / 16 * 16;
            m = ((j >> 1) + 8) / 16 * 16;
          }
        }
        localObject2 = com.tencent.mm.plugin.voip.f.e.ULA;
        com.tencent.mm.plugin.voip.f.e.fu(n, m);
        label304:
        i = com.tencent.mm.plugin.voip.f.e.ULB;
        j = com.tencent.mm.plugin.voip.f.e.ULC;
        if (this.UTq)
        {
          this.UTr = 3;
          label326:
          localObject2 = this.UTl;
          if (localObject2 != null) {
            ((o)localObject2).bl(com.tencent.mm.plugin.voip.f.e.ULB, com.tencent.mm.plugin.voip.f.e.ULC, com.tencent.mm.plugin.voip.f.e.ULD);
          }
          SubCoreVoip.hVp();
          if ((!v2protocal.UDp) || ((!paramBoolean1) && (!paramBoolean2))) {
            break label480;
          }
          this.UTs = true;
        }
        for (;;)
        {
          if ((this.UwF != 0) && ((i <= 0) || (j <= 0)))
          {
            AppMethodBeat.o(293149);
            return;
            i = 0;
            break;
            label404:
            localObject1 = null;
            break label68;
            label410:
            if (((com.tencent.mm.plugin.voip.model.n)localObject2).UwF == 2)
            {
              i = 640;
              break label206;
            }
            if (((com.tencent.mm.plugin.voip.model.n)localObject2).UwF != 3) {
              break label1255;
            }
            i = 1280;
            break label206;
            localObject2 = com.tencent.mm.plugin.voip.f.e.ULA;
            com.tencent.mm.plugin.voip.f.e.clear();
            break label304;
            if (this.UTr <= 0) {
              break label326;
            }
            this.UTr -= 1;
            this.UTq = true;
            break label326;
            label480:
            this.UTs = false;
            if ((k == 0) && (!this.UTq))
            {
              AppMethodBeat.o(293149);
              return;
            }
          }
        }
        if (this.UTq) {
          aru(this.qpM);
        }
        if ((!this.UTq) && (this.UTo == i) && (this.UTp == j))
        {
          AppMethodBeat.o(293149);
          return;
        }
        this.UTo = i;
        this.UTp = j;
        this.UTq = false;
        localObject2 = new StringBuilder("setLocalVideoSize 720pEncodeFlag:");
        SubCoreVoip.hVp();
        Log.i("MicroMsg.VoIPRenderMgr", v2protocal.UDn + ", outSize:[" + i + ", " + j + ']');
        if ((i >= 1280) || (j >= 720))
        {
          SubCoreVoip.hVp();
          if (v2protocal.UDn)
          {
            if (((Size)localObject1).getHeight() * j > ((Size)localObject1).getWidth() * i)
            {
              this.mWn = j;
              f = j / ((Size)localObject1).getWidth();
              this.mWo = (((int)(((Size)localObject1).getHeight() * f) + 4) / 8 * 8);
            }
            for (;;)
            {
              Log.i("MicroMsg.VoIPRenderMgr", "setLocalVideoSize update to 1280p [" + this.mWn + ',' + this.mWo + ']');
              Log.i("MicroMsg.VoIPRenderMgr", "hseasun: set LocalSize: " + this.mWn + ' ' + this.mWo + " EncRes: " + i + ' ' + j);
              localObject1 = this.UTl;
              if (localObject1 == null) {
                break label1248;
              }
              i = this.mWn;
              j = this.mWo;
              if (((o)localObject1).UUw) {
                break;
              }
              localObject1 = ((o)localObject1).UUv;
              if (localObject1 == null) {
                break label1248;
              }
              Log.i("MicroMsg.EncodeWindowSurfaceRenderer", "updateEncodeSize:[" + i + ',' + j + ']');
              ((b)localObject1).mWidth = j;
              ((b)localObject1).mHeight = i;
              localObject2 = ((f)localObject1).URB;
              if (localObject2 != null) {
                ((g)localObject2).mO(j, i);
              }
              localObject1 = ((f)localObject1).USn;
              if (localObject1 != null) {
                ((n)localObject1).ek(i, j);
              }
              AppMethodBeat.o(293149);
              return;
              this.mWo = ((Size)localObject1).getHeight();
              this.mWn = ((Size)localObject1).getWidth();
            }
          }
        }
        if (((Size)localObject1).getHeight() * j > ((Size)localObject1).getWidth() * i)
        {
          this.mWn = 480;
          f = this.mWn / ((Size)localObject1).getWidth();
          this.mWo = (((int)(((Size)localObject1).getHeight() * f) + 4) / 8 * 8);
        }
        for (;;)
        {
          Log.i("MicroMsg.VoIPRenderMgr", "setLocalVideoSize update to normal size [" + this.mWn + ',' + this.mWo + ']');
          break;
          this.mWo = 640;
          f = this.mWo / ((Size)localObject1).getHeight();
          this.mWn = (((int)(((Size)localObject1).getWidth() * f) + 4) / 8 * 8);
        }
        localObject1 = ((o)localObject1).UUs;
        if (localObject1 != null)
        {
          localObject1 = ((h)localObject1).USM;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.EncodeWindowSurfaceRenderer", "updateEncodeSize:[" + i + ',' + j + ']');
            ((a)localObject1).mWidth = j;
            ((a)localObject1).mHeight = i;
            localObject2 = ((a)localObject1).URB;
            if (localObject2 != null) {
              ((g)localObject2).mO(j, i);
            }
            localObject1 = ((a)localObject1).URD;
            if (localObject1 != null) {
              ((l)localObject1).ek(i, j);
            }
          }
        }
        label1248:
        AppMethodBeat.o(293149);
        return;
        label1255:
        i = j;
        break label206;
        label1262:
        i = j;
      }
      label1273:
      k = 0;
      localObject1 = localObject2;
    }
  }
  
  private final void idt()
  {
    AppMethodBeat.i(293154);
    Log.printDebugStack("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.UTc != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala = this.UTc;
      if (locala != null) {
        locala.unInit();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.VoIPRenderMgr", s.X("stop capture error:", localException));
      }
    }
    this.UTc = null;
    AppMethodBeat.o(293154);
  }
  
  private static Size idw()
  {
    AppMethodBeat.i(293163);
    int j = 640;
    int i = 480;
    if (v2protocal.UDp)
    {
      j = 1280;
      i = 720;
    }
    Size localSize = new Size(j, i);
    AppMethodBeat.o(293163);
    return localSize;
  }
  
  private final void k(Size paramSize)
  {
    AppMethodBeat.i(293159);
    Object localObject = this.UTl;
    if (localObject != null) {
      ((o)localObject).k(paramSize);
    }
    localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.bfL(paramSize.getWidth() + ':' + paramSize.getHeight());
    AppMethodBeat.o(293159);
  }
  
  public final void GY(boolean paramBoolean)
  {
    AppMethodBeat.i(293292);
    o localo = this.UTl;
    if (localo != null) {
      localo.Ha(paramBoolean);
    }
    AppMethodBeat.o(293292);
  }
  
  public final g a(SurfaceTexture paramSurfaceTexture, final int paramInt)
  {
    AppMethodBeat.i(293284);
    s.u(paramSurfaceTexture, "surfaceTexture");
    if (!this.UTw)
    {
      this.UTw = true;
      localo = this.UTl;
      if (localo != null) {
        localo.bZ((kotlin.g.a.a)new d(this));
      }
    }
    paramSurfaceTexture = new g(paramSurfaceTexture, (byte)0);
    o localo = this.UTl;
    if (localo != null) {
      localo.a(paramSurfaceTexture, (kotlin.g.a.b)new e(this, paramInt));
    }
    AppMethodBeat.o(293284);
    return paramSurfaceTexture;
  }
  
  public final void aru(int paramInt)
  {
    com.tencent.mm.plugin.voip.video.camera.a.a locala = null;
    boolean bool2 = false;
    AppMethodBeat.i(293280);
    StringBuilder localStringBuilder = new StringBuilder("set rotate degress ").append(paramInt).append(" and capture render is ");
    Object localObject = this.UTc;
    label78:
    label107:
    int i;
    label152:
    int j;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append("  and camera is ");
      localObject = this.UTc;
      if (localObject != null) {
        break label242;
      }
      localObject = locala;
      localObject = localStringBuilder.append(localObject).append(",and ");
      locala = this.UTc;
      if (locala != null) {
        break label255;
      }
      bool1 = false;
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", bool1, new Object[0]);
      this.qpM = paramInt;
      if (this.UTc != null)
      {
        localObject = this.UTc;
        if (localObject != null) {
          break label265;
        }
        i = 0;
        localObject = this.UTc;
        if (localObject != null) {
          break label274;
        }
        j = 0;
        label165:
        localObject = this.UTc;
        if (localObject != null) {
          break label283;
        }
      }
    }
    label265:
    label274:
    label283:
    for (boolean bool1 = bool2;; bool1 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).bqb())
    {
      localObject = this.UTl;
      if (localObject != null) {
        ((o)localObject).q((i + 360 - paramInt) % 360, bool1, (j + 360 + 270) % 360);
      }
      AppMethodBeat.o(293280);
      return;
      localObject = Integer.valueOf(((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icz());
      break;
      label242:
      localObject = Integer.valueOf(((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icA());
      break label78;
      label255:
      bool1 = locala.bqb();
      break label107;
      i = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icA();
      break label152;
      j = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icA();
      break label165;
    }
  }
  
  public final void d(g paramg, int paramInt)
  {
    AppMethodBeat.i(293287);
    s.u(paramg, "renderGLSurface");
    o localo = this.UTl;
    if (localo != null) {
      localo.a(paramg, paramInt);
    }
    paramg = this.UTl;
    if (paramg != null) {
      paramg.idi();
    }
    AppMethodBeat.o(293287);
  }
  
  public final void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293290);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(293290);
      return;
    }
    o localo;
    if (this.UTn)
    {
      if (this.UTx)
      {
        localo = this.UTl;
        if (localo != null) {
          localo.i(new Size(paramInt2, paramInt1));
        }
      }
      AppMethodBeat.o(293290);
      return;
    }
    this.UxE = paramInt2;
    this.UxF = paramInt1;
    if ((this.mIsStarted) && (this.UTl != null))
    {
      this.UTn = true;
      onOrientationChange(this.qpM);
      localo = this.UTl;
      if (localo != null) {
        localo.i(new Size(paramInt2, paramInt1));
      }
      aru(this.qpM);
    }
    AppMethodBeat.o(293290);
  }
  
  public final void ids()
  {
    AppMethodBeat.i(293268);
    long l = com.tencent.mm.plugin.voip.f.h.ibu();
    if (this.UTy == null)
    {
      this.UTy = new MTimerHandler("CameraPreviewInvalidChecker", new j..ExternalSyntheticLambda1(this), true);
      MTimerHandler localMTimerHandler = this.UTy;
      if (localMTimerHandler != null) {
        localMTimerHandler.startTimer(l);
      }
    }
    this.Lnu = Util.currentTicks();
    AppMethodBeat.o(293268);
  }
  
  public final void idu()
  {
    Object localObject2 = null;
    AppMethodBeat.i(293274);
    Object localObject1;
    if (af.lXY.lST == 1)
    {
      localObject1 = this.UTl;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((o)localObject1).UUs)
      {
        AppMethodBeat.o(293274);
        return;
      }
      b((h)localObject1, true);
    }
    if ((!this.UTj) || (af.lXY.lST == 1) || (af.lXY.lSU == 1))
    {
      boolean bool;
      if (this.UTc != null)
      {
        localObject1 = this.UTc;
        if (localObject1 == null)
        {
          bool = true;
          if (!bool) {
            break label135;
          }
        }
      }
      else
      {
        bool = true;
        label105:
        localObject1 = this.UTl;
        if (localObject1 != null) {
          break label140;
        }
      }
      label135:
      label140:
      for (localObject1 = localObject2;; localObject1 = ((o)localObject1).UUs)
      {
        if (localObject1 != null) {
          break label148;
        }
        AppMethodBeat.o(293274);
        return;
        bool = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).icu();
        break;
        bool = false;
        break label105;
      }
      label148:
      b((h)localObject1, bool);
      this.UTj = true;
    }
    AppMethodBeat.o(293274);
  }
  
  public final void idv()
  {
    AppMethodBeat.i(293277);
    com.tencent.mm.plugin.voip.video.camera.a.a locala = this.UTc;
    Object localObject;
    if (locala != null)
    {
      locala.ggH();
      localObject = this.UTl;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((o)localObject).UUs)
      {
        AppMethodBeat.o(293277);
        return;
      }
      if (locala.a((com.tencent.mm.plugin.voip.video.camera.a.c)this.UTz, true) != 1) {
        break label196;
      }
    }
    label196:
    for (boolean bool = true;; bool = false)
    {
      this.UTj = bool;
      if (this.UTj)
      {
        localObject = ((h)localObject).surfaceTexture;
        if (localObject != null) {
          locala.v((SurfaceTexture)localObject);
        }
        SubCoreVoip.hVp().aqt(locala.icw());
        if ((this.UTc != null) && (locala.hq() != null))
        {
          localObject = this.UTc;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).onOrientationChange(this.qpM);
          }
          localObject = this.UTc;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icx();
          }
          this.UTe = 0;
          this.UTf = true;
          localObject = this.UTc;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).hq();
            if (localObject != null) {
              k((Size)localObject);
            }
          }
          aru(this.qpM);
        }
      }
      AppMethodBeat.o(293277);
      return;
    }
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(293265);
    this.qpM = paramInt;
    com.tencent.mm.plugin.voip.video.camera.a.a locala = this.UTc;
    if (locala != null) {
      locala.onOrientationChange(paramInt);
    }
    AppMethodBeat.o(293265);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293295);
    Object localObject = i.USW;
    i.report();
    localObject = com.tencent.mm.plugin.voip.f.e.ULA;
    com.tencent.mm.plugin.voip.f.e.clear();
    localObject = this.UTu;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.UTu = null;
    idt();
    localObject = this.UTl;
    if (localObject != null) {
      ((o)localObject).release();
    }
    localObject = this.UTy;
    if (localObject != null) {
      ((MTimerHandler)localObject).stopTimer();
    }
    localObject = this.UTy;
    if (localObject != null) {
      ((MTimerHandler)localObject).quitSafely();
    }
    this.UTy = null;
    this.UTg = null;
    this.UTi = 0;
    this.Lnu = 0L;
    AppMethodBeat.o(293295);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    int i = 2;
    long l2 = 0L;
    AppMethodBeat.i(293289);
    Log.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.UII) });
    boolean bool;
    if (this.UII != paramInt)
    {
      this.UII = paramInt;
      localObject = com.tencent.mm.plugin.voip.d.g.UHs;
      if ((this.UII & 0x1) == 0) {
        break label223;
      }
      bool = true;
      com.tencent.mm.plugin.voip.d.g.Gx(bool);
      localObject = com.tencent.mm.plugin.voip.d.c.UGb;
      localObject = com.tencent.mm.plugin.voip.d.c.hZD();
      if ((this.UII & 0x1) == 0) {
        break label229;
      }
      paramInt = 1;
      label97:
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label234;
      }
      l1 = 0L;
      label110:
      ((ConcurrentLinkedQueue)localObject).add(new kotlin.r(Integer.valueOf(paramInt), Long.valueOf(l1)));
      localObject = com.tencent.mm.plugin.voip.d.c.UGb;
      localObject = com.tencent.mm.plugin.voip.d.c.hZE();
      paramInt = i;
      if (this.UII >> 8 != 0) {
        paramInt = 1;
      }
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label247;
      }
    }
    label223:
    label229:
    label234:
    label247:
    for (long l1 = l2;; l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh))
    {
      ((ConcurrentLinkedQueue)localObject).add(new kotlin.r(Integer.valueOf(paramInt), Long.valueOf(l1)));
      if ((this.UII & 0x1) == 0) {
        break label260;
      }
      localObject = this.UTl;
      if (localObject == null) {
        break label277;
      }
      ((o)localObject).setShowMode(1);
      AppMethodBeat.o(293289);
      return;
      bool = false;
      break;
      paramInt = 2;
      break label97;
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
      break label110;
    }
    label260:
    Object localObject = this.UTl;
    if (localObject != null) {
      ((o)localObject).setShowMode(0);
    }
    label277:
    AppMethodBeat.o(293289);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$VoipRawData;", "", "()V", "dataType", "", "getDataType", "()I", "setDataType", "(I)V", "encodeBuffer", "Ljava/nio/ByteBuffer;", "getEncodeBuffer", "()Ljava/nio/ByteBuffer;", "setEncodeBuffer", "(Ljava/nio/ByteBuffer;)V", "encodeData", "", "getEncodeData", "()[B", "setEncodeData", "([B)V", "encodeFormat", "getEncodeFormat", "setEncodeFormat", "encodeHeight", "getEncodeHeight", "setEncodeHeight", "encodeLength", "getEncodeLength", "setEncodeLength", "encodeWidth", "getEncodeWidth", "setEncodeWidth", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    byte[] UTE;
    ByteBuffer UTF;
    int UTG;
    int UTH;
    int UTI;
    int UTJ;
    int dataType;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<g, ah>
  {
    e(j paramj, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public f(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$2", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements j.b
  {
    private g UTM;
    
    public g(j paramj) {}
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(293004);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if ((paramSurface != null) && (paramSurface.isValid())) {
          paramSurface = new g(paramSurface, 0, 0, (byte)0);
        }
        for (;;)
        {
          this.UTM = paramSurface;
          paramSurface = this.UTM;
          if (paramSurface != null) {
            break;
          }
          AppMethodBeat.o(293004);
          return;
          if (paramSurfaceTexture != null)
          {
            paramSurface = new g(paramSurfaceTexture, (byte)0);
          }
          else
          {
            Log.e("MicroMsg.VoIPRenderMgr", "surface onView create failed cause not valid");
            paramSurface = null;
          }
        }
        paramSurfaceTexture = j.d(this.UTK);
        if ((paramSurfaceTexture == null) || (paramSurfaceTexture.b(paramSurface) != true)) {
          break label138;
        }
      }
      label138:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramSurfaceTexture = j.d(this.UTK);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.b(paramSurface, paramInt);
          }
        }
        AppMethodBeat.o(293004);
        return;
      }
    }
    
    public final void ary(int paramInt)
    {
      AppMethodBeat.i(293011);
      g localg = this.UTM;
      if (localg != null)
      {
        Object localObject = this.UTK;
        o localo = j.d((j)localObject);
        if (localo != null) {
          localo.a(localg);
        }
        localObject = j.d((j)localObject);
        if (localObject != null) {
          ((o)localObject).c(localg, paramInt);
        }
        this.UTM = null;
      }
      AppMethodBeat.o(293011);
    }
    
    public final void bm(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(293017);
      Object localObject = this.UTM;
      if (localObject != null)
      {
        j localj = this.UTK;
        ((g)localObject).mO(paramInt1, paramInt2);
        o localo = j.d(localj);
        if (localo != null) {
          localo.a((g)localObject, paramInt3);
        }
        localObject = j.d(localj);
        if (localObject != null) {
          ((o)localObject).idi();
        }
      }
      AppMethodBeat.o(293017);
    }
    
    public final void idx()
    {
      AppMethodBeat.i(292992);
      o localo = j.d(this.UTK);
      if (localo != null) {
        localo.idH();
      }
      AppMethodBeat.o(292992);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public h(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$4", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements j.b
  {
    private g UTM;
    
    public i(j paramj) {}
    
    public final void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(293003);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if ((paramSurface != null) && (paramSurface.isValid())) {
          paramSurface = new g(paramSurface, 0, 0, (byte)0);
        }
        for (;;)
        {
          this.UTM = paramSurface;
          Log.i("MicroMsg.VoIPRenderMgr", s.X("onViewCreated in VoIPRenderSurfaceView ", this.UTM));
          paramSurface = this.UTM;
          if (paramSurface != null) {
            break;
          }
          AppMethodBeat.o(293003);
          return;
          if (paramSurfaceTexture != null)
          {
            paramSurface = new g(paramSurfaceTexture, (byte)0);
          }
          else
          {
            Log.e("MicroMsg.VoIPRenderMgr", "surface onView create failed cause not valid");
            paramSurface = null;
          }
        }
        paramSurfaceTexture = j.d(this.UTK);
        if ((paramSurfaceTexture == null) || (paramSurfaceTexture.b(paramSurface) != true)) {
          break label152;
        }
      }
      label152:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramSurfaceTexture = j.d(this.UTK);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.b(paramSurface, paramInt);
          }
        }
        AppMethodBeat.o(293003);
        return;
      }
    }
    
    public final void ary(int paramInt)
    {
      AppMethodBeat.i(293012);
      Log.i("MicroMsg.VoIPRenderMgr", s.X("onViewDestroy in VoIPRenderSurfaceView ", this.UTM));
      g localg = this.UTM;
      if (localg == null)
      {
        AppMethodBeat.o(293012);
        return;
      }
      localg.GX(true);
      o localo = j.d(this.UTK);
      if (localo != null) {
        localo.a(localg);
      }
      localo = j.d(this.UTK);
      if (localo != null) {
        localo.c(localg, paramInt);
      }
      this.UTM = null;
      AppMethodBeat.o(293012);
    }
    
    public final void bm(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(293018);
      Object localObject = this.UTM;
      if (localObject != null)
      {
        j localj = this.UTK;
        ((g)localObject).mO(paramInt1, paramInt2);
        o localo = j.d(localj);
        if (localo != null) {
          localo.a((g)localObject, paramInt3);
        }
        localObject = j.d(localj);
        if (localObject != null) {
          ((o)localObject).idi();
        }
      }
      AppMethodBeat.o(293018);
    }
    
    public final void idx()
    {
      AppMethodBeat.i(292991);
      o localo = j.d(this.UTK);
      if (localo != null) {
        localo.idH();
      }
      AppMethodBeat.o(292991);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "onCameraError", "", "onCameraPreviewApply", "width", "", "height", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.plugin.voip.video.camera.a.c
  {
    j(j paramj) {}
    
    public final void Jd(int paramInt)
    {
      int j = 4;
      AppMethodBeat.i(293032);
      if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvd, true))
      {
        AppMethodBeat.o(293032);
        return;
      }
      com.tencent.mm.plugin.voip.video.camera.a.a locala;
      boolean bool;
      int i;
      if (this.UTK.UTc != null)
      {
        locala = this.UTK.UTc;
        if (locala == null)
        {
          bool = true;
          if (!bool) {
            break label120;
          }
        }
      }
      else
      {
        i = 1;
      }
      switch (paramInt)
      {
      case 3: 
      default: 
      case 2: 
        for (;;)
        {
          label67:
          SubCoreVoip.hVp().aqm(paramInt);
          AppMethodBeat.o(293032);
          return;
          bool = locala.icu();
          break;
          label120:
          i = 0;
          break label67;
          if (i != 0) {
            paramInt = 2;
          } else {
            paramInt = 4;
          }
        }
      }
      if (i != 0) {}
      for (paramInt = j;; paramInt = 2) {
        break;
      }
    }
    
    public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void dre()
    {
      AppMethodBeat.i(293023);
      this.UTK.UTb.hVS();
      com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.hZI();
      AppMethodBeat.o(293023);
    }
    
    public final void gG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(293029);
      Log.i("MicroMsg.VoIPRenderMgr", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
      Object localObject1 = j.d(this.UTK);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).UUs;
        if (localObject2 != null) {
          ((h)localObject2).width = paramInt1;
        }
        localObject1 = ((o)localObject1).UUs;
        if (localObject1 != null) {
          ((h)localObject1).height = paramInt2;
        }
      }
      localObject1 = this.UTK.UTc;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.voip.d.a.UFW;
        com.tencent.mm.plugin.voip.d.a.hz(paramInt1 + " x " + paramInt2, ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).icC());
      }
      j.g(this.UTK);
      AppMethodBeat.o(293029);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.r<ByteBuffer, Integer, Integer, Integer, ah>
  {
    k(j paramj, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<h, ah>
  {
    l(j paramj)
    {
      super();
    }
    
    private static final void i(j paramj)
    {
      AppMethodBeat.i(293005);
      s.u(paramj, "this$0");
      paramj.isInit = true;
      paramj = paramj.UTv;
      if (paramj != null) {
        paramj.invoke();
      }
      AppMethodBeat.o(293005);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height", "useEncodeSurface", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements q<Integer, Integer, Boolean, ah>
  {
    m(j paramj)
    {
      super();
    }
    
    private static final void b(j paramj, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(293006);
      s.u(paramj, "this$0");
      j.a(paramj, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(293006);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    public n(j paramj, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.j
 * JD-Core Version:    0.7.0.1
 */