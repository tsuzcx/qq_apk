package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.iz.a;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.a;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.q;
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
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.c.z;
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
  private String ikj;
  private String mAppId;
  private PayInfo mPayInfo;
  private String plc;
  private com.tencent.mm.sdk.b.c pns;
  private String pqF;
  private d.a.a.c qnc;
  private WalletSuccPageAwardWidget qnd;
  private ViewGroup qne;
  private ViewGroup qnf;
  private ViewGroup qng;
  private TextView qnh;
  private boolean qni;
  private com.tencent.mm.sdk.b.c<vk> qnj;
  private String qpN;
  private TextView qrh;
  private Orders tVr;
  private int uiT;
  private String unA;
  private String unC;
  private Button unD;
  private ImageView unE;
  private ViewGroup unF;
  private CdnImageView unG;
  private TextView unH;
  private TextView unI;
  private View unJ;
  private Button unK;
  private ViewGroup unL;
  private boolean unM;
  private boolean unN;
  private boolean unO;
  private com.tencent.mm.wallet_core.c unP;
  private boolean unu;
  private String unv;
  private String unw;
  private WalletOrderInfoNewUI.b uny;
  private HashMap<String, a> unz;
  protected Set<String> uqP;
  private List<Orders.Commodity> uqQ;
  private Orders.RecommendTinyAppInfo uqR;
  private String uqS;
  private Orders.Promotions uqT;
  private TextView uqU;
  private TextView uqV;
  private WalletTextView uqW;
  private ViewGroup uqX;
  private ViewGroup uqY;
  private ViewGroup uqZ;
  private ViewGroup ura;
  private ViewGroup urb;
  private ViewGroup urc;
  private TextView urd;
  private CheckBox ure;
  private ViewGroup urf;
  private CdnImageView urg;
  private TextView urh;
  private ProgressBar urj;
  private ViewGroup urk;
  private CdnImageView urm;
  private TextView urn;
  private TextView uro;
  private Button urp;
  private int urq;
  private boolean urr;
  private boolean urs;
  private com.tencent.mm.sdk.b.c urt;
  private com.tencent.mm.plugin.wallet_core.c.a uru;
  private com.tencent.mm.plugin.wallet_core.c.c urv;
  private boolean urw;
  private int urx;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(47450);
    this.ikj = null;
    this.pqF = null;
    this.unu = false;
    this.uqP = null;
    this.mAppId = "";
    this.uqQ = null;
    this.unz = new HashMap();
    this.uqT = null;
    this.unC = "-1";
    this.unM = false;
    this.unN = false;
    this.urq = 0;
    this.urr = false;
    this.urs = false;
    this.unO = false;
    this.pns = new WalletOrderInfoNewUI.1(this);
    this.urt = new WalletOrderInfoNewUI.9(this);
    this.qni = false;
    this.qnj = new WalletOrderInfoNewUI.18(this);
    this.urw = false;
    this.urx = 2;
    AppMethodBeat.o(47450);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(47464);
    this.uqP.clear();
    if ((paramOrders == null) || (paramOrders.ujl == null))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(47464);
      return;
    }
    paramOrders = paramOrders.ujl.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.ujc == 2) && (!bo.isNullOrNil(localCommodity.ujN)))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.uqP.add(localCommodity.ujN);
      }
    }
    AppMethodBeat.o(47464);
  }
  
  private void cVI()
  {
    AppMethodBeat.i(142521);
    this.urj.setVisibility(0);
    this.urg.setVisibility(8);
    AppMethodBeat.o(142521);
  }
  
  private void cVJ()
  {
    AppMethodBeat.i(142522);
    if (this.urf.getVisibility() != 0)
    {
      AppMethodBeat.o(142522);
      return;
    }
    if (!this.urr)
    {
      if (!bo.isNullOrNil(this.qnc.CLv.CLy)) {
        this.urg.setUrl(this.qnc.CLv.CLy);
      }
      if (!bo.isNullOrNil(this.qnc.CLv.CLx))
      {
        this.urh.setText(this.qnc.CLv.CLx);
        if (!bo.isNullOrNil(this.qnc.CLv.CLz)) {
          this.urh.setTextColor(Color.parseColor(this.qnc.CLv.CLz));
        }
        if (this.qnc.CLv.CLA > 0L)
        {
          this.urh.setTextSize(1, (float)this.qnc.CLv.CLA);
          AppMethodBeat.o(142522);
        }
      }
    }
    else
    {
      if (!bo.isNullOrNil(this.qnc.CLv.CLD)) {
        this.urg.setUrl(this.qnc.CLv.CLD);
      }
      if (!bo.isNullOrNil(this.qnc.CLv.CLF))
      {
        this.urh.setText(this.qnc.CLv.CLF);
        if (!bo.isNullOrNil(this.qnc.CLv.CLE)) {
          this.urh.setTextColor(Color.parseColor(this.qnc.CLv.CLE));
        }
        if (this.qnc.CLv.CLA > 0L) {
          this.urh.setTextSize(1, (float)this.qnc.CLv.CLA);
        }
      }
    }
    AppMethodBeat.o(142522);
  }
  
  private void cVK()
  {
    AppMethodBeat.i(47457);
    this.uqX.setVisibility(8);
    this.qnf.setVisibility(8);
    this.qne.setVisibility(8);
    this.qng.setVisibility(8);
    if ((this.tVr != null) && (this.uqQ != null) && (this.uqQ.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.uqQ.get(0);
      List localList = localCommodity.ujP;
      int i;
      label143:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label327;
        }
        this.qnf.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label303;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(Color.parseColor("#FA962A"));
        if (localDiscountInfo.ukh <= 0.0D) {
          break label290;
        }
        localTextView.setText(localDiscountInfo.qiO + e.e(localDiscountInfo.ukh / 100.0D, this.tVr.ppp));
      }
      for (;;)
      {
        this.qnf.addView(localTextView);
        i += 1;
        break label143;
        i = 0;
        break;
        label290:
        localTextView.setText(localDiscountInfo.qiO);
      }
      label303:
      this.qnf.setVisibility(0);
      this.uqX.setVisibility(0);
      this.qne.setVisibility(0);
      label327:
      if ((localCommodity.ujM >= 0.0D) && (localCommodity.kNS < localCommodity.ujM))
      {
        this.qnh.setText(e.e(localCommodity.ujM, localCommodity.ppp));
        this.qnh.getPaint().setFlags(16);
        this.qng.setVisibility(0);
        this.uqX.setVisibility(0);
      }
    }
    AppMethodBeat.o(47457);
  }
  
  private void cVL()
  {
    AppMethodBeat.i(47458);
    this.urc.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.tVr != null)
    {
      c(this.tVr);
      if ((this.uqQ != null) && (this.uqQ.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.uqQ.get(0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.ujW) });
        if ((localCommodity.ujW) && (localCommodity.ujV != null) && (localCommodity.ujV.size() > 0))
        {
          Iterator localIterator = localCommodity.ujV.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.ujK);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bo.isNullOrNil(localPromotions.ppq)))
      {
        this.qpN = localCommodity.cnJ;
        com.tencent.mm.plugin.report.service.h.qsU.e(13033, new Object[] { Integer.valueOf(1), localPromotions.ppq, localPromotions.url, localPromotions.name, this.qpN });
        this.urd.setText(getString(2131305363, new Object[] { localPromotions.name }));
        this.uqS = localPromotions.ppq;
        this.ure.setVisibility(0);
        if (!this.uqP.contains(localPromotions.ppq)) {
          break label331;
        }
        this.ure.setChecked(true);
      }
      for (;;)
      {
        this.urc.setOnClickListener(new WalletOrderInfoNewUI.2(this));
        this.urc.setVisibility(0);
        AppMethodBeat.o(47458);
        return;
        label331:
        this.ure.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void cVM()
  {
    AppMethodBeat.i(47459);
    this.urb.setVisibility(8);
    this.urb.removeAllViews();
    Iterator localIterator;
    if ((this.tVr != null) && (this.tVr.ujx == 1) && (this.tVr.ujz != null) && (this.tVr.ujz.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.tVr.ujz, Integer.valueOf(this.tVr.ujz.size()) });
      localIterator = this.tVr.ujz.iterator();
    }
    for (;;)
    {
      Orders.ShowInfo localShowInfo;
      LinearLayout localLinearLayout;
      TextView localTextView2;
      TextView localTextView1;
      if (localIterator.hasNext())
      {
        localShowInfo = (Orders.ShowInfo)localIterator.next();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2130971224, this.urb, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131823493);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131829287);
        if (!bo.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bo.isNullOrNil(localShowInfo.nmk)) {}
      }
      try
      {
        localTextView2.setTextColor(Color.parseColor(localShowInfo.nmk));
        label231:
        if (!bo.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.ukF == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bo.isNullOrNil(localShowInfo.ukA)) {}
        try
        {
          localTextView1.setTextColor(Color.parseColor(localShowInfo.ukA));
          label290:
          if (localShowInfo.ukB == 1) {
            if (!bo.isNullOrNil(localShowInfo.ukE)) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.3(this, localShowInfo));
            }
          }
          for (;;)
          {
            this.urb.addView(localLinearLayout);
            break;
            if ((localShowInfo.ukB == 2) && (!bo.isNullOrNil(localShowInfo.ukC))) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.4(this, localShowInfo));
            }
          }
          this.uqX.setVisibility(0);
          this.urb.setVisibility(0);
          AppMethodBeat.o(47459);
          return;
        }
        catch (Exception localException1)
        {
          break label290;
        }
      }
      catch (Exception localException2)
      {
        break label231;
      }
    }
  }
  
  private void cVr()
  {
    AppMethodBeat.i(47455);
    int j = 0;
    if (this.unF.getVisibility() == 0) {
      j = 1;
    }
    int i = j;
    if (this.uqX.getVisibility() == 0) {
      i = j + 1;
    }
    j = i;
    if (this.urc.getVisibility() == 0) {
      j = i + 1;
    }
    if (this.urk.getVisibility() == 0) {}
    for (i = j + 1;; i = j)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.unE.getLayoutParams();
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.uqU.getLayoutParams();
      if (i >= 3)
      {
        i = com.tencent.mm.cb.a.fromDPToPix(this, 40);
        localMarginLayoutParams1.topMargin = i;
      }
      for (localMarginLayoutParams2.topMargin = i;; localMarginLayoutParams2.topMargin = i)
      {
        this.unE.setLayoutParams(localMarginLayoutParams1);
        this.uqU.setLayoutParams(localMarginLayoutParams2);
        this.unL.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142519);
            int n = WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this).getHeight();
            Object localObject = WalletOrderInfoNewUI.this.findViewById(2131825962);
            if (localObject != null) {}
            for (int j = ((View)localObject).getHeight();; j = 0)
            {
              int k;
              label69:
              int m;
              if (WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this).getVisibility() == 0)
              {
                k = 1;
                if (WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).getVisibility() != 0) {
                  break label329;
                }
                i = 1;
                if (WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this).getVisibility() != 0) {
                  break label334;
                }
                m = 1;
                label85:
                if (i == 0) {
                  break label359;
                }
              }
              label329:
              label334:
              label359:
              for (int i = WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).getBottom();; i = -1)
              {
                if (k != 0) {
                  i = WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this).getBottom();
                }
                for (;;)
                {
                  if (m != 0) {
                    i = WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this).getBottom();
                  }
                  k = i;
                  if (i <= 0)
                  {
                    localObject = WalletOrderInfoNewUI.this.findViewById(2131829035);
                    k = i;
                    if (localObject != null) {
                      k = ((View)localObject).getBottom();
                    }
                  }
                  if ((WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this).getVisibility() != 0) && (WalletOrderInfoNewUI.c(WalletOrderInfoNewUI.this).getVisibility() != 0)) {}
                  for (i = com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
                  {
                    m = j - k - i;
                    n = com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 50);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n) });
                    localObject = (ViewGroup.MarginLayoutParams)WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this).getLayoutParams();
                    if (m > n) {}
                    for (((ViewGroup.MarginLayoutParams)localObject).topMargin = m;; ((ViewGroup.MarginLayoutParams)localObject).topMargin = n)
                    {
                      WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
                      WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this).setVisibility(0);
                      AppMethodBeat.o(142519);
                      return;
                      k = 0;
                      break;
                      i = 0;
                      break label69;
                      m = 0;
                      break label85;
                    }
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(47455);
        return;
        i = com.tencent.mm.cb.a.fromDPToPix(this, 70);
        localMarginLayoutParams1.topMargin = i;
      }
    }
  }
  
  private void cVs()
  {
    AppMethodBeat.i(47456);
    if ((this.tVr != null) && (this.uqQ != null) && (this.uqQ.size() > 0))
    {
      Iterator localIterator = this.uqQ.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).ppi));
    }
    for (int i = 0;; i = 1)
    {
      this.qrh.setVisibility(0);
      if (i != 0)
      {
        if ((!bo.isNullOrNil(this.tVr.uje)) && (!bo.isNullOrNil(this.tVr.uje.trim())))
        {
          this.qrh.setText(this.tVr.uje);
          AppMethodBeat.o(47456);
          return;
        }
        if (this.tVr.ubU != 1)
        {
          this.qrh.setText(2131305356);
          AppMethodBeat.o(47456);
          return;
        }
        this.qrh.setText(2131305355);
        AppMethodBeat.o(47456);
        return;
      }
      this.qrh.setText(2131305357);
      AppMethodBeat.o(47456);
      return;
    }
  }
  
  private void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(47460);
    this.unF.setVisibility(8);
    this.unN = false;
    this.unM = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.tVr != null) {
      if ((this.uqQ != null) && (this.uqQ.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.uqQ.get(0);
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).ujW) });
          if ((((Orders.Commodity)localObject2).ujV == null) || (((Orders.Commodity)localObject2).ujV.size() <= 0)) {
            break label1585;
          }
          localObject3 = ((Orders.Commodity)localObject2).ujV.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.ujL);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).ubC > 0L) && (!bo.isNullOrNil(((Orders.Promotions)localObject1).uiO)))
      {
        this.uqT = ((Orders.Promotions)localObject1);
        this.unJ.setVisibility(8);
        this.unG.setRoundCorner(true);
        this.unK.setEnabled(true);
        this.unK.setBackgroundResource(2130838045);
        this.unI.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.unz.get(((Orders.Promotions)localObject1).ubC);
        if (localObject3 != null)
        {
          if (!bo.isNullOrNil(((a)localObject3).cDz)) {
            this.unG.setUrl(((a)localObject3).cDz);
          }
          if (!bo.isNullOrNil(((a)localObject3).cyA)) {
            this.unH.setText(((a)localObject3).cyA);
          }
          if (!bo.isNullOrNil(((a)localObject3).urC))
          {
            this.unK.setText(((a)localObject3).urC);
            this.unK.setBackgroundResource(2130840866);
          }
          if (!bo.isNullOrNil(((a)localObject3).ugl)) {
            this.uqT.ukn = ((a)localObject3).ugl;
          }
          if (!bo.isNullOrNil(((a)localObject3).uaL)) {
            this.uqT.uko = ((a)localObject3).uaL;
          }
          if (((a)localObject3).urD > 0) {
            this.uqT.ukp = ((a)localObject3).urD;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.unI.getLayoutParams();
          if ((localObject3 == null) || (bo.isNullOrNil(((a)localObject3).title))) {
            break label872;
          }
          this.unI.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.unI.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.unK.setVisibility(0);
          this.unK.setOnClickListener(new WalletOrderInfoNewUI.5(this));
          if (((Orders.Promotions)localObject1).ukk != 1) {
            this.unF.setOnClickListener(new WalletOrderInfoNewUI.6(this));
          }
          localObject3 = this.unC;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.unF.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).ujP;
              if (((((Orders.Commodity)localObject2).ujM >= 0.0D) && (((Orders.Commodity)localObject2).kNS < ((Orders.Commodity)localObject2).ujM)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.unF.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.unF.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.qsU;
                  localObject4 = this.qpN;
                  i = ((Orders.Promotions)localObject1).ukk;
                  if (!this.unC.equals("-1")) {
                    break label1044;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).e(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).ubC), Long.valueOf(((Orders.Promotions)localObject1).uiN) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label872:
      while ((((Orders.Commodity)localObject2).ujT == null) || (bo.isNullOrNil(((Orders.Commodity)localObject2).ujT.ugl))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.unH.getVisibility() == 0)
          {
            this.unH.setSingleLine();
            this.unH.post(new WalletOrderInfoNewUI.8(this));
          }
          AppMethodBeat.o(47460);
          return;
          this.unG.setUrl(((Orders.Promotions)localObject1).pvi);
          this.unH.setText(((Orders.Promotions)localObject1).name);
          this.unK.setText(((Orders.Promotions)localObject1).uiO);
          continue;
          if (!bo.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.unI.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.unI.setVisibility(8);
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
                        this.unK.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.unC;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1044:
      this.unv = ((Orders.Commodity)localObject2).ujT.ugl;
      this.unw = ((Orders.Commodity)localObject2).ujT.uaL;
      this.uiT = ((Orders.Commodity)localObject2).ujT.uiT;
      this.uqR = ((Orders.Commodity)localObject2).ujT;
      this.unG.setUrl(((Orders.Commodity)localObject2).ujT.uiQ);
      this.unH.setText(((Orders.Commodity)localObject2).ujT.uiR);
      this.unI.setText(getString(2131304784));
      this.unI.setVisibility(0);
      this.unG.setRoundCorner(true);
      this.unK.setEnabled(true);
      this.unK.setBackgroundResource(2130838045);
      localObject1 = (RelativeLayout.LayoutParams)this.unI.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.unI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).ujT.uks > 0L)
      {
        if (!bo.isNullOrNil(((Orders.Commodity)localObject2).ujT.uiS))
        {
          this.unK.setVisibility(0);
          this.unK.setText(((Orders.Commodity)localObject2).ujT.uiS);
          this.unJ.setVisibility(8);
        }
        localObject1 = (a)this.unz.get(((Orders.Commodity)localObject2).ujT.uks);
        if (localObject1 != null)
        {
          if (!bo.isNullOrNil(((a)localObject1).uiQ)) {
            this.unG.setUrl(((a)localObject1).uiQ);
          }
          if (!bo.isNullOrNil(((a)localObject1).uiR)) {
            this.unH.setText(((a)localObject1).uiR);
          }
          if (!bo.isNullOrNil(((a)localObject1).uiS))
          {
            this.unK.setText(((a)localObject1).uiS);
            this.unK.setBackgroundResource(2130840866);
          }
          if (!bo.isNullOrNil(((a)localObject1).ugl)) {
            this.unv = ((a)localObject1).ugl;
          }
          if (!bo.isNullOrNil(((a)localObject1).uaL)) {
            this.unw = ((a)localObject1).uaL;
          }
          if (((a)localObject1).urD > 0) {
            this.uiT = ((a)localObject1).urD;
          }
        }
        label1443:
        localObject1 = new WalletOrderInfoNewUI.7(this, (Orders.Commodity)localObject2);
        this.unF.setOnClickListener((View.OnClickListener)localObject1);
        this.unK.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.unF.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).ujP;
        if (((((Orders.Commodity)localObject2).ujM < 0.0D) || (((Orders.Commodity)localObject2).kNS >= ((Orders.Commodity)localObject2).ujM)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1572;
        }
      }
      label1572:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50))
      {
        this.unF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.unF.setVisibility(0);
        break;
        this.unK.setVisibility(8);
        this.unJ.setVisibility(8);
        break label1443;
      }
      label1585:
      localObject1 = null;
    }
  }
  
  protected final void afI(String paramString)
  {
    AppMethodBeat.i(47461);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    cVu();
    e.m(this, paramString, true);
    AppMethodBeat.o(47461);
  }
  
  public final void cVN()
  {
    int j = 1;
    AppMethodBeat.i(47466);
    cVu();
    Object localObject1 = new aq();
    ((aq)localObject1).cnV.cnW = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new gr();
    ((gr)localObject1).cvE.cvF = "ok";
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.uqP.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!bo.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.tVr == null) || (this.mPayInfo == null)) {
          break label369;
        }
        p localp = com.tencent.mm.kernel.g.RK().eHt;
        String str2 = this.tVr.cnI;
        if (this.tVr.ujl.size() <= 0) {
          break label363;
        }
        localObject1 = ((Orders.Commodity)this.tVr.ujl.get(0)).cnJ;
        label280:
        localp.a(new com.tencent.mm.wallet_core.c.r(str1, str2, (String)localObject1, this.mPayInfo.cCD, this.mPayInfo.cCy, this.tVr.ujc), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label363:
        localObject1 = "";
        break label280;
        label369:
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.wallet_core.c.r(str1), 0);
      }
    }
    if (this.unP != null)
    {
      this.unP.a(this, 0, (Bundle)localObject2);
      this.unP = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.cCD != 46) && (this.mPayInfo.cCD != 3))) {
        break label925;
      }
      localObject1 = new bq();
      if (this.mPayInfo.cCD != 46) {
        break label825;
      }
      ((bq)localObject1).cYJ = 2L;
      label472:
      if ((this.tVr == null) || (this.tVr.ujy != 0)) {
        break label844;
      }
      ((bq)localObject1).cYK = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.wgv != null))
      {
        localObject2 = this.mPayInfo.wgv.getString("extinfo_key_20", "");
        if (!bo.isNullOrNil((String)localObject2)) {
          ((bq)localObject1).gL((String)localObject2);
        }
        localObject2 = this.mPayInfo.wgv.getString("extinfo_key_21", "");
        if (!bo.isNullOrNil((String)localObject2)) {
          ((bq)localObject1).gN((String)localObject2);
        }
        localObject2 = this.mPayInfo.wgv.getString("extinfo_key_22", "");
        if (!bo.isNullOrNil((String)localObject2)) {
          ((bq)localObject1).gM((String)localObject2);
        }
      }
      if ((this.tVr != null) && (this.tVr.ujy == 0) && (!bo.isNullOrNil(this.tVr.ujB)) && (!bo.isNullOrNil(this.tVr.ujA)))
      {
        ((bq)localObject1).gP(this.tVr.ujB);
        ((bq)localObject1).gO(this.tVr.ujA);
      }
      ((bq)localObject1).ake();
      if ((this.tVr == null) || (this.tVr.ujy != 0) || (bo.isNullOrNil(this.tVr.ujB)) || (bo.isNullOrNil(this.tVr.ujA))) {
        break label925;
      }
      localObject1 = new so();
      ((so)localObject1).cIQ.userName = this.tVr.ujA;
      ((so)localObject1).cIQ.cIS = this.tVr.ujB;
      ((so)localObject1).cIQ.scene = 1060;
      ((so)localObject1).cIQ.cmF = this.plc;
      ((so)localObject1).cIQ.cIT = 0;
      ((so)localObject1).cIQ.context = this;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(47466);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label825:
      if (this.mPayInfo.cCD != 3) {
        break label472;
      }
      ((bq)localObject1).cYJ = 1L;
      break label472;
      label844:
      if ((this.tVr != null) && (this.tVr.ujy == 1)) {
        ((bq)localObject1).cYK = 2L;
      } else if ((this.tVr != null) && (this.tVr.ujy == 0) && (!bo.isNullOrNil(this.tVr.ujB)) && (!bo.isNullOrNil(this.tVr.ujA))) {
        ((bq)localObject1).cYK = 3L;
      }
    }
    label925:
    int i;
    if ((this.tVr != null) && (!bo.isNullOrNil(this.tVr.lHq)))
    {
      if (this.tVr.ujl.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.tVr.ujl.get(0)).cnJ;
        localObject1 = e(this.tVr.lHq, this.tVr.cnI, (String)localObject1, this.mPayInfo.kmA, this.mPayInfo.hKa);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", com.tencent.mm.model.r.Zn());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      }
    }
    else if ((this.urf.getVisibility() == 0) && (this.qnc.CLv != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      localObject2 = this.qpN;
      localObject3 = this.urh.getText();
      if (this.qnc.CLv.CLw != 0) {
        break label1221;
      }
      i = 1;
      label1146:
      if (!this.urr) {
        break label1226;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).e(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.urx), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(47466);
      return;
      localObject1 = "";
      break;
      label1221:
      i = 2;
      break label1146;
      label1226:
      j = 2;
    }
  }
  
  protected void cVu()
  {
    int i = 0;
    AppMethodBeat.i(47469);
    if (!this.unu)
    {
      iz localiz = new iz();
      localiz.cyt.requestCode = 4;
      iz.a locala = localiz.cyt;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bpE = i;
      localiz.cyt.cyu = new Intent();
      if (this.tVr != null) {
        localiz.cyt.cyu.putExtra("key_jsapi_close_page_after_pay", this.tVr.ujy);
      }
      if ((this.tVr != null) && (this.tVr.ujy == 0) && (!bo.isNullOrNil(this.tVr.ujB)) && (!bo.isNullOrNil(this.tVr.ujA))) {
        localiz.cyt.cyu.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.unP != null) {
        localiz.cyt.cyu.putExtra("key_is_clear_failure", this.unP.mEJ.getInt("key_is_clear_failure", -1));
      }
      com.tencent.mm.sdk.b.a.ymk.l(localiz);
      this.unu = true;
    }
    AppMethodBeat.o(47469);
  }
  
  protected final boolean chF()
  {
    return false;
  }
  
  public void done()
  {
    AppMethodBeat.i(47465);
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool1 = localRealnameGuideHelper.b(this, localBundle, new WalletOrderInfoNewUI.14(this));
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new WalletOrderInfoNewUI.15(this));
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          cVN();
        }
      }
      AppMethodBeat.o(47465);
      return;
    }
    cVN();
    AppMethodBeat.o(47465);
  }
  
  public void finish()
  {
    AppMethodBeat.i(47451);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, bo.dtY() });
    if (this.qni)
    {
      AppMethodBeat.o(47451);
      return;
    }
    super.finish();
    this.qni = true;
    AppMethodBeat.o(47451);
  }
  
  public int getLayoutId()
  {
    return 2130971225;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47454);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.unE = ((ImageView)findViewById(2131829036));
    this.qrh = ((TextView)findViewById(2131829037));
    this.uqU = ((TextView)findViewById(2131829288));
    this.uqV = ((TextView)findViewById(2131829290));
    this.uqW = ((WalletTextView)findViewById(2131829291));
    this.qnh = ((TextView)findViewById(2131827202));
    this.unD = ((Button)findViewById(2131829040));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131296964);
    Object localObject1;
    int i;
    label723:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 2)) {
      if ((this.tVr != null) && (!bo.isNullOrNil(this.tVr.ujw)))
      {
        localObject1 = this.tVr.ujw;
        this.unD.setText((CharSequence)localObject1);
        this.unD.setOnClickListener(new WalletOrderInfoNewUI.19(this));
        this.uqX = ((ViewGroup)findViewById(2131829292));
        this.qnf = ((ViewGroup)findViewById(2131827193));
        this.unL = ((ViewGroup)findViewById(2131829039));
        this.qne = ((ViewGroup)findViewById(2131827192));
        this.qng = ((ViewGroup)findViewById(2131827201));
        this.uqY = ((ViewGroup)findViewById(2131829294));
        this.uqZ = ((ViewGroup)findViewById(2131829296));
        this.urb = ((ViewGroup)findViewById(2131829293));
        this.ura = ((ViewGroup)findViewById(2131829298));
        this.unF = ((ViewGroup)findViewById(2131827332));
        this.unG = ((CdnImageView)findViewById(2131827333));
        this.unG.setUseSdcardCache(true);
        this.unH = ((TextView)findViewById(2131827335));
        this.unI = ((TextView)findViewById(2131827334));
        this.unK = ((Button)findViewById(2131827336));
        this.unJ = findViewById(2131827211);
        this.urc = ((ViewGroup)findViewById(2131829305));
        this.urd = ((TextView)findViewById(2131829307));
        this.ure = ((CheckBox)findViewById(2131829306));
        this.urk = ((ViewGroup)findViewById(2131829308));
        this.urm = ((CdnImageView)findViewById(2131829309));
        this.urm.setUseSdcardCache(true);
        this.uro = ((TextView)findViewById(2131829311));
        this.urn = ((TextView)findViewById(2131829310));
        this.urp = ((Button)findViewById(2131829312));
        this.urf = ((ViewGroup)findViewById(2131829301));
        this.urh = ((TextView)findViewById(2131829304));
        this.urg = ((CdnImageView)findViewById(2131829302));
        this.urj = ((ProgressBar)findViewById(2131829303));
        this.unL.setVisibility(4);
        this.qnd = ((WalletSuccPageAwardWidget)findViewById(2131827212));
        cVs();
        if ((this.tVr != null) && (this.uqQ != null) && (this.uqQ.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.uqQ.get(0);
          this.uqU.setText(((Orders.Commodity)localObject1).ppe);
          this.uqV.setText(e.avZ(((Orders.Commodity)localObject1).ppp));
          this.uqW.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).kNS) }));
        }
        if (this.tVr != null) {
          break label1440;
        }
        i = 0;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.tVr == null) || (this.tVr.ujx != 1)) {
          break label1451;
        }
        this.uqY.setVisibility(8);
        this.uqZ.setVisibility(8);
        this.qng.setVisibility(8);
        this.qne.setVisibility(8);
        this.ura.setVisibility(8);
        cVM();
        label809:
        cVL();
        if ((this.uqQ == null) || (this.uqQ.size() <= 0)) {
          break label1886;
        }
        localObject1 = (Orders.Commodity)this.uqQ.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).ujV == null) || (((Orders.Commodity)localObject1).ujV.size() <= 0)) {
          break label1883;
        }
        localObject2 = ((Orders.Commodity)localObject1).ujV.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).ukr != null) && (((Orders.Promotions)localObject3).ukk == 5)) || ((((Orders.Promotions)localObject3).ukr != null) && (((Orders.Promotions)localObject3).ukr.CLv != null)))
          {
            this.qnc = ((Orders.Promotions)localObject3).ukr;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.qnc, Integer.valueOf(((Orders.Promotions)localObject3).ukk) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.qnc)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.qnd.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).ujP;
          if (((((Orders.Commodity)localObject1).ujM >= 0.0D) && (((Orders.Commodity)localObject1).kNS < ((Orders.Commodity)localObject1).ujM)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1046:
            this.qnd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.qnd.a(this, this.qnc, this.plc, false, (ImageView)findViewById(2131824152));
          this.qnd.init();
          this.qnd.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131824152);
          ((ImageView)localObject1).post(new WalletOrderInfoNewUI.20(this, (ImageView)localObject1));
          label1121:
          if ((this.qnc == null) || (this.qnc.CLv == null)) {
            break label1830;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.qnc.CLv.CLw) });
          this.urf.setVisibility(0);
          if (this.qnc.CLv.CLw != 0) {
            break label1747;
          }
          this.urr = false;
          com.tencent.mm.plugin.report.service.h.qsU.e(17267, new Object[] { this.qpN, this.qnc.CLv.CLx, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1440:
      label1830:
      for (;;)
      {
        cVJ();
        bo.n(this.urf, 12, 12, 12, 12);
        this.urf.setOnClickListener(new WalletOrderInfoNewUI.21(this));
        cVr();
        AppMethodBeat.o(47454);
        return;
        if (!bo.isNullOrNil(this.mPayInfo.uAe))
        {
          localObject1 = getString(2131296546) + this.mPayInfo.uAe;
          break;
        }
        localObject1 = localObject2;
        if (bo.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bo.isNullOrNil(com.tencent.mm.pluginsdk.model.app.g.t(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131296546) + com.tencent.mm.pluginsdk.model.app.g.t(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.tVr == null) {
          break;
        }
        localObject1 = localObject2;
        if (bo.isNullOrNil(this.tVr.ujw)) {
          break;
        }
        localObject1 = this.tVr.ujw;
        break;
        i = this.tVr.ujx;
        break label723;
        label1451:
        cVK();
        if ((this.tVr != null) && (this.uqQ != null) && (this.uqQ.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.uqQ.get(0);
          if (((Orders.Commodity)localObject1).ujU != null)
          {
            localObject2 = (TextView)this.ura.findViewById(2131829299);
            localObject3 = (TextView)this.ura.findViewById(2131829300);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).ujU.uky);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).ujU.ukz);
            this.ura.setVisibility(0);
            this.uqX.setVisibility(0);
          }
        }
        this.uqZ.setVisibility(8);
        this.uqY.setVisibility(8);
        if ((this.tVr == null) || (this.uqQ == null) || (this.uqQ.size() <= 0)) {
          break label809;
        }
        localObject1 = (Orders.Commodity)this.uqQ.get(0);
        if (!bo.isNullOrNil(((Orders.Commodity)localObject1).ujS))
        {
          ((TextView)findViewById(2131829295)).setText(((Orders.Commodity)localObject1).ujS);
          this.uqY.setVisibility(0);
          this.uqX.setVisibility(0);
        }
        if (bo.isNullOrNil(((Orders.Commodity)localObject1).ujQ)) {
          break label809;
        }
        ((TextView)findViewById(2131829297)).setText(((Orders.Commodity)localObject1).ujQ);
        this.uqZ.setVisibility(0);
        this.uqX.setVisibility(0);
        break label809;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
        break label1046;
        nM(true);
        this.qnd.setVisibility(8);
        break label1121;
        label1747:
        if (this.qnc.CLv.CLw == 1)
        {
          this.urr = true;
          com.tencent.mm.plugin.report.service.h.qsU.e(17267, new Object[] { this.qpN, this.qnc.CLv.CLF, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.urf.setVisibility(8);
          continue;
          this.urf.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.qsU.e(17267, new Object[] { this.qpN, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1883:
      continue;
      label1886:
      localObject1 = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47462);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bo.isNullOrNil(this.uny.urI)), Boolean.valueOf(this.urs) });
      if (this.urs)
      {
        AppMethodBeat.o(47462);
        return;
      }
      this.urs = true;
      if (bo.isNullOrNil(this.uny.urI))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(this.uny.uca, this.uny.urE, this.uny.urF, this.uny.urG, this.uny.cwk, this.uny.qkt, this.uny.ukx));
        AppMethodBeat.o(47462);
        return;
      }
      doSceneProgress(new n(this.uny.urI, this.uny.uca));
    }
    AppMethodBeat.o(47462);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47452);
    super.onCreate(paramBundle);
    label221:
    boolean bool1;
    label249:
    int j;
    label256:
    label518:
    label534:
    vk.a locala;
    if (com.tencent.mm.compatible.util.d.fv(21))
    {
      if (com.tencent.mm.compatible.util.d.fv(23))
      {
        getWindow().setStatusBarColor(-1);
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.uqP = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.aM(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.plc = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.plc });
      this.tVr = cVH();
      if (this.tVr == null) {
        break label836;
      }
      setContentViewVisibility(0);
      c(this.tVr);
      Object localObject;
      if ((paramBundle != null) && (this.tVr != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.dRQ();
        com.tencent.mm.plugin.wallet_core.utils.d.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label785;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.qsU;
        int k = this.mPayInfo.cCD;
        if (this.mPayInfo.cCD != 3) {
          break label790;
        }
        bool1 = true;
        if (!bool2) {
          break label796;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).e(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(z.dSu()), Integer.valueOf((int)(this.tVr.cnL * 100.0D)), this.tVr.ppp, Integer.valueOf(i) });
      }
      if (((!t.cTN().cUl()) && (paramBundle != null) && (paramBundle.dRQ())) || (!com.tencent.mm.model.r.Zw())) {
        com.tencent.mm.model.r.Zx();
      }
      if ((this.tVr == null) || (this.tVr.ujl == null) || (this.tVr.ujl.size() <= 0)) {
        break label801;
      }
      this.uqQ = this.tVr.ujl;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.uqQ.size()) });
      this.plc = ((Orders.Commodity)this.uqQ.get(0)).cnJ;
      this.qpN = ((Orders.Commodity)this.uqQ.get(0)).cnJ;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.dRP()) || (paramBundle.dRQ()))) {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(getPayReqKey(), 21));
      }
      ((i)com.tencent.mm.kernel.g.E(i.class)).g(this);
      initView();
      this.unP = getProcess();
      cVs();
      if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 46))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new vk();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.tVr != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.tVr.cnL);
        }
        if (this.unP != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.unP.mEJ.getInt("key_is_clear_failure", -1));
        }
        paramBundle.cMA.intent = ((Intent)localObject);
        paramBundle.cMA.cMD = 1;
        paramBundle.cMA.cnI = getPayReqKey();
        locala = paramBundle.cMA;
        if (!((Intent)localObject).getBooleanExtra("intent_pay_end", false)) {
          break label871;
        }
      }
    }
    label785:
    label790:
    label796:
    label801:
    label836:
    label871:
    for (int i = -1;; i = 0)
    {
      locala.result = i;
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      if ((this.tVr == null) || (this.tVr.ujJ == null) || (this.tVr.ujJ.ukG != 1)) {
        break label876;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      cVN();
      AppMethodBeat.o(47452);
      return;
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      break;
      i = 1;
      break label221;
      bool1 = false;
      break label249;
      j = 2;
      break label256;
      com.tencent.mm.sdk.platformtools.ab.b("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new WalletOrderInfoNewUI.23(this));
      break label518;
      com.tencent.mm.sdk.platformtools.ab.b("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142520);
          WalletOrderInfoNewUI.this.finish();
          AppMethodBeat.o(142520);
        }
      });
      break label534;
    }
    label876:
    addSceneEndListener(1979);
    addSceneEndListener(2948);
    addSceneEndListener(2710);
    com.tencent.mm.sdk.b.a.ymk.c(this.urt);
    com.tencent.mm.sdk.b.a.ymk.c(this.pns);
    this.qnj.alive();
    this.unO = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label978;
      }
    }
    label978:
    for (paramBundle = "";; paramBundle = this.mPayInfo.cnI)
    {
      com.tencent.mm.wallet_core.c.ad.e(i, paramBundle, 16, "");
      AppMethodBeat.o(47452);
      return;
      i = this.mPayInfo.cCD;
      break;
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(47463);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131305351), getResources().getStringArray(2131755065), "", new h.c()
    {
      public final void iA(int paramAnonymousInt)
      {
        AppMethodBeat.i(142512);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(142512);
          return;
          Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this)));
          localIntent.addFlags(268435456);
          WalletOrderInfoNewUI.this.startActivity(localIntent);
        }
      }
    });
    AppMethodBeat.o(47463);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47468);
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.qnc != null) && (this.qnc.CLv != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.qnc.CLv.wKD, this.qnc.CLv.CLw, this.urq).adl().h(new WalletOrderInfoNewUI.13(this));
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.urt);
    com.tencent.mm.sdk.b.a.ymk.d(this.pns);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.qnj.dead();
    if (WalletSuccPageAwardWidget.a(this.qnc)) {
      this.qnd.onDestroy();
    }
    if (this.uru != null) {
      this.uru.cancel();
    }
    if (this.urv != null) {
      this.urv.cancel();
    }
    AppMethodBeat.o(47468);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47467);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(47467);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47467);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47453);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.unO), this.uqT, Boolean.valueOf(this.unM), Boolean.valueOf(this.unN), this.uqR, this.qnc });
    if (WalletSuccPageAwardWidget.a(this.qnc))
    {
      this.qnd.onResume();
      AppMethodBeat.o(47453);
      return;
    }
    if (this.unO)
    {
      this.unO = false;
      AppMethodBeat.o(47453);
      return;
    }
    if ((this.uqT != null) && (this.unN))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bo.isNullOrNil(this.uqT.uWi)), this.uqT.uWi, Boolean.valueOf(this.urs) });
      if (this.urs)
      {
        AppMethodBeat.o(47453);
        return;
      }
      this.urs = true;
      if (bo.isNullOrNil(this.uqT.uWi))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(this.uqT.ubC, this.uqT.ukl, this.uqT.uiL, this.uqT.uiM, getPayReqKey(), this.qpN, this.uqT.uiN));
        AppMethodBeat.o(47453);
        return;
      }
      doSceneProgress(new n(this.uqT.uWi, this.uqT.ubC));
      AppMethodBeat.o(47453);
      return;
    }
    if ((this.unM) && (this.uqR != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(this.uqR.uks, this.uqR.uku, this.uqR.ukv, this.uqR.ukw, getPayReqKey(), this.qpN, this.uqR.ukx));
    }
    AppMethodBeat.o(47453);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47470);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if ((WalletSuccPageAwardWidget.a(this.qnc)) && (this.qnd.onSceneEnd(paramInt1, paramInt2, paramString, paramm)))
    {
      AppMethodBeat.o(47470);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ad)paramm;
        paramm = new a(paramString.hxd);
        if (this.uny != null)
        {
          this.unz.put(paramString.uca, paramm);
          nM(false);
          cVr();
        }
      }
      else
      {
        this.urs = false;
      }
    }
    label279:
    do
    {
      AppMethodBeat.o(47470);
      return false;
      if (!this.unM) {
        break;
      }
      this.unz.put(paramString.uca, paramm);
      nM(false);
      cVr();
      break;
      if ((paramm instanceof n))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (n)paramm;
          paramm = paramString.ubI;
          if (paramm.koj == 0)
          {
            paramm = new a(paramm);
            if (this.uny == null) {
              break label279;
            }
            this.unz.put(paramString.sWB, paramm);
            nM(false);
            cVr();
          }
        }
        for (;;)
        {
          this.urs = false;
          break;
          if (this.unM)
          {
            this.unz.put(paramString.sWB, paramm);
            nM(false);
            cVr();
          }
        }
      }
      if ((paramm instanceof q))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (q)paramm;
          paramm = paramString.ubJ;
          if ((this.uqT != null) && (this.uqT.ubC == paramString.ubM.ubC))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.uqT });
            this.unC = paramm;
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.ubM.uiO });
            nM(false);
            cVr();
            if ((!bo.isNullOrNil(paramString.eev)) && (!"3".equals(paramm))) {
              this.unK.setText(paramString.eev);
            }
          }
          if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bo.isNullOrNil(paramString.ubK))) {
            com.tencent.mm.ui.base.h.b(this, paramString.ubK, "", true);
          }
          while (!"0".equals(paramm))
          {
            AppMethodBeat.o(47470);
            return true;
          }
          if (!bo.isNullOrNil(paramString.ubK)) {}
          for (paramString = paramString.ubK;; paramString = getString(2131305444))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramm = paramString;
        if (bo.isNullOrNil(paramString)) {
          paramm = getString(2131305682);
        }
        com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoNewUI.16(this));
        AppMethodBeat.o(47470);
        return true;
      }
    } while (!(paramm instanceof k));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (k)paramm;
      paramm = paramString.ubB;
      String str;
      if (paramm.koj == 0)
      {
        str = paramm.wZh;
        if ((this.uqT != null) && (this.uqT.ubC == paramString.ubC))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.uqT });
          this.unC = str;
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramm.wZj });
          nM(false);
          cVr();
          if ((!bo.isNullOrNil(paramm.wZj)) && (!"3".equals(str))) {
            this.unK.setText(paramm.wZj);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bo.isNullOrNil(paramm.wZi))) {
          break label829;
        }
        com.tencent.mm.ui.base.h.b(this, paramm.wZi, "", true);
      }
      label829:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(47470);
        return true;
      }
      if (!bo.isNullOrNil(paramm.wZi)) {}
      for (paramString = paramm.wZi;; paramString = getString(2131305444))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramm = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramm = getString(2131305682);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoNewUI.17(this));
    AppMethodBeat.o(47470);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(47471);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(47471);
  }
  
  static final class a
  {
    public String cDz;
    public String cyA;
    public String title;
    public String uaK;
    public String uaL;
    public String ugl;
    public String uiQ;
    public String uiR;
    public String uiS;
    public String urC;
    public int urD;
    public String url;
    
    public a(bpz parambpz)
    {
      AppMethodBeat.i(47448);
      if ((parambpz != null) && (parambpz.xEq != null))
      {
        parambpz = parambpz.xEq;
        this.url = parambpz.url;
        this.cyA = parambpz.cyA;
        this.cDz = parambpz.cDz;
        this.urC = parambpz.urC;
        this.title = parambpz.title;
        this.ugl = parambpz.ugl;
        this.uaL = parambpz.uaL;
        this.urD = parambpz.urD;
        this.uaK = this.title;
        this.uiQ = this.cDz;
        this.uiR = this.cyA;
        this.uiS = this.urC;
      }
      AppMethodBeat.o(47448);
    }
    
    public a(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(47447);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(47447);
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("activity_change_info");
      if (paramJSONObject != null)
      {
        this.url = paramJSONObject.optString("url");
        this.cyA = paramJSONObject.optString("wording");
        this.cDz = paramJSONObject.optString("icon");
        this.urC = paramJSONObject.optString("btn_text");
        this.title = paramJSONObject.optString("title");
        this.uaK = paramJSONObject.optString("tinyapp_name");
        this.uiQ = paramJSONObject.optString("tinyapp_logo");
        this.uiR = paramJSONObject.optString("tinyapp_desc");
        this.ugl = paramJSONObject.optString("tinyapp_username");
        this.uaL = paramJSONObject.optString("tinyapp_path");
        this.uiS = paramJSONObject.optString("activity_tinyapp_btn_text");
      }
      AppMethodBeat.o(47447);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47449);
      String str = this.url + " , " + this.cyA + " , " + this.cDz + " , " + this.urC + " , " + this.title;
      AppMethodBeat.o(47449);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */