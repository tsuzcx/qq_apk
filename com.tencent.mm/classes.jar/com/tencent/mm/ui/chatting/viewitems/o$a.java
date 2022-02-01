package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a
  extends c.a
{
  public ImageView KbJ;
  TextView fOg;
  ImageView fRd;
  TextView sEx;
  ImageView sgf;
  
  public final a D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163352);
    super.gn(paramView);
    this.fRd = ((ImageView)paramView.findViewById(2131299973));
    this.fOg = ((TextView)paramView.findViewById(2131300019));
    this.sgf = ((ImageView)paramView.findViewById(2131300003));
    this.sEx = ((TextView)paramView.findViewById(2131300004));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    if (paramBoolean)
    {
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.KbJ = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(163352);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */