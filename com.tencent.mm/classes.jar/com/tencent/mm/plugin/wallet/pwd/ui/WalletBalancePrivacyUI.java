package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements com.tencent.mm.ai.f
{
  private Dialog gpx;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference tYr;
  private WalletBalancePrivacyMMHeaderPreference tYs;
  
  public int getResourceId()
  {
    return 2131165310;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46217);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131689615));
    setBackGroundColorResource(2131689615);
    setBackBtn(new WalletBalancePrivacyUI.1(this));
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131427589);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(2131689615));
    }
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.removeAll();
    }
    this.gpx = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.wallet.pwd.a.g(), 0);
    AppMethodBeat.o(46217);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46214);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    AppMethodBeat.o(46214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46219);
    super.onDestroy();
    if (this.tYs != null)
    {
      WalletBalancePrivacyMMHeaderPreference localWalletBalancePrivacyMMHeaderPreference = this.tYs;
      Iterator localIterator = localWalletBalancePrivacyMMHeaderPreference.tYo.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        o.ahF().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
      }
      localWalletBalancePrivacyMMHeaderPreference.tYo.clear();
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(2635, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(2554, this);
    AppMethodBeat.o(46219);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(46216);
    if (bo.isEqual(paramPreference.mKey, "wallet_banlance_privacy_cb"))
    {
      ab.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", new Object[] { Boolean.valueOf(((CheckBoxPreference)paramPreference).isChecked()) });
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new i(((CheckBoxPreference)paramPreference).isChecked()), 0);
    }
    AppMethodBeat.o(46216);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46215);
    super.onResume();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(2635, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(2554, this);
    AppMethodBeat.o(46215);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(46218);
    ab.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    int i;
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label587;
      }
      ab.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.g)paramm;
      if ((this.screen != null) && (paramString != null) && (paramString.cSp() != null) && (paramString.cSp().xEE != null)) {
        break label353;
      }
      i = 0;
      if ((this.gpx != null) && (this.gpx.isShowing())) {
        this.gpx.dismiss();
      }
      if (i == 0) {
        h.a(this, getString(2131305609), "", false, new WalletBalancePrivacyUI.2(this));
      }
    }
    label178:
    if ((paramm instanceof i))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = ((i)paramm).cSq().xED;
        if (this.tYr == null) {
          this.tYr = ((CheckBoxPreference)this.screen.atx("wallet_banlance_privacy_cb"));
        }
        if (this.tYr != null)
        {
          paramString = Boolean.valueOf(this.tYr.isChecked());
          label249:
          ab.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
          paramString = com.tencent.mm.plugin.wallet_core.model.t.cTJ().cVl();
          paramString.field_wallet_entrance_balance_switch_state = ((i)paramm).cSq().xED;
          com.tencent.mm.plugin.wallet_core.model.t.cTJ().b(paramString);
          com.tencent.mm.plugin.wallet_core.model.t.cTN().ulP = new ak(paramString.field_switchConfig, paramString.field_wallet_entrance_balance_switch_state);
          if (this.tYr != null)
          {
            paramString = this.tYr;
            if (paramInt1 != 1) {
              break label652;
            }
          }
        }
        for (;;)
        {
          paramString.qH(bool);
          AppMethodBeat.o(46218);
          return;
          label353:
          ab.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", new Object[] { paramString.cSp().xEE.ydM, paramString.cSp().xEE.title, paramString.cSp().xEE.xWf, paramString.cSp().xEE.ydN, Integer.valueOf(paramString.cSp().xED) });
          this.screen.addPreferencesFromResource(2131165310);
          this.tYs = ((WalletBalancePrivacyMMHeaderPreference)this.screen.atx("wallet_balance_privacy_header"));
          this.tYs.cDz = paramString.cSp().xEE.ydM;
          this.tYs.title = paramString.cSp().xEE.title;
          this.tYr = ((CheckBoxPreference)this.screen.atx("wallet_banlance_privacy_cb"));
          this.tYr.zsk = false;
          this.tYr.setTitle(paramString.cSp().xEE.xWf);
          this.tYr.setSummary(paramString.cSp().xEE.ydN);
          this.tYr.vxW = bo.hl(paramString.cSp().xED, 1);
          this.screen.notifyDataSetChanged();
          i = 1;
          break;
          label587:
          ab.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
          if ((this.gpx != null) && (this.gpx.isShowing())) {
            this.gpx.dismiss();
          }
          h.a(this, getString(2131305609), "", false, new WalletBalancePrivacyUI.3(this));
          break label178;
          paramString = "null";
          break label249;
          bool = false;
        }
      }
      com.tencent.mm.ui.base.t.makeText(this, getString(2131305604), 1).show();
      if (this.tYr == null)
      {
        paramString = this.tYr;
        if (this.tYr.isChecked()) {
          break label754;
        }
        bool = true;
        paramString.qH(bool);
      }
      paramString = (i)paramm;
      if (paramString.tXU != null) {
        break label760;
      }
    }
    label652:
    label754:
    label760:
    for (paramString = new cbe();; paramString = paramString.tXU)
    {
      ab.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", new Object[] { Integer.valueOf(paramString.xLX) });
      AppMethodBeat.o(46218);
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