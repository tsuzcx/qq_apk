package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.k;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.h.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.g.b.z.e;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "captureRenderer", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "decMode", "deviceOrientation", "drawHeight", "drawWidth", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isCameraStausChange", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "Ljava/nio/ByteBuffer;", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastEncHeight", "mLastEncWidth", "mLastHWDecH", "mLastHWDecW", "mLastSTFilterCmd", "mLocalIsMirror", "mLocalRotateAngle", "mPauseTransVideo", "mSTDenosingPreProcess", "Lcom/tencent/mm/video/videoprocessing/SpatiotemproalDenosingPreProcess;", "mSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "mSTFilterDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "mUpdateTimes", "mUseLastBeautyCnt", "mVoipWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "screenRotation", "tick", "", "getTick", "()J", "setTick", "(J)V", "use720pCapture", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "getSpatioTemporalFilterData", "initRendererEnvironment", "isLocalUseFaceBeauty", "onFrameDataReady", "onHWDecModeSet", "isSmallViewShowSelf", "onOrientationChange", "rotation", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", "setDeviceOrientation", "degree", "setHWDecMode", "mode", "setLocalRenderOrientation", "setLocalVideoSize", "isVoipBeautySupported", "isSTFilterSupport", "setRemoteVideoData", "outData", "", "setScreenRotation", "setSpatiotemporalDenosing", "cmd", "setVoipBeauty", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class j
{
  public static final j.a Hop;
  public int GUC;
  public int GUD;
  private int GUK;
  private int GUL;
  boolean GUf;
  public boolean GUq;
  public int GUr;
  public boolean GYb;
  private byte[] GYd;
  private ByteBuffer GYe;
  private int GYf;
  public boolean GYg;
  private int GYi;
  private com.tencent.mm.plugin.voip.b.a GYl;
  MMHandler GYm;
  public boolean HdG;
  public int HdK;
  public int Hir;
  private k HkU;
  public com.tencent.mm.plugin.voip.video.camera.a.a HnU;
  private boolean HnV;
  public boolean HnW;
  public m HnX;
  private com.tencent.mm.plugin.voip.video.b.a HnY;
  private com.tencent.mm.plugin.voip.video.d.b HnZ;
  private boolean Hoa;
  private int Hob;
  private int Hoc;
  public boolean Hod;
  private int Hoe;
  private boolean Hof;
  private final int Hog;
  public boolean Hoh;
  private g Hoi;
  private int Hoj;
  private int Hok;
  private int Hol;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Hom;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Hon;
  c Hoo;
  private int hEp;
  private int hEq;
  public int kyf;
  public boolean mIsStarted;
  long tick;
  
  static
  {
    AppMethodBeat.i(236291);
    Hop = new j.a((byte)0);
    AppMethodBeat.o(236291);
  }
  
  public j(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(236290);
    this.Hoo = paramc;
    this.GUf = paramBoolean;
    this.GYg = true;
    this.mIsStarted = true;
    this.HnY = new com.tencent.mm.plugin.voip.video.b.a();
    this.HnZ = new com.tencent.mm.plugin.voip.video.d.b();
    this.Hob = -1;
    this.Hoc = -1;
    this.Hoe = 3;
    paramc = com.tencent.mm.plugin.voip.b.g.HgZ;
    if (com.tencent.mm.plugin.voip.b.g.fKi())
    {
      paramc = com.tencent.mm.plugin.voip.b.g.HgZ;
      if (com.tencent.mm.plugin.voip.b.g.fKj())
      {
        i = 33;
        this.Hog = i;
        this.GYm = new MMHandler("encodeVoipHandler");
        this.GYl = new com.tencent.mm.plugin.voip.b.a();
        paramc = this.GYl;
        if ((this.HdK & 0x1) == 0) {
          break label559;
        }
      }
    }
    label559:
    for (int i = 1;; i = 0)
    {
      paramc.Z(true, i);
      this.GYl.fJK();
      paramc = fLX();
      this.HnX = new m();
      Object localObject1 = this.HnX;
      if (localObject1 != null)
      {
        ((m)localObject1).Hpj = new g(paramc.width, paramc.height);
        ((m)localObject1).Hpk = new n(true);
        ((m)localObject1).Hpl = new n(false);
      }
      paramc = this.HnX;
      if (paramc != null) {
        paramc.aF(com.tencent.mm.plugin.voip.b.c.HgN, com.tencent.mm.plugin.voip.b.c.HgO, com.tencent.mm.plugin.voip.b.c.HgP);
      }
      paramc = this.HnX;
      if (paramc != null)
      {
        kotlin.g.a.b localb = (kotlin.g.a.b)new j(this);
        localObject1 = new z.e();
        ((z.e)localObject1).SYF = -1L;
        Object localObject2 = paramc.Hpj;
        if (localObject2 != null)
        {
          localb = (kotlin.g.a.b)new m.b(paramc, localb);
          if ((((g)localObject2).ilw != null) || (((g)localObject2).Hny)) {
            localb.invoke(localObject2);
          }
          ((g)localObject2).k((kotlin.g.a.a)new g.b((g)localObject2, localb));
        }
        localObject2 = paramc.Hpj;
        if (localObject2 != null) {
          ((g)localObject2).Hnd = ((kotlin.g.a.b)new m.c(paramc, (z.e)localObject1));
        }
        localObject2 = paramc.Hpk;
        if (localObject2 != null) {
          ((d)localObject2).Hnd = ((kotlin.g.a.b)new m.d(paramc, (z.e)localObject1));
        }
        paramc = paramc.Hpj;
        if (paramc != null)
        {
          Log.i("MicroMsg.PboSurfaceRender", "start");
          paramc.k((kotlin.g.a.a)new g.n(paramc));
        }
      }
      if (com.tencent.mm.plugin.voip.b.g.fKg())
      {
        localObject1 = this.HnX;
        if (localObject1 != null)
        {
          paramc = (kotlin.g.a.a)new k(this);
          localObject1 = ((m)localObject1).Hpj;
          if (localObject1 != null) {
            ((g)localObject1).HnE = paramc;
          }
        }
      }
      paramc = this.HnX;
      if (paramc != null) {
        paramc.Hpm = this.Hoo;
      }
      paramc = i.HnR;
      i.reset();
      paramc = com.tencent.mm.plugin.voip.b.c.HgQ;
      com.tencent.mm.plugin.voip.b.c.clear();
      this.Hoi = new g(this);
      AppMethodBeat.o(236290);
      return;
      i = 39;
      break;
      i = 4;
      break;
    }
  }
  
  private final void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236277);
    Object localObject2 = fLX();
    Object localObject1 = this.HnU;
    int i;
    label68:
    label104:
    int j;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).fLc();
      if (localObject1 != null) {
        if ((((ac)localObject1).height != ((ac)localObject2).width) || (((ac)localObject1).width != ((ac)localObject2).height))
        {
          i = 1;
          if (i == 0) {
            break label218;
          }
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = new ac(((ac)localObject1).height, ((ac)localObject1).width);
          Log.i("MicroMsg.VoIPRenderMgr", "force update draw size");
          i = 1;
          com.tencent.mm.plugin.voip.c.fFg().fHZ();
          j = com.tencent.mm.plugin.voip.b.c.HgN;
          k = com.tencent.mm.plugin.voip.b.c.HgO;
          if (!this.Hod) {
            break label234;
          }
          this.Hoe = 3;
          label132:
          localObject2 = this.HnX;
          if (localObject2 != null) {
            ((m)localObject2).aF(com.tencent.mm.plugin.voip.b.c.HgN, com.tencent.mm.plugin.voip.b.c.HgO, com.tencent.mm.plugin.voip.b.c.HgP);
          }
          com.tencent.mm.plugin.voip.c.fFg();
          if ((!u.fIb()) || ((!paramBoolean1) && (!paramBoolean2))) {
            break label259;
          }
          this.Hof = true;
        }
      }
    }
    for (;;)
    {
      if ((!this.Hod) && (this.Hob == j) && (this.Hoc == k))
      {
        AppMethodBeat.o(236277);
        return;
        i = 0;
        break;
        label218:
        localObject1 = null;
        break label68;
        label224:
        i = 0;
        localObject1 = localObject2;
        break label104;
        label234:
        if (this.Hoe <= 0) {
          break label132;
        }
        this.Hoe -= 1;
        this.Hod = true;
        break label132;
        label259:
        this.Hof = false;
        if (i == 0)
        {
          AppMethodBeat.o(236277);
          return;
        }
      }
    }
    this.Hob = j;
    this.Hoc = k;
    this.Hod = false;
    float f;
    if ((j >= 1280) || (k >= 720))
    {
      com.tencent.mm.plugin.voip.c.fFg();
      if (u.fIa()) {
        if (((ac)localObject1).height * k > ((ac)localObject1).width * j)
        {
          this.hEp = k;
          f = k / ((ac)localObject1).width;
          this.hEq = (((int)(((ac)localObject1).height * f) + 8) / 16 * 16);
        }
      }
    }
    for (;;)
    {
      Log.i("EncoderSurfaceRender", "hseasun: set LocalSize: " + this.hEp + ' ' + this.hEq + " EncRes: " + j + ' ' + k);
      localObject1 = this.HnX;
      if (localObject1 != null)
      {
        i = this.hEp;
        j = this.hEq;
        localObject1 = ((m)localObject1).Hpj;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.PboSurfaceRender", "set Local Video Size [hseasun], width:%d height：%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((g)localObject1).k((kotlin.g.a.a)new g.j((g)localObject1, i, j));
        }
      }
      localObject2 = this.HnX;
      if (localObject2 == null) {
        break label787;
      }
      localObject1 = new ac(this.hEp, this.hEq);
      p.h(localObject1, "renderSize");
      localObject2 = ((m)localObject2).Hpk;
      if (localObject2 == null) {
        break label780;
      }
      localObject2 = ((d)localObject2).Hnj;
      if (localObject2 == null) {
        break;
      }
      Integer localInteger = Integer.valueOf(((ac)localObject1).width);
      if (localInteger == null) {
        p.hyc();
      }
      i = localInteger.intValue();
      localObject1 = Integer.valueOf(((ac)localObject1).height);
      if (localObject1 == null) {
        p.hyc();
      }
      ((l)localObject2).cZ(i, ((Integer)localObject1).intValue());
      AppMethodBeat.o(236277);
      return;
      this.hEq = ((ac)localObject1).height;
      this.hEp = ((ac)localObject1).width;
      continue;
      if (((ac)localObject1).height * k > ((ac)localObject1).width * j)
      {
        this.hEp = 480;
        f = this.hEp / ((ac)localObject1).width;
        this.hEq = (((int)(((ac)localObject1).height * f) + 8) / 16 * 16);
      }
      else
      {
        this.hEq = 640;
        f = this.hEq / ((ac)localObject1).height;
        this.hEp = (((int)(((ac)localObject1).width * f) + 8) / 16 * 16);
      }
    }
    AppMethodBeat.o(236277);
    return;
    label780:
    AppMethodBeat.o(236277);
    return;
    label787:
    AppMethodBeat.o(236277);
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(236279);
    int i;
    if (this.HnU != null)
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala = this.HnU;
      if ((locala == null) || (locala.a((com.tencent.mm.plugin.voip.video.camera.a.b)this.Hoi, paramBoolean) != 1)) {
        break label285;
      }
      paramBoolean = true;
      this.GYg = paramBoolean;
      if (this.GYg)
      {
        locala = this.HnU;
        if (locala != null) {
          locala.q(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.fFg();
        locala = this.HnU;
        if (locala == null) {
          break label290;
        }
        i = locala.fLa();
        label96:
        paramSurfaceTexture.adn(i);
        Log.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.HnU);
        if (this.HnU != null)
        {
          paramSurfaceTexture = this.HnU;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          if (paramSurfaceTexture.fLc() != null)
          {
            paramSurfaceTexture = this.HnU;
            if (paramSurfaceTexture != null) {
              paramSurfaceTexture.onOrientationChange(this.kyf);
            }
            paramSurfaceTexture = this.HnU;
            if (paramSurfaceTexture != null) {
              paramSurfaceTexture.fLb();
            }
            this.GYi = 0;
            this.HnV = true;
            paramSurfaceTexture = this.HnU;
            if (paramSurfaceTexture == null) {
              p.hyc();
            }
            paramSurfaceTexture = paramSurfaceTexture.fLc();
            if (paramSurfaceTexture == null) {
              p.hyc();
            }
            locala = this.HnU;
            if (locala == null) {
              p.hyc();
            }
            i = locala.fLe();
            locala = this.HnU;
            if (locala == null) {
              p.hyc();
            }
            if (locala.fLf()) {
              break label295;
            }
          }
        }
      }
    }
    label285:
    label290:
    label295:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(paramSurfaceTexture, i, paramBoolean);
      aeb(this.Hir);
      AppMethodBeat.o(236279);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void fLV()
  {
    AppMethodBeat.i(236278);
    Log.printDebugStack("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.HnU != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala = this.HnU;
      if (locala != null) {
        locala.eoc();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.HnU = null;
    AppMethodBeat.o(236278);
  }
  
  private static ac fLX()
  {
    AppMethodBeat.i(236284);
    int j = 640;
    int i = 480;
    if (v2protocal.Har)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "hseasun: 1280 capture!");
      j = 1280;
      i = 720;
    }
    Object localObject = h.Hhl;
    h.a.aA(j, i);
    localObject = new ac(i, j);
    AppMethodBeat.o(236284);
    return localObject;
  }
  
  private void xc(boolean paramBoolean)
  {
    AppMethodBeat.i(236280);
    int j;
    if (!this.HnV)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      j = 640;
      if (!v2protocal.Har) {
        break label128;
      }
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      j = 1280;
    }
    label128:
    for (int i = 720;; i = 480)
    {
      if (this.HnU == null)
      {
        if (com.tencent.mm.plugin.voip.b.g.fKh())
        {
          this.HnU = ((com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.b.a(this.Hoo.getContext(), j, i));
          AppMethodBeat.o(236280);
          return;
        }
        this.HnU = ((com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.prev.c(j, i));
      }
      AppMethodBeat.o(236280);
      return;
    }
  }
  
  public final void a(ac paramac, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(236282);
    m localm = this.HnX;
    if (localm != null)
    {
      localm.a(paramac, paramInt, paramBoolean);
      AppMethodBeat.o(236282);
      return;
    }
    AppMethodBeat.o(236282);
  }
  
  public final void aeb(int paramInt)
  {
    com.tencent.mm.plugin.voip.video.camera.a.a locala1 = null;
    boolean bool2 = false;
    AppMethodBeat.i(236283);
    Object localObject = this.HnU;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fLg();
    }
    this.Hir = paramInt;
    StringBuilder localStringBuilder = new StringBuilder("set rotate degress ").append(paramInt).append(" and capture render is ");
    localObject = this.HnU;
    boolean bool1;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fLe());
      localStringBuilder = localStringBuilder.append(localObject).append("  and camera is ");
      com.tencent.mm.plugin.voip.video.camera.a.a locala2 = this.HnU;
      localObject = locala1;
      if (locala2 != null) {
        localObject = Integer.valueOf(locala2.fLh());
      }
      localObject = localStringBuilder.append(localObject).append(",and ");
      locala1 = this.HnU;
      if (locala1 == null) {
        break label268;
      }
      bool1 = locala1.fLf();
      label148:
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", bool1, new Object[0]);
      localObject = this.HnX;
      if (localObject != null)
      {
        locala1 = this.HnU;
        if (locala1 == null) {
          break label273;
        }
      }
    }
    label268:
    label273:
    for (int i = locala1.fLh();; i = 0)
    {
      ((m)localObject).aee(i);
      localObject = this.HnX;
      if (localObject != null)
      {
        locala1 = this.HnU;
        bool1 = bool2;
        if (locala1 != null) {
          bool1 = locala1.fLf();
        }
        ((m)localObject).HhF = bool1;
      }
      localObject = this.HnX;
      if (localObject == null) {
        break label278;
      }
      ((m)localObject).aeb(paramInt);
      AppMethodBeat.o(236283);
      return;
      localObject = null;
      break;
      bool1 = false;
      break label148;
    }
    label278:
    AppMethodBeat.o(236283);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a aec(final int paramInt)
  {
    AppMethodBeat.i(236287);
    if (this.Hom == null)
    {
      this.Hom = ((r)new h(this, paramInt));
      localObject = this.HnX;
      if (localObject != null) {
        ((m)localObject).i(this.Hom);
      }
    }
    Object localObject = this.HnY;
    AppMethodBeat.o(236287);
    return localObject;
  }
  
  public final void d(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(236276);
    xc(paramBoolean);
    paramg = paramg.surfaceTexture;
    if (paramg == null) {
      p.hyc();
    }
    b(paramg, paramBoolean);
    AppMethodBeat.o(236276);
  }
  
  public final com.tencent.mm.plugin.voip.video.d.b fJk()
  {
    AppMethodBeat.i(236288);
    if (this.Hon == null)
    {
      this.Hon = ((r)new i(this));
      localObject = this.HnX;
      if (localObject != null) {
        ((m)localObject).i(this.Hon);
      }
    }
    Object localObject = this.HnZ;
    AppMethodBeat.o(236288);
    return localObject;
  }
  
  public final void fLW()
  {
    AppMethodBeat.i(236281);
    Object localObject;
    if ((ae.gKt.gFB == 1) && (this.HnX != null))
    {
      localObject = this.HnX;
      if (localObject == null) {
        p.hyc();
      }
      if (((m)localObject).Hpj != null)
      {
        localObject = this.HnX;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((m)localObject).Hpj;
        if (localObject == null) {
          p.hyc();
        }
        d((g)localObject, true);
      }
    }
    if ((!this.GYg) || (ae.gKt.gFB == 1) || (ae.gKt.gFC == 1)) {
      if (this.HnU != null)
      {
        localObject = this.HnU;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fKY();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.HnX != null)
      {
        localObject = this.HnX;
        if (localObject == null) {
          p.hyc();
        }
        if (((m)localObject).Hpj != null)
        {
          localObject = this.HnX;
          if (localObject == null) {
            p.hyc();
          }
          localObject = ((m)localObject).Hpj;
          if (localObject == null) {
            p.hyc();
          }
          d((g)localObject, bool);
        }
      }
      this.GYg = true;
      AppMethodBeat.o(236281);
      return;
      bool = true;
      break;
    }
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236286);
    Log.printInfoStack("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(236286);
      return;
    }
    if (this.Hoa)
    {
      AppMethodBeat.o(236286);
      return;
    }
    this.GUK = paramInt2;
    this.GUL = paramInt1;
    if ((this.mIsStarted) && (this.HnX != null))
    {
      this.Hoa = true;
      onOrientationChange(this.kyf);
      m localm = this.HnX;
      if (localm != null) {
        localm.a(new ac(paramInt2, paramInt1), Integer.valueOf(270));
      }
      aeb(this.Hir);
    }
    AppMethodBeat.o(236286);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(236275);
    this.kyf = paramInt;
    com.tencent.mm.plugin.voip.video.camera.a.a locala = this.HnU;
    if (locala != null)
    {
      locala.onOrientationChange(paramInt);
      AppMethodBeat.o(236275);
      return;
    }
    AppMethodBeat.o(236275);
  }
  
  public final void release()
  {
    AppMethodBeat.i(236289);
    Object localObject = i.HnR;
    i.report();
    localObject = com.tencent.mm.plugin.voip.b.c.HgQ;
    com.tencent.mm.plugin.voip.b.c.clear();
    localObject = this.GYm;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.GYm = null;
    fLV();
    localObject = this.HnX;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.GYl;
    if ((this.HdK & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).Z(true, i);
      this.GYl.fJL();
      this.GYd = null;
      this.GYf = 0;
      AppMethodBeat.o(236289);
      return;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(236285);
    Log.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HdK) });
    if (this.HdK != paramInt)
    {
      this.HdK = paramInt;
      localObject = this.GYl;
      if ((this.HdK & 0x1) == 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject).Z(true, paramInt);
      this.GYl.fJK();
      if ((this.HdK & 0x1) == 0) {
        break label120;
      }
      localObject = this.HnX;
      if (localObject == null) {
        break;
      }
      ((m)localObject).setShowMode(1);
      AppMethodBeat.o(236285);
      return;
    }
    AppMethodBeat.o(236285);
    return;
    label120:
    Object localObject = this.HnX;
    if (localObject != null)
    {
      ((m)localObject).setShowMode(0);
      AppMethodBeat.o(236285);
      return;
    }
    AppMethodBeat.o(236285);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
    
    public abstract void aG(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void aed(int paramInt);
    
    public abstract void fLY();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$2", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class d
    implements j.b
  {
    private f Hor;
    
    public final void a(final int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(236257);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.Hor = paramSurface;
          paramSurface = j.d(this.Hoq);
          if (paramSurface == null) {
            break;
          }
          paramSurfaceTexture = this.Hor;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurface.a(paramSurfaceTexture, (kotlin.g.a.b)new a(this, paramInt));
          AppMethodBeat.o(236257);
          return;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
        }
      }
      AppMethodBeat.o(236257);
    }
    
    public final void aG(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(236259);
      Object localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.d(this.Hoq);
      if (localObject != null) {
        ((m)localObject).a(this.Hor, paramInt3);
      }
      localObject = j.d(this.Hoq);
      if (localObject != null)
      {
        ((m)localObject).fLR();
        AppMethodBeat.o(236259);
        return;
      }
      AppMethodBeat.o(236259);
    }
    
    public final void aed(int paramInt)
    {
      AppMethodBeat.i(236258);
      m localm = j.d(this.Hoq);
      if (localm != null) {
        localm.c(this.Hor, paramInt);
      }
      localm = j.d(this.Hoq);
      if (localm != null) {
        localm.a(this.Hor);
      }
      this.Hor = null;
      AppMethodBeat.o(236258);
    }
    
    public final void fLY()
    {
      AppMethodBeat.i(236256);
      m localm = j.d(this.Hoq);
      if (localm != null)
      {
        localm.fLT();
        AppMethodBeat.o(236256);
        return;
      }
      AppMethodBeat.o(236256);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<f, x>
    {
      a(j.d paramd, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$4", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static final class f
    implements j.b
  {
    private f Hor;
    
    public final void a(final int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(236263);
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        if (paramSurface != null) {}
        for (paramSurface = new f(paramSurface, (byte)0);; paramSurface = new f(paramSurfaceTexture, (byte)0))
        {
          this.Hor = paramSurface;
          paramSurface = j.d(this.Hoq);
          if (paramSurface == null) {
            break;
          }
          paramSurfaceTexture = this.Hor;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurface.a(paramSurfaceTexture, (kotlin.g.a.b)new a(this, paramInt));
          AppMethodBeat.o(236263);
          return;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
        }
      }
      AppMethodBeat.o(236263);
    }
    
    public final void aG(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(236265);
      Object localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).x = 0;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).y = 0;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).width = paramInt1;
        }
      }
      localObject = this.Hor;
      if (localObject != null)
      {
        localObject = ((f)localObject).Hnv;
        if (localObject != null) {
          ((f.b)localObject).height = paramInt2;
        }
      }
      localObject = j.d(this.Hoq);
      if (localObject != null) {
        ((m)localObject).a(this.Hor, paramInt3);
      }
      localObject = j.d(this.Hoq);
      if (localObject != null)
      {
        ((m)localObject).fLR();
        AppMethodBeat.o(236265);
        return;
      }
      AppMethodBeat.o(236265);
    }
    
    public final void aed(int paramInt)
    {
      AppMethodBeat.i(236264);
      m localm = j.d(this.Hoq);
      if (localm != null) {
        localm.c(this.Hor, paramInt);
      }
      localm = j.d(this.Hoq);
      if (localm != null) {
        localm.a(this.Hor);
      }
      this.Hor = null;
      AppMethodBeat.o(236264);
    }
    
    public final void fLY()
    {
      AppMethodBeat.i(236262);
      m localm = j.d(this.Hoq);
      if (localm != null)
      {
        localm.fLT();
        AppMethodBeat.o(236262);
        return;
      }
      AppMethodBeat.o(236262);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<f, x>
    {
      a(j.f paramf, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "onCameraError", "", "onCameraPreviewApply", "width", "", "height", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "plugin-voip_release"})
  public static final class g
    implements com.tencent.mm.plugin.voip.video.camera.a.b
  {
    public final void a(final byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(236267);
      if (this.Hoq.GYb)
      {
        AppMethodBeat.o(236267);
        return;
      }
      if (this.Hoq.HnU == null)
      {
        Log.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady on previewCallback, captureRender is null!");
        AppMethodBeat.o(236267);
        return;
      }
      Object localObject1 = this.Hoq.HnU;
      int m;
      int n;
      label100:
      final int j;
      final z.d locald1;
      boolean bool1;
      label133:
      final int i;
      label149:
      boolean bool2;
      label169:
      final z.d locald2;
      int k;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).fKY() == true))
      {
        m = OpenGlRender.FLAG_Mirror;
        localObject1 = this.Hoq.HnU;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).fKZ() != true)) {
          break label618;
        }
        n = OpenGlRender.FLAG_Angle270;
        j = paramInt3 + paramInt4;
        localObject1 = null;
        locald1 = null;
        if ((OpenGlRender.getGLVersion() != 2) || (j.g(this.Hoq) == 0)) {
          break label626;
        }
        bool1 = true;
        if ((j.g(this.Hoq) & 0x8) == 0) {
          break label632;
        }
        i = 1;
        if ((OpenGlRender.getGLVersion() != 2) || (j.h(this.Hoq) == 0)) {
          break label638;
        }
        bool2 = true;
        locald2 = new z.d();
        locald2.SYE = 0;
        if (!bool1) {
          break label729;
        }
        if ((i != 0) || (this.Hoq.aec(2) == null)) {
          break label644;
        }
        j.a(this.Hoq, 0);
        k = 1;
        label216:
        if ((!bool2) || (this.Hoq.fJk() != null)) {
          break label1481;
        }
        bool2 = false;
      }
      label449:
      label1481:
      for (;;)
      {
        if ((bool2) && (j.k(this.Hoq) == null)) {
          j.a(this.Hoq, new k());
        }
        if (bool2)
        {
          localObject2 = j.k(this.Hoq);
          if (localObject2 == null) {
            p.hyc();
          }
          i = ((k)localObject2).R(paramArrayOfByte, paramInt1, paramInt2);
          localObject2 = j.k(this.Hoq);
          if (localObject2 == null) {
            p.hyc();
          }
          float f = ((k)localObject2).hff();
          localObject2 = j.d(this.Hoq);
          if (localObject2 != null) {
            ((m)localObject2).x(i, f);
          }
        }
        Object localObject2 = this.Hoq.HnU;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).fKY() != true))
        {
          localObject2 = this.Hoq.HnU;
          if ((localObject2 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).fKY()) || (!j.l(this.Hoq))) {}
        }
        else if (((bool1) && (k != 0)) || ((bool2) && (k == 0)))
        {
          if ((k == 0) && (bool2))
          {
            localObject2 = this.Hoq.fJk();
            if (localObject2 != null)
            {
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).HpD;
              if (paramArrayOfByte == null) {
                break label1467;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).HpD;
              locald2.SYE = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).dataType;
              switch (locald2.SYE)
              {
              default: 
                j = j.m(this.Hoq);
                label505:
                if (paramArrayOfByte == null) {
                  p.hyc();
                }
                paramLong = paramArrayOfByte.capacity();
                i = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).width;
                paramInt3 = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).height;
                j.a(this.Hoq, paramArrayOfByte);
              }
            }
          }
        }
        for (;;)
        {
          j.d(this.Hoq, paramInt3);
          j.c(this.Hoq, i);
          j.b(this.Hoq, locald2.SYE);
          int i1 = i;
          i = paramInt3;
          paramInt3 = i1;
          for (;;)
          {
            if ((localObject1 != null) || (paramArrayOfByte != null)) {
              break label1193;
            }
            Log.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
            paramArrayOfByte = h.Hhl;
            h.a.adL(0);
            AppMethodBeat.o(236267);
            return;
            m = 0;
            break;
            label618:
            n = OpenGlRender.FLAG_Angle90;
            break label100;
            label626:
            bool1 = false;
            break label133;
            label632:
            i = 0;
            break label149;
            label638:
            bool2 = false;
            break label169;
            if ((i != 0) && (this.Hoq.aec(1) != null))
            {
              j.a(this.Hoq, 0);
              k = 2;
              break label216;
            }
            if ((j.j(this.Hoq) != null) && (j.i(this.Hoq) <= 10))
            {
              localObject2 = this.Hoq;
              j.a((j)localObject2, j.i((j)localObject2) + 1);
              k = 3;
              break label216;
            }
            bool1 = false;
            k = 0;
            break label216;
            label729:
            k = 0;
            break label216;
            paramArrayOfByte = null;
            break label449;
            j = 10;
            break label505;
            j = 1;
            break label505;
            if (k == 1)
            {
              localObject2 = this.Hoq.aec(2);
              if (localObject2 != null)
              {
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).iEK;
                if (paramArrayOfByte == null) {
                  break label1467;
                }
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).iEK;
                locald2.SYE = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
                switch (locald2.SYE)
                {
                default: 
                  j = j.m(this.Hoq);
                }
              }
              for (;;)
              {
                if (paramArrayOfByte == null) {
                  p.hyc();
                }
                paramLong = paramArrayOfByte.capacity();
                i = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
                paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
                j.a(this.Hoq, paramArrayOfByte);
                break;
                paramArrayOfByte = null;
                break label780;
                j = 10;
                continue;
                j = 1;
              }
            }
            if (k == 2)
            {
              localObject2 = this.Hoq.aec(1);
              if (localObject2 != null)
              {
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).iEK;
                if (paramArrayOfByte == null) {
                  break label1467;
                }
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).iEK;
                locald2.SYE = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
                switch (locald2.SYE)
                {
                default: 
                  j = j.m(this.Hoq);
                }
              }
              for (;;)
              {
                if (paramArrayOfByte == null) {
                  p.hyc();
                }
                paramLong = paramArrayOfByte.capacity();
                i = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
                paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
                j.a(this.Hoq, paramArrayOfByte);
                break;
                paramArrayOfByte = null;
                break label920;
                j = 10;
                continue;
                j = 1;
              }
            }
            if ((k != 3) || (j.j(this.Hoq) == null)) {
              break label1467;
            }
            paramArrayOfByte = j.n(this.Hoq);
            switch (j.o(this.Hoq))
            {
            default: 
              paramInt3 = j.m(this.Hoq);
            }
            for (;;)
            {
              p.hyc();
              paramLong = null.length;
              i = j.p(this.Hoq);
              i1 = j.q(this.Hoq);
              locald2.SYE = j.o(this.Hoq);
              j.a(this.Hoq, paramArrayOfByte);
              j = paramInt3;
              paramInt3 = i1;
              break;
              paramInt3 = 10;
              continue;
              paramInt3 = 1;
            }
            j = paramInt3 + paramInt4;
            i = paramInt2;
            paramInt3 = paramInt1;
            locald1 = null;
            localObject1 = paramArrayOfByte;
            paramArrayOfByte = locald1;
          }
          Log.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + paramInt3 + "vh=" + i + ", bm=" + k + "format is " + j + "rotate is " + paramInt4);
          locald1 = new z.d();
          locald1.SYE = 0;
          j.a(this.Hoq, bool1, bool2);
          paramInt4 = (int)paramLong;
          localObject2 = this.Hoq.GYm;
          if (localObject2 != null) {
            ((MMHandler)localObject2).post((Runnable)new a(this, paramArrayOfByte, locald1, paramInt4, j, paramInt3, i, locald2, (byte[])localObject1));
          }
          this.Hoq.Hoo.aB(locald1.SYE, paramInt1, paramInt2);
          j.a(this.Hoq, (byte[])localObject1, paramInt1, paramInt2);
          paramArrayOfByte = this.Hoq;
          j.e(paramArrayOfByte, j.r(paramArrayOfByte) + 1);
          paramArrayOfByte = this.Hoq;
          if (m == OpenGlRender.FLAG_Mirror)
          {
            bool1 = true;
            paramArrayOfByte.GUq = bool1;
            paramArrayOfByte = this.Hoq;
            if (n != OpenGlRender.FLAG_Angle270) {
              break label1460;
            }
          }
          for (paramInt1 = 270;; paramInt1 = 90)
          {
            paramArrayOfByte.GUr = paramInt1;
            AppMethodBeat.o(236267);
            return;
            bool1 = false;
            break;
          }
          paramInt3 = paramInt2;
          i = paramInt1;
          paramArrayOfByte = locald1;
        }
      }
    }
    
    public final void cza()
    {
      AppMethodBeat.i(236268);
      this.Hoq.Hoo.fFE();
      AppMethodBeat.o(236268);
    }
    
    public final void fs(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(236269);
      Log.i("MicroMsg.VoIPRenderMgr", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
      Object localObject = com.tencent.mm.plugin.voip.b.j.Hhp;
      com.tencent.mm.plugin.voip.b.j.LE(paramInt1);
      localObject = com.tencent.mm.plugin.voip.b.j.Hhp;
      com.tencent.mm.plugin.voip.b.j.LF(paramInt2);
      localObject = j.d(this.Hoq);
      if (localObject != null)
      {
        if ((((m)localObject).fMe()) || (com.tencent.mm.plugin.voip.b.g.fKg()))
        {
          g localg = ((m)localObject).Hpj;
          if (localg != null) {
            localg.width = paramInt1;
          }
          localObject = ((m)localObject).Hpj;
          if (localObject != null)
          {
            ((g)localObject).height = paramInt2;
            AppMethodBeat.o(236269);
            return;
          }
        }
        AppMethodBeat.o(236269);
        return;
      }
      AppMethodBeat.o(236269);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.g paramg, ByteBuffer paramByteBuffer, z.d paramd1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, z.d paramd2, byte[] paramArrayOfByte) {}
      
      public final void run()
      {
        AppMethodBeat.i(236266);
        if (paramArrayOfByte != null)
        {
          Log.i("MicroMsg.VoIPRenderMgr", "encode tick " + Util.ticksToNow(this.Hov.Hoq.tick));
          this.Hov.Hoq.tick = Util.currentTicks();
          locald1.SYE = com.tencent.mm.plugin.voip.c.fFg().c(paramArrayOfByte, paramInt4, j, paramInt3, i, locald2.SYE);
          AppMethodBeat.o(236266);
          return;
        }
        if (this.HoC != null)
        {
          z.d locald = locald1;
          u localu = com.tencent.mm.plugin.voip.c.fFg();
          byte[] arrayOfByte = this.HoC;
          int i = paramInt4;
          int j = j;
          int k = paramInt3;
          int m = i;
          new Point(0, 0);
          locald.SYE = localu.c(arrayOfByte, i, j, k, m);
        }
        AppMethodBeat.o(236266);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class h
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    h(j paramj, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class i
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    i(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<g, x>
  {
    j(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.j
 * JD-Core Version:    0.7.0.1
 */