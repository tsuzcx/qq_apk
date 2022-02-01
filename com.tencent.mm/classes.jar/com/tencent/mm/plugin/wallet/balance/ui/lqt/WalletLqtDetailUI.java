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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int oRz;
  private Button CSA;
  private Button CSB;
  private LinearLayout CSC;
  private LinearLayout CSD;
  private LinearLayout CSE;
  private TextView CSF;
  private TextView CSG;
  private View CSH;
  private TextView CSI;
  private RelativeLayout CSJ;
  private View CSK;
  private View CSL;
  private CdnImageView CSM;
  private TextView CSN;
  private TextView CSO;
  private LinearLayout CSP;
  private TextView CSQ;
  private TextView CSR;
  private TextView CSS;
  private LinearLayout CST;
  private TextView CSU;
  private WcPayMoneyLoadingView CSV;
  private boolean CSW;
  private boolean CSX;
  private boolean CSY;
  private t CSp;
  private u CSq;
  private cpo CSr;
  private ViewGroup CSs;
  private TextView CSt;
  private ViewGroup CSu;
  private TextView CSv;
  private TextView CSw;
  private ViewGroup CSx;
  private TextView CSy;
  private WalletTextView CSz;
  private aq handler;
  private Dialog iXW;
  private ProgressBar vSc;
  
  static
  {
    AppMethodBeat.i(68832);
    oRz = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.CSp = ((t)aq(t.class));
    this.CSq = ((u)am(u.class));
    this.CSW = true;
    this.handler = new aq(Looper.getMainLooper());
    this.CSX = false;
    this.CSY = false;
    AppMethodBeat.o(68814);
  }
  
  private void a(cda paramcda)
  {
    AppMethodBeat.i(190078);
    if (paramcda == null)
    {
      AppMethodBeat.o(190078);
      return;
    }
    if ((("wxpay://lqt/fixeddeposit/makeplan".equals(paramcda.GvO)) || ("wxpay://lqt/fixeddeposit/planlist".equals(paramcda.GvO))) && (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWQ, Boolean.FALSE)).booleanValue()) && (bu.isNullOrNil(paramcda.desc))) {
      paramcda.desc = getContext().getResources().getText(2131767295).toString();
    }
    AppMethodBeat.o(190078);
  }
  
  private void aFm(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    ae.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.CSr != null)
    {
      str = this.CSr.HAb;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.CSr.dOo != 1) {
        break label270;
      }
      bool1 = true;
      label80:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.CSr.HBi != 1) {
        break label275;
      }
    }
    label270:
    label275:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", eGv());
      localIntent.putExtra("lqt_profile_wording", this.CSr.HAX);
      localIntent.putExtra("lqt_account_type", this.CSr.uIM);
      localIntent.putExtra("lqt_fund_spid", this.CSr.HAd);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  private void aFn(String paramString)
  {
    AppMethodBeat.i(68822);
    ae.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.CSr.Hro);
    localIntent.putExtra("lqt_max_redeem_amount", this.CSr.HBp);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.CSr.HBq);
    localIntent.putExtra("lqt_account_type", this.CSr.uIM);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void dkv()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.CSr != null)
    {
      if ((this.CSr.HBF != null) && (this.CSr.HBF.size() == 1) && (this.CSr.HBs))
      {
        ae.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        cda localcda = (cda)this.CSr.HBF.get(0);
        addTextOptionMenu(0, localcda.title, new WalletLqtDetailUI.14(this, localcda));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190070);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(190067);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  cda localcda = (cda)localIterator.next();
                  if (!bu.isNullOrNil(localcda.title)) {
                    paramAnonymous2l.d(i, localcda.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBs) {
                paramAnonymous2l.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(2131099803), WalletLqtDetailUI.this.getString(2131765387));
              }
              AppMethodBeat.o(190067);
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(190069);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBs))
              {
                if (!bu.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBx)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBx;
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(2131757429), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(190068);
                      WalletLqtDetailUI.h(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(190068);
                    }
                  });
                  AppMethodBeat.o(190069);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).uIM == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765389);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765372);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF.size()))
              {
                paramAnonymous2MenuItem = (cda)WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBF.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.Hpz != 1) {
                  if (paramAnonymous2MenuItem.Hpz == 2)
                  {
                    if (!bu.isNullOrNil(paramAnonymous2MenuItem.GvO))
                    {
                      f.o(WalletLqtDetailUI.this, paramAnonymous2MenuItem.GvO, false);
                      AppMethodBeat.o(190069);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.Hpz == 3) && (!bu.isNullOrNil(paramAnonymous2MenuItem.GjV)) && (!bu.isNullOrNil(paramAnonymous2MenuItem.GvO))) {
                    f.u(paramAnonymous2MenuItem.GjV, paramAnonymous2MenuItem.GvO, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(190069);
            }
          };
          paramAnonymousMenuItem.cPF();
          AppMethodBeat.o(190070);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> eGv()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.CSr.HBj != null) && (this.CSr.HBj.size() > 0))
    {
      Iterator localIterator = this.CSr.HBj.iterator();
      while (localIterator.hasNext())
      {
        afj localafj = (afj)localIterator.next();
        if ((!bu.isNullOrNil(localafj.title)) && (!bu.isNullOrNil(localafj.GvO))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localafj.title, localafj.GvO }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void eGw()
  {
    AppMethodBeat.i(190077);
    ae.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.CSY)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(17084, new Object[] { Integer.valueOf(10) });
      this.CSY = true;
      ae.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494615, this.CSD, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131301687);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131301686);
    localTextView1.setText(this.CSr.HBI.HhO.title);
    localTextView2.setText(this.CSr.HBI.HhO.desc);
    if (this.CSr.HBI.HhO.Hpz != 1)
    {
      if (this.CSr.HBI.HhO.Hpz != 2) {
        break label230;
      }
      if (!bu.isNullOrNil(this.CSr.HBI.HhO.GvO))
      {
        localViewGroup.setTag(this.CSr.HBI.HhO.GvO);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.18(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.CSD.addView(localViewGroup);
      AppMethodBeat.o(190077);
      return;
      label230:
      if ((this.CSr.HBI.HhO.Hpz == 3) && (!bu.isNullOrNil(this.CSr.HBI.HhO.GjV)) && (!bu.isNullOrNil(this.CSr.HBI.HhO.GvO))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.19(this));
      }
    }
  }
  
  private void uc(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    label129:
    label165:
    label340:
    label375:
    int i;
    label454:
    label635:
    int j;
    if (this.CSr != null)
    {
      this.CSs.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXi, Long.valueOf(0L))).longValue();
      Object localObject1 = this.CSV;
      Object localObject2 = f.C(f.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP));
      Object localObject3;
      TextView localTextView1;
      TextView localTextView2;
      Object localObject4;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).co((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(2131301640);
        if (localObject1 != null)
        {
          if (bu.isNullOrNil(this.CSr.HBt)) {
            break label711;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(2131301658);
        if (localObject1 != null)
        {
          if (bu.isNullOrNil(this.CSr.HBt)) {
            break label721;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.20(this);
        this.CSJ.setOnClickListener((View.OnClickListener)localObject1);
        this.CSV.setOnClickListener((View.OnClickListener)localObject1);
        this.CSu.setOnClickListener(new WalletLqtDetailUI.21(this));
        this.CSv.setText(this.CSr.HBd);
        this.CSw.setText(this.CSr.HBe);
        this.CSy.setText(this.CSr.HBf);
        this.CSz.setText(f.D(f.a(this.CSr.HBg, "100", 2, RoundingMode.HALF_UP)));
        this.CSx.setOnClickListener(new WalletLqtDetailUI.22(this));
        if (bu.isNullOrNil(this.CSr.HBw)) {
          break label731;
        }
        this.CSR.setText(this.CSr.HBw);
        this.CSR.setVisibility(0);
        if (bu.isNullOrNil(this.CSr.HBC)) {
          break label742;
        }
        this.CSS.setText(this.CSr.HBC);
        this.CSS.setVisibility(0);
        this.CSC.removeAllViews();
        this.CSD.removeAllViews();
        if ((this.CSr.HBI != null) && (this.CSr.HBI.HhN == 1)) {
          eGw();
        }
        if ((this.CSr.HBv == null) || (this.CSr.HBv.isEmpty())) {
          break label952;
        }
        localObject1 = this.CSr.HBv.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1187;
        }
        localObject3 = (cda)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.CSC, false);
        localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
        localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
        localObject4 = (CdnImageView)((ViewGroup)localObject2).findViewById(2131301372);
        View localView = ((ViewGroup)localObject2).findViewById(2131301374);
        if (i == this.CSr.HBv.size() - 1)
        {
          localView.setVisibility(8);
          ((ViewGroup)localObject2).setBackgroundResource(2131231332);
        }
        a((cda)localObject3);
        localTextView1.setText(((cda)localObject3).title);
        localTextView2.setText(((cda)localObject3).desc);
        if (bu.isNullOrNil(((cda)localObject3).dEM)) {
          break label753;
        }
        ((CdnImageView)localObject4).setUseSdcardCache(true);
        ((CdnImageView)localObject4).setUrl(((cda)localObject3).dEM);
        ((CdnImageView)localObject4).setVisibility(0);
        if (((cda)localObject3).Hpz != 1) {
          break label853;
        }
        if (!"wxpay://lqt/planindex".equals(((cda)localObject3).GvO)) {
          break label763;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.23(this, (cda)localObject3));
      }
      label711:
      label721:
      label853:
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.CSC.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label454;
        paramBoolean = false;
        break;
        ((ImageView)localObject1).setVisibility(8);
        break label129;
        ((ImageView)localObject1).setVisibility(8);
        break label165;
        label731:
        this.CSR.setVisibility(4);
        break label340;
        label742:
        this.CSS.setVisibility(4);
        break label375;
        label753:
        ((CdnImageView)localObject4).setVisibility(8);
        break label635;
        label763:
        if ("wxpay://lqt/autochargesetting".equals(((cda)localObject3).GvO))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.24(this, (cda)localObject3));
        }
        else if ("wxpay://lqt/fixeddeposit/makeplan".equals(((cda)localObject3).GvO))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.25(this));
        }
        else if ("wxpay://lqt/fixeddeposit/planlist".equals(((cda)localObject3).GvO))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.26(this));
          continue;
          if (((cda)localObject3).Hpz == 2)
          {
            if (!bu.isNullOrNil(((cda)localObject3).GvO))
            {
              ((ViewGroup)localObject2).setTag(((cda)localObject3).GvO);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.2(this, (ViewGroup)localObject2, (cda)localObject3));
            }
          }
          else if ((((cda)localObject3).Hpz == 3) && (!bu.isNullOrNil(((cda)localObject3).GjV)) && (!bu.isNullOrNil(((cda)localObject3).GvO))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.3(this, (cda)localObject3));
          }
        }
      }
      label952:
      if ((this.CSr.HBh != null) && (this.CSr.HBh.size() > 0))
      {
        localObject1 = this.CSr.HBh.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (afj)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.CSC, false);
          localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
          localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
          localObject4 = ((ViewGroup)localObject2).findViewById(2131301374);
          if (i == this.CSr.HBh.size() - 1)
          {
            ((View)localObject4).setVisibility(8);
            ((ViewGroup)localObject2).setBackgroundResource(2131231332);
          }
          localTextView1.setText(((afj)localObject3).title);
          localTextView2.setText(((afj)localObject3).desc);
          if (!bu.isNullOrNil(((afj)localObject3).GvO))
          {
            ((ViewGroup)localObject2).setTag(((afj)localObject3).GvO);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.4(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.CSC.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          i += 1;
        }
      }
      label1187:
      if (this.CSC.getChildCount() == 0)
      {
        localObject1 = findViewById(2131301671);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.CSr.Hro > 0) {
        break label1817;
      }
      this.CSB.setEnabled(false);
      if (bu.isNullOrNil(this.CSr.HBD)) {
        break label1828;
      }
      i = 1;
      label1250:
      if ((this.CSr.HBk == null) || (bu.isNullOrNil(this.CSr.HBk.title))) {
        break label1833;
      }
      j = 1;
      label1278:
      if (i != 0)
      {
        this.CSU.setText(this.CSr.HBD);
        al.a(this.CSU.getPaint(), 0.8F);
        f.aW(this.CSU, 50);
        this.CST.setOnClickListener(new WalletLqtDetailUI.5(this));
      }
      if (j != 0)
      {
        this.CSF.setText(this.CSr.HBk.title);
        al.a(this.CSF.getPaint(), 0.8F);
        this.CSE.setOnClickListener(new WalletLqtDetailUI.6(this));
      }
      if ((i == 0) || (j == 0)) {
        break label1838;
      }
      this.CST.setVisibility(0);
      this.CST.setGravity(5);
      this.CSE.setVisibility(0);
      this.CSE.setGravity(3);
      label1422:
      this.CSH.setVisibility(8);
      if ((this.CSr.HBm != null) && (!bu.isNullOrNil(this.CSr.HBm.title)))
      {
        this.CSH.setVisibility(0);
        this.CSI.setText(this.CSr.HBm.title);
        if (!bu.isNullOrNil(this.CSr.HBm.GvO)) {
          this.CSH.setOnClickListener(new WalletLqtDetailUI.7(this));
        }
      }
      this.CSL.setVisibility(8);
      this.CSK.setVisibility(8);
      if ((this.CSr.HBn != null) && (!bu.isNullOrNil(this.CSr.HBn.username)))
      {
        this.CSM.setUrl(this.CSr.HBn.hCp);
        this.CSN.setText(this.CSr.HBn.title);
        this.CSO.setText(this.CSr.HBn.desc);
        this.CSL.setOnClickListener(new WalletLqtDetailUI.8(this));
        this.CSK.setVisibility(0);
        this.CSL.setVisibility(0);
      }
      if (bu.isNullOrNil(this.CSr.COR)) {
        break label1925;
      }
      this.CSG.setText(this.CSr.COR);
      label1666:
      if ((this.CSr.HBz == null) || (bu.isNullOrNil(this.CSr.HBz.title))) {
        break label1973;
      }
      this.CSP.setVisibility(0);
      this.CSQ.setText(this.CSr.HBz.title);
      al.a(this.CSQ.getPaint(), 0.8F);
      this.CSP.setOnClickListener(new WalletLqtDetailUI.9(this));
    }
    for (;;)
    {
      this.CSA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(68796);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          if (ac.iSI)
          {
            localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).HAb;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).dOo != 1) {
                break label274;
              }
              bool1 = true;
              label115:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBi != 1) {
                break label279;
              }
            }
            label274:
            label279:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).HAX);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68796);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label115;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBA != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBA.HgN) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hru != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hru);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).CPg.iJ(WalletLqtDetailUI.d(WalletLqtDetailUI.this).uIM, 1);
          if (!bu.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBo))
          {
            ae.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBo });
            f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBo, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBA);
          }
        }
      });
      this.CSB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190064);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBB != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBB.HgN) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hru != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hru);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190064);
            return;
          }
          paramAnonymousView = WalletLqtDetailUI.g(WalletLqtDetailUI.this).CPf;
          com.tencent.mm.vending.g.g.L(Integer.valueOf(WalletLqtDetailUI.d(WalletLqtDetailUI.this).uIM), Integer.valueOf(1)).c(paramAnonymousView);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).HBB);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190064);
        }
      });
      if ((this.CSr.HgN) && (this.CSr.Hru != null)) {
        af.a(this, this.CSr.Hru);
      }
      dkv();
      AppMethodBeat.o(68820);
      return;
      label1817:
      this.CSB.setEnabled(true);
      break;
      label1828:
      i = 0;
      break label1250;
      label1833:
      j = 0;
      break label1278;
      label1838:
      if (i != 0)
      {
        this.CST.setVisibility(0);
        this.CST.setGravity(17);
        this.CSE.setVisibility(8);
        break label1422;
      }
      if (j != 0)
      {
        this.CST.setVisibility(8);
        this.CSE.setVisibility(0);
        this.CSE.setGravity(17);
        break label1422;
      }
      this.CST.setVisibility(8);
      this.CSE.setVisibility(8);
      break label1422;
      label1925:
      if (this.CSr.uIM == 1)
      {
        this.CSG.setText(2131765391);
        break label1666;
      }
      if (this.CSr.uIM != 2) {
        break label1666;
      }
      this.CSG.setText(2131765392);
      break label1666;
      label1973:
      this.CSP.setVisibility(8);
    }
  }
  
  public final void aV(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190076);
    ae.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.CSq == null)
    {
      AppMethodBeat.o(190076);
      return;
    }
    if (paramBoolean)
    {
      if (this.iXW != null) {
        break label106;
      }
      this.iXW = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    }
    for (;;)
    {
      this.CSq.CPd.aRL().f(new com.tencent.mm.vending.c.a()
      {
        private Void a(cpo paramAnonymouscpo)
        {
          AppMethodBeat.i(68798);
          if (paramAnonymouscpo != null)
          {
            ae.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymouscpo.uIM), Boolean.valueOf(paramAnonymouscpo.HBs) });
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymouscpo);
            WalletLqtDetailUI.b(WalletLqtDetailUI.this);
            WalletLqtDetailUI.c(WalletLqtDetailUI.this);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
          }
          for (;;)
          {
            try
            {
              paramAnonymouscpo = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
              ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXc, paramAnonymouscpo);
              if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
                WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
              }
              paramAnonymouscpo = LEs;
              AppMethodBeat.o(68798);
              return paramAnonymouscpo;
            }
            catch (IOException paramAnonymouscpo)
            {
              ae.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymouscpo, "", new Object[0]);
              continue;
            }
            ae.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
          }
        }
      }).a(new d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68787);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          ae.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
          int i = paramInt - 1;
          if (i > 0)
          {
            WalletLqtDetailUI.this.aV(i, false);
            AppMethodBeat.o(68787);
            return;
          }
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label100;
            }
          }
          label100:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(68787);
            return;
          }
        }
      });
      AppMethodBeat.o(190076);
      return;
      label106:
      this.iXW.show();
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
      this.CSW = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.iXW != null) {
        break label118;
      }
      this.iXW = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    }
    for (;;)
    {
      u.a locala = this.CSq.CPe;
      com.tencent.mm.vending.g.g.L(paramIntent, Integer.valueOf(this.CSr.uIM)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(190071);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          ae.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramAnonymousObject });
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(190071);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.iXW.show();
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
    ae.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      ae.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.CSs = ((ViewGroup)findViewById(2131299040));
    this.CSt = ((TextView)findViewById(2131301667));
    al.a(this.CSt.getPaint(), 0.8F);
    this.CSJ = ((RelativeLayout)findViewById(2131301643));
    this.CSu = ((ViewGroup)findViewById(2131299038));
    this.CSv = ((TextView)findViewById(2131301641));
    this.CSw = ((TextView)findViewById(2131301642));
    this.CSx = ((ViewGroup)findViewById(2131299043));
    this.CSy = ((TextView)findViewById(2131301659));
    this.CSz = ((WalletTextView)findViewById(2131301660));
    this.CSA = ((Button)findViewById(2131301664));
    al.a(this.CSA.getPaint(), 0.8F);
    this.CSB = ((Button)findViewById(2131301655));
    al.a(this.CSB.getPaint(), 0.8F);
    this.CSC = ((LinearLayout)findViewById(2131301650));
    this.CSD = ((LinearLayout)findViewById(2131301684));
    this.CSE = ((LinearLayout)findViewById(2131308501));
    this.CSF = ((TextView)findViewById(2131301654));
    this.CSH = findViewById(2131301646);
    this.CSI = ((TextView)findViewById(2131301647));
    this.CSL = findViewById(2131301666);
    this.CSM = ((CdnImageView)findViewById(2131305850));
    this.CSN = ((TextView)findViewById(2131305851));
    this.CSO = ((TextView)findViewById(2131305849));
    this.CSK = findViewById(2131301665);
    this.CSG = ((TextView)findViewById(2131301652));
    this.CSP = ((LinearLayout)findViewById(2131301668));
    this.CSQ = ((TextView)findViewById(2131301669));
    this.CSR = ((TextView)findViewById(2131301657));
    this.CSS = ((TextView)findViewById(2131301670));
    this.CST = ((LinearLayout)findViewById(2131308502));
    this.CSU = ((TextView)findViewById(2131301656));
    this.CSV = ((WcPayMoneyLoadingView)findViewById(2131301645));
    this.vSc = ((ProgressBar)findViewById(2131306757));
    this.CSV.setLoadingPb(this.vSc);
    getLifecycle().addObserver(this.CSV);
    this.CSV.setPrefixSymbol(getString(2131765813));
    this.CSE.setVisibility(4);
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.CSp = null;
    this.CSq = null;
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.CSV.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    if (this.CSW) {}
    try
    {
      String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXc, "");
      if (!bu.isNullOrNil(str)) {
        this.CSr = ((cpo)new cpo().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
      }
      uc(true);
      aV(0, false);
      this.CSW = true;
      AppMethodBeat.o(68817);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */