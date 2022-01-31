package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private TextView eXw;
  private TextView haW;
  private CdnImageView lmr;
  private String qAc;
  private TextView qKP;
  private LinearLayout qKQ;
  private View qKR;
  private Button qKS;
  private String qjr;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof g))
    {
      paramString = (g)paramm;
      paramString.a(new WalletECardLogoutUI.4(this, paramString)).b(new WalletECardLogoutUI.3(this)).c(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm) {}
      });
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.ecard_logout_ui;
  }
  
  protected final void initView()
  {
    this.haW = ((TextView)findViewById(a.f.elu_title));
    this.qKP = ((TextView)findViewById(a.f.elu_tips_title));
    this.qKQ = ((LinearLayout)findViewById(a.f.elu_tips_layout));
    this.eXw = ((TextView)findViewById(a.f.elu_bottom_link_tv));
    this.lmr = ((CdnImageView)findViewById(a.f.elu_icon_iv));
    this.qKR = findViewById(a.f.elu_mask_view);
    this.qKS = ((Button)findViewById(a.f.elu_logout_btn));
    this.qKS.setOnClickListener(new WalletECardLogoutUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(2931);
    initView();
    setMMTitle(a.i.ecard_logout_title);
    Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
    paramBundle = new g();
    paramBundle.m(this);
    a(paramBundle, true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI
 * JD-Core Version:    0.7.0.1
 */