package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class MMTagPanel$6
  implements View.OnClickListener
{
  MMTagPanel$6(MMTagPanel paramMMTagPanel) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(this.uYn)) });
    if (MMTagPanel.f(this.uYn))
    {
      this.uYn.cBd();
      MMTagPanel.a(this.uYn).requestFocus();
      MMTagPanel.a(this.uYn).setSelection(MMTagPanel.a(this.uYn).getText().length());
      ((InputMethodManager)this.uYn.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(this.uYn), 0);
      y.d("MicroMsg.MMTagPanel", "on content click");
      if (MMTagPanel.e(this.uYn) != null) {
        MMTagPanel.e(this.uYn).aJI();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.6
 * JD-Core Version:    0.7.0.1
 */