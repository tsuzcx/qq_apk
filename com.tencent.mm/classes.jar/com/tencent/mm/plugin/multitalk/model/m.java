package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.s;
import com.tencent.mm.plugin.multitalk.b.t;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "()V", "captureRender", "Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEglHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEglHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "eglThread", "Landroid/os/HandlerThread;", "getEglThread", "()Landroid/os/HandlerThread;", "setEglThread", "(Landroid/os/HandlerThread;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getExternalTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setExternalTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "frameTransObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "getFrameTransObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "setFrameTransObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;)V", "lastFrameTick", "", "mClipTmpBuffer", "", "nativeDrawerObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "getNativeDrawerObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "setNativeDrawerObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "getUiCallback", "()Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;)V", "addUiCallback", "", "checkCreate", "initCallback", "Lkotlin/Function0;", "createContext", "exchangeCapture", "isCameraNeedResume", "", "isCameraOpen", "onCameraError", "onCameraPreviewApply", "width", "", "height", "onDrawerReady", "pBuffer", "", "w", "h", "MediaFmt", "mirror", "angle", "onFrameDataReady", "lBufferSize", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "onTimeTick", "queue", "callback", "release", "removeUiCallback", "startCapture", "startCaptureRenderer", "stopCaptureRender", "Companion", "FrameObj", "FrameTrans", "plugin-multitalk_release"})
public final class m
  implements c
{
  public static final m.a Fro;
  com.tencent.mm.media.g.d Frh;
  public e Fri;
  public long Frj;
  public x Frk;
  c Frl;
  private byte[] Frm;
  private m.b Frn;
  HandlerThread krj;
  MMHandler krk;
  c.b lav;
  SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(197533);
    Fro = new m.a((byte)0);
    AppMethodBeat.o(197533);
  }
  
  public m()
  {
    AppMethodBeat.i(197532);
    this.Frl = new c();
    this.Frn = new m.b((byte)0);
    AppMethodBeat.o(197532);
  }
  
  private void j(a<kotlin.x> parama)
  {
    AppMethodBeat.i(197500);
    p.k(parama, "callback");
    Object localObject = this.krj;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive() == true)
      {
        localObject = this.krk;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new n(parama));
          AppMethodBeat.o(197500);
        }
      }
    }
    else
    {
      AppMethodBeat.o(197500);
      return;
    }
    AppMethodBeat.o(197500);
  }
  
  private final void qn()
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(197528);
    this.Frk = new x();
    Object localObject1 = this.Frk;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (c)this;
      q localq = ad.eYc();
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      ((x)localObject1).a((c)localObject2, localq.eXF());
    }
    localObject1 = this.Frk;
    if (localObject1 != null) {
      ((x)localObject1).mSurfaceTexture = this.surfaceTexture;
    }
    localObject1 = this.Frk;
    if (localObject1 != null) {
      ((x)localObject1).eXR();
    }
    localObject1 = this.Frk;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((x)localObject1).Ftr);; localObject1 = null)
    {
      localObject2 = this.Frk;
      if (localObject2 != null) {
        localBoolean = ((x)localObject2).Fts;
      }
      Log.i("MicroMsg.MultiTalkCameraManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { localObject1, localBoolean });
      AppMethodBeat.o(197528);
      return;
    }
  }
  
  public final void IA(int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197524);
    Object localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).eXh())
    {
      release();
      AppMethodBeat.o(197524);
      return;
    }
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(197524);
      return;
    }
    if (this.Frk == null)
    {
      AppMethodBeat.o(197524);
      return;
    }
    localObject1 = this.Frk;
    if (localObject1 != null) {}
    for (localObject1 = ((x)localObject1).Fts; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(197524);
      return;
    }
    localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).eXc()) {
      ad.eYc().aK(3, ad.eYc().FrS);
    }
    localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool = ((q)localObject1).eXg();
    localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).eXc()) {
      ad.eYc().aK(3, ad.eYc().FrS);
    }
    long l2 = System.currentTimeMillis();
    localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = this.Frk;
    if (localObject2 == null) {
      p.iCn();
    }
    ((q)localObject1).uO(((x)localObject2).Ftr);
    localObject1 = this.Frk;
    if (localObject1 == null) {
      p.iCn();
    }
    int j;
    int k;
    label291:
    int i;
    if (((x)localObject1).Ftr)
    {
      j = OpenGlRender.FLAG_Mirror;
      localObject1 = this.Frk;
      if (localObject1 == null) {
        p.iCn();
      }
      if (!p.h(((x)localObject1).Fts, Boolean.TRUE)) {
        break label407;
      }
      k = OpenGlRender.FLAG_Angle270;
      if (!bool) {
        break label1094;
      }
      if (paramInt1 <= paramInt2) {
        break label415;
      }
      i = paramInt1 - paramInt2;
    }
    for (;;)
    {
      if (i > 0)
      {
        if (this.Frm == null) {
          this.Frm = new byte[paramInt2 * paramInt2 * 3 / 2];
        }
        localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne;
        paramInt1 = com.tencent.mm.plugin.multitalk.b.o.a(this.Frm, paramInt2, paramInt2, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if ((paramInt1 < 0) || (this.Frm == null))
        {
          Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv clip ret: %d", new Object[] { Integer.valueOf(paramInt1) });
          AppMethodBeat.o(197524);
          return;
          j = 0;
          break;
          label407:
          k = OpenGlRender.FLAG_Angle90;
          break label291;
          label415:
          i = 0;
          continue;
        }
        if (this.Frl.Frr == null)
        {
          this.Frl.w = paramInt2;
          this.Frl.h = paramInt2;
          this.Frl.Frr = new int[this.Frl.w * this.Frl.h];
        }
        paramArrayOfByte = com.tencent.mm.plugin.multitalk.b.o.Fne;
        paramArrayOfByte = this.Frm;
        localObject1 = this.Frm;
        if (localObject1 == null) {
          p.iCn();
        }
        paramArrayOfByte = com.tencent.mm.plugin.multitalk.b.o.a(paramArrayOfByte, localObject1.length, this.Frl.w, this.Frl.h, paramInt3 + paramInt4 & 0x1F, this.Frl.Frr);
        if ((paramArrayOfByte.ret < 0) || (this.Frl.Frr == null) || (paramArrayOfByte.Fqc == 0) || (paramArrayOfByte.Fqd == 0))
        {
          Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv trans ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.ret) });
          AppMethodBeat.o(197524);
          return;
        }
        paramInt1 = paramArrayOfByte.Fqc;
        i = paramArrayOfByte.Fqd;
        paramArrayOfByte = com.tencent.mm.plugin.multitalk.b.o.Fne.eVD();
        p.j(paramArrayOfByte, "ILinkService.INSTANCE.videoMgr");
        if (!paramArrayOfByte.isStarted())
        {
          AppMethodBeat.o(197524);
          return;
        }
        paramLong = System.currentTimeMillis();
        paramInt4 = com.tencent.mm.plugin.multitalk.b.o.Fne.g(this.Frm, paramInt2, paramInt2, paramInt3 + paramInt4);
        paramInt3 = i;
        paramInt2 = paramInt1;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      l1 = System.currentTimeMillis();
      long l3 = l1 - l2;
      if (l3 > 30L) {
        Log.d("MicroMsg.MultiTalkCameraManager", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l3), Long.valueOf(paramLong - l2), Long.valueOf(l1 - paramLong) });
      }
      if (paramInt1 <= 0) {
        Log.v("MicroMsg.MultiTalkCameraManager", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (this.Frl.Frr != null)
      {
        paramArrayOfByte = ad.eYc();
        p.j(paramArrayOfByte, "SubCoreMultiTalk.getMultiTalkManager()");
        paramArrayOfByte = paramArrayOfByte.eXp();
        localObject1 = z.bcZ();
        p.j(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
        localObject2 = this.Frl.Frr;
        if (localObject2 == null) {
          p.iCn();
        }
        paramArrayOfByte.a((String)localObject1, (int[])localObject2, paramInt2, paramInt3, j, k);
      }
      this.Frj = Util.currentTicks();
      AppMethodBeat.o(197524);
      return;
      if (this.Frl.Frr == null)
      {
        this.Frl.w = paramInt1;
        this.Frl.h = paramInt2;
        this.Frl.Frr = new int[this.Frl.w * this.Frl.h];
      }
      localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne;
      localObject1 = com.tencent.mm.plugin.multitalk.b.o.a(paramArrayOfByte, (int)paramLong, this.Frl.w, this.Frl.h, paramInt3 + paramInt4 & 0x1F, this.Frl.Frr);
      if ((((t)localObject1).ret < 0) || (this.Frl.Frr == null) || (((t)localObject1).Fqc == 0) || (((t)localObject1).Fqd == 0))
      {
        Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv trans ret: %d", new Object[] { Integer.valueOf(((t)localObject1).ret) });
        AppMethodBeat.o(197524);
        return;
      }
      m = ((t)localObject1).Fqc;
      i = ((t)localObject1).Fqd;
      localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne.eVD();
      p.j(localObject1, "ILinkService.INSTANCE.videoMgr");
      if (!((s)localObject1).isStarted())
      {
        AppMethodBeat.o(197524);
        return;
      }
      paramLong = System.currentTimeMillis();
      paramInt1 = com.tencent.mm.plugin.multitalk.b.o.Fne.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
      paramInt2 = m;
      paramInt3 = i;
    }
    label1094:
    if (this.Frl.Frr == null)
    {
      this.Frl.w = paramInt1;
      this.Frl.h = paramInt2;
      this.Frl.Frr = new int[this.Frl.w * this.Frl.h];
    }
    localObject1 = ad.eYb();
    p.j(localObject1, "SubCoreMultiTalk.getMultiEngine()");
    localObject1 = ((o)localObject1).eWv().b(paramArrayOfByte, (int)paramLong, this.Frl.w, this.Frl.h, paramInt3 + paramInt4 & 0x1F, this.Frl.Frr);
    if ((((g)localObject1).ret < 0) || (this.Frl.Frr == null) || (((g)localObject1).Fqc == 0) || (((g)localObject1).Fqd == 0))
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "mv ret: %d", new Object[] { Integer.valueOf(((g)localObject1).ret) });
      AppMethodBeat.o(197524);
      return;
    }
    int m = ((g)localObject1).Fqc;
    int n = ((g)localObject1).Fqd;
    long l1 = System.currentTimeMillis();
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      label1299:
      localObject1 = ad.eYc();
      p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((q)localObject1).eXE()) {
        break label1397;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label1391;
      }
      i = 259;
    }
    label1391:
    label1397:
    for (;;)
    {
      localObject1 = ad.eYc();
      p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      paramInt1 = ((q)localObject1).eXn().b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = l1;
      paramInt3 = n;
      paramInt2 = m;
      break;
      i = 1;
      break label1299;
      i = 3;
    }
  }
  
  public final boolean aXN()
  {
    return this.Frk != null;
  }
  
  public final void cNy()
  {
    AppMethodBeat.i(197506);
    e locale = this.Fri;
    if (locale != null)
    {
      locale.eWm();
      AppMethodBeat.o(197506);
      return;
    }
    AppMethodBeat.o(197506);
  }
  
  public final void eWs()
  {
    AppMethodBeat.i(197498);
    if ((this.Frk != null) && (aXN()) && (eWu())) {
      qn();
    }
    AppMethodBeat.o(197498);
  }
  
  public final void eWt()
  {
    AppMethodBeat.i(197504);
    a locala = (a)new m.h(this);
    this.krj = com.tencent.e.c.d.ij("MultiTalkCameraManager_Thread" + hashCode(), 5);
    Object localObject = this.krj;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.krj;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.krk = new MMHandler((Looper)localObject);
      j((a)new m.d(this, locala));
      AppMethodBeat.o(197504);
      return;
    }
  }
  
  public final boolean eWu()
  {
    AppMethodBeat.i(197530);
    if ((this.Frj != 0L) && (Util.ticksToNow(this.Frj) > 1000L))
    {
      Log.i("MicroMsg.MultiTalkCameraManager", "current camera is open but has no video ");
      AppMethodBeat.o(197530);
      return true;
    }
    AppMethodBeat.o(197530);
    return false;
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197507);
    Log.i("MicroMsg.MultiTalkCameraManager", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
    AppMethodBeat.o(197507);
  }
  
  public final void release()
  {
    AppMethodBeat.i(197503);
    this.Frj = 0L;
    j((a)new g(this));
    AppMethodBeat.o(197503);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "", "()V", "h", "", "getH", "()I", "setH", "(I)V", "outImg", "", "getOutImg", "()[I", "setOutImg", "([I)V", "w", "getW", "setW", "plugin-multitalk_release"})
  public static final class c
  {
    int[] Frr;
    int h;
    int w;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<kotlin.x>
  {
    g(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */