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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
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
  private ImageView DEL;
  private ImageView DEM;
  private WalletScratchShakeView DEN;
  private WalletAwardShakeAnimView DEO;
  private i DEP;
  private WalletBaseUI DEQ;
  private boolean DER;
  private boolean DES;
  private boolean DET;
  private e.a.a.a DEU;
  private boolean DEW;
  private boolean Dgt;
  private TextView fSj;
  private aq gKO;
  private TextView gXb;
  private CdnImageView oTd;
  private String pgs;
  private Button sos;
  private ViewGroup vMe;
  private boolean yKp;
  private e.a.a.c yrO;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.DER = false;
    this.DES = false;
    this.yKp = true;
    this.DET = false;
    this.DEU = null;
    this.gKO = new aq(Looper.getMainLooper());
    this.DEW = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.DER = false;
    this.DES = false;
    this.yKp = true;
    this.DET = false;
    this.DEU = null;
    this.gKO = new aq(Looper.getMainLooper());
    this.DEW = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.GxD != null) && (paramc.GxD.size() > 0)) || (paramc.Omq != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private String aGv(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!bu.V(new String[0]))
    {
      com.tencent.mm.vfs.o.aZI(getAccImagesPath());
      String str = getAccImagesPath() + d.getMessageDigest(paramString.getBytes());
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
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
        if ((paramc.GxD != null) && (paramc.GxD.size() > 0))
        {
          localObject2 = paramc.GxD.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i locali = (i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.xcF);
            localJSONObject2.put("award_name", locali.OmO);
            localJSONObject2.put("award_description", locali.OmP);
            localJSONObject2.put("background_img", locali.OmQ);
            localJSONObject2.put("award_name_color", locali.OmR);
            localJSONObject2.put("award_description_color", locali.OmS);
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
      localJSONObject1.put("is_query_others", paramc.Oml);
      localJSONObject1.put("draw_lottery_params", paramc.Gwa);
      localJSONObject1.put("is_show_btn", paramc.GxE);
      Object localObject1 = new JSONObject();
      if (paramc.GxF != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.GxF.Omd);
        ((JSONObject)localObject1).put("btn_color", paramc.GxF.Ome);
        ((JSONObject)localObject1).put("btn_op_type", paramc.GxF.Omf);
        ((JSONObject)localObject1).put("url", paramc.GxF.url);
        localObject2 = new JSONObject();
        if (paramc.GxF.Omg != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.GxF.Omg.Hwe);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.GxF.Omg.Hwf);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.GxF.Omg.Hwg);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.GxF.GTG);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.GxC);
      localJSONObject1.put("user_opertaion_type", paramc.Omm);
      localJSONObject1.put("is_show_layer", paramc.Omn);
      localJSONObject1.put("background_img_whole", paramc.Omp);
      if (paramc.Omq != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.Omq.Omh);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.Omq.Omi);
        ((JSONObject)localObject1).put("url", paramc.Omq.url);
        ((JSONObject)localObject1).put("op_type", paramc.Omq.HYJ);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.Omq.Omj);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.Omq.Omk);
        localObject2 = new JSONObject();
        if (paramc.Omq.Omg != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Omq.Omg.Hwe);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Omq.Omg.Hwf);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Omq.Omg.Hwg);
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
  
  private void eMs()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.yrO), Boolean.valueOf(this.yKp) });
    if (this.yrO == null)
    {
      ae.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    ae.m("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.yrO.Omm), Integer.valueOf(this.yrO.GxD.size()), Boolean.valueOf(this.DER) });
    if ((this.yrO.Omm <= 0) || (this.yrO.Omm > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.yrO))
    {
      AppMethodBeat.o(71574);
      return;
    }
    com.tencent.mm.plugin.report.service.g localg;
    if (this.yrO.Omm == 4)
    {
      eMw();
      if ((this.yKp) || (this.DER))
      {
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!this.DER) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localg.f(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.yKp = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.yrO.Omm == 1) || (this.yrO.Omm == 2) || (this.yrO.Omm == 3))
      {
        eMv();
        break;
      }
      if (this.yrO.Omm != 5) {
        break;
      }
      eMx();
      break;
      label293:
      i = 1;
    }
  }
  
  private void eMt()
  {
    AppMethodBeat.i(71575);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.fSj.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.gXb.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.fSj.setLayoutParams(localLayoutParams1);
    this.gXb.setLayoutParams(localLayoutParams2);
    this.fSj.setVisibility(0);
    this.gXb.setVisibility(8);
    this.fSj.setText(2131765881);
    this.fSj.setTextColor(getResources().getColor(2131100711));
    this.gXb.setTextColor(getResources().getColor(2131100490));
    this.DEL.setVisibility(8);
    findViewById(2131303060).setVisibility(0);
    findViewById(2131303061).setVisibility(0);
    this.sos.setVisibility(8);
    this.oTd.setVisibility(0);
    this.oTd.setImageResource(2131234696);
    this.DEN.setVisibility(8);
    this.DEN.onDestroy();
    this.DEO.setVisibility(8);
    this.DEO.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void eMu()
  {
    AppMethodBeat.i(71579);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.yrO.Omq != null) && (this.yrO.Omq.HYJ != 1))
    {
      this.DEN.setVisibility(8);
      this.DEN.onDestroy();
      this.DEO.setVisibility(8);
      this.DEO.destroy();
    }
    eMz();
    AppMethodBeat.o(71579);
  }
  
  private void eMv()
  {
    AppMethodBeat.i(71580);
    eMy();
    if (this.DEO.getVisibility() != 8)
    {
      this.DEO.setVisibility(8);
      this.DEO.destroy();
    }
    if (this.DEN.getVisibility() != 0)
    {
      this.DEN.setVisibility(0);
      this.DEN.post(new Runnable()
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
  
  private void eMw()
  {
    AppMethodBeat.i(71581);
    eMy();
    if (this.DEN.getVisibility() != 8)
    {
      this.DEN.setVisibility(8);
      this.DEN.onDestroy();
    }
    if (this.DEO.getVisibility() != 8)
    {
      this.DEO.setVisibility(8);
      this.DEO.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void eMx()
  {
    AppMethodBeat.i(71582);
    eMy();
    if (this.DEN.getVisibility() != 8)
    {
      this.DEN.setVisibility(8);
      this.DEN.onDestroy();
    }
    if (this.yrO.Omq != null)
    {
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.yrO.Omq.HYJ) });
      switch (this.yrO.Omq.HYJ)
      {
      default: 
        this.DEO.setVisibility(8);
        this.DEO.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.DEO.getVisibility() != 0)
        {
          this.DEO.setVisibility(0);
          this.DEO.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71556);
              if (WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getHeight() != WalletSuccPageAwardWidget.this.getHeight())
              {
                FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).getLayoutParams();
                localLayoutParams.width = WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getWidth();
                localLayoutParams.height = (WalletSuccPageAwardWidget.b(WalletSuccPageAwardWidget.this).getHeight() - com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2));
                localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setLayoutParams(localLayoutParams);
              }
              AppMethodBeat.o(71556);
            }
          });
        }
        this.DEO.destroy();
        if (!bu.isNullOrNil(this.yrO.Omq.Omh))
        {
          ae.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.yrO.Omq.Omh });
          this.DEO.setShakeHintWording(this.yrO.Omq.Omh);
        }
        if (!bu.isNullOrNil(this.yrO.Omq.Omi)) {}
        try
        {
          ae.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.yrO.Omq.Omi });
          this.DEO.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yrO.Omq.Omi, true));
          if (!bu.isNullOrNil(this.yrO.Omq.Omj))
          {
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.yrO.Omq.Omj });
            this.DEO.setAfterHintWording(this.yrO.Omq.Omj);
          }
          if (!bu.isNullOrNil(this.yrO.Omq.Omk)) {
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.yrO.Omq.Omk });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.DEO.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yrO.Omq.Omk, true));
            this.DEO.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void uJ(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                ae.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localg = com.tencent.mm.plugin.report.service.g.yxI;
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
                com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localg.f(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.DEO.eMi();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            ae.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.yrO.Omq.Omi, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.yrO.Omq.Omk, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.yrO.Omq.Omg;
        if (localg == null) {
          break label831;
        }
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.Hwe, localg.Hwf, Integer.valueOf(localg.Hwg) });
        vq localvq = new vq();
        localvq.dKT.userName = localg.Hwe;
        localvq.dKT.dKV = bu.bI(localg.Hwf, "");
        localvq.dKT.scene = 1060;
        localvq.dKT.dlj = this.pgs;
        localvq.dKT.dKW = 0;
        if (localg.Hwg > 0) {
          localvq.dKT.aDD = localg.Hwg;
        }
        localvq.dKT.context = this.DEQ;
        com.tencent.mm.sdk.b.a.IvT.l(localvq);
        this.DER = true;
        this.DEW = false;
        this.gKO.postDelayed(new Runnable()
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
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.yrO.Omq.url });
        f.p(this.DEQ, this.yrO.Omq.url, false);
        this.DER = true;
        this.DEW = false;
        this.gKO.postDelayed(new Runnable()
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
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.DEN.setVisibility(8);
      this.DEN.onDestroy();
    }
    this.DEO.setVisibility(8);
    this.DEO.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void eMy()
  {
    AppMethodBeat.i(71584);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.yrO.GxD;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.DEP = ((i)((List)localObject1).get(0));
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.DEP.OmO, this.DEP.OmP, this.DEP.xcF });
        this.oTd.setUrl(this.DEP.xcF);
        if (!bu.isNullOrNil(this.DEP.xcF)) {
          this.oTd.setVisibility(0);
        }
        if (bu.isNullOrNil(this.DEP.OmO)) {
          break label1228;
        }
        this.fSj.setText(this.DEP.OmO);
        this.fSj.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bu.isNullOrNil(this.DEP.OmR)) {
          this.fSj.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.DEP.OmR, true));
        }
        i = 1;
        if (!bu.isNullOrNil(this.DEP.OmP))
        {
          this.gXb.setText(this.DEP.OmP);
          this.gXb.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bu.isNullOrNil(this.DEP.OmS)) {
            this.gXb.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.DEP.OmS, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.fSj.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.gXb.getLayoutParams();
            if ((!bu.isNullOrNil(this.DEP.OmO)) && (bu.isNullOrNil(this.DEP.OmP)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.fSj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.gXb.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.fSj.setVisibility(0);
              this.gXb.setVisibility(8);
            }
          }
          else
          {
            if (bu.isNullOrNil(this.DEP.OmQ)) {
              continue;
            }
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.DEP.OmQ });
            localObject1 = new c.a();
            ((c.a)localObject1).igk = true;
            ((c.a)localObject1).igj = true;
            ((c.a)localObject1).hgD = aGv(this.DEP.OmQ);
            localObject1 = ((c.a)localObject1).aJu();
            q.aJb().a(this.DEP.OmQ, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                ae.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!bu.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).OmQ)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).OmQ.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.as(paramAnonymousBitmap), "widget_bg");
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.DEY);
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
            i = this.yrO.GxE;
            localObject3 = this.yrO.GxF;
            if (this.yrO.GxF == null) {
              continue;
            }
            localObject1 = this.yrO.GxF.Omd;
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.yrO.GxE != 0) && (this.yrO.GxF != null) && (!bu.isNullOrNil(this.yrO.GxF.Omd))) {
              continue;
            }
            this.sos.setVisibility(8);
            if (this.fSj.getVisibility() == 0)
            {
              this.fSj.setSingleLine();
              this.fSj.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71566);
                  try
                  {
                    if ((WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() > 0) && (WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() > 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() >= WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) && (!bu.ah(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText())))
                    {
                      float f = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getTextSize();
                      ae.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) });
                      Object localObject = new Paint();
                      ((Paint)localObject).setTextSize(f);
                      String str2 = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText().toString();
                      f = WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() - WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getLeft();
                      int i = 1;
                      while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                        i += 1;
                      }
                      ae.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                    ae.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
                    AppMethodBeat.o(71566);
                  }
                }
              });
            }
            if (this.sos.getVisibility() != 0) {
              this.fSj.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.yrO.Omn != 0) {
              ae.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.yrO.Omn) });
            }
            if (!bu.isNullOrNil(this.yrO.Omp))
            {
              ae.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.yrO.Omp });
              if (this.DEM != null)
              {
                this.DEM.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).igk = true;
                ((c.a)localObject1).igj = true;
                ((c.a)localObject1).hgD = aGv(this.yrO.Omp);
                localObject1 = ((c.a)localObject1).aJu();
                q.aJb().a(this.yrO.Omp, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    ae.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!bu.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Omp)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Omp.equals(paramAnonymousString))) {
                      ar.f(new Runnable()
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
            ae.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          ae.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((bu.isNullOrNil(this.DEP.OmO)) && (!bu.isNullOrNil(this.DEP.OmP)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.fSj.setLayoutParams(localException2);
            this.gXb.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.fSj.setVisibility(8);
            this.gXb.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.fSj.setLayoutParams(localException2);
          this.gXb.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.fSj.setVisibility(0);
          this.gXb.setVisibility(0);
          continue;
          this.DEL.setVisibility(8);
          findViewById(2131303060).setVisibility(0);
          findViewById(2131303061).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.yrO.GxF;
          if (localObject2 == null) {
            continue;
          }
          ae.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).Omd, Integer.valueOf(((e.a.a.a)localObject2).Omf), ((e.a.a.a)localObject2).Ome, ((e.a.a.a)localObject2).url });
          this.sos.setText(((e.a.a.a)localObject2).Omd);
          if (!bu.isNullOrNil(((e.a.a.a)localObject2).Ome))
          {
            localObject3 = getContext().getResources().getDrawable(2131231365);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cp(((e.a.a.a)localObject2).Ome, false), PorterDuff.Mode.SRC);
            this.sos.setBackground((Drawable)localObject3);
          }
          this.sos.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71565);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).GxF != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).GxF);
                ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf != 1) {
                  break label282;
                }
                ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                f.p(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
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
                paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omg;
                  if (paramAnonymousView != null)
                  {
                    ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.Hwe, paramAnonymousView.Hwf, Integer.valueOf(paramAnonymousView.Hwg) });
                    localObject = new vq();
                    ((vq)localObject).dKT.userName = paramAnonymousView.Hwe;
                    ((vq)localObject).dKT.dKV = bu.bI(paramAnonymousView.Hwf, "");
                    ((vq)localObject).dKT.scene = 1060;
                    ((vq)localObject).dKT.dlj = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    ((vq)localObject).dKT.dKW = 0;
                    if (paramAnonymousView.Hwg > 0) {
                      ((vq)localObject).dKT.aDD = paramAnonymousView.Hwg;
                    }
                    ((vq)localObject).dKT.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 3)
                {
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 5)
                {
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 6)
                {
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 7)
                {
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Omf != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
              }
            }
          });
          this.sos.setVisibility(0);
          if ((!this.yKp) && (!this.DER)) {
            continue;
          }
          localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
          if (!this.DER) {}
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
  
  private void eMz()
  {
    AppMethodBeat.i(71585);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.DER) });
    if (this.DER)
    {
      com.tencent.mm.plugin.wallet_core.c.o localo = new com.tencent.mm.plugin.wallet_core.c.o(this.yrO.GxC, this.Dgt);
      this.DEQ.doSceneProgress(localo, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.asj() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    z.jV(paramContext).inflate(2131496031, this, true);
    this.vMe = ((ViewGroup)findViewById(2131298761));
    this.oTd = ((CdnImageView)findViewById(2131301587));
    this.fSj = ((TextView)findViewById(2131302666));
    this.gXb = ((TextView)findViewById(2131299008));
    this.sos = ((Button)findViewById(2131297631));
    this.DEN = ((WalletScratchShakeView)findViewById(2131304365));
    this.DEL = ((ImageView)findViewById(2131297029));
    this.DEO = ((WalletAwardShakeAnimView)findViewById(2131304736));
    this.oTd.setRoundCorner(true);
    this.oTd.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.Omo == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.DER), Boolean.valueOf(paramBoolean) });
      this.DEQ = paramWalletBaseUI;
      this.yrO = paramc;
      this.Dgt = paramBoolean;
      this.pgs = paramString;
      this.DEM = paramImageView;
      eMs();
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
    if ((this.DEN != null) && (this.DEN.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.DEN != null)
      {
        localWalletScratchShakeView = this.DEN;
        if (localWalletScratchShakeView.DEl == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.DEl.X(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.DEN;
        if (localWalletScratchShakeView.DEl == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.DEl.DEF;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.DEN.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.vMe == null) || (bool2)) {
          break label141;
        }
        bool1 = this.vMe.dispatchTouchEvent(paramMotionEvent);
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
    if (this.DEQ != null)
    {
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.DEQ.addSceneEndListener(1859);
      this.DEQ.addSceneEndListener(2547);
      this.DEQ.addSceneEndListener(2803);
      this.DEQ.addSceneEndListener(2508);
      this.DEQ.addSceneEndListener(2529);
      this.DEQ.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.DEQ != null)
    {
      this.DEQ.removeSceneEndListener(1859);
      this.DEQ.removeSceneEndListener(2547);
      this.DEQ.removeSceneEndListener(2803);
      this.DEQ.removeSceneEndListener(2508);
      this.DEQ.removeSceneEndListener(2529);
      this.DEQ.removeSceneEndListener(2888);
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.DES), Boolean.valueOf(this.DET) });
      if ((!this.DES) && (!this.DET))
      {
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (!this.DER) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      ae.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new l(this.yrO.Gwa, 4, this.Dgt);
      this.DEQ.doSceneProgress((com.tencent.mm.ak.n)localObject, false);
      if (this.DEN != null) {
        this.DEN.onDestroy();
      }
      if (this.DEO != null) {
        this.DEO.destroy();
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
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.DER), b(this.yrO), Boolean.valueOf(this.DEW) });
    if (!this.DEW)
    {
      this.DEW = true;
      eMu();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    ae.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.n))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.Dgx;
        if (paramString == null)
        {
          ae.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.oGt), paramString.oGu, paramString.GOC, paramString.DqV });
        if (paramString.oGt == 0)
        {
          if (!bu.isNullOrNil(paramString.GOC))
          {
            Toast.makeText(getContext(), paramString.GOC, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.DqV != null)
          {
            if (this.yrO.GxF != null)
            {
              paramInt1 = this.yrO.GxF.Omf;
              this.yrO = paramString.DqV;
              if ((paramString.DqV.GxF != null) && (this.yrO.GxF != null))
              {
                ae.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.DqV.GxF.Omf) });
                if (paramString.DqV.GxF.Omf == 4)
                {
                  ae.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.yrO.GxF.Omf = paramInt1;
                }
              }
              ae.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              eMs();
            }
          }
          else
          {
            if ((this.DEU != null) && (this.DET))
            {
              if (this.DEU.Omf != 8) {
                break label375;
              }
              ae.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              f.p(this.DEQ, this.DEU.url, false);
              this.DER = true;
            }
            label357:
            this.DEU = null;
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
        if (this.DEU.Omf != 9) {
          break label357;
        }
        paramString = this.DEU.Omg;
        if (paramString == null) {
          break label357;
        }
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.Hwe, paramString.Hwf, Integer.valueOf(paramString.Hwg) });
        paramn = new vq();
        paramn.dKT.userName = paramString.Hwe;
        paramn.dKT.dKV = bu.bI(paramString.Hwf, "");
        paramn.dKT.scene = 1060;
        paramn.dKT.dlj = this.pgs;
        paramn.dKT.dKW = 0;
        if (paramString.Hwg > 0) {
          paramn.dKT.aDD = paramString.Hwg;
        }
        paramn.dKT.context = this.DEQ;
        com.tencent.mm.sdk.b.a.IvT.l(paramn);
        this.DER = true;
        this.DEW = false;
        this.gKO.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71555);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71555);
          }
        }, 3000L);
        break label357;
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        eMt();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.o))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.Dgz;
        if (paramString == null)
        {
          ae.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.oGt;
        paramn = paramString.oGu;
        localObject1 = paramString.GxD;
        i = paramString.GxE;
        localObject2 = paramString.GxF;
        if (paramString.GxF == null) {
          break label881;
        }
        paramInt1 = paramString.GxF.Omf;
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramn, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.oGt == 0)
        {
          this.yrO.GxD = paramString.GxD;
          this.yrO.GxE = paramString.GxE;
          if (this.yrO.GxF == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.yrO.GxF.Omf;; paramInt1 = 0)
      {
        if (paramString.GxF != null)
        {
          this.yrO.GxF = paramString.GxF;
          if ((this.yrO.GxF != null) && (paramString.GxF.Omf == 4))
          {
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.yrO.GxF.Omf = paramInt1;
          }
        }
        ae.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.yrO) });
        eMy();
        this.DER = false;
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
        paramn = paramString.Dgs;
        if (paramn == null)
        {
          ae.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramn.oGt;
        localObject1 = paramn.oGu;
        localObject2 = paramn.DqV;
        if (paramn.DqV != null)
        {
          paramString = paramn.DqV.GxD;
          ae.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramn.DqV == null) || (paramn.DqV.GxD == null) || (paramn.DqV.GxD.size() <= 0)) {
            break label1222;
          }
          paramString = paramn.DqV;
          localObject1 = paramn.DqV.GxF;
          if (paramn.DqV.GxF == null) {
            break label1217;
          }
          paramInt1 = paramn.DqV.GxF.Omf;
          label1082:
          ae.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.yrO.GxF != null) {
            paramInt1 = this.yrO.GxF.Omf;
          }
          this.yrO = paramn.DqV;
          if ((this.yrO.GxF != null) && (paramn.DqV.GxF != null) && (paramn.DqV.GxF.Omf == 4))
          {
            ae.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.yrO.GxF.Omf = paramInt1;
          }
          eMs();
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
        eMt();
        continue;
        eMt();
      }
    }
    AppMethodBeat.o(71586);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget
 * JD-Core Version:    0.7.0.1
 */