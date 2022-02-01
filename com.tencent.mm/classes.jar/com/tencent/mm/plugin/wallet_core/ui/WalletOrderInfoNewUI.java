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
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.kn.a;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.a.yp.a;
import com.tencent.mm.g.b.a.hd;
import com.tencent.mm.model.u;
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
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
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
  private Orders CIn;
  private int CXR;
  private boolean DcO;
  private String DcP;
  private String DcQ;
  private b DcS;
  private HashMap<String, WalletOrderInfoNewUI.a> DcT;
  private String DcU;
  private String DcW;
  private Button DcX;
  private ImageView DcY;
  private ViewGroup DcZ;
  private CdnImageView Dda;
  private TextView Ddb;
  private TextView Ddc;
  private View Ddd;
  private Button Dde;
  private ViewGroup Ddf;
  private boolean Ddg;
  private boolean Ddh;
  private boolean Ddi;
  private com.tencent.mm.wallet_core.d Ddj;
  private Orders.RecommendTinyAppInfo DgA;
  private String DgB;
  private Orders.Promotions DgC;
  private TextView DgD;
  private TextView DgE;
  private WalletTextView DgF;
  private ViewGroup DgG;
  private ViewGroup DgH;
  private ViewGroup DgI;
  private ViewGroup DgJ;
  private ViewGroup DgK;
  private ViewGroup DgL;
  private TextView DgM;
  private CheckBox DgN;
  private ViewGroup DgO;
  private CdnImageView DgP;
  private TextView DgQ;
  private ProgressBar DgR;
  private ViewGroup DgS;
  private CdnImageView DgT;
  private TextView DgU;
  private TextView DgV;
  private Button DgW;
  private int DgX;
  private boolean DgY;
  private boolean DgZ;
  protected Set<String> Dgy;
  private List<Orders.Commodity> Dgz;
  private com.tencent.mm.sdk.b.c Dha;
  private com.tencent.mm.plugin.wallet_core.c.a Dhb;
  private com.tencent.mm.plugin.wallet_core.c.c Dhc;
  private boolean Dhd;
  private int Dhe;
  private String lEN;
  private String mAppId;
  private PayInfo mPayInfo;
  private ViewGroup pzs;
  private com.tencent.mm.sdk.b.c wAM;
  private String wDV;
  private String wxW;
  private e.a.a.c ybX;
  private WalletSuccPageAwardWidget ybY;
  private ViewGroup ybZ;
  private ViewGroup yca;
  private ViewGroup ycb;
  private TextView ycc;
  private boolean ycd;
  private com.tencent.mm.sdk.b.c<yp> yce;
  private String yeM;
  private TextView ygd;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.lEN = null;
    this.wDV = null;
    this.DcO = false;
    this.Dgy = null;
    this.mAppId = "";
    this.Dgz = null;
    this.DcT = new HashMap();
    this.DgC = null;
    this.DcW = "-1";
    this.Ddg = false;
    this.Ddh = false;
    this.DgX = 0;
    this.DgY = false;
    this.DgZ = false;
    this.Ddi = false;
    this.wAM = new com.tencent.mm.sdk.b.c() {};
    this.Dha = new WalletOrderInfoNewUI.9(this);
    this.ycd = false;
    this.yce = new com.tencent.mm.sdk.b.c() {};
    this.Dhd = false;
    this.Dhe = 2;
    AppMethodBeat.o(71014);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.Dgy.clear();
    if ((paramOrders == null) || (paramOrders.CYk == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.CYk.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.CYa == 2) && (!bt.isNullOrNil(localCommodity.CYM)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.Dgy.add(localCommodity.CYM);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void eHG()
  {
    AppMethodBeat.i(71019);
    this.DgR.setVisibility(0);
    this.DgP.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void eHH()
  {
    AppMethodBeat.i(71020);
    if (this.DgO.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.DgY)
    {
      if (!bt.isNullOrNil(this.ybX.NPl.NPo)) {
        this.DgP.setUrl(this.ybX.NPl.NPo);
      }
      if (!bt.isNullOrNil(this.ybX.NPl.NPn))
      {
        this.DgQ.setText(this.ybX.NPl.NPn);
        if (!bt.isNullOrNil(this.ybX.NPl.NPp)) {
          this.DgQ.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.ybX.NPl.NPp, true));
        }
        if (this.ybX.NPl.NPq > 0L)
        {
          this.DgQ.setTextSize(1, (float)this.ybX.NPl.NPq);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!bt.isNullOrNil(this.ybX.NPl.NPt)) {
        this.DgP.setUrl(this.ybX.NPl.NPt);
      }
      if (!bt.isNullOrNil(this.ybX.NPl.NPv))
      {
        this.DgQ.setText(this.ybX.NPl.NPv);
        if (!bt.isNullOrNil(this.ybX.NPl.NPu)) {
          this.DgQ.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.ybX.NPl.NPu, true));
        }
        if (this.ybX.NPl.NPq > 0L) {
          this.DgQ.setTextSize(1, (float)this.ybX.NPl.NPq);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void eHI()
  {
    AppMethodBeat.i(71023);
    this.DgG.setVisibility(8);
    this.yca.setVisibility(8);
    this.ybZ.setVisibility(8);
    this.ycb.setVisibility(8);
    if ((this.CIn != null) && (this.Dgz != null) && (this.Dgz.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.Dgz.get(0);
      List localList = localCommodity.CYO;
      int i;
      label144:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label332;
        }
        this.yca.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(2131099777));
        if (localDiscountInfo.CZg <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.xXz + e.d(localDiscountInfo.CZg / 100.0D, this.CIn.wCF));
      }
      for (;;)
      {
        this.yca.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.xXz);
      }
      label308:
      this.yca.setVisibility(0);
      this.DgG.setVisibility(0);
      this.ybZ.setVisibility(0);
      label332:
      if ((localCommodity.CYL >= 0.0D) && (localCommodity.paV < localCommodity.CYL))
      {
        this.ycc.setText(e.d(localCommodity.CYL, localCommodity.wCF));
        this.ycc.getPaint().setFlags(16);
        this.ycb.setVisibility(0);
        this.DgG.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void eHJ()
  {
    AppMethodBeat.i(71024);
    this.DgL.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.CIn != null)
    {
      c(this.CIn);
      if ((this.Dgz != null) && (this.Dgz.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.Dgz.get(0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.CYV) });
        if ((localCommodity.CYV) && (localCommodity.CYU != null) && (localCommodity.CYU.size() > 0))
        {
          Iterator localIterator = localCommodity.CYU.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.CYJ);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bt.isNullOrNil(localPromotions.wCG)))
      {
        this.yeM = localCommodity.dlv;
        com.tencent.mm.plugin.report.service.g.yhR.f(13033, new Object[] { Integer.valueOf(1), localPromotions.wCG, localPromotions.url, localPromotions.name, this.yeM });
        this.DgM.setText(getString(2131765577, new Object[] { localPromotions.name }));
        this.DgB = localPromotions.wCG;
        this.DgN.setVisibility(0);
        if (!this.Dgy.contains(localPromotions.wCG)) {
          break label333;
        }
        this.DgN.setChecked(true);
      }
      for (;;)
      {
        this.DgL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70989);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (!bt.isNullOrNil(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
            {
              if (!WalletOrderInfoNewUI.this.Dgy.contains(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this))) {
                break label118;
              }
              WalletOrderInfoNewUI.this.Dgy.remove(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70989);
              return;
              label118:
              WalletOrderInfoNewUI.this.Dgy.add(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(true);
            }
          }
        });
        this.DgL.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.DgN.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void eHK()
  {
    AppMethodBeat.i(71025);
    this.DgK.setVisibility(8);
    this.DgK.removeAllViews();
    Iterator localIterator;
    if ((this.CIn != null) && (this.CIn.CYw == 1) && (this.CIn.CYy != null) && (this.CIn.CYy.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.CIn.CYy, Integer.valueOf(this.CIn.CYy.size()) });
      localIterator = this.CIn.CYy.iterator();
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496001, this.DgK, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131301393);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131304201);
        if (!bt.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bt.isNullOrNil(localShowInfo.uaQ)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(localShowInfo.uaQ, true));
        label234:
        if (!bt.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.CZE == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bt.isNullOrNil(localShowInfo.CZz)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(localShowInfo.CZz, true));
          label294:
          if (localShowInfo.CZA == 1) {
            if (!bt.isNullOrNil(localShowInfo.CZD)) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70990);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.CZD });
                  WalletOrderInfoNewUI.this.Xd(localShowInfo.CZD);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(70990);
                }
              });
            }
          }
          for (;;)
          {
            this.DgK.addView(localLinearLayout);
            break;
            if ((localShowInfo.CZA == 2) && (!bt.isNullOrNil(localShowInfo.CZB))) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70991);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.CZB, localShowInfo.CZC });
                  paramAnonymousView = new vm();
                  paramAnonymousView.dJF.userName = localShowInfo.CZB;
                  paramAnonymousView.dJF.dJH = bt.bI(localShowInfo.CZC, "");
                  paramAnonymousView.dJF.scene = 1060;
                  paramAnonymousView.dJF.dkh = WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                  paramAnonymousView.dJF.dJI = 0;
                  paramAnonymousView.dJF.context = WalletOrderInfoNewUI.this;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(70991);
                }
              });
            }
          }
          this.DgG.setVisibility(0);
          this.DgK.setVisibility(0);
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
  
  private void eHo()
  {
    AppMethodBeat.i(71021);
    this.DcZ.getVisibility();
    this.DgG.getVisibility();
    this.DgL.getVisibility();
    this.DgS.getVisibility();
    this.Ddf.post(new Runnable()
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
              for (i = com.tencent.mm.cc.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cc.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void eHp()
  {
    AppMethodBeat.i(71022);
    if ((this.CIn != null) && (this.Dgz != null) && (this.Dgz.size() > 0))
    {
      Iterator localIterator = this.Dgz.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).wCy));
    }
    for (int i = 0;; i = 1)
    {
      this.ygd.setVisibility(0);
      if (i != 0)
      {
        if ((!bt.isNullOrNil(this.CIn.CYc)) && (!bt.isNullOrNil(this.CIn.CYc.trim())))
        {
          this.ygd.setText(this.CIn.CYc);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.CIn.CPj != 1)
        {
          this.ygd.setText(2131765570);
          AppMethodBeat.o(71022);
          return;
        }
        this.ygd.setText(2131765569);
        AppMethodBeat.o(71022);
        return;
      }
      this.ygd.setText(2131765571);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void us(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.DcZ.setVisibility(8);
    this.Ddh = false;
    this.Ddg = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.CIn != null) {
      if ((this.Dgz != null) && (this.Dgz.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.Dgz.get(0);
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).CYV) });
          if ((((Orders.Commodity)localObject2).CYU == null) || (((Orders.Commodity)localObject2).CYU.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).CYU.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.CYK);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).COR > 0L) && (!bt.isNullOrNil(((Orders.Promotions)localObject1).CXM)))
      {
        this.DgC = ((Orders.Promotions)localObject1);
        this.Ddd.setVisibility(8);
        this.Dda.setRoundCorner(true);
        this.Dde.setEnabled(true);
        this.Dde.setBackgroundResource(2131231365);
        this.Ddc.setCompoundDrawables(null, null, null, null);
        localObject3 = (WalletOrderInfoNewUI.a)this.DcT.get(((Orders.Promotions)localObject1).COR);
        if (localObject3 != null)
        {
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).dDH)) {
            this.Dda.setUrl(((WalletOrderInfoNewUI.a)localObject3).dDH);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).dxD)) {
            this.Ddb.setText(((WalletOrderInfoNewUI.a)localObject3).dxD);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).Dhj))
          {
            this.Dde.setText(((WalletOrderInfoNewUI.a)localObject3).Dhj);
            this.Dde.setBackgroundResource(2131234694);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).CzQ)) {
            this.DgC.OdP = ((WalletOrderInfoNewUI.a)localObject3).CzQ;
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).CzR)) {
            this.DgC.OdQ = ((WalletOrderInfoNewUI.a)localObject3).CzR;
          }
          if (((WalletOrderInfoNewUI.a)localObject3).Dhk > 0) {
            this.DgC.OdR = ((WalletOrderInfoNewUI.a)localObject3).Dhk;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.Ddc.getLayoutParams();
          if ((localObject3 == null) || (bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).title))) {
            break label876;
          }
          this.Ddc.setText(((WalletOrderInfoNewUI.a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.Ddc.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.Dde.setVisibility(0);
          this.Dde.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70992);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70992);
            }
          });
          if (((Orders.Promotions)localObject1).OdM != 1) {
            this.DcZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70993);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70993);
              }
            });
          }
          localObject3 = this.DcW;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.DcZ.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).CYO;
              if (((((Orders.Commodity)localObject2).CYL >= 0.0D) && (((Orders.Commodity)localObject2).paV < ((Orders.Commodity)localObject2).CYL)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.DcZ.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.DcZ.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.g.yhR;
                  localObject4 = this.yeM;
                  i = ((Orders.Promotions)localObject1).OdM;
                  if (!this.DcW.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.g)localObject3).f(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).COR), Long.valueOf(((Orders.Promotions)localObject1).CXL) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).CYS == null) || (bt.isNullOrNil(((Orders.Commodity)localObject2).CYS.CzQ))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.Ddb.getVisibility() == 0)
          {
            this.Ddb.setSingleLine();
            this.Ddb.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(70995);
                try
                {
                  if ((WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) && (!bt.ai(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getTextSize();
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft();
                    int i = 1;
                    while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                      i += 1;
                    }
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                  com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(70995);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.Dda.setUrl(((Orders.Promotions)localObject1).wMR);
          this.Ddb.setText(((Orders.Promotions)localObject1).name);
          this.Dde.setText(((Orders.Promotions)localObject1).CXM);
          continue;
          if (!bt.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.Ddc.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.Ddc.setVisibility(8);
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
                        this.Dde.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.DcW;
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
      this.DcP = ((Orders.Commodity)localObject2).CYS.CzQ;
      this.DcQ = ((Orders.Commodity)localObject2).CYS.CzR;
      this.CXR = ((Orders.Commodity)localObject2).CYS.CXR;
      this.DgA = ((Orders.Commodity)localObject2).CYS;
      this.Dda.setUrl(((Orders.Commodity)localObject2).CYS.CXO);
      this.Ddb.setText(((Orders.Commodity)localObject2).CYS.CXP);
      this.Ddc.setText(getString(2131764967));
      this.Ddc.setVisibility(0);
      this.Dda.setRoundCorner(true);
      this.Dde.setEnabled(true);
      this.Dde.setBackgroundResource(2131231365);
      localObject1 = (RelativeLayout.LayoutParams)this.Ddc.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.Ddc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).CYS.CZr > 0L)
      {
        if (!bt.isNullOrNil(((Orders.Commodity)localObject2).CYS.CXQ))
        {
          this.Dde.setVisibility(0);
          this.Dde.setText(((Orders.Commodity)localObject2).CYS.CXQ);
          this.Ddd.setVisibility(8);
        }
        localObject1 = (WalletOrderInfoNewUI.a)this.DcT.get(((Orders.Commodity)localObject2).CYS.CZr);
        if (localObject1 != null)
        {
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CXO)) {
            this.Dda.setUrl(((WalletOrderInfoNewUI.a)localObject1).CXO);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CXP)) {
            this.Ddb.setText(((WalletOrderInfoNewUI.a)localObject1).CXP);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CXQ))
          {
            this.Dde.setText(((WalletOrderInfoNewUI.a)localObject1).CXQ);
            this.Dde.setBackgroundResource(2131234694);
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CzQ)) {
            this.DcP = ((WalletOrderInfoNewUI.a)localObject1).CzQ;
          }
          if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).CzR)) {
            this.DcQ = ((WalletOrderInfoNewUI.a)localObject1).CzR;
          }
          if (((WalletOrderInfoNewUI.a)localObject1).Dhk > 0) {
            this.CXR = ((WalletOrderInfoNewUI.a)localObject1).Dhk;
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new vm();
            paramAnonymousView.dJF.userName = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
            paramAnonymousView.dJF.dJH = bt.bI(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.dJF.scene = 1034;
            paramAnonymousView.dJF.dJI = 0;
            if (WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.dJF.aDD = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.dJF.context = WalletOrderInfoNewUI.this;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            boolean bool;
            if ((!bt.isNullOrNil(this.Dhh.CYS.CXQ)) && (this.Dhh.CYS.CZr > 0L))
            {
              bool = true;
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)) {
                break label297;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70994);
              return;
              bool = false;
              break;
              label297:
              com.tencent.mm.plugin.report.service.g.yhR.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            }
          }
        };
        this.DcZ.setOnClickListener((View.OnClickListener)localObject1);
        this.Dde.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.DcZ.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).CYO;
        if (((((Orders.Commodity)localObject2).CYL < 0.0D) || (((Orders.Commodity)localObject2).paV >= ((Orders.Commodity)localObject2).CYL)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50))
      {
        this.DcZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.DcZ.setVisibility(0);
        break;
        this.Dde.setVisibility(8);
        this.Ddd.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  protected final void Xd(String paramString)
  {
    AppMethodBeat.i(71027);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    eHr();
    e.o(this, paramString, true);
    AppMethodBeat.o(71027);
  }
  
  protected final boolean dJV()
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
            WalletOrderInfoNewUI.this.eHL();
            AppMethodBeat.o(71001);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71002);
            WalletOrderInfoNewUI.this.eHL();
            AppMethodBeat.o(71002);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          eHL();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    eHL();
    AppMethodBeat.o(71031);
  }
  
  public final void eHL()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    eHr();
    Object localObject1 = new ax();
    ((ax)localObject1).dlL.dlM = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new hz();
    ((hz)localObject1).dux.duy = "ok";
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.Dgy.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!bt.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.CIn == null) || (this.mPayInfo == null)) {
          break label371;
        }
        q localq = com.tencent.mm.kernel.g.ajB().gAO;
        String str2 = this.CIn.dlu;
        if (this.CIn.CYk.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.CIn.CYk.get(0)).dlv;
        label282:
        localq.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dCC, this.mPayInfo.channel, this.CIn.CYa), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    if (this.Ddj != null)
    {
      this.Ddj.a(this, 0, (Bundle)localObject2);
      this.Ddj = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.dCC != 46) && (this.mPayInfo.dCC != 3))) {
        break label963;
      }
      localObject1 = new hd();
      if (this.mPayInfo.dCC != 46) {
        break label863;
      }
      ((hd)localObject1).erL = 2L;
      label474:
      if ((this.CIn == null) || (this.CIn.CYx != 0)) {
        break label882;
      }
      ((hd)localObject1).erM = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.htZ != null))
      {
        localObject2 = this.mPayInfo.htZ.getString("extinfo_key_20", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((hd)localObject1).erN = ((hd)localObject1).t("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.htZ.getString("extinfo_key_21", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((hd)localObject1).erP = ((hd)localObject1).t("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.htZ.getString("extinfo_key_22", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((hd)localObject1).erO = ((hd)localObject1).t("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.CIn != null) && (this.CIn.CYx == 0) && (!bt.isNullOrNil(this.CIn.CYA)) && (!bt.isNullOrNil(this.CIn.CYz)))
      {
        ((hd)localObject1).erR = ((hd)localObject1).t("TargetAppPath", this.CIn.CYA, true);
        ((hd)localObject1).erQ = ((hd)localObject1).t("TargetAppUsername", this.CIn.CYz, true);
      }
      ((hd)localObject1).aLk();
      if ((this.CIn == null) || (this.CIn.CYx != 0) || (bt.isNullOrNil(this.CIn.CYA)) || (bt.isNullOrNil(this.CIn.CYz))) {
        break label963;
      }
      localObject1 = new vm();
      ((vm)localObject1).dJF.userName = this.CIn.CYz;
      ((vm)localObject1).dJF.dJH = this.CIn.CYA;
      ((vm)localObject1).dJF.scene = 1060;
      ((vm)localObject1).dJF.dkh = this.wxW;
      ((vm)localObject1).dJF.dJI = 0;
      ((vm)localObject1).dJF.context = this;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(71032);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.dCC != 3) {
        break label474;
      }
      ((hd)localObject1).erL = 1L;
      break label474;
      label882:
      if ((this.CIn != null) && (this.CIn.CYx == 1)) {
        ((hd)localObject1).erM = 2L;
      } else if ((this.CIn != null) && (this.CIn.CYx == 0) && (!bt.isNullOrNil(this.CIn.CYA)) && (!bt.isNullOrNil(this.CIn.CYz))) {
        ((hd)localObject1).erM = 3L;
      }
    }
    label963:
    int i;
    if ((this.CIn != null) && (!bt.isNullOrNil(this.CIn.qeQ)))
    {
      if (this.CIn.CYk.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.CIn.CYk.get(0)).dlv;
        localObject1 = e(this.CIn.qeQ, this.CIn.dlu, (String)localObject1, this.mPayInfo.oyb, this.mPayInfo.iTM);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", u.aAm());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        e.an(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.DgO.getVisibility() == 0) && (this.ybX.NPl != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
      localObject2 = this.yeM;
      localObject3 = this.DgQ.getText();
      if (this.ybX.NPl.NPm != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.DgY) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject1).f(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.Dhe), Long.valueOf(System.currentTimeMillis()) });
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
  
  protected void eHr()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.DcO)
    {
      kn localkn = new kn();
      localkn.dxx.requestCode = 4;
      kn.a locala = localkn.dxx;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      localkn.dxx.dxy = new Intent();
      if (this.CIn != null) {
        localkn.dxx.dxy.putExtra("key_jsapi_close_page_after_pay", this.CIn.CYx);
      }
      if ((this.CIn != null) && (this.CIn.CYx == 0) && (!bt.isNullOrNil(this.CIn.CYA)) && (!bt.isNullOrNil(this.CIn.CYz))) {
        localkn.dxx.dxy.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.Ddj != null) {
        localkn.dxx.dxy.putExtra("key_is_clear_failure", this.Ddj.dxT.getInt("key_is_clear_failure", -1));
      }
      com.tencent.mm.sdk.b.a.IbL.l(localkn);
      this.DcO = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71015);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, bt.flS() });
    if (this.ycd)
    {
      AppMethodBeat.o(71015);
      return;
    }
    super.finish();
    this.ycd = true;
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
    this.DcY = ((ImageView)findViewById(2131307115));
    this.ygd = ((TextView)findViewById(2131303156));
    this.DgD = ((TextView)findViewById(2131297511));
    this.DgE = ((TextView)findViewById(2131299875));
    this.DgF = ((WalletTextView)findViewById(2131306043));
    this.ycc = ((TextView)findViewById(2131303088));
    this.DcX = ((Button)findViewById(2131303152));
    this.pzs = ((ViewGroup)findViewById(2131304246));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131755779);
    Object localObject1;
    int i;
    label729:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 2)) {
      if ((this.CIn != null) && (!bt.isNullOrNil(this.CIn.CYv)))
      {
        localObject1 = this.CIn.CYv;
        this.DcX.setText((CharSequence)localObject1);
        this.DcX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            WalletOrderInfoNewUI.this.done();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71005);
          }
        });
        this.DgG = ((ViewGroup)findViewById(2131299142));
        this.yca = ((ViewGroup)findViewById(2131299141));
        this.Ddf = ((ViewGroup)findViewById(2131306773));
        this.ybZ = ((ViewGroup)findViewById(2131299143));
        this.ycb = ((ViewGroup)findViewById(2131303089));
        this.DgH = ((ViewGroup)findViewById(2131301517));
        this.DgI = ((ViewGroup)findViewById(2131299144));
        this.DgK = ((ViewGroup)findViewById(2131304780));
        this.DgJ = ((ViewGroup)findViewById(2131303981));
        this.DcZ = ((ViewGroup)findViewById(2131305855));
        this.Dda = ((CdnImageView)findViewById(2131305857));
        this.Dda.setUseSdcardCache(true);
        this.Ddb = ((TextView)findViewById(2131305854));
        this.Ddc = ((TextView)findViewById(2131305859));
        this.Dde = ((Button)findViewById(2131305852));
        this.Ddd = findViewById(2131305856);
        this.DgL = ((ViewGroup)findViewById(2131305518));
        this.DgM = ((TextView)findViewById(2131297290));
        this.DgN = ((CheckBox)findViewById(2131305517));
        this.DgS = ((ViewGroup)findViewById(2131296425));
        this.DgT = ((CdnImageView)findViewById(2131296426));
        this.DgT.setUseSdcardCache(true);
        this.DgV = ((TextView)findViewById(2131296427));
        this.DgU = ((TextView)findViewById(2131296422));
        this.DgW = ((Button)findViewById(2131296420));
        this.DgO = ((ViewGroup)findViewById(2131306766));
        this.DgQ = ((TextView)findViewById(2131306768));
        this.DgP = ((CdnImageView)findViewById(2131306765));
        this.DgR = ((ProgressBar)findViewById(2131306767));
        this.ybY = ((WalletSuccPageAwardWidget)findViewById(2131297022));
        eHp();
        if ((this.CIn != null) && (this.Dgz != null) && (this.Dgz.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Dgz.get(0);
          this.DgD.setText(((Orders.Commodity)localObject1).wCu);
          this.DgE.setText(e.aYE(((Orders.Commodity)localObject1).wCF));
          this.DgF.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).paV) }));
        }
        if (this.CIn != null) {
          break label1449;
        }
        i = 0;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.CIn == null) || (this.CIn.CYw != 1)) {
          break label1460;
        }
        this.DgH.setVisibility(8);
        this.DgI.setVisibility(8);
        this.ycb.setVisibility(8);
        this.ybZ.setVisibility(8);
        this.DgJ.setVisibility(8);
        eHK();
        label816:
        eHJ();
        if ((this.Dgz == null) || (this.Dgz.size() <= 0)) {
          break label1895;
        }
        localObject1 = (Orders.Commodity)this.Dgz.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).CYU == null) || (((Orders.Commodity)localObject1).CYU.size() <= 0)) {
          break label1892;
        }
        localObject2 = ((Orders.Commodity)localObject1).CYU.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).CZq != null) && (((Orders.Promotions)localObject3).OdM == 5)) || ((((Orders.Promotions)localObject3).CZq != null) && (((Orders.Promotions)localObject3).CZq.NPl != null)))
          {
            this.ybX = ((Orders.Promotions)localObject3).CZq;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.ybX, Integer.valueOf(((Orders.Promotions)localObject3).OdM) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.ybX)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.ybY.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).CYO;
          if (((((Orders.Commodity)localObject1).CYL >= 0.0D) && (((Orders.Commodity)localObject1).paV < ((Orders.Commodity)localObject1).CYL)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1054:
            this.ybY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.ybY.a(this, this.ybX, this.wxW, false, (ImageView)findViewById(2131297029));
          this.ybY.init();
          this.ybY.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131297029);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.yci.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.yci.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1129:
          if ((this.ybX == null) || (this.ybX.NPl == null)) {
            break label1839;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.ybX.NPl.NPm) });
          this.DgO.setVisibility(0);
          if (this.ybX.NPl.NPm != 0) {
            break label1756;
          }
          this.DgY = false;
          com.tencent.mm.plugin.report.service.g.yhR.f(17267, new Object[] { this.yeM, this.ybX.NPl.NPn, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1449:
      label1839:
      for (;;)
      {
        eHH();
        bt.n(this.DgO, 12, 12, 12, 12);
        this.DgO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
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
        eHo();
        AppMethodBeat.o(71018);
        return;
        if (!bt.isNullOrNil(this.mPayInfo.DpS))
        {
          localObject1 = getString(2131755281) + this.mPayInfo.DpS;
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.CIn == null) {
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.CIn.CYv)) {
          break;
        }
        localObject1 = this.CIn.CYv;
        break;
        i = this.CIn.CYw;
        break label729;
        label1460:
        eHI();
        if ((this.CIn != null) && (this.Dgz != null) && (this.Dgz.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Dgz.get(0);
          if (((Orders.Commodity)localObject1).CYT != null)
          {
            localObject2 = (TextView)this.DgJ.findViewById(2131303980);
            localObject3 = (TextView)this.DgJ.findViewById(2131303979);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).CYT.CZx);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).CYT.CZy);
            this.DgJ.setVisibility(0);
            this.DgG.setVisibility(0);
          }
        }
        this.DgI.setVisibility(8);
        this.DgH.setVisibility(8);
        if ((this.CIn == null) || (this.Dgz == null) || (this.Dgz.size() <= 0)) {
          break label816;
        }
        localObject1 = (Orders.Commodity)this.Dgz.get(0);
        if (!bt.isNullOrNil(((Orders.Commodity)localObject1).CYR))
        {
          ((TextView)findViewById(2131301518)).setText(((Orders.Commodity)localObject1).CYR);
          this.DgH.setVisibility(0);
          this.DgG.setVisibility(0);
        }
        if (bt.isNullOrNil(((Orders.Commodity)localObject1).CYP)) {
          break label816;
        }
        ((TextView)findViewById(2131299145)).setText(((Orders.Commodity)localObject1).CYP);
        this.DgI.setVisibility(0);
        this.DgG.setVisibility(0);
        break label816;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
        break label1054;
        us(true);
        this.ybY.setVisibility(8);
        break label1129;
        label1756:
        if (this.ybX.NPl.NPm == 1)
        {
          this.DgY = true;
          com.tencent.mm.plugin.report.service.g.yhR.f(17267, new Object[] { this.yeM, this.ybX.NPl.NPv, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.DgO.setVisibility(8);
          continue;
          this.DgO.setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yhR.f(17267, new Object[] { this.yeM, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.DcS.Dhp)), Boolean.valueOf(this.DgZ) });
      if (this.DgZ)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.DgZ = true;
      if (bt.isNullOrNil(this.DcS.Dhp))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.DcS.CPq, this.DcS.Dhl, this.DcS.Dhm, this.DcS.Dhn, this.DcS.dve, this.DcS.xZh, this.DcS.CZw));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new p(this.DcS.Dhp, this.DcS.CPq));
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
    yp.a locala;
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      if (com.tencent.mm.compatible.util.d.ly(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.Dgy = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.br(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.wxW = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.wxW });
      this.CIn = eHF();
      if (this.CIn == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.CIn);
      Object localObject;
      if ((paramBundle != null) && (this.CIn != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.fQR();
        com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        int k = this.mPayInfo.dCC;
        if (this.mPayInfo.dCC != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject).f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fRB()), Integer.valueOf((int)(this.CIn.dlx * 100.0D)), this.CIn.wCF, Integer.valueOf(i) });
      }
      if (((!com.tencent.mm.plugin.wallet_core.model.t.eFy().eGa()) && (paramBundle != null) && (paramBundle.fQR())) || (!u.aAw())) {
        u.aAx();
      }
      if ((this.CIn == null) || (this.CIn.CYk == null) || (this.CIn.CYk.size() <= 0)) {
        break label818;
      }
      this.Dgz = this.CIn.CYk;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.Dgz.size()) });
      this.wxW = ((Orders.Commodity)this.Dgz.get(0)).dlv;
      this.yeM = ((Orders.Commodity)this.Dgz.get(0)).dlv;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.fQQ()) || (paramBundle.fQR()))) {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
      initView();
      this.Ddj = getProcess();
      eHp();
      if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 46))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new yp();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.CIn != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.CIn.dlx);
        }
        if (this.Ddj != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.Ddj.dxT.getInt("key_is_clear_failure", -1));
        }
        paramBundle.dNx.intent = ((Intent)localObject);
        paramBundle.dNx.dNA = 1;
        paramBundle.dNx.dlu = getPayReqKey();
        locala = paramBundle.dNx;
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
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      if ((this.CIn == null) || (this.CIn.CYI == null) || (this.CIn.CYI.CZF != 1)) {
        break label895;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      eHL();
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
      com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
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
      com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
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
    com.tencent.mm.sdk.b.a.IbL.c(this.Dha);
    com.tencent.mm.sdk.b.a.IbL.c(this.wAM);
    this.yce.alive();
    this.Ddi = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.dlu)
    {
      com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.dCC;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.ybX != null) && (this.ybX.NPl != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.ybX.NPl.FWL, this.ybX.NPl.NPm, this.DgX).aED().h(new WalletOrderInfoNewUI.13(this));
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.Dha);
    com.tencent.mm.sdk.b.a.IbL.d(this.wAM);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.yce.dead();
    if (WalletSuccPageAwardWidget.a(this.ybX)) {
      this.ybY.onDestroy();
    }
    if (this.Dhb != null) {
      this.Dhb.cancel();
    }
    if (this.Dhc != null) {
      this.Dhc.cancel();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.Ddi), this.DgC, Boolean.valueOf(this.Ddg), Boolean.valueOf(this.Ddh), this.DgA, this.ybX });
    if (WalletSuccPageAwardWidget.a(this.ybX))
    {
      this.ybY.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.Ddi)
    {
      this.Ddi = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.DgC != null) && (this.Ddh))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.DgC.OdT)), this.DgC.OdT, Boolean.valueOf(this.DgZ) });
      if (this.DgZ)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.DgZ = true;
      if (bt.isNullOrNil(this.DgC.OdT))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.DgC.COR, this.DgC.OdN, this.DgC.CXJ, this.DgC.CXK, getPayReqKey(), this.yeM, this.DgC.CXL));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new p(this.DgC.OdT, this.DgC.COR));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.Ddg) && (this.DgA != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.DgA.CZr, this.DgA.CZt, this.DgA.CZu, this.DgA.CZv, getPayReqKey(), this.yeM, this.DgA.CZw));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71036);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((WalletSuccPageAwardWidget.a(this.ybX)) && (this.ybY.onSceneEnd(paramInt1, paramInt2, paramString, paramn)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.af)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.af)paramn;
        paramn = new WalletOrderInfoNewUI.a(paramString.kqN);
        if (this.DcS != null)
        {
          this.DcT.put(paramString.CPq, paramn);
          us(false);
          eHo();
        }
      }
      else
      {
        this.DgZ = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.Ddg) {
        break;
      }
      this.DcT.put(paramString.CPq, paramn);
      us(false);
      eHo();
      break;
      if ((paramn instanceof p))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (p)paramn;
          paramn = paramString.COX;
          if (paramn.ozR == 0)
          {
            paramn = new WalletOrderInfoNewUI.a(paramn);
            if (this.DcS == null) {
              break label280;
            }
            this.DcT.put(paramString.Bhd, paramn);
            us(false);
            eHo();
          }
        }
        for (;;)
        {
          this.DgZ = false;
          break;
          if (this.Ddg)
          {
            this.DcT.put(paramString.Bhd, paramn);
            us(false);
            eHo();
          }
        }
      }
      if ((paramn instanceof s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (s)paramn;
          paramn = paramString.COY;
          if ((this.DgC != null) && (this.DgC.COR == paramString.CPb.COR))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.DgC });
            this.DcW = paramn;
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.CPb.CXM });
            us(false);
            eHo();
            if ((!bt.isNullOrNil(paramString.fKQ)) && (!"3".equals(paramn))) {
              this.Dde.setText(paramString.fKQ);
            }
          }
          if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.COZ))) {
            com.tencent.mm.ui.base.h.c(this, paramString.COZ, "", true);
          }
          while (!"0".equals(paramn))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!bt.isNullOrNil(paramString.COZ)) {}
          for (paramString = paramString.COZ;; paramString = getString(2131765658))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
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
      paramn = paramString.COQ;
      String str;
      if (paramn.ozR == 0)
      {
        str = paramn.Gvc;
        if ((this.DgC != null) && (this.DgC.COR == paramString.COR))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.DgC });
          this.DcW = str;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramn.Gve });
          us(false);
          eHo();
          if ((!bt.isNullOrNil(paramn.Gve)) && (!"3".equals(str))) {
            this.Dde.setText(paramn.Gve);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bt.isNullOrNil(paramn.Gvd))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramn.Gvd, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!bt.isNullOrNil(paramn.Gvd)) {}
      for (paramString = paramn.Gvd;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
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
    public String CPq;
    public long CZw;
    public String Dhl;
    public String Dhm;
    public String Dhn;
    public long Dho;
    public String Dhp;
    public String dve;
    public String xZh;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.CPq = paramString1;
      this.Dhl = paramString2;
      this.Dhm = paramString3;
      this.Dhn = paramString4;
      this.dve = paramString5;
      this.xZh = paramString6;
      this.CZw = paramLong1;
      this.Dho = paramLong2;
      this.Dhp = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.CPq = paramString1;
      this.Dhl = paramString2;
      this.Dhm = paramString3;
      this.Dhn = paramString4;
      this.dve = paramString5;
      this.xZh = paramString6;
      this.CZw = paramLong;
      this.Dhp = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */