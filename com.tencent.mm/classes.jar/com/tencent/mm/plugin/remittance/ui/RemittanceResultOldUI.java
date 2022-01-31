package com.tencent.mm.plugin.remittance.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@a(19)
public class RemittanceResultOldUI
  extends RemittanceResultUI
{
  private Orders nEh;
  private String nEi;
  private boolean nEj;
  private int nzY;
  
  private void bwK()
  {
    if (this.BX.containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)this.BX.getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
        localBundle.putString("realname_verify_process_jump_plugin", "remittance");
        localRealnameGuideHelper.b(this, localBundle, new RemittanceResultOldUI.2(this));
        this.BX.remove("key_realname_guide_helper");
      }
      return;
    }
    bwL();
  }
  
  private void bwL()
  {
    cNj().b(this, this.BX);
    new ah().postDelayed(new RemittanceResultOldUI.3(this), 100L);
  }
  
  protected final boolean bwM()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_result_ui;
  }
  
  protected final void initView()
  {
    int k = 1;
    setMMTitle(getString(a.i.remittance_result_title));
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject1 = (TextView)findViewById(a.f.remittance_result_fee);
    if (this.nEh != null) {
      ((TextView)localObject1).setText(e.d(this.nEh.nCq, this.nEh.mOZ));
    }
    Object localObject3 = (PayInfo)this.BX.getParcelable("key_pay_info");
    if (localObject3 == null)
    {
      y.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
      finish();
      return;
    }
    localObject1 = "";
    if (((PayInfo)localObject3).snX != null)
    {
      this.nEj = ((PayInfo)localObject3).snX.getBoolean("extinfo_key_4");
      localObject1 = ((PayInfo)localObject3).snX.getString("extinfo_key_1");
    }
    int i = ((PayInfo)localObject3).bUV;
    this.nzY = i;
    this.nEi = ((String)localObject1);
    Object localObject2 = e.gV((String)localObject1);
    if (i == 31)
    {
      localObject1 = (TextView)findViewById(a.f.remittance_result_receiver_desc);
      localObject2 = getString(a.i.remittance_result_receiver_desc, new Object[] { localObject2 });
      if (!bk.bl((String)localObject2))
      {
        ((TextView)localObject1).setText(j.a(this, (CharSequence)localObject2, ((TextView)localObject1).getTextSize()));
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        findViewById(a.f.remittance_result_f2f_area).setVisibility(8);
        if (this.nEh.nyC > 0.0D)
        {
          localObject1 = getResources().getString(a.i.remittance_result_charge_info, new Object[] { e.d(this.nEh.nyC, this.nEh.mOZ) });
          ((TextView)findViewById(a.f.charge_fee)).setText((CharSequence)localObject1);
          findViewById(a.f.charge_fee_container).setVisibility(0);
        }
        ((Button)findViewById(a.f.remittance_result_next_btn)).setOnClickListener(new RemittanceResultOldUI.1(this));
        ((i)g.r(i.class)).f(this);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = "";
    if (((PayInfo)localObject3).snX != null) {
      localObject1 = ((PayInfo)localObject3).snX.getString("extinfo_key_2");
    }
    if ((i != 32) && (i != 33)) {
      if (!bk.bl((String)localObject1))
      {
        localObject1 = e.afj((String)localObject1);
        localObject1 = (String)localObject2 + "（" + (String)localObject1 + "）";
      }
    }
    for (;;)
    {
      label448:
      localObject2 = (TextView)findViewById(a.f.remittance_result_receiver_desc);
      label504:
      TextView localTextView;
      String str1;
      if (!bk.bl((String)localObject1))
      {
        ((TextView)localObject2).setText(j.a(this, getString(a.i.remittance_result_payer_desc, new Object[] { localObject1 }), ((TextView)localObject2).getTextSize()));
        ((TextView)localObject2).setVisibility(0);
        if ((i != 33) && (i != 32)) {
          break label826;
        }
        localObject1 = findViewById(a.f.remittance_result_f2f_recv_desc_area);
        localObject2 = (TextView)findViewById(a.f.remittance_result_f2f_recv_desc_title);
        localTextView = (TextView)findViewById(a.f.remittance_result_f2f_recv_desc);
        str1 = ((PayInfo)localObject3).snX.getString("extinfo_key_3");
        String str2 = ((PayInfo)localObject3).snX.getString("extinfo_key_8");
        if (bk.bl(str1)) {
          break label802;
        }
        localTextView.setText(j.a(this, str1, localTextView.getTextSize()));
        ((View)localObject1).setVisibility(0);
        if (bk.bl(str2)) {
          break label909;
        }
        ((TextView)localObject2).setText(str2);
        i = 1;
      }
      for (;;)
      {
        label622:
        localObject1 = findViewById(a.f.remittance_result_f2f_payer_desc_area);
        localObject2 = (TextView)findViewById(a.f.remittance_result_f2f_payer_desc_title);
        localTextView = (TextView)findViewById(a.f.remittance_result_f2f_payer_desc);
        str1 = ((PayInfo)localObject3).snX.getString("extinfo_key_6");
        localObject3 = ((PayInfo)localObject3).snX.getString("extinfo_key_7");
        if (!bk.bl((String)localObject3))
        {
          localTextView.setText(j.a(this, (CharSequence)localObject3, localTextView.getTextSize()));
          localTextView.setVisibility(0);
          j = k;
          if (!bk.bl(str1)) {
            ((TextView)localObject2).setText(j.a(this, str1, ((TextView)localObject2).getTextSize()));
          }
        }
        for (int j = k;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label824;
          }
          findViewById(a.f.remittance_result_f2f_area).setVisibility(8);
          break;
          localObject1 = (String)localObject2 + getString(a.i.remittance_without_realname_title);
          break label448;
          ((TextView)localObject2).setVisibility(8);
          break label504;
          label802:
          ((View)localObject1).setVisibility(8);
          i = 0;
          break label622;
          ((View)localObject1).setVisibility(8);
        }
        label824:
        break;
        label826:
        if ((i != 5) || (this.nEh.qwN == null) || (this.nEh.qwN.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.nEh.qwN.get(0)).mOO))) {
          break;
        }
        ((TextView)localObject2).setText(((Orders.Commodity)this.nEh.qwN.get(0)).mOO);
        break;
        label909:
        i = 1;
      }
      localObject1 = localObject2;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    initView();
    if (this.nzY == 31)
    {
      paramBundle = "";
      if (this.nEh.qwN.size() > 0) {
        paramBundle = ((Orders.Commodity)this.nEh.qwN.get(0)).bMY;
      }
      y.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[] { paramBundle });
      b.bvS().bvV().ex(paramBundle, this.nEi);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bwK();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI
 * JD-Core Version:    0.7.0.1
 */