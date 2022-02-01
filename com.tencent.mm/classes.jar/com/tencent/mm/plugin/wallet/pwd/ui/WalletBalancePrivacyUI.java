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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private CheckBoxPreference Blc;
  private WalletBalancePrivacyMMHeaderPreference Bld;
  private Dialog iBT;
  private f screen;
  
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
    this.iBT = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(new i(), 0);
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
    if (this.Bld != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.Bld;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.wHG.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        o.aFA().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.wHG.clear();
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(2635, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (bs.lr(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      ac.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((CheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((CheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(2635, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    ac.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    int i;
    if ((paramn instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label587;
      }
      ac.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (i)paramn;
      if ((this.screen != null) && (paramString != null) && (paramString.epX() != null) && (paramString.epX().Fyx != null)) {
        break label353;
      }
      i = 0;
      if ((this.iBT != null) && (this.iBT.isShowing())) {
        this.iBT.dismiss();
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
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).epY().Fyw;
        if (this.Blc == null) {
          this.Blc = ((CheckBoxPreference)this.screen.aPN("wallet_banlance_privacy_cb"));
        }
        if (this.Blc != null)
        {
          paramString = Boolean.valueOf(this.Blc.isChecked());
          label249:
          ac.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = s.ert().eta();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).epY().Fyw;
          s.ert().b(paramString);
          s.ery().BAE = new ak(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.Blc != null)
          {
            paramString = this.Blc;
            if (paramInt1 != 1) {
              break label652;
            }
          }
        }
        for (;;)
        {
          paramString.wT(bool);
          AppMethodBeat.o(69597);
          return;
          label353:
          ac.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.epX().Fyx.GcK, paramString.epX().Fyx.title, paramString.epX().Fyx.FTK, paramString.epX().Fyx.GcL, Integer.valueOf(paramString.epX().Fyw) });
          this.screen.addPreferencesFromResource(2131951754);
          this.Bld = ((WalletBalancePrivacyMMHeaderPreference)this.screen.aPN("wallet_balance_privacy_header"));
          this.Bld.drM = paramString.epX().Fyx.GcK;
          this.Bld.title = paramString.epX().Fyx.title;
          this.Blc = ((CheckBoxPreference)this.screen.aPN("wallet_banlance_privacy_cb"));
          this.Blc.HFK = false;
          this.Blc.setTitle(paramString.epX().Fyx.FTK);
          this.Blc.setSummary(paramString.epX().Fyx.GcL);
          this.Blc.mF = bs.jl(paramString.epX().Fyw, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label587:
          ac.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.iBT != null) && (this.iBT.isShowing())) {
            this.iBT.dismiss();
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
      t.makeText(this, getString(2131765820), 1).show();
      if (this.Blc == null)
      {
        paramString = this.Blc;
        if (this.Blc.isChecked()) {
          break label754;
        }
        bool = true;
        paramString.wT(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramn;
      if (paramString.BkF != null) {
        break label760;
      }
    }
    label652:
    label754:
    label760:
    for (paramString = new cxd();; paramString = paramString.BkF)
    {
      ac.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.FGT) });
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