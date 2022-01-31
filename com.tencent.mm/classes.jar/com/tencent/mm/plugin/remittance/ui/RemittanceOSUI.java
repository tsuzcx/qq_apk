package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements d.a
{
  private c lZV = new RemittanceOSUI.1(this);
  private int nDZ;
  private String nEa;
  private String nEb;
  private String nEc;
  private String nEd;
  private boolean nEe = false;
  
  protected final void LR(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 3);
    this.nEe = true;
  }
  
  protected final void LS(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 3);
    this.nEe = true;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, fu paramfu)
  {
    paramString3 = q.Gl();
    paramString2 = paramString3;
    if (bk.bl(paramString3)) {
      paramString2 = q.Gj();
    }
    g.DQ();
    paramfu = ((j)g.r(j.class)).Fw().abl(this.djD);
    paramString3 = this.djD;
    if ((int)paramfu.dBe != 0) {
      paramString3 = paramfu.Bq();
    }
    paramString1 = new aa(this.nzU, paramString2, this.djD, paramString3, paramString1, this.nDZ);
    paramString1.dIA = "RemittanceProcess";
    a(paramString1, true, true);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.nzU) });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    super.b(paramInt1, paramInt2, paramString, paramm, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof aa)))
    {
      paramString = (aa)paramm;
      if (paramString.nyz <= 0) {
        break label249;
      }
      if (paramString.nzD != 0) {
        break label166;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.nyz) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new RemittanceOSUI.2(this, paramString), new RemittanceOSUI.3(this, paramString));
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        paramString = ((aa)paramm).nyt;
        paramm = new Intent();
        paramm.putExtra("rawUrl", paramString);
        paramm.putExtra("showShare", false);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramm, 3);
      }
      return;
      label166:
      if (paramString.nzD == 1)
      {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.nyz) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new RemittanceOSUI.4(this, paramString), new RemittanceOSUI.5(this, paramString));
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 0;
        continue;
        label249:
        paramInt1 = 0;
      }
    }
  }
  
  public final void bwo() {}
  
  public final void bwq()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(13337, new Object[] { Integer.valueOf(2) });
  }
  
  public final void bwr()
  {
    com.tencent.mm.ui.base.s.makeText(this.mController.uMN, getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.nEa }), 0).show();
  }
  
  public final void bwu()
  {
    if (!bk.bl(this.nEc))
    {
      e.a((TextView)findViewById(a.f.banner_tips), "", this.nEc, this.nEd);
      return;
    }
    y.i("MicroMsg.RemittanceOSUI", "no bulletin data");
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_new_ui;
  }
  
  public final void kk(String paramString) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.djD);
    this.nEe = false;
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.udP.b(this.lZV);
    this.wCh.kh(1622);
    this.wCh.kh(1574);
    initView();
    this.iKG.setTitleText("");
    o.JQ().a(this);
    this.nDZ = getIntent().getIntExtra("os_currency", 0);
    this.nEa = getIntent().getStringExtra("os_currencyuint");
    this.nEb = getIntent().getStringExtra("os_currencywording");
    this.nEc = getIntent().getStringExtra("os_notice");
    this.nEd = getIntent().getStringExtra("os_notice_url");
    this.iKG.setTitleText(this.nEa);
    bwu();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.lZV);
    o.JQ().b(this);
    this.wCh.ki(1622);
    this.wCh.ki(1574);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */