package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.i;

final class j$5
  implements View.OnClickListener
{
  j$5(j paramj, av paramav, int paramInt, j.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40159);
    this.sgJ.rks.sjX.onClick(paramView);
    if (this.sgF > 0) {
      this.sgJ.rWP.rFk.ll(this.siG.sgK);
    }
    AppMethodBeat.o(40159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.5
 * JD-Core Version:    0.7.0.1
 */