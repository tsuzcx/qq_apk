package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.f;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg, TextView paramTextView, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    this.mRA.setVisibility(8);
    int i = 0;
    while (i < g.a(this.mRC).length)
    {
      paramView = g.a(this.mRC, g.a(this.mRC)[i]);
      this.mRB.addView(paramView, new LinearLayout.LayoutParams(-2, -2));
      i += 1;
    }
    this.mRA.setOnClickListener(null);
    if (g.b(this.mRC) != null) {
      g.b(this.mRC).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g.1
 * JD-Core Version:    0.7.0.1
 */