package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import org.xwalk.core.Log;

public class WalletECardLogoutUI
  extends WalletECardBaseUI
{
  private TextView AwO;
  private LinearLayout AwP;
  private Button AwQ;
  private String dol;
  private String don;
  private TextView ibI;
  private TextView kEu;
  private View lTw;
  private CdnImageView sxt;
  
  public int getLayoutId()
  {
    return 2131493735;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71787);
    this.kEu = ((TextView)findViewById(2131299326));
    this.AwO = ((TextView)findViewById(2131299325));
    this.AwP = ((LinearLayout)findViewById(2131299324));
    this.ibI = ((TextView)findViewById(2131299319));
    this.sxt = ((CdnImageView)findViewById(2131299321));
    this.lTw = findViewById(2131299323);
    this.AwQ = ((Button)findViewById(2131299322));
    this.AwQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71782);
        WalletECardLogoutUI.a(WalletECardLogoutUI.this);
        AppMethodBeat.o(71782);
      }
    });
    AppMethodBeat.o(71787);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71786);
    super.onCreate(paramBundle);
    addSceneEndListener(2931);
    initView();
    setMMTitle(2131758176);
    Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
    paramBundle = new g();
    paramBundle.q(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(71789);
    if ((paramn instanceof g))
    {
      paramString = (g)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(71783);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.Awu.uns);
          WalletECardLogoutUI.b(WalletECardLogoutUI.this, paramString.Awu.dca);
          WalletECardLogoutUI.a(WalletECardLogoutUI.this, paramString.Awu);
          AppMethodBeat.o(71783);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
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