package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout;

final class bt
  extends bv
{
  TextView Xmw;
  bw Xmx;
  bu Xmy;
  
  bt()
  {
    AppMethodBeat.i(266865);
    this.Xmx = new bw();
    this.Xmy = new bu();
    AppMethodBeat.o(266865);
  }
  
  public final c.a iu(View paramView)
  {
    AppMethodBeat.i(266866);
    super.iu(paramView);
    this.Xmw = ((TextView)paramView.findViewById(R.h.dzo));
    this.Xmx.ybY = ((ViewGroup)paramView.findViewById(R.h.dxf));
    this.Xmy.Xmz = ((FoldableCellLayout)paramView.findViewById(R.h.dxT));
    AppMethodBeat.o(266866);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bt
 * JD-Core Version:    0.7.0.1
 */