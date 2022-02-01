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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private WalletBalancePrivacyCheckBoxPreference DcZ;
  private WalletBalancePrivacyMMHeaderPreference Dda;
  private Dialog iXW;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131951754;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69596);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
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
      getListView().setBackgroundColor(getResources().getColor(2131101179));
    }
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.removeAll();
    }
    this.DcZ = ((WalletBalancePrivacyCheckBoxPreference)this.screen.aXe("wallet_banlance_privacy_cb"));
    this.iXW = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    g.ajS();
    g.ajQ().gDv.a(new i(), 0);
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
    if (this.Dda != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.Dda;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.ylg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        com.tencent.mm.av.q.aJa().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.ylg.clear();
    }
    g.ajS();
    g.ajQ().gDv.b(2635, this);
    g.ajS();
    g.ajQ().gDv.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (bu.lX(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      ae.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()) });
      g.ajS();
      g.ajQ().gDv.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    g.ajS();
    g.ajQ().gDv.a(2635, this);
    g.ajS();
    g.ajQ().gDv.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    ae.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    int i;
    if ((paramn instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label585;
      }
      ae.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (i)paramn;
      if ((this.screen != null) && (paramString != null) && (paramString.eHE() != null) && (paramString.eHE().HCc != null)) {
        break label351;
      }
      i = 0;
      if ((this.iXW != null) && (this.iXW.isShowing())) {
        this.iXW.dismiss();
      }
      if (i == 0) {
        com.tencent.mm.ui.base.h.a(this, getString(2131765825), "", false, new DialogInterface.OnClickListener()
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
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.k))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eHF().HCb;
        if (this.DcZ == null) {
          this.DcZ = ((WalletBalancePrivacyCheckBoxPreference)this.screen.aXe("wallet_banlance_privacy_cb"));
        }
        if (this.DcZ != null)
        {
          paramString = Boolean.valueOf(this.DcZ.isChecked());
          label248:
          ae.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = com.tencent.mm.plugin.wallet_core.model.t.eJa().eKO();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eHF().HCb;
          com.tencent.mm.plugin.wallet_core.model.t.eJa().b(paramString);
          com.tencent.mm.plugin.wallet_core.model.t.eJf().DsA = new al(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.DcZ != null)
          {
            paramString = this.DcZ;
            if (paramInt1 != 1) {
              break label650;
            }
          }
        }
        for (;;)
        {
          paramString.uo(bool);
          AppMethodBeat.o(69597);
          return;
          label351:
          ae.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.eHE().HCc.IhQ, paramString.eHE().HCc.title, paramString.eHE().HCc.HYl, paramString.eHE().HCc.IhR, Integer.valueOf(paramString.eHE().HCb) });
          this.screen.addPreferencesFromResource(2131951754);
          this.Dda = ((WalletBalancePrivacyMMHeaderPreference)this.screen.aXe("wallet_balance_privacy_header"));
          this.Dda.dEM = paramString.eHE().HCc.IhQ;
          this.Dda.title = paramString.eHE().HCc.title;
          this.DcZ = ((WalletBalancePrivacyCheckBoxPreference)this.screen.aXe("wallet_banlance_privacy_cb"));
          this.DcZ.JOq = false;
          this.DcZ.setTitle(paramString.eHE().HCc.HYl);
          this.DcZ.setSummary(paramString.eHE().HCc.IhR);
          this.DcZ.oB = bu.jB(paramString.eHE().HCb, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label585:
          ae.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.iXW != null) && (this.iXW.isShowing())) {
            this.iXW.dismiss();
          }
          com.tencent.mm.ui.base.h.a(this, getString(2131765825), "", false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.t.makeText(this, getString(2131765820), 1).show();
      if (this.DcZ == null)
      {
        paramString = this.DcZ;
        if (this.DcZ.isChecked()) {
          break label751;
        }
        bool = true;
        paramString.uo(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramn;
      if (paramString.Dcz != null) {
        break label757;
      }
    }
    label650:
    label751:
    label757:
    for (paramString = new ddk();; paramString = paramString.Dcz)
    {
      ae.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.HLd) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI
 * JD-Core Version:    0.7.0.1
 */