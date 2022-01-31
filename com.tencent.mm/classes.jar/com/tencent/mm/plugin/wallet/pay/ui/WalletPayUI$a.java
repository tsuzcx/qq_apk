package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class WalletPayUI$a
{
  protected WalletPayUI$a(WalletPayUI paramWalletPayUI) {}
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(46075);
    this.tXq.tWV.removeAllViews();
    int i;
    ViewGroup.LayoutParams localLayoutParams;
    int j;
    label41:
    View localView;
    TextView localTextView1;
    TextView localTextView2;
    Orders.Commodity localCommodity;
    String str2;
    String str1;
    label290:
    label333:
    if (this.tXq.mCount == 0)
    {
      i = 0;
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      j = 0;
      if (j >= i) {
        break label565;
      }
      localView = ((LayoutInflater)this.tXq.getSystemService("layout_inflater")).inflate(2130971227, null);
      localTextView1 = (TextView)localView.findViewById(2131829265);
      localTextView2 = (TextView)localView.findViewById(2131829258);
      localCommodity = (Orders.Commodity)this.tXq.qrf.ujl.get(j);
      str2 = "";
      str1 = str2;
      if (this.tXq.mPayInfo != null) {
        if ((this.tXq.mPayInfo.cCD != 32) && (this.tXq.mPayInfo.cCD != 33) && (this.tXq.mPayInfo.cCD != 31))
        {
          str1 = str2;
          if (this.tXq.mPayInfo.cCD != 48) {}
        }
        else
        {
          str1 = this.tXq.mPayInfo.wgv.getString("extinfo_key_1", "");
          if (bo.isNullOrNil(str1)) {
            break label443;
          }
          g.RM();
          ad localad = ((j)g.E(j.class)).YA().aru(str1);
          if (localad == null) {
            break label418;
          }
          str1 = localad.Of();
        }
      }
      label252:
      if (localCommodity != null)
      {
        if (bo.isNullOrNil(str1)) {
          break label461;
        }
        localTextView2.setText(str1);
        localTextView2.setVisibility(0);
        ((TextView)localView.findViewById(2131829322)).setVisibility(0);
        if (bo.isNullOrNil(localCommodity.desc)) {
          break label530;
        }
        localTextView1.setText(localCommodity.desc);
        localTextView1.setVisibility(8);
        ((TextView)localView.findViewById(2131829264)).setVisibility(8);
        if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(localCommodity.ppe))) {
          break label555;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      localView.measure(-2, -2);
      this.tXq.tWV.addView(localView);
      j += 1;
      break label41;
      if (this.tXq.tWJ)
      {
        i = this.tXq.mCount;
        break;
      }
      i = 1;
      break;
      label418:
      ab.e(this.tXq.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
      str1 = str2;
      break label252;
      label443:
      ab.e(this.tXq.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
      str1 = str2;
      break label252;
      label461:
      if (!bo.isNullOrNil(localCommodity.ppe))
      {
        localTextView2.setText(localCommodity.ppe);
        localTextView2.setVisibility(0);
        ((TextView)localView.findViewById(2131829322)).setVisibility(0);
        break label290;
      }
      ((TextView)localView.findViewById(2131829322)).setVisibility(8);
      localTextView2.setVisibility(8);
      break label290;
      label530:
      ((TextView)localView.findViewById(2131829264)).setVisibility(8);
      localTextView1.setVisibility(8);
      break label333;
      label555:
      localView.setVisibility(8);
    }
    label565:
    AppMethodBeat.o(46075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.a
 * JD-Core Version:    0.7.0.1
 */