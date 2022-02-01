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
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget
  extends FrameLayout
{
  private Button Bqo;
  private ViewGroup KGL;
  private g.a.a.c OnC;
  private boolean Pcx;
  private ImageView VXd;
  private ImageView VXe;
  private WalletScratchShakeView VXf;
  private WalletAwardShakeAnimView VXg;
  private g.a.a.i VXh;
  private WalletBaseUI VXi;
  private boolean VXj;
  private boolean VXk;
  private boolean VXl;
  private g.a.a.a VXm;
  private boolean VXn;
  private boolean VxI;
  private TextView descTv;
  private TextView lDF;
  private MMHandler mRi;
  private CdnImageView wGP;
  private String wXY;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.VXj = false;
    this.VXk = false;
    this.Pcx = true;
    this.VXl = false;
    this.VXm = null;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.VXn = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.VXj = false;
    this.VXk = false;
    this.Pcx = true;
    this.VXl = false;
    this.VXm = null;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.VXn = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(g.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.ZvT != null) && (paramc.ZvT.size() > 0)) || (paramc.ajFE != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private static String b(g.a.a.c paramc)
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
        if ((paramc.ZvT != null) && (paramc.ZvT.size() > 0))
        {
          localObject2 = paramc.ZvT.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            g.a.a.i locali = (g.a.a.i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.MRI);
            localJSONObject2.put("award_name", locali.ajGc);
            localJSONObject2.put("award_description", locali.ajGd);
            localJSONObject2.put("background_img", locali.ajGe);
            localJSONObject2.put("award_name_color", locali.ajGf);
            localJSONObject2.put("award_description_color", locali.ajGg);
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
      localJSONObject1.put("is_query_others", paramc.ajFz);
      localJSONObject1.put("draw_lottery_params", paramc.Zsq);
      localJSONObject1.put("is_show_btn", paramc.ZvU);
      Object localObject1 = new JSONObject();
      if (paramc.ZvV != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.ZvV.ajFr);
        ((JSONObject)localObject1).put("btn_color", paramc.ZvV.ajFs);
        ((JSONObject)localObject1).put("btn_op_type", paramc.ZvV.ajFt);
        ((JSONObject)localObject1).put("url", paramc.ZvV.url);
        localObject2 = new JSONObject();
        if (paramc.ZvV.ajFu != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.ZvV.ajFu.abho);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.ZvV.ajFu.abhp);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.ZvV.ajFu.abhq);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.ZvV.aauB);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.ZvS);
      localJSONObject1.put("user_opertaion_type", paramc.ajFA);
      localJSONObject1.put("is_show_layer", paramc.ajFB);
      localJSONObject1.put("background_img_whole", paramc.ajFD);
      if (paramc.ajFE != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.ajFE.ajFv);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.ajFE.ajFw);
        ((JSONObject)localObject1).put("url", paramc.ajFE.url);
        ((JSONObject)localObject1).put("op_type", paramc.ajFE.YAN);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.ajFE.ajFx);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.ajFE.ajFy);
        localObject2 = new JSONObject();
        if (paramc.ajFE.ajFu != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.ajFE.ajFu.abho);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.ajFE.ajFu.abhp);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.ajFE.ajFu.abhq);
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
  
  private String bhp(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!Util.isNullOrNil(new String[0]))
    {
      y.bDX(getAccImagesPath());
      String str = getAccImagesPath() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
      AppMethodBeat.o(71583);
      return str;
    }
    AppMethodBeat.o(71583);
    return null;
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.i.b.bmz() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void ilT()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.OnC), Boolean.valueOf(this.Pcx) });
    if (this.OnC == null)
    {
      Log.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    Log.printInfoStack("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.OnC.ajFA), Integer.valueOf(this.OnC.ZvT.size()), Boolean.valueOf(this.VXj) });
    if ((this.OnC.ajFA <= 0) || (this.OnC.ajFA > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.OnC))
    {
      AppMethodBeat.o(71574);
      return;
    }
    h localh;
    if (this.OnC.ajFA == 4)
    {
      ilX();
      if ((this.Pcx) || (this.VXj))
      {
        localh = h.OAn;
        if (!this.VXj) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.b(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.Pcx = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.OnC.ajFA == 1) || (this.OnC.ajFA == 2) || (this.OnC.ajFA == 3))
      {
        ilW();
        break;
      }
      if (this.OnC.ajFA != 5) {
        break;
      }
      ilY();
      break;
      label293:
      i = 1;
    }
  }
  
  private void ilU()
  {
    AppMethodBeat.i(71575);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.lDF.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.descTv.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.lDF.setLayoutParams(localLayoutParams1);
    this.descTv.setLayoutParams(localLayoutParams2);
    this.lDF.setVisibility(0);
    this.descTv.setVisibility(8);
    this.lDF.setText(a.i.wallet_shake_award_net_failed);
    this.lDF.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.descTv.setTextColor(getResources().getColor(a.c.hint_text_color));
    this.VXd.setVisibility(8);
    findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
    findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
    this.Bqo.setVisibility(8);
    this.wGP.setVisibility(0);
    this.wGP.setImageResource(a.e.wallet_pay_shake_award_net_failed_logo);
    this.VXf.setVisibility(8);
    this.VXf.onDestroy();
    this.VXg.setVisibility(8);
    this.VXg.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void ilV()
  {
    AppMethodBeat.i(71579);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.OnC.ajFE != null) && (this.OnC.ajFE.YAN != 1))
    {
      this.VXf.setVisibility(8);
      this.VXf.onDestroy();
      this.VXg.setVisibility(8);
      this.VXg.destroy();
    }
    ima();
    AppMethodBeat.o(71579);
  }
  
  private void ilW()
  {
    AppMethodBeat.i(71580);
    ilZ();
    if (this.VXg.getVisibility() != 8)
    {
      this.VXg.setVisibility(8);
      this.VXg.destroy();
    }
    if (this.VXf.getVisibility() != 0)
    {
      this.VXf.setVisibility(0);
      this.VXf.post(new Runnable()
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
  
  private void ilX()
  {
    AppMethodBeat.i(71581);
    ilZ();
    if (this.VXf.getVisibility() != 8)
    {
      this.VXf.setVisibility(8);
      this.VXf.onDestroy();
    }
    if (this.VXg.getVisibility() != 8)
    {
      this.VXg.setVisibility(8);
      this.VXg.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void ilY()
  {
    AppMethodBeat.i(71582);
    ilZ();
    if (this.VXf.getVisibility() != 8)
    {
      this.VXf.setVisibility(8);
      this.VXf.onDestroy();
    }
    if (this.OnC.ajFE != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.OnC.ajFE.YAN) });
      switch (this.OnC.ajFE.YAN)
      {
      default: 
        this.VXg.setVisibility(8);
        this.VXg.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.VXg.getVisibility() != 0)
        {
          this.VXg.setVisibility(0);
          this.VXg.post(new Runnable()
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
        this.VXg.destroy();
        if (!Util.isNullOrNil(this.OnC.ajFE.ajFv))
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.OnC.ajFE.ajFv });
          this.VXg.setShakeHintWording(this.OnC.ajFE.ajFv);
        }
        if (!Util.isNullOrNil(this.OnC.ajFE.ajFw)) {}
        try
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.OnC.ajFE.ajFw });
          this.VXg.setShakeHintWordingColor(n.dE(this.OnC.ajFE.ajFw, true));
          if (!Util.isNullOrNil(this.OnC.ajFE.ajFx))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.OnC.ajFE.ajFx });
            this.VXg.setAfterHintWording(this.OnC.ajFE.ajFx);
          }
          if (!Util.isNullOrNil(this.OnC.ajFE.ajFy)) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.OnC.ajFE.ajFy });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.VXg.setAfterHintWordingColor(n.dE(this.OnC.ajFE.ajFy, true));
            this.VXg.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void HX(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.OAn;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localh.b(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(a.i.wallet_shake_award_shaking_wording));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(a.c.desc_text_color));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71557);
                    return;
                  }
                }
                h localh = h.OAn;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.b(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.VXg.hQe();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.OnC.ajFE.ajFw, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.OnC.ajFE.ajFy, localException2.getMessage() });
            }
          }
        }
      case 2: 
        g.a.a.g localg = this.OnC.ajFE.ajFu;
        if (localg == null) {
          break label828;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.abho, localg.abhp, Integer.valueOf(localg.abhq) });
        zp localzp = new zp();
        localzp.icM.userName = localg.abho;
        localzp.icM.icO = Util.nullAs(localg.abhp, "");
        localzp.icM.scene = 1060;
        localzp.icM.hzx = this.wXY;
        localzp.icM.icP = 0;
        if (localg.abhq > 0) {
          localzp.icM.appVersion = localg.abhq;
        }
        localzp.icM.context = this.VXi;
        localzp.publish();
        this.VXj = true;
        this.VXn = false;
        this.mRi.postDelayed(new Runnable()
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
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.OnC.ajFE.url });
        com.tencent.mm.wallet_core.ui.i.p(this.VXi, this.OnC.ajFE.url, false);
        this.VXj = true;
        this.VXn = false;
        this.mRi.postDelayed(new Runnable()
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
      this.VXf.setVisibility(8);
      this.VXf.onDestroy();
    }
    this.VXg.setVisibility(8);
    this.VXg.destroy();
    label828:
    AppMethodBeat.o(71582);
  }
  
  private void ilZ()
  {
    AppMethodBeat.i(71584);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.OnC.ZvT;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.VXh = ((g.a.a.i)((List)localObject1).get(0));
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.VXh.ajGc, this.VXh.ajGd, this.VXh.MRI });
        this.wGP.setUrl(this.VXh.MRI);
        if (!Util.isNullOrNil(this.VXh.MRI)) {
          this.wGP.setVisibility(0);
        }
        if (Util.isNullOrNil(this.VXh.ajGc)) {
          break label1228;
        }
        this.lDF.setText(this.VXh.ajGc);
        this.lDF.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!Util.isNullOrNil(this.VXh.ajGf)) {
          this.lDF.setTextColor(n.dE(this.VXh.ajGf, true));
        }
        i = 1;
        if (!Util.isNullOrNil(this.VXh.ajGd))
        {
          this.descTv.setText(this.VXh.ajGd);
          this.descTv.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!Util.isNullOrNil(this.VXh.ajGg)) {
            this.descTv.setTextColor(n.dE(this.VXh.ajGg, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.lDF.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.descTv.getLayoutParams();
            if ((!Util.isNullOrNil(this.VXh.ajGc)) && (Util.isNullOrNil(this.VXh.ajGd)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.lDF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.descTv.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.lDF.setVisibility(0);
              this.descTv.setVisibility(8);
            }
          }
          else
          {
            if (Util.isNullOrNil(this.VXh.ajGe)) {
              continue;
            }
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.VXh.ajGe });
            localObject1 = new c.a();
            ((c.a)localObject1).oKp = true;
            ((c.a)localObject1).oKo = true;
            ((c.a)localObject1).fullPath = bhp(this.VXh.ajGe);
            localObject1 = ((c.a)localObject1).bKx();
            r.bKe().a(this.VXh.ajGe, null, (com.tencent.mm.modelimage.loader.a.c)localObject1, new k()
            {
              public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).ajGe)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).ajGe.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.aT(paramAnonymousBitmap), "widget_bg");
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.VXp);
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
            i = this.OnC.ZvU;
            localObject3 = this.OnC.ZvV;
            if (this.OnC.ZvV == null) {
              continue;
            }
            localObject1 = this.OnC.ZvV.ajFr;
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.OnC.ZvU != 0) && (this.OnC.ZvV != null) && (!Util.isNullOrNil(this.OnC.ZvV.ajFr))) {
              continue;
            }
            this.Bqo.setVisibility(8);
            if (this.lDF.getVisibility() == 0)
            {
              this.lDF.setSingleLine();
              this.lDF.post(new Runnable()
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
            if (this.Bqo.getVisibility() != 0) {
              this.lDF.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.OnC.ajFB != 0) {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.OnC.ajFB) });
            }
            if (!Util.isNullOrNil(this.OnC.ajFD))
            {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.OnC.ajFD });
              if (this.VXe != null)
              {
                this.VXe.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).oKp = true;
                ((c.a)localObject1).oKo = true;
                ((c.a)localObject1).fullPath = bhp(this.OnC.ajFD);
                localObject1 = ((c.a)localObject1).bKx();
                r.bKe().a(this.OnC.ajFD, null, (com.tencent.mm.modelimage.loader.a.c)localObject1, new k()
                {
                  public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).ajFD)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).ajFD.equals(paramAnonymousString))) {
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
          if ((Util.isNullOrNil(this.VXh.ajGc)) && (!Util.isNullOrNil(this.VXh.ajGd)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.lDF.setLayoutParams(localException2);
            this.descTv.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.lDF.setVisibility(8);
            this.descTv.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.lDF.setLayoutParams(localException2);
          this.descTv.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.lDF.setVisibility(0);
          this.descTv.setVisibility(0);
          continue;
          this.VXd.setVisibility(8);
          findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
          findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.OnC.ZvV;
          if (localObject2 == null) {
            continue;
          }
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((g.a.a.a)localObject2).ajFr, Integer.valueOf(((g.a.a.a)localObject2).ajFt), ((g.a.a.a)localObject2).ajFs, ((g.a.a.a)localObject2).url });
          this.Bqo.setText(((g.a.a.a)localObject2).ajFr);
          if (!Util.isNullOrNil(((g.a.a.a)localObject2).ajFs))
          {
            localObject3 = getContext().getResources().getDrawable(a.e.btn_solid_green);
            ((Drawable)localObject3).setColorFilter(n.dE(((g.a.a.a)localObject2).ajFs, false), PorterDuff.Mode.SRC);
            this.Bqo.setBackground((Drawable)localObject3);
          }
          this.Bqo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71565);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).ZvV != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).ZvV);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt != 1) {
                  break label282;
                }
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                com.tencent.mm.wallet_core.ui.i.p(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
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
                paramAnonymousView = h.OAn;
                if (!WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {
                  break label743;
                }
              }
              label282:
              label743:
              for (int i = 2;; i = 1)
              {
                paramAnonymousView.b(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71565);
                return;
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFu;
                  if (paramAnonymousView != null)
                  {
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.abho, paramAnonymousView.abhp, Integer.valueOf(paramAnonymousView.abhq) });
                    localObject = new zp();
                    ((zp)localObject).icM.userName = paramAnonymousView.abho;
                    ((zp)localObject).icM.icO = Util.nullAs(paramAnonymousView.abhp, "");
                    ((zp)localObject).icM.scene = 1060;
                    ((zp)localObject).icM.hzx = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    ((zp)localObject).icM.icP = 0;
                    if (paramAnonymousView.abhq > 0) {
                      ((zp)localObject).icM.appVersion = paramAnonymousView.abhq;
                    }
                    ((zp)localObject).icM.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    ((zp)localObject).publish();
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 3)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 5)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 6)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 7)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).ajFt != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
              }
            }
          });
          this.Bqo.setVisibility(0);
          if ((!this.Pcx) && (!this.VXj)) {
            continue;
          }
          localObject2 = h.OAn;
          if (!this.VXj) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((h)localObject2).b(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1228:
      i = 0;
    }
  }
  
  private void ima()
  {
    AppMethodBeat.i(71585);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.VXj) });
    if (this.VXj)
    {
      com.tencent.mm.plugin.wallet_core.c.p localp = new com.tencent.mm.plugin.wallet_core.c.p(this.OnC.ZvS, this.VxI);
      this.VXi.doSceneProgress(localp, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    af.mU(paramContext).inflate(a.g.wallet_succ_page_award_widget, this, true);
    this.KGL = ((ViewGroup)findViewById(a.f.content_layout));
    this.wGP = ((CdnImageView)findViewById(a.f.logo_iv));
    this.lDF = ((TextView)findViewById(a.f.name_tv));
    this.descTv = ((TextView)findViewById(a.f.desc_tv));
    this.Bqo = ((Button)findViewById(a.f.button));
    this.VXf = ((WalletScratchShakeView)findViewById(a.f.scratch_shake_view));
    this.VXd = ((ImageView)findViewById(a.f.background));
    this.VXg = ((WalletAwardShakeAnimView)findViewById(a.f.shake_view));
    this.lDF.setTextSize(1, 17.0F);
    this.descTv.setTextSize(1, 14.0F);
    this.Bqo.setTextSize(1, 16.0F);
    this.wGP.setRoundCorner(true);
    this.wGP.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, g.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.ajFC == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.VXj), Boolean.valueOf(paramBoolean) });
      this.VXi = paramWalletBaseUI;
      this.OnC = paramc;
      this.VxI = paramBoolean;
      this.wXY = paramString;
      this.VXe = paramImageView;
      ilT();
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
    if ((this.VXf != null) && (this.VXf.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.VXf != null)
      {
        localWalletScratchShakeView = this.VXf;
        if (localWalletScratchShakeView.VWD == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.VWD.aq(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.VXf;
        if (localWalletScratchShakeView.VWD == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.VWD.VWX;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.VXf.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.KGL == null) || (bool2)) {
          break label141;
        }
        bool1 = this.KGL.dispatchTouchEvent(paramMotionEvent);
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
    if (this.VXi != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.VXi.addSceneEndListener(1859);
      this.VXi.addSceneEndListener(2547);
      this.VXi.addSceneEndListener(2803);
      this.VXi.addSceneEndListener(2508);
      this.VXi.addSceneEndListener(2529);
      this.VXi.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.VXi != null)
    {
      this.VXi.removeSceneEndListener(1859);
      this.VXi.removeSceneEndListener(2547);
      this.VXi.removeSceneEndListener(2803);
      this.VXi.removeSceneEndListener(2508);
      this.VXi.removeSceneEndListener(2529);
      this.VXi.removeSceneEndListener(2888);
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.VXk), Boolean.valueOf(this.VXl) });
      if ((!this.VXk) && (!this.VXl))
      {
        localObject = h.OAn;
        if (!this.VXj) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).b(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new m(this.OnC.Zsq, 4, this.VxI);
      this.VXi.doSceneProgress((com.tencent.mm.am.p)localObject, false);
      if (this.VXf != null) {
        this.VXf.onDestroy();
      }
      if (this.VXg != null) {
        this.VXg.destroy();
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
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.VXj), b(this.OnC), Boolean.valueOf(this.VXn) });
    if (!this.VXn)
    {
      this.VXn = true;
      ilV();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramp instanceof o))
    {
      paramString = (o)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.VxM;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA, paramString.aaoE, paramString.VIz });
        if (paramString.wuz == 0)
        {
          if (!Util.isNullOrNil(paramString.aaoE))
          {
            Toast.makeText(getContext(), paramString.aaoE, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.VIz != null)
          {
            if (this.OnC.ZvV != null)
            {
              paramInt1 = this.OnC.ZvV.ajFt;
              this.OnC = paramString.VIz;
              if ((paramString.VIz.ZvV != null) && (this.OnC.ZvV != null))
              {
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.VIz.ZvV.ajFt) });
                if (paramString.VIz.ZvV.ajFt == 4)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.OnC.ZvV.ajFt = paramInt1;
                }
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              ilT();
            }
          }
          else
          {
            if ((this.VXm != null) && (this.VXl))
            {
              if (this.VXm.ajFt != 8) {
                break label375;
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              com.tencent.mm.wallet_core.ui.i.p(this.VXi, this.VXm.url, false);
              this.VXj = true;
            }
            label357:
            this.VXm = null;
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
        if (this.VXm.ajFt != 9) {
          break label357;
        }
        paramString = this.VXm.ajFu;
        if (paramString == null) {
          break label357;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.abho, paramString.abhp, Integer.valueOf(paramString.abhq) });
        paramp = new zp();
        paramp.icM.userName = paramString.abho;
        paramp.icM.icO = Util.nullAs(paramString.abhp, "");
        paramp.icM.scene = 1060;
        paramp.icM.hzx = this.wXY;
        paramp.icM.icP = 0;
        if (paramString.abhq > 0) {
          paramp.icM.appVersion = paramString.abhq;
        }
        paramp.icM.context = this.VXi;
        paramp.publish();
        this.VXj = true;
        this.VXn = false;
        this.mRi.postDelayed(new Runnable()
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
        ilU();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.p))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.p)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.VxO;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.wuz;
        paramp = paramString.wuA;
        localObject1 = paramString.ZvT;
        i = paramString.ZvU;
        localObject2 = paramString.ZvV;
        if (paramString.ZvV == null) {
          break label878;
        }
        paramInt1 = paramString.ZvV.ajFt;
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramp, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.wuz == 0)
        {
          this.OnC.ZvT = paramString.ZvT;
          this.OnC.ZvU = paramString.ZvU;
          if (this.OnC.ZvV == null) {
            break label883;
          }
        }
      }
      label878:
      label883:
      for (paramInt1 = this.OnC.ZvV.ajFt;; paramInt1 = 0)
      {
        if (paramString.ZvV != null)
        {
          this.OnC.ZvV = paramString.ZvV;
          if ((this.OnC.ZvV != null) && (paramString.ZvV.ajFt == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.OnC.ZvV.ajFt = paramInt1;
          }
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.OnC) });
        ilZ();
        this.VXj = false;
        AppMethodBeat.o(71586);
        return true;
        paramInt1 = 0;
        break;
      }
    }
    if ((paramp instanceof m))
    {
      paramString = (m)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = paramString.VxH;
        if (paramp == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramp.wuz;
        localObject1 = paramp.wuA;
        localObject2 = paramp.VIz;
        if (paramp.VIz != null)
        {
          paramString = paramp.VIz.ZvT;
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramp.VIz == null) || (paramp.VIz.ZvT == null) || (paramp.VIz.ZvT.size() <= 0)) {
            break label1219;
          }
          paramString = paramp.VIz;
          localObject1 = paramp.VIz.ZvV;
          if (paramp.VIz.ZvV == null) {
            break label1214;
          }
          paramInt1 = paramp.VIz.ZvV.ajFt;
          label1079:
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.OnC.ZvV != null) {
            paramInt1 = this.OnC.ZvV.ajFt;
          }
          this.OnC = paramp.VIz;
          if ((this.OnC.ZvV != null) && (paramp.VIz.ZvV != null) && (paramp.VIz.ZvV.ajFt == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.OnC.ZvV.ajFt = paramInt1;
          }
          ilT();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71586);
        return true;
        paramString = "";
        break;
        label1214:
        paramInt1 = 0;
        break label1079;
        label1219:
        ilU();
        continue;
        ilU();
      }
    }
    AppMethodBeat.o(71586);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget
 * JD-Core Version:    0.7.0.1
 */