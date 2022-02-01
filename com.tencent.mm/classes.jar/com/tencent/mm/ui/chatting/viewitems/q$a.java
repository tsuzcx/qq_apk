package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$a
  extends c.a
{
  public ImageView KbJ;
  TextView KbU;
  ImageView fRd;
  TextView gUs;
  TextView opA;
  
  public final a F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(194354);
    super.gn(paramView);
    this.fRd = ((ImageView)paramView.findViewById(2131308315));
    this.opA = ((TextView)paramView.findViewById(2131308318));
    this.gUs = ((TextView)paramView.findViewById(2131308317));
    this.KbU = ((TextView)paramView.findViewById(2131308319));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    if (paramBoolean)
    {
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.KbJ = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(194354);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.a
 * JD-Core Version:    0.7.0.1
 */