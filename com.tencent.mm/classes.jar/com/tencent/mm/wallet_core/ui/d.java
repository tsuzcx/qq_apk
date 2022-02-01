package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements View.OnClickListener
{
  private View.OnClickListener iu;
  private long lTu = 0L;
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72961);
    long l = System.currentTimeMillis();
    if (l - this.lTu >= 500L)
    {
      this.iu.onClick(paramView);
      this.lTu = l;
    }
    AppMethodBeat.o(72961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */