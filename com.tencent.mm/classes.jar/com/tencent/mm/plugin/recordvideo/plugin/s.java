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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s
  implements t
{
  public static final s.a xBq;
  public Context context;
  public int ddx;
  public int htQ;
  public com.tencent.mm.compatible.util.b ixy;
  public VideoPlayerTextureView vRr;
  public com.tencent.mm.media.widget.camerarecordview.b.b xAw;
  private long xBi;
  public int xBj;
  public boolean xBk;
  public boolean xBl;
  private int xBm;
  private long xBn;
  public final d xBo;
  public final TextView xBp;
  
  static
  {
    AppMethodBeat.i(75607);
    xBq = new s.a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public s(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.vRr = paramVideoPlayerTextureView;
    this.xBp = paramTextView;
    this.context = this.vRr.getContext();
    this.xBi = -1L;
    this.xBj = 10000;
    this.xBm = 333;
    this.xBo = new d(this, paramd);
    AppMethodBeat.o(75606);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
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
    com.tencent.mm.compatible.util.b localb = this.ixy;
    if (localb != null) {
      localb.abe();
    }
    this.vRr.pause();
    AppMethodBeat.o(75601);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200323);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200323);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    ad.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    if (!this.vRr.isPlaying())
    {
      com.tencent.mm.compatible.util.b localb = this.ixy;
      if (localb != null) {
        localb.requestFocus();
      }
      this.vRr.start();
    }
    AppMethodBeat.o(75600);
  }
  
  public final void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
    this.xBk = false;
    Object localObject = this.vRr.getParent();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75605);
      throw ((Throwable)localObject);
    }
    localObject = ((ViewGroup)localObject).animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F);
    p.g(localObject, "(videoPlayView.parent as…eY(1.0f).translationY(0f)");
    ((ViewPropertyAnimator)localObject).setDuration(300L);
    if (!paramBoolean)
    {
      this.ddx = 0;
      localObject = this.xAw;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htQ;; i = 10000)
    {
      this.htQ = i;
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    ad.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.ixy;
    if (localb != null) {
      localb.abe();
    }
    this.vRr.stop();
    this.vRr.setVideoCallback(null);
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    ad.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.ixy;
    if (localb != null) {
      localb.abe();
    }
    this.vRr.stop();
    this.vRr.setVideoCallback(null);
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    this.vRr.setVisibility(paramInt);
    TextView localTextView = this.xBp;
    if (localTextView != null)
    {
      localTextView.setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
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
      paramAnimator = this.xBr.vRr.getParent();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      final y.f localf = new y.f();
      Object localObject = s.a(this.xBr);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htN;; localObject = null)
      {
        localf.MLV = com.tencent.mm.plugin.mmsight.d.aqM((String)localObject);
        localObject = (String)localf.MLV;
        localf.MLV = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.MLV;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.a locala = com.tencent.mm.plugin.recordvideo.e.a.xRh;
        localf.MLV = (com.tencent.mm.plugin.recordvideo.e.a.dIp() + "\n");
        localObject = (String)localf.MLV;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.xRh;
        localf.MLV = (com.tencent.mm.plugin.recordvideo.e.a.dIq() + "\n");
        localObject = (String)localf.MLV;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.xRh;
        localf.MLV = (com.tencent.mm.plugin.recordvideo.e.a.dIr() + "\n");
        if (!bt.isNullOrNil((String)localf.MLV)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (aj.cmR())
      {
        localObject = g.ajC();
        p.g(localObject, "storage()");
        if (((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.Iwy, 0) != 1)
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
          ad.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)localf.MLV });
          this.xBt.xBs.setVisibility(0);
          this.xBt.xBs.setText((CharSequence)localf.MLV);
          AppMethodBeat.o(75590);
        }
      });
      AppMethodBeat.o(75591);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements h.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final int eT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75598);
      if ((s.d(this.xBr) <= 0L) || (bt.aO(s.d(this.xBr)) >= 1000L))
      {
        ad.d("MicroMsg.EditVideoPlayPlugin", " " + this.xBr.vRr.isPlaying() + " videoPlayView.currentPosition: " + this.xBr.vRr.getCurrentPosition() + " + " + this.xBr.htQ);
        s.a(this.xBr, bt.HI());
      }
      Bundle localBundle;
      if (this.xBr.vRr.isPlaying())
      {
        if ((this.xBr.vRr.getCurrentPosition() >= this.xBr.htQ) && (this.xBr.htQ < this.xBr.vRr.getDuration()))
        {
          ad.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.xBr.vRr.getCurrentPosition() + " reach endTime:" + this.xBr.htQ + ", seekTo startTime:" + this.xBr.ddx + ", isClipMode:" + s.f(this.xBr));
          this.xBr.vRr.d(this.xBr.ddx, true);
        }
        if (!s.f(this.xBr)) {
          break label308;
        }
        localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.xBr.vRr.getCurrentPosition());
        paramd.a(d.c.xER, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        label308:
        if (System.currentTimeMillis() - s.h(this.xBr) >= s.g(this.xBr))
        {
          localBundle = new Bundle();
          localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.xBr.vRr.getCurrentPosition());
          paramd.a(d.c.xER, localBundle);
        }
      }
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      ad.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.xBr.ddx);
      this.xBr.vRr.d(this.xBr.ddx, true);
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      ad.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(75596);
      ad.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (s.b(this.xBr))
      {
        ar.ci(s.c(this.xBr));
        localObject = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        localObject = com.tencent.mm.plugin.recordvideo.background.e.dEO();
        com.tencent.mm.plugin.recordvideo.model.a locala = com.tencent.mm.plugin.recordvideo.model.a.xyR;
        int i = com.tencent.mm.plugin.recordvideo.model.a.dFK();
        locala = com.tencent.mm.plugin.recordvideo.model.a.xyR;
        ((Rect)localObject).set(new Rect(0, 0, i, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
      }
      for (;;)
      {
        s.a(this.xBr, -1L);
        this.xBr.vRr.start();
        this.xBr.vRr.setLoop(true);
        this.xBr.vRr.setOneTimeVideoTextureUpdateCallback((h.e)new b(this));
        localObject = new Bundle();
        if (this.xBr.htQ - this.xBr.ddx > s.e(this.xBr) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.xEX, (Bundle)localObject);
        if (this.xBr.htQ - this.xBr.ddx > s.e(this.xBr) + 750)
        {
          this.xBr.htQ = (s.e(this.xBr) + 250);
          d.b.a(paramd, d.c.xEP);
        }
        AppMethodBeat.o(75596);
        return;
        this.xBr.vRr.invalidate();
        this.xBr.vRr.post((Runnable)new a(this));
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(75592);
        ad.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.xBv.xBr.vRr.getLeft() + " t:" + this.xBv.xBr.vRr.getTop() + " r:" + this.xBv.xBr.vRr.getRight() + " b:" + this.xBv.xBr.vRr.getBottom());
        com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        com.tencent.mm.plugin.recordvideo.background.e.dEO().set(new Rect(this.xBv.xBr.vRr.getLeft(), this.xBv.xBr.vRr.getTop(), this.xBv.xBr.vRr.getRight(), this.xBv.xBr.vRr.getBottom()));
        AppMethodBeat.o(75592);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements h.e
    {
      b(s.d paramd) {}
      
      public final void boT()
      {
        AppMethodBeat.i(75594);
        aq.o((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            ad.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            this.xBw.xBv.xBr.vRr.setAlpha(1.0F);
            d.b.a(this.xBw.xBv.xAY, d.c.xEu);
            AppMethodBeat.o(75593);
          }
        }, 10L);
        AppMethodBeat.o(75594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */