package com.tencent.mm.plugin.wallet.balance.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.d;
import java.util.ArrayList;
import java.util.List;

final class WalletBalanceFetchUI$12
  implements View.OnClickListener
{
  WalletBalanceFetchUI$12(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(45367);
    this.tOj.hideTenpayKB();
    s.cRG();
    ArrayList localArrayList = s.cRH().cUH();
    s.cRG();
    Object localObject1 = s.cRH().ulR;
    String str = "";
    if (localObject1 != null)
    {
      paramView = ((c)localObject1).ufr;
      str = ((c)localObject1).ufq;
    }
    for (;;)
    {
      if (localArrayList == null)
      {
        ab.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
        AppMethodBeat.o(45367);
        return;
      }
      Object localObject2 = this.tOj;
      AppCompatActivity localAppCompatActivity = this.tOj.getContext();
      localObject1 = WalletBalanceFetchUI.b(this.tOj);
      WalletBalanceFetchUI.12.1 local1 = new WalletBalanceFetchUI.12.1(this, localArrayList);
      d locald = new d(localAppCompatActivity, 2, true);
      locald.sao = new WalletBalanceFetchUI.11((WalletBalanceFetchUI)localObject2, localArrayList, localAppCompatActivity);
      locald.sap = local1;
      locald.AHi = true;
      localObject2 = LayoutInflater.from(localAppCompatActivity).inflate(2130971126, null);
      if (!bo.isNullOrNil(str)) {
        ((TextView)((View)localObject2).findViewById(2131828929)).setText(str);
      }
      if (!bo.isNullOrNil(paramView)) {
        ((TextView)((View)localObject2).findViewById(2131828930)).setText(paramView);
      }
      locald.G((View)localObject2, false);
      int i = localArrayList.size();
      int k;
      if (localObject1 != null)
      {
        k = i;
        if (j >= localArrayList.size()) {
          break label287;
        }
        if (!((Bankcard)localArrayList.get(j)).field_bindSerial.equals(((Bankcard)localObject1).field_bindSerial)) {
          break label305;
        }
        i = j;
      }
      label287:
      label305:
      for (;;)
      {
        j += 1;
        break;
        k = i;
        locald.udx = k;
        locald.crd();
        AppMethodBeat.o(45367);
        return;
      }
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.12
 * JD-Core Version:    0.7.0.1
 */