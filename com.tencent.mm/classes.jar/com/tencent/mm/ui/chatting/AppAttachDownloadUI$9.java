package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bo;

final class AppAttachDownloadUI$9
  implements View.OnClickListener
{
  AppAttachDownloadUI$9(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30272);
    AppAttachDownloadUI.a(this.zvM, 0);
    AppAttachDownloadUI.l(this.zvM).setVisibility(8);
    if (AppAttachDownloadUI.o(this.zvM))
    {
      paramView = AppAttachDownloadUI.n(this.zvM);
      if (paramView != null)
      {
        paramView.field_status = 101L;
        paramView.field_lastModifyTime = bo.aox();
        al.aUJ().a(paramView, new String[0]);
      }
      AppAttachDownloadUI.a(this.zvM, new e(AppAttachDownloadUI.p(this.zvM), AppAttachDownloadUI.q(this.zvM), AppAttachDownloadUI.r(this.zvM)));
      aw.Rc().a(AppAttachDownloadUI.a(this.zvM), 0);
    }
    AppMethodBeat.o(30272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.9
 * JD-Core Version:    0.7.0.1
 */