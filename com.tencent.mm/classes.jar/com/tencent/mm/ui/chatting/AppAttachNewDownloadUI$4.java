package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class AppAttachNewDownloadUI$4
  implements View.OnClickListener
{
  AppAttachNewDownloadUI$4(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(272584);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.AppAttachNewDownloadUI", "start receive file");
    if (AppAttachNewDownloadUI.M(this.Wxg) == 74)
    {
      AppAttachNewDownloadUI.b(this.Wxg, 12, -1);
      AppAttachNewDownloadUI.F(this.Wxg).setFileStatus(1);
      ((n)h.ae(n.class)).eSe().a(AppAttachNewDownloadUI.I(this.Wxg), AppAttachNewDownloadUI.F(this.Wxg));
      if (AppAttachNewDownloadUI.M(this.Wxg) != 74) {
        break label188;
      }
      AppAttachNewDownloadUI.N(this.Wxg);
    }
    for (;;)
    {
      paramView = com.tencent.mm.pluginsdk.model.a.b.QXV;
      com.tencent.mm.pluginsdk.model.a.b.b(AppAttachNewDownloadUI.F(this.Wxg), AppAttachNewDownloadUI.L(this.Wxg));
      a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272584);
      return;
      AppAttachNewDownloadUI.b(this.Wxg, 13, -1);
      AppAttachNewDownloadUI.F(this.Wxg).setFileStatus(0);
      break;
      label188:
      AppAttachNewDownloadUI.O(this.Wxg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */