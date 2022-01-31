package com.tencent.mm.plugin.story.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.CaptureView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCaptureUI$f$a
  implements Runnable
{
  StoryCaptureUI$f$a(StoryCaptureUI.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(138849);
    CaptureView localCaptureView = StoryCaptureUI.c(this.sHx.sHv);
    if (localCaptureView != null)
    {
      localCaptureView.setVisibility(8);
      AppMethodBeat.o(138849);
      return;
    }
    AppMethodBeat.o(138849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI.f.a
 * JD-Core Version:    0.7.0.1
 */