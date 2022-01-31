package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ConfirmScanBankCardResultUI$1
  implements View.OnClickListener
{
  ConfirmScanBankCardResultUI$1(ConfirmScanBankCardResultUI paramConfirmScanBankCardResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81010);
    if (ConfirmScanBankCardResultUI.a(this.qwV) != null)
    {
      paramView = ConfirmScanBankCardResultUI.a(this.qwV).getEditableText().toString();
      if (bo.isNullOrNil(paramView))
      {
        AppMethodBeat.o(81010);
        return;
      }
      ConfirmScanBankCardResultUI.b(this.qwV);
      pw localpw = new pw();
      localpw.cGr.action = 1;
      localpw.cGr.cardNum = paramView;
      a.ymk.l(localpw);
    }
    AppMethodBeat.o(81010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI.1
 * JD-Core Version:    0.7.0.1
 */