package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;

final class AttachDownloadPage$3
  implements View.OnClickListener
{
  AttachDownloadPage$3(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68133);
    AttachDownloadPage.a(this.pLa, 2);
    ac.cdQ().cancel(AttachDownloadPage.b(this.pLa));
    AttachDownloadPage.c(this.pLa);
    AttachDownloadPage.d(this.pLa);
    AppMethodBeat.o(68133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.3
 * JD-Core Version:    0.7.0.1
 */