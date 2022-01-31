package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.List;

final class WalletCardImportUI$8
  implements AdapterView.OnItemClickListener
{
  WalletCardImportUI$8(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.qCx.dismissDialog(1);
    paramInt = ((Integer)WalletCardImportUI.c(this.qCx).bVd().get(paramInt)).intValue();
    if (WalletCardImportUI.f(this.qCx) != paramInt)
    {
      WalletCardImportUI.a(this.qCx, paramInt);
      WalletCardImportUI.g(this.qCx).setText(((CheckedTextView)paramView).getText().toString());
      WalletCardImportUI.c(WalletCardImportUI.h(this.qCx), WalletCardImportUI.f(this.qCx));
      WalletCardImportUI.h(this.qCx).bvr();
      WalletCardImportUI.i(this.qCx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.8
 * JD-Core Version:    0.7.0.1
 */