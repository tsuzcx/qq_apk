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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s
  implements t
{
  public static final s.a xRl;
  public Context context;
  public int dez;
  public int hwE;
  public com.tencent.mm.compatible.util.b iAr;
  public VideoPlayerTextureView wdv;
  public com.tencent.mm.media.widget.camerarecordview.b.b xQs;
  private long xRd;
  public int xRe;
  public boolean xRf;
  public boolean xRg;
  private int xRh;
  private long xRi;
  public final d xRj;
  public final TextView xRk;
  
  static
  {
    AppMethodBeat.i(75607);
    xRl = new s.a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public s(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.wdv = paramVideoPlayerTextureView;
    this.xRk = paramTextView;
    this.context = this.wdv.getContext();
    this.xRd = -1L;
    this.xRe = 10000;
    this.xRh = 333;
    this.xRj = new d(this, paramd);
    AppMethodBeat.o(75606);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
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
    ae.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    com.tencent.mm.compatible.util.b localb = this.iAr;
    if (localb != null) {
      localb.abn();
    }
    this.wdv.pause();
    AppMethodBeat.o(75601);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206584);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206584);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    ae.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    if (!this.wdv.isPlaying())
    {
      com.tencent.mm.compatible.util.b localb = this.iAr;
      if (localb != null) {
        localb.requestFocus();
      }
      this.wdv.start();
    }
    AppMethodBeat.o(75600);
  }
  
  public final void pR(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
    this.xRf = false;
    Object localObject = this.wdv.getParent();
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
      this.dez = 0;
      localObject = this.xQs;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwE;; i = 10000)
    {
      this.hwE = i;
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    ae.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.iAr;
    if (localb != null) {
      localb.abn();
    }
    this.wdv.stop();
    this.wdv.setVideoCallback(null);
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    ae.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.iAr;
    if (localb != null) {
      localb.abn();
    }
    this.wdv.stop();
    this.wdv.setVideoCallback(null);
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    this.wdv.setVisibility(paramInt);
    TextView localTextView = this.xRk;
    if (localTextView != null)
    {
      localTextView.setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
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
      paramAnimator = this.xRm.wdv.getParent();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      final y.f localf = new y.f();
      Object localObject = s.a(this.xRm);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwB;; localObject = null)
      {
        localf.NiY = com.tencent.mm.plugin.mmsight.d.arR((String)localObject);
        localObject = (String)localf.NiY;
        localf.NiY = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.NiY;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        com.tencent.mm.plugin.recordvideo.e.a locala = com.tencent.mm.plugin.recordvideo.e.a.yha;
        localf.NiY = (com.tencent.mm.plugin.recordvideo.e.a.dLG() + "\n");
        localObject = (String)localf.NiY;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.yha;
        localf.NiY = (com.tencent.mm.plugin.recordvideo.e.a.dLH() + "\n");
        localObject = (String)localf.NiY;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        locala = com.tencent.mm.plugin.recordvideo.e.a.yha;
        localf.NiY = (com.tencent.mm.plugin.recordvideo.e.a.dLI() + "\n");
        if (!bu.isNullOrNil((String)localf.NiY)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (ak.coh())
      {
        localObject = g.ajR();
        p.g(localObject, "storage()");
        if (((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.IQW, 0) != 1)
        {
          AppMethodBeat.o(75591);
          return;
        }
      }
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75590);
          ae.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)localf.NiY });
          this.xRo.xRn.setVisibility(0);
          this.xRo.xRn.setText((CharSequence)localf.NiY);
          AppMethodBeat.o(75590);
        }
      });
      AppMethodBeat.o(75591);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements h.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final int eU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75598);
      if ((s.d(this.xRm) <= 0L) || (bu.aO(s.d(this.xRm)) >= 1000L))
      {
        ae.d("MicroMsg.EditVideoPlayPlugin", " " + this.xRm.wdv.isPlaying() + " videoPlayView.currentPosition: " + this.xRm.wdv.getCurrentPosition() + " + " + this.xRm.hwE);
        s.a(this.xRm, bu.HQ());
      }
      Bundle localBundle;
      if (this.xRm.wdv.isPlaying())
      {
        if ((this.xRm.wdv.getCurrentPosition() >= this.xRm.hwE) && (this.xRm.hwE < this.xRm.wdv.getDuration()))
        {
          ae.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.xRm.wdv.getCurrentPosition() + " reach endTime:" + this.xRm.hwE + ", seekTo startTime:" + this.xRm.dez + ", isClipMode:" + s.f(this.xRm));
          this.xRm.wdv.d(this.xRm.dez, true);
        }
        if (!s.f(this.xRm)) {
          break label308;
        }
        localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.xRm.wdv.getCurrentPosition());
        paramd.a(d.c.xUM, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        label308:
        if (System.currentTimeMillis() - s.h(this.xRm) >= s.g(this.xRm))
        {
          localBundle = new Bundle();
          localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.xRm.wdv.getCurrentPosition());
          paramd.a(d.c.xUM, localBundle);
        }
      }
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      ae.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.xRm.dez);
      this.xRm.wdv.d(this.xRm.dez, true);
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      ae.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(75596);
      ae.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (s.b(this.xRm))
      {
        com.tencent.mm.ui.ar.ck(s.c(this.xRm));
        localObject = com.tencent.mm.plugin.recordvideo.background.e.xKl;
        localObject = com.tencent.mm.plugin.recordvideo.background.e.dIf();
        com.tencent.mm.plugin.recordvideo.model.a locala = com.tencent.mm.plugin.recordvideo.model.a.xON;
        int i = com.tencent.mm.plugin.recordvideo.model.a.dJb();
        locala = com.tencent.mm.plugin.recordvideo.model.a.xON;
        ((Rect)localObject).set(new Rect(0, 0, i, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
      }
      for (;;)
      {
        s.a(this.xRm, -1L);
        this.xRm.wdv.start();
        this.xRm.wdv.setLoop(true);
        this.xRm.wdv.setOneTimeVideoTextureUpdateCallback((h.e)new b(this));
        localObject = new Bundle();
        if (this.xRm.hwE - this.xRm.dez > s.e(this.xRm) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.xUS, (Bundle)localObject);
        if (this.xRm.hwE - this.xRm.dez > s.e(this.xRm) + 750)
        {
          this.xRm.hwE = (s.e(this.xRm) + 250);
          d.b.a(paramd, d.c.xUK);
        }
        AppMethodBeat.o(75596);
        return;
        this.xRm.wdv.invalidate();
        this.xRm.wdv.post((Runnable)new a(this));
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(75592);
        ae.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.xRq.xRm.wdv.getLeft() + " t:" + this.xRq.xRm.wdv.getTop() + " r:" + this.xRq.xRm.wdv.getRight() + " b:" + this.xRq.xRm.wdv.getBottom());
        com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xKl;
        com.tencent.mm.plugin.recordvideo.background.e.dIf().set(new Rect(this.xRq.xRm.wdv.getLeft(), this.xRq.xRm.wdv.getTop(), this.xRq.xRm.wdv.getRight(), this.xRq.xRm.wdv.getBottom()));
        AppMethodBeat.o(75592);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements h.e
    {
      b(s.d paramd) {}
      
      public final void bpD()
      {
        AppMethodBeat.i(75594);
        com.tencent.mm.sdk.platformtools.ar.o((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            ae.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            this.xRr.xRq.xRm.wdv.setAlpha(1.0F);
            d.b.a(this.xRr.xRq.xQT, d.c.xUp);
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