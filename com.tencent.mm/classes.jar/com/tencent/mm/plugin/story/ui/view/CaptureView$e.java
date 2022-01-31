package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/CaptureView$hideGuideView$1$1"})
final class CaptureView$e
  implements Runnable
{
  CaptureView$e(g paramg, CaptureView paramCaptureView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110305);
    this.sLm.removeView((View)this.sLn);
    CaptureView.g(this.sLm);
    AppMethodBeat.o(110305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CaptureView.e
 * JD-Core Version:    0.7.0.1
 */