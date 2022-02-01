package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return 2131496043;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72331);
    ((TextView)findViewById(2131306845)).setText(e.D(getInput().getDouble("key_credit_amount")));
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72329);
        WalletWXCreditChangeAmountResultUI.this.getProcess().a(WalletWXCreditChangeAmountResultUI.this.getContext(), 0, WalletWXCreditChangeAmountResultUI.this.getInput());
        AppMethodBeat.o(72329);
        return true;
      }
    });
    AppMethodBeat.o(72331);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72330);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(72330);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI
 * JD-Core Version:    0.7.0.1
 */