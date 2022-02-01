package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.ny;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.g;

public class BankMobileRemittanceChooseUI
  extends MMPreference
{
  private NormalIconNewTipPreference Ijc;
  private NormalIconNewTipPreference Ijd;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private static void acO(int paramInt)
  {
    AppMethodBeat.i(67672);
    ny localny = new ny();
    localny.gef = paramInt;
    localny.bpa();
    AppMethodBeat.o(67672);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)ad.kS(getContext()).inflate(a.g.bank_mobile_remit_choose_ui_footer, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(a.f.bank_mobile_remit_footer_title_tv);
    String str = getString(a.i.bank_mobile_remit_choose_footer_title);
    g.a(localTextView, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(192311);
        Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enter_scene", 1);
        c.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent);
        BankMobileRemittanceChooseUI.fAj();
        AppMethodBeat.o(192311);
      }
    }), getContext());
    AppMethodBeat.o(67669);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return a.m.bank_mobile_remit_choose_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67667);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(a.d.Edge_3A);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(a.c.white));
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
    this.Ijc = ((NormalIconNewTipPreference)this.screen.byG("bank_mobile_remit_choose_bank"));
    this.Ijd = ((NormalIconNewTipPreference)this.screen.byG("bank_mobile_remit_choose_mobile"));
    this.Ijc.Wrr = true;
    this.Ijc.setDesc(getString(a.i.bank_mobile_remit_choose_header_bank_desc));
    this.Ijc.hKI();
    this.Ijc.auG(8);
    this.Ijc.a(this.screen);
    a.fiO().h(this.Ijc);
    this.Ijd.Wrr = true;
    this.Ijd.setDesc(getString(a.i.bank_mobile_remit_choose_header_mobile_desc));
    this.Ijd.hKI();
    this.Ijd.auG(8);
    this.Ijd.a(this.screen);
    a.fiO().h(this.Ijd);
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
      a.fiO().aap(21);
      c.ad(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (Util.isEqual("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      a.fiO().aap(22);
      if (h.aHG().aHp().getBoolean(ar.a.VxD, true)) {
        c.ad(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
      }
      for (;;)
      {
        acO(4);
        AppMethodBeat.o(67671);
        return true;
        c.ad(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
      }
    }
    AppMethodBeat.o(67671);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67668);
    super.onResume();
    setBackGroundColorResource(a.c.white);
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223678);
        BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this);
        AppMethodBeat.o(223678);
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