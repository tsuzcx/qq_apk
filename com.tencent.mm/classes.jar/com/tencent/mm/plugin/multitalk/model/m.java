package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.r;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.plugin.multitalk.c.t;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.g;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "()V", "captureRender", "Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEglHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEglHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "eglThread", "Landroid/os/HandlerThread;", "getEglThread", "()Landroid/os/HandlerThread;", "setEglThread", "(Landroid/os/HandlerThread;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getExternalTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setExternalTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "frameTransObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "getFrameTransObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "setFrameTransObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;)V", "lastFrameTick", "", "mClipTmpBuffer", "", "nativeDrawerObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "getNativeDrawerObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "setNativeDrawerObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;)V", "screenListener", "Lcom/tencent/mm/app/IPhoneScreenListener;", "screenOn", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "timeoutTime", "getTimeoutTime", "()J", "timeoutTime$delegate", "Lkotlin/Lazy;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "getUiCallback", "()Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;)V", "addUiCallback", "", "checkCreate", "initCallback", "Lkotlin/Function0;", "createContext", "exchangeCapture", "isCameraNeedResume", "isCameraOpen", "isFaceCamera", "onCameraError", "onCameraPreviewApply", "width", "", "height", "onDrawerReady", "pBuffer", "", "w", "h", "MediaFmt", "mirror", "angle", "onFrameDataReady", "lBufferSize", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "onTimeTick", "queue", "callback", "release", "removeUiCallback", "startCapture", "startCaptureRenderer", "addListener", "stopCaptureRender", "removeListener", "Companion", "FrameObj", "FrameTrans", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements c
{
  public static final m.a Lnr;
  private final j LnA;
  private m.b LnB;
  com.tencent.mm.media.g.d Lns;
  public e Lnt;
  public long Lnu;
  public w Lnv;
  private volatile boolean Lnw;
  private final r Lnx;
  c Lny;
  private byte[] Lnz;
  HandlerThread mVg;
  MMHandler mVh;
  c.b nFD;
  SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(284839);
    Lnr = new m.a((byte)0);
    AppMethodBeat.o(284839);
  }
  
  public m()
  {
    AppMethodBeat.i(284762);
    this.Lnw = true;
    this.Lnx = new m..ExternalSyntheticLambda1(this);
    this.Lny = new c();
    this.LnA = k.cm((a)m.g.LnI);
    this.LnB = new m.b((byte)0);
    AppMethodBeat.o(284762);
  }
  
  private void K(a<ah> parama)
  {
    int i = 1;
    AppMethodBeat.i(284771);
    kotlin.g.b.s.u(parama, "callback");
    Object localObject = this.mVg;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.mVh;
        if (localObject != null) {
          ((MMHandler)localObject).post(new m..ExternalSyntheticLambda2(parama));
        }
      }
      AppMethodBeat.o(284771);
      return;
      i = 0;
    }
  }
  
  private final void Py()
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(284777);
    Object localObject = this.Lnv;
    if (localObject != null) {
      ((w)localObject).ggH();
    }
    this.Lnv = new w();
    localObject = this.Lnv;
    if (localObject != null) {
      ((w)localObject).a((c)this, ac.ggS().Loe);
    }
    localObject = this.Lnv;
    if (localObject != null) {
      ((w)localObject).mSurfaceTexture = this.surfaceTexture;
    }
    localObject = this.Lnv;
    if (localObject != null) {
      ((w)localObject).ggG();
    }
    localObject = this.Lnv;
    w localw;
    if (localObject == null)
    {
      localObject = null;
      localw = this.Lnv;
      if (localw != null) {
        break label146;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MultiTalkCameraManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { localObject, localBoolean });
      AppMethodBeat.o(284777);
      return;
      localObject = Boolean.valueOf(((w)localObject).LpL);
      break;
      label146:
      localBoolean = localw.LpM;
    }
  }
  
  private static final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(284791);
    kotlin.g.b.s.u(paramm, "this$0");
    Log.i("MicroMsg.MultiTalkCameraManager", kotlin.g.b.s.X("onScreen: ", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramm.Lnw = paramBoolean;
      AppMethodBeat.o(284791);
      return;
    }
  }
  
  private static final void bG(a parama)
  {
    AppMethodBeat.i(284801);
    kotlin.g.b.s.u(parama, "$initCallback");
    parama.invoke();
    AppMethodBeat.o(284801);
  }
  
  private static final void bH(a parama)
  {
    AppMethodBeat.i(284806);
    kotlin.g.b.s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(284806);
  }
  
  private void gfk()
  {
    AppMethodBeat.i(284783);
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.heY;
    r localr = this.Lnx;
    synchronized (localAppForegroundDelegate.hfg)
    {
      localAppForegroundDelegate.hfg.remove(localr);
      release();
      AppMethodBeat.o(284783);
      return;
    }
  }
  
  private final long gfl()
  {
    AppMethodBeat.i(284786);
    long l = ((Number)this.LnA.getValue()).longValue();
    AppMethodBeat.o(284786);
    return l;
  }
  
  private static final void p(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(284796);
    try
    {
      paramSurfaceTexture.updateTexImage();
      AppMethodBeat.o(284796);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "updateTexImage error");
      AppMethodBeat.o(284796);
    }
  }
  
  public final void Jd(int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(284890);
    if (!ac.ggS().gfW())
    {
      gfk();
      AppMethodBeat.o(284890);
      return;
    }
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(284890);
      return;
    }
    if (this.Lnv == null)
    {
      AppMethodBeat.o(284890);
      return;
    }
    Object localObject1 = this.Lnv;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((w)localObject1).LpM)
    {
      AppMethodBeat.o(284890);
      return;
    }
    if (!this.Lnw)
    {
      AppMethodBeat.o(284890);
      return;
    }
    if (!u.abK(ac.ggS().Lod)) {
      ac.ggS().bl(3, ac.ggS().Lof);
    }
    boolean bool = ac.ggS().gfV();
    if (!u.abK(ac.ggS().Lod)) {
      ac.ggS().bl(3, ac.ggS().Lof);
    }
    long l2 = System.currentTimeMillis();
    localObject1 = ac.ggS();
    Object localObject2 = this.Lnv;
    kotlin.g.b.s.checkNotNull(localObject2);
    ((p)localObject1).Loe = ((w)localObject2).LpL;
    localObject1 = this.Lnv;
    kotlin.g.b.s.checkNotNull(localObject1);
    int j;
    int k;
    label246:
    int i;
    if (((w)localObject1).LpL)
    {
      j = OpenGlRender.FLAG_Mirror;
      localObject1 = this.Lnv;
      kotlin.g.b.s.checkNotNull(localObject1);
      if (!kotlin.g.b.s.p(((w)localObject1).LpM, Boolean.TRUE)) {
        break label363;
      }
      k = OpenGlRender.FLAG_Angle270;
      if (!bool) {
        break label1018;
      }
      if (paramInt1 <= paramInt2) {
        break label371;
      }
      i = paramInt1 - paramInt2;
    }
    for (;;)
    {
      if (i > 0)
      {
        if (this.Lnz == null) {
          this.Lnz = new byte[paramInt2 * paramInt2 * 3 / 2];
        }
        localObject1 = o.Ljn;
        paramInt1 = o.a(this.Lnz, paramInt2, paramInt2, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if ((paramInt1 < 0) || (this.Lnz == null))
        {
          Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv clip ret: %d", new Object[] { Integer.valueOf(paramInt1) });
          AppMethodBeat.o(284890);
          return;
          j = 0;
          break;
          label363:
          k = OpenGlRender.FLAG_Angle90;
          break label246;
          label371:
          i = 0;
          continue;
        }
        if (this.Lny.LnE == null)
        {
          this.Lny.w = paramInt2;
          this.Lny.h = paramInt2;
          this.Lny.LnE = new int[this.Lny.w * this.Lny.h];
        }
        paramArrayOfByte = o.Ljn;
        paramArrayOfByte = this.Lnz;
        localObject1 = this.Lnz;
        kotlin.g.b.s.checkNotNull(localObject1);
        paramArrayOfByte = o.a(paramArrayOfByte, localObject1.length, this.Lny.w, this.Lny.h, paramInt3 + paramInt4 & 0x1F, this.Lny.LnE);
        if ((paramArrayOfByte.ret < 0) || (this.Lny.LnE == null) || (paramArrayOfByte.Lmm == 0) || (paramArrayOfByte.Lmn == 0))
        {
          Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv trans ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.ret) });
          AppMethodBeat.o(284890);
          return;
        }
        paramInt1 = paramArrayOfByte.Lmm;
        i = paramArrayOfByte.Lmn;
        if (!o.Ljn.Ljr.isStarted())
        {
          AppMethodBeat.o(284890);
          return;
        }
        paramLong = System.currentTimeMillis();
        paramInt4 = o.Ljn.i(this.Lnz, paramInt2, paramInt2, paramInt3 + paramInt4);
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
      if (this.Lny.LnE != null)
      {
        paramArrayOfByte = ac.ggS().ggf();
        localObject1 = z.bAM();
        kotlin.g.b.s.s(localObject1, "getUsernameFromUserInfo()");
        localObject2 = this.Lny.LnE;
        kotlin.g.b.s.checkNotNull(localObject2);
        paramArrayOfByte.a((String)localObject1, (int[])localObject2, paramInt2, paramInt3, j, k);
      }
      this.Lnu = Util.currentTicks();
      AppMethodBeat.o(284890);
      return;
      if (this.Lny.LnE == null)
      {
        this.Lny.w = paramInt1;
        this.Lny.h = paramInt2;
        this.Lny.LnE = new int[this.Lny.w * this.Lny.h];
      }
      localObject1 = o.Ljn;
      localObject1 = o.a(paramArrayOfByte, (int)paramLong, this.Lny.w, this.Lny.h, paramInt3 + paramInt4 & 0x1F, this.Lny.LnE);
      if ((((t)localObject1).ret < 0) || (this.Lny.LnE == null) || (((t)localObject1).Lmm == 0) || (((t)localObject1).Lmn == 0))
      {
        Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv trans ret: %d", new Object[] { Integer.valueOf(((t)localObject1).ret) });
        AppMethodBeat.o(284890);
        return;
      }
      m = ((t)localObject1).Lmm;
      i = ((t)localObject1).Lmn;
      if (!o.Ljn.Ljr.isStarted())
      {
        AppMethodBeat.o(284890);
        return;
      }
      paramLong = System.currentTimeMillis();
      paramInt1 = o.Ljn.i(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
      paramInt2 = m;
      paramInt3 = i;
    }
    label1018:
    if (this.Lny.LnE == null)
    {
      this.Lny.w = paramInt1;
      this.Lny.h = paramInt2;
      this.Lny.LnE = new int[this.Lny.w * this.Lny.h];
    }
    localObject1 = ac.ggR().LnJ.b(paramArrayOfByte, (int)paramLong, this.Lny.w, this.Lny.h, paramInt3 + paramInt4 & 0x1F, this.Lny.LnE);
    if ((((g)localObject1).ret < 0) || (this.Lny.LnE == null) || (((g)localObject1).Lmm == 0) || (((g)localObject1).Lmn == 0))
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "mv ret: %d", new Object[] { Integer.valueOf(((g)localObject1).ret) });
      AppMethodBeat.o(284890);
      return;
    }
    int m = ((g)localObject1).Lmm;
    int n = ((g)localObject1).Lmn;
    long l1 = System.currentTimeMillis();
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      label1212:
      if (!ac.ggS().Loz) {
        break label1286;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label1280;
      }
      i = 259;
    }
    label1280:
    label1286:
    for (;;)
    {
      paramInt1 = ac.ggS().ggd().b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = l1;
      paramInt3 = n;
      paramInt2 = m;
      break;
      i = 1;
      break label1212;
      i = 3;
    }
  }
  
  public final boolean bsA()
  {
    return this.Lnv != null;
  }
  
  public final void dre()
  {
    AppMethodBeat.i(284872);
    e locale = this.Lnt;
    if (locale != null) {
      locale.gfd();
    }
    AppMethodBeat.o(284872);
  }
  
  public final void gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284875);
    Log.i("MicroMsg.MultiTalkCameraManager", "camera preview size applye is " + paramInt1 + " and " + paramInt2);
    AppMethodBeat.o(284875);
  }
  
  public final void gfj()
  {
    AppMethodBeat.i(284865);
    if ((this.Lnv != null) && (bsA()) && (gfm()) && (this.Lnw)) {
      Py();
    }
    AppMethodBeat.o(284865);
  }
  
  public final boolean gfm()
  {
    AppMethodBeat.i(284905);
    if ((this.Lnu != 0L) && (Util.ticksToNow(this.Lnu) > gfl()))
    {
      Log.i("MicroMsg.MultiTalkCameraManager", "current camera is open but has no video ");
      AppMethodBeat.o(284905);
      return true;
    }
    AppMethodBeat.o(284905);
    return false;
  }
  
  public final boolean gfn()
  {
    w localw = this.Lnv;
    if (localw == null) {
      return false;
    }
    return localw.LpL;
  }
  
  public final void gfo()
  {
    AppMethodBeat.i(284918);
    a locala = (a)new f(this);
    this.mVg = com.tencent.threadpool.c.d.jv(kotlin.g.b.s.X("MultiTalkCameraManager_Thread", Integer.valueOf(hashCode())), 5);
    Object localObject = this.mVg;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.mVg;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((HandlerThread)localObject).getLooper())
    {
      this.mVh = new MMHandler((Looper)localObject);
      K((a)new m.d(this, locala));
      AppMethodBeat.o(284918);
      return;
    }
  }
  
  public final void gfp()
  {
    AppMethodBeat.i(284922);
    gfk();
    AppMethodBeat.o(284922);
  }
  
  public final void release()
  {
    AppMethodBeat.i(284868);
    this.Lnu = 0L;
    K((a)new e(this));
    AppMethodBeat.o(284868);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "", "()V", "h", "", "getH", "()I", "setH", "(I)V", "outImg", "", "getOutImg", "()[I", "setOutImg", "([I)V", "w", "getW", "setW", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    int[] LnE;
    int h;
    int w;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements a<ah>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements a<ah>
  {
    f(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */