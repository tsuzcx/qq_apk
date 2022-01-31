package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.ui.base.sortview.d;

final class WalletBankCardSelectUI$1
  implements AdapterView.OnItemClickListener
{
  WalletBankCardSelectUI$1(WalletBankCardSelectUI paramWalletBankCardSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (d)paramAdapterView.getAdapter().getItem(paramInt);
    paramAdapterView = this.qAo;
    paramView = (BankCardSelectSortView.a)paramView.data;
    if (paramView != null)
    {
      paramAdapterView.XM();
      Intent localIntent = new Intent();
      localIntent.putExtra("bank_name", paramView.mOX);
      paramAdapterView.setResult(-1, localIntent);
      paramAdapterView.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.1
 * JD-Core Version:    0.7.0.1
 */