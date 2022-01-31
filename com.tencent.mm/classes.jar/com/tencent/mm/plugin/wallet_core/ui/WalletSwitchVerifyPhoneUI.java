package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSwitchVerifyPhoneUI
  extends WalletBaseUI
{
  private SwitchPhoneItemGroupView utL;
  private List<hc> utM;
  public boolean utN = false;
  
  private void cRL()
  {
    AppMethodBeat.i(47677);
    ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
    Authen localAuthen = (Authen)getInput().getParcelable("key_authen");
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if ((localAuthen == null) || (localBankcard == null))
    {
      ab.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
      AppMethodBeat.o(47677);
      return;
    }
    ElementQuery localElementQuery = t.cTV().afh(localBankcard.field_bankcardType);
    getInput().putParcelable("elemt_query", localElementQuery);
    localAuthen.poq = localBankcard.field_bankcardType;
    localAuthen.por = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.uhA;
    getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
    getInput().putBoolean("key_is_changing_balance_phone_num", true);
    getInput().putInt("key_err_code", 418);
    com.tencent.mm.wallet_core.a.j(this, getInput());
    AppMethodBeat.o(47677);
  }
  
  public int getLayoutId()
  {
    return 2130971257;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47674);
    this.utL = ((SwitchPhoneItemGroupView)findViewById(2131829408));
    this.utL.setOnItemSelectListener(new WalletSwitchVerifyPhoneUI.1(this));
    AppMethodBeat.o(47674);
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47673);
    overridePendingTransition(2131034230, 2131034130);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131305668));
    initView();
    this.utN = getInput().getBoolean("key_block_bind_new_card", false);
    if (!this.utN)
    {
      paramBundle = new SwitchPhoneItemView(getContext());
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.a(getString(2131305664), null);
      this.utL.a(paramBundle, -1);
    }
    if ((getProcess() != null) && (getProcess().bzC().equals("PayProcess")) && (getInput().getInt("key_can_verify_tail", 0) == 1))
    {
      ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(2131305100);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext(), 2130971255);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.a(paramBundle, null);
      this.utL.a(localSwitchPhoneItemView, -1);
    }
    addSceneEndListener(1667);
    addSceneEndListener(461);
    addSceneEndListener(1505);
    doSceneProgress(new h(getPayReqKey()));
    AppMethodBeat.o(47673);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47675);
    super.onDestroy();
    removeSceneEndListener(1667);
    removeSceneEndListener(461);
    removeSceneEndListener(1505);
    AppMethodBeat.o(47675);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47676);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof h))
      {
        paramString = (h)paramm;
        this.utM = ((h)paramm).ubu.wZn;
        if (this.utM != null) {
          Collections.sort(this.utM, new WalletSwitchVerifyPhoneUI.2(this));
        }
        if (paramString.ubu.wZo != null)
        {
          paramString = paramString.ubu.wZo;
          getInput().putString("key_true_name", paramString.ueu);
          getInput().putString("key_cre_name", paramString.wOr);
          getInput().putString("key_cre_type", paramString.ulg);
        }
        if ((this.utM == null) || (this.utM.isEmpty()))
        {
          ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          AppMethodBeat.o(47676);
          return true;
        }
        paramInt1 = this.utM.size() - 1;
        label172:
        if (paramInt1 >= 0)
        {
          paramm = (hc)this.utM.get(paramInt1);
          if (!paramm.wtO.equals("cft")) {
            break label462;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext());
          if (!paramm.wtP.equals("1")) {
            break label325;
          }
          paramString = getString(2131305667);
          label240:
          paramString = getString(2131305665, new Object[] { paramm.nLq, paramString, paramm.wtQ });
          if (!this.utN) {
            break label336;
          }
          paramString = new SpannableString(paramString);
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.a(paramm.ubQ, paramString);
          this.utL.a(localSwitchPhoneItemView, 0);
        }
        for (;;)
        {
          label288:
          paramInt1 -= 1;
          break label172;
          break;
          label325:
          paramString = getString(2131305666);
          break label240;
          label336:
          String str1 = getString(2131305670);
          j localj = new j(this);
          String str2 = paramString + "，";
          localj.mColor = getResources().getColor(2131689771);
          paramString = new SpannableString(str2 + str1);
          paramString.setSpan(localj, str2.length(), str2.length() + str1.length(), 33);
          localj.uqj = new WalletSwitchVerifyPhoneUI.3(this, paramm);
          break label288;
          label462:
          paramString = new SwitchPhoneItemView(getContext());
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.a(paramm.ubQ, getString(2131305671));
          this.utL.a(paramString, 0);
        }
      }
      if ((paramm instanceof w)) {
        cRL();
      }
    }
    AppMethodBeat.o(47676);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI
 * JD-Core Version:    0.7.0.1
 */