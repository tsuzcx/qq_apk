package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AttachDownloadPage$8
  implements View.OnClickListener
{
  AttachDownloadPage$8(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68138);
    if (AttachDownloadPage.i(this.pLa) == 3)
    {
      AttachDownloadPage.b(this.pLa, AttachDownloadPage.a(this.pLa));
      AppMethodBeat.o(68138);
      return;
    }
    AttachDownloadPage.h(this.pLa);
    AttachDownloadPage.e(this.pLa);
    AttachDownloadPage.f(this.pLa);
    AppMethodBeat.o(68138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.8
 * JD-Core Version:    0.7.0.1
 */