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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.e.a;

public class BankMobileRemittanceChooseUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  private NormalIconNewTipPreference ylj;
  private NormalIconNewTipPreference ylk;
  
  private static void OF(int paramInt)
  {
    AppMethodBeat.i(67672);
    hl localhl = new hl();
    localhl.dQB = paramInt;
    localhl.aLH();
    AppMethodBeat.o(67672);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)z.jV(getContext()).inflate(2131493146, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131297125);
    String str = getString(2131756348);
    com.tencent.mm.wallet_core.ui.f.a(localTextView, str, str.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void aRM()
      {
        AppMethodBeat.i(189963);
        ae.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enter_scene", 1);
        d.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent);
        BankMobileRemittanceChooseUI.dMu();
        AppMethodBeat.o(189963);
      }
    }), getContext());
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
    this.ylj = ((NormalIconNewTipPreference)this.screen.aXe("bank_mobile_remit_choose_bank"));
    this.ylk = ((NormalIconNewTipPreference)this.screen.aXe("bank_mobile_remit_choose_mobile"));
    this.ylj.JNi = true;
    this.ylj.setDesc(getString(2131756350));
    this.ylj.fDC();
    this.ylj.acX(8);
    this.ylj.a(this.screen);
    a.dxD().h(this.ylj);
    this.ylk.JNi = true;
    this.ylk.setDesc(getString(2131756352));
    this.ylk.fDC();
    this.ylk.acX(8);
    this.ylk.a(this.screen);
    a.dxD().h(this.ylk);
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
    ae.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", new Object[] { paramPreference.mKey });
    if (bu.lX("bank_mobile_remit_choose_bank", paramPreference.mKey))
    {
      a.dxD().Mv(21);
      d.Q(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (bu.lX("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      a.dxD().Mv(22);
      if (g.ajR().ajA().getBoolean(am.a.JaH, true)) {
        d.Q(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
      }
      for (;;)
      {
        OF(4);
        AppMethodBeat.o(67671);
        return true;
        d.Q(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
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
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189962);
        BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this);
        AppMethodBeat.o(189962);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI
 * JD-Core Version:    0.7.0.1
 */