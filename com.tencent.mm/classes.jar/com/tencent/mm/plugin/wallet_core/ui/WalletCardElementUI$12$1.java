package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.Iterator;
import java.util.List;

final class WalletCardElementUI$12$1
  implements b.a
{
  WalletCardElementUI$12$1(WalletCardElementUI.12 param12, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142499);
    this.jxY.hide();
    if (paramBoolean)
    {
      paramObject1 = (String)paramObject1;
      WalletCardElementUI.f(this.uoX.uoW).setText(paramObject1);
      if (!paramObject1.equals(this.uoX.uoW.getString(2131305029))) {
        break label162;
      }
    }
    label162:
    for (int i = 0;; i = 1)
    {
      paramObject1 = WalletCardElementUI.d(this.uoX.uoW).iterator();
      while (paramObject1.hasNext())
      {
        paramObject2 = (ElementQuery)paramObject1.next();
        if (((i != 0) && (paramObject2.cTv())) || ((i == 0) && (paramObject2.cTh())))
        {
          WalletCardElementUI.a(this.uoX.uoW, paramObject2);
          WalletCardElementUI.g(this.uoX.uoW);
        }
      }
      WalletCardElementUI.a(this.uoX.uoW, this.jxY.dPp());
      AppMethodBeat.o(142499);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.12.1
 * JD-Core Version:    0.7.0.1
 */