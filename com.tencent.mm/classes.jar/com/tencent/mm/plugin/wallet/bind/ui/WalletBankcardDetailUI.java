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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  protected TextView HDa;
  private TextView HDb;
  private View HDc;
  protected LinearLayout HDd;
  protected LinearLayout HDe;
  protected LinearLayout HDf;
  protected Bankcard Hww;
  
  private void xS(boolean paramBoolean)
  {
    AppMethodBeat.i(69093);
    if ((!z.aUo()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)g.af(com.tencent.mm.plugin.walletlock.a.b.class)).fUF()))
    {
      f.aqm(0);
      h.a(this, 2131767499, -1, 2131767498, 2131767500, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69083);
          ((com.tencent.mm.plugin.walletlock.a.b)g.af(com.tencent.mm.plugin.walletlock.a.b.class)).l(WalletBankcardDetailUI.this, 1);
          f.aqm(1);
          AppMethodBeat.o(69083);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69084);
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          f.aqm(2);
          AppMethodBeat.o(69084);
        }
      });
      AppMethodBeat.o(69093);
      return;
    }
    getInput().putBoolean("offline_pay", false);
    com.tencent.mm.wallet_core.a.l(this, getInput());
    AppMethodBeat.o(69093);
  }
  
  protected final void fNX()
  {
    AppMethodBeat.i(69092);
    this.HDd.setVisibility(0);
    this.HDe.setVisibility(8);
    ((TextView)findViewById(2131310131)).setOnClickListener(new WalletBankcardDetailUI.3(this));
    ((TextView)findViewById(2131310144)).setOnClickListener(new WalletBankcardDetailUI.4(this));
    AppMethodBeat.o(69092);
  }
  
  public int getLayoutId()
  {
    return 2131496895;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69090);
    this.Hww = ((Bankcard)getInput().getParcelable("key_bankcard"));
    if (this.Hww == null)
    {
      AppMethodBeat.o(69090);
      return;
    }
    this.HDd = ((LinearLayout)findViewById(2131310130));
    this.HDe = ((LinearLayout)findViewById(2131310137));
    this.HDf = ((LinearLayout)findViewById(2131310135));
    this.HDb = ((TextView)findViewById(2131310133));
    this.HDc = findViewById(2131310142);
    this.HDc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69077);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.p(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.Hww.field_repay_url, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69077);
      }
    });
    if (1 == this.Hww.field_bankcardState)
    {
      fNX();
      AppMethodBeat.o(69090);
      return;
    }
    if (this.Hww.fQe())
    {
      xR(true);
      this.HDa = ((TextView)findViewById(2131310129));
      s.fOg();
      s.fOh();
      this.HDa.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69082);
          s.fOg();
          paramAnonymousMenuItem = s.fOh().fRE();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.size() > 1))
          {
            s.fOg();
            s.fOh();
          }
          paramAnonymousMenuItem = new ArrayList();
          h.b(WalletBankcardDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletBankcardDetailUI.this.getString(2131767762), new h.d()
          {
            public final void oj(int paramAnonymous2Int)
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
      xR(false);
      this.HDa = ((TextView)findViewById(2131310134));
      s.fOg();
      s.fOh();
      this.HDa.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69087);
    super.onCreate(paramBundle);
    addSceneEndListener(621);
    setMMTitle(2131767497);
    initView();
    AppMethodBeat.o(69087);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(69094);
    Dialog localDialog = h.a(getContext(), getString(2131767484), getResources().getStringArray(2130903100), "", new WalletBankcardDetailUI.8(this));
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
  
  public boolean onSceneEnd(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69095);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
        if (this.HDa != null) {
          this.HDa.setVisibility(0);
        }
      }
    }
    while (!(paramq instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
      for (;;)
      {
        AppMethodBeat.o(69095);
        return false;
        if ((paramq instanceof com.tencent.mm.plugin.wallet.bind.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet.bind.a.a)paramq;
          Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.HCt);
          switch (paramString.HCt)
          {
          default: 
            xS(false);
            break;
          case 2: 
          case 3: 
            paramInt1 = paramString.HCt;
            h.a(this, paramString.HCu, null, false, new DialogInterface.OnClickListener()
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
    Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    xS(false);
    AppMethodBeat.o(69095);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void xR(boolean paramBoolean)
  {
    AppMethodBeat.i(69091);
    if (paramBoolean)
    {
      this.HDd.setVisibility(8);
      this.HDe.setVisibility(0);
      ((TextView)findViewById(2131310128)).setOnClickListener(new WalletBankcardDetailUI.2(this));
      TextView localTextView1 = (TextView)findViewById(2131310140);
      TextView localTextView2 = (TextView)findViewById(2131310141);
      TextView localTextView3 = (TextView)findViewById(2131310138);
      TextView localTextView4 = (TextView)findViewById(2131310139);
      localTextView1.setText(f.d(this.Hww.field_onceQuotaKind, null));
      localTextView2.setText(f.d(this.Hww.field_onceQuotaVirtual, null));
      localTextView3.setText(f.d(this.Hww.field_dayQuotaKind, null));
      localTextView4.setText(f.d(this.Hww.field_dayQuotaVirtual, null));
      if (!Util.isNullOrNil(this.Hww.field_repay_url))
      {
        this.HDb.setVisibility(0);
        this.HDc.setVisibility(0);
      }
      AppMethodBeat.o(69091);
      return;
    }
    this.HDd.setVisibility(8);
    this.HDe.setVisibility(8);
    this.HDf.setVisibility(0);
    AppMethodBeat.o(69091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */