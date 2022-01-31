package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSwitchVerifyPhoneUI
  extends WalletBaseUI
{
  private SwitchPhoneItemGroupView qGF;
  private List<ft> qGG;
  public boolean qGH = false;
  
  private void bTP()
  {
    y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
    Authen localAuthen = (Authen)this.BX.getParcelable("key_authen");
    Bankcard localBankcard = (Bankcard)this.BX.getParcelable("key_bankcard");
    ElementQuery localElementQuery = o.bVA().Qp(localBankcard.field_bankcardType);
    this.BX.putParcelable("elemt_query", localElementQuery);
    localAuthen.mOb = localBankcard.field_bankcardType;
    localAuthen.mOc = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.qvi;
    this.BX.putBoolean("key_balance_change_phone_need_confirm_phone", true);
    this.BX.putBoolean("key_is_changing_balance_phone_num", true);
    this.BX.putInt("key_err_code", 418);
    com.tencent.mm.wallet_core.a.j(this, this.BX);
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        this.qGG = ((e)paramm).qqy.taW;
        Collections.sort(this.qGG, new Comparator() {});
        if (paramString.qqy.taX != null)
        {
          paramString = paramString.qqy.taX;
          this.BX.putString("key_true_name", paramString.qsJ);
          this.BX.putString("key_cre_name", paramString.sPW);
          this.BX.putString("key_cre_type", paramString.qyx);
        }
        if ((this.qGG == null) || (this.qGG.isEmpty()))
        {
          y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          return true;
        }
        paramInt1 = this.qGG.size() - 1;
        label149:
        if (paramInt1 >= 0)
        {
          paramm = (ft)this.qGG.get(paramInt1);
          if (!paramm.szN.equals("cft")) {
            break label441;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(this.mController.uMN);
          if (!paramm.szO.equals("1")) {
            break label304;
          }
          paramString = getString(a.i.wallet_switch_phone_debit_card);
          label219:
          paramString = getString(a.i.wallet_switch_phone_card_hint, new Object[] { paramm.lnT, paramString, paramm.szP });
          if (!this.qGH) {
            break label315;
          }
          paramString = new SpannableString(paramString);
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.a(paramm.qqU, paramString);
          this.qGF.a(localSwitchPhoneItemView, 0);
        }
        for (;;)
        {
          label267:
          paramInt1 -= 1;
          break label149;
          break;
          label304:
          paramString = getString(a.i.wallet_switch_phone_credit_card);
          break label219;
          label315:
          String str1 = getString(a.i.wallet_switch_phone_update);
          h localh = new h(this);
          String str2 = paramString + "，";
          localh.mColor = getResources().getColor(a.c.blue_text_color);
          paramString = new SpannableString(str2 + str1);
          paramString.setSpan(localh, str2.length(), str2.length() + str1.length(), 33);
          localh.qDo = new h.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              y.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
              WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, paramm);
            }
          };
          break label267;
          label441:
          paramString = new SwitchPhoneItemView(this.mController.uMN);
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.a(paramm.qqU, getString(a.i.wallet_switch_phone_wx_bind_phone));
          this.qGF.a(paramString, 0);
        }
      }
      if ((paramm instanceof t)) {
        bTP();
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_switch_verify_phone_ui;
  }
  
  protected final void initView()
  {
    this.qGF = ((SwitchPhoneItemGroupView)findViewById(a.f.phone_number_container));
    this.qGF.setOnItemSelectListener(new WalletSwitchVerifyPhoneUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    super.onCreate(paramBundle);
    setMMTitle(getString(a.i.wallet_switch_phone_title_1));
    initView();
    this.qGH = this.BX.getBoolean("key_block_bind_new_card", false);
    if (!this.qGH)
    {
      paramBundle = new SwitchPhoneItemView(this.mController.uMN);
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.a(getString(a.i.wallet_switch_phone_bind_new_card), null);
      this.qGF.a(paramBundle, -1);
    }
    if ((cNj() != null) && (cNj().aTh() == "PayProcess") && (this.BX.getInt("key_can_verify_tail", 0) == 1))
    {
      y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(a.i.wallet_idcard_item_text);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(this.mController.uMN, a.g.wallet_switch_verify_phone_idcard_item);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.a(paramBundle, null);
      this.qGF.a(localSwitchPhoneItemView, -1);
    }
    kh(1667);
    kh(461);
    kh(1505);
    a(new e(bTO()), true, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1667);
    ki(461);
    ki(1505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI
 * JD-Core Version:    0.7.0.1
 */