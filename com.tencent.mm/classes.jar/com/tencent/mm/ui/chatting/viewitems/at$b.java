package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class at$b
  extends c.a
{
  TextView aeQc;
  TextView aeUc;
  View aeUd;
  ImageView aeUe;
  ImageView aeUf;
  TextView aeUg;
  TextView aeUh;
  TextView qfH;
  
  public final c.a lM(View paramView)
  {
    AppMethodBeat.i(37298);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aeQc = ((TextView)paramView.findViewById(R.h.fAp));
    this.qfH = ((TextView)paramView.findViewById(R.h.fAs));
    this.aeUc = ((TextView)paramView.findViewById(R.h.fxy));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.aeUh = ((TextView)paramView.findViewById(R.h.fzo));
    this.aeUd = paramView.findViewById(R.h.fyl);
    this.aeUe = ((ImageView)paramView.findViewById(R.h.fvF));
    this.aeUf = ((ImageView)paramView.findViewById(R.h.fym));
    this.aeUg = ((TextView)paramView.findViewById(R.h.fvG));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37298);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.b
 * JD-Core Version:    0.7.0.1
 */