package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class WalletCardElementUI$7
  extends BaseAdapter
{
  WalletCardElementUI$7(WalletCardElementUI paramWalletCardElementUI) {}
  
  private Integer AT(int paramInt)
  {
    return (Integer)WalletCardElementUI.n(this.qCj).bVd().get(paramInt);
  }
  
  public final int getCount()
  {
    if (WalletCardElementUI.n(this.qCj).bVd() != null) {
      return WalletCardElementUI.n(this.qCj).bVd().size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)View.inflate(this.qCj, a.g.wallet_list_dialog_item_singlechoice, null);
    paramView.setText(o.bVA().O(this.qCj, AT(paramInt).intValue()));
    if (WalletCardElementUI.u(this.qCj) == AT(paramInt).intValue())
    {
      paramView.setChecked(true);
      return paramView;
    }
    paramView.setChecked(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.7
 * JD-Core Version:    0.7.0.1
 */