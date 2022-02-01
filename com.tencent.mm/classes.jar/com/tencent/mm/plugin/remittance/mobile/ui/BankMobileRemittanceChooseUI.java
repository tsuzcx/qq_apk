package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.rq;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.plugin.remittance.mobile.cgi.d;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.ui.f.a;
import java.io.IOException;

public class BankMobileRemittanceChooseUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private NormalIconNewTipPreference OfN;
  private NormalIconNewTipPreference OfO;
  private String OfP;
  private Dialog pIx = null;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void a(final MMActivity paramMMActivity, final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(288916);
    final j localj = new j(paramMMActivity, 1, 3);
    localj.d(paramMMActivity.getString(a.i.mobile_remit_number_input_cancel), paramMMActivity.getString(a.i.bank_mobile_remit_dialog_ok));
    View localView = View.inflate(paramMMActivity, a.g.bank_mobile_remit_short_cut_dialog_title, null);
    Object localObject = (TextView)localView.findViewById(a.f.title);
    aw.a(((TextView)localObject).getPaint(), 0.8F);
    if (paramBoolean)
    {
      ((TextView)localObject).setText(a.i.bank_mobile_remit_dialog_title_bank);
      char[] arrayOfChar = paramString.toCharArray();
      paramString = "";
      int i = 0;
      while (i < arrayOfChar.length)
      {
        localObject = paramString;
        if (i % 4 == 0)
        {
          localObject = paramString;
          if (i > 0) {
            localObject = paramString + " ";
          }
        }
        paramString = (String)localObject + arrayOfChar[i];
        i += 1;
      }
      b.ahf(4);
    }
    for (;;)
    {
      localObject = View.inflate(paramMMActivity, a.g.bank_mobile_remit_short_cut_dialog_content, null);
      ((TextView)((View)localObject).findViewById(a.f.content)).setText(paramString);
      localj.a(new j.a()new j.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(288871);
          Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "showBankMobileShortCutView click cancel!");
          localj.cyW();
          if (paramBoolean)
          {
            b.ahf(5);
            AppMethodBeat.o(288871);
            return;
          }
          b.ahf(2);
          AppMethodBeat.o(288871);
        }
      }, new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(288872);
          Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "showBankMobileShortCutView click confirm!");
          Intent localIntent = new Intent();
          if (paramBoolean)
          {
            localIntent.putExtra("key_content", paramString);
            c.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", localIntent);
            b.ahf(6);
          }
          for (;;)
          {
            localj.cyW();
            AppMethodBeat.o(288872);
            return;
            BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this, paramString);
            BankMobileRemittanceChooseUI.this.gLV();
            b.ahf(3);
          }
        }
      });
      localj.setHeaderView(localView);
      localj.setCustomView((View)localObject);
      localj.dDn();
      AppMethodBeat.o(288916);
      return;
      ((TextView)localObject).setText(a.i.bank_mobile_remit_dialog_title_mobile);
      b.ahf(1);
    }
  }
  
  private static void ahh(int paramInt)
  {
    AppMethodBeat.i(67672);
    rq localrq = new rq();
    localrq.ikE = paramInt;
    localrq.bMH();
    AppMethodBeat.o(67672);
  }
  
  public final void gLV()
  {
    AppMethodBeat.i(288943);
    Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "doNetSceneMobileRemitGetHomePage() ");
    if (this.pIx == null) {
      this.pIx = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getContext().getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(288870);
          if ((BankMobileRemittanceChooseUI.b(BankMobileRemittanceChooseUI.this) != null) && (BankMobileRemittanceChooseUI.b(BankMobileRemittanceChooseUI.this).isShowing())) {
            BankMobileRemittanceChooseUI.b(BankMobileRemittanceChooseUI.this).dismiss();
          }
          AppMethodBeat.o(288870);
        }
      });
    }
    com.tencent.mm.kernel.h.aZW().a(2952, this);
    d locald = new d(false);
    com.tencent.mm.kernel.h.aZW().a(locald, 0);
    AppMethodBeat.o(288943);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(67669);
    LinearLayout localLinearLayout = (LinearLayout)af.mU(getContext()).inflate(a.g.bank_mobile_remit_choose_ui_footer, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(a.f.bank_mobile_remit_footer_title_tv);
    String str = getString(a.i.bank_mobile_remit_choose_footer_title);
    com.tencent.mm.wallet_core.ui.i.a(localTextView, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288868);
        boolean bool = u.iiC().ijp().iiX();
        Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI, isNewSetting: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramAnonymousView = new etg();
          paramAnonymousView.type = 4;
          paramAnonymousView.url = "paySettingsUseCase";
          n.a(BankMobileRemittanceChooseUI.this.getContext(), paramAnonymousView, null);
        }
        for (;;)
        {
          BankMobileRemittanceChooseUI.gLW();
          AppMethodBeat.o(288868);
          return;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_enter_scene", 1);
          c.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", paramAnonymousView);
        }
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
    this.OfN = ((NormalIconNewTipPreference)this.screen.bAi("bank_mobile_remit_choose_bank"));
    this.OfO = ((NormalIconNewTipPreference)this.screen.bAi("bank_mobile_remit_choose_mobile"));
    this.OfN.adYG = true;
    this.OfN.setDesc(getString(a.i.bank_mobile_remit_choose_header_bank_desc));
    this.OfN.jnl();
    this.OfN.aBi(8);
    this.OfN.a(this.screen);
    a.gtf().h(this.OfN);
    this.OfO.adYG = true;
    this.OfO.setDesc(getString(a.i.bank_mobile_remit_choose_header_mobile_desc));
    this.OfO.jnl();
    this.OfO.aBi(8);
    this.OfO.a(this.screen);
    a.gtf().h(this.OfO);
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
    this.pIx = null;
    com.tencent.mm.kernel.h.aZW().b(2952, this);
    super.onDestroy();
    AppMethodBeat.o(67670);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67671);
    Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", new Object[] { paramPreference.mKey });
    if (Util.isEqual("bank_mobile_remit_choose_bank", paramPreference.mKey))
    {
      a.gtf().aeI(21);
      c.ai(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(67671);
      return true;
    }
    if (Util.isEqual("bank_mobile_remit_choose_mobile", paramPreference.mKey))
    {
      a.gtf().aeI(22);
      gLV();
      ahh(4);
      AppMethodBeat.o(67671);
      return true;
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
        AppMethodBeat.i(288869);
        BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this);
        AppMethodBeat.o(288869);
      }
    });
    AppMethodBeat.o(67668);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(288947);
    Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((this.pIx != null) && (this.pIx.isShowing()))
    {
      this.pIx.dismiss();
      this.pIx = null;
    }
    if ((paramp instanceof d))
    {
      com.tencent.mm.kernel.h.aZW().b(2952, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = ((d)paramp).gLM();
        paramp = new Intent();
        if (!Util.isNullOrNil(this.OfP))
        {
          paramp.putExtra("key_content", this.OfP);
          this.OfP = "";
        }
        Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "mResponse.is_new_user: %s", new Object[] { Boolean.valueOf(paramString.Vpn) });
        if ((!paramString.Vpn) || (paramString.abPD == null)) {
          break label303;
        }
        try
        {
          paramp.putExtra("key_compliance_item ", paramString.abPD.toByteArray());
          c.b(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI", paramp);
          AppMethodBeat.o(288947);
          return;
        }
        catch (IOException paramString)
        {
          Log.e("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", " mResponse printStackTrace: %s", new Object[] { paramString.toString() });
        }
      }
      k.a(getContext(), getContext().getString(a.i.wallet_unknown_err), "", getContext().getString(a.i.wallet_alert_btn_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288878);
          Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "click AlertDialog");
          AppMethodBeat.o(288878);
        }
      });
    }
    else
    {
      AppMethodBeat.o(288947);
      return;
    }
    label303:
    c.b(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI", paramp);
    AppMethodBeat.o(288947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI
 * JD-Core Version:    0.7.0.1
 */