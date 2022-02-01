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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView BJe;
  private ArrayList<com.tencent.mm.plugin.wallet_core.model.ac> BJf = null;
  private t BJg = null;
  private com.tencent.mm.plugin.wallet_core.model.ac BJh;
  private com.tencent.mm.plugin.wallet_core.model.ac BJi;
  
  private void tO(boolean paramBoolean)
  {
    AppMethodBeat.i(71251);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
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
    this.BJe = ((ListView)findViewById(2131304670));
    this.BJg = new t(this, this.BJf);
    this.BJe.setAdapter(this.BJg);
    if ((this.BJf != null) && (this.BJf.size() > 0))
    {
      this.BJg.mData = this.BJf;
      this.BJg.notifyDataSetChanged();
    }
    this.BJe.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71247);
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).TQ(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).BJk);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
          paramAnonymousAdapterView.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.u(paramAnonymousView));
        }
        AppMethodBeat.o(71247);
      }
    });
    AppMethodBeat.o(71249);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(71252);
    AppMethodBeat.o(71252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71248);
    super.onCreate(paramBundle);
    setMMTitle(2131765893);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHK, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.BJf = s.erB().esZ();
    if ((this.BJf == null) || (this.BJf.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      tO(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(71248);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      tO(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71250);
    if ((paramn instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.BJf = s.erB().esZ();
        this.BJg.mData = this.BJf;
        this.BJg.notifyDataSetChanged();
        AppMethodBeat.o(71250);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.BJf == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(71250);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(71250);
      return true;
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.u)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.BJh.field_wallet_selected = 1;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.BJh.field_wallet_type + " " + this.BJh.field_wallet_tpa_country_mask);
      aq.eLo().reset();
      s.erB().update(this.BJh, new String[0]);
      paramString = this.BJg.BJk;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        s.erB().update(paramString, new String[0]);
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(339975, Integer.valueOf(this.BJh.field_wallet_type));
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIP, Integer.valueOf(this.BJh.field_wallet_tpa_country_mask));
      if (com.tencent.mm.model.u.axM())
      {
        s.ers();
        s.ab(this, null);
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