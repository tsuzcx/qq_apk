package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WalletPayDeductUI$3
  implements h.a
{
  WalletPayDeductUI$3(WalletPayDeductUI paramWalletPayDeductUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.qng.mController.uMN;
    Object localObject = this.qnh;
    String str = WalletPayDeductUI.a(this.qng);
    Bankcard localBankcard1 = WalletPayDeductUI.b(this.qng);
    WalletPayDeductUI.3.1 local1 = new WalletPayDeductUI.3.1(this);
    LinkedList localLinkedList = new LinkedList();
    if (((localObject == null) || (((List)localObject).size() == 0)) && (bk.bl(null)))
    {
      y.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
      return;
    }
    int i;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      for (int j = 0; ((Iterator)localObject).hasNext(); j = k)
      {
        Bankcard localBankcard2 = (Bankcard)((Iterator)localObject).next();
        localLinkedList.add(localBankcard2.field_desc);
        k = j;
        if (localBankcard1 != null)
        {
          k = j;
          if (localBankcard1.equals(localBankcard2)) {
            k = i;
          }
        }
        i += 1;
      }
      k = j;
      if (!bk.bl(null))
      {
        localLinkedList.add(null);
        k = j;
        if (localBankcard1 != null) {}
      }
    }
    for (int k = i;; k = 0)
    {
      h.a(paramView, str, localLinkedList, k, local1);
      return;
      y.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
      localLinkedList.add(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.3
 * JD-Core Version:    0.7.0.1
 */