package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.i;

final class j$3
  implements View.OnClickListener
{
  j$3(j paramj, int paramInt, av paramav, j.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40158);
    if (this.sgF > 0) {
      this.sgJ.rWP.rFk.ll(this.siG.sgK);
    }
    this.sgJ.rks.sjX.onClick(paramView);
    AppMethodBeat.o(40158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.3
 * JD-Core Version:    0.7.0.1
 */