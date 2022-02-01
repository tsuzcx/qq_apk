package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.e.g;

public final class ab
  implements View.OnClickListener
{
  a HpO;
  
  public ab(a parama)
  {
    this.HpO = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33517);
    if ((paramView.getTag() instanceof e.g))
    {
      r.fU(paramView);
      this.HpO.bJU();
    }
    AppMethodBeat.o(33517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */