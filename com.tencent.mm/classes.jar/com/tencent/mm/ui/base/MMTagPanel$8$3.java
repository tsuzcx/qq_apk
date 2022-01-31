package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTagPanel$8$3
  implements Runnable
{
  MMTagPanel$8$3(MMTagPanel.8 param8, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106819);
    MMTagPanel.e(this.zmG.zmE).Le(((TextView)this.bTJ).getText().toString());
    AppMethodBeat.o(106819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.8.3
 * JD-Core Version:    0.7.0.1
 */