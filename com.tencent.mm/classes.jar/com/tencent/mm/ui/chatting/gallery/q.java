package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.pm;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.thumbplayer.downloader.i.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.j;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler;", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAbstractVideoHandler;", "adapter", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter;", "(Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter;)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "currPlayTime", "", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "enterTime", "", "filename", "", "hadPlayError", "", "handledItems", "Ljava/util/HashMap;", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$VideoItem;", "Lkotlin/collections/HashMap;", "isPlayRawVideo", "isToolbarShowing", "itemScope", "Lkotlinx/coroutines/CoroutineScope;", "lastCheckTime", "lastSurfaceUpdateTime", "listener", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged;", "progressMonitorJob", "Lkotlinx/coroutines/Job;", "seekCallback", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "surfaceCheckerJob", "surfaceErrorTime", "surfaceRepairTime", "waitingForDownload", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "attachDebugInfo", "", "videoView", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;", "textView", "Landroid/widget/TextView;", "awaitVideoDownloadedWithProgress", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "(Lcom/tencent/mm/storage/MsgInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cachedVideoTime", "canPlayAsSender", "info", "Lcom/tencent/mm/modelvideo/VideoInfo;", "checkIsRawVideoPlayError", "checkOriginVideoProcess", "position", "checkScope", "checkSurfaceIsUpdate", "detach", "endNotify", "item", "filling", "holder", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder;", "getHolder", "pos", "keepScreenOn", "loadThumb", "monitorProgress", "onDownloadError", "error", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$DownloadException;", "onPause", "onResume", "onVideoBuffering", "onVideoCompletion", "onVideoDownloading", "progress", "onVideoError", "what", "extra", "onVideoPlaying", "onVideoPrepared", "onVideoStopped", "updateIndicator", "openByExternalPlayer", "videoPath", "pause", "play", "releaseScreenOn", "removePlayingCache", "repairVideoDuration", "duration", "resetSeekCallback", "rptRepairEffect", "errorTime", "rptRestransmit", "rptSaveVideo", "rptSurfaceNotUpdate", "rptWaitToRestransmit", "rptWaitToSaveVideo", "showErrorView", "errMsg", "showToolbar", "fileName", "startSurfaceChecker", "stop", "stopAll", "toggleVideo", "toggleVideoMenu", "tryPlayOriginVideo", "Companion", "VideoItem", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends g
{
  public static final q.a aeEM;
  private static final boolean rKp;
  private int Aqd;
  private final com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private cb RVb;
  private com.tencent.mm.plugin.thumbplayer.downloader.i RgU;
  private aq aeEN;
  private cb aeEO;
  private final HashMap<String, q.b> aeEP;
  private boolean aeEQ;
  private aa.a aeER;
  private boolean aeES;
  private boolean aeET;
  private boolean aeEv;
  private int aeEx;
  private int aeEy;
  private long enterTime;
  private String filename;
  private long lastCheckTime;
  private final com.tencent.mm.model.d nmW;
  private long sJl;
  private PowerManager.WakeLock wakeLock;
  
  static
  {
    AppMethodBeat.i(254645);
    aeEM = new q.a((byte)0);
    rKp = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvu, false);
    AppMethodBeat.o(254645);
  }
  
  public q(h paramh)
  {
    super(paramh);
    AppMethodBeat.i(254456);
    this.aeEN = ar.kBZ();
    this.nmW = new com.tencent.mm.model.d();
    this.aeEP = new HashMap();
    this.Aqj = ((com.tencent.mm.plugin.sight.decode.ui.b)new m(paramh, this));
    AppMethodBeat.o(254456);
  }
  
  private static final void V(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(254513);
    if (paramDialogInterface != null) {
      paramDialogInterface.cancel();
    }
    AppMethodBeat.o(254513);
  }
  
  private final Object a(final cc paramcc, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(254484);
    if ((paramd instanceof d))
    {
      localObject = (d)paramd;
      if ((((d)localObject).label & 0x80000000) != 0) {
        ((d)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject;; paramd = new d(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramcc = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254484);
        throw paramcc;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("await video to be fully downloaded, status=", Integer.valueOf(((z)localObject).status)));
    if (((z)localObject).bOw())
    {
      com.tencent.mm.modelvideo.ab.Qu(paramcc.field_imgPath);
      if (paramcc.isClean()) {
        break label262;
      }
      localObject = g.dd(paramcc);
      if ((localObject == null) || (((z)localObject).bOx() != true)) {
        break label257;
      }
    }
    label257:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label262;
      }
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "msg is not clean and video has been downloaded");
      paramcc = ah.aiuX;
      AppMethodBeat.o(254484);
      return paramcc;
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "start offline mode receive");
      com.tencent.threadpool.h.ahAA.bm(new q..ExternalSyntheticLambda3(paramcc));
      com.tencent.mm.modelvideo.ab.Qj(paramcc.field_imgPath);
      break;
    }
    label262:
    paramd.L$0 = this;
    paramd.Uf = paramcc;
    paramd.label = 1;
    localObject = new kotlinx.coroutines.q(kotlin.d.a.b.au(paramd), 1);
    ((kotlinx.coroutines.q)localObject).kBA();
    p localp = (p)localObject;
    paramcc = new f(localp, paramcc, this);
    com.tencent.mm.modelvideo.v.bOh().a((aa.a)paramcc, Looper.getMainLooper());
    localp.bg((kotlin.g.a.b)new e(paramcc));
    localObject = ((kotlinx.coroutines.q)localObject).getResult();
    if (localObject == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    paramcc = (cc)localObject;
    if (localObject == locala)
    {
      AppMethodBeat.o(254484);
      return locala;
      ResultKt.throwOnFailure(localObject);
      paramcc = (cc)localObject;
    }
    if (((Boolean)paramcc).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("video has been fully downloaded: ret=", Boolean.valueOf(bool)));
      paramcc = ah.aiuX;
      AppMethodBeat.o(254484);
      return paramcc;
    }
  }
  
  private static final void a(q paramq)
  {
    AppMethodBeat.i(254493);
    s.u(paramq, "this$0");
    paramq.aeAg.aeAB.bBj(null);
    paramq.aeAg.aeAB.jvG();
    AppMethodBeat.o(254493);
  }
  
  private static final void a(q paramq, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(254507);
    s.u(paramq, "this$0");
    if (paramDialogInterface != null) {
      paramDialogInterface.cancel();
    }
    com.tencent.threadpool.h.ahAA.bk(new q..ExternalSyntheticLambda5(paramq));
    AppMethodBeat.o(254507);
  }
  
  private final boolean a(q.b paramb)
  {
    AppMethodBeat.i(254489);
    if (paramb == null)
    {
      AppMethodBeat.o(254489);
      return false;
    }
    if (this.aeAg.aeAB.getCurrentItem() == paramb.position)
    {
      paramb = aCt(paramb.position);
      if (paramb != null)
      {
        paramb.jwq().aeFB.setVisibility(8);
        paramb.jwq().aeFs.setVisibility(8);
        paramb.jwq().aeFq.setVisibility(8);
      }
      this.aeET = true;
      this.aeAg.aeAB.jvG();
      AppMethodBeat.o(254489);
      return true;
    }
    this.aeAg.aCG(paramb.position);
    AppMethodBeat.o(254489);
    return false;
  }
  
  private static final void b(q paramq)
  {
    AppMethodBeat.i(254497);
    s.u(paramq, "this$0");
    paramq.aeAg.aeAB.onBackPressed();
    AppMethodBeat.o(254497);
  }
  
  private static final void b(q paramq, r paramr)
  {
    AppMethodBeat.i(254518);
    s.u(paramq, "this$0");
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "First video frame has been rendered");
    paramq.h(paramr);
    AppMethodBeat.o(254518);
  }
  
  private final void b(r paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(254471);
    if (this.aeAg == null)
    {
      AppMethodBeat.o(254471);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoStopped(" + paramr.mPosition + ')');
    this.aeAg.aeAB.Aqi.stopTimer();
    if (paramBoolean)
    {
      this.aeAg.aeAB.setVideoStateIv(true);
      paramr.jwq().aeFs.setVisibility(8);
      paramr.jwq().aeFB.setVisibility(8);
      r.bo((View)paramr.jwq().aeFq, 0);
    }
    this.nmW.gR(false);
    if (this.aeAg != null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "release screen on");
      paramr = this.wakeLock;
      if (paramr != null) {
        if (!paramr.isHeld()) {
          break label366;
        }
      }
    }
    for (;;)
    {
      if (paramr != null)
      {
        com.tencent.mm.hellhoundlib.a.a.b(paramr, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "releaseScreenOn", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        paramr.release();
        com.tencent.mm.hellhoundlib.a.a.c(paramr, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "releaseScreenOn", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      this.aeAg.aeAB.getContext().getWindow().clearFlags(128);
      paramr = this.RVb;
      if (paramr != null) {
        paramr.a(null);
      }
      this.RVb = null;
      paramr = this.aeEO;
      if (paramr != null) {
        paramr.a(null);
      }
      this.aeEO = null;
      if ((this.aeAg != null) && (this.aeAg.aeAB != null)) {
        this.aeAg.aeAB.aeCD.dt(this.aeAg.jvd());
      }
      paramr = this.aeAu;
      if (paramr != null) {
        paramr.aeJs.jtn = kotlin.h.a.ai((float)(System.currentTimeMillis() - paramr.ork) / 1000.0F);
      }
      paramr = this.aeAu;
      if (paramr != null) {
        paramr.report();
      }
      this.aeAu = null;
      AppMethodBeat.o(254471);
      return;
      label366:
      paramr = null;
    }
  }
  
  private static final void c(q paramq)
  {
    AppMethodBeat.i(254502);
    s.u(paramq, "this$0");
    if ((paramq.aeAg != null) && (paramq.aeAg.aeAB != null)) {
      paramq.aeAg.aeAB.onBackPressed();
    }
    AppMethodBeat.o(254502);
  }
  
  private static final void dy(cc paramcc)
  {
    AppMethodBeat.i(254522);
    s.u(paramcc, "$msg");
    com.tencent.mm.modelvideo.ab.bh(paramcc.field_imgPath, 10);
    AppMethodBeat.o(254522);
  }
  
  private final void h(r paramr)
  {
    AppMethodBeat.i(254468);
    if (this.aeAg == null)
    {
      AppMethodBeat.o(254468);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoPlaying");
    paramr.d(true, 1.0F);
    paramr.jwq().aeFB.setVisibility(8);
    this.aeAg.aeAB.setVideoStateIv(false);
    if (this.aeAg.aeAB.aeDV) {
      this.aeAg.aeAB.jvR();
    }
    this.nmW.bAh();
    paramr = paramr.jwq().aeFr;
    if (paramr == null)
    {
      paramr = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
      AppMethodBeat.o(254468);
      throw paramr;
    }
    paramr = (ThumbPlayerVideoView)paramr;
    Object localObject = this.aeAg.aeAB.jvo().SGW;
    ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime(paramr.getDuration() / 1000);
    ((RedesignVideoPlayerSeekBar)localObject).seek(paramr.getCurrentPosition() / 1000);
    cb localcb = this.RVb;
    if (localcb != null) {
      localcb.a(null);
    }
    this.RVb = j.a(this.aeEN, null, null, (m)new i(paramr, (RedesignVideoPlayerSeekBar)localObject, this, null), 3);
    localObject = this.aeEO;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    this.aeEO = j.a(this.aeEN, null, null, (m)new q.n(this, paramr, null), 3);
    if (this.aeAg != null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "keep screen on");
      this.aeAg.aeAB.getContext().getWindow().addFlags(128);
    }
    if ((this.aeAg != null) && (this.aeAg.aeAB != null)) {
      this.aeAg.aeAB.aeCD.du(this.aeAg.jvd());
    }
    AppMethodBeat.o(254468);
  }
  
  public static final boolean isEnabled()
  {
    return rKp;
  }
  
  private final void jwe()
  {
    AppMethodBeat.i(254461);
    try
    {
      this.aeAg.aeAB.jvo().SGW.setIplaySeekCallback(this.Aqj);
      AppMethodBeat.o(254461);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(254461);
    }
  }
  
  private final void jwi()
  {
    AppMethodBeat.i(254462);
    if (!ar.a(this.aeEN)) {
      this.aeEN = ar.kBZ();
    }
    AppMethodBeat.o(254462);
  }
  
  private final void p(final cc paramcc, final int paramInt)
  {
    AppMethodBeat.i(254459);
    this.aeES = false;
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "play(" + paramInt + ')');
    final r localr = aCt(paramInt);
    if (localr == null)
    {
      AppMethodBeat.o(254459);
      return;
    }
    Object localObject = localr.jwq().aeFr;
    if (localObject == null)
    {
      paramcc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
      AppMethodBeat.o(254459);
      throw paramcc;
    }
    localObject = (ThumbPlayerVideoView)localObject;
    j.a(this.aeEN, null, null, (m)new k(this, paramcc, localr, (ThumbPlayerVideoView)localObject, paramInt, null), 3);
    AppMethodBeat.o(254459);
  }
  
  protected final void a(r paramr)
  {
    AppMethodBeat.i(254757);
    s.u(paramr, "holder");
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "stop(" + paramr.mPosition + ')');
    paramr.d(false, 0.0F);
    Object localObject = paramr.aeFr;
    if ((localObject instanceof ThumbPlayerVideoView)) {}
    for (localObject = (ThumbPlayerVideoView)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(254757);
      return;
    }
    int i = paramr.jwq().aeFr.getCurrentPosition();
    if (!this.aeEv) {
      com.tencent.mm.modelvideo.ab.k(this.filename, Math.max(i - 1000, 0), ((ThumbPlayerVideoView)localObject).ykm);
    }
    this.aeEQ = false;
    ((ThumbPlayerVideoView)localObject).stop();
    localObject = this.RgU;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject).stop();
    }
    b(paramr, true);
    AppMethodBeat.o(254757);
  }
  
  protected final void a(r paramr, String paramString)
  {
    AppMethodBeat.i(254747);
    super.a(paramr, paramString);
    if (paramr != null) {
      r.bo((View)paramr.jwq().aeFq, 8);
    }
    AppMethodBeat.o(254747);
  }
  
  public final boolean a(final r paramr, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(254742);
    s.u(paramr, "holder");
    super.a(paramr, paramcc, paramInt);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("filling: ", Integer.valueOf(paramInt)));
    if (paramcc == null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", s.X("null msg: imgPath=", null));
      AppMethodBeat.o(254742);
      return false;
    }
    if (!this.aeEP.containsKey(paramcc.field_imgPath)) {
      ((Map)this.aeEP).put(paramcc.field_imgPath, new q.b(paramInt, paramcc, (byte)0));
    }
    jwi();
    if (!(paramr.jwq().aeFr instanceof ThumbPlayerVideoView))
    {
      paramr = (Throwable)new IllegalStateException("Must use ThumbPlayerTextureView".toString());
      AppMethodBeat.o(254742);
      throw paramr;
    }
    Object localObject = paramr.jwq().aeFr;
    if (localObject == null)
    {
      paramr = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
      AppMethodBeat.o(254742);
      throw paramr;
    }
    ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)localObject;
    if (localThumbPlayerVideoView.isPlaying()) {
      localThumbPlayerVideoView.stop();
    }
    if ((aw.jkS()) || (aw.ato())) {}
    for (localObject = i.e.XYM;; localObject = i.e.XYK)
    {
      localThumbPlayerVideoView.setScaleType((i.e)localObject);
      paramr.aeFt.setVisibility(8);
      paramr.jwq().aeFs.setVisibility(8);
      paramr.jwq().aeFB.setVisibility(8);
      paramr.d(false, 0.0F);
      this.enterTime = Util.nowMilliSecond();
      j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new h(paramcc, paramr, this, null), 2);
      AppMethodBeat.o(254742);
      return true;
    }
  }
  
  public final r aCt(int paramInt)
  {
    AppMethodBeat.i(254739);
    r localr = super.aCt(paramInt);
    if (localr == null) {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "getHolder(" + paramInt + ") returns null!");
    }
    AppMethodBeat.o(254739);
    return localr;
  }
  
  protected final void aCw(int paramInt)
  {
    AppMethodBeat.i(254704);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "removePlayingCache");
    AppMethodBeat.o(254704);
  }
  
  protected final void aCx(int paramInt)
  {
    AppMethodBeat.i(254709);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "pause()");
    r localr = aCt(paramInt);
    if (localr == null)
    {
      AppMethodBeat.o(254709);
      return;
    }
    localr.jwq().aeFr.pause();
    this.aeAg.aeAB.setVideoStateIv(true);
    b(localr, true);
    AppMethodBeat.o(254709);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(254750);
    Log.w("MicroMsg.Imagegallery.handler.video.tp", "detach");
    aa.a locala = this.aeER;
    if (locala != null) {
      com.tencent.mm.modelvideo.v.bOh().a(locala);
    }
    stopAll();
    super.detach();
    ar.a(this.aeEN, null);
    AppMethodBeat.o(254750);
  }
  
  protected final void di(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254732);
    Log.w("MicroMsg.Imagegallery.handler.video.tp", "onVideoError(" + paramInt1 + ", " + paramInt2 + ')');
    Object localObject1 = this.aeAg;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((h)localObject1).jve())
    {
      AppMethodBeat.o(254732);
      return;
    }
    Object localObject2 = ((r)localObject1).aeFr;
    if ((localObject2 instanceof ThumbPlayerVideoView)) {}
    for (localObject2 = (ThumbPlayerVideoView)localObject2; localObject2 == null; localObject2 = null)
    {
      AppMethodBeat.o(254732);
      return;
    }
    Object localObject3 = com.tencent.mm.modelvideo.ab.Qo(this.filename);
    if ((localObject3 != null) && (this.aeES))
    {
      this.aeES = false;
      localObject3 = com.tencent.mm.modelvideo.ab.Qo(((z)localObject3).oYk);
      if (localObject3 != null)
      {
        ((z)localObject3).status = 143;
        ((z)localObject3).eQp = 256;
        com.tencent.mm.modelvideo.ab.f((z)localObject3);
      }
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      com.tencent.mm.modelvideo.v.bOh();
      ((ThumbPlayerVideoView)localObject2).setVideoPath(com.tencent.mm.modelvideo.aa.PX(this.filename));
      localObject1 = this.aeAg;
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).aeAB;
        if (localObject1 != null) {
          ((ImageGalleryUI)localObject1).jvW();
        }
      }
      localObject1 = this.aeAg;
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).aeAB;
        if (localObject1 != null) {
          ((ImageGalleryUI)localObject1).jvG();
        }
      }
      AppMethodBeat.o(254732);
      return;
    }
    this.aeEv = true;
    Object localObject4;
    if (!((ThumbPlayerVideoView)localObject2).ykm)
    {
      localObject3 = ((ThumbPlayerVideoView)localObject2).getVideoPath();
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
        break label532;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        Log.e("MicroMsg.Imagegallery.handler.video.tp", "play video error, use third player.[" + localObject3 + ']');
      }
      try
      {
        localObject4 = new Intent();
        ((Intent)localObject4).setAction("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType((Context)this.aeAg.aeAB, (Intent)localObject4, new com.tencent.mm.vfs.u((String)localObject3), "video/*", false);
        localObject3 = this.aeAg.aeAB;
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject4);
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "openByExternalPlayer", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((ImageGalleryUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "openByExternalPlayer", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        b((r)localObject1, true);
        localObject3 = this.RgU;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject3).stop();
        }
        this.aeAg.aeAB.jvo().SGW.seek(0);
        ((r)localObject1).d(false, 0.0F);
        com.tencent.mm.modelvideo.ab.k(this.filename, 0, ((ThumbPlayerVideoView)localObject2).ykm);
        AppMethodBeat.o(254732);
        return;
        label532:
        paramInt1 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Imagegallery.handler.video.tp", "startActivity fail, activity not found");
          com.tencent.mm.ui.base.k.s((Context)this.aeAg.aeAB, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
        }
      }
    }
  }
  
  protected final void juY()
  {
    AppMethodBeat.i(254721);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoPrepared");
    this.aeEv = false;
    Object localObject1 = this.aeAg;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label93;
      }
      localObject1 = null;
      label42:
      if (!(localObject1 instanceof ThumbPlayerVideoView)) {
        break label121;
      }
    }
    label93:
    label121:
    for (localObject1 = (ThumbPlayerVideoView)localObject1;; localObject1 = null)
    {
      if ((localObject2 != null) && (localObject1 != null)) {
        break label127;
      }
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "notify video prepared, but holder or videoView is null.");
      AppMethodBeat.o(254721);
      return;
      localObject2 = ((h)localObject1).jve();
      break;
      localObject1 = ((r)localObject2).jwq();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label42;
      }
      localObject1 = ((r)localObject1).aeFr;
      break label42;
    }
    label127:
    final int i = Util.videoMsToSec(((ThumbPlayerVideoView)localObject1).getDuration());
    int j = com.tencent.mm.modelvideo.ab.X(i, this.filename);
    int k = this.aeAg.aeAB.jvo().SGW.getVideoTotalTime();
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoPrepared(" + hashCode() + "): lastPlayPosition=" + j + ", videoDuration=" + i + ", hadSetTotalTime=" + k + ", isUiPlaying=" + this.aeAg.aeAB.fjy());
    if ((k <= 0) || (Math.abs(k - i) >= 2)) {
      this.aeAg.aeAB.jvo().SGW.setVideoTotalTime(i);
    }
    jwe();
    if ((i == 0) || (i >= 1800))
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      ((ThumbPlayerVideoView)localObject1).setOneTimeVideoTextureUpdateCallback(new q..ExternalSyntheticLambda2(this, (r)localObject2));
      if ((this.aeAg.aeAB.isPaused()) || (this.aeEQ)) {
        break label552;
      }
      if (j <= 0) {
        break label538;
      }
      if (j >= i) {
        break label533;
      }
      i = 1;
      label367:
      if (i == 0) {
        break label543;
      }
      ((ThumbPlayerVideoView)localObject1).c(j * 1000, true);
      label383:
      ((r)localObject2).d(true, 0.0F);
      label390:
      localObject2 = ((r)localObject2).aeFt;
      if (localObject2 != null)
      {
        if (!((ThumbPlayerVideoView)localObject1).ykm) {
          break label595;
        }
        localObject1 = this.RgU;
        if (localObject1 != null) {
          break label583;
        }
        localObject1 = null;
        label424:
        Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("video path=", localObject1));
        CharSequence localCharSequence = (CharSequence)localObject1;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label605;
        }
      }
    }
    label533:
    label538:
    label543:
    label552:
    label583:
    label595:
    label605:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        j.a(this.aeEN, null, null, (m)new q.c((TextView)localObject2, (String)localObject1, null), 3);
      }
      AppMethodBeat.o(254721);
      return;
      j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new l(this, i, null), 2);
      break;
      i = 0;
      break label367;
      i = 0;
      break label367;
      ((ThumbPlayerVideoView)localObject1).start();
      break label383;
      if (this.aeEQ)
      {
        Log.w("MicroMsg.Imagegallery.handler.video.tp", "video is prepared, but we're waiting for fully download");
        break label390;
      }
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "video is prepared, but activity is paused, ignored.");
      break label390;
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject1).hKD();
      break label424;
      localObject1 = ((ThumbPlayerVideoView)localObject1).getVideoPath();
      break label424;
    }
  }
  
  protected final void juZ()
  {
    AppMethodBeat.i(254725);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoCompletion");
    Object localObject1 = this.aeAg;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((h)localObject1).jve())
    {
      AppMethodBeat.o(254725);
      return;
    }
    Object localObject2 = ((r)localObject1).aeFr;
    if ((localObject2 instanceof ThumbPlayerVideoView)) {}
    for (localObject2 = (ThumbPlayerVideoView)localObject2; localObject2 == null; localObject2 = null)
    {
      AppMethodBeat.o(254725);
      return;
    }
    b((r)localObject1, true);
    this.aeAg.aeAB.jvo().SGW.seek(0);
    ((r)localObject1).d(false, 0.0F);
    com.tencent.mm.modelvideo.ab.k(this.filename, 0, ((ThumbPlayerVideoView)localObject2).ykm);
    ((ThumbPlayerVideoView)localObject2).stop();
    localObject1 = this.RgU;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject1).stop();
    }
    AppMethodBeat.o(254725);
  }
  
  protected final void k(final cc paramcc, final int paramInt)
  {
    AppMethodBeat.i(254684);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("toggleVideo: position=", Integer.valueOf(paramInt)));
    if (paramcc == null)
    {
      AppMethodBeat.o(254684);
      return;
    }
    if ((!h.m(paramcc)) && (!h.df(paramcc)))
    {
      AppMethodBeat.o(254684);
      return;
    }
    if (this.aeEQ)
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "it's waiting for download, ignore operation");
      AppMethodBeat.o(254684);
      return;
    }
    jwi();
    Object localObject1 = g.de(paramcc);
    s.s(localObject1, "info");
    Object localObject2 = ae.pbN;
    localObject2 = ae.a.Qv(((z)localObject1).bOu());
    int i;
    if ((localObject2 != null) && (((ae)localObject2).pbO))
    {
      ((ae)localObject2).pbU = true;
      this.aeAu = new com.tencent.mm.ui.chatting.i.e(paramcc, ((z)localObject1).getFileName(), false, 1);
      localObject2 = aCt(paramInt);
      if (localObject2 != null) {
        r.bo((View)((r)localObject2).aeFq, 8);
      }
      if (cn.bDu() - paramcc.getCreateTime() > 432000000L)
      {
        this.aeAg.aeAB.bBj(this.aeAg.aeAB.getString(R.l.gRn));
        i = 1;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(254684);
      return;
      com.tencent.threadpool.h.ahAA.bk(new q..ExternalSyntheticLambda6(this));
      this.aeER = ((aa.a)new g((z)localObject1, this, paramcc, paramInt));
      com.tencent.mm.modelvideo.v.bOh().a(this.aeER, Looper.getMainLooper());
      i = 1;
      continue;
      i = 0;
    }
    boolean bool;
    if ((((z)localObject1).status == 199) || (((z)localObject1).status == 123))
    {
      bool = true;
      if (!paramcc.dSI()) {
        break label988;
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO toggle mp video, status: " + localObject1 + ".status");
      com.tencent.mm.modelvideo.v.bOh();
      localObject2 = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
      if ((!bool) || (com.tencent.mm.vfs.y.ZC((String)localObject2))) {
        break label988;
      }
      ((z)localObject1).status = 111;
      com.tencent.mm.modelvideo.v.bOh().c((z)localObject1);
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO_WARN user delete local file,reset video info status");
      bool = false;
    }
    label988:
    for (;;)
    {
      if (paramcc.dSI())
      {
        localObject2 = g.dc(paramcc);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO_ERROR mpShareVideoInfo is null");
          AppMethodBeat.o(254684);
          return;
          bool = false;
          break;
        }
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "mpVideo videoDownload " + bool + ", playKey " + ((com.tencent.mm.message.y)localObject2).Hl(paramcc.field_imgPath));
        Object localObject3 = t.aeGb;
        localObject3 = ((com.tencent.mm.message.y)localObject2).Hl(paramcc.field_imgPath);
        s.s(localObject3, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
        localObject3 = t.ajV((String)localObject3);
        Object localObject4 = t.aeGb;
        localObject4 = ((com.tencent.mm.message.y)localObject2).Hl(paramcc.field_imgPath);
        s.s(localObject4, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
        localObject4 = t.bBp((String)localObject4);
        if (((drh)localObject4).block == 1)
        {
          Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO block video");
          a(aCt(paramInt), ((drh)localObject4).aawp);
          AppMethodBeat.o(254684);
          return;
        }
        b(aCt(paramInt));
        CharSequence localCharSequence = (CharSequence)localObject3;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) && ((((z)localObject1).osy <= 0) || (!s.p(localObject3, ((z)localObject1).pbk.nTu))))
          {
            Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO  update video info. playUrl:" + localObject3 + ", length:" + ((drh)localObject4).Zhu);
            ((z)localObject1).pbk.nTu = ((String)localObject3);
            ((z)localObject1).osy = ((drh)localObject4).Zhu;
            com.tencent.mm.modelvideo.v.bOh().c((z)localObject1);
          }
          if ((!g.a((z)localObject1, (com.tencent.mm.message.y)localObject2, paramcc, paramInt, bool, (g)this)) || (bool)) {
            break;
          }
          paramcc = aCt(paramInt);
          if ((paramcc != null) && (paramcc.jwq() != null))
          {
            paramcc.jwq().aeFq.setVisibility(8);
            paramcc.jwq().aeFB.setVisibility(0);
          }
          AppMethodBeat.o(254684);
          return;
        }
      }
      b(aCt(paramInt));
      if (this.aeAg.aeAB.fjy())
      {
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "toggle pause video.");
        aCx(paramInt);
        AppMethodBeat.o(254684);
        return;
      }
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j((Context)this.aeAg.aeAB.getContext(), null);
        AppMethodBeat.o(254684);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "play(" + paramInt + ')');
      localObject1 = aCt(paramInt);
      if (localObject1 != null)
      {
        localObject1 = ((r)localObject1).jwq().aeFr;
        if (localObject1 == null)
        {
          paramcc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
          AppMethodBeat.o(254684);
          throw paramcc;
        }
        localObject1 = (ThumbPlayerVideoView)localObject1;
        if (com.tencent.mm.compatible.util.d.rc(23)) {
          ((ThumbPlayerVideoView)localObject1).setAutoFixRotation(true);
        }
        j.a(this.aeEN, null, null, (m)new p(paramcc, this, paramInt, (ThumbPlayerVideoView)localObject1, null), 3);
      }
      AppMethodBeat.o(254684);
      return;
    }
  }
  
  protected final void l(final cc paramcc, final int paramInt)
  {
    AppMethodBeat.i(254690);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("toggleVideoMenu: position=", Integer.valueOf(paramInt)));
    if (paramcc == null)
    {
      AppMethodBeat.o(254690);
      return;
    }
    jwi();
    final z localz = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    if ((localz == null) || (localz.bOx()))
    {
      AppMethodBeat.o(254690);
      return;
    }
    final r localr = aCt(paramInt);
    if (localr == null)
    {
      localObject = null;
      if (!(localObject instanceof ThumbPlayerVideoView)) {
        break label112;
      }
    }
    label112:
    for (Object localObject = (ThumbPlayerVideoView)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label117;
      }
      AppMethodBeat.o(254690);
      return;
      localObject = localr.aeFr;
      break;
    }
    label117:
    ((ThumbPlayerVideoView)localObject).pause();
    b(localr, true);
    r.bo((View)localr.jwq().aeFq, 8);
    this.aeAg.aeAB.setVideoStateIv(true);
    paramInt = this.aeAg.aeAB.An(paramcc.field_msgId);
    j.a(this.aeEN, (f)bg.kCh().kCK(), null, (m)new o((ThumbPlayerVideoView)localObject, this, localr, paramcc, paramInt, localz, null), 2);
    AppMethodBeat.o(254690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(254701);
    super.onPause();
    Object localObject = this.aeAg;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((h)localObject).jve())
    {
      AppMethodBeat.o(254701);
      return;
    }
    ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)((r)localObject).aeFr;
    if (localThumbPlayerVideoView == null)
    {
      AppMethodBeat.o(254701);
      return;
    }
    if (!this.aeEv) {
      com.tencent.mm.modelvideo.ab.k(this.filename, localThumbPlayerVideoView.getCurrentPosition(), localThumbPlayerVideoView.ykm);
    }
    if (localThumbPlayerVideoView.isPlaying())
    {
      localThumbPlayerVideoView.pause();
      j.a(this.aeEN, null, null, (m)new j(this, (r)localObject, null), 3);
    }
    if (localThumbPlayerVideoView.ykm)
    {
      localObject = this.RgU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject).stop();
      }
    }
    AppMethodBeat.o(254701);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(254696);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onResume");
    AppMethodBeat.o(254696);
  }
  
  protected final void stopAll()
  {
    AppMethodBeat.i(254693);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "stopAll");
    SparseArray localSparseArray = this.aeAg.adVc;
    int k = localSparseArray.size();
    if (k > 0) {}
    int j;
    label165:
    label175:
    label181:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = (View)localSparseArray.get(localSparseArray.keyAt(i));
      r localr;
      if (localObject == null)
      {
        localObject = null;
        localr = (r)localObject;
        if (localr != null) {
          break label165;
        }
        localObject = null;
        label79:
        if (localObject != null)
        {
          localObject = localr.aeFr;
          if (!(localObject instanceof ThumbPlayerVideoView)) {
            break label175;
          }
        }
      }
      for (localObject = (ThumbPlayerVideoView)localObject;; localObject = null)
      {
        if ((localObject != null) && (((ThumbPlayerVideoView)localObject).isInitialized())) {
          a(localr);
        }
        if (j < k) {
          break label181;
        }
        this.RgU = null;
        this.aeEQ = false;
        ar.a(this.aeEN, null);
        AppMethodBeat.o(254693);
        return;
        localObject = ((View)localObject).getTag();
        break;
        localObject = localr.aeFo;
        break label79;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    d(q paramq, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254713);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = q.a(this.aeEU, null, (kotlin.d.d)this);
      AppMethodBeat.o(254713);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Throwable, ah>
  {
    e(q.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$awaitVideoDownloadedWithProgress$succeed$1$listener$1", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged;", "notifyChanged", "", "notifyInfo", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged$NotifyInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements aa.a
  {
    f(p<? super Boolean> paramp, cc paramcc, q paramq) {}
    
    public final void a(aa.a.a parama)
    {
      AppMethodBeat.i(254720);
      s.u(parama, "notifyInfo");
      if (this.bPv.isCompleted())
      {
        AppMethodBeat.o(254720);
        return;
      }
      Object localObject2 = g.dd(paramcc);
      String str = parama.fileName;
      if (localObject2 == null) {}
      for (Object localObject1 = null; !s.p(str, localObject1); localObject1 = ((z)localObject2).getFileName())
      {
        AppMethodBeat.o(254720);
        return;
      }
      localObject1 = (q.b)q.j(jdField_this).get(parama.fileName);
      if ((localObject2 == null) || (localObject1 == null))
      {
        com.tencent.mm.modelvideo.v.bOh().a((aa.a)this);
        parama = (kotlin.d.d)this.bPv;
        localObject1 = (Throwable)new IllegalStateException("Couldn't find video info: info=" + localObject2 + ", item=" + localObject1);
        localObject2 = Result.Companion;
        parama.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1)));
        AppMethodBeat.o(254720);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("onNotifyChange, status:", Integer.valueOf(((z)localObject2).status)));
      if (((!paramcc.dSI()) && (paramcc.isClean())) || (((z)localObject2).status == 198))
      {
        if (q.a(jdField_this, (q.b)localObject1)) {
          Toast.makeText((Context)jdField_this.aeAg.aeAB, R.l.gXE, 0).show();
        }
        com.tencent.mm.modelvideo.v.bOh().a((aa.a)this);
        parama = (kotlin.d.d)this.bPv;
        localObject1 = (Throwable)new IllegalStateException("Video is expired or failed to download");
        localObject2 = Result.Companion;
        parama.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1)));
        AppMethodBeat.o(254720);
        return;
      }
      int i = com.tencent.mm.modelvideo.ab.g((z)localObject2);
      parama = jdField_this.aCt(((q.b)localObject1).position);
      if ((jdField_this.aeAg.aeAB.getCurrentItem() == ((q.b)localObject1).position) && (parama != null)) {
        q.a(jdField_this, parama, i);
      }
      if (((z)localObject2).bOx())
      {
        q.a(jdField_this, (q.b)localObject1);
        com.tencent.mm.modelvideo.v.bOh().a((aa.a)this);
        parama = (kotlin.d.d)this.bPv;
        localObject1 = Boolean.TRUE;
        localObject2 = Result.Companion;
        parama.resumeWith(Result.constructor-impl(localObject1));
      }
      AppMethodBeat.o(254720);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$checkOriginVideoProcess$1$2", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged;", "notifyChanged", "", "notifyInfo", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged$NotifyInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements aa.a
  {
    g(z paramz, q paramq, cc paramcc, int paramInt) {}
    
    private static final void b(q paramq, cc paramcc, int paramInt)
    {
      AppMethodBeat.i(254716);
      s.u(paramq, "this$0");
      s.u(paramcc, "$msg");
      com.tencent.mm.ui.chatting.i.e locale = paramq.aeAu;
      if (locale != null) {
        locale.report();
      }
      if ((paramq.aeAg == null) || (paramq.aeAg.aeAB == null))
      {
        AppMethodBeat.o(254716);
        return;
      }
      paramq.aeAg.aeAB.jvy();
      paramq.aeAg.aeAB.jvG();
      paramq.k(paramcc, paramInt);
      AppMethodBeat.o(254716);
    }
    
    public final void a(aa.a.a parama)
    {
      AppMethodBeat.i(254726);
      q localq;
      cc localcc;
      int i;
      if (parama != null)
      {
        Object localObject = this.aeEW;
        localq = jdField_this;
        localcc = paramcc;
        i = paramInt;
        if (!((z)localObject).getFileName().equals(parama.fileName))
        {
          AppMethodBeat.o(254726);
          return;
        }
        localObject = ae.pbN;
        parama = com.tencent.mm.modelvideo.ab.Qo(parama.fileName);
        if (parama != null) {
          break label123;
        }
      }
      label123:
      for (parama = null;; parama = parama.bOu())
      {
        parama = ae.a.Qv(parama);
        if ((parama != null) && (!parama.pbO))
        {
          com.tencent.mm.modelvideo.v.bOh().a((aa.a)this);
          com.tencent.threadpool.h.ahAA.bk(new q.g..ExternalSyntheticLambda0(localq, localcc, i));
        }
        AppMethodBeat.o(254726);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    h(cc paramcc, r paramr, q paramq, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254799);
      paramObject = (kotlin.d.d)new h(this.ERZ, paramr, jdField_this, paramd);
      AppMethodBeat.o(254799);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254795);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254795);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (g.de(this.ERZ) == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", "null info");
          paramObject = ah.aiuX;
          AppMethodBeat.o(254795);
          return paramObject;
        }
        if (this.ERZ.dSI())
        {
          paramObject = g.dc(this.ERZ);
          if (paramObject == null)
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(254795);
            return paramObject;
          }
          localObject1 = com.tencent.mm.pluginsdk.model.y.bpF(paramObject.nUM);
          localObject2 = com.tencent.mm.modelimage.r.bKe();
          localObject3 = paramObject.nUM;
          localObject4 = paramr.jwq().aeFp;
          com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
          locala.fullPath = ((String)localObject1);
          locala.oKp = true;
          ((com.tencent.mm.modelimage.loader.a)localObject2).a((String)localObject3, (ImageView)localObject4, locala.bKx());
          localObject1 = t.aeGb;
          paramObject = paramObject.Hl(this.ERZ.field_imgPath);
          s.s(paramObject, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
          paramObject = t.bBp(paramObject);
          if (paramObject.block == 1) {
            jdField_this.a(paramr, paramObject.aawp);
          }
          for (;;)
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(254795);
            return paramObject;
            q.b(paramr);
          }
        }
        localObject1 = paramr.jwq().aeFp;
        final int i = ((ImageView)localObject1).getWidth();
        final int j = ((ImageView)localObject1).getHeight();
        paramObject = (f)bg.kCi();
        Object localObject3 = (m)new a(paramr, this.ERZ, i, j, null);
        Object localObject4 = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.label = 1;
        paramObject = kotlinx.coroutines.l.a(paramObject, (m)localObject3, (kotlin.d.d)localObject4);
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(254795);
          return localObject2;
        }
        break;
      case 1: 
        localObject1 = (ImageView)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        ((ImageView)localObject1).setImageBitmap((Bitmap)paramObject);
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super Bitmap>, Object>
    {
      int label;
      
      a(r paramr, cc paramcc, int paramInt1, int paramInt2, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(254417);
        paramObject = (kotlin.d.d)new a(this.aeEX, this.ERZ, i, j, paramd);
        AppMethodBeat.o(254417);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(254415);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(254415);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost. position=", Integer.valueOf(this.aeEX.mPosition)));
        try
        {
          com.tencent.mm.modelvideo.v.bOh();
          paramObject = BitmapUtil.createThumbBitmap(com.tencent.mm.modelvideo.aa.PY(this.ERZ.field_imgPath), i, j, false, false);
          AppMethodBeat.o(254415);
          return paramObject;
        }
        catch (OutOfMemoryError paramObject)
        {
          for (;;)
          {
            paramObject = null;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(ThumbPlayerVideoView paramThumbPlayerVideoView, RedesignVideoPlayerSeekBar paramRedesignVideoPlayerSeekBar, q paramq, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254790);
      paramd = new i(this.aeEY, this.aeEZ, jdField_this, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(254790);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254785);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254785);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        if (ar.a(paramObject))
        {
          int i = this.aeEY.getCurrentPosition() / 1000;
          if (this.aeEZ.getmPosition() != i)
          {
            Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("progress: ", Integer.valueOf(i)));
            this.aeEZ.seek(i);
          }
          long l = Math.min(1000L - this.aeEY.getCurrentPosition() % 1000L, 500L);
          if (this.aeEY.ykm)
          {
            i = (int)(q.a(jdField_this, this.aeEY) / 1000L);
            if (i > 0) {
              this.aeEZ.axi(i);
            }
          }
          localObject = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          if (bb.e(l, (kotlin.d.d)localObject) != locala) {
            break label245;
          }
          AppMethodBeat.o(254785);
          return locala;
        }
        break;
      case 1: 
        localObject = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      label245:
      for (;;)
      {
        break;
        paramObject = ah.aiuX;
        AppMethodBeat.o(254785);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    j(q paramq, r paramr, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254768);
      paramObject = (kotlin.d.d)new j(this.aeEU, this.aeEX, paramd);
      AppMethodBeat.o(254768);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254761);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254761);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(100L, paramObject) == locala)
        {
          AppMethodBeat.o(254761);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      q.a(this.aeEU, this.aeEX);
      paramObject = ah.aiuX;
      AppMethodBeat.o(254761);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    int aai;
    int asI;
    int label;
    int nuz;
    
    k(q paramq, cc paramcc, r paramr, ThumbPlayerVideoView paramThumbPlayerVideoView, int paramInt, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    private static final void a(q paramq, r paramr, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254778);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(254778);
        return;
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "on buffering start");
        q.d(paramq, paramr);
        AppMethodBeat.o(254778);
        return;
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "on buffering end");
        q.c(paramq, paramr);
      }
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254803);
      paramd = new k(this.aeEU, paramcc, localr, this.aeEY, paramInt, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(254803);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(254800);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254800);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = (f)bg.kCi();
        localObject2 = (m)new b(paramcc, null);
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = kotlinx.coroutines.l.a((f)localObject1, (m)localObject2, (kotlin.d.d)localObject3);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(254800);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (z)localObject1;
        if (localObject1 == null)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(254800);
          return paramObject;
        }
        q.a(this.aeEU, ((z)localObject1).getFileName());
        if ((!paramcc.dSI()) && (paramcc.isClean()))
        {
          Toast.makeText((Context)this.aeEU.aeAg.aeAB, R.l.gXE, 0).show();
          paramObject = ah.aiuX;
          AppMethodBeat.o(254800);
          return paramObject;
        }
        localObject2 = this.aeEU;
        localObject3 = ((z)localObject1).getFileName();
        s.s(localObject3, "info.fileName");
        q.b((q)localObject2, (String)localObject3);
        localObject3 = j.a(paramObject, (f)bg.kCg(), (m)new a((z)localObject1, null), 2);
        Object localObject4 = j.a(paramObject, (f)bg.kCi(), (m)new c((z)localObject1, null), 2);
        localObject2 = localr;
        int j = ((z)localObject1).omT;
        int i = ((z)localObject1).osy;
        Object localObject5 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.VC = localObject3;
        this.VD = localObject2;
        this.aai = j;
        this.asI = i;
        this.label = 2;
        localObject4 = ((ay)localObject4).e((kotlin.d.d)localObject5);
        if (localObject4 == locala)
        {
          AppMethodBeat.o(254800);
          return locala;
          i = this.asI;
          j = this.aai;
          localObject2 = (r)this.VD;
          localObject5 = (ay)this.VC;
          localObject4 = (z)this.Uf;
          localObject1 = (aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject3 = paramObject;
          paramObject = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject5;
        }
        for (;;)
        {
          int m = ((Number)localObject4).intValue();
          localObject4 = paramObject.bOs();
          localObject5 = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.Uf = paramObject;
          this.VC = localObject2;
          this.VD = localObject4;
          this.aai = j;
          this.asI = i;
          this.nuz = m;
          this.label = 3;
          localObject5 = ((ay)localObject3).e((kotlin.d.d)localObject5);
          int k;
          if (localObject5 == locala)
          {
            AppMethodBeat.o(254800);
            return locala;
            k = this.nuz;
            j = this.asI;
            i = this.aai;
            localObject3 = (String)this.VD;
            localObject5 = (r)this.VC;
            localObject4 = (z)this.Uf;
            localObject1 = (aq)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject2 = paramObject;
            paramObject = localObject4;
            localObject4 = localObject2;
            localObject2 = localObject5;
          }
          for (;;)
          {
            ((r)localObject2).a(i, j, k, (String)localObject3, (String)localObject4, paramObject.createTime);
            if (this.aeEU.aeAg.aeAB.aeDV) {
              this.aeEU.aeAg.aeAB.jvR();
            }
            q.g(this.aeEU);
            if (this.aeEY.cxs())
            {
              this.aeEY.start();
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "resume playing");
              q.c(this.aeEU, localr);
              localObject1 = q.d(this.aeEU);
              if ((localObject1 != null) && (this.aeEY.ykm) && (!((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject1).aVB())) {
                ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject1).start();
              }
              this.aeEU.aeAu = new com.tencent.mm.ui.chatting.i.e(paramcc, q.e(this.aeEU), false, 2);
              localObject2 = this.aeEU.aeAu;
              localObject1 = paramObject;
              if (localObject2 != null)
              {
                ((com.tencent.mm.ui.chatting.i.e)localObject2).ork = System.currentTimeMillis();
                localObject1 = paramObject;
              }
            }
            for (;;)
            {
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "play video: video status=" + ((z)localObject1).status + ", position=" + paramInt);
              paramObject = ah.aiuX;
              AppMethodBeat.o(254800);
              return paramObject;
              i = this.aeEU.aeAg.aeAB.An(paramcc.field_msgId);
              localObject2 = this.aeEY;
              if (i == 3) {}
              for (boolean bool = true;; bool = false)
              {
                ((ThumbPlayerVideoView)localObject2).setMute(bool);
                this.aeEY.setOnInfoCallback(new q.k..ExternalSyntheticLambda0(this.aeEU, localr));
                localObject4 = new pm();
                ((pm)localObject4).imP = paramcc.field_msgSvrId;
                localObject3 = new com.tencent.mm.plugin.thumbplayer.f.b(q.h(this.aeEU));
                localObject2 = new e(paramcc, paramObject, (com.tencent.mm.plugin.thumbplayer.f.b)localObject3, (kotlin.g.a.b)new d((pm)localObject4, paramObject));
                localObject4 = new com.tencent.mm.plugin.thumbplayer.f.d((pm)localObject4, q.h(this.aeEU), 1);
                localObject2 = new com.tencent.mm.plugin.thumbplayer.downloader.d((com.tencent.mm.plugin.thumbplayer.downloader.h)localObject2);
                ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).a((com.tencent.mm.plugin.thumbplayer.f.a)localObject4);
                ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).a((com.tencent.mm.plugin.thumbplayer.f.a)new b(paramcc, paramObject.getFileName(), false));
                ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).a((com.tencent.mm.plugin.thumbplayer.f.a)localObject3);
                q.a(this.aeEU, (com.tencent.mm.plugin.thumbplayer.downloader.i)localObject2);
                this.aeEY.THo.clear();
                this.aeEY.a((com.tencent.mm.plugin.thumbplayer.f.c)localObject4);
                this.aeEY.a((com.tencent.mm.plugin.thumbplayer.f.c)localObject3);
                if ((!((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).aVB()) && (!q.d(paramcc, paramObject))) {
                  break label1296;
                }
                localObject1 = ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).hKD();
                if ((localObject1 != null) && (com.tencent.mm.vfs.y.ZC((String)localObject1))) {
                  break;
                }
                Toast.makeText((Context)this.aeEU.aeAg.aeAB, R.l.gXE, 0).show();
                paramObject = ah.aiuX;
                AppMethodBeat.o(254800);
                return paramObject;
              }
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "start play local video file");
              this.aeEY.setVideoPath((String)localObject1);
              this.aeEU.aeAu = new com.tencent.mm.ui.chatting.i.e(paramcc, q.e(this.aeEU), false, 2);
              localObject2 = this.aeEU.aeAu;
              localObject1 = paramObject;
              if (localObject2 != null)
              {
                ((com.tencent.mm.ui.chatting.i.e)localObject2).ork = System.currentTimeMillis();
                localObject1 = paramObject;
                continue;
                label1296:
                if (((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).start())
                {
                  Log.i("MicroMsg.Imagegallery.handler.video.tp", "start online play video.");
                  this.aeEY.setResourceDownloader((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject2);
                  q.d(this.aeEU, localr);
                  try
                  {
                    localObject1 = (kotlin.d.d)this;
                    this.L$0 = paramObject;
                    this.Uf = null;
                    this.VC = null;
                    this.VD = null;
                    this.label = 4;
                    localObject1 = ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).ao((kotlin.d.d)localObject1);
                    if (localObject1 == locala)
                    {
                      AppMethodBeat.o(254800);
                      return locala;
                      localObject1 = (z)this.L$0;
                      ResultKt.throwOnFailure(paramObject);
                      paramObject = localObject1;
                    }
                    Log.i("MicroMsg.Imagegallery.handler.video.tp", s.X("moov is Ready: waitingForDownload=", Boolean.valueOf(q.i(this.aeEU))));
                    if (!q.i(this.aeEU)) {
                      this.aeEY.prepare();
                    }
                    localObject2 = this.aeEU.aeAu;
                    localObject1 = paramObject;
                    if (localObject2 == null) {
                      continue;
                    }
                    ((com.tencent.mm.ui.chatting.i.e)localObject2).ork = System.currentTimeMillis();
                    localObject1 = paramObject;
                  }
                  catch (i.a paramObject)
                  {
                    Log.w("MicroMsg.Imagegallery.handler.video.tp", "Unable to wait moov ready");
                    q.a(this.aeEU, localr, paramObject);
                    paramObject = ah.aiuX;
                    AppMethodBeat.o(254800);
                    return paramObject;
                  }
                }
                else
                {
                  Log.i("MicroMsg.Imagegallery.handler.video.tp", "start offline play video.");
                  q.a(this.aeEU, localr, com.tencent.mm.modelvideo.ab.g(paramObject));
                  for (;;)
                  {
                    try
                    {
                      q.a(this.aeEU, true);
                      localObject3 = this.aeEU;
                      localObject4 = paramcc;
                      localObject5 = (kotlin.d.d)this;
                      this.L$0 = localObject1;
                      this.Uf = paramObject;
                      this.VC = localObject2;
                      this.VD = null;
                      this.label = 5;
                      localObject3 = q.a((q)localObject3, (cc)localObject4, (kotlin.d.d)localObject5);
                      if (localObject3 == locala)
                      {
                        AppMethodBeat.o(254800);
                        return locala;
                        localObject2 = (com.tencent.mm.plugin.thumbplayer.downloader.d)this.VC;
                        localObject3 = (z)this.Uf;
                        localObject1 = (aq)this.L$0;
                        ResultKt.throwOnFailure(paramObject);
                        paramObject = localObject3;
                      }
                      q.a(this.aeEU, false);
                      if ((!ar.a((aq)localObject1)) || (this.aeEU.aeAg == null))
                      {
                        localObject1 = new StringBuilder("Seems the job is canceled(it shouldn't happen at all), isActive=").append(ar.a((aq)localObject1)).append(", adapter is null=");
                        if (this.aeEU.aeAg == null)
                        {
                          bool = true;
                          Log.w("MicroMsg.Imagegallery.handler.video.tp", bool);
                        }
                      }
                      else
                      {
                        localObject1 = ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).hKD();
                        if ((localObject1 != null) && (com.tencent.mm.vfs.y.ZC((String)localObject1))) {
                          break;
                        }
                        Toast.makeText((Context)this.aeEU.aeAg.aeAB, R.l.gXE, 0).show();
                        paramObject = ah.aiuX;
                        AppMethodBeat.o(254800);
                        return paramObject;
                      }
                    }
                    catch (IllegalStateException paramObject)
                    {
                      Log.w("MicroMsg.Imagegallery.handler.video.tp", s.X("awaiting video to be downloaded doesn't success: ", paramObject.getMessage()));
                      q.a(this.aeEU, localr);
                      paramObject = ah.aiuX;
                      return paramObject;
                    }
                    finally
                    {
                      q.a(this.aeEU, false);
                      AppMethodBeat.o(254800);
                    }
                    bool = false;
                  }
                  this.aeEY.setVideoPath((String)localObject1);
                  this.aeEU.aeAu = new com.tencent.mm.ui.chatting.i.e(paramcc, q.e(this.aeEU), false, 2);
                  localObject2 = this.aeEU.aeAu;
                  localObject1 = paramObject;
                  if (localObject2 != null)
                  {
                    ((com.tencent.mm.ui.chatting.i.e)localObject2).ork = System.currentTimeMillis();
                    localObject1 = paramObject;
                  }
                }
              }
            }
            k = i;
            i = j;
            j = k;
            k = m;
            localObject3 = localObject4;
            localObject4 = localObject5;
          }
          localObject5 = paramObject;
          paramObject = localObject1;
          localObject1 = localObject5;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super String>, Object>
    {
      int label;
      
      a(z paramz, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(254644);
        paramObject = (kotlin.d.d)new a(this.aeEW, paramd);
        AppMethodBeat.o(254644);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(254637);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(254637);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = z.PM(this.aeEW.bOu());
        AppMethodBeat.o(254637);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelvideo/VideoInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super z>, Object>
    {
      int label;
      
      b(cc paramcc, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(254639);
        paramObject = (kotlin.d.d)new b(this.ERZ, paramd);
        AppMethodBeat.o(254639);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(254633);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(254633);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = g.dd(this.ERZ);
        AppMethodBeat.o(254633);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super Integer>, Object>
    {
      int label;
      
      c(z paramz, kotlin.d.d<? super c> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(254652);
        paramObject = (kotlin.d.d)new c(this.aeEW, paramd);
        AppMethodBeat.o(254652);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(254646);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(254646);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        if (au.bwE(this.aeEW.bOs())) {}
        for (int i = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.aeEW.bOs());; i = 0)
        {
          AppMethodBeat.o(254646);
          return Integer.valueOf(i);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.b<com.tencent.mm.g.h, ah>
    {
      d(pm parampm, z paramz)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    l(q paramq, int paramInt, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254781);
      paramObject = (kotlin.d.d)new l(this.aeEU, i, paramd);
      AppMethodBeat.o(254781);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254776);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254776);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      com.tencent.mm.modelvideo.ab.bg(q.e(this.aeEU), i);
      paramObject = ah.aiuX;
      AppMethodBeat.o(254776);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$seekCallback$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "onSeeking", "currentTime", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    m(h paramh, q paramq) {}
    
    private static final void a(q paramq, r paramr, boolean paramBoolean)
    {
      AppMethodBeat.i(254758);
      s.u(paramq, "this$0");
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "seek completed");
      s.s(paramr, "holder");
      q.c(paramq, paramr);
      AppMethodBeat.o(254758);
    }
    
    public final void blc()
    {
      AppMethodBeat.i(254772);
      r localr = this.aeFb.jve();
      if (localr != null)
      {
        localr.jwq().aeFr.pause();
        q.e(jdField_this, localr);
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "onSeekPre");
      AppMethodBeat.o(254772);
    }
    
    public final void tS(int paramInt)
    {
      AppMethodBeat.i(254783);
      Object localObject1 = this.aeFb.jve();
      Object localObject2 = ((r)localObject1).aeFr;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
        AppMethodBeat.o(254783);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ThumbPlayerVideoView)localObject2;
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "onSeekTo(" + paramInt + ')');
      ((r)localObject1).jwq().aeFq.setVisibility(8);
      if (((ThumbPlayerVideoView)localObject2).cxs())
      {
        ((ThumbPlayerVideoView)localObject2).setOnSeekCompleteCallback(new q.m..ExternalSyntheticLambda0(jdField_this, (r)localObject1));
        ((ThumbPlayerVideoView)localObject2).c(paramInt * 1000.0D, true);
      }
      for (;;)
      {
        this.aeFb.aeAB.jvR();
        localObject1 = this.aeFb.jvd();
        if ((localObject1 != null) && (((cc)localObject1).dSI())) {
          this.aeFb.aeAB.aeCD.n((cc)localObject1, 13);
        }
        AppMethodBeat.o(254783);
        return;
        localObject1 = this.aeFb.jvd();
        if ((localObject1 != null) && (((cc)localObject1).dSH())) {
          com.tencent.mm.modelvideo.ab.k(((fi)localObject1).field_imgPath, paramInt * 1000, ((ThumbPlayerVideoView)localObject2).ykm);
        }
        this.aeFb.aCE(this.aeFb.aeAB.getCurrentItem());
      }
    }
    
    public final void tT(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    o(ThumbPlayerVideoView paramThumbPlayerVideoView, q paramq, r paramr, cc paramcc, int paramInt, z paramz, kotlin.d.d<? super o> paramd)
    {
      super(paramd);
    }
    
    private static final void a(q paramq, int paramInt)
    {
      AppMethodBeat.i(254751);
      com.tencent.mm.modelvideo.ab.bh(q.e(paramq), paramInt);
      AppMethodBeat.o(254751);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254777);
      paramObject = (kotlin.d.d)new o(this.aeEY, jdField_this, localr, paramcc, paramInt, localz, paramd);
      AppMethodBeat.o(254777);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254771);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254771);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (this.aeEY.ykm)
        {
          paramObject = q.d(jdField_this);
          if (paramObject != null) {
            paramObject.hKC();
          }
        }
        q.a(jdField_this, localr, com.tencent.mm.modelvideo.ab.g(g.dd(paramcc)));
        if (paramInt == 2)
        {
          i = 8;
          com.tencent.threadpool.h.ahAA.bm(new q.o..ExternalSyntheticLambda0(jdField_this, i));
          if (paramInt != 2) {
            break label205;
          }
          q.jwj();
        }
        break;
      }
      for (;;)
      {
        try
        {
          q.a(jdField_this, true);
          paramObject = jdField_this;
          cc localcc = paramcc;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          paramObject = q.a(paramObject, localcc, locald);
          if (paramObject == locala)
          {
            AppMethodBeat.o(254771);
            return locala;
            i = 5;
            break;
            label205:
            if (paramInt != 1) {
              continue;
            }
            q.jwk();
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          q.a(jdField_this, false);
          q.a(jdField_this, localr);
          switch (paramInt)
          {
          default: 
            paramObject = ah.aiuX;
            AppMethodBeat.o(254771);
            return paramObject;
          }
        }
        catch (IllegalStateException paramObject)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", s.X("Failed to wait video to be downloaded: ", paramObject.getMessage()));
          paramObject = ah.aiuX;
          return paramObject;
        }
        finally
        {
          q.a(jdField_this, false);
          q.a(jdField_this, localr);
          AppMethodBeat.o(254771);
        }
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "do restransmit video");
        q.jwl();
        jdField_this.aeAg.dm(paramcc);
        jdField_this.aeAg.aeAB.Ao(-1L);
        if (this.aeEY.ykm)
        {
          i = this.aeEY.getCurrentPosition();
          com.tencent.mm.modelvideo.ab.k(localz.getFileName(), i, true);
          continue;
          q.jwm();
          h.b((Context)jdField_this.aeAg.aeAB, paramcc);
          jdField_this.aeAg.aeAB.Ao(-1L);
          if (this.aeEY.ykm)
          {
            i = this.aeEY.getCurrentPosition();
            com.tencent.mm.modelvideo.ab.k(localz.getFileName(), i, true);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    p(cc paramcc, q paramq, int paramInt, ThumbPlayerVideoView paramThumbPlayerVideoView, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(254766);
      paramObject = (kotlin.d.d)new p(this.ERZ, jdField_this, paramInt, this.aeEY, paramd);
      AppMethodBeat.o(254766);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(254759);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254759);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new ah.f();
        localObject1 = new ah.a();
        localObject3 = (f)bg.kCi();
        m localm = (m)new kotlin.d.b.a.k(this.ERZ, jdField_this)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(254412);
            paramAnonymousObject = (kotlin.d.d)new 1(this.ERZ, this.aeEU, paramObject, this.aeFf, paramAnonymousd);
            AppMethodBeat.o(254412);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(254411);
            Object localObject1 = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(254411);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = g.dd(this.ERZ);
            int i;
            if (paramAnonymousObject != null)
            {
              q localq = this.aeEU;
              Object localObject2 = paramObject;
              localObject1 = this.aeFf;
              if (Util.isNullOrNil(paramAnonymousObject.oYk))
              {
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(254411);
                return paramAnonymousObject;
              }
              q.a(localq, paramAnonymousObject.getFileName());
              ((ah.f)localObject2).aqH = com.tencent.mm.modelvideo.ab.Qo(paramAnonymousObject.oYk);
              if ((z)((ah.f)localObject2).aqH == null)
              {
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(254411);
                return paramAnonymousObject;
              }
              com.tencent.mm.modelvideo.v.bOh();
              paramAnonymousObject = (z)((ah.f)localObject2).aqH;
              if (paramAnonymousObject != null) {
                break label229;
              }
              paramAnonymousObject = null;
              paramAnonymousObject = com.tencent.mm.modelvideo.aa.PX(paramAnonymousObject);
              localObject2 = (z)((ah.f)localObject2).aqH;
              if ((localObject2 == null) || (((z)localObject2).status != 199)) {
                break label237;
              }
              i = 1;
              label199:
              if ((i == 0) || (!com.tencent.mm.vfs.y.ZC(paramAnonymousObject))) {
                break label242;
              }
            }
            label229:
            label237:
            label242:
            for (boolean bool = true;; bool = false)
            {
              ((ah.a)localObject1).aiwY = bool;
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(254411);
              return paramAnonymousObject;
              paramAnonymousObject = paramAnonymousObject.getFileName();
              break;
              i = 0;
              break label199;
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.label = 1;
        if (kotlinx.coroutines.l.a((f)localObject3, localm, locald) == localObject2)
        {
          AppMethodBeat.o(254759);
          return localObject2;
        }
        break;
      case 1: 
        localObject1 = (ah.a)this.Uf;
        localObject2 = (ah.f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      if ((!this.ERZ.dSI()) && (this.ERZ.isClean()))
      {
        Toast.makeText((Context)jdField_this.aeAg.aeAB, R.l.gXE, 0).show();
        paramObject = ah.aiuX;
        AppMethodBeat.o(254759);
        return paramObject;
      }
      if ((paramObject.aqH == null) || (!((ah.a)localObject1).aiwY))
      {
        q.a(jdField_this, this.ERZ, paramInt);
        paramObject = ah.aiuX;
        AppMethodBeat.o(254759);
        return paramObject;
      }
      localObject2 = (z)paramObject.aqH;
      if (localObject2 != null)
      {
        paramObject = jdField_this;
        localObject3 = this.ERZ;
        int i = paramInt;
        localObject1 = this.aeEY;
        if (((z)localObject2).status == 143)
        {
          q.a(paramObject, (cc)localObject3, i);
          paramObject = ah.aiuX;
          AppMethodBeat.o(254759);
          return paramObject;
        }
        paramObject.aeAu = new com.tencent.mm.ui.chatting.i.e((cc)localObject3, ((fi)localObject3).field_imgPath, true, 3);
        localObject3 = ((fi)localObject3).field_imgPath;
        s.s(localObject3, "msg.imgPath");
        q.b(paramObject, (String)localObject3);
        com.tencent.mm.modelvideo.v.bOh();
        localObject2 = com.tencent.mm.modelvideo.aa.PX(((z)localObject2).getFileName());
        ((ThumbPlayerVideoView)localObject1).stop();
        ((ThumbPlayerVideoView)localObject1).setVideoPath((String)localObject2);
        paramObject.aeAg.aeAB.jvV();
        localObject1 = paramObject.aeAu;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.chatting.i.e)localObject1).ork = System.currentTimeMillis();
        }
        q.f(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(254759);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.q
 * JD-Core Version:    0.7.0.1
 */