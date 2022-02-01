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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.g
{
  private Dialog ibM;
  private f screen;
  private CheckBoxPreference zSI;
  private WalletBalancePrivacyMMHeaderPreference zSJ;
  
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
    this.ibM = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(new i(), 0);
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
    if (this.zSJ != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.zSJ;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.vxB.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        o.ayI().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.vxB.clear();
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (bt.kU(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      ad.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((CheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((CheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2554, this);
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
      if ((this.screen != null) && (paramString != null) && (paramString.eaB() != null) && (paramString.eaB().EbC != null)) {
        break label353;
      }
      i = 0;
      if ((this.ibM != null) && (this.ibM.isShowing())) {
        this.ibM.dismiss();
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
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eaC().EbB;
        if (this.zSI == null) {
          this.zSI = ((CheckBoxPreference)this.screen.aKk("wallet_banlance_privacy_cb"));
        }
        if (this.zSI != null)
        {
          paramString = Boolean.valueOf(this.zSI.isChecked());
          label249:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = s.ebX().edF();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramn).eaC().EbB;
          s.ebX().b(paramString);
          s.ecc().Aij = new ak(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.zSI != null)
          {
            paramString = this.zSI;
            if (paramInt1 != 1) {
              break label652;
            }
          }
        }
        for (;;)
        {
          paramString.vP(bool);
          AppMethodBeat.o(69597);
          return;
          label353:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.eaB().EbC.EFy, paramString.eaB().EbC.title, paramString.eaB().EbC.EwI, paramString.eaB().EbC.EFz, Integer.valueOf(paramString.eaB().EbB) });
          this.screen.addPreferencesFromResource(2131951754);
          this.zSJ = ((WalletBalancePrivacyMMHeaderPreference)this.screen.aKk("wallet_balance_privacy_header"));
          this.zSJ.dub = paramString.eaB().EbC.EFy;
          this.zSJ.title = paramString.eaB().EbC.title;
          this.zSI = ((CheckBoxPreference)this.screen.aKk("wallet_banlance_privacy_cb"));
          this.zSI.GfV = false;
          this.zSI.setTitle(paramString.eaB().EbC.EwI);
          this.zSI.setSummary(paramString.eaB().EbC.EFz);
          this.zSI.lG = bt.iY(paramString.eaB().EbB, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label587:
          ad.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.ibM != null) && (this.ibM.isShowing())) {
            this.ibM.dismiss();
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
      if (this.zSI == null)
      {
        paramString = this.zSI;
        if (this.zSI.isChecked()) {
          break label754;
        }
        bool = true;
        paramString.vP(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramn;
      if (paramString.zSl != null) {
        break label760;
      }
    }
    label652:
    label754:
    label760:
    for (paramString = new cru();; paramString = paramString.zSl)
    {
      ad.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.EjV) });
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