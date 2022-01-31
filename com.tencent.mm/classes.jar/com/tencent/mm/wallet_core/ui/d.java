package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements View.OnClickListener
{
  private long iHv = 0L;
  private View.OnClickListener qaq;
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(49240);
    long l = System.currentTimeMillis();
    if (l - this.iHv >= 500L)
    {
      this.qaq.onClick(paramView);
      this.iHv = l;
    }
    AppMethodBeat.o(49240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */