package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Orders CwO;
  protected TextView Hwu;
  protected CheckBox Hwv;
  protected Bankcard Hww;
  protected Button krs;
  
  private void fNr()
  {
    AppMethodBeat.i(213910);
    int i = getInput().getInt("key_pay_flag", 0);
    String str1 = getInput().getString("key_pwd1");
    String str2 = getInput().getString("key_verify_code");
    PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sma, 1);
    if ((localPayInfo != null) && (j == 1))
    {
      if (this.Hww == null)
      {
        Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dDL, Integer.valueOf(localPayInfo.dVv), "0" });
        doSceneProgress(new c(i, str1, str2, localPayInfo.dDL, localPayInfo.dVv, "0"));
        AppMethodBeat.o(213910);
        return;
      }
      Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dDL, Integer.valueOf(localPayInfo.dVv), "1" });
      doSceneProgress(new c(i, str1, str2, localPayInfo.dDL, localPayInfo.dVv, "1"), false);
    }
    next();
    AppMethodBeat.o(213910);
  }
  
  public int getLayoutId()
  {
    return 2131496886;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.Hwu = ((TextView)findViewById(2131310341));
    this.krs = ((Button)findViewById(2131310340));
    if (this.CwO == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.Hwu.setText(f.d(this.CwO.dDO, this.CwO.AOl));
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.Hww = ((Bankcard)getInput().getParcelable("key_bankcard"));
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().r(new Object[] { this.CwO })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.CwO = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    showHomeBtn(false);
    AppMethodBeat.o(68687);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68690);
    if ((paramq instanceof c))
    {
      if (((c)paramq).HsS)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          s.fOg();
          s.fOh().IbS = Util.nowSecond();
          paramString = new zv();
          paramString.efR.scene = 15;
          paramString.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68686);
              Log.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
              AppMethodBeat.o(68686);
            }
          };
          EventCenter.instance.publish(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */