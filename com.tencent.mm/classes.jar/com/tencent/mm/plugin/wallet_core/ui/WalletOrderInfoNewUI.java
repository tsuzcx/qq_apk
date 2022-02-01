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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaa.a;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.b.a.kw;
import com.tencent.mm.model.z;
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
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
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
  private String AJn;
  private IListener AMo;
  private String APz;
  private e.a.a.c CsF;
  private WalletSuccPageAwardWidget CsG;
  private ViewGroup CsH;
  private ViewGroup CsI;
  private ViewGroup CsJ;
  private TextView CsK;
  private boolean CsL;
  private IListener<aaa> CsM;
  private String Cvu;
  private TextView CwQ;
  private Orders HFH;
  private int HYK;
  private boolean IdD;
  private String IdE;
  private String IdF;
  private b IdH;
  private HashMap<String, a> IdI;
  private String IdJ;
  private String IdL;
  private Button IdM;
  private ImageView IdN;
  private ViewGroup IdO;
  private CdnImageView IdP;
  private TextView IdQ;
  private TextView IdR;
  private View IdS;
  private Button IdT;
  private ViewGroup IdU;
  private boolean IdV;
  private boolean IdW;
  private boolean IdX;
  private com.tencent.mm.wallet_core.d IdY;
  private ViewGroup IhA;
  private TextView IhB;
  private CheckBox IhC;
  private ViewGroup IhD;
  private CdnImageView IhE;
  private TextView IhF;
  private ProgressBar IhG;
  private ViewGroup IhH;
  private CdnImageView IhI;
  private TextView IhJ;
  private TextView IhK;
  private Button IhL;
  private int IhM;
  private boolean IhN;
  private boolean IhO;
  private IListener IhP;
  private com.tencent.mm.plugin.wallet_core.c.a IhQ;
  private com.tencent.mm.plugin.wallet_core.c.c IhR;
  private boolean IhS;
  private int IhT;
  protected Set<String> Ihn;
  private List<Orders.Commodity> Iho;
  private Orders.RecommendTinyAppInfo Ihp;
  private String Ihq;
  private Orders.Promotions Ihr;
  private TextView Ihs;
  private TextView Iht;
  private WalletTextView Ihu;
  private ViewGroup Ihv;
  private ViewGroup Ihw;
  private ViewGroup Ihx;
  private ViewGroup Ihy;
  private ViewGroup Ihz;
  private String mAppId;
  private PayInfo mPayInfo;
  private String mRa;
  private ViewGroup qVm;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.mRa = null;
    this.APz = null;
    this.IdD = false;
    this.Ihn = null;
    this.mAppId = "";
    this.Iho = null;
    this.IdI = new HashMap();
    this.Ihr = null;
    this.IdL = "-1";
    this.IdV = false;
    this.IdW = false;
    this.IhM = 0;
    this.IhN = false;
    this.IhO = false;
    this.IdX = false;
    this.AMo = new IListener() {};
    this.IhP = new WalletOrderInfoNewUI.9(this);
    this.CsL = false;
    this.CsM = new IListener() {};
    this.IhS = false;
    this.IhT = 2;
    AppMethodBeat.o(71014);
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.Ihn.clear();
    if ((paramOrders == null) || (paramOrders.HZd == null))
    {
      Log.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.HZd.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.HYT == 2) && (!Util.isNullOrNil(localCommodity.HZF)))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.Ihn.add(localCommodity.HZF);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void fSB()
  {
    AppMethodBeat.i(71021);
    this.IdO.getVisibility();
    this.Ihv.getVisibility();
    this.IhA.getVisibility();
    this.IhH.getVisibility();
    this.IdU.post(new Runnable()
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
                View localView = WalletOrderInfoNewUI.this.findViewById(2131305811);
                k = i;
                if (localView != null) {
                  k = localView.getBottom();
                }
              }
              if ((WalletOrderInfoNewUI.n(WalletOrderInfoNewUI.this).getVisibility() != 0) && (WalletOrderInfoNewUI.c(WalletOrderInfoNewUI.this).getVisibility() != 0)) {}
              for (i = com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                Log.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void fSC()
  {
    AppMethodBeat.i(71022);
    if ((this.HFH != null) && (this.Iho != null) && (this.Iho.size() > 0))
    {
      Iterator localIterator = this.Iho.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).AOe));
    }
    for (int i = 0;; i = 1)
    {
      this.CwQ.setVisibility(0);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.HFH.HYV)) && (!Util.isNullOrNil(this.HFH.HYV.trim())))
        {
          this.CwQ.setText(this.HFH.HYV);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.HFH.HQg != 1)
        {
          this.CwQ.setText(2131768019);
          AppMethodBeat.o(71022);
          return;
        }
        this.CwQ.setText(2131768018);
        AppMethodBeat.o(71022);
        return;
      }
      this.CwQ.setText(2131768020);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void fST()
  {
    AppMethodBeat.i(71019);
    this.IhG.setVisibility(0);
    this.IhE.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void fSU()
  {
    AppMethodBeat.i(71020);
    if (this.IhD.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.IhN)
    {
      if (!Util.isNullOrNil(this.CsF.Ubn.Ubq)) {
        this.IhE.setUrl(this.CsF.Ubn.Ubq);
      }
      if (!Util.isNullOrNil(this.CsF.Ubn.Ubp))
      {
        this.IhF.setText(this.CsF.Ubn.Ubp);
        if (!Util.isNullOrNil(this.CsF.Ubn.Ubr)) {
          this.IhF.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubn.Ubr, true));
        }
        if (this.CsF.Ubn.Ubs > 0L)
        {
          this.IhF.setTextSize(1, (float)this.CsF.Ubn.Ubs);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!Util.isNullOrNil(this.CsF.Ubn.Ubv)) {
        this.IhE.setUrl(this.CsF.Ubn.Ubv);
      }
      if (!Util.isNullOrNil(this.CsF.Ubn.Ubx))
      {
        this.IhF.setText(this.CsF.Ubn.Ubx);
        if (!Util.isNullOrNil(this.CsF.Ubn.Ubw)) {
          this.IhF.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubn.Ubw, true));
        }
        if (this.CsF.Ubn.Ubs > 0L) {
          this.IhF.setTextSize(1, (float)this.CsF.Ubn.Ubs);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void fSV()
  {
    AppMethodBeat.i(71023);
    this.Ihv.setVisibility(8);
    this.CsI.setVisibility(8);
    this.CsH.setVisibility(8);
    this.CsJ.setVisibility(8);
    if ((this.HFH != null) && (this.Iho != null) && (this.Iho.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.Iho.get(0);
      List localList = localCommodity.HZH;
      int i;
      label144:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (localList != null)
      {
        i = localList.size();
        Log.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", new Object[] { localList, Integer.valueOf(i) });
        if ((localList == null) || (localList.size() <= 0)) {
          break label332;
        }
        this.CsI.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(2131099792));
        if (localDiscountInfo.HZY <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.Coh + com.tencent.mm.wallet_core.ui.f.d(localDiscountInfo.HZY / 100.0D, this.HFH.AOl));
      }
      for (;;)
      {
        this.CsI.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.Coh);
      }
      label308:
      this.CsI.setVisibility(0);
      this.Ihv.setVisibility(0);
      this.CsH.setVisibility(0);
      label332:
      if ((localCommodity.HZE >= 0.0D) && (localCommodity.qwJ < localCommodity.HZE))
      {
        this.CsK.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.HZE, localCommodity.AOl));
        this.CsK.getPaint().setFlags(16);
        this.CsJ.setVisibility(0);
        this.Ihv.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void fSW()
  {
    AppMethodBeat.i(71024);
    this.IhA.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.HFH != null)
    {
      c(this.HFH);
      if ((this.Iho != null) && (this.Iho.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.Iho.get(0);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.HZO) });
        if ((localCommodity.HZO) && (localCommodity.HZN != null) && (localCommodity.HZN.size() > 0))
        {
          Iterator localIterator = localCommodity.HZN.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.HZC);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!Util.isNullOrNil(localPromotions.dCu)))
      {
        this.Cvu = localCommodity.dDM;
        com.tencent.mm.plugin.report.service.h.CyF.a(13033, new Object[] { Integer.valueOf(1), localPromotions.dCu, localPromotions.url, localPromotions.name, this.Cvu });
        this.IhB.setText(getString(2131768026, new Object[] { localPromotions.name }));
        this.Ihq = localPromotions.dCu;
        this.IhC.setVisibility(0);
        if (!this.Ihn.contains(localPromotions.dCu)) {
          break label333;
        }
        this.IhC.setChecked(true);
      }
      for (;;)
      {
        this.IhA.setOnClickListener(new WalletOrderInfoNewUI.2(this));
        this.IhA.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.IhC.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void fSX()
  {
    AppMethodBeat.i(71025);
    this.Ihz.setVisibility(8);
    this.Ihz.removeAllViews();
    Iterator localIterator;
    if ((this.HFH != null) && (this.HFH.HZp == 1) && (this.HFH.HZr != null) && (this.HFH.HZr.size() > 0))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.HFH.HZr, Integer.valueOf(this.HFH.HZr.size()) });
      localIterator = this.HFH.HZr.iterator();
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
        Log.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496981, this.Ihz, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131303148);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131307115);
        if (!Util.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (Util.isNullOrNil(localShowInfo.xEk)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(localShowInfo.xEk, true));
        label234:
        if (!Util.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.Iav == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!Util.isNullOrNil(localShowInfo.Iaq)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(localShowInfo.Iaq, true));
          label294:
          if (localShowInfo.Iar == 1) {
            if (!Util.isNullOrNil(localShowInfo.Iau)) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.3(this, localShowInfo));
            }
          }
          for (;;)
          {
            this.Ihz.addView(localLinearLayout);
            break;
            if ((localShowInfo.Iar == 2) && (!Util.isNullOrNil(localShowInfo.Ias))) {
              localLinearLayout.setOnClickListener(new WalletOrderInfoNewUI.4(this, localShowInfo));
            }
          }
          this.Ihv.setVisibility(0);
          this.Ihz.setVisibility(0);
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
  
  private void yo(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.IdO.setVisibility(8);
    this.IdW = false;
    this.IdV = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.HFH != null) {
      if ((this.Iho != null) && (this.Iho.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.Iho.get(0);
        if (localObject2 != null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).HZO) });
          if ((((Orders.Commodity)localObject2).HZN == null) || (((Orders.Commodity)localObject2).HZN.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).HZN.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.HZD);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).crw > 0L) && (!Util.isNullOrNil(((Orders.Promotions)localObject1).HYF)))
      {
        this.Ihr = ((Orders.Promotions)localObject1);
        this.IdS.setVisibility(8);
        this.IdP.setRoundCorner(true);
        this.IdT.setEnabled(true);
        this.IdT.setBackgroundResource(2131231429);
        this.IdR.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.IdI.get(((Orders.Promotions)localObject1).crw);
        if (localObject3 != null)
        {
          if (!Util.isNullOrNil(((a)localObject3).icon)) {
            this.IdP.setUrl(((a)localObject3).icon);
          }
          if (!Util.isNullOrNil(((a)localObject3).dQx)) {
            this.IdQ.setText(((a)localObject3).dQx);
          }
          if (!Util.isNullOrNil(((a)localObject3).IhY))
          {
            this.IdT.setText(((a)localObject3).IhY);
            this.IdT.setBackgroundResource(2131235656);
          }
          if (!Util.isNullOrNil(((a)localObject3).Hwr)) {
            this.Ihr.Uty = ((a)localObject3).Hwr;
          }
          if (!Util.isNullOrNil(((a)localObject3).Hws)) {
            this.Ihr.Utz = ((a)localObject3).Hws;
          }
          if (((a)localObject3).IhZ > 0) {
            this.Ihr.UtA = ((a)localObject3).IhZ;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.IdR.getLayoutParams();
          if ((localObject3 == null) || (Util.isNullOrNil(((a)localObject3).title))) {
            break label876;
          }
          this.IdR.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.IdR.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.IdT.setVisibility(0);
          this.IdT.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70992);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70992);
            }
          });
          if (((Orders.Promotions)localObject1).Utv != 1) {
            this.IdO.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70993);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                Log.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70993);
              }
            });
          }
          localObject3 = this.IdL;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.IdO.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).HZH;
              if (((((Orders.Commodity)localObject2).HZE >= 0.0D) && (((Orders.Commodity)localObject2).qwJ < ((Orders.Commodity)localObject2).HZE)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.IdO.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.IdO.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
                  localObject4 = this.Cvu;
                  i = ((Orders.Promotions)localObject1).Utv;
                  if (!this.IdL.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).a(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).crw), Long.valueOf(((Orders.Promotions)localObject1).HYE) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).HZL == null) || (Util.isNullOrNil(((Orders.Commodity)localObject2).HZL.Hwr))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.IdQ.getVisibility() == 0)
          {
            this.IdQ.setSingleLine();
            this.IdQ.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(70995);
                try
                {
                  if ((WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) && (!Util.isNullOrNil(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getTextSize();
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft();
                    int i = 1;
                    while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                      i += 1;
                    }
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                  Log.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(70995);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.IdP.setUrl(((Orders.Promotions)localObject1).Bah);
          this.IdQ.setText(((Orders.Promotions)localObject1).name);
          this.IdT.setText(((Orders.Promotions)localObject1).HYF);
          continue;
          if (!Util.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.IdR.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.IdR.setVisibility(8);
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
                        this.IdT.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.IdL;
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
      this.IdE = ((Orders.Commodity)localObject2).HZL.Hwr;
      this.IdF = ((Orders.Commodity)localObject2).HZL.Hws;
      this.HYK = ((Orders.Commodity)localObject2).HZL.HYK;
      this.Ihp = ((Orders.Commodity)localObject2).HZL;
      this.IdP.setUrl(((Orders.Commodity)localObject2).HZL.HYH);
      this.IdQ.setText(((Orders.Commodity)localObject2).HZL.HYI);
      this.IdR.setText(getString(2131767410));
      this.IdR.setVisibility(0);
      this.IdP.setRoundCorner(true);
      this.IdT.setEnabled(true);
      this.IdT.setBackgroundResource(2131231429);
      localObject1 = (RelativeLayout.LayoutParams)this.IdR.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.IdR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).HZL.Iai > 0L)
      {
        if (!Util.isNullOrNil(((Orders.Commodity)localObject2).HZL.HYJ))
        {
          this.IdT.setVisibility(0);
          this.IdT.setText(((Orders.Commodity)localObject2).HZL.HYJ);
          this.IdS.setVisibility(8);
        }
        localObject1 = (a)this.IdI.get(((Orders.Commodity)localObject2).HZL.Iai);
        if (localObject1 != null)
        {
          if (!Util.isNullOrNil(((a)localObject1).HYH)) {
            this.IdP.setUrl(((a)localObject1).HYH);
          }
          if (!Util.isNullOrNil(((a)localObject1).HYI)) {
            this.IdQ.setText(((a)localObject1).HYI);
          }
          if (!Util.isNullOrNil(((a)localObject1).HYJ))
          {
            this.IdT.setText(((a)localObject1).HYJ);
            this.IdT.setBackgroundResource(2131235656);
          }
          if (!Util.isNullOrNil(((a)localObject1).Hwr)) {
            this.IdE = ((a)localObject1).Hwr;
          }
          if (!Util.isNullOrNil(((a)localObject1).Hws)) {
            this.IdF = ((a)localObject1).Hws;
          }
          if (((a)localObject1).IhZ > 0) {
            this.HYK = ((a)localObject1).IhZ;
          }
        }
        label1447:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70994);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new wq();
            paramAnonymousView.ecI.userName = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
            paramAnonymousView.ecI.ecK = Util.nullAs(WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.ecI.scene = 1034;
            paramAnonymousView.ecI.ecL = 0;
            if (WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.ecI.appVersion = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.ecI.context = WalletOrderInfoNewUI.this;
            EventCenter.instance.publish(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            boolean bool;
            if ((!Util.isNullOrNil(this.IhW.HZL.HYJ)) && (this.IhW.HZL.Iai > 0L))
            {
              bool = true;
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)) {
                break label297;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70994);
              return;
              bool = false;
              break;
              label297:
              com.tencent.mm.plugin.report.service.h.CyF.a(14118, new Object[] { WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            }
          }
        };
        this.IdO.setOnClickListener((View.OnClickListener)localObject1);
        this.IdT.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.IdO.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).HZH;
        if (((((Orders.Commodity)localObject2).HZE < 0.0D) || (((Orders.Commodity)localObject2).qwJ >= ((Orders.Commodity)localObject2).HZE)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50))
      {
        this.IdO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.IdO.setVisibility(0);
        break;
        this.IdT.setVisibility(8);
        this.IdS.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  protected final void ahM(String paramString)
  {
    AppMethodBeat.i(71027);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    fSE();
    com.tencent.mm.wallet_core.ui.f.p(this, paramString, true);
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
            WalletOrderInfoNewUI.this.fSY();
            AppMethodBeat.o(71001);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71002);
            WalletOrderInfoNewUI.this.fSY();
            AppMethodBeat.o(71002);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          fSY();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    fSY();
    AppMethodBeat.o(71031);
  }
  
  protected final boolean eOn()
  {
    return false;
  }
  
  protected void fSE()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.IdD)
    {
      le localle = new le();
      localle.dQr.requestCode = 4;
      le.a locala = localle.dQr;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      localle.dQr.dQs = new Intent();
      if (this.HFH != null) {
        localle.dQr.dQs.putExtra("key_jsapi_close_page_after_pay", this.HFH.HZq);
      }
      if ((this.HFH != null) && (this.HFH.HZq == 0) && (!Util.isNullOrNil(this.HFH.HZt)) && (!Util.isNullOrNil(this.HFH.HZs))) {
        localle.dQr.dQs.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.IdY != null) {
        localle.dQr.dQs.putExtra("key_is_clear_failure", this.IdY.dQL.getInt("key_is_clear_failure", -1));
      }
      EventCenter.instance.publish(localle);
      this.IdD = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public final void fSY()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    fSE();
    Object localObject1 = new az();
    ((az)localObject1).dEc.dEd = true;
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = new ip();
    ((ip)localObject1).dNj.dNk = "ok";
    EventCenter.instance.publish((IEvent)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.Ihn.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.HFH == null) || (this.mPayInfo == null)) {
          break label371;
        }
        com.tencent.mm.ak.t localt = com.tencent.mm.kernel.g.aAg().hqi;
        String str2 = this.HFH.dDL;
        if (this.HFH.HZd.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.HFH.HZd.get(0)).dDM;
        label282:
        localt.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dVv, this.mPayInfo.channel, this.HFH.HYT), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    if (this.IdY != null)
    {
      this.IdY.a(this, 0, (Bundle)localObject2);
      this.IdY = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.dVv != 46) && (this.mPayInfo.dVv != 3))) {
        break label963;
      }
      localObject1 = new kw();
      if (this.mPayInfo.dVv != 46) {
        break label863;
      }
      ((kw)localObject1).eXy = 2L;
      label474:
      if ((this.HFH == null) || (this.HFH.HZq != 0)) {
        break label882;
      }
      ((kw)localObject1).eXz = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.iqp != null))
      {
        localObject2 = this.mPayInfo.iqp.getString("extinfo_key_20", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((kw)localObject1).eXA = ((kw)localObject1).x("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.iqp.getString("extinfo_key_21", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((kw)localObject1).eXC = ((kw)localObject1).x("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.iqp.getString("extinfo_key_22", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((kw)localObject1).eXB = ((kw)localObject1).x("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.HFH != null) && (this.HFH.HZq == 0) && (!Util.isNullOrNil(this.HFH.HZt)) && (!Util.isNullOrNil(this.HFH.HZs)))
      {
        ((kw)localObject1).eXE = ((kw)localObject1).x("TargetAppPath", this.HFH.HZt, true);
        ((kw)localObject1).eXD = ((kw)localObject1).x("TargetAppUsername", this.HFH.HZs, true);
      }
      ((kw)localObject1).bfK();
      if ((this.HFH == null) || (this.HFH.HZq != 0) || (Util.isNullOrNil(this.HFH.HZt)) || (Util.isNullOrNil(this.HFH.HZs))) {
        break label963;
      }
      localObject1 = new wq();
      ((wq)localObject1).ecI.userName = this.HFH.HZs;
      ((wq)localObject1).ecI.ecK = this.HFH.HZt;
      ((wq)localObject1).ecI.scene = 1060;
      ((wq)localObject1).ecI.dCw = this.AJn;
      ((wq)localObject1).ecI.ecL = 0;
      ((wq)localObject1).ecI.context = this;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(71032);
      return;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.dVv != 3) {
        break label474;
      }
      ((kw)localObject1).eXy = 1L;
      break label474;
      label882:
      if ((this.HFH != null) && (this.HFH.HZq == 1)) {
        ((kw)localObject1).eXz = 2L;
      } else if ((this.HFH != null) && (this.HFH.HZq == 0) && (!Util.isNullOrNil(this.HFH.HZt)) && (!Util.isNullOrNil(this.HFH.HZs))) {
        ((kw)localObject1).eXz = 3L;
      }
    }
    label963:
    int i;
    if ((this.HFH != null) && (!Util.isNullOrNil(this.HFH.rCq)))
    {
      if (this.HFH.HZd.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.HFH.HZd.get(0)).dDM;
        localObject1 = i(this.HFH.rCq, this.HFH.dDL, (String)localObject1, this.mPayInfo.pSm, this.mPayInfo.remark);
        Log.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", z.aTY());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        com.tencent.mm.wallet_core.ui.f.aA(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.IhD.getVisibility() == 0) && (this.CsF.Ubn != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      localObject2 = this.Cvu;
      localObject3 = this.IhF.getText();
      if (this.CsF.Ubn.Ubo != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.IhN) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.IhT), Long.valueOf(System.currentTimeMillis()) });
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
    Log.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.CsL)
    {
      AppMethodBeat.o(71015);
      return;
    }
    this.CsL = true;
    super.finish();
    AppMethodBeat.o(71015);
  }
  
  public int getLayoutId()
  {
    return 2131496982;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71018);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.IdN = ((ImageView)findViewById(2131310649));
    this.CwQ = ((TextView)findViewById(2131305813));
    this.Ihs = ((TextView)findViewById(2131297737));
    this.Iht = ((TextView)findViewById(2131300555));
    this.Ihu = ((WalletTextView)findViewById(2131309365));
    this.CsK = ((TextView)findViewById(2131305696));
    this.IdM = ((Button)findViewById(2131305809));
    this.qVm = ((ViewGroup)findViewById(2131307165));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(2131755858);
    Object localObject1;
    int i;
    label729:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 2)) {
      if ((this.HFH != null) && (!Util.isNullOrNil(this.HFH.HZo)))
      {
        localObject1 = this.HFH.HZo;
        this.IdM.setText((CharSequence)localObject1);
        this.IdM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            WalletOrderInfoNewUI.this.done();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71005);
          }
        });
        this.Ihv = ((ViewGroup)findViewById(2131299669));
        this.CsI = ((ViewGroup)findViewById(2131299668));
        this.IdU = ((ViewGroup)findViewById(2131310234));
        this.CsH = ((ViewGroup)findViewById(2131299670));
        this.CsJ = ((ViewGroup)findViewById(2131305705));
        this.Ihw = ((ViewGroup)findViewById(2131303723));
        this.Ihx = ((ViewGroup)findViewById(2131299671));
        this.Ihz = ((ViewGroup)findViewById(2131307862));
        this.Ihy = ((ViewGroup)findViewById(2131306835));
        this.IdO = ((ViewGroup)findViewById(2131309134));
        this.IdP = ((CdnImageView)findViewById(2131309136));
        this.IdP.setUseSdcardCache(true);
        this.IdQ = ((TextView)findViewById(2131309133));
        this.IdR = ((TextView)findViewById(2131309138));
        this.IdT = ((Button)findViewById(2131309131));
        this.IdS = findViewById(2131309135);
        this.IhA = ((ViewGroup)findViewById(2131308735));
        this.IhB = ((TextView)findViewById(2131297457));
        this.IhC = ((CheckBox)findViewById(2131308734));
        this.IhH = ((ViewGroup)findViewById(2131296460));
        this.IhI = ((CdnImageView)findViewById(2131296461));
        this.IhI.setUseSdcardCache(true);
        this.IhK = ((TextView)findViewById(2131296462));
        this.IhJ = ((TextView)findViewById(2131296456));
        this.IhL = ((Button)findViewById(2131296452));
        this.IhD = ((ViewGroup)findViewById(2131310227));
        this.IhF = ((TextView)findViewById(2131310229));
        this.IhE = ((CdnImageView)findViewById(2131310226));
        this.IhG = ((ProgressBar)findViewById(2131310228));
        this.CsG = ((WalletSuccPageAwardWidget)findViewById(2131297151));
        fSC();
        if ((this.HFH != null) && (this.Iho != null) && (this.Iho.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Iho.get(0);
          this.Ihs.setText(((Orders.Commodity)localObject1).AOa);
          this.Iht.setText(com.tencent.mm.wallet_core.ui.f.bpp(((Orders.Commodity)localObject1).AOl));
          this.Ihu.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).qwJ) }));
        }
        if (this.HFH != null) {
          break label1449;
        }
        i = 0;
        Log.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.HFH == null) || (this.HFH.HZp != 1)) {
          break label1460;
        }
        this.Ihw.setVisibility(8);
        this.Ihx.setVisibility(8);
        this.CsJ.setVisibility(8);
        this.CsH.setVisibility(8);
        this.Ihy.setVisibility(8);
        fSX();
        label816:
        fSW();
        if ((this.Iho == null) || (this.Iho.size() <= 0)) {
          break label1895;
        }
        localObject1 = (Orders.Commodity)this.Iho.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).HZN == null) || (((Orders.Commodity)localObject1).HZN.size() <= 0)) {
          break label1892;
        }
        localObject2 = ((Orders.Commodity)localObject1).HZN.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).Iah != null) && (((Orders.Promotions)localObject3).Utv == 5)) || ((((Orders.Promotions)localObject3).Iah != null) && (((Orders.Promotions)localObject3).Iah.Ubn != null)))
          {
            this.CsF = ((Orders.Promotions)localObject3).Iah;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.CsF, Integer.valueOf(((Orders.Promotions)localObject3).Utv) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.CsF)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.CsG.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).HZH;
          if (((((Orders.Commodity)localObject1).HZE >= 0.0D) && (((Orders.Commodity)localObject1).qwJ < ((Orders.Commodity)localObject1).HZE)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1054:
            this.CsG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.CsG.a(this, this.CsF, this.AJn, false, (ImageView)findViewById(2131297171));
          this.CsG.init();
          this.CsG.setVisibility(0);
          localObject1 = (ImageView)findViewById(2131297171);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.CsQ.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.CsQ.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1129:
          if ((this.CsF == null) || (this.CsF.Ubn == null)) {
            break label1839;
          }
          Log.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.CsF.Ubn.Ubo) });
          this.IhD.setVisibility(0);
          if (this.CsF.Ubn.Ubo != 0) {
            break label1756;
          }
          this.IhN = false;
          com.tencent.mm.plugin.report.service.h.CyF.a(17267, new Object[] { this.Cvu, this.CsF.Ubn.Ubp, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label1449:
      label1839:
      for (;;)
      {
        fSU();
        Util.expandViewTouchArea(this.IhD, 12, 12, 12, 12);
        this.IhD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
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
        fSB();
        AppMethodBeat.o(71018);
        return;
        if (!Util.isNullOrNil(this.mPayInfo.IqM))
        {
          localObject1 = getString(2131755316) + this.mPayInfo.IqM;
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(2131755316) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.HFH == null) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.HFH.HZo)) {
          break;
        }
        localObject1 = this.HFH.HZo;
        break;
        i = this.HFH.HZp;
        break label729;
        label1460:
        fSV();
        if ((this.HFH != null) && (this.Iho != null) && (this.Iho.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.Iho.get(0);
          if (((Orders.Commodity)localObject1).HZM != null)
          {
            localObject2 = (TextView)this.Ihy.findViewById(2131306834);
            localObject3 = (TextView)this.Ihy.findViewById(2131306833);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).HZM.Iao);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).HZM.Iap);
            this.Ihy.setVisibility(0);
            this.Ihv.setVisibility(0);
          }
        }
        this.Ihx.setVisibility(8);
        this.Ihw.setVisibility(8);
        if ((this.HFH == null) || (this.Iho == null) || (this.Iho.size() <= 0)) {
          break label816;
        }
        localObject1 = (Orders.Commodity)this.Iho.get(0);
        if (!Util.isNullOrNil(((Orders.Commodity)localObject1).HZK))
        {
          ((TextView)findViewById(2131303724)).setText(((Orders.Commodity)localObject1).HZK);
          this.Ihw.setVisibility(0);
          this.Ihv.setVisibility(0);
        }
        if (Util.isNullOrNil(((Orders.Commodity)localObject1).HZI)) {
          break label816;
        }
        ((TextView)findViewById(2131299672)).setText(((Orders.Commodity)localObject1).HZI);
        this.Ihx.setVisibility(0);
        this.Ihv.setVisibility(0);
        break label816;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
        break label1054;
        yo(true);
        this.CsG.setVisibility(8);
        break label1129;
        label1756:
        if (this.CsF.Ubn.Ubo == 1)
        {
          this.IhN = true;
          com.tencent.mm.plugin.report.service.h.CyF.a(17267, new Object[] { this.Cvu, this.CsF.Ubn.Ubx, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.IhD.setVisibility(8);
          continue;
          this.IhD.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.CyF.a(17267, new Object[] { this.Cvu, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
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
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.IdH.Iie)), Boolean.valueOf(this.IhO) });
      if (this.IhO)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.IhO = true;
      if (Util.isNullOrNil(this.IdH.Iie))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.IdH.HQn, this.IdH.Iia, this.IdH.Iib, this.IdH.Iic, this.IdH.dNQ, this.IdH.CpP, this.IdH.Ian));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new p(this.IdH.Iie, this.IdH.HQn));
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
    aaa.a locala;
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      if (com.tencent.mm.compatible.util.d.oD(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101424));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.Ihn = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.by(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.AJn = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      Log.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.AJn });
      this.HFH = fSS();
      if (this.HFH == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.HFH);
      Object localObject;
      if ((paramBundle != null) && (this.HFH != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.hgK();
        com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        int k = this.mPayInfo.dVv;
        if (this.mPayInfo.dVv != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.hhu()), Integer.valueOf((int)(this.HFH.dDO * 100.0D)), this.HFH.AOl, Integer.valueOf(i) });
      }
      if (((!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()) && (paramBundle != null) && (paramBundle.hgK())) || (!z.aUj())) {
        z.aUk();
      }
      if ((this.HFH == null) || (this.HFH.HZd == null) || (this.HFH.HZd.size() <= 0)) {
        break label818;
      }
      this.Iho = this.HFH.HZd;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.Iho.size()) });
      this.AJn = ((Orders.Commodity)this.Iho.get(0)).dDM;
      this.Cvu = ((Orders.Commodity)this.Iho.get(0)).dDM;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.hgJ()) || (paramBundle.hgK()))) {
        doSceneProgress(new ad(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
      initView();
      this.IdY = getProcess();
      fSC();
      if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 46))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new aaa();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.HFH != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.HFH.dDO);
        }
        if (this.IdY != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.IdY.dQL.getInt("key_is_clear_failure", -1));
        }
        paramBundle.egJ.intent = ((Intent)localObject);
        paramBundle.egJ.egM = 1;
        paramBundle.egJ.dDL = getPayReqKey();
        locala = paramBundle.egJ;
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
      EventCenter.instance.publish(paramBundle);
      if ((this.HFH == null) || (this.HFH.HZB == null) || (this.HFH.HZB.Iaw != 1)) {
        break label895;
      }
      Log.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      fSY();
      AppMethodBeat.o(71016);
      return;
      getWindow().setStatusBarColor(getResources().getColor(2131099687));
      break;
      i = 1;
      break label231;
      bool1 = false;
      break label259;
      j = 2;
      break label266;
      Log.printInfoStack("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71009);
          WalletOrderInfoNewUI.this.done();
          AppMethodBeat.o(71009);
        }
      });
      break label529;
      Log.printInfoStack("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
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
    EventCenter.instance.addListener(this.IhP);
    EventCenter.instance.addListener(this.AMo);
    this.CsM.alive();
    this.IdX = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.dDL)
    {
      com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.dVv;
      break;
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71029);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131768014), getResources().getStringArray(2130903100), "", new WalletOrderInfoNewUI.10(this));
    AppMethodBeat.o(71029);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71034);
    super.onDestroy();
    if (!this.CsL)
    {
      ip localip = new ip();
      localip.dNj.dNk = "ok";
      EventCenter.instance.publish(localip);
    }
    Log.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.CsF != null) && (this.CsF.Ubn != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.CsF.Ubn.LjW, this.CsF.Ubn.Ubo, this.IhM).aYI().h(new com.tencent.mm.vending.c.a() {});
    }
    EventCenter.instance.removeListener(this.IhP);
    EventCenter.instance.removeListener(this.AMo);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.CsM.dead();
    if (WalletSuccPageAwardWidget.a(this.CsF)) {
      this.CsG.onDestroy();
    }
    if (this.IhQ != null) {
      this.IhQ.cancel();
    }
    if (this.IhR != null) {
      this.IhR.cancel();
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
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.IdX), this.Ihr, Boolean.valueOf(this.IdV), Boolean.valueOf(this.IdW), this.Ihp, this.CsF });
    if (WalletSuccPageAwardWidget.a(this.CsF))
    {
      this.CsG.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.IdX)
    {
      this.IdX = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.Ihr != null) && (this.IdW))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.Ihr.UtC)), this.Ihr.UtC, Boolean.valueOf(this.IhO) });
      if (this.IhO)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.IhO = true;
      if (Util.isNullOrNil(this.Ihr.UtC))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Ihr.crw, this.Ihr.Utw, this.Ihr.HYC, this.Ihr.HYD, getPayReqKey(), this.Cvu, this.Ihr.HYE));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new p(this.Ihr.UtC, this.Ihr.crw));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.IdV) && (this.Ihp != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.Ihp.Iai, this.Ihp.Iak, this.Ihp.Ial, this.Ihp.Iam, getPayReqKey(), this.Cvu, this.Ihp.Ian));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71036);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq });
    if ((WalletSuccPageAwardWidget.a(this.CsF)) && (this.CsG.onSceneEnd(paramInt1, paramInt2, paramString, paramq)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.af)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.af)paramq;
        paramq = new a(paramString.lxS);
        if (this.IdH != null)
        {
          this.IdI.put(paramString.HQn, paramq);
          yo(false);
          fSB();
        }
      }
      else
      {
        this.IhO = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.IdV) {
        break;
      }
      this.IdI.put(paramString.HQn, paramq);
      yo(false);
      fSB();
      break;
      if ((paramq instanceof p))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (p)paramq;
          paramq = paramString.HPU;
          if (paramq.pTZ == 0)
          {
            paramq = new a(paramq);
            if (this.IdH == null) {
              break label280;
            }
            this.IdI.put(paramString.FJm, paramq);
            yo(false);
            fSB();
          }
        }
        for (;;)
        {
          this.IhO = false;
          break;
          if (this.IdV)
          {
            this.IdI.put(paramString.FJm, paramq);
            yo(false);
            fSB();
          }
        }
      }
      if ((paramq instanceof s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (s)paramq;
          paramq = paramString.HPV;
          if ((this.Ihr != null) && (this.Ihr.crw == paramString.HPY.crw))
          {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.Ihr });
            this.IdL = paramq;
            Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.HPY.HYF });
            yo(false);
            fSB();
            if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramq))) {
              this.IdT.setText(paramString.resultMsg);
            }
          }
          if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.HPW))) {
            com.tencent.mm.ui.base.h.c(this, paramString.HPW, "", true);
          }
          while (!"0".equals(paramq))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!Util.isNullOrNil(paramString.HPW)) {}
          for (paramString = paramString.HPW;; paramString = getString(2131768111))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131768354);
        }
        com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71036);
        return true;
      }
    } while (!(paramq instanceof m));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (m)paramq;
      paramq = paramString.HPO;
      String str;
      if (paramq.pTZ == 0)
      {
        str = paramq.LSF;
        if ((this.Ihr != null) && (this.Ihr.crw == paramString.crw))
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.Ihr });
          this.IdL = str;
          Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramq.LSH });
          yo(false);
          fSB();
          if ((!Util.isNullOrNil(paramq.LSH)) && (!"3".equals(str))) {
            this.IdT.setText(paramq.LSH);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (Util.isNullOrNil(paramq.LSG))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramq.LSG, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!Util.isNullOrNil(paramq.LSG)) {}
      for (paramString = paramq.LSG;; paramString = getString(2131768111))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131768354);
    }
    com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
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
    public String HLz;
    public String HYH;
    public String HYI;
    public String HYJ;
    public String Hwr;
    public String Hws;
    public String IhY;
    public int IhZ;
    public String dQx;
    public String icon;
    public String title;
    public String url;
    
    public a(dhq paramdhq)
    {
      AppMethodBeat.i(71012);
      if ((paramdhq != null) && (paramdhq.MMy != null))
      {
        paramdhq = paramdhq.MMy;
        this.url = paramdhq.url;
        this.dQx = paramdhq.dQx;
        this.icon = paramdhq.icon;
        this.IhY = paramdhq.IhY;
        this.title = paramdhq.title;
        this.Hwr = paramdhq.Hwr;
        this.Hws = paramdhq.Hws;
        this.IhZ = paramdhq.IhZ;
        this.HLz = this.title;
        this.HYH = this.icon;
        this.HYI = this.dQx;
        this.HYJ = this.IhY;
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
        this.dQx = paramJSONObject.optString("wording");
        this.icon = paramJSONObject.optString("icon");
        this.IhY = paramJSONObject.optString("btn_text");
        this.title = paramJSONObject.optString("title");
        this.HLz = paramJSONObject.optString("tinyapp_name");
        this.HYH = paramJSONObject.optString("tinyapp_logo");
        this.HYI = paramJSONObject.optString("tinyapp_desc");
        this.Hwr = paramJSONObject.optString("tinyapp_username");
        this.Hws = paramJSONObject.optString("tinyapp_path");
        this.HYJ = paramJSONObject.optString("activity_tinyapp_btn_text");
      }
      AppMethodBeat.o(71011);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71013);
      String str = this.url + " , " + this.dQx + " , " + this.icon + " , " + this.IhY + " , " + this.title;
      AppMethodBeat.o(71013);
      return str;
    }
  }
  
  static final class b
  {
    public String CpP;
    public String HQn;
    public long Ian;
    public String Iia;
    public String Iib;
    public String Iic;
    public long Iid;
    public String Iie;
    public String dNQ;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.HQn = paramString1;
      this.Iia = paramString2;
      this.Iib = paramString3;
      this.Iic = paramString4;
      this.dNQ = paramString5;
      this.CpP = paramString6;
      this.Ian = paramLong1;
      this.Iid = paramLong2;
      this.Iie = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.HQn = paramString1;
      this.Iia = paramString2;
      this.Iib = paramString3;
      this.Iic = paramString4;
      this.dNQ = paramString5;
      this.CpP = paramString6;
      this.Ian = paramLong;
      this.Iie = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */