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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected TextView CzT;
  protected CheckBox CzU;
  protected Bankcard CzV;
  protected Button jqk;
  protected Orders ygb;
  
  private void eCC()
  {
    AppMethodBeat.i(199205);
    int i = getInput().getInt("key_pay_flag", 0);
    String str1 = getInput().getString("key_pwd1");
    String str2 = getInput().getString("key_verify_code");
    PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHn, 1);
    if ((localPayInfo != null) && (j == 1))
    {
      if (this.CzV == null)
      {
        ad.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dlu, Integer.valueOf(localPayInfo.dCC), "0" });
        doSceneProgress(new c(i, str1, str2, localPayInfo.dlu, localPayInfo.dCC, "0"));
        AppMethodBeat.o(199205);
        return;
      }
      ad.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dlu, Integer.valueOf(localPayInfo.dCC), "1" });
      doSceneProgress(new c(i, str1, str2, localPayInfo.dlu, localPayInfo.dCC, "1"), false);
    }
    next();
    AppMethodBeat.o(199205);
  }
  
  public int getLayoutId()
  {
    return 2131495906;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.CzT = ((TextView)findViewById(2131306874));
    this.jqk = ((Button)findViewById(2131306873));
    if (this.ygb == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.CzT.setText(e.d(this.ygb.dlx, this.ygb.wCF));
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.WalletBalanceResultUI", "click finish btn");
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
    this.CzV = ((Bankcard)getInput().getParcelable("key_bankcard"));
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().s(new Object[] { this.ygb })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.ygb = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    showHomeBtn(false);
    AppMethodBeat.o(68687);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68690);
    if ((paramn instanceof c))
    {
      if (((c)paramn).Cww)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          s.eDp();
          s.eDq().Dbc = bt.aQJ();
          paramString = new yk();
          paramString.dMG.scene = 15;
          paramString.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68686);
              ad.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
              AppMethodBeat.o(68686);
            }
          };
          com.tencent.mm.sdk.b.a.IbL.l(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */