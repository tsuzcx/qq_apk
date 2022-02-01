package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private IListener<lj> AJa;
  protected ArrayList<Bankcard> HDi;
  private ArrayList<Bankcard> HDj;
  protected an HDk;
  private ListView HDl;
  private a HDm;
  private a HDn;
  private TextView HDo;
  private View HDp;
  private View HDq;
  private View HDr;
  private CdnImageView HDs;
  private TextView HDt;
  private n HDu;
  private AdapterView.OnItemClickListener ars;
  private View.OnClickListener kuO;
  private ListView mListView;
  private u zmb;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.zmb = new u();
    this.HDi = new ArrayList();
    this.HDj = new ArrayList();
    this.HDk = null;
    this.mListView = null;
    this.HDl = null;
    this.HDm = null;
    this.HDn = null;
    this.kuO = new WalletBankcardManageUI.10(this);
    this.ars = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(69112);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.f.aqm(18);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          if ((paramAnonymousView.HCI == null) || (paramAnonymousView.HCI.isEmpty()))
          {
            break label314;
            label106:
            if (!paramAnonymousAdapterView.fQa()) {
              break label447;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label417;
            }
            if ((b.c(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              g.aAi();
              paramAnonymousView = (String)g.aAh().azQ().get(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label404;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              label192:
              g.aAi();
              g.aAh().azQ().set(196659, ((StringBuilder)localObject).toString());
            }
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            paramAnonymousView.putString("key_bank_username", paramAnonymousAdapterView.field_bizUsername);
            paramAnonymousView.putString("key_bank_type", paramAnonymousAdapterView.field_bankcardType);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", paramAnonymousView, null);
            label258:
            h.CyF.a(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69112);
          return;
          localObject = paramAnonymousView.HCI.iterator();
          label314:
          if (!((Iterator)localObject).hasNext()) {
            break label106;
          }
          String str = (String)((Iterator)localObject).next();
          if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
            break;
          }
          Log.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
          paramAnonymousView.HCI.remove(str);
          g.aAi();
          g.aAh().azQ().set(ar.a.Odx, Util.listToString(paramAnonymousView.HCI, ","));
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
          if (paramAnonymousAdapterView.fQf())
          {
            Log.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
            c.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            break label258;
          }
          paramAnonymousView = t.fQI().fRs();
          if ((paramAnonymousView.IbF & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.IbF) });
            if (!bool) {
              break label699;
            }
            Log.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            g.aAi();
            paramAnonymousView = (String)g.aAh().azQ().get(ar.a.NXo, "");
            g.aAi();
            paramAnonymousLong = ((Long)g.aAh().azQ().get(ar.a.NXp, Long.valueOf(0L))).longValue();
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
          WalletBankcardManageUI.this.fOa();
          h.CyF.a(14422, new Object[] { Integer.valueOf(2) });
        }
      }
    };
    this.AJa = new IListener() {};
    AppMethodBeat.o(69114);
  }
  
  private void a(n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(2131310210);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.aeG(paramn.field_red_dot_index))
    {
      Log.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(2131310200);
      if (paramn.field_is_overdue != 1) {
        break label105;
      }
      Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
      localTextView.setText(2131767504);
      localTextView.setTextColor(getResources().getColor(2131100994));
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      AppMethodBeat.o(69127);
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label105:
      if (!Util.isNullOrNil(paramn.field_tips))
      {
        Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramn.field_tips);
      }
      else
      {
        if (Util.isNullOrNil(paramn.field_available_otb)) {
          break label201;
        }
        Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
        int i = paramn.field_available_otb.indexOf(".");
        localObject = paramn.field_available_otb;
        paramn = (n)localObject;
        if (i > 0) {
          paramn = ((String)localObject).substring(0, i);
        }
        localTextView.setText(getString(2131767503, new Object[] { paramn }));
      }
    }
    label201:
    localTextView.setVisibility(8);
    AppMethodBeat.o(69127);
  }
  
  private void fNY()
  {
    AppMethodBeat.i(69122);
    g.aAi();
    com.tencent.mm.plugin.wallet_core.model.f localf = com.tencent.mm.plugin.wallet_core.model.f.aVf((String)g.aAh().azQ().get(ar.a.OdO, ""));
    if ((localf != null) && (!Util.isNullOrNil(localf.HWm)))
    {
      if (!Util.isNullOrNil(localf.HWn)) {
        this.HDs.setUrl(localf.HWn);
      }
      this.HDt.setText(localf.HWm);
      com.tencent.mm.wallet_core.ui.f.G(this.HDt);
      if (localf.HWi == 1)
      {
        this.HDr.setOnClickListener(new WalletBankcardManageUI.8(this, localf));
        this.HDr.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.HWi == 2)
      {
        this.HDr.setOnClickListener(new WalletBankcardManageUI.9(this, localf));
        this.HDr.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      Log.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.HWi) });
    }
    this.HDr.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69126);
    if (this.HDk.fRp())
    {
      this.HDo.setEnabled(false);
      if ((this.HDi == null) || (this.HDi.size() <= 0)) {
        break label193;
      }
      this.mListView.setVisibility(0);
      label49:
      if ((this.HDj == null) || (this.HDj.size() <= 0)) {
        break label205;
      }
      this.HDl.setVisibility(0);
      label74:
      if ((this.HDu == null) || (this.HDu.field_is_show_entry != 1)) {
        break label217;
      }
      ((TextView)this.HDq.findViewById(2131310201)).setText(this.HDu.field_title);
      a(this.HDu);
      this.HDq.setVisibility(0);
    }
    for (;;)
    {
      this.HDm.aV(this.HDi);
      this.HDm.notifyDataSetChanged();
      this.HDn.aV(this.HDj);
      this.HDn.notifyDataSetChanged();
      this.HDo.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.HDo.setEnabled(true);
      break;
      label193:
      this.mListView.setVisibility(8);
      break label49;
      label205:
      this.HDl.setVisibility(8);
      break label74;
      label217:
      this.HDq.setVisibility(8);
    }
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void d(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NXo, "");
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
        localIntent.putExtra(e.p.OzJ, true);
        com.tencent.mm.wallet_core.ui.f.aA(getContext(), localIntent);
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
  
  protected a fNZ()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.HDi);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void fOa()
  {
    AppMethodBeat.i(69128);
    final Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69113);
        this.HDB.putInt("key_bind_scene", 15);
        this.HDB.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.rZU, true))
        {
          EventCenter.instance.add(WalletBankcardManageUI.c(WalletBankcardManageUI.this));
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.HDB);
          AppMethodBeat.o(69113);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.HDB, null);
        AppMethodBeat.o(69113);
      }
    };
    al localal = new al();
    this.zmb.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(69099);
        WalletBankcardManageUI.d(WalletBankcardManageUI.this).dEF = false;
        AppMethodBeat.o(69099);
      }
      
      public final void ehm()
      {
        AppMethodBeat.i(69098);
        local12.run();
        AppMethodBeat.o(69098);
      }
      
      public final void ehn()
      {
        AppMethodBeat.i(69100);
        local12.run();
        AppMethodBeat.o(69100);
      }
    }, localal.fRi());
    AppMethodBeat.o(69128);
  }
  
  protected final void fOb()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.HDk.g(this.HDi, this.HDj);
    updateView();
    fNY();
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
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true);
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
  
  public int getLayoutId()
  {
    return 2131496900;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69121);
    setBackBtn(new WalletBankcardManageUI.5(this));
    this.HDo = ((TextView)findViewById(2131310110));
    this.HDo.setOnClickListener(new WalletBankcardManageUI.6(this));
    this.mListView = ((ListView)findViewById(2131297308));
    this.HDm = fNZ();
    this.mListView.setAdapter(this.HDm);
    this.mListView.setOnItemClickListener(this.ars);
    this.HDl = ((ListView)findViewById(2131309902));
    this.HDn = new a(this, this.HDj);
    this.HDl.setAdapter(this.HDn);
    this.HDl.setOnItemClickListener(this.ars);
    this.HDp = findViewById(2131310195);
    this.HDp.setOnClickListener(this.kuO);
    this.HDq = findViewById(2131310199);
    this.HDq.setOnClickListener(this.kuO);
    this.HDr = findViewById(2131310197);
    this.HDs = ((CdnImageView)findViewById(2131310198));
    this.HDt = ((TextView)findViewById(2131310196));
    fNY();
    final zt localzt = new zt();
    localzt.efM.scene = "4";
    localzt.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69107);
        if (!Util.isNullOrNil(localzt.efN.efO))
        {
          com.tencent.mm.wallet_core.ui.f.a((TextView)WalletBankcardManageUI.this.findViewById(2131297330), localzt.efN.efO, localzt.efN.content, localzt.efN.url);
          AppMethodBeat.o(69107);
          return;
        }
        Log.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        AppMethodBeat.o(69107);
      }
    };
    EventCenter.instance.publish(localzt);
    addIconOptionMenu(0, 2131690843, new WalletBankcardManageUI.4(this));
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
        this.zmb.ehm();
        AppMethodBeat.o(69119);
        return;
      }
      this.zmb.cancel();
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
    s.fOg();
    this.HDk = s.fOh();
    setMMTitle(2131767760);
    hideActionbarLine();
    initView();
    ab.mg(5, 0);
    com.tencent.mm.wallet_core.ui.f.aqm(27);
    h.CyF.a(14422, new Object[] { Integer.valueOf(5) });
    this.HDu = t.fQI().IbN;
    this.zmb.IkQ = new u.b()
    {
      public final int eho()
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
    this.HDm.HCH.destory();
    this.HDn.HCH.destory();
    EventCenter.instance.removeListener(this.AJa);
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    this.zmb.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.HDk.fRp())
    {
      this.HDk.g(this.HDi, this.HDj);
      if (this.HDk.Hwc != null) {
        setContentViewVisibility(0);
      }
      xT(false);
    }
    for (;;)
    {
      this.zmb.onResume();
      updateView();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      xT(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69130);
    Log.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ad)))
    {
      this.HDu = t.fQI().IbN;
      fOb();
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
  
  protected void xT(boolean paramBoolean)
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