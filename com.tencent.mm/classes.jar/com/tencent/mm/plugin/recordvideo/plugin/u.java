package com.tencent.mm.plugin.recordvideo.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.util.g;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getParentViewGroup", "Landroid/view/ViewGroup;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements v
{
  public static final u.a NKJ;
  private boolean FVa;
  public VideoPlayerTextureView KZh;
  private final TextView NKK;
  private long NKL;
  private int NKM;
  public boolean NKN;
  private int NKO;
  private long NKP;
  private final c NKQ;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  public Context context;
  public int endTime;
  private com.tencent.mm.compatible.util.b peV;
  public int startTime;
  
  static
  {
    AppMethodBeat.i(75607);
    NKJ = new u.a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public u(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.KZh = paramVideoPlayerTextureView;
    this.NKK = paramTextView;
    paramVideoPlayerTextureView = this.KZh;
    if (paramVideoPlayerTextureView == null) {}
    for (paramVideoPlayerTextureView = null;; paramVideoPlayerTextureView = paramVideoPlayerTextureView.getContext())
    {
      this.context = paramVideoPlayerTextureView;
      this.NKL = -1L;
      this.NKM = 10000;
      this.NKO = 333;
      this.NKQ = new c(this, parama);
      AppMethodBeat.o(75606);
      return;
    }
  }
  
  private static final void a(u paramu, TextView paramTextView)
  {
    AppMethodBeat.i(280717);
    s.u(paramu, "this$0");
    s.u(paramTextView, "$it");
    ah.f localf = new ah.f();
    paramu = paramu.NKf;
    if (paramu == null) {}
    for (paramu = null;; paramu = paramu.nJU)
    {
      localf.aqH = com.tencent.mm.plugin.mmsight.d.aMu(paramu);
      localf.aqH = s.X((String)localf.aqH, "\n针对拍摄视频：\n");
      paramu = new StringBuilder().append((String)localf.aqH).append("是否使用CPU预览裁剪方式：");
      com.tencent.mm.plugin.recordvideo.util.d locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.bsq() + '\n');
      paramu = new StringBuilder().append((String)localf.aqH).append("是否使用两路流录制：");
      locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.gLd() + '\n');
      paramu = new StringBuilder().append((String)localf.aqH).append("预览页视频个数：");
      locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.gLe() + '\n');
      if (!Util.isNullOrNil((String)localf.aqH)) {
        break;
      }
      AppMethodBeat.o(280717);
      return;
    }
    if ((MMApplicationContext.isMainProcess()) && (h.baE().ban().getInt(at.a.acOt, 0) != 1))
    {
      AppMethodBeat.o(280717);
      return;
    }
    MMHandlerThread.postToMainThread(new u..ExternalSyntheticLambda1(localf, paramTextView));
    AppMethodBeat.o(280717);
  }
  
  private static final void a(ah.f paramf, TextView paramTextView)
  {
    AppMethodBeat.i(280708);
    s.u(paramf, "$debugInfo");
    s.u(paramTextView, "$it");
    Log.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { paramf.aqH });
    paramTextView.setVisibility(0);
    paramTextView.setText((CharSequence)paramf.aqH);
    AppMethodBeat.o(280708);
  }
  
  public final void AX(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75605);
    this.NKN = false;
    Object localObject1 = gIE();
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null) {
        ((ViewPropertyAnimator)localObject1).setDuration(300L);
      }
      if (!paramBoolean)
      {
        this.startTime = 0;
        localObject1 = this.NKf;
        if (localObject1 != null) {
          break label128;
        }
      }
    }
    label128:
    for (int i = 10000;; i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime)
    {
      this.endTime = i;
      AppMethodBeat.o(75605);
      return;
      ViewPropertyAnimator localViewPropertyAnimator = ((ViewGroup)localObject1).animate();
      localObject1 = localObject2;
      if (localViewPropertyAnimator == null) {
        break;
      }
      localViewPropertyAnimator = localViewPropertyAnimator.scaleX(1.0F);
      localObject1 = localObject2;
      if (localViewPropertyAnimator == null) {
        break;
      }
      localViewPropertyAnimator = localViewPropertyAnimator.scaleY(1.0F);
      localObject1 = localObject2;
      if (localViewPropertyAnimator == null) {
        break;
      }
      localObject1 = localViewPropertyAnimator.translationY(0.0F);
      break;
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280882);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280882);
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280846);
    s.u(paramb, "info");
    Log.i("MicroMsg.EditVideoPlayPlugin", s.X("start preview ", paramb));
    this.NKf = paramb;
    int i;
    Object localObject;
    label58:
    boolean bool;
    if (paramRecordConfigProvider == null)
    {
      i = 10000;
      this.NKM = i;
      localObject = this.KZh;
      if (localObject != null) {
        break label339;
      }
      localObject = null;
      this.peV = new com.tencent.mm.compatible.util.b((Context)localObject);
      localObject = this.peV;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      localObject = this.KZh;
      if (localObject != null) {
        ((VideoPlayerTextureView)localObject).setVisibility(0);
      }
      localObject = this.KZh;
      if (localObject != null) {
        ((VideoPlayerTextureView)localObject).setAlpha(0.0F);
      }
      localObject = this.KZh;
      if (localObject != null) {
        ((VideoPlayerTextureView)localObject).setVideoPath(paramb.bug());
      }
      if (paramRecordConfigProvider != null) {
        break label349;
      }
      bool = false;
      label149:
      if (bool)
      {
        localObject = g.Obu;
        localObject = g.aTF(paramb.bug());
        if (localObject != null)
        {
          if ((((g.a)localObject).hYK != 0) && (((g.a)localObject).hYK != 180)) {
            break label369;
          }
          if (((g.a)localObject).width <= ((g.a)localObject).height) {
            break label364;
          }
          i = 1;
          label207:
          if ((paramRecordConfigProvider != null) && (paramRecordConfigProvider.NHS != i.e.XYK)) {
            break label425;
          }
          if (i == 0) {
            break label392;
          }
          paramRecordConfigProvider = this.KZh;
          if (paramRecordConfigProvider != null) {
            paramRecordConfigProvider.setScaleType(i.e.XYK);
          }
        }
      }
    }
    for (;;)
    {
      this.FVa = true;
      paramRecordConfigProvider = this.KZh;
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.setVideoCallback((i.a)this.NKQ);
      }
      this.startTime = paramb.startTime;
      this.endTime = paramb.endTime;
      paramb = this.NKK;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      paramb = this.NKK;
      if ((paramb != null) && (WeChatEnvironment.hasDebugger())) {
        i.au(new u..ExternalSyntheticLambda0(this, paramb));
      }
      AppMethodBeat.o(280846);
      return;
      i = paramRecordConfigProvider.NHZ;
      break;
      label339:
      localObject = ((VideoPlayerTextureView)localObject).getContext();
      break label58;
      label349:
      bool = s.p(paramRecordConfigProvider.NHU, Boolean.TRUE);
      break label149;
      label364:
      i = 0;
      break label207;
      label369:
      if (((g.a)localObject).height > ((g.a)localObject).width)
      {
        i = 1;
        break label207;
      }
      i = 0;
      break label207;
      label392:
      paramRecordConfigProvider = this.KZh;
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.setForceScaleFullScreen(true);
      }
      paramRecordConfigProvider = this.KZh;
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider.setScaleType(i.e.XYN);
        continue;
        label425:
        localObject = this.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).setScaleType(paramRecordConfigProvider.NHS);
        }
      }
    }
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280900);
    s.u(this, "this");
    AppMethodBeat.o(280900);
  }
  
  public final ViewGroup gIE()
  {
    AppMethodBeat.i(280872);
    Object localObject = this.KZh;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((VideoPlayerTextureView)localObject).getParent())
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(280872);
      return localObject;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(280889);
    String str = v.a.b(this);
    AppMethodBeat.o(280889);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280895);
    s.u(this, "this");
    AppMethodBeat.o(280895);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280906);
    s.u(this, "this");
    AppMethodBeat.o(280906);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(75604);
    s.u((v)this, "this");
    release();
    AppMethodBeat.o(75604);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75601);
    Log.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    Object localObject = this.peV;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).aPS();
    }
    localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).pause();
    }
    AppMethodBeat.o(75601);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280913);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280913);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    Log.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    Object localObject = this.KZh;
    s.checkNotNull(localObject);
    if (!((VideoPlayerTextureView)localObject).isPlaying())
    {
      localObject = this.peV;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      localObject = this.KZh;
      if (localObject != null) {
        ((VideoPlayerTextureView)localObject).start();
      }
    }
    AppMethodBeat.o(75600);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    Object localObject = this.peV;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).aPS();
    }
    localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).stop();
    }
    localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).setVideoCallback(null);
    }
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    Object localObject = this.peV;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).aPS();
    }
    localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).stop();
    }
    localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).setVideoCallback(null);
    }
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    Object localObject = this.KZh;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).setVisibility(paramInt);
    }
    localObject = this.NKK;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    AppMethodBeat.o(75599);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    public b(u paramu) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(75588);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(75588);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75587);
      s.u(paramAnimator, "animation");
      paramAnimator = u.a(this.NKR);
      if (paramAnimator != null) {
        paramAnimator.requestLayout();
      }
      AppMethodBeat.o(75587);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(75589);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(75589);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(75586);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(75586);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.a
  {
    c(u paramu, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    private static final void a(u paramu, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
    {
      AppMethodBeat.i(280460);
      s.u(paramu, "this$0");
      s.u(parama, "$status");
      Log.i("MicroMsg.MMRecordUI", "onTextureUpdate");
      paramu = paramu.KZh;
      if (paramu != null) {
        paramu.setAlpha(1.0F);
      }
      a.b.a(parama, a.c.NOk);
      AppMethodBeat.o(280460);
    }
    
    private static final void b(u paramu, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
    {
      AppMethodBeat.i(280463);
      s.u(paramu, "this$0");
      s.u(parama, "$status");
      MMHandlerThread.postToMainThreadDelayed(new u.c..ExternalSyntheticLambda2(paramu, parama), 10L);
      AppMethodBeat.o(280463);
    }
    
    private static final void i(u paramu)
    {
      VideoPlayerTextureView localVideoPlayerTextureView = null;
      AppMethodBeat.i(280458);
      s.u(paramu, "this$0");
      StringBuilder localStringBuilder = new StringBuilder("video onPrepared l:");
      Object localObject = paramu.KZh;
      if (localObject == null)
      {
        localObject = null;
        localStringBuilder = localStringBuilder.append(localObject).append(" t:");
        localObject = paramu.KZh;
        if (localObject != null) {
          break label247;
        }
        localObject = null;
        label67:
        localStringBuilder = localStringBuilder.append(localObject).append(" r:");
        localObject = paramu.KZh;
        if (localObject != null) {
          break label260;
        }
        localObject = null;
        label95:
        localStringBuilder = localStringBuilder.append(localObject).append(" b:");
        localObject = paramu.KZh;
        if (localObject != null) {
          break label273;
        }
      }
      label260:
      label273:
      for (localObject = localVideoPlayerTextureView;; localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getBottom()))
      {
        Log.i("MicroMsg.EditVideoPlayPlugin", localObject);
        localObject = e.NDU;
        localObject = e.gGM();
        localVideoPlayerTextureView = paramu.KZh;
        s.checkNotNull(localVideoPlayerTextureView);
        int i = localVideoPlayerTextureView.getLeft();
        localVideoPlayerTextureView = paramu.KZh;
        s.checkNotNull(localVideoPlayerTextureView);
        int j = localVideoPlayerTextureView.getTop();
        localVideoPlayerTextureView = paramu.KZh;
        s.checkNotNull(localVideoPlayerTextureView);
        int k = localVideoPlayerTextureView.getRight();
        paramu = paramu.KZh;
        s.checkNotNull(paramu);
        ((Rect)localObject).set(new Rect(i, j, k, paramu.getBottom()));
        AppMethodBeat.o(280458);
        return;
        localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getLeft());
        break;
        label247:
        localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getTop());
        break label67;
        localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getRight());
        break label95;
      }
    }
    
    public final void Qz()
    {
      AppMethodBeat.i(75596);
      Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (u.b(this.NKR))
      {
        bf.bf(u.c(this.NKR));
        localObject = e.NDU;
        localObject = e.gGM();
        com.tencent.mm.plugin.recordvideo.model.a locala = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        int i = com.tencent.mm.plugin.recordvideo.model.a.gHH();
        locala = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        ((Rect)localObject).set(new Rect(0, 0, i, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
      }
      for (;;)
      {
        u.a(this.NKR, -1L);
        localObject = this.NKR.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).start();
        }
        localObject = this.NKR.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).setLoop(true);
        }
        localObject = this.NKR.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).setOneTimeVideoTextureUpdateCallback(new u.c..ExternalSyntheticLambda0(this.NKR, parama));
        }
        localObject = new Bundle();
        if (this.NKR.endTime - this.NKR.startTime > u.d(this.NKR) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        parama.a(a.c.NOR, (Bundle)localObject);
        if (this.NKR.endTime - this.NKR.startTime > u.d(this.NKR) + 750)
        {
          this.NKR.endTime = (u.d(this.NKR) + 250);
          a.b.a(parama, a.c.NOI);
        }
        AppMethodBeat.o(75596);
        return;
        localObject = this.NKR.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).invalidate();
        }
        localObject = this.NKR.KZh;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).post(new u.c..ExternalSyntheticLambda1(this.NKR));
        }
      }
    }
    
    public final void fG(int paramInt1, int paramInt2) {}
    
    public final int gw(int paramInt1, int paramInt2)
    {
      VideoPlayerTextureView localVideoPlayerTextureView = null;
      AppMethodBeat.i(75598);
      StringBuilder localStringBuilder;
      Object localObject;
      if ((u.e(this.NKR) <= 0L) || (Util.ticksToNow(u.e(this.NKR)) >= 1000L))
      {
        localStringBuilder = new StringBuilder(" ");
        localObject = this.NKR.KZh;
        if (localObject == null)
        {
          localObject = null;
          localStringBuilder = localStringBuilder.append(localObject).append(" videoPlayView.currentPosition: ");
          localObject = this.NKR.KZh;
          if (localObject != null) {
            break label395;
          }
          localObject = null;
          label92:
          Log.d("MicroMsg.EditVideoPlayPlugin", localObject + " + " + this.NKR.endTime);
          u.a(this.NKR, Util.currentTicks());
        }
      }
      else
      {
        localObject = this.NKR.KZh;
        s.checkNotNull(localObject);
        if (((VideoPlayerTextureView)localObject).isPlaying())
        {
          localObject = this.NKR.KZh;
          s.checkNotNull(localObject);
          if (((VideoPlayerTextureView)localObject).getCurrentPosition() >= this.NKR.endTime)
          {
            paramInt1 = this.NKR.endTime;
            localObject = this.NKR.KZh;
            s.checkNotNull(localObject);
            if (paramInt1 < ((VideoPlayerTextureView)localObject).getDuration())
            {
              localStringBuilder = new StringBuilder("currentPosition:");
              localObject = this.NKR.KZh;
              if (localObject != null) {
                break label406;
              }
              localObject = localVideoPlayerTextureView;
              label232:
              Log.i("MicroMsg.EditVideoPlayPlugin", localObject + " reach endTime:" + this.NKR.endTime + ", seekTo startTime:" + this.NKR.startTime + ", isClipMode:" + u.f(this.NKR));
              localObject = this.NKR.KZh;
              if (localObject != null) {
                ((VideoPlayerTextureView)localObject).c(this.NKR.startTime, true);
              }
            }
          }
          if (!u.f(this.NKR)) {
            break label417;
          }
          localObject = new Bundle();
          localVideoPlayerTextureView = this.NKR.KZh;
          s.checkNotNull(localVideoPlayerTextureView);
          ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", localVideoPlayerTextureView.getCurrentPosition());
          parama.a(a.c.NOK, (Bundle)localObject);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        localObject = Boolean.valueOf(((VideoPlayerTextureView)localObject).isPlaying());
        break;
        label395:
        localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getCurrentPosition());
        break label92;
        label406:
        localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getCurrentPosition());
        break label232;
        label417:
        if (System.currentTimeMillis() - u.g(this.NKR) >= u.h(this.NKR))
        {
          localObject = new Bundle();
          localVideoPlayerTextureView = this.NKR.KZh;
          s.checkNotNull(localVideoPlayerTextureView);
          ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", localVideoPlayerTextureView.getCurrentPosition());
          parama.a(a.c.NOK, (Bundle)localObject);
        }
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      Log.i("MicroMsg.EditVideoPlayPlugin", s.X("onCompletion, startTime:", Integer.valueOf(this.NKR.startTime)));
      VideoPlayerTextureView localVideoPlayerTextureView = this.NKR.KZh;
      if (localVideoPlayerTextureView != null) {
        localVideoPlayerTextureView.c(this.NKR.startTime, true);
      }
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      Log.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.u
 * JD-Core Version:    0.7.0.1
 */