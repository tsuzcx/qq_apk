package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private Button fks;
  private ImageView heN;
  private TextView nwM;
  private Button qoB;
  private LinearLayout qoC;
  private TextView qoD;
  
  private void bUv()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.qoC.removeAllViews();
    if (com.tencent.mm.wallet_core.c.y.cMH().cMI())
    {
      this.qoB.setVisibility(8);
      this.fks.setVisibility(0);
      this.nwM.setText(a.i.wallet_password_setting_digitalcert_succ);
      this.heN.setImageResource(a.e.wallet_cert_installed);
    }
    for (;;)
    {
      localObject = com.tencent.mm.wallet_core.c.y.cMH().wAW;
      if (((Vector)localObject).size() != 0) {
        break;
      }
      this.qoC.setVisibility(8);
      this.qoD.setVisibility(8);
      return;
      this.qoB.setVisibility(0);
      this.fks.setVisibility(8);
      this.nwM.setText(a.i.wallet_password_setting_digitalcert_fail);
      this.heN.setImageResource(a.e.wallet_cert_uninstall);
    }
    this.qoC.setVisibility(0);
    this.qoD.setVisibility(0);
    Object localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      x localx = (x)((Iterator)localObject).next();
      if (localx.wAQ <= 0)
      {
        View localView = View.inflate(this, a.g.wallet_cert_adapter_item, null);
        TextView localTextView1 = (TextView)localView.findViewById(a.f.cert_title);
        TextView localTextView2 = (TextView)localView.findViewById(a.f.cert_summary);
        TextView localTextView3 = (TextView)localView.findViewById(a.f.del_item);
        localTextView1.setText(localx.tVv);
        localTextView2.setText(localx.wAP);
        localTextView3.setTag(localx);
        localTextView3.setOnClickListener(new WalletDigitalCertUI.4(this));
        this.qoC.addView(localView);
      }
    }
    if (this.qoC.getChildCount() == 0)
    {
      this.qoD.setVisibility(8);
      return;
    }
    this.qoD.setVisibility(0);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (!(paramm instanceof e))
    {
      if (!(paramm instanceof com.tencent.mm.wallet_core.c.k)) {
        break label86;
      }
      if (paramInt2 != 0) {
        break label88;
      }
      paramString = new aa();
      paramString.ckr = 2L;
      paramString.cks = 2L;
      paramString.QX();
      h.nFQ.f(13731, new Object[] { Integer.valueOf(11) });
      com.tencent.mm.wallet_core.c.y.cMH().aff(((com.tencent.mm.wallet_core.c.k)paramm).wAr);
    }
    for (;;)
    {
      bUv();
      label86:
      return false;
      label88:
      h.nFQ.f(13731, new Object[] { Integer.valueOf(12) });
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_digital_certui;
  }
  
  public final void initView()
  {
    setMMTitle(a.i.wallet_password_setting_digitalcert);
    this.heN = ((ImageView)findViewById(a.f.cert_icon_iv));
    this.nwM = ((TextView)findViewById(a.f.cert_tip_state));
    this.qoB = ((Button)findViewById(a.f.install_cert));
    this.fks = ((Button)findViewById(a.f.del_cert));
    this.qoC = ((LinearLayout)findViewById(a.f.installed_list));
    this.qoD = ((TextView)findViewById(a.f.installed_list_tip));
    this.qoB.setOnClickListener(new WalletDigitalCertUI.1(this));
    this.fks.setOnClickListener(new WalletDigitalCertUI.2(this));
    setBackBtn(new WalletDigitalCertUI.3(this));
    bUv();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      bool = ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).aSw();
      paramIntent = ae.cqS();
      if (paramIntent == null) {
        break label103;
      }
      str = paramIntent.getString("cpu_id", null);
      paramIntent = paramIntent.getString("uid", null);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      a(new e(bool, str, paramIntent), false, false);
      return;
      label103:
      paramIntent = null;
      str = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1654);
    kh(1568);
    kh(1669);
    initView();
    h.nFQ.f(13731, new Object[] { Integer.valueOf(1) });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1654);
    ki(1568);
    ki(1669);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI
 * JD-Core Version:    0.7.0.1
 */