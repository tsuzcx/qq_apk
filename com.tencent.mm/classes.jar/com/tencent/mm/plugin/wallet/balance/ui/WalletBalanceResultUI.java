package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Button frP;
  protected TextView lLL;
  public Orders nEh;
  public TextView nvx;
  protected TextView psN;
  public TextView qhs;
  protected TextView qht;
  public CheckBox qhu;
  public Bankcard qhv;
  
  private void bTs()
  {
    if ((this.qhu.getVisibility() == 0) && (this.qhu.isChecked()))
    {
      int i = this.BX.getInt("key_pay_flag", 0);
      String str1 = this.BX.getString("key_pwd1");
      String str2 = this.BX.getString("key_verify_code");
      PayInfo localPayInfo = (PayInfo)this.BX.getParcelable("key_pay_info");
      a(new com.tencent.mm.plugin.wallet.balance.a.a(i, str1, str2, localPayInfo.bMX, localPayInfo.bUV), true, true);
      return;
    }
    cN();
  }
  
  public void aZ()
  {
    Object localObject;
    if (this.nEh != null)
    {
      this.qhs.setText(e.d(this.nEh.nCq, this.nEh.mOZ));
      if ((this.nEh.qwN != null) && (this.nEh.qwN.size() > 0))
      {
        localObject = (Orders.Commodity)this.nEh.qwN.get(0);
        if (bk.bl(((Orders.Commodity)localObject).qxg)) {
          break label200;
        }
        this.nvx.setText(((Orders.Commodity)localObject).mOX + " " + getString(a.i.wallet_pay_bankcard_tail) + ((Orders.Commodity)localObject).qxg);
      }
    }
    for (;;)
    {
      if ((cNj() instanceof b))
      {
        if (this.nEh.nyC <= 0.0D) {
          break;
        }
        findViewById(a.f.wallet_balance_result_fetch_fee_title).setVisibility(0);
        localObject = (TextView)findViewById(a.f.wallet_balance_result_fetch_fee);
        ((TextView)localObject).setText(e.d(this.nEh.nyC, this.nEh.mOZ));
        ((TextView)localObject).setVisibility(0);
      }
      return;
      label200:
      this.nvx.setText(((Orders.Commodity)localObject).mOX);
    }
    y.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.balance.a.a)))
    {
      p.bTK();
      p.bTL().qzk = bk.UX();
      paramString = new tk();
      paramString.ccZ.scene = 15;
      paramString.bFJ = new WalletBalanceResultUI.3(this);
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      cN();
      return true;
    }
    return false;
  }
  
  public final void cN()
  {
    if (!cNk().m(new Object[] { this.nEh })) {
      super.cN();
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_balance_result_ui;
  }
  
  public void initView()
  {
    setMMTitle((String)cNk().vy(0));
    this.psN = ((TextView)findViewById(a.f.wallet_balance_result_desc));
    this.psN.setText(cNk().vy(1));
    this.qht = ((TextView)findViewById(a.f.wallet_balance_result_time_title));
    this.lLL = ((TextView)findViewById(a.f.wallet_balance_result_time));
    Object localObject = cNk().vy(2);
    if (!bk.L((CharSequence)localObject))
    {
      this.qht.setVisibility(0);
      this.lLL.setVisibility(0);
      this.lLL.setText((CharSequence)localObject);
      localObject = (ImageView)findViewById(a.f.wallet_balance_result_logo);
      int i = this.BX.getInt("key_balance_result_logo", -1);
      if (i <= 0) {
        break label312;
      }
      ((ImageView)localObject).setImageResource(i);
      label144:
      this.nvx = ((TextView)findViewById(a.f.wallet_balance_result_bankcard));
      this.qhs = ((TextView)findViewById(a.f.wallet_balance_result_total_fee));
      localObject = (TextView)findViewById(a.f.wallet_balance_result_total_fee_title);
      if ((cNj() instanceof b)) {
        ((TextView)localObject).setText(getString(a.i.wallet_balance_result_total_fee_fetch));
      }
      this.qhu = ((CheckBox)findViewById(a.f.bind_cb));
      this.qhv = ((Bankcard)this.BX.getParcelable("key_bankcard"));
      if (this.qhv == null) {
        break label322;
      }
      this.qhu.setVisibility(8);
    }
    for (;;)
    {
      this.frP = ((Button)findViewById(a.f.next_btn));
      this.frP.setOnClickListener(new WalletBalanceResultUI.1(this));
      showHomeBtn(false);
      enableBackMenu(false);
      return;
      this.qht.setVisibility(8);
      this.lLL.setVisibility(8);
      break;
      label312:
      ((ImageView)localObject).setImageResource(a.h.remittance_received);
      break label144;
      label322:
      this.qhu.setVisibility(0);
    }
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    initView();
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */