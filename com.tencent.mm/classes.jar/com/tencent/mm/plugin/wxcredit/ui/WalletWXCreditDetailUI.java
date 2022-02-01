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
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private View.OnClickListener Fms;
  private Bankcard OvO;
  private com.tencent.mm.wallet_core.d QOY;
  private k QOZ;
  private boolean hasInit;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public WalletWXCreditDetailUI()
  {
    AppMethodBeat.i(72369);
    this.hasInit = false;
    this.Fms = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72366);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == a.f.wallet_wxcredit_detail_username_tv) {
          if (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null) {
            com.tencent.mm.wallet_core.ui.g.an(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).QOr.username);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72366);
          return;
          if ((paramAnonymousView.getId() == a.f.wallet_wxcredit_detail_help_tv) && (WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this) != null)) {
            com.tencent.mm.wallet_core.ui.g.p(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.b(WalletWXCreditDetailUI.this).QOq, false);
          }
        }
      }
    };
    AppMethodBeat.o(72369);
  }
  
  private boolean heT()
  {
    AppMethodBeat.i(72371);
    if (this.OvO == null)
    {
      AppMethodBeat.o(72371);
      return false;
    }
    if (this.OvO.field_bankcardState == 0)
    {
      AppMethodBeat.o(72371);
      return true;
    }
    int i = this.OvO.field_wxcreditState;
    if (this.QOZ != null) {
      i = this.QOZ.QOd;
    }
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(72371);
      return true;
    case 1: 
      if (u.gJo().gKx())
      {
        AppMethodBeat.o(72371);
        return true;
      }
      AppMethodBeat.o(72371);
      return false;
    case 3: 
      com.tencent.mm.ui.base.h.a(this, a.i.wallet_wxcredit_detail_review_fail, -1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72364);
          WalletWXCreditDetailUI.this.ijz().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).ONz), true, 1);
          AppMethodBeat.o(72364);
        }
      });
      AppMethodBeat.o(72371);
      return false;
    case 5: 
      this.QOY.fKb.putBoolean("key_can_unbind", false);
    }
    if (this.QOZ != null)
    {
      this.QOY.fKb.putString("key_repayment_url", this.QOZ.QOl);
      this.QOY.a(this, 1, this.QOY.fKb);
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
    if (this.QOZ != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.screen.byG("wallet_wxcredit_header");
      double d = this.QOZ.QOe;
      ((WalletWXCreditDetailHeaderPreference)localObject1).mMc.setText(com.tencent.mm.wallet_core.ui.g.F(d));
      localObject2 = this.OvO.field_bankName;
      String str = this.QOZ.QOp;
      ((WalletWXCreditDetailHeaderPreference)localObject1).QOX.setText(((Preference)localObject1).mContext.getString(a.i.wallet_wxcredit_update_tips, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.QOZ != null)
    {
      this.screen.byG("wallet_wxcredit_total_amount").setTitle(getString(a.i.wallet_wxcredit_detail_total_amount, new Object[] { com.tencent.mm.wallet_core.ui.g.F(this.QOZ.QNY) }));
      localObject1 = this.screen;
      if (this.QOZ.QOj) {
        break label380;
      }
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("wallet_wxcredit_change_amount", bool);
      localObject1 = this.screen.byG("wallet_wxcredit_bill");
      if (this.QOZ.QOf != 0.0D) {
        ((Preference)localObject1).aF(com.tencent.mm.wallet_core.ui.g.F(this.QOZ.QOf));
      }
      localObject1 = this.screen.byG("wallet_wxcredit_repayment");
      localObject2 = this.screen.byG("wallet_wxcredit_repayment_tips");
      if (this.QOZ.QOh <= 0.0D) {
        break label385;
      }
      ((Preference)localObject1).aF(com.tencent.mm.wallet_core.ui.g.F(this.QOZ.QOh));
      ((Preference)localObject2).setTitle(getString(a.i.wallet_wxcredit_repayment_tips, new Object[] { this.QOZ.QOm }));
      this.screen.dz("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.OvO != null) {
        this.screen.byG("wallet_wxcredit_bank_name").setTitle(this.OvO.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.screen.byG("wallet_wxcredit_footer")).Fms = this.Fms;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(72374);
      return;
      label380:
      bool = false;
      break;
      label385:
      this.screen.dz("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  public final boolean f(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72376);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.wxcredit.a.d))
      {
        u.gJo().OUg = (System.currentTimeMillis() / 1000L);
        this.QOZ = ((com.tencent.mm.plugin.wxcredit.a.d)paramq).QNZ;
        if ((this.QOZ != null) && (this.QOZ.QOd == 2))
        {
          com.tencent.mm.kernel.h.aHH();
          if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(196658, Boolean.FALSE)).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.bF(this);
            paramq = paramString.fKb;
            paramq.putDouble("key_total_amount", this.QOZ.QNY);
            paramq.putBoolean("key_can_upgrade_amount", this.QOZ.QOj);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramq, 1);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(72376);
          return true;
          if (heT())
          {
            setContentViewVisibility(0);
            updateView();
          }
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label204;
      }
      ijz().a(new ae(), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(72376);
      return false;
      label204:
      if ((paramq instanceof ae)) {
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
        u.gJo();
        WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
        com.tencent.mm.ui.base.h.b(WalletWXCreditDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletWXCreditDetailUI.this.getString(a.i.wallet_index_ui_unbind_bankcard), new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(72367);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(72367);
              return;
              u.gJo();
              WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this);
              WalletWXCreditDetailUI.heU();
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
    ijz().addSceneEndListener(621);
    ijz().addSceneEndListener(600);
    setContentViewVisibility(4);
    this.QOY = com.tencent.mm.wallet_core.a.bF(this);
    if (this.OvO == null) {
      this.OvO = ((Bankcard)this.QOY.fKb.getParcelable("key_bankcard"));
    }
    if (heT()) {
      if (!getNetController().A(new Object[] { this.OvO }))
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
    ijz().removeSceneEndListener(621);
    ijz().removeSceneEndListener(600);
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
      paramf.putParcelable("key_bankcard", this.OvO);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, paramf);
      AppMethodBeat.o(72375);
      return true;
    }
    if ("wallet_wxcredit_bill".equals(paramf)) {
      if (this.QOZ != null)
      {
        paramf = new Bundle();
        paramf.putString("key_url", this.QOZ.ImN);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72375);
      return false;
      if ("wallet_wxcredit_card_info".equals(paramf))
      {
        if (this.QOZ != null)
        {
          paramf = new Bundle();
          paramf.putString("key_url", this.QOZ.QOn);
          com.tencent.mm.wallet_core.a.a(this, c.class, paramf);
        }
      }
      else if ("wallet_wxcredit_right".equals(paramf))
      {
        if (this.QOZ != null) {
          com.tencent.mm.wallet_core.ui.g.p(this, this.QOZ.QOo, false);
        }
      }
      else if ("wallet_wxcredit_repayment".equals(paramf))
      {
        if (this.QOZ != null) {
          com.tencent.mm.wallet_core.ui.g.p(this, this.QOZ.QOl, false);
        }
      }
      else if (("wallet_wxcredit_bank_name".equals(paramf)) && (this.QOZ != null)) {
        com.tencent.mm.wallet_core.ui.g.am(this, this.QOZ.QOr.username);
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