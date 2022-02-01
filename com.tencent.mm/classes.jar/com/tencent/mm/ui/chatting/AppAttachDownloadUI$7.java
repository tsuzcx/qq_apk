package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppAttachDownloadUI$7
  implements View.OnClickListener
{
  AppAttachDownloadUI$7(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232800);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    AppAttachDownloadUI.O(this.PdA);
    AppAttachDownloadUI.P(this.PdA);
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.7
 * JD-Core Version:    0.7.0.1
 */