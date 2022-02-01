package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.f.a.abe;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.abh.a;
import com.tencent.mm.f.a.bb;
import com.tencent.mm.f.a.jf;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.f.a.lv.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.ns;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.FinderInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
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
  private String GCu;
  private IListener GFB;
  private String GIN;
  private e.a.a.c Iqj;
  private WalletSuccPageAwardWidget Iqk;
  private ViewGroup Iql;
  private ViewGroup Iqm;
  private ViewGroup Iqn;
  private TextView Iqo;
  private boolean Iqp;
  private IListener<abh> Iqq;
  private String Itj;
  private TextView Ivj;
  private ViewGroup NEN;
  private int OQK;
  private boolean OVT;
  private String OVU;
  private String OVV;
  private b OVX;
  private HashMap<String, WalletOrderInfoNewUI.a> OVY;
  private String OVZ;
  private String OWb;
  private Button OWc;
  private ImageView OWd;
  private ViewGroup OWe;
  private CdnImageView OWf;
  private TextView OWg;
  private TextView OWh;
  private View OWi;
  private Button OWj;
  private boolean OWk;
  private boolean OWl;
  private boolean OWm;
  private com.tencent.mm.wallet_core.d OWn;
  private WalletTextView OZA;
  private LinearLayout OZB;
  private ViewGroup OZC;
  private ViewGroup OZD;
  private ViewGroup OZE;
  private ViewGroup OZF;
  private ViewGroup OZG;
  private RelativeLayout OZH;
  private CdnImageView OZI;
  private CdnImageView OZJ;
  private TextView OZK;
  private View OZL;
  private RelativeLayout OZM;
  private ViewGroup OZN;
  private TextView OZO;
  private CheckBox OZP;
  private ViewGroup OZQ;
  private CdnImageView OZR;
  private TextView OZS;
  private ProgressBar OZT;
  private ViewGroup OZU;
  private CdnImageView OZV;
  private TextView OZW;
  private TextView OZX;
  private Button OZY;
  private int OZZ;
  protected Set<String> OZt;
  private List<Orders.Commodity> OZu;
  private Orders.RecommendTinyAppInfo OZv;
  private String OZw;
  private Orders.Promotions OZx;
  private TextView OZy;
  private TextView OZz;
  private Orders OxA;
  private boolean Paa;
  private boolean Pab;
  private IListener Pac;
  private com.tencent.mm.plugin.wallet_core.c.a Pad;
  private com.tencent.mm.plugin.wallet_core.c.c Pae;
  private boolean Paf;
  private int Pag;
  private TextView finderDesc;
  private String mAppId;
  private PayInfo mPayInfo;
  private String pRV;
  private ViewGroup uxW;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.pRV = null;
    this.GIN = null;
    this.OVT = false;
    this.OZt = null;
    this.mAppId = "";
    this.OZu = null;
    this.OVY = new HashMap();
    this.OZx = null;
    this.OWb = "-1";
    this.OWk = false;
    this.OWl = false;
    this.OZZ = 0;
    this.Paa = false;
    this.Pab = false;
    this.OWm = false;
    this.GFB = new IListener() {};
    this.Pac = new WalletOrderInfoNewUI.9(this);
    this.Iqp = false;
    this.Iqq = new IListener() {};
    this.Paf = false;
    this.Pag = 2;
    AppMethodBeat.o(71014);
  }
  
  private void Cj(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.OWe.setVisibility(8);
    this.OWl = false;
    this.OWk = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.OxA != null) {
      if ((this.OZu != null) && (this.OZu.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.OZu.get(0);
        if (localObject2 != null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).ORP) });
          if ((((Orders.Commodity)localObject2).ORO == null) || (((Orders.Commodity)localObject2).ORO.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).ORO.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.ORD);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).cpu > 0L) && (!Util.isNullOrNil(((Orders.Promotions)localObject1).OQF)))
      {
        this.OZx = ((Orders.Promotions)localObject1);
        this.OWi.setVisibility(8);
        this.OWf.setRoundCorner(true);
        this.OWj.setEnabled(true);
        this.OWj.setBackgroundResource(a.e.btn_solid_green);
        this.OWh.setCompoundDrawables(null, null, null, null);
        localObject3 = (WalletOrderInfoNewUI.a)this.OVY.get(((Orders.Promotions)localObject1).cpu);
        if (localObject3 != null)
        {
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).icon)) {
            this.OWf.setUrl(((WalletOrderInfoNewUI.a)localObject3).icon);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).wording)) {
            this.OWg.setText(((WalletOrderInfoNewUI.a)localObject3).wording);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).Pap))
          {
            this.OWj.setText(((WalletOrderInfoNewUI.a)localObject3).Pap);
            this.OWj.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).Ooe)) {
            this.OZx.SuD = ((WalletOrderInfoNewUI.a)localObject3).Ooe;
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).Oof)) {
            this.OZx.SuE = ((WalletOrderInfoNewUI.a)localObject3).Oof;
          }
          if (((WalletOrderInfoNewUI.a)localObject3).Paq > 0) {
            this.OZx.SuF = ((WalletOrderInfoNewUI.a)localObject3).Paq;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.OWh.getLayoutParams();
          if ((localObject3 == null) || (Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject3).title))) {
            break label876;
          }
          this.OWh.setText(((WalletOrderInfoNewUI.a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.OWh.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.OWj.setVisibility(0);
          this.OWj.setOnClickListener(new WalletOrderInfoNewUI.8(this));
          if (((Orders.Promotions)localObject1).SuA != 1) {
            this.OWe.setOnClickListener(new WalletOrderInfoNewUI.10(this));
          }
          localObject3 = this.OWb;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.OWe.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).ORH;
              if (((((Orders.Commodity)localObject2).ORE >= 0.0D) && (((Orders.Commodity)localObject2).tVK < ((Orders.Commodity)localObject2).ORE)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.OWe.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.OWe.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
                  localObject4 = this.Itj;
                  i = ((Orders.Promotions)localObject1).SuA;
                  if (!this.OWb.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).a(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).cpu), Long.valueOf(((Orders.Promotions)localObject1).OQE) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).ORL == null) || (Util.isNullOrNil(((Orders.Commodity)localObject2).ORL.Ooe))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.OWg.getVisibility() == 0)
          {
            this.OWg.setSingleLine();
            this.OWg.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(226819);
                try
                {
                  if ((WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft()) && (!Util.isNullOrNil(WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getTextSize();
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).getLeft();
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
                    WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).setText((CharSequence)localObject);
                    WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this).append("...");
                  }
                  AppMethodBeat.o(226819);
                  return;
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(226819);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.OWf.setUrl(((Orders.Promotions)localObject1).GUf);
          this.OWg.setText(((Orders.Promotions)localObject1).name);
          this.OWj.setText(((Orders.Promotions)localObject1).OQF);
          continue;
          if (!Util.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.OWh.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.OWh.setVisibility(8);
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
                        this.OWj.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.OWb;
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
      this.OVU = ((Orders.Commodity)localObject2).ORL.Ooe;
      this.OVV = ((Orders.Commodity)localObject2).ORL.Oof;
      this.OQK = ((Orders.Commodity)localObject2).ORL.OQK;
      this.OZv = ((Orders.Commodity)localObject2).ORL;
      this.OWf.setUrl(((Orders.Commodity)localObject2).ORL.OQH);
      this.OWg.setText(((Orders.Commodity)localObject2).ORL.OQI);
      this.OWh.setText(getString(a.i.wallet_app_brand_entrance));
      this.OWh.setVisibility(0);
      this.OWf.setRoundCorner(true);
      this.OWj.setEnabled(true);
      this.OWj.setBackgroundResource(a.e.btn_solid_green);
      localObject1 = (RelativeLayout.LayoutParams)this.OWh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.OWh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).ORL.OSt > 0L)
      {
        if (!Util.isNullOrNil(((Orders.Commodity)localObject2).ORL.OQJ))
        {
          this.OWj.setVisibility(0);
          this.OWj.setText(((Orders.Commodity)localObject2).ORL.OQJ);
          this.OWi.setVisibility(8);
        }
        localObject1 = (WalletOrderInfoNewUI.a)this.OVY.get(((Orders.Commodity)localObject2).ORL.OSt);
        if (localObject1 != null)
        {
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).OQH)) {
            this.OWf.setUrl(((WalletOrderInfoNewUI.a)localObject1).OQH);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).OQI)) {
            this.OWg.setText(((WalletOrderInfoNewUI.a)localObject1).OQI);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).OQJ))
          {
            this.OWj.setText(((WalletOrderInfoNewUI.a)localObject1).OQJ);
            this.OWj.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).Ooe)) {
            this.OVU = ((WalletOrderInfoNewUI.a)localObject1).Ooe;
          }
          if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject1).Oof)) {
            this.OVV = ((WalletOrderInfoNewUI.a)localObject1).Oof;
          }
          if (((WalletOrderInfoNewUI.a)localObject1).Paq > 0) {
            this.OQK = ((WalletOrderInfoNewUI.a)localObject1).Paq;
          }
        }
        label1447:
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(272066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new xw();
            paramAnonymousView.fWN.userName = WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this);
            paramAnonymousView.fWN.fWP = Util.nullAs(WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.fWN.scene = 1034;
            paramAnonymousView.fWN.fWQ = 0;
            if (WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.fWN.appVersion = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.fWN.context = WalletOrderInfoNewUI.this;
            EventCenter.instance.publish(paramAnonymousView);
            paramAnonymousView = WalletOrderInfoNewUI.this;
            boolean bool;
            if ((!Util.isNullOrNil(this.Pan.ORL.OQJ)) && (this.Pan.ORL.OSt > 0L))
            {
              bool = true;
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this)) {
                break label297;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(14118, new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(272066);
              return;
              bool = false;
              break;
              label297:
              com.tencent.mm.plugin.report.service.h.IzE.a(14118, new Object[] { WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            }
          }
        };
        this.OWe.setOnClickListener((View.OnClickListener)localObject1);
        this.OWj.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.OWe.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).ORH;
        if (((((Orders.Commodity)localObject2).ORE < 0.0D) || (((Orders.Commodity)localObject2).tVK >= ((Orders.Commodity)localObject2).ORE)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 50))
      {
        this.OWe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.OWe.setVisibility(0);
        break;
        this.OWj.setVisibility(8);
        this.OWi.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.OZt.clear();
    if ((paramOrders == null) || (paramOrders.ORd == null))
    {
      Log.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.ORd.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.OQT == 2) && (!Util.isNullOrNil(localCommodity.ORF)))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.OZt.add(localCommodity.ORF);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void gLA()
  {
    AppMethodBeat.i(71020);
    if (this.OZQ.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.Paa)
    {
      if (!Util.isNullOrNil(this.Iqj.abEC.abEF)) {
        this.OZR.setUrl(this.Iqj.abEC.abEF);
      }
      if (!Util.isNullOrNil(this.Iqj.abEC.abEE))
      {
        this.OZS.setText(this.Iqj.abEC.abEE);
        if (!Util.isNullOrNil(this.Iqj.abEC.abEG)) {
          this.OZS.setTextColor(k.cW(this.Iqj.abEC.abEG, true));
        }
        if (this.Iqj.abEC.abEH > 0L)
        {
          this.OZS.setTextSize(1, (float)this.Iqj.abEC.abEH);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!Util.isNullOrNil(this.Iqj.abEC.abEK)) {
        this.OZR.setUrl(this.Iqj.abEC.abEK);
      }
      if (!Util.isNullOrNil(this.Iqj.abEC.abEM))
      {
        this.OZS.setText(this.Iqj.abEC.abEM);
        if (!Util.isNullOrNil(this.Iqj.abEC.abEL)) {
          this.OZS.setTextColor(k.cW(this.Iqj.abEC.abEL, true));
        }
        if (this.Iqj.abEC.abEH > 0L) {
          this.OZS.setTextSize(1, (float)this.Iqj.abEC.abEH);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void gLB()
  {
    AppMethodBeat.i(71023);
    this.OZC.setVisibility(8);
    this.Iqm.setVisibility(8);
    this.Iql.setVisibility(8);
    this.Iqn.setVisibility(8);
    if ((this.OxA != null) && (this.OZu != null) && (this.OZu.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.OZu.get(0);
      List localList = localCommodity.ORH;
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
        this.Iqm.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(a.c.Orange));
        if (localDiscountInfo.ORZ <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.Ila + g.d(localDiscountInfo.ORZ / 100.0D, this.OxA.GHz));
      }
      for (;;)
      {
        this.Iqm.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.Ila);
      }
      label308:
      this.Iqm.setVisibility(0);
      this.OZC.setVisibility(0);
      this.Iql.setVisibility(0);
      label332:
      if ((localCommodity.ORE >= 0.0D) && (localCommodity.tVK < localCommodity.ORE))
      {
        this.Iqo.setText(g.d(localCommodity.ORE, localCommodity.GHz));
        this.Iqo.getPaint().setFlags(16);
        this.Iqn.setVisibility(0);
        this.OZC.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void gLC()
  {
    AppMethodBeat.i(71024);
    this.OZN.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.OxA != null)
    {
      c(this.OxA);
      if ((this.OZu != null) && (this.OZu.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.OZu.get(0);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.ORP) });
        if ((localCommodity.ORP) && (localCommodity.ORO != null) && (localCommodity.ORO.size() > 0))
        {
          Iterator localIterator = localCommodity.ORO.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.ORC);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!Util.isNullOrNil(localPromotions.fvb)))
      {
        this.Itj = localCommodity.fww;
        com.tencent.mm.plugin.report.service.h.IzE.a(13033, new Object[] { Integer.valueOf(1), localPromotions.fvb, localPromotions.url, localPromotions.name, this.Itj });
        this.OZO.setText(getString(a.i.wallet_order_info_subscribe_biz, new Object[] { localPromotions.name }));
        this.OZw = localPromotions.fvb;
        this.OZP.setVisibility(0);
        if (!this.OZt.contains(localPromotions.fvb)) {
          break label333;
        }
        this.OZP.setChecked(true);
      }
      for (;;)
      {
        this.OZN.setOnClickListener(new WalletOrderInfoNewUI.5(this));
        this.OZN.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.OZP.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void gLD()
  {
    AppMethodBeat.i(71025);
    this.OZG.setVisibility(8);
    this.OZG.removeAllViews();
    Iterator localIterator;
    if ((this.OxA != null) && (this.OxA.ORp == 1) && (this.OxA.ORr != null) && (this.OxA.ORr.size() > 0))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.OxA.ORr, Integer.valueOf(this.OxA.ORr.size()) });
      localIterator = this.OxA.ORr.iterator();
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
        Log.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[] { localShowInfo });
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.wallet_order_info_show_info_layout, this.OZG, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(a.f.left_tv);
        localTextView1 = (TextView)localLinearLayout.findViewById(a.f.right_tv);
        localTextView2.setTextSize(1, 14.0F);
        localTextView1.setTextSize(1, 14.0F);
        if (!Util.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (Util.isNullOrNil(localShowInfo.CIl)) {}
      }
      try
      {
        localTextView2.setTextColor(k.cW(localShowInfo.CIl, true));
        label252:
        if (!Util.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.OSG == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!Util.isNullOrNil(localShowInfo.OSB)) {}
        try
        {
          localTextView1.setTextColor(k.cW(localShowInfo.OSB, true));
          label312:
          if (localShowInfo.OSC == 1) {
            if (!Util.isNullOrNil(localShowInfo.OSF)) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(189845);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.OSF });
                  WalletOrderInfoNewUI.this.apy(localShowInfo.OSF);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(189845);
                }
              });
            }
          }
          for (;;)
          {
            this.OZG.addView(localLinearLayout);
            break;
            if ((localShowInfo.OSC == 2) && (!Util.isNullOrNil(localShowInfo.OSD))) {
              localLinearLayout.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(226361);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.OSD, localShowInfo.OSE });
                  paramAnonymousView = new xw();
                  paramAnonymousView.fWN.userName = localShowInfo.OSD;
                  paramAnonymousView.fWN.fWP = Util.nullAs(localShowInfo.OSE, "");
                  paramAnonymousView.fWN.scene = 1060;
                  paramAnonymousView.fWN.fvd = WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this);
                  paramAnonymousView.fWN.fWQ = 0;
                  paramAnonymousView.fWN.context = WalletOrderInfoNewUI.this;
                  EventCenter.instance.publish(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(226361);
                }
              });
            }
          }
          this.OZC.setVisibility(0);
          this.OZG.setVisibility(0);
          AppMethodBeat.o(71025);
          return;
        }
        catch (Exception localException1)
        {
          break label312;
        }
      }
      catch (Exception localException2)
      {
        break label252;
      }
    }
  }
  
  private void gLh()
  {
    AppMethodBeat.i(71021);
    this.OWe.getVisibility();
    this.OZC.getVisibility();
    this.OZN.getVisibility();
    this.OZU.getVisibility();
    this.NEN.post(new Runnable()
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
              break label269;
            }
            i = 1;
            if (WalletOrderInfoNewUI.m(WalletOrderInfoNewUI.this).getVisibility() != 0) {
              break label274;
            }
            m = 1;
            label84:
            if (i == 0) {
              break label289;
            }
          }
          label269:
          label274:
          label289:
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
                View localView = WalletOrderInfoNewUI.this.findViewById(a.f.pay_info_layout);
                k = i;
                if (localView != null) {
                  k = localView.getBottom();
                }
              }
              if ((WalletOrderInfoNewUI.n(WalletOrderInfoNewUI.this).getVisibility() != 0) && (WalletOrderInfoNewUI.c(WalletOrderInfoNewUI.this).getVisibility() != 0)) {}
              for (i = com.tencent.mm.ci.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                Log.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.ci.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void gLi()
  {
    AppMethodBeat.i(71022);
    if ((this.OxA != null) && (this.OZu != null) && (this.OZu.size() > 0))
    {
      Iterator localIterator = this.OZu.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).GHs));
    }
    for (int i = 0;; i = 1)
    {
      this.Ivj.setVisibility(0);
      this.Ivj.setTextSize(1, 17.0F);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.OxA.OQV)) && (!Util.isNullOrNil(this.OxA.OQV.trim())))
        {
          this.Ivj.setText(this.OxA.OQV);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.OxA.OIp != 1)
        {
          this.Ivj.setText(a.i.wallet_order_info_result_success_international);
          AppMethodBeat.o(71022);
          return;
        }
        this.Ivj.setText(a.i.wallet_order_info_result_success);
        AppMethodBeat.o(71022);
        return;
      }
      this.Ivj.setText(a.i.wallet_order_info_result_wait);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  private void gLz()
  {
    AppMethodBeat.i(71019);
    this.OZT.setVisibility(0);
    this.OZR.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  protected final void apy(String paramString)
  {
    AppMethodBeat.i(71027);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    gLk();
    g.p(this, paramString, true);
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
            AppMethodBeat.i(219384);
            WalletOrderInfoNewUI.this.gLE();
            AppMethodBeat.o(219384);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(217132);
            WalletOrderInfoNewUI.this.gLE();
            AppMethodBeat.o(217132);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          gLE();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    gLE();
    AppMethodBeat.o(71031);
  }
  
  protected final boolean fBc()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(71015);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.Iqp)
    {
      AppMethodBeat.o(71015);
      return;
    }
    this.Iqp = true;
    super.finish();
    AppMethodBeat.o(71015);
  }
  
  public final void gLE()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    gLk();
    Object localObject1 = new bb();
    ((bb)localObject1).fwN.fwO = true;
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = new jf();
    ((jf)localObject1).fGv.fGw = "ok";
    EventCenter.instance.publish((IEvent)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.OZt.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.OxA == null) || (this.mPayInfo == null)) {
          break label371;
        }
        com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aHF().kcd;
        String str2 = this.OxA.fwv;
        if (this.OxA.ORd.size() <= 0) {
          break label365;
        }
        localObject1 = ((Orders.Commodity)this.OxA.ORd.get(0)).fww;
        label282:
        localt.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.fOY, this.mPayInfo.channel, this.OxA.OQT), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label365:
        localObject1 = "";
        break label282;
        label371:
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    if (this.OWn != null)
    {
      this.OWn.a(this, 0, (Bundle)localObject2);
      this.OWn = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.fOY != 46) && (this.mPayInfo.fOY != 3))) {
        break label963;
      }
      localObject1 = new ns();
      if (this.mPayInfo.fOY != 46) {
        break label863;
      }
      ((ns)localObject1).had = 2L;
      label474:
      if ((this.OxA == null) || (this.OxA.ORq != 0)) {
        break label882;
      }
      ((ns)localObject1).hae = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.lfu != null))
      {
        localObject2 = this.mPayInfo.lfu.getString("extinfo_key_20", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((ns)localObject1).haf = ((ns)localObject1).z("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.lfu.getString("extinfo_key_21", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((ns)localObject1).hah = ((ns)localObject1).z("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.lfu.getString("extinfo_key_22", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((ns)localObject1).hag = ((ns)localObject1).z("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.OxA != null) && (this.OxA.ORq == 0) && (!Util.isNullOrNil(this.OxA.ORt)) && (!Util.isNullOrNil(this.OxA.ORs)))
      {
        ((ns)localObject1).haj = ((ns)localObject1).z("TargetAppPath", this.OxA.ORt, true);
        ((ns)localObject1).hai = ((ns)localObject1).z("TargetAppUsername", this.OxA.ORs, true);
      }
      ((ns)localObject1).bpa();
      if ((this.OxA == null) || (this.OxA.ORq != 0) || (Util.isNullOrNil(this.OxA.ORt)) || (Util.isNullOrNil(this.OxA.ORs))) {
        break label963;
      }
      localObject1 = new xw();
      ((xw)localObject1).fWN.userName = this.OxA.ORs;
      ((xw)localObject1).fWN.fWP = this.OxA.ORt;
      ((xw)localObject1).fWN.scene = 1060;
      ((xw)localObject1).fWN.fvd = this.GCu;
      ((xw)localObject1).fWN.fWQ = 0;
      ((xw)localObject1).fWN.context = this;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(71032);
      return;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label863:
      if (this.mPayInfo.fOY != 3) {
        break label474;
      }
      ((ns)localObject1).had = 1L;
      break label474;
      label882:
      if ((this.OxA != null) && (this.OxA.ORq == 1)) {
        ((ns)localObject1).hae = 2L;
      } else if ((this.OxA != null) && (this.OxA.ORq == 0) && (!Util.isNullOrNil(this.OxA.ORt)) && (!Util.isNullOrNil(this.OxA.ORs))) {
        ((ns)localObject1).hae = 3L;
      }
    }
    label963:
    int i;
    if ((this.OxA != null) && (!Util.isNullOrNil(this.OxA.vhY)))
    {
      if (this.OxA.ORd.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.OxA.ORd.get(0)).fww;
        localObject1 = i(this.OxA.vhY, this.OxA.fwv, (String)localObject1, this.mPayInfo.tol, this.mPayInfo.remark);
        Log.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", z.bcZ());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        g.aJ(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.OZQ.getVisibility() == 0) && (this.Iqj.abEC != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      localObject2 = this.Itj;
      localObject3 = this.OZS.getText();
      if (this.Iqj.abEC.abED != 0) {
        break label1257;
      }
      i = 1;
      label1182:
      if (!this.Paa) {
        break label1262;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.Pag), Long.valueOf(System.currentTimeMillis()) });
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
  
  protected void gLk()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.OVT)
    {
      lv locallv = new lv();
      locallv.fJI.requestCode = 4;
      lv.a locala = locallv.fJI;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      locallv.fJI.fJJ = new Intent();
      if (this.OxA != null) {
        locallv.fJI.fJJ.putExtra("key_jsapi_close_page_after_pay", this.OxA.ORq);
      }
      if ((this.OxA != null) && (this.OxA.ORq == 0) && (!Util.isNullOrNil(this.OxA.ORt)) && (!Util.isNullOrNil(this.OxA.ORs))) {
        locallv.fJI.fJJ.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.OWn != null) {
        locallv.fJI.fJJ.putExtra("key_is_clear_failure", this.OWn.fKb.getInt("key_is_clear_failure", -1));
      }
      EventCenter.instance.publish(locallv);
      this.OVT = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_order_info_ui_new;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71018);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.OWd = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.Ivj = ((TextView)findViewById(a.f.pay_succ_wording));
    ar.a(this.Ivj.getPaint(), 0.8F);
    this.OZy = ((TextView)findViewById(a.f.brand_tv));
    this.OZz = ((TextView)findViewById(a.f.fee_unit_tv));
    this.OZA = ((WalletTextView)findViewById(a.f.total_fee_tv));
    this.OZB = ((LinearLayout)findViewById(a.f.fee_layout));
    this.OZH = ((RelativeLayout)findViewById(a.f.finder_info_layout));
    this.OZI = ((CdnImageView)findViewById(a.f.finder_info_logo));
    this.OZJ = ((CdnImageView)findViewById(a.f.finder_info_sub_logo));
    this.OZK = ((TextView)findViewById(a.f.finder_info_title));
    this.finderDesc = ((TextView)findViewById(a.f.finder_info_desc));
    this.OZL = findViewById(a.f.finder_info_iv_layout_left);
    this.OZM = ((RelativeLayout)findViewById(a.f.finder_info_iv_layout_right));
    this.Iqo = ((TextView)findViewById(a.f.origin_fee_tv));
    this.OWc = ((Button)findViewById(a.f.pay_finish_button));
    this.uxW = ((ViewGroup)findViewById(a.f.root_layout));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(a.i.app_finish);
    Object localObject1;
    int i;
    label874:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 2)) {
      if ((this.OxA != null) && (!Util.isNullOrNil(this.OxA.ORo)))
      {
        localObject1 = this.OxA.ORo;
        this.OWc.setText((CharSequence)localObject1);
        this.OWc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71005);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            WalletOrderInfoNewUI.this.done();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71005);
          }
        });
        this.OZC = ((ViewGroup)findViewById(a.f.discount_info_layout));
        this.Iqm = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
        this.NEN = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
        this.Iql = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
        this.Iqn = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
        this.OZD = ((ViewGroup)findViewById(a.f.local_feeinfo_layout));
        this.OZE = ((ViewGroup)findViewById(a.f.discount_rateinfo_layout));
        this.OZG = ((ViewGroup)findViewById(a.f.show_info_container));
        this.OZF = ((ViewGroup)findViewById(a.f.remark_layout));
        this.OWe = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
        this.OWf = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
        this.OWf.setUseSdcardCache(true);
        this.OWg = ((TextView)findViewById(a.f.tinyapp_desc_tv));
        this.OWh = ((TextView)findViewById(a.f.tinyapp_name_tv));
        this.OWj = ((Button)findViewById(a.f.tinyapp_button));
        this.OWi = findViewById(a.f.tinyapp_info_touch_mask);
        this.OZN = ((ViewGroup)findViewById(a.f.subscribe_biz_layout));
        this.OZO = ((TextView)findViewById(a.f.biz_name_tv));
        this.OZP = ((CheckBox)findViewById(a.f.subscribe_biz_checkbox));
        this.OZU = ((ViewGroup)findViewById(a.f.activity_layout));
        this.OZV = ((CdnImageView)findViewById(a.f.activity_logo_iv));
        this.OZV.setUseSdcardCache(true);
        this.OZX = ((TextView)findViewById(a.f.activity_name_tv));
        this.OZW = ((TextView)findViewById(a.f.activity_desc_tv));
        this.OZY = ((Button)findViewById(a.f.activity_button));
        this.OZQ = ((ViewGroup)findViewById(a.f.wallet_order_card_mch_layout));
        this.OZS = ((TextView)findViewById(a.f.wallet_order_card_mch_title_tv));
        this.OZR = ((CdnImageView)findViewById(a.f.wallet_order_card_mch_icon_iv));
        this.OZT = ((ProgressBar)findViewById(a.f.wallet_order_card_mch_pb));
        this.Iqk = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
        gLi();
        if ((this.OxA != null) && (this.OZu != null) && (this.OZu.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.OZu.get(0);
          this.OZy.setText(((Orders.Commodity)localObject1).GHo);
          this.OZz.setText(g.bCm(((Orders.Commodity)localObject1).GHz));
          this.OZA.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).tVK) }));
          this.OZz.setTextSize(1, 48.0F);
          this.OZA.setTextSize(1, 48.0F);
        }
        if (this.OxA != null) {
          break label1636;
        }
        i = 0;
        Log.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.OxA == null) || (this.OxA.ORp != 1)) {
          break label1647;
        }
        this.OZD.setVisibility(8);
        this.OZE.setVisibility(8);
        this.Iqn.setVisibility(8);
        this.Iql.setVisibility(8);
        this.OZF.setVisibility(8);
        gLD();
        label961:
        gLC();
        if ((this.OxA != null) && (this.OZu != null)) {
          break label1915;
        }
        Log.i("MicroMsg.WalletOrderInfoNewUI", "corders == null || commditys == null");
        this.OZH.setVisibility(8);
        label997:
        if ((this.OZu == null) || (this.OZu.size() <= 0)) {
          break label2913;
        }
        localObject1 = (Orders.Commodity)this.OZu.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).ORO == null) || (((Orders.Commodity)localObject1).ORO.size() <= 0)) {
          break label2910;
        }
        localObject2 = ((Orders.Commodity)localObject1).ORO.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).OSs != null) && (((Orders.Promotions)localObject3).SuA == 5)) || ((((Orders.Promotions)localObject3).OSs != null) && (((Orders.Promotions)localObject3).OSs.abEC != null)))
          {
            this.Iqj = ((Orders.Promotions)localObject3).OSs;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.Iqj, Integer.valueOf(((Orders.Promotions)localObject3).SuA) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.Iqj)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.Iqk.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).ORH;
          if (((((Orders.Commodity)localObject1).ORE >= 0.0D) && (((Orders.Commodity)localObject1).tVK < ((Orders.Commodity)localObject1).ORE)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1236:
            this.Iqk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.Iqk.a(this, this.Iqj, this.GCu, false, (ImageView)findViewById(a.f.background));
          this.Iqk.init();
          this.Iqk.setVisibility(0);
          localObject1 = (ImageView)findViewById(a.f.background);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.Iqu.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.Iqu.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1312:
          if ((this.Iqj == null) || (this.Iqj.abEC == null)) {
            break label2857;
          }
          Log.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.Iqj.abEC.abED) });
          this.OZQ.setVisibility(0);
          if (this.Iqj.abEC.abED != 0) {
            break label2774;
          }
          this.Paa = false;
          com.tencent.mm.plugin.report.service.h.IzE.a(17267, new Object[] { this.Itj, this.Iqj.abEC.abEE, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label2193:
      label2461:
      label2720:
      label2857:
      for (;;)
      {
        gLA();
        Util.expandViewTouchArea(this.OZQ, 12, 12, 12, 12);
        this.OZQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71007);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        gLh();
        AppMethodBeat.o(71018);
        return;
        if (!Util.isNullOrNil(this.mPayInfo.Pjv))
        {
          localObject1 = getString(a.i.app_back) + this.mPayInfo.Pjv;
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.t(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.h.t(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.OxA == null) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.OxA.ORo)) {
          break;
        }
        localObject1 = this.OxA.ORo;
        break;
        label1636:
        i = this.OxA.ORp;
        break label874;
        label1647:
        gLB();
        if ((this.OxA != null) && (this.OZu != null) && (this.OZu.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.OZu.get(0);
          if (((Orders.Commodity)localObject1).ORN != null)
          {
            localObject2 = (TextView)this.OZF.findViewById(a.f.remark_info_title);
            localObject3 = (TextView)this.OZF.findViewById(a.f.remark_info_desc);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).ORN.OSz);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).ORN.OSA);
            this.OZF.setVisibility(0);
            this.OZC.setVisibility(0);
          }
        }
        this.OZE.setVisibility(8);
        this.OZD.setVisibility(8);
        if ((this.OxA == null) || (this.OZu == null) || (this.OZu.size() <= 0)) {
          break label961;
        }
        localObject1 = (Orders.Commodity)this.OZu.get(0);
        if (!Util.isNullOrNil(((Orders.Commodity)localObject1).ORK))
        {
          ((TextView)findViewById(a.f.local_feeinfo_tv)).setText(((Orders.Commodity)localObject1).ORK);
          this.OZD.setVisibility(0);
          this.OZC.setVisibility(0);
        }
        if (Util.isNullOrNil(((Orders.Commodity)localObject1).ORI)) {
          break label961;
        }
        ((TextView)findViewById(a.f.discount_rateinfo_tv)).setText(((Orders.Commodity)localObject1).ORI);
        this.OZE.setVisibility(0);
        this.OZC.setVisibility(0);
        break label961;
        label1915:
        if (this.OZu.size() < 0)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commditys.size() < 0");
          this.OZH.setVisibility(8);
          break label997;
        }
        localObject1 = (Orders.Commodity)this.OZu.get(0);
        if (((Orders.Commodity)localObject1).ORM == null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commodity.finder_info == null");
          this.OZH.setVisibility(8);
          break label997;
        }
        localObject2 = ((Orders.Commodity)localObject1).ORM.OSa;
        String str1 = ((Orders.Commodity)localObject1).ORM.OSb;
        String str2 = ((Orders.Commodity)localObject1).ORM.OSc;
        String str3 = ((Orders.Commodity)localObject1).ORM.OSd;
        localObject3 = ((Orders.Commodity)localObject1).ORM.OSe;
        String str4 = ((Orders.Commodity)localObject1).ORM.OSf;
        if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3)))
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "Util.isNullOrNil(finder_logo_normal) || Util.isNullOrNil(finder_title)");
          this.OZH.setVisibility(8);
          localObject1 = (RelativeLayout.LayoutParams)this.OZB.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 16);
          this.OZB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label997;
        }
        this.OZH.setVisibility(0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.OZB.getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 24);
        this.OZB.setLayoutParams(localLayoutParams);
        this.OZy.setVisibility(8);
        this.OZK.setText((CharSequence)localObject3);
        int j;
        if (!Util.isNullOrNil(str4))
        {
          this.finderDesc.setVisibility(0);
          this.finderDesc.setText(str4);
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0F);
          j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
          this.OZI.setRoundCorner(true);
          this.OZI.setRoundCornerRate(0.5F);
          this.OZJ.setRoundCorner(true);
          this.OZJ.setRoundCornerRate(0.5F);
          if ((!ar.isDarkMode()) || (Util.isNullOrNil(str1))) {
            break label2461;
          }
          this.OZI.w(str1, i, i, -1);
          label2271:
          if ((!ar.isDarkMode()) || (Util.isNullOrNil(str3))) {
            break label2476;
          }
          this.OZJ.w(str3, j, j, -1);
          label2297:
          i = ((Orders.Commodity)localObject1).ORM.type;
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder jump_type：%s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.IzE.a(22110, new Object[] { Integer.valueOf(2), this.Itj });
          }
          switch (i)
          {
          default: 
            this.OZL.setVisibility(8);
            this.OZM.setVisibility(8);
          }
        }
        while (this.OZM.getVisibility() == 0)
        {
          if (ar.isDarkMode()) {
            break label2720;
          }
          this.OZM.setBackgroundDrawable(getContext().getResources().getDrawable(a.e.wallet_order_info_finder_circle));
          break;
          this.finderDesc.setVisibility(8);
          break label2193;
          this.OZI.w((String)localObject2, i, i, -1);
          break label2271;
          label2476:
          this.OZJ.w(str2, j, j, -1);
          break label2297;
          localObject1 = ((Orders.Commodity)localObject1).ORM.url;
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder url：%s，mTransactionId：%s", new Object[] { localObject1, this.Itj });
          this.OZH.setOnClickListener(new WalletOrderInfoNewUI.2(this, (String)localObject1));
          continue;
          localObject2 = ((Orders.Commodity)localObject1).ORM.username;
          localObject3 = ((Orders.Commodity)localObject1).ORM.path;
          i = Util.getInt(((Orders.Commodity)localObject1).ORM.version, 0);
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder username：%s，path：%s，version：%s ,mTransactionId：%s", new Object[] { localObject2, localObject3, Integer.valueOf(i), this.Itj });
          this.OZH.setOnClickListener(new WalletOrderInfoNewUI.3(this, (String)localObject2, (String)localObject3, i));
          continue;
          i = ((Orders.Commodity)localObject1).ORM.OSg;
          str1 = ((Orders.Commodity)localObject1).ORM.OSh;
          str2 = ((Orders.Commodity)localObject1).ORM.OSi;
          localObject1 = ((Orders.Commodity)localObject1).ORM.OSj;
          Log.i("MicroMsg.WalletOrderInfoNewUI", " finder_logo_normal: %s ，finder_title:%s，finder_uri_type：%s", new Object[] { localObject2, localObject3, Integer.valueOf(i) });
          this.OZH.setOnClickListener(new WalletOrderInfoNewUI.4(this, i, str1, str2, (String)localObject1));
        }
        this.OZM.setBackground(getContext().getResources().getDrawable(a.e.wallet_order_info_finder_circle_darkmode));
        break label997;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 16);
        break label1236;
        Cj(true);
        this.Iqk.setVisibility(8);
        break label1312;
        label2774:
        if (this.Iqj.abEC.abED == 1)
        {
          this.Paa = true;
          com.tencent.mm.plugin.report.service.h.IzE.a(17267, new Object[] { this.Itj, this.Iqj.abEC.abEM, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.OZQ.setVisibility(8);
          continue;
          this.OZQ.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.IzE.a(17267, new Object[] { this.Itj, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label2910:
      continue;
      label2913:
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
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.OVX.Pav)), Boolean.valueOf(this.Pab) });
      if (this.Pab)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.Pab = true;
      if (Util.isNullOrNil(this.OVX.Pav))
      {
        doSceneProgress(new ag(this.OVX.OIw, this.OVX.Par, this.OVX.Pas, this.OVX.Pat, this.OVX.fHb, this.OVX.Ine, this.OVX.OSy));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(this.OVX.Pav, this.OVX.OIw));
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
    abh.a locala;
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(a.c.BG_2));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.OZt = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.bF(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.GCu = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      Log.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.GCu });
      this.OxA = gLy();
      if (this.OxA == null) {
        break label854;
      }
      setContentViewVisibility(0);
      c(this.OxA);
      Object localObject;
      if ((paramBundle != null) && (this.OxA != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.iim();
        j.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label802;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        int k = this.mPayInfo.fOY;
        if (this.mPayInfo.fOY != 3) {
          break label807;
        }
        bool1 = true;
        if (!bool2) {
          break label813;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.iiW()), Integer.valueOf((int)(this.OxA.fwy * 100.0D)), this.OxA.GHz, Integer.valueOf(i) });
      }
      if (((!u.gJo().gJQ()) && (paramBundle != null) && (paramBundle.iim())) || (!z.bdl())) {
        z.bdm();
      }
      if ((this.OxA == null) || (this.OxA.ORd == null) || (this.OxA.ORd.size() <= 0)) {
        break label818;
      }
      this.OZu = this.OxA.ORd;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.OZu.size()) });
      this.GCu = ((Orders.Commodity)this.OZu.get(0)).fww;
      this.Itj = ((Orders.Commodity)this.OZu.get(0)).fww;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.iil()) || (paramBundle.iim()))) {
        doSceneProgress(new ae(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.h.class)).j(this);
      initView();
      this.OWn = getProcess();
      gLi();
      if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 46))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new abh();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.OxA != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.OxA.fwy);
        }
        if (this.OWn != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.OWn.fKb.getInt("key_is_clear_failure", -1));
        }
        paramBundle.gaZ.intent = ((Intent)localObject);
        paramBundle.gaZ.gbc = 1;
        paramBundle.gaZ.fwv = getPayReqKey();
        locala = paramBundle.gaZ;
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
      if ((this.OxA == null) || (this.OxA.ORB == null) || (this.OxA.ORB.OSH != 1)) {
        break label895;
      }
      Log.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      gLE();
      AppMethodBeat.o(71016);
      return;
      getWindow().setStatusBarColor(getResources().getColor(a.c.BG_2));
      break;
      i = 1;
      break label231;
      bool1 = false;
      break label259;
      j = 2;
      break label266;
      Log.printInfoStack("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
      com.tencent.mm.ui.base.h.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.h.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    EventCenter.instance.addListener(this.Pac);
    EventCenter.instance.addListener(this.GFB);
    this.Iqq.alive();
    this.OWm = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label997;
      }
    }
    label997:
    for (paramBundle = "";; paramBundle = this.mPayInfo.fwv)
    {
      af.f(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.fOY;
      break;
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71029);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoNewUI.13(this));
    AppMethodBeat.o(71029);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71034);
    super.onDestroy();
    if (!this.Iqp)
    {
      jf localjf = new jf();
      localjf.fGv.fGw = "ok";
      EventCenter.instance.publish(localjf);
    }
    Log.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.Iqj != null) && (this.Iqj.abEC != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.Iqj.abEC.Sld, this.Iqj.abEC.abED, this.OZZ).bhW().h(new WalletOrderInfoNewUI.16(this));
    }
    EventCenter.instance.removeListener(this.Pac);
    EventCenter.instance.removeListener(this.GFB);
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.Iqq.dead();
    if (WalletSuccPageAwardWidget.a(this.Iqj)) {
      this.Iqk.onDestroy();
    }
    if (this.Pad != null) {
      this.Pad.cancel();
    }
    if (this.Pae != null) {
      this.Pae.cancel();
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
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.OWm), this.OZx, Boolean.valueOf(this.OWk), Boolean.valueOf(this.OWl), this.OZv, this.Iqj });
    if (WalletSuccPageAwardWidget.a(this.Iqj))
    {
      this.Iqk.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.OWm)
    {
      this.OWm = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.OZx != null) && (this.OWl))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.OZx.SuI)), this.OZx.SuI, Boolean.valueOf(this.Pab) });
      if (this.Pab)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.Pab = true;
      if (Util.isNullOrNil(this.OZx.SuI))
      {
        doSceneProgress(new ag(this.OZx.cpu, this.OZx.SuB, this.OZx.OQC, this.OZx.OQD, getPayReqKey(), this.Itj, this.OZx.OQE));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(this.OZx.SuI, this.OZx.cpu));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.OWk) && (this.OZv != null)) {
      doSceneProgress(new ag(this.OZv.OSt, this.OZv.OSv, this.OZv.OSw, this.OZv.OSx, getPayReqKey(), this.Itj, this.OZv.OSy));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(71036);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq });
    if ((WalletSuccPageAwardWidget.a(this.Iqj)) && (this.Iqk.onSceneEnd(paramInt1, paramInt2, paramString, paramq)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramq instanceof ag)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ag)paramq;
        paramq = new WalletOrderInfoNewUI.a(paramString.osF);
        if (this.OVX != null)
        {
          this.OVY.put(paramString.OIw, paramq);
          Cj(false);
          gLh();
        }
      }
      else
      {
        this.Pab = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.OWk) {
        break;
      }
      this.OVY.put(paramString.OIw, paramq);
      Cj(false);
      gLh();
      break;
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.q))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.q)paramq;
          paramq = paramString.OId;
          if (paramq.tqa == 0)
          {
            paramq = new WalletOrderInfoNewUI.a(paramq);
            if (this.OVX == null) {
              break label280;
            }
            this.OVY.put(paramString.oym, paramq);
            Cj(false);
            gLh();
          }
        }
        for (;;)
        {
          this.Pab = false;
          break;
          if (this.OWk)
          {
            this.OVY.put(paramString.oym, paramq);
            Cj(false);
            gLh();
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.t))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.t)paramq;
          paramq = paramString.OIe;
          if ((this.OZx != null) && (this.OZx.cpu == paramString.OIh.cpu))
          {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.OZx });
            this.OWb = paramq;
            Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.OIh.OQF });
            Cj(false);
            gLh();
            if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramq))) {
              this.OWj.setText(paramString.resultMsg);
            }
          }
          if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.OIf))) {
            com.tencent.mm.ui.base.h.c(this, paramString.OIf, "", true);
          }
          while (!"0".equals(paramq))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!Util.isNullOrNil(paramString.OIf)) {}
          for (paramString = paramString.OIf;; paramString = getString(a.i.wallet_pay_award_got))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71036);
        return true;
      }
    } while (!(paramq instanceof n));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (n)paramq;
      paramq = paramString.OHX;
      String str;
      if (paramq.tqa == 0)
      {
        str = paramq.Tbr;
        if ((this.OZx != null) && (this.OZx.cpu == paramString.cpu))
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.OZx });
          this.OWb = str;
          Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramq.Tbt });
          Cj(false);
          gLh();
          if ((!Util.isNullOrNil(paramq.Tbt)) && (!"3".equals(str))) {
            this.OWj.setText(paramq.Tbt);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (Util.isNullOrNil(paramq.Tbs))) {
          break label834;
        }
        com.tencent.mm.ui.base.h.c(this, paramq.Tbs, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!Util.isNullOrNil(paramq.Tbs)) {}
      for (paramString = paramq.Tbs;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(a.i.wallet_unknown_err);
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
  
  static final class b
  {
    public String Ine;
    public String OIw;
    public long OSy;
    public String Par;
    public String Pas;
    public String Pat;
    public long Pau;
    public String Pav;
    public String fHb;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.OIw = paramString1;
      this.Par = paramString2;
      this.Pas = paramString3;
      this.Pat = paramString4;
      this.fHb = paramString5;
      this.Ine = paramString6;
      this.OSy = paramLong1;
      this.Pau = paramLong2;
      this.Pav = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.OIw = paramString1;
      this.Par = paramString2;
      this.Pas = paramString3;
      this.Pat = paramString4;
      this.fHb = paramString5;
      this.Ine = paramString6;
      this.OSy = paramLong;
      this.Pav = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */