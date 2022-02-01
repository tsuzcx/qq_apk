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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
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
  private boolean COO;
  private ImageView Dnh;
  private ImageView Dni;
  private WalletScratchShakeView Dnj;
  private WalletAwardShakeAnimView Dnk;
  private e.a.a.i Dnl;
  private WalletBaseUI Dnm;
  private boolean Dnn;
  private boolean Dno;
  private boolean Dnp;
  private e.a.a.a Dnq;
  private boolean Dnr;
  private TextView fQd;
  private ap gIf;
  private TextView gUs;
  private CdnImageView oMB;
  private String oZO;
  private Button sfz;
  private ViewGroup vAa;
  private e.a.a.c ybX;
  private boolean yuo;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.Dnn = false;
    this.Dno = false;
    this.yuo = true;
    this.Dnp = false;
    this.Dnq = null;
    this.gIf = new ap(Looper.getMainLooper());
    this.Dnr = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.Dnn = false;
    this.Dno = false;
    this.yuo = true;
    this.Dnp = false;
    this.Dnq = null;
    this.gIf = new ap(Looper.getMainLooper());
    this.Dnr = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.GeV != null) && (paramc.GeV.size() > 0)) || (paramc.NPk != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private String aFb(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!bt.V(new String[0]))
    {
      com.tencent.mm.vfs.i.aYg(getAccImagesPath());
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
        if ((paramc.GeV != null) && (paramc.GeV.size() > 0))
        {
          localObject2 = paramc.GeV.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            e.a.a.i locali = (e.a.a.i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.wMR);
            localJSONObject2.put("award_name", locali.NPI);
            localJSONObject2.put("award_description", locali.NPJ);
            localJSONObject2.put("background_img", locali.NPK);
            localJSONObject2.put("award_name_color", locali.NPL);
            localJSONObject2.put("award_description_color", locali.NPM);
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
      localJSONObject1.put("is_query_others", paramc.NPf);
      localJSONObject1.put("draw_lottery_params", paramc.Gdt);
      localJSONObject1.put("is_show_btn", paramc.GeW);
      Object localObject1 = new JSONObject();
      if (paramc.GeX != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.GeX.NOX);
        ((JSONObject)localObject1).put("btn_color", paramc.GeX.NOY);
        ((JSONObject)localObject1).put("btn_op_type", paramc.GeX.NOZ);
        ((JSONObject)localObject1).put("url", paramc.GeX.url);
        localObject2 = new JSONObject();
        if (paramc.GeX.NPa != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.GeX.NPa.HcE);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.GeX.NPa.HcF);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.GeX.NPa.HcG);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.GeX.GAg);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.GeU);
      localJSONObject1.put("user_opertaion_type", paramc.NPg);
      localJSONObject1.put("is_show_layer", paramc.NPh);
      localJSONObject1.put("background_img_whole", paramc.NPj);
      if (paramc.NPk != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.NPk.NPb);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.NPk.NPc);
        ((JSONObject)localObject1).put("url", paramc.NPk.url);
        ((JSONObject)localObject1).put("op_type", paramc.NPk.HEW);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.NPk.NPd);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.NPk.NPe);
        localObject2 = new JSONObject();
        if (paramc.NPk.NPa != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.NPk.NPa.HcE);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.NPk.NPa.HcF);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.NPk.NPa.HcG);
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
  
  private void eIK()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.ybX), Boolean.valueOf(this.yuo) });
    if (this.ybX == null)
    {
      ad.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    ad.m("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.ybX.NPg), Integer.valueOf(this.ybX.GeV.size()), Boolean.valueOf(this.Dnn) });
    if ((this.ybX.NPg <= 0) || (this.ybX.NPg > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.ybX))
    {
      AppMethodBeat.o(71574);
      return;
    }
    com.tencent.mm.plugin.report.service.g localg;
    if (this.ybX.NPg == 4)
    {
      eIO();
      if ((this.yuo) || (this.Dnn))
      {
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!this.Dnn) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localg.f(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.yuo = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.ybX.NPg == 1) || (this.ybX.NPg == 2) || (this.ybX.NPg == 3))
      {
        eIN();
        break;
      }
      if (this.ybX.NPg != 5) {
        break;
      }
      eIP();
      break;
      label293:
      i = 1;
    }
  }
  
  private void eIL()
  {
    AppMethodBeat.i(71575);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.fQd.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.gUs.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.fQd.setLayoutParams(localLayoutParams1);
    this.gUs.setLayoutParams(localLayoutParams2);
    this.fQd.setVisibility(0);
    this.gUs.setVisibility(8);
    this.fQd.setText(2131765881);
    this.fQd.setTextColor(getResources().getColor(2131100711));
    this.gUs.setTextColor(getResources().getColor(2131100490));
    this.Dnh.setVisibility(8);
    findViewById(2131303060).setVisibility(0);
    findViewById(2131303061).setVisibility(0);
    this.sfz.setVisibility(8);
    this.oMB.setVisibility(0);
    this.oMB.setImageResource(2131234696);
    this.Dnj.setVisibility(8);
    this.Dnj.onDestroy();
    this.Dnk.setVisibility(8);
    this.Dnk.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void eIM()
  {
    AppMethodBeat.i(71579);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.ybX.NPk != null) && (this.ybX.NPk.HEW != 1))
    {
      this.Dnj.setVisibility(8);
      this.Dnj.onDestroy();
      this.Dnk.setVisibility(8);
      this.Dnk.destroy();
    }
    eIR();
    AppMethodBeat.o(71579);
  }
  
  private void eIN()
  {
    AppMethodBeat.i(71580);
    eIQ();
    if (this.Dnk.getVisibility() != 8)
    {
      this.Dnk.setVisibility(8);
      this.Dnk.destroy();
    }
    if (this.Dnj.getVisibility() != 0)
    {
      this.Dnj.setVisibility(0);
      this.Dnj.post(new Runnable()
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
  
  private void eIO()
  {
    AppMethodBeat.i(71581);
    eIQ();
    if (this.Dnj.getVisibility() != 8)
    {
      this.Dnj.setVisibility(8);
      this.Dnj.onDestroy();
    }
    if (this.Dnk.getVisibility() != 8)
    {
      this.Dnk.setVisibility(8);
      this.Dnk.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void eIP()
  {
    AppMethodBeat.i(71582);
    eIQ();
    if (this.Dnj.getVisibility() != 8)
    {
      this.Dnj.setVisibility(8);
      this.Dnj.onDestroy();
    }
    if (this.ybX.NPk != null)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.ybX.NPk.HEW) });
      switch (this.ybX.NPk.HEW)
      {
      default: 
        this.Dnk.setVisibility(8);
        this.Dnk.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.Dnk.getVisibility() != 0)
        {
          this.Dnk.setVisibility(0);
          this.Dnk.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71556);
              if (WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getHeight() != WalletSuccPageAwardWidget.this.getHeight())
              {
                FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getLayoutParams();
                localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
                localLayoutParams.height = (WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight() - com.tencent.mm.cc.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2));
                localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
              }
              AppMethodBeat.o(71556);
            }
          });
        }
        this.Dnk.destroy();
        if (!bt.isNullOrNil(this.ybX.NPk.NPb))
        {
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.ybX.NPk.NPb });
          this.Dnk.setShakeHintWording(this.ybX.NPk.NPb);
        }
        if (!bt.isNullOrNil(this.ybX.NPk.NPc)) {}
        try
        {
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.ybX.NPk.NPc });
          this.Dnk.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.ybX.NPk.NPc, true));
          if (!bt.isNullOrNil(this.ybX.NPk.NPd))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.ybX.NPk.NPd });
            this.Dnk.setAfterHintWording(this.ybX.NPk.NPd);
          }
          if (!bt.isNullOrNil(this.ybX.NPk.NPe)) {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.ybX.NPk.NPe });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.Dnk.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.ybX.NPk.NPe, true));
            this.Dnk.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void uB(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localg = com.tencent.mm.plugin.report.service.g.yhR;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localg.f(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(2131765882));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(2131100212));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71557);
                    return;
                  }
                }
                com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localg.f(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.Dnk.eIA();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.ybX.NPk.NPc, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.ybX.NPk.NPe, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.ybX.NPk.NPa;
        if (localg == null) {
          break label831;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.HcE, localg.HcF, Integer.valueOf(localg.HcG) });
        vm localvm = new vm();
        localvm.dJF.userName = localg.HcE;
        localvm.dJF.dJH = bt.bI(localg.HcF, "");
        localvm.dJF.scene = 1060;
        localvm.dJF.dkh = this.oZO;
        localvm.dJF.dJI = 0;
        if (localg.HcG > 0) {
          localvm.dJF.aDD = localg.HcG;
        }
        localvm.dJF.context = this.Dnm;
        com.tencent.mm.sdk.b.a.IbL.l(localvm);
        this.Dnn = true;
        this.Dnr = false;
        this.gIf.postDelayed(new Runnable()
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
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.ybX.NPk.url });
        e.o(this.Dnm, this.ybX.NPk.url, false);
        this.Dnn = true;
        this.Dnr = false;
        this.gIf.postDelayed(new Runnable()
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
      this.Dnj.setVisibility(8);
      this.Dnj.onDestroy();
    }
    this.Dnk.setVisibility(8);
    this.Dnk.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void eIQ()
  {
    AppMethodBeat.i(71584);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.ybX.GeV;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.Dnl = ((e.a.a.i)((List)localObject1).get(0));
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.Dnl.NPI, this.Dnl.NPJ, this.Dnl.wMR });
        this.oMB.setUrl(this.Dnl.wMR);
        if (!bt.isNullOrNil(this.Dnl.wMR)) {
          this.oMB.setVisibility(0);
        }
        if (bt.isNullOrNil(this.Dnl.NPI)) {
          break label1228;
        }
        this.fQd.setText(this.Dnl.NPI);
        this.fQd.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bt.isNullOrNil(this.Dnl.NPL)) {
          this.fQd.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.Dnl.NPL, true));
        }
        i = 1;
        if (!bt.isNullOrNil(this.Dnl.NPJ))
        {
          this.gUs.setText(this.Dnl.NPJ);
          this.gUs.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bt.isNullOrNil(this.Dnl.NPM)) {
            this.gUs.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.Dnl.NPM, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.fQd.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.gUs.getLayoutParams();
            if ((!bt.isNullOrNil(this.Dnl.NPI)) && (bt.isNullOrNil(this.Dnl.NPJ)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.fQd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.gUs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.fQd.setVisibility(0);
              this.gUs.setVisibility(8);
            }
          }
          else
          {
            if (bt.isNullOrNil(this.Dnl.NPK)) {
              continue;
            }
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.Dnl.NPK });
            localObject1 = new c.a();
            ((c.a)localObject1).idr = true;
            ((c.a)localObject1).idq = true;
            ((c.a)localObject1).hdP = aFb(this.Dnl.NPK);
            localObject1 = ((c.a)localObject1).aJc();
            q.aIJ().a(this.Dnl.NPK, null, (com.tencent.mm.aw.a.a.c)localObject1, new k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!bt.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).NPK)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).NPK.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.ar(paramAnonymousBitmap), "widget_bg");
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.Dnt);
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
            i = this.ybX.GeW;
            localObject3 = this.ybX.GeX;
            if (this.ybX.GeX == null) {
              continue;
            }
            localObject1 = this.ybX.GeX.NOX;
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.ybX.GeW != 0) && (this.ybX.GeX != null) && (!bt.isNullOrNil(this.ybX.GeX.NOX))) {
              continue;
            }
            this.sfz.setVisibility(8);
            if (this.fQd.getVisibility() == 0)
            {
              this.fQd.setSingleLine();
              this.fQd.post(new Runnable()
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
            if (this.sfz.getVisibility() != 0) {
              this.fQd.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.ybX.NPh != 0) {
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.ybX.NPh) });
            }
            if (!bt.isNullOrNil(this.ybX.NPj))
            {
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.ybX.NPj });
              if (this.Dni != null)
              {
                this.Dni.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).idr = true;
                ((c.a)localObject1).idq = true;
                ((c.a)localObject1).hdP = aFb(this.ybX.NPj);
                localObject1 = ((c.a)localObject1).aJc();
                q.aIJ().a(this.ybX.NPj, null, (com.tencent.mm.aw.a.a.c)localObject1, new k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    ad.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!bt.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).NPj)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).NPj.equals(paramAnonymousString))) {
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
          if ((bt.isNullOrNil(this.Dnl.NPI)) && (!bt.isNullOrNil(this.Dnl.NPJ)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.fQd.setLayoutParams(localException2);
            this.gUs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.fQd.setVisibility(8);
            this.gUs.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.fQd.setLayoutParams(localException2);
          this.gUs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.fQd.setVisibility(0);
          this.gUs.setVisibility(0);
          continue;
          this.Dnh.setVisibility(8);
          findViewById(2131303060).setVisibility(0);
          findViewById(2131303061).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.ybX.GeX;
          if (localObject2 == null) {
            continue;
          }
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).NOX, Integer.valueOf(((e.a.a.a)localObject2).NOZ), ((e.a.a.a)localObject2).NOY, ((e.a.a.a)localObject2).url });
          this.sfz.setText(((e.a.a.a)localObject2).NOX);
          if (!bt.isNullOrNil(((e.a.a.a)localObject2).NOY))
          {
            localObject3 = getContext().getResources().getDrawable(2131231365);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cl(((e.a.a.a)localObject2).NOY, false), PorterDuff.Mode.SRC);
            this.sfz.setBackground((Drawable)localObject3);
          }
          this.sfz.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71565);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).GeX != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).GeX);
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ != 1) {
                  break label282;
                }
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                e.o(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
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
                paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
                if (!WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {
                  break label746;
                }
              }
              label282:
              label746:
              for (int i = 2;; i = 1)
              {
                paramAnonymousView.f(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71565);
                return;
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NPa;
                  if (paramAnonymousView != null)
                  {
                    ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.HcE, paramAnonymousView.HcF, Integer.valueOf(paramAnonymousView.HcG) });
                    localObject = new vm();
                    ((vm)localObject).dJF.userName = paramAnonymousView.HcE;
                    ((vm)localObject).dJF.dJH = bt.bI(paramAnonymousView.HcF, "");
                    ((vm)localObject).dJF.scene = 1060;
                    ((vm)localObject).dJF.dkh = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    ((vm)localObject).dJF.dJI = 0;
                    if (paramAnonymousView.HcG > 0) {
                      ((vm)localObject).dJF.aDD = paramAnonymousView.HcG;
                    }
                    ((vm)localObject).dJF.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 3)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 5)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 6)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 7)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).NOZ != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
              }
            }
          });
          this.sfz.setVisibility(0);
          if ((!this.yuo) && (!this.Dnn)) {
            continue;
          }
          localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
          if (!this.Dnn) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject2).f(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1228:
      i = 0;
    }
  }
  
  private void eIR()
  {
    AppMethodBeat.i(71585);
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.Dnn) });
    if (this.Dnn)
    {
      o localo = new o(this.ybX.GeU, this.COO);
      this.Dnm.doSceneProgress(localo, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.arU() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    z.jO(paramContext).inflate(2131496031, this, true);
    this.vAa = ((ViewGroup)findViewById(2131298761));
    this.oMB = ((CdnImageView)findViewById(2131301587));
    this.fQd = ((TextView)findViewById(2131302666));
    this.gUs = ((TextView)findViewById(2131299008));
    this.sfz = ((Button)findViewById(2131297631));
    this.Dnj = ((WalletScratchShakeView)findViewById(2131304365));
    this.Dnh = ((ImageView)findViewById(2131297029));
    this.Dnk = ((WalletAwardShakeAnimView)findViewById(2131304736));
    this.oMB.setRoundCorner(true);
    this.oMB.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.NPi == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.Dnn), Boolean.valueOf(paramBoolean) });
      this.Dnm = paramWalletBaseUI;
      this.ybX = paramc;
      this.COO = paramBoolean;
      this.oZO = paramString;
      this.Dni = paramImageView;
      eIK();
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
    if ((this.Dnj != null) && (this.Dnj.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.Dnj != null)
      {
        localWalletScratchShakeView = this.Dnj;
        if (localWalletScratchShakeView.DmH == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.DmH.Z(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.Dnj;
        if (localWalletScratchShakeView.DmH == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.DmH.Dnb;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.Dnj.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.vAa == null) || (bool2)) {
          break label141;
        }
        bool1 = this.vAa.dispatchTouchEvent(paramMotionEvent);
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
    if (this.Dnm != null)
    {
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.Dnm.addSceneEndListener(1859);
      this.Dnm.addSceneEndListener(2547);
      this.Dnm.addSceneEndListener(2803);
      this.Dnm.addSceneEndListener(2508);
      this.Dnm.addSceneEndListener(2529);
      this.Dnm.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.Dnm != null)
    {
      this.Dnm.removeSceneEndListener(1859);
      this.Dnm.removeSceneEndListener(2547);
      this.Dnm.removeSceneEndListener(2803);
      this.Dnm.removeSceneEndListener(2508);
      this.Dnm.removeSceneEndListener(2529);
      this.Dnm.removeSceneEndListener(2888);
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.Dno), Boolean.valueOf(this.Dnp) });
      if ((!this.Dno) && (!this.Dnp))
      {
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        if (!this.Dnn) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      ad.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new l(this.ybX.Gdt, 4, this.COO);
      this.Dnm.doSceneProgress((com.tencent.mm.al.n)localObject, false);
      if (this.Dnj != null) {
        this.Dnj.onDestroy();
      }
      if (this.Dnk != null) {
        this.Dnk.destroy();
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
    ad.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.Dnn), b(this.ybX), Boolean.valueOf(this.Dnr) });
    if (!this.Dnr)
    {
      this.Dnr = true;
      eIM();
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
        paramString = paramString.COT;
        if (paramString == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.ozR), paramString.ozS, paramString.Gvd, paramString.CZq });
        if (paramString.ozR == 0)
        {
          if (!bt.isNullOrNil(paramString.Gvd))
          {
            Toast.makeText(getContext(), paramString.Gvd, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.CZq != null)
          {
            if (this.ybX.GeX != null)
            {
              paramInt1 = this.ybX.GeX.NOZ;
              this.ybX = paramString.CZq;
              if ((paramString.CZq.GeX != null) && (this.ybX.GeX != null))
              {
                ad.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.CZq.GeX.NOZ) });
                if (paramString.CZq.GeX.NOZ == 4)
                {
                  ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.ybX.GeX.NOZ = paramInt1;
                }
              }
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              eIK();
            }
          }
          else
          {
            if ((this.Dnq != null) && (this.Dnp))
            {
              if (this.Dnq.NOZ != 8) {
                break label375;
              }
              ad.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              e.o(this.Dnm, this.Dnq.url, false);
              this.Dnn = true;
            }
            label357:
            this.Dnq = null;
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
        if (this.Dnq.NOZ != 9) {
          break label357;
        }
        paramString = this.Dnq.NPa;
        if (paramString == null) {
          break label357;
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.HcE, paramString.HcF, Integer.valueOf(paramString.HcG) });
        paramn = new vm();
        paramn.dJF.userName = paramString.HcE;
        paramn.dJF.dJH = bt.bI(paramString.HcF, "");
        paramn.dJF.scene = 1060;
        paramn.dJF.dkh = this.oZO;
        paramn.dJF.dJI = 0;
        if (paramString.HcG > 0) {
          paramn.dJF.aDD = paramString.HcG;
        }
        paramn.dJF.context = this.Dnm;
        com.tencent.mm.sdk.b.a.IbL.l(paramn);
        this.Dnn = true;
        this.Dnr = false;
        this.gIf.postDelayed(new Runnable()
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
        eIL();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.COV;
        if (paramString == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.ozR;
        paramn = paramString.ozS;
        localObject1 = paramString.GeV;
        i = paramString.GeW;
        localObject2 = paramString.GeX;
        if (paramString.GeX == null) {
          break label881;
        }
        paramInt1 = paramString.GeX.NOZ;
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramn, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.ozR == 0)
        {
          this.ybX.GeV = paramString.GeV;
          this.ybX.GeW = paramString.GeW;
          if (this.ybX.GeX == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.ybX.GeX.NOZ;; paramInt1 = 0)
      {
        if (paramString.GeX != null)
        {
          this.ybX.GeX = paramString.GeX;
          if ((this.ybX.GeX != null) && (paramString.GeX.NOZ == 4))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.ybX.GeX.NOZ = paramInt1;
          }
        }
        ad.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.ybX) });
        eIQ();
        this.Dnn = false;
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
        paramn = paramString.CON;
        if (paramn == null)
        {
          ad.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramn.ozR;
        localObject1 = paramn.ozS;
        localObject2 = paramn.CZq;
        if (paramn.CZq != null)
        {
          paramString = paramn.CZq.GeV;
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramn.CZq == null) || (paramn.CZq.GeV == null) || (paramn.CZq.GeV.size() <= 0)) {
            break label1222;
          }
          paramString = paramn.CZq;
          localObject1 = paramn.CZq.GeX;
          if (paramn.CZq.GeX == null) {
            break label1217;
          }
          paramInt1 = paramn.CZq.GeX.NOZ;
          label1082:
          ad.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.ybX.GeX != null) {
            paramInt1 = this.ybX.GeX.NOZ;
          }
          this.ybX = paramn.CZq;
          if ((this.ybX.GeX != null) && (paramn.CZq.GeX != null) && (paramn.CZq.GeX.NOZ == 4))
          {
            ad.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.ybX.GeX.NOZ = paramInt1;
          }
          eIK();
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
        eIL();
        continue;
        eIL();
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