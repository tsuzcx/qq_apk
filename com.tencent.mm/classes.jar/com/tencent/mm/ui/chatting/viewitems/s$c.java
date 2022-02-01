package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class s$c
  extends c.a
{
  boolean aePy;
  MMNeat7extView aeQk;
  ImageView lKK;
  ImageView lPb;
  
  public s$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(254968);
    super.create(paramView);
    this.aeQk = ((MMNeat7extView)paramView.findViewById(R.h.fIe));
    this.lPb = ((ImageView)paramView.findViewById(R.h.fId));
    this.lKK = ((ImageView)paramView.findViewById(R.h.fIc));
    this.lPb.setImageDrawable(bb.m(this.lPb.getContext(), R.k.icons_outlined_finder_icon, a.w(this.lPb.getContext(), R.e.Orange)));
    this.aePy = paramBoolean.booleanValue();
    AppMethodBeat.o(254968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.c
 * JD-Core Version:    0.7.0.1
 */