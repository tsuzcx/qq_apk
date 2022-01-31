package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxcredit.a.l;
import java.util.List;

final class WalletWXCreditChangeAmountUI$11
  extends BaseAdapter
{
  WalletWXCreditChangeAmountUI$11(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  private l Lr(int paramInt)
  {
    AppMethodBeat.i(48700);
    l locall = (l)WalletWXCreditChangeAmountUI.j(this.vIv).get(paramInt);
    AppMethodBeat.o(48700);
    return locall;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(48699);
    if (WalletWXCreditChangeAmountUI.j(this.vIv) != null)
    {
      int i = WalletWXCreditChangeAmountUI.j(this.vIv).size();
      AppMethodBeat.o(48699);
      return i;
    }
    AppMethodBeat.o(48699);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(48701);
    paramView = (CheckedTextView)View.inflate(this.vIv, 2130971195, null);
    paramViewGroup = Lr(paramInt);
    paramView.setText(paramViewGroup.desc);
    if (paramViewGroup.vHT != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(48701);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.11
 * JD-Core Version:    0.7.0.1
 */