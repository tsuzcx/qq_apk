package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class be$c
  extends c.a
{
  TextView Aoo;
  TextView aeUc;
  View yBS;
  
  public final View getMainContainerView()
  {
    return this.yBS;
  }
  
  public final c.a lM(View paramView)
  {
    AppMethodBeat.i(37372);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeUc = ((TextView)paramView.findViewById(R.h.fxy));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fzS));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.yBS = paramView.findViewById(R.h.fyY);
    AppMethodBeat.o(37372);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.c
 * JD-Core Version:    0.7.0.1
 */