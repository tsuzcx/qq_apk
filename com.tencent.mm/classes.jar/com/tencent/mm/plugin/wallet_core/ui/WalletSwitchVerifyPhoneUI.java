package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private SwitchPhoneItemGroupView Ikh;
  private List<ix> Iki;
  public boolean Ikj = false;
  
  private void fOl()
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
    ElementQuery localElementQuery = t.fQQ().aVi(localBankcard.field_bankcardType);
    getInput().putParcelable("elemt_query", localElementQuery);
    localAuthen.dDj = localBankcard.field_bankcardType;
    localAuthen.ANo = localBankcard.field_bindSerial;
    localBankcard.field_bankPhone = localElementQuery.HXo;
    getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
    getInput().putBoolean("key_is_changing_balance_phone_num", true);
    getInput().putInt("key_err_code", 418);
    com.tencent.mm.wallet_core.a.l(this, getInput());
    AppMethodBeat.o(71244);
  }
  
  public int getLayoutId()
  {
    return 2131497014;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71241);
    this.Ikh = ((SwitchPhoneItemGroupView)findViewById(2131305885));
    this.Ikh.setOnItemSelectListener(new SwitchPhoneItemGroupView.a()
    {
      public final void gb(View paramAnonymousView)
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
            com.tencent.mm.wallet_core.a.l(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.getInput());
            AppMethodBeat.o(71237);
            return;
          }
          paramAnonymousView = (ix)WalletSwitchVerifyPhoneUI.b(WalletSwitchVerifyPhoneUI.this).get(i);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", false);
          Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramAnonymousView.KNr.equals("wx")) });
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
    overridePendingTransition(2130772132, 2130771986);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131768340));
    initView();
    this.Ikj = getInput().getBoolean("key_block_bind_new_card", false);
    if (!this.Ikj)
    {
      paramBundle = new SwitchPhoneItemView(getContext());
      paramBundle.setTag(Integer.valueOf(-1));
      paramBundle.a(getString(2131768336), null);
      this.Ikh.a(paramBundle, -1);
    }
    if ((getProcess() != null) && (getProcess().dKC().equals("PayProcess")) && (getInput().getInt("key_can_verify_tail", 0) == 1))
    {
      Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
      paramBundle = getString(2131767735);
      SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext(), 2131497012);
      localSwitchPhoneItemView.setTag(Integer.valueOf(-2));
      localSwitchPhoneItemView.a(paramBundle, null);
      this.Ikh.a(localSwitchPhoneItemView, -1);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(71243);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof h))
      {
        paramString = (h)paramq;
        this.Iki = ((h)paramq).HPF.LSL;
        if (this.Iki != null) {
          Collections.sort(this.Iki, new Comparator() {});
        }
        if (paramString.HPF.LSM != null)
        {
          paramString = paramString.HPF.LSM;
          getInput().putString("key_true_name", paramString.HTZ);
          getInput().putString("key_cre_name", paramString.HUd);
          getInput().putString("key_cre_type", paramString.IaZ);
        }
        if ((this.Iki == null) || (this.Iki.isEmpty()))
        {
          Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
          AppMethodBeat.o(71243);
          return true;
        }
        paramInt1 = this.Iki.size() - 1;
        label172:
        if (paramInt1 >= 0)
        {
          paramq = (ix)this.Iki.get(paramInt1);
          if ((Util.isNullOrNil(paramq.KNr)) || (!paramq.KNr.equals("cft"))) {
            break label484;
          }
          SwitchPhoneItemView localSwitchPhoneItemView = new SwitchPhoneItemView(getContext());
          if ((Util.isNullOrNil(paramq.KNs)) || (!paramq.KNs.equals("1"))) {
            break label347;
          }
          paramString = getString(2131768339);
          paramString = getString(2131768337, new Object[] { paramq.ynT, paramString, paramq.KNt });
          if (!this.Ikj) {
            break label358;
          }
          paramString = new SpannableString(paramString);
          label310:
          localSwitchPhoneItemView.setTag(Integer.valueOf(paramInt1));
          localSwitchPhoneItemView.a(paramq.HQc, paramString);
          this.Ikh.a(localSwitchPhoneItemView, 0);
        }
        for (;;)
        {
          label262:
          paramInt1 -= 1;
          break label172;
          break;
          label347:
          paramString = getString(2131768338);
          break label262;
          label358:
          String str1 = getString(2131768342);
          l locall = new l(this);
          String str2 = paramString + "，";
          locall.mColor = getResources().getColor(2131100053);
          paramString = new SpannableString(str2 + str1);
          paramString.setSpan(locall, str2.length(), str2.length() + str1.length(), 33);
          locall.IgH = new l.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71239);
              Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
              WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, paramq);
              AppMethodBeat.o(71239);
            }
          };
          break label310;
          label484:
          paramString = new SwitchPhoneItemView(getContext());
          paramString.setTag(Integer.valueOf(paramInt1));
          paramString.a(paramq.HQc, getString(2131768343));
          this.Ikh.a(paramString, 0);
        }
      }
      if ((paramq instanceof y)) {
        fOl();
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