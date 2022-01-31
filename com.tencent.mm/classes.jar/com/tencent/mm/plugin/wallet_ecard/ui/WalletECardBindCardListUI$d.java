package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.sdk.platformtools.y;

final class WalletECardBindCardListUI$d
  implements WalletECardBindCardListUI.b
{
  TextView haW;
  TextView irN;
  CdnImageView qKK;
  
  public WalletECardBindCardListUI$d(WalletECardBindCardListUI paramWalletECardBindCardListUI, View paramView)
  {
    this.qKK = ((CdnImageView)paramView.findViewById(a.f.bcard_bind_card_iv));
    this.haW = ((TextView)paramView.findViewById(a.f.bcard_bind_card_title_tv));
    this.irN = ((TextView)paramView.findViewById(a.f.bcard_bind_card_subtitle_tv));
  }
  
  public final void a(View paramView, fv paramfv)
  {
    if (paramfv != null)
    {
      this.qKK.setRoundCorner(true);
      this.qKK.setUrl(paramfv.szU);
      this.haW.setText(String.format("%s %s(%s)", new Object[] { paramfv.lnT, paramfv.ivG, paramfv.szS }));
      this.irN.setText(String.format("%s", new Object[] { paramfv.qqU }));
      if (paramfv.szV)
      {
        y.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramfv.lnT });
        paramView.setEnabled(false);
        this.haW.setTextColor(this.qKH.getResources().getColor(a.c.big_line_color));
        this.irN.setTextColor(this.qKH.getResources().getColor(a.c.big_line_color));
      }
    }
    else
    {
      return;
    }
    paramView.setEnabled(true);
    this.haW.setTextColor(this.qKH.getResources().getColor(a.c.black));
    this.irN.setTextColor(this.qKH.getResources().getColor(a.c.normal_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.d
 * JD-Core Version:    0.7.0.1
 */