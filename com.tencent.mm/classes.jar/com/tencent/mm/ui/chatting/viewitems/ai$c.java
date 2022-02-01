package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

final class ai$c
  extends c.a
{
  FinderLiveOnliveWidget VYJ;
  boolean Xfv;
  MMNeat7extView XhE;
  MMTextView XhF;
  FinderLiveOnliveWidget XhG;
  
  public ai$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(278946);
    super.create(paramView);
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.XhE = ((MMNeat7extView)paramView.findViewById(R.h.dVa));
    this.XhF = ((MMTextView)paramView.findViewById(R.h.dVb));
    this.VYJ = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.dVc));
    this.XhG = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.dVd));
    this.Xfv = paramBoolean.booleanValue();
    AppMethodBeat.o(278946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.c
 * JD-Core Version:    0.7.0.1
 */