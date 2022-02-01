package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.ejh;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private View FTX;
  private TextView Iqs;
  private LinearLayout Iqt;
  private Button Iqu;
  private String dQl;
  private String dQm;
  private TextView jUR;
  private TextView mPa;
  private CdnImageView ymf;
  
  public int getLayoutId()
  {
    return 2131493870;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71787);
    this.mPa = ((TextView)findViewById(2131299938));
    this.Iqs = ((TextView)findViewById(2131299937));
    this.Iqt = ((LinearLayout)findViewById(2131299936));
    this.jUR = ((TextView)findViewById(2131299931));
    this.ymf = ((CdnImageView)findViewById(2131299933));
    this.FTX = findViewById(2131299935);
    this.Iqu = ((Button)findViewById(2131299934));
    this.Iqu.setOnClickListener(new WalletECardLogoutUI.1(this));
    AppMethodBeat.o(71787);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71786);
    super.onCreate(paramBundle);
    addSceneEndListener(2931);
    initView();
    setMMTitle(2131758449);
    Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
    paramBundle = new g();
    paramBundle.t(this);
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
    if ((paramq instanceof g))
    {
      paramString = (g)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(71783);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.IpY.ANo);
          WalletECardLogoutUI.b(WalletECardLogoutUI.this, paramString.IpY.dDj);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.IpY);
          AppMethodBeat.o(71783);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
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