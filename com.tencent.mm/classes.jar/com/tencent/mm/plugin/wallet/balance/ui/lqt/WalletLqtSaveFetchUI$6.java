package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtSaveFetchUI$6
  implements TextWatcher
{
  boolean qjc = true;
  
  WalletLqtSaveFetchUI$6(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    Object localObject = paramEditable.toString();
    int i = ((String)localObject).indexOf(".");
    int j = ((String)localObject).length();
    long l;
    if ((i >= 0) && (j - i > 3))
    {
      paramEditable.delete(i + 3, j);
      l = e.gJ(paramEditable.toString(), "100");
      if (l <= 0L) {
        break label977;
      }
      if (WalletLqtSaveFetchUI.h(this.qiZ) != 1) {
        break label472;
      }
      if (WalletLqtSaveFetchUI.d(this.qiZ) == null) {
        break label452;
      }
      if (!WalletLqtSaveFetchUI.d(this.qiZ).bUQ()) {
        break label318;
      }
      if ((WalletLqtSaveFetchUI.b(this.qiZ) == null) || (l <= WalletLqtSaveFetchUI.fh(WalletLqtSaveFetchUI.b(this.qiZ).qty, "100"))) {
        break label266;
      }
      WalletLqtSaveFetchUI.m(this.qiZ).setText(this.qiZ.getString(a.i.wallet_lqt_save_balance_not_enough_hint));
      WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(-65536);
      WalletLqtSaveFetchUI.b(this.qiZ, false);
      WalletLqtSaveFetchUI.a(this.qiZ, false);
    }
    for (;;)
    {
      if (l > 0L) {
        break label1105;
      }
      this.qjc = true;
      return;
      if (i > 12)
      {
        paramEditable.delete(12, i);
        break;
      }
      if ((i != -1) || (j <= 12)) {
        break;
      }
      paramEditable.delete(12, j);
      break;
      label266:
      WalletLqtSaveFetchUI.m(this.qiZ).setText(WalletLqtSaveFetchUI.n(this.qiZ));
      WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(Color.parseColor("#888888"));
      WalletLqtSaveFetchUI.b(this.qiZ, true);
      WalletLqtSaveFetchUI.a(this.qiZ, true);
      continue;
      label318:
      if ((WalletLqtSaveFetchUI.d(this.qiZ).field_dayQuotaKind > 0.0D) && (l > WalletLqtSaveFetchUI.fh(WalletLqtSaveFetchUI.d(this.qiZ).field_dayQuotaKind, "100")))
      {
        WalletLqtSaveFetchUI.m(this.qiZ).setText(this.qiZ.getString(a.i.wallet_lqt_save_exceed_bankcard_limit));
        WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(-65536);
        WalletLqtSaveFetchUI.b(this.qiZ, false);
        WalletLqtSaveFetchUI.a(this.qiZ, false);
      }
      else
      {
        WalletLqtSaveFetchUI.m(this.qiZ).setText("");
        WalletLqtSaveFetchUI.b(this.qiZ, true);
        WalletLqtSaveFetchUI.a(this.qiZ, true);
        continue;
        label452:
        WalletLqtSaveFetchUI.b(this.qiZ, true);
        WalletLqtSaveFetchUI.a(this.qiZ, true);
        continue;
        label472:
        if (WalletLqtSaveFetchUI.h(this.qiZ) == 2)
        {
          if ((WalletLqtSaveFetchUI.d(this.qiZ) != null) && (WalletLqtSaveFetchUI.d(this.qiZ).bUQ()))
          {
            i = this.qiZ.getIntent().getIntExtra("lqt_balance", 0);
            j = 1;
          }
          for (;;)
          {
            if (j != 0)
            {
              if (l > i)
              {
                WalletLqtSaveFetchUI.m(this.qiZ).setText(this.qiZ.getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
                WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.qiZ, false);
                WalletLqtSaveFetchUI.o(this.qiZ);
                WalletLqtSaveFetchUI.a(this.qiZ, false);
                break;
                localObject = l.bTj().qfL;
                if (localObject == null)
                {
                  i = 0;
                  j = 0;
                  continue;
                }
                i = ((bae)localObject).twa;
                j = 0;
                continue;
              }
              WalletLqtSaveFetchUI.m(this.qiZ).setText(WalletLqtSaveFetchUI.n(this.qiZ));
              WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(Color.parseColor("#888888"));
              WalletLqtSaveFetchUI.b(this.qiZ, true);
              WalletLqtSaveFetchUI.a(this.qiZ, this.qjc, paramEditable.toString());
              WalletLqtSaveFetchUI.a(this.qiZ, true);
              break;
            }
          }
          if (l > i)
          {
            WalletLqtSaveFetchUI.m(this.qiZ).setText(this.qiZ.getString(a.i.wallet_lqt_fetch_bankcard_money_not_enough_hint));
            WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(-65536);
            WalletLqtSaveFetchUI.b(this.qiZ, false);
            WalletLqtSaveFetchUI.o(this.qiZ);
            WalletLqtSaveFetchUI.a(this.qiZ, false);
          }
          else if ((WalletLqtSaveFetchUI.d(this.qiZ) != null) && (!WalletLqtSaveFetchUI.d(this.qiZ).bUQ()) && (WalletLqtSaveFetchUI.d(this.qiZ).field_dayQuotaKind > 0.0D) && (l > WalletLqtSaveFetchUI.fh(WalletLqtSaveFetchUI.d(this.qiZ).field_dayQuotaKind, "100")))
          {
            WalletLqtSaveFetchUI.m(this.qiZ).setText(this.qiZ.getString(a.i.wallet_lqt_fetch_exceed_bankcard_limit, new Object[] { Double.valueOf(WalletLqtSaveFetchUI.d(this.qiZ).field_dayQuotaKind) }));
            WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(-65536);
            WalletLqtSaveFetchUI.b(this.qiZ, false);
            WalletLqtSaveFetchUI.o(this.qiZ);
            WalletLqtSaveFetchUI.a(this.qiZ, false);
          }
          else
          {
            WalletLqtSaveFetchUI.m(this.qiZ).setText(WalletLqtSaveFetchUI.n(this.qiZ));
            WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(Color.parseColor("#888888"));
            WalletLqtSaveFetchUI.b(this.qiZ, true);
            WalletLqtSaveFetchUI.a(this.qiZ, this.qjc, paramEditable.toString());
            WalletLqtSaveFetchUI.a(this.qiZ, true);
          }
        }
      }
    }
    label977:
    if (WalletLqtSaveFetchUI.h(this.qiZ) == 1) {
      if ((WalletLqtSaveFetchUI.d(this.qiZ) != null) && (WalletLqtSaveFetchUI.d(this.qiZ).bUQ())) {
        WalletLqtSaveFetchUI.m(this.qiZ).setText(WalletLqtSaveFetchUI.n(this.qiZ));
      }
    }
    for (;;)
    {
      WalletLqtSaveFetchUI.m(this.qiZ).setTextColor(Color.parseColor("#888888"));
      WalletLqtSaveFetchUI.b(this.qiZ, false);
      WalletLqtSaveFetchUI.a(this.qiZ, false);
      break;
      WalletLqtSaveFetchUI.m(this.qiZ).setText("");
      continue;
      WalletLqtSaveFetchUI.m(this.qiZ).setText(WalletLqtSaveFetchUI.n(this.qiZ));
      WalletLqtSaveFetchUI.o(this.qiZ);
    }
    label1105:
    this.qjc = false;
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.6
 * JD-Core Version:    0.7.0.1
 */