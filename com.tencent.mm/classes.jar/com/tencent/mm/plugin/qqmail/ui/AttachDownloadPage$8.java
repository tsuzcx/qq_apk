package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AttachDownloadPage$8
  implements View.OnClickListener
{
  AttachDownloadPage$8(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(122864);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (AttachDownloadPage.i(this.NlX) == 3) {
      AttachDownloadPage.b(this.NlX, AttachDownloadPage.a(this.NlX));
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(122864);
      return;
      AttachDownloadPage.h(this.NlX);
      AttachDownloadPage.e(this.NlX);
      AttachDownloadPage.f(this.NlX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.8
 * JD-Core Version:    0.7.0.1
 */