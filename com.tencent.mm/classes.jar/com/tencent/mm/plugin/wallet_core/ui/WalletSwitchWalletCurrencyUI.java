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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView Ikm;
  private ArrayList<ad> Ikn = null;
  private t Iko = null;
  private ad Ikp;
  private ad Ikq;
  
  private void yu(boolean paramBoolean)
  {
    AppMethodBeat.i(71251);
    Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(), paramBoolean);
    AppMethodBeat.o(71251);
  }
  
  public int getLayoutId()
  {
    return 2131497016;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71249);
    this.Ikm = ((ListView)findViewById(2131307722));
    this.Iko = new t(this, this.Ikn);
    this.Ikm.setAdapter(this.Iko);
    if ((this.Ikn != null) && (this.Ikn.size() > 0))
    {
      this.Iko.mData = this.Ikn;
      this.Iko.notifyDataSetChanged();
    }
    this.Ikm.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71247);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).aeV(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).Iks);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
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
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71248);
    super.onCreate(paramBundle);
    setMMTitle(2131768346);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWB, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.Ikn = com.tencent.mm.plugin.wallet_core.model.t.fQL().fSs();
    if ((this.Ikn == null) || (this.Ikn.size() == 0))
    {
      Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      yu(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(71248);
      return;
      Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      yu(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(71250);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.Ikn = com.tencent.mm.plugin.wallet_core.model.t.fQL().fSs();
        this.Iko.mData = this.Ikn;
        this.Iko.notifyDataSetChanged();
        AppMethodBeat.o(71250);
        return true;
      }
      Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.Ikn == null)
      {
        Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(71250);
        return false;
      }
      Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(71250);
      return true;
    }
    if (((paramq instanceof u)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Ikp.field_wallet_selected = 1;
      Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.Ikp.field_wallet_type + " " + this.Ikp.field_wallet_tpa_country_mask);
      ap.gni().reset();
      com.tencent.mm.plugin.wallet_core.model.t.fQL().update(this.Ikp, new String[0]);
      paramString = this.Iko.Iks;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        com.tencent.mm.plugin.wallet_core.model.t.fQL().update(paramString, new String[0]);
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(339975, Integer.valueOf(this.Ikp.field_wallet_type));
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXG, Integer.valueOf(this.Ikp.field_wallet_tpa_country_mask));
      c.cjL();
      if (z.aUp())
      {
        com.tencent.mm.plugin.wallet_core.model.t.fQC();
        com.tencent.mm.plugin.wallet_core.model.t.aq(this, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI
 * JD-Core Version:    0.7.0.1
 */