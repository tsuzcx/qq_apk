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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private AdapterView.OnItemClickListener aos;
  private View.OnClickListener iAw;
  private ListView mListView;
  private u tuG;
  private c<kb> ujv;
  protected ArrayList<Bankcard> zNg;
  private ArrayList<Bankcard> zNh;
  protected am zNi;
  private ListView zNj;
  private a zNk;
  private a zNl;
  private TextView zNm;
  private View zNn;
  private View zNo;
  private View zNp;
  private CdnImageView zNq;
  private TextView zNr;
  private com.tencent.mm.plugin.wallet_core.model.n zNs;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.tuG = new u();
    this.zNg = new ArrayList();
    this.zNh = new ArrayList();
    this.zNi = null;
    this.mListView = null;
    this.zNj = null;
    this.zNk = null;
    this.zNl = null;
    this.iAw = new View.OnClickListener()
    {
      final int zNx = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69110);
        if (paramAnonymousView.getId() == 2131306733)
        {
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.g.ebF();
          if (paramAnonymousView.bcB())
          {
            com.tencent.mm.ui.base.h.c(WalletBankcardManageUI.this, paramAnonymousView.unt, WalletBankcardManageUI.this.getString(2131755906), true);
            AppMethodBeat.o(69110);
            return;
          }
          com.tencent.mm.wallet_core.ui.e.aby(19);
          WalletBankcardManageUI.this.dZN();
          com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(69110);
          return;
        }
        if (paramAnonymousView.getId() == 2131306738)
        {
          Object localObject = paramAnonymousView.getTag();
          long l = new Date().getTime();
          paramAnonymousView.setTag(Long.valueOf(l));
          if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
          {
            AppMethodBeat.o(69110);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra(e.m.FIC, true);
          paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
          com.tencent.mm.wallet_core.ui.e.X(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjq, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
          com.tencent.mm.wallet_core.ui.e.aby(6);
          AppMethodBeat.o(69110);
          return;
        }
        if (paramAnonymousView.getId() == 2131297115)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra(e.m.FIC, true);
          paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
          com.tencent.mm.wallet_core.ui.e.X(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(3) });
        }
        AppMethodBeat.o(69110);
      }
    };
    this.aos = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(69112);
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.aby(18);
        label55:
        label341:
        label600:
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          Object localObject;
          if ((paramAnonymousView.zMH == null) || (paramAnonymousView.zMH.isEmpty()))
          {
            break label251;
            if (!paramAnonymousAdapterView.ebu()) {
              break label383;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label354;
            }
            if ((b.b(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              com.tencent.mm.kernel.g.afC();
              paramAnonymousView = (String)com.tencent.mm.kernel.g.afB().afk().get(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label341;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(196659, ((StringBuilder)localObject).toString());
            }
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            paramAnonymousView.putString("key_bank_username", paramAnonymousAdapterView.field_bizUsername);
            paramAnonymousView.putString("key_bank_type", paramAnonymousAdapterView.field_bankcardType);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", paramAnonymousView, null);
          }
          label354:
          label627:
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
            AppMethodBeat.o(69112);
            return;
            localObject = paramAnonymousView.zMH.iterator();
            label251:
            if (!((Iterator)localObject).hasNext()) {
              break label55;
            }
            String str = (String)((Iterator)localObject).next();
            if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
            paramAnonymousView.zMH.remove(str);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqv, bt.n(paramAnonymousView.zMH, ","));
            break label55;
            ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
            break label141;
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", paramAnonymousView, null);
            continue;
            label383:
            if (paramAnonymousAdapterView.ebz())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
              d.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            }
            else
            {
              paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecN();
              if ((paramAnonymousView.Aid & 0x1000) > 0) {}
              for (boolean bool = true;; bool = false)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.Aid) });
                if (!bool) {
                  break label627;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                com.tencent.mm.kernel.g.afC();
                paramAnonymousView = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkI, "");
                com.tencent.mm.kernel.g.afC();
                paramAnonymousLong = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkJ, Long.valueOf(0L))).longValue();
                long l = System.currentTimeMillis() / 1000L;
                if ((bt.isNullOrNil(paramAnonymousView)) || (l - paramAnonymousLong >= 7200L)) {
                  break label600;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                WalletBankcardManageUI.this.c(paramAnonymousAdapterView);
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
              com.tencent.mm.sdk.b.a.ESL.c(new c() {});
              continue;
              WalletBankcardManageUI.this.d(paramAnonymousAdapterView);
            }
          }
        }
        label141:
        WalletBankcardManageUI.this.dZN();
        com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(69112);
      }
    };
    this.ujv = new c() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.model.n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(2131306749);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.Rv(paramn.field_red_dot_index))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(2131306739);
      if (paramn.field_is_overdue != 1) {
        break label105;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
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
      if (!bt.isNullOrNil(paramn.field_tips))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramn.field_tips);
      }
      else
      {
        if (bt.isNullOrNil(paramn.field_available_otb)) {
          break label201;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
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
  
  private void cE()
  {
    AppMethodBeat.i(69126);
    if (this.zNi.ecK())
    {
      this.zNm.setEnabled(false);
      if ((this.zNg == null) || (this.zNg.size() <= 0)) {
        break label191;
      }
      this.mListView.setVisibility(0);
      label48:
      if ((this.zNh == null) || (this.zNh.size() <= 0)) {
        break label203;
      }
      this.zNj.setVisibility(0);
      label73:
      if ((this.zNs == null) || (this.zNs.field_is_show_entry != 1)) {
        break label215;
      }
      ((TextView)this.zNo.findViewById(2131306740)).setText(this.zNs.field_title);
      a(this.zNs);
      this.zNo.setVisibility(0);
    }
    for (;;)
    {
      this.zNk.au(this.zNg);
      this.zNk.notifyDataSetChanged();
      this.zNl.au(this.zNh);
      this.zNl.notifyDataSetChanged();
      this.zNm.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.zNm.setEnabled(true);
      break;
      label191:
      this.mListView.setVisibility(8);
      break label48;
      label203:
      this.zNj.setVisibility(8);
      break label73;
      label215:
      this.zNo.setVisibility(8);
    }
  }
  
  private void dZL()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.g.afC();
    f localf = f.atM((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqM, ""));
    if ((localf != null) && (!bt.isNullOrNil(localf.AcF)))
    {
      if (!bt.isNullOrNil(localf.AcG)) {
        this.zNq.setUrl(localf.AcG);
      }
      this.zNr.setText(localf.AcF);
      if (localf.AcB == 1)
      {
        this.zNp.setOnClickListener(new WalletBankcardManageUI.8(this, localf));
        this.zNp.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.AcB == 2)
      {
        this.zNp.setOnClickListener(new WalletBankcardManageUI.9(this, localf));
        this.zNp.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.AcB) });
    }
    this.zNp.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  public final void c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkI, "");
    if (!bt.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        localIntent.putExtra(e.m.FIC, true);
        com.tencent.mm.wallet_core.ui.e.X(getContext(), localIntent);
        AppMethodBeat.o(69124);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
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
  
  protected a dZM()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.zNg);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void dZN()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.zNz.putInt("key_bind_scene", 15);
        this.zNz.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.fjk();
        if (com.tencent.mm.wallet_core.b.b(b.a.pre, false))
        {
          com.tencent.mm.sdk.b.a.ESL.b(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.zNz);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.zNz, null);
        AppMethodBeat.o(69113);
      }
    };
    ak localak = new ak();
    this.tuG.a(new u.a()
    {
      public final void cNA()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void cNB()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
      
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).ddw = false;
        AppMethodBeat.o(69099);
      }
    }, localak.ecD());
    AppMethodBeat.o(69128);
  }
  
  protected final void dZO()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.zNi.f(this.zNg, this.zNh);
    cE();
    dZL();
    AppMethodBeat.o(69129);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69131);
    if (!getIntent().getBooleanExtra("intent_finish_self", false))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
    super.finish();
    AppMethodBeat.o(69131);
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
        com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(69105);
        return true;
      }
    });
    this.zNm = ((TextView)findViewById(2131306650));
    this.zNm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69106);
        WalletBankcardManageUI.this.dZN();
        com.tencent.mm.wallet_core.ui.e.aby(19);
        com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(69106);
      }
    });
    this.mListView = ((ListView)findViewById(2131297164));
    this.zNk = dZM();
    this.mListView.setAdapter(this.zNk);
    this.mListView.setOnItemClickListener(this.aos);
    this.zNj = ((ListView)findViewById(2131306458));
    this.zNl = new a(this, this.zNh);
    this.zNj.setAdapter(this.zNl);
    this.zNj.setOnItemClickListener(this.aos);
    this.zNn = findViewById(2131306733);
    this.zNn.setOnClickListener(this.iAw);
    this.zNo = findViewById(2131306738);
    this.zNo.setOnClickListener(this.iAw);
    this.zNp = findViewById(2131306735);
    this.zNq = ((CdnImageView)findViewById(2131306737));
    this.zNr = ((TextView)findViewById(2131306734));
    dZL();
    findViewById(2131297115).setOnClickListener(this.iAw);
    final xd localxd = new xd();
    localxd.dCC.scene = "4";
    localxd.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!bt.isNullOrNil(localxd.dCD.dCE))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)WalletBankcardManageUI.this.findViewById(2131297186), localxd.dCD.dCE, localxd.dCD.content, localxd.dCD.url);
          AppMethodBeat.o(69107);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(localxd);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69104);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBankcardManageUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(69102);
            paramAnonymous2l.jj(0, 2131765059);
            AppMethodBeat.o(69102);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(69103);
            paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "operType：%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(69103);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra(e.m.FIC, true);
              paramAnonymous2MenuItem.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
              com.tencent.mm.wallet_core.ui.e.X(WalletBankcardManageUI.this.getContext(), paramAnonymous2MenuItem);
              com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(3) });
            }
          }
        };
        paramAnonymousMenuItem.csG();
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
        this.tuG.cNA();
        AppMethodBeat.o(69119);
        return;
      }
      this.tuG.cancel();
    }
    AppMethodBeat.o(69119);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69115);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    com.tencent.mm.plugin.wallet.a.s.dZT();
    this.zNi = com.tencent.mm.plugin.wallet.a.s.dZU();
    setMMTitle(2131765317);
    hideActionbarLine();
    initView();
    com.tencent.mm.wallet_core.c.ab.jZ(5, 0);
    com.tencent.mm.wallet_core.ui.e.aby(27);
    com.tencent.mm.plugin.report.service.h.vKh.f(14422, new Object[] { Integer.valueOf(5) });
    this.zNs = com.tencent.mm.plugin.wallet_core.model.s.ecc().Aik;
    this.tuG.Aro = new u.b()
    {
      public final int cNC()
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
    this.zNk.zMG.destory();
    this.zNl.zMG.destory();
    com.tencent.mm.sdk.b.a.ESL.d(this.ujv);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.tuG.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.zNi.ecK())
    {
      this.zNi.f(this.zNg, this.zNh);
      if (this.zNi.zHd != null) {
        setContentViewVisibility(0);
      }
      sq(false);
    }
    for (;;)
    {
      this.tuG.onResume();
      cE();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      sq(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69130);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
    {
      this.zNs = com.tencent.mm.plugin.wallet_core.model.s.ecc().Aik;
      dZO();
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
  
  protected void sq(boolean paramBoolean)
  {
    AppMethodBeat.i(69118);
    if (paramBoolean)
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12));
      AppMethodBeat.o(69118);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12), false);
    AppMethodBeat.o(69118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */