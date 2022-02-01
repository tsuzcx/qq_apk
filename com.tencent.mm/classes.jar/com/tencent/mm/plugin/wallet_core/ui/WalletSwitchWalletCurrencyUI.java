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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.wallet_core.model.ad DjA;
  private ListView Djw;
  private ArrayList<com.tencent.mm.plugin.wallet_core.model.ad> Djx = null;
  private t Djy = null;
  private com.tencent.mm.plugin.wallet_core.model.ad Djz;
  
  private void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(71251);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
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
    this.Djw = ((ListView)findViewById(2131304670));
    this.Djy = new t(this, this.Djx);
    this.Djw.setAdapter(this.Djy);
    if ((this.Djx != null) && (this.Djx.size() > 0))
    {
      this.Djy.mData = this.Djx;
      this.Djy.notifyDataSetChanged();
    }
    this.Djw.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71247);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).VI(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).DjC);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
          paramAnonymousAdapterView.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.u(paramAnonymousView));
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
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71248);
    super.onCreate(paramBundle);
    setMMTitle(2131765893);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iuc, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.Djx = com.tencent.mm.plugin.wallet_core.model.t.eFB().eHf();
    if ((this.Djx == null) || (this.Djx.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      uy(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(71248);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      uy(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71250);
    if ((paramn instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.Djx = com.tencent.mm.plugin.wallet_core.model.t.eFB().eHf();
        this.Djy.mData = this.Djx;
        this.Djy.notifyDataSetChanged();
        AppMethodBeat.o(71250);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.Djx == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(71250);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(71250);
      return true;
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.u)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Djz.field_wallet_selected = 1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.Djz.field_wallet_type + " " + this.Djz.field_wallet_tpa_country_mask);
      ap.faj().reset();
      com.tencent.mm.plugin.wallet_core.model.t.eFB().update(this.Djz, new String[0]);
      paramString = this.Djy.DjC;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        com.tencent.mm.plugin.wallet_core.model.t.eFB().update(paramString, new String[0]);
      }
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(339975, Integer.valueOf(this.Djz.field_wallet_type));
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivh, Integer.valueOf(this.Djz.field_wallet_tpa_country_mask));
      if (com.tencent.mm.model.u.aAC())
      {
        com.tencent.mm.plugin.wallet_core.model.t.eFs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI
 * JD-Core Version:    0.7.0.1
 */