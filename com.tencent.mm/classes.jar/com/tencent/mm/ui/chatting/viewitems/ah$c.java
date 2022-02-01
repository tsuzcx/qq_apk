package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

final class ah$c
  extends c.a
{
  FinderLiveOnliveWidget adDe;
  boolean aePy;
  MMNeat7extView aeRK;
  MMTextView aeRL;
  FinderLiveOnliveWidget aeRM;
  
  public ah$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(255154);
    super.create(paramView);
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeRK = ((MMNeat7extView)paramView.findViewById(R.h.fXw));
    this.aeRL = ((MMTextView)paramView.findViewById(R.h.fXx));
    this.adDe = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.fXy));
    this.aeRM = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.fXz));
    this.aePy = paramBoolean.booleanValue();
    AppMethodBeat.o(255154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.c
 * JD-Core Version:    0.7.0.1
 */