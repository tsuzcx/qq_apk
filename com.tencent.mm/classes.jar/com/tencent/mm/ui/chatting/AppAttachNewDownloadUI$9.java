package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppAttachNewDownloadUI$9
  implements View.OnClickListener
{
  AppAttachNewDownloadUI$9(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(288223);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    AppAttachNewDownloadUI.U(this.Wxg);
    AppAttachNewDownloadUI.V(this.Wxg);
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.9
 * JD-Core Version:    0.7.0.1
 */