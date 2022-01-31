package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private ListView qGK;
  private ArrayList<x> qGL = null;
  private p qGM = null;
  private x qGN;
  private x qGO;
  
  private void kL(boolean paramBoolean)
  {
    y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = " + paramBoolean);
    a(new l(), paramBoolean, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof l))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
        this.qGL = o.bVv().bWp();
        this.qGM.mData = this.qGL;
        this.qGM.notifyDataSetChanged();
        return true;
      }
      y.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
      if (this.qGL == null)
      {
        y.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
        return false;
      }
      y.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
      return true;
    }
    if (((paramm instanceof com.tencent.mm.plugin.wallet_core.c.p)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qGN.field_wallet_selected = 1;
      y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.qGN.field_wallet_type + " " + this.qGN.field_wallet_tpa_country_mask);
      aq.clf().reset();
      o.bVv().c(this.qGN, new String[0]);
      paramString = this.qGM.qGQ;
      if (paramString != null)
      {
        paramString.field_wallet_selected = 0;
        o.bVv().c(paramString, new String[0]);
      }
      g.DQ();
      g.DP().Dz().o(339975, Integer.valueOf(this.qGN.field_wallet_type));
      g.DQ();
      g.DP().Dz().c(ac.a.usE, Integer.valueOf(this.qGN.field_wallet_tpa_country_mask));
      if (q.Gx())
      {
        o.bVn();
        o.v(this, null);
      }
      setResult(-1);
      finish();
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_switch_wallet_kind;
  }
  
  protected final void initView()
  {
    this.qGK = ((ListView)findViewById(a.f.settings_wallet_type_list));
    this.qGM = new p(this, this.qGL);
    this.qGK.setAdapter(this.qGM);
    if ((this.qGL != null) && (this.qGL.size() > 0))
    {
      this.qGM.mData = this.qGL;
      this.qGM.notifyDataSetChanged();
    }
    this.qGK.setOnItemClickListener(new WalletSwitchWalletCurrencyUI.1(this));
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_switch_wallet_type);
    g.DQ();
    g.DP().Dz().c(ac.a.urA, Boolean.valueOf(true));
    getIntent().getIntExtra("switch_wallet_scene", 0);
    this.qGL = o.bVv().bWp();
    if ((this.qGL == null) || (this.qGL.size() == 0))
    {
      y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
      kL(true);
    }
    for (;;)
    {
      initView();
      setResult(0);
      return;
      y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
      kL(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI
 * JD-Core Version:    0.7.0.1
 */