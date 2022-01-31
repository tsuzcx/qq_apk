package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private boolean hasInit;
  private View.OnClickListener qMg;
  private f screen;
  private Bankcard tTH;
  private k vIA;
  private com.tencent.mm.wallet_core.c vIz;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(48725);
    this.hasInit = false;
    this.qMg = new WalletWXCreditDetailUI.3(this);
    AppMethodBeat.o(48725);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(48730);
    if (!this.hasInit) {
      initView();
    }
    Object localObject1;
    Object localObject2;
    if (this.vIA != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.atx("wallet_wxcredit_header");
      double d = this.vIA.vHF;
      ((WalletWXCreditDetailHeaderPreference)localObject1).gpq.setText(com.tencent.mm.wallet_core.ui.e.F(d));
      localObject2 = this.tTH.field_bankName;
      String str = this.vIA.vHQ;
      ((WalletWXCreditDetailHeaderPreference)localObject1).vIy.setText(((Preference)localObject1).mContext.getString(2131305812, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.vIA != null)
    {
      this.screen.atx("wallet_wxcredit_total_amount").setTitle(getString(2131305786, new Object[] { com.tencent.mm.wallet_core.ui.e.F(this.vIA.vHz) }));
      localObject1 = this.screen;
      if (this.vIA.vHK) {
        break label375;
      }
      bool = true;
      ((f)localObject1).cl("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.atx("wallet_wxcredit_bill");
      if (this.vIA.vHG != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.F(this.vIA.vHG));
      }
      localObject1 = this.screen.atx("wallet_wxcredit_repayment");
      localObject2 = this.screen.atx("wallet_wxcredit_repayment_tips");
      if (this.vIA.vHI <= 0.0D) {
        break label380;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.F(this.vIA.vHI));
      ((Preference)localObject2).setTitle(getString(2131305810, new Object[] { this.vIA.vHN }));
      this.screen.cl("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.tTH != null) {
        this.screen.atx("wallet_wxcredit_bank_name").setTitle(this.tTH.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.atx("wallet_wxcredit_footer")).qMg = this.qMg;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(48730);
      return;
      label375:
      bool = false;
      break;
      label380:
      this.screen.cl("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  private boolean dkJ()
  {
    AppMethodBeat.i(48727);
    if (this.tTH == null)
    {
      AppMethodBeat.o(48727);
      return false;
    }
    if (this.tTH.field_bankcardState == 0)
    {
      AppMethodBeat.o(48727);
      return true;
    }
    int i = this.tTH.field_wxcreditState;
    if (this.vIA != null) {
      i = this.vIA.vHE;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(48727);
      return true;
    case 1: 
      if (t.cTN().cUQ())
      {
        AppMethodBeat.o(48727);
        return true;
      }
      AppMethodBeat.o(48727);
      return false;
    case 3: 
      h.a(this, 2131305784, -1, false, new WalletWXCreditDetailUI.1(this));
      AppMethodBeat.o(48727);
      return false;
    case 5: 
      this.vIz.mEJ.putBoolean("key_can_unbind", false);
    }
    if (this.vIA != null)
    {
      this.vIz.mEJ.putString("key_repayment_url", this.vIA.vHM);
      this.vIz.a(this, 1, this.vIz.mEJ);
      AppMethodBeat.o(48727);
      return false;
    }
    AppMethodBeat.o(48727);
    return true;
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48732);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        t.cTN().ulW = (System.currentTimeMillis() / 1000L);
        this.vIA = ((d)paramm).vHA;
        if ((this.vIA != null) && (this.vIA.vHE == 2))
        {
          com.tencent.mm.kernel.g.RM();
          if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.aM(this);
            paramm = paramString.mEJ;
            paramm.putDouble("key_total_amount", this.vIA.vHz);
            paramm.putBoolean("key_can_upgrade_amount", this.vIA.vHK);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramm, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(48732);
          return true;
          if (dkJ())
          {
            setContentViewVisibility(0);
            bJ();
          }
        }
      }
      if (!(paramm instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label201;
      }
      dSV().a(new ab(), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(48732);
      return false;
      label201:
      if ((paramm instanceof ab)) {
        finish();
      }
    }
  }
  
  public int getResourceId()
  {
    return 2131165319;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48729);
    this.hasInit = true;
    setMMTitle(2131305785);
    this.screen = getPreferenceScreen();
    setBackBtn(new WalletWXCreditDetailUI.2(this));
    addIconOptionMenu(0, 2130839668, new WalletWXCreditDetailUI.4(this));
    AppMethodBeat.o(48729);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48733);
    setContentViewVisibility(0);
    bJ();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(48733);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48726);
    super.onCreate(paramBundle);
    dSV().addSceneEndListener(621);
    dSV().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.vIz = com.tencent.mm.wallet_core.a.aM(this);
    if (this.tTH == null) {
      this.tTH = ((Bankcard)this.vIz.mEJ.getParcelable("key_bankcard"));
    }
    if (dkJ())
    {
      if (this.mNetController == null)
      {
        if (this.mProcess == null) {
          this.mProcess = com.tencent.mm.wallet_core.a.aM(this);
        }
        this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
      }
      if (!this.mNetController.x(new Object[] { this.tTH }))
      {
        setContentViewVisibility(0);
        initView();
      }
    }
    AppMethodBeat.o(48726);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48728);
    dSV().removeSceneEndListener(621);
    dSV().removeSceneEndListener(600);
    super.onDestroy();
    AppMethodBeat.o(48728);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48731);
    paramf = paramPreference.mKey;
    if ("wallet_wxcredit_change_amount".equals(paramf))
    {
      paramf = new Bundle();
      paramf.putParcelable("key_bankcard", this.tTH);
      com.tencent.mm.wallet_core.a.a(this, b.class, paramf);
      AppMethodBeat.o(48731);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.vIA != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.vIA.qkc);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(48731);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.vIA != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.vIA.vHO);
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.vIA != null) {
          com.tencent.mm.wallet_core.ui.e.m(this, this.vIA.vHP, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.vIA != null) {
          com.tencent.mm.wallet_core.ui.e.m(this, this.vIA.vHM, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.vIA != null)) {
        com.tencent.mm.wallet_core.ui.e.ad(this, this.vIA.vHS.username);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI
 * JD-Core Version:    0.7.0.1
 */