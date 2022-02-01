package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.adb;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.ade.a;
import com.tencent.mm.autogen.a.bh;
import com.tencent.mm.autogen.a.kg;
import com.tencent.mm.autogen.a.na;
import com.tencent.mm.autogen.a.na.a;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.mmdata.rpt.rk;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.FinderInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.LeadTailViewInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.protocal.protobuf.frc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
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
  private String MCK;
  private String MCL;
  private IListener MCd;
  private String MFC;
  private String MyF;
  private g.a.a.c OnC;
  private WalletSuccPageAwardWidget OnD;
  private ViewGroup OnE;
  private ViewGroup OnF;
  private ViewGroup OnG;
  private TextView OnH;
  private boolean OnI;
  private IListener<ade> OnJ;
  private String OqR;
  private TextView OsL;
  private ViewGroup Urc;
  private int VGE;
  private boolean VMA;
  private com.tencent.mm.wallet_core.e VMB;
  private boolean VMj;
  private b VMl;
  private HashMap<String, a> VMm;
  private String VMn;
  private String VMp;
  private Button VMq;
  private ImageView VMr;
  private ViewGroup VMs;
  private CdnImageView VMt;
  private TextView VMu;
  private TextView VMv;
  private View VMw;
  private Button VMx;
  private boolean VMy;
  private boolean VMz;
  protected Set<String> VPH;
  private List<Orders.Commodity> VPI;
  private Orders.RecommendTinyAppInfo VPJ;
  private String VPK;
  private Orders.Promotions VPL;
  private TextView VPM;
  private TextView VPN;
  private WalletTextView VPO;
  private LinearLayout VPP;
  private ViewGroup VPQ;
  private ViewGroup VPR;
  private ViewGroup VPS;
  private ViewGroup VPT;
  private ViewGroup VPU;
  private RelativeLayout VPV;
  private CdnImageView VPW;
  private CdnImageView VPX;
  private TextView VPY;
  private View VPZ;
  private RelativeLayout VQa;
  private LinearLayout VQb;
  private CdnImageView VQc;
  private TextView VQd;
  private ImageView VQe;
  private ViewGroup VQf;
  private TextView VQg;
  private CheckBox VQh;
  private ViewGroup VQi;
  private CdnImageView VQj;
  private TextView VQk;
  private ProgressBar VQl;
  private ViewGroup VQm;
  private CdnImageView VQn;
  private TextView VQo;
  private TextView VQp;
  private Button VQq;
  private int VQr;
  private boolean VQs;
  private boolean VQt;
  private IListener VQu;
  private com.tencent.mm.plugin.wallet_core.c.a VQv;
  private com.tencent.mm.plugin.wallet_core.c.c VQw;
  private boolean VQx;
  private int VQy;
  private Orders VmL;
  private TextView finderDesc;
  private String mAppId;
  private PayInfo mPayInfo;
  private String sWX;
  private ViewGroup xcW;
  
  public WalletOrderInfoNewUI()
  {
    AppMethodBeat.i(71014);
    this.sWX = null;
    this.MFC = null;
    this.VMj = false;
    this.VPH = null;
    this.mAppId = "";
    this.VPI = null;
    this.VMm = new HashMap();
    this.VPL = null;
    this.VMp = "-1";
    this.VMy = false;
    this.VMz = false;
    this.VQr = 0;
    this.VQs = false;
    this.VQt = false;
    this.VMA = false;
    this.MCd = new IListener(com.tencent.mm.app.f.hfK) {};
    this.VQu = new WalletOrderInfoNewUI.2(this, com.tencent.mm.app.f.hfK);
    this.OnI = false;
    this.OnJ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.VQx = false;
    this.VQy = 2;
    AppMethodBeat.o(71014);
  }
  
  private void HO(boolean paramBoolean)
  {
    AppMethodBeat.i(71026);
    this.VMs.setVisibility(8);
    this.VMz = false;
    this.VMy = false;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.VmL != null) {
      if ((this.VPI != null) && (this.VPI.size() > 0))
      {
        localObject2 = (Orders.Commodity)this.VPI.get(0);
        if (localObject2 != null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(((Orders.Commodity)localObject2).VHK) });
          if ((((Orders.Commodity)localObject2).VHJ == null) || (((Orders.Commodity)localObject2).VHJ.size() <= 0)) {
            break label1589;
          }
          localObject3 = ((Orders.Commodity)localObject2).VHJ.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (Orders.Promotions)((Iterator)localObject3).next();
          } while (((Orders.Promotions)localObject1).type != Orders.VHx);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (((Orders.Promotions)localObject1).ehe > 0L) && (!Util.isNullOrNil(((Orders.Promotions)localObject1).VGz)))
      {
        this.VPL = ((Orders.Promotions)localObject1);
        this.VMw.setVisibility(8);
        this.VMt.setRoundCorner(true);
        this.VMx.setEnabled(true);
        this.VMx.setBackgroundResource(a.e.btn_solid_green);
        this.VMv.setCompoundDrawables(null, null, null, null);
        localObject3 = (a)this.VMm.get(((Orders.Promotions)localObject1).ehe);
        if (localObject3 != null)
        {
          if (!Util.isNullOrNil(((a)localObject3).icon)) {
            this.VMt.setUrl(((a)localObject3).icon);
          }
          if (!Util.isNullOrNil(((a)localObject3).wording)) {
            this.VMu.setText(((a)localObject3).wording);
          }
          if (!Util.isNullOrNil(((a)localObject3).VQT))
          {
            this.VMx.setText(((a)localObject3).VQT);
            this.VMx.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!Util.isNullOrNil(((a)localObject3).VcU)) {
            this.VPL.akjs = ((a)localObject3).VcU;
          }
          if (!Util.isNullOrNil(((a)localObject3).VcV)) {
            this.VPL.akjt = ((a)localObject3).VcV;
          }
          if (((a)localObject3).VQU > 0) {
            this.VPL.akju = ((a)localObject3).VQU;
          }
          localObject4 = (RelativeLayout.LayoutParams)this.VMv.getLayoutParams();
          if ((localObject3 == null) || (Util.isNullOrNil(((a)localObject3).title))) {
            break label876;
          }
          this.VMv.setText(((a)localObject3).title);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          this.VMv.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.VMx.setVisibility(0);
          this.VMx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(301220);
              Log.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
              WalletOrderInfoNewUI.z(WalletOrderInfoNewUI.this);
              AppMethodBeat.o(301220);
            }
          });
          if (((Orders.Promotions)localObject1).akjp != 1) {
            this.VMs.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(301206);
                Log.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                WalletOrderInfoNewUI.z(WalletOrderInfoNewUI.this);
                AppMethodBeat.o(301206);
              }
            });
          }
          localObject3 = this.VMp;
          i = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              localObject3 = (ViewGroup.MarginLayoutParams)this.VMs.getLayoutParams();
              localObject4 = ((Orders.Commodity)localObject2).VHB;
              if (((((Orders.Commodity)localObject2).VHy >= 0.0D) && (((Orders.Commodity)localObject2).wZe < ((Orders.Commodity)localObject2).VHy)) || ((localObject4 != null) && (((List)localObject4).size() > 0)))
              {
                ((ViewGroup.MarginLayoutParams)localObject3).topMargin = 0;
                this.VMs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.VMs.setVisibility(0);
                if (paramBoolean)
                {
                  localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
                  localObject4 = this.OqR;
                  i = ((Orders.Promotions)localObject1).akjp;
                  if (!this.VMp.equals("-1")) {
                    break label1048;
                  }
                  localObject2 = Integer.valueOf(5);
                  ((com.tencent.mm.plugin.report.service.h)localObject3).b(13471, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), localObject2, Long.valueOf(((Orders.Promotions)localObject1).ehe), Long.valueOf(((Orders.Promotions)localObject1).VGy) });
                }
              }
              break;
            }
            break;
          }
        }
      }
      label876:
      while ((((Orders.Commodity)localObject2).VHF == null) || (Util.isNullOrNil(((Orders.Commodity)localObject2).VHF.VcU))) {
        for (;;)
        {
          Object localObject4;
          int i;
          if (this.VMu.getVisibility() == 0)
          {
            this.VMu.setSingleLine();
            this.VMu.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(301208);
                try
                {
                  if ((WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this).getVisibility() == 0) && (WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getRight() > 0) && (WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this).getLeft() > 0) && (WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getRight() >= WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this).getLeft()) && (!Util.isNullOrNil(WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getText())))
                  {
                    float f = WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getTextSize();
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getRight()), Integer.valueOf(WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this).getLeft()) });
                    Object localObject = new Paint();
                    ((Paint)localObject).setTextSize(f);
                    String str2 = WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getText().toString();
                    f = WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this).getLeft() - WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).getLeft();
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
                    WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).setText((CharSequence)localObject);
                    WalletOrderInfoNewUI.C(WalletOrderInfoNewUI.this).append("...");
                  }
                  AppMethodBeat.o(301208);
                  return;
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(301208);
                }
              }
            });
          }
          AppMethodBeat.o(71026);
          return;
          this.VMt.setUrl(((Orders.Promotions)localObject1).MRI);
          this.VMu.setText(((Orders.Promotions)localObject1).name);
          this.VMx.setText(((Orders.Promotions)localObject1).VGz);
          continue;
          if (!Util.isNullOrNil(((Orders.Promotions)localObject1).title))
          {
            this.VMv.setText(((Orders.Promotions)localObject1).title);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, 0);
          }
          else
          {
            this.VMv.setVisibility(8);
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
                        this.VMx.setEnabled(false);
                        continue;
                        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50);
                        continue;
                        localObject2 = this.VMp;
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
      this.MCK = ((Orders.Commodity)localObject2).VHF.VcU;
      this.MCL = ((Orders.Commodity)localObject2).VHF.VcV;
      this.VGE = ((Orders.Commodity)localObject2).VHF.VGE;
      this.VPJ = ((Orders.Commodity)localObject2).VHF;
      this.VMt.setUrl(((Orders.Commodity)localObject2).VHF.VGB);
      this.VMu.setText(((Orders.Commodity)localObject2).VHF.VGC);
      this.VMv.setText(getString(a.i.wallet_app_brand_entrance));
      this.VMv.setVisibility(0);
      this.VMt.setRoundCorner(true);
      this.VMx.setEnabled(true);
      this.VMx.setBackgroundResource(a.e.btn_solid_green);
      localObject1 = (RelativeLayout.LayoutParams)this.VMv.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 0);
      this.VMv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (((Orders.Commodity)localObject2).VHF.VIA > 0L)
      {
        if (!Util.isNullOrNil(((Orders.Commodity)localObject2).VHF.VGD))
        {
          this.VMx.setVisibility(0);
          this.VMx.setText(((Orders.Commodity)localObject2).VHF.VGD);
          this.VMw.setVisibility(8);
        }
        localObject1 = (a)this.VMm.get(((Orders.Commodity)localObject2).VHF.VIA);
        if (localObject1 != null)
        {
          if (!Util.isNullOrNil(((a)localObject1).VGB)) {
            this.VMt.setUrl(((a)localObject1).VGB);
          }
          if (!Util.isNullOrNil(((a)localObject1).VGC)) {
            this.VMu.setText(((a)localObject1).VGC);
          }
          if (!Util.isNullOrNil(((a)localObject1).VGD))
          {
            this.VMx.setText(((a)localObject1).VGD);
            this.VMx.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
          }
          if (!Util.isNullOrNil(((a)localObject1).VcU)) {
            this.MCK = ((a)localObject1).VcU;
          }
          if (!Util.isNullOrNil(((a)localObject1).VcV)) {
            this.MCL = ((a)localObject1).VcV;
          }
          if (((a)localObject1).VQU > 0) {
            this.VGE = ((a)localObject1).VQU;
          }
        }
        label1447:
        localObject1 = new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301209);
            Log.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this), Integer.valueOf(WalletOrderInfoNewUI.A(WalletOrderInfoNewUI.this)) });
            paramAnonymousView = new zp();
            paramAnonymousView.icM.userName = WalletOrderInfoNewUI.w(WalletOrderInfoNewUI.this);
            paramAnonymousView.icM.icO = Util.nullAs(WalletOrderInfoNewUI.x(WalletOrderInfoNewUI.this), "");
            paramAnonymousView.icM.scene = 1034;
            paramAnonymousView.icM.icP = 0;
            if (WalletOrderInfoNewUI.A(WalletOrderInfoNewUI.this) > 0) {
              paramAnonymousView.icM.appVersion = WalletOrderInfoNewUI.A(WalletOrderInfoNewUI.this);
            }
            paramAnonymousView.icM.context = WalletOrderInfoNewUI.this;
            paramAnonymousView.publish();
            paramAnonymousView = WalletOrderInfoNewUI.this;
            if ((!Util.isNullOrNil(this.VQR.VHF.VGD)) && (this.VQR.VHF.VIA > 0L)) {}
            for (boolean bool = true;; bool = false)
            {
              WalletOrderInfoNewUI.a(paramAnonymousView, bool);
              if (!WalletOrderInfoNewUI.y(WalletOrderInfoNewUI.this)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(14118, new Object[] { WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(3) });
              AppMethodBeat.o(301209);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(14118, new Object[] { WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this), WalletOrderInfoNewUI.this.getPayReqKey(), Integer.valueOf(1) });
            AppMethodBeat.o(301209);
          }
        };
        this.VMs.setOnClickListener((View.OnClickListener)localObject1);
        this.VMx.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = (ViewGroup.MarginLayoutParams)this.VMs.getLayoutParams();
        localObject3 = ((Orders.Commodity)localObject2).VHB;
        if (((((Orders.Commodity)localObject2).VHy < 0.0D) || (((Orders.Commodity)localObject2).wZe >= ((Orders.Commodity)localObject2).VHy)) && ((localObject3 == null) || (((List)localObject3).size() <= 0))) {
          break label1576;
        }
      }
      label1576:
      for (((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;; ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50))
      {
        this.VMs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.VMs.setVisibility(0);
        break;
        this.VMx.setVisibility(8);
        this.VMw.setVisibility(8);
        break label1447;
      }
      label1589:
      localObject1 = null;
    }
  }
  
  private void c(Orders paramOrders)
  {
    AppMethodBeat.i(71030);
    this.VPH.clear();
    if ((paramOrders == null) || (paramOrders.VGX == null))
    {
      Log.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
      AppMethodBeat.o(71030);
      return;
    }
    paramOrders = paramOrders.VGX.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.VGN == 2) && (!Util.isNullOrNil(localCommodity.VHz)))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
        this.VPH.add(localCommodity.VHz);
      }
    }
    AppMethodBeat.o(71030);
  }
  
  private void ikQ()
  {
    AppMethodBeat.i(71019);
    this.VQl.setVisibility(0);
    this.VQj.setVisibility(8);
    AppMethodBeat.o(71019);
  }
  
  private void ikR()
  {
    AppMethodBeat.i(71020);
    if (this.VQi.getVisibility() != 0)
    {
      AppMethodBeat.o(71020);
      return;
    }
    if (!this.VQs)
    {
      if (!Util.isNullOrNil(this.OnC.ajFF.ajFI)) {
        this.VQj.setUrl(this.OnC.ajFF.ajFI);
      }
      if (!Util.isNullOrNil(this.OnC.ajFF.ajFH))
      {
        this.VQk.setText(this.OnC.ajFF.ajFH);
        if (!Util.isNullOrNil(this.OnC.ajFF.ajFJ)) {
          this.VQk.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(this.OnC.ajFF.ajFJ, true));
        }
        if (this.OnC.ajFF.ajFK > 0L)
        {
          this.VQk.setTextSize(1, (float)this.OnC.ajFF.ajFK);
          AppMethodBeat.o(71020);
        }
      }
    }
    else
    {
      if (!Util.isNullOrNil(this.OnC.ajFF.ajFN)) {
        this.VQj.setUrl(this.OnC.ajFF.ajFN);
      }
      if (!Util.isNullOrNil(this.OnC.ajFF.ajFP))
      {
        this.VQk.setText(this.OnC.ajFF.ajFP);
        if (!Util.isNullOrNil(this.OnC.ajFF.ajFO)) {
          this.VQk.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(this.OnC.ajFF.ajFO, true));
        }
        if (this.OnC.ajFF.ajFK > 0L) {
          this.VQk.setTextSize(1, (float)this.OnC.ajFF.ajFK);
        }
      }
    }
    AppMethodBeat.o(71020);
  }
  
  private void ikS()
  {
    AppMethodBeat.i(71023);
    this.VPQ.setVisibility(8);
    this.OnF.setVisibility(8);
    this.OnE.setVisibility(8);
    this.OnG.setVisibility(8);
    if ((this.VmL != null) && (this.VPI != null) && (this.VPI.size() > 0))
    {
      Orders.Commodity localCommodity = (Orders.Commodity)this.VPI.get(0);
      List localList = localCommodity.VHB;
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
        this.OnF.removeAllViews();
        i = 0;
        if (i >= localList.size()) {
          break label308;
        }
        localDiscountInfo = (Orders.DiscountInfo)localList.get(i);
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(getResources().getColor(a.c.Orange));
        if (localDiscountInfo.VHU <= 0.0D) {
          break label295;
        }
        localTextView.setText(localDiscountInfo.OhO + i.e(localDiscountInfo.VHU / 100.0D, this.VmL.MEq));
      }
      for (;;)
      {
        this.OnF.addView(localTextView);
        i += 1;
        break label144;
        i = 0;
        break;
        label295:
        localTextView.setText(localDiscountInfo.OhO);
      }
      label308:
      this.OnF.setVisibility(0);
      this.VPQ.setVisibility(0);
      this.OnE.setVisibility(0);
      label332:
      if ((localCommodity.VHy >= 0.0D) && (localCommodity.wZe < localCommodity.VHy))
      {
        this.OnH.setText(i.e(localCommodity.VHy, localCommodity.MEq));
        this.OnH.getPaint().setFlags(16);
        this.OnG.setVisibility(0);
        this.VPQ.setVisibility(0);
      }
    }
    AppMethodBeat.o(71023);
  }
  
  private void ikT()
  {
    AppMethodBeat.i(71024);
    this.VQf.setVisibility(8);
    Orders.Commodity localCommodity;
    Orders.Promotions localPromotions;
    if (this.VmL != null)
    {
      c(this.VmL);
      if ((this.VPI != null) && (this.VPI.size() > 0))
      {
        localCommodity = (Orders.Commodity)this.VPI.get(0);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[] { Boolean.valueOf(localCommodity.VHK) });
        if ((localCommodity.VHK) && (localCommodity.VHJ != null) && (localCommodity.VHJ.size() > 0))
        {
          Iterator localIterator = localCommodity.VHJ.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localPromotions = (Orders.Promotions)localIterator.next();
          } while (localPromotions.type != Orders.VHw);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[] { localPromotions });
      if ((localPromotions != null) && (!Util.isNullOrNil(localPromotions.hzv)))
      {
        this.OqR = localCommodity.hAU;
        com.tencent.mm.plugin.report.service.h.OAn.b(13033, new Object[] { Integer.valueOf(1), localPromotions.hzv, localPromotions.url, localPromotions.name, this.OqR });
        this.VQg.setText(getString(a.i.wallet_order_info_subscribe_biz, new Object[] { localPromotions.name }));
        this.VPK = localPromotions.hzv;
        this.VQh.setVisibility(0);
        if (!this.VPH.contains(localPromotions.hzv)) {
          break label333;
        }
        this.VQh.setChecked(true);
      }
      for (;;)
      {
        this.VQf.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301219);
            if (!Util.isNullOrNil(WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)))
            {
              if (WalletOrderInfoNewUI.this.VPH.contains(WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this)))
              {
                WalletOrderInfoNewUI.this.VPH.remove(WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this));
                WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this).setChecked(false);
                AppMethodBeat.o(301219);
                return;
              }
              WalletOrderInfoNewUI.this.VPH.add(WalletOrderInfoNewUI.t(WalletOrderInfoNewUI.this));
              WalletOrderInfoNewUI.u(WalletOrderInfoNewUI.this).setChecked(true);
            }
            AppMethodBeat.o(301219);
          }
        });
        this.VQf.setVisibility(0);
        AppMethodBeat.o(71024);
        return;
        label333:
        this.VQh.setChecked(false);
      }
      localPromotions = null;
    }
  }
  
  private void ikU()
  {
    AppMethodBeat.i(71025);
    this.VPU.setVisibility(8);
    this.VPU.removeAllViews();
    Iterator localIterator;
    if ((this.VmL != null) && (this.VmL.VHj == 1) && (this.VmL.VHl != null) && (this.VmL.VHl.size() > 0))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[] { this.VmL.VHl, Integer.valueOf(this.VmL.VHl.size()) });
      localIterator = this.VmL.VHl.iterator();
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
        localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.wallet_order_info_show_info_layout, this.VPU, false);
        localTextView2 = (TextView)localLinearLayout.findViewById(a.f.left_tv);
        localTextView1 = (TextView)localLinearLayout.findViewById(a.f.right_tv);
        localTextView2.setTextSize(1, 14.0F);
        localTextView1.setTextSize(1, 14.0F);
        if (!Util.isNullOrNil(localShowInfo.name)) {
          localTextView2.setText(localShowInfo.name);
        }
        if (Util.isNullOrNil(localShowInfo.ICv)) {}
      }
      try
      {
        localTextView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(localShowInfo.ICv, true));
        label252:
        if (!Util.isNullOrNil(localShowInfo.value)) {
          localTextView1.setText(localShowInfo.value);
        }
        if (localShowInfo.VIN == 1) {
          localTextView1.getPaint().setFlags(16);
        }
        if (!Util.isNullOrNil(localShowInfo.VII)) {}
        try
        {
          localTextView1.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(localShowInfo.VII, true));
          label312:
          if (localShowInfo.VIJ == 1) {
            if (!Util.isNullOrNil(localShowInfo.VIM)) {
              localLinearLayout.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymousView)
                {
                  AppMethodBeat.i(301216);
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { localShowInfo.VIM });
                  WalletOrderInfoNewUI.this.aiT(localShowInfo.VIM);
                  AppMethodBeat.o(301216);
                }
              });
            }
          }
          for (;;)
          {
            this.VPU.addView(localLinearLayout);
            break;
            if ((localShowInfo.VIJ == 2) && (!Util.isNullOrNil(localShowInfo.VIK))) {
              localLinearLayout.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymousView)
                {
                  AppMethodBeat.i(301221);
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { localShowInfo.VIK, localShowInfo.VIL });
                  paramAnonymousView = new zp();
                  paramAnonymousView.icM.userName = localShowInfo.VIK;
                  paramAnonymousView.icM.icO = Util.nullAs(localShowInfo.VIL, "");
                  paramAnonymousView.icM.scene = 1060;
                  paramAnonymousView.icM.hzx = WalletOrderInfoNewUI.v(WalletOrderInfoNewUI.this);
                  paramAnonymousView.icM.icP = 0;
                  paramAnonymousView.icM.context = WalletOrderInfoNewUI.this;
                  paramAnonymousView.publish();
                  AppMethodBeat.o(301221);
                }
              });
            }
          }
          this.VPQ.setVisibility(0);
          this.VPU.setVisibility(0);
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
  
  private void iky()
  {
    AppMethodBeat.i(71021);
    this.VMs.getVisibility();
    this.VPQ.getVisibility();
    this.VQf.getVisibility();
    this.VQm.getVisibility();
    this.Urc.post(new Runnable()
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
              for (i = com.tencent.mm.cd.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + n;; i = n)
              {
                Log.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(j - k - i), Integer.valueOf(com.tencent.mm.cd.a.fromDPToPix(WalletOrderInfoNewUI.this, 50)) });
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
  
  private void ikz()
  {
    AppMethodBeat.i(71022);
    if ((this.VmL != null) && (this.VPI != null) && (this.VPI.size() > 0))
    {
      Iterator localIterator = this.VPI.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).MEj));
    }
    for (int i = 0;; i = 1)
    {
      this.OsL.setVisibility(0);
      this.OsL.setTextSize(1, 17.0F);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.VmL.VGP)) && (!Util.isNullOrNil(this.VmL.VGP.trim())))
        {
          this.OsL.setText(this.VmL.VGP);
          AppMethodBeat.o(71022);
          return;
        }
        if (this.VmL.Vyb != 1)
        {
          this.OsL.setText(a.i.wallet_order_info_result_success_international);
          AppMethodBeat.o(71022);
          return;
        }
        this.OsL.setText(a.i.wallet_order_info_result_success);
        AppMethodBeat.o(71022);
        return;
      }
      this.OsL.setText(a.i.wallet_order_info_result_wait);
      AppMethodBeat.o(71022);
      return;
    }
  }
  
  protected final void aiT(String paramString)
  {
    AppMethodBeat.i(71027);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[] { paramString });
    ikB();
    i.p(this, paramString, true);
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
            AppMethodBeat.i(301313);
            WalletOrderInfoNewUI.this.ikV();
            AppMethodBeat.o(301313);
          }
        });
        boolean bool2 = localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301311);
            WalletOrderInfoNewUI.this.ikV();
            AppMethodBeat.o(301311);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if ((!bool1) && (!bool2)) {
          ikV();
        }
      }
      AppMethodBeat.o(71031);
      return;
    }
    ikV();
    AppMethodBeat.o(71031);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71015);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.OnI)
    {
      AppMethodBeat.o(71015);
      return;
    }
    this.OnI = true;
    super.finish();
    AppMethodBeat.o(71015);
  }
  
  protected final boolean gNb()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_order_info_ui_new;
  }
  
  protected void ikB()
  {
    int i = 0;
    AppMethodBeat.i(71035);
    if (!this.VMj)
    {
      na localna = new na();
      localna.hPl.hPm = 4;
      na.a locala = localna.hPl;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      localna.hPl.hPn = new Intent();
      if (this.VmL != null) {
        localna.hPl.hPn.putExtra("key_jsapi_close_page_after_pay", this.VmL.VHk);
      }
      if ((this.VmL != null) && (this.VmL.VHk == 0) && (!Util.isNullOrNil(this.VmL.VHn)) && (!Util.isNullOrNil(this.VmL.VHm))) {
        localna.hPl.hPn.putExtra("key_jsapi_close_page_after_pay", 1);
      }
      if (this.VMB != null) {
        localna.hPl.hPn.putExtra("key_is_clear_failure", this.VMB.hPH.getInt("key_is_clear_failure", -1));
      }
      localna.publish();
      this.VMj = true;
    }
    AppMethodBeat.o(71035);
  }
  
  public final void ikV()
  {
    int j = 1;
    AppMethodBeat.i(71032);
    ikB();
    Object localObject1 = new bh();
    ((bh)localObject1).hBn.hBo = true;
    ((bh)localObject1).publish();
    localObject1 = new kg();
    ((kg)localObject1).hLR.hLS = "ok";
    ((kg)localObject1).publish();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject3 = this.VPH.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.VmL == null) || (this.mPayInfo == null)) {
          break label365;
        }
        s locals = com.tencent.mm.kernel.h.baD().mCm;
        String str2 = this.VmL.hAT;
        if (this.VmL.VGX.size() <= 0) {
          break label359;
        }
        localObject1 = ((Orders.Commodity)this.VmL.VGX.get(0)).hAU;
        label276:
        locals.a(new com.tencent.mm.wallet_core.model.t(str1, str2, (String)localObject1, this.mPayInfo.hUR, this.mPayInfo.channel, this.VmL.VGN), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label359:
        localObject1 = "";
        break label276;
        label365:
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.wallet_core.model.t(str1), 0);
      }
    }
    if (this.VMB != null)
    {
      this.VMB.a(this, 0, (Bundle)localObject2);
      this.VMB = null;
      if ((this.mPayInfo == null) || ((this.mPayInfo.hUR != 46) && (this.mPayInfo.hUR != 3))) {
        break label954;
      }
      localObject1 = new rk();
      if (this.mPayInfo.hUR != 46) {
        break label854;
      }
      ((rk)localObject1).jvN = 2L;
      label468:
      if ((this.VmL == null) || (this.VmL.VHk != 0)) {
        break label873;
      }
      ((rk)localObject1).jvO = 1L;
    }
    for (;;)
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.nKf != null))
      {
        localObject2 = this.mPayInfo.nKf.getString("extinfo_key_20", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((rk)localObject1).jvP = ((rk)localObject1).F("SourceH5Url", (String)localObject2, false);
        }
        localObject2 = this.mPayInfo.nKf.getString("extinfo_key_21", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((rk)localObject1).jvR = ((rk)localObject1).F("SourceAppPath", (String)localObject2, true);
        }
        localObject2 = this.mPayInfo.nKf.getString("extinfo_key_22", "");
        if (!Util.isNullOrNil((String)localObject2)) {
          ((rk)localObject1).jvQ = ((rk)localObject1).F("SourceAppUsername", (String)localObject2, true);
        }
      }
      if ((this.VmL != null) && (this.VmL.VHk == 0) && (!Util.isNullOrNil(this.VmL.VHn)) && (!Util.isNullOrNil(this.VmL.VHm)))
      {
        ((rk)localObject1).jvT = ((rk)localObject1).F("TargetAppPath", this.VmL.VHn, true);
        ((rk)localObject1).jvS = ((rk)localObject1).F("TargetAppUsername", this.VmL.VHm, true);
      }
      ((rk)localObject1).bMH();
      if ((this.VmL == null) || (this.VmL.VHk != 0) || (Util.isNullOrNil(this.VmL.VHn)) || (Util.isNullOrNil(this.VmL.VHm))) {
        break label954;
      }
      localObject1 = new zp();
      ((zp)localObject1).icM.userName = this.VmL.VHm;
      ((zp)localObject1).icM.icO = this.VmL.VHn;
      ((zp)localObject1).icM.scene = 1060;
      ((zp)localObject1).icM.hzx = this.MyF;
      ((zp)localObject1).icM.icP = 0;
      ((zp)localObject1).icM.context = this;
      ((zp)localObject1).publish();
      AppMethodBeat.o(71032);
      return;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
      finish();
      break;
      label854:
      if (this.mPayInfo.hUR != 3) {
        break label468;
      }
      ((rk)localObject1).jvN = 1L;
      break label468;
      label873:
      if ((this.VmL != null) && (this.VmL.VHk == 1)) {
        ((rk)localObject1).jvO = 2L;
      } else if ((this.VmL != null) && (this.VmL.VHk == 0) && (!Util.isNullOrNil(this.VmL.VHn)) && (!Util.isNullOrNil(this.VmL.VHm))) {
        ((rk)localObject1).jvO = 3L;
      }
    }
    label954:
    int i;
    if ((this.VmL != null) && (!Util.isNullOrNil(this.VmL.ytZ)))
    {
      if (this.VmL.VGX.size() > 0)
      {
        localObject1 = ((Orders.Commodity)this.VmL.VGX.get(0)).hAU;
        localObject1 = i(this.VmL.ytZ, this.VmL.hAT, (String)localObject1, this.mPayInfo.wsM, this.mPayInfo.remark);
        Log.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(localObject1)));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject2).putExtra("showShare", false);
        ((Intent)localObject2).putExtra("geta8key_username", z.bAM());
        ((Intent)localObject2).putExtra("stastic_scene", 8);
        i.aS(getContext(), (Intent)localObject2);
      }
    }
    else if ((this.VQi.getVisibility() == 0) && (this.OnC.ajFF != null))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      localObject2 = this.OqR;
      localObject3 = this.VQk.getText();
      if (this.OnC.ajFF.ajFG != 0) {
        break label1248;
      }
      i = 1;
      label1173:
      if (!this.VQs) {
        break label1253;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).b(17271, new Object[] { localObject2, localObject3, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.VQy), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(71032);
      return;
      localObject1 = "";
      break;
      label1248:
      i = 2;
      break label1173;
      label1253:
      j = 2;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(71018);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.VMr = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.OsL = ((TextView)findViewById(a.f.pay_succ_wording));
    aw.a(this.OsL.getPaint(), 0.8F);
    this.VPM = ((TextView)findViewById(a.f.brand_tv));
    this.VPN = ((TextView)findViewById(a.f.fee_unit_tv));
    this.VPO = ((WalletTextView)findViewById(a.f.total_fee_tv));
    this.VPP = ((LinearLayout)findViewById(a.f.fee_layout));
    this.VPV = ((RelativeLayout)findViewById(a.f.finder_info_layout));
    this.VPW = ((CdnImageView)findViewById(a.f.finder_info_logo));
    this.VPX = ((CdnImageView)findViewById(a.f.finder_info_sub_logo));
    this.VPY = ((TextView)findViewById(a.f.finder_info_title));
    this.finderDesc = ((TextView)findViewById(a.f.finder_info_desc));
    this.VPZ = findViewById(a.f.finder_info_iv_layout_left);
    this.VQa = ((RelativeLayout)findViewById(a.f.finder_info_iv_layout_right));
    this.VQb = ((LinearLayout)findViewById(a.f.wallet_order_info_lead_tail_view_layout));
    this.VQc = ((CdnImageView)findViewById(a.f.lead_tail_view_logo));
    this.VQd = ((TextView)findViewById(a.f.lead_tail_view_desc));
    this.VQe = ((ImageView)findViewById(a.f.lead_tail_view_arrow));
    this.OnH = ((TextView)findViewById(a.f.origin_fee_tv));
    this.VMq = ((Button)findViewById(a.f.pay_finish_button));
    this.xcW = ((ViewGroup)findViewById(a.f.root_layout));
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject2 = getString(a.i.app_finish);
    Object localObject1;
    final int i;
    label936:
    label1023:
    Object localObject3;
    if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 2)) {
      if ((this.VmL != null) && (!Util.isNullOrNil(this.VmL.VHi)))
      {
        localObject1 = this.VmL.VHi;
        this.VMq.setText((CharSequence)localObject1);
        this.VMq.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301308);
            WalletOrderInfoNewUI.this.done();
            AppMethodBeat.o(301308);
          }
        });
        this.VPQ = ((ViewGroup)findViewById(a.f.discount_info_layout));
        this.OnF = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
        this.Urc = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
        this.OnE = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
        this.OnG = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
        this.VPR = ((ViewGroup)findViewById(a.f.local_feeinfo_layout));
        this.VPS = ((ViewGroup)findViewById(a.f.discount_rateinfo_layout));
        this.VPU = ((ViewGroup)findViewById(a.f.show_info_container));
        this.VPT = ((ViewGroup)findViewById(a.f.remark_layout));
        this.VMs = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
        this.VMt = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
        this.VMt.setUseSdcardCache(true);
        this.VMu = ((TextView)findViewById(a.f.tinyapp_desc_tv));
        this.VMv = ((TextView)findViewById(a.f.tinyapp_name_tv));
        this.VMx = ((Button)findViewById(a.f.tinyapp_button));
        this.VMw = findViewById(a.f.tinyapp_info_touch_mask);
        this.VQf = ((ViewGroup)findViewById(a.f.subscribe_biz_layout));
        this.VQg = ((TextView)findViewById(a.f.biz_name_tv));
        this.VQh = ((CheckBox)findViewById(a.f.subscribe_biz_checkbox));
        this.VQm = ((ViewGroup)findViewById(a.f.activity_layout));
        this.VQn = ((CdnImageView)findViewById(a.f.activity_logo_iv));
        this.VQn.setUseSdcardCache(true);
        this.VQp = ((TextView)findViewById(a.f.activity_name_tv));
        this.VQo = ((TextView)findViewById(a.f.activity_desc_tv));
        this.VQq = ((Button)findViewById(a.f.activity_button));
        this.VQi = ((ViewGroup)findViewById(a.f.wallet_order_card_mch_layout));
        this.VQk = ((TextView)findViewById(a.f.wallet_order_card_mch_title_tv));
        this.VQj = ((CdnImageView)findViewById(a.f.wallet_order_card_mch_icon_iv));
        this.VQl = ((ProgressBar)findViewById(a.f.wallet_order_card_mch_pb));
        this.OnD = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
        ikz();
        if ((this.VmL != null) && (this.VPI != null) && (this.VPI.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.VPI.get(0);
          this.VPM.setText(((Orders.Commodity)localObject1).MEf);
          this.VPN.setText(i.bEK(((Orders.Commodity)localObject1).MEq));
          this.VPO.setText(String.format("%.2f", new Object[] { Double.valueOf(((Orders.Commodity)localObject1).wZe) }));
          this.VPN.setTextSize(1, 48.0F);
          this.VPO.setTextSize(1, 48.0F);
        }
        if (this.VmL != null) {
          break label1750;
        }
        i = 0;
        Log.i("MicroMsg.WalletOrderInfoNewUI", "is_use_show_info: %s", new Object[] { Integer.valueOf(i) });
        if ((this.VmL == null) || (this.VmL.VHj != 1)) {
          break label1761;
        }
        this.VPR.setVisibility(8);
        this.VPS.setVisibility(8);
        this.OnG.setVisibility(8);
        this.OnE.setVisibility(8);
        this.VPT.setVisibility(8);
        ikU();
        ikT();
        if ((this.VmL != null) && (this.VPI != null)) {
          break label2038;
        }
        Log.i("MicroMsg.WalletOrderInfoNewUI", "corders == null || commditys == null");
        this.VPV.setVisibility(8);
        label1059:
        if ((this.VmL != null) && (this.VPI != null)) {
          break label2892;
        }
        Log.i("MicroMsg.WalletOrderInfoNewUI", "corders == null || commditys == null");
        this.VQb.setVisibility(8);
        label1091:
        if ((this.VPI == null) || (this.VPI.size() <= 0)) {
          break label3646;
        }
        localObject1 = (Orders.Commodity)this.VPI.get(0);
        if ((localObject1 == null) || (((Orders.Commodity)localObject1).VHJ == null) || (((Orders.Commodity)localObject1).VHJ.size() <= 0)) {
          break label3643;
        }
        localObject2 = ((Orders.Commodity)localObject1).VHJ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Orders.Promotions)((Iterator)localObject2).next();
          if (((((Orders.Promotions)localObject3).VIz != null) && (((Orders.Promotions)localObject3).akjp == 5)) || ((((Orders.Promotions)localObject3).VIz != null) && (((Orders.Promotions)localObject3).VIz.ajFF != null)))
          {
            this.OnC = ((Orders.Promotions)localObject3).VIz;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[] { this.OnC, Integer.valueOf(((Orders.Promotions)localObject3).akjp) });
          }
        }
      }
    }
    for (;;)
    {
      if (WalletSuccPageAwardWidget.a(this.OnC)) {
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)this.OnD.getLayoutParams();
          localObject3 = ((Orders.Commodity)localObject1).VHB;
          if (((((Orders.Commodity)localObject1).VHy >= 0.0D) && (((Orders.Commodity)localObject1).wZe < ((Orders.Commodity)localObject1).VHy)) || ((localObject3 != null) && (((List)localObject3).size() > 0)))
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
            label1340:
            this.OnD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          this.OnD.a(this, this.OnC, this.MyF, false, (ImageView)findViewById(a.f.background));
          this.OnD.init();
          this.OnD.setVisibility(0);
          localObject1 = (ImageView)findViewById(a.f.background);
          ((ImageView)localObject1).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71006);
              ViewGroup.LayoutParams localLayoutParams = this.OnN.getLayoutParams();
              localLayoutParams.width = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getWidth();
              localLayoutParams.height = WalletOrderInfoNewUI.f(WalletOrderInfoNewUI.this).getHeight();
              this.OnN.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(71006);
            }
          });
          label1419:
          if ((this.OnC == null) || (this.OnC.ajFF == null)) {
            break label3590;
          }
          Log.i("MicroMsg.WalletOrderInfoNewUI", "show card info: %s", new Object[] { Integer.valueOf(this.OnC.ajFF.ajFG) });
          this.VQi.setVisibility(0);
          if (this.OnC.ajFF.ajFG != 0) {
            break label3507;
          }
          this.VQs = false;
          com.tencent.mm.plugin.report.service.h.OAn.b(17267, new Object[] { this.OqR, this.OnC.ajFF.ajFH, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label3590:
      for (;;)
      {
        ikR();
        Util.expandViewTouchArea(this.VQi, 12, 12, 12, 12);
        this.VQi.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301301);
            Log.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
            if (WalletOrderInfoNewUI.g(WalletOrderInfoNewUI.this))
            {
              WalletOrderInfoNewUI.h(WalletOrderInfoNewUI.this);
              AppMethodBeat.o(301301);
              return;
            }
            WalletOrderInfoNewUI.i(WalletOrderInfoNewUI.this);
            AppMethodBeat.o(301301);
          }
        });
        iky();
        AppMethodBeat.o(71018);
        return;
        if (!Util.isNullOrNil(this.mPayInfo.Wan))
        {
          localObject1 = getString(a.i.app_back) + this.mPayInfo.Wan;
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.mPayInfo.appId)) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.x(this, this.mPayInfo.appId))) {
          break;
        }
        localObject1 = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.h.x(this, this.mPayInfo.appId);
        break;
        localObject1 = localObject2;
        if (this.VmL == null) {
          break;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.VmL.VHi)) {
          break;
        }
        localObject1 = this.VmL.VHi;
        break;
        label1750:
        i = this.VmL.VHj;
        break label936;
        label1761:
        ikS();
        if ((this.VmL != null) && (this.VPI != null) && (this.VPI.size() > 0))
        {
          localObject1 = (Orders.Commodity)this.VPI.get(0);
          if (((Orders.Commodity)localObject1).VHI != null)
          {
            localObject2 = (TextView)this.VPT.findViewById(a.f.remark_info_title);
            localObject3 = (TextView)this.VPT.findViewById(a.f.remark_info_desc);
            ((TextView)localObject2).setText(((Orders.Commodity)localObject1).VHI.VIG);
            ((TextView)localObject3).setText(((Orders.Commodity)localObject1).VHI.VIH);
            this.VPT.setVisibility(0);
            this.VPQ.setVisibility(0);
          }
        }
        this.VPS.setVisibility(8);
        this.VPR.setVisibility(8);
        if ((this.VmL == null) || (this.VPI == null) || (this.VPI.size() <= 0)) {
          break label1023;
        }
        localObject1 = (Orders.Commodity)this.VPI.get(0);
        if (!Util.isNullOrNil(((Orders.Commodity)localObject1).VHE))
        {
          ((TextView)findViewById(a.f.local_feeinfo_tv)).setText(((Orders.Commodity)localObject1).VHE);
          this.VPR.setVisibility(0);
          this.VPQ.setVisibility(0);
        }
        if (Util.isNullOrNil(((Orders.Commodity)localObject1).VHC)) {
          break label1023;
        }
        ((TextView)findViewById(a.f.discount_rateinfo_tv)).setText(((Orders.Commodity)localObject1).VHC);
        this.VPS.setVisibility(0);
        this.VPQ.setVisibility(0);
        break label1023;
        label2038:
        if (this.VPI.size() < 0)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commditys.size() < 0");
          this.VPV.setVisibility(8);
          break label1059;
        }
        localObject1 = (Orders.Commodity)this.VPI.get(0);
        if (((Orders.Commodity)localObject1).VHG == null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commodity.finder_info == null");
          this.VPV.setVisibility(8);
          break label1059;
        }
        localObject2 = ((Orders.Commodity)localObject1).VHG.VHV;
        final String str1 = ((Orders.Commodity)localObject1).VHG.VHW;
        final String str2 = ((Orders.Commodity)localObject1).VHG.VHX;
        String str3 = ((Orders.Commodity)localObject1).VHG.VHY;
        localObject3 = ((Orders.Commodity)localObject1).VHG.VHZ;
        String str4 = ((Orders.Commodity)localObject1).VHG.VIa;
        if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3)))
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "Util.isNullOrNil(finder_logo_normal) || Util.isNullOrNil(finder_title)");
          this.VPV.setVisibility(8);
          localObject1 = (RelativeLayout.LayoutParams)this.VPP.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
          this.VPP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label1059;
        }
        this.VPV.setVisibility(0);
        Object localObject4 = (RelativeLayout.LayoutParams)this.VPP.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 24);
        this.VPP.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.VPM.setVisibility(8);
        this.VPY.setText((CharSequence)localObject3);
        label2327:
        int j;
        if (!Util.isNullOrNil(str4))
        {
          this.finderDesc.setVisibility(0);
          this.finderDesc.setText(str4);
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0F);
          j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
          this.VPW.setRoundCorner(true);
          this.VPW.setRoundCornerRate(0.5F);
          this.VPX.setRoundCorner(true);
          this.VPX.setRoundCornerRate(0.5F);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(str1))) {
            break label2597;
          }
          this.VPW.w(str1, i, i, -1);
          label2405:
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(str3))) {
            break label2612;
          }
          this.VPX.w(str3, j, j, -1);
          label2431:
          i = ((Orders.Commodity)localObject1).VHG.type;
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder jump_type：%s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.OAn.b(22110, new Object[] { Integer.valueOf(2), this.OqR });
          }
          switch (i)
          {
          default: 
            this.VPZ.setVisibility(8);
            this.VQa.setVisibility(8);
          }
        }
        while (this.VQa.getVisibility() == 0)
        {
          if (aw.isDarkMode()) {
            break label2869;
          }
          this.VQa.setBackgroundDrawable(getContext().getResources().getDrawable(a.e.wallet_order_info_finder_circle));
          break;
          this.finderDesc.setVisibility(8);
          break label2327;
          label2597:
          this.VPW.w((String)localObject2, i, i, -1);
          break label2405;
          label2612:
          this.VPX.w(str2, j, j, -1);
          break label2431;
          localObject1 = ((Orders.Commodity)localObject1).VHG.url;
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder url：%s，mTransactionId：%s", new Object[] { localObject1, this.OqR });
          this.VPV.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(301319);
              com.tencent.mm.plugin.report.service.h.OAn.b(22110, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
              i.o(WalletOrderInfoNewUI.this, this.val$url, true);
              AppMethodBeat.o(301319);
            }
          });
          continue;
          localObject2 = ((Orders.Commodity)localObject1).VHG.username;
          localObject3 = ((Orders.Commodity)localObject1).VHG.path;
          i = Util.getInt(((Orders.Commodity)localObject1).VHG.version, 0);
          Log.i("MicroMsg.WalletOrderInfoNewUI", "finder username：%s，path：%s，version：%s ,mTransactionId：%s", new Object[] { localObject2, localObject3, Integer.valueOf(i), this.OqR });
          this.VPV.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(301322);
              com.tencent.mm.plugin.report.service.h.OAn.b(22110, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
              i.y(this.lzC, this.val$path, i, 8);
              AppMethodBeat.o(301322);
            }
          });
          continue;
          i = ((Orders.Commodity)localObject1).VHG.VIb;
          str1 = ((Orders.Commodity)localObject1).VHG.VIc;
          str2 = ((Orders.Commodity)localObject1).VHG.VId;
          localObject1 = ((Orders.Commodity)localObject1).VHG.VIe;
          Log.i("MicroMsg.WalletOrderInfoNewUI", " finder_logo_normal: %s ，finder_title:%s，finder_uri_type：%s", new Object[] { localObject2, localObject3, Integer.valueOf(i) });
          this.VPV.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(301323);
              com.tencent.mm.plugin.report.service.h.OAn.b(22110, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
              switch (i)
              {
              default: 
                Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_feedid：%s，finder_uri_nonceid：%s", new Object[] { str2, this.VQD });
                AppMethodBeat.o(301323);
                return;
              case 0: 
                Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_username：%s, mTransactionId:%s", new Object[] { str1, WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().G(WalletOrderInfoNewUI.this, str1, com.tencent.mm.plugin.wallet_core.utils.m.asD(1));
                AppMethodBeat.o(301323);
                return;
              }
              Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_feedid：%s，finder_uri_nonceid：%s，mTransactionId:%s ", new Object[] { str2, this.VQD, WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().h(WalletOrderInfoNewUI.this, str2, this.VQD, com.tencent.mm.plugin.wallet_core.utils.m.asD(1));
              AppMethodBeat.o(301323);
            }
          });
        }
        label2869:
        this.VQa.setBackground(getContext().getResources().getDrawable(a.e.wallet_order_info_finder_circle_darkmode));
        break label1059;
        label2892:
        if (this.VPI.size() < 0)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commditys.size() < 0");
          this.VQb.setVisibility(8);
          break label1091;
        }
        localObject1 = (Orders.Commodity)this.VPI.get(0);
        if (((Orders.Commodity)localObject1).VHH == null)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "commodity.lead_tail_view_info == null");
          this.VQb.setVisibility(8);
          break label1091;
        }
        localObject2 = ((Orders.Commodity)localObject1).VHH.desc;
        int k;
        final String str5;
        final String str6;
        final int m;
        if (!Util.isNullOrNil((String)localObject2))
        {
          this.VQd.setText((CharSequence)localObject2);
          localObject2 = ((Orders.Commodity)localObject1).VHH.VIf;
          localObject3 = ((Orders.Commodity)localObject1).VHH.VIg;
          str1 = ((Orders.Commodity)localObject1).VHH.VIh;
          str2 = ((Orders.Commodity)localObject1).VHH.VIi;
          i = ((Orders.Commodity)localObject1).VHH.type;
          j = ((Orders.Commodity)localObject1).VHH.VIj;
          str3 = ((Orders.Commodity)localObject1).VHH.VIk;
          str4 = ((Orders.Commodity)localObject1).VHH.VIl;
          localObject4 = ((Orders.Commodity)localObject1).VHH.VIm;
          k = Util.getInt(((Orders.Commodity)localObject1).VHH.VIn, 0);
          str5 = ((Orders.Commodity)localObject1).VHH.VIp;
          str6 = ((Orders.Commodity)localObject1).VHH.VIq;
          localObject1 = ((Orders.Commodity)localObject1).VHH.VIo;
          m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 15.0F);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(str2))) {
            break label3269;
          }
          this.VQc.w(str2, m, m, -1);
        }
        for (;;)
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "leadViewInfo jump_type，route_info_type：%s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != 2) {
            break label3385;
          }
          switch (j)
          {
          default: 
            this.VQe.setVisibility(8);
            this.VQb.setOnClickListener(null);
            this.VQb.setBackground(null);
            break label1091;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "commodity.lead_tail_view_info desc == null");
            this.VQb.setVisibility(8);
            break label1091;
            label3269:
            this.VQc.w(str1, m, m, -1);
          }
        }
        this.VQb.setClickable(true);
        this.VQb.setBackground(getContext().getResources().getDrawable(a.e.wallet_order_status_click_bg));
        this.VQb.setOnClickListener(new WalletOrderInfoNewUI.7(this, str3));
        break label1091;
        this.VQb.setClickable(true);
        this.VQb.setBackground(getContext().getResources().getDrawable(a.e.wallet_order_status_click_bg));
        this.VQb.setOnClickListener(new WalletOrderInfoNewUI.8(this, str4, (String)localObject4, k));
        break label1091;
        label3385:
        if (i == 3)
        {
          this.VQb.setClickable(true);
          this.VQb.setBackground(getContext().getResources().getDrawable(a.e.wallet_order_status_click_bg));
          this.VQb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(301324);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.WalletOrderInfoNewUI", "leadViewInfo click jump status");
              paramAnonymousView = new com.tencent.mm.plugin.textstatus.proto.k();
              paramAnonymousView.Oks = str5;
              paramAnonymousView.ToN = str6;
              paramAnonymousView = new z.a().bdz(this.VQK).a(paramAnonymousView).bdA("8").ThX;
              com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
              ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a(WalletOrderInfoNewUI.this.getContext(), paramAnonymousView, new y()
              {
                public final void onFinishAction(int paramAnonymous2Int, String paramAnonymous2String, com.tencent.mm.plugin.textstatus.proto.q paramAnonymous2q)
                {
                  AppMethodBeat.i(301295);
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onFinishAction result :%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "onFinishAction default");
                  case 0: 
                    do
                    {
                      AppMethodBeat.o(301295);
                      return;
                      Log.i("MicroMsg.WalletOrderInfoNewUI", "onFinishAction click ok");
                    } while ((paramAnonymous2q == null) || (paramAnonymous2q.action != 2));
                    if ((aw.isDarkMode()) && (!Util.isNullOrNil(WalletOrderInfoNewUI.9.this.VQL))) {
                      WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).w(WalletOrderInfoNewUI.9.this.VQL, WalletOrderInfoNewUI.9.this.VQM, WalletOrderInfoNewUI.9.this.VQM, -1);
                    }
                    for (;;)
                    {
                      paramAnonymous2String = paramAnonymous2q.Tpn.Okz;
                      WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this).setText(WalletOrderInfoNewUI.this.getString(a.i.wallet_order_info_leadtail_desc, new Object[] { paramAnonymous2String }));
                      WalletOrderInfoNewUI.r(WalletOrderInfoNewUI.this).setVisibility(8);
                      WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).setOnClickListener(null);
                      WalletOrderInfoNewUI.s(WalletOrderInfoNewUI.this).setBackground(null);
                      com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(3), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
                      AppMethodBeat.o(301295);
                      return;
                      WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this).w(WalletOrderInfoNewUI.9.this.VQN, WalletOrderInfoNewUI.9.this.VQM, WalletOrderInfoNewUI.9.this.VQM, -1);
                    }
                  case 1: 
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "onFinishAction click error");
                    com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(4), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
                    com.tencent.mm.ui.base.k.a(WalletOrderInfoNewUI.this.getContext(), WalletOrderInfoNewUI.this.getContext().getString(a.i.wallet_order_info_leadtail_error), "", WalletOrderInfoNewUI.this.getContext().getString(a.i.wallet_alert_btn_i_know), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(301305);
                        Log.i("MicroMsg.WalletOrderInfoNewUI", "click AlertDialog");
                        AppMethodBeat.o(301305);
                      }
                    });
                    AppMethodBeat.o(301295);
                    return;
                  }
                  Log.i("MicroMsg.WalletOrderInfoNewUI", "onFinishAction click cancel");
                  com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(2), WalletOrderInfoNewUI.o(WalletOrderInfoNewUI.this) });
                  AppMethodBeat.o(301295);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(301324);
            }
          });
          break label1091;
        }
        this.VQe.setVisibility(8);
        this.VQb.setOnClickListener(null);
        this.VQb.setBackground(null);
        break label1091;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
        break label1340;
        HO(true);
        this.OnD.setVisibility(8);
        break label1419;
        label3507:
        if (this.OnC.ajFF.ajFG == 1)
        {
          this.VQs = true;
          com.tencent.mm.plugin.report.service.h.OAn.b(17267, new Object[] { this.OqR, this.OnC.ajFF.ajFP, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
        }
        else
        {
          this.VQi.setVisibility(8);
          continue;
          this.VQi.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.OAn.b(17267, new Object[] { this.OqR, "", Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        }
      }
      label3643:
      continue;
      label3646:
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
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.VMl.VQZ)), Boolean.valueOf(this.VQt) });
      if (this.VQt)
      {
        AppMethodBeat.o(71028);
        return;
      }
      this.VQt = true;
      if (Util.isNullOrNil(this.VMl.VQZ))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ag(this.VMl.Vyi, this.VMl.VQV, this.VMl.VQW, this.VMl.VQX, this.VMl.hMy, this.VMl.Oks, this.VMl.VIF));
        AppMethodBeat.o(71028);
        return;
      }
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(this.VMl.VQZ, this.VMl.Vyi));
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
    ade.a locala;
    if (com.tencent.mm.compatible.util.d.rb(21))
    {
      if (com.tencent.mm.compatible.util.d.rb(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(a.c.BG_2));
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setContentViewVisibility(4);
      this.VPH = new HashSet();
      paramBundle = com.tencent.mm.wallet_core.a.cm(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.MyF = getInput().getString("key_trans_id");
      getInput().getInt("key_pay_type", -1);
      Log.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[] { this.MyF });
      this.VmL = ikP();
      if (this.VmL == null) {
        break label851;
      }
      setContentViewVisibility(0);
      c(this.VmL);
      Object localObject;
      if ((paramBundle != null) && (this.VmL != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = paramBundle.jOh();
        com.tencent.mm.plugin.wallet_core.utils.m.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) != 2) {
          break label799;
        }
        i = 2;
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        int k = this.mPayInfo.hUR;
        if (this.mPayInfo.hUR != 3) {
          break label804;
        }
        bool1 = true;
        if (!bool2) {
          break label810;
        }
        j = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).b(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ac.jOS()), Integer.valueOf((int)(this.VmL.hAW * 100.0D)), this.VmL.MEq, Integer.valueOf(i) });
      }
      if (((!u.iiC().ijf()) && (paramBundle != null) && (paramBundle.jOh())) || (!z.bBd())) {
        z.bBe();
      }
      if ((this.VmL == null) || (this.VmL.VGX == null) || (this.VmL.VGX.size() <= 0)) {
        break label815;
      }
      this.VPI = this.VmL.VGX;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[] { Integer.valueOf(this.VPI.size()) });
      this.MyF = ((Orders.Commodity)this.VPI.get(0)).hAU;
      this.OqR = ((Orders.Commodity)this.VPI.get(0)).hAU;
      if ((this.mPayInfo != null) && (paramBundle != null) && ((paramBundle.jOg()) || (paramBundle.jOh()))) {
        doSceneProgress(new ae(getPayReqKey(), 21));
      }
      ((com.tencent.mm.plugin.fingerprint.mgr.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.e.class)).l(this);
      initView();
      this.VMB = getProcess();
      ikz();
      if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 46))
      {
        Log.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
        paramBundle = new ade();
        localObject = new Intent();
        ((Intent)localObject).putExtras(getInput());
        if (this.VmL != null) {
          ((Intent)localObject).putExtra("key_total_fee", this.VmL.hAW);
        }
        if (this.VMB != null) {
          ((Intent)localObject).putExtra("key_is_clear_failure", this.VMB.hPH.getInt("key_is_clear_failure", -1));
        }
        paramBundle.ihj.intent = ((Intent)localObject);
        paramBundle.ihj.ihm = 1;
        paramBundle.ihj.hAT = getPayReqKey();
        locala = paramBundle.ihj;
        if (!((Intent)localObject).getBooleanExtra("intent_pay_end", false)) {
          break label887;
        }
      }
    }
    label799:
    label804:
    label810:
    label815:
    label851:
    label887:
    for (int i = -1;; i = 0)
    {
      locala.result = i;
      paramBundle.publish();
      if ((this.VmL == null) || (this.VmL.VHv == null) || (this.VmL.VHv.VIO != 1)) {
        break label892;
      }
      Log.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
      ikV();
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
      com.tencent.mm.ui.base.k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    label892:
    addSceneEndListener(1979);
    addSceneEndListener(2948);
    addSceneEndListener(2710);
    this.VQu.alive();
    this.MCd.alive();
    this.OnJ.alive();
    this.VMA = true;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label985;
      }
    }
    label985:
    for (paramBundle = "";; paramBundle = this.mPayInfo.hAT)
    {
      com.tencent.mm.wallet_core.model.ag.g(i, paramBundle, 16, "");
      AppMethodBeat.o(71016);
      return;
      i = this.mPayInfo.hUR;
      break;
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71029);
    Dialog localDialog = com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoNewUI.17(this));
    AppMethodBeat.o(71029);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71034);
    super.onDestroy();
    if (!this.OnI)
    {
      kg localkg = new kg();
      localkg.hLR.hLS = "ok";
      localkg.publish();
    }
    Log.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
    if ((this.OnC != null) && (this.OnC.ajFF != null)) {
      new com.tencent.mm.plugin.wallet_core.c.b(this.OnC.ajFF.Zjn, this.OnC.ajFF.ajFG, this.VQr).bFJ().h(new com.tencent.mm.vending.c.a() {});
    }
    this.VQu.dead();
    this.MCd.dead();
    removeSceneEndListener(1979);
    removeSceneEndListener(2948);
    removeSceneEndListener(2710);
    this.OnJ.dead();
    if (WalletSuccPageAwardWidget.a(this.OnC)) {
      this.OnD.onDestroy();
    }
    if (this.VQv != null) {
      this.VQv.cancel();
    }
    if (this.VQw != null) {
      this.VQw.cancel();
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
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[] { Boolean.valueOf(this.VMA), this.VPL, Boolean.valueOf(this.VMy), Boolean.valueOf(this.VMz), this.VPJ, this.OnC });
    if (WalletSuccPageAwardWidget.a(this.OnC))
    {
      this.OnD.onResume();
      AppMethodBeat.o(71017);
      return;
    }
    if (this.VMA)
    {
      this.VMA = false;
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.VPL != null) && (this.VMz))
    {
      Log.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.VPL.akjw)), this.VPL.akjw, Boolean.valueOf(this.VQt) });
      if (this.VQt)
      {
        AppMethodBeat.o(71017);
        return;
      }
      this.VQt = true;
      if (Util.isNullOrNil(this.VPL.akjw))
      {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ag(this.VPL.ehe, this.VPL.akjq, this.VPL.VGw, this.VPL.VGx, getPayReqKey(), this.OqR, this.VPL.VGy));
        AppMethodBeat.o(71017);
        return;
      }
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(this.VPL.akjw, this.VPL.ehe));
      AppMethodBeat.o(71017);
      return;
    }
    if ((this.VMy) && (this.VPJ != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ag(this.VPJ.VIA, this.VPJ.VIC, this.VPJ.VID, this.VPJ.VIE, getPayReqKey(), this.OqR, this.VPJ.VIF));
    }
    AppMethodBeat.o(71017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71036);
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp });
    if ((WalletSuccPageAwardWidget.a(this.OnC)) && (this.OnD.onSceneEnd(paramInt1, paramInt2, paramString, paramp)))
    {
      AppMethodBeat.o(71036);
      return true;
    }
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.ag)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ag)paramp;
        paramp = new a(paramString.rwB);
        if (this.VMl != null)
        {
          this.VMm.put(paramString.Vyi, paramp);
          HO(false);
          iky();
        }
      }
      else
      {
        this.VQt = false;
      }
    }
    label280:
    do
    {
      AppMethodBeat.o(71036);
      return false;
      if (!this.VMy) {
        break;
      }
      this.VMm.put(paramString.Vyi, paramp);
      HO(false);
      iky();
      break;
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.q))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.q)paramp;
          paramp = paramString.VxQ;
          if (paramp.wuz == 0)
          {
            paramp = new a(paramp);
            if (this.VMl == null) {
              break label280;
            }
            this.VMm.put(paramString.rBJ, paramp);
            HO(false);
            iky();
          }
        }
        for (;;)
        {
          this.VQt = false;
          break;
          if (this.VMy)
          {
            this.VMm.put(paramString.rBJ, paramp);
            HO(false);
            iky();
          }
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.t))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.t)paramp;
          paramp = paramString.VxR;
          if ((this.VPL != null) && (this.VPL.ehe == paramString.VxU.ehe))
          {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.VPL });
            this.VMp = paramp;
            Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramString.VxU.VGz });
            HO(false);
            iky();
            if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramp))) {
              this.VMx.setText(paramString.resultMsg);
            }
          }
          if ((!"-1".equals(paramp)) && (!"0".equals(paramp)) && (!Util.isNullOrNil(paramString.VxS))) {
            com.tencent.mm.ui.base.k.c(this, paramString.VxS, "", true);
          }
          while (!"0".equals(paramp))
          {
            AppMethodBeat.o(71036);
            return true;
          }
          if (!Util.isNullOrNil(paramString.VxS)) {}
          for (paramString = paramString.VxS;; paramString = getString(a.i.wallet_pay_award_got))
          {
            Toast.makeText(this, paramString, 0).show();
            break;
          }
        }
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71036);
        return true;
      }
    } while (!(paramp instanceof com.tencent.mm.plugin.wallet_core.c.n));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.n)paramp;
      paramp = paramString.VxK;
      String str;
      if (paramp.wuz == 0)
      {
        str = paramp.aaoD;
        if ((this.VPL != null) && (this.VPL.ehe == paramString.ehe))
        {
          Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[] { this.VPL });
          this.VMp = str;
          Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[] { paramp.aaoF });
          HO(false);
          iky();
          if ((!Util.isNullOrNil(paramp.aaoF)) && (!"3".equals(str))) {
            this.VMx.setText(paramp.aaoF);
          }
        }
        if (("-1".equals(str)) || ("0".equals(str)) || (Util.isNullOrNil(paramp.aaoE))) {
          break label834;
        }
        com.tencent.mm.ui.base.k.c(this, paramp.aaoE, "", true);
      }
      label834:
      while (!"0".equals(str))
      {
        AppMethodBeat.o(71036);
        return true;
      }
      if (!Util.isNullOrNil(paramp.aaoE)) {}
      for (paramString = paramp.aaoE;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
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
    public String VGB;
    public String VGC;
    public String VGD;
    public String VQT;
    public int VQU;
    public String VcU;
    public String VcV;
    public String VsI;
    public String icon;
    public String title;
    public String url;
    public String wording;
    
    public a(ekf paramekf)
    {
      AppMethodBeat.i(71012);
      if ((paramekf != null) && (paramekf.abpp != null))
      {
        paramekf = paramekf.abpp;
        this.url = paramekf.url;
        this.wording = paramekf.wording;
        this.icon = paramekf.icon;
        this.VQT = paramekf.VQT;
        this.title = paramekf.title;
        this.VcU = paramekf.VcU;
        this.VcV = paramekf.VcV;
        this.VQU = paramekf.VQU;
        this.VsI = this.title;
        this.VGB = this.icon;
        this.VGC = this.wording;
        this.VGD = this.VQT;
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
        this.wording = paramJSONObject.optString("wording");
        this.icon = paramJSONObject.optString("icon");
        this.VQT = paramJSONObject.optString("btn_text");
        this.title = paramJSONObject.optString("title");
        this.VsI = paramJSONObject.optString("tinyapp_name");
        this.VGB = paramJSONObject.optString("tinyapp_logo");
        this.VGC = paramJSONObject.optString("tinyapp_desc");
        this.VcU = paramJSONObject.optString("tinyapp_username");
        this.VcV = paramJSONObject.optString("tinyapp_path");
        this.VGD = paramJSONObject.optString("activity_tinyapp_btn_text");
      }
      AppMethodBeat.o(71011);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71013);
      String str = this.url + " , " + this.wording + " , " + this.icon + " , " + this.VQT + " , " + this.title;
      AppMethodBeat.o(71013);
      return str;
    }
  }
  
  static final class b
  {
    public String Oks;
    public long VIF;
    public String VQV;
    public String VQW;
    public String VQX;
    public long VQY;
    public String VQZ;
    public String Vyi;
    public String hMy;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
    {
      this.Vyi = paramString1;
      this.VQV = paramString2;
      this.VQW = paramString3;
      this.VQX = paramString4;
      this.hMy = paramString5;
      this.Oks = paramString6;
      this.VIF = paramLong1;
      this.VQY = paramLong2;
      this.VQZ = null;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.Vyi = paramString1;
      this.VQV = paramString2;
      this.VQW = paramString3;
      this.VQX = paramString4;
      this.hMy = paramString5;
      this.Oks = paramString6;
      this.VIF = paramLong;
      this.VQZ = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */