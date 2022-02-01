package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int ohD;
  private ViewGroup BaA;
  private TextView BaB;
  private ViewGroup BaC;
  private TextView BaD;
  private TextView BaE;
  private ViewGroup BaF;
  private TextView BaG;
  private WalletTextView BaH;
  private Button BaI;
  private Button BaJ;
  private LinearLayout BaK;
  private LinearLayout BaL;
  private TextView BaM;
  private TextView BaN;
  private View BaO;
  private TextView BaP;
  private RelativeLayout BaQ;
  private View BaR;
  private View BaS;
  private CdnImageView BaT;
  private TextView BaU;
  private TextView BaV;
  private LinearLayout BaW;
  private TextView BaX;
  private TextView BaY;
  private TextView BaZ;
  private t Bax;
  private u Bay;
  private cju Baz;
  private TextView Bba;
  private WcPayMoneyLoadingView Bbb;
  private boolean Bbc;
  private boolean Bbd;
  private boolean Bbe;
  private ao handler;
  private Dialog iBT;
  private ProgressBar uDg;
  
  static
  {
    AppMethodBeat.i(68832);
    ohD = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.Bax = ((t)aq(t.class));
    this.Bay = ((u)am(u.class));
    this.Bbc = true;
    this.handler = new ao(Looper.getMainLooper());
    this.Bbd = false;
    this.Bbe = false;
    AppMethodBeat.o(68814);
  }
  
  private void Tp(final int paramInt)
  {
    AppMethodBeat.i(68819);
    ac.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.Bay == null)
    {
      AppMethodBeat.o(68819);
      return;
    }
    this.Bay.AXp.aOa().f(new com.tencent.mm.vending.c.a()
    {
      private Void a(cju paramAnonymouscju)
      {
        AppMethodBeat.i(68798);
        if (paramAnonymouscju != null)
        {
          ac.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymouscju.ErG), Boolean.valueOf(paramAnonymouscju.FxN) });
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymouscju);
          WalletLqtDetailUI.b(WalletLqtDetailUI.this);
          WalletLqtDetailUI.c(WalletLqtDetailUI.this);
          if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
        }
        for (;;)
        {
          try
          {
            paramAnonymouscju = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
            ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ah.a.GQi, paramAnonymouscju);
            if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
              WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
            }
            paramAnonymouscju = Jql;
            AppMethodBeat.o(68798);
            return paramAnonymouscju;
          }
          catch (IOException paramAnonymouscju)
          {
            ac.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymouscju, "", new Object[0]);
            continue;
          }
          ac.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
        }
      }
    }).a(new d.a()
    {
      public final void cc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68787);
        if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
          WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
        }
        ac.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
        int i = paramInt - 1;
        if (i > 0)
        {
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, i);
          AppMethodBeat.o(68787);
          return;
        }
        if (paramAnonymousObject != null) {
          if (!(paramAnonymousObject instanceof String)) {
            break label99;
          }
        }
        label99:
        for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
        {
          Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
          AppMethodBeat.o(68787);
          return;
        }
      }
    });
    AppMethodBeat.o(68819);
  }
  
  private void ayL(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    ac.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.Baz != null)
    {
      str = this.Baz.Fwv;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.Baz.dAL != 1) {
        break label266;
      }
      bool1 = true;
      label77:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.Baz.FxD != 1) {
        break label271;
      }
    }
    label266:
    label271:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", eoO());
      localIntent.putExtra("lqt_profile_wording", this.Baz.Fxs);
      localIntent.putExtra("lqt_account_type", this.Baz.ErG);
      localIntent.putExtra("lqt_fund_spid", this.Baz.Fwx);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label77;
    }
  }
  
  private void ayM(String paramString)
  {
    AppMethodBeat.i(68822);
    ac.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.Baz.Foc);
    localIntent.putExtra("lqt_max_redeem_amount", this.Baz.FxK);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.Baz.FxL);
    localIntent.putExtra("lqt_account_type", this.Baz.ErG);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void cYk()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.Baz != null)
    {
      if ((this.Baz.Fya != null) && (this.Baz.Fya.size() == 1) && (this.Baz.FxN))
      {
        ac.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        bxp localbxp = (bxp)this.Baz.Fya.get(0);
        addTextOptionMenu(0, localbxp.title, new WalletLqtDetailUI.11(this, localbxp));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68803);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(68800);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  bxp localbxp = (bxp)localIterator.next();
                  if (!bs.isNullOrNil(localbxp.title)) {
                    paramAnonymous2l.c(i, localbxp.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxN) {
                paramAnonymous2l.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(2131099803), WalletLqtDetailUI.this.getString(2131765387));
              }
              AppMethodBeat.o(68800);
            }
          };
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68802);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxN))
              {
                if (!bs.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxS)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxS;
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(2131757429), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(68801);
                      WalletLqtDetailUI.h(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(68801);
                    }
                  });
                  AppMethodBeat.o(68802);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).ErG == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765389);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765372);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya.size()))
              {
                paramAnonymous2MenuItem = (bxp)WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fya.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.Fmq != 1) {
                  if (paramAnonymous2MenuItem.Fmq == 2)
                  {
                    if (!bs.isNullOrNil(paramAnonymous2MenuItem.EvL))
                    {
                      com.tencent.mm.wallet_core.ui.e.n(WalletLqtDetailUI.this, paramAnonymous2MenuItem.EvL, false);
                      AppMethodBeat.o(68802);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.Fmq == 3) && (!bs.isNullOrNil(paramAnonymous2MenuItem.Ekn)) && (!bs.isNullOrNil(paramAnonymous2MenuItem.EvL))) {
                    com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.Ekn, paramAnonymous2MenuItem.EvL, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(68802);
            }
          };
          paramAnonymousMenuItem.cED();
          AppMethodBeat.o(68803);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> eoO()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.Baz.FxE != null) && (this.Baz.FxE.size() > 0))
    {
      Iterator localIterator = this.Baz.FxE.iterator();
      while (localIterator.hasNext())
      {
        acz localacz = (acz)localIterator.next();
        if ((!bs.isNullOrNil(localacz.title)) && (!bs.isNullOrNil(localacz.EvL))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localacz.title, localacz.EvL }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void eoP()
  {
    AppMethodBeat.i(207197);
    ac.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.Bbe)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(17084, new Object[] { Integer.valueOf(10) });
      this.Bbe = true;
      ac.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494615, this.BaL, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131301687);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131301686);
    localTextView1.setText(this.Baz.Fyd.FeK.title);
    localTextView2.setText(this.Baz.Fyd.FeK.desc);
    if (this.Baz.Fyd.FeK.Fmq != 1)
    {
      if (this.Baz.Fyd.FeK.Fmq != 2) {
        break label228;
      }
      if (!bs.isNullOrNil(this.Baz.Fyd.FeK.EvL))
      {
        localViewGroup.setTag(this.Baz.Fyd.FeK.EvL);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.16(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.BaL.addView(localViewGroup);
      AppMethodBeat.o(207197);
      return;
      label228:
      if ((this.Baz.Fyd.FeK.Fmq == 3) && (!bs.isNullOrNil(this.Baz.Fyd.FeK.Ekn)) && (!bs.isNullOrNil(this.Baz.Fyd.FeK.EvL))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.17(this));
      }
    }
  }
  
  private void tl(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    Object localObject1;
    if (this.Baz != null)
    {
      this.BaA.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQo, Long.valueOf(0L))).longValue();
      localObject1 = this.Bbb;
      Object localObject2 = com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.b(String.valueOf(l), "100", RoundingMode.HALF_UP));
      label126:
      int i;
      label162:
      label336:
      label371:
      Object localObject3;
      label450:
      TextView localTextView1;
      TextView localTextView2;
      CdnImageView localCdnImageView;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).cc((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(2131301640);
        if (localObject1 != null)
        {
          if (bs.isNullOrNil(this.Baz.FxO)) {
            break label693;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(2131301658);
        if (localObject1 != null)
        {
          if (bs.isNullOrNil(this.Baz.FxO)) {
            break label703;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.18(this);
        this.BaQ.setOnClickListener((View.OnClickListener)localObject1);
        this.Bbb.setOnClickListener((View.OnClickListener)localObject1);
        this.BaC.setOnClickListener(new WalletLqtDetailUI.19(this));
        this.BaD.setText(this.Baz.Fxy);
        this.BaE.setText(this.Baz.Fxz);
        this.BaG.setText(this.Baz.FxA);
        this.BaH.setText(com.tencent.mm.wallet_core.ui.e.D(com.tencent.mm.wallet_core.ui.e.b(this.Baz.FxB, "100", RoundingMode.HALF_UP)));
        this.BaF.setOnClickListener(new WalletLqtDetailUI.20(this));
        if (bs.isNullOrNil(this.Baz.FxR)) {
          break label713;
        }
        this.BaY.setText(this.Baz.FxR);
        this.BaY.setVisibility(0);
        if (bs.isNullOrNil(this.Baz.FxX)) {
          break label724;
        }
        this.BaZ.setText(this.Baz.FxX);
        this.BaZ.setVisibility(0);
        this.BaK.removeAllViews();
        this.BaL.removeAllViews();
        if ((this.Baz.Fyd != null) && (this.Baz.Fyd.FeJ == 1)) {
          eoP();
        }
        if ((this.Baz.FxQ == null) || (this.Baz.FxQ.isEmpty())) {
          break label876;
        }
        localObject1 = this.Baz.FxQ.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1064;
        }
        localObject3 = (bxp)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.BaK, false);
        localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
        localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
        localCdnImageView = (CdnImageView)((ViewGroup)localObject2).findViewById(2131301372);
        View localView = ((ViewGroup)localObject2).findViewById(2131301374);
        if (i == this.Baz.FxQ.size() - 1) {
          localView.setVisibility(8);
        }
        localTextView1.setText(((bxp)localObject3).title);
        localTextView2.setText(((bxp)localObject3).desc);
        if (bs.isNullOrNil(((bxp)localObject3).drM)) {
          break label735;
        }
        localCdnImageView.setUseSdcardCache(true);
        localCdnImageView.setUrl(((bxp)localObject3).drM);
        localCdnImageView.setVisibility(0);
        label617:
        if (((bxp)localObject3).Fmq != 1) {
          break label777;
        }
        if (!"wxpay://lqt/planindex".equals(((bxp)localObject3).EvL)) {
          break label745;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.21(this, (bxp)localObject3));
      }
      label777:
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.BaK.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label450;
        paramBoolean = false;
        break;
        label693:
        ((ImageView)localObject1).setVisibility(8);
        break label126;
        label703:
        ((ImageView)localObject1).setVisibility(8);
        break label162;
        label713:
        this.BaY.setVisibility(4);
        break label336;
        label724:
        this.BaZ.setVisibility(4);
        break label371;
        label735:
        localCdnImageView.setVisibility(8);
        break label617;
        label745:
        if ("wxpay://lqt/autochargesetting".equals(((bxp)localObject3).EvL))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.22(this, (bxp)localObject3));
          continue;
          if (((bxp)localObject3).Fmq == 2)
          {
            if (!bs.isNullOrNil(((bxp)localObject3).EvL))
            {
              ((ViewGroup)localObject2).setTag(((bxp)localObject3).EvL);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.23(this, (ViewGroup)localObject2, (bxp)localObject3));
            }
          }
          else if ((((bxp)localObject3).Fmq == 3) && (!bs.isNullOrNil(((bxp)localObject3).Ekn)) && (!bs.isNullOrNil(((bxp)localObject3).EvL))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.24(this, (bxp)localObject3));
          }
        }
      }
      label876:
      if ((this.Baz.FxC != null) && (this.Baz.FxC.size() > 0))
      {
        localObject1 = this.Baz.FxC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (acz)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.BaK, false);
          localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
          localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
          localTextView1.setText(((acz)localObject3).title);
          localTextView2.setText(((acz)localObject3).desc);
          if (!bs.isNullOrNil(((acz)localObject3).EvL))
          {
            ((ViewGroup)localObject2).setTag(((acz)localObject3).EvL);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.2(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.BaK.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
      }
      label1064:
      if (this.BaK.getChildCount() == 0)
      {
        localObject1 = findViewById(2131301671);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.Baz.Foc > 0) {
        break label1649;
      }
      this.BaJ.setEnabled(false);
      if (bs.isNullOrNil(this.Baz.FxY)) {
        break label1660;
      }
      this.Bba.setText(this.Baz.FxY);
      com.tencent.mm.wallet_core.ui.e.aT(this.Bba, 50);
      this.Bba.setOnClickListener(new WalletLqtDetailUI.3(this));
      this.Bba.setVisibility(0);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.BaM.setGravity(3);
      this.BaM.setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 5), 0, 0, 0);
      label1217:
      if (this.Baz.FxF != null)
      {
        this.BaM.setText(this.Baz.FxF.title);
        this.BaM.setOnClickListener(new WalletLqtDetailUI.4(this));
      }
      this.BaO.setVisibility(8);
      if ((this.Baz.FxH != null) && (!bs.isNullOrNil(this.Baz.FxH.title)))
      {
        this.BaO.setVisibility(0);
        this.BaP.setText(this.Baz.FxH.title);
        if (!bs.isNullOrNil(this.Baz.FxH.EvL)) {
          this.BaO.setOnClickListener(new WalletLqtDetailUI.5(this));
        }
      }
      this.BaS.setVisibility(8);
      this.BaR.setVisibility(8);
      if ((this.Baz.FxI != null) && (!bs.isNullOrNil(this.Baz.FxI.username)))
      {
        this.BaT.setUrl(this.Baz.FxI.hhs);
        this.BaU.setText(this.Baz.FxI.title);
        this.BaV.setText(this.Baz.FxI.desc);
        this.BaS.setOnClickListener(new WalletLqtDetailUI.6(this));
        this.BaR.setVisibility(0);
        this.BaS.setVisibility(0);
      }
      this.BaM.setVisibility(0);
      if (bs.isNullOrNil(this.Baz.AXd)) {
        break label1712;
      }
      this.BaN.setText(this.Baz.AXd);
      label1511:
      if ((this.Baz.FxU == null) || (bs.isNullOrNil(this.Baz.FxU.title))) {
        break label1760;
      }
      this.BaW.setVisibility(0);
      this.BaX.setText(this.Baz.FxU.title);
      this.BaW.setOnClickListener(new WalletLqtDetailUI.7(this));
    }
    for (;;)
    {
      this.BaI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(68794);
          if (ab.iwH)
          {
            Object localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fwv;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).dAL != 1) {
                break label230;
              }
              bool1 = true;
              label83:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxD != 1) {
                break label235;
              }
            }
            label230:
            label235:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).Fxs);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(68794);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label83;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxV != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxV.FdJ) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Foi != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).Foi);
            AppMethodBeat.o(68794);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).AXs.is(WalletLqtDetailUI.d(WalletLqtDetailUI.this).ErG, 1);
          if (!bs.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxJ))
          {
            ac.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxJ });
            com.tencent.mm.wallet_core.ui.e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxJ, false);
            AppMethodBeat.o(68794);
            return;
          }
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxV);
          AppMethodBeat.o(68794);
        }
      });
      this.BaJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68795);
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxW != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxW.FdJ) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Foi != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).Foi);
            AppMethodBeat.o(68795);
            return;
          }
          paramAnonymousView = WalletLqtDetailUI.g(WalletLqtDetailUI.this).AXr;
          com.tencent.mm.vending.g.g.J(Integer.valueOf(WalletLqtDetailUI.d(WalletLqtDetailUI.this).ErG), Integer.valueOf(1)).c(paramAnonymousView);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).FxW);
          AppMethodBeat.o(68795);
        }
      });
      if ((this.Baz.FdJ) && (this.Baz.Foi != null)) {
        af.a(this, this.Baz.Foi);
      }
      cYk();
      AppMethodBeat.o(68820);
      return;
      label1649:
      this.BaJ.setEnabled(true);
      break;
      label1660:
      this.Bba.setVisibility(8);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.BaM.setGravity(17);
      this.BaM.setPadding(0, 0, 0, 0);
      break label1217;
      label1712:
      if (this.Baz.ErG == 1)
      {
        this.BaN.setText(2131765391);
        break label1511;
      }
      if (this.Baz.ErG != 2) {
        break label1511;
      }
      this.BaN.setText(2131765392);
      break label1511;
      label1760:
      this.BaW.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495973;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.Bbc = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.iBT != null) {
        break label118;
      }
      this.iBT = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    for (;;)
    {
      u.a locala = this.Bay.AXq;
      com.tencent.mm.vending.g.g.J(paramIntent, Integer.valueOf(this.Baz.ErG)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void cc(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68804);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          ac.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramAnonymousObject });
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(68804);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.iBT.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68815);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101118));
    setActionbarElementColor(getResources().getColor(2131099828));
    hideActionbarLine();
    setMMTitle("");
    ac.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      ac.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.BaA = ((ViewGroup)findViewById(2131299040));
    this.BaB = ((TextView)findViewById(2131301667));
    this.BaQ = ((RelativeLayout)findViewById(2131301643));
    this.BaC = ((ViewGroup)findViewById(2131299038));
    this.BaD = ((TextView)findViewById(2131301641));
    this.BaE = ((TextView)findViewById(2131301642));
    this.BaF = ((ViewGroup)findViewById(2131299043));
    this.BaG = ((TextView)findViewById(2131301659));
    this.BaH = ((WalletTextView)findViewById(2131301660));
    this.BaI = ((Button)findViewById(2131301664));
    this.BaJ = ((Button)findViewById(2131301655));
    this.BaK = ((LinearLayout)findViewById(2131301650));
    this.BaL = ((LinearLayout)findViewById(2131301684));
    this.BaM = ((TextView)findViewById(2131301654));
    this.BaO = findViewById(2131301646);
    this.BaP = ((TextView)findViewById(2131301647));
    this.BaS = findViewById(2131301666);
    this.BaT = ((CdnImageView)findViewById(2131305850));
    this.BaU = ((TextView)findViewById(2131305851));
    this.BaV = ((TextView)findViewById(2131305849));
    this.BaR = findViewById(2131301665);
    this.BaN = ((TextView)findViewById(2131301652));
    this.BaW = ((LinearLayout)findViewById(2131301668));
    this.BaX = ((TextView)findViewById(2131301669));
    this.BaY = ((TextView)findViewById(2131301657));
    this.BaZ = ((TextView)findViewById(2131301670));
    this.Bba = ((TextView)findViewById(2131301656));
    this.Bbb = ((WcPayMoneyLoadingView)findViewById(2131301645));
    this.uDg = ((ProgressBar)findViewById(2131306757));
    this.Bbb.setLoadingPb(this.uDg);
    getLifecycle().addObserver(this.Bbb);
    this.Bbb.setPrefixSymbol(getString(2131765813));
    this.BaM.setVisibility(4);
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.Bax = null;
    this.Bay = null;
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.Bbb.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    if (this.Bbc) {}
    try
    {
      String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQi, "");
      if (!bs.isNullOrNil(str)) {
        this.Baz = ((cju)new cju().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
      }
      tl(true);
      Tp(0);
      this.Bbc = true;
      AppMethodBeat.o(68817);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */