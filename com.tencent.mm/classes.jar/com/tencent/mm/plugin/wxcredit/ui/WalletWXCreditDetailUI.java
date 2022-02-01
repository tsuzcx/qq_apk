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
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.storage.ai;
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
  private Bankcard CGB;
  private com.tencent.mm.wallet_core.d EHt;
  private k EHu;
  private boolean hasInit;
  private f screen;
  private View.OnClickListener waa;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.waa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131306854) {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null) {
            com.tencent.mm.wallet_core.ui.e.ad(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).EGM.username);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72366);
          return;
          if ((paramAnonymousView.getId() == 2131306852) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
            com.tencent.mm.wallet_core.ui.e.o(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).EGL, false);
          }
        }
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private boolean eYh()
  {
    AppMethodBeat.i(72371);
    if (this.CGB == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.CGB.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.CGB.field_wxcreditState;
    if (this.EHu != null) {
      i = this.EHu.EGy;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (t.eFy().eGG())
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
          WalletWXCreditDetailUI.this.fSc().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).CUz), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.EHt.dxT.putBoolean("key_can_unbind", false);
    }
    if (this.EHu != null)
    {
      this.EHt.dxT.putString("key_repayment_url", this.EHu.EGG);
      this.EHt.a(this, 1, this.EHt.dxT);
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
    if (this.EHu != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.aVD("wallet_wxcredit_header");
      double d = this.EHu.EGz;
      ((WalletWXCreditDetailHeaderPreference)localObject1).iUX.setText(com.tencent.mm.wallet_core.ui.e.D(d));
      localObject2 = this.CGB.field_bankName;
      String str = this.EHu.EGK;
      ((WalletWXCreditDetailHeaderPreference)localObject1).EHs.setText(((Preference)localObject1).mContext.getString(2131766032, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.EHu != null)
    {
      this.screen.aVD("wallet_wxcredit_total_amount").setTitle(getString(2131766006, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.EHu.EGt) }));
      localObject1 = this.screen;
      if (this.EHu.EGE) {
        break label377;
      }
      bool = true;
      ((f)localObject1).cP("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.aVD("wallet_wxcredit_bill");
      if (this.EHu.EGA != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.D(this.EHu.EGA));
      }
      localObject1 = this.screen.aVD("wallet_wxcredit_repayment");
      localObject2 = this.screen.aVD("wallet_wxcredit_repayment_tips");
      if (this.EHu.EGC <= 0.0D) {
        break label382;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.D(this.EHu.EGC));
      ((Preference)localObject2).setTitle(getString(2131766030, new Object[] { this.EHu.EGH }));
      this.screen.cP("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.CGB != null) {
        this.screen.aVD("wallet_wxcredit_bank_name").setTitle(this.CGB.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.aVD("wallet_wxcredit_footer")).waa = this.waa;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label377:
      bool = false;
      break;
      label382:
      this.screen.cP("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72376);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wxcredit.a.d))
      {
        t.eFy().Dbe = (System.currentTimeMillis() / 1000L);
        this.EHu = ((com.tencent.mm.plugin.wxcredit.a.d)paramn).EGu;
        if ((this.EHu != null) && (this.EHu.EGy == 2))
        {
          com.tencent.mm.kernel.g.ajD();
          if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.br(this);
            paramn = paramString.dxT;
            paramn.putDouble("key_total_amount", this.EHu.EGt);
            paramn.putBoolean("key_can_upgrade_amount", this.EHu.EGE);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramn, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (eYh())
          {
            setContentViewVisibility(0);
            updateView();
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label201;
      }
      fSc().a(new ad(), true, 1);
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
        t.eFy();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        h.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(2131765319), new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              t.eFy();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.eYi();
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
    fSc().addSceneEndListener(621);
    fSc().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.EHt = com.tencent.mm.wallet_core.a.br(this);
    if (this.CGB == null) {
      this.CGB = ((Bankcard)this.EHt.dxT.getParcelable("key_bankcard"));
    }
    if (eYh())
    {
      if (this.mNetController == null)
      {
        if (this.mProcess == null) {
          this.mProcess = com.tencent.mm.wallet_core.a.br(this);
        }
        this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
      }
      if (!this.mNetController.z(new Object[] { this.CGB }))
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
    fSc().removeSceneEndListener(621);
    fSc().removeSceneEndListener(600);
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
      paramf.putParcelable("key_bankcard", this.CGB);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.EHu != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.EHu.xYQ);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.EHu != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.EHu.EGI);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.EHu != null) {
          com.tencent.mm.wallet_core.ui.e.o(this, this.EHu.EGJ, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.EHu != null) {
          com.tencent.mm.wallet_core.ui.e.o(this, this.EHu.EGG, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.EHu != null)) {
        com.tencent.mm.wallet_core.ui.e.ac(this, this.EHu.EGM.username);
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