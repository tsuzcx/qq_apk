package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget
  extends FrameLayout
{
  private WalletBaseUI AuA;
  private boolean AuB;
  private boolean AuC;
  private boolean AuD;
  private e.a.a.a AuE;
  private boolean AuF;
  private ImageView Auv;
  private ImageView Auw;
  private WalletScratchShakeView Aux;
  private WalletAwardShakeAnimView Auy;
  private e.a.a.i Auz;
  private TextView ftj;
  private ap gAC;
  private TextView lEA;
  private Button mWp;
  private CdnImageView nGe;
  private String nSY;
  private ViewGroup tpf;
  private e.a.a.c vEk;
  private boolean vVB;
  private boolean zWf;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.AuB = false;
    this.AuC = false;
    this.vVB = true;
    this.AuD = false;
    this.AuE = null;
    this.gAC = new ap(Looper.getMainLooper());
    this.AuF = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.AuB = false;
    this.AuC = false;
    this.vVB = true;
    this.AuD = false;
    this.AuE = null;
    this.gAC = new ap(Looper.getMainLooper());
    this.AuF = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.Dem != null) && (paramc.Dem.size() > 0)) || (paramc.Khb != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private String auA(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!bt.T(new String[0]))
    {
      com.tencent.mm.vfs.i.aMF(getAccImagesPath());
      String str = getAccImagesPath() + d.getMessageDigest(paramString.getBytes());
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
      AppMethodBeat.o(71583);
      return str;
    }
    AppMethodBeat.o(71583);
    return null;
  }
  
  private static String b(e.a.a.c paramc)
  {
    AppMethodBeat.i(71588);
    if (paramc != null)
    {
      JSONObject localJSONObject1;
      Object localObject2;
      try
      {
        localJSONObject1 = new JSONObject();
        localObject1 = new JSONArray();
        if ((paramc.Dem != null) && (paramc.Dem.size() > 0))
        {
          localObject2 = paramc.Dem.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            e.a.a.i locali = (e.a.a.i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.uwS);
            localJSONObject2.put("award_name", locali.KhA);
            localJSONObject2.put("award_description", locali.KhB);
            localJSONObject2.put("background_img", locali.KhC);
            localJSONObject2.put("award_name_color", locali.KhD);
            localJSONObject2.put("award_description_color", locali.KhE);
            ((JSONArray)localObject1).put(localJSONObject2);
          }
        }
        localJSONObject1.put("single_exposure_info_list", localObject1);
      }
      catch (Exception paramc)
      {
        AppMethodBeat.o(71588);
        return "";
      }
      localJSONObject1.put("is_query_others", paramc.KgW);
      localJSONObject1.put("draw_lottery_params", paramc.DcQ);
      localJSONObject1.put("is_show_btn", paramc.Den);
      Object localObject1 = new JSONObject();
      if (paramc.Deo != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.Deo.KgO);
        ((JSONObject)localObject1).put("btn_color", paramc.Deo.KgP);
        ((JSONObject)localObject1).put("btn_op_type", paramc.Deo.KgQ);
        ((JSONObject)localObject1).put("url", paramc.Deo.url);
        localObject2 = new JSONObject();
        if (paramc.Deo.KgR != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Deo.KgR.DVJ);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Deo.KgR.DVK);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Deo.KgR.DVL);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.Deo.Dvu);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.Del);
      localJSONObject1.put("user_opertaion_type", paramc.KgX);
      localJSONObject1.put("is_show_layer", paramc.KgY);
      localJSONObject1.put("background_img_whole", paramc.Kha);
      if (paramc.Khb != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.Khb.KgS);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.Khb.KgT);
        ((JSONObject)localObject1).put("url", paramc.Khb.url);
        ((JSONObject)localObject1).put("op_type", paramc.Khb.Exg);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.Khb.KgU);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.Khb.KgV);
        localObject2 = new JSONObject();
        if (paramc.Khb.KgR != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Khb.KgR.DVJ);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Khb.KgR.DVK);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Khb.KgR.DVL);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        localJSONObject1.put("draw_lottery_info", localObject1);
      }
      paramc = localJSONObject1.toString();
      AppMethodBeat.o(71588);
      return paramc;
    }
    AppMethodBeat.o(71588);
    return "";
  }
  
  private void efj()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.vEk), Boolean.valueOf(this.vVB) });
    if (this.vEk == null)
    {
      ad.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    ad.m("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.vEk.KgX), Integer.valueOf(this.vEk.Dem.size()), Boolean.valueOf(this.AuB) });
    if ((this.vEk.KgX <= 0) || (this.vEk.KgX > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.vEk))
    {
      AppMethodBeat.o(71574);
      return;
    }
    h localh;
    if (this.vEk.KgX == 4)
    {
      efn();
      if ((this.vVB) || (this.AuB))
      {
        localh = h.vKh;
        if (!this.AuB) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.f(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.vVB = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.vEk.KgX == 1) || (this.vEk.KgX == 2) || (this.vEk.KgX == 3))
      {
        efm();
        break;
      }
      if (this.vEk.KgX != 5) {
        break;
      }
      efo();
      break;
      label293:
      i = 1;
    }
  }
  
  private void efk()
  {
    AppMethodBeat.i(71575);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.ftj.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.lEA.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.ftj.setLayoutParams(localLayoutParams1);
    this.lEA.setLayoutParams(localLayoutParams2);
    this.ftj.setVisibility(0);
    this.lEA.setVisibility(8);
    this.ftj.setText(2131765881);
    this.ftj.setTextColor(getResources().getColor(2131100711));
    this.lEA.setTextColor(getResources().getColor(2131100490));
    this.Auv.setVisibility(8);
    findViewById(2131303060).setVisibility(0);
    findViewById(2131303061).setVisibility(0);
    this.mWp.setVisibility(8);
    this.nGe.setVisibility(0);
    this.nGe.setImageResource(2131234696);
    this.Aux.setVisibility(8);
    this.Aux.onDestroy();
    this.Auy.setVisibility(8);
    this.Auy.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void efl()
  {
    AppMethodBeat.i(71579);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.vEk.Khb != null) && (this.vEk.Khb.Exg != 1))
    {
      this.Aux.setVisibility(8);
      this.Aux.onDestroy();
      this.Auy.setVisibility(8);
      this.Auy.destroy();
    }
    efq();
    AppMethodBeat.o(71579);
  }
  
  private void efm()
  {
    AppMethodBeat.i(71580);
    efp();
    if (this.Auy.getVisibility() != 8)
    {
      this.Auy.setVisibility(8);
      this.Auy.destroy();
    }
    if (this.Aux.getVisibility() != 0)
    {
      this.Aux.setVisibility(0);
      this.Aux.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71552);
          if (WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this).getHeight() != WalletSuccPageAwardWidget.this.getHeight())
          {
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this).getLayoutParams();
            localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
            localLayoutParams.height = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight();
            WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
          }
          WalletSuccPageAwardWidget.c(WalletSuccPageAwardWidget.this);
          AppMethodBeat.o(71552);
        }
      });
    }
    AppMethodBeat.o(71580);
  }
  
  private void efn()
  {
    AppMethodBeat.i(71581);
    efp();
    if (this.Aux.getVisibility() != 8)
    {
      this.Aux.setVisibility(8);
      this.Aux.onDestroy();
    }
    if (this.Auy.getVisibility() != 8)
    {
      this.Auy.setVisibility(8);
      this.Auy.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void efo()
  {
    AppMethodBeat.i(71582);
    efp();
    if (this.Aux.getVisibility() != 8)
    {
      this.Aux.setVisibility(8);
      this.Aux.onDestroy();
    }
    if (this.vEk.Khb != null)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.vEk.Khb.Exg) });
      switch (this.vEk.Khb.Exg)
      {
      default: 
        this.Auy.setVisibility(8);
        this.Auy.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.Auy.getVisibility() != 0)
        {
          this.Auy.setVisibility(0);
          this.Auy.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71556);
              if (WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getHeight() != WalletSuccPageAwardWidget.this.getHeight())
              {
                FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getLayoutParams();
                localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
                localLayoutParams.height = (WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight() - com.tencent.mm.cd.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2));
                localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
              }
              AppMethodBeat.o(71556);
            }
          });
        }
        this.Auy.destroy();
        if (!bt.isNullOrNil(this.vEk.Khb.KgS))
        {
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.vEk.Khb.KgS });
          this.Auy.setShakeHintWording(this.vEk.Khb.KgS);
        }
        if (!bt.isNullOrNil(this.vEk.Khb.KgT)) {}
        try
        {
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.vEk.Khb.KgT });
          this.Auy.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vEk.Khb.KgT, true));
          if (!bt.isNullOrNil(this.vEk.Khb.KgU))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.vEk.Khb.KgU });
            this.Auy.setAfterHintWording(this.vEk.Khb.KgU);
          }
          if (!bt.isNullOrNil(this.vEk.Khb.KgV)) {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.vEk.Khb.KgV });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.Auy.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vEk.Khb.KgV, true));
            this.Auy.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void sQ(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.vKh;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localh.f(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(2131765882));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(2131100212));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71557);
                    return;
                  }
                }
                h localh = h.vKh;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.f(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.Auy.eeZ();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.vEk.Khb.KgT, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.vEk.Khb.KgV, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.vEk.Khb.KgR;
        if (localg == null) {
          break label831;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.DVJ, localg.DVK, Integer.valueOf(localg.DVL) });
        uj localuj = new uj();
        localuj.dzH.userName = localg.DVJ;
        localuj.dzH.dzJ = bt.by(localg.DVK, "");
        localuj.dzH.scene = 1060;
        localuj.dzH.dbt = this.nSY;
        localuj.dzH.dzK = 0;
        if (localg.DVL > 0) {
          localuj.dzH.aAS = localg.DVL;
        }
        localuj.dzH.context = this.AuA;
        com.tencent.mm.sdk.b.a.ESL.l(localuj);
        this.AuB = true;
        this.AuF = false;
        this.gAC.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71558);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71558);
          }
        }, 3000L);
        AppMethodBeat.o(71582);
        return;
      case 3: 
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.vEk.Khb.url });
        e.p(this.AuA, this.vEk.Khb.url, false);
        this.AuB = true;
        this.AuF = false;
        this.gAC.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71559);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71559);
          }
        }, 3000L);
        AppMethodBeat.o(71582);
        return;
      }
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.Aux.setVisibility(8);
      this.Aux.onDestroy();
    }
    this.Auy.setVisibility(8);
    this.Auy.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void efp()
  {
    AppMethodBeat.i(71584);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.vEk.Dem;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.Auz = ((e.a.a.i)((List)localObject1).get(0));
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.Auz.KhA, this.Auz.KhB, this.Auz.uwS });
        this.nGe.setUrl(this.Auz.uwS);
        if (!bt.isNullOrNil(this.Auz.uwS)) {
          this.nGe.setVisibility(0);
        }
        if (bt.isNullOrNil(this.Auz.KhA)) {
          break label1228;
        }
        this.ftj.setText(this.Auz.KhA);
        this.ftj.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bt.isNullOrNil(this.Auz.KhD)) {
          this.ftj.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.Auz.KhD, true));
        }
        i = 1;
        if (!bt.isNullOrNil(this.Auz.KhB))
        {
          this.lEA.setText(this.Auz.KhB);
          this.lEA.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bt.isNullOrNil(this.Auz.KhE)) {
            this.lEA.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.Auz.KhE, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.ftj.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.lEA.getLayoutParams();
            if ((!bt.isNullOrNil(this.Auz.KhA)) && (bt.isNullOrNil(this.Auz.KhB)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.ftj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.lEA.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.ftj.setVisibility(0);
              this.lEA.setVisibility(8);
            }
          }
          else
          {
            if (bt.isNullOrNil(this.Auz.KhC)) {
              continue;
            }
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.Auz.KhC });
            localObject1 = new c.a();
            ((c.a)localObject1).hjU = true;
            ((c.a)localObject1).hjT = true;
            ((c.a)localObject1).gjt = auA(this.Auz.KhC);
            localObject1 = ((c.a)localObject1).azc();
            com.tencent.mm.aw.o.ayJ().a(this.Auz.KhC, null, (com.tencent.mm.aw.a.a.c)localObject1, new k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!bt.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).KhC)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).KhC.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.ao(paramAnonymousBitmap), "widget_bg");
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.AuH);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setVisibility(0);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).post(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(71560);
                          ViewGroup.LayoutParams localLayoutParams = WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).getLayoutParams();
                          localLayoutParams.height = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight();
                          localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
                          WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
                          WalletSuccPageAwardWidget.this.findViewById(2131303060).setVisibility(8);
                          WalletSuccPageAwardWidget.this.findViewById(2131303061).setVisibility(8);
                          AppMethodBeat.o(71560);
                        }
                      });
                      AppMethodBeat.o(71561);
                    }
                  });
                }
                AppMethodBeat.o(71562);
              }
            });
            i = this.vEk.Den;
            localObject3 = this.vEk.Deo;
            if (this.vEk.Deo == null) {
              continue;
            }
            localObject1 = this.vEk.Deo.KgO;
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.vEk.Den != 0) && (this.vEk.Deo != null) && (!bt.isNullOrNil(this.vEk.Deo.KgO))) {
              continue;
            }
            this.mWp.setVisibility(8);
            if (this.ftj.getVisibility() == 0)
            {
              this.ftj.setSingleLine();
              this.ftj.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71566);
                  try
                  {
                    if ((WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() > 0) && (WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() > 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() >= WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) && (!bt.ai(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText())))
                    {
                      float f = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getTextSize();
                      ad.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) });
                      Object localObject = new Paint();
                      ((Paint)localObject).setTextSize(f);
                      String str2 = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText().toString();
                      f = WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() - WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getLeft();
                      int i = 1;
                      while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                        i += 1;
                      }
                      ad.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
                      String str1 = str2.substring(0, str2.length() - i - 1);
                      localObject = str1;
                      if (str2.length() > 9)
                      {
                        localObject = str1;
                        if (str1.length() < 9) {
                          localObject = str2.substring(0, 9);
                        }
                      }
                      WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).setText((CharSequence)localObject);
                      WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).append("...");
                    }
                    AppMethodBeat.o(71566);
                    return;
                  }
                  catch (Exception localException)
                  {
                    ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
                    AppMethodBeat.o(71566);
                  }
                }
              });
            }
            if (this.mWp.getVisibility() != 0) {
              this.ftj.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.vEk.KgY != 0) {
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.vEk.KgY) });
            }
            if (!bt.isNullOrNil(this.vEk.Kha))
            {
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.vEk.Kha });
              if (this.Auw != null)
              {
                this.Auw.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).hjU = true;
                ((c.a)localObject1).hjT = true;
                ((c.a)localObject1).gjt = auA(this.vEk.Kha);
                localObject1 = ((c.a)localObject1).azc();
                com.tencent.mm.aw.o.ayJ().a(this.vEk.Kha, null, (com.tencent.mm.aw.a.a.c)localObject1, new k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    ad.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!bt.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Kha)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Kha.equals(paramAnonymousString))) {
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(71567);
                          WalletSuccPageAwardWidget.u(WalletSuccPageAwardWidget.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                          WalletSuccPageAwardWidget.u(WalletSuccPageAwardWidget.this).setImageBitmap(paramAnonymousBitmap);
                          AppMethodBeat.o(71567);
                        }
                      });
                    }
                    AppMethodBeat.o(71568);
                  }
                });
              }
            }
            AppMethodBeat.o(71584);
            return;
            i = 0;
            break;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((bt.isNullOrNil(this.Auz.KhA)) && (!bt.isNullOrNil(this.Auz.KhB)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.ftj.setLayoutParams(localException2);
            this.lEA.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.ftj.setVisibility(8);
            this.lEA.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.ftj.setLayoutParams(localException2);
          this.lEA.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.ftj.setVisibility(0);
          this.lEA.setVisibility(0);
          continue;
          this.Auv.setVisibility(8);
          findViewById(2131303060).setVisibility(0);
          findViewById(2131303061).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.vEk.Deo;
          if (localObject2 == null) {
            continue;
          }
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).KgO, Integer.valueOf(((e.a.a.a)localObject2).KgQ), ((e.a.a.a)localObject2).KgP, ((e.a.a.a)localObject2).url });
          this.mWp.setText(((e.a.a.a)localObject2).KgO);
          if (!bt.isNullOrNil(((e.a.a.a)localObject2).KgP))
          {
            localObject3 = getContext().getResources().getDrawable(2131231365);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.bW(((e.a.a.a)localObject2).KgP, false), PorterDuff.Mode.SRC);
            this.mWp.setBackground((Drawable)localObject3);
          }
          this.mWp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              int i = 2;
              AppMethodBeat.i(71565);
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Deo != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Deo);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ != 1) {
                  break label241;
                }
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                e.p(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
                WalletSuccPageAwardWidget.m(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.o(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.p(WalletSuccPageAwardWidget.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(71563);
                    WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71563);
                  }
                }, 3000L);
                paramAnonymousView = h.vKh;
                if (!WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {
                  break label705;
                }
              }
              for (;;)
              {
                paramAnonymousView.f(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
                AppMethodBeat.o(71565);
                return;
                label241:
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgR;
                  if (paramAnonymousView != null)
                  {
                    ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.DVJ, paramAnonymousView.DVK, Integer.valueOf(paramAnonymousView.DVL) });
                    uj localuj = new uj();
                    localuj.dzH.userName = paramAnonymousView.DVJ;
                    localuj.dzH.dzJ = bt.by(paramAnonymousView.DVK, "");
                    localuj.dzH.scene = 1060;
                    localuj.dzH.dbt = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    localuj.dzH.dzK = 0;
                    if (paramAnonymousView.DVL > 0) {
                      localuj.dzH.aAS = paramAnonymousView.DVL;
                    }
                    localuj.dzH.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    com.tencent.mm.sdk.b.a.ESL.l(localuj);
                    WalletSuccPageAwardWidget.m(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.o(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.p(WalletSuccPageAwardWidget.this).postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(71564);
                        WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                        AppMethodBeat.o(71564);
                      }
                    }, 3000L);
                  }
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 3)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 5)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 6)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 7)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).KgQ != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
                label705:
                i = 1;
              }
            }
          });
          this.mWp.setVisibility(0);
          if ((!this.vVB) && (!this.AuB)) {
            continue;
          }
          localObject2 = h.vKh;
          if (!this.AuB) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((h)localObject2).f(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1228:
      i = 0;
    }
  }
  
  private void efq()
  {
    AppMethodBeat.i(71585);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.AuB) });
    if (this.AuB)
    {
      com.tencent.mm.plugin.wallet_core.c.o localo = new com.tencent.mm.plugin.wallet_core.c.o(this.vEk.Del, this.zWf);
      this.AuA.doSceneProgress(localo, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.aih() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    y.js(paramContext).inflate(2131496031, this, true);
    this.tpf = ((ViewGroup)findViewById(2131298761));
    this.nGe = ((CdnImageView)findViewById(2131301587));
    this.ftj = ((TextView)findViewById(2131302666));
    this.lEA = ((TextView)findViewById(2131299008));
    this.mWp = ((Button)findViewById(2131297631));
    this.Aux = ((WalletScratchShakeView)findViewById(2131304365));
    this.Auv = ((ImageView)findViewById(2131297029));
    this.Auy = ((WalletAwardShakeAnimView)findViewById(2131304736));
    this.nGe.setRoundCorner(true);
    this.nGe.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.KgZ == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.AuB), Boolean.valueOf(paramBoolean) });
      this.AuA = paramWalletBaseUI;
      this.vEk = paramc;
      this.zWf = paramBoolean;
      this.nSY = paramString;
      this.Auw = paramImageView;
      efj();
      AppMethodBeat.o(71573);
      return;
      bool1 = false;
      break;
      label129:
      bool2 = false;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(71587);
    if ((this.Aux != null) && (this.Aux.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.Aux != null)
      {
        localWalletScratchShakeView = this.Aux;
        if (localWalletScratchShakeView.AtV == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.AtV.X(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.Aux;
        if (localWalletScratchShakeView.AtV == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.AtV.Aup;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.Aux.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.tpf == null) || (bool2)) {
          break label141;
        }
        bool1 = this.tpf.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(71587);
        return bool1;
        bool1 = false;
        break;
      }
    }
    label141:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(71587);
    return bool1;
  }
  
  public final void init()
  {
    AppMethodBeat.i(71576);
    if (this.AuA != null)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.AuA.addSceneEndListener(1859);
      this.AuA.addSceneEndListener(2547);
      this.AuA.addSceneEndListener(2803);
      this.AuA.addSceneEndListener(2508);
      this.AuA.addSceneEndListener(2529);
      this.AuA.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.AuA != null)
    {
      this.AuA.removeSceneEndListener(1859);
      this.AuA.removeSceneEndListener(2547);
      this.AuA.removeSceneEndListener(2803);
      this.AuA.removeSceneEndListener(2508);
      this.AuA.removeSceneEndListener(2529);
      this.AuA.removeSceneEndListener(2888);
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.AuC), Boolean.valueOf(this.AuD) });
      if ((!this.AuC) && (!this.AuD))
      {
        localObject = h.vKh;
        if (!this.AuB) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).f(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new l(this.vEk.DcQ, 4, this.zWf);
      this.AuA.doSceneProgress((com.tencent.mm.al.n)localObject, false);
      if (this.Aux != null) {
        this.Aux.onDestroy();
      }
      if (this.Auy != null) {
        this.Auy.destroy();
      }
      AppMethodBeat.o(71577);
      return;
      label230:
      i = 1;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71578);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.AuB), b(this.vEk), Boolean.valueOf(this.AuF) });
    if (!this.AuF)
    {
      this.AuF = true;
      efl();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.n))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.zWk;
        if (paramString == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.ntx), paramString.nty, paramString.DqX, paramString.AgD });
        if (paramString.ntx == 0)
        {
          if (!bt.isNullOrNil(paramString.DqX))
          {
            Toast.makeText(getContext(), paramString.DqX, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.AgD != null)
          {
            if (this.vEk.Deo != null)
            {
              paramInt1 = this.vEk.Deo.KgQ;
              this.vEk = paramString.AgD;
              if ((paramString.AgD.Deo != null) && (this.vEk.Deo != null))
              {
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.AgD.Deo.KgQ) });
                if (paramString.AgD.Deo.KgQ == 4)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.vEk.Deo.KgQ = paramInt1;
                }
              }
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              efj();
            }
          }
          else
          {
            if ((this.AuE != null) && (this.AuD))
            {
              if (this.AuE.KgQ != 8) {
                break label375;
              }
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              e.p(this.AuA, this.AuE.url, false);
              this.AuB = true;
            }
            label357:
            this.AuE = null;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71586);
        return true;
        paramInt1 = 0;
        break;
        label375:
        if (this.AuE.KgQ != 9) {
          break label357;
        }
        paramString = this.AuE.KgR;
        if (paramString == null) {
          break label357;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.DVJ, paramString.DVK, Integer.valueOf(paramString.DVL) });
        paramn = new uj();
        paramn.dzH.userName = paramString.DVJ;
        paramn.dzH.dzJ = bt.by(paramString.DVK, "");
        paramn.dzH.scene = 1060;
        paramn.dzH.dbt = this.nSY;
        paramn.dzH.dzK = 0;
        if (paramString.DVL > 0) {
          paramn.dzH.aAS = paramString.DVL;
        }
        paramn.dzH.context = this.AuA;
        com.tencent.mm.sdk.b.a.ESL.l(paramn);
        this.AuB = true;
        this.AuF = false;
        this.gAC.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71555);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71555);
          }
        }, 3000L);
        break label357;
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        efk();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.o))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.zWm;
        if (paramString == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.ntx;
        paramn = paramString.nty;
        localObject1 = paramString.Dem;
        i = paramString.Den;
        localObject2 = paramString.Deo;
        if (paramString.Deo == null) {
          break label881;
        }
        paramInt1 = paramString.Deo.KgQ;
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramn, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.ntx == 0)
        {
          this.vEk.Dem = paramString.Dem;
          this.vEk.Den = paramString.Den;
          if (this.vEk.Deo == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.vEk.Deo.KgQ;; paramInt1 = 0)
      {
        if (paramString.Deo != null)
        {
          this.vEk.Deo = paramString.Deo;
          if ((this.vEk.Deo != null) && (paramString.Deo.KgQ == 4))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.vEk.Deo.KgQ = paramInt1;
          }
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.vEk) });
        efp();
        this.AuB = false;
        AppMethodBeat.o(71586);
        return true;
        paramInt1 = 0;
        break;
      }
    }
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = paramString.zWe;
        if (paramn == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramn.ntx;
        localObject1 = paramn.nty;
        localObject2 = paramn.AgD;
        if (paramn.AgD != null)
        {
          paramString = paramn.AgD.Dem;
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramn.AgD == null) || (paramn.AgD.Dem == null) || (paramn.AgD.Dem.size() <= 0)) {
            break label1222;
          }
          paramString = paramn.AgD;
          localObject1 = paramn.AgD.Deo;
          if (paramn.AgD.Deo == null) {
            break label1217;
          }
          paramInt1 = paramn.AgD.Deo.KgQ;
          label1082:
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.vEk.Deo != null) {
            paramInt1 = this.vEk.Deo.KgQ;
          }
          this.vEk = paramn.AgD;
          if ((this.vEk.Deo != null) && (paramn.AgD.Deo != null) && (paramn.AgD.Deo.KgQ == 4))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.vEk.Deo.KgQ = paramInt1;
          }
          efj();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71586);
        return true;
        paramString = "";
        break;
        label1217:
        paramInt1 = 0;
        break label1082;
        label1222:
        efk();
        continue;
        efk();
      }
    }
    AppMethodBeat.o(71586);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget
 * JD-Core Version:    0.7.0.1
 */