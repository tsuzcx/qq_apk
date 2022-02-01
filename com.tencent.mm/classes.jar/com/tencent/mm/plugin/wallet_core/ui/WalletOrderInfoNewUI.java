package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ko.a;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.a;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI
  extends WalletOrderInfoUI
{
  private Orders CZT;
  private int Dpw;
  private String DuA;
  private Button DuB;
  private ImageView DuC;
  private ViewGroup DuD;
  private CdnImageView DuE;
  private TextView DuF;
  private TextView DuG;
  private View DuH;
  private Button DuI;
  private ViewGroup DuJ;
  private boolean DuK;
  private boolean DuL;
  private boolean DuM;
  private com.tencent.mm.wallet_core.d DuN;
  private boolean Dus;
  private String Dut;
  private String Duu;
  private b Duw;
  private HashMap<String, WalletOrderInfoNewUI.a> Dux;
  private String Duy;
  private Button DyA;
  private int DyB;
  private boolean DyC;
  private boolean DyD;
  private com.tencent.mm.sdk.b.c DyE;
  private com.tencent.mm.plugin.wallet_core.c.a DyF;
  private com.tencent.mm.plugin.wallet_core.c.c DyG;
  private boolean DyH;
  private int DyI;
  protected Set<String> Dyc;
  private List<Orders.Commodity> Dyd;
  private Orders.RecommendTinyAppInfo Dye;
  private String Dyf;
  private Orders.Promotions Dyg;
  private TextView Dyh;
  private TextView Dyi;
  private WalletTextView Dyj;
  private ViewGroup Dyk;
  private ViewGroup Dyl;
  private ViewGroup Dym;
  private ViewGroup Dyn;
  private ViewGroup Dyo;
  private ViewGroup Dyp;
  private TextView Dyq;
  private CheckBox Dyr;
  private ViewGroup Dys;
  private CdnImageView Dyt;
  private TextView Dyu;
  private ProgressBar Dyv;
  private ViewGroup Dyw;
  private CdnImageView Dyx;
  private TextView Dyy;
  private TextView Dyz;
  private String lJm;
  private String mAppId;
  private PayInfo mPayInfo;
  private ViewGroup pFW;
  private String wNH;
  private com.tencent.mm.sdk.b.c wQx;
  private String wTG;
  private e.a.a.c yrO;
  private WalletSuccPageAwardWidget yrP;
  private ViewGroup yrQ;
  private ViewGroup yrR;
  private ViewGroup yrS;
  private TextView yrT;
  private boolean yrU;
  private com.tencent.mm.sdk.b.c<yv> yrV;
  private String yuD;
  private TextView yvU;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.lJm = null;
    this.wTG = null;
    this.Dus = false;
    this.Dyc = null;
    this.mAppId = "";
    this.Dyd = null;
    this.Dux = new HashMap();
    this.Dyg = null;
    this.DuA = "-1";
    this.DuK = false;
    this.DuL = false;
    this.DyB = 0;
    this.DyC = false;
    this.DyD = false;
    this.DuM = false;
    this.wQx = new com.tencent.mm.sdk.b.c() {};
    this.DyE = new WalletOrderInfoNewUI.9(this);
    this.yrU = false;
    this.yrV = new com.tencent.mm.sdk.b.c() {};
    this.DyH = false;
    this.DyI = 2;
    AppMethodBeat.o(71014);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.Dyc.clear();
    if ((paramOrders == null) || (paramOrders.DpP == null))
    {
      ae.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.DpP.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.DpF == 2) && (!bu.isNullOrNil(localCommodity.Dqr)))
      {
        ae.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.Dyc.add(localCommodity.Dqr);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void eKW()
  {
    AppMethodBeat.i(71021);
    this.DuD.getVisibility();
    this.Dyk.getVisibility();
    this.Dyp.getVisibility();
    this.Dyw.getVisibility();
    this.DuJ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71008);
        int n = WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this).getHeight();
        if (WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this) != null) {}
        for (int j = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();; j = 0)
        {
          int k;
          label68:
          int m;
          if (WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).getVisibility() == 0)
          {
            k = 1;
            if (WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this).getVisibility() != 0) {
              break label268;
            }
            i = 1;
            if (WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this).getVisibility() != 0) {
              break label273;
            }
            m = 1;
            label84:
            if (i == 0) {
              break label288;
            }
          }
          label268:
          label273:
          label288:
          for (int i = WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this).getBottom();; i = -1)
          {
            if (k != 0) {
              i = WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).getBottom();
            }
            for (;;)
            {
              if (m != 0) {
                i = WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this).getBottom();
              }
              k = i;
              if (i <= 0)
              {
                View localView = WalletOrderInfoNewUI.this.findViewById(2131303154);
                k = i;
                if (localView != null) {
                  k = localView.getBottom();
                }
              }
              if ((WalletOrderInfoNewUI.n(WalletOrderInfoNewUI.this).getVisibility() != 0) && (WalletOrderInfoNewUI.c(WalletOrderInfoNewUI.this).getVisibility() != 0)) {}
              for (i = com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                ae.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
                AppMethodBeat.o(71008);
                return;
                k = 0;
                break;
                i = 0;
                break label68;
                m = 0;
                break label84;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(71021);
  }
  
  private void eKX()
  {
    AppMethodBeat.i(71022);
    if ((this.CZT != null) && (this.Dyd != null) && (this.Dyd.size() > 0))
    {
      Iterator localIterator = this.Dyd.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).wSj));
    }
    for (int i = 0;; i = 1)
    {
      this.yvU.setVisibility(0);
      if (i != 0)
      {
        if ((!bu.isNullOrNil(this.CZT.DpH)) && (!bu.isNullOrNil(this.CZT.DpH.trim())))
        {
          this.yvU.setText(this.CZT.DpH);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.CZT.DgN != 1)
        {
          this.yvU.setText(2131765570);
          AppMethodBeat.o(71022);
          return;
        }
        this.yvU.setText(2131765569);
        AppMethodBeat.o(71022);
        return;
      }
      this.yvU.setText(2131765571);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void eLo()
  {
    AppMethodBeat.i(71019);
    this.Dyv.setVisibility(0);
    this.Dyt.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void eLp()
  {
    AppMethodBeat.i(71020);
    if (this.Dys.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.DyC)
    {
      if (!bu.isNullOrNil(this.yrO.Omr.Omu)) {
        this.Dyt.setUrl(this.yrO.Omr.Omu);
      }
      if (!bu.isNullOrNil(this.yrO.Omr.Omt))
      {
        this.Dyu.setText(this.yrO.Omr.Omt);
        if (!bu.isNullOrNil(this.yrO.Omr.Omv)) {
          this.Dyu.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yrO.Omr.Omv, true));
        }
        if (this.yrO.Omr.Omw > 0L)
        {
          this.Dyu.setTextSize(1, (float)this.yrO.Omr.Omw);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!bu.isNullOrNil(this.yrO.Omr.Omz)) {
        this.Dyt.setUrl(this.yrO.Omr.Omz);
      }
      if (!bu.isNullOrNil(this.yrO.Omr.OmB))
      {
        this.Dyu.setText(this.yrO.Omr.OmB);
        if (!bu.isNullOrNil(this.yrO.Omr.OmA)) {
          this.Dyu.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yrO.Omr.OmA, true));
        }
        if (this.yrO.Omr.Omw > 0L) {
          this.Dyu.setTextSize(1, (float)this.yrO.Omr.Omw);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void eLq()
  {
    AppMethodBeat.i(71023);
    this.Dyk.setVisibility(8);
    this.yrR.setVisibility(8);
    this.yrQ.setVisibility(8);
    this.yrS.setVisibility(8);
    if ((this.CZT != null) && (this.Dyd != null) && (this.Dyd.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.Dyd.get(0);
      List localList = localCommodity.Dqt;
      int i;
      label144:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        ae.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label332;
        }
        this.yrR.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(2131099777));
        if (localDiscountInfo.DqL <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.ynr + com.tencent.mm.wallet_core.ui.f.d(localDiscountInfo.DqL / 100.0D, this.CZT.wSq));
      }
      for (;;)
      {
        this.yrR.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.ynr);
      }
      label308:
      this.yrR.setVisibility(0);
      this.Dyk.setVisibility(0);
      this.yrQ.setVisibility(0);
      label332:
      if ((localCommodity.Dqq >= 0.0D) && (localCommodity.phz < localCommodity.Dqq))
      {
        this.yrT.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.Dqq, localCommodity.wSq));
        this.yrT.getPaint().setFlags(16);
        this.yrS.setVisibility(0);
        this.Dyk.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void eLr()
  {
    AppMethodBeat.i(71024);
    this.Dyp.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.CZT != null)
    {
      c(this.CZT);
      if ((this.Dyd != null) && (this.Dyd.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.Dyd.get(0);
        ae.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.DqA) });
        if ((localCommodity.DqA) && (localCommodity.Dqz != null) && (localCommodity.Dqz.size() > 0))
        {
          Iterator localIterator = localCommodity.Dqz.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.Dqo);
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bu.isNullOrNil(localPromotions.wSr)))
      {
        this.yuD = localCommodity.dmx;
        com.tencent.mm.plugin.report.service.g.yxI.f(13033, new Object[] { Integer.valueOf(1), localPromotions.wSr, localPromotions.url, localPromotions.name, this.yuD });
        this.Dyq.setText(getString(2131765577, new Object[] { localPromotions.name }));
        this.Dyf = localPromotions.wSr;
        this.Dyr.setVisibility(0);
        if (!this.Dyc.contains(localPromotions.wSr)) {
          break label333;
        }
        this.Dyr.setChecked(true);
      }
      for (;;)
      {
        this.Dyp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70989);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (!bu.isNullOrNil(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
            {
              if (!WalletOrderInfoNewUI.this.Dyc.contains(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this))) {
                break label118;
              }
              WalletOrderInfoNewUI.this.Dyc.remove(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70989);
              return;
              label118:
              WalletOrderInfoNewUI.this.Dyc.add(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(true);
            }
          }
        });
        this.Dyp.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.Dyr.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void eLs()
  {
    AppMethodBeat.i(71025);
    this.Dyo.setVisibility(8);
    this.Dyo.removeAllViews();
    Iterator localIterator;
    if ((this.CZT != null) && (this.CZT.Dqb == 1) && (this.CZT.Dqd != null) && (this.CZT.Dqd.size() > 0))
    {
      ae.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.CZT.Dqd, Integer.valueOf(this.CZT.Dqd.size()) });
      localIterator = this.CZT.Dqd.iterator();
    }
    for (;;)
    {
      final Orders.ShowInfo localShowInfo;
      LinearLayout localLinearLayout;
      TextView localTextView2;
      TextView localTextView1;
      if (localIterator.hasNext())
      {
        localShowInfo = (Orders.ShowInfo)localIterator.next();
        ae.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496001, this.Dyo, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131301393);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131304201);
        if (!bu.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bu.isNullOrNil(localShowInfo.ulS)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(localShowInfo.ulS, true));
        label234:
        if (!bu.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.Drj == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bu.isNullOrNil(localShowInfo.Dre)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(localShowInfo.Dre, true));
          label294:
          if (localShowInfo.Drf == 1) {
            if (!bu.isNullOrNil(localShowInfo.Dri)) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70990);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.Dri });
                  WalletOrderInfoNewUI.this.XP(localShowInfo.Dri);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(70990);
                }
              });
            }
          }
          for (;;)
          {
            this.Dyo.addView(localLinearLayout);
            break;
            if ((localShowInfo.Drf == 2) && (!bu.isNullOrNil(localShowInfo.Drg))) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70991);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.Drg, localShowInfo.Drh });
                  paramAnonymousView = new vq();
                  paramAnonymousView.dKT.userName = localShowInfo.Drg;
                  paramAnonymousView.dKT.dKV = bu.bI(localShowInfo.Drh, "");
                  paramAnonymousView.dKT.scene = 1060;
                  paramAnonymousView.dKT.dlj = WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                  paramAnonymousView.dKT.dKW = 0;
                  paramAnonymousView.dKT.context = WalletOrderInfoNewUI.this;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(70991);
                }
              });
            }
          }
          this.Dyk.setVisibility(0);
          this.Dyo.setVisibility(0);
          AppMethodBeat.o(71025);
          return;
        }
        catch (Exception localException1)
        {
          break label294;
        }
      }
      catch (Exception localException2)
      {
        break label234;
      }
    }
  }
  
  private void uA(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.DuD.setVisibility(8);
    this.DuL = false;
    this.DuK = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.CZT != null) {
      if ((this.Dyd != null) && (this.Dyd.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.Dyd.get(0);
        if (localObject2 != null)
        {
          ae.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).DqA) });
          if ((((Orders.Commodity)localObject2).Dqz == null) || (((Orders.Commodity)localObject2).Dqz.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).Dqz.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.Dqp);
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).vlr > 0L) && (!bu.isNullOrNil(((Orders.Promotions)localObject1).Dpr)))
      {
        this.Dyg = ((Orders.Promotions)localObject1);
        this.DuH.setVisibility(8);
        this.DuE.setRoundCorner(true);
        this.DuI.setEnabled(true);
        this.DuI.setBackgroundResource(2131231365);
        this.DuG.setCompoundDrawables(null, null, null, null);
        localObject3 = (WalletOrderInfoNewUI.a)this.Dux.get(((Orders.Promotions)localObject1).vlr);
        if (localObject3 != null)
        {
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).dEM)) {
            this.DuE.setUrl(((WalletOrderInfoNewUI.a)localObject3).dEM);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).dyI)) {
            this.DuF.setText(((WalletOrderInfoNewUI.a)localObject3).dyI);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).DyN))
          {
            this.DuI.setText(((WalletOrderInfoNewUI.a)localObject3).DyN);
            this.DuI.setBackgroundResource(2131234694);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).CRv)) {
            this.Dyg.JhU = ((WalletOrderInfoNewUI.a)localObject3).CRv;
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).CRw)) {
            this.Dyg.JhV = ((WalletOrderInfoNewUI.a)localObject3).CRw;
          }
          if (((WalletOrderInfoNewUI.a)localObject3).DyO > 0) {
            this.Dyg.JhW = ((WalletOrderInfoNewUI.a)localObject3).DyO;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.DuG.getLayoutParams();
          if ((localObject3 == null) || (bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).title))) {
            break label876;
          }
          this.DuG.setText(((WalletOrderInfoNewUI.a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.DuG.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.DuI.setVisibility(0);
          this.DuI.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70992);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70992);
            }
          });
          if (((Orders.Promotions)localObject1).JhR != 1) {
            this.DuD.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70993);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70993);
              }
            });
          }
          localObject3 = this.DuA;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.DuD.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).Dqt;
              if (((((Orders.Commodity)localObject2).Dqq >= 0.0D) && (((Orders.Commodity)localObject2).phz < ((Orders.Commodity)localObject2).Dqq)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.DuD.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.DuD.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
                  localObject4 = this.yuD;
                  i = ((Orders.Promotions)localObject1).JhR;
                  if (!this.DuA.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.g)localObject3).f(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).vlr), Long.valueOf(((Orders.Promotions)localObject1).Dpq) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).Dqx == null) || (bu.isNullOrNil(((Orders.Commodity)localObject2).Dqx.CRv))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.DuF.getVisibility() == 0)
          {
            this.DuF.setSingleLine();
            this.DuF.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(70995);
                try
                {
                  if ((WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) && (!bu.ah(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getTextSize();
                    ae.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft();
                    int i = 1;
                    while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                      i += 1;
                    }
                    ae.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
                    String str1 = str2.substring(0, str2.length() - i - 1);
                    localObject = str1;
                    if (str2.length() > 9)
                    {
                      localObject = str1;
                      if (str1.length() < 9) {
                        localObject = str2.substring(0, 9);
                      }
                    }
                    WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).setText((CharSequence)localObject);
                    WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).append("...");
                  }
                  AppMethodBeat.o(70995);
                  return;
                }
                catch (Exception localException)
                {
                  ae.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(70995);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.DuE.setUrl(((Orders.Promotions)localObject1).xcF);
          this.DuF.setText(((Orders.Promotions)localObject1).name);
          this.DuI.setText(((Orders.Promotions)localObject1).Dpr);
          continue;
          if (!bu.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.DuG.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.DuG.setVisibility(8);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
            continue;
            if (((String)localObject3).equals("0"))
            {
              i = 0;
              continue;
              if (((String)localObject3).equals("-1"))
              {
                i = 1;
                continue;
                if (((String)localObject3).equals("3"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject3).equals("4"))
                  {
                    i = 3;
                    continue;
                    if (((String)localObject3).equals("2"))
                    {
                      i = 4;
                      continue;
                      if (((String)localObject3).equals("1"))
                      {
                        i = 5;
                        continue;
                        this.DuI.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.DuA;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1048:
      this.Dut = ((Orders.Commodity)localObject2).Dqx.CRv;
      this.Duu = ((Orders.Commodity)localObject2).Dqx.CRw;
      this.Dpw = ((Orders.Commodity)localObject2).Dqx.Dpw;
      this.Dye = ((Orders.Commodity)localObject2).Dqx;
      this.DuE.setUrl(((Orders.Commodity)localObject2).Dqx.Dpt);
      this.DuF.setText(((Orders.Commodity)localObject2).Dqx.Dpu);
      this.DuG.setText(getString(2131764967));
      this.DuG.setVisibility(0);
      this.DuE.setRoundCorner(true);
      this.DuI.setEnabled(true);
      this.DuI.setBackgroundResource(2131231365);
      localObject1 = (RelativeLayout.LayoutParams)this.DuG.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.DuG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).Dqx.DqW > 0L)
      {
        if (!bu.isNullOrNil(((Orders.Commodity)localObject2).Dqx.Dpv))
        {
          this.DuI.setVisibility(0);
          this.DuI.setText(((Orders.Commodity)localObject2).Dqx.Dpv);
          this.DuH.setVisibility(8);
        }
        localObject1 = (WalletOrderInfoNewUI.a)this.Dux.get(((Orders.Commodity)localObject2).Dqx.DqW);
        if (localObject1 != null)
        {
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).Dpt)) {
            this.DuE.setUrl(((WalletOrderInfoNewUI.a)localObject1).Dpt);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).Dpu)) {
            this.DuF.setText(((WalletOrderInfoNewUI.a)localObject1).Dpu);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).Dpv))
          {
            this.DuI.setText(((WalletOrderInfoNewUI.a)localObject1).Dpv);
            this.DuI.setBackgroundResource(2131234694);
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CRv)) {
            this.Dut = ((WalletOrderInfoNewUI.a)localObject1).CRv;
          }
          if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CRw)) {
            this.Duu = ((WalletOrderInfoNewUI.a)localObject1).CRw;
          }
          if (((WalletOrderInfoNewUI.a)localObject1).DyO > 0) {
            this.Dpw = ((WalletOrderInfoNewUI.a)localObject1).DyO;
          }
        }
        label1447:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70994);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new vq();
            paramAnonymousView.dKT.userName = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
            paramAnonymousView.dKT.dKV = bu.bI(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.dKT.scene = 1034;
            paramAnonymousView.dKT.dKW = 0;
            if (WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.dKT.aDD = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.dKT.context = WalletOrderInfoNewUI.this;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            boolean bool;
            if ((!bu.isNullOrNil(this.DyL.Dqx.Dpv)) && (this.DyL.Dqx.DqW > 0L))
            {
              bool = true;
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)) {
                break label297;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70994);
              return;
              bool = false;
              break;
              label297:
              com.tencent.mm.plugin.report.service.g.yxI.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            }
          }
        };
        this.DuD.setOnClickListener((View.OnClickListener)localObject1);
        this.DuI.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.DuD.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).Dqt;
        if (((((Orders.Commodity)localObject2).Dqq < 0.0D) || (((Orders.Commodity)localObject2).phz >= ((Orders.Commodity)localObject2).Dqq)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50))
      {
        this.DuD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.DuD.setVisibility(0);
        break;
        this.DuI.setVisibility(8);
        this.DuH.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  protected final void XP(String paramString)
  {
    AppMethodBeat.i(71027);
    ae.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    eKZ();
    com.tencent.mm.wallet_core.ui.f.p(this, paramString, true);
    AppMethodBeat.o(71027);
  }
  
  protected final boolean dNn()
  {
    return false;
  }
  
  public void done()
  {
    AppMethodBeat.i(71031);
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool1 = localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71001);
            WalletOrderInfoNewUI.this.eLt();
            AppMethodBeat.o(71001);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71002);
            WalletOrderInfoNewUI.this.eLt();
            AppMethodBeat.o(71002);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          eLt();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    eLt();
    AppMethodBeat.o(71031);
  }
  
  protected void eKZ()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.Dus)
    {
      ko localko = new ko();
      localko.dyC.requestCode = 4;
      ko.a locala = localko.dyC;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      localko.dyC.dyD = new Intent();
      if (this.CZT != null) {
        localko.dyC.dyD.putExtra("key_jsapi_close_page_after_pay", this.CZT.Dqc);
      }
      if ((this.CZT != null) && (this.CZT.Dqc == 0) && (!bu.isNullOrNil(this.CZT.Dqf)) && (!bu.isNullOrNil(this.CZT.Dqe))) {
        localko.dyC.dyD.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.DuN != null) {
        localko.dyC.dyD.putExtra("key_is_clear_failure", this.DuN.dyY.getInt("key_is_clear_failure", -1));
      }
      com.tencent.mm.sdk.b.a.IvT.l(localko);
      this.Dus = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public final void eLt()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    eKZ();
    Object localObject1 = new ax();
    ((ax)localObject1).dmN.dmO = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new ia();
    ((ia)localObject1).dvC.dvD = "ok";
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    ae.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.Dyc.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!bu.isNullOrNil(str1))
      {
        ae.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.CZT == null) || (this.mPayInfo == null)) {
          break label371;
        }
        q localq = com.tencent.mm.kernel.g.ajQ().gDv;
        String str2 = this.CZT.dmw;
        if (this.CZT.DpP.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.CZT.DpP.get(0)).dmx;
        label282:
        localq.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dDH, this.mPayInfo.channel, this.CZT.DpF), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    if (this.DuN != null)
    {
      this.DuN.a(this, 0, (Bundle)localObject2);
      this.DuN = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.dDH != 46) && (this.mPayInfo.dDH != 3))) {
        break label963;
      }
      localObject1 = new hf();
      if (this.mPayInfo.dDH != 46) {
        break label863;
      }
      ((hf)localObject1).ets = 2L;
      label474:
      if ((this.CZT == null) || (this.CZT.Dqc != 0)) {
        break label882;
      }
      ((hf)localObject1).ett = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.hwN != null))
      {
        localObject2 = this.mPayInfo.hwN.getString("extinfo_key_20", "");
        if (!bu.isNullOrNil((String)localObject2)) {
          ((hf)localObject1).etu = ((hf)localObject1).t("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.hwN.getString("extinfo_key_21", "");
        if (!bu.isNullOrNil((String)localObject2)) {
          ((hf)localObject1).etw = ((hf)localObject1).t("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.hwN.getString("extinfo_key_22", "");
        if (!bu.isNullOrNil((String)localObject2)) {
          ((hf)localObject1).etv = ((hf)localObject1).t("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.CZT != null) && (this.CZT.Dqc == 0) && (!bu.isNullOrNil(this.CZT.Dqf)) && (!bu.isNullOrNil(this.CZT.Dqe)))
      {
        ((hf)localObject1).ety = ((hf)localObject1).t("TargetAppPath", this.CZT.Dqf, true);
        ((hf)localObject1).etx = ((hf)localObject1).t("TargetAppUsername", this.CZT.Dqe, true);
      }
      ((hf)localObject1).aLH();
      if ((this.CZT == null) || (this.CZT.Dqc != 0) || (bu.isNullOrNil(this.CZT.Dqf)) || (bu.isNullOrNil(this.CZT.Dqe))) {
        break label963;
      }
      localObject1 = new vq();
      ((vq)localObject1).dKT.userName = this.CZT.Dqe;
      ((vq)localObject1).dKT.dKV = this.CZT.Dqf;
      ((vq)localObject1).dKT.scene = 1060;
      ((vq)localObject1).dKT.dlj = this.wNH;
      ((vq)localObject1).dKT.dKW = 0;
      ((vq)localObject1).dKT.context = this;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(71032);
      return;
      ae.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.dDH != 3) {
        break label474;
      }
      ((hf)localObject1).ets = 1L;
      break label474;
      label882:
      if ((this.CZT != null) && (this.CZT.Dqc == 1)) {
        ((hf)localObject1).ett = 2L;
      } else if ((this.CZT != null) && (this.CZT.Dqc == 0) && (!bu.isNullOrNil(this.CZT.Dqf)) && (!bu.isNullOrNil(this.CZT.Dqe))) {
        ((hf)localObject1).ett = 3L;
      }
    }
    label963:
    int i;
    if ((this.CZT != null) && (!bu.isNullOrNil(this.CZT.qlv)))
    {
      if (this.CZT.DpP.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.CZT.DpP.get(0)).dmx;
        localObject1 = e(this.CZT.qlv, this.CZT.dmw, (String)localObject1, this.mPayInfo.oED, this.mPayInfo.iWF);
        ae.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", v.aAC());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        com.tencent.mm.wallet_core.ui.f.an(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.Dys.getVisibility() == 0) && (this.yrO.Omr != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
      localObject2 = this.yuD;
      localObject3 = this.Dyu.getText();
      if (this.yrO.Omr.Oms != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.DyC) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject1).f(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.DyI), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(71032);
      return;
      localObject1 = "";
      break;
      label1257:
      i = 2;
      break label1182;
      label1262:
      j = 2;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(71015);
    ae.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, bu.fpN() });
    if (this.yrU)
    {
      AppMethodBeat.o(71015);
      return;
    }
    super.finish();
    this.yrU = true;
    AppMethodBeat.o(71015);
  }
  
  public int getLayoutId()
  {
    return 2131496002;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71018);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.DuC = ((ImageView)findViewById(2131307115));
    this.yvU = ((TextView)findViewById(2131303156));
    this.Dyh = ((TextView)findViewById(2131297511));
    this.Dyi = ((TextView)findViewById(2131299875));
    this.Dyj = ((WalletTextView)findViewById(2131306043));
    this.yrT = ((TextView)findViewById(2131303088));
    this.DuB = ((Button)findViewById(2131303152));
    this.pFW = ((ViewGroup)findViewById(2131304246));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131755779);
    Object localObject1;
    int i;
    label729:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 2)) {
      if ((this.CZT != null) && (!bu.isNullOrNil(this.CZT.Dqa)))
      {
        localObject1 = this.CZT.Dqa;
        this.DuB.setText((CharSequence)localObject1);
        this.DuB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            WalletOrderInfoNewUI.this.done();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71005);
          }
        });
        this.Dyk = ((ViewGroup)findViewById(2131299142));
        this.yrR = ((ViewGroup)findViewById(2131299141));
        this.DuJ = ((ViewGroup)findViewById(2131306773));
        this.yrQ = ((ViewGroup)findViewById(2131299143));
        this.yrS = ((ViewGroup)findViewById(2131303089));
        this.Dyl = ((ViewGroup)findViewById(2131301517));
        this.Dym = ((ViewGroup)findViewById(2131299144));
        this.Dyo = ((ViewGroup)findViewById(2131304780));
        this.Dyn = ((ViewGroup)findViewById(2131303981));
        this.DuD = ((ViewGroup)findViewById(2131305855));
        this.DuE = ((CdnImageView)findViewById(2131305857));
        this.DuE.setUseSdcardCache(true);
        this.DuF = ((TextView)findViewById(2131305854));
        this.DuG = ((TextView)findViewById(2131305859));
        this.DuI = ((Button)findViewById(2131305852));
        this.DuH = findViewById(2131305856);
        this.Dyp = ((ViewGroup)findViewById(2131305518));
        this.Dyq = ((TextView)findViewById(2131297290));
        this.Dyr = ((CheckBox)findViewById(2131305517));
        this.Dyw = ((ViewGroup)findViewById(2131296425));
        this.Dyx = ((CdnImageView)findViewById(2131296426));
        this.Dyx.setUseSdcardCache(true);
        this.Dyz = ((TextView)findViewById(2131296427));
        this.Dyy = ((TextView)findViewById(2131296422));
        this.DyA = ((Button)findViewById(2131296420));
        this.Dys = ((ViewGroup)findViewById(2131306766));
        this.Dyu = ((TextView)findViewById(2131306768));
        this.Dyt = ((CdnImageView)findViewById(2131306765));
        this.Dyv = ((ProgressBar)findViewById(2131306767));
        this.yrP = ((WalletSuccPageAwardWidget)findViewById(2131297022));
        eKX();
        if ((this.CZT != null) && (this.Dyd != null) && (this.Dyd.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Dyd.get(0);
          this.Dyh.setText(((Orders.Commodity)localObject1).wSf);
          this.Dyi.setText(com.tencent.mm.wallet_core.ui.f.bah(((Orders.Commodity)localObject1).wSq));
          this.Dyj.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).phz) }));
        }
        if (this.CZT != null) {
          break label1449;
        }
        i = 0;
        ae.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.CZT == null) || (this.CZT.Dqb != 1)) {
          break label1460;
        }
        this.Dyl.setVisibility(8);
        this.Dym.setVisibility(8);
        this.yrS.setVisibility(8);
        this.yrQ.setVisibility(8);
        this.Dyn.setVisibility(8);
        eLs();
        label816:
        eLr();
        if ((this.Dyd == null) || (this.Dyd.size() <= 0)) {
          break label1895;
        }
        localObject1 = (Orders.Commodity)this.Dyd.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).Dqz == null) || (((Orders.Commodity)localObject1).Dqz.size() <= 0)) {
          break label1892;
        }
        localObject2 = ((Orders.Commodity)localObject1).Dqz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).DqV != null) && (((Orders.Promotions)localObject3).JhR == 5)) || ((((Orders.Promotions)localObject3).DqV != null) && (((Orders.Promotions)localObject3).DqV.Omr != null)))
          {
            this.yrO = ((Orders.Promotions)localObject3).DqV;
            ae.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.yrO, Integer.valueOf(((Orders.Promotions)localObject3).JhR) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.yrO)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.yrP.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).Dqt;
          if (((((Orders.Commodity)localObject1).Dqq >= 0.0D) && (((Orders.Commodity)localObject1).phz < ((Orders.Commodity)localObject1).Dqq)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1054:
            this.yrP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.yrP.a(this, this.yrO, this.wNH, false, (ImageView)findViewById(2131297029));
          this.yrP.init();
          this.yrP.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131297029);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.yrZ.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.yrZ.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1129:
          if ((this.yrO == null) || (this.yrO.Omr == null)) {
            break label1839;
          }
          ae.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.yrO.Omr.Oms) });
          this.Dys.setVisibility(0);
          if (this.yrO.Omr.Oms != 0) {
            break label1756;
          }
          this.DyC = false;
          com.tencent.mm.plugin.report.service.g.yxI.f(17267, new Object[] { this.yuD, this.yrO.Omr.Omt, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1449:
      label1839:
      for (;;)
      {
        eLp();
        bu.n(this.Dys, 12, 12, 12, 12);
        this.Dys.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
            if (WalletOrderInfoNewUI.g(WalletOrderInfoNewUI.this)) {
              WalletOrderInfoNewUI.h(WalletOrderInfoNewUI.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71007);
              return;
              WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this);
            }
          }
        });
        eKW();
        AppMethodBeat.o(71018);
        return;
        if (!bu.isNullOrNil(this.mPayInfo.DHy))
        {
          localObject1 = getString(2131755281) + this.mPayInfo.DHy;
          break;
        }
        localObject1 = localObject2;
        if (bu.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bu.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.CZT == null) {
          break;
        }
        localObject1 = localObject2;
        if (bu.isNullOrNil(this.CZT.Dqa)) {
          break;
        }
        localObject1 = this.CZT.Dqa;
        break;
        i = this.CZT.Dqb;
        break label729;
        label1460:
        eLq();
        if ((this.CZT != null) && (this.Dyd != null) && (this.Dyd.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Dyd.get(0);
          if (((Orders.Commodity)localObject1).Dqy != null)
          {
            localObject2 = (TextView)this.Dyn.findViewById(2131303980);
            localObject3 = (TextView)this.Dyn.findViewById(2131303979);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).Dqy.Drc);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).Dqy.Drd);
            this.Dyn.setVisibility(0);
            this.Dyk.setVisibility(0);
          }
        }
        this.Dym.setVisibility(8);
        this.Dyl.setVisibility(8);
        if ((this.CZT == null) || (this.Dyd == null) || (this.Dyd.size() <= 0)) {
          break label816;
        }
        localObject1 = (Orders.Commodity)this.Dyd.get(0);
        if (!bu.isNullOrNil(((Orders.Commodity)localObject1).Dqw))
        {
          ((TextView)findViewById(2131301518)).setText(((Orders.Commodity)localObject1).Dqw);
          this.Dyl.setVisibility(0);
          this.Dyk.setVisibility(0);
        }
        if (bu.isNullOrNil(((Orders.Commodity)localObject1).Dqu)) {
          break label816;
        }
        ((TextView)findViewById(2131299145)).setText(((Orders.Commodity)localObject1).Dqu);
        this.Dym.setVisibility(0);
        this.Dyk.setVisibility(0);
        break label816;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
        break label1054;
        uA(true);
        this.yrP.setVisibility(8);
        break label1129;
        label1756:
        if (this.yrO.Omr.Oms == 1)
        {
          this.DyC = true;
          com.tencent.mm.plugin.report.service.g.yxI.f(17267, new Object[] { this.yuD, this.yrO.Omr.OmB, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.Dys.setVisibility(8);
          continue;
          this.Dys.setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yxI.f(17267, new Object[] { this.yuD, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1892:
      continue;
      label1895:
      localObject1 = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71028);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      ae.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bu.isNullOrNil(this.Duw.DyT)), Boolean.valueOf(this.DyD) });
      if (this.DyD)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.DyD = true;
      if (bu.isNullOrNil(this.Duw.DyT))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Duw.DgU, this.Duw.DyP, this.Duw.DyQ, this.Duw.DyR, this.Duw.dwj, this.Duw.yoZ, this.Duw.Drb));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new p(this.Duw.DyT, this.Duw.DgU));
    }
    AppMethodBeat.o(71028);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71016);
    super.onCreate(paramBundle);
    label231:
    boolean bool1;
    label259:
    int j;
    label266:
    label529:
    label545:
    yv.a locala;
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      if (com.tencent.mm.compatible.util.d.lA(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.Dyc = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.bs(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.wNH = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      ae.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.wNH });
      this.CZT = eLn();
      if (this.CZT == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.CZT);
      Object localObject;
      if ((paramBundle != null) && (this.CZT != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.fVn();
        com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        int k = this.mPayInfo.dDH;
        if (this.mPayInfo.dDH != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject).f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fVX()), Integer.valueOf((int)(this.CZT.dmz * 100.0D)), this.CZT.wSq, Integer.valueOf(i) });
      }
      if (((!com.tencent.mm.plugin.wallet_core.model.t.eJf().eJH()) && (paramBundle != null) && (paramBundle.fVn())) || (!v.aAM())) {
        v.aAN();
      }
      if ((this.CZT == null) || (this.CZT.DpP == null) || (this.CZT.DpP.size() <= 0)) {
        break label818;
      }
      this.Dyd = this.CZT.DpP;
      ae.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.Dyd.size()) });
      this.wNH = ((Orders.Commodity)this.Dyd.get(0)).dmx;
      this.yuD = ((Orders.Commodity)this.Dyd.get(0)).dmx;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.fVm()) || (paramBundle.fVn()))) {
        doSceneProgress(new ad(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
      initView();
      this.DuN = getProcess();
      eKX();
      if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 46))
      {
        ae.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new yv();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.CZT != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.CZT.dmz);
        }
        if (this.DuN != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.DuN.dyY.getInt("key_is_clear_failure", -1));
        }
        paramBundle.dON.intent = ((Intent)localObject);
        paramBundle.dON.dOQ = 1;
        paramBundle.dON.dmw = getPayReqKey();
        locala = paramBundle.dON;
        if (!((Intent)localObject).getBooleanExtra("intent_pay_end", false)) {
          break label890;
        }
      }
    }
    label802:
    label807:
    label813:
    label818:
    label854:
    label890:
    for (int i = -1;; i = 0)
    {
      locala.result = i;
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      if ((this.CZT == null) || (this.CZT.Dqn == null) || (this.CZT.Dqn.Drk != 1)) {
        break label895;
      }
      ae.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      eLt();
      AppMethodBeat.o(71016);
      return;
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
      break;
      i = 1;
      break label231;
      bool1 = false;
      break label259;
      j = 2;
      break label266;
      ae.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71009);
          WalletOrderInfoNewUI.this.done();
          AppMethodBeat.o(71009);
        }
      });
      break label529;
      ae.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71010);
          WalletOrderInfoNewUI.this.finish();
          AppMethodBeat.o(71010);
        }
      });
      break label545;
    }
    label895:
    addSceneEndListener(1979);
    addSceneEndListener(2948);
    addSceneEndListener(2710);
    com.tencent.mm.sdk.b.a.IvT.c(this.DyE);
    com.tencent.mm.sdk.b.a.IvT.c(this.wQx);
    this.yrV.alive();
    this.DuM = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.dmw)
    {
      com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.dDH;
      break;
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71029);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131765565), getResources().getStringArray(2130903098), "", new WalletOrderInfoNewUI.10(this));
    AppMethodBeat.o(71029);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71034);
    super.onDestroy();
    ae.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.yrO != null) && (this.yrO.Omr != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.yrO.Omr.Gpk, this.yrO.Omr.Oms, this.DyB).aET().h(new WalletOrderInfoNewUI.13(this));
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.DyE);
    com.tencent.mm.sdk.b.a.IvT.d(this.wQx);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.yrV.dead();
    if (WalletSuccPageAwardWidget.a(this.yrO)) {
      this.yrP.onDestroy();
    }
    if (this.DyF != null) {
      this.DyF.cancel();
    }
    if (this.DyG != null) {
      this.DyG.cancel();
    }
    AppMethodBeat.o(71034);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71033);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(71033);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71033);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71017);
    super.onResume();
    ae.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.DuM), this.Dyg, Boolean.valueOf(this.DuK), Boolean.valueOf(this.DuL), this.Dye, this.yrO });
    if (WalletSuccPageAwardWidget.a(this.yrO))
    {
      this.yrP.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.DuM)
    {
      this.DuM = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.Dyg != null) && (this.DuL))
    {
      ae.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bu.isNullOrNil(this.Dyg.JhY)), this.Dyg.JhY, Boolean.valueOf(this.DyD) });
      if (this.DyD)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.DyD = true;
      if (bu.isNullOrNil(this.Dyg.JhY))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Dyg.vlr, this.Dyg.JhS, this.Dyg.Dpo, this.Dyg.Dpp, getPayReqKey(), this.yuD, this.Dyg.Dpq));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new p(this.Dyg.JhY, this.Dyg.vlr));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.DuK) && (this.Dye != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Dye.DqW, this.Dye.DqY, this.Dye.DqZ, this.Dye.Dra, getPayReqKey(), this.yuD, this.Dye.Drb));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71036);
    ae.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((WalletSuccPageAwardWidget.a(this.yrO)) && (this.yrP.onSceneEnd(paramInt1, paramInt2, paramString, paramn)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.af)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.af)paramn;
        paramn = new WalletOrderInfoNewUI.a(paramString.kuc);
        if (this.Duw != null)
        {
          this.Dux.put(paramString.DgU, paramn);
          uA(false);
          eKW();
        }
      }
      else
      {
        this.DyD = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.DuK) {
        break;
      }
      this.Dux.put(paramString.DgU, paramn);
      uA(false);
      eKW();
      break;
      if ((paramn instanceof p))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (p)paramn;
          paramn = paramString.DgB;
          if (paramn.oGt == 0)
          {
            paramn = new WalletOrderInfoNewUI.a(paramn);
            if (this.Duw == null) {
              break label280;
            }
            this.Dux.put(paramString.ByB, paramn);
            uA(false);
            eKW();
          }
        }
        for (;;)
        {
          this.DyD = false;
          break;
          if (this.DuK)
          {
            this.Dux.put(paramString.ByB, paramn);
            uA(false);
            eKW();
          }
        }
      }
      if ((paramn instanceof s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (s)paramn;
          paramn = paramString.DgC;
          if ((this.Dyg != null) && (this.Dyg.vlr == paramString.DgF.vlr))
          {
            ae.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.Dyg });
            this.DuA = paramn;
            ae.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.DgF.Dpr });
            uA(false);
            eKW();
            if ((!bu.isNullOrNil(paramString.fMT)) && (!"3".equals(paramn))) {
              this.DuI.setText(paramString.fMT);
            }
          }
          if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bu.isNullOrNil(paramString.DgD))) {
            com.tencent.mm.ui.base.h.c(this, paramString.DgD, "", true);
          }
          while (!"0".equals(paramn))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!bu.isNullOrNil(paramString.DgD)) {}
          for (paramString = paramString.DgD;; paramString = getString(2131765658))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71036);
        return true;
      }
    } while (!(paramn instanceof m));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (m)paramn;
      paramn = paramString.Dgv;
      String str;
      if (paramn.oGt == 0)
      {
        str = paramn.GOB;
        if ((this.Dyg != null) && (this.Dyg.vlr == paramString.vlr))
        {
          ae.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.Dyg });
          this.DuA = str;
          ae.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramn.GOD });
          uA(false);
          eKW();
          if ((!bu.isNullOrNil(paramn.GOD)) && (!"3".equals(str))) {
            this.DuI.setText(paramn.GOD);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bu.isNullOrNil(paramn.GOC))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramn.GOC, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!bu.isNullOrNil(paramn.GOC)) {}
      for (paramString = paramn.GOC;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramn = getString(2131765901);
    }
    com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(71036);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(71037);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(71037);
  }
  
  static final class b
  {
    public String DgU;
    public long Drb;
    public String DyP;
    public String DyQ;
    public String DyR;
    public long DyS;
    public String DyT;
    public String dwj;
    public String yoZ;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.DgU = paramString1;
      this.DyP = paramString2;
      this.DyQ = paramString3;
      this.DyR = paramString4;
      this.dwj = paramString5;
      this.yoZ = paramString6;
      this.Drb = paramLong1;
      this.DyS = paramLong2;
      this.DyT = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.DgU = paramString1;
      this.DyP = paramString2;
      this.DyQ = paramString3;
      this.DyR = paramString4;
      this.dwj = paramString5;
      this.yoZ = paramString6;
      this.Drb = paramLong;
      this.DyT = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */