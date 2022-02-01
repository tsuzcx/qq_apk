package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

public class WalletWXCreditChangeAmountResultUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_change_amount_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72331);
    ((TextView)findViewById(a.f.wallet_wxcredit_amount)).setText(i.X(getInput().getDouble("key_credit_amount")));
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI
 * JD-Core Version:    0.7.0.1
 */