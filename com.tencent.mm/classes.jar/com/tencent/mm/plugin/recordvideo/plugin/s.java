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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.model.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s
  implements t
{
  public static final s.a BRi;
  public com.tencent.mm.media.widget.camerarecordview.b.b BQt;
  private long BRa;
  public int BRb;
  public boolean BRc;
  public boolean BRd;
  private int BRe;
  private long BRf;
  public final d BRg;
  public final TextView BRh;
  public Context context;
  public int dvv;
  public int iqg;
  public com.tencent.mm.compatible.util.b jvG;
  public VideoPlayerTextureView zyd;
  
  static
  {
    AppMethodBeat.i(75607);
    BRi = new s.a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public s(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.zyd = paramVideoPlayerTextureView;
    this.BRh = paramTextView;
    this.context = this.zyd.getContext();
    this.BRa = -1L;
    this.BRb = 10000;
    this.BRe = 333;
    this.BRg = new d(this, paramd);
    AppMethodBeat.o(75606);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(75604);
    release();
    AppMethodBeat.o(75604);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75601);
    Log.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    com.tencent.mm.compatible.util.b localb = this.jvG;
    if (localb != null) {
      localb.apm();
    }
    this.zyd.pause();
    AppMethodBeat.o(75601);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237300);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237300);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    Log.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    if (!this.zyd.isPlaying())
    {
      com.tencent.mm.compatible.util.b localb = this.jvG;
      if (localb != null) {
        localb.requestFocus();
      }
      this.zyd.start();
    }
    AppMethodBeat.o(75600);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.jvG;
    if (localb != null) {
      localb.apm();
    }
    this.zyd.stop();
    this.zyd.setVideoCallback(null);
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.jvG;
    if (localb != null) {
      localb.apm();
    }
    this.zyd.stop();
    this.zyd.setVideoCallback(null);
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    this.zyd.setVisibility(paramInt);
    TextView localTextView = this.BRh;
    if (localTextView != null)
    {
      localTextView.setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  public final void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
    this.BRc = false;
    Object localObject = this.zyd.getParent();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75605);
      throw ((Throwable)localObject);
    }
    localObject = ((ViewGroup)localObject).animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F);
    p.g(localObject, "(videoPlayView.parent as…eY(1.0f).translationY(0f)");
    ((ViewPropertyAnimator)localObject).setDuration(300L);
    if (!paramBoolean)
    {
      this.dvv = 0;
      localObject = this.BQt;
      if (localObject == null) {
        break label112;
      }
    }
    label112:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqg;; i = 10000)
    {
      this.iqg = i;
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(75588);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(75588);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75587);
      p.h(paramAnimator, "animation");
      paramAnimator = this.BRj.zyd.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(75587);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).requestLayout();
      AppMethodBeat.o(75587);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(75589);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(75589);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(75586);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(75586);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      z.f localf = new z.f();
      Object localObject = s.a(this.BRj);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqd;; localObject = null)
      {
        localf.SYG = com.tencent.mm.plugin.mmsight.d.aFm((String)localObject);
        localObject = (String)localf.SYG;
        localf.SYG = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.SYG;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.ChY;
        localf.SYG = (com.tencent.mm.plugin.recordvideo.e.b.eME() + "\n");
        localObject = (String)localf.SYG;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        localb = com.tencent.mm.plugin.recordvideo.e.b.ChY;
        localf.SYG = (com.tencent.mm.plugin.recordvideo.e.b.eMF() + "\n");
        localObject = (String)localf.SYG;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        localb = com.tencent.mm.plugin.recordvideo.e.b.ChY;
        localf.SYG = (com.tencent.mm.plugin.recordvideo.e.b.eMG() + "\n");
        if (!Util.isNullOrNil((String)localf.SYG)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = g.aAh();
        p.g(localObject, "storage()");
        if (((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.NYY, 0) != 1)
        {
          AppMethodBeat.o(75591);
          return;
        }
      }
      MMHandlerThread.postToMainThread((Runnable)new s.c.1(this, localf));
      AppMethodBeat.o(75591);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements j.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final void eo(int paramInt1, int paramInt2) {}
    
    public final int fh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75598);
      if ((s.d(this.BRj) <= 0L) || (Util.ticksToNow(s.d(this.BRj)) >= 1000L))
      {
        Log.d("MicroMsg.EditVideoPlayPlugin", " " + this.BRj.zyd.isPlaying() + " videoPlayView.currentPosition: " + this.BRj.zyd.getCurrentPosition() + " + " + this.BRj.iqg);
        s.a(this.BRj, Util.currentTicks());
      }
      Bundle localBundle;
      if (this.BRj.zyd.isPlaying())
      {
        if ((this.BRj.zyd.getCurrentPosition() >= this.BRj.iqg) && (this.BRj.iqg < this.BRj.zyd.getDuration()))
        {
          Log.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.BRj.zyd.getCurrentPosition() + " reach endTime:" + this.BRj.iqg + ", seekTo startTime:" + this.BRj.dvv + ", isClipMode:" + s.f(this.BRj));
          this.BRj.zyd.d(this.BRj.dvv, true);
        }
        if (!s.f(this.BRj)) {
          break label308;
        }
        localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.BRj.zyd.getCurrentPosition());
        paramd.a(d.c.BVq, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        label308:
        if (System.currentTimeMillis() - s.h(this.BRj) >= s.g(this.BRj))
        {
          localBundle = new Bundle();
          localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.BRj.zyd.getCurrentPosition());
          paramd.a(d.c.BVq, localBundle);
        }
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      Log.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.BRj.dvv);
      this.BRj.zyd.d(this.BRj.dvv, true);
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      Log.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void tf()
    {
      AppMethodBeat.i(75596);
      Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (s.b(this.BRj))
      {
        au.az(s.c(this.BRj));
        localObject = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        localObject = com.tencent.mm.plugin.recordvideo.background.e.eIS();
        a locala = a.BOO;
        int i = a.eJO();
        locala = a.BOO;
        ((Rect)localObject).set(new Rect(0, 0, i, a.getDisplayHeight()));
      }
      for (;;)
      {
        s.a(this.BRj, -1L);
        this.BRj.zyd.start();
        this.BRj.zyd.setLoop(true);
        this.BRj.zyd.setOneTimeVideoTextureUpdateCallback((j.e)new b(this));
        localObject = new Bundle();
        if (this.BRj.iqg - this.BRj.dvv > s.e(this.BRj) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.BVx, (Bundle)localObject);
        if (this.BRj.iqg - this.BRj.dvv > s.e(this.BRj) + 750)
        {
          this.BRj.iqg = (s.e(this.BRj) + 250);
          d.b.a(paramd, d.c.BVo);
        }
        AppMethodBeat.o(75596);
        return;
        this.BRj.zyd.invalidate();
        this.BRj.zyd.post((Runnable)new a(this));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(75592);
        Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.BRn.BRj.zyd.getLeft() + " t:" + this.BRn.BRj.zyd.getTop() + " r:" + this.BRn.BRj.zyd.getRight() + " b:" + this.BRn.BRj.zyd.getBottom());
        com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        com.tencent.mm.plugin.recordvideo.background.e.eIS().set(new Rect(this.BRn.BRj.zyd.getLeft(), this.BRn.BRj.zyd.getTop(), this.BRn.BRj.zyd.getRight(), this.BRn.BRj.zyd.getBottom()));
        AppMethodBeat.o(75592);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements j.e
    {
      b(s.d paramd) {}
      
      public final void bLh()
      {
        AppMethodBeat.i(75594);
        MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            Log.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            this.BRo.BRn.BRj.zyd.setAlpha(1.0F);
            d.b.a(this.BRo.BRn.BQQ, d.c.BUR);
            AppMethodBeat.o(75593);
          }
        }, 10L);
        AppMethodBeat.o(75594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */