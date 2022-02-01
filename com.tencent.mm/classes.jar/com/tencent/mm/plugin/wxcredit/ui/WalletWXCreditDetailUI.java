package com.tencent.mm.plugin.wxcredit.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private Bankcard Vla;
  private e XIw;
  private com.tencent.mm.plugin.wxcredit.a.k XIx;
  private boolean hasInit;
  private com.tencent.mm.ui.base.preference.f screen;
  private View.OnClickListener tyA;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.tyA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.f.wallet_wxcredit_detail_username_tv) {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null) {
            com.tencent.mm.wallet_core.ui.i.ao(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).XHP.username);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72366);
          return;
          if ((paramAnonymousView.getId() == a.f.wallet_wxcredit_detail_help_tv) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
            com.tencent.mm.wallet_core.ui.i.p(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).XHO, false);
          }
        }
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private boolean iFB()
  {
    AppMethodBeat.i(72371);
    if (this.Vla == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.Vla.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.Vla.field_wxcreditState;
    if (this.XIx != null) {
      i = this.XIx.XHB;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (u.iiC().ijP())
      {
        AppMethodBeat.o(72371);
        return true;
      }
      AppMethodBeat.o(72371);
      return false;
    case 3: 
      com.tencent.mm.ui.base.k.a(this, a.i.wallet_wxcredit_detail_review_fail, -1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72364);
          WalletWXCreditDetailUI.this.jPx().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).VDk), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.XIw.hPH.putBoolean("key_can_unbind", false);
    }
    if (this.XIx != null)
    {
      this.XIw.hPH.putString("key_repayment_url", this.XIx.XHJ);
      this.XIw.a(this, 1, this.XIw.hPH);
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
    if (this.XIx != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.bAi("wallet_wxcredit_header");
      double d = this.XIx.XHC;
      ((WalletWXCreditDetailHeaderPreference)localObject1).pIK.setText(com.tencent.mm.wallet_core.ui.i.X(d));
      localObject2 = this.Vla.field_bankName;
      String str = this.XIx.XHN;
      ((WalletWXCreditDetailHeaderPreference)localObject1).XIv.setText(((Preference)localObject1).mContext.getString(a.i.wallet_wxcredit_update_tips, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.XIx != null)
    {
      this.screen.bAi("wallet_wxcredit_total_amount").setTitle(getString(a.i.wallet_wxcredit_detail_total_amount, new Object[] { com.tencent.mm.wallet_core.ui.i.X(this.XIx.XHw) }));
      localObject1 = this.screen;
      if (this.XIx.XHH) {
        break label380;
      }
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.bAi("wallet_wxcredit_bill");
      if (this.XIx.XHD != 0.0D) {
        ((Preference)localObject1).aS(com.tencent.mm.wallet_core.ui.i.X(this.XIx.XHD));
      }
      localObject1 = this.screen.bAi("wallet_wxcredit_repayment");
      localObject2 = this.screen.bAi("wallet_wxcredit_repayment_tips");
      if (this.XIx.XHF <= 0.0D) {
        break label385;
      }
      ((Preference)localObject1).aS(com.tencent.mm.wallet_core.ui.i.X(this.XIx.XHF));
      ((Preference)localObject2).setTitle(getString(a.i.wallet_wxcredit_repayment_tips, new Object[] { this.XIx.XHK }));
      this.screen.eh("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.Vla != null) {
        this.screen.bAi("wallet_wxcredit_bank_name").setTitle(this.Vla.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.bAi("wallet_wxcredit_footer")).tyA = this.tyA;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label380:
      bool = false;
      break;
      label385:
      this.screen.eh("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  public final boolean d(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72376);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof d))
      {
        u.iiC().VKm = (System.currentTimeMillis() / 1000L);
        this.XIx = ((d)paramp).XHx;
        if ((this.XIx != null) && (this.XIx.XHB == 2))
        {
          h.baF();
          if (((Boolean)h.baE().ban().d(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.cm(this);
            paramp = paramString.hPH;
            paramp.putDouble("key_total_amount", this.XIx.XHw);
            paramp.putBoolean("key_can_upgrade_amount", this.XIx.XHH);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramp, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (iFB())
          {
            setContentViewVisibility(0);
            updateView();
          }
        }
      }
      if (!(paramp instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label204;
      }
      jPx().a(new ae(), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(72376);
      return false;
      label204:
      if ((paramp instanceof ae)) {
        finish();
      }
    }
  }
  
  public int getResourceId()
  {
    return a.m.wallet_wxcredit_detail_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72373);
    this.hasInit = true;
    setMMTitle(a.i.wallet_wxcredit_detail_title);
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
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72368);
        paramAnonymousMenuItem = new ArrayList();
        u.iiC();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        com.tencent.mm.ui.base.k.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(a.i.wallet_index_ui_unbind_bankcard), new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              u.iiC();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.iFC();
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
    jPx().addSceneEndListener(621);
    jPx().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.XIw = com.tencent.mm.wallet_core.a.cm(this);
    if (this.Vla == null) {
      this.Vla = ((Bankcard)this.XIw.hPH.getParcelable("key_bankcard"));
    }
    if (iFB()) {
      if (!getNetController().D(new Object[] { this.Vla }))
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
    jPx().removeSceneEndListener(621);
    jPx().removeSceneEndListener(600);
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
      paramf.putParcelable("key_bankcard", this.Vla);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.XIx != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.XIx.Okd);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.XIx != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.XIx.XHL);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.XIx != null) {
          com.tencent.mm.wallet_core.ui.i.p(this, this.XIx.XHM, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.XIx != null) {
          com.tencent.mm.wallet_core.ui.i.p(this, this.XIx.XHJ, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.XIx != null)) {
        com.tencent.mm.wallet_core.ui.i.an(this, this.XIx.XHP.username);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI
 * JD-Core Version:    0.7.0.1
 */