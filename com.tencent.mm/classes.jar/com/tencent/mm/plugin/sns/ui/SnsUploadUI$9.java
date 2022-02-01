package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.pulldown.f.a;

final class SnsUploadUI$9
  implements f.a
{
  SnsUploadUI$9(SnsUploadUI paramSnsUploadUI) {}
  
  public final void Wm(int paramInt)
  {
    AppMethodBeat.i(369951);
    if (paramInt != 0)
    {
      SnsUploadUI.a(this.REd).onPause();
      SnsUploadUI.M(this.REd);
    }
    AppMethodBeat.o(369951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.9
 * JD-Core Version:    0.7.0.1
 */