package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c$b$4
  implements View.OnFocusChangeListener
{
  public c$b$4(c.b paramb, InstantAutoCompleteTextView paramInstantAutoCompleteTextView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nrT.setHintTextColor(paramView.getContext().getResources().getColor(a.c.confirm_edit_text_color));
      if ((this.nrS.nqg == null) || (this.nrS.nqg.bIl != 2) || (this.nrS.nrR)) {
        break label108;
      }
      y.d(c.access$100(), "clear input");
      this.nrS.nrP.bvr();
      this.nrS.nqg = null;
    }
    for (;;)
    {
      if (bk.bl(this.nrT.getText().toString())) {
        this.nrT.showDropDown();
      }
      return;
      label108:
      if (this.nrS.nrR) {
        this.nrS.nrR = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.b.4
 * JD-Core Version:    0.7.0.1
 */