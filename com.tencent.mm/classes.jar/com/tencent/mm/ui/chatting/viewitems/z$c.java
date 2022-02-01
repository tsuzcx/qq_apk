package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

final class z$c
  extends c.a
{
  boolean KxF;
  MMNeat7extView Kzl;
  MMTextView Kzm;
  
  public z$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(187806);
    super.gs(paramView);
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.Kzl = ((MMNeat7extView)paramView.findViewById(2131307980));
    this.Kzm = ((MMTextView)paramView.findViewById(2131307981));
    this.KxF = paramBoolean.booleanValue();
    AppMethodBeat.o(187806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.c
 * JD-Core Version:    0.7.0.1
 */