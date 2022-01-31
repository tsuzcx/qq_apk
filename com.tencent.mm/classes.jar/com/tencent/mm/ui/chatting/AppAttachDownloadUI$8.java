package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppAttachDownloadUI$8
  implements View.OnClickListener
{
  AppAttachDownloadUI$8(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30271);
    AppAttachDownloadUI.a(this.zvM, 8);
    AppAttachDownloadUI.l(this.zvM).setVisibility(0);
    AppAttachDownloadUI.m(this.zvM).setVisibility(8);
    ab.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(this.zvM) });
    if (AppAttachDownloadUI.a(this.zvM) != null)
    {
      AppAttachDownloadUI.a(this.zvM).a(this.zvM);
      g.Rc().a(AppAttachDownloadUI.a(this.zvM));
      AppMethodBeat.o(30271);
      return;
    }
    paramView = AppAttachDownloadUI.n(this.zvM);
    if ((paramView != null) && (paramView.field_status != 199L))
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramView.field_status) });
      paramView.field_status = 102L;
      al.aUJ().a(paramView, new String[0]);
    }
    AppMethodBeat.o(30271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.8
 * JD-Core Version:    0.7.0.1
 */