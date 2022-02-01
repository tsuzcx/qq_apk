package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a
  extends c.a
{
  public ImageView GLo;
  public View GLw;
  TextView frs;
  ImageView fuj;
  ImageView qAi;
  TextView qKL;
  
  public final a D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163352);
    super.fK(paramView);
    this.fuj = ((ImageView)paramView.findViewById(2131299973));
    this.frs = ((TextView)paramView.findViewById(2131300019));
    this.qAi = ((ImageView)paramView.findViewById(2131300003));
    this.qKL = ((TextView)paramView.findViewById(2131300004));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    if (paramBoolean)
    {
      this.GLw = paramView.findViewById(2131306220);
      this.GLo = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(163352);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */