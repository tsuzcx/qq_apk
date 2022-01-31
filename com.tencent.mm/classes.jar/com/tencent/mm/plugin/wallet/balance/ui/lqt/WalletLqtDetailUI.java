package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.a.a.j;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.plugin.wallet.balance.a.a.k.a;
import com.tencent.mm.plugin.wallet.balance.a.a.k.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private Dialog eXA;
  private ah handler = new ah(Looper.getMainLooper());
  private j qhN = (j)C(j.class);
  private k qhO = (k)z(k.class);
  private bhm qhP;
  private ViewGroup qhQ;
  private TextView qhR;
  private WalletTextView qhS;
  private ViewGroup qhT;
  private TextView qhU;
  private TextView qhV;
  private ViewGroup qhW;
  private TextView qhX;
  private WalletTextView qhY;
  private Button qhZ;
  private Button qia;
  private LinearLayout qib;
  private TextView qic;
  private View qid;
  private TextView qie;
  private View qif;
  private View qig;
  private CdnImageView qih;
  private TextView qii;
  private TextView qij;
  private boolean qik = true;
  
  protected final int getLayoutId()
  {
    return a.g.wallet_lqt_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.qik = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.eXA != null) {
        break label106;
      }
      this.eXA = g.b(this, false, null);
    }
    for (;;)
    {
      k.a locala = this.qhO.qfG;
      f.p(paramIntent, Integer.valueOf(this.qhP.sOy)).c(locala).f(new WalletLqtDetailUI.6(this)).a(new WalletLqtDetailUI.5(this));
      return;
      label106:
      this.eXA.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(getResources().getColor(a.c.wallet_lqt_detail_bg));
    czo();
    setMMTitle(getString(a.i.wallet_lqt_title));
    y.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    this.qhQ = ((ViewGroup)findViewById(a.f.detail_container_ll));
    this.qhR = ((TextView)findViewById(a.f.lqt_detail_title_tv));
    this.qhS = ((WalletTextView)findViewById(a.f.lqt_detail_balance_amount_tv));
    this.qhT = ((ViewGroup)findViewById(a.f.detail_balance_layout));
    this.qhU = ((TextView)findViewById(a.f.lqt_detail_balance_rate_hint_tv));
    this.qhV = ((TextView)findViewById(a.f.lqt_detail_balance_rate_tv));
    this.qhW = ((ViewGroup)findViewById(a.f.detail_gain_balance_layout));
    this.qhX = ((TextView)findViewById(a.f.lqt_detail_gain_balance_hint_tv));
    this.qhY = ((WalletTextView)findViewById(a.f.lqt_detail_gain_balance_tv));
    this.qhZ = ((Button)findViewById(a.f.lqt_detail_save_btn));
    this.qia = ((Button)findViewById(a.f.lqt_detail_fetch_btn));
    this.qib = ((LinearLayout)findViewById(a.f.lqt_detail_bottom_info_layout));
    this.qic = ((TextView)findViewById(a.f.lqt_detail_faq_link_tv));
    this.qid = findViewById(a.f.lqt_detail_banner_ll);
    this.qie = ((TextView)findViewById(a.f.lqt_detail_banner_text));
    this.qig = findViewById(a.f.lqt_detail_tiny_app_ll);
    this.qih = ((CdnImageView)findViewById(a.f.tiny_app_logo));
    this.qii = ((TextView)findViewById(a.f.tiny_app_name));
    this.qij = ((TextView)findViewById(a.f.tiny_app_desc));
    this.qif = findViewById(a.f.lqt_detail_tiny_app_gap);
    this.qic.setVisibility(4);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.qhN = null;
    this.qhO = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.qik)
    {
      this.qhQ.setVisibility(8);
      this.eXA = g.b(this, false, null);
      k.b localb = this.qhO.qfF;
      f.cLb().c(localb).f(new WalletLqtDetailUI.7(this)).a(new WalletLqtDetailUI.1(this));
    }
    this.qik = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */