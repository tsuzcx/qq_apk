package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

final class y$c
  extends c.a
{
  boolean IkP;
  MMTextView Imv;
  MMTextView Imw;
  
  public y$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(196722);
    super.fX(paramView);
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.Imv = ((MMTextView)paramView.findViewById(2131307980));
    this.Imw = ((MMTextView)paramView.findViewById(2131307981));
    this.IkP = paramBoolean.booleanValue();
    AppMethodBeat.o(196722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.c
 * JD-Core Version:    0.7.0.1
 */