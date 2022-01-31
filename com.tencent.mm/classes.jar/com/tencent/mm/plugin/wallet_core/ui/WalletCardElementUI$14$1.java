package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$14$1
  implements b.a
{
  WalletCardElementUI$14$1(WalletCardElementUI.14 param14, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142500);
    if (paramBoolean)
    {
      WalletCardElementUI.i(this.uoY.uoW).setText((String)paramObject1);
      WalletCardElementUI.b(this.uoY.uoW, this.val$optionPicker.dPp());
      WalletCardElementUI.b(this.uoY.uoW);
    }
    this.val$optionPicker.hide();
    AppMethodBeat.o(142500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.14.1
 * JD-Core Version:    0.7.0.1
 */