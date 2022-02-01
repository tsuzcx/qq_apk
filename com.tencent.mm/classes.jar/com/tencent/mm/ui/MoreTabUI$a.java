package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.ui.base.preference.IconPreference;

final class MoreTabUI$a
  implements i.a
{
  IconPreference adIe;
  
  public MoreTabUI$a(IconPreference paramIconPreference)
  {
    this.adIe = paramIconPreference;
  }
  
  public final void e(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(249239);
    if ((parama != null) && (parama.field_tipId == d.Mse))
    {
      com.tencent.mm.plugin.newtips.a.gti();
      if (e.aeE(d.Mse))
      {
        this.adIe.aeD(0);
        this.adIe.afx(8);
        this.adIe.gv("", -1);
        AppMethodBeat.o(249239);
        return;
      }
    }
    AppMethodBeat.o(249239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.a
 * JD-Core Version:    0.7.0.1
 */