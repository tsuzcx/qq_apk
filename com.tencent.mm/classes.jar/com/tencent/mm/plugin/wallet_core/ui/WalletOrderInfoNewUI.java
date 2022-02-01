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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.a;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xv.a;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.ad;
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
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private b BCA;
  private HashMap<String, a> BCB;
  private String BCC;
  private String BCE;
  private Button BCF;
  private ImageView BCG;
  private ViewGroup BCH;
  private CdnImageView BCI;
  private TextView BCJ;
  private TextView BCK;
  private View BCL;
  private Button BCM;
  private ViewGroup BCN;
  private boolean BCO;
  private boolean BCP;
  private boolean BCQ;
  private com.tencent.mm.wallet_core.d BCR;
  private boolean BCw;
  private String BCx;
  private String BCy;
  private ViewGroup BGA;
  private CdnImageView BGB;
  private TextView BGC;
  private TextView BGD;
  private Button BGE;
  private int BGF;
  private boolean BGG;
  private boolean BGH;
  private com.tencent.mm.sdk.b.c BGI;
  private com.tencent.mm.plugin.wallet_core.c.a BGJ;
  private com.tencent.mm.plugin.wallet_core.c.c BGK;
  private boolean BGL;
  private int BGM;
  protected Set<String> BGg;
  private List<Orders.Commodity> BGh;
  private Orders.RecommendTinyAppInfo BGi;
  private String BGj;
  private Orders.Promotions BGk;
  private TextView BGl;
  private TextView BGm;
  private WalletTextView BGn;
  private ViewGroup BGo;
  private ViewGroup BGp;
  private ViewGroup BGq;
  private ViewGroup BGr;
  private ViewGroup BGs;
  private ViewGroup BGt;
  private TextView BGu;
  private CheckBox BGv;
  private ViewGroup BGw;
  private CdnImageView BGx;
  private TextView BGy;
  private ProgressBar BGz;
  private Orders BhZ;
  private int Bxy;
  private String lhM;
  private String mAppId;
  private PayInfo mPayInfo;
  private ViewGroup oVI;
  private String vsE;
  private com.tencent.mm.sdk.b.c vvs;
  private String vyB;
  private e.a.a.c wOp;
  private WalletSuccPageAwardWidget wOq;
  private ViewGroup wOr;
  private ViewGroup wOs;
  private ViewGroup wOt;
  private TextView wOu;
  private boolean wOv;
  private com.tencent.mm.sdk.b.c<xv> wOw;
  private String wRe;
  private TextView wSw;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.lhM = null;
    this.vyB = null;
    this.BCw = false;
    this.BGg = null;
    this.mAppId = "";
    this.BGh = null;
    this.BCB = new HashMap();
    this.BGk = null;
    this.BCE = "-1";
    this.BCO = false;
    this.BCP = false;
    this.BGF = 0;
    this.BGG = false;
    this.BGH = false;
    this.BCQ = false;
    this.vvs = new com.tencent.mm.sdk.b.c() {};
    this.BGI = new WalletOrderInfoNewUI.9(this);
    this.wOv = false;
    this.wOw = new com.tencent.mm.sdk.b.c() {};
    this.BGL = false;
    this.BGM = 2;
    AppMethodBeat.o(71014);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.BGg.clear();
    if ((paramOrders == null) || (paramOrders.BxR == null))
    {
      ac.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.BxR.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.BxH == 2) && (!bs.isNullOrNil(localCommodity.Byt)))
      {
        ac.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.BGg.add(localCommodity.Byt);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void etA()
  {
    AppMethodBeat.i(71019);
    this.BGz.setVisibility(0);
    this.BGx.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void etB()
  {
    AppMethodBeat.i(71020);
    if (this.BGw.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.BGG)
    {
      if (!bs.isNullOrNil(this.wOp.LUM.LUP)) {
        this.BGx.setUrl(this.wOp.LUM.LUP);
      }
      if (!bs.isNullOrNil(this.wOp.LUM.LUO))
      {
        this.BGy.setText(this.wOp.LUM.LUO);
        if (!bs.isNullOrNil(this.wOp.LUM.LUQ)) {
          this.BGy.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wOp.LUM.LUQ, true));
        }
        if (this.wOp.LUM.LUR > 0L)
        {
          this.BGy.setTextSize(1, (float)this.wOp.LUM.LUR);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!bs.isNullOrNil(this.wOp.LUM.LUU)) {
        this.BGx.setUrl(this.wOp.LUM.LUU);
      }
      if (!bs.isNullOrNil(this.wOp.LUM.LUW))
      {
        this.BGy.setText(this.wOp.LUM.LUW);
        if (!bs.isNullOrNil(this.wOp.LUM.LUV)) {
          this.BGy.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wOp.LUM.LUV, true));
        }
        if (this.wOp.LUM.LUR > 0L) {
          this.BGy.setTextSize(1, (float)this.wOp.LUM.LUR);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void etC()
  {
    AppMethodBeat.i(71023);
    this.BGo.setVisibility(8);
    this.wOs.setVisibility(8);
    this.wOr.setVisibility(8);
    this.wOt.setVisibility(8);
    if ((this.BhZ != null) && (this.BGh != null) && (this.BGh.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.BGh.get(0);
      List localList = localCommodity.Byv;
      int i;
      label144:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        ac.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label332;
        }
        this.wOs.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(2131099777));
        if (localDiscountInfo.ByN <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.wJS + e.d(localDiscountInfo.ByN / 100.0D, this.BhZ.vxl));
      }
      for (;;)
      {
        this.wOs.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.wJS);
      }
      label308:
      this.wOs.setVisibility(0);
      this.BGo.setVisibility(0);
      this.wOr.setVisibility(0);
      label332:
      if ((localCommodity.Bys >= 0.0D) && (localCommodity.oxA < localCommodity.Bys))
      {
        this.wOu.setText(e.d(localCommodity.Bys, localCommodity.vxl));
        this.wOu.getPaint().setFlags(16);
        this.wOt.setVisibility(0);
        this.BGo.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void etD()
  {
    AppMethodBeat.i(71024);
    this.BGt.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.BhZ != null)
    {
      c(this.BhZ);
      if ((this.BGh != null) && (this.BGh.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.BGh.get(0);
        ac.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.ByC) });
        if ((localCommodity.ByC) && (localCommodity.ByB != null) && (localCommodity.ByB.size() > 0))
        {
          Iterator localIterator = localCommodity.ByB.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.Byq);
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!bs.isNullOrNil(localPromotions.vxm)))
      {
        this.wRe = localCommodity.dad;
        com.tencent.mm.plugin.report.service.h.wUl.f(13033, new Object[] { Integer.valueOf(1), localPromotions.vxm, localPromotions.url, localPromotions.name, this.wRe });
        this.BGu.setText(getString(2131765577, new Object[] { localPromotions.name }));
        this.BGj = localPromotions.vxm;
        this.BGv.setVisibility(0);
        if (!this.BGg.contains(localPromotions.vxm)) {
          break label333;
        }
        this.BGv.setChecked(true);
      }
      for (;;)
      {
        this.BGt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70989);
            if (!bs.isNullOrNil(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
            {
              if (WalletOrderInfoNewUI.this.BGg.contains(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this)))
              {
                WalletOrderInfoNewUI.this.BGg.remove(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
                WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(false);
                AppMethodBeat.o(70989);
                return;
              }
              WalletOrderInfoNewUI.this.BGg.add(WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).setChecked(true);
            }
            AppMethodBeat.o(70989);
          }
        });
        this.BGt.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.BGv.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void etE()
  {
    AppMethodBeat.i(71025);
    this.BGs.setVisibility(8);
    this.BGs.removeAllViews();
    Iterator localIterator;
    if ((this.BhZ != null) && (this.BhZ.Byd == 1) && (this.BhZ.Byf != null) && (this.BhZ.Byf.size() > 0))
    {
      ac.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.BhZ.Byf, Integer.valueOf(this.BhZ.Byf.size()) });
      localIterator = this.BhZ.Byf.iterator();
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
        ac.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496001, this.BGs, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131301393);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131304201);
        if (!bs.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (bs.isNullOrNil(localShowInfo.tda)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(localShowInfo.tda, true));
        label234:
        if (!bs.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.Bzl == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!bs.isNullOrNil(localShowInfo.Bzg)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(localShowInfo.Bzg, true));
          label294:
          if (localShowInfo.Bzh == 1) {
            if (!bs.isNullOrNil(localShowInfo.Bzk)) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70990);
                  ac.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.Bzk });
                  WalletOrderInfoNewUI.this.Tw(localShowInfo.Bzk);
                  AppMethodBeat.o(70990);
                }
              });
            }
          }
          for (;;)
          {
            this.BGs.addView(localLinearLayout);
            break;
            if ((localShowInfo.Bzh == 2) && (!bs.isNullOrNil(localShowInfo.Bzi))) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(70991);
                  ac.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.Bzi, localShowInfo.Bzj });
                  paramAnonymousView = new ut();
                  paramAnonymousView.dxt.userName = localShowInfo.Bzi;
                  paramAnonymousView.dxt.dxv = bs.bG(localShowInfo.Bzj, "");
                  paramAnonymousView.dxt.scene = 1060;
                  paramAnonymousView.dxt.cYP = WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                  paramAnonymousView.dxt.dxw = 0;
                  paramAnonymousView.dxt.context = WalletOrderInfoNewUI.this;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
                  AppMethodBeat.o(70991);
                }
              });
            }
          }
          this.BGo.setVisibility(0);
          this.BGs.setVisibility(0);
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
  
  private void eti()
  {
    AppMethodBeat.i(71021);
    this.BCH.getVisibility();
    this.BGo.getVisibility();
    this.BGt.getVisibility();
    this.BGA.getVisibility();
    this.BCN.post(new Runnable()
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
                ac.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cc.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void etj()
  {
    AppMethodBeat.i(71022);
    if ((this.BhZ != null) && (this.BGh != null) && (this.BGh.size() > 0))
    {
      Iterator localIterator = this.BGh.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).vxe));
    }
    for (int i = 0;; i = 1)
    {
      this.wSw.setVisibility(0);
      if (i != 0)
      {
        if ((!bs.isNullOrNil(this.BhZ.BxJ)) && (!bs.isNullOrNil(this.BhZ.BxJ.trim())))
        {
          this.wSw.setText(this.BhZ.BxJ);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.BhZ.BoU != 1)
        {
          this.wSw.setText(2131765570);
          AppMethodBeat.o(71022);
          return;
        }
        this.wSw.setText(2131765569);
        AppMethodBeat.o(71022);
        return;
      }
      this.wSw.setText(2131765571);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void tI(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.BCH.setVisibility(8);
    this.BCP = false;
    this.BCO = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.BhZ != null) {
      if ((this.BGh != null) && (this.BGh.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.BGh.get(0);
        if (localObject2 != null)
        {
          ac.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).ByC) });
          if ((((Orders.Commodity)localObject2).ByB == null) || (((Orders.Commodity)localObject2).ByB.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).ByB.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.Byr);
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).BoC > 0L) && (!bs.isNullOrNil(((Orders.Promotions)localObject1).Bxt)))
      {
        this.BGk = ((Orders.Promotions)localObject1);
        this.BCL.setVisibility(8);
        this.BCI.setRoundCorner(true);
        this.BCM.setEnabled(true);
        this.BCM.setBackgroundResource(2131231365);
        this.BCK.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.BCB.get(((Orders.Promotions)localObject1).BoC);
        if (localObject3 != null)
        {
          if (!bs.isNullOrNil(((a)localObject3).drM)) {
            this.BCI.setUrl(((a)localObject3).drM);
          }
          if (!bs.isNullOrNil(((a)localObject3).dlQ)) {
            this.BCJ.setText(((a)localObject3).dlQ);
          }
          if (!bs.isNullOrNil(((a)localObject3).BGR))
          {
            this.BCM.setText(((a)localObject3).BGR);
            this.BCM.setBackgroundResource(2131234694);
          }
          if (!bs.isNullOrNil(((a)localObject3).AZE)) {
            this.BGk.DeH = ((a)localObject3).AZE;
          }
          if (!bs.isNullOrNil(((a)localObject3).AZF)) {
            this.BGk.DeI = ((a)localObject3).AZF;
          }
          if (((a)localObject3).BGS > 0) {
            this.BGk.DeJ = ((a)localObject3).BGS;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.BCK.getLayoutParams();
          if ((localObject3 == null) || (bs.isNullOrNil(((a)localObject3).title))) {
            break label876;
          }
          this.BCK.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.BCK.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.BCM.setVisibility(0);
          this.BCM.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70992);
              ac.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
              AppMethodBeat.o(70992);
            }
          });
          if (((Orders.Promotions)localObject1).DeE != 1) {
            this.BCH.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70993);
                ac.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
                AppMethodBeat.o(70993);
              }
            });
          }
          localObject3 = this.BCE;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.BCH.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).Byv;
              if (((((Orders.Commodity)localObject2).Bys >= 0.0D) && (((Orders.Commodity)localObject2).oxA < ((Orders.Commodity)localObject2).Bys)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.BCH.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.BCH.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
                  localObject4 = this.wRe;
                  i = ((Orders.Promotions)localObject1).DeE;
                  if (!this.BCE.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).f(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).BoC), Long.valueOf(((Orders.Promotions)localObject1).Bxs) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).Byz == null) || (bs.isNullOrNil(((Orders.Commodity)localObject2).Byz.AZE))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.BCJ.getVisibility() == 0)
          {
            this.BCJ.setSingleLine();
            this.BCJ.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(70995);
                try
                {
                  if ((WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) && (!bs.aj(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getTextSize();
                    ac.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft();
                    int i = 1;
                    while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                      i += 1;
                    }
                    ac.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                  ac.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(70995);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.BCI.setUrl(((Orders.Promotions)localObject1).vFL);
          this.BCJ.setText(((Orders.Promotions)localObject1).name);
          this.BCM.setText(((Orders.Promotions)localObject1).Bxt);
          continue;
          if (!bs.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.BCK.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.BCK.setVisibility(8);
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
                        this.BCM.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.BCE;
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
      this.BCx = ((Orders.Commodity)localObject2).Byz.AZE;
      this.BCy = ((Orders.Commodity)localObject2).Byz.AZF;
      this.Bxy = ((Orders.Commodity)localObject2).Byz.Bxy;
      this.BGi = ((Orders.Commodity)localObject2).Byz;
      this.BCI.setUrl(((Orders.Commodity)localObject2).Byz.Bxv);
      this.BCJ.setText(((Orders.Commodity)localObject2).Byz.Bxw);
      this.BCK.setText(getString(2131764967));
      this.BCK.setVisibility(0);
      this.BCI.setRoundCorner(true);
      this.BCM.setEnabled(true);
      this.BCM.setBackgroundResource(2131231365);
      localObject1 = (RelativeLayout.LayoutParams)this.BCK.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.BCK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).Byz.ByY > 0L)
      {
        if (!bs.isNullOrNil(((Orders.Commodity)localObject2).Byz.Bxx))
        {
          this.BCM.setVisibility(0);
          this.BCM.setText(((Orders.Commodity)localObject2).Byz.Bxx);
          this.BCL.setVisibility(8);
        }
        localObject1 = (a)this.BCB.get(((Orders.Commodity)localObject2).Byz.ByY);
        if (localObject1 != null)
        {
          if (!bs.isNullOrNil(((a)localObject1).Bxv)) {
            this.BCI.setUrl(((a)localObject1).Bxv);
          }
          if (!bs.isNullOrNil(((a)localObject1).Bxw)) {
            this.BCJ.setText(((a)localObject1).Bxw);
          }
          if (!bs.isNullOrNil(((a)localObject1).Bxx))
          {
            this.BCM.setText(((a)localObject1).Bxx);
            this.BCM.setBackgroundResource(2131234694);
          }
          if (!bs.isNullOrNil(((a)localObject1).AZE)) {
            this.BCx = ((a)localObject1).AZE;
          }
          if (!bs.isNullOrNil(((a)localObject1).AZF)) {
            this.BCy = ((a)localObject1).AZF;
          }
          if (((a)localObject1).BGS > 0) {
            this.Bxy = ((a)localObject1).BGS;
          }
        }
        label1447:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70994);
            ac.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new ut();
            paramAnonymousView.dxt.userName = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
            paramAnonymousView.dxt.dxv = bs.bG(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.dxt.scene = 1034;
            paramAnonymousView.dxt.dxw = 0;
            if (WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.dxt.aBM = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.dxt.context = WalletOrderInfoNewUI.this;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            if ((!bs.isNullOrNil(this.BGP.Byz.Bxx)) && (this.BGP.Byz.ByY > 0L)) {}
            for (boolean bool = true;; bool = false)
            {
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
              AppMethodBeat.o(70994);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            AppMethodBeat.o(70994);
          }
        };
        this.BCH.setOnClickListener((View.OnClickListener)localObject1);
        this.BCM.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.BCH.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).Byv;
        if (((((Orders.Commodity)localObject2).Bys < 0.0D) || (((Orders.Commodity)localObject2).oxA >= ((Orders.Commodity)localObject2).Bys)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50))
      {
        this.BCH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.BCH.setVisibility(0);
        break;
        this.BCM.setVisibility(8);
        this.BCL.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  protected final void Tw(String paramString)
  {
    AppMethodBeat.i(71027);
    ac.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    etl();
    e.o(this, paramString, true);
    AppMethodBeat.o(71027);
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
            WalletOrderInfoNewUI.this.etF();
            AppMethodBeat.o(71001);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71002);
            WalletOrderInfoNewUI.this.etF();
            AppMethodBeat.o(71002);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          etF();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    etF();
    AppMethodBeat.o(71031);
  }
  
  protected final boolean dyD()
  {
    return false;
  }
  
  public final void etF()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    etl();
    Object localObject1 = new av();
    ((av)localObject1).dar.das = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new hs();
    ((hs)localObject1).diL.diM = "ok";
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    ac.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.BGg.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!bs.isNullOrNil(str1))
      {
        ac.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.BhZ == null) || (this.mPayInfo == null)) {
          break label371;
        }
        q localq = com.tencent.mm.kernel.g.agQ().ghe;
        String str2 = this.BhZ.dac;
        if (this.BhZ.BxR.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.BhZ.BxR.get(0)).dad;
        label282:
        localq.a(new t(str1, str2, (String)localObject1, this.mPayInfo.dqL, this.mPayInfo.channel, this.BhZ.BxH), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.g.agQ().ghe.a(new t(str1), 0);
      }
    }
    if (this.BCR != null)
    {
      this.BCR.a(this, 0, (Bundle)localObject2);
      this.BCR = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.dqL != 46) && (this.mPayInfo.dqL != 3))) {
        break label963;
      }
      localObject1 = new ga();
      if (this.mPayInfo.dqL != 46) {
        break label863;
      }
      ((ga)localObject1).ebf = 2L;
      label474:
      if ((this.BhZ == null) || (this.BhZ.Bye != 0)) {
        break label882;
      }
      ((ga)localObject1).ebg = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.hbR != null))
      {
        localObject2 = this.mPayInfo.hbR.getString("extinfo_key_20", "");
        if (!bs.isNullOrNil((String)localObject2)) {
          ((ga)localObject1).ebh = ((ga)localObject1).t("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.hbR.getString("extinfo_key_21", "");
        if (!bs.isNullOrNil((String)localObject2)) {
          ((ga)localObject1).ebj = ((ga)localObject1).t("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.hbR.getString("extinfo_key_22", "");
        if (!bs.isNullOrNil((String)localObject2)) {
          ((ga)localObject1).ebi = ((ga)localObject1).t("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.BhZ != null) && (this.BhZ.Bye == 0) && (!bs.isNullOrNil(this.BhZ.Byh)) && (!bs.isNullOrNil(this.BhZ.Byg)))
      {
        ((ga)localObject1).ebl = ((ga)localObject1).t("TargetAppPath", this.BhZ.Byh, true);
        ((ga)localObject1).ebk = ((ga)localObject1).t("TargetAppUsername", this.BhZ.Byg, true);
      }
      ((ga)localObject1).aHZ();
      if ((this.BhZ == null) || (this.BhZ.Bye != 0) || (bs.isNullOrNil(this.BhZ.Byh)) || (bs.isNullOrNil(this.BhZ.Byg))) {
        break label963;
      }
      localObject1 = new ut();
      ((ut)localObject1).dxt.userName = this.BhZ.Byg;
      ((ut)localObject1).dxt.dxv = this.BhZ.Byh;
      ((ut)localObject1).dxt.scene = 1060;
      ((ut)localObject1).dxt.cYP = this.vsE;
      ((ut)localObject1).dxt.dxw = 0;
      ((ut)localObject1).dxt.context = this;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(71032);
      return;
      ac.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.dqL != 3) {
        break label474;
      }
      ((ga)localObject1).ebf = 1L;
      break label474;
      label882:
      if ((this.BhZ != null) && (this.BhZ.Bye == 1)) {
        ((ga)localObject1).ebg = 2L;
      } else if ((this.BhZ != null) && (this.BhZ.Bye == 0) && (!bs.isNullOrNil(this.BhZ.Byh)) && (!bs.isNullOrNil(this.BhZ.Byg))) {
        ((ga)localObject1).ebg = 3L;
      }
    }
    label963:
    int i;
    if ((this.BhZ != null) && (!bs.isNullOrNil(this.BhZ.pBl)))
    {
      if (this.BhZ.BxR.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.BhZ.BxR.get(0)).dad;
        localObject1 = e(this.BhZ.pBl, this.BhZ.dac, (String)localObject1, this.mPayInfo.nUG, this.mPayInfo.iAC);
        ac.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", u.axw());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        e.al(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.BGw.getVisibility() == 0) && (this.wOp.LUM != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
      localObject2 = this.wRe;
      localObject3 = this.BGy.getText();
      if (this.wOp.LUM.LUN != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.BGG) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.BGM), Long.valueOf(System.currentTimeMillis()) });
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
  
  protected void etl()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.BCw)
    {
      kf localkf = new kf();
      localkf.dlK.requestCode = 4;
      kf.a locala = localkf.dlK;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bPH = i;
      localkf.dlK.dlL = new Intent();
      if (this.BhZ != null) {
        localkf.dlK.dlL.putExtra("key_jsapi_close_page_after_pay", this.BhZ.Bye);
      }
      if ((this.BhZ != null) && (this.BhZ.Bye == 0) && (!bs.isNullOrNil(this.BhZ.Byh)) && (!bs.isNullOrNil(this.BhZ.Byg))) {
        localkf.dlK.dlL.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.BCR != null) {
        localkf.dlK.dlL.putExtra("key_is_clear_failure", this.BCR.dmf.getInt("key_is_clear_failure", -1));
      }
      com.tencent.mm.sdk.b.a.GpY.l(localkf);
      this.BCw = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71015);
    ac.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, bs.eWi() });
    if (this.wOv)
    {
      AppMethodBeat.o(71015);
      return;
    }
    super.finish();
    this.wOv = true;
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
    this.BCG = ((ImageView)findViewById(2131307115));
    this.wSw = ((TextView)findViewById(2131303156));
    this.BGl = ((TextView)findViewById(2131297511));
    this.BGm = ((TextView)findViewById(2131299875));
    this.BGn = ((WalletTextView)findViewById(2131306043));
    this.wOu = ((TextView)findViewById(2131303088));
    this.BCF = ((Button)findViewById(2131303152));
    this.oVI = ((ViewGroup)findViewById(2131304246));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131755779);
    Object localObject1;
    int i;
    label729:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 2)) {
      if ((this.BhZ != null) && (!bs.isNullOrNil(this.BhZ.Byc)))
      {
        localObject1 = this.BhZ.Byc;
        this.BCF.setText((CharSequence)localObject1);
        this.BCF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            WalletOrderInfoNewUI.this.done();
            AppMethodBeat.o(71005);
          }
        });
        this.BGo = ((ViewGroup)findViewById(2131299142));
        this.wOs = ((ViewGroup)findViewById(2131299141));
        this.BCN = ((ViewGroup)findViewById(2131306773));
        this.wOr = ((ViewGroup)findViewById(2131299143));
        this.wOt = ((ViewGroup)findViewById(2131303089));
        this.BGp = ((ViewGroup)findViewById(2131301517));
        this.BGq = ((ViewGroup)findViewById(2131299144));
        this.BGs = ((ViewGroup)findViewById(2131304780));
        this.BGr = ((ViewGroup)findViewById(2131303981));
        this.BCH = ((ViewGroup)findViewById(2131305855));
        this.BCI = ((CdnImageView)findViewById(2131305857));
        this.BCI.setUseSdcardCache(true);
        this.BCJ = ((TextView)findViewById(2131305854));
        this.BCK = ((TextView)findViewById(2131305859));
        this.BCM = ((Button)findViewById(2131305852));
        this.BCL = findViewById(2131305856);
        this.BGt = ((ViewGroup)findViewById(2131305518));
        this.BGu = ((TextView)findViewById(2131297290));
        this.BGv = ((CheckBox)findViewById(2131305517));
        this.BGA = ((ViewGroup)findViewById(2131296425));
        this.BGB = ((CdnImageView)findViewById(2131296426));
        this.BGB.setUseSdcardCache(true);
        this.BGD = ((TextView)findViewById(2131296427));
        this.BGC = ((TextView)findViewById(2131296422));
        this.BGE = ((Button)findViewById(2131296420));
        this.BGw = ((ViewGroup)findViewById(2131306766));
        this.BGy = ((TextView)findViewById(2131306768));
        this.BGx = ((CdnImageView)findViewById(2131306765));
        this.BGz = ((ProgressBar)findViewById(2131306767));
        this.wOq = ((WalletSuccPageAwardWidget)findViewById(2131297022));
        etj();
        if ((this.BhZ != null) && (this.BGh != null) && (this.BGh.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.BGh.get(0);
          this.BGl.setText(((Orders.Commodity)localObject1).vxa);
          this.BGm.setText(e.aSF(((Orders.Commodity)localObject1).vxl));
          this.BGn.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).oxA) }));
        }
        if (this.BhZ != null) {
          break label1449;
        }
        i = 0;
        ac.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.BhZ == null) || (this.BhZ.Byd != 1)) {
          break label1460;
        }
        this.BGp.setVisibility(8);
        this.BGq.setVisibility(8);
        this.wOt.setVisibility(8);
        this.wOr.setVisibility(8);
        this.BGr.setVisibility(8);
        etE();
        label816:
        etD();
        if ((this.BGh == null) || (this.BGh.size() <= 0)) {
          break label1895;
        }
        localObject1 = (Orders.Commodity)this.BGh.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).ByB == null) || (((Orders.Commodity)localObject1).ByB.size() <= 0)) {
          break label1892;
        }
        localObject2 = ((Orders.Commodity)localObject1).ByB.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).ByX != null) && (((Orders.Promotions)localObject3).DeE == 5)) || ((((Orders.Promotions)localObject3).ByX != null) && (((Orders.Promotions)localObject3).ByX.LUM != null)))
          {
            this.wOp = ((Orders.Promotions)localObject3).ByX;
            ac.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.wOp, Integer.valueOf(((Orders.Promotions)localObject3).DeE) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.wOp)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.wOq.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).Byv;
          if (((((Orders.Commodity)localObject1).Bys >= 0.0D) && (((Orders.Commodity)localObject1).oxA < ((Orders.Commodity)localObject1).Bys)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1054:
            this.wOq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.wOq.a(this, this.wOp, this.vsE, false, (ImageView)findViewById(2131297029));
          this.wOq.init();
          this.wOq.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131297029);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.wOA.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.wOA.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1129:
          if ((this.wOp == null) || (this.wOp.LUM == null)) {
            break label1839;
          }
          ac.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.wOp.LUM.LUN) });
          this.BGw.setVisibility(0);
          if (this.wOp.LUM.LUN != 0) {
            break label1756;
          }
          this.BGG = false;
          com.tencent.mm.plugin.report.service.h.wUl.f(17267, new Object[] { this.wRe, this.wOp.LUM.LUO, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1449:
      label1839:
      for (;;)
      {
        etB();
        bs.n(this.BGw, 12, 12, 12, 12);
        this.BGw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            ac.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
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
        eti();
        AppMethodBeat.o(71018);
        return;
        if (!bs.isNullOrNil(this.mPayInfo.BPA))
        {
          localObject1 = getString(2131755281) + this.mPayInfo.BPA;
          break;
        }
        localObject1 = localObject2;
        if (bs.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (bs.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.BhZ == null) {
          break;
        }
        localObject1 = localObject2;
        if (bs.isNullOrNil(this.BhZ.Byc)) {
          break;
        }
        localObject1 = this.BhZ.Byc;
        break;
        i = this.BhZ.Byd;
        break label729;
        label1460:
        etC();
        if ((this.BhZ != null) && (this.BGh != null) && (this.BGh.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.BGh.get(0);
          if (((Orders.Commodity)localObject1).ByA != null)
          {
            localObject2 = (TextView)this.BGr.findViewById(2131303980);
            localObject3 = (TextView)this.BGr.findViewById(2131303979);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).ByA.Bze);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).ByA.Bzf);
            this.BGr.setVisibility(0);
            this.BGo.setVisibility(0);
          }
        }
        this.BGq.setVisibility(8);
        this.BGp.setVisibility(8);
        if ((this.BhZ == null) || (this.BGh == null) || (this.BGh.size() <= 0)) {
          break label816;
        }
        localObject1 = (Orders.Commodity)this.BGh.get(0);
        if (!bs.isNullOrNil(((Orders.Commodity)localObject1).Byy))
        {
          ((TextView)findViewById(2131301518)).setText(((Orders.Commodity)localObject1).Byy);
          this.BGp.setVisibility(0);
          this.BGo.setVisibility(0);
        }
        if (bs.isNullOrNil(((Orders.Commodity)localObject1).Byw)) {
          break label816;
        }
        ((TextView)findViewById(2131299145)).setText(((Orders.Commodity)localObject1).Byw);
        this.BGq.setVisibility(0);
        this.BGo.setVisibility(0);
        break label816;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
        break label1054;
        tI(true);
        this.wOq.setVisibility(8);
        break label1129;
        label1756:
        if (this.wOp.LUM.LUN == 1)
        {
          this.BGG = true;
          com.tencent.mm.plugin.report.service.h.wUl.f(17267, new Object[] { this.wRe, this.wOp.LUM.LUW, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.BGw.setVisibility(8);
          continue;
          this.BGw.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.wUl.f(17267, new Object[] { this.wRe, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
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
    ac.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      ac.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bs.isNullOrNil(this.BCA.BGX)), Boolean.valueOf(this.BGH) });
      if (this.BGH)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.BGH = true;
      if (bs.isNullOrNil(this.BCA.BGX))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.BCA.Bpb, this.BCA.BGT, this.BCA.BGU, this.BCA.BGV, this.BCA.djr, this.BCA.wLA, this.BCA.Bzd));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new p(this.BCA.BGX, this.BCA.Bpb));
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
    xv.a locala;
    if (com.tencent.mm.compatible.util.d.kZ(21))
    {
      if (com.tencent.mm.compatible.util.d.kZ(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.BGg = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.br(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.vsE = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      ac.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.vsE });
      this.BhZ = etz();
      if (this.BhZ == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.BhZ);
      Object localObject;
      if ((paramBundle != null) && (this.BhZ != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.fzH();
        com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        int k = this.mPayInfo.dqL;
        if (this.mPayInfo.dqL != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fAr()), Integer.valueOf((int)(this.BhZ.daf * 100.0D)), this.BhZ.vxl, Integer.valueOf(i) });
      }
      if (((!com.tencent.mm.plugin.wallet_core.model.s.ery().esa()) && (paramBundle != null) && (paramBundle.fzH())) || (!u.axG())) {
        u.axH();
      }
      if ((this.BhZ == null) || (this.BhZ.BxR == null) || (this.BhZ.BxR.size() <= 0)) {
        break label818;
      }
      this.BGh = this.BhZ.BxR;
      ac.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.BGh.size()) });
      this.vsE = ((Orders.Commodity)this.BGh.get(0)).dad;
      this.wRe = ((Orders.Commodity)this.BGh.get(0)).dad;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.fzG()) || (paramBundle.fzH()))) {
        doSceneProgress(new ad(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).h(this);
      initView();
      this.BCR = getProcess();
      etj();
      if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 46))
      {
        ac.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new xv();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.BhZ != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.BhZ.daf);
        }
        if (this.BCR != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.BCR.dmf.getInt("key_is_clear_failure", -1));
        }
        paramBundle.dBk.intent = ((Intent)localObject);
        paramBundle.dBk.dBn = 1;
        paramBundle.dBk.dac = getPayReqKey();
        locala = paramBundle.dBk;
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
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      if ((this.BhZ == null) || (this.BhZ.Byp == null) || (this.BhZ.Byp.Bzm != 1)) {
        break label895;
      }
      ac.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      etF();
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
      ac.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
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
      ac.m("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
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
    com.tencent.mm.sdk.b.a.GpY.c(this.BGI);
    com.tencent.mm.sdk.b.a.GpY.c(this.vvs);
    this.wOw.alive();
    this.BCQ = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.dac)
    {
      com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.dqL;
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
    ac.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.wOp != null) && (this.wOp.LUM != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.wOp.LUM.Epz, this.wOp.LUM.LUN, this.BGF).aBB().h(new WalletOrderInfoNewUI.13(this));
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.BGI);
    com.tencent.mm.sdk.b.a.GpY.d(this.vvs);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.wOw.dead();
    if (WalletSuccPageAwardWidget.a(this.wOp)) {
      this.wOq.onDestroy();
    }
    if (this.BGJ != null) {
      this.BGJ.cancel();
    }
    if (this.BGK != null) {
      this.BGK.cancel();
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
    ac.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.BCQ), this.BGk, Boolean.valueOf(this.BCO), Boolean.valueOf(this.BCP), this.BGi, this.wOp });
    if (WalletSuccPageAwardWidget.a(this.wOp))
    {
      this.wOq.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.BCQ)
    {
      this.BCQ = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.BGk != null) && (this.BCP))
    {
      ac.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(bs.isNullOrNil(this.BGk.GZR)), this.BGk.GZR, Boolean.valueOf(this.BGH) });
      if (this.BGH)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.BGH = true;
      if (bs.isNullOrNil(this.BGk.GZR))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.BGk.BoC, this.BGk.DeF, this.BGk.Bxq, this.BGk.Bxr, getPayReqKey(), this.wRe, this.BGk.Bxs));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new p(this.BGk.GZR, this.BGk.BoC));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.BCO) && (this.BGi != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.BGi.ByY, this.BGi.Bza, this.BGi.Bzb, this.BGi.Bzc, getPayReqKey(), this.wRe, this.BGi.Bzd));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71036);
    ac.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((WalletSuccPageAwardWidget.a(this.wOp)) && (this.wOq.onSceneEnd(paramInt1, paramInt2, paramString, paramn)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.af)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.af)paramn;
        paramn = new a(paramString.jWw);
        if (this.BCA != null)
        {
          this.BCB.put(paramString.Bpb, paramn);
          tI(false);
          eti();
        }
      }
      else
      {
        this.BGH = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.BCO) {
        break;
      }
      this.BCB.put(paramString.Bpb, paramn);
      tI(false);
      eti();
      break;
      if ((paramn instanceof p))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (p)paramn;
          paramn = paramString.BoI;
          if (paramn.nWx == 0)
          {
            paramn = new a(paramn);
            if (this.BCA == null) {
              break label280;
            }
            this.BCB.put(paramString.zPC, paramn);
            tI(false);
            eti();
          }
        }
        for (;;)
        {
          this.BGH = false;
          break;
          if (this.BCO)
          {
            this.BCB.put(paramString.zPC, paramn);
            tI(false);
            eti();
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramn;
          paramn = paramString.BoJ;
          if ((this.BGk != null) && (this.BGk.BoC == paramString.BoM.BoC))
          {
            ac.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.BGk });
            this.BCE = paramn;
            ac.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.BoM.Bxt });
            tI(false);
            eti();
            if ((!bs.isNullOrNil(paramString.fsq)) && (!"3".equals(paramn))) {
              this.BCM.setText(paramString.fsq);
            }
          }
          if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bs.isNullOrNil(paramString.BoK))) {
            com.tencent.mm.ui.base.h.c(this, paramString.BoK, "", true);
          }
          while (!"0".equals(paramn))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!bs.isNullOrNil(paramString.BoK)) {}
          for (paramString = paramString.BoK;; paramString = getString(2131765658))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
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
      paramn = paramString.BoB;
      String str;
      if (paramn.nWx == 0)
      {
        str = paramn.ELY;
        if ((this.BGk != null) && (this.BGk.BoC == paramString.BoC))
        {
          ac.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.BGk });
          this.BCE = str;
          ac.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramn.EMa });
          tI(false);
          eti();
          if ((!bs.isNullOrNil(paramn.EMa)) && (!"3".equals(str))) {
            this.BCM.setText(paramn.EMa);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (bs.isNullOrNil(paramn.ELZ))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramn.ELZ, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!bs.isNullOrNil(paramn.ELZ)) {}
      for (paramString = paramn.ELZ;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bs.isNullOrNil(paramString)) {
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
    public String AZE;
    public String AZF;
    public String BGR;
    public int BGS;
    public String BnG;
    public String Bxv;
    public String Bxw;
    public String Bxx;
    public String dlQ;
    public String drM;
    public String title;
    public String url;
    
    public a(cjx paramcjx)
    {
      AppMethodBeat.i(71012);
      if ((paramcjx != null) && (paramcjx.Fyf != null))
      {
        paramcjx = paramcjx.Fyf;
        this.url = paramcjx.url;
        this.dlQ = paramcjx.dlQ;
        this.drM = paramcjx.drM;
        this.BGR = paramcjx.BGR;
        this.title = paramcjx.title;
        this.AZE = paramcjx.AZE;
        this.AZF = paramcjx.AZF;
        this.BGS = paramcjx.BGS;
        this.BnG = this.title;
        this.Bxv = this.drM;
        this.Bxw = this.dlQ;
        this.Bxx = this.BGR;
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
        this.dlQ = paramJSONObject.optString("wording");
        this.drM = paramJSONObject.optString("icon");
        this.BGR = paramJSONObject.optString("btn_text");
        this.title = paramJSONObject.optString("title");
        this.BnG = paramJSONObject.optString("tinyapp_name");
        this.Bxv = paramJSONObject.optString("tinyapp_logo");
        this.Bxw = paramJSONObject.optString("tinyapp_desc");
        this.AZE = paramJSONObject.optString("tinyapp_username");
        this.AZF = paramJSONObject.optString("tinyapp_path");
        this.Bxx = paramJSONObject.optString("activity_tinyapp_btn_text");
      }
      AppMethodBeat.o(71011);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71013);
      String str = this.url + " , " + this.dlQ + " , " + this.drM + " , " + this.BGR + " , " + this.title;
      AppMethodBeat.o(71013);
      return str;
    }
  }
  
  static final class b
  {
    public String BGT;
    public String BGU;
    public String BGV;
    public long BGW;
    public String BGX;
    public String Bpb;
    public long Bzd;
    public String djr;
    public String wLA;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.Bpb = paramString1;
      this.BGT = paramString2;
      this.BGU = paramString3;
      this.BGV = paramString4;
      this.djr = paramString5;
      this.wLA = paramString6;
      this.Bzd = paramLong1;
      this.BGW = paramLong2;
      this.BGX = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.Bpb = paramString1;
      this.BGT = paramString2;
      this.BGU = paramString3;
      this.BGV = paramString4;
      this.djr = paramString5;
      this.wLA = paramString6;
      this.Bzd = paramLong;
      this.BGX = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */