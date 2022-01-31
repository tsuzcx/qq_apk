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
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView utQ;
  private ArrayList<ac> utR = null;
  private r utS = null;
  private ac utT;
  private ac utU;
  
  private void nS(boolean paramBoolean)
  {
    AppMethodBeat.i(47684);
    ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(paramBoolean)));
    doSceneProgress(new o(), paramBoolean);
    AppMethodBeat.o(47684);
  }
  
  public int getLayoutId()
  {
    return 2130971259;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47682);
    this.utQ = ((ListView)findViewById(2131829411));
    this.utS = new r(this, this.utR);
    this.utQ.setAdapter(this.utS);
    if ((this.utR != null) && (this.utR.size() > 0))
    {
      this.utS.mData = this.utR;
      this.utS.notifyDataSetChanged();
    }
    this.utQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(47680);
        paramAnonymousView = WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).II(paramAnonymousInt);
        WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this, WalletSwitchWalletCurrencyUI.a(WalletSwitchWalletCurrencyUI.this).utW);
        if ((paramAnonymousView != null) && ((WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this) == null) || (!WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this).field_wallet_tpa_country.equals(paramAnonymousView.field_wallet_tpa_country))))
        {
          WalletSwitchWalletCurrencyUI.b(WalletSwitchWalletCurrencyUI.this, paramAnonymousView);
          paramAnonymousAdapterView = WalletSwitchWalletCurrencyUI.this;
          paramAnonymousView = paramAnonymousView.field_wallet_tpa_country;
          ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(paramAnonymousView)));
          paramAnonymousAdapterView.doSceneForceProgress(new s(paramAnonymousView));
        }
        AppMethodBeat.o(47680);
      }
    });
    AppMethodBeat.o(47682);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47681);
    super.onCreate(paramBundle);
    setMMTitle(2131305674);
    g.RM();
    g.RL().Ru().set(ac.a.yBz, Boolean.TRUE);
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.utR = t.cTQ().cVk();
    if ((this.utR == null) || (this.utR.size() == 0))
    {
      ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      nS(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      AppMethodBeat.o(47681);
      return;
      ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      nS(false);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47683);
    if ((paramm instanceof o))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.utR = t.cTQ().cVk();
        this.utS.mData = this.utR;
        this.utS.notifyDataSetChanged();
        AppMethodBeat.o(47683);
        return true;
      }
      ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.utR == null)
      {
        ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        AppMethodBeat.o(47683);
        return false;
      }
      ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      AppMethodBeat.o(47683);
      return true;
    }
    if (((paramm instanceof s)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.utT.field_wallet_selected = 1;
      ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.utT.field_wallet_type + " " + this.utT.field_wallet_tpa_country_mask);
      am.dlO().reset();
      t.cTQ().update(this.utT, new String[0]);
      paramString = this.utS.utW;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        t.cTQ().update(paramString, new String[0]);
      }
      g.RM();
      g.RL().Ru().set(339975, Integer.valueOf(this.utT.field_wallet_type));
      g.RM();
      g.RL().Ru().set(ac.a.yCE, Integer.valueOf(this.utT.field_wallet_tpa_country_mask));
      if (com.tencent.mm.model.r.ZC())
      {
        t.cTI();
        t.B(this, null);
      }
      setResult(-1);
      finish();
      AppMethodBeat.o(47683);
      return true;
    }
    AppMethodBeat.o(47683);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI
 * JD-Core Version:    0.7.0.1
 */