package com.tencent.mm.plugin.vlog.ui.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;Landroid/content/Context;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "firstFrame", "", "isClipMode", "maxRecordTime", "mediaModel", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "startTime", "getStartTime", "setStartTime", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoCallback", "com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;)V", "getParentViewGroup", "Landroid/view/ViewGroup;", "gotoClipMode", "", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onPreViewVideo", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onResume", "release", "releaseVideo", "reset", "seek", "start", "setMediaModel", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "stopPreview", "videoPause", "videoResume", "Companion", "plugin-vlog_release"})
public final class c
  implements u
{
  public static final a NFw;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  int HNQ;
  boolean HNR;
  final TextView HNV;
  com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  e NFt;
  final d NFu;
  VideoCompositionPlayView NFv;
  ac Nlb;
  Context context;
  int endTime;
  int fod;
  com.tencent.mm.compatible.util.b mlj;
  boolean vcc;
  
  static
  {
    AppMethodBeat.i(233908);
    NFw = new a((byte)0);
    AppMethodBeat.o(233908);
  }
  
  public c(VideoCompositionPlayView paramVideoCompositionPlayView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView, Context paramContext)
  {
    AppMethodBeat.i(233905);
    this.NFv = paramVideoCompositionPlayView;
    this.APl = paramd;
    this.HNV = paramTextView;
    this.context = paramContext;
    this.HNQ = 10000;
    this.vcc = true;
    this.NFu = new d(this);
    AppMethodBeat.o(233905);
  }
  
  public final void bbp() {}
  
  final ViewGroup fwW()
  {
    AppMethodBeat.i(233903);
    Object localObject = this.NFv;
    if (localObject != null) {}
    for (localObject = ((VideoCompositionPlayView)localObject).getParent();; localObject = null)
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(233903);
      return localObject;
    }
  }
  
  public final void gvc()
  {
    AppMethodBeat.i(233894);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "videoPause");
    Object localObject = this.mlj;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avz();
    }
    localObject = this.NFv;
    if (localObject != null)
    {
      ((VideoCompositionPlayView)localObject).pause();
      AppMethodBeat.o(233894);
      return;
    }
    AppMethodBeat.o(233894);
  }
  
  public final String name()
  {
    AppMethodBeat.i(233910);
    String str = getClass().getName();
    AppMethodBeat.o(233910);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(233898);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onDetach");
    View localView = (View)this.NFv;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(233898);
      return;
    }
    AppMethodBeat.o(233898);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233892);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onPause");
    Object localObject = this.mlj;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avz();
    }
    localObject = this.NFv;
    if (localObject != null)
    {
      ((VideoCompositionPlayView)localObject).pause();
      AppMethodBeat.o(233892);
      return;
    }
    AppMethodBeat.o(233892);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(233911);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(233911);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233891);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onResume");
    if (this.NFv != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.NFv;
      if (localVideoCompositionPlayView == null) {
        p.iCn();
      }
      if (!localVideoCompositionPlayView.isPlaying())
      {
        localVideoCompositionPlayView = this.NFv;
        if (localVideoCompositionPlayView == null) {
          p.iCn();
        }
        localVideoCompositionPlayView.resume();
      }
    }
    AppMethodBeat.o(233891);
  }
  
  public final void release()
  {
    AppMethodBeat.i(233893);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "onRelease");
    if (this.NFv != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.NFv;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.NFv = null;
    }
    AppMethodBeat.o(233893);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(233896);
    Log.i("MicroMsg.EditVideoPreviewPlugin", "reset");
    com.tencent.mm.compatible.util.b localb = this.mlj;
    if (localb != null)
    {
      localb.avz();
      AppMethodBeat.o(233896);
      return;
    }
    AppMethodBeat.o(233896);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(233890);
    Object localObject = this.NFv;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).setVisibility(paramInt);
    }
    localObject = this.HNV;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(233890);
      return;
    }
    AppMethodBeat.o(233890);
  }
  
  public final void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(233900);
    this.HNR = false;
    Object localObject = fwW();
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).scaleX(1.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).scaleY(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).setDuration(300L);
            }
          }
        }
      }
    }
    if (!paramBoolean)
    {
      this.fod = 0;
      localObject = this.HNh;
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).endTime;; i = 10000)
    {
      this.endTime = i;
      AppMethodBeat.o(233900);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$Companion;", "", "()V", "TAG", "", "VIDEO_DURATION_TOLERANT_MS", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(252216);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(252216);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252214);
      p.k(paramAnimator, "animation");
      paramAnimator = c.a(this.NFx);
      if (paramAnimator != null)
      {
        paramAnimator.requestLayout();
        AppMethodBeat.o(252214);
        return;
      }
      AppMethodBeat.o(252214);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(252219);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(252219);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(252213);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(252213);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$showVideoDebugInfoIfNeed$1$1"})
  static final class c
    implements Runnable
  {
    c(TextView paramTextView, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(244252);
      final aa.f localf = new aa.f();
      Object localObject = c.b(this.NFx);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfj;; localObject = null)
      {
        localf.aaBC = com.tencent.mm.plugin.mmsight.d.aPw((String)localObject);
        localObject = (String)localf.aaBC;
        localf.aaBC = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        localf.aaBC = (com.tencent.mm.plugin.recordvideo.e.c.aXG() + "\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        localc = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        localf.aaBC = (com.tencent.mm.plugin.recordvideo.e.c.fzr() + "\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        localc = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        localf.aaBC = (com.tencent.mm.plugin.recordvideo.e.c.fzs() + "\n");
        if (!Util.isNullOrNil((String)localf.aaBC)) {
          break;
        }
        AppMethodBeat.o(244252);
        return;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        if (((f)localObject).aHp().getInt(ar.a.VmY, 0) != 1)
        {
          AppMethodBeat.o(244252);
          return;
        }
      }
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248193);
          Log.i("MicroMsg.EditVideoPreviewPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)localf.aaBC });
          this.NFy.HNY.setVisibility(0);
          this.NFy.HNY.setText((CharSequence)localf.aaBC);
          AppMethodBeat.o(248193);
        }
      });
      AppMethodBeat.o(244252);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$videoCallback$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class d
    implements a.a.b
  {
    public final void Np(long paramLong) {}
    
    public final void egA()
    {
      AppMethodBeat.i(225755);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on start");
      AppMethodBeat.o(225755);
    }
    
    public final void egB()
    {
      AppMethodBeat.i(225756);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on stop");
      AppMethodBeat.o(225756);
    }
    
    public final void egC()
    {
      AppMethodBeat.i(225751);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on completed");
      AppMethodBeat.o(225751);
    }
    
    public final void egD()
    {
      AppMethodBeat.i(225753);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "videoView on FirstFrame");
      AppMethodBeat.o(225753);
    }
    
    public final void egE()
    {
      AppMethodBeat.i(225752);
      Log.i("MicroMsg.EditVideoPreviewPlugin", "video on error");
      AppMethodBeat.o(225752);
    }
    
    public final void egF()
    {
      AppMethodBeat.i(225757);
      if (c.c(this.NFx))
      {
        Log.i("MicroMsg.EditVideoPreviewPlugin", "video on First Frame");
        c.d(this.NFx);
        View localView = (View)this.NFx.NFv;
        if (localView != null) {
          localView.setAlpha(1.0F);
        }
        d.b.a(this.NFx.APl, d.c.HRE);
      }
      AppMethodBeat.o(225757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.c
 * JD-Core Version:    0.7.0.1
 */