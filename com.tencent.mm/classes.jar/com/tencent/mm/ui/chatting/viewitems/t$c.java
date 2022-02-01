package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class t$c
  extends c.a
{
  boolean Xfv;
  MMNeat7extView Xgs;
  ImageView jiu;
  ImageView jmf;
  
  public t$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(291386);
    super.create(paramView);
    this.Xgs = ((MMNeat7extView)paramView.findViewById(R.h.dGW));
    this.jmf = ((ImageView)paramView.findViewById(R.h.dGV));
    this.jiu = ((ImageView)paramView.findViewById(R.h.dGU));
    this.jmf.setImageDrawable(au.o(this.jmf.getContext(), R.k.icons_outlined_finder_icon, a.w(this.jmf.getContext(), R.e.Orange)));
    this.Xfv = paramBoolean.booleanValue();
    AppMethodBeat.o(291386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.c
 * JD-Core Version:    0.7.0.1
 */