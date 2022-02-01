package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
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
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private SwitchPhoneItemGroupView DAV;
  private List<ik> DAW;
  public boolean DAX = false;
  
  private void eHb()
  {
    AppMethodBeat.i(71244);
    ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
    Authen localAuthen = (Authen)getInput().getParcelable("key_authen");
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if ((localAuthen == null) || (localBankcard == null))
    {
      ae.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
      AppMethodBeat.o(71244);
      return;
    }
    ElementQuery localElementQuery = t.eJn().aFJ(localBankcard.field_bankcardType);
    getInput().putParcelable("elemt_query", localElementQuery);
    localAuthen.dlT = localBankcard.field_bankcardType;
    localAuthen.wRt = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.DnW;
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
    this.DAV = ((SwitchPhoneItemGroupView)findViewById(2131303217));
    this.DAV.setOnItemSelectListener(new SwitchPhoneItemGroupView.a()
    {
      public final void fJ(View paramAnonymousView)
      {
        AppMethodBeat.i(71237);
        if (paramAnonymousView.getTag() != null)
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          ae.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
            WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
            AppMethodBeat.o(71237);
            return;
          }
          if (i == -2)
          {
            ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
            WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", true);
            com.tencent.mm.wallet_core.a.k(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.getInput());
            AppMethodBeat.o(71237);
            return;
          }
          paramAnonymousView = (ik)WalletSwitchVerifyPhoneUI.b(WalletSwitchVerifyPhoneUI.this).get(i);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", false);
          ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramAnonymousView.FTI.equals("wx")) });
          WalletSwitchVerifyPhoneUI.this.getNetController().r(new Object[] { paramAnonymousView });
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
    this.DAX = getInput().getBoolean("key_block_bind_new_card", false);
    if (!this.DAX)
    {
      paramBundle = new SwitchPhoneItemView(getContext());
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.a(getString(2131765883), null);
      this.DAV.a(paramBundle, -1);
    }
    if ((getProcess() != null) && (getProcess().cSH().equals("PayProcess")) && (getInput().getInt("key_can_verify_tail", 0) == 1))
    {
      ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(2131765292);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext(), 2131496032);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.a(paramBundle, null);
      this.DAV.a(localSwitchPhoneItemView, -1);
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
        this.DAW = ((h)paramn).Dgm.GOH;
        if (this.DAW != null) {
          Collections.sort(this.DAW, new Comparator() {});
        }
        if (paramString.Dgm.GOI != null)
        {
          paramString = paramString.Dgm.GOI;
          getInput().putString("key_true_name", paramString.DkG);
          getInput().putString("key_cre_name", paramString.DkK);
          getInput().putString("key_cre_type", paramString.DrN);
        }
        if ((this.DAW == null) || (this.DAW.isEmpty()))
        {
          ae.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          AppMethodBeat.o(71243);
          return true;
        }
        paramInt1 = this.DAW.size() - 1;
        label172:
        if (paramInt1 >= 0)
        {
          paramn = (ik)this.DAW.get(paramInt1);
          if ((bu.isNullOrNil(paramn.FTI)) || (!paramn.FTI.equals("cft"))) {
            break label484;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext());
          if ((bu.isNullOrNil(paramn.FTJ)) || (!paramn.FTJ.equals("1"))) {
            break label347;
          }
          paramString = getString(2131765886);
          paramString = getString(2131765884, new Object[] { paramn.uVs, paramString, paramn.FTK });
          if (!this.DAX) {
            break label358;
          }
          paramString = new SpannableString(paramString);
          label310:
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.a(paramn.DgJ, paramString);
          this.DAV.a(localSwitchPhoneItemView, 0);
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
          locall.Dxw = new l.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71239);
              ae.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
              WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, paramn);
              AppMethodBeat.o(71239);
            }
          };
          break label310;
          label484:
          paramString = new SwitchPhoneItemView(getContext());
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.a(paramn.DgJ, getString(2131765890));
          this.DAV.a(paramString, 0);
        }
      }
      if ((paramn instanceof y)) {
        eHb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI
 * JD-Core Version:    0.7.0.1
 */