package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.e.c.a;

final class TVInfoUI$2
  implements View.OnClickListener
{
  TVInfoUI$2(TVInfoUI paramTVInfoUI, c.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24911);
    h.qsU.e(10987, new Object[] { Integer.valueOf(2), this.qRO.field_playstatid, "", "" });
    TVInfoUI.a(this.qRP, this.qRO.field_playurl);
    AppMethodBeat.o(24911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.2
 * JD-Core Version:    0.7.0.1
 */