package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button fpF;
  private com.tencent.mm.plugin.ag.a gkr = null;
  private PayInfo nDu;
  private Orders nEh;
  private int qGT = 60000;
  protected WalletFormView qGU = null;
  private Button qGV;
  private String qGW;
  private String qGX;
  private boolean qGY = false;
  private a qGZ = null;
  private TextView qHa;
  private TextView qHb;
  private boolean qHc = false;
  private boolean qHd = true;
  private com.tencent.mm.plugin.wallet_core.model.h qHe = new com.tencent.mm.plugin.wallet_core.model.h();
  private l.a qHf = new WalletVerifyCodeUI.2(this);
  private Authen qkD;
  
  protected final boolean bTZ()
  {
    boolean bool = getIntent().getBooleanExtra("key_need_confirm_finish", false);
    if (((this.nDu != null) && (this.nDu.kPR)) || (bool)) {
      return true;
    }
    return super.bTZ();
  }
  
  protected final String bWZ()
  {
    String str = bk.aM(this.BX.getString("key_mobile"), "");
    if (bk.bl(str))
    {
      Bankcard localBankcard = (Bankcard)this.BX.getParcelable("key_bankcard");
      if (localBankcard != null) {
        return localBankcard.field_mobile;
      }
    }
    return str;
  }
  
  protected final void bXa()
  {
    int j = 2;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.h.nFQ;
    int i;
    if ((this.nDu != null) && (this.nDu.bUV != 0))
    {
      i = 1;
      if (!this.qGY) {
        break label170;
      }
      label40:
      ((com.tencent.mm.plugin.report.service.h)localObject).f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.qGY = true;
      this.qGV.setClickable(false);
      this.qGV.setEnabled(false);
      if (this.qGZ != null)
      {
        this.qGZ.cancel();
        this.qGZ = null;
      }
      localObject = new a(this.qGT);
      this.qGZ = ((a)localObject);
      ((a)localObject).start();
      if (this.gkr != null) {
        this.gkr.start();
      }
      if (!cNk().t(new Object[] { this.qGW })) {
        break label175;
      }
    }
    label170:
    label175:
    while (of(false))
    {
      return;
      i = 2;
      break;
      j = 1;
      break label40;
    }
    this.qkD = ((Authen)this.BX.getParcelable("key_authen"));
    if (this.qkD == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      return;
    }
    com.tencent.mm.plugin.wallet_core.e.c.bXt();
  }
  
  protected final void bXb()
  {
    Bundle localBundle = this.BX;
    Object localObject = this.BX.getString("key_pwd1");
    this.qGW = this.qGU.getText();
    p localp = new p();
    localp.feN = ((String)localObject);
    localp.nqa = this.nDu;
    localp.qyu = this.qGW;
    localp.token = bk.aM(this.BX.getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localp.mOb = ((Bankcard)localObject).field_bankcardType;
      localp.mOc = ((Bankcard)localObject).field_bindSerial;
      localp.qsQ = bk.aM(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localp.nqa + " mVerifyCode: " + this.qGW);
      localBundle.putString("key_verify_code", this.qGW);
      com.tencent.mm.wallet_core.a.aj(this);
      boolean bool = cNk().m(new Object[] { this.qGW, localp });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "do verify result : " + bool);
      return;
      localp.mOb = this.BX.getString("key_bank_type");
      if (bk.bl(localp.mOb)) {
        localp.mOb = this.BX.getString("key_bind_card_type", "");
      }
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramm instanceof l))
    {
      if ((paramInt2 != 0) && (((l)paramm).bZB)) {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, null, false, new WalletVerifyCodeUI.3(this));
      }
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.wallet_core.a.aj(this);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
      {
        this.BX.putBoolean("intent_bind_end", true);
        com.tencent.mm.ui.base.h.bC(this, getString(a.i.wallet_bank_card_bind_success_tips));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.q)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.wallet_core.e.c.bXu()) });
      }
      if ((this.qkD != null) && ((paramm instanceof j)))
      {
        paramString = ((j)paramm).getToken();
        if (!bk.bl(paramString)) {
          this.BX.putString("kreq_token", paramString);
        }
      }
      if (paramInt1 != 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
        com.tencent.mm.wallet_core.a.j(this, this.BX);
        finish();
        return true;
        if (!(paramm instanceof n))
        {
          if (paramString.c(this, null))
          {
            a(new com.tencent.mm.plugin.wallet_core.c.y(bTO(), 13), true, false);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
          }
        }
        else {
          paramInt1 = 0;
        }
      }
      else
      {
        return false;
      }
      paramInt1 = 1;
    }
  }
  
  public final void gG(boolean paramBoolean)
  {
    if (this.qGU.eq(null))
    {
      this.fpF.setEnabled(true);
      this.fpF.setClickable(true);
      return;
    }
    this.fpF.setEnabled(false);
    this.fpF.setClickable(false);
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_verify_code;
  }
  
  protected final void initView()
  {
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aj(this);
    final Bankcard localBankcard = (Bankcard)this.BX.getParcelable("key_bankcard");
    this.qHa = ((TextView)findViewById(a.f.bind_wallet_verify_hint));
    this.qHb = ((TextView)findViewById(a.f.bind_wallet_verify_mobile_tv));
    Object localObject2 = bWZ();
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2))
    {
      localObject1 = localObject2;
      if (localBankcard != null)
      {
        localObject1 = localBankcard.field_mobile;
        this.BX.putString("key_mobile", (String)localObject1);
      }
    }
    this.qHb.setText(getString(a.i.wallet_receive_verify_code_phone, new Object[] { localObject1 }));
    localObject2 = cNl();
    TextView localTextView;
    boolean bool2;
    if (!bk.L((CharSequence)localObject2))
    {
      this.qHa.setText((CharSequence)localObject2);
      this.qGU = ((WalletFormView)findViewById(a.f.bind_mcontact_verify_num));
      this.qGU.setOnInputValidChangeListener(this);
      this.qGV = ((Button)findViewById(a.f.get_verify_btn));
      this.qGV.setOnClickListener(new WalletVerifyCodeUI.5(this, localBankcard));
      this.qGV.setClickable(false);
      this.qGV.setEnabled(false);
      if (this.qGZ != null)
      {
        this.qGZ.cancel();
        this.qGZ = null;
      }
      localObject1 = new a(this.qGT);
      this.qGZ = ((a)localObject1);
      ((a)localObject1).start();
      this.fpF = ((Button)findViewById(a.f.bind_mcontact_verify_btn));
      this.fpF.setOnClickListener(new WalletVerifyCodeUI.6(this));
      localTextView = (TextView)findViewById(a.f.bind_wallet_reset_mobile);
      boolean bool1 = this.BX.getBoolean("key_is_changing_balance_phone_num");
      bool2 = this.BX.getBoolean("key_need_show_switch_phone", false);
      if ((!bool1) || (bool2)) {
        break label476;
      }
      localTextView.setVisibility(8);
      label335:
      localObject1 = (PayInfo)this.BX.getParcelable("key_pay_info");
      if (localObject1 == null) {
        break label659;
      }
    }
    label659:
    for (int i = ((PayInfo)localObject1).bUV;; i = 0)
    {
      if (bool2)
      {
        localTextView.setText(a.i.wallet_verify_code_get_failed_title);
        localTextView.setOnClickListener(new WalletVerifyCodeUI.7(this, localBankcard));
      }
      for (;;)
      {
        this.qGU.requestFocus();
        localObject1 = this.BX.getString("key_QADNA_URL");
        if (!bk.bl((String)localObject1)) {
          addIconOptionMenu(0, a.e.wallet_qanda_icon, new WalletVerifyCodeUI.11(this, (String)localObject1));
        }
        setBackBtn(new WalletVerifyCodeUI.12(this));
        return;
        this.qHa.setText(String.format(getString(a.i.wallet_verify_code_common_hint), new Object[] { localObject1 }));
        break;
        label476:
        localTextView.setVisibility(0);
        break label335;
        if ((localc == null) || (!localc.cMp()) || (i == 11) || (i == 21)) {
          break label609;
        }
        if ((!localBankcard.bUQ()) && (!localBankcard.bUR()))
        {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              com.tencent.mm.ui.base.h.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(a.i.wallet_pay_reset_info_tips, new Object[] { localBankcard.field_desc, localBankcard.field_mobile }), "", WalletVerifyCodeUI.this.getString(a.i.wallet_pay_reset_info), WalletVerifyCodeUI.this.getString(a.i.app_cancel), new WalletVerifyCodeUI.8.1(this), null);
            }
          });
        }
        else
        {
          localObject2 = this.BX.getString("key_verify_tail_wording", getString(a.i.wallet_verify_code_get_failed_title));
          localObject1 = localObject2;
          if (bk.bl((String)localObject2)) {
            localObject1 = getString(a.i.wallet_verify_code_get_failed_title);
          }
          localTextView.setText((CharSequence)localObject1);
          localTextView.setOnClickListener(new WalletVerifyCodeUI.9(this, localBankcard));
        }
      }
      label609:
      if (com.tencent.mm.model.q.Gw()) {}
      for (localObject1 = getString(a.i.wallet_verify_code_get_failed_payu);; localObject1 = getString(a.i.wallet_verify_code_get_failed))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setOnClickListener(new WalletVerifyCodeUI.10(this));
        break;
      }
    }
  }
  
  public final boolean j(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramm });
    if (((paramm instanceof l)) && (paramInt2 == 0))
    {
      this.qHc = true;
      com.tencent.mm.ui.base.s.makeText(this, a.i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 2;
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_verify_phone);
    this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    this.qGX = this.BX.getString("key_bank_phone");
    this.gkr = new com.tencent.mm.plugin.ag.a(this);
    this.gkr.fiZ = getResources().getStringArray(a.b.wallet_sms_content);
    this.gkr.oiY = new WalletVerifyCodeUI.1(this);
    this.gkr.start();
    this.qHe = new com.tencent.mm.plugin.wallet_core.model.h(this.BX);
    this.qGY = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.h.nFQ;
    int i;
    if ((this.nDu != null) && (this.nDu.bUV != 0))
    {
      i = 1;
      if (!this.qGY) {
        break label341;
      }
    }
    for (;;)
    {
      paramBundle.f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.plugin.wallet_core.e.c.bXt();
      com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 4);
      if (this.qHe.bUZ())
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13731, new Object[] { Integer.valueOf(5) });
        if (!bk.bl(this.qHe.quI.title)) {
          setMMTitle(this.qHe.quI.title);
        }
        if (this.qHa != null) {
          this.qHa.setText(getString(a.i.wallet_verify_code_install_cert_hint));
        }
        if ((this.fpF != null) && (!bk.bl(this.qHe.quI.wAj))) {
          this.fpF.setText(this.qHe.quI.wAj);
        }
      }
      this.wCh.kh(1580);
      return;
      i = 2;
      break;
      label341:
      j = 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.gkr != null) {
      this.gkr.stop();
    }
    this.wCh.ki(1580);
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.gkr != null) {
      this.gkr.stop();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] != 0) || (this.gkr == null));
    this.gkr.start();
  }
  
  final class a
    extends CountDownTimer
  {
    public a(long paramLong)
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setClickable(true);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setEnabled(true);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(a.i.wallet_verify_get_more_one));
    }
    
    public final void onTick(long paramLong)
    {
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(a.i.wallet_verify_get_more_one) + "(" + paramLong / 1000L + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */