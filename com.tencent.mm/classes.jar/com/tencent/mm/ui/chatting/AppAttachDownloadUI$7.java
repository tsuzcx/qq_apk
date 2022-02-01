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
    AppMethodBeat.i(253969);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    AppAttachDownloadUI.P(this.aeed);
    AppAttachDownloadUI.Q(this.aeed);
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(253969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.7
 * JD-Core Version:    0.7.0.1
 */