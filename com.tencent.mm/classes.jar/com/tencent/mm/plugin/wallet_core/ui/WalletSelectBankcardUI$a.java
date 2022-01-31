package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.List;

final class WalletSelectBankcardUI$a
  extends BaseAdapter
{
  private WalletSelectBankcardUI$a(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final int getCount()
  {
    if (WalletSelectBankcardUI.a(this.qGy))
    {
      if (WalletSelectBankcardUI.b(this.qGy) == null) {
        return 1;
      }
      return WalletSelectBankcardUI.b(this.qGy).size() + 1;
    }
    if (WalletSelectBankcardUI.b(this.qGy) == null) {
      return 0;
    }
    return WalletSelectBankcardUI.b(this.qGy).size();
  }
  
  public final Object getItem(int paramInt)
  {
    if ((WalletSelectBankcardUI.b(this.qGy) == null) || (WalletSelectBankcardUI.b(this.qGy).size() <= paramInt)) {
      return null;
    }
    return WalletSelectBankcardUI.b(this.qGy).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Bankcard localBankcard = (Bankcard)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.qGy).inflate(a.g.wallet_select_bankcard_lv_item, paramViewGroup, false);
      paramView = new WalletSelectBankcardUI.a.a(this);
      paramView.qGB = ((TextView)localView.findViewById(a.f.bankcard_desc));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    while (localBankcard != null)
    {
      paramViewGroup.qGB.setText(localBankcard.field_desc);
      return localView;
      paramViewGroup = (WalletSelectBankcardUI.a.a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.qGB.setText(a.i.wallet_select_bankcard_new_bankcard);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.a
 * JD-Core Version:    0.7.0.1
 */