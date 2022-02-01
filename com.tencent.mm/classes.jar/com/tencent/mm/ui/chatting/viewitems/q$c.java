package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class q$c
  extends c.a
{
  boolean PJV;
  MMNeat7extView PKy;
  ImageView gBZ;
  ImageView gyr;
  
  public q$c(View paramView, Boolean paramBoolean)
  {
    AppMethodBeat.i(233681);
    super.create(paramView);
    this.PKy = ((MMNeat7extView)paramView.findViewById(2131301035));
    this.gBZ = ((ImageView)paramView.findViewById(2131301034));
    this.gyr = ((ImageView)paramView.findViewById(2131301032));
    this.gBZ.setImageDrawable(ar.m(this.gBZ.getContext(), 2131690801, a.n(this.gBZ.getContext(), 2131099792)));
    this.PJV = paramBoolean.booleanValue();
    AppMethodBeat.o(233681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */