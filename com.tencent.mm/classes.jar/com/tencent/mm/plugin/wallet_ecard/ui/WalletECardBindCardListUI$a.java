package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.graphics.drawable.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class WalletECardBindCardListUI$a
{
  TextView jaY;
  
  public WalletECardBindCardListUI$a(WalletECardBindCardListUI paramWalletECardBindCardListUI, View paramView)
  {
    AppMethodBeat.i(48117);
    this.jaY = ((TextView)paramView.findViewById(2131823472));
    paramWalletECardBindCardListUI = (ImageView)paramView.findViewById(2131823471);
    paramView = a.e(paramWalletECardBindCardListUI.getDrawable());
    a.a(paramView, ColorStateList.valueOf(ah.getResources().getColor(2131690214)));
    paramWalletECardBindCardListUI.setImageDrawable(paramView);
    AppMethodBeat.o(48117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.a
 * JD-Core Version:    0.7.0.1
 */