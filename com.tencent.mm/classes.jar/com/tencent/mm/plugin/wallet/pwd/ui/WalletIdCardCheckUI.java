package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;

@com.tencent.mm.ui.base.a(3)
public class WalletIdCardCheckUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private WalletFormView qpk;
  private TextView qpl;
  private TextView qpm;
  private Button qpn;
  private int qpo = 1;
  
  protected final void bfH()
  {
    y.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
    this.wCh.bfH();
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    this.qpm.setVisibility(4);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_check_id_card;
  }
  
  protected final void initView()
  {
    this.qpk = ((WalletFormView)findViewById(a.f.identity_et));
    this.qpm = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.qpl = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.qpk.setOnInputValidChangeListener(this);
    this.qpk.setOnEditorActionListener(this);
    this.qpm.setVisibility(4);
    this.qpn = ((Button)findViewById(a.f.install_query));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.qpk);
    e(this.qpk, 1, false);
    this.qpn.setOnClickListener(new WalletIdCardCheckUI.2(this));
    this.qpo = o.bVs().bVT();
    Object localObject1 = o.bVs();
    if (((ag)localObject1).qzd != null)
    {
      localObject1 = ((ag)localObject1).qzd.field_cre_name;
      y.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.qpo), localObject1 });
      if (!bk.bl((String)localObject1)) {
        break label300;
      }
      localObject1 = o.bVA().O(this, this.qpo);
    }
    label300:
    for (;;)
    {
      Object localObject2 = this.qpk;
      int i = this.qpo;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).Jd(i);
      }
      this.qpk.setTitleText((String)localObject1);
      this.qpk.bvr();
      if (this.qpo == 1) {
        e(this.qpk, 1, false);
      }
      for (;;)
      {
        localObject1 = o.bVs().aEZ();
        this.qpk.setHint(getString(a.i.wallet_password_setting_digitalcert_hint, new Object[] { e.afm((String)localObject1) }));
        return;
        localObject1 = "";
        break;
        e(this.qpk, 1, true);
      }
    }
  }
  
  public final boolean j(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("Micromsg.WalletIdCardCheckUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof l)))
    {
      paramString = new aa();
      paramString.ckr = 1L;
      paramString.cks = 2L;
      paramString.QX();
      h.a(this, getString(a.i.wallet_password_setting_digitalcert_install_ok), "", getString(a.i.wallet_i_know_it), false, new WalletIdCardCheckUI.3(this));
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_password_setting_digitalcert_install_title);
    kh(1580);
    initView();
    setBackBtn(new WalletIdCardCheckUI.1(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1580);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI
 * JD-Core Version:    0.7.0.1
 */