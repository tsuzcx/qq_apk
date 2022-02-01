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
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jx.a;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xk.a;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI
  extends WalletOrderInfoUI
{
  private int Afe;
  private boolean Aka;
  private String Akb;
  private String Akc;
  private b Ake;
  private HashMap<String, a> Akf;
  private String Akg;
  private String Aki;
  private Button Akj;
  private ImageView Akk;
  private ViewGroup Akl;
  private CdnImageView Akm;
  private TextView Akn;
  private TextView Ako;
  private View Akp;
  private Button Akq;
  private ViewGroup Akr;
  private boolean Aks;
  private boolean Akt;
  private boolean Aku;
  private com.tencent.mm.wallet_core.d Akv;
  protected Set<String> AnM;
  private List<Orders.Commodity> AnN;
  private Orders.RecommendTinyAppInfo AnO;
  private String AnP;
  private Orders.Promotions AnQ;
  private TextView AnR;
  private TextView AnS;
  private WalletTextView AnT;
  private ViewGroup AnU;
  private ViewGroup AnV;
  private ViewGroup AnW;
  private ViewGroup AnX;
  private ViewGroup AnY;
  private ViewGroup AnZ;
  private TextView Aoa;
  private CheckBox Aob;
  private ViewGroup Aoc;
  private CdnImageView Aod;
  private TextView Aoe;
  private ProgressBar Aof;
  private ViewGroup Aog;
  private CdnImageView Aoh;
  private TextView Aoi;
  private TextView Aoj;
  private Button Aok;
  private int Aol;
  private boolean Aom;
  private boolean Aon;
  private com.tencent.mm.sdk.b.c Aoo;
  private com.tencent.mm.plugin.wallet_core.c.a Aop;
  private com.tencent.mm.plugin.wallet_core.c.c Aoq;
  private boolean Aor;
  private int Aos;
  private String kGt;
  private String mAppId;
  private PayInfo mPayInfo;
  private ViewGroup osi;
  private String ujI;
  private com.tencent.mm.sdk.b.c umw;
  private String upF;
  private e.a.a.c vEk;
  private WalletSuccPageAwardWidget vEl;
  private ViewGroup vEm;
  private ViewGroup vEn;
  private ViewGroup vEo;
  private TextView vEp;
  private boolean vEq;
  private com.tencent.mm.sdk.b.c<xk> vEr;
  private String vGZ;
  private TextView vIs;
  private Orders zPF;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.kGt = null;
    this.upF = null;
    this.Aka = false;
    this.AnM = null;
    this.mAppId = "";
    this.AnN = null;
    this.Akf = new HashMap();
    this.AnQ = null;
    this.Aki = "-1";
    this.Aks = false;
    this.Akt = false;
    this.Aol = 0;
    this.Aom = false;
    this.Aon = false;
    this.Aku = false;
    this.umw = new com.tencent.mm.sdk.b.c() {};
    this.Aoo = new WalletOrderInfoNewUI.9(this);
    this.vEq = false;
    this.vEr = new com.tencent.mm.sdk.b.c() {};
    this.Aor = false;
    this.Aos = 2;
    AppMethodBeat.o(71014);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.AnM.clear();
    if ((paramOrders == null) || (paramOrders.Afx == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.Afx.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.Afn == 2) && (!bt.isNullOrNil(localCommodity.AfZ)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.AnM.add(localCommodity.AfZ);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void edN()
  {
    AppMethodBeat.i(71021);
    this.Akl.getVisibility();
    this.AnU.getVisibility();
    this.AnZ.getVisibility();
    this.Aog.getVisibility();
    this.Akr.post(new Runnable()
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
              for (i = com.tencent.mm.cd.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cd.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void edO()
  {
    AppMethodBeat.i(71022);
    if ((this.zPF != null) && (this.AnN != null) && (this.AnN.size() > 0))
    {
      Iterator localIterator = this.AnN.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).uoi));
    }
    for (int i = 0;; i = 1)
    {
      this.vIs.setVisibility(0);
      if (i != 0)
      {
        if ((!bt.isNullOrNil(this.zPF.Afp)) && (!bt.isNullOrNil(this.zPF.Afp.trim())))
        {
          this.vIs.setText(this.zPF.Afp);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.zPF.zWA != 1)
        {
          this.vIs.setText(2131765570);
          AppMethodBeat.o(71022);
          return;
        }
        this.vIs.setText(2131765569);
        AppMethodBeat.o(71022);
        return;
      }
      this.vIs.setText(2131765571);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void eef()
  {
    AppMethodBeat.i(71019);
    this.Aof.setVisibility(0);
    this.Aod.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void eeg()
  {
    AppMethodBeat.i(71020);
    if (this.Aoc.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.Aom)
    {
      if (!bt.isNullOrNil(this.vEk.Khc.Khf)) {
        this.Aod.setUrl(this.vEk.Khc.Khf);
      }
      if (!bt.isNullOrNil(this.vEk.Khc.Khe))
      {
        this.Aoe.setText(this.vEk.Khc.Khe);
        if (!bt.isNullOrNil(this.vEk.Khc.Khg)) {
          this.Aoe.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vEk.Khc.Khg, true));
        }
        if (this.vEk.Khc.Khh > 0L)
        {
          this.Aoe.setTextSize(1, (float)this.vEk.Khc.Khh);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!bt.isNullOrNil(this.vEk.Khc.Khk)) {
        this.Aod.setUrl(this.vEk.Khc.Khk);
      }
      if (!bt.isNullOrNil(this.vEk.Khc.Khm))
      {
        this.Aoe.setText(this.vEk.Khc.Khm);
        if (!bt.isNullOrNil(this.vEk.Khc.Khl)) {
          this.Aoe.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vEk.Khc.Khl, true));
        }
        if (this.vEk.Khc.Khh > 0L) {
          this.Aoe.setTextSize(1, (float)this.vEk.Khc.Khh);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void eeh()
  {
    AppMethodBeat.i(71023);
    this.AnU.setVisibility(8);
    this.vEn.setVisibility(8);
    this.vEm.setVisibility(8);
    this.vEo.setVisibility(8);
    if ((this.zPF != null) && (this.AnN != null) && (this.AnN.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.AnN.get(0);
      List localList = localCommodity.Agb;
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
        this.vEn.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(2131099777));
        if (localDiscountInfo.Agt <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.vzN + e.d(localDiscountInfo.Agt / 100.0D, this.zPF.uop));
      }
      for (;;)
      {
        this.vEn.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.vzN);
      }
      label308:
      this.vEn.setVisibility(0);
      this.AnU.setVisibility(0);
      this.vEm.setVisibility(0);
      label332:
      if ((localCommodity.AfY >= 0.0D) && (localCommodity.nUf < localCommodity.AfY))
      {
        this.vEp.setText(e.d(localCommodity.AfY, localCommodity.uop));
        this.vEp.getPaint().setFlags(16);
        this.vEo.setVisibility(0);
        this.AnU.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void eei()
  {
    AppMethodBeat.i(71024);
    this.AnZ.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.zPF != null)
    {
      c(this.zPF);
      if ((this.AnN != null) && (this.AnN.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.AnN.get(0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.Agi) });
        if ((localCommodity.Agi) && (localCommodity.Agh != null) && (localCommodity.Agh.size() > 0))
        {
          Iterator localIterator = localCommodity.Agh.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.AfW);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bt.isNullOrNil(localPromotions.uoq)))
      {
        this.vGZ = localCommodity.dcF;
        com.tencent.mm.plugin.report.service.h.vKh.f(13033, new Object[] { Integer.valueOf(1), localPromotions.uoq, localPromotions.url, localPromotions.name, this.vGZ });
        this.Aoa.setText(getString(2131765577, new Object[] { localPromotions.name }));
        this.AnP = localPromotions.uoq;
        this.Aob.setVisibility(0);
        if (!this.AnM.contains(localPromotions.uoq)) {
          break label333;
        }
        this.Aob.setChecked(true);
      }
      for (;;)
      {
        this.AnZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70989);
            if (!bt.isNullOrNil(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
            {
              if (WalletOrderInfoNewUI.this.AnM.contains(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
              {
                WalletOrderInfoNewUI.this.AnM.remove(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
                WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(false);
                AppMethodBeat.o(70989);
                return;
              }
              WalletOrderInfoNewUI.this.AnM.add(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(true);
            }
            AppMethodBeat.o(70989);
          }
        });
        this.AnZ.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.Aob.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void eej()
  {
    AppMethodBeat.i(71025);
    this.AnY.setVisibility(8);
    this.AnY.removeAllViews();
    Iterator localIterator;
    if ((this.zPF != null) && (this.zPF.AfJ == 1) && (this.zPF.AfL != null) && (this.zPF.AfL.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.zPF.AfL, Integer.valueOf(this.zPF.AfL.size()) });
      localIterator = this.zPF.AfL.iterator();
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
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496001, this.AnY, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131301393);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131304201);
        if (!bt.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bt.isNullOrNil(localShowInfo.rVi)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(localShowInfo.rVi, true));
        label234:
        if (!bt.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.AgR == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bt.isNullOrNil(localShowInfo.AgM)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(localShowInfo.AgM, true));
          label294:
          if (localShowInfo.AgN == 1) {
            if (!bt.isNullOrNil(localShowInfo.AgQ)) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70990);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.AgQ });
                  WalletOrderInfoNewUI.this.aur(localShowInfo.AgQ);
                  AppMethodBeat.o(70990);
                }
              });
            }
          }
          for (;;)
          {
            this.AnY.addView(localLinearLayout);
            break;
            if ((localShowInfo.AgN == 2) && (!bt.isNullOrNil(localShowInfo.AgO))) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70991);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.AgO, localShowInfo.AgP });
                  paramAnonymousView = new uj();
                  paramAnonymousView.dzH.userName = localShowInfo.AgO;
                  paramAnonymousView.dzH.dzJ = bt.by(localShowInfo.AgP, "");
                  paramAnonymousView.dzH.scene = 1060;
                  paramAnonymousView.dzH.dbt = WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                  paramAnonymousView.dzH.dzK = 0;
                  paramAnonymousView.dzH.context = WalletOrderInfoNewUI.this;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
                  AppMethodBeat.o(70991);
                }
              });
            }
          }
          this.AnU.setVisibility(0);
          this.AnY.setVisibility(0);
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
  
  private void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.Akl.setVisibility(8);
    this.Akt = false;
    this.Aks = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.zPF != null) {
      if ((this.AnN != null) && (this.AnN.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.AnN.get(0);
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).Agi) });
          if ((((Orders.Commodity)localObject2).Agh == null) || (((Orders.Commodity)localObject2).Agh.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).Agh.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.AfX);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).zWi > 0L) && (!bt.isNullOrNil(((Orders.Promotions)localObject1).AeZ)))
      {
        this.AnQ = ((Orders.Promotions)localObject1);
        this.Akp.setVisibility(8);
        this.Akm.setRoundCorner(true);
        this.Akq.setEnabled(true);
        this.Akq.setBackgroundResource(2131231365);
        this.Ako.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.Akf.get(((Orders.Promotions)localObject1).zWi);
        if (localObject3 != null)
        {
          if (!bt.isNullOrNil(((a)localObject3).dub)) {
            this.Akm.setUrl(((a)localObject3).dub);
          }
          if (!bt.isNullOrNil(((a)localObject3).doh)) {
            this.Akn.setText(((a)localObject3).doh);
          }
          if (!bt.isNullOrNil(((a)localObject3).Aox))
          {
            this.Akq.setText(((a)localObject3).Aox);
            this.Akq.setBackgroundResource(2131234694);
          }
          if (!bt.isNullOrNil(((a)localObject3).zHs)) {
            this.AnQ.LvW = ((a)localObject3).zHs;
          }
          if (!bt.isNullOrNil(((a)localObject3).zHt)) {
            this.AnQ.LvX = ((a)localObject3).zHt;
          }
          if (((a)localObject3).Aoy > 0) {
            this.AnQ.LvY = ((a)localObject3).Aoy;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.Ako.getLayoutParams();
          if ((localObject3 == null) || (bt.isNullOrNil(((a)localObject3).title))) {
            break label876;
          }
          this.Ako.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.Ako.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.Akq.setVisibility(0);
          this.Akq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70992);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
              AppMethodBeat.o(70992);
            }
          });
          if (((Orders.Promotions)localObject1).LvT != 1) {
            this.Akl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70993);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
                AppMethodBeat.o(70993);
              }
            });
          }
          localObject3 = this.Aki;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.Akl.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).Agb;
              if (((((Orders.Commodity)localObject2).AfY >= 0.0D) && (((Orders.Commodity)localObject2).nUf < ((Orders.Commodity)localObject2).AfY)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.Akl.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.Akl.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
                  localObject4 = this.vGZ;
                  i = ((Orders.Promotions)localObject1).LvT;
                  if (!this.Aki.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).f(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).zWi), Long.valueOf(((Orders.Promotions)localObject1).AeY) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).Agf == null) || (bt.isNullOrNil(((Orders.Commodity)localObject2).Agf.zHs))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.Akn.getVisibility() == 0)
          {
            this.Akn.setSingleLine();
            this.Akn.post(new Runnable()
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
          this.Akm.setUrl(((Orders.Promotions)localObject1).uwS);
          this.Akn.setText(((Orders.Promotions)localObject1).name);
          this.Akq.setText(((Orders.Promotions)localObject1).AeZ);
          continue;
          if (!bt.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.Ako.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.Ako.setVisibility(8);
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
                        this.Akq.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.Aki;
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
      this.Akb = ((Orders.Commodity)localObject2).Agf.zHs;
      this.Akc = ((Orders.Commodity)localObject2).Agf.zHt;
      this.Afe = ((Orders.Commodity)localObject2).Agf.Afe;
      this.AnO = ((Orders.Commodity)localObject2).Agf;
      this.Akm.setUrl(((Orders.Commodity)localObject2).Agf.Afb);
      this.Akn.setText(((Orders.Commodity)localObject2).Agf.Afc);
      this.Ako.setText(getString(2131764967));
      this.Ako.setVisibility(0);
      this.Akm.setRoundCorner(true);
      this.Akq.setEnabled(true);
      this.Akq.setBackgroundResource(2131231365);
      localObject1 = (RelativeLayout.LayoutParams)this.Ako.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.Ako.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).Agf.AgE > 0L)
      {
        if (!bt.isNullOrNil(((Orders.Commodity)localObject2).Agf.Afd))
        {
          this.Akq.setVisibility(0);
          this.Akq.setText(((Orders.Commodity)localObject2).Agf.Afd);
          this.Akp.setVisibility(8);
        }
        localObject1 = (a)this.Akf.get(((Orders.Commodity)localObject2).Agf.AgE);
        if (localObject1 != null)
        {
          if (!bt.isNullOrNil(((a)localObject1).Afb)) {
            this.Akm.setUrl(((a)localObject1).Afb);
          }
          if (!bt.isNullOrNil(((a)localObject1).Afc)) {
            this.Akn.setText(((a)localObject1).Afc);
          }
          if (!bt.isNullOrNil(((a)localObject1).Afd))
          {
            this.Akq.setText(((a)localObject1).Afd);
            this.Akq.setBackgroundResource(2131234694);
          }
          if (!bt.isNullOrNil(((a)localObject1).zHs)) {
            this.Akb = ((a)localObject1).zHs;
          }
          if (!bt.isNullOrNil(((a)localObject1).zHt)) {
            this.Akc = ((a)localObject1).zHt;
          }
          if (((a)localObject1).Aoy > 0) {
            this.Afe = ((a)localObject1).Aoy;
          }
        }
        label1447:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70994);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new uj();
            paramAnonymousView.dzH.userName = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
            paramAnonymousView.dzH.dzJ = bt.by(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.dzH.scene = 1034;
            paramAnonymousView.dzH.dzK = 0;
            if (WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.dzH.aAS = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.dzH.context = WalletOrderInfoNewUI.this;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            if ((!bt.isNullOrNil(this.Aov.Agf.Afd)) && (this.Aov.Agf.AgE > 0L)) {}
            for (boolean bool = true;; bool = false)
            {
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
              AppMethodBeat.o(70994);
              return;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            AppMethodBeat.o(70994);
          }
        };
        this.Akl.setOnClickListener((View.OnClickListener)localObject1);
        this.Akq.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.Akl.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).Agb;
        if (((((Orders.Commodity)localObject2).AfY < 0.0D) || (((Orders.Commodity)localObject2).nUf >= ((Orders.Commodity)localObject2).AfY)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50))
      {
        this.Akl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Akl.setVisibility(0);
        break;
        this.Akq.setVisibility(8);
        this.Akp.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  protected final void aur(String paramString)
  {
    AppMethodBeat.i(71027);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    edQ();
    e.p(this, paramString, true);
    AppMethodBeat.o(71027);
  }
  
  protected final boolean dkB()
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
            WalletOrderInfoNewUI.this.eek();
            AppMethodBeat.o(71001);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71002);
            WalletOrderInfoNewUI.this.eek();
            AppMethodBeat.o(71002);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          eek();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    eek();
    AppMethodBeat.o(71031);
  }
  
  protected void edQ()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.Aka)
    {
      jx localjx = new jx();
      localjx.dob.requestCode = 4;
      jx.a locala = localjx.dob;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bRZ = i;
      localjx.dob.doc = new Intent();
      if (this.zPF != null) {
        localjx.dob.doc.putExtra("key_jsapi_close_page_after_pay", this.zPF.AfK);
      }
      if ((this.zPF != null) && (this.zPF.AfK == 0) && (!bt.isNullOrNil(this.zPF.AfN)) && (!bt.isNullOrNil(this.zPF.AfM))) {
        localjx.dob.doc.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.Akv != null) {
        localjx.dob.doc.putExtra("key_is_clear_failure", this.Akv.dow.getInt("key_is_clear_failure", -1));
      }
      com.tencent.mm.sdk.b.a.ESL.l(localjx);
      this.Aka = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public final void eek()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    edQ();
    Object localObject1 = new au();
    ((au)localObject1).dcT.dcU = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new hl();
    ((hl)localObject1).dlc.dld = "ok";
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.AnM.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!bt.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.zPF == null) || (this.mPayInfo == null)) {
          break label371;
        }
        q localq = com.tencent.mm.kernel.g.afA().gcy;
        String str2 = this.zPF.dcE;
        if (this.zPF.Afx.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.zPF.Afx.get(0)).dcF;
        label282:
        localq.a(new t(str1, str2, (String)localObject1, this.mPayInfo.dtb, this.mPayInfo.channel, this.zPF.Afn), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.g.afA().gcy.a(new t(str1), 0);
      }
    }
    if (this.Akv != null)
    {
      this.Akv.a(this, 0, (Bundle)localObject2);
      this.Akv = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.dtb != 46) && (this.mPayInfo.dtb != 3))) {
        break label963;
      }
      localObject1 = new ek();
      if (this.mPayInfo.dtb != 46) {
        break label863;
      }
      ((ek)localObject1).dZn = 2L;
      label474:
      if ((this.zPF == null) || (this.zPF.AfK != 0)) {
        break label882;
      }
      ((ek)localObject1).dZo = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.Cos != null))
      {
        localObject2 = this.mPayInfo.Cos.getString("extinfo_key_20", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((ek)localObject1).dZp = ((ek)localObject1).t("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.Cos.getString("extinfo_key_21", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((ek)localObject1).dZr = ((ek)localObject1).t("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.Cos.getString("extinfo_key_22", "");
        if (!bt.isNullOrNil((String)localObject2)) {
          ((ek)localObject1).dZq = ((ek)localObject1).t("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.zPF != null) && (this.zPF.AfK == 0) && (!bt.isNullOrNil(this.zPF.AfN)) && (!bt.isNullOrNil(this.zPF.AfM)))
      {
        ((ek)localObject1).dZt = ((ek)localObject1).t("TargetAppPath", this.zPF.AfN, true);
        ((ek)localObject1).dZs = ((ek)localObject1).t("TargetAppUsername", this.zPF.AfM, true);
      }
      ((ek)localObject1).aBj();
      if ((this.zPF == null) || (this.zPF.AfK != 0) || (bt.isNullOrNil(this.zPF.AfN)) || (bt.isNullOrNil(this.zPF.AfM))) {
        break label963;
      }
      localObject1 = new uj();
      ((uj)localObject1).dzH.userName = this.zPF.AfM;
      ((uj)localObject1).dzH.dzJ = this.zPF.AfN;
      ((uj)localObject1).dzH.scene = 1060;
      ((uj)localObject1).dzH.dbt = this.ujI;
      ((uj)localObject1).dzH.dzK = 0;
      ((uj)localObject1).dzH.context = this;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(71032);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.dtb != 3) {
        break label474;
      }
      ((ek)localObject1).dZn = 1L;
      break label474;
      label882:
      if ((this.zPF != null) && (this.zPF.AfK == 1)) {
        ((ek)localObject1).dZo = 2L;
      } else if ((this.zPF != null) && (this.zPF.AfK == 0) && (!bt.isNullOrNil(this.zPF.AfN)) && (!bt.isNullOrNil(this.zPF.AfM))) {
        ((ek)localObject1).dZo = 3L;
      }
    }
    label963:
    int i;
    if ((this.zPF != null) && (!bt.isNullOrNil(this.zPF.oYa)))
    {
      if (this.zPF.Afx.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.zPF.Afx.get(0)).dcF;
        localObject1 = e(this.zPF.oYa, this.zPF.dcE, (String)localObject1, this.mPayInfo.nrG, this.mPayInfo.iaz);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", u.aqG());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        e.X(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.Aoc.getVisibility() == 0) && (this.vEk.Khc != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
      localObject2 = this.vGZ;
      localObject3 = this.Aoe.getText();
      if (this.vEk.Khc.Khd != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.Aom) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.Aos), Long.valueOf(System.currentTimeMillis()) });
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, bt.eGN() });
    if (this.vEq)
    {
      AppMethodBeat.o(71015);
      return;
    }
    super.finish();
    this.vEq = true;
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
    this.Akk = ((ImageView)findViewById(2131307115));
    this.vIs = ((TextView)findViewById(2131303156));
    this.AnR = ((TextView)findViewById(2131297511));
    this.AnS = ((TextView)findViewById(2131299875));
    this.AnT = ((WalletTextView)findViewById(2131306043));
    this.vEp = ((TextView)findViewById(2131303088));
    this.Akj = ((Button)findViewById(2131303152));
    this.osi = ((ViewGroup)findViewById(2131304246));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131755779);
    Object localObject1;
    int i;
    label729:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 2)) {
      if ((this.zPF != null) && (!bt.isNullOrNil(this.zPF.AfI)))
      {
        localObject1 = this.zPF.AfI;
        this.Akj.setText((CharSequence)localObject1);
        this.Akj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            WalletOrderInfoNewUI.this.done();
            AppMethodBeat.o(71005);
          }
        });
        this.AnU = ((ViewGroup)findViewById(2131299142));
        this.vEn = ((ViewGroup)findViewById(2131299141));
        this.Akr = ((ViewGroup)findViewById(2131306773));
        this.vEm = ((ViewGroup)findViewById(2131299143));
        this.vEo = ((ViewGroup)findViewById(2131303089));
        this.AnV = ((ViewGroup)findViewById(2131301517));
        this.AnW = ((ViewGroup)findViewById(2131299144));
        this.AnY = ((ViewGroup)findViewById(2131304780));
        this.AnX = ((ViewGroup)findViewById(2131303981));
        this.Akl = ((ViewGroup)findViewById(2131305855));
        this.Akm = ((CdnImageView)findViewById(2131305857));
        this.Akm.setUseSdcardCache(true);
        this.Akn = ((TextView)findViewById(2131305854));
        this.Ako = ((TextView)findViewById(2131305859));
        this.Akq = ((Button)findViewById(2131305852));
        this.Akp = findViewById(2131305856);
        this.AnZ = ((ViewGroup)findViewById(2131305518));
        this.Aoa = ((TextView)findViewById(2131297290));
        this.Aob = ((CheckBox)findViewById(2131305517));
        this.Aog = ((ViewGroup)findViewById(2131296425));
        this.Aoh = ((CdnImageView)findViewById(2131296426));
        this.Aoh.setUseSdcardCache(true);
        this.Aoj = ((TextView)findViewById(2131296427));
        this.Aoi = ((TextView)findViewById(2131296422));
        this.Aok = ((Button)findViewById(2131296420));
        this.Aoc = ((ViewGroup)findViewById(2131306766));
        this.Aoe = ((TextView)findViewById(2131306768));
        this.Aod = ((CdnImageView)findViewById(2131306765));
        this.Aof = ((ProgressBar)findViewById(2131306767));
        this.vEl = ((WalletSuccPageAwardWidget)findViewById(2131297022));
        edO();
        if ((this.zPF != null) && (this.AnN != null) && (this.AnN.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.AnN.get(0);
          this.AnR.setText(((Orders.Commodity)localObject1).uoe);
          this.AnS.setText(e.aNc(((Orders.Commodity)localObject1).uop));
          this.AnT.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).nUf) }));
        }
        if (this.zPF != null) {
          break label1449;
        }
        i = 0;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.zPF == null) || (this.zPF.AfJ != 1)) {
          break label1460;
        }
        this.AnV.setVisibility(8);
        this.AnW.setVisibility(8);
        this.vEo.setVisibility(8);
        this.vEm.setVisibility(8);
        this.AnX.setVisibility(8);
        eej();
        label816:
        eei();
        if ((this.AnN == null) || (this.AnN.size() <= 0)) {
          break label1895;
        }
        localObject1 = (Orders.Commodity)this.AnN.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).Agh == null) || (((Orders.Commodity)localObject1).Agh.size() <= 0)) {
          break label1892;
        }
        localObject2 = ((Orders.Commodity)localObject1).Agh.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).AgD != null) && (((Orders.Promotions)localObject3).LvT == 5)) || ((((Orders.Promotions)localObject3).AgD != null) && (((Orders.Promotions)localObject3).AgD.Khc != null)))
          {
            this.vEk = ((Orders.Promotions)localObject3).AgD;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.vEk, Integer.valueOf(((Orders.Promotions)localObject3).LvT) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.vEk)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.vEl.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).Agb;
          if (((((Orders.Commodity)localObject1).AfY >= 0.0D) && (((Orders.Commodity)localObject1).nUf < ((Orders.Commodity)localObject1).AfY)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1054:
            this.vEl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.vEl.a(this, this.vEk, this.ujI, false, (ImageView)findViewById(2131297029));
          this.vEl.init();
          this.vEl.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131297029);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.vEv.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.vEv.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1129:
          if ((this.vEk == null) || (this.vEk.Khc == null)) {
            break label1839;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.vEk.Khc.Khd) });
          this.Aoc.setVisibility(0);
          if (this.vEk.Khc.Khd != 0) {
            break label1756;
          }
          this.Aom = false;
          com.tencent.mm.plugin.report.service.h.vKh.f(17267, new Object[] { this.vGZ, this.vEk.Khc.Khe, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1449:
      label1839:
      for (;;)
      {
        eeg();
        bt.n(this.Aoc, 12, 12, 12, 12);
        this.Aoc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
            if (WalletOrderInfoNewUI.g(WalletOrderInfoNewUI.this))
            {
              WalletOrderInfoNewUI.h(WalletOrderInfoNewUI.this);
              AppMethodBeat.o(71007);
              return;
            }
            WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this);
            AppMethodBeat.o(71007);
          }
        });
        edN();
        AppMethodBeat.o(71018);
        return;
        if (!bt.isNullOrNil(this.mPayInfo.Axg))
        {
          localObject1 = getString(2131755281) + this.mPayInfo.Axg;
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.zPF == null) {
          break;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.zPF.AfI)) {
          break;
        }
        localObject1 = this.zPF.AfI;
        break;
        i = this.zPF.AfJ;
        break label729;
        label1460:
        eeh();
        if ((this.zPF != null) && (this.AnN != null) && (this.AnN.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.AnN.get(0);
          if (((Orders.Commodity)localObject1).Agg != null)
          {
            localObject2 = (TextView)this.AnX.findViewById(2131303980);
            localObject3 = (TextView)this.AnX.findViewById(2131303979);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).Agg.AgK);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).Agg.AgL);
            this.AnX.setVisibility(0);
            this.AnU.setVisibility(0);
          }
        }
        this.AnW.setVisibility(8);
        this.AnV.setVisibility(8);
        if ((this.zPF == null) || (this.AnN == null) || (this.AnN.size() <= 0)) {
          break label816;
        }
        localObject1 = (Orders.Commodity)this.AnN.get(0);
        if (!bt.isNullOrNil(((Orders.Commodity)localObject1).Age))
        {
          ((TextView)findViewById(2131301518)).setText(((Orders.Commodity)localObject1).Age);
          this.AnV.setVisibility(0);
          this.AnU.setVisibility(0);
        }
        if (bt.isNullOrNil(((Orders.Commodity)localObject1).Agc)) {
          break label816;
        }
        ((TextView)findViewById(2131299145)).setText(((Orders.Commodity)localObject1).Agc);
        this.AnW.setVisibility(0);
        this.AnU.setVisibility(0);
        break label816;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50);
        break label1054;
        sH(true);
        this.vEl.setVisibility(8);
        break label1129;
        label1756:
        if (this.vEk.Khc.Khd == 1)
        {
          this.Aom = true;
          com.tencent.mm.plugin.report.service.h.vKh.f(17267, new Object[] { this.vGZ, this.vEk.Khc.Khm, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.Aoc.setVisibility(8);
          continue;
          this.Aoc.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.vKh.f(17267, new Object[] { this.vGZ, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.Ake.AoD)), Boolean.valueOf(this.Aon) });
      if (this.Aon)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.Aon = true;
      if (bt.isNullOrNil(this.Ake.AoD))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Ake.zWH, this.Ake.Aoz, this.Ake.AoA, this.Ake.AoB, this.Ake.dlJ, this.Ake.vBv, this.Ake.AgJ));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new p(this.Ake.AoD, this.Ake.zWH));
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
    xk.a locala;
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      if (com.tencent.mm.compatible.util.d.lf(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.AnM = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.bo(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.ujI = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.ujI });
      this.zPF = eee();
      if (this.zPF == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.zPF);
      Object localObject;
      if ((paramBundle != null) && (this.zPF != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.fjs();
        com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        int k = this.mPayInfo.dtb;
        if (this.mPayInfo.dtb != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fkb()), Integer.valueOf((int)(this.zPF.dcH * 100.0D)), this.zPF.uop, Integer.valueOf(i) });
      }
      if (((!com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF()) && (paramBundle != null) && (paramBundle.fjs())) || (!u.aqQ())) {
        u.aqR();
      }
      if ((this.zPF == null) || (this.zPF.Afx == null) || (this.zPF.Afx.size() <= 0)) {
        break label818;
      }
      this.AnN = this.zPF.Afx;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.AnN.size()) });
      this.ujI = ((Orders.Commodity)this.AnN.get(0)).dcF;
      this.vGZ = ((Orders.Commodity)this.AnN.get(0)).dcF;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.fjr()) || (paramBundle.fjs()))) {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).h(this);
      initView();
      this.Akv = getProcess();
      edO();
      if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 46))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new xk();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.zPF != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.zPF.dcH);
        }
        if (this.Akv != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.Akv.dow.getInt("key_is_clear_failure", -1));
        }
        paramBundle.dDy.intent = ((Intent)localObject);
        paramBundle.dDy.dDB = 1;
        paramBundle.dDy.dcE = getPayReqKey();
        locala = paramBundle.dDy;
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
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      if ((this.zPF == null) || (this.zPF.AfV == null) || (this.zPF.AfV.AgS != 1)) {
        break label895;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      eek();
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
    com.tencent.mm.sdk.b.a.ESL.c(this.Aoo);
    com.tencent.mm.sdk.b.a.ESL.c(this.umw);
    this.vEr.alive();
    this.Aku = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.dcE)
    {
      com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.dtb;
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
    if ((this.vEk != null) && (this.vEk.Khc != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.vEk.Khc.CWQ, this.vEk.Khc.Khd, this.Aol).auK().h(new WalletOrderInfoNewUI.13(this));
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.Aoo);
    com.tencent.mm.sdk.b.a.ESL.d(this.umw);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.vEr.dead();
    if (WalletSuccPageAwardWidget.a(this.vEk)) {
      this.vEl.onDestroy();
    }
    if (this.Aop != null) {
      this.Aop.cancel();
    }
    if (this.Aoq != null) {
      this.Aoq.cancel();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.Aku), this.AnQ, Boolean.valueOf(this.Aks), Boolean.valueOf(this.Akt), this.AnO, this.vEk });
    if (WalletSuccPageAwardWidget.a(this.vEk))
    {
      this.vEl.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.Aku)
    {
      this.Aku = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.AnQ != null) && (this.Akt))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.AnQ.Lwa)), this.AnQ.Lwa, Boolean.valueOf(this.Aon) });
      if (this.Aon)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.Aon = true;
      if (bt.isNullOrNil(this.AnQ.Lwa))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.AnQ.zWi, this.AnQ.LvU, this.AnQ.AeW, this.AnQ.AeX, getPayReqKey(), this.vGZ, this.AnQ.AeY));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new p(this.AnQ.Lwa, this.AnQ.zWi));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.Aks) && (this.AnO != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.AnO.AgE, this.AnO.AgG, this.AnO.AgH, this.AnO.AgI, getPayReqKey(), this.vGZ, this.AnO.AgJ));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71036);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((WalletSuccPageAwardWidget.a(this.vEk)) && (this.vEl.onSceneEnd(paramInt1, paramInt2, paramString, paramn)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.af)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.af)paramn;
        paramn = new a(paramString.jwa);
        if (this.Ake != null)
        {
          this.Akf.put(paramString.zWH, paramn);
          sH(false);
          edN();
        }
      }
      else
      {
        this.Aon = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.Aks) {
        break;
      }
      this.Akf.put(paramString.zWH, paramn);
      sH(false);
      edN();
      break;
      if ((paramn instanceof p))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (p)paramn;
          paramn = paramString.zWo;
          if (paramn.ntx == 0)
          {
            paramn = new a(paramn);
            if (this.Ake == null) {
              break label280;
            }
            this.Akf.put(paramString.yCo, paramn);
            sH(false);
            edN();
          }
        }
        for (;;)
        {
          this.Aon = false;
          break;
          if (this.Aks)
          {
            this.Akf.put(paramString.yCo, paramn);
            sH(false);
            edN();
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramn;
          paramn = paramString.zWp;
          if ((this.AnQ != null) && (this.AnQ.zWi == paramString.zWs.zWi))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.AnQ });
            this.Aki = paramn;
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.zWs.AeZ });
            sH(false);
            edN();
            if ((!bt.isNullOrNil(paramString.foR)) && (!"3".equals(paramn))) {
              this.Akq.setText(paramString.foR);
            }
          }
          if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.zWq))) {
            com.tencent.mm.ui.base.h.c(this, paramString.zWq, "", true);
          }
          while (!"0".equals(paramn))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!bt.isNullOrNil(paramString.zWq)) {}
          for (paramString = paramString.zWq;; paramString = getString(2131765658))
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
      paramn = paramString.zWh;
      String str;
      if (paramn.ntx == 0)
      {
        str = paramn.DqW;
        if ((this.AnQ != null) && (this.AnQ.zWi == paramString.zWi))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.AnQ });
          this.Aki = str;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramn.DqY });
          sH(false);
          edN();
          if ((!bt.isNullOrNil(paramn.DqY)) && (!"3".equals(str))) {
            this.Akq.setText(paramn.DqY);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bt.isNullOrNil(paramn.DqX))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramn.DqX, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!bt.isNullOrNil(paramn.DqX)) {}
      for (paramString = paramn.DqX;; paramString = getString(2131765658))
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
  
  static final class a
  {
    public String Afb;
    public String Afc;
    public String Afd;
    public String Aox;
    public int Aoy;
    public String doh;
    public String dub;
    public String title;
    public String url;
    public String zHs;
    public String zHt;
    public String zVm;
    
    public a(ceu paramceu)
    {
      AppMethodBeat.i(71012);
      if ((paramceu != null) && (paramceu.Ebk != null))
      {
        paramceu = paramceu.Ebk;
        this.url = paramceu.url;
        this.doh = paramceu.doh;
        this.dub = paramceu.dub;
        this.Aox = paramceu.Aox;
        this.title = paramceu.title;
        this.zHs = paramceu.zHs;
        this.zHt = paramceu.zHt;
        this.Aoy = paramceu.Aoy;
        this.zVm = this.title;
        this.Afb = this.dub;
        this.Afc = this.doh;
        this.Afd = this.Aox;
      }
      AppMethodBeat.o(71012);
    }
    
    public a(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(71011);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(71011);
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("activity_change_info");
      if (paramJSONObject != null)
      {
        this.url = paramJSONObject.optString("url");
        this.doh = paramJSONObject.optString("wording");
        this.dub = paramJSONObject.optString("icon");
        this.Aox = paramJSONObject.optString("btn_text");
        this.title = paramJSONObject.optString("title");
        this.zVm = paramJSONObject.optString("tinyapp_name");
        this.Afb = paramJSONObject.optString("tinyapp_logo");
        this.Afc = paramJSONObject.optString("tinyapp_desc");
        this.zHs = paramJSONObject.optString("tinyapp_username");
        this.zHt = paramJSONObject.optString("tinyapp_path");
        this.Afd = paramJSONObject.optString("activity_tinyapp_btn_text");
      }
      AppMethodBeat.o(71011);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71013);
      String str = this.url + " , " + this.doh + " , " + this.dub + " , " + this.Aox + " , " + this.title;
      AppMethodBeat.o(71013);
      return str;
    }
  }
  
  static final class b
  {
    public long AgJ;
    public String AoA;
    public String AoB;
    public long AoC;
    public String AoD;
    public String Aoz;
    public String dlJ;
    public String vBv;
    public String zWH;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.zWH = paramString1;
      this.Aoz = paramString2;
      this.AoA = paramString3;
      this.AoB = paramString4;
      this.dlJ = paramString5;
      this.vBv = paramString6;
      this.AgJ = paramLong1;
      this.AoC = paramLong2;
      this.AoD = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.zWH = paramString1;
      this.Aoz = paramString2;
      this.AoA = paramString3;
      this.AoB = paramString4;
      this.dlJ = paramString5;
      this.vBv = paramString6;
      this.AgJ = paramLong;
      this.AoD = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */