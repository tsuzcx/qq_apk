package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class WalletCardImportUI$9
  extends BaseAdapter
{
  WalletCardImportUI$9(WalletCardImportUI paramWalletCardImportUI) {}
  
  private Integer AT(int paramInt)
  {
    return (Integer)WalletCardImportUI.c(this.qCx).bVd().get(paramInt);
  }
  
  public final int getCount()
  {
    if (WalletCardImportUI.c(this.qCx).bVd() != null) {
      return WalletCardImportUI.c(this.qCx).bVd().size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)View.inflate(this.qCx, a.g.wallet_list_dialog_item_singlechoice, null);
    paramView.setText(o.bVA().O(this.qCx, AT(paramInt).intValue()));
    if (WalletCardImportUI.f(this.qCx) == AT(paramInt).intValue()) {
      paramView.setChecked(true);
    }
    for (;;)
    {
      paramView.setBackgroundResource(a.e.comm_list_item_selector);
      return paramView;
      paramView.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.9
 * JD-Core Version:    0.7.0.1
 */