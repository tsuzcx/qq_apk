package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.n;

public final class a
  extends n
{
  private a.a tPa;
  
  public a(a.a parama)
  {
    super(2, null);
    this.tPa = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45498);
    if (this.tPa != null) {
      this.tPa.aoW();
    }
    AppMethodBeat.o(45498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.a
 * JD-Core Version:    0.7.0.1
 */