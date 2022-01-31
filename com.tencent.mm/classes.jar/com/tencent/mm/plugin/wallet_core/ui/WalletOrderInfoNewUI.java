package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.an;
import com.tencent.mm.h.a.gm;
import com.tencent.mm.h.a.is;
import com.tencent.mm.h.a.is.a;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
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
  private String hcm = null;
  private String mAppId = "";
  private String mKL;
  private com.tencent.mm.sdk.b.c mNd = new WalletOrderInfoNewUI.1(this);
  private String mQr = null;
  private b.a.a.c nBp;
  private WalletSuccPageAwardWidget nBq;
  private ViewGroup nBr;
  private ViewGroup nBs;
  private ViewGroup nBt;
  private TextView nBu;
  private String nDd;
  private PayInfo nDu;
  private TextView nEk;
  private boolean qAJ = false;
  private String qAK;
  private String qAL;
  private WalletOrderInfoNewUI.b qAN;
  private HashMap<String, a> qAO = new HashMap();
  private String qAP;
  private String qAR = "-1";
  private Button qAS;
  private ImageView qAT;
  private ViewGroup qAU;
  private CdnImageView qAV;
  private TextView qAW;
  private TextView qAX;
  private View qAY;
  private Button qAZ;
  private ViewGroup qBa;
  private boolean qBb = false;
  private boolean qBc = false;
  private boolean qBd = false;
  private com.tencent.mm.wallet_core.c qBe;
  public Set<String> qDU = null;
  private List<Orders.Commodity> qDV = null;
  private Orders.RecommendTinyAppInfo qDW;
  private String qDX;
  private Orders.Promotions qDY = null;
  private TextView qDZ;
  private TextView qEa;
  private WalletTextView qEb;
  private ViewGroup qEc;
  private ViewGroup qEd;
  private ViewGroup qEe;
  private ViewGroup qEf;
  private ViewGroup qEg;
  private ViewGroup qEh;
  private TextView qEi;
  private CheckBox qEj;
  private ViewGroup qEk;
  private CdnImageView qEl;
  private TextView qEm;
  private TextView qEn;
  private Button qEo;
  private boolean qEp = false;
  private com.tencent.mm.sdk.b.c qEq = new WalletOrderInfoNewUI.9(this);
  private Orders qmc;
  private int qwv;
  
  private void b(Orders paramOrders)
  {
    this.qDU.clear();
    if ((paramOrders == null) || (paramOrders.qwN == null)) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
    }
    for (;;)
    {
      return;
      paramOrders = paramOrders.qwN.iterator();
      while (paramOrders.hasNext())
      {
        Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
        if ((localCommodity.qwE == 2) && (!bk.bl(localCommodity.qxf)))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
          this.qDU.add(localCommodity.qxf);
        }
      }
    }
  }
  
  private void bWH()
  {
    this.qEc.setVisibility(8);
    this.nBs.setVisibility(8);
    this.nBr.setVisibility(8);
    this.nBt.setVisibility(8);
    if ((this.qmc != null) && (this.qDV != null) && (this.qDV.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.qDV.get(0);
      List localList = localCommodity.qxh;
      int i;
      label136:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label323;
        }
        this.nBs.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label299;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(this.mController.uMN);
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(Color.parseColor("#FA962A"));
        if (localDiscountInfo.qxz <= 0.0D) {
          break label286;
        }
        localTextView.setText(localDiscountInfo.nxN + e.d(localDiscountInfo.qxz / 100.0D, this.qmc.mOZ));
      }
      for (;;)
      {
        this.nBs.addView(localTextView);
        i += 1;
        break label136;
        i = 0;
        break;
        label286:
        localTextView.setText(localDiscountInfo.nxN);
      }
      label299:
      this.nBs.setVisibility(0);
      this.qEc.setVisibility(0);
      this.nBr.setVisibility(0);
      label323:
      if ((localCommodity.qxe >= 0.0D) && (localCommodity.iHP < localCommodity.qxe))
      {
        this.nBu.setText(e.d(localCommodity.qxe, localCommodity.mOZ));
        this.nBu.getPaint().setFlags(16);
        this.nBt.setVisibility(0);
        this.qEc.setVisibility(0);
      }
    }
  }
  
  private void bWI()
  {
    this.qEh.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.qmc != null)
    {
      b(this.qmc);
      if ((this.qDV != null) && (this.qDV.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.qDV.get(0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.qxo) });
        if ((localCommodity.qxo) && (localCommodity.qxn != null) && (localCommodity.qxn.size() > 0))
        {
          Iterator localIterator = localCommodity.qxn.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.qxc);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bk.bl(localPromotions.mPa)))
      {
        this.nDd = localCommodity.bMY;
        com.tencent.mm.plugin.report.service.h.nFQ.f(13033, new Object[] { Integer.valueOf(1), localPromotions.mPa, localPromotions.url, localPromotions.name, this.nDd });
        this.qEi.setText(getString(a.i.wallet_order_info_subscribe_biz, new Object[] { localPromotions.name }));
        this.qDX = localPromotions.mPa;
        this.qEj.setVisibility(0);
        if (!this.qDU.contains(localPromotions.mPa)) {
          break label319;
        }
        this.qEj.setChecked(true);
      }
      for (;;)
      {
        this.qEh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (!bk.bl(WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this)))
            {
              if (WalletOrderInfoNewUI.this.qDU.contains(WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this)))
              {
                WalletOrderInfoNewUI.this.qDU.remove(WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this));
                WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).setChecked(false);
              }
            }
            else {
              return;
            }
            WalletOrderInfoNewUI.this.qDU.add(WalletOrderInfoNewUI.j(WalletOrderInfoNewUI.this));
            WalletOrderInfoNewUI.k(WalletOrderInfoNewUI.this).setChecked(true);
          }
        });
        this.qEh.setVisibility(0);
        return;
        label319:
        this.qEj.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void bWJ()
  {
    this.qEg.setVisibility(8);
    this.qEg.removeAllViews();
    Iterator localIterator;
    if ((this.qmc != null) && (this.qmc.qwZ == 1) && (this.qmc.qxb != null) && (this.qmc.qxb.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.qmc.qxb, Integer.valueOf(this.qmc.qxb.size()) });
      localIterator = this.qmc.qxb.iterator();
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
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.wallet_order_info_show_info_layout, this.qEg, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(a.f.left_tv);
        localTextView1 = (TextView)localLinearLayout.findViewById(a.f.right_tv);
        if (!bk.bl(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bk.bl(localShowInfo.kOn)) {}
      }
      try
      {
        localTextView2.setTextColor(Color.parseColor(localShowInfo.kOn));
        label225:
        if (!bk.bl(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.qxX == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bk.bl(localShowInfo.qxS)) {}
        try
        {
          localTextView1.setTextColor(Color.parseColor(localShowInfo.qxS));
          label284:
          if (localShowInfo.qxT == 1) {
            if (!bk.bl(localShowInfo.qxW)) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.19(this, localShowInfo));
            }
          }
          for (;;)
          {
            this.qEg.addView(localLinearLayout);
            break;
            if ((localShowInfo.qxT == 2) && (!bk.bl(localShowInfo.qxU))) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.2(this, localShowInfo));
            }
          }
          this.qEc.setVisibility(0);
          this.qEg.setVisibility(0);
          return;
        }
        catch (Exception localException1)
        {
          break label284;
        }
      }
      catch (Exception localException2)
      {
        break label225;
      }
    }
  }
  
  private void bWu()
  {
    int j = 0;
    if (this.qAU.getVisibility() == 0) {
      j = 1;
    }
    int i = j;
    if (this.qEc.getVisibility() == 0) {
      i = j + 1;
    }
    j = i;
    if (this.qEh.getVisibility() == 0) {
      j = i + 1;
    }
    if (this.qEk.getVisibility() == 0) {}
    for (i = j + 1;; i = j)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.qAT.getLayoutParams();
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.qDZ.getLayoutParams();
      if (i >= 3)
      {
        i = com.tencent.mm.cb.a.fromDPToPix(this, 40);
        localMarginLayoutParams1.topMargin = i;
      }
      for (localMarginLayoutParams2.topMargin = i;; localMarginLayoutParams2.topMargin = i)
      {
        this.qAT.setLayoutParams(localMarginLayoutParams1);
        this.qDZ.setLayoutParams(localMarginLayoutParams2);
        this.qBa.post(new WalletOrderInfoNewUI.15(this));
        return;
        i = com.tencent.mm.cb.a.fromDPToPix(this, 70);
        localMarginLayoutParams1.topMargin = i;
      }
    }
  }
  
  private void bWv()
  {
    if ((this.qmc != null) && (this.qDV != null) && (this.qDV.size() > 0))
    {
      Iterator localIterator = this.qDV.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).mOS));
    }
    for (int i = 0;; i = 1)
    {
      this.nEk.setVisibility(0);
      if (i != 0)
      {
        if ((!bk.bl(this.qmc.qwG)) && (!bk.bl(this.qmc.qwG.trim())))
        {
          this.nEk.setText(this.qmc.qwG);
          return;
        }
        if (this.qmc.qqY != 1)
        {
          this.nEk.setText(a.i.wallet_order_info_result_success_international);
          return;
        }
        this.nEk.setText(a.i.wallet_order_info_result_success);
        return;
      }
      this.nEk.setText(a.i.wallet_order_info_result_wait);
      return;
    }
  }
  
  private void kF(boolean paramBoolean)
  {
    this.qAU.setVisibility(8);
    this.qBc = false;
    this.qBb = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.qmc != null) {
      if ((this.qDV != null) && (this.qDV.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.qDV.get(0);
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).qxo) });
          if ((((Orders.Commodity)localObject2).qxn == null) || (((Orders.Commodity)localObject2).qxn.size() <= 0)) {
            break label1575;
          }
          localObject3 = ((Orders.Commodity)localObject2).qxn.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.qxd);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).qqG > 0L) && (!bk.bl(((Orders.Promotions)localObject1).qwp)))
      {
        this.qDY = ((Orders.Promotions)localObject1);
        this.qAY.setVisibility(8);
        this.qAV.setRoundCorner(true);
        this.qAZ.setEnabled(true);
        this.qAZ.setBackgroundResource(a.e.btn_solid_green);
        this.qAX.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.qAO.get(((Orders.Promotions)localObject1).qqG);
        if (localObject3 != null)
        {
          if (!bk.bl(((a)localObject3).bVO)) {
            this.qAV.setUrl(((a)localObject3).bVO);
          }
          if (!bk.bl(((a)localObject3).bQZ)) {
            this.qAW.setText(((a)localObject3).bQZ);
          }
          if (!bk.bl(((a)localObject3).qEu))
          {
            this.qAZ.setText(((a)localObject3).qEu);
            this.qAZ.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!bk.bl(((a)localObject3).qhq)) {
            this.qDY.qxE = ((a)localObject3).qhq;
          }
          if (!bk.bl(((a)localObject3).qhr)) {
            this.qDY.qxF = ((a)localObject3).qhr;
          }
          if (((a)localObject3).qEv > 0) {
            this.qDY.qxG = ((a)localObject3).qEv;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.qAX.getLayoutParams();
          if ((localObject3 == null) || (bk.bl(((a)localObject3).title))) {
            break label862;
          }
          this.qAX.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.qAX.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.qAZ.setVisibility(0);
          this.qAZ.setOnClickListener(new WalletOrderInfoNewUI.3(this));
          if (((Orders.Promotions)localObject1).qxB != 1) {
            this.qAU.setOnClickListener(new WalletOrderInfoNewUI.4(this));
          }
          localObject3 = this.qAR;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.qAU.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).qxh;
              if (((((Orders.Commodity)localObject2).qxe >= 0.0D) && (((Orders.Commodity)localObject2).iHP < ((Orders.Commodity)localObject2).qxe)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.qAU.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.qAU.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.nFQ;
                  localObject4 = this.nDd;
                  i = ((Orders.Promotions)localObject1).qxB;
                  if (!this.qAR.equals("-1")) {
                    break label1034;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).f(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).qqG), Long.valueOf(((Orders.Promotions)localObject1).qwo) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label862:
      while ((((Orders.Commodity)localObject2).qxl == null) || (bk.bl(((Orders.Commodity)localObject2).qxl.qhq))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.qAW.getVisibility() == 0)
          {
            this.qAW.setSingleLine();
            this.qAW.post(new Runnable()
            {
              public final void run()
              {
                try
                {
                  if ((WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).getLeft()) && (!bk.L(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getTextSize();
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).getLeft();
                    int i = 1;
                    while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                      i += 1;
                    }
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
                    String str1 = str2.substring(0, str2.length() - i - 1);
                    localObject = str1;
                    if (str2.length() > 9)
                    {
                      localObject = str1;
                      if (str1.length() < 9) {
                        localObject = str2.substring(0, 9);
                      }
                    }
                    WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).setText((CharSequence)localObject);
                    WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).append("...");
                  }
                  return;
                }
                catch (Exception localException)
                {
                  com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                }
              }
            });
          }
          return;
          this.qAV.setUrl(((Orders.Promotions)localObject1).mTc);
          this.qAW.setText(((Orders.Promotions)localObject1).name);
          this.qAZ.setText(((Orders.Promotions)localObject1).qwp);
          continue;
          if (!bk.bl(((Orders.Promotions)localObject1).title))
          {
            this.qAX.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.qAX.setVisibility(8);
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
                        this.qAZ.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.qAR;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1034:
      this.qAK = ((Orders.Commodity)localObject2).qxl.qhq;
      this.qAL = ((Orders.Commodity)localObject2).qxl.qhr;
      this.qwv = ((Orders.Commodity)localObject2).qxl.qwv;
      this.qDW = ((Orders.Commodity)localObject2).qxl;
      this.qAV.setUrl(((Orders.Commodity)localObject2).qxl.qws);
      this.qAW.setText(((Orders.Commodity)localObject2).qxl.qwt);
      this.qAX.setText(getString(a.i.wallet_app_brand_entrance));
      this.qAX.setVisibility(0);
      this.qAV.setRoundCorner(true);
      this.qAZ.setEnabled(true);
      this.qAZ.setBackgroundResource(a.e.btn_solid_green);
      localObject1 = (RelativeLayout.LayoutParams)this.qAX.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.qAX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).qxl.qxK > 0L)
      {
        if (!bk.bl(((Orders.Commodity)localObject2).qxl.qwu))
        {
          this.qAZ.setVisibility(0);
          this.qAZ.setText(((Orders.Commodity)localObject2).qxl.qwu);
          this.qAY.setVisibility(8);
        }
        localObject1 = (a)this.qAO.get(((Orders.Commodity)localObject2).qxl.qxK);
        if (localObject1 != null)
        {
          if (!bk.bl(((a)localObject1).qws)) {
            this.qAV.setUrl(((a)localObject1).qws);
          }
          if (!bk.bl(((a)localObject1).qwt)) {
            this.qAW.setText(((a)localObject1).qwt);
          }
          if (!bk.bl(((a)localObject1).qwu))
          {
            this.qAZ.setText(((a)localObject1).qwu);
            this.qAZ.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!bk.bl(((a)localObject1).qhq)) {
            this.qAK = ((a)localObject1).qhq;
          }
          if (!bk.bl(((a)localObject1).qhr)) {
            this.qAL = ((a)localObject1).qhr;
          }
          if (((a)localObject1).qEv > 0) {
            this.qwv = ((a)localObject1).qEv;
          }
        }
        label1433:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.n(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new rc();
            paramAnonymousView.caq.userName = WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this);
            paramAnonymousView.caq.cas = bk.aM(WalletOrderInfoNewUI.n(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.caq.scene = 1034;
            paramAnonymousView.caq.cat = 0;
            if (WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.caq.cau = WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.caq.context = WalletOrderInfoNewUI.this;
            com.tencent.mm.sdk.b.a.udP.m(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            if ((!bk.bl(this.qEt.qxl.qwu)) && (this.qEt.qxl.qxK > 0L)) {}
            for (boolean bool = true;; bool = false)
            {
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(14118, new Object[] { WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.bTO(), Integer.valueOf(3) });
              return;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(14118, new Object[] { WalletOrderInfoNewUI.l(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.bTO(), Integer.valueOf(1) });
          }
        };
        this.qAU.setOnClickListener((View.OnClickListener)localObject1);
        this.qAZ.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.qAU.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).qxh;
        if (((((Orders.Commodity)localObject2).qxe < 0.0D) || (((Orders.Commodity)localObject2).iHP >= ((Orders.Commodity)localObject2).qxe)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1562;
        }
      }
      label1562:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50))
      {
        this.qAU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.qAU.setVisibility(0);
        break;
        this.qAZ.setVisibility(8);
        this.qAY.setVisibility(8);
        break label1433;
      }
      label1575:
      localObject1 = null;
    }
  }
  
  protected final void QK(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    bWx();
    e.l(this, paramString, true);
  }
  
  public final void bWK()
  {
    bWx();
    Object localObject1 = new an();
    ((an)localObject1).bGG.bGH = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new gm();
    ((gm)localObject1).bOm.bOn = "ok";
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", this.BX.getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", this.BX.getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", this.BX.getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.BX.getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.qDU.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bk.bl(str1))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.qmc == null) || (this.nDu == null)) {
          break label354;
        }
        com.tencent.mm.ah.p localp = com.tencent.mm.kernel.g.DO().dJT;
        String str2 = this.qmc.bMX;
        if (this.qmc.qwN.size() <= 0) {
          break label348;
        }
        localObject1 = ((Orders.Commodity)this.qmc.qwN.get(0)).bMY;
        label265:
        localp.a(new com.tencent.mm.wallet_core.c.p(str1, str2, (String)localObject1, this.nDu.bUV, this.nDu.bUR, this.qmc.qwE), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label348:
        localObject1 = "";
        break label265;
        label354:
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.wallet_core.c.p(str1), 0);
      }
    }
    if (this.qBe != null) {
      this.qBe.a(this, 0, (Bundle)localObject2);
    }
    if ((this.qmc != null) && (!bk.bl(this.qmc.jxR))) {
      if (this.qmc.qwN.size() <= 0) {
        break label563;
      }
    }
    label563:
    for (localObject1 = ((Orders.Commodity)this.qmc.qwN.get(0)).bMY;; localObject1 = "")
    {
      localObject1 = d(this.qmc.jxR, this.qmc.bMX, (String)localObject1, this.nDu.ilD, this.nDu.fGK);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoNewUI", "url = " + (String)localObject1);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", q.Gj());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      return;
    }
  }
  
  public void bWx()
  {
    int i = 0;
    if (!this.qAJ)
    {
      is localis = new is();
      localis.bQT.bQU = 4;
      is.a locala = localis.bQT;
      if (this.BX.getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.aYY = i;
      localis.bQT.bQV = new Intent();
      if (this.qmc != null) {
        localis.bQT.bQV.putExtra("key_jsapi_close_page_after_pay", this.qmc.qxa);
      }
      com.tencent.mm.sdk.b.a.udP.m(localis);
      this.qAJ = true;
    }
  }
  
  protected final boolean bwM()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if ((WalletSuccPageAwardWidget.a(this.nBp)) && (this.nBq.c(paramInt1, paramInt2, paramString, paramm))) {
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.aa)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.aa)paramm;
        paramm = new a(paramString.gff);
        if (this.qAN != null)
        {
          this.qAO.put(paramString.qrd, paramm);
          kF(false);
          bWu();
        }
      }
      else
      {
        this.qEp = false;
      }
    }
    label261:
    do
    {
      return false;
      if (!this.qBb) {
        break;
      }
      this.qAO.put(paramString.qrd, paramm);
      kF(false);
      bWu();
      break;
      if ((paramm instanceof k))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramm;
          paramm = paramString.qqM;
          if (paramm.ino == 0)
          {
            paramm = new a(paramm);
            if (this.qAN == null) {
              break label261;
            }
            this.qAO.put(paramString.pva, paramm);
            kF(false);
            bWu();
          }
        }
        for (;;)
        {
          this.qEp = false;
          break;
          if (this.qBb)
          {
            this.qAO.put(paramString.pva, paramm);
            kF(false);
            bWu();
          }
        }
      }
      if ((paramm instanceof n))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (n)paramm;
          paramm = paramString.qqN;
          if ((this.qDY != null) && (this.qDY.qqG == paramString.qqQ.qqG))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.qDY });
            this.qAR = paramm;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.qqQ.qwp });
            kF(false);
            bWu();
            if ((!bk.bl(paramString.dmU)) && (!"3".equals(paramm))) {
              this.qAZ.setText(paramString.dmU);
            }
          }
          if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bk.bl(paramString.qqO))) {
            com.tencent.mm.ui.base.h.b(this, paramString.qqO, "", true);
          }
          while (!"0".equals(paramm)) {
            return true;
          }
          if (!bk.bl(paramString.qqO)) {}
          for (paramString = paramString.qqO;; paramString = getString(a.i.wallet_pay_award_got))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramm = paramString;
        if (bk.bl(paramString)) {
          paramm = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoNewUI.11(this));
        return true;
      }
    } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.h));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.h)paramm;
      paramm = paramString.qqF;
      String str;
      if (paramm.ino == 0)
      {
        str = paramm.taR;
        if ((this.qDY != null) && (this.qDY.qqG == paramString.qqG))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.qDY });
          this.qAR = str;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramm.taT });
          kF(false);
          bWu();
          if ((!bk.bl(paramm.taT)) && (!"3".equals(str))) {
            this.qAZ.setText(paramm.taT);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bk.bl(paramm.taS))) {
          break label793;
        }
        com.tencent.mm.ui.base.h.b(this, paramm.taS, "", true);
      }
      label793:
      while (!"0".equals(str)) {
        return true;
      }
      if (!bk.bl(paramm.taS)) {}
      for (paramString = paramm.taS;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoNewUI.12(this));
    return true;
  }
  
  public void done()
  {
    if (this.BX.containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)this.BX.getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool1 = localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            WalletOrderInfoNewUI.this.bWK();
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new WalletOrderInfoNewUI.10(this));
        this.BX.remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          bWK();
        }
      }
      return;
    }
    bWK();
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_order_info_ui_new;
  }
  
  protected final void initView()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.qAT = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.nEk = ((TextView)findViewById(a.f.pay_succ_wording));
    this.qDZ = ((TextView)findViewById(a.f.brand_tv));
    this.qEa = ((TextView)findViewById(a.f.fee_unit_tv));
    this.qEb = ((WalletTextView)findViewById(a.f.total_fee_tv));
    this.nBu = ((TextView)findViewById(a.f.origin_fee_tv));
    this.qAS = ((Button)findViewById(a.f.pay_finish_button));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(a.i.app_finish);
    Object localObject1;
    int i;
    label661:
    label747:
    Object localObject3;
    if ((this.nDu != null) && (this.nDu.bUV == 2)) {
      if ((this.qmc != null) && (!bk.bl(this.qmc.qwY)))
      {
        localObject1 = this.qmc.qwY;
        this.qAS.setText((CharSequence)localObject1);
        this.qAS.setOnClickListener(new WalletOrderInfoNewUI.13(this));
        this.qEc = ((ViewGroup)findViewById(a.f.discount_info_layout));
        this.nBs = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
        this.qBa = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
        this.nBr = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
        this.nBt = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
        this.qEd = ((ViewGroup)findViewById(a.f.local_feeinfo_layout));
        this.qEe = ((ViewGroup)findViewById(a.f.discount_rateinfo_layout));
        this.qEg = ((ViewGroup)findViewById(a.f.show_info_container));
        this.qEf = ((ViewGroup)findViewById(a.f.remark_layout));
        this.qAU = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
        this.qAV = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
        this.qAV.setUseSdcardCache(true);
        this.qAW = ((TextView)findViewById(a.f.tinyapp_desc_tv));
        this.qAX = ((TextView)findViewById(a.f.tinyapp_name_tv));
        this.qAZ = ((Button)findViewById(a.f.tinyapp_button));
        this.qAY = findViewById(a.f.tinyapp_info_touch_mask);
        this.qEh = ((ViewGroup)findViewById(a.f.subscribe_biz_layout));
        this.qEi = ((TextView)findViewById(a.f.biz_name_tv));
        this.qEj = ((CheckBox)findViewById(a.f.subscribe_biz_checkbox));
        this.qEk = ((ViewGroup)findViewById(a.f.activity_layout));
        this.qEl = ((CdnImageView)findViewById(a.f.activity_logo_iv));
        this.qEl.setUseSdcardCache(true);
        this.qEn = ((TextView)findViewById(a.f.activity_name_tv));
        this.qEm = ((TextView)findViewById(a.f.activity_desc_tv));
        this.qEo = ((Button)findViewById(a.f.activity_button));
        this.qBa.setVisibility(4);
        this.nBq = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
        bWv();
        if ((this.qmc != null) && (this.qDV != null) && (this.qDV.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.qDV.get(0);
          this.qDZ.setText(((Orders.Commodity)localObject1).mOO);
          this.qEa.setText(e.afg(((Orders.Commodity)localObject1).mOZ));
          this.qEb.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).iHP) }));
        }
        if (this.qmc != null) {
          break label1199;
        }
        i = 0;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.qmc == null) || (this.qmc.qwZ != 1)) {
          break label1210;
        }
        this.qEd.setVisibility(8);
        this.qEe.setVisibility(8);
        this.nBt.setVisibility(8);
        this.nBr.setVisibility(8);
        this.qEf.setVisibility(8);
        bWJ();
        bWI();
        if ((this.qDV == null) || (this.qDV.size() <= 0)) {
          break label1509;
        }
        localObject1 = (Orders.Commodity)this.qDV.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).qxn == null) || (((Orders.Commodity)localObject1).qxn.size() <= 0)) {
          break label1506;
        }
        localObject2 = ((Orders.Commodity)localObject1).qxn.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if ((((Orders.Promotions)localObject3).qxJ != null) && (((Orders.Promotions)localObject3).qxB == 5))
          {
            this.nBp = ((Orders.Promotions)localObject3).qxJ;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.nBp, Integer.valueOf(((Orders.Promotions)localObject3).qxB) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.nBp)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.nBq.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).qxh;
          if (((((Orders.Commodity)localObject1).qxe >= 0.0D) && (((Orders.Commodity)localObject1).iHP < ((Orders.Commodity)localObject1).qxe)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label965:
            this.nBq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.nBq.a(this, this.nBp, this.mKL, false, (ImageView)findViewById(a.f.background));
          this.nBq.init();
          this.nBq.setVisibility(0);
          localObject1 = (ImageView)findViewById(a.f.background);
          ((ImageView)localObject1).post(new WalletOrderInfoNewUI.14(this, (ImageView)localObject1));
        }
      }
      for (;;)
      {
        bWu();
        return;
        if (!bk.bl(this.nDu.qLi))
        {
          localObject1 = getString(a.i.app_back) + this.nDu.qLi;
          break;
        }
        localObject1 = localObject2;
        if (bk.bl(this.nDu.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bk.bl(com.tencent.mm.pluginsdk.model.app.g.n(this, this.nDu.appId))) {
          break;
        }
        localObject1 = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.g.n(this, this.nDu.appId);
        break;
        localObject1 = localObject2;
        if (this.qmc == null) {
          break;
        }
        localObject1 = localObject2;
        if (bk.bl(this.qmc.qwY)) {
          break;
        }
        localObject1 = this.qmc.qwY;
        break;
        label1199:
        i = this.qmc.qwZ;
        break label661;
        label1210:
        bWH();
        if ((this.qmc != null) && (this.qDV != null) && (this.qDV.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.qDV.get(0);
          if (((Orders.Commodity)localObject1).qxm != null)
          {
            localObject2 = (TextView)this.qEf.findViewById(a.f.remark_info_title);
            localObject3 = (TextView)this.qEf.findViewById(a.f.remark_info_desc);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).qxm.qxQ);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).qxm.qxR);
            this.qEf.setVisibility(0);
            this.qEc.setVisibility(0);
          }
        }
        this.qEe.setVisibility(8);
        this.qEd.setVisibility(8);
        if ((this.qmc == null) || (this.qDV == null) || (this.qDV.size() <= 0)) {
          break label747;
        }
        localObject1 = (Orders.Commodity)this.qDV.get(0);
        if (!bk.bl(((Orders.Commodity)localObject1).qxk))
        {
          ((TextView)findViewById(a.f.local_feeinfo_tv)).setText(((Orders.Commodity)localObject1).qxk);
          this.qEd.setVisibility(0);
          this.qEc.setVisibility(0);
        }
        if (bk.bl(((Orders.Commodity)localObject1).qxi)) {
          break label747;
        }
        ((TextView)findViewById(a.f.discount_rateinfo_tv)).setText(((Orders.Commodity)localObject1).qxi);
        this.qEe.setVisibility(0);
        this.qEc.setVisibility(0);
        break label747;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
        break label965;
        kF(true);
        this.nBq.setVisibility(8);
      }
      label1506:
      continue;
      label1509:
      localObject1 = null;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bk.bl(this.qAN.qEA)), Boolean.valueOf(this.qEp) });
      if (!this.qEp) {}
    }
    else
    {
      return;
    }
    this.qEp = true;
    if (bk.bl(this.qAN.qEA))
    {
      a(new com.tencent.mm.plugin.wallet_core.c.aa(this.qAN.qrd, this.qAN.qEw, this.qAN.qEx, this.qAN.qEy, this.qAN.bOT, this.qAN.nzq, this.qAN.qxP), true, true);
      return;
    }
    a(new k(this.qAN.qEA, this.qAN.qrd), true, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int k = 0;
    super.onCreate(paramBundle);
    int i;
    label218:
    boolean bool1;
    label246:
    int j;
    if (com.tencent.mm.compatible.util.d.gF(21))
    {
      if (com.tencent.mm.compatible.util.d.gF(23))
      {
        getWindow().setStatusBarColor(-1);
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      vN(4);
      this.qDU = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.aj(this);
      this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
      this.mKL = this.BX.getString("key_trans_id");
      this.BX.getInt("key_pay_type", -1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.mKL });
      this.qmc = bWG();
      if (this.qmc == null) {
        break label704;
      }
      vN(0);
      b(this.qmc);
      if ((paramBundle != null) && (this.qmc != null) && (this.nDu != null))
      {
        this.mAppId = this.nDu.appId;
        boolean bool2 = paramBundle.cMo();
        com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 7);
        if (this.BX.getInt("key_support_bankcard", 1) != 2) {
          break label650;
        }
        i = 2;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
        int m = this.nDu.bUV;
        if (this.nDu.bUV != 3) {
          break label655;
        }
        bool1 = true;
        if (!bool2) {
          break label661;
        }
        j = 1;
        label253:
        localh.f(10691, new Object[] { Integer.valueOf(m), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(w.cMF()), Integer.valueOf((int)(this.qmc.nCq * 100.0D)), this.qmc.mOZ, Integer.valueOf(i) });
      }
      if (((!o.bVs().bVN()) && (paramBundle != null) && (paramBundle.cMo())) || (!q.Gs())) {
        q.Gt();
      }
      if ((this.qmc == null) || (this.qmc.qwN == null) || (this.qmc.qwN.size() <= 0)) {
        break label666;
      }
      this.qDV = this.qmc.qwN;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.qDV.size()) });
      this.mKL = ((Orders.Commodity)this.qDV.get(0)).bMY;
      this.nDd = ((Orders.Commodity)this.qDV.get(0)).bMY;
      if ((this.nDu != null) && (paramBundle != null) && ((paramBundle.cMn()) || (paramBundle.cMo()))) {
        a(new com.tencent.mm.plugin.wallet_core.c.y(bTO(), 21), true, true);
      }
      label517:
      if (this.mKL == null) {
        ((i)com.tencent.mm.kernel.g.r(i.class)).f(this);
      }
      label540:
      initView();
      this.qBe = cNj();
      bWv();
      kh(1979);
      kh(2948);
      kh(2710);
      com.tencent.mm.sdk.b.a.udP.c(this.qEq);
      com.tencent.mm.sdk.b.a.udP.c(this.mNd);
      this.qBd = true;
      if (this.nDu != null) {
        break label742;
      }
      i = k;
      label614:
      if (this.nDu != null) {
        break label753;
      }
    }
    label650:
    label655:
    label661:
    label666:
    label704:
    label742:
    label753:
    for (paramBundle = "";; paramBundle = this.nDu.bMX)
    {
      com.tencent.mm.wallet_core.c.aa.d(i, paramBundle, 16, "");
      return;
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      break;
      i = 1;
      break label218;
      bool1 = false;
      break label246;
      j = 2;
      break label253;
      com.tencent.mm.sdk.platformtools.y.l("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletOrderInfoNewUI.16(this));
      break label517;
      com.tencent.mm.sdk.platformtools.y.l("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletOrderInfoNewUI.17(this));
      break label540;
      i = this.nDu.bUV;
      break label614;
    }
  }
  
  @Deprecated
  protected Dialog onCreateDialog(int paramInt)
  {
    return com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoNewUI.7(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.qEq);
    com.tencent.mm.sdk.b.a.udP.d(this.mNd);
    ki(1979);
    ki(2948);
    ki(2710);
    if (WalletSuccPageAwardWidget.a(this.nBp)) {
      this.nBq.onDestroy();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      done();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.qBd), this.qDY, Boolean.valueOf(this.qBb), Boolean.valueOf(this.qBc), this.qDW, this.nBp });
    if (WalletSuccPageAwardWidget.a(this.nBp)) {
      this.nBq.onResume();
    }
    do
    {
      do
      {
        return;
        if (this.qBd)
        {
          this.qBd = false;
          return;
        }
        if ((this.qDY == null) || (!this.qBc)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bk.bl(this.qDY.qxI)), this.qDY.qxI, Boolean.valueOf(this.qEp) });
      } while (this.qEp);
      this.qEp = true;
      if (bk.bl(this.qDY.qxI))
      {
        a(new com.tencent.mm.plugin.wallet_core.c.aa(this.qDY.qqG, this.qDY.qxC, this.qDY.qwm, this.qDY.qwn, bTO(), this.nDd, this.qDY.qwo), true, true);
        return;
      }
      a(new k(this.qDY.qxI, this.qDY.qqG), true, true);
      return;
    } while ((!this.qBb) || (this.qDW == null));
    a(new com.tencent.mm.plugin.wallet_core.c.aa(this.qDW.qxK, this.qDW.qxM, this.qDW.qxN, this.qDW.qxO, bTO(), this.nDd, this.qDW.qxP), true, true);
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
  }
  
  static final class a
  {
    public String bQZ;
    public String bVO;
    public String qEu;
    public int qEv;
    public String qhq;
    public String qhr;
    public String qwr;
    public String qws;
    public String qwt;
    public String qwu;
    public String title;
    public String url;
    
    public a(bhp parambhp)
    {
      if ((parambhp != null) && (parambhp.tCn != null))
      {
        parambhp = parambhp.tCn;
        this.url = parambhp.url;
        this.bQZ = parambhp.bQZ;
        this.bVO = parambhp.bVO;
        this.qEu = parambhp.qEu;
        this.title = parambhp.title;
        this.qhq = parambhp.qhq;
        this.qhr = parambhp.qhr;
        this.qEv = parambhp.qEv;
        this.qwr = this.title;
        this.qws = this.bVO;
        this.qwt = this.bQZ;
        this.qwu = this.qEu;
      }
    }
    
    public a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      do
      {
        return;
        paramJSONObject = paramJSONObject.optJSONObject("activity_change_info");
      } while (paramJSONObject == null);
      this.url = paramJSONObject.optString("url");
      this.bQZ = paramJSONObject.optString("wording");
      this.bVO = paramJSONObject.optString("icon");
      this.qEu = paramJSONObject.optString("btn_text");
      this.title = paramJSONObject.optString("title");
      this.qwr = paramJSONObject.optString("tinyapp_name");
      this.qws = paramJSONObject.optString("tinyapp_logo");
      this.qwt = paramJSONObject.optString("tinyapp_desc");
      this.qhq = paramJSONObject.optString("tinyapp_username");
      this.qhr = paramJSONObject.optString("tinyapp_path");
      this.qwu = paramJSONObject.optString("activity_tinyapp_btn_text");
    }
    
    public final String toString()
    {
      return this.url + " , " + this.bQZ + " , " + this.bVO + " , " + this.qEu + " , " + this.title;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */