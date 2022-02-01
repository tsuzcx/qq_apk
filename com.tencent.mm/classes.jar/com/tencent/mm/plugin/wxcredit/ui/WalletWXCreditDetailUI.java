package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private Bankcard HDV;
  private com.tencent.mm.wallet_core.d JQH;
  private k JQI;
  private boolean hasInit;
  private com.tencent.mm.ui.base.preference.f screen;
  private View.OnClickListener zHh;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.zHh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131310316) {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null) {
            com.tencent.mm.wallet_core.ui.f.an(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).JQa.username);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72366);
          return;
          if ((paramAnonymousView.getId() == 2131310314) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
            com.tencent.mm.wallet_core.ui.f.p(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).JPZ, false);
          }
        }
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private boolean gld()
  {
    AppMethodBeat.i(72371);
    if (this.HDV == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.HDV.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.HDV.field_wxcreditState;
    if (this.JQI != null) {
      i = this.JQI.JPM;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (t.fQI().fRS())
      {
        AppMethodBeat.o(72371);
        return true;
      }
      AppMethodBeat.o(72371);
      return false;
    case 3: 
      h.a(this, 2131768457, -1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72364);
          WalletWXCreditDetailUI.this.hhW().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).HVy), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.JQH.dQL.putBoolean("key_can_unbind", false);
    }
    if (this.JQI != null)
    {
      this.JQH.dQL.putString("key_repayment_url", this.JQI.JPU);
      this.JQH.a(this, 1, this.JQH.dQL);
      AppMethodBeat.o(72371);
      return false;
    }
    AppMethodBeat.o(72371);
    return true;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72374);
    if (!this.hasInit) {
      initView();
    }
    Object localObject1;
    Object localObject2;
    if (this.JQI != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.bmg("wallet_wxcredit_header");
      double d = this.JQI.JPN;
      ((WalletWXCreditDetailHeaderPreference)localObject1).jUP.setText(com.tencent.mm.wallet_core.ui.f.D(d));
      localObject2 = this.HDV.field_bankName;
      String str = this.JQI.JPY;
      ((WalletWXCreditDetailHeaderPreference)localObject1).JQG.setText(((Preference)localObject1).mContext.getString(2131768485, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.JQI != null)
    {
      this.screen.bmg("wallet_wxcredit_total_amount").setTitle(getString(2131768459, new Object[] { com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPH) }));
      localObject1 = this.screen;
      if (this.JQI.JPS) {
        break label377;
      }
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.bmg("wallet_wxcredit_bill");
      if (this.JQI.JPO != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPO));
      }
      localObject1 = this.screen.bmg("wallet_wxcredit_repayment");
      localObject2 = this.screen.bmg("wallet_wxcredit_repayment_tips");
      if (this.JQI.JPQ <= 0.0D) {
        break label382;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPQ));
      ((Preference)localObject2).setTitle(getString(2131768483, new Object[] { this.JQI.JPV }));
      this.screen.jdMethod_do("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.HDV != null) {
        this.screen.bmg("wallet_wxcredit_bank_name").setTitle(this.HDV.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.bmg("wallet_wxcredit_footer")).zHh = this.zHh;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label377:
      bool = false;
      break;
      label382:
      this.screen.jdMethod_do("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72376);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.wxcredit.a.d))
      {
        t.fQI().IbU = (System.currentTimeMillis() / 1000L);
        this.JQI = ((com.tencent.mm.plugin.wxcredit.a.d)paramq).JPI;
        if ((this.JQI != null) && (this.JQI.JPM == 2))
        {
          com.tencent.mm.kernel.g.aAi();
          if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.by(this);
            paramq = paramString.dQL;
            paramq.putDouble("key_total_amount", this.JQI.JPH);
            paramq.putBoolean("key_can_upgrade_amount", this.JQI.JPS);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramq, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (gld())
          {
            setContentViewVisibility(0);
            updateView();
          }
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label201;
      }
      hhW().a(new ad(), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(72376);
      return false;
      label201:
      if ((paramq instanceof ad)) {
        finish();
      }
    }
  }
  
  public int getResourceId()
  {
    return 2132017309;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72373);
    this.hasInit = true;
    setMMTitle(2131768458);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72365);
        WalletWXCreditDetailUI.this.hideVKB();
        WalletWXCreditDetailUI.this.finish();
        AppMethodBeat.o(72365);
        return true;
      }
    });
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72368);
        paramAnonymousMenuItem = new ArrayList();
        t.fQI();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        h.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(2131767762), new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              t.fQI();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.gle();
              AppMethodBeat.o(72367);
              return;
              WalletWXCreditDetailUI.c(WalletWXCreditDetailUI.this);
            }
          }
        });
        AppMethodBeat.o(72368);
        return true;
      }
    });
    AppMethodBeat.o(72373);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72377);
    setContentViewVisibility(0);
    updateView();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(72377);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72370);
    super.onCreate(paramBundle);
    hhW().addSceneEndListener(621);
    hhW().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.JQH = com.tencent.mm.wallet_core.a.by(this);
    if (this.HDV == null) {
      this.HDV = ((Bankcard)this.JQH.dQL.getParcelable("key_bankcard"));
    }
    if (gld())
    {
      if (this.mNetController == null)
      {
        if (this.mProcess == null) {
          this.mProcess = com.tencent.mm.wallet_core.a.by(this);
        }
        this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
      }
      if (!this.mNetController.A(new Object[] { this.HDV }))
      {
        setContentViewVisibility(0);
        initView();
      }
    }
    AppMethodBeat.o(72370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72372);
    hhW().removeSceneEndListener(621);
    hhW().removeSceneEndListener(600);
    super.onDestroy();
    AppMethodBeat.o(72372);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(72375);
    paramf = paramPreference.mKey;
    if ("wallet_wxcredit_change_amount".equals(paramf))
    {
      paramf = new Bundle();
      paramf.putParcelable("key_bankcard", this.HDV);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.JQI != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.JQI.Cpy);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.JQI != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.JQI.JPW);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.JQI != null) {
          com.tencent.mm.wallet_core.ui.f.p(this, this.JQI.JPX, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.JQI != null) {
          com.tencent.mm.wallet_core.ui.f.p(this, this.JQI.JPU, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.JQI != null)) {
        com.tencent.mm.wallet_core.ui.f.am(this, this.JQI.JQa.username);
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI
 * JD-Core Version:    0.7.0.1
 */