package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class BankRemitHistoryUI$b
{
  TextView eXs;
  TextView gaI;
  TextView nwK;
  TextView nwL;
  TextView nwM;
  CdnImageView nwN;
  
  public BankRemitHistoryUI$b(BankRemitHistoryUI paramBankRemitHistoryUI, View paramView)
  {
    this.nwK = ((TextView)paramView.findViewById(a.f.brhi_header_tv));
    this.gaI = ((TextView)paramView.findViewById(a.f.brhi_desc_tv));
    this.nwL = ((TextView)paramView.findViewById(a.f.brhi_money_tv));
    this.eXs = ((TextView)paramView.findViewById(a.f.brhi_date_tv));
    this.nwM = ((TextView)paramView.findViewById(a.f.brhi_state_tv));
    this.nwN = ((CdnImageView)paramView.findViewById(a.f.brhi_bank_icon_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.b
 * JD-Core Version:    0.7.0.1
 */