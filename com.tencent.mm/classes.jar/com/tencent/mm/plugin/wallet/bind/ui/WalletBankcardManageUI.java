package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.ak;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.v;
import com.tencent.mm.plugin.wallet_core.ui.v.a;
import com.tencent.mm.plugin.wallet_core.ui.v.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private v ERr;
  private IListener<ma> GCj;
  protected ArrayList<Bankcard> Ovb;
  private ArrayList<Bankcard> Ovc;
  protected com.tencent.mm.plugin.wallet_core.model.ao Ovd;
  private ListView Ove;
  private a Ovf;
  private a Ovg;
  private TextView Ovh;
  private View Ovi;
  private View Ovj;
  private View Ovk;
  private CdnImageView Ovl;
  private TextView Ovm;
  private n Ovn;
  private ListView mListView;
  private View.OnClickListener nmC;
  private AdapterView.OnItemClickListener tp;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.ERr = new v();
    this.Ovb = new ArrayList();
    this.Ovc = new ArrayList();
    this.Ovd = null;
    this.mListView = null;
    this.Ove = null;
    this.Ovf = null;
    this.Ovg = null;
    this.nmC = new View.OnClickListener()
    {
      final int Ovs = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69110);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (paramAnonymousView.getId() == a.f.wallet_entrance_add_bankcard)
        {
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.g.gIR();
          if (paramAnonymousView.bVd())
          {
            com.tencent.mm.ui.base.h.c(WalletBankcardManageUI.this, paramAnonymousView.GGD, WalletBankcardManageUI.this.getString(a.i.app_tip), true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69110);
            return;
          }
          com.tencent.mm.wallet_core.ui.g.azK(19);
          WalletBankcardManageUI.this.gGF();
          com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69110);
          return;
          if (paramAnonymousView.getId() == a.f.wallet_entrance_loan)
          {
            localObject = paramAnonymousView.getTag();
            long l = new Date().getTime();
            paramAnonymousView.setTag(Long.valueOf(l));
            if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69110);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra(f.r.VSX, true);
            paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
            com.tencent.mm.wallet_core.ui.g.aJ(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjW, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
            com.tencent.mm.wallet_core.ui.g.azK(6);
          }
        }
      }
    };
    this.tp = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(69112);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.g.azK(18);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          if ((paramAnonymousView.OuB == null) || (paramAnonymousView.OuB.isEmpty()))
          {
            break label314;
            label106:
            if (!paramAnonymousAdapterView.gIG()) {
              break label447;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label417;
            }
            if ((b.c(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              com.tencent.mm.kernel.h.aHH();
              paramAnonymousView = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label404;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              label192:
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(196659, ((StringBuilder)localObject).toString());
            }
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            paramAnonymousView.putString("key_bank_username", paramAnonymousAdapterView.field_bizUsername);
            paramAnonymousView.putString("key_bank_type", paramAnonymousAdapterView.field_bankcardType);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", paramAnonymousView, null);
            label258:
            com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69112);
          return;
          localObject = paramAnonymousView.OuB.iterator();
          label314:
          if (!((Iterator)localObject).hasNext()) {
            break label106;
          }
          String str = (String)((Iterator)localObject).next();
          if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
            break;
          }
          Log.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
          paramAnonymousView.OuB.remove(str);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrI, Util.listToString(paramAnonymousView.OuB, ","));
          break label106;
          label404:
          ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
          break label192;
          label417:
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
          com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", paramAnonymousView, null);
          break label258;
          label447:
          if (paramAnonymousAdapterView.gIL())
          {
            Log.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
            c.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            break label258;
          }
          paramAnonymousView = u.gJo().gJY();
          if ((paramAnonymousView.OTR & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.OTR) });
            if (!bool) {
              break label699;
            }
            Log.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            com.tencent.mm.kernel.h.aHH();
            paramAnonymousView = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlo, "");
            com.tencent.mm.kernel.h.aHH();
            paramAnonymousLong = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlp, Long.valueOf(0L))).longValue();
            long l = System.currentTimeMillis() / 1000L;
            if ((Util.isNullOrNil(paramAnonymousView)) || (l - paramAnonymousLong >= 7200L)) {
              break label671;
            }
            Log.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
            WalletBankcardManageUI.this.d(paramAnonymousAdapterView);
            break;
          }
          label671:
          Log.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
          EventCenter.instance.addListener(new IListener() {});
          break label258;
          label699:
          WalletBankcardManageUI.this.e(paramAnonymousAdapterView);
          break label258;
          WalletBankcardManageUI.this.gGF();
          com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(2) });
        }
      }
    };
    this.GCj = new IListener() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(a.f.wallet_load_red_point);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.amt(paramn.field_red_dot_index))
    {
      Log.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(a.f.wallet_entrance_loan_credits_tip);
      if (paramn.field_is_overdue != 1) {
        break label109;
      }
      Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
      localTextView.setText(a.i.wallet_bankcard_manager_ui_loan_overdue);
      localTextView.setTextColor(getResources().getColor(a.c.red));
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      AppMethodBeat.o(69127);
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label109:
      if (!Util.isNullOrNil(paramn.field_tips))
      {
        Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramn.field_tips);
      }
      else
      {
        if (Util.isNullOrNil(paramn.field_available_otb)) {
          break label206;
        }
        Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
        int i = paramn.field_available_otb.indexOf(".");
        localObject = paramn.field_available_otb;
        paramn = (n)localObject;
        if (i > 0) {
          paramn = ((String)localObject).substring(0, i);
        }
        localTextView.setText(getString(a.i.wallet_bankcard_manager_ui_loan_available_otb, new Object[] { paramn }));
      }
    }
    label206:
    localTextView.setVisibility(8);
    AppMethodBeat.o(69127);
  }
  
  private void gGD()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.plugin.wallet_core.model.f localf = com.tencent.mm.plugin.wallet_core.model.f.bgO((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrZ, ""));
    if ((localf != null) && (!Util.isNullOrNil(localf.OOm)))
    {
      if (!Util.isNullOrNil(localf.OOn)) {
        this.Ovl.setUrl(localf.OOn);
      }
      this.Ovm.setText(localf.OOm);
      com.tencent.mm.wallet_core.ui.g.N(this.Ovm);
      if (localf.OOi == 1)
      {
        this.Ovk.setOnClickListener(new WalletBankcardManageUI.8(this, localf));
        this.Ovk.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.OOi == 2)
      {
        this.Ovk.setOnClickListener(new WalletBankcardManageUI.9(this, localf));
        this.Ovk.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      Log.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.OOi) });
    }
    this.Ovk.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69126);
    if (this.Ovd.gJV())
    {
      this.Ovh.setEnabled(false);
      if ((this.Ovb == null) || (this.Ovb.size() <= 0)) {
        break label201;
      }
      this.mListView.setVisibility(0);
      label49:
      if ((this.Ovc == null) || (this.Ovc.size() <= 0)) {
        break label213;
      }
      this.Ove.setVisibility(0);
      label74:
      if ((this.Ovn == null) || (this.Ovn.field_is_show_entry != 1)) {
        break label225;
      }
      ((TextView)this.Ovj.findViewById(a.f.wallet_entrance_loan_text)).setText(this.Ovn.field_title);
      a(this.Ovn);
      this.Ovj.setVisibility(0);
    }
    for (;;)
    {
      this.Ovf.bj(this.Ovb);
      this.Ovf.notifyDataSetChanged();
      this.Ovg.bj(this.Ovc);
      this.Ovg.notifyDataSetChanged();
      this.Ovh.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.Ovd.gJS();
      this.Ovh.setEnabled(true);
      break;
      label201:
      this.mListView.setVisibility(8);
      break label49;
      label213:
      this.Ove.setVisibility(8);
      break label74;
      label225:
      this.Ovj.setVisibility(8);
    }
  }
  
  protected void BN(boolean paramBoolean)
  {
    AppMethodBeat.i(69118);
    if (paramBoolean)
    {
      doSceneForceProgress(new ae(null, 12));
      AppMethodBeat.o(69118);
      return;
    }
    doSceneProgress(new ae(null, 12), false);
    AppMethodBeat.o(69118);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void d(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlo, "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        localIntent.putExtra(f.r.VSX, true);
        com.tencent.mm.wallet_core.ui.g.aJ(getContext(), localIntent);
        AppMethodBeat.o(69124);
        return;
      }
    }
    Log.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
    AppMethodBeat.o(69124);
  }
  
  protected void e(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69125);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localBundle, null);
    AppMethodBeat.o(69125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69131);
    Intent localIntent;
    if (!getIntent().getBooleanExtra("intent_finish_self", false))
    {
      localIntent = new Intent();
      localIntent.addFlags(67108864);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true);
      Log.i("MicroMsg.WalletBankcardManageUI", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label100;
      }
      c.b(this, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      super.finish();
      AppMethodBeat.o(69131);
      return;
      label100:
      c.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  protected a gGE()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.Ovb);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void gGF()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.Ovu.putInt("key_bind_scene", 15);
        this.Ovu.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.iie();
        if (com.tencent.mm.wallet_core.b.b(b.a.vGW, true))
        {
          EventCenter.instance.add(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.Ovu);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.Ovu, null);
        AppMethodBeat.o(69113);
      }
    };
    am localam = new am();
    this.ERr.a(new v.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).fxt = false;
        AppMethodBeat.o(69099);
      }
      
      public final void eQT()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void eQU()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
    }, localam.gJO());
    AppMethodBeat.o(69128);
  }
  
  protected final void gGG()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.Ovd.i(this.Ovb, this.Ovc);
    updateView();
    gGD();
    AppMethodBeat.o(69129);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bankcard_manage_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69121);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69105);
        WalletBankcardManageUI.this.finish();
        com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(69105);
        return true;
      }
    });
    this.Ovh = ((TextView)findViewById(a.f.wallet_add_bankcard_for_empty));
    this.Ovh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69106);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletBankcardManageUI.this.gGF();
        com.tencent.mm.wallet_core.ui.g.azK(19);
        com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69106);
      }
    });
    this.mListView = ((ListView)findViewById(a.f.bankcard_list));
    this.Ovf = gGE();
    this.mListView.setAdapter(this.Ovf);
    this.mListView.setOnItemClickListener(this.tp);
    this.Ove = ((ListView)findViewById(a.f.virtual_bankcard_list));
    this.Ovg = new a(this, this.Ovc);
    this.Ove.setAdapter(this.Ovg);
    this.Ove.setOnItemClickListener(this.tp);
    this.Ovi = findViewById(a.f.wallet_entrance_add_bankcard);
    this.Ovi.setOnClickListener(this.nmC);
    this.Ovj = findViewById(a.f.wallet_entrance_loan);
    this.Ovj.setOnClickListener(this.nmC);
    this.Ovk = findViewById(a.f.wallet_entrance_apply_credit);
    this.Ovl = ((CdnImageView)findViewById(a.f.wallet_entrance_apply_credit_icon_iv));
    this.Ovm = ((TextView)findViewById(a.f.wallet_entrance_applay_credit_text_tv));
    gGD();
    final aba localaba = new aba();
    localaba.gac.scene = "4";
    localaba.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!Util.isNullOrNil(localaba.gad.gae))
        {
          com.tencent.mm.wallet_core.ui.g.a((TextView)WalletBankcardManageUI.this.findViewById(a.f.banner_tips), localaba.gad.gae, localaba.gad.content, localaba.gad.url);
          AppMethodBeat.o(69107);
          return;
        }
        Log.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    EventCenter.instance.publish(localaba);
    addIconOptionMenu(0, a.h.icons_outlined_more, new WalletBankcardManageUI.4(this));
    AppMethodBeat.o(69121);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69119);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.ERr.eQT();
        AppMethodBeat.o(69119);
        return;
      }
      this.ERr.cancel();
    }
    AppMethodBeat.o(69119);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69115);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    Log.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    s.gGL();
    this.Ovd = s.gGM();
    setMMTitle(a.i.wallet_index_ui_title);
    hideActionbarLine();
    initView();
    ab.ny(5, 0);
    com.tencent.mm.wallet_core.ui.g.azK(27);
    com.tencent.mm.plugin.report.service.h.IzE.a(14422, new Object[] { Integer.valueOf(5) });
    this.Ovn = u.gJo().OTZ;
    this.ERr.Pdi = new v.b()
    {
      public final int eQV()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBankcardManageUI.this;
      }
    };
    AppMethodBeat.o(69115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69120);
    super.onDestroy();
    this.Ovf.OuA.destory();
    this.Ovg.OuA.destory();
    EventCenter.instance.removeListener(this.GCj);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.ERr.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.Ovd.gJV())
    {
      this.Ovd.i(this.Ovb, this.Ovc);
      if (this.Ovd.OnP != null) {
        setContentViewVisibility(0);
      }
      BN(false);
    }
    for (;;)
    {
      this.ERr.onResume();
      updateView();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      BN(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69130);
    Log.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ae)))
    {
      this.Ovn = u.gJo().OTZ;
      gGG();
      AppMethodBeat.o(69130);
      return true;
    }
    AppMethodBeat.o(69130);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */