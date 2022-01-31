package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.a.a;
import java.util.LinkedList;

final class MallEditText$a$2
  implements View.OnClickListener
{
  MallEditText$a$2(MallEditText.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44212);
    a.cfm().cH(null);
    this.pVE.pVy.setInput(null);
    MallEditText.d(this.pVE.pVy).cH(new LinkedList());
    MallEditText.d(this.pVE.pVy).notifyDataSetChanged();
    AppMethodBeat.o(44212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.2
 * JD-Core Version:    0.7.0.1
 */