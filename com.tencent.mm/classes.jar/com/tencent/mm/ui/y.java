package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.d.f;

public final class y
  implements View.OnClickListener
{
  a zcV;
  
  public y(a parama)
  {
    this.zcV = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29683);
    if ((paramView.getTag() instanceof d.f))
    {
      r.eQ(paramView);
      this.zcV.aWN();
    }
    AppMethodBeat.o(29683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y
 * JD-Core Version:    0.7.0.1
 */