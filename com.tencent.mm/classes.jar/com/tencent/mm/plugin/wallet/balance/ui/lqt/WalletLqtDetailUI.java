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
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w.d;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.eok;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
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
  private static final int qfn;
  private LinearLayout HxA;
  private LinearLayout HxB;
  private TextView HxC;
  private TextView HxD;
  private View HxE;
  private TextView HxF;
  private RelativeLayout HxG;
  private View HxH;
  private View HxI;
  private CdnImageView HxJ;
  private TextView HxK;
  private TextView HxL;
  private LinearLayout HxM;
  private TextView HxN;
  private TextView HxO;
  private TextView HxP;
  private LinearLayout HxQ;
  private TextView HxR;
  private WcPayMoneyLoadingView HxS;
  private boolean HxT;
  private boolean HxU;
  private boolean HxV;
  private boolean HxW;
  private boolean HxX;
  private LinearLayout HxY;
  private LinearLayout HxZ;
  private v Hxm;
  private w Hxn;
  private dhn Hxo;
  private ViewGroup Hxp;
  private TextView Hxq;
  private ViewGroup Hxr;
  private TextView Hxs;
  private TextView Hxt;
  private ViewGroup Hxu;
  private TextView Hxv;
  private WalletTextView Hxw;
  private Button Hxx;
  private Button Hxy;
  private LinearLayout Hxz;
  private CdnImageView Hya;
  private TextView Hyb;
  private ImageView Hyc;
  private WeImageView Hyd;
  private boolean Hye;
  private a Hyf;
  private IListener Hyg;
  private IListener Hyh;
  private MMHandler handler;
  private Dialog jUV;
  private ProgressBar zmi;
  
  static
  {
    AppMethodBeat.i(68832);
    qfn = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.Hxm = ((v)au(v.class));
    this.Hxn = ((w)aq(w.class));
    this.HxT = true;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.HxU = false;
    this.HxV = false;
    this.HxW = false;
    this.HxX = false;
    this.Hye = false;
    this.Hyg = new IListener() {};
    this.Hyh = new IListener() {};
    AppMethodBeat.o(68814);
  }
  
  private void a(ctg paramctg)
  {
    AppMethodBeat.i(213959);
    if (paramctg == null)
    {
      AppMethodBeat.o(213959);
      return;
    }
    if ((("wxpay://lqt/fixeddeposit/makeplan".equals(paramctg.yUB)) || ("wxpay://lqt/fixeddeposit/planlist".equals(paramctg.yUB))) && (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofi, Boolean.FALSE)).booleanValue()) && (Util.isNullOrNil(paramctg.desc))) {
      paramctg.desc = getContext().getResources().getText(2131767865).toString();
    }
    AppMethodBeat.o(213959);
  }
  
  private void aUK(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.Hxo != null)
    {
      str = this.Hxo.Mnl;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.Hxo.egj != 1) {
        break label270;
      }
      bool1 = true;
      label80:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.Hxo.MLU != 1) {
        break label275;
      }
    }
    label270:
    label275:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", fND());
      localIntent.putExtra("lqt_profile_wording", this.Hxo.MLJ);
      localIntent.putExtra("lqt_account_type", this.Hxo.yba);
      localIntent.putExtra("lqt_fund_spid", this.Hxo.Mnk);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  private void aUL(String paramString)
  {
    AppMethodBeat.i(68822);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.Hxo.MAf);
    localIntent.putExtra("lqt_max_redeem_amount", this.Hxo.MMb);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.Hxo.MMc);
    localIntent.putExtra("lqt_account_type", this.Hxo.yba);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void eeh()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.Hxo != null)
    {
      if ((this.Hxo.MMr != null) && (this.Hxo.MMr.size() == 1) && (this.Hxo.MMe))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        ctg localctg = (ctg)this.Hxo.MMr.get(0);
        addTextOptionMenu(0, localctg.title, new WalletLqtDetailUI.16(this, localctg));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213944);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(213941);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  ctg localctg = (ctg)localIterator.next();
                  if (!Util.isNullOrNil(localctg.title)) {
                    paramAnonymous2m.d(i, localctg.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMe) {
                paramAnonymous2m.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(2131099818), WalletLqtDetailUI.this.getString(2131767831));
              }
              AppMethodBeat.o(213941);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213943);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMe))
              {
                if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMj)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMj;
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(2131757647), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(213942);
                      WalletLqtDetailUI.i(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(213942);
                    }
                  });
                  AppMethodBeat.o(213943);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).yba == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131767833);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131767815);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr.size()))
              {
                paramAnonymous2MenuItem = (ctg)WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMr.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.Myg != 1) {
                  if (paramAnonymous2MenuItem.Myg == 2)
                  {
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.yUB))
                    {
                      f.o(WalletLqtDetailUI.this, paramAnonymous2MenuItem.yUB, false);
                      AppMethodBeat.o(213943);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.Myg == 3) && (!Util.isNullOrNil(paramAnonymous2MenuItem.KZR)) && (!Util.isNullOrNil(paramAnonymous2MenuItem.yUB))) {
                    f.u(paramAnonymous2MenuItem.KZR, paramAnonymous2MenuItem.yUB, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(213943);
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(213944);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> fND()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.Hxo.MLV != null) && (this.Hxo.MLV.size() > 0))
    {
      Iterator localIterator = this.Hxo.MLV.iterator();
      while (localIterator.hasNext())
      {
        ahq localahq = (ahq)localIterator.next();
        if ((!Util.isNullOrNil(localahq.title)) && (!Util.isNullOrNil(localahq.yUB))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localahq.title, localahq.yUB }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void fNE()
  {
    AppMethodBeat.i(213955);
    if (this.Hxo.MMw == null)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "svr not return data, hide security entry");
      this.HxZ.setVisibility(8);
      AppMethodBeat.o(213955);
      return;
    }
    Log.i("MicroMsg.WalletLqtDetailUI", "show lqt security entry with svr data");
    this.HxZ.setVisibility(0);
    int i;
    if (!Util.isNullOrNil(this.Hxo.MMw.icon))
    {
      this.Hya.setVisibility(0);
      this.Hya.setUrl(this.Hxo.MMw.icon);
      this.Hyb.setText(this.Hxo.MMw.title);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.HxY.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        this.HxY.setLayoutParams(localLayoutParams);
      }
      com.tencent.mm.kernel.g.aAi();
      i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oon, Integer.valueOf(0))).intValue();
      if (i != 0) {
        break label356;
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oon, Integer.valueOf(cl.aWB()));
      i = 1;
      label207:
      if (i == 0) {
        break label433;
      }
      this.Hyc.setVisibility(0);
      localLayoutParams = (LinearLayout.LayoutParams)this.Hyd.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.Hyd.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      if (!this.Hye)
      {
        this.Hye = true;
        com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(20) });
        Log.i("MicroMsg.WalletLqtDetailUI", "report show security entry");
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(22) });
        }
      }
      this.HxZ.setOnClickListener(new WalletLqtDetailUI.20(this));
      AppMethodBeat.o(213955);
      return;
      this.Hya.setVisibility(8);
      break;
      label356:
      if (i > 0)
      {
        if (cl.aWB() - i >= 604800L)
        {
          Log.i("MicroMsg.WalletLqtDetailUI", "reddot has display above 7 day, hide it");
          com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(24) });
          i = 0;
          break label207;
        }
        i = 1;
        break label207;
      }
      if (i == -1) {
        Log.i("MicroMsg.WalletLqtDetailUI", "has click reddot");
      }
      i = 0;
      break label207;
      label433:
      this.Hyc.setVisibility(8);
    }
  }
  
  private void fNF()
  {
    AppMethodBeat.i(213956);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.HxV)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(10) });
      this.HxV = true;
      Log.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131495334, this.HxA, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131303985);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131303984);
    localTextView1.setText(this.Hxo.MMv.Mnf.title);
    localTextView2.setText(this.Hxo.MMv.Mnf.desc);
    if (this.Hxo.MMv.Mnf.Myg != 1)
    {
      if (this.Hxo.MMv.Mnf.Myg != 2) {
        break label230;
      }
      if (!Util.isNullOrNil(this.Hxo.MMv.Mnf.yUB))
      {
        localViewGroup.setTag(this.Hxo.MMv.Mnf.yUB);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.21(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.HxA.addView(localViewGroup);
      AppMethodBeat.o(213956);
      return;
      label230:
      if ((this.Hxo.MMv.Mnf.Myg == 3) && (!Util.isNullOrNil(this.Hxo.MMv.Mnf.KZR)) && (!Util.isNullOrNil(this.Hxo.MMv.Mnf.yUB))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.22(this));
      }
    }
  }
  
  private void fNG()
  {
    AppMethodBeat.i(213957);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView2");
    Object localObject;
    ViewGroup localViewGroup;
    CdnImageView localCdnImageView;
    TextView localTextView;
    if (this.Hxo.MMv.Mng.Mno != null)
    {
      if (!this.HxW)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        this.HxW = true;
      }
      localObject = this.Hxo.MMv.Mng.Mno;
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131495335, this.HxA, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131303976);
      localTextView = (TextView)localViewGroup.findViewById(2131303986);
      if (Util.isNullOrNil(((ctg)localObject).icon)) {
        break label220;
      }
      localCdnImageView.setUrl(((ctg)localObject).icon);
      localCdnImageView.setVisibility(0);
    }
    for (;;)
    {
      localTextView.setText(((ctg)localObject).title);
      localViewGroup.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213951);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfL, Boolean.FALSE)).booleanValue();
          if (this.Hyk.Myg == 2) {
            if (!Util.isNullOrNil(this.Hyk.yUB))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Hyk.yUB);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(e.p.OzJ, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title);
              }
              f.aA(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213951);
            return;
            if ((this.Hyk.Myg == 3) && (!Util.isNullOrNil(this.Hyk.KZR)) && (!Util.isNullOrNil(this.Hyk.yUB)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Hyk.KZR;
              paramAnonymousView.kHw = this.Hyk.yUB;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content;
                String str2 = WalletLqtDetailUI.this.getString(2131755874);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.kHS = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.kHT = str1;
                localWeAppOpenDeclarePromptBundle.kHU = str2;
                localWeAppOpenDeclarePromptBundle.ox = false;
                paramAnonymousView.kHJ = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
        }
      });
      localObject = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
      this.HxA.addView(localViewGroup, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(213957);
      return;
      label220:
      localCdnImageView.setVisibility(8);
    }
  }
  
  private void fNH()
  {
    AppMethodBeat.i(213958);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView3");
    Object localObject2;
    Object localObject1;
    ViewGroup localViewGroup1;
    Object localObject3;
    TextView localTextView1;
    if (this.Hxo.MMv.Mng.Mno != null)
    {
      if (!this.HxX)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        this.HxX = true;
      }
      localObject2 = this.Hxo.MMv.Mng.Mno;
      localObject1 = (chv)this.Hxo.MMv.Mng.Mnp.get(0);
      localViewGroup1 = (ViewGroup)getLayoutInflater().inflate(2131495336, this.HxA, false);
      localObject3 = (CdnImageView)localViewGroup1.findViewById(2131303976);
      localTextView1 = (TextView)localViewGroup1.findViewById(2131303986);
      if (Util.isNullOrNil(((ctg)localObject2).icon)) {
        break label357;
      }
      ((CdnImageView)localObject3).setUrl(((ctg)localObject2).icon);
      ((CdnImageView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      localTextView1.setText(((ctg)localObject2).title);
      localViewGroup1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213952);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfL, Boolean.FALSE)).booleanValue();
          if (this.Hyk.Myg == 2) {
            if (!Util.isNullOrNil(this.Hyk.yUB))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Hyk.yUB);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(e.p.OzJ, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title);
              }
              f.aA(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Hyr.Mnk, this.Hyr.Mnl, this.Hyr.Mnm, this.Hyr.Mnn, Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213952);
            return;
            if ((this.Hyk.Myg == 3) && (!Util.isNullOrNil(this.Hyk.KZR)) && (!Util.isNullOrNil(this.Hyk.yUB)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Hyk.KZR;
              paramAnonymousView.kHw = this.Hyk.yUB;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content;
                String str2 = WalletLqtDetailUI.this.getString(2131755874);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.kHS = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.kHT = str1;
                localWeAppOpenDeclarePromptBundle.kHU = str2;
                localWeAppOpenDeclarePromptBundle.ox = false;
                paramAnonymousView.kHJ = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Hyr.Mnk, this.Hyr.Mnl, this.Hyr.Mnm, this.Hyr.Mnn, Integer.valueOf(1) });
            }
          }
        }
      });
      localObject2 = (TextView)localViewGroup1.findViewById(2131303980);
      localObject3 = (TextView)localViewGroup1.findViewById(2131303978);
      localTextView1 = (TextView)localViewGroup1.findViewById(2131303982);
      TextView localTextView2 = (TextView)localViewGroup1.findViewById(2131303981);
      ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(2131303979);
      ((TextView)localObject2).setText(((chv)localObject1).name);
      ((TextView)localObject3).setText(((chv)localObject1).desc);
      localTextView1.setText(((chv)localObject1).Mnh);
      localTextView2.setText(((chv)localObject1).Mni);
      localViewGroup2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213953);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfL, Boolean.FALSE)).booleanValue();
          if (this.Hyr.Mnj == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213953);
            return;
          }
          if (this.Hyr.Mnj.Myg == 2) {
            if (!Util.isNullOrNil(this.Hyr.Mnj.url))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Hyr.Mnj.url);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(e.p.OzJ, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title);
              }
              f.aA(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Hyr.Mnk, this.Hyr.Mnl, this.Hyr.Mnm, this.Hyr.Mnn, Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213953);
            return;
            if ((this.Hyr.Mnj.Myg == 3) && (!Util.isNullOrNil(this.Hyr.Mnj.KZR)) && (!Util.isNullOrNil(this.Hyr.Mnj.url)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Hyr.Mnj.KZR;
              paramAnonymousView.kHw = this.Hyr.Mnj.url;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMv.Mng.Mnq.content;
                String str2 = WalletLqtDetailUI.this.getString(2131755874);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.kHS = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.kHT = str1;
                localWeAppOpenDeclarePromptBundle.kHU = str2;
                localWeAppOpenDeclarePromptBundle.ox = false;
                paramAnonymousView.kHJ = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfL, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Hyr.Mnk, this.Hyr.Mnl, this.Hyr.Mnm, this.Hyr.Mnn, Integer.valueOf(2) });
            }
          }
        }
      });
      localObject1 = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
      this.HxA.addView(localViewGroup1, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(213958);
      return;
      label357:
      ((CdnImageView)localObject3).setVisibility(8);
    }
  }
  
  private void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    label133:
    label169:
    label344:
    label379:
    int i;
    label421:
    label458:
    label639:
    int j;
    if (this.Hxo != null)
    {
      fNE();
      this.Hxp.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfB, Long.valueOf(0L))).longValue();
      Object localObject1 = this.HxS;
      Object localObject2 = f.formatMoney2f(f.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP));
      Object localObject3;
      TextView localTextView1;
      TextView localTextView2;
      Object localObject4;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).cH((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(2131303918);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.Hxo.MMf)) {
            break label715;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(2131303938);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.Hxo.MMf)) {
            break label725;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.23(this);
        this.HxG.setOnClickListener((View.OnClickListener)localObject1);
        this.HxS.setOnClickListener((View.OnClickListener)localObject1);
        this.Hxr.setOnClickListener(new WalletLqtDetailUI.27(this));
        this.Hxs.setText(this.Hxo.MLP);
        this.Hxt.setText(this.Hxo.MLQ);
        this.Hxv.setText(this.Hxo.MLR);
        this.Hxw.setText(f.D(f.a(this.Hxo.MLS, "100", 2, RoundingMode.HALF_UP)));
        this.Hxu.setOnClickListener(new WalletLqtDetailUI.28(this));
        if (Util.isNullOrNil(this.Hxo.MMi)) {
          break label735;
        }
        this.HxO.setText(this.Hxo.MMi);
        this.HxO.setVisibility(0);
        if (Util.isNullOrNil(this.Hxo.MMo)) {
          break label746;
        }
        this.HxP.setText(this.Hxo.MMo);
        this.HxP.setVisibility(0);
        this.Hxz.removeAllViews();
        this.HxA.removeAllViews();
        if ((this.Hxo.MMv == null) || (this.Hxo.MMv.Mne != 1)) {
          break label757;
        }
        fNF();
        if ((this.Hxo.MMh == null) || (this.Hxo.MMh.isEmpty())) {
          break label1039;
        }
        localObject1 = this.Hxo.MMh.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1274;
        }
        localObject3 = (ctg)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495327, this.Hxz, false);
        localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131303929);
        localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131303927);
        localObject4 = (CdnImageView)((ViewGroup)localObject2).findViewById(2131303125);
        View localView = ((ViewGroup)localObject2).findViewById(2131303127);
        if (i == this.Hxo.MMh.size() - 1)
        {
          localView.setVisibility(8);
          ((ViewGroup)localObject2).setBackgroundResource(2131231393);
        }
        a((ctg)localObject3);
        localTextView1.setText(((ctg)localObject3).title);
        localTextView2.setText(((ctg)localObject3).desc);
        if (Util.isNullOrNil(((ctg)localObject3).icon)) {
          break label839;
        }
        ((CdnImageView)localObject4).setUseSdcardCache(true);
        ((CdnImageView)localObject4).setUrl(((ctg)localObject3).icon);
        ((CdnImageView)localObject4).setVisibility(0);
        if (((ctg)localObject3).Myg != 1) {
          break label940;
        }
        if (!"wxpay://lqt/planindex".equals(((ctg)localObject3).yUB)) {
          break label849;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.29(this, (ctg)localObject3));
      }
      label940:
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.Hxz.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label458;
        paramBoolean = false;
        break;
        label715:
        ((ImageView)localObject1).setVisibility(8);
        break label133;
        label725:
        ((ImageView)localObject1).setVisibility(8);
        break label169;
        label735:
        this.HxO.setVisibility(4);
        break label344;
        label746:
        this.HxP.setVisibility(4);
        break label379;
        label757:
        if ((this.Hxo.MMv == null) || (this.Hxo.MMv.Mne != 2) || (this.Hxo.MMv.Mng == null)) {
          break label421;
        }
        localObject1 = this.Hxo.MMv.Mng;
        if ((((chw)localObject1).Mnp == null) || (((chw)localObject1).Mnp.isEmpty()))
        {
          fNG();
          break label421;
        }
        fNH();
        break label421;
        label839:
        ((CdnImageView)localObject4).setVisibility(8);
        break label639;
        label849:
        if ("wxpay://lqt/autochargesetting".equals(((ctg)localObject3).yUB))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.30(this, (ctg)localObject3));
        }
        else if ("wxpay://lqt/fixeddeposit/makeplan".equals(((ctg)localObject3).yUB))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.31(this));
        }
        else if ("wxpay://lqt/fixeddeposit/planlist".equals(((ctg)localObject3).yUB))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.32(this));
          continue;
          if (((ctg)localObject3).Myg == 2)
          {
            if (!Util.isNullOrNil(((ctg)localObject3).yUB))
            {
              ((ViewGroup)localObject2).setTag(((ctg)localObject3).yUB);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.2(this, (ViewGroup)localObject2, (ctg)localObject3));
            }
          }
          else if ((((ctg)localObject3).Myg == 3) && (!Util.isNullOrNil(((ctg)localObject3).KZR)) && (!Util.isNullOrNil(((ctg)localObject3).yUB))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.3(this, (ctg)localObject3));
          }
        }
      }
      label1039:
      if ((this.Hxo.MLT != null) && (this.Hxo.MLT.size() > 0))
      {
        localObject1 = this.Hxo.MLT.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ahq)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495327, this.Hxz, false);
          localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131303929);
          localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131303927);
          localObject4 = ((ViewGroup)localObject2).findViewById(2131303127);
          if (i == this.Hxo.MLT.size() - 1)
          {
            ((View)localObject4).setVisibility(8);
            ((ViewGroup)localObject2).setBackgroundResource(2131231393);
          }
          localTextView1.setText(((ahq)localObject3).title);
          localTextView2.setText(((ahq)localObject3).desc);
          if (!Util.isNullOrNil(((ahq)localObject3).yUB))
          {
            ((ViewGroup)localObject2).setTag(((ahq)localObject3).yUB);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.4(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.Hxz.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          i += 1;
        }
      }
      label1274:
      if (this.Hxz.getChildCount() == 0)
      {
        localObject1 = findViewById(2131303956);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.Hxo.MAf > 0) {
        break label1904;
      }
      this.Hxy.setEnabled(false);
      if (Util.isNullOrNil(this.Hxo.MMp)) {
        break label1915;
      }
      i = 1;
      label1337:
      if ((this.Hxo.MLW == null) || (Util.isNullOrNil(this.Hxo.MLW.title))) {
        break label1920;
      }
      j = 1;
      label1365:
      if (i != 0)
      {
        this.HxR.setText(this.Hxo.MMp);
        com.tencent.mm.ui.ao.a(this.HxR.getPaint(), 0.8F);
        f.aZ(this.HxR, 50);
        this.HxQ.setOnClickListener(new WalletLqtDetailUI.5(this));
      }
      if (j != 0)
      {
        this.HxC.setText(this.Hxo.MLW.title);
        com.tencent.mm.ui.ao.a(this.HxC.getPaint(), 0.8F);
        this.HxB.setOnClickListener(new WalletLqtDetailUI.6(this));
      }
      if ((i == 0) || (j == 0)) {
        break label1925;
      }
      this.HxQ.setVisibility(0);
      this.HxQ.setGravity(5);
      this.HxB.setVisibility(0);
      this.HxB.setGravity(3);
      label1509:
      this.HxE.setVisibility(8);
      if ((this.Hxo.MLY != null) && (!Util.isNullOrNil(this.Hxo.MLY.title)))
      {
        this.HxE.setVisibility(0);
        this.HxF.setText(this.Hxo.MLY.title);
        if (!Util.isNullOrNil(this.Hxo.MLY.yUB)) {
          this.HxE.setOnClickListener(new WalletLqtDetailUI.7(this));
        }
      }
      this.HxI.setVisibility(8);
      this.HxH.setVisibility(8);
      if ((this.Hxo.MLZ != null) && (!Util.isNullOrNil(this.Hxo.MLZ.username)))
      {
        this.HxJ.setUrl(this.Hxo.MLZ.iwv);
        this.HxK.setText(this.Hxo.MLZ.title);
        this.HxL.setText(this.Hxo.MLZ.desc);
        this.HxI.setOnClickListener(new WalletLqtDetailUI.8(this));
        this.HxH.setVisibility(0);
        this.HxI.setVisibility(0);
      }
      if (Util.isNullOrNil(this.Hxo.HtI)) {
        break label2012;
      }
      this.HxD.setText(this.Hxo.HtI);
      label1753:
      if ((this.Hxo.MMl == null) || (Util.isNullOrNil(this.Hxo.MMl.title))) {
        break label2060;
      }
      this.HxM.setVisibility(0);
      this.HxN.setText(this.Hxo.MMl.title);
      com.tencent.mm.ui.ao.a(this.HxN.getPaint(), 0.8F);
      this.HxM.setOnClickListener(new WalletLqtDetailUI.9(this));
    }
    for (;;)
    {
      this.Hxx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(68796);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (ac.jPD)
          {
            localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Mnl;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).egj != 1) {
                break label274;
              }
              bool1 = true;
              label115:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MLU != 1) {
                break label279;
              }
            }
            label274:
            label279:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).MLJ);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMm != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMm.Mma) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MAl != null))
          {
            ah.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).MAl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).HtX.jP(WalletLqtDetailUI.d(WalletLqtDetailUI.this).yba, 1);
          if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMa))
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMa });
            f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMa, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMm);
          }
        }
      });
      this.Hxy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213934);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMn != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMn.Mma) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).MAl != null))
          {
            ah.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).MAl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213934);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).HtW.aen(WalletLqtDetailUI.d(WalletLqtDetailUI.this).yba);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).MMn);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213934);
        }
      });
      if ((this.Hxo.Mma) && (this.Hxo.MAl != null)) {
        ah.a(this, this.Hxo.MAl);
      }
      eeh();
      AppMethodBeat.o(68820);
      return;
      label1904:
      this.Hxy.setEnabled(true);
      break;
      label1915:
      i = 0;
      break label1337;
      label1920:
      j = 0;
      break label1365;
      label1925:
      if (i != 0)
      {
        this.HxQ.setVisibility(0);
        this.HxQ.setGravity(17);
        this.HxB.setVisibility(8);
        break label1509;
      }
      if (j != 0)
      {
        this.HxQ.setVisibility(8);
        this.HxB.setVisibility(0);
        this.HxB.setGravity(17);
        break label1509;
      }
      this.HxQ.setVisibility(8);
      this.HxB.setVisibility(8);
      break label1509;
      label2012:
      if (this.Hxo.yba == 1)
      {
        this.HxD.setText(2131767835);
        break label1753;
      }
      if (this.Hxo.yba != 2) {
        break label1753;
      }
      this.HxD.setText(2131767836);
      break label1753;
      label2060:
      this.HxM.setVisibility(8);
    }
  }
  
  public final void bn(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(213954);
    Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.Hxn == null)
    {
      AppMethodBeat.o(213954);
      return;
    }
    if (paramBoolean)
    {
      if (this.jUV != null) {
        break label106;
      }
      this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    }
    for (;;)
    {
      this.Hxn.HtU.bmq().f(new com.tencent.mm.vending.c.a()
      {
        private Void a(dhn paramAnonymousdhn)
        {
          AppMethodBeat.i(68798);
          if (paramAnonymousdhn != null)
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymousdhn.yba), Boolean.valueOf(paramAnonymousdhn.MMe) });
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymousdhn);
            WalletLqtDetailUI.b(WalletLqtDetailUI.this);
            WalletLqtDetailUI.c(WalletLqtDetailUI.this);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
          }
          for (;;)
          {
            try
            {
              paramAnonymousdhn = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
              ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.Ofv, paramAnonymousdhn);
              if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
                WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
              }
              paramAnonymousdhn = QZL;
              AppMethodBeat.o(68798);
              return paramAnonymousdhn;
            }
            catch (IOException paramAnonymousdhn)
            {
              Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymousdhn, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
          }
        }
      }).a(new d.a()
      {
        public final void cn(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68787);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
          int i = paramInt - 1;
          if (i > 0)
          {
            WalletLqtDetailUI.this.bn(i, false);
            AppMethodBeat.o(68787);
            return;
          }
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label100;
            }
          }
          label100:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131767869))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(68787);
            return;
          }
        }
      });
      AppMethodBeat.o(213954);
      return;
      label106:
      this.jUV.show();
    }
  }
  
  public int getLayoutId()
  {
    return 2131496953;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.HxT = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.jUV != null) {
        break label118;
      }
      this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    }
    for (;;)
    {
      w.a locala = this.Hxn.HtV;
      com.tencent.mm.vending.g.g.O(paramIntent, Integer.valueOf(this.Hxo.yba)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void cn(Object paramAnonymousObject)
        {
          AppMethodBeat.i(213945);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          Log.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramAnonymousObject });
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131767869))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(213945);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.jUV.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68815);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101361));
    setActionbarElementColor(getResources().getColor(2131099844));
    hideActionbarLine();
    setMMTitle("");
    this.Hyf = new a(this);
    Log.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.Hxp = ((ViewGroup)findViewById(2131299545));
    this.Hxq = ((TextView)findViewById(2131303952));
    com.tencent.mm.ui.ao.a(this.Hxq.getPaint(), 0.8F);
    this.HxG = ((RelativeLayout)findViewById(2131303921));
    this.Hxr = ((ViewGroup)findViewById(2131299542));
    this.Hxs = ((TextView)findViewById(2131303919));
    this.Hxt = ((TextView)findViewById(2131303920));
    this.Hxu = ((ViewGroup)findViewById(2131299549));
    this.Hxv = ((TextView)findViewById(2131303939));
    this.Hxw = ((WalletTextView)findViewById(2131303940));
    this.Hxx = ((Button)findViewById(2131303944));
    com.tencent.mm.ui.ao.a(this.Hxx.getPaint(), 0.8F);
    this.Hxy = ((Button)findViewById(2131303934));
    com.tencent.mm.ui.ao.a(this.Hxy.getPaint(), 0.8F);
    this.Hxz = ((LinearLayout)findViewById(2131303928));
    this.HxA = ((LinearLayout)findViewById(2131303977));
    this.HxB = ((LinearLayout)findViewById(2131303932));
    this.HxC = ((TextView)findViewById(2131303933));
    this.HxE = findViewById(2131303924);
    this.HxF = ((TextView)findViewById(2131303925));
    this.HxI = findViewById(2131303951);
    this.HxJ = ((CdnImageView)findViewById(2131309129));
    this.HxK = ((TextView)findViewById(2131309130));
    this.HxL = ((TextView)findViewById(2131309128));
    this.HxH = findViewById(2131303950);
    this.HxD = ((TextView)findViewById(2131303930));
    this.HxM = ((LinearLayout)findViewById(2131303953));
    this.HxN = ((TextView)findViewById(2131303954));
    this.HxO = ((TextView)findViewById(2131303937));
    this.HxP = ((TextView)findViewById(2131303955));
    this.HxQ = ((LinearLayout)findViewById(2131303935));
    this.HxR = ((TextView)findViewById(2131303936));
    this.HxS = ((WcPayMoneyLoadingView)findViewById(2131303923));
    this.zmi = ((ProgressBar)findViewById(2131310218));
    this.HxZ = ((LinearLayout)findViewById(2131303946));
    this.Hya = ((CdnImageView)findViewById(2131303947));
    this.Hyb = ((TextView)findViewById(2131303949));
    this.Hyc = ((ImageView)findViewById(2131303948));
    this.Hyd = ((WeImageView)findViewById(2131303945));
    this.HxY = ((LinearLayout)findViewById(2131303941));
    this.HxS.setLoadingPb(this.zmi);
    getLifecycle().addObserver(this.HxS);
    this.HxS.setPrefixSymbol(getString(2131768266));
    this.HxB.setVisibility(4);
    this.Hyg.alive();
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.Hxm = null;
    this.Hxn = null;
    this.Hyg.dead();
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.Hyh.dead();
    this.HxS.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    this.Hyh.alive();
    if (this.HxT) {}
    try
    {
      Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Ofv, "");
      if (!Util.isNullOrNil((String)localObject)) {
        this.Hxo = ((dhn)new dhn().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1)));
      }
      xM(true);
      bn(0, false);
      this.HxT = true;
      com.tencent.mm.kernel.g.aAi();
      if ((((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oon, Integer.valueOf(0))).intValue() == -1) && (this.Hyc.getVisibility() == 0))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "remove lqt security reddot");
        this.Hyc.setVisibility(8);
        com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(23) });
        localObject = (LinearLayout.LayoutParams)this.Hyd.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
          this.Hyd.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(68817);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
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