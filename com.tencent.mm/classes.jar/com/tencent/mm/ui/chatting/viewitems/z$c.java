package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

final class z$c
  extends c.a
{
  boolean Kbn;
  MMNeat7extView KcT;
  MMTextView KcU;
  
  public z$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(194411);
    super.gn(paramView);
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.KcT = ((MMNeat7extView)paramView.findViewById(2131307980));
    this.KcU = ((MMTextView)paramView.findViewById(2131307981));
    this.Kbn = paramBoolean.booleanValue();
    AppMethodBeat.o(194411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.c
 * JD-Core Version:    0.7.0.1
 */