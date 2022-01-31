package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class MMTagPanel$6
  implements View.OnClickListener
{
  MMTagPanel$6(MMTagPanel paramMMTagPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106815);
    ab.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(this.zmE)) });
    if (MMTagPanel.f(this.zmE))
    {
      this.zmE.dEq();
      MMTagPanel.a(this.zmE).requestFocus();
      MMTagPanel.a(this.zmE).setSelection(MMTagPanel.a(this.zmE).getText().length());
      ((InputMethodManager)this.zmE.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(this.zmE), 0);
      ab.d("MicroMsg.MMTagPanel", "on content click");
      if (MMTagPanel.e(this.zmE) != null) {
        MMTagPanel.e(this.zmE).bnq();
      }
    }
    AppMethodBeat.o(106815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.6
 * JD-Core Version:    0.7.0.1
 */