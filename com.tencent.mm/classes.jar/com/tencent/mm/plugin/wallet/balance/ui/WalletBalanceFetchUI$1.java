package com.tencent.mm.plugin.wallet.balance.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

final class WalletBalanceFetchUI$1
  implements View.OnClickListener
{
  WalletBalanceFetchUI$1(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void onClick(View paramView)
  {
    this.qgO.VH();
    p.bTK();
    ArrayList localArrayList = p.bTL().bWb();
    p.bTK();
    Object localObject1 = p.bTL().qzh;
    String str = "";
    if (localObject1 != null)
    {
      paramView = ((b)localObject1).qtg;
      str = ((b)localObject1).qtf;
    }
    for (;;)
    {
      Object localObject2 = this.qgO;
      AppCompatActivity localAppCompatActivity = this.qgO.mController.uMN;
      localObject1 = WalletBalanceFetchUI.a(this.qgO);
      WalletBalanceFetchUI.1.1 local1 = new WalletBalanceFetchUI.1.1(this, localArrayList);
      d locald = new d(localAppCompatActivity, 2, true);
      locald.phH = new WalletBalanceFetchUI.11((WalletBalanceFetchUI)localObject2, localArrayList, localAppCompatActivity);
      locald.phI = local1;
      locald.wnm = true;
      localObject2 = LayoutInflater.from(localAppCompatActivity).inflate(a.g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
      if (!bk.bl(str)) {
        ((TextView)((View)localObject2).findViewById(a.f.bfbh_header_title_tv)).setText(str);
      }
      if (!bk.bl(paramView)) {
        ((TextView)((View)localObject2).findViewById(a.f.bfbh_header_desc_tv)).setText(paramView);
      }
      locald.ej((View)localObject2);
      int i = localArrayList.size();
      int j;
      int k;
      if (localObject1 != null)
      {
        j = 0;
        k = i;
        if (j >= localArrayList.size()) {
          break label269;
        }
        if (!((Bankcard)localArrayList.get(j)).field_bindSerial.equals(((Bankcard)localObject1).field_bindSerial)) {
          break label282;
        }
        i = j;
      }
      label269:
      label282:
      for (;;)
      {
        j += 1;
        break;
        k = i;
        locald.wno = k;
        locald.cfU();
        return;
      }
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.1
 * JD-Core Version:    0.7.0.1
 */