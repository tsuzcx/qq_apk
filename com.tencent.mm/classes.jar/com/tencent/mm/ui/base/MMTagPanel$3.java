package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMTagPanel$3
  implements View.OnFocusChangeListener
{
  MMTagPanel$3(MMTagPanel paramMMTagPanel) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(106812);
    ab.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (MMTagPanel.e(this.zmE) != null)) {
      MMTagPanel.e(this.zmE).bnq();
    }
    AppMethodBeat.o(106812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.3
 * JD-Core Version:    0.7.0.1
 */