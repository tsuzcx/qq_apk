package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.sdk.platformtools.Log;

final class AppAttachDownloadUI$1
  implements View.OnClickListener
{
  AppAttachDownloadUI$1(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(278129);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.d("MicroMsg.AppAttachDownloadUI", "MoreOpenWaysArea#onClick");
    if (AppAttachDownloadUI.a(this.WwM) != null) {
      AppAttachDownloadUI.a(this.WwM).ccF();
    }
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */