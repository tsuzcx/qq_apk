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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.z;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankMobileRemittanceChooseUI
  extends MMPreference
{
  private f screen;
  private NormalIconNewTipPreference wHJ;
  private NormalIconNewTipPreference wHK;
  
  private static void Mx(int paramInt)
  {
    AppMethodBeat.i(67672);
    gg localgg = new gg();
    localgg.dCQ = paramInt;
    localgg.aHZ();
    AppMethodBeat.o(67672);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)z.jD(getContext()).inflate(2131493146, null);
    localLinearLayout.findViewById(2131297125).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67665);
        ac.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_scene", 1);
        d.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", paramAnonymousView);
        BankMobileRemittanceChooseUI.dxL();
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
    this.wHJ = ((NormalIconNewTipPreference)this.screen.aPN("bank_mobile_remit_choose_bank"));
    this.wHK = ((NormalIconNewTipPreference)this.screen.aPN("bank_mobile_remit_choose_mobile"));
    this.wHJ.HED = true;
    this.wHJ.setDesc(getString(2131756350));
    this.wHJ.fjl();
    this.wHJ.aag(8);
    this.wHJ.a(this.screen);
    com.tencent.mm.plugin.newtips.a.dkb().h(this.wHJ);
    this.wHK.HED = true;
    this.wHK.setDesc(getString(2131756352));
    this.wHK.fjl();
    this.wHK.aag(8);
    this.wHK.a(this.screen);
    com.tencent.mm.plugin.newtips.a.dkb().h(this.wHK);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(67667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(67666);
    super.onCreate(paramBundle);
    initView();
    paramBundle = com.tencent.mm.pluginsdk.g.a.eLv();
    if (!bs.aj(paramBundle))
    {
      paramBundle = paramBundle.toString().replace(" ", "");
      if ((!bs.isNullOrNil(paramBundle)) && ((c.dxj().wEc == null) || (!bs.lr(c.dxj().wEc.toString(), paramBundle))))
      {
        paramBundle = paramBundle.trim();
        ac.d("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "text:%s", new Object[] { paramBundle });
        if (!j.a.DCt.matcher(paramBundle).find()) {
          break label132;
        }
        a.a(this, false, paramBundle);
      }
    }
    for (;;)
    {
      if (i != 0) {
        c.dxj().wEc = paramBundle;
      }
      AppMethodBeat.o(67666);
      return;
      label132:
      if (j.a.DCs.matcher(paramBundle).find()) {
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
    ac.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", new Object[] { paramPreference.mKey });
    if (bs.lr("bank_mobile_remit_choose_bank", paramPreference.mKey))
    {
      com.tencent.mm.plugin.newtips.a.dkb().Ko(21);
      d.N(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (bs.lr("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      com.tencent.mm.plugin.newtips.a.dkb().Ko(22);
      if (g.agR().agA().getBoolean(ah.a.GTC, true)) {
        d.N(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
      }
      for (;;)
      {
        Mx(4);
        AppMethodBeat.o(67671);
        return true;
        d.N(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI
 * JD-Core Version:    0.7.0.1
 */