package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.c;
import com.tencent.mm.ax.d.a;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.base.preference.IconPreference;

final class MoreTabUI$6
  implements d.a
{
  MoreTabUI$6(MoreTabUI paramMoreTabUI, IconPreference paramIconPreference) {}
  
  public final void e(bm parambm)
  {
    AppMethodBeat.i(29697);
    if (parambm.field_tipId == b.fKS)
    {
      a.bWU();
      if (c.lO(b.fKS))
      {
        this.zdx.ON(0);
        this.zdx.OL(8);
        this.zdx.eN("", -1);
        AppMethodBeat.o(29697);
        return;
      }
    }
    AppMethodBeat.o(29697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.6
 * JD-Core Version:    0.7.0.1
 */