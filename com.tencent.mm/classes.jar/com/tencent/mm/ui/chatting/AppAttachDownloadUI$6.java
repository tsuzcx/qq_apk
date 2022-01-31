package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bk;

final class AppAttachDownloadUI$6
  implements View.OnClickListener
{
  AppAttachDownloadUI$6(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppAttachDownloadUI.k(this.vgK).setVisibility(0);
    AppAttachDownloadUI.l(this.vgK).setVisibility(8);
    AppAttachDownloadUI.m(this.vgK).setVisibility(0);
    if (AppAttachDownloadUI.p(this.vgK))
    {
      paramView = AppAttachDownloadUI.o(this.vgK);
      if (paramView != null)
      {
        paramView.field_status = 101L;
        paramView.field_lastModifyTime = bk.UX();
        ap.avh().c(paramView, new String[0]);
      }
      AppAttachDownloadUI.a(this.vgK, new ac(AppAttachDownloadUI.q(this.vgK), AppAttachDownloadUI.r(this.vgK), AppAttachDownloadUI.s(this.vgK)));
      au.Dk().a(AppAttachDownloadUI.a(this.vgK), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.6
 * JD-Core Version:    0.7.0.1
 */