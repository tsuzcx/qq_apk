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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private com.tencent.mm.wallet_core.d BLl;
  private k BLm;
  private boolean hasInit;
  private f screen;
  private View.OnClickListener tOp;
  private Bankcard zNT;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.tOp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        if (paramAnonymousView.getId() == 2131306854)
        {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)
          {
            com.tencent.mm.wallet_core.ui.e.ad(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).BKE.username);
            AppMethodBeat.o(72366);
          }
        }
        else if ((paramAnonymousView.getId() == 2131306852) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
          com.tencent.mm.wallet_core.ui.e.p(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).BKD, false);
        }
        AppMethodBeat.o(72366);
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private void cE()
  {
    AppMethodBeat.i(72374);
    if (!this.hasInit) {
      initView();
    }
    Object localObject1;
    Object localObject2;
    if (this.BLm != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.aKk("wallet_wxcredit_header");
      double d = this.BLm.BKr;
      ((WalletWXCreditDetailHeaderPreference)localObject1).ibG.setText(com.tencent.mm.wallet_core.ui.e.E(d));
      localObject2 = this.zNT.field_bankName;
      String str = this.BLm.BKC;
      ((WalletWXCreditDetailHeaderPreference)localObject1).BLk.setText(((Preference)localObject1).mContext.getString(2131766032, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.BLm != null)
    {
      this.screen.aKk("wallet_wxcredit_total_amount").setTitle(getString(2131766006, new Object[] { com.tencent.mm.wallet_core.ui.e.E(this.BLm.BKl) }));
      localObject1 = this.screen;
      if (this.BLm.BKw) {
        break label377;
      }
      bool = true;
      ((f)localObject1).cE("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.aKk("wallet_wxcredit_bill");
      if (this.BLm.BKs != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.E(this.BLm.BKs));
      }
      localObject1 = this.screen.aKk("wallet_wxcredit_repayment");
      localObject2 = this.screen.aKk("wallet_wxcredit_repayment_tips");
      if (this.BLm.BKu <= 0.0D) {
        break label382;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.E(this.BLm.BKu));
      ((Preference)localObject2).setTitle(getString(2131766030, new Object[] { this.BLm.BKz }));
      this.screen.cE("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.zNT != null) {
        this.screen.aKk("wallet_wxcredit_bank_name").setTitle(this.zNT.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.aKk("wallet_wxcredit_footer")).tOp = this.tOp;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label377:
      bool = false;
      break;
      label382:
      this.screen.cE("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  private boolean etU()
  {
    AppMethodBeat.i(72371);
    if (this.zNT == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.zNT.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.zNT.field_wxcreditState;
    if (this.BLm != null) {
      i = this.BLm.BKq;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (s.ecc().edl())
      {
        AppMethodBeat.o(72371);
        return true;
      }
      AppMethodBeat.o(72371);
      return false;
    case 3: 
      h.a(this, 2131766004, -1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72364);
          WalletWXCreditDetailUI.this.fkC().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).AbQ), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.BLl.dow.putBoolean("key_can_unbind", false);
    }
    if (this.BLm != null)
    {
      this.BLl.dow.putString("key_repayment_url", this.BLm.BKy);
      this.BLl.a(this, 1, this.BLl.dow);
      AppMethodBeat.o(72371);
      return false;
    }
    AppMethodBeat.o(72371);
    return true;
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72376);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wxcredit.a.d))
      {
        s.ecc().Air = (System.currentTimeMillis() / 1000L);
        this.BLm = ((com.tencent.mm.plugin.wxcredit.a.d)paramn).BKm;
        if ((this.BLm != null) && (this.BLm.BKq == 2))
        {
          com.tencent.mm.kernel.g.afC();
          if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.bo(this);
            paramn = paramString.dow;
            paramn.putDouble("key_total_amount", this.BLm.BKl);
            paramn.putBoolean("key_can_upgrade_amount", this.BLm.BKw);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramn, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (etU())
          {
            setContentViewVisibility(0);
            cE();
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label201;
      }
      fkC().a(new ad(), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(72376);
      return false;
      label201:
      if ((paramn instanceof ad)) {
        finish();
      }
    }
  }
  
  public int getResourceId()
  {
    return 2131951764;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72373);
    this.hasInit = true;
    setMMTitle(2131766005);
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
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72368);
        paramAnonymousMenuItem = new ArrayList();
        s.ecc();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        h.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(2131765319), new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              s.ecc();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.etV();
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
    cE();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(72377);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72370);
    super.onCreate(paramBundle);
    fkC().addSceneEndListener(621);
    fkC().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.BLl = com.tencent.mm.wallet_core.a.bo(this);
    if (this.zNT == null) {
      this.zNT = ((Bankcard)this.BLl.dow.getParcelable("key_bankcard"));
    }
    if (etU())
    {
      if (this.mNetController == null)
      {
        if (this.mProcess == null) {
          this.mProcess = com.tencent.mm.wallet_core.a.bo(this);
        }
        this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
      }
      if (!this.mNetController.x(new Object[] { this.zNT }))
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
    fkC().removeSceneEndListener(621);
    fkC().removeSceneEndListener(600);
    super.onDestroy();
    AppMethodBeat.o(72372);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(72375);
    paramf = paramPreference.mKey;
    if ("wallet_wxcredit_change_amount".equals(paramf))
    {
      paramf = new Bundle();
      paramf.putParcelable("key_bankcard", this.zNT);
      com.tencent.mm.wallet_core.a.a(this, b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.BLm != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.BLm.vBe);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.BLm != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.BLm.BKA);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.BLm != null) {
          com.tencent.mm.wallet_core.ui.e.p(this, this.BLm.BKB, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.BLm != null) {
          com.tencent.mm.wallet_core.ui.e.p(this, this.BLm.BKy, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.BLm != null)) {
        com.tencent.mm.wallet_core.ui.e.ac(this, this.BLm.BKE.username);
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