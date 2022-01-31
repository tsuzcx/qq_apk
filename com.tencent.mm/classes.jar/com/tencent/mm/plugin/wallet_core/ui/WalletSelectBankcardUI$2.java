package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletSelectBankcardUI$2
  implements AdapterView.OnItemClickListener
{
  WalletSelectBankcardUI$2(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Bankcard)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView != null)
    {
      com.tencent.mm.ui.base.h.a(this.qGy, true, this.qGy.getString(a.i.wallet_select_bankcard_bcp_confirm_num_msg, new Object[] { paramAdapterView.field_desc, paramAdapterView.field_mobile }), this.qGy.getString(a.i.wallet_select_bankcard_bcp_confirm_num_title), this.qGy.getString(a.i.wallet_select_bankcard_bcp_confirm_num_continue), this.qGy.getString(a.i.wallet_select_bankcard_bcp_confirm_num_reset), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WalletSelectBankcardUI.2.this.qGy.BX.putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSelectBankcardUI.a(WalletSelectBankcardUI.2.this.qGy, paramAdapterView);
          com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WalletSelectBankcardUI.2.this.qGy.BX.putBoolean("key_balance_change_phone_need_confirm_phone", true);
          WalletSelectBankcardUI.a(WalletSelectBankcardUI.2.this.qGy, paramAdapterView);
        }
      });
      return;
    }
    this.qGy.BX.putBoolean("key_balance_change_phone_need_confirm_phone", false);
    WalletSelectBankcardUI.a(this.qGy, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.2
 * JD-Core Version:    0.7.0.1
 */