package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class i$1$1
  implements Runnable
{
  int count = 20;
  
  i$1$1(i.1 param1, int paramInt1, int paramInt2, int paramInt3, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38164);
    this.rFF.rFD.list.setSelectionFromTop(this.lU + this.rFF.rFD.list.getHeaderViewsCount(), this.nkP + this.rFE);
    this.count -= 1;
    ab.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[] { Integer.valueOf(this.count), Integer.valueOf(Math.abs(this.val$view.getTop() - (this.nkP + this.rFE))) });
    if ((this.count <= 0) || (Math.abs(this.val$view.getTop() - (this.nkP + this.rFE)) < 5))
    {
      ab.d("MicroMsg.TimelineClickListener", "count: %s", new Object[] { Integer.valueOf(this.count) });
      this.rFF.rFD.rkX.notifyDataSetChanged();
      AppMethodBeat.o(38164);
      return;
    }
    new ak().postDelayed(this, 5L);
    AppMethodBeat.o(38164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.1.1
 * JD-Core Version:    0.7.0.1
 */