package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getDebugInfoView", "()Landroid/widget/TextView;", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "isClipMode", "", "lastPlayTimeLogTick", "", "maxRecordTime", "parent", "Landroid/widget/RelativeLayout;", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "gotoClipMode", "", "gotoPreviewMode", "enableCrop", "onPause", "onResume", "release", "setMute", "mute", "setPlayRange", "start", "end", "showVideoDebugInfoIfNeed", "info", "Companion", "plugin-recordvideo_release"})
public final class p
  implements q
{
  public static final p.a qcG;
  public Context context;
  public int endTime;
  public com.tencent.mm.compatible.util.b gaP;
  public VideoPlayerTextureView oKC;
  public com.tencent.mm.media.widget.camerarecordview.a.b qbS;
  public int qcA;
  private long qcB;
  public RelativeLayout qcC;
  public boolean qcD;
  public final p.d qcE;
  public final TextView qcF;
  public int startTime;
  
  static
  {
    AppMethodBeat.i(150692);
    qcG = new p.a((byte)0);
    AppMethodBeat.o(150692);
  }
  
  public p(VideoPlayerTextureView paramVideoPlayerTextureView, d paramd, TextView paramTextView)
  {
    AppMethodBeat.i(150691);
    this.oKC = paramVideoPlayerTextureView;
    this.qcF = paramTextView;
    this.context = this.oKC.getContext();
    this.qcA = 10000;
    this.qcB = -1L;
    paramVideoPlayerTextureView = this.oKC.getParent();
    if (paramVideoPlayerTextureView == null)
    {
      paramVideoPlayerTextureView = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(150691);
      throw paramVideoPlayerTextureView;
    }
    this.qcC = ((RelativeLayout)paramVideoPlayerTextureView);
    this.qcE = new p.d(this, paramd);
    AppMethodBeat.o(150691);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(150690);
    this.qcD = false;
    Object localObject = this.qcC.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F);
    j.p(localObject, "parent.animate().scaleX(…eY(1.0f).translationY(0f)");
    ((ViewPropertyAnimator)localObject).setDuration(300L);
    if (!paramBoolean)
    {
      this.startTime = 0;
      localObject = this.qbS;
      if (localObject == null) {
        break label78;
      }
    }
    label78:
    for (int i = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject).endTime;; i = 10000)
    {
      this.endTime = i;
      AppMethodBeat.o(150690);
      return;
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(150688);
    ab.i("MicroMsg.EditVideoPlayPlugin", "onPause");
    com.tencent.mm.compatible.util.b localb = this.gaP;
    if (localb != null) {
      localb.Mh();
    }
    this.oKC.pause();
    AppMethodBeat.o(150688);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(150687);
    ab.i("MicroMsg.EditVideoPlayPlugin", "onResume");
    com.tencent.mm.compatible.util.b localb = this.gaP;
    if (localb != null) {
      localb.requestFocus();
    }
    this.oKC.start();
    AppMethodBeat.o(150687);
  }
  
  public final void release()
  {
    AppMethodBeat.i(150689);
    ab.i("MicroMsg.EditVideoPlayPlugin", "release");
    com.tencent.mm.compatible.util.b localb = this.gaP;
    if (localb != null) {
      localb.Mh();
    }
    this.oKC.stop();
    this.oKC.setVideoCallback(null);
    AppMethodBeat.o(150689);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p
 * JD-Core Version:    0.7.0.1
 */