package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Date;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  protected ArrayList<Bankcard> CFO;
  private ArrayList<Bankcard> CFP;
  protected an CFQ;
  private ListView CFR;
  private a CFS;
  private a CFT;
  private TextView CFU;
  private View CFV;
  private View CFW;
  private View CFX;
  private CdnImageView CFY;
  private TextView CFZ;
  private com.tencent.mm.plugin.wallet_core.model.n CGa;
  private AdapterView.OnItemClickListener arf;
  private View.OnClickListener jtG;
  private ListView mListView;
  private u vFR;
  private c<ks> wxJ;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.vFR = new u();
    this.CFO = new ArrayList();
    this.CFP = new ArrayList();
    this.CFQ = null;
    this.mListView = null;
    this.CFR = null;
    this.CFS = null;
    this.CFT = null;
    this.jtG = new View.OnClickListener()
    {
      final int CGf = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69110);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (paramAnonymousView.getId() == 2131306733)
        {
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.g.eFb();
          if (paramAnonymousView.bni())
          {
            h.c(WalletBankcardManageUI.this, paramAnonymousView.wBJ, WalletBankcardManageUI.this.getString(2131755906), true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69110);
            return;
          }
          com.tencent.mm.wallet_core.ui.e.agr(19);
          WalletBankcardManageUI.this.eDj();
          com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(2) });
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
            paramAnonymousView.putExtra(e.m.IVa, true);
            paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
            com.tencent.mm.wallet_core.ui.e.an(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Itx, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
            com.tencent.mm.wallet_core.ui.e.agr(6);
          }
          else if (paramAnonymousView.getId() == 2131297115)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra(e.m.IVa, true);
            paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
            com.tencent.mm.wallet_core.ui.e.an(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(3) });
          }
        }
      }
    };
    this.arf = new WalletBankcardManageUI.11(this);
    this.wxJ = new c() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.model.n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(2131306749);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.Vw(paramn.field_red_dot_index))
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
  
  private void eDh()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.g.ajD();
    final f localf = f.aEm((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAX, ""));
    if ((localf != null) && (!bt.isNullOrNil(localf.CVo)))
    {
      if (!bt.isNullOrNil(localf.CVp)) {
        this.CFY.setUrl(localf.CVp);
      }
      this.CFZ.setText(localf.CVo);
      if (localf.CVk == 1)
      {
        this.CFX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69108);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (!bt.isNullOrNil(localf.CVl))
            {
              com.tencent.mm.wallet_core.ui.e.n(WalletBankcardManageUI.this.getContext(), localf.CVl, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(6) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69108);
          }
        });
        this.CFX.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.CVk == 2)
      {
        this.CFX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69109);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new vm();
            paramAnonymousView.dJF.userName = localf.CVm;
            paramAnonymousView.dJF.dJH = bt.bI(localf.CVn, "");
            paramAnonymousView.dJF.scene = 1071;
            paramAnonymousView.dJF.dJI = 0;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69109);
          }
        });
        this.CFX.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.CVk) });
    }
    this.CFX.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69126);
    if (this.CFQ.eGf())
    {
      this.CFU.setEnabled(false);
      if ((this.CFO == null) || (this.CFO.size() <= 0)) {
        break label193;
      }
      this.mListView.setVisibility(0);
      label49:
      if ((this.CFP == null) || (this.CFP.size() <= 0)) {
        break label205;
      }
      this.CFR.setVisibility(0);
      label74:
      if ((this.CGa == null) || (this.CGa.field_is_show_entry != 1)) {
        break label217;
      }
      ((TextView)this.CFW.findViewById(2131306740)).setText(this.CGa.field_title);
      a(this.CGa);
      this.CFW.setVisibility(0);
    }
    for (;;)
    {
      this.CFS.aC(this.CFO);
      this.CFS.notifyDataSetChanged();
      this.CFT.aC(this.CFP);
      this.CFT.notifyDataSetChanged();
      this.CFU.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.CFU.setEnabled(true);
      break;
      label193:
      this.mListView.setVisibility(8);
      break label49;
      label205:
      this.CFR.setVisibility(8);
      break label74;
      label217:
      this.CFW.setVisibility(8);
    }
  }
  
  public final void c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.g.ajD();
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuP, "");
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
        localIntent.putExtra(e.m.IVa, true);
        com.tencent.mm.wallet_core.ui.e.an(getContext(), localIntent);
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
  
  protected a eDi()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.CFO);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void eDj()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.CGh.putInt("key_bind_scene", 15);
        this.CGh.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.fQJ();
        if (com.tencent.mm.wallet_core.b.b(b.a.qzx, false))
        {
          com.tencent.mm.sdk.b.a.IbL.b(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.CGh);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.CGh, null);
        AppMethodBeat.o(69113);
      }
    };
    al localal = new al();
    this.vFR.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).dmo = false;
        AppMethodBeat.o(69099);
      }
      
      public final void dkA()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void dkB()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
    }, localal.eFY());
    AppMethodBeat.o(69128);
  }
  
  protected final void eDk()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.CFQ.f(this.CFO, this.CFP);
    updateView();
    eDh();
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
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
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
        com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(69105);
        return true;
      }
    });
    this.CFU = ((TextView)findViewById(2131306650));
    this.CFU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69106);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletBankcardManageUI.this.eDj();
        com.tencent.mm.wallet_core.ui.e.agr(19);
        com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69106);
      }
    });
    this.mListView = ((ListView)findViewById(2131297164));
    this.CFS = eDi();
    this.mListView.setAdapter(this.CFS);
    this.mListView.setOnItemClickListener(this.arf);
    this.CFR = ((ListView)findViewById(2131306458));
    this.CFT = new a(this, this.CFP);
    this.CFR.setAdapter(this.CFT);
    this.CFR.setOnItemClickListener(this.arf);
    this.CFV = findViewById(2131306733);
    this.CFV.setOnClickListener(this.jtG);
    this.CFW = findViewById(2131306738);
    this.CFW.setOnClickListener(this.jtG);
    this.CFX = findViewById(2131306735);
    this.CFY = ((CdnImageView)findViewById(2131306737));
    this.CFZ = ((TextView)findViewById(2131306734));
    eDh();
    findViewById(2131297115).setOnClickListener(this.jtG);
    final yi localyi = new yi();
    localyi.dMB.scene = "4";
    localyi.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!bt.isNullOrNil(localyi.dMC.dMD))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)WalletBankcardManageUI.this.findViewById(2131297186), localyi.dMC.dMD, localyi.dMC.content, localyi.dMC.url);
          AppMethodBeat.o(69107);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localyi);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69104);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBankcardManageUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(69102);
            paramAnonymous2l.jI(0, 2131765059);
            AppMethodBeat.o(69102);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
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
              paramAnonymous2MenuItem.putExtra(e.m.IVa, true);
              paramAnonymous2MenuItem.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
              com.tencent.mm.wallet_core.ui.e.an(WalletBankcardManageUI.this.getContext(), paramAnonymous2MenuItem);
              com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(3) });
            }
          }
        };
        paramAnonymousMenuItem.cMW();
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
        this.vFR.dkA();
        AppMethodBeat.o(69119);
        return;
      }
      this.vFR.cancel();
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
    s.eDp();
    this.CFQ = s.eDq();
    setMMTitle(2131765317);
    hideActionbarLine();
    initView();
    ab.kB(5, 0);
    com.tencent.mm.wallet_core.ui.e.agr(27);
    com.tencent.mm.plugin.report.service.g.yhR.f(14422, new Object[] { Integer.valueOf(5) });
    this.CGa = t.eFy().DaX;
    this.vFR.Dka = new u.b()
    {
      public final int dkC()
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
    this.CFS.CFp.destory();
    this.CFT.CFp.destory();
    com.tencent.mm.sdk.b.a.IbL.d(this.wxJ);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.vFR.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.CFQ.eGf())
    {
      this.CFQ.f(this.CFO, this.CFP);
      if (this.CFQ.CzB != null) {
        setContentViewVisibility(0);
      }
      ub(false);
    }
    for (;;)
    {
      this.vFR.onResume();
      updateView();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      ub(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69130);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
    {
      this.CGa = t.eFy().DaX;
      eDk();
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
  
  protected void ub(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */