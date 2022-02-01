package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSwitchVerifyPhoneUI
  extends WalletBaseUI
{
  private SwitchPhoneItemGroupView Djr;
  private List<ik> Djs;
  public boolean Djt = false;
  
  private void eDu()
  {
    AppMethodBeat.i(71244);
    ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
    Authen localAuthen = (Authen)getInput().getParcelable("key_authen");
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if ((localAuthen == null) || (localBankcard == null))
    {
      ad.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
      AppMethodBeat.o(71244);
      return;
    }
    ElementQuery localElementQuery = t.eFG().aEp(localBankcard.field_bankcardType);
    getInput().putParcelable("elemt_query", localElementQuery);
    localAuthen.dkR = localBankcard.field_bankcardType;
    localAuthen.wBI = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.CWr;
    getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
    getInput().putBoolean("key_is_changing_balance_phone_num", true);
    getInput().putInt("key_err_code", 418);
    com.tencent.mm.wallet_core.a.k(this, getInput());
    AppMethodBeat.o(71244);
  }
  
  public int getLayoutId()
  {
    return 2131496034;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71241);
    this.Djr = ((SwitchPhoneItemGroupView)findViewById(2131303217));
    this.Djr.setOnItemSelectListener(new SwitchPhoneItemGroupView.a()
    {
      public final void fK(View paramAnonymousView)
      {
        AppMethodBeat.i(71237);
        if (paramAnonymousView.getTag() != null)
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          ad.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
            WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
            AppMethodBeat.o(71237);
            return;
          }
          if (i == -2)
          {
            ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
            WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", true);
            com.tencent.mm.wallet_core.a.k(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.getInput());
            AppMethodBeat.o(71237);
            return;
          }
          paramAnonymousView = (ik)WalletSwitchVerifyPhoneUI.b(WalletSwitchVerifyPhoneUI.this).get(i);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", false);
          ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramAnonymousView.FBn.equals("wx")) });
          WalletSwitchVerifyPhoneUI.this.getNetController().s(new Object[] { paramAnonymousView });
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
    overridePendingTransition(2130772108, 2130771986);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131765887));
    initView();
    this.Djt = getInput().getBoolean("key_block_bind_new_card", false);
    if (!this.Djt)
    {
      paramBundle = new SwitchPhoneItemView(getContext());
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.a(getString(2131765883), null);
      this.Djr.a(paramBundle, -1);
    }
    if ((getProcess() != null) && (getProcess().cQc().equals("PayProcess")) && (getInput().getInt("key_can_verify_tail", 0) == 1))
    {
      ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(2131765292);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext(), 2131496032);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.a(paramBundle, null);
      this.Djr.a(localSwitchPhoneItemView, -1);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(71243);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof h))
      {
        paramString = (h)paramn;
        this.Djs = ((h)paramn).COH.Gvi;
        if (this.Djs != null) {
          Collections.sort(this.Djs, new Comparator() {});
        }
        if (paramString.COH.Gvj != null)
        {
          paramString = paramString.COH.Gvj;
          getInput().putString("key_true_name", paramString.CTa);
          getInput().putString("key_cre_name", paramString.CTe);
          getInput().putString("key_cre_type", paramString.Dai);
        }
        if ((this.Djs == null) || (this.Djs.isEmpty()))
        {
          ad.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          AppMethodBeat.o(71243);
          return true;
        }
        paramInt1 = this.Djs.size() - 1;
        label172:
        if (paramInt1 >= 0)
        {
          paramn = (ik)this.Djs.get(paramInt1);
          if ((bt.isNullOrNil(paramn.FBn)) || (!paramn.FBn.equals("cft"))) {
            break label484;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext());
          if ((bt.isNullOrNil(paramn.FBo)) || (!paramn.FBo.equals("1"))) {
            break label347;
          }
          paramString = getString(2131765886);
          paramString = getString(2131765884, new Object[] { paramn.uJF, paramString, paramn.FBp });
          if (!this.Djt) {
            break label358;
          }
          paramString = new SpannableString(paramString);
          label310:
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.a(paramn.CPf, paramString);
          this.Djr.a(localSwitchPhoneItemView, 0);
        }
        for (;;)
        {
          label262:
          paramInt1 -= 1;
          break label172;
          break;
          label347:
          paramString = getString(2131765885);
          break label262;
          label358:
          String str1 = getString(2131765889);
          l locall = new l(this);
          String str2 = paramString + "，";
          locall.mColor = getResources().getColor(2131100027);
          paramString = new SpannableString(str2 + str1);
          paramString.setSpan(locall, str2.length(), str2.length() + str1.length(), 33);
          locall.DfS = new l.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71239);
              ad.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
              WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, paramn);
              AppMethodBeat.o(71239);
            }
          };
          break label310;
          label484:
          paramString = new SwitchPhoneItemView(getContext());
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.a(paramn.CPf, getString(2131765890));
          this.Djr.a(paramString, 0);
        }
      }
      if ((paramn instanceof y)) {
        eDu();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI
 * JD-Core Version:    0.7.0.1
 */