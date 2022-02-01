package com.tencent.mm.plugin.vlog.ui.video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;Landroid/content/Context;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "firstFrame", "", "isClipMode", "maxRecordTime", "mediaModel", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "startTime", "getStartTime", "setStartTime", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoCallback", "com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;)V", "getParentViewGroup", "Landroid/view/ViewGroup;", "gotoClipMode", "", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onPreViewVideo", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onResume", "release", "releaseVideo", "reset", "seek", "start", "setMediaModel", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "stopPreview", "videoPause", "videoResume", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements v
{
  public static final c.a UrC;
  a GrC;
  private final TextView NKK;
  private int NKM;
  boolean NKN;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private ac TYA;
  VideoCompositionPlayView UrD;
  d UrE;
  private final c UrF;
  Context context;
  int endTime;
  com.tencent.mm.compatible.util.b peV;
  int startTime;
  private boolean ynV;
  
  static
  {
    AppMethodBeat.i(281930);
    UrC = new c.a((byte)0);
    AppMethodBeat.o(281930);
  }
  
  public c(VideoCompositionPlayView paramVideoCompositionPlayView, a parama, TextView paramTextView, Context paramContext)
  {
    AppMethodBeat.i(281892);
    this.UrD = paramVideoCompositionPlayView;
    this.GrC = parama;
    this.NKK = paramTextView;
    this.context = paramContext;
    this.NKM = 10000;
    this.ynV = true;
    this.UrF = new c(this);
    AppMethodBeat.o(281892);
  }
  
  private static final void a(c paramc, TextView paramTextView)
  {
    AppMethodBeat.i(281910);
    s.u(paramc, "this$0");
    s.u(paramTextView, "$it");
    ah.f localf = new ah.f();
    paramc = paramc.NKf;
    if (paramc == null) {}
    for (paramc = null;; paramc = paramc.nJU)
    {
      localf.aqH = com.tencent.mm.plugin.mmsight.d.aMu(paramc);
      localf.aqH = s.X((String)localf.aqH, "\n针对拍摄视频：\n");
      paramc = new StringBuilder().append((String)localf.aqH).append("是否使用CPU预览裁剪方式：");
      com.tencent.mm.plugin.recordvideo.util.d locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.bsq() + '\n');
      paramc = new StringBuilder().append((String)localf.aqH).append("是否使用两路流录制：");
      locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.gLd() + '\n');
      paramc = new StringBuilder().append((String)localf.aqH).append("预览页视频个数：");
      locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      localf.aqH = (com.tencent.mm.plugin.recordvideo.util.d.gLe() + '\n');
      if (!Util.isNullOrNil((String)localf.aqH)) {
        break;
      }
      AppMethodBeat.o(281910);
      return;
    }
    if ((MMApplicationContext.isMainProcess()) && (h.baE().ban().getInt(at.a.acOt, 0) != 1))
    {
      AppMethodBeat.o(281910);
      return;
    }
    MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda1(localf, paramTextView));
    AppMethodBeat.o(281910);
  }
  
  private static final void b(ah.f paramf, TextView paramTextView)
  {
    AppMethodBeat.i(281896);
    s.u(paramf, "$debugInfo");
    s.u(paramTextView, "$it");
    Log.i("MicroMsg.EditVideoPreviewPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { paramf.aqH });
    paramTextView.setVisibility(0);
    paramTextView.setText((CharSequence)paramf.aqH);
    AppMethodBeat.o(281896);
  }
  
  public final void AX(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(282001);
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
      AppMethodBeat.o(282001);
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
    AppMethodBeat.i(282014);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(282014);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(282026);
    s.u(this, "this");
    AppMethodBeat.o(282026);
  }
  
  public final void d(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject = null;
    AppMethodBeat.i(281953);
    s.u(paramb, "info");
    Log.i("MicroMsg.EditVideoPreviewPlugin", s.X("start preview ", paramb));
    this.NKf = paramb;
    int i;
    if (paramRecordConfigProvider == null)
    {
      i = 10000;
      this.NKM = i;
      if (this.UrD == null) {
        this.UrD = new VideoCompositionPlayView(this.context);
      }
      this.ynV = true;
      paramRecordConfigProvider = this.UrD;
      if (paramRecordConfigProvider != null) {
        break label369;
      }
      paramRecordConfigProvider = null;
      label85:
      this.peV = new com.tencent.mm.compatible.util.b(paramRecordConfigProvider);
      paramRecordConfigProvider = this.peV;
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.requestFocus();
      }
      paramRecordConfigProvider = this.UrD;
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.setVisibility(0);
      }
      paramRecordConfigProvider = this.UrD;
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.setPlayerCallback((a.a.a)this.UrF);
      }
      this.startTime = paramb.startTime;
      this.endTime = paramb.endTime;
      paramb = this.NKK;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      paramb = this.NKK;
      if ((paramb != null) && (WeChatEnvironment.hasDebugger())) {
        i.au(new c..ExternalSyntheticLambda0(this, paramb));
      }
      paramb = this.UrE;
      if (paramb != null) {
        break label377;
      }
    }
    label369:
    label377:
    for (paramb = localObject;; paramb = paramb.TYA)
    {
      this.TYA = paramb;
      paramb = (View)this.UrD;
      if (paramb != null) {
        paramb.setAlpha(0.0F);
      }
      paramb = this.UrD;
      if (paramb != null)
      {
        paramRecordConfigProvider = this.TYA;
        s.checkNotNull(paramRecordConfigProvider);
        paramb.a(paramRecordConfigProvider.getComposition());
      }
      paramb = new Bundle();
      if (this.endTime - this.startTime > this.NKM + 750) {
        paramb.putBoolean("PARAM_VIDEO_NEED_CROP", true);
      }
      this.GrC.a(a.c.NOR, paramb);
      if (this.endTime - this.startTime > this.NKM + 750)
      {
        this.endTime = (this.NKM + 250);
        a.b.a(this.GrC, a.c.NOI);
      }
      AppMethodBeat.o(281953);
      return;
      i = paramRecordConfigProvider.NHZ;
      break;
      paramRecordConfigProvider = paramRecordConfigProvider.getContext();
      break label85;
    }
  }
  
  final ViewGroup gIE()
  {
    AppMethodBeat.i(282009);
    Object localObject = this.UrD;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((VideoCompositionPlayView)localObject).getParent())
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(282009);
      return localObject;
    }
  }
  
  public final void hSS()
  {
    AppMethodBeat.i(281980);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "videoPause");
    Object localObject = this.peV;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).aPS();
    }
    localObject = this.UrD;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).pause();
    }
    AppMethodBeat.o(281980);
  }
  
  public final String name()
  {
    AppMethodBeat.i(282020);
    String str = v.a.b(this);
    AppMethodBeat.o(282020);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(282024);
    s.u(this, "this");
    AppMethodBeat.o(282024);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282032);
    s.u(this, "this");
    AppMethodBeat.o(282032);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281992);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onDetach");
    View localView = (View)this.UrD;
    if (localView != null) {
      localView.setAlpha(0.0F);
    }
    AppMethodBeat.o(281992);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281964);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onPause");
    Object localObject = this.peV;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).aPS();
    }
    localObject = this.UrD;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).pause();
    }
    AppMethodBeat.o(281964);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(282035);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(282035);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281959);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onResume");
    if (this.UrD != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.UrD;
      s.checkNotNull(localVideoCompositionPlayView);
      if (!localVideoCompositionPlayView.isPlaying())
      {
        localVideoCompositionPlayView = this.UrD;
        s.checkNotNull(localVideoCompositionPlayView);
        localVideoCompositionPlayView.resume();
      }
    }
    AppMethodBeat.o(281959);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281972);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onRelease");
    if (this.UrD != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.UrD;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.UrD = null;
    }
    AppMethodBeat.o(281972);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281986);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "reset");
    com.tencent.mm.compatible.util.b localb = this.peV;
    if (localb != null) {
      localb.aPS();
    }
    AppMethodBeat.o(281986);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(281944);
    Object localObject = this.UrD;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).setVisibility(paramInt);
    }
    localObject = this.NKK;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    AppMethodBeat.o(281944);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.a.b
  {
    c(c paramc) {}
    
    public final void fiA()
    {
      AppMethodBeat.i(281912);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "videoView on FirstFrame");
      AppMethodBeat.o(281912);
    }
    
    public final void fiB()
    {
      AppMethodBeat.i(281904);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on error");
      AppMethodBeat.o(281904);
    }
    
    public final void fiC()
    {
      AppMethodBeat.i(281934);
      if (c.b(this.UrG))
      {
        Log.i("MicroMsg.EditVideoPreviewPlugin", "video on First Frame");
        c.c(this.UrG);
        View localView = (View)this.UrG.UrD;
        if (localView != null) {
          localView.setAlpha(1.0F);
        }
        a.b.a(this.UrG.GrC, a.c.NOk);
      }
      AppMethodBeat.o(281934);
    }
    
    public final void fix()
    {
      AppMethodBeat.i(281923);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on start");
      AppMethodBeat.o(281923);
    }
    
    public final void fiy()
    {
      AppMethodBeat.i(281927);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on stop");
      AppMethodBeat.o(281927);
    }
    
    public final void fiz()
    {
      AppMethodBeat.i(281898);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on completed");
      AppMethodBeat.o(281898);
    }
    
    public final void qT(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.c
 * JD-Core Version:    0.7.0.1
 */