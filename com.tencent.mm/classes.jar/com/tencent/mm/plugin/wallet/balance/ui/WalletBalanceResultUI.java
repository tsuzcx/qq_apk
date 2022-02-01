package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Orders OsJ;
  protected TextView VcX;
  protected CheckBox VcY;
  protected Bankcard VcZ;
  protected Button qgp;
  
  private void ieU()
  {
    AppMethodBeat.i(316333);
    int i = getInput().getInt("key_pay_flag", 0);
    String str1 = getInput().getString("key_pwd1");
    String str2 = getInput().getString("key_verify_code");
    PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpu, 1);
    if ((localPayInfo != null) && (j == 1))
    {
      if (this.VcZ == null)
      {
        Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.hAT, Integer.valueOf(localPayInfo.hUR), "0" });
        doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.c(i, str1, str2, localPayInfo.hAT, localPayInfo.hUR, "0"));
        AppMethodBeat.o(316333);
        return;
      }
      Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.hAT, Integer.valueOf(localPayInfo.hUR), "1" });
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.c(i, str1, str2, localPayInfo.hAT, localPayInfo.hUR, "1"), false);
    }
    next();
    AppMethodBeat.o(316333);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_save_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.VcX = ((TextView)findViewById(a.f.wbsr_money_tv));
    this.qgp = ((Button)findViewById(a.f.wbsr_finish_btn));
    if (this.OsJ == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.VcX.setText(i.e(this.OsJ.hAW, this.OsJ.MEq));
    this.qgp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.WalletBalanceResultUI", "click finish btn");
        WalletBalanceResultUI.a(WalletBalanceResultUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68683);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68684);
        WalletBalanceResultUI.a(WalletBalanceResultUI.this);
        AppMethodBeat.o(68684);
        return false;
      }
    });
    this.VcZ = ((Bankcard)getInput().getParcelable("key_bankcard"));
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().t(new Object[] { this.OsJ })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    showHomeBtn(false);
    AppMethodBeat.o(68687);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68690);
    if ((paramp instanceof com.tencent.mm.plugin.wallet.balance.model.c))
    {
      if (((com.tencent.mm.plugin.wallet.balance.model.c)paramp).UZg)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.wallet.model.p.ifO();
          com.tencent.mm.plugin.wallet.model.p.ifP().VKk = Util.nowSecond();
          paramString = new acz();
          paramString.igq.scene = 15;
          paramString.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68686);
              Log.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
              AppMethodBeat.o(68686);
            }
          };
          paramString.publish();
        }
        next();
      }
      AppMethodBeat.o(68690);
      return true;
    }
    AppMethodBeat.o(68690);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */