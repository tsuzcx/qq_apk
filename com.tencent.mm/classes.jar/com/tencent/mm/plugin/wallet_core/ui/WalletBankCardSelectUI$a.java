package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.d;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

final class WalletBankCardSelectUI$a
  implements Comparator<d>
{
  private Collator DtP;
  
  private WalletBankCardSelectUI$a()
  {
    AppMethodBeat.i(70697);
    this.DtP = Collator.getInstance(Locale.getDefault());
    AppMethodBeat.o(70697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.a
 * JD-Core Version:    0.7.0.1
 */