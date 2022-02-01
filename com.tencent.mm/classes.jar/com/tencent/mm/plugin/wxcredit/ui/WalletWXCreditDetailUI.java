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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.storage.ae;
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
  private Bankcard Bgn;
  private com.tencent.mm.wallet_core.d Ddt;
  private k Ddu;
  private boolean hasInit;
  private f screen;
  private View.OnClickListener uWS;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.uWS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        if (paramAnonymousView.getId() == 2131306854)
        {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)
          {
            com.tencent.mm.wallet_core.ui.e.ae(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).DcM.username);
            AppMethodBeat.o(72366);
          }
        }
        else if ((paramAnonymousView.getId() == 2131306852) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
          com.tencent.mm.wallet_core.ui.e.o(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).DcL, false);
        }
        AppMethodBeat.o(72366);
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private void cL()
  {
    AppMethodBeat.i(72374);
    if (!this.hasInit) {
      initView();
    }
    Object localObject1;
    Object localObject2;
    if (this.Ddu != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.aPN("wallet_wxcredit_header");
      double d = this.Ddu.Dcz;
      ((WalletWXCreditDetailHeaderPreference)localObject1).iBN.setText(com.tencent.mm.wallet_core.ui.e.D(d));
      localObject2 = this.Bgn.field_bankName;
      String str = this.Ddu.DcK;
      ((WalletWXCreditDetailHeaderPreference)localObject1).Dds.setText(((Preference)localObject1).mContext.getString(2131766032, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.Ddu != null)
    {
      this.screen.aPN("wallet_wxcredit_total_amount").setTitle(getString(2131766006, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.Ddu.Dct) }));
      localObject1 = this.screen;
      if (this.Ddu.DcE) {
        break label377;
      }
      bool = true;
      ((f)localObject1).cK("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.aPN("wallet_wxcredit_bill");
      if (this.Ddu.DcA != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.D(this.Ddu.DcA));
      }
      localObject1 = this.screen.aPN("wallet_wxcredit_repayment");
      localObject2 = this.screen.aPN("wallet_wxcredit_repayment_tips");
      if (this.Ddu.DcC <= 0.0D) {
        break label382;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.D(this.Ddu.DcC));
      ((Preference)localObject2).setTitle(getString(2131766030, new Object[] { this.Ddu.DcH }));
      this.screen.cK("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.Bgn != null) {
        this.screen.aPN("wallet_wxcredit_bank_name").setTitle(this.Bgn.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.aPN("wallet_wxcredit_footer")).uWS = this.uWS;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label377:
      bool = false;
      break;
      label382:
      this.screen.cK("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  private boolean eJn()
  {
    AppMethodBeat.i(72371);
    if (this.Bgn == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.Bgn.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.Bgn.field_wxcreditState;
    if (this.Ddu != null) {
      i = this.Ddu.Dcy;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (s.ery().esG())
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
          WalletWXCreditDetailUI.this.fAS().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).Buk), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.Ddt.dmf.putBoolean("key_can_unbind", false);
    }
    if (this.Ddu != null)
    {
      this.Ddt.dmf.putString("key_repayment_url", this.Ddu.DcG);
      this.Ddt.a(this, 1, this.Ddt.dmf);
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
        s.ery().BAM = (System.currentTimeMillis() / 1000L);
        this.Ddu = ((com.tencent.mm.plugin.wxcredit.a.d)paramn).Dcu;
        if ((this.Ddu != null) && (this.Ddu.Dcy == 2))
        {
          com.tencent.mm.kernel.g.agS();
          if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.br(this);
            paramn = paramString.dmf;
            paramn.putDouble("key_total_amount", this.Ddu.Dct);
            paramn.putBoolean("key_can_upgrade_amount", this.Ddu.DcE);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramn, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (eJn())
          {
            setContentViewVisibility(0);
            cL();
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label201;
      }
      fAS().a(new ad(), true, 1);
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
        s.ery();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        h.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(2131765319), new h.c()
        {
          public final void kG(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              s.ery();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.eJo();
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
    cL();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(72377);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72370);
    super.onCreate(paramBundle);
    fAS().addSceneEndListener(621);
    fAS().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.Ddt = com.tencent.mm.wallet_core.a.br(this);
    if (this.Bgn == null) {
      this.Bgn = ((Bankcard)this.Ddt.dmf.getParcelable("key_bankcard"));
    }
    if (eJn())
    {
      if (this.mNetController == null)
      {
        if (this.mProcess == null) {
          this.mProcess = com.tencent.mm.wallet_core.a.br(this);
        }
        this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
      }
      if (!this.mNetController.z(new Object[] { this.Bgn }))
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
    fAS().removeSceneEndListener(621);
    fAS().removeSceneEndListener(600);
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
      paramf.putParcelable("key_bankcard", this.Bgn);
      com.tencent.mm.wallet_core.a.a(this, b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.Ddu != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.Ddu.wLj);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.Ddu != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.Ddu.DcI);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.Ddu != null) {
          com.tencent.mm.wallet_core.ui.e.o(this, this.Ddu.DcJ, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.Ddu != null) {
          com.tencent.mm.wallet_core.ui.e.o(this, this.Ddu.DcG, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.Ddu != null)) {
        com.tencent.mm.wallet_core.ui.e.ad(this, this.Ddu.DcM.username);
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