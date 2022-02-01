package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class AppAttachNewDownloadUI$5
  implements View.OnClickListener
{
  AppAttachNewDownloadUI$5(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(288812);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.AppAttachNewDownloadUI", "cancel receive file");
    AppAttachNewDownloadUI.b(this.Wxg, 14, -1);
    AppAttachNewDownloadUI.F(this.Wxg).setFileStatus(0);
    ((n)h.ae(n.class)).eSe().a(AppAttachNewDownloadUI.I(this.Wxg), AppAttachNewDownloadUI.F(this.Wxg));
    AppAttachNewDownloadUI.G(this.Wxg);
    a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.5
 * JD-Core Version:    0.7.0.1
 */