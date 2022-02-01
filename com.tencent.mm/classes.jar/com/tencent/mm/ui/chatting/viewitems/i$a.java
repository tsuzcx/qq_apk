package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

final class i$a
  extends c.a
{
  ImageView JZD;
  MMTextView Kbm;
  View ize;
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36886);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.Kbm = ((MMTextView)paramView.findViewById(2131298073));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.ize = paramView.findViewById(2131298071);
    if (!paramBoolean)
    {
      this.JZD = ((ImageView)paramView.findViewById(2131298176));
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
    }
    AppMethodBeat.o(36886);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */