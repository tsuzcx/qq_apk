package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMTagPanel$4
  implements View.OnClickListener
{
  MMTagPanel$4(MMTagPanel paramMMTagPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106813);
    ab.d("MicroMsg.MMTagPanel", "on edittext click");
    this.zmE.dEq();
    if (MMTagPanel.e(this.zmE) != null) {
      MMTagPanel.e(this.zmE).bnq();
    }
    AppMethodBeat.o(106813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.4
 * JD-Core Version:    0.7.0.1
 */