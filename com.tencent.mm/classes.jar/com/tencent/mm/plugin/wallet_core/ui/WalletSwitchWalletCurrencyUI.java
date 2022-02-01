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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView AqK;
  private ArrayList<ac> AqL = null;
  private t AqM = null;
  private ac AqN;
  private ac AqO;
  
  private void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(71251);
    ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
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
    this.AqK = ((ListView)findViewById(2131304670));
    this.AqM = new t(this, this.AqL);
    this.AqK.setAdapter(this.AqM);
    if ((this.AqL != null) && (this.AqL.size() > 0))
    {
      this.AqM.mData = this.AqL;
      this.AqM.notifyDataSetChanged();
    }
    this.AqK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71247);
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).RH(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).AqQ);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjV, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.AqL = s.ecf().edE();
    if ((this.AqL == null) || (this.AqL.size() == 0))
    {
      ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      sN(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(71248);
      return;
      ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      sN(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71250);
    if ((paramn instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.AqL = s.ecf().edE();
        this.AqM.mData = this.AqL;
        this.AqM.notifyDataSetChanged();
        AppMethodBeat.o(71250);
        return true;
      }
      ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.AqL == null)
      {
        ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(71250);
        return false;
      }
      ad.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(71250);
      return true;
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.u)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.AqN.field_wallet_selected = 1;
      ad.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.AqN.field_wallet_type + " " + this.AqN.field_wallet_tpa_country_mask);
      aq.evU().reset();
      s.ecf().update(this.AqN, new String[0]);
      paramString = this.AqM.AqQ;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        s.ecf().update(paramString, new String[0]);
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(339975, Integer.valueOf(this.AqN.field_wallet_type));
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fla, Integer.valueOf(this.AqN.field_wallet_tpa_country_mask));
      if (com.tencent.mm.model.u.aqW())
      {
        s.ebW();
        s.N(this, null);
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