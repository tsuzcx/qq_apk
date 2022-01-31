package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class WalletBankcardManageUI$9
  implements AdapterView.OnItemClickListener
{
  WalletBankcardManageUI$9(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(45773);
    paramAdapterView = (Bankcard)paramAdapterView.getAdapter().getItem(paramInt);
    com.tencent.mm.wallet_core.ui.e.RX(18);
    label55:
    label341:
    label600:
    if (paramAdapterView != null)
    {
      paramView = WalletBankcardManageUI.b(this.tTk);
      Object localObject;
      if ((paramView.tSz == null) || (paramView.tSz.isEmpty()))
      {
        break label251;
        if (!paramAdapterView.cTe()) {
          break label383;
        }
        if (paramAdapterView.field_wxcreditState != 0) {
          break label354;
        }
        if ((b.b(paramAdapterView)) && (paramAdapterView != null))
        {
          g.RM();
          paramView = (String)g.RL().Ru().get(196659, null);
          localObject = new StringBuilder();
          if (TextUtils.isEmpty(paramView)) {
            break label341;
          }
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append("&");
          ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
          g.RM();
          g.RL().Ru().set(196659, ((StringBuilder)localObject).toString());
        }
        paramView = new Bundle();
        paramView.putParcelable("key_bankcard", paramAdapterView);
        paramView.putString("key_bank_username", paramAdapterView.field_bizUsername);
        paramView.putString("key_bank_type", paramAdapterView.field_bankcardType);
        com.tencent.mm.wallet_core.a.a(this.tTk, "WXCreditOpenProcess", paramView, null);
      }
      label354:
      label627:
      for (;;)
      {
        h.qsU.e(14422, new Object[] { Integer.valueOf(1), paramAdapterView.field_bankcardType });
        AppMethodBeat.o(45773);
        return;
        localObject = paramView.tSz.iterator();
        label251:
        if (!((Iterator)localObject).hasNext()) {
          break label55;
        }
        String str = (String)((Iterator)localObject).next();
        if (!str.equals(paramAdapterView.field_bindSerial)) {
          break;
        }
        ab.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
        paramView.tSz.remove(str);
        g.RM();
        g.RL().Ru().set(ac.a.yHC, bo.d(paramView.tSz, ","));
        break label55;
        ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
        break label141;
        paramView = new Bundle();
        paramView.putParcelable("key_bankcard", paramAdapterView);
        com.tencent.mm.wallet_core.a.a(this.tTk, "WXCreditManagerProcess", paramView, null);
        continue;
        label383:
        if (paramAdapterView.cTj())
        {
          ab.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
          paramView = new Intent();
          paramView.putExtra("key_card_no", paramAdapterView.field_bindSerial);
          d.b(this.tTk, "honey_pay", ".ui.HoneyPayCardBackUI", paramView);
        }
        else
        {
          paramView = t.cTN().cUt();
          if ((paramView.ulJ & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            ab.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramView.ulJ) });
            if (!bool) {
              break label627;
            }
            ab.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            g.RM();
            paramView = (String)g.RL().Ru().get(ac.a.yCm, "");
            g.RM();
            paramLong = ((Long)g.RL().Ru().get(ac.a.yCn, Long.valueOf(0L))).longValue();
            long l = System.currentTimeMillis() / 1000L;
            if ((bo.isNullOrNil(paramView)) || (l - paramLong >= 7200L)) {
              break label600;
            }
            ab.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
            this.tTk.c(paramAdapterView);
            break;
          }
          ab.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
          com.tencent.mm.sdk.b.a.ymk.c(new WalletBankcardManageUI.9.1(this, paramAdapterView));
          continue;
          this.tTk.d(paramAdapterView);
        }
      }
    }
    label141:
    this.tTk.cRA();
    h.qsU.e(14422, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(45773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9
 * JD-Core Version:    0.7.0.1
 */