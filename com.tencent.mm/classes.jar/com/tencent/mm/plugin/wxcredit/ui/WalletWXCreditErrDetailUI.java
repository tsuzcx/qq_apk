package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditErrDetailUI
  extends WalletBaseUI
{
  private Bankcard Bfr;
  private String Ddx;
  private TextView Ddy;
  private TextView Ddz;
  
  public int getLayoutId()
  {
    return 2131496048;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72382);
    this.Bfr = ((Bankcard)getInput().getParcelable("key_bankcard"));
    this.Ddx = getInput().getString("key_repayment_url");
    if (this.Bfr == null)
    {
      AppMethodBeat.o(72382);
      return;
    }
    this.Ddy = ((TextView)findViewById(2131306683));
    this.Ddy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72379);
        e.o(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.a(WalletWXCreditErrDetailUI.this), false);
        AppMethodBeat.o(72379);
      }
    });
    this.Ddz = ((TextView)findViewById(2131306684));
    this.Ddz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72380);
        a.k(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.getInput());
        AppMethodBeat.o(72380);
      }
    });
    boolean bool = getInput().getBoolean("key_can_unbind", true);
    TextView localTextView = this.Ddz;
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(72382);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72381);
    super.onCreate(paramBundle);
    setMMTitle(2131765054);
    initView();
    AppMethodBeat.o(72381);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI
 * JD-Core Version:    0.7.0.1
 */