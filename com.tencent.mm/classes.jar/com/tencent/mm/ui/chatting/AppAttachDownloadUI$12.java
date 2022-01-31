package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class AppAttachDownloadUI$12
  implements View.OnLongClickListener
{
  AppAttachDownloadUI$12(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(30275);
    ab.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
    if (AppAttachDownloadUI.t(this.zvM) == null) {
      AppAttachDownloadUI.a(this.zvM, new a(this.zvM.getContext()));
    }
    AppAttachDownloadUI.t(this.zvM).a(paramView, this.zvM, AppAttachDownloadUI.u(this.zvM), AppAttachDownloadUI.v(this.zvM), AppAttachDownloadUI.w(this.zvM));
    AppMethodBeat.o(30275);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.12
 * JD-Core Version:    0.7.0.1
 */