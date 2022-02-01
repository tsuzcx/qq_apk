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
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Orders Ivh;
  protected TextView Ooh;
  protected CheckBox Ooi;
  protected Bankcard Ooj;
  protected Button njb;
  
  private void gFV()
  {
    AppMethodBeat.i(255327);
    int i = getInput().getInt("key_pay_flag", 0);
    String str1 = getInput().getString("key_pwd1");
    String str2 = getInput().getString("key_verify_code");
    PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
    int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWP, 1);
    if ((localPayInfo != null) && (j == 1))
    {
      if (this.Ooj == null)
      {
        Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.fwv, Integer.valueOf(localPayInfo.fOY), "0" });
        doSceneProgress(new c(i, str1, str2, localPayInfo.fwv, localPayInfo.fOY, "0"));
        AppMethodBeat.o(255327);
        return;
      }
      Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", new Object[] { Integer.valueOf(i), str2, localPayInfo.fwv, Integer.valueOf(localPayInfo.fOY), "1" });
      doSceneProgress(new c(i, str1, str2, localPayInfo.fwv, localPayInfo.fOY, "1"), false);
    }
    next();
    AppMethodBeat.o(255327);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_save_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.Ooh = ((TextView)findViewById(a.f.wbsr_money_tv));
    this.njb = ((Button)findViewById(a.f.wbsr_finish_btn));
    if (this.Ivh == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.Ooh.setText(com.tencent.mm.wallet_core.ui.g.d(this.Ivh.fwy, this.Ivh.GHz));
    this.njb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.Ooj = ((Bankcard)getInput().getParcelable("key_bankcard"));
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().r(new Object[] { this.Ivh })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    showHomeBtn(false);
    AppMethodBeat.o(68687);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68690);
    if ((paramq instanceof c))
    {
      if (((c)paramq).OkD)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          s.gGL();
          s.gGM().OUe = Util.nowSecond();
          paramString = new abc();
          paramString.gah.scene = 15;
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