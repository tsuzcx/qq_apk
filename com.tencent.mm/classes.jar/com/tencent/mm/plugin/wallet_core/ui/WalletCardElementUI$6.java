package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.List;

final class WalletCardElementUI$6
  implements AdapterView.OnItemClickListener
{
  WalletCardElementUI$6(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.qCj.dismissDialog(1);
    paramInt = ((Integer)WalletCardElementUI.n(this.qCj).bVd().get(paramInt)).intValue();
    if (WalletCardElementUI.u(this.qCj) != paramInt)
    {
      WalletCardElementUI.i(this.qCj, paramInt);
      WalletCardElementUI.v(this.qCj).setText(((CheckedTextView)paramView).getText().toString());
      WalletCardElementUI.b(WalletCardElementUI.w(this.qCj), WalletCardElementUI.u(this.qCj));
      WalletCardElementUI.w(this.qCj).bvr();
      WalletCardElementUI.g(this.qCj);
      WalletCardElementUI.j(this.qCj, WalletCardElementUI.u(this.qCj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.6
 * JD-Core Version:    0.7.0.1
 */