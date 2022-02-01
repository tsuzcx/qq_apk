package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class AppAttachNewDownloadUI$8
  implements View.OnLongClickListener
{
  AppAttachNewDownloadUI$8(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(275413);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    Log.d("MicroMsg.AppAttachNewDownloadUI", "onLongClick");
    if (AppAttachNewDownloadUI.Q(this.Wxg) == null) {
      AppAttachNewDownloadUI.a(this.Wxg, new com.tencent.mm.ui.widget.b.a(this.Wxg.dlC()));
    }
    AppAttachNewDownloadUI.Q(this.Wxg).a(paramView, this.Wxg, AppAttachNewDownloadUI.R(this.Wxg), AppAttachNewDownloadUI.S(this.Wxg), AppAttachNewDownloadUI.T(this.Wxg));
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(275413);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.8
 * JD-Core Version:    0.7.0.1
 */