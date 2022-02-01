package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class cg
  extends c.a
{
  protected ImageView aeZg;
  protected TextView plr;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final cg lS(View paramView)
  {
    AppMethodBeat.i(37564);
    super.create(paramView);
    this.plr = ((TextView)paramView.findViewById(R.h.fwH));
    this.aeZg = ((ImageView)paramView.findViewById(R.h.fxc));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.cg
 * JD-Core Version:    0.7.0.1
 */