package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
public final class p$d
  implements e.a
{
  p$d(d paramd) {}
  
  public final void Es()
  {
    AppMethodBeat.i(150685);
    ab.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.qcH.startTime);
    this.qcH.oKC.e(this.qcH.startTime, true);
    AppMethodBeat.o(150685);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150686);
    if ((p.c(this.qcH) <= 0L) || (bo.av(p.c(this.qcH)) >= 1000L))
    {
      ab.d("MicroMsg.EditVideoPlayPlugin", " " + this.qcH.oKC.isPlaying() + " videoPlayView.currentPosition: " + this.qcH.oKC.getCurrentPosition() + " + " + this.qcH.endTime);
      p.a(this.qcH, bo.yB());
    }
    if (this.qcH.oKC.isPlaying())
    {
      if (this.qcH.oKC.getCurrentPosition() + 100 >= this.qcH.endTime)
      {
        ab.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.qcH.oKC.getCurrentPosition() + " reach endTime:" + this.qcH.endTime + ", seekTo startTime:" + this.qcH.startTime + ", isClipMode:" + p.e(this.qcH));
        this.qcH.oKC.e(this.qcH.startTime, true);
      }
      if (p.e(this.qcH))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.qcH.oKC.getCurrentPosition());
        this.qcL.a(d.c.qeI, localBundle);
      }
    }
    AppMethodBeat.o(150686);
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(150684);
    ab.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
    k localk = k.sCp;
    k.cCr().set(new Rect(this.qcH.oKC.getLeft(), this.qcH.oKC.getTop(), this.qcH.oKC.getRight(), this.qcH.oKC.getBottom()));
    localk = k.sCp;
    k.cCt();
    p.a(this.qcH, -1L);
    this.qcH.oKC.start();
    this.qcH.oKC.setLoop(true);
    this.qcH.oKC.setOneTimeVideoTextureUpdateCallback((e.e)new p.d.a(this));
    d.b.a(this.qcL, d.c.qeO);
    if (this.qcH.endTime - this.qcH.startTime > p.d(this.qcH) + 750)
    {
      this.qcH.endTime = (p.d(this.qcH) + 250);
      d.b.a(this.qcL, d.c.qeG);
    }
    AppMethodBeat.o(150684);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150683);
    ab.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p.d
 * JD-Core Version:    0.7.0.1
 */