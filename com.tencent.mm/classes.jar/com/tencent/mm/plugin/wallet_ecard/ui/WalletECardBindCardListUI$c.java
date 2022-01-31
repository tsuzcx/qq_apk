package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class WalletECardBindCardListUI$c
  extends BaseAdapter
{
  public final int qKI = 0;
  public final int qKJ = 1;
  
  private WalletECardBindCardListUI$c(WalletECardBindCardListUI paramWalletECardBindCardListUI) {}
  
  public final int getCount()
  {
    return WalletECardBindCardListUI.f(this.qKH).size() + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt < WalletECardBindCardListUI.f(this.qKH).size()) {
      return WalletECardBindCardListUI.f(this.qKH).get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt >= WalletECardBindCardListUI.f(this.qKH).size()) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.qKH.mController.uMN).inflate(a.g.ecard_bind_card_list_item_add, paramViewGroup, false);
        localView.setTag(new WalletECardBindCardListUI.a(this.qKH, localView));
      }
      ((WalletECardBindCardListUI.a)localView.getTag()).hov.setText(a.i.ecard_bind_card_add_other_debit_card);
      return localView;
    }
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.qKH.mController.uMN).inflate(a.g.ecard_bind_card_list_item, paramViewGroup, false);
      localView.setTag(new WalletECardBindCardListUI.d(this.qKH, localView));
    }
    ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (fv)getItem(paramInt));
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    fv localfv = (fv)getItem(paramInt);
    if (localfv != null) {
      return !localfv.szV;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.c
 * JD-Core Version:    0.7.0.1
 */