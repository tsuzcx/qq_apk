package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.e;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private TextView gpt;
  private TextView iJG;
  private View jdA;
  private CdnImageView nJN;
  private String tSr;
  private String umN;
  private TextView uzM;
  private LinearLayout uzN;
  private Button uzO;
  
  public int getLayoutId()
  {
    return 2130969346;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48152);
    this.iJG = ((TextView)findViewById(2131823485));
    this.uzM = ((TextView)findViewById(2131823486));
    this.uzN = ((LinearLayout)findViewById(2131823487));
    this.gpt = ((TextView)findViewById(2131823489));
    this.nJN = ((CdnImageView)findViewById(2131823484));
    this.jdA = findViewById(2131823490);
    this.uzO = ((Button)findViewById(2131823488));
    this.uzO.setOnClickListener(new WalletECardLogoutUI.1(this));
    AppMethodBeat.o(48152);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48151);
    super.onCreate(paramBundle);
    addSceneEndListener(2931);
    initView();
    setMMTitle(2131299071);
    Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
    paramBundle = new g();
    paramBundle.o(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(48151);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48153);
    super.onDestroy();
    removeSceneEndListener(2931);
    AppMethodBeat.o(48153);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48154);
    if ((paramm instanceof g))
    {
      paramString = (g)paramm;
      paramString.a(new WalletECardLogoutUI.4(this, paramString)).b(new WalletECardLogoutUI.3(this)).c(new p.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm) {}
      });
      AppMethodBeat.o(48154);
      return true;
    }
    AppMethodBeat.o(48154);
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