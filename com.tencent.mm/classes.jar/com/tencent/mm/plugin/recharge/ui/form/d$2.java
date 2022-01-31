package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.a.a;
import java.util.LinkedList;

final class d$2
  implements View.OnClickListener
{
  d$2(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44404);
    a.cfm().cH(null);
    d.b(this.pXT).cfK();
    this.pXT.cH(new LinkedList());
    if (d.c(this.pXT) != null) {
      d.c(this.pXT).cfz();
    }
    AppMethodBeat.o(44404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d.2
 * JD-Core Version:    0.7.0.1
 */