package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView DBa;
  private ArrayList<ad> DBb = null;
  private t DBc = null;
  private ad DBd;
  private ad DBe;
  
  private void uG(boolean paramBoolean)
  {
    AppMethodBeat.i(71251);
    ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
    doSceneProgress(new q(), paramBoolean);
    AppMethodBeat.o(71251);
  }
  
  public int getLayoutId()
  {
    return 2131496036;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71249);
    this.DBa = ((ListView)findViewById(2131304670));
    this.DBc = new t(this, this.DBb);
    this.DBa.setAdapter(this.DBc);
    if ((this.DBb != null) && (this.DBb.size() > 0))
    {
      this.DBc.mData = this.DBb;
      this.DBc.notifyDataSetChanged();
    }
    this.DBa.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71247);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).Wp(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).DBg);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
          paramAnonymousAdapterView.doSceneForceProgress(new u(paramAnonymousView));
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(71247);
      }
    });
    AppMethodBeat.o(71249);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(71252);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71248);
    super.onCreate(paramBundle);
    setMMTitle(2131765893);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOz, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.DBb = com.tencent.mm.plugin.wallet_core.model.t.eJi().eKN();
    if ((this.DBb == null) || (this.DBb.size() == 0))
    {
      ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      uG(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(71248);
      return;
      ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      uG(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71250);
    if ((paramn instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.DBb = com.tencent.mm.plugin.wallet_core.model.t.eJi().eKN();
        this.DBc.mData = this.DBb;
        this.DBc.notifyDataSetChanged();
        AppMethodBeat.o(71250);
        return true;
      }
      ae.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.DBb == null)
      {
        ae.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(71250);
        return false;
      }
      ae.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(71250);
      return true;
    }
    if (((paramn instanceof u)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.DBd.field_wallet_selected = 1;
      ae.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.DBd.field_wallet_type + " " + this.DBd.field_wallet_tpa_country_mask);
      ap.fdX().reset();
      com.tencent.mm.plugin.wallet_core.model.t.eJi().update(this.DBd, new String[0]);
      paramString = this.DBc.DBg;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        com.tencent.mm.plugin.wallet_core.model.t.eJi().update(paramString, new String[0]);
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(339975, Integer.valueOf(this.DBd.field_wallet_type));
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPF, Integer.valueOf(this.DBd.field_wallet_tpa_country_mask));
      if (v.aAS())
      {
        com.tencent.mm.plugin.wallet_core.model.t.eIZ();
        com.tencent.mm.plugin.wallet_core.model.t.ad(this, null);
      }
      paramString = new Intent();
      paramString.putExtra("is_switch_wallet", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71250);
      return true;
    }
    AppMethodBeat.o(71250);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI
 * JD-Core Version:    0.7.0.1
 */