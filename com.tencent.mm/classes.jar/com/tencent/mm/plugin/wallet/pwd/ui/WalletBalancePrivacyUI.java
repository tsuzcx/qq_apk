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
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.protocal.protobuf.exa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.ak.i
{
  private WalletBalancePrivacyCheckBoxPreference HIN;
  private WalletBalancePrivacyMMHeaderPreference HIO;
  private Dialog jUV;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017299;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69596);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    setBackGroundColorResource(2131101424);
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
      getListView().setBackgroundColor(getResources().getColor(2131101424));
    }
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.removeAll();
    }
    this.HIN = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bmg("wallet_banlance_privacy_cb"));
    this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    g.aAi();
    g.aAg().hqi.a(new com.tencent.mm.plugin.wallet.pwd.a.i(), 0);
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
    if (this.HIO != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.HIO;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.Cmg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        com.tencent.mm.av.q.bcU().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.Cmg.clear();
    }
    g.aAi();
    g.aAg().hqi.b(2635, this);
    g.aAi();
    g.aAg().hqi.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (Util.isEqual(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()) });
      g.aAi();
      g.aAg().hqi.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    g.aAi();
    g.aAg().hqi.a(2635, this);
    g.aAi();
    g.aAg().hqi.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    Log.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    int i;
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label585;
      }
      Log.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.i)paramq;
      if ((this.screen != null) && (paramString != null) && (paramString.fOO() != null) && (paramString.fOO().MMQ != null)) {
        break label351;
      }
      i = 0;
      if ((this.jUV != null) && (this.jUV.isShowing())) {
        this.jUV.dismiss();
      }
      if (i == 0) {
        com.tencent.mm.ui.base.h.a(this, getString(2131768278), "", false, new DialogInterface.OnClickListener()
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
    label177:
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.k))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramq).fOP().MMP;
        if (this.HIN == null) {
          this.HIN = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bmg("wallet_banlance_privacy_cb"));
        }
        if (this.HIN != null)
        {
          paramString = Boolean.valueOf(this.HIN.isChecked());
          label248:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = com.tencent.mm.plugin.wallet_core.model.t.fQD().fRN();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramq).fOP().MMP;
          com.tencent.mm.plugin.wallet_core.model.t.fQD().b(paramString);
          com.tencent.mm.plugin.wallet_core.model.t.fQI().IbM = new al(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.HIN != null)
          {
            paramString = this.HIN;
            if (paramInt1 != 1) {
              break label650;
            }
          }
        }
        for (;;)
        {
          paramString.xZ(bool);
          AppMethodBeat.o(69597);
          return;
          label351:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.fOO().MMQ.Nuu, paramString.fOO().MMQ.title, paramString.fOO().MMQ.Nkr, paramString.fOO().MMQ.Nuv, Integer.valueOf(paramString.fOO().MMP) });
          this.screen.addPreferencesFromResource(2132017299);
          this.HIO = ((WalletBalancePrivacyMMHeaderPreference)this.screen.bmg("wallet_balance_privacy_header"));
          this.HIO.icon = paramString.fOO().MMQ.Nuu;
          this.HIO.title = paramString.fOO().MMQ.title;
          this.HIN = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bmg("wallet_banlance_privacy_cb"));
          this.HIN.OZw = false;
          this.HIN.setTitle(paramString.fOO().MMQ.Nkr);
          this.HIN.setSummary(paramString.fOO().MMQ.Nuv);
          this.HIN.oD = Util.isEqual(paramString.fOO().MMP, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label585:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.jUV != null) && (this.jUV.isShowing())) {
            this.jUV.dismiss();
          }
          com.tencent.mm.ui.base.h.a(this, getString(2131768278), "", false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69592);
              WalletBalancePrivacyUI.this.finish();
              AppMethodBeat.o(69592);
            }
          });
          break label177;
          paramString = "null";
          break label248;
          bool = false;
        }
      }
      u.makeText(this, getString(2131768273), 1).show();
      if (this.HIN == null)
      {
        paramString = this.HIN;
        if (this.HIN.isChecked()) {
          break label751;
        }
        bool = true;
        paramString.xZ(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramq;
      if (paramString.HIn != null) {
        break label757;
      }
    }
    label650:
    label751:
    label757:
    for (paramString = new dwo();; paramString = paramString.HIn)
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.MWM) });
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