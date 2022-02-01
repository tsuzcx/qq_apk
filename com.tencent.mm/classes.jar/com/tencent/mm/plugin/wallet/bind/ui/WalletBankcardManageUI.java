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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private TextView CXA;
  private View CXB;
  private View CXC;
  private View CXD;
  private CdnImageView CXE;
  private TextView CXF;
  private com.tencent.mm.plugin.wallet_core.model.n CXG;
  protected ArrayList<Bankcard> CXu;
  private ArrayList<Bankcard> CXv;
  protected an CXw;
  private ListView CXx;
  private a CXy;
  private a CXz;
  private AdapterView.OnItemClickListener arf;
  private View.OnClickListener jwB;
  private ListView mListView;
  private u vRV;
  private c<kt> wNu;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.vRV = new u();
    this.CXu = new ArrayList();
    this.CXv = new ArrayList();
    this.CXw = null;
    this.mListView = null;
    this.CXx = null;
    this.CXy = null;
    this.CXz = null;
    this.jwB = new View.OnClickListener()
    {
      final int CXL = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69110);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (paramAnonymousView.getId() == 2131306733)
        {
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.g.eII();
          if (paramAnonymousView.bnS())
          {
            h.c(WalletBankcardManageUI.this, paramAnonymousView.wRu, WalletBankcardManageUI.this.getString(2131755906), true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69110);
            return;
          }
          com.tencent.mm.wallet_core.ui.f.aha(19);
          WalletBankcardManageUI.this.eGQ();
          com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69110);
          return;
          if (paramAnonymousView.getId() == 2131306738)
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
            paramAnonymousView.putExtra(e.m.JpI, true);
            paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
            com.tencent.mm.wallet_core.ui.f.an(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INU, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
            com.tencent.mm.wallet_core.ui.f.aha(6);
          }
          else if (paramAnonymousView.getId() == 2131297115)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra(e.m.JpI, true);
            paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
            com.tencent.mm.wallet_core.ui.f.an(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(3) });
          }
        }
      }
    };
    this.arf = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(69112);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.f.aha(18);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          if ((paramAnonymousView.CWW == null) || (paramAnonymousView.CWW.isEmpty()))
          {
            break label314;
            label106:
            if (!paramAnonymousAdapterView.eIx()) {
              break label447;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label417;
            }
            if ((b.b(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              com.tencent.mm.kernel.g.ajS();
              paramAnonymousView = (String)com.tencent.mm.kernel.g.ajR().ajA().get(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label404;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              label192:
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(196659, ((StringBuilder)localObject).toString());
            }
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            paramAnonymousView.putString("key_bank_username", paramAnonymousAdapterView.field_bizUsername);
            paramAnonymousView.putString("key_bank_type", paramAnonymousAdapterView.field_bankcardType);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", paramAnonymousView, null);
            label258:
            com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69112);
          return;
          localObject = paramAnonymousView.CWW.iterator();
          label314:
          if (!((Iterator)localObject).hasNext()) {
            break label106;
          }
          String str = (String)((Iterator)localObject).next();
          if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
            break;
          }
          ae.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
          paramAnonymousView.CWW.remove(str);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVf, bu.m(paramAnonymousView.CWW, ","));
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
          if (paramAnonymousAdapterView.eIC())
          {
            ae.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
            d.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            break label258;
          }
          paramAnonymousView = t.eJf().eJP();
          if ((paramAnonymousView.Dst & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            ae.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.Dst) });
            if (!bool) {
              break label699;
            }
            ae.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            com.tencent.mm.kernel.g.ajS();
            paramAnonymousView = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPn, "");
            com.tencent.mm.kernel.g.ajS();
            paramAnonymousLong = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPo, Long.valueOf(0L))).longValue();
            long l = System.currentTimeMillis() / 1000L;
            if ((bu.isNullOrNil(paramAnonymousView)) || (l - paramAnonymousLong >= 7200L)) {
              break label671;
            }
            ae.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
            WalletBankcardManageUI.this.c(paramAnonymousAdapterView);
            break;
          }
          label671:
          ae.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
          com.tencent.mm.sdk.b.a.IvT.c(new c() {});
          break label258;
          label699:
          WalletBankcardManageUI.this.d(paramAnonymousAdapterView);
          break label258;
          WalletBankcardManageUI.this.eGQ();
          com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(2) });
        }
      }
    };
    this.wNu = new c() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.model.n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(2131306749);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.Wd(paramn.field_red_dot_index))
    {
      ae.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(2131306739);
      if (paramn.field_is_overdue != 1) {
        break label105;
      }
      ae.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
      localTextView.setText(2131765061);
      localTextView.setTextColor(getResources().getColor(2131100798));
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      AppMethodBeat.o(69127);
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label105:
      if (!bu.isNullOrNil(paramn.field_tips))
      {
        ae.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramn.field_tips);
      }
      else
      {
        if (bu.isNullOrNil(paramn.field_available_otb)) {
          break label201;
        }
        ae.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
        int i = paramn.field_available_otb.indexOf(".");
        localObject = paramn.field_available_otb;
        paramn = (com.tencent.mm.plugin.wallet_core.model.n)localObject;
        if (i > 0) {
          paramn = ((String)localObject).substring(0, i);
        }
        localTextView.setText(getString(2131765060, new Object[] { paramn }));
      }
    }
    label201:
    localTextView.setVisibility(8);
    AppMethodBeat.o(69127);
  }
  
  private void eGO()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.g.ajS();
    final com.tencent.mm.plugin.wallet_core.model.f localf = com.tencent.mm.plugin.wallet_core.model.f.aFG((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVw, ""));
    if ((localf != null) && (!bu.isNullOrNil(localf.DmU)))
    {
      if (!bu.isNullOrNil(localf.DmV)) {
        this.CXE.setUrl(localf.DmV);
      }
      this.CXF.setText(localf.DmU);
      if (localf.DmQ == 1)
      {
        this.CXD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69108);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (!bu.isNullOrNil(localf.DmR))
            {
              com.tencent.mm.wallet_core.ui.f.o(WalletBankcardManageUI.this.getContext(), localf.DmR, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(6) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69108);
          }
        });
        this.CXD.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.DmQ == 2)
      {
        this.CXD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69109);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new vq();
            paramAnonymousView.dKT.userName = localf.DmS;
            paramAnonymousView.dKT.dKV = bu.bI(localf.DmT, "");
            paramAnonymousView.dKT.scene = 1071;
            paramAnonymousView.dKT.dKW = 0;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69109);
          }
        });
        this.CXD.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      ae.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.DmQ) });
    }
    this.CXD.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69126);
    if (this.CXw.eJM())
    {
      this.CXA.setEnabled(false);
      if ((this.CXu == null) || (this.CXu.size() <= 0)) {
        break label193;
      }
      this.mListView.setVisibility(0);
      label49:
      if ((this.CXv == null) || (this.CXv.size() <= 0)) {
        break label205;
      }
      this.CXx.setVisibility(0);
      label74:
      if ((this.CXG == null) || (this.CXG.field_is_show_entry != 1)) {
        break label217;
      }
      ((TextView)this.CXC.findViewById(2131306740)).setText(this.CXG.field_title);
      a(this.CXG);
      this.CXC.setVisibility(0);
    }
    for (;;)
    {
      this.CXy.aD(this.CXu);
      this.CXy.notifyDataSetChanged();
      this.CXz.aD(this.CXv);
      this.CXz.notifyDataSetChanged();
      this.CXA.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.CXA.setEnabled(true);
      break;
      label193:
      this.mListView.setVisibility(8);
      break label49;
      label205:
      this.CXx.setVisibility(8);
      break label74;
      label217:
      this.CXC.setVisibility(8);
    }
  }
  
  public final void c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.g.ajS();
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPn, "");
    if (!bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        localIntent.putExtra(e.m.JpI, true);
        com.tencent.mm.wallet_core.ui.f.an(getContext(), localIntent);
        AppMethodBeat.o(69124);
        return;
      }
    }
    ae.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
    AppMethodBeat.o(69124);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected void d(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69125);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localBundle, null);
    AppMethodBeat.o(69125);
  }
  
  protected a eGP()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.CXu);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void eGQ()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.CXN.putInt("key_bind_scene", 15);
        this.CXN.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.fVf();
        if (com.tencent.mm.wallet_core.b.b(b.a.qGD, false))
        {
          com.tencent.mm.sdk.b.a.IvT.b(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.CXN);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.CXN, null);
        AppMethodBeat.o(69113);
      }
    };
    al localal = new al();
    this.vRV.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).dnq = false;
        AppMethodBeat.o(69099);
      }
      
      public final void dnA()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void dnB()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
    }, localal.eJF());
    AppMethodBeat.o(69128);
  }
  
  protected final void eGR()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.CXw.f(this.CXu, this.CXv);
    updateView();
    eGO();
    AppMethodBeat.o(69129);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69131);
    Intent localIntent;
    if (!getIntent().getBooleanExtra("intent_finish_self", false))
    {
      localIntent = new Intent();
      localIntent.addFlags(67108864);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGM, false);
      ae.i("MicroMsg.WalletBankcardManageUI", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label100;
      }
      d.b(this, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      super.finish();
      AppMethodBeat.o(69131);
      return;
      label100:
      d.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495920;
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
        com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(69105);
        return true;
      }
    });
    this.CXA = ((TextView)findViewById(2131306650));
    this.CXA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69106);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletBankcardManageUI.this.eGQ();
        com.tencent.mm.wallet_core.ui.f.aha(19);
        com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69106);
      }
    });
    this.mListView = ((ListView)findViewById(2131297164));
    this.CXy = eGP();
    this.mListView.setAdapter(this.CXy);
    this.mListView.setOnItemClickListener(this.arf);
    this.CXx = ((ListView)findViewById(2131306458));
    this.CXz = new a(this, this.CXv);
    this.CXx.setAdapter(this.CXz);
    this.CXx.setOnItemClickListener(this.arf);
    this.CXB = findViewById(2131306733);
    this.CXB.setOnClickListener(this.jwB);
    this.CXC = findViewById(2131306738);
    this.CXC.setOnClickListener(this.jwB);
    this.CXD = findViewById(2131306735);
    this.CXE = ((CdnImageView)findViewById(2131306737));
    this.CXF = ((TextView)findViewById(2131306734));
    eGO();
    findViewById(2131297115).setOnClickListener(this.jwB);
    final yo localyo = new yo();
    localyo.dNR.scene = "4";
    localyo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!bu.isNullOrNil(localyo.dNS.dNT))
        {
          com.tencent.mm.wallet_core.ui.f.a((TextView)WalletBankcardManageUI.this.findViewById(2131297186), localyo.dNS.dNT, localyo.dNS.content, localyo.dNS.url);
          AppMethodBeat.o(69107);
          return;
        }
        ae.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localyo);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69104);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBankcardManageUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(69102);
            paramAnonymous2l.jM(0, 2131765059);
            AppMethodBeat.o(69102);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(69103);
            paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
            ae.i("MicroMsg.WalletBankcardManageUI", "operType：%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(69103);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra(e.m.JpI, true);
              paramAnonymous2MenuItem.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
              com.tencent.mm.wallet_core.ui.f.an(WalletBankcardManageUI.this.getContext(), paramAnonymous2MenuItem);
              com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(3) });
            }
          }
        };
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(69104);
        return false;
      }
    });
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
        this.vRV.dnA();
        AppMethodBeat.o(69119);
        return;
      }
      this.vRV.cancel();
    }
    AppMethodBeat.o(69119);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69115);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    ae.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    s.eGW();
    this.CXw = s.eGX();
    setMMTitle(2131765317);
    hideActionbarLine();
    initView();
    ab.kI(5, 0);
    com.tencent.mm.wallet_core.ui.f.aha(27);
    com.tencent.mm.plugin.report.service.g.yxI.f(14422, new Object[] { Integer.valueOf(5) });
    this.CXG = t.eJf().DsB;
    this.vRV.DBE = new u.b()
    {
      public final int dnC()
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
    this.CXy.CWV.destory();
    this.CXz.CWV.destory();
    com.tencent.mm.sdk.b.a.IvT.d(this.wNu);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.vRV.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.CXw.eJM())
    {
      this.CXw.f(this.CXu, this.CXv);
      if (this.CXw.CRg != null) {
        setContentViewVisibility(0);
      }
      ui(false);
    }
    for (;;)
    {
      this.vRV.onResume();
      updateView();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      ui(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69130);
    ae.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof ad)))
    {
      this.CXG = t.eJf().DsB;
      eGR();
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
  
  protected void ui(boolean paramBoolean)
  {
    AppMethodBeat.i(69118);
    if (paramBoolean)
    {
      doSceneForceProgress(new ad(null, 12));
      AppMethodBeat.o(69118);
      return;
    }
    doSceneProgress(new ad(null, 12), false);
    AppMethodBeat.o(69118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */