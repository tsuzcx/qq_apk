package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.sdk.platformtools.Log;

final class AppAttachNewDownloadUI$1
  implements View.OnClickListener
{
  AppAttachNewDownloadUI$1(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287729);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.d("MicroMsg.AppAttachNewDownloadUI", "MoreOpenWaysArea#onClick");
    if (AppAttachNewDownloadUI.a(this.Wxg) != null) {
      AppAttachNewDownloadUI.a(this.Wxg).ccF();
    }
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */