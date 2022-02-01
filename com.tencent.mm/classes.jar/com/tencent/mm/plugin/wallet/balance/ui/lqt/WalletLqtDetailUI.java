package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import androidx.lifecycle.q;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aco;
import com.tencent.mm.autogen.a.acr;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aj;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y.e;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpayreport.a.b.a;
import com.tencent.mm.plugin.wxpayreport.a.c.a;
import com.tencent.mm.plugin.wxpayreport.j.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.protocal.protobuf.ful;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int wFJ;
  private ProgressBar KLX;
  private x VdR;
  private y VdS;
  private ekd VdT;
  private ViewGroup VdU;
  private TextView VdV;
  private ViewGroup VdW;
  private TextView VdX;
  private ViewGroup VdY;
  private TextView VdZ;
  private TextView VeA;
  private TextView VeB;
  private LinearLayout VeC;
  private TextView VeD;
  private WcPayMoneyLoadingView VeE;
  private boolean VeF;
  private boolean VeG;
  private boolean VeH;
  private boolean VeI;
  private boolean VeJ;
  private LinearLayout VeK;
  private LinearLayout VeL;
  private CdnImageView VeM;
  private TextView VeN;
  private ImageView VeO;
  private WeImageView VeP;
  private boolean VeQ;
  private boolean VeR;
  private a VeS;
  private LinearLayout VeT;
  private LinearLayout VeU;
  private boolean VeV;
  private com.tencent.mm.ui.widget.a.j VeW;
  private IListener VeX;
  private IListener VeY;
  private TextView Vea;
  private ViewGroup Veb;
  private TextView Vec;
  private WalletTextView Ved;
  private Button Vee;
  private Button Vef;
  private LinearLayout Veg;
  private LinearLayout Veh;
  private LinearLayout Vei;
  private TextView Vej;
  private TextView Vek;
  private LinearLayout Vel;
  private TextView Vem;
  private View Ven;
  private TextView Veo;
  private RelativeLayout Vep;
  private View Veq;
  private TextView Ver;
  private WeImageView Ves;
  private View Vet;
  private View Veu;
  private CdnImageView Vev;
  private TextView Vew;
  private TextView Vex;
  private LinearLayout Vey;
  private TextView Vez;
  private MMHandler handler;
  private Dialog pIQ;
  
  static
  {
    AppMethodBeat.i(68832);
    wFJ = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.VdR = ((x)aM(x.class));
    this.VdS = ((y)aI(y.class));
    this.VeF = true;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.VeG = false;
    this.VeH = false;
    this.VeI = false;
    this.VeJ = false;
    this.VeQ = false;
    this.VeR = false;
    this.VeV = false;
    this.VeX = new IListener(com.tencent.mm.app.f.hfK) {};
    this.VeY = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(68814);
  }
  
  private void Hl(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    label139:
    label175:
    label341:
    label376:
    int i;
    label418:
    label455:
    label626:
    label759:
    label891:
    int j;
    label659:
    label739:
    label749:
    label881:
    int k;
    if (this.VdT != null)
    {
      ifi();
      if (!paramBoolean) {
        ifj();
      }
      this.VdU.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVs, Long.valueOf(0L))).longValue();
      Object localObject1 = this.VeE;
      Object localObject2 = i.formatMoney2f(i.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP));
      Object localObject3;
      Object localObject5;
      TextView localTextView;
      Object localObject4;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).dD((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(a.f.lqt_detail_balance_rate_hint_iv);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.VdT.aboS)) {
            break label739;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(a.f.lqt_detail_gain_balance_hint_iv);
        if (localObject1 != null)
        {
          if (Util.isNullOrNil(this.VdT.aboS)) {
            break label749;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.21(this);
        this.VeU.setOnClickListener((View.OnClickListener)localObject1);
        this.VdY.setOnClickListener(new WalletLqtDetailUI.33(this));
        this.VdZ.setText(this.VdT.aboC);
        this.Vea.setText(this.VdT.aboD);
        this.Vec.setText(this.VdT.aboE);
        this.Ved.setText(i.X(i.a(this.VdT.aboF, "100", 2, RoundingMode.HALF_UP)));
        this.Veb.setOnClickListener(new WalletLqtDetailUI.34(this));
        if (Util.isNullOrNil(this.VdT.aboV)) {
          break label759;
        }
        this.VeA.setText(this.VdT.aboV);
        this.VeA.setVisibility(0);
        if (Util.isNullOrNil(this.VdT.abpb)) {
          break label770;
        }
        this.VeB.setText(this.VdT.abpb);
        this.VeB.setVisibility(0);
        this.Veg.removeAllViews();
        this.Veh.removeAllViews();
        if ((this.VdT.abpi == null) || (this.VdT.abpi.aaMG != 1)) {
          break label781;
        }
        ifk();
        if ((this.VdT.aboU == null) || (this.VdT.aboU.isEmpty())) {
          break label1176;
        }
        localObject1 = this.VdT.aboU.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1411;
        }
        localObject3 = (dtx)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_detail_bottom_info_layout, this.Veg, false);
        localObject5 = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_title_tv);
        localTextView = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_desc_tv);
        localObject4 = (CdnImageView)((ViewGroup)localObject2).findViewById(a.f.ldbi_content_icon_iv);
        View localView = ((ViewGroup)localObject2).findViewById(a.f.ldbi_divider);
        if (i == this.VdT.aboU.size() - 1)
        {
          localView.setVisibility(8);
          ((ViewGroup)localObject2).setBackgroundResource(a.e.bottom_info_layout_bg);
        }
        a((dtx)localObject3);
        ((TextView)localObject5).setText(((dtx)localObject3).title);
        localObject5 = ifn();
        if ((((dtx)localObject3).aaZw == null) || (localObject5 == null)) {
          break label863;
        }
        a((JSONObject)localObject5, ((dtx)localObject3).aaZw, (dtx)localObject3, (ViewGroup)localObject2);
        if (Util.isNullOrNil(((dtx)localObject3).icon)) {
          break label881;
        }
        ((CdnImageView)localObject4).setUseSdcardCache(true);
        ((CdnImageView)localObject4).setUrl(((dtx)localObject3).icon);
        ((CdnImageView)localObject4).setVisibility(0);
        if (((dtx)localObject3).aaZv != 1) {
          break label1071;
        }
        if (!"wxpay://lqt/planindex".equals(((dtx)localObject3).Krl)) {
          break label891;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.35(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
      }
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.Veg.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label455;
        paramBoolean = false;
        break;
        ((ImageView)localObject1).setVisibility(8);
        break label139;
        ((ImageView)localObject1).setVisibility(8);
        break label175;
        this.VeA.setVisibility(4);
        break label341;
        label770:
        this.VeB.setVisibility(4);
        break label376;
        label781:
        if ((this.VdT.abpi == null) || (this.VdT.abpi.aaMG != 2) || (this.VdT.abpi.aaMI == null)) {
          break label418;
        }
        localObject1 = this.VdT.abpi.aaMI;
        if ((((dhm)localObject1).aaMR == null) || (((dhm)localObject1).aaMR.isEmpty()))
        {
          ifl();
          break label418;
        }
        ifm();
        break label418;
        label863:
        aa((ViewGroup)localObject2);
        localTextView.setText(((dtx)localObject3).desc);
        break label626;
        ((CdnImageView)localObject4).setVisibility(8);
        break label659;
        if ("wxpay://lqt/autochargesetting".equals(((dtx)localObject3).Krl))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.36(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/fixeddeposit/makeplan".equals(((dtx)localObject3).Krl))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.37(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/fixeddeposit/planlist".equals(((dtx)localObject3).Krl))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.38(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
        }
        else if ("wxpay://lqt/spenddeposit/makeplan".equals(((dtx)localObject3).Krl))
        {
          ((ViewGroup)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68788);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt hhc make plan");
              WalletLqtDetailUI.a(WalletLqtDetailUI.this, this.Vfb, this.Vfc, this.Vfd);
              paramAnonymousView = ITransmitKvData.create();
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("HHCMakePlanUseCase", paramAnonymousView, new UseCaseCallback()
              {
                public final void call(ITransmitKvData paramAnonymous2ITransmitKvData)
                {
                  AppMethodBeat.i(316375);
                  WalletLqtDetailUI.this.cg(0, true);
                  AppMethodBeat.o(316375);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68788);
            }
          });
        }
        else if ("wxpay://lqt/spenddeposit/plandetail".equals(((dtx)localObject3).Krl))
        {
          ((ViewGroup)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68789);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt hhc plan detail");
              WalletLqtDetailUI.a(WalletLqtDetailUI.this, this.Vfb, this.Vfc, this.Vfd);
              paramAnonymousView = ITransmitKvData.create();
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("HHCPlanDetailUseCase", paramAnonymousView, new UseCaseCallback()
              {
                public final void call(ITransmitKvData paramAnonymous2ITransmitKvData)
                {
                  AppMethodBeat.i(316459);
                  WalletLqtDetailUI.this.cg(0, true);
                  AppMethodBeat.o(316459);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68789);
            }
          });
          continue;
          label1071:
          if (((dtx)localObject3).aaZv == 2)
          {
            if (!Util.isNullOrNil(((dtx)localObject3).Krl))
            {
              ((ViewGroup)localObject2).setTag(((dtx)localObject3).Krl);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.4(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
            }
          }
          else if ((((dtx)localObject3).aaZv == 3) && (!Util.isNullOrNil(((dtx)localObject3).YYZ)) && (!Util.isNullOrNil(((dtx)localObject3).Krl))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.5(this, (JSONObject)localObject5, (dtx)localObject3, (ViewGroup)localObject2));
          }
        }
      }
      label1176:
      if ((this.VdT.aboG != null) && (this.VdT.aboG.size() > 0))
      {
        localObject1 = this.VdT.aboG.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (aku)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_detail_bottom_info_layout, this.Veg, false);
          localTextView = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_title_tv);
          localObject4 = (TextView)((ViewGroup)localObject2).findViewById(a.f.lqt_detail_bottom_info_desc_tv);
          localObject5 = ((ViewGroup)localObject2).findViewById(a.f.ldbi_divider);
          if (i == this.VdT.aboG.size() - 1)
          {
            ((View)localObject5).setVisibility(8);
            ((ViewGroup)localObject2).setBackgroundResource(a.e.bottom_info_layout_bg);
          }
          localTextView.setText(((aku)localObject3).title);
          ((TextView)localObject4).setText(((aku)localObject3).desc);
          if (!Util.isNullOrNil(((aku)localObject3).Krl))
          {
            ((ViewGroup)localObject2).setTag(((aku)localObject3).Krl);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.6(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.Veg.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          i += 1;
        }
      }
      label1411:
      if (this.Veg.getChildCount() == 0)
      {
        localObject1 = findViewById(a.f.lqt_divider);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (!this.VdT.abpm) {
        break label2169;
      }
      this.Vef.setEnabled(false);
      if (!this.VdT.abpl) {
        break label2180;
      }
      this.Vee.setEnabled(false);
      label1477:
      if (this.VdT.ftr <= 0) {
        this.Vef.setEnabled(false);
      }
      if (Util.isNullOrNil(this.VdT.abpc)) {
        break label2191;
      }
      i = 1;
      label1510:
      if ((this.VdT.aboJ == null) || (Util.isNullOrNil(this.VdT.aboJ.title))) {
        break label2196;
      }
      j = 1;
      label1538:
      if ((this.VdT.abpn == null) || (Util.isNullOrNil(this.VdT.abpn.Zna))) {
        break label2201;
      }
      k = 1;
      label1567:
      if (i == 0) {
        break label2207;
      }
      this.VeD.setText(this.VdT.abpc);
      aw.a(this.VeD.getPaint(), 0.8F);
      i.bG(this.VeD, 50);
      this.VeC.setOnClickListener(new WalletLqtDetailUI.7(this));
      this.VeC.setVisibility(0);
      label1630:
      if (j == 0) {
        break label2219;
      }
      this.Vej.setText(this.VdT.aboJ.title);
      aw.a(this.Vej.getPaint(), 0.8F);
      this.Vei.setOnClickListener(new WalletLqtDetailUI.8(this));
      this.Vei.setVisibility(0);
      label1687:
      if (k == 0) {
        break label2231;
      }
      this.Vem.setText(this.VdT.abpn.Zna);
      aw.a(this.Vem.getPaint(), 0.8F);
      this.Vel.setOnClickListener(new WalletLqtDetailUI.9(this));
      this.Vel.setVisibility(0);
      label1745:
      this.Ven.setVisibility(8);
      if ((this.VdT.aboL == null) || (Util.isNullOrNil(this.VdT.aboL.title))) {
        break label2243;
      }
      this.Ven.setVisibility(0);
      this.Veo.setText(this.VdT.aboL.title);
      this.Ven.sendAccessibilityEvent(128);
      if (!Util.isNullOrNil(this.VdT.aboL.Krl)) {
        this.Ven.setOnClickListener(new WalletLqtDetailUI.10(this));
      }
      label1846:
      ifh();
      this.Veu.setVisibility(8);
      this.Vet.setVisibility(8);
      if ((this.VdT.aboM != null) && (!Util.isNullOrNil(this.VdT.aboM.username)))
      {
        this.Vev.setUrl(this.VdT.aboM.nQG);
        this.Vew.setText(this.VdT.aboM.title);
        this.Vex.setText(this.VdT.aboM.desc);
        this.Veu.setOnClickListener(new WalletLqtDetailUI.11(this));
        this.Vet.setVisibility(0);
        this.Veu.setVisibility(0);
      }
      if (Util.isNullOrNil(this.VdT.UZW)) {
        break label2256;
      }
      this.Vek.setText(this.VdT.UZW);
      label2003:
      if ((this.VdT.aboY == null) || (Util.isNullOrNil(this.VdT.aboY.title))) {
        break label2304;
      }
      this.Vey.setVisibility(0);
      this.Vez.setText(this.VdT.aboY.title);
      aw.a(this.Vez.getPaint(), 0.8F);
      this.Vey.setOnClickListener(new WalletLqtDetailUI.13(this));
    }
    for (;;)
    {
      this.Vee.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(316480);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (z.pDn)
          {
            localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).aaMN;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).igI != 1) {
                break label274;
              }
              bool1 = true;
              label115:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboH != 1) {
                break label279;
              }
            }
            label274:
            label279:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abow);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(316480);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label115;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboZ != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboZ.aaLz) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abce != null))
          {
            aj.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).abce);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316480);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).Vao.mQ(WalletLqtDetailUI.d(WalletLqtDetailUI.this).JaC, 1);
          if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboN))
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboN });
            i.o(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboN, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316480);
            return;
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboZ);
          }
        }
      });
      this.Vef.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316467);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpa != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpa.aaLz) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abce != null))
          {
            aj.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).abce);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316467);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).Van.arJ(WalletLqtDetailUI.d(WalletLqtDetailUI.this).JaC);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpa);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(316467);
        }
      });
      if ((this.VdT.aaLz) && (this.VdT.abce != null)) {
        aj.a(this, this.VdT.abce);
      }
      cxR();
      ((a)component(a.class)).b(this.VdT);
      AppMethodBeat.o(68820);
      return;
      label2169:
      this.Vef.setEnabled(true);
      break;
      label2180:
      this.Vee.setEnabled(true);
      break label1477;
      label2191:
      i = 0;
      break label1510;
      label2196:
      j = 0;
      break label1538;
      label2201:
      k = 0;
      break label1567;
      label2207:
      this.VeC.setVisibility(8);
      break label1630;
      label2219:
      this.Vei.setVisibility(8);
      break label1687;
      label2231:
      this.Vel.setVisibility(8);
      break label1745;
      label2243:
      this.VeT.sendAccessibilityEvent(128);
      break label1846;
      label2256:
      if (this.VdT.JaC == 1)
      {
        this.Vek.setText(a.i.wallet_lqt_detail_bottom_sponsor_wording);
        break label2003;
      }
      if (this.VdT.JaC != 2) {
        break label2003;
      }
      this.Vek.setText(a.i.wallet_lqt_detail_bottom_sponsor_wording_2);
      break label2003;
      label2304:
      this.Vey.setVisibility(8);
    }
  }
  
  private void a(dtx paramdtx)
  {
    AppMethodBeat.i(316548);
    if (paramdtx == null)
    {
      AppMethodBeat.o(316548);
      return;
    }
    if (("wxpay://lqt/fixeddeposit/makeplan".equals(paramdtx.Krl)) || ("wxpay://lqt/fixeddeposit/planlist".equals(paramdtx.Krl)))
    {
      if (!this.VeR)
      {
        this.VeR = true;
        com.tencent.mm.plugin.report.service.h.OAn.b(22449, new Object[] { Integer.valueOf(1) });
      }
      if ((!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUZ, Boolean.FALSE)).booleanValue()) && (Util.isNullOrNil(paramdtx.desc))) {
        paramdtx.desc = getContext().getResources().getText(a.i.wallet_lqt_fixed_deposit_entrance_tips).toString();
      }
    }
    AppMethodBeat.o(316548);
  }
  
  private void a(JSONObject paramJSONObject, eod parameod, dtx paramdtx, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(316543);
    boolean bool1;
    long l;
    if (paramJSONObject.optInt(parameod.abst, 0) == 1)
    {
      bool1 = true;
      l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { parameod.abst }), 0L);
      if ((l <= 0L) || (System.currentTimeMillis() <= l)) {
        break label447;
      }
    }
    label407:
    label447:
    for (boolean bool2 = false;; bool2 = bool1)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "show red dot: %s, red dot id: %s, red dot expired: %s, red dot type: %s", new Object[] { Boolean.valueOf(bool2), parameod.abst, Long.valueOf(l), Integer.valueOf(parameod.type) });
      if ((bool1) && (!bool2)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { parameod.abst, Integer.valueOf(2), "" });
      }
      aa(paramViewGroup);
      if (bool2)
      {
        paramJSONObject = (ImageView)paramViewGroup.findViewById(a.f.mwsc_reddot1_title_right_iv);
        ImageView localImageView = (ImageView)paramViewGroup.findViewById(a.f.mwsc_reddot2_desc_right_iv);
        TextView localTextView1 = (TextView)paramViewGroup.findViewById(a.f.mwsc_newdot_tv);
        TextView localTextView2 = (TextView)paramViewGroup.findViewById(a.f.mwsc_numdot_tv);
        paramViewGroup = (TextView)paramViewGroup.findViewById(a.f.lqt_detail_bottom_info_desc_tv);
        switch (parameod.type)
        {
        default: 
          bool2 = false;
        }
        for (;;)
        {
          if (!bool2) {
            break label407;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { parameod.abst, Integer.valueOf(1), "" });
          AppMethodBeat.o(316543);
          return;
          bool1 = false;
          break;
          if (!Util.isNullOrNil(paramdtx.desc))
          {
            paramViewGroup.setText(paramdtx.desc);
            localImageView.setVisibility(0);
          }
          else
          {
            paramJSONObject.setVisibility(0);
            continue;
            localTextView1.setVisibility(0);
            continue;
            localTextView2.setText(n.a(getContext(), parameod.ZoM));
            localTextView2.setVisibility(0);
            continue;
            localImageView.setVisibility(0);
            n.a(paramViewGroup, parameod.ZoM, null);
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { parameod.abst, Integer.valueOf(0), "Red Dot Type returned by server is invalid." });
      }
      AppMethodBeat.o(316543);
      return;
    }
  }
  
  private static void aa(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(316546);
    paramViewGroup.findViewById(a.f.mwsc_reddot1_title_right_iv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_reddot2_desc_right_iv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_newdot_tv).setVisibility(8);
    paramViewGroup.findViewById(a.f.mwsc_numdot_tv).setVisibility(8);
    AppMethodBeat.o(316546);
  }
  
  private void bfY(String paramString)
  {
    AppMethodBeat.i(68821);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.VdT != null)
    {
      str = this.VdT.aaMN;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.VdT.igI != 1) {
        break label275;
      }
      bool = true;
      label76:
      localIntent.putExtra("lqt_is_show_protocol", bool);
      if (this.VdT.aboH != 1) {
        break label280;
      }
    }
    label275:
    label280:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool);
      localIntent.putStringArrayListExtra("lqt_protocol_list", ifg());
      localIntent.putExtra("lqt_profile_wording", this.VdT.abow);
      localIntent.putExtra("lqt_account_type", this.VdT.JaC);
      localIntent.putExtra("lqt_fund_spid", this.VdT.aaMM);
      localIntent.putExtra("operate_id", paramString);
      localIntent.putExtra("entrance_type", 1);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool = false;
      break label76;
    }
  }
  
  private void bfZ(String paramString)
  {
    AppMethodBeat.i(68822);
    Log.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.VdT.ftr);
    localIntent.putExtra("lqt_max_redeem_amount", this.VdT.aboO);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.VdT.aboP);
    localIntent.putExtra("lqt_account_type", this.VdT.JaC);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void cxR()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.VdT != null)
    {
      if ((this.VdT.abpe != null) && (this.VdT.abpe.size() == 1) && (this.VdT.aboR))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        dtx localdtx = (dtx)this.VdT.abpe.get(0);
        addTextOptionMenu(0, localdtx.title, new WalletLqtDetailUI.17(this, localdtx));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(316471);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(316507);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  dtx localdtx = (dtx)localIterator.next();
                  if (!Util.isNullOrNil(localdtx.title)) {
                    paramAnonymous2s.c(i, localdtx.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboR) {
                paramAnonymous2s.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(a.c.Red), WalletLqtDetailUI.this.getString(a.i.wallet_lqt_close_account));
              }
              AppMethodBeat.o(316507);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(316500);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboR))
              {
                if (!Util.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboW)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).aboW;
                }
                for (;;)
                {
                  k.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(a.i.close_btn), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(316544);
                      WalletLqtDetailUI.i(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(316544);
                    }
                  });
                  AppMethodBeat.o(316500);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).JaC == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_close_alert_wording);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(a.i.wallet_lqb_close_alert_wording);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe.size()))
              {
                paramAnonymous2MenuItem = (dtx)WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpe.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.aaZv != 1) {
                  if (paramAnonymous2MenuItem.aaZv == 2)
                  {
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.Krl))
                    {
                      i.o(WalletLqtDetailUI.this, paramAnonymous2MenuItem.Krl, false);
                      AppMethodBeat.o(316500);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.aaZv == 3) && (!Util.isNullOrNil(paramAnonymous2MenuItem.YYZ)) && (!Util.isNullOrNil(paramAnonymous2MenuItem.Krl))) {
                    i.y(paramAnonymous2MenuItem.YYZ, paramAnonymous2MenuItem.Krl, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(316500);
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(316471);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> ifg()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.VdT.aboI != null) && (this.VdT.aboI.size() > 0))
    {
      Iterator localIterator = this.VdT.aboI.iterator();
      while (localIterator.hasNext())
      {
        aku localaku = (aku)localIterator.next();
        if ((!Util.isNullOrNil(localaku.title)) && (!Util.isNullOrNil(localaku.Krl))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localaku.title, localaku.Krl }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void ifh()
  {
    AppMethodBeat.i(316509);
    if (this.VdT.abpk == null)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "svr not return middle banner, hide middle banner");
      this.Veq.setVisibility(8);
      AppMethodBeat.o(316509);
      return;
    }
    Object localObject = this.VdT.abpk;
    if (Util.isNullOrNil(((dtx)localObject).title))
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "middle banner title is nil, hide middle banner");
      this.Veq.setVisibility(8);
      AppMethodBeat.o(316509);
      return;
    }
    this.Veq.setVisibility(0);
    this.Veq.setImportantForAccessibility(1);
    this.Ver.setText(((dtx)localObject).title);
    if ((Util.isNullOrNil(((dtx)localObject).Krl)) && (Util.isNullOrNil(((dtx)localObject).YYZ)))
    {
      this.Ver.setVisibility(0);
      this.Ves.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.Veq.getLayoutParams();
      if (this.VdT.abpj == null) {
        break label316;
      }
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
        this.Veq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      localObject = (LinearLayout.LayoutParams)this.VeK.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
        this.VeK.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(316509);
      return;
      this.Ves.setVisibility(0);
      this.Ver.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(316455);
          int i = com.tencent.mm.cd.a.fromDPToPix(WalletLqtDetailUI.this.getContext(), 16);
          int j = WalletLqtDetailUI.k(WalletLqtDetailUI.this).getWidth();
          int k = WalletLqtDetailUI.k(WalletLqtDetailUI.this).getPaddingLeft();
          int m = WalletLqtDetailUI.l(WalletLqtDetailUI.this).getWidth();
          WalletLqtDetailUI.m(WalletLqtDetailUI.this).setWidth(j - k * 2 - m - i);
          WalletLqtDetailUI.m(WalletLqtDetailUI.this).setVisibility(0);
          AppMethodBeat.o(316455);
        }
      });
      this.Veq.setOnClickListener(new WalletLqtDetailUI.25(this));
      this.Ver.setContentDescription(this.Ver.getText() + getString(a.i.common_btn));
      break;
      label316:
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        this.Veq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void ifi()
  {
    AppMethodBeat.i(316515);
    if (this.VdT.abpj == null)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "svr not return data, hide security entry");
      this.VeL.setVisibility(8);
      AppMethodBeat.o(316515);
      return;
    }
    Log.i("MicroMsg.WalletLqtDetailUI", "show lqt security entry with svr data");
    this.VeL.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if (!Util.isNullOrNil(this.VdT.abpj.icon))
    {
      this.VeM.setVisibility(0);
      this.VeM.setUrl(this.VdT.abpj.icon);
      this.VeN.setText(this.VdT.abpj.title);
      localLayoutParams = (LinearLayout.LayoutParams)this.VeK.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
        this.VeK.setLayoutParams(localLayoutParams);
      }
      com.tencent.mm.kernel.h.baF();
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgD, Integer.valueOf(0))).intValue();
      if (i != 0) {
        break label356;
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgD, Integer.valueOf(cn.getSyncServerTimeSecond()));
      i = 1;
      label207:
      localLayoutParams = (LinearLayout.LayoutParams)this.VeP.getLayoutParams();
      if (i == 0) {
        break label433;
      }
      this.VeO.setVisibility(0);
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
        this.VeP.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      if (!this.VeQ)
      {
        this.VeQ = true;
        com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(20) });
        Log.i("MicroMsg.WalletLqtDetailUI", "report show security entry");
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(22) });
        }
      }
      this.VeL.setOnClickListener(new WalletLqtDetailUI.26(this));
      AppMethodBeat.o(316515);
      return;
      this.VeM.setVisibility(8);
      break;
      label356:
      if (i > 0)
      {
        if (cn.getSyncServerTimeSecond() - i >= 604800L)
        {
          Log.i("MicroMsg.WalletLqtDetailUI", "reddot has display above 7 day, hide it");
          com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(24) });
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
      this.VeO.setVisibility(8);
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
        this.VeP.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void ifj()
  {
    AppMethodBeat.i(316520);
    if (this.VdT.abpo == null)
    {
      AppMethodBeat.o(316520);
      return;
    }
    if (this.VeV)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "has showed dialog, ignore");
      AppMethodBeat.o(316520);
      return;
    }
    this.VeV = true;
    efh localefh = this.VdT.abpo;
    this.VeW = new com.tencent.mm.ui.widget.a.j(getContext(), 2, 0, false);
    View localView;
    CdnImageView localCdnImageView;
    TextView localTextView1;
    TextView localTextView2;
    if (!Util.isNullOrNil(localefh.abkF.wording))
    {
      this.VeW.au(localefh.abkF.wording);
      this.VeW.aFe(0);
      this.VeW.agfR = new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(316450);
          WalletLqtDetailUI.o(WalletLqtDetailUI.this).cyW();
          AppMethodBeat.o(316450);
        }
      };
      localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_lqt_detail_halfdialog_content, null);
      localCdnImageView = (CdnImageView)localView.findViewById(a.f.lqt_detail_halfdialog_icon_iv);
      localTextView1 = (TextView)localView.findViewById(a.f.lqt_detail_halfdialog_main_title_tv);
      localTextView2 = (TextView)localView.findViewById(a.f.lqt_detail_halfdialog_desc_tv);
      if (!Util.isNullOrNil(localefh.abkH)) {
        break label272;
      }
      localCdnImageView.setVisibility(8);
      label193:
      if (!Util.isNullOrNil(localefh.abkJ)) {
        break label315;
      }
      localTextView1.setVisibility(8);
      label210:
      if (!Util.isNullOrNil(localefh.abkE.ZmZ)) {
        break label333;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      this.VeW.setCustomView(localView);
      this.VeW.dDn();
      AppMethodBeat.o(316520);
      return;
      this.VeW.au(getResources().getString(a.i.i_know_it));
      break;
      label272:
      localCdnImageView.setVisibility(0);
      if ((aw.isDarkMode()) && (!Util.isNullOrNil(localefh.abkI)))
      {
        localCdnImageView.setUrl(localefh.abkI);
        break label193;
      }
      localCdnImageView.setUrl(localefh.abkH);
      break label193;
      label315:
      localTextView1.setVisibility(0);
      localTextView1.setText(localefh.abkJ);
      break label210;
      label333:
      localTextView2.setVisibility(0);
      localTextView2.setText(localefh.abkE.ZmZ);
    }
  }
  
  private void ifk()
  {
    AppMethodBeat.i(316526);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.VeH)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(10) });
      this.VeH = true;
      Log.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout, this.Veh, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_tips_title);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_tips_desc);
    localTextView1.setText(this.VdT.abpi.aaMH.title);
    localTextView2.setText(this.VdT.abpi.aaMH.desc);
    if (this.VdT.abpi.aaMH.aaZv != 1)
    {
      if (this.VdT.abpi.aaMH.aaZv != 2) {
        break label230;
      }
      if (!Util.isNullOrNil(this.VdT.abpi.aaMH.Krl))
      {
        localViewGroup.setTag(this.VdT.abpi.aaMH.Krl);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.28(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.Veh.addView(localViewGroup);
      AppMethodBeat.o(316526);
      return;
      label230:
      if ((this.VdT.abpi.aaMH.aaZv == 3) && (!Util.isNullOrNil(this.VdT.abpi.aaMH.YYZ)) && (!Util.isNullOrNil(this.VdT.abpi.aaMH.Krl))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.29(this));
      }
    }
  }
  
  private void ifl()
  {
    AppMethodBeat.i(316528);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView2");
    Object localObject;
    ViewGroup localViewGroup;
    CdnImageView localCdnImageView;
    TextView localTextView;
    if (this.VdT.abpi.aaMI.aaMQ != null)
    {
      if (!this.VeI)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        this.VeI = true;
      }
      localObject = this.VdT.abpi.aaMI.aaMQ;
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout2, this.Veh, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(a.f.lqt_lct_operation_icon_iv);
      localTextView = (TextView)localViewGroup.findViewById(a.f.lqt_lct_operation_title_tv);
      if (Util.isNullOrNil(((dtx)localObject).icon)) {
        break label220;
      }
      localCdnImageView.setUrl(((dtx)localObject).icon);
      localCdnImageView.setVisibility(0);
    }
    for (;;)
    {
      localTextView.setText(((dtx)localObject).title);
      localViewGroup.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316436);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVE, Boolean.FALSE)).booleanValue();
          if (this.Vfc.aaZv == 2) {
            if (!Util.isNullOrNil(this.Vfc.Krl))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Vfc.Krl);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.s.adxf, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title);
              }
              i.aS(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316436);
            return;
            if ((this.Vfc.aaZv == 3) && (!Util.isNullOrNil(this.Vfc.YYZ)) && (!Util.isNullOrNil(this.Vfc.Krl)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Vfc.YYZ;
              paramAnonymousView.qAF = this.Vfc.Krl;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.qBc = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.qBd = str1;
                localWeAppOpenDeclarePromptBundle.qBe = str2;
                localWeAppOpenDeclarePromptBundle.dqR = false;
                paramAnonymousView.qAR = localWeAppOpenDeclarePromptBundle;
              }
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            }
          }
        }
      });
      localObject = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
      this.Veh.addView(localViewGroup, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(316528);
      return;
      label220:
      localCdnImageView.setVisibility(8);
    }
  }
  
  private void ifm()
  {
    AppMethodBeat.i(316536);
    Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView3");
    Object localObject2;
    Object localObject1;
    ViewGroup localViewGroup1;
    Object localObject3;
    TextView localTextView1;
    if (this.VdT.abpi.aaMI.aaMQ != null)
    {
      if (!this.VeJ)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        this.VeJ = true;
      }
      localObject2 = this.VdT.abpi.aaMI.aaMQ;
      localObject1 = (dhl)this.VdT.abpi.aaMI.aaMR.get(0);
      localViewGroup1 = (ViewGroup)getLayoutInflater().inflate(a.g.lqt_lct_operation_layout3, this.Veh, false);
      localObject3 = (CdnImageView)localViewGroup1.findViewById(a.f.lqt_lct_operation_icon_iv);
      localTextView1 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_title_tv);
      if (Util.isNullOrNil(((dtx)localObject2).icon)) {
        break label357;
      }
      ((CdnImageView)localObject3).setUrl(((dtx)localObject2).icon);
      ((CdnImageView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      localTextView1.setText(((dtx)localObject2).title);
      localViewGroup1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316442);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVE, Boolean.FALSE)).booleanValue();
          if (this.Vfc.aaZv == 2) {
            if (!Util.isNullOrNil(this.Vfc.Krl))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Vfc.Krl);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.s.adxf, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title);
              }
              i.aS(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Vfn.aaMM, this.Vfn.aaMN, this.Vfn.aaMO, this.Vfn.aaMP, Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316442);
            return;
            if ((this.Vfc.aaZv == 3) && (!Util.isNullOrNil(this.Vfc.YYZ)) && (!Util.isNullOrNil(this.Vfc.Krl)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Vfc.YYZ;
              paramAnonymousView.qAF = this.Vfc.Krl;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.qBc = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.qBd = str1;
                localWeAppOpenDeclarePromptBundle.qBe = str2;
                localWeAppOpenDeclarePromptBundle.dqR = false;
                paramAnonymousView.qAR = localWeAppOpenDeclarePromptBundle;
              }
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Vfn.aaMM, this.Vfn.aaMN, this.Vfn.aaMO, this.Vfn.aaMP, Integer.valueOf(1) });
            }
          }
        }
      });
      localObject2 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_name_tv);
      localObject3 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_desc_tv);
      localTextView1 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_profit_tv);
      TextView localTextView2 = (TextView)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_profit_desc_tv);
      ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(a.f.lqt_lct_operation_product_layout);
      ((TextView)localObject2).setText(((dhl)localObject1).name);
      ((TextView)localObject3).setText(((dhl)localObject1).desc);
      localTextView1.setText(((dhl)localObject1).aaMJ);
      localTextView2.setText(((dhl)localObject1).aaMK);
      localViewGroup2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316454);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVE, Boolean.FALSE)).booleanValue();
          if (this.Vfn.aaML == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316454);
            return;
          }
          if (this.Vfn.aaML.aaZv == 2) {
            if (!Util.isNullOrNil(this.Vfn.aaML.url))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", this.Vfn.aaML.url);
              paramAnonymousView.putExtra("showShare", true);
              paramAnonymousView.putExtra(f.s.adxf, true);
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                paramAnonymousView.putExtra("key_first_tips", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content);
                paramAnonymousView.putExtra("key_first_tips_title", WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title);
              }
              i.aS(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Vfn.aaMM, this.Vfn.aaMN, this.Vfn.aaMO, this.Vfn.aaMP, Integer.valueOf(2) });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(316454);
            return;
            if ((this.Vfn.aaML.aaZv == 3) && (!Util.isNullOrNil(this.Vfn.aaML.YYZ)) && (!Util.isNullOrNil(this.Vfn.aaML.url)))
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.g();
              paramAnonymousView.username = this.Vfn.aaML.YYZ;
              paramAnonymousView.qAF = this.Vfn.aaML.url;
              paramAnonymousView.scene = 1061;
              if ((!bool) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS != null))
              {
                localObject = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.title;
                String str1 = WalletLqtDetailUI.d(WalletLqtDetailUI.this).abpi.aaMI.aaMS.content;
                String str2 = WalletLqtDetailUI.this.getString(a.i.app_i_known);
                WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
                localWeAppOpenDeclarePromptBundle.qBc = ((String)localObject);
                localWeAppOpenDeclarePromptBundle.qBd = str1;
                localWeAppOpenDeclarePromptBundle.qBe = str2;
                localWeAppOpenDeclarePromptBundle.dqR = false;
                paramAnonymousView.qAR = localWeAppOpenDeclarePromptBundle;
              }
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(WalletLqtDetailUI.this.getContext(), paramAnonymousView);
              if (!bool) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVE, Boolean.TRUE);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21309, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Vfn.aaMM, this.Vfn.aaMN, this.Vfn.aaMO, this.Vfn.aaMP, Integer.valueOf(2) });
            }
          }
        }
      });
      localObject1 = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
      this.Veh.addView(localViewGroup1, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(316536);
      return;
      label357:
      ((CdnImageView)localObject3).setVisibility(8);
    }
  }
  
  private static JSONObject ifn()
  {
    AppMethodBeat.i(316539);
    com.tencent.mm.kernel.h.baF();
    Object localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUU, "");
    if (!Util.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        AppMethodBeat.o(316539);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localJSONException, "", new Object[0]);
      }
      Object localObject2 = null;
    }
  }
  
  public final void cg(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(316650);
    Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.VdS == null)
    {
      AppMethodBeat.o(316650);
      return;
    }
    if (paramBoolean)
    {
      if (this.pIQ != null) {
        break label106;
      }
      this.pIQ = l.c(this, false, null);
    }
    for (;;)
    {
      this.VdS.Val.bVq().f(new com.tencent.mm.vending.c.a()
      {
        private Void a(ekd paramAnonymousekd)
        {
          AppMethodBeat.i(68798);
          if (paramAnonymousekd != null)
          {
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymousekd.JaC), Boolean.valueOf(paramAnonymousekd.aboR) });
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymousekd);
            WalletLqtDetailUI.b(WalletLqtDetailUI.this);
            WalletLqtDetailUI.c(WalletLqtDetailUI.this);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
          }
          for (;;)
          {
            try
            {
              paramAnonymousekd = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.b.a.ISO_8859_1);
              ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.acVm, paramAnonymousekd);
              if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
                WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
              }
              paramAnonymousekd = aguz;
              AppMethodBeat.o(68798);
              return paramAnonymousekd;
            }
            catch (IOException paramAnonymousekd)
            {
              Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymousekd, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
          }
        }
      }).a(new d.a()
      {
        public final void onInterrupt(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68787);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
          int i = paramInt - 1;
          if (i > 0)
          {
            WalletLqtDetailUI.this.cg(i, false);
            AppMethodBeat.o(68787);
            return;
          }
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label120;
            }
          }
          label120:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_network_error))
          {
            k.a(WalletLqtDetailUI.this.getContext(), paramAnonymousObject, "", WalletLqtDetailUI.this.getString(a.i.app_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(68787);
            return;
          }
        }
      });
      AppMethodBeat.o(316650);
      return;
      label106:
      this.pIQ.show();
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_lqt_detail_ui;
  }
  
  public Class<? extends com.tencent.mm.wallet_core.ui.h> getReportUIC()
  {
    return a.class;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.VeF = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.pIQ != null) {
        break label118;
      }
      this.pIQ = l.c(this, false, null);
    }
    for (;;)
    {
      y.a locala = this.VdS.Vam;
      com.tencent.mm.vending.g.g.S(paramIntent, Integer.valueOf(this.VdT.JaC)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void onInterrupt(Object paramAnonymousObject)
        {
          AppMethodBeat.i(316465);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          Log.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramAnonymousObject });
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label94;
            }
          }
          label94:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(a.i.wallet_lqt_network_error))
          {
            k.a(WalletLqtDetailUI.this.getContext(), paramAnonymousObject, "", WalletLqtDetailUI.this.getString(a.i.app_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(316465);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.pIQ.show();
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
    this.VeS = new a(this);
    Log.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      Log.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.VdU = ((ViewGroup)findViewById(a.f.detail_container_ll));
    this.VdV = ((TextView)findViewById(a.f.lqt_detail_title_tv));
    aw.a(this.VdV.getPaint(), 0.8F);
    this.Vep = ((RelativeLayout)findViewById(a.f.lqt_detail_balance_title_layout));
    this.VdW = ((ViewGroup)findViewById(a.f.lqt_know_detail_view_ll));
    this.VdX = ((TextView)findViewById(a.f.lqt_know_detail_textView));
    aw.c(this.VdX.getPaint());
    this.VdY = ((ViewGroup)findViewById(a.f.detail_balance_layout));
    this.VdZ = ((TextView)findViewById(a.f.lqt_detail_balance_rate_hint_tv));
    this.Vea = ((TextView)findViewById(a.f.lqt_detail_balance_rate_tv));
    this.Veb = ((ViewGroup)findViewById(a.f.detail_gain_balance_layout));
    this.Vec = ((TextView)findViewById(a.f.lqt_detail_gain_balance_hint_tv));
    this.Ved = ((WalletTextView)findViewById(a.f.lqt_detail_gain_balance_tv));
    this.Vee = ((Button)findViewById(a.f.lqt_detail_save_btn));
    aw.a(this.Vee.getPaint(), 0.8F);
    this.Vef = ((Button)findViewById(a.f.lqt_detail_fetch_btn));
    aw.a(this.Vef.getPaint(), 0.8F);
    this.Veg = ((LinearLayout)findViewById(a.f.lqt_detail_bottom_info_layout));
    this.Veh = ((LinearLayout)findViewById(a.f.lqt_lct_operation_layout));
    this.Vei = ((LinearLayout)findViewById(a.f.lqt_detail_faq_link_ll));
    this.Vej = ((TextView)findViewById(a.f.lqt_detail_faq_link_tv));
    this.Vel = ((LinearLayout)findViewById(a.f.lqt_detail_fof_link_ll));
    this.Vem = ((TextView)findViewById(a.f.lqt_detail_fof_link_tv));
    this.Ven = findViewById(a.f.lqt_detail_banner_ll);
    this.Veo = ((TextView)findViewById(a.f.lqt_detail_banner_text));
    this.Veq = findViewById(a.f.lqt_detail_middle_banner_ll);
    this.Ver = ((TextView)findViewById(a.f.lqt_detail_middle_banner_title_tv));
    this.Ves = ((WeImageView)findViewById(a.f.lqt_detail_middle_banner_arrow));
    this.Veu = findViewById(a.f.lqt_detail_tiny_app_ll);
    this.Vev = ((CdnImageView)findViewById(a.f.tiny_app_logo));
    this.Vew = ((TextView)findViewById(a.f.tiny_app_name));
    this.Vex = ((TextView)findViewById(a.f.tiny_app_desc));
    this.Vet = findViewById(a.f.lqt_detail_tiny_app_gap);
    this.Vek = ((TextView)findViewById(a.f.lqt_detail_bottom_sponsor_tv));
    this.Vey = ((LinearLayout)findViewById(a.f.lqt_detail_top_biz_layout));
    this.Vez = ((TextView)findViewById(a.f.lqt_detail_top_biz_tv));
    this.VeA = ((TextView)findViewById(a.f.lqt_detail_fundname_tv));
    this.VeB = ((TextView)findViewById(a.f.lqt_detail_yesterday_rate_tv));
    this.VeC = ((LinearLayout)findViewById(a.f.lqt_detail_financial_info_ll));
    this.VeD = ((TextView)findViewById(a.f.lqt_detail_financial_info_tv));
    this.VeE = ((WcPayMoneyLoadingView)findViewById(a.f.lqt_detail_balance_view));
    this.KLX = ((ProgressBar)findViewById(a.f.wallet_money_load_pb));
    this.VeL = ((LinearLayout)findViewById(a.f.lqt_detail_security_container));
    this.VeL.setImportantForAccessibility(1);
    this.VeM = ((CdnImageView)findViewById(a.f.lqt_detail_security_icon));
    this.VeN = ((TextView)findViewById(a.f.lqt_detail_security_title_tv));
    this.VeO = ((ImageView)findViewById(a.f.lqt_detail_security_reddot));
    this.VeP = ((WeImageView)findViewById(a.f.lqt_detail_security_arrow));
    this.VeK = ((LinearLayout)findViewById(a.f.lqt_detail_inner_container));
    this.VeT = ((LinearLayout)findViewById(a.f.lqt_detail_title_ll));
    this.VeU = ((LinearLayout)findViewById(a.f.lqt_detail_balance_ll));
    this.VeT.setImportantForAccessibility(1);
    this.VeU.setImportantForAccessibility(1);
    this.VeE.setLoadingPb(this.KLX);
    getLifecycle().addObserver(this.VeE);
    this.VeE.setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    this.Vei.setVisibility(4);
    this.Vel.setVisibility(4);
    this.VeX.alive();
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.VdR = null;
    this.VdS = null;
    this.VeX.dead();
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.VeY.dead();
    this.VeE.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    this.VeY.alive();
    if (this.VeF) {}
    for (;;)
    {
      try
      {
        String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVm, "");
        if (!Util.isNullOrNil(str)) {
          this.VdT = ((ekd)new ekd().parseFrom(str.getBytes(org.apache.commons.b.a.ISO_8859_1)));
        }
        Hl(true);
        cg(0, false);
        this.VeF = true;
        AppMethodBeat.o(68817);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
        continue;
      }
      com.tencent.mm.kernel.h.baF();
      if ((((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgD, Integer.valueOf(0))).intValue() == -1) && (this.VeO.getVisibility() == 0))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "remove lqt security reddot");
        this.VeO.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.VeP.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
          this.VeP.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316635);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.b.class);
    AppMethodBeat.o(316635);
  }
  
  public static class a
    extends com.tencent.mm.wallet_core.ui.h
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(316438);
      b.a locala = new b.a();
      addCustomReportEvent("lqt_save_btn", locala.a(a.f.lqt_detail_save_btn, c.a.XJJ.toString(), (MMFragmentActivity)paramAppCompatActivity));
      addCustomReportEvent("lqt_fetch_btn", locala.a(a.f.lqt_detail_fetch_btn, c.a.XJK.toString(), (MMFragmentActivity)paramAppCompatActivity));
      AppMethodBeat.o(316438);
    }
    
    public final void b(ekd paramekd)
    {
      AppMethodBeat.i(316440);
      if (paramekd != null)
      {
        paramekd = (Button)findViewById(a.f.lqt_detail_save_btn);
        Button localButton = (Button)findViewById(a.f.lqt_detail_fetch_btn);
        if ((localButton != null) && (localButton.isEnabled())) {
          triggerReport(j.b.XJg, "lqt_fetch_btn");
        }
        if ((paramekd != null) && (paramekd.isEnabled())) {
          triggerReport(j.b.XJg, "lqt_save_btn");
        }
      }
      AppMethodBeat.o(316440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */