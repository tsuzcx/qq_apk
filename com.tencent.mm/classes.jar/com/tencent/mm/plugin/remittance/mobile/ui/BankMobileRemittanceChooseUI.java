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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.ui.e.a;

public class BankMobileRemittanceChooseUI
  extends MMPreference
{
  private NormalIconNewTipPreference Cmj;
  private NormalIconNewTipPreference Cmk;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private static void Wa(int paramInt)
  {
    AppMethodBeat.i(67672);
    lc locallc = new lc();
    locallc.ejA = paramInt;
    locallc.bfK();
    AppMethodBeat.o(67672);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)aa.jQ(getContext()).inflate(2131493190, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131297269);
    String str = getString(2131756483);
    com.tencent.mm.wallet_core.ui.f.a(localTextView, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(213707);
        Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enter_scene", 1);
        c.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent);
        BankMobileRemittanceChooseUI.eNu();
        AppMethodBeat.o(213707);
      }
    }), getContext());
    AppMethodBeat.o(67669);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return 2132017168;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67667);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackGroundColorResource(2131101424);
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131165299);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(2131101424));
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
    this.Cmj = ((NormalIconNewTipPreference)this.screen.bmg("bank_mobile_remit_choose_bank"));
    this.Cmk = ((NormalIconNewTipPreference)this.screen.bmg("bank_mobile_remit_choose_mobile"));
    this.Cmj.OYi = true;
    this.Cmj.setDesc(getString(2131756485));
    this.Cmj.gLF();
    this.Cmj.alI(8);
    this.Cmj.a(this.screen);
    a.exl().h(this.Cmj);
    this.Cmk.OYi = true;
    this.Cmk.setDesc(getString(2131756487));
    this.Cmk.gLF();
    this.Cmk.alI(8);
    this.Cmk.a(this.screen);
    a.exl().h(this.Cmk);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(67667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67666);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(67666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67670);
    super.onDestroy();
    AppMethodBeat.o(67670);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67671);
    Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", new Object[] { paramPreference.mKey });
    if (Util.isEqual("bank_mobile_remit_choose_bank", paramPreference.mKey))
    {
      a.exl().TC(21);
      c.V(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (Util.isEqual("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      a.exl().TC(22);
      if (g.aAh().azQ().getBoolean(ar.a.Ojn, true)) {
        c.V(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
      }
      for (;;)
      {
        Wa(4);
        AppMethodBeat.o(67671);
        return true;
        c.V(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
      }
    }
    AppMethodBeat.o(67671);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67668);
    super.onResume();
    setBackGroundColorResource(2131101424);
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213706);
        BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this);
        AppMethodBeat.o(213706);
      }
    });
    AppMethodBeat.o(67668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI
 * JD-Core Version:    0.7.0.1
 */