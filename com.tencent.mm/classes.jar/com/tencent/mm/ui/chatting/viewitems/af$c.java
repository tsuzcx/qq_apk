package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

final class af$c
  extends c.a
{
  boolean PJV;
  MMNeat7extView PLK;
  MMTextView PLL;
  ImageView PLM;
  
  public af$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(233803);
    super.create(paramView);
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.PLK = ((MMNeat7extView)paramView.findViewById(2131307815));
    this.PLL = ((MMTextView)paramView.findViewById(2131307816));
    this.PLM = ((ImageView)paramView.findViewById(2131307814));
    this.PJV = paramBoolean.booleanValue();
    AppMethodBeat.o(233803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.c
 * JD-Core Version:    0.7.0.1
 */