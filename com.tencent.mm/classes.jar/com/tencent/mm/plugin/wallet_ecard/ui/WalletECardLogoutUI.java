package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.wallet_core.c.r;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private CdnImageView DMh;
  private TextView Pja;
  private LinearLayout Pjb;
  private View Pjc;
  private Button Pjd;
  private String fJC;
  private String fJD;
  private TextView mMe;
  private TextView pPT;
  
  public int getLayoutId()
  {
    return a.g.ecard_logout_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71787);
    this.pPT = ((TextView)findViewById(a.f.elu_title));
    this.Pja = ((TextView)findViewById(a.f.elu_tips_title));
    this.Pjb = ((LinearLayout)findViewById(a.f.elu_tips_layout));
    this.mMe = ((TextView)findViewById(a.f.elu_bottom_link_tv));
    this.DMh = ((CdnImageView)findViewById(a.f.elu_icon_iv));
    this.Pjc = findViewById(a.f.elu_mask_view);
    this.Pjd = ((Button)findViewById(a.f.elu_logout_btn));
    this.Pjd.setOnClickListener(new WalletECardLogoutUI.1(this));
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
    paramBundle = new com.tencent.mm.plugin.wallet_ecard.a.g();
    paramBundle.u(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(71789);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.g))
    {
      paramString = (com.tencent.mm.plugin.wallet_ecard.a.g)paramq;
      paramString.a(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(71783);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.PiG.GGC);
          WalletECardLogoutUI.b(WalletECardLogoutUI.this, paramString.PiG.fvP);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.PiG);
          AppMethodBeat.o(71783);
        }
      }).b(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI
 * JD-Core Version:    0.7.0.1
 */