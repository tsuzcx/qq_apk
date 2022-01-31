package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditErrDetailUI
  extends WalletBaseUI
{
  private Bankcard tOQ;
  private String vID;
  private TextView vIE;
  private TextView vIF;
  
  public int getLayoutId()
  {
    return 2130971271;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48739);
    this.tOQ = ((Bankcard)getInput().getParcelable("key_bankcard"));
    this.vID = getInput().getString("key_repayment_url");
    if (this.tOQ == null)
    {
      AppMethodBeat.o(48739);
      return;
    }
    this.vIE = ((TextView)findViewById(2131829433));
    this.vIE.setOnClickListener(new WalletWXCreditErrDetailUI.1(this));
    this.vIF = ((TextView)findViewById(2131829005));
    this.vIF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48737);
        a.j(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.getInput());
        AppMethodBeat.o(48737);
      }
    });
    boolean bool = getInput().getBoolean("key_can_unbind", true);
    TextView localTextView = this.vIF;
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(48739);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48738);
    super.onCreate(paramBundle);
    setMMTitle(2131304867);
    initView();
    AppMethodBeat.o(48738);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI
 * JD-Core Version:    0.7.0.1
 */