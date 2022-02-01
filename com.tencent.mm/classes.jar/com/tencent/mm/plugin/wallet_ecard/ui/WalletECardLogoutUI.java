package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.protocal.protobuf.fou;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.i;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private CdnImageView KKO;
  private TextView VZO;
  private LinearLayout VZP;
  private View VZQ;
  private Button VZR;
  private String hPf;
  private String hPg;
  private TextView pIM;
  private TextView sUt;
  
  public int getLayoutId()
  {
    return a.g.ecard_logout_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71787);
    this.sUt = ((TextView)findViewById(a.f.elu_title));
    this.VZO = ((TextView)findViewById(a.f.elu_tips_title));
    this.VZP = ((LinearLayout)findViewById(a.f.elu_tips_layout));
    this.pIM = ((TextView)findViewById(a.f.elu_bottom_link_tv));
    this.KKO = ((CdnImageView)findViewById(a.f.elu_icon_iv));
    this.VZQ = findViewById(a.f.elu_mask_view);
    this.VZR = ((Button)findViewById(a.f.elu_logout_btn));
    this.VZR.setOnClickListener(new WalletECardLogoutUI.1(this));
    AppMethodBeat.o(71787);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71786);
    super.onCreate(paramBundle);
    addSceneEndListener(2931);
    initView();
    setMMTitle(a.i.ecard_logout_title);
    Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
    paramBundle = new g();
    paramBundle.r(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(71786);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71788);
    super.onDestroy();
    removeSceneEndListener(2931);
    AppMethodBeat.o(71788);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(71789);
    if ((paramp instanceof g))
    {
      paramString = (g)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(71783);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.VZu.MDt);
          WalletECardLogoutUI.b(WalletECardLogoutUI.this, paramString.VZu.hAk);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.VZu);
          AppMethodBeat.o(71783);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      });
      AppMethodBeat.o(71789);
      return true;
    }
    AppMethodBeat.o(71789);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI
 * JD-Core Version:    0.7.0.1
 */