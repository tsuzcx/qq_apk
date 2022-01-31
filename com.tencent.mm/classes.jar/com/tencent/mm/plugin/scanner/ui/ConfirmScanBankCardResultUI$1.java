package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.h.a.ou;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class ConfirmScanBankCardResultUI$1
  implements View.OnClickListener
{
  ConfirmScanBankCardResultUI$1(ConfirmScanBankCardResultUI paramConfirmScanBankCardResultUI) {}
  
  public final void onClick(View paramView)
  {
    if (ConfirmScanBankCardResultUI.a(this.nJt) != null)
    {
      paramView = ConfirmScanBankCardResultUI.a(this.nJt).getEditableText().toString();
      if (!bk.bl(paramView)) {}
    }
    else
    {
      return;
    }
    ou localou = new ou();
    localou.bYq.action = 1;
    localou.bYq.cardNum = paramView;
    a.udP.m(localou);
    ConfirmScanBankCardResultUI.b(this.nJt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI.1
 * JD-Core Version:    0.7.0.1
 */