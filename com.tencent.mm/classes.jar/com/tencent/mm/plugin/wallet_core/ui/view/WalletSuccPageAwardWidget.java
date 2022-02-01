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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.vfs.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.xweb.util.d;
import e.a.a.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget
  extends FrameLayout
{
  private ViewGroup EMs;
  private boolean ITE;
  private e.a.a.c Iqj;
  private boolean OHV;
  private ImageView Pgp;
  private ImageView Pgq;
  private WalletScratchShakeView Pgr;
  private WalletAwardShakeAnimView Pgs;
  private i Pgt;
  private WalletBaseUI Pgu;
  private boolean Pgv;
  private boolean Pgw;
  private boolean Pgx;
  private e.a.a.a Pgy;
  private boolean Pgz;
  private TextView jbF;
  private TextView kEs;
  private MMHandler knk;
  private CdnImageView tCM;
  private String tUC;
  private Button xQQ;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.Pgv = false;
    this.Pgw = false;
    this.ITE = true;
    this.Pgx = false;
    this.Pgy = null;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.Pgz = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.Pgv = false;
    this.Pgw = false;
    this.ITE = true;
    this.Pgx = false;
    this.Pgy = null;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.Pgz = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.SvK != null) && (paramc.SvK.size() > 0)) || (paramc.abEB != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
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
        if ((paramc.SvK != null) && (paramc.SvK.size() > 0))
        {
          localObject2 = paramc.SvK.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i locali = (i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.GUf);
            localJSONObject2.put("award_name", locali.abEZ);
            localJSONObject2.put("award_description", locali.abFa);
            localJSONObject2.put("background_img", locali.abFb);
            localJSONObject2.put("award_name_color", locali.abFc);
            localJSONObject2.put("award_description_color", locali.abFd);
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
      localJSONObject1.put("is_query_others", paramc.abEw);
      localJSONObject1.put("draw_lottery_params", paramc.Std);
      localJSONObject1.put("is_show_btn", paramc.SvL);
      Object localObject1 = new JSONObject();
      if (paramc.SvM != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.SvM.abEo);
        ((JSONObject)localObject1).put("btn_color", paramc.SvM.abEp);
        ((JSONObject)localObject1).put("btn_op_type", paramc.SvM.abEq);
        ((JSONObject)localObject1).put("url", paramc.SvM.url);
        localObject2 = new JSONObject();
        if (paramc.SvM.abEr != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.SvM.abEr.TQP);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.SvM.abEr.TQQ);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.SvM.abEr.TQR);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.SvM.Thl);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.SvJ);
      localJSONObject1.put("user_opertaion_type", paramc.abEx);
      localJSONObject1.put("is_show_layer", paramc.abEy);
      localJSONObject1.put("background_img_whole", paramc.abEA);
      if (paramc.abEB != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.abEB.abEs);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.abEB.abEt);
        ((JSONObject)localObject1).put("url", paramc.abEB.url);
        ((JSONObject)localObject1).put("op_type", paramc.abEB.SLl);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.abEB.abEu);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.abEB.abEv);
        localObject2 = new JSONObject();
        if (paramc.abEB.abEr != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.abEB.abEr.TQP);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.abEB.abEr.TQQ);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.abEB.abEr.TQR);
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
  
  private String bhG(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!Util.isNullOrNil(new String[0]))
    {
      u.bBD(getAccImagesPath());
      String str = getAccImagesPath() + d.getMessageDigest(paramString.getBytes());
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
      AppMethodBeat.o(71583);
      return str;
    }
    AppMethodBeat.o(71583);
    return null;
  }
  
  private void gMF()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.Iqj), Boolean.valueOf(this.ITE) });
    if (this.Iqj == null)
    {
      Log.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    Log.printInfoStack("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.Iqj.abEx), Integer.valueOf(this.Iqj.SvK.size()), Boolean.valueOf(this.Pgv) });
    if ((this.Iqj.abEx <= 0) || (this.Iqj.abEx > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.Iqj))
    {
      AppMethodBeat.o(71574);
      return;
    }
    h localh;
    if (this.Iqj.abEx == 4)
    {
      gMJ();
      if ((this.ITE) || (this.Pgv))
      {
        localh = h.IzE;
        if (!this.Pgv) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.a(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.ITE = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.Iqj.abEx == 1) || (this.Iqj.abEx == 2) || (this.Iqj.abEx == 3))
      {
        gMI();
        break;
      }
      if (this.Iqj.abEx != 5) {
        break;
      }
      gMK();
      break;
      label293:
      i = 1;
    }
  }
  
  private void gMG()
  {
    AppMethodBeat.i(71575);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jbF.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.kEs.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.jbF.setLayoutParams(localLayoutParams1);
    this.kEs.setLayoutParams(localLayoutParams2);
    this.jbF.setVisibility(0);
    this.kEs.setVisibility(8);
    this.jbF.setText(a.i.wallet_shake_award_net_failed);
    this.jbF.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.kEs.setTextColor(getResources().getColor(a.c.hint_text_color));
    this.Pgp.setVisibility(8);
    findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
    findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
    this.xQQ.setVisibility(8);
    this.tCM.setVisibility(0);
    this.tCM.setImageResource(a.e.wallet_pay_shake_award_net_failed_logo);
    this.Pgr.setVisibility(8);
    this.Pgr.onDestroy();
    this.Pgs.setVisibility(8);
    this.Pgs.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void gMH()
  {
    AppMethodBeat.i(71579);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.Iqj.abEB != null) && (this.Iqj.abEB.SLl != 1))
    {
      this.Pgr.setVisibility(8);
      this.Pgr.onDestroy();
      this.Pgs.setVisibility(8);
      this.Pgs.destroy();
    }
    gMM();
    AppMethodBeat.o(71579);
  }
  
  private void gMI()
  {
    AppMethodBeat.i(71580);
    gML();
    if (this.Pgs.getVisibility() != 8)
    {
      this.Pgs.setVisibility(8);
      this.Pgs.destroy();
    }
    if (this.Pgr.getVisibility() != 0)
    {
      this.Pgr.setVisibility(0);
      this.Pgr.post(new Runnable()
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
  
  private void gMJ()
  {
    AppMethodBeat.i(71581);
    gML();
    if (this.Pgr.getVisibility() != 8)
    {
      this.Pgr.setVisibility(8);
      this.Pgr.onDestroy();
    }
    if (this.Pgs.getVisibility() != 8)
    {
      this.Pgs.setVisibility(8);
      this.Pgs.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void gMK()
  {
    AppMethodBeat.i(71582);
    gML();
    if (this.Pgr.getVisibility() != 8)
    {
      this.Pgr.setVisibility(8);
      this.Pgr.onDestroy();
    }
    if (this.Iqj.abEB != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.Iqj.abEB.SLl) });
      switch (this.Iqj.abEB.SLl)
      {
      default: 
        this.Pgs.setVisibility(8);
        this.Pgs.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.Pgs.getVisibility() != 0)
        {
          this.Pgs.setVisibility(0);
          this.Pgs.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71556);
              if (WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getHeight() != WalletSuccPageAwardWidget.this.getHeight())
              {
                FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getLayoutParams();
                localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
                localLayoutParams.height = (WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight() - com.tencent.mm.ci.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2));
                localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
              }
              AppMethodBeat.o(71556);
            }
          });
        }
        this.Pgs.destroy();
        if (!Util.isNullOrNil(this.Iqj.abEB.abEs))
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.Iqj.abEB.abEs });
          this.Pgs.setShakeHintWording(this.Iqj.abEB.abEs);
        }
        if (!Util.isNullOrNil(this.Iqj.abEB.abEt)) {}
        try
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.Iqj.abEB.abEt });
          this.Pgs.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(this.Iqj.abEB.abEt, true));
          if (!Util.isNullOrNil(this.Iqj.abEB.abEu))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.Iqj.abEB.abEu });
            this.Pgs.setAfterHintWording(this.Iqj.abEB.abEu);
          }
          if (!Util.isNullOrNil(this.Iqj.abEB.abEv)) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.Iqj.abEB.abEv });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.Pgs.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(this.Iqj.abEB.abEv, true));
            this.Pgs.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void Cs(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.IzE;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localh.a(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(a.i.wallet_shake_award_shaking_wording));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(a.c.desc_text_color));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71557);
                    return;
                  }
                }
                h localh = h.IzE;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.a(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.Pgs.gMv();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.Iqj.abEB.abEt, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.Iqj.abEB.abEv, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.Iqj.abEB.abEr;
        if (localg == null) {
          break label831;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.TQP, localg.TQQ, Integer.valueOf(localg.TQR) });
        xw localxw = new xw();
        localxw.fWN.userName = localg.TQP;
        localxw.fWN.fWP = Util.nullAs(localg.TQQ, "");
        localxw.fWN.scene = 1060;
        localxw.fWN.fvd = this.tUC;
        localxw.fWN.fWQ = 0;
        if (localg.TQR > 0) {
          localxw.fWN.appVersion = localg.TQR;
        }
        localxw.fWN.context = this.Pgu;
        EventCenter.instance.publish(localxw);
        this.Pgv = true;
        this.Pgz = false;
        this.knk.postDelayed(new Runnable()
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
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.Iqj.abEB.url });
        com.tencent.mm.wallet_core.ui.g.p(this.Pgu, this.Iqj.abEB.url, false);
        this.Pgv = true;
        this.Pgz = false;
        this.knk.postDelayed(new Runnable()
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
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.Pgr.setVisibility(8);
      this.Pgr.onDestroy();
    }
    this.Pgs.setVisibility(8);
    this.Pgs.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void gML()
  {
    AppMethodBeat.i(71584);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.Iqj.SvK;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.Pgt = ((i)((List)localObject1).get(0));
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.Pgt.abEZ, this.Pgt.abFa, this.Pgt.GUf });
        this.tCM.setUrl(this.Pgt.GUf);
        if (!Util.isNullOrNil(this.Pgt.GUf)) {
          this.tCM.setVisibility(0);
        }
        if (Util.isNullOrNil(this.Pgt.abEZ)) {
          break label1228;
        }
        this.jbF.setText(this.Pgt.abEZ);
        this.jbF.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!Util.isNullOrNil(this.Pgt.abFc)) {
          this.jbF.setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(this.Pgt.abFc, true));
        }
        i = 1;
        if (!Util.isNullOrNil(this.Pgt.abFa))
        {
          this.kEs.setText(this.Pgt.abFa);
          this.kEs.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!Util.isNullOrNil(this.Pgt.abFd)) {
            this.kEs.setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(this.Pgt.abFd, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.jbF.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.kEs.getLayoutParams();
            if ((!Util.isNullOrNil(this.Pgt.abEZ)) && (Util.isNullOrNil(this.Pgt.abFa)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.jbF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.kEs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.jbF.setVisibility(0);
              this.kEs.setVisibility(8);
            }
          }
          else
          {
            if (Util.isNullOrNil(this.Pgt.abFb)) {
              continue;
            }
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.Pgt.abFb });
            localObject1 = new c.a();
            ((c.a)localObject1).lRD = true;
            ((c.a)localObject1).lRC = true;
            ((c.a)localObject1).fullPath = bhG(this.Pgt.abFb);
            localObject1 = ((c.a)localObject1).bmL();
            com.tencent.mm.ay.q.bml().a(this.Pgt.abFb, null, (com.tencent.mm.ay.a.a.c)localObject1, new com.tencent.mm.ay.a.c.k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).abFb)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).abFb.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.aB(paramAnonymousBitmap), "widget_bg");
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.PgB);
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
                          WalletSuccPageAwardWidget.this.findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(8);
                          WalletSuccPageAwardWidget.this.findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(8);
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
            i = this.Iqj.SvL;
            localObject3 = this.Iqj.SvM;
            if (this.Iqj.SvM == null) {
              continue;
            }
            localObject1 = this.Iqj.SvM.abEo;
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.Iqj.SvL != 0) && (this.Iqj.SvM != null) && (!Util.isNullOrNil(this.Iqj.SvM.abEo))) {
              continue;
            }
            this.xQQ.setVisibility(8);
            if (this.jbF.getVisibility() == 0)
            {
              this.jbF.setSingleLine();
              this.jbF.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71566);
                  try
                  {
                    if ((WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() > 0) && (WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() > 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() >= WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText())))
                    {
                      float f = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getTextSize();
                      Log.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) });
                      Object localObject = new Paint();
                      ((Paint)localObject).setTextSize(f);
                      String str2 = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText().toString();
                      f = WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() - WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getLeft();
                      int i = 1;
                      while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                        i += 1;
                      }
                      Log.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                    Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
                    AppMethodBeat.o(71566);
                  }
                }
              });
            }
            if (this.xQQ.getVisibility() != 0) {
              this.jbF.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.Iqj.abEy != 0) {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.Iqj.abEy) });
            }
            if (!Util.isNullOrNil(this.Iqj.abEA))
            {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.Iqj.abEA });
              if (this.Pgq != null)
              {
                this.Pgq.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).lRD = true;
                ((c.a)localObject1).lRC = true;
                ((c.a)localObject1).fullPath = bhG(this.Iqj.abEA);
                localObject1 = ((c.a)localObject1).bmL();
                com.tencent.mm.ay.q.bml().a(this.Iqj.abEA, null, (com.tencent.mm.ay.a.a.c)localObject1, new com.tencent.mm.ay.a.c.k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).abEA)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).abEA.equals(paramAnonymousString))) {
                      MMHandlerThread.postToMainThread(new Runnable()
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
            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((Util.isNullOrNil(this.Pgt.abEZ)) && (!Util.isNullOrNil(this.Pgt.abFa)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.jbF.setLayoutParams(localException2);
            this.kEs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.jbF.setVisibility(8);
            this.kEs.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.jbF.setLayoutParams(localException2);
          this.kEs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jbF.setVisibility(0);
          this.kEs.setVisibility(0);
          continue;
          this.Pgp.setVisibility(8);
          findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
          findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.Iqj.SvM;
          if (localObject2 == null) {
            continue;
          }
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).abEo, Integer.valueOf(((e.a.a.a)localObject2).abEq), ((e.a.a.a)localObject2).abEp, ((e.a.a.a)localObject2).url });
          this.xQQ.setText(((e.a.a.a)localObject2).abEo);
          if (!Util.isNullOrNil(((e.a.a.a)localObject2).abEp))
          {
            localObject3 = getContext().getResources().getDrawable(a.e.btn_solid_green);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.k.cW(((e.a.a.a)localObject2).abEp, false), PorterDuff.Mode.SRC);
            this.xQQ.setBackground((Drawable)localObject3);
          }
          this.xQQ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71565);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).SvM != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).SvM);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq != 1) {
                  break label282;
                }
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                com.tencent.mm.wallet_core.ui.g.p(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
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
                paramAnonymousView = h.IzE;
                if (!WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {
                  break label746;
                }
              }
              label282:
              label746:
              for (int i = 2;; i = 1)
              {
                paramAnonymousView.a(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71565);
                return;
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEr;
                  if (paramAnonymousView != null)
                  {
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.TQP, paramAnonymousView.TQQ, Integer.valueOf(paramAnonymousView.TQR) });
                    localObject = new xw();
                    ((xw)localObject).fWN.userName = paramAnonymousView.TQP;
                    ((xw)localObject).fWN.fWP = Util.nullAs(paramAnonymousView.TQQ, "");
                    ((xw)localObject).fWN.scene = 1060;
                    ((xw)localObject).fWN.fvd = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    ((xw)localObject).fWN.fWQ = 0;
                    if (paramAnonymousView.TQR > 0) {
                      ((xw)localObject).fWN.appVersion = paramAnonymousView.TQR;
                    }
                    ((xw)localObject).fWN.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    EventCenter.instance.publish((IEvent)localObject);
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 3)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 5)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 6)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 7)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).abEq != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
              }
            }
          });
          this.xQQ.setVisibility(0);
          if ((!this.ITE) && (!this.Pgv)) {
            continue;
          }
          localObject2 = h.IzE;
          if (!this.Pgv) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((h)localObject2).a(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1228:
      i = 0;
    }
  }
  
  private void gMM()
  {
    AppMethodBeat.i(71585);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.Pgv) });
    if (this.Pgv)
    {
      p localp = new p(this.Iqj.SvJ, this.OHV);
      this.Pgu.doSceneProgress(localp, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.aSL() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    ad.kS(paramContext).inflate(a.g.wallet_succ_page_award_widget, this, true);
    this.EMs = ((ViewGroup)findViewById(a.f.content_layout));
    this.tCM = ((CdnImageView)findViewById(a.f.logo_iv));
    this.jbF = ((TextView)findViewById(a.f.name_tv));
    this.kEs = ((TextView)findViewById(a.f.desc_tv));
    this.xQQ = ((Button)findViewById(a.f.button));
    this.Pgr = ((WalletScratchShakeView)findViewById(a.f.scratch_shake_view));
    this.Pgp = ((ImageView)findViewById(a.f.background));
    this.Pgs = ((WalletAwardShakeAnimView)findViewById(a.f.shake_view));
    this.jbF.setTextSize(1, 17.0F);
    this.kEs.setTextSize(1, 14.0F);
    this.xQQ.setTextSize(1, 16.0F);
    this.tCM.setRoundCorner(true);
    this.tCM.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.abEz == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.Pgv), Boolean.valueOf(paramBoolean) });
      this.Pgu = paramWalletBaseUI;
      this.Iqj = paramc;
      this.OHV = paramBoolean;
      this.tUC = paramString;
      this.Pgq = paramImageView;
      gMF();
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
    if ((this.Pgr != null) && (this.Pgr.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.Pgr != null)
      {
        localWalletScratchShakeView = this.Pgr;
        if (localWalletScratchShakeView.PfP == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.PfP.an(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.Pgr;
        if (localWalletScratchShakeView.PfP == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.PfP.Pgj;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.Pgr.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.EMs == null) || (bool2)) {
          break label141;
        }
        bool1 = this.EMs.dispatchTouchEvent(paramMotionEvent);
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
    if (this.Pgu != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.Pgu.addSceneEndListener(1859);
      this.Pgu.addSceneEndListener(2547);
      this.Pgu.addSceneEndListener(2803);
      this.Pgu.addSceneEndListener(2508);
      this.Pgu.addSceneEndListener(2529);
      this.Pgu.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.Pgu != null)
    {
      this.Pgu.removeSceneEndListener(1859);
      this.Pgu.removeSceneEndListener(2547);
      this.Pgu.removeSceneEndListener(2803);
      this.Pgu.removeSceneEndListener(2508);
      this.Pgu.removeSceneEndListener(2529);
      this.Pgu.removeSceneEndListener(2888);
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.Pgw), Boolean.valueOf(this.Pgx) });
      if ((!this.Pgw) && (!this.Pgx))
      {
        localObject = h.IzE;
        if (!this.Pgv) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).a(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new m(this.Iqj.Std, 4, this.OHV);
      this.Pgu.doSceneProgress((com.tencent.mm.an.q)localObject, false);
      if (this.Pgr != null) {
        this.Pgr.onDestroy();
      }
      if (this.Pgs != null) {
        this.Pgs.destroy();
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
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.Pgv), b(this.Iqj), Boolean.valueOf(this.Pgz) });
    if (!this.Pgz)
    {
      this.Pgz = true;
      gMH();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof o))
    {
      paramString = (o)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.OHZ;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.tqa), paramString.tqb, paramString.Tbs, paramString.OSs });
        if (paramString.tqa == 0)
        {
          if (!Util.isNullOrNil(paramString.Tbs))
          {
            Toast.makeText(getContext(), paramString.Tbs, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.OSs != null)
          {
            if (this.Iqj.SvM != null)
            {
              paramInt1 = this.Iqj.SvM.abEq;
              this.Iqj = paramString.OSs;
              if ((paramString.OSs.SvM != null) && (this.Iqj.SvM != null))
              {
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.OSs.SvM.abEq) });
                if (paramString.OSs.SvM.abEq == 4)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.Iqj.SvM.abEq = paramInt1;
                }
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              gMF();
            }
          }
          else
          {
            if ((this.Pgy != null) && (this.Pgx))
            {
              if (this.Pgy.abEq != 8) {
                break label375;
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              com.tencent.mm.wallet_core.ui.g.p(this.Pgu, this.Pgy.url, false);
              this.Pgv = true;
            }
            label357:
            this.Pgy = null;
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
        if (this.Pgy.abEq != 9) {
          break label357;
        }
        paramString = this.Pgy.abEr;
        if (paramString == null) {
          break label357;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.TQP, paramString.TQQ, Integer.valueOf(paramString.TQR) });
        paramq = new xw();
        paramq.fWN.userName = paramString.TQP;
        paramq.fWN.fWP = Util.nullAs(paramString.TQQ, "");
        paramq.fWN.scene = 1060;
        paramq.fWN.fvd = this.tUC;
        paramq.fWN.fWQ = 0;
        if (paramString.TQR > 0) {
          paramq.fWN.appVersion = paramString.TQR;
        }
        paramq.fWN.context = this.Pgu;
        EventCenter.instance.publish(paramq);
        this.Pgv = true;
        this.Pgz = false;
        this.knk.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71555);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71555);
          }
        }, 3000L);
        break label357;
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        gMG();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof p))
    {
      paramString = (p)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.OIb;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.tqa;
        paramq = paramString.tqb;
        localObject1 = paramString.SvK;
        i = paramString.SvL;
        localObject2 = paramString.SvM;
        if (paramString.SvM == null) {
          break label881;
        }
        paramInt1 = paramString.SvM.abEq;
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramq, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.tqa == 0)
        {
          this.Iqj.SvK = paramString.SvK;
          this.Iqj.SvL = paramString.SvL;
          if (this.Iqj.SvM == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.Iqj.SvM.abEq;; paramInt1 = 0)
      {
        if (paramString.SvM != null)
        {
          this.Iqj.SvM = paramString.SvM;
          if ((this.Iqj.SvM != null) && (paramString.SvM.abEq == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.Iqj.SvM.abEq = paramInt1;
          }
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.Iqj) });
        gML();
        this.Pgv = false;
        AppMethodBeat.o(71586);
        return true;
        paramInt1 = 0;
        break;
      }
    }
    if ((paramq instanceof m))
    {
      paramString = (m)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = paramString.OHU;
        if (paramq == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramq.tqa;
        localObject1 = paramq.tqb;
        localObject2 = paramq.OSs;
        if (paramq.OSs != null)
        {
          paramString = paramq.OSs.SvK;
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramq.OSs == null) || (paramq.OSs.SvK == null) || (paramq.OSs.SvK.size() <= 0)) {
            break label1222;
          }
          paramString = paramq.OSs;
          localObject1 = paramq.OSs.SvM;
          if (paramq.OSs.SvM == null) {
            break label1217;
          }
          paramInt1 = paramq.OSs.SvM.abEq;
          label1082:
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.Iqj.SvM != null) {
            paramInt1 = this.Iqj.SvM.abEq;
          }
          this.Iqj = paramq.OSs;
          if ((this.Iqj.SvM != null) && (paramq.OSs.SvM != null) && (paramq.OSs.SvM.abEq == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.Iqj.SvM.abEq = paramInt1;
          }
          gMF();
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
        gMG();
        continue;
        gMG();
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