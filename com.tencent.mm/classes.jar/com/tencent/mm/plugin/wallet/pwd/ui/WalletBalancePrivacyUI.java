package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.ekw;
import com.tencent.mm.protocal.protobuf.fao;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.gdz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WalletBalancePrivacyUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private WalletBalancePrivacyCheckBoxPreference VpS;
  private WalletBalancePrivacyMMHeaderPreference VpT;
  private Dialog pIQ;
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
    this.VpS = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bAi("wallet_banlance_privacy_cb"));
    this.pIQ = l.c(this, false, null);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(new i(), 0);
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
    if (this.VpT != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.VpT;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.OfK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        r.bKd().b((String)localEntry.getKey(), (s.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.OfK.clear();
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2635, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2554, this);
    AppMethodBeat.o(69598);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69595);
    if (Util.isEqual(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.wallet.pwd.a.k(((WalletBalancePrivacyCheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(69595);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69594);
    super.onResume();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2635, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2554, this);
    AppMethodBeat.o(69594);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(69597);
    Log.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    int i;
    if ((paramp instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label588;
      }
      Log.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (i)paramp;
      if ((this.screen != null) && (paramString != null) && (paramString.igy() != null) && (paramString.igy().abpH != null)) {
        break label353;
      }
      i = 0;
      if ((this.pIQ != null) && (this.pIQ.isShowing())) {
        this.pIQ.dismiss();
      }
      if (i == 0) {
        com.tencent.mm.ui.base.k.a(this, getString(a.i.wallet_security_info_get_error), "", false, new DialogInterface.OnClickListener()
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
    if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.k))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramp).igz().abpG;
        if (this.VpS == null) {
          this.VpS = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bAi("wallet_banlance_privacy_cb"));
        }
        if (this.VpS != null)
        {
          paramString = Boolean.valueOf(this.VpS.isChecked());
          label249:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = u.iix().ijK();
          paramString.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.k)paramp).igz().abpG;
          u.iix().b(paramString);
          u.iiC().VKe = new ak(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.VpS != null)
          {
            paramString = this.VpS;
            if (paramInt1 != 1) {
              break label653;
            }
          }
        }
        for (;;)
        {
          paramString.Hy(bool);
          AppMethodBeat.o(69597);
          return;
          label353:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.igy().abpH.aakc, paramString.igy().abpH.title, paramString.igy().abpH.abQJ, paramString.igy().abpH.acbF, Integer.valueOf(paramString.igy().abpG) });
          this.screen.aBe(a.m.wallet_balance_privacy_ui);
          this.VpT = ((WalletBalancePrivacyMMHeaderPreference)this.screen.bAi("wallet_balance_privacy_header"));
          this.VpT.icon = paramString.igy().abpH.aakc;
          this.VpT.title = paramString.igy().abpH.title;
          this.VpS = ((WalletBalancePrivacyCheckBoxPreference)this.screen.bAi("wallet_banlance_privacy_cb"));
          this.VpS.adZV = false;
          this.VpS.setTitle(paramString.igy().abpH.abQJ);
          this.VpS.aS(paramString.igy().abpH.acbF);
          this.VpS.duj = Util.isEqual(paramString.igy().abpG, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label588:
          Log.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.pIQ != null) && (this.pIQ.isShowing())) {
            this.pIQ.dismiss();
          }
          com.tencent.mm.ui.base.k.a(this, getString(a.i.wallet_security_info_get_error), "", false, new DialogInterface.OnClickListener()
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
      aa.makeText(this, getString(a.i.wallet_security_balance_privacy_set_fail), 1).show();
      if (this.VpS == null)
      {
        paramString = this.VpS;
        if (this.VpS.isChecked()) {
          break label755;
        }
        bool = true;
        paramString.Hy(bool);
      }
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.k)paramp;
      if (paramString.Vps != null) {
        break label761;
      }
    }
    label653:
    label755:
    label761:
    for (paramString = new fao();; paramString = paramString.Vps)
    {
      Log.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.aagR) });
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315696);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(d.class);
    AppMethodBeat.o(315696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI
 * JD-Core Version:    0.7.0.1
 */