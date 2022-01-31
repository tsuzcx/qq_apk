package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(3)
public class WalletWXCreditDetailUI
  extends WalletPreferenceUI
{
  private f dnn;
  private boolean hasInit = false;
  private View.OnClickListener nXW = new WalletWXCreditDetailUI.3(this);
  private Bankcard qkH;
  private com.tencent.mm.wallet_core.c rRJ;
  private k rRK;
  
  private void aZ()
  {
    if (!this.hasInit) {
      initView();
    }
    Object localObject1;
    Object localObject2;
    if (this.rRK != null)
    {
      localObject1 = (WalletWXCreditDetailHeaderPreference)this.dnn.add("wallet_wxcredit_header");
      double d = this.rRK.rQO;
      ((WalletWXCreditDetailHeaderPreference)localObject1).eXt.setText(com.tencent.mm.wallet_core.ui.e.B(d));
      localObject2 = this.qkH.field_bankName;
      String str = this.rRK.rRa;
      ((WalletWXCreditDetailHeaderPreference)localObject1).rRI.setText(((Preference)localObject1).mContext.getString(a.i.wallet_wxcredit_update_tips, new Object[] { str, localObject2 }));
    }
    boolean bool;
    if (this.rRK != null)
    {
      this.dnn.add("wallet_wxcredit_total_amount").setTitle(getString(a.i.wallet_wxcredit_detail_total_amount, new Object[] { com.tencent.mm.wallet_core.ui.e.B(this.rRK.rQI) }));
      localObject1 = this.dnn;
      if (this.rRK.rQT) {
        break label368;
      }
      bool = true;
      ((f)localObject1).bJ("wallet_wxcredit_change_amount", bool);
      localObject1 = this.dnn.add("wallet_wxcredit_bill");
      if (this.rRK.rQP != 0.0D) {
        ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.B(this.rRK.rQP));
      }
      localObject1 = this.dnn.add("wallet_wxcredit_repayment");
      localObject2 = this.dnn.add("wallet_wxcredit_repayment_tips");
      if (this.rRK.rQR <= 0.0D) {
        break label373;
      }
      ((Preference)localObject1).setSummary(com.tencent.mm.wallet_core.ui.e.B(this.rRK.rQR));
      ((Preference)localObject2).setTitle(getString(a.i.wallet_wxcredit_repayment_tips, new Object[] { this.rRK.rQW }));
      this.dnn.bJ("wallet_wxcredit_repayment_tips", false);
    }
    for (;;)
    {
      if (this.qkH != null) {
        this.dnn.add("wallet_wxcredit_bank_name").setTitle(this.qkH.field_bankName);
      }
      ((WalletWXCreditDetailFooterPreference)this.dnn.add("wallet_wxcredit_footer")).nXW = this.nXW;
      this.dnn.notifyDataSetChanged();
      return;
      label368:
      bool = false;
      break;
      label373:
      this.dnn.bJ("wallet_wxcredit_repayment_tips", true);
    }
  }
  
  private boolean ckf()
  {
    if (this.qkH == null) {
      return false;
    }
    if (this.qkH.field_bankcardState == 0) {
      return true;
    }
    int i = this.qkH.field_wxcreditState;
    if (this.rRK != null) {
      i = this.rRK.rQN;
    }
    switch (i)
    {
    case 2: 
    default: 
      return true;
    case 1: 
      long l = bk.cn(o.bVs().qzm);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletUserInfoManger", "pass time " + l);
      if (l > 300L) {}
      for (i = 1; i != 0; i = 0) {
        return true;
      }
    case 3: 
      h.a(this, a.i.wallet_wxcredit_detail_review_fail, -1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WalletWXCreditDetailUI.this.cNr().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).field_bankcardType, WalletWXCreditDetailUI.a(WalletWXCreditDetailUI.this).qtu), true, 1);
        }
      });
      return false;
    case 5: 
      this.rRJ.kke.putBoolean("key_can_unbind", false);
    }
    if (this.rRK != null)
    {
      this.rRJ.kke.putString("key_repayment_url", this.rRK.rQV);
      this.rRJ.a(this, 1, this.rRJ.kke);
      return false;
    }
    return true;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    paramf = paramPreference.mKey;
    boolean bool1;
    if ("wallet_wxcredit_change_amount".equals(paramf))
    {
      paramf = new Bundle();
      paramf.putParcelable("key_bankcard", this.qkH);
      com.tencent.mm.wallet_core.a.a(this, b.class, paramf);
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!"wallet_wxcredit_bill".equals(paramf)) {
                  break;
                }
                bool1 = bool2;
              } while (this.rRK == null);
              paramf = new Bundle();
              paramf.putString("key_url", this.rRK.rQZ);
              com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, paramf);
              return false;
              if (!"wallet_wxcredit_card_info".equals(paramf)) {
                break;
              }
              bool1 = bool2;
            } while (this.rRK == null);
            paramf = new Bundle();
            paramf.putString("key_url", this.rRK.rQX);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, paramf);
            return false;
            if (!"wallet_wxcredit_right".equals(paramf)) {
              break;
            }
            bool1 = bool2;
          } while (this.rRK == null);
          com.tencent.mm.wallet_core.ui.e.l(this, this.rRK.rQY, false);
          return false;
          if (!"wallet_wxcredit_repayment".equals(paramf)) {
            break;
          }
          bool1 = bool2;
        } while (this.rRK == null);
        com.tencent.mm.wallet_core.ui.e.l(this, this.rRK.rQV, false);
        return false;
        bool1 = bool2;
      } while (!"wallet_wxcredit_bank_name".equals(paramf));
      bool1 = bool2;
    } while (this.rRK == null);
    com.tencent.mm.wallet_core.ui.e.aa(this, this.rRK.rRc.username);
    return false;
  }
  
  public final boolean g(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        o.bVs().qzm = (System.currentTimeMillis() / 1000L);
        this.rRK = ((d)paramm).rQJ;
        if ((this.rRK != null) && (this.rRK.rQN == 2))
        {
          com.tencent.mm.kernel.g.DQ();
          if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(196658, Boolean.valueOf(false))).booleanValue())
          {
            paramString = com.tencent.mm.wallet_core.a.aj(this);
            paramm = paramString.kke;
            paramm.putDouble("key_total_amount", this.rRK.rQI);
            paramm.putBoolean("key_can_upgrade_amount", this.rRK.rQT);
            paramString.a(this, WalletWXCreditOpenNotifyUI.class, paramm, 1);
          }
        }
        for (;;)
        {
          return true;
          if (ckf())
          {
            vN(0);
            aZ();
          }
        }
      }
      if (!(paramm instanceof com.tencent.mm.plugin.wxcredit.a.i)) {
        break label187;
      }
      cNr().a(new com.tencent.mm.plugin.wallet_core.c.y(), true, 1);
    }
    for (;;)
    {
      return false;
      label187:
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) {
        finish();
      }
    }
  }
  
  protected final void initView()
  {
    this.hasInit = true;
    setMMTitle(a.i.wallet_wxcredit_detail_title);
    this.dnn = this.vdd;
    setBackBtn(new WalletWXCreditDetailUI.2(this));
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new WalletWXCreditDetailUI.4(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    vN(0);
    aZ();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    cNr().kh(621);
    cNr().kh(600);
    vN(4);
    this.rRJ = com.tencent.mm.wallet_core.a.aj(this);
    if (this.qkH == null) {
      this.qkH = ((Bankcard)this.rRJ.kke.getParcelable("key_bankcard"));
    }
    if (ckf())
    {
      if (this.wCi == null)
      {
        if (this.wCg == null) {
          this.wCg = com.tencent.mm.wallet_core.a.aj(this);
        }
        this.wCi = this.wCg.a(this, this.wCh);
      }
      if (!this.wCi.s(new Object[] { this.qkH }))
      {
        vN(0);
        initView();
      }
    }
  }
  
  protected void onDestroy()
  {
    cNr().ki(621);
    cNr().ki(600);
    super.onDestroy();
  }
  
  public final int xj()
  {
    return a.l.wallet_wxcredit_detail_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI
 * JD-Core Version:    0.7.0.1
 */