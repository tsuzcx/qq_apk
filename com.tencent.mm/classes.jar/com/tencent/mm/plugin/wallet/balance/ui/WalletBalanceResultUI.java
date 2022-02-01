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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Bankcard CRA;
  protected TextView CRy;
  protected CheckBox CRz;
  protected Button jtd;
  protected Orders yvS;
  
  private void eGj()
  {
    AppMethodBeat.i(190062);
    int i = getInput().getInt("key_pay_flag", 0);
    String str1 = getInput().getString("key_pwd1");
    String str2 = getInput().getString("key_verify_code");
    PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOT, 1);
    if ((localPayInfo != null) && (j == 1))
    {
      if (this.CRA == null)
      {
        ae.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dmw, Integer.valueOf(localPayInfo.dDH), "0" });
        doSceneProgress(new c(i, str1, str2, localPayInfo.dmw, localPayInfo.dDH, "0"));
        AppMethodBeat.o(190062);
        return;
      }
      ae.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.dmw, Integer.valueOf(localPayInfo.dDH), "1" });
      doSceneProgress(new c(i, str1, str2, localPayInfo.dmw, localPayInfo.dDH, "1"), false);
    }
    next();
    AppMethodBeat.o(190062);
  }
  
  public int getLayoutId()
  {
    return 2131495906;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.CRy = ((TextView)findViewById(2131306874));
    this.jtd = ((Button)findViewById(2131306873));
    if (this.yvS == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.CRy.setText(f.d(this.yvS.dmz, this.yvS.wSq));
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WalletBalanceResultUI", "click finish btn");
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
    this.CRA = ((Bankcard)getInput().getParcelable("key_bankcard"));
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().r(new Object[] { this.yvS })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.yvS = ((Orders)getInput().getParcelable("key_orders"));
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
      if (((c)paramn).COb)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          s.eGW();
          s.eGX().DsG = bu.aRi();
          paramString = new yq();
          paramString.dNW.scene = 15;
          paramString.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68686);
              ae.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
              AppMethodBeat.o(68686);
            }
          };
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
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