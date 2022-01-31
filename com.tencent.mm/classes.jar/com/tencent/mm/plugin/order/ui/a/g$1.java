package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg, TextView paramTextView, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43912);
    this.prN.setVisibility(8);
    int i = 0;
    while (i < g.a(this.prP).length)
    {
      paramView = g.a(this.prP, g.a(this.prP)[i]);
      this.prO.addView(paramView, new LinearLayout.LayoutParams(-2, -2));
      i += 1;
    }
    this.prN.setOnClickListener(null);
    if (g.b(this.prP) != null) {
      g.b(this.prP).notifyDataSetChanged();
    }
    AppMethodBeat.o(43912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g.1
 * JD-Core Version:    0.7.0.1
 */