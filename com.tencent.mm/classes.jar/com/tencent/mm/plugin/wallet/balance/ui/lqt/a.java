package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;

public final class a
  extends o
{
  private a CRQ;
  
  public a(a parama)
  {
    super(2, null);
    this.CRQ = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68736);
    if (this.CRQ != null) {
      this.CRQ.aRM();
    }
    AppMethodBeat.o(68736);
  }
  
  public static abstract interface a
  {
    public abstract void aRM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.a
 * JD-Core Version:    0.7.0.1
 */