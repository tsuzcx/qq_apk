package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class WalletCardImportUI$5
  implements View.OnClickListener
{
  WalletCardImportUI$5(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramView.add(this.qCx.getString(a.i.wallet_card_aggreement_user));
    localLinkedList.add(Integer.valueOf(0));
    if ((WalletCardImportUI.c(this.qCx) != null) && (WalletCardImportUI.c(this.qCx).qvx))
    {
      paramView.add(this.qCx.getString(a.i.wallet_card_aggreement_bank));
      localLinkedList.add(Integer.valueOf(1));
    }
    h.a(this.qCx, "", paramView, localLinkedList, "", new WalletCardImportUI.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5
 * JD-Core Version:    0.7.0.1
 */