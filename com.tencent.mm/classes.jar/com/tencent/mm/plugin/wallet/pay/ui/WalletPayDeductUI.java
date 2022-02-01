package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.k.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.am.h
{
  private LinearLayout JBz;
  protected Orders OsJ;
  protected ArrayList<Preference> VnG;
  protected TextView VnH;
  private TextView VnI;
  private TextView VnJ;
  private String VnK;
  private String VnL;
  private Bankcard VnM;
  protected boolean VnN = false;
  private int VnO = 0;
  private String VnP;
  protected com.tencent.mm.ui.base.preference.f pkD;
  protected MMSwitchBtn pkU;
  protected Button qgp;
  private Dialog tipDialog = null;
  private String wul;
  
  private void igf()
  {
    AppMethodBeat.i(69378);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    Object localObject = com.tencent.mm.plugin.wallet.model.p.ifP();
    if (this.VnM == null) {
      this.VnM = ((am)localObject).a(null, null, true, true, true);
    }
    if (this.VnM == null)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.VnM.field_desc);
    com.tencent.mm.plugin.wallet_core.ui.n localn = new com.tencent.mm.plugin.wallet_core.ui.n(getContext());
    localn.VPb = new n.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.VnR;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        k.a local1 = new k.a()
        {
          public final void agm(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.VnR.get(paramAnonymous2Int));
            WalletPayDeductUI.c(WalletPayDeductUI.this);
            AppMethodBeat.o(69371);
          }
        };
        LinkedList localLinkedList = new LinkedList();
        if (((localObject == null) || (((List)localObject).size() == 0)) && (Util.isNullOrNil(null)))
        {
          Log.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
          AppMethodBeat.o(69372);
          return;
        }
        int i;
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          localObject = ((List)localObject).iterator();
          i = 0;
          for (int j = 0; ((Iterator)localObject).hasNext(); j = k)
          {
            Bankcard localBankcard2 = (Bankcard)((Iterator)localObject).next();
            localLinkedList.add(localBankcard2.field_desc);
            k = j;
            if (localBankcard1 != null)
            {
              k = j;
              if (localBankcard1.equals(localBankcard2)) {
                k = i;
              }
            }
            i += 1;
          }
          k = j;
          if (!Util.isNullOrNil(null))
          {
            localLinkedList.add(null);
            k = j;
            if (localBankcard1 != null) {}
          }
        }
        for (int k = i;; k = 0)
        {
          com.tencent.mm.ui.base.k.a(paramAnonymousView, str, localLinkedList, k, local1);
          AppMethodBeat.o(69372);
          return;
          Log.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(localn, 0, ((SpannableString)localObject).length(), 18);
    this.VnI.setText((CharSequence)localObject);
    this.VnI.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void igg()
  {
    AppMethodBeat.i(69380);
    if ((this.VnG == null) || (this.VnG.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.VnG.size();
    int i = 0;
    while (i < j)
    {
      this.pkD.eh(((Preference)this.VnG.get(i)).mKey, false);
      i += 1;
    }
    this.pkD.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void lU(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.VnG == null)
    {
      int j = paramList.size();
      this.VnG = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.i locali;
        if ((localObject != null) && (!Util.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          locali = new com.tencent.mm.plugin.wallet_core.ui.i(this);
          locali.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).mdV <= 0) {
            break label232;
          }
          locali.MGA = getResources().getColor(a.c.link_color);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(315506);
              Log.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.VnT.mdV) });
              if (this.VnT.mdV == 1)
              {
                if (!Util.isNullOrNil(this.VnT.VHT))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.VnT.VHT);
                  paramAnonymousView.putExtra("showShare", false);
                  com.tencent.mm.wallet_core.ui.i.aS(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                  AppMethodBeat.o(315506);
                }
              }
              else if (this.VnT.mdV == 2)
              {
                paramAnonymousView = new zp();
                paramAnonymousView.icM.userName = this.VnT.VHR;
                paramAnonymousView.icM.icO = Util.nullAs(this.VnT.VHS, "");
                paramAnonymousView.icM.scene = 1097;
                paramAnonymousView.icM.icP = 0;
                paramAnonymousView.publish();
              }
              AppMethodBeat.o(315506);
            }
          };
          locali.mContent = str;
          locali.mClickable = true;
          locali.mWW = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          locali.setKey("deduct_info_".concat(String.valueOf(i)));
          this.VnG.add(locali);
          this.pkD.c(locali);
          this.pkD.eh(locali.mKey, true);
          i += 1;
          break;
          label232:
          locali.mContent = ((Orders.DeductShowInfo)localObject).value;
          locali.mClickable = false;
        }
      }
    }
    AppMethodBeat.o(69381);
  }
  
  protected final void Hu(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.OsJ.VHc.VHO == 1)
      {
        this.JBz.setVisibility(0);
        igg();
        if (!u.iiC().ijf()) {
          break label122;
        }
        this.VnH.setVisibility(8);
        this.qgp.setText(a.i.wallet_deduct_pay_open_button_txt);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.pkU.afTT);
      AppMethodBeat.o(69379);
      return;
      this.JBz.setVisibility(8);
      break;
      label122:
      this.VnH.setVisibility(0);
      this.VnH.setText(a.i.wallet_deduct_pay_need_bind_card_txt);
      this.qgp.setText(a.i.wallet_deduct_pay_bind_card_button_txt);
      continue;
      if ((this.VnG != null) && (this.VnG.size() > 0))
      {
        int j = this.VnG.size();
        int i = 0;
        while (i < j)
        {
          this.pkD.eh(((Preference)this.VnG.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.JBz.setVisibility(8);
      this.VnH.setVisibility(8);
      this.qgp.setText(a.i.wallet_deduct_pay_button_txt);
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_pay_deduct_ui;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69377);
    this.VnH = ((TextView)getContentView().findViewById(a.f.bindcard_tip_tv));
    this.qgp = ((Button)getContentView().findViewById(a.f.next_btn));
    this.JBz = ((LinearLayout)findViewById(a.f.pay_way_ll));
    ((TextView)findViewById(a.f.deduct_title)).setText(this.OsJ.VHc.title);
    ((TextView)findViewById(a.f.title)).setText(((Orders.Commodity)this.OsJ.VGX.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(a.f.fee_type);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.i.bEL(this.OsJ.MEq));
    ((TextView)findViewById(a.f.fee)).setText(((Orders.Commodity)this.OsJ.VGX.get(0)).wZe);
    localObject1 = (TextView)findViewById(a.f.footer_tips);
    Object localObject2 = (TextView)findViewById(a.f.deduct_desc);
    boolean bool;
    if (!Util.isNullOrNil(this.OsJ.VHc.VHP))
    {
      ((TextView)localObject2).setText(this.OsJ.VHc.VHP);
      if (!Util.isNullOrNil(this.OsJ.VHc.VHQ)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(this.OsJ.VHc.VHQ, true));
      }
      this.VnI = ((TextView)findViewById(a.f.default_bankCard_tv));
      this.VnJ = ((TextView)findViewById(a.f.bankCard_tip_tv));
      if (this.OsJ.VHc.VoA != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.VnN = bool;
      this.VnO = this.OsJ.VHc.VnO;
      this.wul = this.OsJ.VHc.wul;
      this.VnP = this.OsJ.VHc.VnP;
      Log.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.VnN), Integer.valueOf(this.VnO) });
      if (this.VnO != 0) {
        break label777;
      }
      this.pkU = ((MMSwitchBtn)findViewById(a.f.checkbox));
      this.pkU.setCheck(this.VnN);
      this.pkU.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.Hu(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.OsJ != null)
          {
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localh.b(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.OsJ.hAT });
          }
          AppMethodBeat.o(69370);
        }
      });
      Hu(this.VnN);
      label448:
      Log.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.OsJ.VHc.VHO) });
      if (this.OsJ.VHc.VHO != 1) {
        break label864;
      }
      com.tencent.mm.kernel.h.baF();
      this.VnL = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMV, ""));
      com.tencent.mm.kernel.h.baF();
      this.VnK = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMU, ""));
      if ((!Util.isNullOrNil(this.VnK)) && (!Util.isNullOrNil(this.VnK))) {
        break label846;
      }
      Log.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.l.a(getContext(), false, null);
      localObject2 = new com.tencent.mm.plugin.wallet.pwd.a.l();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject2, 0);
      label607:
      if (Util.isNullOrNil(this.OsJ.VHc.VHM)) {
        break label876;
      }
      Object localObject3 = getString(a.i.wallet_deduct_foot_tips_part1);
      localObject2 = getString(a.i.wallet_deduct_foot_tips_part2);
      localObject3 = com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(a.i.wallet_deduct_foot_tips, new Object[] { localObject3, localObject2 }));
      com.tencent.mm.plugin.wallet_core.ui.n localn = new com.tencent.mm.plugin.wallet_core.ui.n(getContext());
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(localn, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.qgp.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!Util.isNullOrNil(this.wul)) {
        this.qgp.setText(this.wul);
      }
      if (!Util.isNullOrNil(this.VnP))
      {
        this.VnH.setText(this.VnP);
        this.VnH.setVisibility(0);
      }
      findViewById(a.f.deduct_checkbox_layout).setVisibility(8);
      igg();
      break label448;
      label846:
      this.VnJ.setText(this.VnL);
      igf();
      break label607;
      label864:
      this.JBz.setVisibility(8);
      break label607;
      label876:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(69382);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = paramView.getId();
    if (i == a.f.next_btn)
    {
      paramView = new Intent();
      if (this.VnO == 0) {
        if (this.pkU.afTT)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          label87:
          if (this.VnM != null)
          {
            paramView.putExtra("deduct_bank_type", this.VnM.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.VnM.field_bindSerial);
            Log.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.VnM.field_bankcardType });
          }
          setResult(-1, paramView);
          finish();
        }
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69382);
      return;
      i = 0;
      break;
      paramView.putExtra("auto_deduct_flag", this.OsJ.VHc.VoA);
      break label87;
      if ((i == a.f.footer_tips) && (!Util.isNullOrNil(this.OsJ.VHc.VHM)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.OsJ.VHc.VHM);
        paramView.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.i.aS(getContext(), paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.pkD = getPreferenceScreen();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(a.f.divider);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(a.c.transparent));
      }
      paramBundle = paramBundle.findViewById(16908309);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.white));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      if (!d.rb(23)) {
        break label188;
      }
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        break;
      }
      Log.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(69374);
      return;
      label188:
      getWindow().setStatusBarColor(getResources().getColor(a.c.BW_90));
    }
    this.OsJ = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.OsJ == null) || (this.OsJ.VHc == null))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.OsJ);
      finish();
    }
    lU(this.OsJ.VHc.VHN);
    setResult(0);
    setBackBtn(new ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(315504);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(315504);
      }
    }, a.h.actionbar_icon_dark_back);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    AppMethodBeat.o(69376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69383);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(69383);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69375);
    super.onResume();
    AppMethodBeat.o(69375);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69384);
    Log.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.l)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.h.baF();
        this.VnL = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMV, getString(a.i.wallet_pay_deduct_change_pay_way_tip)));
        com.tencent.mm.kernel.h.baF();
        this.VnK = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMU, getString(a.i.wallet_pay_deduct_select_pay_way_label)));
        this.VnJ.setText(this.VnL);
        igf();
      }
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(69384);
      return;
      Log.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */