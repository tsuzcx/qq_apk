package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  protected TextView CFG;
  private TextView CFH;
  private View CFI;
  protected LinearLayout CFJ;
  protected LinearLayout CFK;
  protected LinearLayout CFL;
  protected Bankcard CzV;
  
  private void ua(boolean paramBoolean)
  {
    AppMethodBeat.i(69093);
    if ((!u.aAB()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).eJo()))
    {
      e.agr(0);
      h.a(this, 2131765056, -1, 2131765055, 2131765057, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69083);
          ((com.tencent.mm.plugin.walletlock.a.b)g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).l(WalletBankcardDetailUI.this, 1);
          e.agr(1);
          AppMethodBeat.o(69083);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69084);
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          e.agr(2);
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
  
  protected final void eDg()
  {
    AppMethodBeat.i(69092);
    this.CFJ.setVisibility(0);
    this.CFK.setVisibility(8);
    ((TextView)findViewById(2131306671)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69079);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletBankcardDetailUI.this.showDialog(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69079);
      }
    });
    ((TextView)findViewById(2131306684)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69080);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.wallet_core.a.k(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.getInput());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69080);
      }
    });
    AppMethodBeat.o(69092);
  }
  
  public int getLayoutId()
  {
    return 2131495915;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69090);
    this.CzV = ((Bankcard)getInput().getParcelable("key_bankcard"));
    if (this.CzV == null)
    {
      AppMethodBeat.o(69090);
      return;
    }
    this.CFJ = ((LinearLayout)findViewById(2131306670));
    this.CFK = ((LinearLayout)findViewById(2131306677));
    this.CFL = ((LinearLayout)findViewById(2131306675));
    this.CFH = ((TextView)findViewById(2131306673));
    this.CFI = findViewById(2131306682);
    this.CFI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69077);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.o(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.CzV.field_repay_url, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69077);
      }
    });
    if (1 == this.CzV.field_bankcardState)
    {
      eDg();
      AppMethodBeat.o(69090);
      return;
    }
    if (this.CzV.eEU())
    {
      tZ(true);
      this.CFG = ((TextView)findViewById(2131306669));
      s.eDp();
      s.eDq();
      this.CFG.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69082);
          s.eDp();
          paramAnonymousMenuItem = s.eDq().eGu();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.size() > 1))
          {
            s.eDp();
            s.eDq();
          }
          paramAnonymousMenuItem = new ArrayList();
          h.b(WalletBankcardDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletBankcardDetailUI.this.getString(2131765319), new h.c()
          {
            public final void lf(int paramAnonymous2Int)
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
      tZ(false);
      this.CFG = ((TextView)findViewById(2131306674));
      s.eDp();
      s.eDq();
      this.CFG.setVisibility(8);
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
    Dialog localDialog = h.a(getContext(), getString(2131765041), getResources().getStringArray(2130903098), "", new h.c()
    {
      public final void lf(int paramAnonymousInt)
      {
        AppMethodBeat.i(69085);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(69085);
          return;
          Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletBankcardDetailUI.this.getString(2131765040)));
          ((Intent)localObject).addFlags(268435456);
          WalletBankcardDetailUI localWalletBankcardDetailUI = WalletBankcardDetailUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localWalletBankcardDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localWalletBankcardDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localWalletBankcardDetailUI, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
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
        if (this.CFG != null) {
          this.CFG.setVisibility(0);
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
          ad.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.CFh);
          switch (paramString.CFh)
          {
          default: 
            ua(false);
            break;
          case 2: 
          case 3: 
            paramInt1 = paramString.CFh;
            h.a(this, paramString.CFi, null, false, new DialogInterface.OnClickListener()
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
    ad.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    ua(false);
    AppMethodBeat.o(69095);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(69091);
    if (paramBoolean)
    {
      this.CFJ.setVisibility(8);
      this.CFK.setVisibility(0);
      ((TextView)findViewById(2131306668)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          WalletBankcardDetailUI.this.showDialog(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69078);
        }
      });
      TextView localTextView1 = (TextView)findViewById(2131306680);
      TextView localTextView2 = (TextView)findViewById(2131306681);
      TextView localTextView3 = (TextView)findViewById(2131306678);
      TextView localTextView4 = (TextView)findViewById(2131306679);
      localTextView1.setText(e.d(this.CzV.field_onceQuotaKind, null));
      localTextView2.setText(e.d(this.CzV.field_onceQuotaVirtual, null));
      localTextView3.setText(e.d(this.CzV.field_dayQuotaKind, null));
      localTextView4.setText(e.d(this.CzV.field_dayQuotaVirtual, null));
      if (!bt.isNullOrNil(this.CzV.field_repay_url))
      {
        this.CFH.setVisibility(0);
        this.CFI.setVisibility(0);
      }
      AppMethodBeat.o(69091);
      return;
    }
    this.CFJ.setVisibility(8);
    this.CFK.setVisibility(8);
    this.CFL.setVisibility(0);
    AppMethodBeat.o(69091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */