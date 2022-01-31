package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.e.c.a;

final class TVInfoUI$1
  implements View.OnClickListener
{
  TVInfoUI$1(TVInfoUI paramTVInfoUI, c.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24910);
    h.qsU.e(10987, new Object[] { Integer.valueOf(2), this.qRO.field_playstatid, "", "" });
    TVInfoUI.a(this.qRP, this.qRO.field_playurl);
    AppMethodBeat.o(24910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.1
 * JD-Core Version:    0.7.0.1
 */