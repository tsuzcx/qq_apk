package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.c.h.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.a.r;
import kotlin.g.b.aa.e;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "captureRenderer", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "decMode", "deviceOrientation", "drawHeight", "drawWidth", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isCameraStausChange", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "lastSendFilterData", "", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastEncHeight", "mLastEncWidth", "mLastHWDecH", "mLastHWDecW", "mLastSTFilterCmd", "mLocalIsMirror", "mLocalRotateAngle", "mPauseTransVideo", "mSTDenosingPreProcess", "Lcom/tencent/mm/video/videoprocessing/SpatiotemproalDenosingPreProcess;", "mSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "mSTFilterDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "mUpdateTimes", "mUseLastBeautyCnt", "mVoipWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "screenRotation", "tick", "", "getTick", "()J", "setTick", "(J)V", "use720pCapture", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "cacheCallbackBuffer", "size", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "getSpatioTemporalFilterData", "initRendererEnvironment", "isLocalUseFaceBeauty", "onFrameDataReady", "onHWDecModeSet", "isSmallViewShowSelf", "onOrientationChange", "rotation", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "rotateDegree", "mirror", "setDeviceOrientation", "degree", "setHWDecMode", "mode", "setLocalRenderOrientation", "setLocalVideoSize", "isVoipBeautySupported", "isSTFilterSupport", "setRemoteVideoData", "outData", "", "setScreenRotation", "setSpatiotemporalDenosing", "cmd", "setVoipBeauty", "unInitCaptureRender", "Companion", "RendererViewEvent", "VoipRawData", "plugin-voip_release"})
public final class k
{
  public static final k.a Ofi;
  public boolean NKC;
  public int NKD;
  public int NKO;
  public int NKP;
  private int NKW;
  private int NKX;
  boolean NKr;
  MMHandler NOA;
  public boolean NOp;
  private byte[] NOr;
  private ByteBuffer NOs;
  private int NOt;
  public boolean NOu;
  private int NOw;
  public int NUC;
  public boolean NUy;
  public int NZg;
  private com.tencent.mm.ct.a.j ObJ;
  private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> OdQ;
  public com.tencent.mm.plugin.voip.video.camera.a.a OeO;
  private boolean OeP;
  public boolean OeQ;
  public p OeR;
  private com.tencent.mm.plugin.voip.video.b.a OeS;
  private com.tencent.mm.plugin.voip.video.d.b OeT;
  private boolean OeU;
  private int OeV;
  private int OeW;
  public boolean OeX;
  private int OeY;
  private boolean OeZ;
  private final int Ofa;
  public boolean Ofb;
  private h Ofc;
  private int Ofd;
  private int Ofe;
  private int Off;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Ofg;
  d Ofh;
  private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Sur;
  private int ksu;
  private int ksv;
  public boolean mIsStarted;
  public int nrf;
  long tick;
  
  static
  {
    AppMethodBeat.i(241637);
    Ofi = new k.a((byte)0);
    AppMethodBeat.o(241637);
  }
  
  public k(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(241636);
    this.Ofh = paramd;
    this.NKr = paramBoolean;
    this.NOu = true;
    this.mIsStarted = true;
    this.OeS = new com.tencent.mm.plugin.voip.video.b.a();
    this.OeT = new com.tencent.mm.plugin.voip.video.d.b();
    this.OeV = -1;
    this.OeW = -1;
    this.OeY = 3;
    paramd = g.NXO;
    int i;
    if (g.gCH())
    {
      paramd = g.NXO;
      if (g.gCI()) {
        i = 33;
      }
    }
    for (;;)
    {
      this.Ofa = i;
      this.NOA = new MMHandler("encodeVoipHandler", (MMHandler.Callback)new i(this));
      paramd = gEy();
      this.OeR = new p();
      Object localObject1 = this.OeR;
      if (localObject1 != null)
      {
        ((p)localObject1).Oga = new h(paramd.width, paramd.height);
        ((p)localObject1).Ogb = new q(true);
        ((p)localObject1).Ogc = new q(false);
      }
      paramd = this.OeR;
      if (paramd != null) {
        paramd.aJ(com.tencent.mm.plugin.voip.c.c.NXB, com.tencent.mm.plugin.voip.c.c.NXC, com.tencent.mm.plugin.voip.c.c.NXD);
      }
      paramd = this.OeR;
      if (paramd != null)
      {
        kotlin.g.a.b localb = (kotlin.g.a.b)new k(this);
        localObject1 = new aa.e();
        ((aa.e)localObject1).aaBB = -1L;
        Object localObject2 = paramd.Oga;
        if (localObject2 != null)
        {
          localb = (kotlin.g.a.b)new p.b(paramd, localb);
          if ((((h)localObject2).lav != null) || (((h)localObject2).Oex)) {
            localb.invoke(localObject2);
          }
          ((h)localObject2).j((kotlin.g.a.a)new h.b((h)localObject2, localb));
        }
        localObject2 = paramd.Oga;
        if (localObject2 != null) {
          ((h)localObject2).Oeb = ((kotlin.g.a.b)new p.c((aa.e)localObject1));
        }
        localObject2 = paramd.Ogb;
        if (localObject2 != null) {
          ((e)localObject2).Oeb = ((kotlin.g.a.b)new p.d(paramd, (aa.e)localObject1));
        }
        paramd = paramd.Oga;
        if (paramd != null)
        {
          Log.i("MicroMsg.PboSurfaceRender", "start");
          paramd.j((kotlin.g.a.a)new h.k(paramd));
        }
      }
      if (g.gCF())
      {
        localObject1 = this.OeR;
        if (localObject1 != null)
        {
          paramd = (kotlin.g.a.a)new l(this);
          localObject1 = ((p)localObject1).Oga;
          if (localObject1 != null) {
            ((h)localObject1).Sul = paramd;
          }
        }
      }
      paramd = this.OeR;
      if (paramd != null) {
        paramd.Oge = this.Ofh;
      }
      paramd = j.OeL;
      j.reset();
      paramd = com.tencent.mm.plugin.voip.c.c.NXF;
      com.tencent.mm.plugin.voip.c.c.clear();
      paramd = this.NOA;
      if (paramd != null) {
        paramd.setLogging(false);
      }
      this.OdQ = new HashMap();
      this.Ofc = new h(this);
      AppMethodBeat.o(241636);
      return;
      i = 39;
      continue;
      i = 4;
    }
  }
  
  private void AU(boolean paramBoolean)
  {
    AppMethodBeat.i(241621);
    int j;
    if (!this.OeP)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      j = 640;
      if (!v2protocal.NQD) {
        break label128;
      }
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      j = 1280;
    }
    label128:
    for (int i = 720;; i = 480)
    {
      if (this.OeO == null)
      {
        if (g.gCG())
        {
          this.OeO = ((com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.b.a(this.Ofh.getContext(), j, i));
          AppMethodBeat.o(241621);
          return;
        }
        this.OeO = ((com.tencent.mm.plugin.voip.video.camera.a.a)new com.tencent.mm.plugin.voip.video.camera.prev.c(j, i));
      }
      AppMethodBeat.o(241621);
      return;
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(241619);
    int i;
    if (this.OeO != null)
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala = this.OeO;
      if ((locala == null) || (locala.a((com.tencent.mm.plugin.voip.video.camera.a.c)this.Ofc, paramBoolean) != 1)) {
        break label285;
      }
      paramBoolean = true;
      this.NOu = paramBoolean;
      if (this.NOu)
      {
        locala = this.OeO;
        if (locala != null) {
          locala.t(paramSurfaceTexture);
        }
        paramSurfaceTexture = com.tencent.mm.plugin.voip.c.gxs();
        locala = this.OeO;
        if (locala == null) {
          break label290;
        }
        i = locala.gDA();
        label96:
        paramSurfaceTexture.akX(i);
        Log.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.OeO);
        if (this.OeO != null)
        {
          paramSurfaceTexture = this.OeO;
          if (paramSurfaceTexture == null) {
            kotlin.g.b.p.iCn();
          }
          if (paramSurfaceTexture.gDC() != null)
          {
            paramSurfaceTexture = this.OeO;
            if (paramSurfaceTexture != null) {
              paramSurfaceTexture.onOrientationChange(this.nrf);
            }
            paramSurfaceTexture = this.OeO;
            if (paramSurfaceTexture != null) {
              paramSurfaceTexture.gDB();
            }
            this.NOw = 0;
            this.OeP = true;
            paramSurfaceTexture = this.OeO;
            if (paramSurfaceTexture == null) {
              kotlin.g.b.p.iCn();
            }
            paramSurfaceTexture = paramSurfaceTexture.gDC();
            if (paramSurfaceTexture == null) {
              kotlin.g.b.p.iCn();
            }
            locala = this.OeO;
            if (locala == null) {
              kotlin.g.b.p.iCn();
            }
            i = locala.gDE();
            locala = this.OeO;
            if (locala == null) {
              kotlin.g.b.p.iCn();
            }
            if (locala.gDF()) {
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
      alO(this.NZg);
      AppMethodBeat.o(241619);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label96;
    }
  }
  
  private final void bd(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(241616);
    Object localObject2 = gEy();
    Object localObject1 = this.OeO;
    int i;
    label68:
    label104:
    int j;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).gDC();
      if (localObject1 != null) {
        if ((((ad)localObject1).height != ((ad)localObject2).width) || (((ad)localObject1).width != ((ad)localObject2).height))
        {
          i = 1;
          if (i == 0) {
            break label218;
          }
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = new ad(((ad)localObject1).height, ((ad)localObject1).width);
          Log.i("MicroMsg.VoIPRenderMgr", "force update draw size");
          i = 1;
          com.tencent.mm.plugin.voip.c.gxs().gAs();
          j = com.tencent.mm.plugin.voip.c.c.NXB;
          k = com.tencent.mm.plugin.voip.c.c.NXC;
          if (!this.OeX) {
            break label234;
          }
          this.OeY = 3;
          label132:
          localObject2 = this.OeR;
          if (localObject2 != null) {
            ((p)localObject2).aJ(com.tencent.mm.plugin.voip.c.c.NXB, com.tencent.mm.plugin.voip.c.c.NXC, com.tencent.mm.plugin.voip.c.c.NXD);
          }
          com.tencent.mm.plugin.voip.c.gxs();
          if ((!u.gAu()) || ((!paramBoolean1) && (!paramBoolean2))) {
            break label259;
          }
          this.OeZ = true;
        }
      }
    }
    for (;;)
    {
      if ((!this.OeX) && (this.OeV == j) && (this.OeW == k))
      {
        AppMethodBeat.o(241616);
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
        if (this.OeY <= 0) {
          break label132;
        }
        this.OeY -= 1;
        this.OeX = true;
        break label132;
        label259:
        this.OeZ = false;
        if ((i == 0) && (!this.OeX))
        {
          AppMethodBeat.o(241616);
          return;
        }
      }
    }
    this.OeV = j;
    this.OeW = k;
    this.OeX = false;
    localObject2 = new StringBuilder("setLocalVideoSize 720pEncodeFlag:");
    com.tencent.mm.plugin.voip.c.gxs();
    Log.i("MicroMsg.VoIPRenderMgr", u.gAt() + ", outSize:[" + j + ", " + k + ']');
    float f;
    if ((j >= 1280) || (k >= 720))
    {
      com.tencent.mm.plugin.voip.c.gxs();
      if (u.gAt())
      {
        if (((ad)localObject1).height * k > ((ad)localObject1).width * j)
        {
          this.ksu = k;
          f = k / ((ad)localObject1).width;
          this.ksv = (((int)(((ad)localObject1).height * f) + 4) / 8 * 8);
        }
        for (;;)
        {
          Log.i("MicroMsg.VoIPRenderMgr", "setLocalVideoSize update to 1280p [" + this.ksu + ',' + this.ksv + ']');
          Log.i("MicroMsg.VoIPRenderMgr", "hseasun: set LocalSize: " + this.ksu + ' ' + this.ksv + " EncRes: " + j + ' ' + k);
          localObject1 = this.OeR;
          if (localObject1 != null)
          {
            i = this.ksu;
            j = this.ksv;
            localObject1 = ((p)localObject1).Oga;
            if (localObject1 != null)
            {
              Log.i("MicroMsg.PboSurfaceRender", "set Local Video Size [hseasun], width:%d height：%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              ((h)localObject1).j((kotlin.g.a.a)new h.g((h)localObject1, i, j));
            }
          }
          localObject2 = this.OeR;
          if (localObject2 == null) {
            break label937;
          }
          localObject1 = new ad(this.ksu, this.ksv);
          kotlin.g.b.p.k(localObject1, "renderSize");
          localObject2 = ((p)localObject2).Ogb;
          if (localObject2 == null) {
            break label930;
          }
          localObject2 = ((e)localObject2).Oei;
          if (localObject2 == null) {
            break;
          }
          Integer localInteger = Integer.valueOf(((ad)localObject1).width);
          if (localInteger == null) {
            kotlin.g.b.p.iCn();
          }
          i = localInteger.intValue();
          localObject1 = Integer.valueOf(((ad)localObject1).height);
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          ((o)localObject2).dv(i, ((Integer)localObject1).intValue());
          AppMethodBeat.o(241616);
          return;
          this.ksv = ((ad)localObject1).height;
          this.ksu = ((ad)localObject1).width;
        }
      }
    }
    if (((ad)localObject1).height * k > ((ad)localObject1).width * j)
    {
      this.ksu = 480;
      f = this.ksu / ((ad)localObject1).width;
      this.ksv = (((int)(((ad)localObject1).height * f) + 4) / 8 * 8);
    }
    for (;;)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "setLocalVideoSize update to normal size [" + this.ksu + ',' + this.ksv + ']');
      break;
      this.ksv = 640;
      f = this.ksv / ((ad)localObject1).height;
      this.ksu = (((int)(((ad)localObject1).width * f) + 4) / 8 * 8);
    }
    AppMethodBeat.o(241616);
    return;
    label930:
    AppMethodBeat.o(241616);
    return;
    label937:
    AppMethodBeat.o(241616);
  }
  
  private final void gEw()
  {
    AppMethodBeat.i(241618);
    Log.printDebugStack("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
    if (this.OeO != null) {}
    try
    {
      com.tencent.mm.plugin.voip.video.camera.a.a locala = this.OeO;
      if (locala != null) {
        locala.eXS();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(localException)));
      }
    }
    this.OeO = null;
    AppMethodBeat.o(241618);
  }
  
  private static ad gEy()
  {
    AppMethodBeat.i(241628);
    int j = 640;
    int i = 480;
    if (v2protocal.NQD)
    {
      j = 1280;
      i = 720;
    }
    Object localObject = com.tencent.mm.plugin.voip.c.h.NYa;
    h.a.aQ(j, i);
    localObject = new ad(i, j);
    AppMethodBeat.o(241628);
    return localObject;
  }
  
  public final void a(ad paramad, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241625);
    Object localObject = this.OeR;
    if (localObject != null) {
      ((p)localObject).a(paramad, paramInt, paramBoolean);
    }
    localObject = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.bIE(paramad.width + ':' + paramad.height);
    AppMethodBeat.o(241625);
  }
  
  public final void alO(int paramInt)
  {
    com.tencent.mm.plugin.voip.video.camera.a.a locala1 = null;
    boolean bool2 = false;
    AppMethodBeat.i(241627);
    Object localObject = this.OeO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDG();
    }
    this.NZg = paramInt;
    StringBuilder localStringBuilder = new StringBuilder("set rotate degress ").append(paramInt).append(" and capture render is ");
    localObject = this.OeO;
    boolean bool1;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDE());
      localStringBuilder = localStringBuilder.append(localObject).append("  and camera is ");
      com.tencent.mm.plugin.voip.video.camera.a.a locala2 = this.OeO;
      localObject = locala1;
      if (locala2 != null) {
        localObject = Integer.valueOf(locala2.gDH());
      }
      localObject = localStringBuilder.append(localObject).append(",and ");
      locala1 = this.OeO;
      if (locala1 == null) {
        break label268;
      }
      bool1 = locala1.gDF();
      label148:
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", bool1, new Object[0]);
      localObject = this.OeR;
      if (localObject != null)
      {
        locala1 = this.OeO;
        if (locala1 == null) {
          break label273;
        }
      }
    }
    label268:
    label273:
    for (int i = locala1.gDH();; i = 0)
    {
      ((p)localObject).wAs = i;
      localObject = this.OeR;
      if (localObject != null)
      {
        locala1 = this.OeO;
        bool1 = bool2;
        if (locala1 != null) {
          bool1 = locala1.gDF();
        }
        ((p)localObject).NYu = bool1;
      }
      localObject = this.OeR;
      if (localObject == null) {
        break label278;
      }
      ((p)localObject).alO(paramInt);
      AppMethodBeat.o(241627);
      return;
      localObject = null;
      break;
      bool1 = false;
      break label148;
    }
    label278:
    AppMethodBeat.o(241627);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a alP(int paramInt)
  {
    AppMethodBeat.i(241631);
    if (this.Ofg == null)
    {
      this.Ofg = ((r)new k.j(this, paramInt));
      localObject = this.OeR;
      if (localObject != null) {
        ((p)localObject).i(this.Ofg);
      }
    }
    Object localObject = this.OeS;
    AppMethodBeat.o(241631);
    return localObject;
  }
  
  public final void c(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(241614);
    AU(paramBoolean);
    paramh = paramh.surfaceTexture;
    if (paramh == null) {
      kotlin.g.b.p.iCn();
    }
    b(paramh, paramBoolean);
    AppMethodBeat.o(241614);
  }
  
  public final com.tencent.mm.plugin.voip.video.d.b gBH()
  {
    AppMethodBeat.i(293192);
    if (this.Sur == null)
    {
      this.Sur = ((r)new k.m(this));
      localObject = this.OeR;
      if (localObject != null) {
        ((p)localObject).i(this.Sur);
      }
    }
    Object localObject = this.OeT;
    AppMethodBeat.o(293192);
    return localObject;
  }
  
  public final void gEx()
  {
    AppMethodBeat.i(241623);
    Object localObject;
    if ((af.juH.jpL == 1) && (this.OeR != null))
    {
      localObject = this.OeR;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      if (((p)localObject).Oga != null)
      {
        localObject = this.OeR;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localObject = ((p)localObject).Oga;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        c((h)localObject, true);
      }
    }
    if ((!this.NOu) || (af.juH.jpL == 1) || (af.juH.jpM == 1)) {
      if (this.OeO != null)
      {
        localObject = this.OeO;
        if (localObject == null) {
          break label194;
        }
        bool = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDy();
        if (!bool) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      if (this.OeR != null)
      {
        localObject = this.OeR;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        if (((p)localObject).Oga != null)
        {
          localObject = this.OeR;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          localObject = ((p)localObject).Oga;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          c((h)localObject, bool);
        }
      }
      this.NOu = true;
      AppMethodBeat.o(241623);
      return;
      bool = true;
      break;
    }
  }
  
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241630);
    Log.printInfoStack("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(241630);
      return;
    }
    if (this.OeU)
    {
      AppMethodBeat.o(241630);
      return;
    }
    this.NKW = paramInt2;
    this.NKX = paramInt1;
    if ((this.mIsStarted) && (this.OeR != null))
    {
      this.OeU = true;
      onOrientationChange(this.nrf);
      p localp = this.OeR;
      if (localp != null) {
        localp.a(new ad(paramInt2, paramInt1), Integer.valueOf(270));
      }
      alO(this.NZg);
    }
    AppMethodBeat.o(241630);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(241613);
    this.nrf = paramInt;
    com.tencent.mm.plugin.voip.video.camera.a.a locala = this.OeO;
    if (locala != null)
    {
      locala.onOrientationChange(paramInt);
      AppMethodBeat.o(241613);
      return;
    }
    AppMethodBeat.o(241613);
  }
  
  public final void release()
  {
    AppMethodBeat.i(241634);
    Object localObject = j.OeL;
    j.report();
    localObject = com.tencent.mm.plugin.voip.c.c.NXF;
    com.tencent.mm.plugin.voip.c.c.clear();
    localObject = this.NOA;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.NOA = null;
    gEw();
    localObject = this.OeR;
    if (localObject != null) {
      ((p)localObject).release();
    }
    this.NOr = null;
    this.NOt = 0;
    AppMethodBeat.o(241634);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    int i = 2;
    long l2 = 0L;
    AppMethodBeat.i(241629);
    Log.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.NUC) });
    if (this.NUC != paramInt)
    {
      this.NUC = paramInt;
      localObject = com.tencent.mm.plugin.voip.b.a.NTi;
      localObject = com.tencent.mm.plugin.voip.b.a.gBz();
      if ((this.NUC & 0x1) == 0) {
        break label201;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.c.gxs().NKx != 0L) {
        break label206;
      }
      l1 = 0L;
      label88:
      ((ArrayList)localObject).add(new kotlin.o(Integer.valueOf(paramInt), Long.valueOf(l1)));
      localObject = com.tencent.mm.plugin.voip.b.a.NTi;
      localObject = com.tencent.mm.plugin.voip.b.a.gBA();
      paramInt = i;
      if (this.NUC >> 8 != 0) {
        paramInt = 1;
      }
      if (com.tencent.mm.plugin.voip.c.gxs().NKx != 0L) {
        break label219;
      }
    }
    label201:
    label206:
    label219:
    for (long l1 = l2;; l1 = Util.secondsToNow(com.tencent.mm.plugin.voip.c.gxs().NKx))
    {
      ((ArrayList)localObject).add(new kotlin.o(Integer.valueOf(paramInt), Long.valueOf(l1)));
      if ((this.NUC & 0x1) == 0) {
        break label239;
      }
      localObject = this.OeR;
      if (localObject == null) {
        break label232;
      }
      ((p)localObject).setShowMode(1);
      AppMethodBeat.o(241629);
      return;
      paramInt = 2;
      break;
      l1 = Util.secondsToNow(com.tencent.mm.plugin.voip.c.gxs().NKx);
      break label88;
    }
    label232:
    AppMethodBeat.o(241629);
    return;
    label239:
    Object localObject = this.OeR;
    if (localObject != null)
    {
      ((p)localObject).setShowMode(0);
      AppMethodBeat.o(241629);
      return;
    }
    AppMethodBeat.o(241629);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
    
    public abstract void aK(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void alQ(int paramInt);
    
    public abstract void gEz();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$VoipRawData;", "", "()V", "dataType", "", "getDataType", "()I", "setDataType", "(I)V", "encodeBuffer", "Ljava/nio/ByteBuffer;", "getEncodeBuffer", "()Ljava/nio/ByteBuffer;", "setEncodeBuffer", "(Ljava/nio/ByteBuffer;)V", "encodeData", "", "getEncodeData", "()[B", "setEncodeData", "([B)V", "encodeFormat", "getEncodeFormat", "setEncodeFormat", "encodeHeight", "getEncodeHeight", "setEncodeHeight", "encodeLength", "getEncodeLength", "setEncodeLength", "encodeWidth", "getEncodeWidth", "setEncodeWidth", "plugin-voip_release"})
  public static final class c
  {
    byte[] Ofj;
    ByteBuffer Ofk;
    int Ofl;
    int Ofm;
    int Ofn;
    int Ofo;
    int dataType;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public d(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public f(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "onCameraError", "", "onCameraPreviewApply", "width", "", "height", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "plugin-voip_release"})
  public static final class h
    implements com.tencent.mm.plugin.voip.video.camera.a.c
  {
    public final void IA(int paramInt)
    {
      int j = 4;
      AppMethodBeat.i(237344);
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbI, true))
      {
        AppMethodBeat.o(237344);
        return;
      }
      boolean bool;
      int i;
      if (this.Ofp.OeO != null)
      {
        com.tencent.mm.plugin.voip.video.camera.a.a locala = this.Ofp.OeO;
        if (locala != null)
        {
          bool = locala.gDy();
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
          label71:
          com.tencent.mm.plugin.voip.c.gxs().akQ(paramInt);
          AppMethodBeat.o(237344);
          return;
          bool = true;
          break;
          label120:
          i = 0;
          break label71;
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
    
    public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(237337);
      if (this.Ofp.NOp)
      {
        AppMethodBeat.o(237337);
        return;
      }
      if (this.Ofp.OeO == null)
      {
        Log.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady on previewCallback, captureRender is null!");
        AppMethodBeat.o(237337);
        return;
      }
      Object localObject1 = this.Ofp.OeO;
      int n;
      int i1;
      label100:
      int k;
      Object localObject2;
      boolean bool1;
      label133:
      int i;
      label149:
      boolean bool2;
      label169:
      int i2;
      int m;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).gDy() == true))
      {
        n = OpenGlRender.FLAG_Mirror;
        localObject1 = this.Ofp.OeO;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject1).gDz() != true)) {
          break label598;
        }
        i1 = OpenGlRender.FLAG_Angle270;
        k = paramInt3 + paramInt4;
        localObject2 = null;
        localObject1 = null;
        if ((OpenGlRender.getGLVersion() != 2) || (k.e(this.Ofp) == 0)) {
          break label606;
        }
        bool1 = true;
        if ((k.e(this.Ofp) & 0x8) == 0) {
          break label612;
        }
        i = 1;
        if ((OpenGlRender.getGLVersion() != 2) || (k.f(this.Ofp) == 0)) {
          break label618;
        }
        bool2 = true;
        i2 = 0;
        if (!bool1) {
          break label709;
        }
        if ((i != 0) || (this.Ofp.alP(2) == null)) {
          break label624;
        }
        k.a(this.Ofp, 0);
        m = 1;
        label204:
        if ((!bool2) || (this.Ofp.gBH() != null)) {
          break label1820;
        }
        bool2 = false;
      }
      label1152:
      label1410:
      label1796:
      label1803:
      label1820:
      for (;;)
      {
        if ((bool2) && (k.i(this.Ofp) == null)) {
          k.a(this.Ofp, new com.tencent.mm.ct.a.j());
        }
        if (bool2)
        {
          localObject3 = k.i(this.Ofp);
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          i = ((com.tencent.mm.ct.a.j)localObject3).T(paramArrayOfByte, paramInt1, paramInt2);
          localObject3 = k.i(this.Ofp);
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          float f = ((com.tencent.mm.ct.a.j)localObject3).igy();
          localObject3 = k.c(this.Ofp);
          if (localObject3 != null)
          {
            ((p)localObject3).y(i, f);
            localObject3 = x.aazN;
          }
        }
        Object localObject3 = this.Ofp.OeO;
        label442:
        label493:
        int j;
        if ((localObject3 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject3).gDy() != true))
        {
          localObject3 = this.Ofp.OeO;
          if ((localObject3 == null) || (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject3).gDy()) || (!k.t(this.Ofp))) {}
        }
        else if (((bool1) && (m != 0)) || ((bool2) && (m == 0)))
        {
          if ((m == 0) && (bool2))
          {
            localObject2 = this.Ofp.gBH();
            if (localObject2 != null)
            {
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).Ogw;
              if (paramArrayOfByte == null) {
                break label1803;
              }
              paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).Ogw;
              paramInt3 = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).dataType;
              switch (paramInt3)
              {
              default: 
                k = k.k(this.Ofp);
                if (paramArrayOfByte == null) {
                  kotlin.g.b.p.iCn();
                }
                paramLong = paramArrayOfByte.capacity();
                j = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).width;
                i = ((com.tencent.mm.plugin.voip.video.d.b)localObject2).height;
                k.a(this.Ofp, paramArrayOfByte);
              }
            }
          }
        }
        for (;;)
        {
          k.b(this.Ofp, i);
          k.c(this.Ofp, j);
          k.d(this.Ofp, paramInt3);
          localObject1 = null;
          localObject2 = paramArrayOfByte;
          for (;;)
          {
            if ((localObject1 != null) || (localObject2 != null)) {
              break label1152;
            }
            Log.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
            paramArrayOfByte = com.tencent.mm.plugin.voip.c.h.NYa;
            h.a.aly(0);
            AppMethodBeat.o(237337);
            return;
            n = 0;
            break;
            label598:
            i1 = OpenGlRender.FLAG_Angle90;
            break label100;
            label606:
            bool1 = false;
            break label133;
            label612:
            i = 0;
            break label149;
            label618:
            bool2 = false;
            break label169;
            label624:
            if ((i != 0) && (this.Ofp.alP(1) != null))
            {
              k.a(this.Ofp, 0);
              m = 2;
              break label204;
            }
            if ((k.h(this.Ofp) != null) && (k.g(this.Ofp) <= 10))
            {
              localObject3 = this.Ofp;
              k.a((k)localObject3, k.g((k)localObject3) + 1);
              m = 3;
              break label204;
            }
            bool1 = false;
            m = 0;
            break label204;
            label709:
            m = 0;
            break label204;
            paramArrayOfByte = null;
            break label442;
            k = 10;
            break label493;
            k = 1;
            break label493;
            if (m == 1)
            {
              localObject2 = this.Ofp.alP(2);
              if (localObject2 != null)
              {
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).luM;
                label760:
                if (paramArrayOfByte == null) {
                  break label1803;
                }
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).luM;
                paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
                switch (paramInt3)
                {
                default: 
                  k = k.k(this.Ofp);
                }
              }
              for (;;)
              {
                if (paramArrayOfByte == null) {
                  kotlin.g.b.p.iCn();
                }
                paramLong = paramArrayOfByte.capacity();
                j = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
                i = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
                k.a(this.Ofp, paramArrayOfByte);
                break;
                paramArrayOfByte = null;
                break label760;
                k = 10;
                continue;
                k = 1;
              }
            }
            if (m == 2)
            {
              localObject2 = this.Ofp.alP(1);
              if (localObject2 != null)
              {
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).luM;
                label892:
                if (paramArrayOfByte == null) {
                  break label1803;
                }
                paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).luM;
                paramInt3 = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).dataType;
                switch (paramInt3)
                {
                default: 
                  k = k.k(this.Ofp);
                }
              }
              for (;;)
              {
                if (paramArrayOfByte == null) {
                  kotlin.g.b.p.iCn();
                }
                paramLong = paramArrayOfByte.capacity();
                j = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).width;
                i = ((com.tencent.mm.plugin.voip.video.b.a)localObject2).height;
                k.a(this.Ofp, paramArrayOfByte);
                break;
                paramArrayOfByte = null;
                break label892;
                k = 10;
                continue;
                k = 1;
              }
            }
            if ((m != 3) || (k.h(this.Ofp) == null)) {
              break label1803;
            }
            paramArrayOfByte = k.j(this.Ofp);
            switch (k.n(this.Ofp))
            {
            default: 
              paramInt3 = k.k(this.Ofp);
            }
            for (;;)
            {
              kotlin.g.b.p.iCn();
              paramLong = null.length;
              j = k.m(this.Ofp);
              i = k.l(this.Ofp);
              i2 = k.n(this.Ofp);
              k.a(this.Ofp, paramArrayOfByte);
              k = paramInt3;
              paramInt3 = i2;
              break;
              paramInt3 = 10;
              continue;
              paramInt3 = 1;
            }
            k = paramInt3 + paramInt4;
            i = paramInt2;
            j = paramInt1;
            paramInt3 = i2;
            localObject1 = paramArrayOfByte;
          }
          Log.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + j + "vh=" + i + ", bm=" + m + "format is " + k + "rotate is " + paramInt4);
          k.a(this.Ofp, bool1, bool2);
          localObject3 = new k.c();
          if (localObject2 != null)
          {
            m = ((ByteBuffer)localObject2).capacity();
            k.e(this.Ofp, m);
            paramArrayOfByte = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = (ByteBuffer)paramArrayOfByte.remove();
              if (paramArrayOfByte != null)
              {
                paramArrayOfByte.clear();
                paramArrayOfByte.position(0);
                ((ByteBuffer)localObject2).position(0);
                ((ByteBuffer)localObject2).rewind();
                paramArrayOfByte.put((ByteBuffer)localObject2);
                ((ByteBuffer)localObject2).rewind();
                paramArrayOfByte.position(0);
                ((ByteBuffer)localObject2).position(0);
                paramArrayOfByte.flip();
                ((k.c)localObject3).Ofk = paramArrayOfByte;
                localObject2 = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
                if (localObject2 == null) {
                  break label1607;
                }
                paramInt4 = ((LinkedBlockingQueue)localObject2).size();
                if (paramInt4 < 2)
                {
                  localObject2 = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
                  if (localObject2 != null) {
                    ((LinkedBlockingQueue)localObject2).add(paramArrayOfByte);
                  }
                }
                paramArrayOfByte = x.aazN;
              }
              label1452:
              ((k.c)localObject3).dataType = paramInt3;
              ((k.c)localObject3).Ofl = ((int)paramLong);
              ((k.c)localObject3).Ofm = k;
              ((k.c)localObject3).Ofn = j;
              ((k.c)localObject3).Ofo = i;
              paramArrayOfByte = new Message();
              paramArrayOfByte.obj = localObject3;
              localObject2 = this.Ofp.NOA;
              if (localObject2 != null) {
                ((MMHandler)localObject2).sendMessage(paramArrayOfByte);
              }
              k.a(this.Ofp, (byte[])localObject1, paramInt1, paramInt2);
              paramArrayOfByte = this.Ofp;
              k.f(paramArrayOfByte, k.p(paramArrayOfByte) + 1);
              paramArrayOfByte = this.Ofp;
              if (n != OpenGlRender.FLAG_Mirror) {
                break label1790;
              }
              bool1 = true;
              label1566:
              paramArrayOfByte.NKC = bool1;
              paramArrayOfByte = this.Ofp;
              if (i1 != OpenGlRender.FLAG_Angle270) {
                break label1796;
              }
            }
          }
          for (paramInt1 = 270;; paramInt1 = 90)
          {
            paramArrayOfByte.NKD = paramInt1;
            AppMethodBeat.o(237337);
            return;
            paramArrayOfByte = null;
            break;
            label1607:
            paramInt4 = 0;
            break label1410;
            if (localObject1 == null) {
              break label1452;
            }
            m = localObject1.length;
            k.e(this.Ofp, m);
            paramArrayOfByte = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = (ByteBuffer)paramArrayOfByte.remove();
              label1663:
              if (paramArrayOfByte == null) {
                break label1782;
              }
              paramArrayOfByte.clear();
              paramArrayOfByte.position(0);
              paramArrayOfByte.put((byte[])localObject1);
              paramArrayOfByte.position(0);
              paramArrayOfByte.flip();
              ((k.c)localObject3).Ofk = paramArrayOfByte;
              localObject2 = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
              if (localObject2 == null) {
                break label1784;
              }
            }
            label1782:
            label1784:
            for (paramInt4 = ((LinkedBlockingQueue)localObject2).size();; paramInt4 = 0)
            {
              if (paramInt4 < 2)
              {
                localObject2 = (LinkedBlockingQueue)k.o(this.Ofp).get(Integer.valueOf(m));
                if (localObject2 != null) {
                  ((LinkedBlockingQueue)localObject2).add(paramArrayOfByte);
                }
              }
              paramArrayOfByte = x.aazN;
              break;
              paramArrayOfByte = null;
              break label1663;
              break;
            }
            label1790:
            bool1 = false;
            break label1566;
          }
          paramInt3 = 0;
          i = paramInt2;
          j = paramInt1;
          paramArrayOfByte = (byte[])localObject1;
        }
      }
    }
    
    public final void cNy()
    {
      AppMethodBeat.i(237339);
      this.Ofp.Ofh.gxQ();
      com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.gEH();
      AppMethodBeat.o(237339);
    }
    
    public final void fP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(237341);
      Log.i("MicroMsg.VoIPRenderMgr", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
      Object localObject = k.c(this.Ofp);
      if (localObject != null)
      {
        h localh = ((p)localObject).Oga;
        if (localh != null) {
          localh.width = paramInt1;
        }
        localObject = ((p)localObject).Oga;
        if (localObject != null) {
          ((h)localObject).height = paramInt2;
        }
      }
      k.q(this.Ofp);
      AppMethodBeat.o(237341);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class i
    implements MMHandler.Callback
  {
    i(k paramk) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(234763);
      paramMessage = paramMessage.obj;
      int i;
      if (paramMessage != null)
      {
        if ((paramMessage instanceof k.c)) {}
        while (paramMessage != null) {
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.plugin.voip.video.render.VoIPRenderMgr.VoipRawData");
            AppMethodBeat.o(234763);
            throw paramMessage;
            paramMessage = null;
          }
          else
          {
            Log.d("MicroMsg.VoIPRenderMgr", "voip encode in post data ");
            if (((k.c)paramMessage).Ofk == null) {
              break label161;
            }
            this.Ofp.tick = Util.currentTicks();
            i = com.tencent.mm.plugin.voip.c.gxs().c(((k.c)paramMessage).Ofk, ((k.c)paramMessage).Ofl, ((k.c)paramMessage).Ofm, ((k.c)paramMessage).Ofn, ((k.c)paramMessage).Ofo, ((k.c)paramMessage).dataType);
          }
        }
      }
      for (;;)
      {
        this.Ofp.Ofh.aF(i, ((k.c)paramMessage).Ofn, ((k.c)paramMessage).Ofo);
        AppMethodBeat.o(234763);
        return true;
        label161:
        if (((k.c)paramMessage).Ofj != null)
        {
          u localu = com.tencent.mm.plugin.voip.c.gxs();
          byte[] arrayOfByte = ((k.c)paramMessage).Ofj;
          i = ((k.c)paramMessage).Ofl;
          int j = ((k.c)paramMessage).Ofm;
          int k = ((k.c)paramMessage).Ofn;
          int m = ((k.c)paramMessage).Ofo;
          new Point(0, 0);
          i = localu.c(arrayOfByte, i, j, k, m);
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<h, x>
  {
    k(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    l(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */