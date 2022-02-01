package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class ci
  extends c.a
{
  TextView plr;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final c.a lT(View paramView)
  {
    AppMethodBeat.i(37565);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.plr = ((TextView)paramView.findViewById(R.h.fxy));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37565);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ci
 * JD-Core Version:    0.7.0.1
 */