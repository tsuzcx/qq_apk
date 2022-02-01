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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s
  implements t
{
  public static final a vkM;
  private int Lnf;
  private long Lng;
  public int cUL;
  public Context context;
  public int gBm;
  public com.tencent.mm.compatible.util.b hDB;
  public VideoPlayerTextureView tFN;
  public com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  private long vkG;
  public int vkH;
  public boolean vkI;
  public boolean vkJ;
  public final d vkK;
  public final TextView vkL;
  
  static
  {
    AppMethodBeat.i(75607);
    vkM = new a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public s(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.tFN = paramVideoPlayerTextureView;
    this.vkL = paramTextView;
    this.context = this.tFN.getContext();
    this.vkG = -1L;
    this.vkH = 10000;
    this.Lnf = 333;
    this.vkK = new d(this, paramd);
    AppMethodBeat.o(75606);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
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
    ad.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    com.tencent.mm.compatible.util.b localb = this.hDB;
    if (localb != null) {
      localb.XF();
    }
    this.tFN.pause();
    AppMethodBeat.o(75601);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    ad.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    com.tencent.mm.compatible.util.b localb = this.hDB;
    if (localb != null) {
      localb.requestFocus();
    }
    this.tFN.start();
    AppMethodBeat.o(75600);
  }
  
  public final void os(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
    this.vkI = false;
    Object localObject = this.tFN.getParent();
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
      this.cUL = 0;
      localObject = this.vjS;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBm;; i = 10000)
    {
      this.gBm = i;
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    ad.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.hDB;
    if (localb != null) {
      localb.XF();
    }
    this.tFN.stop();
    this.tFN.setVideoCallback(null);
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    ad.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.hDB;
    if (localb != null) {
      localb.XF();
    }
    this.tFN.stop();
    this.tFN.setVideoCallback(null);
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    this.tFN.setVisibility(paramInt);
    TextView localTextView = this.vkL;
    if (localTextView != null)
    {
      localTextView.setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$Companion;", "", "()V", "TAG", "", "VIDEO_DURATION_TOLERANT_MS", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
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
      paramAnimator = this.vkN.tFN.getParent();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      final v.e locale = new v.e();
      Object localObject = s.a(this.vkN);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBj;; localObject = null)
      {
        locale.Jhw = com.tencent.mm.plugin.mmsight.d.ahc((String)localObject);
        localObject = (String)locale.Jhw;
        locale.Jhw = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)locale.Jhw;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.a locala = com.tencent.mm.plugin.recordvideo.e.a.vtA;
        locale.Jhw = (com.tencent.mm.plugin.recordvideo.e.a.dja() + "\n");
        localObject = (String)locale.Jhw;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.vtA;
        locale.Jhw = (com.tencent.mm.plugin.recordvideo.e.a.djb() + "\n");
        localObject = (String)locale.Jhw;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.vtA;
        locale.Jhw = (com.tencent.mm.plugin.recordvideo.e.a.djc() + "\n");
        if (!bt.isNullOrNil((String)locale.Jhw)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (aj.cbe())
      {
        localObject = g.afB();
        k.g(localObject, "storage()");
        if (((e)localObject).afk().getInt(ae.a.Fmr, 0) != 1)
        {
          AppMethodBeat.o(75591);
          return;
        }
      }
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75590);
          ad.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)locale.Jhw });
          this.vkP.vkO.setVisibility(0);
          this.vkP.vkO.setText((CharSequence)locale.Jhw);
          AppMethodBeat.o(75590);
        }
      });
      AppMethodBeat.o(75591);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements h.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final void dY(int paramInt1, int paramInt2) {}
    
    public final int eM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75598);
      if ((s.d(this.vkN) <= 0L) || (bt.aS(s.d(this.vkN)) >= 1000L))
      {
        ad.d("MicroMsg.EditVideoPlayPlugin", " " + this.vkN.tFN.isPlaying() + " videoPlayView.currentPosition: " + this.vkN.tFN.getCurrentPosition() + " + " + this.vkN.gBm);
        s.a(this.vkN, bt.GC());
      }
      Bundle localBundle;
      if (this.vkN.tFN.isPlaying())
      {
        if ((this.vkN.tFN.getCurrentPosition() >= this.vkN.gBm) && (this.vkN.gBm < this.vkN.tFN.getDuration()))
        {
          ad.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.vkN.tFN.getCurrentPosition() + " reach endTime:" + this.vkN.gBm + ", seekTo startTime:" + this.vkN.cUL + ", isClipMode:" + s.f(this.vkN));
          this.vkN.tFN.d(this.vkN.cUL, true);
        }
        if (!s.f(this.vkN)) {
          break label308;
        }
        localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.vkN.tFN.getCurrentPosition());
        paramd.a(d.c.vob, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        label308:
        if (System.currentTimeMillis() - s.h(this.vkN) >= s.g(this.vkN))
        {
          localBundle = new Bundle();
          localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.vkN.tFN.getCurrentPosition());
          paramd.a(d.c.vob, localBundle);
        }
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      ad.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.vkN.cUL);
      this.vkN.tFN.d(this.vkN.cUL, true);
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      ad.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void rq()
    {
      AppMethodBeat.i(75596);
      ad.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (s.b(this.vkN))
      {
        ap.cf(s.c(this.vkN));
        localObject = f.vdH;
        localObject = f.dgK();
        com.tencent.mm.plugin.recordvideo.model.a locala = com.tencent.mm.plugin.recordvideo.model.a.viq;
        int i = com.tencent.mm.plugin.recordvideo.model.a.dhH();
        locala = com.tencent.mm.plugin.recordvideo.model.a.viq;
        ((Rect)localObject).set(new Rect(0, 0, i, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
      }
      for (;;)
      {
        s.a(this.vkN, -1L);
        this.vkN.tFN.start();
        this.vkN.tFN.setLoop(true);
        this.vkN.tFN.setOneTimeVideoTextureUpdateCallback((h.e)new b(this));
        localObject = new Bundle();
        if (this.vkN.gBm - this.vkN.cUL > s.e(this.vkN) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.voh, (Bundle)localObject);
        if (this.vkN.gBm - this.vkN.cUL > s.e(this.vkN) + 750)
        {
          this.vkN.gBm = (s.e(this.vkN) + 250);
          d.b.a(paramd, d.c.vnZ);
        }
        AppMethodBeat.o(75596);
        return;
        this.vkN.tFN.invalidate();
        this.vkN.tFN.post((Runnable)new a(this));
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(75592);
        ad.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.vkR.vkN.tFN.getLeft() + " t:" + this.vkR.vkN.tFN.getTop() + " r:" + this.vkR.vkN.tFN.getRight() + " b:" + this.vkR.vkN.tFN.getBottom());
        f localf = f.vdH;
        f.dgK().set(new Rect(this.vkR.vkN.tFN.getLeft(), this.vkR.vkN.tFN.getTop(), this.vkR.vkN.tFN.getRight(), this.vkR.vkN.tFN.getBottom()));
        AppMethodBeat.o(75592);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements h.e
    {
      b(s.d paramd) {}
      
      public final void beo()
      {
        AppMethodBeat.i(75594);
        aq.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            ad.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            this.vkS.vkR.vkN.tFN.setAlpha(1.0F);
            d.b.a(this.vkS.vkR.vkw, d.c.vnG);
            AppMethodBeat.o(75593);
          }
        }, 10L);
        AppMethodBeat.o(75594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */