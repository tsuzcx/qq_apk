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
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.model.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getParentViewGroup", "Landroid/view/ViewGroup;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class t
  implements u
{
  public static final a HNW;
  public boolean Awa;
  public VideoPlayerTextureView Fdy;
  private long HNP;
  public int HNQ;
  public boolean HNR;
  private int HNS;
  private long HNT;
  public final d HNU;
  public final TextView HNV;
  public com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  public Context context;
  public int endTime;
  public int fod;
  public com.tencent.mm.compatible.util.b mlj;
  
  static
  {
    AppMethodBeat.i(75607);
    HNW = new a((byte)0);
    AppMethodBeat.o(75607);
  }
  
  public t(VideoPlayerTextureView paramVideoPlayerTextureView, final com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(75606);
    this.Fdy = paramVideoPlayerTextureView;
    this.HNV = paramTextView;
    paramVideoPlayerTextureView = this.Fdy;
    if (paramVideoPlayerTextureView != null) {}
    for (paramVideoPlayerTextureView = paramVideoPlayerTextureView.getContext();; paramVideoPlayerTextureView = null)
    {
      this.context = paramVideoPlayerTextureView;
      this.HNP = -1L;
      this.HNQ = 10000;
      this.HNS = 333;
      this.HNU = new d(this, paramd);
      AppMethodBeat.o(75606);
      return;
    }
  }
  
  public final void bbp() {}
  
  public final ViewGroup fwW()
  {
    AppMethodBeat.i(225231);
    Object localObject = this.Fdy;
    if (localObject != null) {}
    for (localObject = ((VideoPlayerTextureView)localObject).getParent();; localObject = null)
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(225231);
      return localObject;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(225244);
    String str = getClass().getName();
    AppMethodBeat.o(225244);
    return str;
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
    Object localObject = this.mlj;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avz();
    }
    localObject = this.Fdy;
    if (localObject != null)
    {
      ((VideoPlayerTextureView)localObject).pause();
      AppMethodBeat.o(75601);
      return;
    }
    AppMethodBeat.o(75601);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225251);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(225251);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75600);
    Log.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    Object localObject = this.Fdy;
    if (localObject == null) {
      p.iCn();
    }
    if (!((VideoPlayerTextureView)localObject).isPlaying())
    {
      localObject = this.mlj;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).avy();
      }
      localObject = this.Fdy;
      if (localObject != null)
      {
        ((VideoPlayerTextureView)localObject).start();
        AppMethodBeat.o(75600);
        return;
      }
    }
    AppMethodBeat.o(75600);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75602);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    Object localObject = this.mlj;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avz();
    }
    localObject = this.Fdy;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).stop();
    }
    localObject = this.Fdy;
    if (localObject != null)
    {
      ((VideoPlayerTextureView)localObject).setVideoCallback(null);
      AppMethodBeat.o(75602);
      return;
    }
    AppMethodBeat.o(75602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75603);
    Log.i("MicroMsg.EditVideoPlayPlugin", "release");
    Object localObject = this.mlj;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avz();
    }
    localObject = this.Fdy;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).stop();
    }
    localObject = this.Fdy;
    if (localObject != null)
    {
      ((VideoPlayerTextureView)localObject).setVideoCallback(null);
      AppMethodBeat.o(75603);
      return;
    }
    AppMethodBeat.o(75603);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75599);
    Object localObject = this.Fdy;
    if (localObject != null) {
      ((VideoPlayerTextureView)localObject).setVisibility(paramInt);
    }
    localObject = this.HNV;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(75599);
      return;
    }
    AppMethodBeat.o(75599);
  }
  
  public final void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(75605);
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
      AppMethodBeat.o(75605);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$Companion;", "", "()V", "TAG", "", "VIDEO_DURATION_TOLERANT_MS", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(75588);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(75588);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75587);
      p.k(paramAnimator, "animation");
      paramAnimator = t.a(this.HNX);
      if (paramAnimator != null)
      {
        paramAnimator.requestLayout();
        AppMethodBeat.o(75587);
        return;
      }
      AppMethodBeat.o(75587);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(75589);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(75589);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(75586);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(75586);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
  public static final class c
    implements Runnable
  {
    public c(TextView paramTextView, t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75591);
      final aa.f localf = new aa.f();
      Object localObject = t.b(this.HNX);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfj;; localObject = null)
      {
        localf.aaBC = com.tencent.mm.plugin.mmsight.d.aPw((String)localObject);
        localObject = (String)localf.aaBC;
        localf.aaBC = ((String)localObject + "\n针对拍摄视频：\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("是否使用CPU预览裁剪方式：");
        c localc = c.IeQ;
        localf.aaBC = (c.aXG() + "\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("是否使用两路流录制：");
        localc = c.IeQ;
        localf.aaBC = (c.fzr() + "\n");
        localObject = (String)localf.aaBC;
        localObject = new StringBuilder().append((String)localObject).append("预览页视频个数：");
        localc = c.IeQ;
        localf.aaBC = (c.fzs() + "\n");
        if (!Util.isNullOrNil((String)localf.aaBC)) {
          break;
        }
        AppMethodBeat.o(75591);
        return;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = h.aHG();
        p.j(localObject, "storage()");
        if (((f)localObject).aHp().getInt(ar.a.VmY, 0) != 1)
        {
          AppMethodBeat.o(75591);
          return;
        }
      }
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75590);
          Log.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)localf.aaBC });
          this.HNZ.HNY.setVisibility(0);
          this.HNZ.HNY.setText((CharSequence)localf.aaBC);
          AppMethodBeat.o(75590);
        }
      });
      AppMethodBeat.o(75591);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
  public static final class d
    implements k.a
  {
    d(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd) {}
    
    public final void eM(int paramInt1, int paramInt2) {}
    
    public final int fE(int paramInt1, int paramInt2)
    {
      VideoPlayerTextureView localVideoPlayerTextureView1 = null;
      AppMethodBeat.i(75598);
      StringBuilder localStringBuilder;
      Object localObject;
      if ((t.e(this.HNX) <= 0L) || (Util.ticksToNow(t.e(this.HNX)) >= 1000L))
      {
        localStringBuilder = new StringBuilder(" ");
        localObject = this.HNX.Fdy;
        if (localObject != null)
        {
          localObject = Boolean.valueOf(((VideoPlayerTextureView)localObject).isPlaying());
          localStringBuilder = localStringBuilder.append(localObject).append(" videoPlayView.currentPosition: ");
          localObject = this.HNX.Fdy;
          if (localObject == null) {
            break label414;
          }
          localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getCurrentPosition());
          label101:
          Log.d("MicroMsg.EditVideoPlayPlugin", localObject + " + " + this.HNX.endTime);
          t.a(this.HNX, Util.currentTicks());
        }
      }
      else
      {
        localObject = this.HNX.Fdy;
        if (localObject == null) {
          p.iCn();
        }
        if (((VideoPlayerTextureView)localObject).isPlaying())
        {
          localObject = this.HNX.Fdy;
          if (localObject == null) {
            p.iCn();
          }
          if (((VideoPlayerTextureView)localObject).getCurrentPosition() >= this.HNX.endTime)
          {
            paramInt1 = this.HNX.endTime;
            localObject = this.HNX.Fdy;
            if (localObject == null) {
              p.iCn();
            }
            if (paramInt1 < ((VideoPlayerTextureView)localObject).getDuration())
            {
              localStringBuilder = new StringBuilder("currentPosition:");
              VideoPlayerTextureView localVideoPlayerTextureView2 = this.HNX.Fdy;
              localObject = localVideoPlayerTextureView1;
              if (localVideoPlayerTextureView2 != null) {
                localObject = Integer.valueOf(localVideoPlayerTextureView2.getCurrentPosition());
              }
              Log.i("MicroMsg.EditVideoPlayPlugin", localObject + " reach endTime:" + this.HNX.endTime + ", seekTo startTime:" + this.HNX.fod + ", isClipMode:" + t.g(this.HNX));
              localObject = this.HNX.Fdy;
              if (localObject != null) {
                ((VideoPlayerTextureView)localObject).b(this.HNX.fod, true);
              }
            }
          }
          if (!t.g(this.HNX)) {
            break label419;
          }
          localObject = new Bundle();
          localVideoPlayerTextureView1 = this.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", localVideoPlayerTextureView1.getCurrentPosition());
          paramd.a(d.c.HSe, (Bundle)localObject);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(75598);
        return 0;
        localObject = null;
        break;
        label414:
        localObject = null;
        break label101;
        label419:
        if (System.currentTimeMillis() - t.i(this.HNX) >= t.h(this.HNX))
        {
          localObject = new Bundle();
          localVideoPlayerTextureView1 = this.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", localVideoPlayerTextureView1.getCurrentPosition());
          paramd.a(d.c.HSe, (Bundle)localObject);
        }
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(75597);
      Log.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.HNX.fod);
      VideoPlayerTextureView localVideoPlayerTextureView = this.HNX.Fdy;
      if (localVideoPlayerTextureView != null)
      {
        localVideoPlayerTextureView.b(this.HNX.fod, true);
        AppMethodBeat.o(75597);
        return;
      }
      AppMethodBeat.o(75597);
    }
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75595);
      Log.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(75595);
    }
    
    public final void qX()
    {
      AppMethodBeat.i(75596);
      Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
      Object localObject;
      if (t.c(this.HNX))
      {
        ax.au(t.d(this.HNX));
        localObject = e.HGz;
        localObject = e.fuW();
        a locala = a.HLt;
        int i = a.fvZ();
        locala = a.HLt;
        ((Rect)localObject).set(new Rect(0, 0, i, a.getDisplayHeight()));
      }
      for (;;)
      {
        t.a(this.HNX, -1L);
        localObject = this.HNX.Fdy;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).start();
        }
        localObject = this.HNX.Fdy;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).setLoop(true);
        }
        localObject = this.HNX.Fdy;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).setOneTimeVideoTextureUpdateCallback((k.e)new b(this));
        }
        localObject = new Bundle();
        if (this.HNX.endTime - this.HNX.fod > t.f(this.HNX) + 750) {
          ((Bundle)localObject).putBoolean("PARAM_VIDEO_NEED_CROP", true);
        }
        paramd.a(d.c.HSl, (Bundle)localObject);
        if (this.HNX.endTime - this.HNX.fod > t.f(this.HNX) + 750)
        {
          this.HNX.endTime = (t.f(this.HNX) + 250);
          d.b.a(paramd, d.c.HSc);
        }
        AppMethodBeat.o(75596);
        return;
        localObject = this.HNX.Fdy;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).invalidate();
        }
        localObject = this.HNX.Fdy;
        if (localObject != null) {
          ((VideoPlayerTextureView)localObject).post((Runnable)new a(this));
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(t.d paramd) {}
      
      public final void run()
      {
        VideoPlayerTextureView localVideoPlayerTextureView1 = null;
        AppMethodBeat.i(75592);
        StringBuilder localStringBuilder = new StringBuilder("video onPrepared l:");
        Object localObject = this.HOb.HNX.Fdy;
        if (localObject != null)
        {
          localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getLeft());
          localStringBuilder = localStringBuilder.append(localObject).append(" t:");
          localObject = this.HOb.HNX.Fdy;
          if (localObject == null) {
            break label328;
          }
          localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getTop());
          label87:
          localStringBuilder = localStringBuilder.append(localObject).append(" r:");
          localObject = this.HOb.HNX.Fdy;
          if (localObject == null) {
            break label334;
          }
        }
        label328:
        label334:
        for (localObject = Integer.valueOf(((VideoPlayerTextureView)localObject).getRight());; localObject = null)
        {
          localStringBuilder = localStringBuilder.append(localObject).append(" b:");
          VideoPlayerTextureView localVideoPlayerTextureView2 = this.HOb.HNX.Fdy;
          localObject = localVideoPlayerTextureView1;
          if (localVideoPlayerTextureView2 != null) {
            localObject = Integer.valueOf(localVideoPlayerTextureView2.getBottom());
          }
          Log.i("MicroMsg.EditVideoPlayPlugin", localObject);
          localObject = e.HGz;
          localObject = e.fuW();
          localVideoPlayerTextureView1 = this.HOb.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          int i = localVideoPlayerTextureView1.getLeft();
          localVideoPlayerTextureView1 = this.HOb.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          int j = localVideoPlayerTextureView1.getTop();
          localVideoPlayerTextureView1 = this.HOb.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          int k = localVideoPlayerTextureView1.getRight();
          localVideoPlayerTextureView1 = this.HOb.HNX.Fdy;
          if (localVideoPlayerTextureView1 == null) {
            p.iCn();
          }
          ((Rect)localObject).set(new Rect(i, j, k, localVideoPlayerTextureView1.getBottom()));
          AppMethodBeat.o(75592);
          return;
          localObject = null;
          break;
          localObject = null;
          break label87;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTextureUpdate"})
    static final class b
      implements k.e
    {
      b(t.d paramd) {}
      
      public final void bXh()
      {
        AppMethodBeat.i(75594);
        MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(75593);
            Log.i("MicroMsg.MMRecordUI", "onTextureUpdate");
            VideoPlayerTextureView localVideoPlayerTextureView = this.HOc.HOb.HNX.Fdy;
            if (localVideoPlayerTextureView != null) {
              localVideoPlayerTextureView.setAlpha(1.0F);
            }
            d.b.a(this.HOc.HOb.HNG, d.c.HRE);
            AppMethodBeat.o(75593);
          }
        }, 10L);
        AppMethodBeat.o(75594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.t
 * JD-Core Version:    0.7.0.1
 */