package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.j;

final class h$14
  implements View.OnClickListener
{
  h$14(LinearLayout paramLinearLayout, h.a parama) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    while (i < this.nTq.getChildCount())
    {
      TextView localTextView = (TextView)this.nTq.getChildAt(i);
      if (localTextView.getId() != a.g.tips_tv) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(a.j.radio_off, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(a.j.radio_on, 0, 0, 0);
    paramView.post(new h.14.1(this, ((Integer)paramView.getTag()).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.14
 * JD-Core Version:    0.7.0.1
 */