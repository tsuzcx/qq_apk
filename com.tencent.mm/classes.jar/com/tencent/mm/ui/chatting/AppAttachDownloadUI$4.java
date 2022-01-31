package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;

final class AppAttachDownloadUI$4
  implements g
{
  AppAttachDownloadUI$4(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    if (paramInt2 == 0) {}
    for (float f = 0.0F;; f = paramInt1 * 100.0F / paramInt2)
    {
      if ((paramInt1 < paramInt2) && (AppAttachDownloadUI.k(this.vgK).getVisibility() != 0))
      {
        AppAttachDownloadUI.k(this.vgK).setVisibility(0);
        AppAttachDownloadUI.l(this.vgK).setVisibility(8);
        AppAttachDownloadUI.m(this.vgK).setVisibility(0);
      }
      AppAttachDownloadUI.n(this.vgK).setProgress((int)f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */