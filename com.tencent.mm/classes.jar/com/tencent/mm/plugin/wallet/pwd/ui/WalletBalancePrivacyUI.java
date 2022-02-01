package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private WalletBalancePrivacyCheckBoxPreference OAF;
  private WalletBalancePrivacyMMHeaderPreference OAG;
  private Dialog mMi;
  private f screen;
  
  public int getResourceId()
  {
    return a.m.wallet_balance_privacy_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69596);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69590);
        WalletBalancePrivacyUI.this.finish();
        AppMethodBeat.o(69590);
        return true;
      }
    });
    if (getListView() != null) {
      getListView().setBackgroundColor(getResources().getColor(a.c.white));
    }
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.removeAll();
    }
    this.OAF = ((WalletBalancePrivacyCheckBoxPreference)this.screen.byG("wallet_banlance_privacy_cb"));
    this.mMi = com.tencent.mm.wallet_core.ui.i.c(this, false, null);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.wallet.pwd.a.i(), 0);
    AppMethodBeat.o(69596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69593);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    AppMethodBeat.o(69593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69598);
    super.onDestroy();
    if (this.OAG != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.OAG;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.IiZ.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        com.tencent.mm.ay.q.bmk().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.IiZ.clear();
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2635, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (Util.isEqual(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2635, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    Log.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    int i;
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label588;
      }
      Log.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.i)paramq;
      if ((this.screen != null) && (paramString != null) && (paramString.gHt() != null) && (paramString.gHt().TYK != null)) {
        break label353;
      }
      i = 0;
      if ((this.mMi != null) && (this.mMi.isShowing())) {
        this.mMi.dismiss();
      }
      if (i == 0) {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_security_info_get_error), "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69591);
            WalletBalancePrivacyUI.this.finish();
            AppMethodBeat.o(69591);
          }
        });
      }
    }
    label178:
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.k))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramq).gHu().TYJ;
        if (this.OAF == null) {
          this.OAF = ((WalletBalancePrivacyCheckBoxPreference)this.screen.byG("wallet_banlance_privacy_cb"));
        }
        if (this.OAF != null)
        {
          paramString = Boolean.valueOf(this.OAF.isChecked());
          label249:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = u.gJj().gKZ();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramq).gHu().TYJ;
          u.gJj().b(paramString);
          u.gJo().OTY = new am(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.OAF != null)
          {
            paramString = this.OAF;
            if (paramInt1 != 1) {
              break label653;
            }
          }
        }
        for (;;)
        {
          paramString.BT(bool);
          AppMethodBeat.o(69597);
          return;
          label353:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.gHt().TYK.UHv, paramString.gHt().TYK.title, paramString.gHt().TYK.Uxb, paramString.gHt().TYK.UHw, Integer.valueOf(paramString.gHt().TYJ) });
          this.screen.auC(a.m.wallet_balance_privacy_ui);
          this.OAG = ((WalletBalancePrivacyMMHeaderPreference)this.screen.byG("wallet_balance_privacy_header"));
          this.OAG.icon = paramString.gHt().TYK.UHv;
          this.OAG.title = paramString.gHt().TYK.title;
          this.OAF = ((WalletBalancePrivacyCheckBoxPreference)this.screen.byG("wallet_banlance_privacy_cb"));
          this.OAF.WsF = false;
          this.OAF.setTitle(paramString.gHt().TYK.Uxb);
          this.OAF.aF(paramString.gHt().TYK.UHw);
          this.OAF.bBh = Util.isEqual(paramString.gHt().TYJ, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label588:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.mMi != null) && (this.mMi.isShowing())) {
            this.mMi.dismiss();
          }
          com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_security_info_get_error), "", false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69592);
              WalletBalancePrivacyUI.this.finish();
              AppMethodBeat.o(69592);
            }
          });
          break label178;
          paramString = "null";
          break label249;
          bool = false;
        }
      }
      w.makeText(this, getString(a.i.wallet_security_balance_privacy_set_fail), 1).show();
      if (this.OAF == null)
      {
        paramString = this.OAF;
        if (this.OAF.isChecked()) {
          break label755;
        }
        bool = true;
        paramString.BT(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramq;
      if (paramString.OAf != null) {
        break label761;
      }
    }
    label653:
    label755:
    label761:
    for (paramString = new ego();; paramString = paramString.OAf)
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.Ujh) });
      AppMethodBeat.o(69597);
      return;
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI
 * JD-Core Version:    0.7.0.1
 */