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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s
  implements t
{
  public static final s.a wtq;
  public int cSh;
  public Context context;
  public int hbI;
  public com.tencent.mm.compatible.util.b ied;
  public com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  public VideoPlayerTextureView uOi;
  private long wti;
  public int wtj;
  public boolean wtk;
  public boolean wtl;
  private int wtm;
  private long wtn;
  public final d wto;
  public final TextView wtp;
  
  static
  {
    AppMethodBeat.i(75607);
    wtq = new s.a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public s(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.uOi = paramVideoPlayerTextureView;
    this.wtp = paramTextView;
    this.context = this.uOi.getContext();
    this.wti = -1L;
    this.wtj = 10000;
    this.wtm = 333;
    this.wto = new d(this, paramd);
    AppMethodBeat.o(75606);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(75604);
    release();
    AppMethodBeat.o(75604);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75601);
    ac.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    com.tencent.mm.compatible.util.b localb = this.ied;
    if (localb != null) {
      localb.YC();
    }
    this.uOi.pause();
    AppMethodBeat.o(75601);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    ac.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    com.tencent.mm.compatible.util.b localb = this.ied;
    if (localb != null) {
      localb.requestFocus();
    }
    this.uOi.start();
    AppMethodBeat.o(75600);
  }
  
  public final void pm(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
    this.wtk = false;
    Object localObject = this.uOi.getParent();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75605);
      throw ((Throwable)localObject);
    }
    localObject = ((ViewGroup)localObject).animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F);
    k.g(localObject, "(videoPlayView.parent as…eY(1.0f).translationY(0f)");
    ((ViewPropertyAnimator)localObject).setDuration(300L);
    if (!paramBoolean)
    {
      this.cSh = 0;
      localObject = this.sgm;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbI;; i = 10000)
    {
      this.hbI = i;
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    ac.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.ied;
    if (localb != null) {
      localb.YC();
    }
    this.uOi.stop();
    this.uOi.setVideoCallback(null);
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    ac.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.ied;
    if (localb != null) {
      localb.YC();
    }
    this.uOi.stop();
    this.uOi.setVideoCallback(null);
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    this.uOi.setVisibility(paramInt);
    TextView localTextView = this.wtp;
    if (localTextView != null)
    {
      localTextView.setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(75588);
      k.h(paramAnimator, "animation");
      AppMethodBeat.o(75588);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75587);
      k.h(paramAnimator, "animation");
      paramAnimator = this.wtr.uOi.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(75587);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).requestLayout();
      AppMethodBeat.o(75587);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(75589);
      k.h(paramAnimator, "animation");
      AppMethodBeat.o(75589);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(75586);
      k.h(paramAnimator, "animation");
      AppMethodBeat.o(75586);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      final v.f localf = new v.f();
      Object localObject = s.a(this.wtr);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbF;; localObject = null)
      {
        localf.KUQ = com.tencent.mm.plugin.mmsight.d.alX((String)localObject);
        localObject = (String)localf.KUQ;
        localf.KUQ = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.KUQ;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.a locala = com.tencent.mm.plugin.recordvideo.e.a.wDA;
        localf.KUQ = (com.tencent.mm.plugin.recordvideo.e.a.dwX() + "\n");
        localObject = (String)localf.KUQ;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.wDA;
        localf.KUQ = (com.tencent.mm.plugin.recordvideo.e.a.dwY() + "\n");
        localObject = (String)localf.KUQ;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.wDA;
        localf.KUQ = (com.tencent.mm.plugin.recordvideo.e.a.dwZ() + "\n");
        if (!bs.isNullOrNil((String)localf.KUQ)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (ai.cin())
      {
        localObject = com.tencent.mm.kernel.g.agR();
        k.g(localObject, "storage()");
        if (((e)localObject).agA().getInt(ah.a.GKg, 0) != 1)
        {
          AppMethodBeat.o(75591);
          return;
        }
      }
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75590);
          ac.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)localf.KUQ });
          this.wtt.wts.setVisibility(0);
          this.wtt.wts.setText((CharSequence)localf.KUQ);
          AppMethodBeat.o(75590);
        }
      });
      AppMethodBeat.o(75591);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements h.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final void dZ(int paramInt1, int paramInt2) {}
    
    public final int eP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75598);
      if ((s.d(this.wtr) <= 0L) || (bs.aO(s.d(this.wtr)) >= 1000L))
      {
        ac.d("MicroMsg.EditVideoPlayPlugin", " " + this.wtr.uOi.isPlaying() + " videoPlayView.currentPosition: " + this.wtr.uOi.getCurrentPosition() + " + " + this.wtr.hbI);
        s.a(this.wtr, bs.Gn());
      }
      Bundle localBundle;
      if (this.wtr.uOi.isPlaying())
      {
        if ((this.wtr.uOi.getCurrentPosition() >= this.wtr.hbI) && (this.wtr.hbI < this.wtr.uOi.getDuration()))
        {
          ac.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.wtr.uOi.getCurrentPosition() + " reach endTime:" + this.wtr.hbI + ", seekTo startTime:" + this.wtr.cSh + ", isClipMode:" + s.f(this.wtr));
          this.wtr.uOi.d(this.wtr.cSh, true);
        }
        if (!s.f(this.wtr)) {
          break label308;
        }
        localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.wtr.uOi.getCurrentPosition());
        paramd.a(d.c.wwI, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        label308:
        if (System.currentTimeMillis() - s.h(this.wtr) >= s.g(this.wtr))
        {
          localBundle = new Bundle();
          localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.wtr.uOi.getCurrentPosition());
          paramd.a(d.c.wwI, localBundle);
        }
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      ac.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.wtr.cSh);
      this.wtr.uOi.d(this.wtr.cSh, true);
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      ac.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void rB()
    {
      AppMethodBeat.i(75596);
      ac.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (s.b(this.wtr))
      {
        com.tencent.mm.ui.ap.cl(s.c(this.wtr));
        localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        localObject = com.tencent.mm.plugin.recordvideo.background.g.dus();
        com.tencent.mm.plugin.recordvideo.model.a locala = com.tencent.mm.plugin.recordvideo.model.a.wra;
        int i = com.tencent.mm.plugin.recordvideo.model.a.dvp();
        locala = com.tencent.mm.plugin.recordvideo.model.a.wra;
        ((Rect)localObject).set(new Rect(0, 0, i, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
      }
      for (;;)
      {
        s.a(this.wtr, -1L);
        this.wtr.uOi.start();
        this.wtr.uOi.setLoop(true);
        this.wtr.uOi.setOneTimeVideoTextureUpdateCallback((h.e)new b(this));
        localObject = new Bundle();
        if (this.wtr.hbI - this.wtr.cSh > s.e(this.wtr) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.wwO, (Bundle)localObject);
        if (this.wtr.hbI - this.wtr.cSh > s.e(this.wtr) + 750)
        {
          this.wtr.hbI = (s.e(this.wtr) + 250);
          d.b.a(paramd, d.c.wwG);
        }
        AppMethodBeat.o(75596);
        return;
        this.wtr.uOi.invalidate();
        this.wtr.uOi.post((Runnable)new a(this));
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(75592);
        ac.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.wtv.wtr.uOi.getLeft() + " t:" + this.wtv.wtr.uOi.getTop() + " r:" + this.wtv.wtr.uOi.getRight() + " b:" + this.wtv.wtr.uOi.getBottom());
        com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        com.tencent.mm.plugin.recordvideo.background.g.dus().set(new Rect(this.wtv.wtr.uOi.getLeft(), this.wtv.wtr.uOi.getTop(), this.wtv.wtr.uOi.getRight(), this.wtv.wtr.uOi.getBottom()));
        AppMethodBeat.o(75592);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements h.e
    {
      b(s.d paramd) {}
      
      public final void bli()
      {
        AppMethodBeat.i(75594);
        com.tencent.mm.sdk.platformtools.ap.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            ac.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            this.wtw.wtv.wtr.uOi.setAlpha(1.0F);
            d.b.a(this.wtw.wtv.wsY, d.c.wwm);
            AppMethodBeat.o(75593);
          }
        }, 10L);
        AppMethodBeat.o(75594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */