package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$14
  implements View.OnClickListener
{
  h$14(LinearLayout paramLinearLayout, h.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106418);
    int i = 0;
    while (i < this.qHq.getChildCount())
    {
      TextView localTextView = (TextView)this.qHq.getChildAt(i);
      if (localTextView.getId() != 2131823916) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2131231905, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    paramView.post(new h.14.1(this, ((Integer)paramView.getTag()).intValue()));
    AppMethodBeat.o(106418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.14
 * JD-Core Version:    0.7.0.1
 */