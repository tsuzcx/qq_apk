package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout;

final class bu
  extends bw
{
  bx aeXA;
  bv aeXB;
  TextView aeXz;
  
  bu()
  {
    AppMethodBeat.i(255307);
    this.aeXA = new bx();
    this.aeXB = new bv();
    AppMethodBeat.o(255307);
  }
  
  public final c.a lR(View paramView)
  {
    AppMethodBeat.i(255311);
    super.lR(paramView);
    this.aeXz = ((TextView)paramView.findViewById(R.h.fAi));
    this.aeXA.CAj = ((ViewGroup)paramView.findViewById(R.h.fxA));
    this.aeXB.aeXC = ((FoldableCellLayout)paramView.findViewById(R.h.fyA));
    AppMethodBeat.o(255311);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bu
 * JD-Core Version:    0.7.0.1
 */