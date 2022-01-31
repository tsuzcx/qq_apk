package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class WalletWXCreditChangeAmountUI$11
  extends BaseAdapter
{
  WalletWXCreditChangeAmountUI$11(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  private l Dz(int paramInt)
  {
    return (l)WalletWXCreditChangeAmountUI.j(this.rRF).get(paramInt);
  }
  
  public final int getCount()
  {
    if (WalletWXCreditChangeAmountUI.j(this.rRF) != null) {
      return WalletWXCreditChangeAmountUI.j(this.rRF).size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)View.inflate(this.rRF, a.g.wallet_list_dialog_item_singlechoice, null);
    paramViewGroup = Dz(paramInt);
    paramView.setText(paramViewGroup.desc);
    if (paramViewGroup.rRd != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.11
 * JD-Core Version:    0.7.0.1
 */