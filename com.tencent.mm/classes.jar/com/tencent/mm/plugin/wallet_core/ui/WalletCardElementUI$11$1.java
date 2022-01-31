package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.Iterator;
import java.util.List;

final class WalletCardElementUI$11$1
  implements b.a
{
  WalletCardElementUI$11$1(WalletCardElementUI.11 param11, b paramb) {}
  
  public final void f(boolean paramBoolean, Object paramObject)
  {
    this.hEL.hide();
    if (paramBoolean)
    {
      paramObject = (String)paramObject;
      WalletCardElementUI.f(this.qCk.qCj).setText(paramObject);
      if (!paramObject.equals(this.qCk.qCj.getString(a.i.wallet_credit_card))) {
        break label154;
      }
    }
    label154:
    for (int i = 0;; i = 1)
    {
      paramObject = WalletCardElementUI.d(this.qCk.qCj).iterator();
      while (paramObject.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramObject.next();
        if (((i != 0) && (localElementQuery.bVc())) || ((i == 0) && (localElementQuery.bUS())))
        {
          WalletCardElementUI.a(this.qCk.qCj, localElementQuery);
          WalletCardElementUI.g(this.qCk.qCj);
        }
      }
      WalletCardElementUI.a(this.qCk.qCj, this.hEL.cKk());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.11.1
 * JD-Core Version:    0.7.0.1
 */