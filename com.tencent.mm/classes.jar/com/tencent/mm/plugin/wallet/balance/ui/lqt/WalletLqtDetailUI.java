package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aar;
import com.tencent.mm.f.a.aau;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x.e;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int tBk;
  private ProgressBar ERy;
  private w OoZ;
  private TextView OpA;
  private TextView OpB;
  private TextView OpC;
  private LinearLayout OpD;
  private TextView OpE;
  private WcPayMoneyLoadingView OpF;
  private boolean OpG;
  private boolean OpH;
  private boolean OpI;
  private boolean OpJ;
  private boolean OpK;
  private LinearLayout OpL;
  private LinearLayout OpM;
  private CdnImageView OpN;
  private TextView OpO;
  private ImageView OpP;
  private WeImageView OpQ;
  private boolean OpR;
  private boolean OpS;
  private a OpT;
  private IListener OpU;
  private IListener OpV;
  private x Opa;
  private dri Opb;
  private ViewGroup Opc;
  private TextView Opd;
  private ViewGroup Ope;
  private TextView Opf;
  private TextView Opg;
  private ViewGroup Oph;
  private TextView Opi;
  private WalletTextView Opj;
  private Button Opk;
  private Button Opl;
  private LinearLayout Opm;
  private LinearLayout Opn;
  private LinearLayout Opo;
  private TextView Opp;
  private TextView Opq;
  private View Opr;
  private TextView Ops;
  private RelativeLayout Opt;
  private View Opu;
  private View Opv;
  private CdnImageView Opw;
  private TextView Opx;
  private TextView Opy;
  private LinearLayout Opz;
  private MMHandler handler;
  private Dialog mMi;
  
  static
  {
    AppMethodBeat.i(68832);
    tBk = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.OoZ = ((w)at(w.class));
    this.Opa = ((x)ap(x.class));
    this.OpG = true;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.OpH = false;
    this.OpI = false;
    this.OpJ = false;
    this.OpK = false;
    this.OpR = false;
    this.OpS = false;
    this.OpU = new IListener() {};
    this.OpV = new IListener() {};
    AppMethodBeat.o(68814);
  }
  
  private void BG(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    label131:
    label167:
    label342:
    label377:
    int i;
    label419:
    label456:
    label627:
    label760:
    label892:
    int j;
    if (this.Opb != null)
    {
      gGi();
      this.Opc.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtN, Long.valueOf(0L))).longValue();
      Object localObject1 = this.OpF;
      Object localObject2 = com.tencent.mm.wallet_core.ui.g.formatMoney2f(com.tencent.mm.wallet_core.ui.g.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP));
      Object localObject3;
      Object localObject5;
      TextView localTextView;
      Object localObject4;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).cV((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(a.f.lqt_detail_balance_rate_hint_iv);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.Opb.TYa)) {
            break label740;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(a.f.lqt_detail_gain_balance_hint_iv);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.Opb.TYa)) {
            break label750;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.23(this);
        this.Opt.setOnClickListener((View.OnClickListener)localObject1);
        this.OpF.setOnClickListener((View.OnClickListener)localObject1);
        this.Ope.setOnClickListener(new WalletLqtDetailUI.29(this));
        this.Opf.setText(this.Opb.TXK);
        this.Opg.setText(this.Opb.TXL);
        this.Opi.setText(this.Opb.TXM);
        this.Opj.setText(com.tencent.mm.wallet_core.ui.g.F(com.tencent.mm.wallet_core.ui.g.a(this.Opb.TXN, "100", 2, RoundingMode.HALF_UP)));
        this.Oph.setOnClickListener(new WalletLqtDetailUI.30(this));
        if (Util.isNullOrNil(this.Opb.TYd)) {
          break label760;
        }
        this.OpB.setText(this.Opb.TYd);
        this.OpB.setVisibility(0);
        if (Util.isNullOrNil(this.Opb.TYj)) {
          break label771;
        }
        this.OpC.setText(this.Opb.TYj);
        this.OpC.setVisibility(0);
        this.Opm.removeAllViews();
        this.Opn.removeAllViews();
        if ((this.Opb.TYq == null) || (this.Opb.TYq.TxZ != 1)) {
          break label782;
        }
        gGj();
        if ((this.Opb.TYc == null) || (this.Opb.TYc.isEmpty())) {
          break label1177;
        }
        localObject1 = this.Opb.TYc.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1412;
        }
        localObject3 = (dcf)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_detail_bottom_info_layout, this.Opm, false);
        localObject5 = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_title_tv);
        localTextView = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_desc_tv);
        localObject4 = (CdnImageView)((ViewGroup)localObject2).findViewById(a.f.ldbi_content_icon_iv);
        View localView = ((ViewGroup)localObject2).findViewById(a.f.ldbi_divider);
        if (i == this.Opb.TYc.size() - 1)
        {
          localView.setVisibility(8);
          ((ViewGroup)localObject2).setBackgroundResource(a.e.bottom_info_layout_bg);
        }
        a((dcf)localObject3);
        ((TextView)localObject5).setText(((dcf)localObject3).title);
        localObject5 = gGm();
        if ((((dcf)localObject3).TJH == null) || (localObject5 == null)) {
          break label864;
        }
        a((JSONObject)localObject5, ((dcf)localObject3).TJH, (dcf)localObject3, (ViewGroup)localObject2);
        if (Util.isNullOrNil(((dcf)localObject3).icon)) {
          break label882;
        }
        ((CdnImageView)localObject4).setUseSdcardCache(true);
        ((CdnImageView)localObject4).setUrl(((dcf)localObject3).icon);
        ((CdnImageView)localObject4).setVisibility(0);
        label660:
        if (((dcf)localObject3).TJG != 1) {
          break label1072;
        }
        if (!"wxpay://lqt/planindex".equals(((dcf)localObject3).Eyy)) {
          break label892;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.31(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
      }
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.Opm.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label456;
        paramBoolean = false;
        break;
        label740:
        ((ImageView)localObject1).setVisibility(8);
        break label131;
        label750:
        ((ImageView)localObject1).setVisibility(8);
        break label167;
        this.OpB.setVisibility(4);
        break label342;
        label771:
        this.OpC.setVisibility(4);
        break label377;
        label782:
        if ((this.Opb.TYq == null) || (this.Opb.TYq.TxZ != 2) || (this.Opb.TYq.Tyb == null)) {
          break label419;
        }
        localObject1 = this.Opb.TYq.Tyb;
        if ((((cqs)localObject1).Tyk == null) || (((cqs)localObject1).Tyk.isEmpty()))
        {
          gGk();
          break label419;
        }
        gGl();
        break label419;
        label864:
        Q((ViewGroup)localObject2);
        localTextView.setText(((dcf)localObject3).desc);
        break label627;
        label882:
        ((CdnImageView)localObject4).setVisibility(8);
        break label660;
        if ("wxpay://lqt/autochargesetting".equals(((dcf)localObject3).Eyy))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.32(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/fixeddeposit/makeplan".equals(((dcf)localObject3).Eyy))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.33(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/fixeddeposit/planlist".equals(((dcf)localObject3).Eyy))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.34(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/spenddeposit/makeplan".equals(((dcf)localObject3).Eyy))
        {
          ((ViewGroup)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68788);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt hhc make plan");
              WalletLqtDetailUI.a(WalletLqtDetailUI.this, this.OpX, this.OpY, this.OpZ);
              paramAnonymousView = ITransmitKvData.create();
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("HHCMakePlanUseCase", paramAnonymousView, new UseCaseCallback()
              {
                public final void call(ITransmitKvData paramAnonymous2ITransmitKvData)
                {
                  AppMethodBeat.i(267606);
                  WalletLqtDetailUI.this.by(0, true);
                  AppMethodBeat.o(267606);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68788);
            }
          });
        }
        else if ("wxpay://lqt/spenddeposit/plandetail".equals(((dcf)localObject3).Eyy))
        {
          ((ViewGroup)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68789);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt hhc plan detail");
              WalletLqtDetailUI.a(WalletLqtDetailUI.this, this.OpX, this.OpY, this.OpZ);
              paramAnonymousView = ITransmitKvData.create();
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("HHCPlanDetailUseCase", paramAnonymousView, new UseCaseCallback()
              {
                public final void call(ITransmitKvData paramAnonymous2ITransmitKvData)
                {
                  AppMethodBeat.i(262115);
                  WalletLqtDetailUI.this.by(0, true);
                  AppMethodBeat.o(262115);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68789);
            }
          });
          continue;
          label1072:
          if (((dcf)localObject3).TJG == 2)
          {
            if (!Util.isNullOrNil(((dcf)localObject3).Eyy))
            {
              ((ViewGroup)localObject2).setTag(((dcf)localObject3).Eyy);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.4(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
            }
          }
          else if ((((dcf)localObject3).TJG == 3) && (!Util.isNullOrNil(((dcf)localObject3).Sba)) && (!Util.isNullOrNil(((dcf)localObject3).Eyy))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.5(this, (JSONObject)localObject5, (dcf)localObject3, (ViewGroup)localObject2));
          }
        }
      }
      label1177:
      if ((this.Opb.TXO != null) && (this.Opb.TXO.size() > 0))
      {
        localObject1 = this.Opb.TXO.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (aib)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_detail_bottom_info_layout, this.Opm, false);
          localTextView = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_title_tv);
          localObject4 = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_desc_tv);
          localObject5 = ((ViewGroup)localObject2).findViewById(a.f.ldbi_divider);
          if (i == this.Opb.TXO.size() - 1)
          {
            ((View)localObject5).setVisibility(8);
            ((ViewGroup)localObject2).setBackgroundResource(a.e.bottom_info_layout_bg);
          }
          localTextView.setText(((aib)localObject3).title);
          ((TextView)localObject4).setText(((aib)localObject3).desc);
          if (!Util.isNullOrNil(((aib)localObject3).Eyy))
          {
            ((ViewGroup)localObject2).setTag(((aib)localObject3).Eyy);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.6(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.Opm.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          i += 1;
        }
      }
      label1412:
      if (this.Opm.getChildCount() == 0)
      {
        localObject1 = findViewById(a.f.lqt_divider);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.Opb.dta > 0) {
        break label2041;
      }
      this.Opl.setEnabled(false);
      if (Util.isNullOrNil(this.Opb.TYk)) {
        break label2052;
      }
      i = 1;
      label1475:
      if ((this.Opb.TXR == null) || (Util.isNullOrNil(this.Opb.TXR.title))) {
        break label2057;
      }
      j = 1;
      label1503:
      if (i != 0)
      {
        this.OpE.setText(this.Opb.TYk);
        ar.a(this.OpE.getPaint(), 0.8F);
        com.tencent.mm.wallet_core.ui.g.bi(this.OpE, 50);
        this.OpD.setOnClickListener(new WalletLqtDetailUI.7(this));
      }
      if (j != 0)
      {
        this.Opp.setText(this.Opb.TXR.title);
        ar.a(this.Opp.getPaint(), 0.8F);
        this.Opo.setOnClickListener(new WalletLqtDetailUI.8(this));
      }
      if ((i == 0) || (j == 0)) {
        break label2062;
      }
      this.OpD.setVisibility(0);
      this.OpD.setGravity(5);
      this.Opo.setVisibility(0);
      this.Opo.setGravity(3);
      label1647:
      this.Opr.setVisibility(8);
      if ((this.Opb.TXT != null) && (!Util.isNullOrNil(this.Opb.TXT.title)))
      {
        this.Opr.setVisibility(0);
        this.Ops.setText(this.Opb.TXT.title);
        if (!Util.isNullOrNil(this.Opb.TXT.Eyy)) {
          this.Opr.setOnClickListener(new WalletLqtDetailUI.9(this));
        }
      }
      this.Opv.setVisibility(8);
      this.Opu.setVisibility(8);
      if ((this.Opb.TXU != null) && (!Util.isNullOrNil(this.Opb.TXU.username)))
      {
        this.Opw.setUrl(this.Opb.TXU.llI);
        this.Opx.setText(this.Opb.TXU.title);
        this.Opy.setText(this.Opb.TXU.desc);
        this.Opv.setOnClickListener(new WalletLqtDetailUI.10(this));
        this.Opu.setVisibility(0);
        this.Opv.setVisibility(0);
      }
      if (Util.isNullOrNil(this.Opb.Olt)) {
        break label2149;
      }
      this.Opq.setText(this.Opb.Olt);
      label1891:
      if ((this.Opb.TYg == null) || (Util.isNullOrNil(this.Opb.TYg.title))) {
        break label2197;
      }
      this.Opz.setVisibility(0);
      this.OpA.setText(this.Opb.TYg.title);
      ar.a(this.OpA.getPaint(), 0.8F);
      this.Opz.setOnClickListener(new WalletLqtDetailUI.11(this));
    }
    for (;;)
    {
      this.Opk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(219714);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          if (ac.mGN)
          {
            localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Tyg;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).gaz != 1) {
                break label274;
              }
              bool1 = true;
              label115:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXP != 1) {
                break label279;
              }
            }
            label274:
            label279:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXE);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219714);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label115;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYh != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYh.TwU) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TLU != null))
          {
            ai.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).TLU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219714);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).OlI.lf(WalletLqtDetailUI.d(WalletLqtDetailUI.this).DgI, 1);
          if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXV))
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXV });
            com.tencent.mm.wallet_core.ui.g.o(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXV, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219714);
            return;
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYh);
          }
        }
      });
      this.Opl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(272385);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYi != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYi.TwU) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TLU != null))
          {
            ai.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).TLU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(272385);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).OlH.ama(WalletLqtDetailUI.d(WalletLqtDetailUI.this).DgI);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYi);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(272385);
        }
      });
      if ((this.Opb.TwU) && (this.Opb.TLU != null)) {
        ai.a(this, this.Opb.TLU);
      }
      bXG();
      AppMethodBeat.o(68820);
      return;
      label2041:
      this.Opl.setEnabled(true);
      break;
      label2052:
      i = 0;
      break label1475;
      label2057:
      j = 0;
      break label1503;
      label2062:
      if (i != 0)
      {
        this.OpD.setVisibility(0);
        this.OpD.setGravity(17);
        this.Opo.setVisibility(8);
        break label1647;
      }
      if (j != 0)
      {
        this.OpD.setVisibility(8);
        this.Opo.setVisibility(0);
        this.Opo.setGravity(17);
        break label1647;
      }
      this.OpD.setVisibility(8);
      this.Opo.setVisibility(8);
      break label1647;
      label2149:
      if (this.Opb.DgI == 1)
      {
        this.Opq.setText(a.i.wallet_lqt_detail_bottom_sponsor_wording);
        break label1891;
      }
      if (this.Opb.DgI != 2) {
        break label1891;
      }
      this.Opq.setText(a.i.wallet_lqt_detail_bottom_sponsor_wording_2);
      break label1891;
      label2197:
      this.Opz.setVisibility(8);
    }
  }
  
  private static void Q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(277038);
    paramViewGroup.findViewById(a.f.mwsc_reddot1_title_right_iv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_reddot2_desc_right_iv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_newdot_tv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_numdot_tv).setVisibility(8);
    AppMethodBeat.o(277038);
  }
  
  private void a(dcf paramdcf)
  {
    AppMethodBeat.i(277039);
    if (paramdcf == null)
    {
      AppMethodBeat.o(277039);
      return;
    }
    if (("wxpay://lqt/fixeddeposit/makeplan".equals(paramdcf.Eyy)) || ("wxpay://lqt/fixeddeposit/planlist".equals(paramdcf.Eyy)))
    {
      if (!this.OpS)
      {
        this.OpS = true;
        com.tencent.mm.plugin.report.service.h.IzE.a(22449, new Object[] { Integer.valueOf(1) });
      }
      if ((!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtu, Boolean.FALSE)).booleanValue()) && (Util.isNullOrNil(paramdcf.desc))) {
        paramdcf.desc = getContext().getResources().getText(a.i.wallet_lqt_fixed_deposit_entrance_tips).toString();
      }
    }
    AppMethodBeat.o(277039);
  }
  
  private void a(JSONObject paramJSONObject, dvh paramdvh, dcf paramdcf, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(277037);
    boolean bool1;
    long l;
    if (paramJSONObject.optInt(paramdvh.Ubm, 0) == 1)
    {
      bool1 = true;
      l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramdvh.Ubm }), 0L);
      if ((l <= 0L) || (System.currentTimeMillis() <= l)) {
        break label447;
      }
    }
    label407:
    label447:
    for (boolean bool2 = false;; bool2 = bool1)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "show red dot: %s, red dot id: %s, red dot expired: %s, red dot type: %s", new Object[] { Boolean.valueOf(bool2), paramdvh.Ubm, Long.valueOf(l), Integer.valueOf(paramdvh.type) });
      if ((bool1) && (!bool2)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { paramdvh.Ubm, Integer.valueOf(2), "" });
      }
      Q(paramViewGroup);
      if (bool2)
      {
        paramJSONObject = (ImageView)paramViewGroup.findViewById(a.f.mwsc_reddot1_title_right_iv);
        ImageView localImageView = (ImageView)paramViewGroup.findViewById(a.f.mwsc_reddot2_desc_right_iv);
        TextView localTextView1 = (TextView)paramViewGroup.findViewById(a.f.mwsc_newdot_tv);
        TextView localTextView2 = (TextView)paramViewGroup.findViewById(a.f.mwsc_numdot_tv);
        paramViewGroup = (TextView)paramViewGroup.findViewById(a.f.lqt_detail_bottom_info_desc_tv);
        switch (paramdvh.type)
        {
        default: 
          bool2 = false;
        }
        for (;;)
        {
          if (!bool2) {
            break label407;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { paramdvh.Ubm, Integer.valueOf(1), "" });
          AppMethodBeat.o(277037);
          return;
          bool1 = false;
          break;
          if (!Util.isNullOrNil(paramdcf.desc))
          {
            paramViewGroup.setText(paramdcf.desc);
            localImageView.setVisibility(0);
          }
          else
          {
            paramJSONObject.setVisibility(0);
            continue;
            localTextView1.setVisibility(0);
            continue;
            localTextView2.setText(k.a(getContext(), paramdvh.SpR));
            localTextView2.setVisibility(0);
            continue;
            localImageView.setVisibility(0);
            k.a(paramViewGroup, paramdvh.SpR, null);
          }
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { paramdvh.Ubm, Integer.valueOf(0), "Red Dot Type returned by server is invalid." });
      }
      AppMethodBeat.o(277037);
      return;
    }
  }
  
  private void bXG()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.Opb != null)
    {
      if ((this.Opb.TYm != null) && (this.Opb.TYm.size() == 1) && (this.Opb.TXZ))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        dcf localdcf = (dcf)this.Opb.TYm.get(0);
        addTextOptionMenu(0, localdcf.title, new WalletLqtDetailUI.18(this, localdcf));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(270921);
          paramAnonymousMenuItem = new e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(270167);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  dcf localdcf = (dcf)localIterator.next();
                  if (!Util.isNullOrNil(localdcf.title)) {
                    paramAnonymous2o.d(i, localdcf.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXZ) {
                paramAnonymous2o.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(a.c.Red), WalletLqtDetailUI.this.getString(a.i.wallet_lqt_close_account));
              }
              AppMethodBeat.o(270167);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(247703);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).TXZ))
              {
                if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYe)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYe;
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(a.i.close_btn), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(246199);
                      WalletLqtDetailUI.i(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(246199);
                    }
                  });
                  AppMethodBeat.o(247703);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).DgI == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_close_alert_wording);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(a.i.wallet_lqb_close_alert_wording);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm.size()))
              {
                paramAnonymous2MenuItem = (dcf)WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYm.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.TJG != 1) {
                  if (paramAnonymous2MenuItem.TJG == 2)
                  {
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.Eyy))
                    {
                      com.tencent.mm.wallet_core.ui.g.o(WalletLqtDetailUI.this, paramAnonymous2MenuItem.Eyy, false);
                      AppMethodBeat.o(247703);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.TJG == 3) && (!Util.isNullOrNil(paramAnonymous2MenuItem.Sba)) && (!Util.isNullOrNil(paramAnonymous2MenuItem.Eyy))) {
                    com.tencent.mm.wallet_core.ui.g.v(paramAnonymous2MenuItem.Sba, paramAnonymous2MenuItem.Eyy, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(247703);
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(270921);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private void bgt(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.Opb != null)
    {
      str = this.Opb.Tyg;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.Opb.gaz != 1) {
        break label270;
      }
      bool1 = true;
      label80:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.Opb.TXP != 1) {
        break label275;
      }
    }
    label270:
    label275:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", gGh());
      localIntent.putExtra("lqt_profile_wording", this.Opb.TXE);
      localIntent.putExtra("lqt_account_type", this.Opb.DgI);
      localIntent.putExtra("lqt_fund_spid", this.Opb.Tyf);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  private void bgu(String paramString)
  {
    AppMethodBeat.i(68822);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.Opb.dta);
    localIntent.putExtra("lqt_max_redeem_amount", this.Opb.TXW);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.Opb.TXX);
    localIntent.putExtra("lqt_account_type", this.Opb.DgI);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private ArrayList<String> gGh()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.Opb.TXQ != null) && (this.Opb.TXQ.size() > 0))
    {
      Iterator localIterator = this.Opb.TXQ.iterator();
      while (localIterator.hasNext())
      {
        aib localaib = (aib)localIterator.next();
        if ((!Util.isNullOrNil(localaib.title)) && (!Util.isNullOrNil(localaib.Eyy))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localaib.title, localaib.Eyy }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void gGi()
  {
    AppMethodBeat.i(277029);
    if (this.Opb.TYr == null)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "svr not return data, hide security entry");
      this.OpM.setVisibility(8);
      AppMethodBeat.o(277029);
      return;
    }
    Log.i("MicroMsg.WalletLqtDetailUI", "show lqt security entry with svr data");
    this.OpM.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if (!Util.isNullOrNil(this.Opb.TYr.icon))
    {
      this.OpN.setVisibility(0);
      this.OpN.setUrl(this.Opb.TYr.icon);
      this.OpO.setText(this.Opb.TYr.title);
      localLayoutParams = (LinearLayout.LayoutParams)this.OpL.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
        this.OpL.setLayoutParams(localLayoutParams);
      }
      com.tencent.mm.kernel.h.aHH();
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDG, Integer.valueOf(0))).intValue();
      if (i != 0) {
        break label356;
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDG, Integer.valueOf(cm.bfF()));
      i = 1;
      label207:
      localLayoutParams = (LinearLayout.LayoutParams)this.OpQ.getLayoutParams();
      if (i == 0) {
        break label433;
      }
      this.OpP.setVisibility(0);
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
        this.OpQ.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      if (!this.OpR)
      {
        this.OpR = true;
        com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(20) });
        Log.i("MicroMsg.WalletLqtDetailUI", "report show security entry");
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(22) });
        }
      }
      this.OpM.setOnClickListener(new WalletLqtDetailUI.22(this));
      AppMethodBeat.o(277029);
      return;
      this.OpN.setVisibility(8);
      break;
      label356:
      if (i > 0)
      {
        if (cm.bfF() - i >= 604800L)
        {
          Log.i("MicroMsg.WalletLqtDetailUI", "reddot has display above 7 day, hide it");
          com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(24) });
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
      this.OpP.setVisibility(8);
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 4);
        this.OpQ.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void gGj()
  {
    AppMethodBeat.i(277030);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.OpI)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(10) });
      this.OpI = true;
      Log.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout, this.Opn, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_tips_title);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_tips_desc);
    localTextView1.setText(this.Opb.TYq.Tya.title);
    localTextView2.setText(this.Opb.TYq.Tya.desc);
    if (this.Opb.TYq.Tya.TJG != 1)
    {
      if (this.Opb.TYq.Tya.TJG != 2) {
        break label230;
      }
      if (!Util.isNullOrNil(this.Opb.TYq.Tya.Eyy))
      {
        localViewGroup.setTag(this.Opb.TYq.Tya.Eyy);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.24(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.Opn.addView(localViewGroup);
      AppMethodBeat.o(277030);
      return;
      label230:
      if ((this.Opb.TYq.Tya.TJG == 3) && (!Util.isNullOrNil(this.Opb.TYq.Tya.Sba)) && (!Util.isNullOrNil(this.Opb.TYq.Tya.Eyy))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.25(this));
      }
    }
  }
  
  private void gGk()
  {
    AppMethodBeat.i(277031);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView2");
    Object localObject;
    ViewGroup localViewGroup;
    CdnImageView localCdnImageView;
    TextView localTextView;
    if (this.Opb.TYq.Tyb.Tyj != null)
    {
      if (!this.OpJ)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        this.OpJ = true;
      }
      localObject = this.Opb.TYq.Tyb.Tyj;
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout2, this.Opn, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(a.f.lqt_lct_operation_icon_iv);
      localTextView = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_title_tv);
      if (Util.isNullOrNil(((dcf)localObject).icon)) {
        break label220;
      }
      localCdnImageView.setUrl(((dcf)localObject).icon);
      localCdnImageView.setVisibility(0);
    }
    for (;;)
    {
      localTextView.setText(((dcf)localObject).title);
      localViewGroup.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(273341);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtZ, Boolean.FALSE)).booleanValue();
          if (this.OpY.TJG == 2) {
            if (!Util.isNullOrNil(this.OpY.Eyy))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.OpY.Eyy);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.r.VSX, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title);
              }
              com.tencent.mm.wallet_core.ui.g.aJ(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(273341);
            return;
            if ((this.OpY.TJG == 3) && (!Util.isNullOrNil(this.OpY.Sba)) && (!Util.isNullOrNil(this.OpY.Eyy)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.OpY.Sba;
              paramAnonymousView.nBq = this.OpY.Eyy;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.nBL = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.nBM = str1;
                localWeAppOpenDeclarePromptBundle.nBN = str2;
                localWeAppOpenDeclarePromptBundle.bxO = false;
                paramAnonymousView.nBC = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
        }
      });
      localObject = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
      this.Opn.addView(localViewGroup, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(277031);
      return;
      label220:
      localCdnImageView.setVisibility(8);
    }
  }
  
  private void gGl()
  {
    AppMethodBeat.i(277033);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView3");
    Object localObject2;
    Object localObject1;
    ViewGroup localViewGroup1;
    Object localObject3;
    TextView localTextView1;
    if (this.Opb.TYq.Tyb.Tyj != null)
    {
      if (!this.OpK)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        this.OpK = true;
      }
      localObject2 = this.Opb.TYq.Tyb.Tyj;
      localObject1 = (cqr)this.Opb.TYq.Tyb.Tyk.get(0);
      localViewGroup1 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout3, this.Opn, false);
      localObject3 = (CdnImageView)localViewGroup1.findViewById(a.f.lqt_lct_operation_icon_iv);
      localTextView1 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_title_tv);
      if (Util.isNullOrNil(((dcf)localObject2).icon)) {
        break label357;
      }
      ((CdnImageView)localObject3).setUrl(((dcf)localObject2).icon);
      ((CdnImageView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      localTextView1.setText(((dcf)localObject2).title);
      localViewGroup1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(188603);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtZ, Boolean.FALSE)).booleanValue();
          if (this.OpY.TJG == 2) {
            if (!Util.isNullOrNil(this.OpY.Eyy))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.OpY.Eyy);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.r.VSX, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title);
              }
              com.tencent.mm.wallet_core.ui.g.aJ(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Oqi.Tyf, this.Oqi.Tyg, this.Oqi.Tyh, this.Oqi.Tyi, Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(188603);
            return;
            if ((this.OpY.TJG == 3) && (!Util.isNullOrNil(this.OpY.Sba)) && (!Util.isNullOrNil(this.OpY.Eyy)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.OpY.Sba;
              paramAnonymousView.nBq = this.OpY.Eyy;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.nBL = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.nBM = str1;
                localWeAppOpenDeclarePromptBundle.nBN = str2;
                localWeAppOpenDeclarePromptBundle.bxO = false;
                paramAnonymousView.nBC = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Oqi.Tyf, this.Oqi.Tyg, this.Oqi.Tyh, this.Oqi.Tyi, Integer.valueOf(1) });
            }
          }
        }
      });
      localObject2 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_name_tv);
      localObject3 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_desc_tv);
      localTextView1 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_profit_tv);
      TextView localTextView2 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_profit_desc_tv);
      ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_layout);
      ((TextView)localObject2).setText(((cqr)localObject1).name);
      ((TextView)localObject3).setText(((cqr)localObject1).desc);
      localTextView1.setText(((cqr)localObject1).Tyc);
      localTextView2.setText(((cqr)localObject1).Tyd);
      localViewGroup2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276053);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtZ, Boolean.FALSE)).booleanValue();
          if (this.Oqi.Tye == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(276053);
            return;
          }
          if (this.Oqi.Tye.TJG == 2) {
            if (!Util.isNullOrNil(this.Oqi.Tye.url))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Oqi.Tye.url);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.r.VSX, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title);
              }
              com.tencent.mm.wallet_core.ui.g.aJ(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Oqi.Tyf, this.Oqi.Tyg, this.Oqi.Tyh, this.Oqi.Tyi, Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(276053);
            return;
            if ((this.Oqi.Tye.TJG == 3) && (!Util.isNullOrNil(this.Oqi.Tye.Sba)) && (!Util.isNullOrNil(this.Oqi.Tye.url)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Oqi.Tye.Sba;
              paramAnonymousView.nBq = this.Oqi.Tye.url;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).TYq.Tyb.Tyl.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.nBL = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.nBM = str1;
                localWeAppOpenDeclarePromptBundle.nBN = str2;
                localWeAppOpenDeclarePromptBundle.bxO = false;
                paramAnonymousView.nBC = localWeAppOpenDeclarePromptBundle;
              }
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtZ, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Oqi.Tyf, this.Oqi.Tyg, this.Oqi.Tyh, this.Oqi.Tyi, Integer.valueOf(2) });
            }
          }
        }
      });
      localObject1 = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
      this.Opn.addView(localViewGroup1, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(277033);
      return;
      label357:
      ((CdnImageView)localObject3).setVisibility(8);
    }
  }
  
  private static JSONObject gGm()
  {
    AppMethodBeat.i(277035);
    com.tencent.mm.kernel.h.aHH();
    Object localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtp, "");
    if (!Util.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        AppMethodBeat.o(277035);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localJSONException, "", new Object[0]);
      }
      Object localObject2 = null;
    }
  }
  
  public final void by(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(277025);
    Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.Opa == null)
    {
      AppMethodBeat.o(277025);
      return;
    }
    if (paramBoolean)
    {
      if (this.mMi != null) {
        break label106;
      }
      this.mMi = i.c(this, false, null);
    }
    for (;;)
    {
      this.Opa.OlF.bwy().f(new com.tencent.mm.vending.c.a()
      {
        private Void a(dri paramAnonymousdri)
        {
          AppMethodBeat.i(68798);
          if (paramAnonymousdri != null)
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymousdri.DgI), Boolean.valueOf(paramAnonymousdri.TXZ) });
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymousdri);
            WalletLqtDetailUI.b(WalletLqtDetailUI.this);
            WalletLqtDetailUI.c(WalletLqtDetailUI.this);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
          }
          for (;;)
          {
            try
            {
              paramAnonymousdri = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
              ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VtH, paramAnonymousdri);
              if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
                WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
              }
              paramAnonymousdri = YAb;
              AppMethodBeat.o(68798);
              return paramAnonymousdri;
            }
            catch (IOException paramAnonymousdri)
            {
              Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymousdri, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
          }
        }
      }).a(new d.a()
      {
        public final void cm(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68787);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
          int i = paramInt - 1;
          if (i > 0)
          {
            WalletLqtDetailUI.this.by(i, false);
            AppMethodBeat.o(68787);
            return;
          }
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label100;
            }
          }
          label100:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_network_error))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(68787);
            return;
          }
        }
      });
      AppMethodBeat.o(277025);
      return;
      label106:
      this.mMi.show();
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_lqt_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.OpG = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.mMi != null) {
        break label118;
      }
      this.mMi = i.c(this, false, null);
    }
    for (;;)
    {
      x.a locala = this.Opa.OlG;
      com.tencent.mm.vending.g.g.H(paramIntent, Integer.valueOf(this.Opb.DgI)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void cm(Object paramAnonymousObject)
        {
          AppMethodBeat.i(271215);
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
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_network_error))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(271215);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.mMi.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68815);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.wallet_lqt_detail_bg));
    setActionbarElementColor(getResources().getColor(a.c.White));
    hideActionbarLine();
    setMMTitle("");
    this.OpT = new a(this);
    Log.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.Opc = ((ViewGroup)findViewById(a.f.detail_container_ll));
    this.Opd = ((TextView)findViewById(a.f.lqt_detail_title_tv));
    ar.a(this.Opd.getPaint(), 0.8F);
    this.Opt = ((RelativeLayout)findViewById(a.f.lqt_detail_balance_title_layout));
    this.Ope = ((ViewGroup)findViewById(a.f.detail_balance_layout));
    this.Opf = ((TextView)findViewById(a.f.lqt_detail_balance_rate_hint_tv));
    this.Opg = ((TextView)findViewById(a.f.lqt_detail_balance_rate_tv));
    this.Oph = ((ViewGroup)findViewById(a.f.detail_gain_balance_layout));
    this.Opi = ((TextView)findViewById(a.f.lqt_detail_gain_balance_hint_tv));
    this.Opj = ((WalletTextView)findViewById(a.f.lqt_detail_gain_balance_tv));
    this.Opk = ((Button)findViewById(a.f.lqt_detail_save_btn));
    ar.a(this.Opk.getPaint(), 0.8F);
    this.Opl = ((Button)findViewById(a.f.lqt_detail_fetch_btn));
    ar.a(this.Opl.getPaint(), 0.8F);
    this.Opm = ((LinearLayout)findViewById(a.f.lqt_detail_bottom_info_layout));
    this.Opn = ((LinearLayout)findViewById(a.f.lqt_lct_operation_layout));
    this.Opo = ((LinearLayout)findViewById(a.f.lqt_detail_faq_link_ll));
    this.Opp = ((TextView)findViewById(a.f.lqt_detail_faq_link_tv));
    this.Opr = findViewById(a.f.lqt_detail_banner_ll);
    this.Ops = ((TextView)findViewById(a.f.lqt_detail_banner_text));
    this.Opv = findViewById(a.f.lqt_detail_tiny_app_ll);
    this.Opw = ((CdnImageView)findViewById(a.f.tiny_app_logo));
    this.Opx = ((TextView)findViewById(a.f.tiny_app_name));
    this.Opy = ((TextView)findViewById(a.f.tiny_app_desc));
    this.Opu = findViewById(a.f.lqt_detail_tiny_app_gap);
    this.Opq = ((TextView)findViewById(a.f.lqt_detail_bottom_sponsor_tv));
    this.Opz = ((LinearLayout)findViewById(a.f.lqt_detail_top_biz_layout));
    this.OpA = ((TextView)findViewById(a.f.lqt_detail_top_biz_tv));
    this.OpB = ((TextView)findViewById(a.f.lqt_detail_fundname_tv));
    this.OpC = ((TextView)findViewById(a.f.lqt_detail_yesterday_rate_tv));
    this.OpD = ((LinearLayout)findViewById(a.f.lqt_detail_financial_info_ll));
    this.OpE = ((TextView)findViewById(a.f.lqt_detail_financial_info_tv));
    this.OpF = ((WcPayMoneyLoadingView)findViewById(a.f.lqt_detail_balance_view));
    this.ERy = ((ProgressBar)findViewById(a.f.wallet_money_load_pb));
    this.OpM = ((LinearLayout)findViewById(a.f.lqt_detail_security_container));
    this.OpN = ((CdnImageView)findViewById(a.f.lqt_detail_security_icon));
    this.OpO = ((TextView)findViewById(a.f.lqt_detail_security_title_tv));
    this.OpP = ((ImageView)findViewById(a.f.lqt_detail_security_reddot));
    this.OpQ = ((WeImageView)findViewById(a.f.lqt_detail_security_arrow));
    this.OpL = ((LinearLayout)findViewById(a.f.lqt_detail_inner_container));
    this.OpF.setLoadingPb(this.ERy);
    getLifecycle().a(this.OpF);
    this.OpF.setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    this.Opo.setVisibility(4);
    this.OpU.alive();
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.OoZ = null;
    this.Opa = null;
    this.OpU.dead();
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.OpV.dead();
    this.OpF.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    this.OpV.alive();
    if (this.OpG) {}
    for (;;)
    {
      try
      {
        String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtH, "");
        if (!Util.isNullOrNil(str)) {
          this.Opb = ((dri)new dri().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
        }
        BG(true);
        by(0, false);
        this.OpG = true;
        AppMethodBeat.o(68817);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
        continue;
      }
      com.tencent.mm.kernel.h.aHH();
      if ((((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDG, Integer.valueOf(0))).intValue() == -1) && (this.OpP.getVisibility() == 0))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "remove lqt security reddot");
        this.OpP.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.OpQ.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 4);
          this.OpQ.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */