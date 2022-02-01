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
  ImageView GJi;
  MMTextView GKR;
  View hFi;
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36886);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.GKR = ((MMTextView)paramView.findViewById(2131298073));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.hFi = paramView.findViewById(2131298071);
    if (!paramBoolean)
    {
      this.GJi = ((ImageView)paramView.findViewById(2131298176));
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
    }
    AppMethodBeat.o(36886);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */