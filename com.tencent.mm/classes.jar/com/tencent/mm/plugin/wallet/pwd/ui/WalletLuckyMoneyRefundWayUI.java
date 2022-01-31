package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private f iLA;
  private long kRf;
  private Preference tYK;
  private RadioBelowSummarytAndIconPreference tZG;
  private RadioBelowSummarytAndIconPreference tZH;
  private f.a tZI;
  
  private boolean BF(int paramInt)
  {
    return (this.kRf & paramInt) != 0L;
  }
  
  private void Is(int paramInt)
  {
    AppMethodBeat.i(142384);
    bp localbp = new bp();
    if (bo.ah(this.kRf & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localbp.cYH = i;
      localbp.cYI = paramInt;
      localbp.ake();
      AppMethodBeat.o(142384);
      return;
    }
  }
  
  private void cSG()
  {
    AppMethodBeat.i(142385);
    this.tZG.setWidgetLayoutResource(2130970249);
    this.tZH.setWidgetLayoutResource(2130970250);
    AppMethodBeat.o(142385);
  }
  
  private void cSH()
  {
    AppMethodBeat.i(142386);
    this.tZG.setWidgetLayoutResource(2130970250);
    this.tZH.setWidgetLayoutResource(2130970249);
    AppMethodBeat.o(142386);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(142381);
    this.tYK = this.iLA.atx("refund_way_detail");
    this.tZG = ((RadioBelowSummarytAndIconPreference)this.iLA.atx("refund_way_detail_lq"));
    this.tZH = ((RadioBelowSummarytAndIconPreference)this.iLA.atx("refund_way_detail_origin"));
    if (this.tYK != null) {
      this.tYK.setTitle(this.tZI.tXO);
    }
    if (this.tZG != null)
    {
      this.tZG.setTitle(this.tZI.tXK);
      this.tZG.setSummary(this.tZI.tXL);
    }
    if (this.tZH != null)
    {
      this.tZH.setTitle(this.tZI.tXM);
      this.tZH.setSummary(this.tZI.tXN);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.tZH;
      WalletLuckyMoneyRefundWayUI.1 local1 = new WalletLuckyMoneyRefundWayUI.1(this);
      localRadioBelowSummarytAndIconPreference.UM = 2130840134;
      localRadioBelowSummarytAndIconPreference.tYk = local1;
    }
    if (bo.ah(this.kRf & 0x3, 2L)) {
      cSH();
    }
    for (;;)
    {
      setBackBtn(new WalletLuckyMoneyRefundWayUI.2(this));
      AppMethodBeat.o(142381);
      return;
      cSG();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142380);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("key_hb_refund_config");
    if (!bo.isNullOrNil(paramBundle))
    {
      this.tZI = f.a.afe(paramBundle);
      ab.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.tZI });
    }
    for (;;)
    {
      this.iLA = getPreferenceScreen();
      this.iLA.addPreferencesFromResource(2131165314);
      setMMTitle(this.tZI.tXI);
      g.RM();
      this.kRf = ((Long)g.RL().Ru().get(ac.a.yLV, Long.valueOf(0L))).longValue();
      ab.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.kRf) });
      initView();
      AppMethodBeat.o(142380);
      return;
      ab.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(142382);
    super.onDestroy();
    beh localbeh = new beh();
    if (BF(1))
    {
      localbeh.xtV = 1L;
      localbeh.xtW = 2L;
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.kRf), Long.toBinaryString(localbeh.xtV), Long.toBinaryString(localbeh.xtW) });
      ((j)g.E(j.class)).Yz().c(new j.a(218, localbeh));
      AppMethodBeat.o(142382);
      return;
      if (BF(2))
      {
        localbeh.xtV = 2L;
        localbeh.xtW = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(142383);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      cSG();
      Is(1);
      this.kRf |= 1L;
      this.kRf &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yLV, Long.valueOf(this.kRf));
      this.iLA.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(142383);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        cSH();
        Is(2);
        this.kRf &= 0xFFFFFFFE;
        this.kRf |= 0x2;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI
 * JD-Core Version:    0.7.0.1
 */