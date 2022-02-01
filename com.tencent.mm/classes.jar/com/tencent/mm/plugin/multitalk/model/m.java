package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.t;
import com.tencent.mm.plugin.multitalk.b.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.g;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "()V", "captureRender", "Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEglHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEglHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "eglThread", "Landroid/os/HandlerThread;", "getEglThread", "()Landroid/os/HandlerThread;", "setEglThread", "(Landroid/os/HandlerThread;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getExternalTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setExternalTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "frameTransObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "getFrameTransObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "setFrameTransObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;)V", "lastFrameTick", "", "nativeDrawerObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "getNativeDrawerObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "setNativeDrawerObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "getUiCallback", "()Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;)V", "addUiCallback", "", "checkCreate", "initCallback", "Lkotlin/Function0;", "createContext", "exchangeCapture", "isCameraOpen", "", "onCameraError", "onCameraPreviewApply", "width", "", "height", "onDrawerReady", "pBuffer", "", "w", "h", "MediaFmt", "mirror", "angle", "onFrameDataReady", "", "lBufferSize", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onTimeTick", "queue", "callback", "release", "removeUiCallback", "startCapture", "startCaptureRenderer", "stopCaptureRender", "Companion", "FrameObj", "FrameTrans", "plugin-multitalk_release"})
public final class m
  implements b
{
  public static final m.a zLW;
  HandlerThread hDq;
  MMHandler hDr;
  c.b ilw;
  SurfaceTexture surfaceTexture;
  com.tencent.mm.media.g.d zLQ;
  public e zLR;
  public long zLS;
  public x zLT;
  private c zLU;
  private m.b zLV;
  
  static
  {
    AppMethodBeat.i(239619);
    zLW = new m.a((byte)0);
    AppMethodBeat.o(239619);
  }
  
  public m()
  {
    AppMethodBeat.i(239618);
    this.zLU = new c();
    this.zLV = new m.b((byte)0);
    AppMethodBeat.o(239618);
  }
  
  private void k(a<kotlin.x> parama)
  {
    AppMethodBeat.i(239610);
    kotlin.g.b.p.h(parama, "callback");
    Object localObject = this.hDq;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive() == true)
      {
        localObject = this.hDr;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new n(parama));
          AppMethodBeat.o(239610);
        }
      }
    }
    else
    {
      AppMethodBeat.o(239610);
      return;
    }
    AppMethodBeat.o(239610);
  }
  
  private final void sz()
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(239616);
    this.zLT = new x();
    Object localObject1 = this.zLT;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (b)this;
      q localq = ac.eom();
      kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      ((x)localObject1).a((b)localObject2, localq.enP());
    }
    localObject1 = this.zLT;
    if (localObject1 != null) {
      ((x)localObject1).mSurfaceTexture = this.surfaceTexture;
    }
    localObject1 = this.zLT;
    if (localObject1 != null) {
      ((x)localObject1).eob();
    }
    localObject1 = this.zLT;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((x)localObject1).zNU);; localObject1 = null)
    {
      localObject2 = this.zLT;
      if (localObject2 != null) {
        localBoolean = ((x)localObject2).zNV;
      }
      Log.i("MicroMsg.MultiTalkCameraManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { localObject1, localBoolean });
      AppMethodBeat.o(239616);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239615);
    Object localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).ent())
    {
      release();
      AppMethodBeat.o(239615);
      return;
    }
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(239615);
      return;
    }
    if (this.zLT == null)
    {
      AppMethodBeat.o(239615);
      return;
    }
    localObject1 = this.zLT;
    if (localObject1 != null) {}
    for (localObject1 = ((x)localObject1).zNV; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(239615);
      return;
    }
    if (this.zLU.zLY == null)
    {
      this.zLU.w = paramInt1;
      this.zLU.h = paramInt2;
      this.zLU.zLY = new int[this.zLU.w * this.zLU.h];
    }
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).eno()) {
      ac.eom().aF(3, ac.eom().zMz);
    }
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool = ((q)localObject1).ens();
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject1).eno()) {
      ac.eom().aF(3, ac.eom().zMz);
    }
    long l2 = System.currentTimeMillis();
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = this.zLT;
    if (localObject2 == null) {
      kotlin.g.b.p.hyc();
    }
    ((q)localObject1).rL(((x)localObject2).zNU);
    localObject1 = this.zLT;
    if (localObject1 == null) {
      kotlin.g.b.p.hyc();
    }
    int j;
    int k;
    if (((x)localObject1).zNU)
    {
      j = OpenGlRender.FLAG_Mirror;
      localObject1 = this.zLT;
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      if (!kotlin.g.b.p.j(((x)localObject1).zNV, Boolean.TRUE)) {
        break label460;
      }
      k = OpenGlRender.FLAG_Angle270;
    }
    label460:
    int i;
    for (;;)
    {
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.b.p.zHS;
        localObject1 = com.tencent.mm.plugin.multitalk.b.p.a(paramArrayOfByte, (int)paramLong, this.zLU.w, this.zLU.h, paramInt3 + paramInt4 & 0x1F, this.zLU.zLY);
        if ((((u)localObject1).ret < 0) || (this.zLU.zLY == null) || (((u)localObject1).zKK == 0) || (((u)localObject1).zKL == 0))
        {
          Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv ret: %d", new Object[] { Integer.valueOf(((u)localObject1).ret) });
          AppMethodBeat.o(239615);
          return;
          j = 0;
          break;
          k = OpenGlRender.FLAG_Angle90;
          continue;
        }
        i = ((u)localObject1).zKK;
        m = ((u)localObject1).zKL;
        localObject1 = com.tencent.mm.plugin.multitalk.b.p.zHS.elQ();
        kotlin.g.b.p.g(localObject1, "ILinkService.INSTANCE.videoMgr");
        if (!((t)localObject1).isStarted())
        {
          AppMethodBeat.o(239615);
          return;
        }
        paramLong = System.currentTimeMillis();
        paramInt2 = com.tencent.mm.plugin.multitalk.b.p.zHS.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
        paramInt1 = m;
        paramInt3 = i;
        l1 = System.currentTimeMillis();
        long l3 = l1 - l2;
        if (l3 > 30L) {
          Log.d("MicroMsg.MultiTalkCameraManager", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Long.valueOf(l3), Long.valueOf(paramLong - l2), Long.valueOf(l1 - paramLong) });
        }
        if (paramInt2 <= 0) {
          Log.v("MicroMsg.MultiTalkCameraManager", "send ret = %d", new Object[] { Integer.valueOf(paramInt2) });
        }
        if (this.zLU.zLY != null)
        {
          paramArrayOfByte = ac.eom();
          kotlin.g.b.p.g(paramArrayOfByte, "SubCoreMultiTalk.getMultiTalkManager()");
          paramArrayOfByte = paramArrayOfByte.enz();
          localObject1 = z.aTY();
          kotlin.g.b.p.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
          localObject2 = this.zLU.zLY;
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          paramArrayOfByte.a((String)localObject1, (int[])localObject2, paramInt3, paramInt1, j, k);
        }
        this.zLS = Util.currentTicks();
        AppMethodBeat.o(239615);
        return;
      }
    }
    localObject1 = ac.eol();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiEngine()");
    localObject1 = ((o)localObject1).emG().b(paramArrayOfByte, (int)paramLong, this.zLU.w, this.zLU.h, paramInt3 + paramInt4 & 0x1F, this.zLU.zLY);
    if ((((g)localObject1).ret < 0) || (this.zLU.zLY == null) || (((g)localObject1).zKK == 0) || (((g)localObject1).zKL == 0))
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "mv ret: %d", new Object[] { Integer.valueOf(((g)localObject1).ret) });
      AppMethodBeat.o(239615);
      return;
    }
    int m = ((g)localObject1).zKK;
    int n = ((g)localObject1).zKL;
    long l1 = System.currentTimeMillis();
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      label884:
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((q)localObject1).enO()) {
        break label982;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label976;
      }
      i = 259;
    }
    label976:
    label982:
    for (;;)
    {
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      paramInt2 = ((q)localObject1).enx().b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = l1;
      paramInt1 = n;
      paramInt3 = m;
      break;
      i = 1;
      break label884;
      i = 3;
    }
  }
  
  public final void cza()
  {
    AppMethodBeat.i(239613);
    e locale = this.zLR;
    if (locale != null)
    {
      locale.emy();
      AppMethodBeat.o(239613);
      return;
    }
    AppMethodBeat.o(239613);
  }
  
  public final void emE()
  {
    AppMethodBeat.i(239609);
    if ((this.zLT != null) && (!emo())) {
      sz();
    }
    AppMethodBeat.o(239609);
  }
  
  public final void emF()
  {
    AppMethodBeat.i(239612);
    final a locala = (a)new h(this);
    this.hDq = com.tencent.f.c.d.hz("MultiTalkCameraManager_Thread" + hashCode(), 5);
    Object localObject = this.hDq;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.hDq;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.hDr = new MMHandler((Looper)localObject);
      k((a)new d(this, locala));
      AppMethodBeat.o(239612);
      return;
    }
  }
  
  public final boolean emo()
  {
    AppMethodBeat.i(239617);
    if (this.zLT == null)
    {
      AppMethodBeat.o(239617);
      return false;
    }
    if ((this.zLS != 0L) && (Util.ticksToNow(this.zLS) > 1000L))
    {
      Log.i("MicroMsg.MultiTalkCameraManager", "current camera is open but has no video ");
      AppMethodBeat.o(239617);
      return false;
    }
    AppMethodBeat.o(239617);
    return true;
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239614);
    Log.i("MicroMsg.MultiTalkCameraManager", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
    AppMethodBeat.o(239614);
  }
  
  public final void release()
  {
    AppMethodBeat.i(239611);
    this.zLS = 0L;
    k((a)new g(this));
    AppMethodBeat.o(239611);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "", "()V", "h", "", "getH", "()I", "setH", "(I)V", "outImg", "", "getOutImg", "()[I", "setOutImg", "([I)V", "w", "getW", "setW", "plugin-multitalk_release"})
  public static final class c
  {
    int h;
    int w;
    int[] zLY;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements a<kotlin.x>
  {
    d(m paramm, a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$createContext$1$2"})
  static final class e
    implements Runnable
  {
    e(m paramm, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(239603);
      this.zMb.invoke();
      AppMethodBeat.o(239603);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<kotlin.x>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements a<kotlin.x>
  {
    h(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */