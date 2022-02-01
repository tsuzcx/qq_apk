package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.b.a.mj;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.thumbplayer.c.i.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.b;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.at;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;
import kotlinx.coroutines.ci;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler;", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAbstractVideoHandler;", "adapter", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter;", "(Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter;)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "currPlayTime", "", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "enterTime", "", "filename", "", "hadPlayError", "", "handledItems", "Ljava/util/HashMap;", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$VideoItem;", "Lkotlin/collections/HashMap;", "isToolbarShowing", "itemScope", "Lkotlinx/coroutines/CoroutineScope;", "lastCheckTime", "lastSurfaceUpdateTime", "progressMonitorJob", "Lkotlinx/coroutines/Job;", "seekCallback", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "surfaceCheckerJob", "surfaceErrorTime", "surfaceRepairTime", "waitingForDownload", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "attachDebugInfo", "", "videoView", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;", "textView", "Landroid/widget/TextView;", "awaitVideoDownloadedWithProgress", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "(Lcom/tencent/mm/storage/MsgInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cachedVideoTime", "canPlayAsSender", "info", "Lcom/tencent/mm/modelvideo/VideoInfo;", "checkScope", "checkSurfaceIsUpdate", "detach", "endNotify", "item", "filling", "holder", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder;", "position", "getHolder", "pos", "keepScreenOn", "loadThumb", "monitorProgress", "onDownloadError", "error", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$DownloadException;", "onPause", "onResume", "onVideoBuffering", "onVideoCompletion", "onVideoDownloading", "progress", "onVideoError", "what", "extra", "onVideoPlaying", "onVideoPrepared", "onVideoStopped", "updateIndicator", "openByExternalPlayer", "videoPath", "pause", "play", "releaseScreenOn", "removePlayingCache", "repairVideoDuration", "duration", "resetSeekCallback", "rptRepairEffect", "errorTime", "rptRestransmit", "rptSaveVideo", "rptSurfaceNotUpdate", "rptWaitToRestransmit", "rptWaitToSaveVideo", "showErrorView", "errMsg", "showToolbar", "fileName", "startSurfaceChecker", "stop", "stopAll", "toggleVideo", "toggleVideoMenu", "Companion", "VideoItem", "app_release"})
public final class o
  extends e
{
  private static final boolean Grv;
  public static final o.a WVg;
  private com.tencent.mm.plugin.thumbplayer.c.i KHu;
  private by LrW;
  private boolean WUK;
  private int WUM;
  private int WUN;
  private ak WVb;
  private by WVc;
  private final HashMap<String, b> WVd;
  private boolean WVe;
  private boolean WVf;
  private long enterTime;
  private String filename;
  private final com.tencent.mm.model.d kKI;
  private long lastCheckTime;
  private long pDZ;
  private int wTA;
  private final com.tencent.mm.plugin.sight.decode.ui.b wTG;
  private PowerManager.WakeLock wakeLock;
  
  static
  {
    AppMethodBeat.i(207896);
    WVg = new o.a((byte)0);
    Grv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbW, false);
    AppMethodBeat.o(207896);
  }
  
  public o(final f paramf)
  {
    super(paramf);
    AppMethodBeat.i(207894);
    this.WVb = al.iRe();
    this.kKI = com.tencent.mm.model.d.bcs();
    this.WVd = new HashMap();
    this.wTG = ((com.tencent.mm.plugin.sight.decode.ui.b)new q(this, paramf));
    AppMethodBeat.o(207894);
  }
  
  private final boolean a(b paramb)
  {
    AppMethodBeat.i(207893);
    if (paramb == null)
    {
      AppMethodBeat.o(207893);
      return false;
    }
    Object localObject = this.WQM.WQV;
    kotlin.g.b.p.j(localObject, "adapter.ui");
    if (((ImageGalleryUI)localObject).getCurrentItem() == paramb.position)
    {
      paramb = avN(paramb.position);
      if (paramb != null)
      {
        localObject = paramb.hSL().WVV;
        kotlin.g.b.p.j(localObject, "holder.videoView.mImgDownloadingCirclePB");
        ((ProgressBar)localObject).setVisibility(8);
        localObject = paramb.hSL().WVM;
        kotlin.g.b.p.j(localObject, "holder.videoView.mVideoDownloadingPB");
        ((MMPinProgressBtn)localObject).setVisibility(8);
        paramb = paramb.hSL().WVK;
        kotlin.g.b.p.j(paramb, "holder.videoView.mVideoWaitPlayBtn");
        paramb.setVisibility(8);
      }
      this.WVf = true;
      this.WQM.WQV.hSg();
      AppMethodBeat.o(207893);
      return true;
    }
    this.WQM.avX(paramb.position);
    AppMethodBeat.o(207893);
    return false;
  }
  
  private final void b(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(207888);
    if (this.WQM == null)
    {
      AppMethodBeat.o(207888);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoStopped(" + paramp.mPosition + ')');
    this.WQM.WQV.hSt();
    Object localObject;
    if (paramBoolean)
    {
      this.WQM.WQV.setVideoStateIv(true);
      localObject = paramp.hSL().WVM;
      kotlin.g.b.p.j(localObject, "holder.videoView.mVideoDownloadingPB");
      ((MMPinProgressBtn)localObject).setVisibility(8);
      localObject = paramp.hSL().WVV;
      kotlin.g.b.p.j(localObject, "holder.videoView.mImgDownloadingCirclePB");
      ((ProgressBar)localObject).setVisibility(8);
      p.aR((View)paramp.hSL().WVK, 0);
    }
    this.kKI.avz();
    if (this.WQM != null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "release screen on");
      paramp = this.wakeLock;
      if (paramp != null) {
        if (!paramp.isHeld()) {
          break label357;
        }
      }
    }
    for (;;)
    {
      if (paramp != null)
      {
        com.tencent.mm.hellhoundlib.a.a.b(paramp, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "releaseScreenOn", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        paramp.release();
        com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "releaseScreenOn", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      paramp = this.WQM.WQV;
      kotlin.g.b.p.j(paramp, "adapter.ui");
      paramp = paramp.getContext();
      kotlin.g.b.p.j(paramp, "adapter.ui.context");
      paramp.getWindow().clearFlags(128);
      paramp = this.LrW;
      if (paramp != null) {
        paramp.a(null);
      }
      this.LrW = null;
      paramp = this.WVc;
      if (paramp != null) {
        paramp.a(null);
      }
      this.WVc = null;
      if ((this.WQM != null) && (this.WQM.WQV != null))
      {
        paramp = this.WQM.WQV.WTa;
        localObject = this.WQM;
        kotlin.g.b.p.j(localObject, "adapter");
        paramp.cW(((f)localObject).hRF());
      }
      AppMethodBeat.o(207888);
      return;
      label357:
      paramp = null;
    }
  }
  
  private final void hSA()
  {
    AppMethodBeat.i(207874);
    try
    {
      ImageGalleryUI localImageGalleryUI = this.WQM.WQV;
      kotlin.g.b.p.j(localImageGalleryUI, "adapter.ui");
      localImageGalleryUI.hRQ().Mfz.setIplaySeekCallback(this.wTG);
      AppMethodBeat.o(207874);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(207874);
    }
  }
  
  private final void hSD()
  {
    AppMethodBeat.i(207885);
    if (!al.a(this.WVb)) {
      this.WVb = al.iRe();
    }
    AppMethodBeat.o(207885);
  }
  
  public static final boolean isEnabled()
  {
    return Grv;
  }
  
  private final void o(final ca paramca, final int paramInt)
  {
    AppMethodBeat.i(207867);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "play(" + paramInt + ')');
    final p localp = avN(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(207867);
      return;
    }
    Object localObject = localp.hSL().WVL;
    if (localObject == null)
    {
      paramca = new t("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
      AppMethodBeat.o(207867);
      throw paramca;
    }
    localObject = (ThumbPlayerVideoView)localObject;
    g.b(this.WVb, null, (kotlin.g.a.m)new o(this, paramca, localp, (ThumbPlayerVideoView)localObject, paramInt, null), 3);
    AppMethodBeat.o(207867);
  }
  
  protected final void MX(int paramInt)
  {
    AppMethodBeat.i(207865);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "pause()");
    p localp = avN(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(207865);
      return;
    }
    localp.hSL().WVL.pause();
    this.WQM.WQV.setVideoStateIv(true);
    b(localp, true);
    AppMethodBeat.o(207865);
  }
  
  protected final void a(p paramp)
  {
    AppMethodBeat.i(207887);
    kotlin.g.b.p.k(paramp, "holder");
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "stop(" + paramp.mPosition + ')');
    paramp.d(false, 0.0F);
    k localk = paramp.WVL;
    Object localObject = localk;
    if (!(localk instanceof ThumbPlayerVideoView)) {
      localObject = null;
    }
    localObject = (ThumbPlayerVideoView)localObject;
    if (localObject == null)
    {
      AppMethodBeat.o(207887);
      return;
    }
    localk = paramp.hSL().WVL;
    kotlin.g.b.p.j(localk, "holder.videoView.mVideoView");
    int i = localk.getCurrentPosition();
    if (!this.WUK) {
      com.tencent.mm.modelvideo.y.j(this.filename, Math.max(i - 1000, 0), ((ThumbPlayerVideoView)localObject).uXY);
    }
    this.WVe = false;
    ((ThumbPlayerVideoView)localObject).stop();
    localObject = this.KHu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.c.i)localObject).stop();
    }
    b(paramp, true);
    AppMethodBeat.o(207887);
  }
  
  protected final void a(p paramp, String paramString)
  {
    AppMethodBeat.i(207884);
    super.a(paramp, paramString);
    if (paramp != null) {
      p.aR((View)paramp.hSL().WVK, 8);
    }
    AppMethodBeat.o(207884);
  }
  
  public final boolean a(final p paramp, final ca paramca, int paramInt)
  {
    AppMethodBeat.i(207883);
    kotlin.g.b.p.k(paramp, "holder");
    super.a(paramp, paramca, paramInt);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "filling: ".concat(String.valueOf(paramInt)));
    if (paramca == null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "null msg: imgPath=" + null);
      AppMethodBeat.o(207883);
      return false;
    }
    if (!this.WVd.containsKey(paramca.apK())) {
      ((Map)this.WVd).put(paramca.apK(), new b(paramInt, paramca, (byte)0));
    }
    hSD();
    if (!(paramp.hSL().WVL instanceof ThumbPlayerVideoView))
    {
      paramp = (Throwable)new IllegalStateException("Must use ThumbPlayerTextureView".toString());
      AppMethodBeat.o(207883);
      throw paramp;
    }
    Object localObject = paramp.hSL().WVL;
    if (localObject == null)
    {
      paramp = new t("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
      AppMethodBeat.o(207883);
      throw paramp;
    }
    ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)localObject;
    if (localThumbPlayerVideoView.isPlaying()) {
      localThumbPlayerVideoView.stop();
    }
    if ((ar.hIH()) || (ar.hIM())) {}
    for (localObject = i.e.RcG;; localObject = i.e.RcE)
    {
      localThumbPlayerVideoView.setScaleType((i.e)localObject);
      localObject = paramp.WVN;
      kotlin.g.b.p.j(localObject, "holder.debugInfoTv");
      ((TextView)localObject).setVisibility(8);
      localObject = paramp.hSL().WVM;
      kotlin.g.b.p.j(localObject, "holder.videoView.mVideoDownloadingPB");
      ((MMPinProgressBtn)localObject).setVisibility(8);
      localObject = paramp.hSL().WVV;
      kotlin.g.b.p.j(localObject, "holder.videoView.mImgDownloadingCirclePB");
      ((ProgressBar)localObject).setVisibility(8);
      paramp.d(false, 0.0F);
      this.enterTime = Util.nowMilliSecond();
      g.b((ak)br.abxo, (kotlin.d.f)bc.iRr(), (kotlin.g.a.m)new h(this, paramca, paramp, null), 2);
      AppMethodBeat.o(207883);
      return true;
    }
  }
  
  public final p avN(int paramInt)
  {
    AppMethodBeat.i(207882);
    p localp = super.avN(paramInt);
    if (localp == null) {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "getHolder(" + paramInt + ") returns null!");
    }
    AppMethodBeat.o(207882);
    return localp;
  }
  
  protected final void avQ(int paramInt)
  {
    AppMethodBeat.i(207864);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "removePlayingCache");
    AppMethodBeat.o(207864);
  }
  
  protected final void cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207881);
    Log.w("MicroMsg.Imagegallery.handler.video.tp", "onVideoError(" + paramInt1 + ", " + paramInt2 + ')');
    this.WUK = true;
    Object localObject1 = this.WQM;
    p localp;
    if (localObject1 != null)
    {
      localp = ((f)localObject1).hRG();
      if (localp != null) {}
    }
    else
    {
      AppMethodBeat.o(207881);
      return;
    }
    Object localObject2 = localp.WVL;
    localObject1 = localObject2;
    if (!(localObject2 instanceof ThumbPlayerVideoView)) {
      localObject1 = null;
    }
    localObject1 = (ThumbPlayerVideoView)localObject1;
    if (localObject1 == null)
    {
      AppMethodBeat.o(207881);
      return;
    }
    Object localObject3;
    if (!((ThumbPlayerVideoView)localObject1).uXY)
    {
      localObject2 = ((ThumbPlayerVideoView)localObject1).getVideoPath();
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label396;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        Log.e("MicroMsg.Imagegallery.handler.video.tp", "play video error, use third player.[" + (String)localObject2 + ']');
      }
      try
      {
        localObject3 = new Intent();
        ((Intent)localObject3).setAction("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType((Context)this.WQM.WQV, (Intent)localObject3, new com.tencent.mm.vfs.q((String)localObject2), "video/*", false);
        localObject2 = this.WQM.WQV;
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "openByExternalPlayer", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((ImageGalleryUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler", "openByExternalPlayer", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        b(localp, true);
        localObject2 = this.KHu;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.c.i)localObject2).stop();
        }
        localObject2 = this.WQM.WQV;
        kotlin.g.b.p.j(localObject2, "adapter.ui");
        ((ImageGalleryUI)localObject2).hRQ().Mfz.seek(0);
        localp.d(false, 0.0F);
        com.tencent.mm.modelvideo.y.j(this.filename, 0, ((ThumbPlayerVideoView)localObject1).uXY);
        AppMethodBeat.o(207881);
        return;
        label396:
        paramInt1 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Imagegallery.handler.video.tp", "startActivity fail, activity not found");
          com.tencent.mm.ui.base.h.p((Context)this.WQM.WQV, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(207886);
    Log.w("MicroMsg.Imagegallery.handler.video.tp", "detach");
    stopAll();
    super.detach();
    al.a(this.WVb, null);
    AppMethodBeat.o(207886);
  }
  
  protected final void hRB()
  {
    AppMethodBeat.i(207871);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoPrepared");
    this.WUK = false;
    Object localObject1 = this.WQM;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((f)localObject1).hRG();
      if (localObject2 == null) {
        break label107;
      }
    }
    label107:
    for (localObject1 = ((p)localObject2).hSL().WVL;; localObject1 = null)
    {
      localObject3 = localObject1;
      if (!(localObject1 instanceof ThumbPlayerVideoView)) {
        localObject3 = null;
      }
      localObject1 = (ThumbPlayerVideoView)localObject3;
      if ((localObject2 != null) && (localObject1 != null)) {
        break label113;
      }
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "notify video prepared, but holder or videoView is null.");
      AppMethodBeat.o(207871);
      return;
      localObject2 = null;
      break;
    }
    label113:
    final int i = Util.videoMsToSec(((ThumbPlayerVideoView)localObject1).getDuration());
    int j = com.tencent.mm.modelvideo.y.S(i, this.filename);
    Object localObject3 = this.WQM.WQV;
    kotlin.g.b.p.j(localObject3, "adapter.ui");
    localObject3 = ((ImageGalleryUI)localObject3).hRQ().Mfz;
    kotlin.g.b.p.j(localObject3, "adapter.ui.footerRootVideo.videoPlayerSeekBar");
    int k = ((RedesignVideoPlayerSeekBar)localObject3).getVideoTotalTime();
    localObject3 = new StringBuilder("onVideoPrepared(").append(hashCode()).append("): lastPlayPosition=").append(j).append(", videoDuration=").append(i).append(", hadSetTotalTime=").append(k).append(", isUiPlaying=");
    ImageGalleryUI localImageGalleryUI = this.WQM.WQV;
    kotlin.g.b.p.j(localImageGalleryUI, "adapter.ui");
    Log.i("MicroMsg.Imagegallery.handler.video.tp", localImageGalleryUI.ehu());
    if ((k <= 0) || (Math.abs(k - i) >= 2))
    {
      localObject3 = this.WQM.WQV;
      kotlin.g.b.p.j(localObject3, "adapter.ui");
      localObject3 = ((ImageGalleryUI)localObject3).hRQ().Mfz;
      kotlin.g.b.p.j(localObject3, "adapter.ui.footerRootVideo.videoPlayerSeekBar");
      ((RedesignVideoPlayerSeekBar)localObject3).setVideoTotalTime(i);
    }
    hSA();
    if ((i == 0) || (i >= 1800))
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      ((ThumbPlayerVideoView)localObject1).setOneTimeVideoTextureUpdateCallback((k.e)new n(this, (p)localObject2));
      localObject3 = this.WQM.WQV;
      kotlin.g.b.p.j(localObject3, "adapter.ui");
      if ((((ImageGalleryUI)localObject3).isPaused()) || (this.WVe)) {
        break label644;
      }
      if (1 <= j) {
        break label624;
      }
      label426:
      ((ThumbPlayerVideoView)localObject1).start();
      label432:
      ((p)localObject2).d(true, 0.0F);
      label439:
      localObject2 = ((p)localObject2).WVN;
      if (localObject2 == null) {
        break label696;
      }
      localObject3 = new aa.f();
      if (!((ThumbPlayerVideoView)localObject1).uXY) {
        break label681;
      }
      localObject1 = this.KHu;
      if (localObject1 == null) {
        break label675;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.i)localObject1).gnQ();
      label488:
      ((aa.f)localObject3).aaBC = localObject1;
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "video path=" + (String)((aa.f)localObject3).aaBC);
      localObject1 = (CharSequence)((aa.f)localObject3).aaBC;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label691;
      }
    }
    label644:
    label675:
    label681:
    label691:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        g.b(this.WVb, null, (kotlin.g.a.m)new o.c((aa.f)localObject3, (TextView)localObject2, null), 3);
      }
      AppMethodBeat.o(207871);
      return;
      g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new p(this, i, null), 2);
      break;
      label624:
      if (i <= j) {
        break label426;
      }
      ((ThumbPlayerVideoView)localObject1).b(j * 1000, true);
      break label432;
      if (this.WVe)
      {
        Log.w("MicroMsg.Imagegallery.handler.video.tp", "video is prepared, but we're waiting for fully download");
        break label439;
      }
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "video is prepared, but activity is paused, ignored.");
      break label439;
      localObject1 = null;
      break label488;
      localObject1 = ((ThumbPlayerVideoView)localObject1).getVideoPath();
      break label488;
    }
    label696:
    AppMethodBeat.o(207871);
  }
  
  protected final void hRC()
  {
    AppMethodBeat.i(207877);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onVideoCompletion");
    Object localObject1 = this.WQM;
    p localp;
    if (localObject1 != null)
    {
      localp = ((f)localObject1).hRG();
      if (localp != null) {}
    }
    else
    {
      AppMethodBeat.o(207877);
      return;
    }
    Object localObject2 = localp.WVL;
    localObject1 = localObject2;
    if (!(localObject2 instanceof ThumbPlayerVideoView)) {
      localObject1 = null;
    }
    localObject1 = (ThumbPlayerVideoView)localObject1;
    if (localObject1 == null)
    {
      AppMethodBeat.o(207877);
      return;
    }
    b(localp, true);
    localObject2 = this.WQM.WQV;
    kotlin.g.b.p.j(localObject2, "adapter.ui");
    ((ImageGalleryUI)localObject2).hRQ().Mfz.seek(0);
    localp.d(false, 0.0F);
    com.tencent.mm.modelvideo.y.j(this.filename, 0, ((ThumbPlayerVideoView)localObject1).uXY);
    ((ThumbPlayerVideoView)localObject1).stop();
    localObject1 = this.KHu;
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.thumbplayer.c.i)localObject1).stop();
      AppMethodBeat.o(207877);
      return;
    }
    AppMethodBeat.o(207877);
  }
  
  protected final void k(ca paramca, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(207854);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "toggleVideo: position=".concat(String.valueOf(paramInt)));
    if (paramca == null)
    {
      AppMethodBeat.o(207854);
      return;
    }
    if ((!f.m(paramca)) && (!f.cJ(paramca)))
    {
      AppMethodBeat.o(207854);
      return;
    }
    if (this.WVe)
    {
      Log.w("MicroMsg.Imagegallery.handler.video.tp", "it's waiting for download, ignore operation");
      AppMethodBeat.o(207854);
      return;
    }
    hSD();
    Object localObject1 = e.cI(paramca);
    kotlin.g.b.p.j(localObject1, "info");
    boolean bool;
    Object localObject2;
    if ((((com.tencent.mm.modelvideo.w)localObject1).getStatus() == 199) || (((com.tencent.mm.modelvideo.w)localObject1).getStatus() == 123))
    {
      bool = true;
      if (!paramca.dlS()) {
        break label736;
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO toggle mp video, status: " + localObject1 + ".status");
      s.bqB();
      localObject2 = com.tencent.mm.modelvideo.x.XT(paramca.apK());
      if ((!bool) || (u.agG((String)localObject2))) {
        break label736;
      }
      ((com.tencent.mm.modelvideo.w)localObject1).ZK();
      s.bqB().c((com.tencent.mm.modelvideo.w)localObject1);
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO_WARN user delete local file,reset video info status");
      bool = false;
    }
    label736:
    for (;;)
    {
      if (paramca.dlS())
      {
        localObject2 = e.cG(paramca);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO_ERROR mpShareVideoInfo is null");
          AppMethodBeat.o(207854);
          return;
          bool = false;
          break;
        }
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "mpVideo videoDownload " + bool + ", playKey " + ((com.tencent.mm.aj.y)localObject2).OW(paramca.apK()));
        Object localObject3 = r.WWC;
        localObject3 = ((com.tencent.mm.aj.y)localObject2).OW(paramca.apK());
        kotlin.g.b.p.j(localObject3, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
        localObject3 = r.aqw((String)localObject3);
        Object localObject4 = r.WWC;
        localObject4 = ((com.tencent.mm.aj.y)localObject2).OW(paramca.apK());
        kotlin.g.b.p.j(localObject4, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
        localObject4 = r.bzB((String)localObject4);
        if (((daa)localObject4).block == 1)
        {
          Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO block video");
          a(avN(paramInt), ((daa)localObject4).TiP);
          AppMethodBeat.o(207854);
          return;
        }
        b(avN(paramInt));
        CharSequence localCharSequence = (CharSequence)localObject3;
        int i = j;
        if (localCharSequence != null) {
          if (localCharSequence.length() != 0) {
            break label616;
          }
        }
        label616:
        for (i = j;; i = 0)
        {
          if ((i == 0) && ((((com.tencent.mm.modelvideo.w)localObject1).blF() <= 0) || ((kotlin.g.b.p.h(localObject3, ((com.tencent.mm.modelvideo.w)localObject1).mhZ.lor) ^ true))))
          {
            Log.i("MicroMsg.Imagegallery.handler.video.tp", "MP_VIDEO  update video info. playUrl:" + (String)localObject3 + ", length:" + ((daa)localObject4).Sjq);
            ((com.tencent.mm.modelvideo.w)localObject1).mhZ.lor = ((String)localObject3);
            ((com.tencent.mm.modelvideo.w)localObject1).wf(((daa)localObject4).Sjq);
            s.bqB().c((com.tencent.mm.modelvideo.w)localObject1);
          }
          if ((!e.a((com.tencent.mm.modelvideo.w)localObject1, (com.tencent.mm.aj.y)localObject2, paramca, paramInt, bool, (e)this)) || (bool)) {
            break;
          }
          paramca = avN(paramInt);
          if (paramca != null)
          {
            paramca.hSL();
            localObject1 = paramca.hSL().WVK;
            kotlin.g.b.p.j(localObject1, "holder.videoView.mVideoWaitPlayBtn");
            ((ImageView)localObject1).setVisibility(8);
            paramca = paramca.hSL().WVV;
            kotlin.g.b.p.j(paramca, "holder.videoView.mImgDownloadingCirclePB");
            paramca.setVisibility(0);
          }
          AppMethodBeat.o(207854);
          return;
        }
      }
      b(avN(paramInt));
      localObject1 = this.WQM.WQV;
      kotlin.g.b.p.j(localObject1, "adapter.ui");
      if (((ImageGalleryUI)localObject1).ehu())
      {
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "toggle pause video.");
        MX(paramInt);
        AppMethodBeat.o(207854);
        return;
      }
      kotlin.g.b.p.j(bh.beI(), "MMCore.getAccStg()");
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramca = this.WQM.WQV;
        kotlin.g.b.p.j(paramca, "adapter.ui");
        com.tencent.mm.ui.base.w.g((Context)paramca.getContext(), null);
        AppMethodBeat.o(207854);
        return;
      }
      o(paramca, paramInt);
      AppMethodBeat.o(207854);
      return;
    }
  }
  
  protected final void l(final ca paramca, final int paramInt)
  {
    AppMethodBeat.i(207856);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "toggleVideoMenu: position=".concat(String.valueOf(paramInt)));
    if (paramca == null)
    {
      AppMethodBeat.o(207856);
      return;
    }
    hSD();
    final com.tencent.mm.modelvideo.w localw = com.tencent.mm.modelvideo.y.Yk(paramca.apK());
    if ((localw == null) || (localw.bqS()))
    {
      AppMethodBeat.o(207856);
      return;
    }
    final p localp = avN(paramInt);
    Object localObject;
    if (localp != null)
    {
      localObject = localp.WVL;
      if ((localObject instanceof ThumbPlayerVideoView)) {
        break label211;
      }
      localObject = null;
    }
    label211:
    for (;;)
    {
      localObject = (ThumbPlayerVideoView)localObject;
      if (localObject == null)
      {
        AppMethodBeat.o(207856);
        return;
        localObject = null;
        break;
      }
      ((ThumbPlayerVideoView)localObject).pause();
      b(localp, true);
      p.aR((View)localp.hSL().WVK, 8);
      this.WQM.WQV.setVideoStateIv(true);
      paramInt = this.WQM.WQV.Wc(paramca.apG());
      g.b(this.WVb, (kotlin.d.f)bc.iRr().iRV(), (kotlin.g.a.m)new s(this, (ThumbPlayerVideoView)localObject, localp, paramca, paramInt, localw, null), 2);
      AppMethodBeat.o(207856);
      return;
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(207863);
    super.onPause();
    Object localObject = this.WQM;
    if (localObject != null)
    {
      localObject = ((f)localObject).hRG();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(207863);
      return;
    }
    ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)((p)localObject).WVL;
    if (localThumbPlayerVideoView == null)
    {
      AppMethodBeat.o(207863);
      return;
    }
    if (!this.WUK) {
      com.tencent.mm.modelvideo.y.j(this.filename, localThumbPlayerVideoView.getCurrentPosition(), localThumbPlayerVideoView.uXY);
    }
    if (localThumbPlayerVideoView.isPlaying())
    {
      localThumbPlayerVideoView.pause();
      g.b(this.WVb, null, (kotlin.g.a.m)new m(this, (p)localObject, null), 3);
    }
    if (localThumbPlayerVideoView.uXY)
    {
      localObject = this.KHu;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.c.i)localObject).stop();
        AppMethodBeat.o(207863);
        return;
      }
    }
    AppMethodBeat.o(207863);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(207860);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "onResume");
    AppMethodBeat.o(207860);
  }
  
  protected final void stopAll()
  {
    AppMethodBeat.i(207858);
    Log.i("MicroMsg.Imagegallery.handler.video.tp", "stopAll");
    Object localObject = this.WQM;
    kotlin.g.b.p.j(localObject, "adapter");
    SparseArray localSparseArray = ((f)localObject).hKl();
    int j = localSparseArray.size();
    int i = 0;
    if (i < j)
    {
      localObject = (View)localSparseArray.get(localSparseArray.keyAt(i));
      label69:
      p localp;
      if (localObject != null)
      {
        localObject = ((View)localObject).getTag();
        localp = (p)localObject;
        if (localp == null) {
          break label144;
        }
      }
      label144:
      for (localObject = localp.WVI;; localObject = null)
      {
        if (localObject != null)
        {
          k localk = localp.WVL;
          localObject = localk;
          if (!(localk instanceof ThumbPlayerVideoView)) {
            localObject = null;
          }
          localObject = (ThumbPlayerVideoView)localObject;
          if ((localObject != null) && (((ThumbPlayerVideoView)localObject).isInitialized())) {
            a(localp);
          }
        }
        i += 1;
        break;
        localObject = null;
        break label69;
      }
    }
    this.KHu = null;
    this.WVe = false;
    al.a(this.WVb, null);
    AppMethodBeat.o(207858);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$VideoItem;", "", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "(ILcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;)V", "getDownloader", "()Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "getMsg", "()Lcom/tencent/mm/storage/MsgInfo;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
  public static final class b
  {
    private final com.tencent.mm.plugin.thumbplayer.c.i KHu;
    final ca fvt;
    final int position;
    
    private b(int paramInt, ca paramca)
    {
      AppMethodBeat.i(274031);
      this.position = paramInt;
      this.fvt = paramca;
      this.KHu = null;
      AppMethodBeat.o(274031);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(274035);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.position != paramObject.position) || (!kotlin.g.b.p.h(this.fvt, paramObject.fvt)) || (!kotlin.g.b.p.h(this.KHu, paramObject.KHu))) {}
        }
      }
      else
      {
        AppMethodBeat.o(274035);
        return true;
      }
      AppMethodBeat.o(274035);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(274033);
      int k = this.position;
      Object localObject = this.fvt;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.KHu;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(274033);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(274032);
      String str = "VideoItem(position=" + this.position + ", msg=" + this.fvt + ", downloader=" + this.KHu + ")";
      AppMethodBeat.o(274032);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$awaitVideoDownloadedWithProgress$succeed$1$listener$1", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged;", "notifyChanged", "", "notifyInfo", "Lcom/tencent/mm/modelvideo/VideoInfoStorage$IOnVideoInfoChanged$NotifyInfo;", "app_release"})
  public static final class d
    implements x.a
  {
    d(kotlinx.coroutines.m paramm, o paramo, ca paramca) {}
    
    public final void a(x.a.a parama)
    {
      AppMethodBeat.i(290263);
      kotlin.g.b.p.k(parama, "notifyInfo");
      if (this.WVi.isCompleted())
      {
        AppMethodBeat.o(290263);
        return;
      }
      Object localObject2 = e.cH(this.WVk);
      Object localObject3 = parama.fileName;
      if (localObject2 != null) {}
      for (Object localObject1 = ((com.tencent.mm.modelvideo.w)localObject2).getFileName(); (kotlin.g.b.p.h(localObject3, localObject1) ^ true); localObject1 = null)
      {
        AppMethodBeat.o(290263);
        return;
      }
      parama = (o.b)o.f(this.WVj).get(parama.fileName);
      if ((localObject2 == null) || (parama == null))
      {
        s.bqB().a((x.a)this);
        localObject1 = (kotlin.d.d)this.WVi;
        parama = (Throwable)new IllegalStateException("Couldn't find video info: info=" + localObject2 + ", item=" + parama);
        localObject2 = Result.Companion;
        ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure(parama)));
        AppMethodBeat.o(290263);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "onNotifyChange, status:" + ((com.tencent.mm.modelvideo.w)localObject2).getStatus());
      if (((!this.WVk.dlS()) && (this.WVk.Ic())) || (((com.tencent.mm.modelvideo.w)localObject2).getStatus() == 198))
      {
        if (o.a(this.WVj, parama)) {
          Toast.makeText((Context)this.WVj.WQM.WQV, R.l.eUF, 0).show();
        }
        s.bqB().a((x.a)this);
        parama = (kotlin.d.d)this.WVi;
        localObject1 = (Throwable)new IllegalStateException("Video is expired or failed to download");
        localObject2 = Result.Companion;
        parama.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1)));
        AppMethodBeat.o(290263);
        return;
      }
      int i = com.tencent.mm.modelvideo.y.g((com.tencent.mm.modelvideo.w)localObject2);
      localObject1 = this.WVj.avN(parama.position);
      localObject3 = this.WVj.WQM.WQV;
      kotlin.g.b.p.j(localObject3, "adapter.ui");
      if ((((ImageGalleryUI)localObject3).getCurrentItem() == parama.position) && (localObject1 != null)) {
        o.a(this.WVj, (p)localObject1, i);
      }
      if (((com.tencent.mm.modelvideo.w)localObject2).bqS())
      {
        o.a(this.WVj, parama);
        s.bqB().a((x.a)this);
        parama = (kotlin.d.d)this.WVi;
        localObject1 = Boolean.TRUE;
        localObject2 = Result.Companion;
        parama.resumeWith(Result.constructor-impl(localObject1));
      }
      AppMethodBeat.o(290263);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$awaitVideoDownloadedWithProgress$succeed$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Throwable, kotlin.x>
  {
    e(o.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"awaitVideoDownloadedWithProgress", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    
    f(o paramo, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(261613);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.WVj.a(null, this);
      AppMethodBeat.o(261613);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ca paramca) {}
    
    public final void run()
    {
      AppMethodBeat.i(291238);
      com.tencent.mm.modelvideo.y.aT(this.lEd.apK(), 10);
      AppMethodBeat.o(291238);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class h
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    Object rdb;
    
    h(o paramo, ca paramca, p paramp, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(291555);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new h(this.WVj, paramca, paramp, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(291555);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(291556);
      paramObject1 = ((h)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(291556);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(291554);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject2;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(291554);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject2 = e.cI(paramca);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", "null info");
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(291554);
          return paramObject;
        }
        if (paramca.dlS())
        {
          paramObject = e.cG(paramca);
          if (paramObject == null)
          {
            paramObject = kotlin.x.aazN;
            AppMethodBeat.o(291554);
            return paramObject;
          }
          localObject1 = com.tencent.mm.pluginsdk.model.w.bpO(paramObject.lpK);
          com.tencent.mm.ay.q.bml().a(paramObject.lpK, paramp.hSL().WVJ, new c.a().Wq((String)localObject1).bmF().bmL());
          localObject1 = r.WWC;
          paramObject = paramObject.OW(paramca.apK());
          kotlin.g.b.p.j(paramObject, "mpShareVideoInfo.getPlayKey(msg.imgPath)");
          paramObject = r.bzB(paramObject);
          if (paramObject.block == 1) {
            this.WVj.a(paramp, paramObject.TiP);
          }
        }
        break;
      }
      for (;;)
      {
        paramObject = kotlin.x.aazN;
        AppMethodBeat.o(291554);
        return paramObject;
        o.b(paramp);
        continue;
        localObject1 = paramp.hSL().WVJ;
        final aa.d locald1 = new aa.d();
        kotlin.g.b.p.j(localObject1, "imageView");
        locald1.aaBA = ((ImageView)localObject1).getWidth();
        final aa.d locald2 = new aa.d();
        locald2.aaBA = ((ImageView)localObject1).getHeight();
        kotlin.d.f localf = (kotlin.d.f)bc.iRs();
        kotlin.g.a.m localm = (kotlin.g.a.m)new a(this, locald1, locald2, null);
        this.L$0 = paramObject;
        this.oDA = localObject2;
        this.pGq = localObject1;
        this.pGr = locald1;
        this.rdb = locald2;
        this.label = 1;
        localObject2 = kotlinx.coroutines.i.a(localf, localm, this);
        paramObject = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(291554);
          return locala;
          localObject1 = (ImageView)this.pGq;
          ResultKt.throwOnFailure(paramObject);
        }
        ((ImageView)localObject1).setImageBitmap((Bitmap)paramObject);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super Bitmap>, Object>
    {
      int label;
      private ak p$;
      
      a(o.h paramh, aa.d paramd1, aa.d paramd2, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(266930);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new a(this.WVn, locald1, locald2, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(266930);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(266931);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(266931);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(266929);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(266929);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost. position=" + this.WVn.WVm.mPosition);
        try
        {
          s.bqB();
          paramObject = BitmapUtil.createThumbBitmap(com.tencent.mm.modelvideo.x.XU(this.WVn.lEd.apK()), locald1.aaBA, locald2.aaBA, false, false);
          AppMethodBeat.o(266929);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class i
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    int rdc;
    long uyU;
    
    i(o paramo, ThumbPlayerVideoView paramThumbPlayerVideoView, RedesignVideoPlayerSeekBar paramRedesignVideoPlayerSeekBar, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273900);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new i(this.WVj, this.WVo, this.WVp, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(273900);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(273901);
      paramObject1 = ((i)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(273901);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273898);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273898);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      while (al.a(paramObject))
      {
        int i = this.WVo.getCurrentPosition() / 1000;
        if (this.WVp.getmPosition() != i)
        {
          Log.i("MicroMsg.Imagegallery.handler.video.tp", "progress: ".concat(String.valueOf(i)));
          this.WVp.seek(i);
        }
        long l = Math.min(1000L - this.WVo.getCurrentPosition() % 1000L, 500L);
        if (this.WVo.uXY)
        {
          int j = (int)(o.a(this.WVj, this.WVo) / 1000L);
          if (j > 0) {
            this.WVp.arc(j);
          }
        }
        this.L$0 = paramObject;
        this.rdc = i;
        this.uyU = l;
        this.label = 1;
        if (aw.a(l, this) == locala)
        {
          AppMethodBeat.o(273898);
          return locala;
          ak localak = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localak;
        }
      }
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(273898);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(o paramo) {}
    
    public final void run()
    {
      AppMethodBeat.i(274202);
      this.WVj.WQM.WQV.onBackPressed();
      AppMethodBeat.o(274202);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(o paramo) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(280133);
      if (paramDialogInterface != null) {
        paramDialogInterface.cancel();
      }
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292341);
          if ((this.WVq.WVj.WQM != null) && (this.WVq.WVj.WQM.WQV != null)) {
            this.WVq.WVj.WQM.WQV.onBackPressed();
          }
          AppMethodBeat.o(292341);
        }
      });
      AppMethodBeat.o(280133);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class m
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    m(o paramo, p paramp, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(279735);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new m(this.WVj, this.WVm, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(279735);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(279736);
      paramObject1 = ((m)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(279736);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(279734);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(279734);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        this.L$0 = this.p$;
        this.label = 1;
        if (aw.a(100L, this) == locala)
        {
          AppMethodBeat.o(279734);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      o.a(this.WVj, this.WVm);
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(279734);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTextureUpdate"})
  static final class n
    implements k.e
  {
    n(o paramo, p paramp) {}
    
    public final void bXh()
    {
      AppMethodBeat.i(288966);
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "First video frame has been rendered");
      o.b(this.WVj, this.WVm);
      AppMethodBeat.o(288966);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    Object rdb;
    int rdc;
    int rdd;
    int sPA;
    Object sPl;
    Object sPm;
    Object sPn;
    Object sPo;
    
    o(o paramo, ca paramca, p paramp, ThumbPlayerVideoView paramThumbPlayerVideoView, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(288455);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new o(this.WVj, paramca, localp, this.WVo, paramInt, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(288455);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(288457);
      paramObject1 = ((o)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(288457);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(288453);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(288453);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = (kotlin.d.f)bc.iRs();
        localObject2 = (kotlin.g.a.m)new b(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = kotlinx.coroutines.i.a((kotlin.d.f)localObject1, (kotlin.g.a.m)localObject2, this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(288453);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (com.tencent.mm.modelvideo.w)localObject1;
        if (localObject1 == null)
        {
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(288453);
          return paramObject;
        }
        kotlin.g.b.p.j(localObject1, "withContext(Dispatchers.…       } ?: return@launch");
        o.a(this.WVj, ((com.tencent.mm.modelvideo.w)localObject1).getFileName());
        if ((!paramca.dlS()) && (paramca.Ic()))
        {
          Toast.makeText((Context)this.WVj.WQM.WQV, R.l.eUF, 0).show();
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(288453);
          return paramObject;
        }
        localObject2 = this.WVj;
        Object localObject3 = ((com.tencent.mm.modelvideo.w)localObject1).getFileName();
        kotlin.g.b.p.j(localObject3, "info.fileName");
        o.b((o)localObject2, (String)localObject3);
        localObject2 = g.a(paramObject, (kotlin.d.f)bc.iRq(), (kotlin.g.a.m)new a((com.tencent.mm.modelvideo.w)localObject1, null), 2);
        localObject3 = g.a(paramObject, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new c((com.tencent.mm.modelvideo.w)localObject1, null), 2);
        Object localObject4 = localp;
        int j = ((com.tencent.mm.modelvideo.w)localObject1).bfj();
        int i = ((com.tencent.mm.modelvideo.w)localObject1).blF();
        this.L$0 = paramObject;
        this.oDA = localObject1;
        this.pGq = localObject2;
        this.pGr = localObject3;
        this.rdb = localObject4;
        this.rdc = j;
        this.rdd = i;
        this.label = 2;
        Object localObject5 = ((at)localObject3).n(this);
        Object localObject6;
        if (localObject5 == locala)
        {
          AppMethodBeat.o(288453);
          return locala;
          i = this.rdd;
          j = this.rdc;
          localObject4 = (p)this.rdb;
          localObject3 = (at)this.pGr;
          localObject2 = (at)this.pGq;
          localObject6 = (com.tencent.mm.modelvideo.w)this.oDA;
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject5 = paramObject;
          paramObject = localObject6;
        }
        for (;;)
        {
          int m = ((Number)localObject5).intValue();
          localObject5 = paramObject.bqM();
          this.L$0 = localObject1;
          this.oDA = paramObject;
          this.pGq = localObject2;
          this.pGr = localObject3;
          this.rdb = localObject4;
          this.rdc = j;
          this.rdd = i;
          this.sPA = m;
          this.sPl = localObject5;
          this.label = 3;
          localObject6 = ((at)localObject2).n(this);
          int k;
          Object localObject7;
          if (localObject6 == locala)
          {
            AppMethodBeat.o(288453);
            return locala;
            localObject5 = (String)this.sPl;
            k = this.sPA;
            j = this.rdd;
            i = this.rdc;
            localObject7 = (p)this.rdb;
            localObject3 = (at)this.pGr;
            localObject2 = (at)this.pGq;
            localObject6 = (com.tencent.mm.modelvideo.w)this.oDA;
            localObject1 = (ak)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject4 = paramObject;
            paramObject = localObject6;
            localObject6 = localObject4;
            localObject4 = localObject7;
          }
          for (;;)
          {
            ((p)localObject4).a(i, j, k, (String)localObject5, (String)localObject6, paramObject.getCreateTime());
            localObject4 = this.WVj.WQM.WQV;
            kotlin.g.b.p.j(localObject4, "adapter.ui");
            if (((ImageGalleryUI)localObject4).hSp()) {
              this.WVj.WQM.WQV.hSs();
            }
            o.d(this.WVj);
            if (this.WVo.ayN())
            {
              this.WVo.start();
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "resume playing");
              o.b(this.WVj, localp);
              localObject2 = o.a(this.WVj);
              localObject1 = paramObject;
              if (localObject2 != null)
              {
                localObject1 = paramObject;
                if (this.WVo.uXY)
                {
                  localObject1 = paramObject;
                  if (!((com.tencent.mm.plugin.thumbplayer.c.i)localObject2).aCE())
                  {
                    ((com.tencent.mm.plugin.thumbplayer.c.i)localObject2).start();
                    localObject1 = paramObject;
                  }
                }
              }
            }
            for (;;)
            {
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "play video: video status=" + ((com.tencent.mm.modelvideo.w)localObject1).getStatus() + ", position=" + paramInt);
              paramObject = kotlin.x.aazN;
              AppMethodBeat.o(288453);
              return paramObject;
              i = this.WVj.WQM.WQV.Wc(paramca.apG());
              localObject4 = this.WVo;
              if (i == 3) {}
              com.tencent.mm.plugin.thumbplayer.g.d locald;
              for (boolean bool = true;; bool = false)
              {
                ((ThumbPlayerVideoView)localObject4).setMute(bool);
                this.WVo.setOnInfoCallback((k.b)new k.b()
                {
                  public final void eN(int paramAnonymousInt1, int paramAnonymousInt2)
                  {
                    AppMethodBeat.i(229039);
                    switch (paramAnonymousInt1)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(229039);
                      return;
                      Log.i("MicroMsg.Imagegallery.handler.video.tp", "on buffering start");
                      o.c(this.WVs.WVj, this.WVs.WVm);
                      AppMethodBeat.o(229039);
                      return;
                      Log.i("MicroMsg.Imagegallery.handler.video.tp", "on buffering end");
                      o.b(this.WVs.WVj, this.WVs.WVm);
                    }
                  }
                });
                localObject5 = new mj();
                ((mj)localObject5).xl(paramca.apH());
                localObject6 = new com.tencent.mm.plugin.thumbplayer.g.b(o.e(this.WVj));
                localObject7 = new c(paramca, paramObject, (com.tencent.mm.plugin.thumbplayer.g.b)localObject6, (kotlin.g.a.b)new d((mj)localObject5, paramObject));
                locald = new com.tencent.mm.plugin.thumbplayer.g.d((mj)localObject5, o.e(this.WVj), 1);
                localObject4 = new com.tencent.mm.plugin.thumbplayer.c.d((com.tencent.mm.plugin.thumbplayer.c.h)localObject7);
                ((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).a((com.tencent.mm.plugin.thumbplayer.g.a)locald);
                ((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).a((com.tencent.mm.plugin.thumbplayer.g.a)new b());
                ((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).a((com.tencent.mm.plugin.thumbplayer.g.a)localObject6);
                o.a(this.WVj, (com.tencent.mm.plugin.thumbplayer.c.i)localObject4);
                this.WVo.MUL.clear();
                this.WVo.a((com.tencent.mm.plugin.thumbplayer.g.c)locald);
                this.WVo.a((com.tencent.mm.plugin.thumbplayer.g.c)localObject6);
                if ((!((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).aCE()) && (!o.c(paramca, paramObject))) {
                  break label1221;
                }
                localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).gnQ();
                if ((localObject1 != null) && (u.agG((String)localObject1))) {
                  break;
                }
                Toast.makeText((Context)this.WVj.WQM.WQV, R.l.eUF, 0).show();
                paramObject = kotlin.x.aazN;
                AppMethodBeat.o(288453);
                return paramObject;
              }
              Log.i("MicroMsg.Imagegallery.handler.video.tp", "start play local video file");
              this.WVo.setVideoPath((String)localObject1);
              localObject1 = paramObject;
              continue;
              label1221:
              if (((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).start())
              {
                Log.i("MicroMsg.Imagegallery.handler.video.tp", "start online play video.");
                this.WVo.setResourceDownloader((com.tencent.mm.plugin.thumbplayer.c.i)localObject4);
                o.c(this.WVj, localp);
                try
                {
                  this.L$0 = localObject1;
                  this.oDA = paramObject;
                  this.pGq = localObject2;
                  this.pGr = localObject3;
                  this.rdc = i;
                  this.rdb = localObject5;
                  this.sPl = localObject6;
                  this.sPm = localObject7;
                  this.sPn = locald;
                  this.sPo = localObject4;
                  this.label = 4;
                  localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject4).f(this);
                  if (localObject1 == locala)
                  {
                    AppMethodBeat.o(288453);
                    return locala;
                    localObject1 = (com.tencent.mm.modelvideo.w)this.oDA;
                    ResultKt.throwOnFailure(paramObject);
                    paramObject = localObject1;
                  }
                  Log.i("MicroMsg.Imagegallery.handler.video.tp", "moov is Ready: waitingForDownload=" + o.c(this.WVj));
                  localObject1 = paramObject;
                  if (o.c(this.WVj)) {
                    continue;
                  }
                  this.WVo.prepare();
                  localObject1 = paramObject;
                }
                catch (i.a paramObject)
                {
                  Log.w("MicroMsg.Imagegallery.handler.video.tp", "Unable to wait moov ready");
                  o.a(this.WVj, localp, paramObject);
                  paramObject = kotlin.x.aazN;
                  AppMethodBeat.o(288453);
                  return paramObject;
                }
              }
              else
              {
                Log.i("MicroMsg.Imagegallery.handler.video.tp", "start offline play video.");
                o.a(this.WVj, localp, com.tencent.mm.modelvideo.y.g(paramObject));
                for (;;)
                {
                  try
                  {
                    o.a(this.WVj, true);
                    o localo = this.WVj;
                    ca localca = paramca;
                    this.L$0 = localObject1;
                    this.oDA = paramObject;
                    this.pGq = localObject2;
                    this.pGr = localObject3;
                    this.rdc = i;
                    this.rdb = localObject5;
                    this.sPl = localObject6;
                    this.sPm = localObject7;
                    this.sPn = locald;
                    this.sPo = localObject4;
                    this.label = 5;
                    localObject3 = localo.a(localca, this);
                    localObject2 = localObject4;
                    if (localObject3 == locala)
                    {
                      AppMethodBeat.o(288453);
                      return locala;
                      localObject2 = (com.tencent.mm.plugin.thumbplayer.c.d)this.sPo;
                      localObject3 = (com.tencent.mm.modelvideo.w)this.oDA;
                      localObject1 = (ak)this.L$0;
                      ResultKt.throwOnFailure(paramObject);
                      paramObject = localObject3;
                    }
                    o.a(this.WVj, false);
                    if ((!al.a((ak)localObject1)) || (this.WVj.WQM == null))
                    {
                      localObject1 = new StringBuilder("Seems the job is canceled(it shouldn't happen at all), isActive=").append(al.a((ak)localObject1)).append(", adapter is null=");
                      if (this.WVj.WQM == null)
                      {
                        bool = true;
                        Log.w("MicroMsg.Imagegallery.handler.video.tp", bool);
                      }
                    }
                    else
                    {
                      localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject2).gnQ();
                      if ((localObject1 != null) && (u.agG((String)localObject1))) {
                        break;
                      }
                      Toast.makeText((Context)this.WVj.WQM.WQV, R.l.eUF, 0).show();
                      paramObject = kotlin.x.aazN;
                      AppMethodBeat.o(288453);
                      return paramObject;
                    }
                  }
                  catch (IllegalStateException paramObject)
                  {
                    Log.w("MicroMsg.Imagegallery.handler.video.tp", "awaiting video to be downloaded doesn't success: " + paramObject.getMessage());
                    o.a(this.WVj, localp);
                    paramObject = kotlin.x.aazN;
                    return paramObject;
                  }
                  finally
                  {
                    o.a(this.WVj, false);
                    AppMethodBeat.o(288453);
                  }
                  bool = false;
                }
                this.WVo.setVideoPath((String)localObject1);
                localObject1 = paramObject;
              }
            }
            k = i;
            i = j;
            j = k;
            k = m;
          }
          localObject6 = paramObject;
          paramObject = localObject1;
          localObject1 = localObject6;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super String>, Object>
    {
      int label;
      private ak p$;
      
      a(com.tencent.mm.modelvideo.w paramw, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(195953);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new a(this.WVt, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(195953);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(195955);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(195955);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(195951);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(195951);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.modelvideo.w.XK(this.WVt.bqO());
        AppMethodBeat.o(195951);
        return paramObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelvideo/VideoInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class b
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super com.tencent.mm.modelvideo.w>, Object>
    {
      int label;
      private ak p$;
      
      b(o.o paramo, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(290487);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new b(this.WVs, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(290487);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(290488);
        paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(290488);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(290486);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(290486);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = e.cH(this.WVs.lEd);
        AppMethodBeat.o(290486);
        return paramObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class c
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super Integer>, Object>
    {
      int label;
      private ak p$;
      
      c(com.tencent.mm.modelvideo.w paramw, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(286941);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new c(this.WVt, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(286941);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(286942);
        paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(286942);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(286940);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(286940);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        if (ab.Lj(this.WVt.bqM())) {}
        for (int i = v.Pu(this.WVt.bqM());; i = 0)
        {
          AppMethodBeat.o(286940);
          return Integer.valueOf(i);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.i.h, kotlin.x>
    {
      d(mj parammj, com.tencent.mm.modelvideo.w paramw)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    int label;
    private ak p$;
    
    p(o paramo, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(229209);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new p(this.WVj, i, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(229209);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(229212);
      paramObject1 = ((p)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(229212);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(229204);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(229204);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      com.tencent.mm.modelvideo.y.aS(o.b(this.WVj), i);
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(229204);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$seekCallback$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "app_release"})
  public static final class q
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    q(f paramf) {}
    
    public final void aRo()
    {
      AppMethodBeat.i(274688);
      p localp = paramf.hRG();
      if (localp != null)
      {
        localp.hSL().WVL.pause();
        o.d(this.WVj, localp);
      }
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "onSeekPre");
      AppMethodBeat.o(274688);
    }
    
    public final void tY(int paramInt)
    {
      AppMethodBeat.i(274689);
      Object localObject1 = paramf.hRG();
      Object localObject2 = ((p)localObject1).WVL;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView");
        AppMethodBeat.o(274689);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ThumbPlayerVideoView)localObject2;
      Log.i("MicroMsg.Imagegallery.handler.video.tp", "onSeekTo(" + paramInt + ')');
      kotlin.g.b.p.j(localObject1, "holder");
      ImageView localImageView = ((p)localObject1).hSL().WVK;
      kotlin.g.b.p.j(localImageView, "holder.videoView.mVideoWaitPlayBtn");
      localImageView.setVisibility(8);
      if (((ThumbPlayerVideoView)localObject2).ayN())
      {
        ((ThumbPlayerVideoView)localObject2).setOnSeekCompleteCallback((k.c)new a(this, (p)localObject1));
        ((ThumbPlayerVideoView)localObject2).b(paramInt * 1000.0D, true);
      }
      for (;;)
      {
        paramf.WQV.hSs();
        localObject1 = paramf.hRF();
        if ((localObject1 != null) && (((ca)localObject1).dlS())) {
          paramf.WQV.WTa.n((ca)localObject1, 13);
        }
        AppMethodBeat.o(274689);
        return;
        localObject1 = paramf.hRF();
        if ((localObject1 != null) && (((ca)localObject1).dlR())) {
          com.tencent.mm.modelvideo.y.j(((ca)localObject1).apK(), paramInt * 1000, ((ThumbPlayerVideoView)localObject2).uXY);
        }
        localObject1 = paramf;
        localObject2 = paramf.WQV;
        kotlin.g.b.p.j(localObject2, "adapter.ui");
        ((f)localObject1).avV(((ImageGalleryUI)localObject2).getCurrentItem());
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onSeekComplete"})
    static final class a
      implements k.c
    {
      a(o.q paramq, p paramp) {}
      
      public final void gz(boolean paramBoolean)
      {
        AppMethodBeat.i(289354);
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "seek completed");
        o localo = this.WVw.WVj;
        p localp = this.WVm;
        kotlin.g.b.p.j(localp, "holder");
        o.b(localo, localp);
        AppMethodBeat.o(289354);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class r
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    r(o paramo, ThumbPlayerVideoView paramThumbPlayerVideoView, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(286709);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new r(this.WVj, this.WVo, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(286709);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(286710);
      paramObject1 = ((r)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(286710);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(286707);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(286707);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      while (al.a(paramObject))
      {
        this.L$0 = paramObject;
        this.label = 1;
        if (aw.a(500L, this) == locala)
        {
          AppMethodBeat.o(286707);
          return locala;
          ak localak = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localak;
        }
        o.b(this.WVj, this.WVo);
      }
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(286707);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class s
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    int rdc;
    
    s(o paramo, ThumbPlayerVideoView paramThumbPlayerVideoView, p paramp, ca paramca, int paramInt, com.tencent.mm.modelvideo.w paramw, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(287233);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new s(this.WVj, this.WVo, localp, paramca, paramInt, localw, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(287233);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(287235);
      paramObject1 = ((s)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(287235);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(287231);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject;
      final int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(287231);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        if (this.WVo.uXY)
        {
          localObject = o.a(this.WVj);
          if (localObject != null) {
            ((com.tencent.mm.plugin.thumbplayer.c.i)localObject).gnP();
          }
        }
        o.a(this.WVj, localp, com.tencent.mm.modelvideo.y.g(e.cH(paramca)));
        if (paramInt == 2)
        {
          i = 8;
          com.tencent.e.h.ZvG.be((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(283370);
              com.tencent.mm.modelvideo.y.aT(o.b(this.WVz.WVj), i);
              AppMethodBeat.o(283370);
            }
          });
          if (paramInt != 2) {
            break label218;
          }
          o.hSE();
        }
        break;
      }
      for (;;)
      {
        try
        {
          o.a(this.WVj, true);
          localObject = this.WVj;
          ca localca = paramca;
          this.L$0 = paramObject;
          this.rdc = i;
          this.label = 1;
          paramObject = ((o)localObject).a(localca, this);
          if (paramObject == locala)
          {
            AppMethodBeat.o(287231);
            return locala;
            i = 5;
            break;
            label218:
            if (paramInt != 1) {
              continue;
            }
            o.hSF();
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          o.a(this.WVj, false);
          o.a(this.WVj, localp);
          switch (paramInt)
          {
          default: 
            paramObject = kotlin.x.aazN;
            AppMethodBeat.o(287231);
            return paramObject;
          }
        }
        catch (IllegalStateException paramObject)
        {
          Log.w("MicroMsg.Imagegallery.handler.video.tp", "Failed to wait video to be downloaded: " + paramObject.getMessage());
          paramObject = kotlin.x.aazN;
          return paramObject;
        }
        finally
        {
          o.a(this.WVj, false);
          o.a(this.WVj, localp);
          AppMethodBeat.o(287231);
        }
        Log.i("MicroMsg.Imagegallery.handler.video.tp", "do restransmit video");
        o.hSG();
        this.WVj.WQM.cP(paramca);
        this.WVj.WQM.WQV.Wd(-1L);
        if (this.WVo.uXY)
        {
          i = this.WVo.getCurrentPosition();
          com.tencent.mm.modelvideo.y.j(localw.getFileName(), i, true);
          continue;
          o.hSH();
          f.a((Context)this.WVj.WQM.WQV, paramca);
          this.WVj.WQM.WQV.Wd(-1L);
          if (this.WVo.uXY)
          {
            i = this.WVo.getCurrentPosition();
            com.tencent.mm.modelvideo.y.j(localw.getFileName(), i, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o
 * JD-Core Version:    0.7.0.1
 */