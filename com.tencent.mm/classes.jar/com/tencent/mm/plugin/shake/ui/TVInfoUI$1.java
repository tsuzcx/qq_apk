package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.e.c.a;

final class TVInfoUI$1
  implements View.OnClickListener
{
  TVInfoUI$1(TVInfoUI paramTVInfoUI, c.a parama) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(10987, new Object[] { Integer.valueOf(2), this.odH.field_playstatid, "", "" });
    TVInfoUI.a(this.odI, this.odH.field_playurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.1
 * JD-Core Version:    0.7.0.1
 */