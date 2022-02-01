package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class AppAttachDownloadUI$6
  implements View.OnLongClickListener
{
  AppAttachDownloadUI$6(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(285417);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    Log.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
    if (AppAttachDownloadUI.K(this.WwM) == null) {
      AppAttachDownloadUI.a(this.WwM, new com.tencent.mm.ui.widget.b.a(this.WwM.dlC()));
    }
    AppAttachDownloadUI.K(this.WwM).a(paramView, this.WwM, AppAttachDownloadUI.L(this.WwM), AppAttachDownloadUI.M(this.WwM), AppAttachDownloadUI.N(this.WwM));
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(285417);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.6
 * JD-Core Version:    0.7.0.1
 */