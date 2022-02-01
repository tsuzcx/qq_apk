package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private CheckBoxPreference CLq;
  private WalletBalancePrivacyMMHeaderPreference CLr;
  private Dialog iVd;
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
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131165292);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(2131101179));
    }
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.removeAll();
    }
    this.iVd = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(new i(), 0);
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
    if (this.CLr != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.CLr;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.xVn.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        com.tencent.mm.aw.q.aII().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.xVn.clear();
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2635, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (bt.lQ(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      ad.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((CheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((CheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2635, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    ad.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    int i;
    if ((paramn instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label587;
      }
      ad.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (i)paramn;
      if ((this.screen != null) && (paramString != null) && (paramString.eDX() != null) && (paramString.eDX().HiC != null)) {
        break label353;
      }
      i = 0;
      if ((this.iVd != null) && (this.iVd.isShowing())) {
        this.iVd.dismiss();
      }
      if (i == 0) {
        h.a(this, getString(2131765825), "", false, new DialogInterface.OnClickListener()
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
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.k))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eDY().HiB;
        if (this.CLq == null) {
          this.CLq = ((CheckBoxPreference)this.screen.aVD("wallet_banlance_privacy_cb"));
        }
        if (this.CLq != null)
        {
          paramString = Boolean.valueOf(this.CLq.isChecked());
          label249:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = com.tencent.mm.plugin.wallet_core.model.t.eFt().eHg();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eDY().HiB;
          com.tencent.mm.plugin.wallet_core.model.t.eFt().b(paramString);
          com.tencent.mm.plugin.wallet_core.model.t.eFy().DaW = new al(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.CLq != null)
          {
            paramString = this.CLq;
            if (paramInt1 != 1) {
              break label652;
            }
          }
        }
        for (;;)
        {
          paramString.xE(bool);
          AppMethodBeat.o(69597);
          return;
          label353:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.eDX().HiC.HNJ, paramString.eDX().HiC.title, paramString.eDX().HiC.HEy, paramString.eDX().HiC.HNK, Integer.valueOf(paramString.eDX().HiB) });
          this.screen.addPreferencesFromResource(2131951754);
          this.CLr = ((WalletBalancePrivacyMMHeaderPreference)this.screen.aVD("wallet_balance_privacy_header"));
          this.CLr.dDH = paramString.eDX().HiC.HNJ;
          this.CLr.title = paramString.eDX().HiC.title;
          this.CLq = ((CheckBoxPreference)this.screen.aVD("wallet_banlance_privacy_cb"));
          this.CLq.JtB = false;
          this.CLq.setTitle(paramString.eDX().HiC.HEy);
          this.CLq.setSummary(paramString.eDX().HiC.HNK);
          this.CLq.oB = bt.jx(paramString.eDX().HiB, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label587:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.iVd != null) && (this.iVd.isShowing())) {
            this.iVd.dismiss();
          }
          h.a(this, getString(2131765825), "", false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.t.makeText(this, getString(2131765820), 1).show();
      if (this.CLq == null)
      {
        paramString = this.CLq;
        if (this.CLq.isChecked()) {
          break label754;
        }
        bool = true;
        paramString.xE(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramn;
      if (paramString.CKT != null) {
        break label760;
      }
    }
    label652:
    label754:
    label760:
    for (paramString = new dcq();; paramString = paramString.CKT)
    {
      ad.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.HrB) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI
 * JD-Core Version:    0.7.0.1
 */