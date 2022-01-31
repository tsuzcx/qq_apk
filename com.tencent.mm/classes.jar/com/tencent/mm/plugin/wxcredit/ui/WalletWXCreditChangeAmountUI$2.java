package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxcredit.a.l;

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
    AppMethodBeat.i(48689);
    paramView = (CheckedTextView)View.inflate(this.vIv, 2130971195, null);
    if (paramInt == 0)
    {
      paramView.setText(2131297115);
      if (!WalletWXCreditChangeAmountUI.l(this.vIv)) {
        break label137;
      }
      if ((WalletWXCreditChangeAmountUI.c(this.vIv).vHW == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(this.vIv).ooD))) {
        break label114;
      }
      if (paramInt != 0) {
        break label108;
      }
    }
    for (;;)
    {
      paramView.setChecked(bool1);
      AppMethodBeat.o(48689);
      return paramView;
      paramView.setText(2131297014);
      break;
      label108:
      bool1 = false;
    }
    label114:
    if (paramInt != 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      break;
    }
    label137:
    if ((WalletWXCreditChangeAmountUI.f(this.vIv).vHW != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(this.vIv).ooD)))
    {
      if (paramInt == 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramView.setChecked(bool1);
        break;
      }
    }
    if (paramInt != 0) {}
    for (bool1 = bool4;; bool1 = false)
    {
      paramView.setChecked(bool1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.2
 * JD-Core Version:    0.7.0.1
 */