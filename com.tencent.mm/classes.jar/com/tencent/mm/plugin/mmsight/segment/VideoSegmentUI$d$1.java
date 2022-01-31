package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSegmentUI$d$1
  implements Runnable
{
  VideoSegmentUI$d$1(VideoSegmentUI.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(55051);
    if ((VideoSegmentUI.t(this.oMR.oME)) || (this.oMR.oME.isFinishing()) || (VideoSegmentUI.j(this.oMR.oME) == null) || (VideoSegmentUI.d(this.oMR.oME) == null))
    {
      ab.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
      AppMethodBeat.o(55051);
      return;
    }
    ((View)VideoSegmentUI.j(this.oMR.oME)).setAlpha(0.0F);
    ((View)VideoSegmentUI.j(this.oMR.oME)).setVisibility(0);
    ((View)VideoSegmentUI.j(this.oMR.oME)).animate().setDuration(300L).setStartDelay(200L).alpha(1.0F);
    float f1 = VideoSegmentUI.j(this.oMR.oME).bRy();
    float f2 = VideoSegmentUI.j(this.oMR.oME).bRz();
    if ((f2 - f1) * VideoSegmentUI.e(this.oMR.oME) <= VideoSegmentUI.p(this.oMR.oME)) {
      this.oMR.oME.enableOptionMenu(true);
    }
    VideoSegmentUI.d(this.oMR.oME).setLoop((int)(f1 * VideoSegmentUI.e(this.oMR.oME)), (int)(f2 * VideoSegmentUI.e(this.oMR.oME)));
    AppMethodBeat.o(55051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d.1
 * JD-Core Version:    0.7.0.1
 */