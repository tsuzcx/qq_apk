package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

final class AppAttachDownloadUI$7
  implements g
{
  AppAttachDownloadUI$7(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(30270);
    if (paramInt2 == 0) {}
    for (float f = 0.0F;; f = paramInt1 * 100.0F / paramInt2)
    {
      if ((paramInt1 < paramInt2) && (AppAttachDownloadUI.k(this.zvM).getVisibility() != 0))
      {
        AppAttachDownloadUI.a(this.zvM, 0);
        AppAttachDownloadUI.l(this.zvM).setVisibility(8);
      }
      AppAttachDownloadUI.k(this.zvM).setProgress((int)f);
      AppMethodBeat.o(30270);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.7
 * JD-Core Version:    0.7.0.1
 */