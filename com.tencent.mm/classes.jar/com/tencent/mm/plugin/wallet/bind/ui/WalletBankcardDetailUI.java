package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  protected Bankcard CRA;
  protected TextView CXm;
  private TextView CXn;
  private View CXo;
  protected LinearLayout CXp;
  protected LinearLayout CXq;
  protected LinearLayout CXr;
  
  private void uh(boolean paramBoolean)
  {
    AppMethodBeat.i(69093);
    if ((!v.aAR()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).eMW()))
    {
      f.aha(0);
      h.a(this, 2131765056, -1, 2131765055, 2131765057, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69083);
          ((com.tencent.mm.plugin.walletlock.a.b)g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).l(WalletBankcardDetailUI.this, 1);
          f.aha(1);
          AppMethodBeat.o(69083);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69084);
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          f.aha(2);
          AppMethodBeat.o(69084);
        }
      });
      AppMethodBeat.o(69093);
      return;
    }
    getInput().putBoolean("offline_pay", false);
    com.tencent.mm.wallet_core.a.k(this, getInput());
    AppMethodBeat.o(69093);
  }
  
  protected final void eGN()
  {
    AppMethodBeat.i(69092);
    this.CXp.setVisibility(0);
    this.CXq.setVisibility(8);
    ((TextView)findViewById(2131306671)).setOnClickListener(new WalletBankcardDetailUI.3(this));
    ((TextView)findViewById(2131306684)).setOnClickListener(new WalletBankcardDetailUI.4(this));
    AppMethodBeat.o(69092);
  }
  
  public int getLayoutId()
  {
    return 2131495915;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69090);
    this.CRA = ((Bankcard)getInput().getParcelable("key_bankcard"));
    if (this.CRA == null)
    {
      AppMethodBeat.o(69090);
      return;
    }
    this.CXp = ((LinearLayout)findViewById(2131306670));
    this.CXq = ((LinearLayout)findViewById(2131306677));
    this.CXr = ((LinearLayout)findViewById(2131306675));
    this.CXn = ((TextView)findViewById(2131306673));
    this.CXo = findViewById(2131306682);
    this.CXo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69077);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.p(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.CRA.field_repay_url, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69077);
      }
    });
    if (1 == this.CRA.field_bankcardState)
    {
      eGN();
      AppMethodBeat.o(69090);
      return;
    }
    if (this.CRA.eIB())
    {
      ug(true);
      this.CXm = ((TextView)findViewById(2131306669));
      s.eGW();
      s.eGX();
      this.CXm.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69082);
          s.eGW();
          paramAnonymousMenuItem = s.eGX().eKb();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.size() > 1))
          {
            s.eGW();
            s.eGX();
          }
          paramAnonymousMenuItem = new ArrayList();
          h.b(WalletBankcardDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletBankcardDetailUI.this.getString(2131765319), new h.c()
          {
            public final void lh(int paramAnonymous2Int)
            {
              AppMethodBeat.i(69081);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(69081);
                return;
                WalletBankcardDetailUI.a(WalletBankcardDetailUI.this);
              }
            }
          });
          AppMethodBeat.o(69082);
          return true;
        }
      });
      AppMethodBeat.o(69090);
      return;
      ug(false);
      this.CXm = ((TextView)findViewById(2131306674));
      s.eGW();
      s.eGX();
      this.CXm.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69087);
    super.onCreate(paramBundle);
    addSceneEndListener(621);
    setMMTitle(2131765054);
    initView();
    AppMethodBeat.o(69087);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(69094);
    Dialog localDialog = h.a(getContext(), getString(2131765041), getResources().getStringArray(2130903098), "", new WalletBankcardDetailUI.8(this));
    AppMethodBeat.o(69094);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69089);
    removeSceneEndListener(621);
    super.onDestroy();
    AppMethodBeat.o(69089);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69088);
    super.onResume();
    AppMethodBeat.o(69088);
  }
  
  public boolean onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69095);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
        if (this.CXm != null) {
          this.CXm.setVisibility(0);
        }
      }
    }
    while (!(paramn instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
      for (;;)
      {
        AppMethodBeat.o(69095);
        return false;
        if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet.bind.a.a)paramn;
          ae.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.CWN);
          switch (paramString.CWN)
          {
          default: 
            uh(false);
            break;
          case 2: 
          case 3: 
            paramInt1 = paramString.CWN;
            h.a(this, paramString.CWO, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69086);
                if (paramInt1 == 2) {
                  WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                }
                paramAnonymousDialogInterface.dismiss();
                AppMethodBeat.o(69086);
              }
            });
          }
        }
      }
    }
    ae.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    uh(false);
    AppMethodBeat.o(69095);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void ug(boolean paramBoolean)
  {
    AppMethodBeat.i(69091);
    if (paramBoolean)
    {
      this.CXp.setVisibility(8);
      this.CXq.setVisibility(0);
      ((TextView)findViewById(2131306668)).setOnClickListener(new WalletBankcardDetailUI.2(this));
      TextView localTextView1 = (TextView)findViewById(2131306680);
      TextView localTextView2 = (TextView)findViewById(2131306681);
      TextView localTextView3 = (TextView)findViewById(2131306678);
      TextView localTextView4 = (TextView)findViewById(2131306679);
      localTextView1.setText(f.d(this.CRA.field_onceQuotaKind, null));
      localTextView2.setText(f.d(this.CRA.field_onceQuotaVirtual, null));
      localTextView3.setText(f.d(this.CRA.field_dayQuotaKind, null));
      localTextView4.setText(f.d(this.CRA.field_dayQuotaVirtual, null));
      if (!bu.isNullOrNil(this.CRA.field_repay_url))
      {
        this.CXn.setVisibility(0);
        this.CXo.setVisibility(0);
      }
      AppMethodBeat.o(69091);
      return;
    }
    this.CXp.setVisibility(8);
    this.CXq.setVisibility(8);
    this.CXr.setVisibility(0);
    AppMethodBeat.o(69091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */