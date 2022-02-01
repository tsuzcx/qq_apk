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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.ao;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

public class WalletWXCreditOpenNotifyUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_notify_ui;
  }
  
  public void initView()
  {
    int i = 0;
    AppMethodBeat.i(72386);
    setMMTitle(a.i.wallet_wxcredit_open_notify_title);
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
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
    ((TextView)findViewById(a.f.wallet_wxcredit_amount)).setText(g.F(getInput().getDouble("key_total_amount")));
    Button localButton = (Button)findViewById(a.f.next_btn);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenNotifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.getInput().getParcelable("key_bankcard"));
        com.tencent.mm.wallet_core.a.a(WalletWXCreditOpenNotifyUI.this, com.tencent.mm.plugin.wxcredit.b.class, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenNotifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    h.aHH();
    h.aHG().aHp().i(196658, Boolean.FALSE);
    initView();
    AppMethodBeat.o(72385);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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