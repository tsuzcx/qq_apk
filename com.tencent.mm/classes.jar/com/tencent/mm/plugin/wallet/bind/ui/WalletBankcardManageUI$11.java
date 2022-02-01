package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.List;

final class WalletBankcardManageUI$11
  implements AdapterView.OnItemClickListener
{
  WalletBankcardManageUI$11(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(69112);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramAdapterView = (Bankcard)paramAdapterView.getAdapter().getItem(paramInt);
    com.tencent.mm.wallet_core.ui.e.agr(18);
    if (paramAdapterView != null)
    {
      paramView = WalletBankcardManageUI.b(this.CGb);
      if ((paramView.CFq == null) || (paramView.CFq.isEmpty()))
      {
        break label314;
        label106:
        if (!paramAdapterView.eEQ()) {
          break label447;
        }
        if (paramAdapterView.field_wxcreditState != 0) {
          break label417;
        }
        if ((b.b(paramAdapterView)) && (paramAdapterView != null))
        {
          com.tencent.mm.kernel.g.ajD();
          paramView = (String)com.tencent.mm.kernel.g.ajC().ajl().get(196659, null);
          localObject = new StringBuilder();
          if (TextUtils.isEmpty(paramView)) {
            break label404;
          }
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append("&");
          ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
          label192:
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(196659, ((StringBuilder)localObject).toString());
        }
        paramView = new Bundle();
        paramView.putParcelable("key_bankcard", paramAdapterView);
        paramView.putString("key_bank_username", paramAdapterView.field_bizUsername);
        paramView.putString("key_bank_type", paramAdapterView.field_bankcardType);
        com.tencent.mm.wallet_core.a.a(this.CGb, "WXCreditOpenProcess", paramView, null);
        label258:
        com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(1), paramAdapterView.field_bankcardType });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(69112);
      return;
      localObject = paramView.CFq.iterator();
      label314:
      if (!((Iterator)localObject).hasNext()) {
        break label106;
      }
      String str = (String)((Iterator)localObject).next();
      if (!str.equals(paramAdapterView.field_bindSerial)) {
        break;
      }
      ad.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
      paramView.CFq.remove(str);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAG, bt.m(paramView.CFq, ","));
      break label106;
      label404:
      ((StringBuilder)localObject).append(paramAdapterView.field_bankcardType);
      break label192;
      label417:
      paramView = new Bundle();
      paramView.putParcelable("key_bankcard", paramAdapterView);
      com.tencent.mm.wallet_core.a.a(this.CGb, "WXCreditManagerProcess", paramView, null);
      break label258;
      label447:
      if (paramAdapterView.eEV())
      {
        ad.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
        paramView = new Intent();
        paramView.putExtra("key_card_no", paramAdapterView.field_bindSerial);
        d.b(this.CGb, "honey_pay", ".ui.HoneyPayCardBackUI", paramView);
        break label258;
      }
      paramView = t.eFy().eGi();
      if ((paramView.DaP & 0x1000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramView.DaP) });
        if (!bool) {
          break label699;
        }
        ad.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
        com.tencent.mm.kernel.g.ajD();
        paramView = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuP, "");
        com.tencent.mm.kernel.g.ajD();
        paramLong = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuQ, Long.valueOf(0L))).longValue();
        long l = System.currentTimeMillis() / 1000L;
        if ((bt.isNullOrNil(paramView)) || (l - paramLong >= 7200L)) {
          break label671;
        }
        ad.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
        this.CGb.c(paramAdapterView);
        break;
      }
      label671:
      ad.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
      com.tencent.mm.sdk.b.a.IbL.c(new c() {});
      break label258;
      label699:
      this.CGb.d(paramAdapterView);
      break label258;
      this.CGb.eDj();
      com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.11
 * JD-Core Version:    0.7.0.1
 */