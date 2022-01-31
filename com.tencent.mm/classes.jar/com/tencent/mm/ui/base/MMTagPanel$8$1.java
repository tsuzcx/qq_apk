package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTagPanel$8$1
  implements Runnable
{
  MMTagPanel$8$1(MMTagPanel.8 param8, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106817);
    MMTagPanel.e(this.zmG.zmE).Lf(((TextView)this.bTJ).getText().toString());
    AppMethodBeat.o(106817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.8.1
 * JD-Core Version:    0.7.0.1
 */