package com.tencent.mm.plugin.recordvideo.d;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.h;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/recorder/CameraKitRecorder;", "Lcom/tencent/mm/media/camera/render/BaseCustomRenderCallback;", "useCachePath", "", "(Z)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "glContext", "Landroid/opengl/EGLContext;", "mediaRecorder", "Lcom/tencent/mm/media/widget/recorder/MediaCodecMP4MuxRecorder;", "minRecordTimeMs", "", "mute", "startRecordTimeStamp", "textureHeight", "", "textureWidth", "getUseCachePath", "()Z", "setUseCachePath", "createRecordRender", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "createRecorder", "", "glCreate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glRelease", "glRender", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initProvider", "renderEncode", "reset", "setMute", "setRecordMinTimeMs", "cost", "startRecord", "orientation", "isLandscape", "stopRecord", "Lkotlin/Pair;", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.media.camera.f.a
{
  public static final a.a NQQ;
  private boolean NQR;
  private c NQS;
  private EGLContext NQT;
  public long NQU;
  private int mVd;
  private int mVe;
  private long nJl;
  private boolean nLP;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(279753);
    NQQ = new a.a((byte)0);
    AppMethodBeat.o(279753);
  }
  
  public a(boolean paramBoolean)
  {
    super((byte)0);
    this.NQR = paramBoolean;
    this.NQU = 1500L;
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(279747);
    s.u(parama, "this$0");
    parama.gJb();
    AppMethodBeat.o(279747);
  }
  
  private static com.tencent.mm.media.j.a gJa()
  {
    AppMethodBeat.i(279733);
    com.tencent.mm.media.j.a locala = (com.tencent.mm.media.j.a)new b();
    AppMethodBeat.o(279733);
    return locala;
  }
  
  private final void gJb()
  {
    Object localObject2 = null;
    AppMethodBeat.i(279742);
    c localc;
    if ((this.oaV != null) && (this.NQT != null))
    {
      Log.i("MicroMsg.CameraKitRecorder", "create recorder");
      localObject1 = this.NQS;
      if (localObject1 != null) {
        ((c)localObject1).cancel();
      }
      localObject1 = this.oaV;
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject1 = (VideoTransPara)localObject1;
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(279742);
        return;
        localObject1 = ((RecordConfigProvider)localObject1).oXZ;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((VideoTransPara)localObject1).clone();
        }
      }
      ((VideoTransPara)localObject1).videoBitrate *= 5;
      this.NQS = new c((VideoTransPara)localObject1, gJa(), this.NQT, -1);
      localObject1 = this.NQS;
      if (localObject1 != null) {
        ((c)localObject1).setMute(this.nLP);
      }
      localObject1 = this.NQS;
      if (localObject1 != null) {
        ((c)localObject1).uw(0);
      }
      localc = this.NQS;
      if (localc != null)
      {
        if (!this.NQR) {
          break label211;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.util.e.Obp;
        localObject1 = com.tencent.mm.plugin.recordvideo.util.e.gLf();
        localc.setFilePath((String)localObject1);
      }
      localc = this.NQS;
      if (localc != null)
      {
        localObject1 = this.oaV;
        if (localObject1 != null) {
          break label233;
        }
      }
    }
    label211:
    label233:
    for (Object localObject1 = localObject2;; localObject1 = ((RecordConfigProvider)localObject1).thumbPath)
    {
      localc.Hd((String)localObject1);
      AppMethodBeat.o(279742);
      return;
      localObject1 = this.oaV;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RecordConfigProvider)localObject1).NId;
      break;
    }
  }
  
  public final Object G(kotlin.d.d<? super r<Integer, com.tencent.mm.media.widget.camerarecordview.b.b>> paramd)
  {
    AppMethodBeat.i(279805);
    h localh = new h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject;
    Result.Companion localCompanion;
    if (System.currentTimeMillis() - this.nJl <= this.NQU)
    {
      reset();
      localObject = new r(Integer.valueOf(-4), null);
      localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localObject));
    }
    label168:
    for (;;)
    {
      localObject = localh.kli();
      if (localObject == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(279805);
      return localObject;
      localObject = this.NQS;
      if (localObject == null) {}
      for (localObject = null;; localObject = ah.aiuX)
      {
        if (localObject != null) {
          break label168;
        }
        localObject = new r(Integer.valueOf(-1), null);
        localCompanion = Result.Companion;
        locald.resumeWith(Result.constructor-impl(localObject));
        break;
        ((c)localObject).J((Runnable)new g(this, locald));
      }
    }
  }
  
  public final Object a(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    int j = 1;
    AppMethodBeat.i(279780);
    e locale;
    if ((paramd1 instanceof e))
    {
      locale = (e)paramd1;
      if ((locale.label & 0x80000000) != 0) {
        locale.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = locale.result;
      locala = kotlin.d.a.a.aiwj;
      switch (locale.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(279780);
        throw paramd;
        locale = new e(this, paramd1);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    locale.L$0 = this;
    locale.Uf = paramd;
    locale.label = 1;
    Object localObject1 = this;
    paramd1 = paramd;
    if (super.a(paramd, locale) == locala)
    {
      AppMethodBeat.o(279780);
      return locala;
      paramd1 = (com.tencent.mm.media.g.d)locale.Uf;
      localObject1 = (a)locale.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    int i;
    if ((((a)localObject1).mVd == paramd1.width) && (((a)localObject1).mVe == paramd1.height))
    {
      i = paramd1.nAF;
      paramd = ((a)localObject1).NQS;
      if ((paramd == null) || (i != paramd.textureId)) {
        break label532;
      }
      i = 1;
      if (i != 0) {}
    }
    else
    {
      Log.i("MicroMsg.CameraKitRecorder", "input tex:" + paramd1.nAF + " width:" + paramd1.width + " height:" + paramd1.height);
      ((a)localObject1).mVd = paramd1.width;
      ((a)localObject1).mVe = paramd1.height;
      paramd = ((a)localObject1).NQS;
      if (paramd != null) {
        paramd.A(((a)localObject1).mVd, ((a)localObject1).mVe, ((a)localObject1).mVd, ((a)localObject1).mVe);
      }
      paramd = ((a)localObject1).NQS;
      if (paramd != null) {
        paramd.textureId = paramd1.nAF;
      }
    }
    locale.L$0 = paramd1;
    locale.Uf = null;
    locale.label = 2;
    paramd = new q(kotlin.d.a.b.au(locale), 1);
    paramd.kBA();
    Object localObject2 = (p)paramd;
    Object localObject3 = ((a)localObject1).NQS;
    if ((localObject3 != null) && (((c)localObject3).buK() == true))
    {
      i = j;
      label438:
      if (i == 0) {
        break label542;
      }
      GLES20.glFlush();
      localObject1 = ((a)localObject1).NQS;
      if (localObject1 != null)
      {
        ((c)localObject1).nCZ = ((kotlin.g.a.a)new a.f((p)localObject2));
        ((c)localObject1).gJ(false);
      }
    }
    for (;;)
    {
      localObject1 = paramd.getResult();
      if (localObject1 == kotlin.d.a.a.aiwj) {
        s.u(locale, "frame");
      }
      paramd = (com.tencent.mm.media.g.d)localObject1;
      if (localObject1 != kotlin.d.a.a.aiwj) {
        paramd = ah.aiuX;
      }
      if (paramd != locala) {
        break label588;
      }
      AppMethodBeat.o(279780);
      return locala;
      label532:
      i = 0;
      break;
      i = 0;
      break label438;
      label542:
      localObject1 = (kotlin.d.d)localObject2;
      localObject2 = ah.aiuX;
      localObject3 = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
    }
    paramd1 = (com.tencent.mm.media.g.d)locale.L$0;
    ResultKt.throwOnFailure(localObject2);
    label588:
    AppMethodBeat.o(279780);
    return paramd1;
  }
  
  public final boolean bu(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(279792);
    this.nJl = System.currentTimeMillis();
    c localc = this.NQS;
    if (localc != null) {
      localc.b(0, paramBoolean, paramInt);
    }
    AppMethodBeat.o(279792);
    return true;
  }
  
  public final void i(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279762);
    s.u(paramRecordConfigProvider, "configProvider");
    this.oaV = paramRecordConfigProvider;
    AppMethodBeat.o(279762);
  }
  
  public final Object p(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279768);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(279768);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.CameraKitRecorder", "create");
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (super.p(paramd) == locala)
    {
      AppMethodBeat.o(279768);
      return locala;
      localObject1 = (a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    ((a)localObject1).NQT = EGL14.eglGetCurrentContext();
    ((a)localObject1).gJb();
    paramd = ah.aiuX;
    AppMethodBeat.o(279768);
    return paramd;
  }
  
  public final Object q(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279787);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(279787);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.CameraKitRecorder", "release");
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (super.q(paramd) == locala)
    {
      AppMethodBeat.o(279787);
      return locala;
      localObject1 = (a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    ((a)localObject1).NQT = null;
    ((a)localObject1).mVd = 0;
    ((a)localObject1).mVe = 0;
    paramd = ((a)localObject1).NQS;
    if (paramd != null) {
      paramd.cancel();
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(279787);
    return paramd;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(279796);
    Log.i("MicroMsg.CameraKitRecorder", "reset");
    this.mVd = 0;
    this.mVe = 0;
    c localc = this.NQS;
    if (localc != null) {
      localc.cancel();
    }
    this.NQS = null;
    bot();
    com.tencent.mm.media.camera.f.a.a((com.tencent.mm.media.camera.f.a)this, new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(279796);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(279772);
    Log.i("MicroMsg.CameraKitRecorder", s.X("setMute ", Boolean.valueOf(paramBoolean)));
    this.nLP = paramBoolean;
    c localc = this.NQS;
    if (localc != null) {
      localc.setMute(paramBoolean);
    }
    AppMethodBeat.o(279772);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/recorder/CameraKitRecorder$createRecordRender$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.media.j.a
  {
    b()
    {
      super(0, 1, 2, 15);
    }
    
    public final com.tencent.mm.media.j.b.a bgD()
    {
      AppMethodBeat.i(279736);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.e(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
      AppMethodBeat.o(279736);
      return locala;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(a parama, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(279722);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.NQV.p((kotlin.d.d)this);
      AppMethodBeat.o(279722);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(a parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(279731);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.NQV.q((kotlin.d.d)this);
      AppMethodBeat.o(279731);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    e(a parama, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(279723);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.NQV.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(279723);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    implements Runnable
  {
    g(a parama, kotlin.d.d<? super r<Integer, com.tencent.mm.media.widget.camerarecordview.b.b>> paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(279738);
      Object localObject1 = a.b(this.NQV);
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.CameraKitRecorder", s.X("media recorder stop file exist:", Boolean.valueOf(y.ZC((String)localObject1))));
        localObject1 = a.b(this.NQV);
        if (localObject1 != null) {
          break label138;
        }
        localObject1 = null;
        label50:
        if (!y.ZC((String)localObject1)) {
          break label285;
        }
        localObject1 = a.b(this.NQV);
        if (localObject1 != null) {
          break label146;
        }
      }
      label138:
      label146:
      for (localObject1 = null;; localObject1 = ((c)localObject1).getFilePath())
      {
        localObject2 = f.aVX((String)localObject1);
        Log.i("MicroMsg.CameraKitRecorder", s.X("media result info:", localObject2));
        if (localObject2 != null) {
          break label154;
        }
        localObject1 = locald;
        localObject2 = new r(Integer.valueOf(-3), null);
        localObject3 = Result.Companion;
        ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
        AppMethodBeat.o(279738);
        return;
        localObject1 = ((c)localObject1).getFilePath();
        break;
        localObject1 = ((c)localObject1).getFilePath();
        break label50;
      }
      label154:
      localObject1 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW = true;
      Object localObject3 = a.b(this.NQV);
      s.checkNotNull(localObject3);
      localObject3 = ((c)localObject3).getFilePath();
      s.s(localObject3, "mediaRecorder!!.filePath");
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).GZ((String)localObject3);
      localObject3 = a.b(this.NQV);
      s.checkNotNull(localObject3);
      localObject3 = ((c)localObject3).bud();
      s.s(localObject3, "mediaRecorder!!.thumbPath");
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).Ha((String)localObject3);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).startTime = 0;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime = ((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration;
      Object localObject2 = locald;
      localObject1 = new r(Integer.valueOf(0), localObject1);
      localObject3 = Result.Companion;
      ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(localObject1));
      AppMethodBeat.o(279738);
      return;
      label285:
      localObject1 = locald;
      localObject2 = new r(Integer.valueOf(-2), null);
      localObject3 = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
      AppMethodBeat.o(279738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a
 * JD-Core Version:    0.7.0.1
 */