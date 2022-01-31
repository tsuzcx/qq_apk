package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class WalletRealNameVerifyUI$6
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$6(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramView.add(this.qse.getString(a.i.wallet_card_aggreement_user));
    localLinkedList.add(Integer.valueOf(0));
    if ((WalletRealNameVerifyUI.e(this.qse) != null) && (WalletRealNameVerifyUI.e(this.qse).qvx))
    {
      paramView.add(this.qse.getString(a.i.wallet_card_aggreement_bank));
      localLinkedList.add(Integer.valueOf(1));
    }
    h.a(this.qse, "", paramView, localLinkedList, "", new WalletRealNameVerifyUI.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */