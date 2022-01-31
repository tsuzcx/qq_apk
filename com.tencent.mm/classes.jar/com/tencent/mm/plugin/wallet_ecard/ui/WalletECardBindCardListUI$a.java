package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.a.a.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ae;

final class WalletECardBindCardListUI$a
{
  TextView hov;
  
  public WalletECardBindCardListUI$a(WalletECardBindCardListUI paramWalletECardBindCardListUI, View paramView)
  {
    this.hov = ((TextView)paramView.findViewById(a.f.ecard_bind_card_add_main_title_tv));
    paramWalletECardBindCardListUI = (ImageView)paramView.findViewById(a.f.ecard_bind_card_add_main_iv);
    paramView = a.f(paramWalletECardBindCardListUI.getDrawable());
    a.a(paramView, ColorStateList.valueOf(ae.getResources().getColor(a.c.link_color)));
    paramWalletECardBindCardListUI.setImageDrawable(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.a
 * JD-Core Version:    0.7.0.1
 */