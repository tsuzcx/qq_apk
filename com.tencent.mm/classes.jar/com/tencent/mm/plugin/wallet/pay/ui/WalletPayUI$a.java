package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class WalletPayUI$a
{
  protected WalletPayUI$a(WalletPayUI paramWalletPayUI) {}
  
  public final void notifyDataSetChanged()
  {
    this.qnV.qnE.removeAllViews();
    int i;
    ViewGroup.LayoutParams localLayoutParams;
    int j;
    label36:
    View localView;
    TextView localTextView1;
    TextView localTextView2;
    Orders.Commodity localCommodity;
    String str2;
    String str1;
    label289:
    label333:
    if (this.qnV.mCount == 0)
    {
      i = 0;
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      j = 0;
      if (j >= i) {
        return;
      }
      localView = ((LayoutInflater)this.qnV.getSystemService("layout_inflater")).inflate(a.g.wallet_pay_item, null);
      localTextView1 = (TextView)localView.findViewById(a.f.wallet_order_info_desc);
      localTextView2 = (TextView)localView.findViewById(a.f.wallet_order_info_spid);
      localCommodity = (Orders.Commodity)this.qnV.nEh.qwN.get(j);
      str2 = "";
      str1 = str2;
      if (this.qnV.nDu != null) {
        if ((this.qnV.nDu.bUV != 32) && (this.qnV.nDu.bUV != 33) && (this.qnV.nDu.bUV != 31))
        {
          str1 = str2;
          if (this.qnV.nDu.bUV != 48) {}
        }
        else
        {
          str1 = this.qnV.nDu.snX.getString("extinfo_key_1", "");
          if (bk.bl(str1)) {
            break label445;
          }
          g.DQ();
          ad localad = ((j)g.r(j.class)).Fw().abj(str1);
          if (localad == null) {
            break label418;
          }
          str1 = localad.Bq();
        }
      }
      label250:
      if (localCommodity != null)
      {
        if (bk.bl(str1)) {
          break label458;
        }
        localTextView2.setText(str1);
        localTextView2.setVisibility(0);
        ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(0);
        if (bk.bl(localCommodity.desc)) {
          break label529;
        }
        localTextView1.setText(localCommodity.desc);
        localTextView1.setVisibility(8);
        ((TextView)localView.findViewById(a.f.wallet_order_info_desc_title)).setVisibility(8);
        if ((bk.bl(str1)) && (bk.bl(localCommodity.mOO))) {
          break label555;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      localView.measure(-2, -2);
      this.qnV.qnE.addView(localView);
      j += 1;
      break label36;
      if (this.qnV.qns)
      {
        i = this.qnV.mCount;
        break;
      }
      i = 1;
      break;
      label418:
      y.e("MicroMsg.WalletPayUI", "can not found contact for user::" + str1);
      str1 = str2;
      break label250;
      label445:
      y.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
      str1 = str2;
      break label250;
      label458:
      if (!bk.bl(localCommodity.mOO))
      {
        localTextView2.setText(localCommodity.mOO);
        localTextView2.setVisibility(0);
        ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(0);
        break label289;
      }
      ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(8);
      localTextView2.setVisibility(8);
      break label289;
      label529:
      ((TextView)localView.findViewById(a.f.wallet_order_info_desc_title)).setVisibility(8);
      localTextView1.setVisibility(8);
      break label333;
      label555:
      localView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.a
 * JD-Core Version:    0.7.0.1
 */