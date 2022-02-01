package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankMobileRemittanceChooseUI
  extends MMPreference
{
  private f screen;
  private NormalIconNewTipPreference vxE;
  private NormalIconNewTipPreference vxF;
  
  private static void Ky(int paramInt)
  {
    AppMethodBeat.i(67672);
    eq localeq = new eq();
    localeq.dFd = paramInt;
    localeq.aBj();
    AppMethodBeat.o(67672);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)y.js(getContext()).inflate(2131493146, null);
    localLinearLayout.findViewById(2131297125).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67665);
        ad.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_scene", 1);
        d.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", paramAnonymousView);
        BankMobileRemittanceChooseUI.djJ();
        AppMethodBeat.o(67665);
      }
    });
    AppMethodBeat.o(67669);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return 2131951631;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67667);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131165292);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(2131101179));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67664);
        BankMobileRemittanceChooseUI.this.finish();
        AppMethodBeat.o(67664);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.vxE = ((NormalIconNewTipPreference)this.screen.aKk("bank_mobile_remit_choose_bank"));
    this.vxF = ((NormalIconNewTipPreference)this.screen.aKk("bank_mobile_remit_choose_mobile"));
    this.vxE.GeO = true;
    this.vxE.setDesc(getString(2131756350));
    this.vxE.eTz();
    this.vxE.XV(8);
    this.vxE.a(this.screen);
    com.tencent.mm.plugin.newtips.a.cWs().h(this.vxE);
    this.vxF.GeO = true;
    this.vxF.setDesc(getString(2131756352));
    this.vxF.eTz();
    this.vxF.XV(8);
    this.vxF.a(this.screen);
    com.tencent.mm.plugin.newtips.a.cWs().h(this.vxF);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(67667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(67666);
    super.onCreate(paramBundle);
    initView();
    paramBundle = com.tencent.mm.pluginsdk.g.a.ewb();
    if (!bt.ai(paramBundle))
    {
      paramBundle = paramBundle.toString().replace(" ", "");
      if ((!bt.isNullOrNil(paramBundle)) && ((c.djj().vtX == null) || (!bt.kU(c.djj().vtX.toString(), paramBundle))))
      {
        paramBundle = paramBundle.trim();
        ad.d("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "text:%s", new Object[] { paramBundle });
        if (!j.a.Ckc.matcher(paramBundle).find()) {
          break label132;
        }
        a.a(this, false, paramBundle);
      }
    }
    for (;;)
    {
      if (i != 0) {
        c.djj().vtX = paramBundle;
      }
      AppMethodBeat.o(67666);
      return;
      label132:
      if (j.a.Ckb.matcher(paramBundle).find()) {
        a.a(this, true, paramBundle);
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67670);
    super.onDestroy();
    AppMethodBeat.o(67670);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67671);
    ad.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", new Object[] { paramPreference.mKey });
    if (bt.kU("bank_mobile_remit_choose_bank", paramPreference.mKey))
    {
      com.tencent.mm.plugin.newtips.a.cWs().Ip(21);
      d.O(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (bt.kU("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      com.tencent.mm.plugin.newtips.a.cWs().Ip(22);
      if (g.afB().afk().getBoolean(ae.a.FvI, true)) {
        d.O(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
      }
      for (;;)
      {
        Ky(4);
        AppMethodBeat.o(67671);
        return true;
        d.O(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
      }
    }
    AppMethodBeat.o(67671);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67668);
    super.onResume();
    setBackGroundColorResource(2131101179);
    AppMethodBeat.o(67668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI
 * JD-Core Version:    0.7.0.1
 */