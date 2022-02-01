package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.an.i
{
  private LinearLayout DKD;
  protected Orders Ivh;
  private String OyA;
  private Bankcard OyB;
  protected boolean OyC = false;
  private int OyD = 0;
  private String OyE;
  protected ArrayList<Preference> Oyv;
  protected TextView Oyw;
  private TextView Oyx;
  private TextView Oyy;
  private String Oyz;
  protected com.tencent.mm.ui.base.preference.f mrf;
  protected MMSwitchBtn mru;
  protected Button njb;
  private Dialog tipDialog = null;
  private String tpM;
  
  private void gHb()
  {
    AppMethodBeat.i(69378);
    s.gGL();
    Object localObject = s.gGM();
    if (this.OyB == null) {
      this.OyB = ((com.tencent.mm.plugin.wallet_core.model.ao)localObject).a(null, null, true, true, true);
    }
    if (this.OyB == null)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.OyB.field_desc);
    com.tencent.mm.plugin.wallet_core.ui.m localm = new com.tencent.mm.plugin.wallet_core.ui.m(getContext());
    localm.OYN = new m.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.OyG;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void abY(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.OyG.get(paramAnonymous2Int));
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
          com.tencent.mm.ui.base.h.a(paramAnonymousView, str, localLinkedList, k, local1);
          AppMethodBeat.o(69372);
          return;
          Log.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(localm, 0, ((SpannableString)localObject).length(), 18);
    this.Oyx.setText((CharSequence)localObject);
    this.Oyx.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void gHc()
  {
    AppMethodBeat.i(69380);
    if ((this.Oyv == null) || (this.Oyv.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.Oyv.size();
    int i = 0;
    while (i < j)
    {
      this.mrf.dz(((Preference)this.Oyv.get(i)).mKey, false);
      i += 1;
    }
    this.mrf.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void iM(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.Oyv == null)
    {
      int j = paramList.size();
      this.Oyv = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.h localh;
        if ((localObject != null) && (!Util.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localh = new com.tencent.mm.plugin.wallet_core.ui.h(this);
          localh.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).jDZ <= 0) {
            break label232;
          }
          localh.GJL = getResources().getColor(a.c.link_color);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69373);
              b localb = new b();
              localb.bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.OyI.jDZ) });
              if (this.OyI.jDZ == 1) {
                if (!Util.isNullOrNil(this.OyI.ORY))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.OyI.ORY);
                  paramAnonymousView.putExtra("showShare", false);
                  g.aJ(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                }
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69373);
                return;
                if (this.OyI.jDZ == 2)
                {
                  paramAnonymousView = new xw();
                  paramAnonymousView.fWN.userName = this.OyI.ORW;
                  paramAnonymousView.fWN.fWP = Util.nullAs(this.OyI.ORX, "");
                  paramAnonymousView.fWN.scene = 1097;
                  paramAnonymousView.fWN.fWQ = 0;
                  EventCenter.instance.publish(paramAnonymousView);
                }
              }
            }
          };
          localh.mContent = str;
          localh.mClickable = true;
          localh.kte = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localh.setKey("deduct_info_".concat(String.valueOf(i)));
          this.Oyv.add(localh);
          this.mrf.b(localh);
          this.mrf.dz(localh.mKey, true);
          i += 1;
          break;
          label232:
          localh.mContent = ((Orders.DeductShowInfo)localObject).value;
          localh.mClickable = false;
        }
      }
    }
    AppMethodBeat.o(69381);
  }
  
  protected final void BP(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.Ivh.ORi.ORT == 1)
      {
        this.DKD.setVisibility(0);
        gHc();
        if (!u.gJo().gJQ()) {
          break label122;
        }
        this.Oyw.setVisibility(8);
        this.njb.setText(a.i.wallet_deduct_pay_open_button_txt);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.mru.YbZ);
      AppMethodBeat.o(69379);
      return;
      this.DKD.setVisibility(8);
      break;
      label122:
      this.Oyw.setVisibility(0);
      this.Oyw.setText(a.i.wallet_deduct_pay_need_bind_card_txt);
      this.njb.setText(a.i.wallet_deduct_pay_bind_card_button_txt);
      continue;
      if ((this.Oyv != null) && (this.Oyv.size() > 0))
      {
        int j = this.Oyv.size();
        int i = 0;
        while (i < j)
        {
          this.mrf.dz(((Preference)this.Oyv.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.DKD.setVisibility(8);
      this.Oyw.setVisibility(8);
      this.njb.setText(a.i.wallet_deduct_pay_button_txt);
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
    this.Oyw = ((TextView)getContentView().findViewById(a.f.bindcard_tip_tv));
    this.njb = ((Button)getContentView().findViewById(a.f.next_btn));
    this.DKD = ((LinearLayout)findViewById(a.f.pay_way_ll));
    ((TextView)findViewById(a.f.deduct_title)).setText(this.Ivh.ORi.title);
    ((TextView)findViewById(a.f.title)).setText(((Orders.Commodity)this.Ivh.ORd.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(a.f.fee_type);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(g.bCn(this.Ivh.GHz));
    ((TextView)findViewById(a.f.fee)).setText(((Orders.Commodity)this.Ivh.ORd.get(0)).tVK);
    localObject1 = (TextView)findViewById(a.f.footer_tips);
    Object localObject2 = (TextView)findViewById(a.f.deduct_desc);
    boolean bool;
    if (!Util.isNullOrNil(this.Ivh.ORi.ORU))
    {
      ((TextView)localObject2).setText(this.Ivh.ORi.ORU);
      if (!Util.isNullOrNil(this.Ivh.ORi.ORV)) {
        ((TextView)localObject2).setTextColor(k.cW(this.Ivh.ORi.ORV, true));
      }
      this.Oyx = ((TextView)findViewById(a.f.default_bankCard_tv));
      this.Oyy = ((TextView)findViewById(a.f.bankCard_tip_tv));
      if (this.Ivh.ORi.Ozp != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.OyC = bool;
      this.OyD = this.Ivh.ORi.OyD;
      this.tpM = this.Ivh.ORi.tpM;
      this.OyE = this.Ivh.ORi.OyE;
      Log.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.OyC), Integer.valueOf(this.OyD) });
      if (this.OyD != 0) {
        break label777;
      }
      this.mru = ((MMSwitchBtn)findViewById(a.f.checkbox));
      this.mru.setCheck(this.OyC);
      this.mru.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.BP(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.Ivh != null)
          {
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localh.a(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.Ivh.fwv });
          }
          AppMethodBeat.o(69370);
        }
      });
      BP(this.OyC);
      label448:
      Log.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.Ivh.ORi.ORT) });
      if (this.Ivh.ORi.ORT != 1) {
        break label864;
      }
      com.tencent.mm.kernel.h.aHH();
      this.OyA = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlB, ""));
      com.tencent.mm.kernel.h.aHH();
      this.Oyz = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlA, ""));
      if ((!Util.isNullOrNil(this.Oyz)) && (!Util.isNullOrNil(this.Oyz))) {
        break label846;
      }
      Log.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), false, null);
      localObject2 = new com.tencent.mm.plugin.wallet.pwd.a.m();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject2, 0);
      label607:
      if (Util.isNullOrNil(this.Ivh.ORi.ORR)) {
        break label876;
      }
      Object localObject3 = getString(a.i.wallet_deduct_foot_tips_part1);
      localObject2 = getString(a.i.wallet_deduct_foot_tips_part2);
      localObject3 = l.c(this, getString(a.i.wallet_deduct_foot_tips, new Object[] { localObject3, localObject2 }));
      com.tencent.mm.plugin.wallet_core.ui.m localm = new com.tencent.mm.plugin.wallet_core.ui.m(getContext());
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(localm, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.njb.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!Util.isNullOrNil(this.tpM)) {
        this.njb.setText(this.tpM);
      }
      if (!Util.isNullOrNil(this.OyE))
      {
        this.Oyw.setText(this.OyE);
        this.Oyw.setVisibility(0);
      }
      findViewById(a.f.deduct_checkbox_layout).setVisibility(8);
      gHc();
      break label448;
      label846:
      this.Oyy.setText(this.OyA);
      gHb();
      break label607;
      label864:
      this.DKD.setVisibility(8);
      break label607;
      label876:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(69382);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i = paramView.getId();
    if (i == a.f.next_btn)
    {
      paramView = new Intent();
      if (this.OyD == 0) {
        if (this.mru.YbZ)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          label87:
          if (this.OyB != null)
          {
            paramView.putExtra("deduct_bank_type", this.OyB.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.OyB.field_bindSerial);
            Log.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.OyB.field_bankcardType });
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
      paramView.putExtra("auto_deduct_flag", this.Ivh.ORi.Ozp);
      break label87;
      if ((i == a.f.footer_tips) && (!Util.isNullOrNil(this.Ivh.ORi.ORR)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.Ivh.ORi.ORR);
        paramView.putExtra("showShare", false);
        g.aJ(getContext(), paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.mrf = getPreferenceScreen();
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
      if (!d.qV(23)) {
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
    this.Ivh = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.Ivh == null) || (this.Ivh.ORi == null))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.Ivh);
      finish();
    }
    iM(this.Ivh.ORi.ORS);
    setResult(0);
    setBackBtn(new ab()
    {
      public final void atf()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, a.h.actionbar_icon_dark_back);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69384);
    Log.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.h.aHH();
        this.OyA = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlB, getString(a.i.wallet_pay_deduct_change_pay_way_tip)));
        com.tencent.mm.kernel.h.aHH();
        this.Oyz = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlA, getString(a.i.wallet_pay_deduct_select_pay_way_label)));
        this.Oyy.setText(this.OyA);
        gHb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */