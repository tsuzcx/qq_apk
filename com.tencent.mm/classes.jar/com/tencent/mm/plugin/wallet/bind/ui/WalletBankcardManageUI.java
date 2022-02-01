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
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  protected ArrayList<Bankcard> BfA;
  private ArrayList<Bankcard> BfB;
  protected am BfC;
  private ListView BfD;
  private a BfE;
  private a BfF;
  private TextView BfG;
  private View BfH;
  private View BfI;
  private View BfJ;
  private CdnImageView BfK;
  private TextView BfL;
  private com.tencent.mm.plugin.wallet_core.model.n BfM;
  private AdapterView.OnItemClickListener apn;
  private View.OnClickListener jax;
  private ListView mListView;
  private u uCZ;
  private c<kj> vsr;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.uCZ = new u();
    this.BfA = new ArrayList();
    this.BfB = new ArrayList();
    this.BfC = null;
    this.mListView = null;
    this.BfD = null;
    this.BfE = null;
    this.BfF = null;
    this.jax = new View.OnClickListener()
    {
      final int BfR = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69110);
        if (paramAnonymousView.getId() == 2131306733)
        {
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.g.erb();
          if (paramAnonymousView.bjw())
          {
            com.tencent.mm.ui.base.h.c(WalletBankcardManageUI.this, paramAnonymousView.vwp, WalletBankcardManageUI.this.getString(2131755906), true);
            AppMethodBeat.o(69110);
            return;
          }
          com.tencent.mm.wallet_core.ui.e.adR(19);
          WalletBankcardManageUI.this.epj();
          com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(2) });
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
          paramAnonymousView.putExtra(e.m.HhK, true);
          paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
          com.tencent.mm.wallet_core.ui.e.al(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHf, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
          com.tencent.mm.wallet_core.ui.e.adR(6);
          AppMethodBeat.o(69110);
          return;
        }
        if (paramAnonymousView.getId() == 2131297115)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra(e.m.HhK, true);
          paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
          com.tencent.mm.wallet_core.ui.e.al(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(3) });
        }
        AppMethodBeat.o(69110);
      }
    };
    this.apn = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(69112);
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.adR(18);
        label55:
        label341:
        label600:
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          Object localObject;
          if ((paramAnonymousView.Bfb == null) || (paramAnonymousView.Bfb.isEmpty()))
          {
            break label251;
            if (!paramAnonymousAdapterView.eqQ()) {
              break label383;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label354;
            }
            if ((b.b(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              com.tencent.mm.kernel.g.agS();
              paramAnonymousView = (String)com.tencent.mm.kernel.g.agR().agA().get(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label341;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(196659, ((StringBuilder)localObject).toString());
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
            com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
            AppMethodBeat.o(69112);
            return;
            localObject = paramAnonymousView.Bfb.iterator();
            label251:
            if (!((Iterator)localObject).hasNext()) {
              break label55;
            }
            String str = (String)((Iterator)localObject).next();
            if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
              break;
            }
            ac.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
            paramAnonymousView.Bfb.remove(str);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOl, bs.n(paramAnonymousView.Bfb, ","));
            break label55;
            ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
            break label141;
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", paramAnonymousView, null);
            continue;
            label383:
            if (paramAnonymousAdapterView.eqV())
            {
              ac.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
              d.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            }
            else
            {
              paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.s.ery().esi();
              if ((paramAnonymousView.BAx & 0x1000) > 0) {}
              for (boolean bool = true;; bool = false)
              {
                ac.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.BAx) });
                if (!bool) {
                  break label627;
                }
                ac.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                com.tencent.mm.kernel.g.agS();
                paramAnonymousView = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIx, "");
                com.tencent.mm.kernel.g.agS();
                paramAnonymousLong = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIy, Long.valueOf(0L))).longValue();
                long l = System.currentTimeMillis() / 1000L;
                if ((bs.isNullOrNil(paramAnonymousView)) || (l - paramAnonymousLong >= 7200L)) {
                  break label600;
                }
                ac.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                WalletBankcardManageUI.this.c(paramAnonymousAdapterView);
                break;
              }
              ac.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
              com.tencent.mm.sdk.b.a.GpY.c(new c() {});
              continue;
              WalletBankcardManageUI.this.d(paramAnonymousAdapterView);
            }
          }
        }
        label141:
        WalletBankcardManageUI.this.epj();
        com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(69112);
      }
    };
    this.vsr = new c() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.model.n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(2131306749);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.TE(paramn.field_red_dot_index))
    {
      ac.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(2131306739);
      if (paramn.field_is_overdue != 1) {
        break label105;
      }
      ac.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
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
      if (!bs.isNullOrNil(paramn.field_tips))
      {
        ac.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramn.field_tips);
      }
      else
      {
        if (bs.isNullOrNil(paramn.field_available_otb)) {
          break label201;
        }
        ac.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
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
  
  private void cL()
  {
    AppMethodBeat.i(69126);
    if (this.BfC.esf())
    {
      this.BfG.setEnabled(false);
      if ((this.BfA == null) || (this.BfA.size() <= 0)) {
        break label191;
      }
      this.mListView.setVisibility(0);
      label48:
      if ((this.BfB == null) || (this.BfB.size() <= 0)) {
        break label203;
      }
      this.BfD.setVisibility(0);
      label73:
      if ((this.BfM == null) || (this.BfM.field_is_show_entry != 1)) {
        break label215;
      }
      ((TextView)this.BfI.findViewById(2131306740)).setText(this.BfM.field_title);
      a(this.BfM);
      this.BfI.setVisibility(0);
    }
    for (;;)
    {
      this.BfE.aG(this.BfA);
      this.BfE.notifyDataSetChanged();
      this.BfF.aG(this.BfB);
      this.BfF.notifyDataSetChanged();
      this.BfG.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.BfG.setEnabled(true);
      break;
      label191:
      this.mListView.setVisibility(8);
      break label48;
      label203:
      this.BfD.setVisibility(8);
      break label73;
      label215:
      this.BfI.setVisibility(8);
    }
  }
  
  private void eph()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.g.agS();
    f localf = f.aze((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOC, ""));
    if ((localf != null) && (!bs.isNullOrNil(localf.BuZ)))
    {
      if (!bs.isNullOrNil(localf.Bva)) {
        this.BfK.setUrl(localf.Bva);
      }
      this.BfL.setText(localf.BuZ);
      if (localf.BuV == 1)
      {
        this.BfJ.setOnClickListener(new WalletBankcardManageUI.8(this, localf));
        this.BfJ.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.BuV == 2)
      {
        this.BfJ.setOnClickListener(new WalletBankcardManageUI.9(this, localf));
        this.BfJ.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      ac.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.BuV) });
    }
    this.BfJ.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  public final void c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIx, "");
    if (!bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        localIntent.putExtra(e.m.HhK, true);
        com.tencent.mm.wallet_core.ui.e.al(getContext(), localIntent);
        AppMethodBeat.o(69124);
        return;
      }
    }
    ac.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
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
  
  protected a epi()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.BfA);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void epj()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.BfT.putInt("key_bind_scene", 15);
        this.BfT.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.fzz();
        if (com.tencent.mm.wallet_core.b.b(b.a.pUR, false))
        {
          com.tencent.mm.sdk.b.a.GpY.b(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.BfT);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.BfT, null);
        AppMethodBeat.o(69113);
      }
    };
    ak localak = new ak();
    this.uCZ.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).daU = false;
        AppMethodBeat.o(69099);
      }
      
      public final void dbh()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void dbi()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
    }, localak.erY());
    AppMethodBeat.o(69128);
  }
  
  protected final void epk()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.BfC.f(this.BfA, this.BfB);
    cL();
    eph();
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
        com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(69105);
        return true;
      }
    });
    this.BfG = ((TextView)findViewById(2131306650));
    this.BfG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69106);
        WalletBankcardManageUI.this.epj();
        com.tencent.mm.wallet_core.ui.e.adR(19);
        com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(69106);
      }
    });
    this.mListView = ((ListView)findViewById(2131297164));
    this.BfE = epi();
    this.mListView.setAdapter(this.BfE);
    this.mListView.setOnItemClickListener(this.apn);
    this.BfD = ((ListView)findViewById(2131306458));
    this.BfF = new a(this, this.BfB);
    this.BfD.setAdapter(this.BfF);
    this.BfD.setOnItemClickListener(this.apn);
    this.BfH = findViewById(2131306733);
    this.BfH.setOnClickListener(this.jax);
    this.BfI = findViewById(2131306738);
    this.BfI.setOnClickListener(this.jax);
    this.BfJ = findViewById(2131306735);
    this.BfK = ((CdnImageView)findViewById(2131306737));
    this.BfL = ((TextView)findViewById(2131306734));
    eph();
    findViewById(2131297115).setOnClickListener(this.jax);
    final xo localxo = new xo();
    localxo.dAo.scene = "4";
    localxo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!bs.isNullOrNil(localxo.dAp.dAq))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)WalletBankcardManageUI.this.findViewById(2131297186), localxo.dAp.dAq, localxo.dAp.content, localxo.dAp.url);
          AppMethodBeat.o(69107);
          return;
        }
        ac.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(localxo);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69104);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBankcardManageUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(69102);
            paramAnonymous2l.jw(0, 2131765059);
            AppMethodBeat.o(69102);
          }
        };
        paramAnonymousMenuItem.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(69103);
            paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
            ac.i("MicroMsg.WalletBankcardManageUI", "operType：%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(69103);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra(e.m.HhK, true);
              paramAnonymous2MenuItem.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
              com.tencent.mm.wallet_core.ui.e.al(WalletBankcardManageUI.this.getContext(), paramAnonymous2MenuItem);
              com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(3) });
            }
          }
        };
        paramAnonymousMenuItem.cED();
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
        this.uCZ.dbh();
        AppMethodBeat.o(69119);
        return;
      }
      this.uCZ.cancel();
    }
    AppMethodBeat.o(69119);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69115);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    ac.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    com.tencent.mm.plugin.wallet.a.s.epp();
    this.BfC = com.tencent.mm.plugin.wallet.a.s.epq();
    setMMTitle(2131765317);
    hideActionbarLine();
    initView();
    ab.km(5, 0);
    com.tencent.mm.wallet_core.ui.e.adR(27);
    com.tencent.mm.plugin.report.service.h.wUl.f(14422, new Object[] { Integer.valueOf(5) });
    this.BfM = com.tencent.mm.plugin.wallet_core.model.s.ery().BAF;
    this.uCZ.BJI = new u.b()
    {
      public final int dbj()
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
    this.BfE.Bfa.destory();
    this.BfF.Bfa.destory();
    com.tencent.mm.sdk.b.a.GpY.d(this.vsr);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.uCZ.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.BfC.esf())
    {
      this.BfC.f(this.BfA, this.BfB);
      if (this.BfC.AZp != null) {
        setContentViewVisibility(0);
      }
      tr(false);
    }
    for (;;)
    {
      this.uCZ.onResume();
      cL();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      tr(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69130);
    ac.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof ad)))
    {
      this.BfM = com.tencent.mm.plugin.wallet_core.model.s.ery().BAF;
      epk();
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
  
  protected void tr(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */