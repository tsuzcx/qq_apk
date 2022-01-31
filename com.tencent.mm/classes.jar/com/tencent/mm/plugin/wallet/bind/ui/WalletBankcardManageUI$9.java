package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    paramAdapterView = (Bankcard)paramAdapterView.getAdapter().getItem(paramInt);
    com.tencent.mm.wallet_core.ui.e.Jc(18);
    label50:
    label331:
    label590:
    if (paramAdapterView != null)
    {
      paramView = WalletBankcardManageUI.b(this.qkk);
      Object localObject;
      if ((paramView.qjz == null) || (paramView.qjz.isEmpty()))
      {
        break label241;
        if (!paramAdapterView.bUP()) {
          break label373;
        }
        if (paramAdapterView.field_wxcreditState != 0) {
          break label344;
        }
        if ((b.a(paramAdapterView)) && (paramAdapterView != null))
        {
          g.DQ();
          paramView = (String)g.DP().Dz().get(196659, null);
          localObject = new StringBuilder();
          if (TextUtils.isEmpty(paramView)) {
            break label331;
          }
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append("&");
          ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
          g.DQ();
          g.DP().Dz().o(196659, ((StringBuilder)localObject).toString());
        }
        paramView = new Bundle();
        paramView.putParcelable("key_bankcard", paramAdapterView);
        paramView.putString("key_bank_username", paramAdapterView.field_bizUsername);
        paramView.putString("key_bank_type", paramAdapterView.field_bankcardType);
        com.tencent.mm.wallet_core.a.a(this.qkk, "WXCreditOpenProcess", paramView, null);
      }
      label344:
      label617:
      for (;;)
      {
        h.nFQ.f(14422, new Object[] { Integer.valueOf(1), paramAdapterView.field_bankcardType });
        return;
        localObject = paramView.qjz.iterator();
        label241:
        if (!((Iterator)localObject).hasNext()) {
          break label50;
        }
        String str = (String)((Iterator)localObject).next();
        if (!str.equals(paramAdapterView.field_bindSerial)) {
          break;
        }
        y.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
        paramView.qjz.remove(str);
        g.DQ();
        g.DP().Dz().c(ac.a.uxt, bk.c(paramView.qjz, ","));
        break label50;
        ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
        break label136;
        paramView = new Bundle();
        paramView.putParcelable("key_bankcard", paramAdapterView);
        com.tencent.mm.wallet_core.a.a(this.qkk, "WXCreditManagerProcess", paramView, null);
        continue;
        label373:
        if (paramAdapterView.bUU())
        {
          y.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
          paramView = new Intent();
          paramView.putExtra("key_card_no", paramAdapterView.field_bindSerial);
          d.b(this.qkk, "honey_pay", ".ui.HoneyPayCardBackUI", paramView);
        }
        else
        {
          paramView = o.bVs().bVR();
          if ((paramView.qza & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            y.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramView.qza) });
            if (!bool) {
              break label617;
            }
            y.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            g.DQ();
            paramView = (String)g.DP().Dz().get(ac.a.usm, "");
            g.DQ();
            paramLong = ((Long)g.DP().Dz().get(ac.a.usn, Long.valueOf(0L))).longValue();
            long l = System.currentTimeMillis() / 1000L;
            if ((bk.bl(paramView)) || (l - paramLong >= 7200L)) {
              break label590;
            }
            y.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
            this.qkk.b(paramAdapterView);
            break;
          }
          y.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
          com.tencent.mm.sdk.b.a.udP.c(new WalletBankcardManageUI.9.1(this, paramAdapterView));
          continue;
          this.qkk.c(paramAdapterView);
        }
      }
    }
    label136:
    this.qkk.bTE();
    h.nFQ.f(14422, new Object[] { Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9
 * JD-Core Version:    0.7.0.1
 */