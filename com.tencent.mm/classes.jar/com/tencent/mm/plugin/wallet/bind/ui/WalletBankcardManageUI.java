package com.tencent.mm.plugin.wallet.bind.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.an;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private IListener<ng> Myr;
  private TextView VkA;
  private n VkB;
  protected ArrayList<Bankcard> Vkp;
  private ArrayList<Bankcard> Vkq;
  protected am Vkr;
  private ListView Vks;
  private a Vkt;
  private a Vku;
  private TextView Vkv;
  private View Vkw;
  private View Vkx;
  private View Vky;
  private CdnImageView Vkz;
  private ListView mListView;
  private WcPayBannerView pLM;
  private View.OnClickListener qjL;
  private AdapterView.OnItemClickListener un;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(69114);
    this.Vkp = new ArrayList();
    this.Vkq = new ArrayList();
    this.Vkr = null;
    this.mListView = null;
    this.Vks = null;
    this.Vkt = null;
    this.Vku = null;
    this.qjL = new View.OnClickListener()
    {
      final int VkE = 1000;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69108);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (paramAnonymousView.getId() == a.f.wallet_entrance_add_bankcard)
        {
          paramAnonymousView = g.iif();
          if (paramAnonymousView.cvt())
          {
            k.c(WalletBankcardManageUI.this, paramAnonymousView.MDu, WalletBankcardManageUI.this.getString(a.i.app_tip), true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69108);
            return;
          }
          i.aGA(19);
          WalletBankcardManageUI.this.ifI();
          com.tencent.mm.plugin.report.service.h.OAn.b(14422, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69108);
          return;
          if (paramAnonymousView.getId() == a.f.wallet_entrance_loan)
          {
            localObject = paramAnonymousView.getTag();
            long l = new Date().getTime();
            paramAnonymousView.setTag(Long.valueOf(l));
            if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69108);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra(f.s.adxf, true);
            paramAnonymousView.putExtra("rawUrl", WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_loan_jump_url);
            i.aS(WalletBankcardManageUI.this.getContext(), paramAnonymousView);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acLq, Integer.valueOf(WalletBankcardManageUI.a(WalletBankcardManageUI.this).field_red_dot_index));
            i.aGA(6);
          }
        }
      }
    };
    this.un = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(315563);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        i.aGA(18);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = WalletBankcardManageUI.b(WalletBankcardManageUI.this);
          if ((paramAnonymousView.VjP == null) || (paramAnonymousView.VjP.isEmpty()))
          {
            break label314;
            label106:
            if (!paramAnonymousAdapterView.ihU()) {
              break label447;
            }
            if (paramAnonymousAdapterView.field_wxcreditState != 0) {
              break label417;
            }
            if ((b.d(paramAnonymousAdapterView)) && (paramAnonymousAdapterView != null))
            {
              com.tencent.mm.kernel.h.baF();
              paramAnonymousView = (String)com.tencent.mm.kernel.h.baE().ban().d(196659, null);
              localObject = new StringBuilder();
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label404;
              }
              ((StringBuilder)localObject).append(paramAnonymousView);
              ((StringBuilder)localObject).append("&");
              ((StringBuilder)localObject).append(paramAnonymousAdapterView.field_bankcardType);
              label192:
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(196659, ((StringBuilder)localObject).toString());
            }
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("key_bankcard", paramAnonymousAdapterView);
            paramAnonymousView.putString("key_bank_username", paramAnonymousAdapterView.field_bizUsername);
            paramAnonymousView.putString("key_bank_type", paramAnonymousAdapterView.field_bankcardType);
            com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", paramAnonymousView, null);
            label258:
            com.tencent.mm.plugin.report.service.h.OAn.b(14422, new Object[] { Integer.valueOf(1), paramAnonymousAdapterView.field_bankcardType });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(315563);
          return;
          localObject = paramAnonymousView.VjP.iterator();
          label314:
          if (!((Iterator)localObject).hasNext()) {
            break label106;
          }
          String str = (String)((Iterator)localObject).next();
          if (!str.equals(paramAnonymousAdapterView.field_bindSerial)) {
            break;
          }
          Log.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[] { str });
          paramAnonymousView.VjP.remove(str);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acTm, Util.listToString(paramAnonymousView.VjP, ","));
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
          if (paramAnonymousAdapterView.ihZ())
          {
            Log.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_no", paramAnonymousAdapterView.field_bindSerial);
            com.tencent.mm.br.c.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", paramAnonymousView);
            break label258;
          }
          paramAnonymousView = u.iiC().ijp();
          if ((paramAnonymousView.VJX & 0x1000) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousView.VJX) });
            if (!bool) {
              break label698;
            }
            Log.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
            com.tencent.mm.kernel.h.baF();
            paramAnonymousView = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMI, "");
            com.tencent.mm.kernel.h.baF();
            paramAnonymousLong = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMJ, Long.valueOf(0L))).longValue();
            long l = System.currentTimeMillis() / 1000L;
            if ((Util.isNullOrNil(paramAnonymousView)) || (l - paramAnonymousLong >= 7200L)) {
              break label671;
            }
            Log.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
            WalletBankcardManageUI.this.e(paramAnonymousAdapterView);
            break;
          }
          label671:
          Log.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
          new IListener(com.tencent.mm.app.f.hfK) {}.alive();
          break label258;
          label698:
          WalletBankcardManageUI.this.f(paramAnonymousAdapterView);
          break label258;
          WalletBankcardManageUI.this.ifI();
          com.tencent.mm.plugin.report.service.h.OAn.b(14422, new Object[] { Integer.valueOf(2) });
        }
      }
    };
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(69114);
  }
  
  private void a(n paramn)
  {
    AppMethodBeat.i(69127);
    Object localObject = (TextView)findViewById(a.f.wallet_load_red_point);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.asc(paramn.field_red_dot_index))
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
          break label209;
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
    label209:
    localTextView.setVisibility(8);
    AppMethodBeat.o(69127);
  }
  
  private void ifG()
  {
    AppMethodBeat.i(69122);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.plugin.wallet_core.model.f localf = com.tencent.mm.plugin.wallet_core.model.f.bgv((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTD, ""));
    if ((localf != null) && (!Util.isNullOrNil(localf.VEg)))
    {
      if (!Util.isNullOrNil(localf.VEh)) {
        this.Vkz.setUrl(localf.VEh);
      }
      this.VkA.setText(localf.VEg);
      i.Q(this.VkA);
      if (localf.VEc == 1)
      {
        this.Vky.setOnClickListener(new WalletBankcardManageUI.3(this, localf));
        this.Vky.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      if (localf.VEc == 2)
      {
        this.Vky.setOnClickListener(new WalletBankcardManageUI.4(this, localf));
        this.Vky.setVisibility(0);
        AppMethodBeat.o(69122);
        return;
      }
      Log.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.VEc) });
    }
    this.Vky.setVisibility(8);
    AppMethodBeat.o(69122);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69126);
    if (this.Vkr.ijl())
    {
      this.Vkv.setEnabled(false);
      if ((this.Vkp == null) || (this.Vkp.size() <= 0)) {
        break label201;
      }
      this.mListView.setVisibility(0);
      label49:
      if ((this.Vkq == null) || (this.Vkq.size() <= 0)) {
        break label213;
      }
      this.Vks.setVisibility(0);
      label74:
      if ((this.VkB == null) || (this.VkB.field_is_show_entry != 1)) {
        break label225;
      }
      ((TextView)this.Vkx.findViewById(a.f.wallet_entrance_loan_text)).setText(this.VkB.field_title);
      a(this.VkB);
      this.Vkx.setVisibility(0);
    }
    for (;;)
    {
      this.Vkt.bK(this.Vkp);
      this.Vkt.notifyDataSetChanged();
      this.Vku.bK(this.Vkq);
      this.Vku.notifyDataSetChanged();
      this.Vkv.setEnabled(true);
      AppMethodBeat.o(69126);
      return;
      this.Vkr.ijh();
      this.Vkv.setEnabled(true);
      break;
      label201:
      this.mListView.setVisibility(8);
      break label49;
      label213:
      this.Vks.setVisibility(8);
      break label74;
      label225:
      this.Vkx.setVisibility(8);
    }
  }
  
  protected void Hs(boolean paramBoolean)
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
  
  public final void e(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69124);
    com.tencent.mm.kernel.h.baF();
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMI, "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("disable_bounce_scroll", true);
        localIntent.putExtra(f.s.adxf, true);
        localIntent.putExtra("pay_report_scene", 1);
        i.aS(getContext(), localIntent);
        AppMethodBeat.o(69124);
        return;
      }
    }
    Log.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
    AppMethodBeat.o(69124);
  }
  
  protected void f(Bankcard paramBankcard)
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
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true);
      Log.i("MicroMsg.WalletBankcardManageUI", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label100;
      }
      com.tencent.mm.br.c.b(this, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      super.finish();
      AppMethodBeat.o(69131);
      return;
      label100:
      com.tencent.mm.br.c.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bankcard_manage_ui;
  }
  
  protected a ifH()
  {
    AppMethodBeat.i(69123);
    a locala = new a(this, this.Vkp);
    AppMethodBeat.o(69123);
    return locala;
  }
  
  protected void ifI()
  {
    AppMethodBeat.i(69128);
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315556);
        this.VkG.putInt("key_bind_scene", 15);
        this.VkG.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.b.jNX();
        if (com.tencent.mm.wallet_core.b.b(c.a.yWP, true))
        {
          WalletBankcardManageUI.c(WalletBankcardManageUI.this).alive();
          WalletBankcardManageUI.a(WalletBankcardManageUI.this, this.VkG);
          AppMethodBeat.o(315556);
          return;
        }
        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, this.VkG, null);
        AppMethodBeat.o(315556);
      }
    }.run();
    AppMethodBeat.o(69128);
  }
  
  protected final void ifJ()
  {
    AppMethodBeat.i(69129);
    setContentViewVisibility(0);
    this.Vkr.l(this.Vkp, this.Vkq);
    updateView();
    ifG();
    AppMethodBeat.o(69129);
  }
  
  public void initView()
  {
    AppMethodBeat.i(69121);
    setBackBtn(new WalletBankcardManageUI.1(this));
    this.Vkv = ((TextView)findViewById(a.f.wallet_add_bankcard_for_empty));
    this.Vkv.setOnClickListener(new WalletBankcardManageUI.2(this));
    this.mListView = ((ListView)findViewById(a.f.bankcard_list));
    this.Vkt = ifH();
    this.mListView.setAdapter(this.Vkt);
    this.mListView.setOnItemClickListener(this.un);
    this.Vks = ((ListView)findViewById(a.f.virtual_bankcard_list));
    this.Vku = new a(this, this.Vkq);
    this.Vks.setAdapter(this.Vku);
    this.Vks.setOnItemClickListener(this.un);
    this.Vkw = findViewById(a.f.wallet_entrance_add_bankcard);
    this.Vkw.setOnClickListener(this.qjL);
    this.Vkx = findViewById(a.f.wallet_entrance_loan);
    this.Vkx.setOnClickListener(this.qjL);
    this.Vky = findViewById(a.f.wallet_entrance_apply_credit);
    this.Vkz = ((CdnImageView)findViewById(a.f.wallet_entrance_apply_credit_icon_iv));
    this.VkA = ((TextView)findViewById(a.f.wallet_entrance_applay_credit_text_tv));
    ifG();
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    acx localacx = new acx();
    localacx.igk.scene = "4";
    localacx.callback = new WalletBankcardManageUI..ExternalSyntheticLambda0(this, localacx);
    localacx.publish();
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(315557);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(WalletBankcardManageUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(315565);
            paramAnonymous2s.oh(0, a.i.wallet_bankcard_manager_ui_help_text);
            AppMethodBeat.o(315565);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(315566);
            paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
            Log.i("MicroMsg.WalletBankcardManageUI", "operType：%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(315566);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra(f.s.adxf, true);
              paramAnonymous2MenuItem.putExtra("rawUrl", "https://payapp.weixin.qq.com/kfweb/helpcenter/dispatch?scene_code=CommIssueBankCard");
              i.aS(WalletBankcardManageUI.this.getContext(), paramAnonymous2MenuItem);
              com.tencent.mm.plugin.report.service.h.OAn.b(14422, new Object[] { Integer.valueOf(3) });
            }
          }
        };
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(315557);
        return false;
      }
    });
    AppMethodBeat.o(69121);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69119);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(69119);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69115);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    Log.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    com.tencent.mm.plugin.wallet.model.p.ifO();
    this.Vkr = com.tencent.mm.plugin.wallet.model.p.ifP();
    setMMTitle(a.i.wallet_index_ui_title);
    hideActionbarLine();
    initView();
    ac.pu(5, 0);
    i.aGA(27);
    com.tencent.mm.plugin.report.service.h.OAn.b(14422, new Object[] { Integer.valueOf(5) });
    this.VkB = u.iiC().VKf;
    AppMethodBeat.o(69115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69120);
    super.onDestroy();
    this.Vkt.VjO.destory();
    this.Vku.VjO.destory();
    this.Myr.dead();
    AppMethodBeat.o(69120);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69117);
    super.onPause();
    AppMethodBeat.o(69117);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69116);
    if (!this.Vkr.ijl())
    {
      this.Vkr.l(this.Vkp, this.Vkq);
      if (this.Vkr.VcF != null) {
        setContentViewVisibility(0);
      }
      Hs(false);
    }
    for (;;)
    {
      updateView();
      super.onResume();
      AppMethodBeat.o(69116);
      return;
      Hs(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69130);
    Log.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof ae)))
    {
      this.VkB = u.iiC().VKf;
      ifJ();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315589);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.a.class);
    AppMethodBeat.o(315589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */