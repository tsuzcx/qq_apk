package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

final class WalletWXCreditChangeAmountUI$2
  extends BaseAdapter
{
  WalletWXCreditChangeAmountUI$2(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final int getCount()
  {
    return 2;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    paramView = (CheckedTextView)View.inflate(this.rRF, a.g.wallet_list_dialog_item_singlechoice, null);
    if (paramInt == 0)
    {
      paramView.setText(a.i.app_yes);
      if (!WalletWXCreditChangeAmountUI.l(this.rRF)) {
        break label129;
      }
      if ((WalletWXCreditChangeAmountUI.c(this.rRF).rRg == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(this.rRF).lQN))) {
        break label107;
      }
      if (paramInt != 0) {
        break label101;
      }
    }
    for (;;)
    {
      paramView.setChecked(bool1);
      return paramView;
      paramView.setText(a.i.app_no);
      break;
      label101:
      bool1 = false;
    }
    label107:
    if (paramInt != 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return paramView;
    }
    label129:
    if ((WalletWXCreditChangeAmountUI.f(this.rRF).rRg != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(this.rRF).lQN)))
    {
      if (paramInt == 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramView.setChecked(bool1);
        return paramView;
      }
    }
    if (paramInt != 0) {}
    for (bool1 = bool4;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.2
 * JD-Core Version:    0.7.0.1
 */