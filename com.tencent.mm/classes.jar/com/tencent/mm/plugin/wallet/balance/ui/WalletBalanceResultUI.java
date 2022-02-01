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
import com.tencent.mm.g.a.xf;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Button iwY;
  protected Orders vIq;
  protected TextView zHv;
  protected CheckBox zHw;
  
  public int getLayoutId()
  {
    return 2131495906;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68688);
    this.zHv = ((TextView)findViewById(2131306874));
    this.iwY = ((Button)findViewById(2131306873));
    if (this.vIq == null)
    {
      finish();
      AppMethodBeat.o(68688);
      return;
    }
    this.zHv.setText(e.d(this.vIq.dcH, this.vIq.uop));
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68683);
        ad.i("MicroMsg.WalletBalanceResultUI", "click finish btn");
        WalletBalanceResultUI.a(WalletBalanceResultUI.this);
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
    AppMethodBeat.o(68688);
  }
  
  public void next()
  {
    AppMethodBeat.i(68689);
    if (!getNetController().q(new Object[] { this.vIq })) {
      super.next();
    }
    AppMethodBeat.o(68689);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68687);
    super.onCreate(paramBundle);
    this.vIq = ((Orders)getInput().getParcelable("key_orders"));
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
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        s.dZT();
        s.dZU().Aip = bt.aGK();
        paramString = new xf();
        paramString.dCH.scene = 15;
        paramString.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68686);
            ad.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
            AppMethodBeat.o(68686);
          }
        };
        com.tencent.mm.sdk.b.a.ESL.l(paramString);
      }
      next();
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