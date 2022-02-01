package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.storage.ae;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenNotifyUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return 2131496049;
  }
  
  public void initView()
  {
    int i = 0;
    AppMethodBeat.i(72386);
    setMMTitle(2131766012);
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72383);
        WalletWXCreditOpenNotifyUI.this.setResult(-1);
        WalletWXCreditOpenNotifyUI.this.finish();
        AppMethodBeat.o(72383);
        return true;
      }
    });
    ((TextView)findViewById(2131306845)).setText(com.tencent.mm.wallet_core.ui.e.D(getInput().getDouble("key_total_amount")));
    Button localButton = (Button)findViewById(2131302852);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72384);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.getInput().getParcelable("key_bankcard"));
        a.a(WalletWXCreditOpenNotifyUI.this, b.class, paramAnonymousView);
        AppMethodBeat.o(72384);
      }
    });
    if (getInput().getBoolean("key_can_upgrade_amount", true)) {}
    for (;;)
    {
      localButton.setVisibility(i);
      AppMethodBeat.o(72386);
      return;
      i = 8;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72385);
    super.onCreate(paramBundle);
    g.agS();
    g.agR().agA().set(196658, Boolean.FALSE);
    initView();
    AppMethodBeat.o(72385);
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI
 * JD-Core Version:    0.7.0.1
 */