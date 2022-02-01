package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSwitchVerifyPhoneUI
  extends WalletBaseUI
{
  private SwitchPhoneItemGroupView VTf;
  private List<ji> VTg;
  public boolean VTh = false;
  
  private void ifT()
  {
    AppMethodBeat.i(71244);
    Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
    Authen localAuthen = (Authen)getInput().getParcelable("key_authen");
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if ((localAuthen == null) || (localBankcard == null))
    {
      Log.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
      AppMethodBeat.o(71244);
      return;
    }
    ElementQuery localElementQuery = u.iiK().bgz(localBankcard.field_bankcardType);
    getInput().putParcelable("elemt_query", localElementQuery);
    localAuthen.hAk = localBankcard.field_bankcardType;
    localAuthen.MDt = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.VFi;
    getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
    getInput().putBoolean("key_is_changing_balance_phone_num", true);
    getInput().putInt("key_err_code", 418);
    com.tencent.mm.wallet_core.a.k(this, getInput());
    AppMethodBeat.o(71244);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_switch_verify_phone_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71241);
    this.VTf = ((SwitchPhoneItemGroupView)findViewById(a.f.phone_number_container));
    this.VTf.setOnItemSelectListener(new SwitchPhoneItemGroupView.a()
    {
      public final void ky(View paramAnonymousView)
      {
        AppMethodBeat.i(71237);
        if (paramAnonymousView.getTag() != null)
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
            WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
            AppMethodBeat.o(71237);
            return;
          }
          if (i == -2)
          {
            Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
            WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", true);
            com.tencent.mm.wallet_core.a.k(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.getInput());
            AppMethodBeat.o(71237);
            return;
          }
          paramAnonymousView = (ji)WalletSwitchVerifyPhoneUI.b(WalletSwitchVerifyPhoneUI.this).get(i);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", false);
          Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramAnonymousView.YLz.equals("wx")) });
          WalletSwitchVerifyPhoneUI.this.getNetController().t(new Object[] { paramAnonymousView });
        }
        AppMethodBeat.o(71237);
      }
    });
    AppMethodBeat.o(71241);
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71240);
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    super.onCreate(paramBundle);
    setMMTitle(getString(a.i.wallet_switch_phone_title_1));
    initView();
    this.VTh = getInput().getBoolean("key_block_bind_new_card", false);
    if (!this.VTh)
    {
      paramBundle = new SwitchPhoneItemView(getContext());
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.c(getString(a.i.wallet_switch_phone_bind_new_card), null);
      this.VTf.a(paramBundle, -1);
    }
    if ((getProcess() != null) && (getProcess().fud().equals("PayProcess")) && (getInput().getInt("key_can_verify_tail", 0) == 1))
    {
      Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(a.i.wallet_idcard_item_text);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext(), a.g.wallet_switch_verify_phone_idcard_item);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.c(paramBundle, null);
      this.VTf.a(localSwitchPhoneItemView, -1);
    }
    addSceneEndListener(1667);
    addSceneEndListener(461);
    addSceneEndListener(1505);
    doSceneProgress(new h(getPayReqKey()));
    AppMethodBeat.o(71240);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71242);
    super.onDestroy();
    removeSceneEndListener(1667);
    removeSceneEndListener(461);
    removeSceneEndListener(1505);
    AppMethodBeat.o(71242);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(71243);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof h))
      {
        paramString = (h)paramp;
        this.VTg = ((h)paramp).Vxz.aaoI;
        if (this.VTg != null) {
          Collections.sort(this.VTg, new Comparator() {});
        }
        if (paramString.Vxz.aaoJ != null)
        {
          paramString = paramString.Vxz.aaoJ;
          getInput().putString("key_true_name", paramString.VBL);
          getInput().putString("key_cre_name", paramString.VBP);
          getInput().putString("key_cre_type", paramString.VJr);
        }
        if ((this.VTg == null) || (this.VTg.isEmpty()))
        {
          Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          AppMethodBeat.o(71243);
          return true;
        }
        paramInt1 = this.VTg.size() - 1;
        label172:
        if (paramInt1 >= 0)
        {
          paramp = (ji)this.VTg.get(paramInt1);
          if ((Util.isNullOrNil(paramp.YLz)) || (!paramp.YLz.equals("cft"))) {
            break label484;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext());
          if ((Util.isNullOrNil(paramp.YLA)) || (!paramp.YLA.equals("1"))) {
            break label347;
          }
          paramString = getString(a.i.wallet_switch_phone_debit_card);
          paramString = getString(a.i.wallet_switch_phone_card_hint, new Object[] { paramp.JFk, paramString, paramp.YLB });
          if (!this.VTh) {
            break label358;
          }
          paramString = new SpannableString(paramString);
          label310:
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.c(paramp.VxX, paramString);
          this.VTf.a(localSwitchPhoneItemView, 0);
        }
        for (;;)
        {
          label262:
          paramInt1 -= 1;
          break label172;
          break;
          label347:
          paramString = getString(a.i.wallet_switch_phone_credit_card);
          break label262;
          label358:
          String str1 = getString(a.i.wallet_switch_phone_update);
          n localn = new n(this);
          String str2 = paramString + "，";
          localn.mColor = getResources().getColor(a.c.blue_text_color);
          paramString = new SpannableString(str2 + str1);
          paramString.setSpan(localn, str2.length(), str2.length() + str1.length(), 33);
          localn.VPb = new n.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71239);
              Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
              WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, paramp);
              AppMethodBeat.o(71239);
            }
          };
          break label310;
          label484:
          paramString = new SwitchPhoneItemView(getContext());
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.c(paramp.VxX, getString(a.i.wallet_switch_phone_wx_bind_phone));
          this.VTf.a(paramString, 0);
        }
      }
      if ((paramp instanceof z)) {
        ifT();
      }
    }
    AppMethodBeat.o(71243);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI
 * JD-Core Version:    0.7.0.1
 */