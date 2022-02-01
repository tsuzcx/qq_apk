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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ImageView BMP;
  private ImageView BMQ;
  private WalletScratchShakeView BMR;
  private WalletAwardShakeAnimView BMS;
  private e.a.a.i BMT;
  private WalletBaseUI BMU;
  private boolean BMV;
  private boolean BMW;
  private boolean BMX;
  private e.a.a.a BMY;
  private boolean BMZ;
  private boolean Boz;
  private TextView fwQ;
  private TextView gAI;
  private ao gox;
  private Button nyO;
  private CdnImageView ojf;
  private String owt;
  private ViewGroup uxx;
  private e.a.a.c wOp;
  private boolean xgn;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.BMV = false;
    this.BMW = false;
    this.xgn = true;
    this.BMX = false;
    this.BMY = null;
    this.gox = new ao(Looper.getMainLooper());
    this.BMZ = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.BMV = false;
    this.BMW = false;
    this.xgn = true;
    this.BMX = false;
    this.BMY = null;
    this.gox = new ao(Looper.getMainLooper());
    this.BMZ = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.Exs != null) && (paramc.Exs.size() > 0)) || (paramc.LUL != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private String azR(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!bs.T(new String[0]))
    {
      com.tencent.mm.vfs.i.aSh(getAccImagesPath());
      String str = getAccImagesPath() + d.getMessageDigest(paramString.getBytes());
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
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
        if ((paramc.Exs != null) && (paramc.Exs.size() > 0))
        {
          localObject2 = paramc.Exs.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            e.a.a.i locali = (e.a.a.i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.vFL);
            localJSONObject2.put("award_name", locali.LVj);
            localJSONObject2.put("award_description", locali.LVk);
            localJSONObject2.put("background_img", locali.LVl);
            localJSONObject2.put("award_name_color", locali.LVm);
            localJSONObject2.put("award_description_color", locali.LVn);
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
      localJSONObject1.put("is_query_others", paramc.LUG);
      localJSONObject1.put("draw_lottery_params", paramc.EvX);
      localJSONObject1.put("is_show_btn", paramc.Ext);
      Object localObject1 = new JSONObject();
      if (paramc.Exu != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.Exu.LUy);
        ((JSONObject)localObject1).put("btn_color", paramc.Exu.LUz);
        ((JSONObject)localObject1).put("btn_op_type", paramc.Exu.LUA);
        ((JSONObject)localObject1).put("url", paramc.Exu.url);
        localObject2 = new JSONObject();
        if (paramc.Exu.LUB != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Exu.LUB.Fsx);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Exu.LUB.Fsy);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Exu.LUB.Fsz);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.Exu.EQP);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.Exr);
      localJSONObject1.put("user_opertaion_type", paramc.LUH);
      localJSONObject1.put("is_show_layer", paramc.LUI);
      localJSONObject1.put("background_img_whole", paramc.LUK);
      if (paramc.LUL != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.LUL.LUC);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.LUL.LUD);
        ((JSONObject)localObject1).put("url", paramc.LUL.url);
        ((JSONObject)localObject1).put("op_type", paramc.LUL.FUi);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.LUL.LUE);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.LUL.LUF);
        localObject2 = new JSONObject();
        if (paramc.LUL.LUB != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.LUL.LUB.Fsx);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.LUL.LUB.Fsy);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.LUL.LUB.Fsz);
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
  
  private void euE()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.wOp), Boolean.valueOf(this.xgn) });
    if (this.wOp == null)
    {
      ac.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    ac.m("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.wOp.LUH), Integer.valueOf(this.wOp.Exs.size()), Boolean.valueOf(this.BMV) });
    if ((this.wOp.LUH <= 0) || (this.wOp.LUH > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.wOp))
    {
      AppMethodBeat.o(71574);
      return;
    }
    h localh;
    if (this.wOp.LUH == 4)
    {
      euI();
      if ((this.xgn) || (this.BMV))
      {
        localh = h.wUl;
        if (!this.BMV) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.f(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.xgn = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.wOp.LUH == 1) || (this.wOp.LUH == 2) || (this.wOp.LUH == 3))
      {
        euH();
        break;
      }
      if (this.wOp.LUH != 5) {
        break;
      }
      euJ();
      break;
      label293:
      i = 1;
    }
  }
  
  private void euF()
  {
    AppMethodBeat.i(71575);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.fwQ.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.gAI.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.fwQ.setLayoutParams(localLayoutParams1);
    this.gAI.setLayoutParams(localLayoutParams2);
    this.fwQ.setVisibility(0);
    this.gAI.setVisibility(8);
    this.fwQ.setText(2131765881);
    this.fwQ.setTextColor(getResources().getColor(2131100711));
    this.gAI.setTextColor(getResources().getColor(2131100490));
    this.BMP.setVisibility(8);
    findViewById(2131303060).setVisibility(0);
    findViewById(2131303061).setVisibility(0);
    this.nyO.setVisibility(8);
    this.ojf.setVisibility(0);
    this.ojf.setImageResource(2131234696);
    this.BMR.setVisibility(8);
    this.BMR.onDestroy();
    this.BMS.setVisibility(8);
    this.BMS.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void euG()
  {
    AppMethodBeat.i(71579);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.wOp.LUL != null) && (this.wOp.LUL.FUi != 1))
    {
      this.BMR.setVisibility(8);
      this.BMR.onDestroy();
      this.BMS.setVisibility(8);
      this.BMS.destroy();
    }
    euL();
    AppMethodBeat.o(71579);
  }
  
  private void euH()
  {
    AppMethodBeat.i(71580);
    euK();
    if (this.BMS.getVisibility() != 8)
    {
      this.BMS.setVisibility(8);
      this.BMS.destroy();
    }
    if (this.BMR.getVisibility() != 0)
    {
      this.BMR.setVisibility(0);
      this.BMR.post(new Runnable()
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
  
  private void euI()
  {
    AppMethodBeat.i(71581);
    euK();
    if (this.BMR.getVisibility() != 8)
    {
      this.BMR.setVisibility(8);
      this.BMR.onDestroy();
    }
    if (this.BMS.getVisibility() != 8)
    {
      this.BMS.setVisibility(8);
      this.BMS.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void euJ()
  {
    AppMethodBeat.i(71582);
    euK();
    if (this.BMR.getVisibility() != 8)
    {
      this.BMR.setVisibility(8);
      this.BMR.onDestroy();
    }
    if (this.wOp.LUL != null)
    {
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.wOp.LUL.FUi) });
      switch (this.wOp.LUL.FUi)
      {
      default: 
        this.BMS.setVisibility(8);
        this.BMS.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.BMS.getVisibility() != 0)
        {
          this.BMS.setVisibility(0);
          this.BMS.post(new Runnable()
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
        this.BMS.destroy();
        if (!bs.isNullOrNil(this.wOp.LUL.LUC))
        {
          ac.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.wOp.LUL.LUC });
          this.BMS.setShakeHintWording(this.wOp.LUL.LUC);
        }
        if (!bs.isNullOrNil(this.wOp.LUL.LUD)) {}
        try
        {
          ac.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.wOp.LUL.LUD });
          this.BMS.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wOp.LUL.LUD, true));
          if (!bs.isNullOrNil(this.wOp.LUL.LUE))
          {
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.wOp.LUL.LUE });
            this.BMS.setAfterHintWording(this.wOp.LUL.LUE);
          }
          if (!bs.isNullOrNil(this.wOp.LUL.LUF)) {
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.wOp.LUL.LUF });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.BMS.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wOp.LUL.LUF, true));
            this.BMS.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void tR(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                ac.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.wUl;
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
                h localh = h.wUl;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.f(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.BMS.euu();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            ac.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.wOp.LUL.LUD, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.wOp.LUL.LUF, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.wOp.LUL.LUB;
        if (localg == null) {
          break label831;
        }
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.Fsx, localg.Fsy, Integer.valueOf(localg.Fsz) });
        ut localut = new ut();
        localut.dxt.userName = localg.Fsx;
        localut.dxt.dxv = bs.bG(localg.Fsy, "");
        localut.dxt.scene = 1060;
        localut.dxt.cYP = this.owt;
        localut.dxt.dxw = 0;
        if (localg.Fsz > 0) {
          localut.dxt.aBM = localg.Fsz;
        }
        localut.dxt.context = this.BMU;
        com.tencent.mm.sdk.b.a.GpY.l(localut);
        this.BMV = true;
        this.BMZ = false;
        this.gox.postDelayed(new Runnable()
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
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.wOp.LUL.url });
        e.o(this.BMU, this.wOp.LUL.url, false);
        this.BMV = true;
        this.BMZ = false;
        this.gox.postDelayed(new Runnable()
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
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.BMR.setVisibility(8);
      this.BMR.onDestroy();
    }
    this.BMS.setVisibility(8);
    this.BMS.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void euK()
  {
    AppMethodBeat.i(71584);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.wOp.Exs;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.BMT = ((e.a.a.i)((List)localObject1).get(0));
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.BMT.LVj, this.BMT.LVk, this.BMT.vFL });
        this.ojf.setUrl(this.BMT.vFL);
        if (!bs.isNullOrNil(this.BMT.vFL)) {
          this.ojf.setVisibility(0);
        }
        if (bs.isNullOrNil(this.BMT.LVj)) {
          break label1228;
        }
        this.fwQ.setText(this.BMT.LVj);
        this.fwQ.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bs.isNullOrNil(this.BMT.LVm)) {
          this.fwQ.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.BMT.LVm, true));
        }
        i = 1;
        if (!bs.isNullOrNil(this.BMT.LVk))
        {
          this.gAI.setText(this.BMT.LVk);
          this.gAI.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bs.isNullOrNil(this.BMT.LVn)) {
            this.gAI.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.BMT.LVn, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.fwQ.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.gAI.getLayoutParams();
            if ((!bs.isNullOrNil(this.BMT.LVj)) && (bs.isNullOrNil(this.BMT.LVk)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.fwQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.gAI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.fwQ.setVisibility(0);
              this.gAI.setVisibility(8);
            }
          }
          else
          {
            if (bs.isNullOrNil(this.BMT.LVl)) {
              continue;
            }
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.BMT.LVl });
            localObject1 = new c.a();
            ((c.a)localObject1).hKx = true;
            ((c.a)localObject1).hKw = true;
            ((c.a)localObject1).gKe = azR(this.BMT.LVl);
            localObject1 = ((c.a)localObject1).aFT();
            com.tencent.mm.av.o.aFB().a(this.BMT.LVl, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                ac.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!bs.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).LVl)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).LVl.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.ap(paramAnonymousBitmap), "widget_bg");
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.BNb);
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
            i = this.wOp.Ext;
            localObject3 = this.wOp.Exu;
            if (this.wOp.Exu == null) {
              continue;
            }
            localObject1 = this.wOp.Exu.LUy;
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.wOp.Ext != 0) && (this.wOp.Exu != null) && (!bs.isNullOrNil(this.wOp.Exu.LUy))) {
              continue;
            }
            this.nyO.setVisibility(8);
            if (this.fwQ.getVisibility() == 0)
            {
              this.fwQ.setSingleLine();
              this.fwQ.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71566);
                  try
                  {
                    if ((WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() > 0) && (WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() > 0) && (WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight() >= WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) && (!bs.aj(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText())))
                    {
                      float f = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getTextSize();
                      ac.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft()) });
                      Object localObject = new Paint();
                      ((Paint)localObject).setTextSize(f);
                      String str2 = WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getText().toString();
                      f = WalletSuccPageAwardWidget.s(WalletSuccPageAwardWidget.this).getLeft() - WalletSuccPageAwardWidget.t(WalletSuccPageAwardWidget.this).getLeft();
                      int i = 1;
                      while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
                        i += 1;
                      }
                      ac.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
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
                    ac.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
                    AppMethodBeat.o(71566);
                  }
                }
              });
            }
            if (this.nyO.getVisibility() != 0) {
              this.fwQ.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.wOp.LUI != 0) {
              ac.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.wOp.LUI) });
            }
            if (!bs.isNullOrNil(this.wOp.LUK))
            {
              ac.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.wOp.LUK });
              if (this.BMQ != null)
              {
                this.BMQ.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).hKx = true;
                ((c.a)localObject1).hKw = true;
                ((c.a)localObject1).gKe = azR(this.wOp.LUK);
                localObject1 = ((c.a)localObject1).aFT();
                com.tencent.mm.av.o.aFB().a(this.wOp.LUK, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    ac.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!bs.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).LUK)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).LUK.equals(paramAnonymousString))) {
                      ap.f(new Runnable()
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
            ac.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          ac.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((bs.isNullOrNil(this.BMT.LVj)) && (!bs.isNullOrNil(this.BMT.LVk)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.fwQ.setLayoutParams(localException2);
            this.gAI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.fwQ.setVisibility(8);
            this.gAI.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.fwQ.setLayoutParams(localException2);
          this.gAI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.fwQ.setVisibility(0);
          this.gAI.setVisibility(0);
          continue;
          this.BMP.setVisibility(8);
          findViewById(2131303060).setVisibility(0);
          findViewById(2131303061).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.wOp.Exu;
          if (localObject2 == null) {
            continue;
          }
          ac.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).LUy, Integer.valueOf(((e.a.a.a)localObject2).LUA), ((e.a.a.a)localObject2).LUz, ((e.a.a.a)localObject2).url });
          this.nyO.setText(((e.a.a.a)localObject2).LUy);
          if (!bs.isNullOrNil(((e.a.a.a)localObject2).LUz))
          {
            localObject3 = getContext().getResources().getDrawable(2131231365);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cd(((e.a.a.a)localObject2).LUz, false), PorterDuff.Mode.SRC);
            this.nyO.setBackground((Drawable)localObject3);
          }
          this.nyO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              int i = 2;
              AppMethodBeat.i(71565);
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Exu != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Exu);
                ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA != 1) {
                  break label241;
                }
                ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
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
                paramAnonymousView = h.wUl;
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUB;
                  if (paramAnonymousView != null)
                  {
                    ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.Fsx, paramAnonymousView.Fsy, Integer.valueOf(paramAnonymousView.Fsz) });
                    ut localut = new ut();
                    localut.dxt.userName = paramAnonymousView.Fsx;
                    localut.dxt.dxv = bs.bG(paramAnonymousView.Fsy, "");
                    localut.dxt.scene = 1060;
                    localut.dxt.cYP = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    localut.dxt.dxw = 0;
                    if (paramAnonymousView.Fsz > 0) {
                      localut.dxt.aBM = paramAnonymousView.Fsz;
                    }
                    localut.dxt.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    com.tencent.mm.sdk.b.a.GpY.l(localut);
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 3)
                {
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 5)
                {
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 6)
                {
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 7)
                {
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).LUA != 9) {
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
          this.nyO.setVisibility(0);
          if ((!this.xgn) && (!this.BMV)) {
            continue;
          }
          localObject2 = h.wUl;
          if (!this.BMV) {}
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
  
  private void euL()
  {
    AppMethodBeat.i(71585);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.BMV) });
    if (this.BMV)
    {
      com.tencent.mm.plugin.wallet_core.c.o localo = new com.tencent.mm.plugin.wallet_core.c.o(this.wOp.Exr, this.Boz);
      this.BMU.doSceneProgress(localo, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.aph() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    z.jD(paramContext).inflate(2131496031, this, true);
    this.uxx = ((ViewGroup)findViewById(2131298761));
    this.ojf = ((CdnImageView)findViewById(2131301587));
    this.fwQ = ((TextView)findViewById(2131302666));
    this.gAI = ((TextView)findViewById(2131299008));
    this.nyO = ((Button)findViewById(2131297631));
    this.BMR = ((WalletScratchShakeView)findViewById(2131304365));
    this.BMP = ((ImageView)findViewById(2131297029));
    this.BMS = ((WalletAwardShakeAnimView)findViewById(2131304736));
    this.ojf.setRoundCorner(true);
    this.ojf.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.LUJ == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.BMV), Boolean.valueOf(paramBoolean) });
      this.BMU = paramWalletBaseUI;
      this.wOp = paramc;
      this.Boz = paramBoolean;
      this.owt = paramString;
      this.BMQ = paramImageView;
      euE();
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
    if ((this.BMR != null) && (this.BMR.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.BMR != null)
      {
        localWalletScratchShakeView = this.BMR;
        if (localWalletScratchShakeView.BMp == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.BMp.X(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.BMR;
        if (localWalletScratchShakeView.BMp == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.BMp.BMJ;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.BMR.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.uxx == null) || (bool2)) {
          break label141;
        }
        bool1 = this.uxx.dispatchTouchEvent(paramMotionEvent);
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
    if (this.BMU != null)
    {
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.BMU.addSceneEndListener(1859);
      this.BMU.addSceneEndListener(2547);
      this.BMU.addSceneEndListener(2803);
      this.BMU.addSceneEndListener(2508);
      this.BMU.addSceneEndListener(2529);
      this.BMU.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.BMU != null)
    {
      this.BMU.removeSceneEndListener(1859);
      this.BMU.removeSceneEndListener(2547);
      this.BMU.removeSceneEndListener(2803);
      this.BMU.removeSceneEndListener(2508);
      this.BMU.removeSceneEndListener(2529);
      this.BMU.removeSceneEndListener(2888);
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.BMW), Boolean.valueOf(this.BMX) });
      if ((!this.BMW) && (!this.BMX))
      {
        localObject = h.wUl;
        if (!this.BMV) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).f(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      ac.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new l(this.wOp.EvX, 4, this.Boz);
      this.BMU.doSceneProgress((com.tencent.mm.ak.n)localObject, false);
      if (this.BMR != null) {
        this.BMR.onDestroy();
      }
      if (this.BMS != null) {
        this.BMS.destroy();
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
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.BMV), b(this.wOp), Boolean.valueOf(this.BMZ) });
    if (!this.BMZ)
    {
      this.BMZ = true;
      euG();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    ac.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.n))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.BoE;
        if (paramString == null)
        {
          ac.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.nWx), paramString.nWy, paramString.ELZ, paramString.ByX });
        if (paramString.nWx == 0)
        {
          if (!bs.isNullOrNil(paramString.ELZ))
          {
            Toast.makeText(getContext(), paramString.ELZ, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.ByX != null)
          {
            if (this.wOp.Exu != null)
            {
              paramInt1 = this.wOp.Exu.LUA;
              this.wOp = paramString.ByX;
              if ((paramString.ByX.Exu != null) && (this.wOp.Exu != null))
              {
                ac.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.ByX.Exu.LUA) });
                if (paramString.ByX.Exu.LUA == 4)
                {
                  ac.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.wOp.Exu.LUA = paramInt1;
                }
              }
              ac.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              euE();
            }
          }
          else
          {
            if ((this.BMY != null) && (this.BMX))
            {
              if (this.BMY.LUA != 8) {
                break label375;
              }
              ac.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              e.o(this.BMU, this.BMY.url, false);
              this.BMV = true;
            }
            label357:
            this.BMY = null;
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
        if (this.BMY.LUA != 9) {
          break label357;
        }
        paramString = this.BMY.LUB;
        if (paramString == null) {
          break label357;
        }
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.Fsx, paramString.Fsy, Integer.valueOf(paramString.Fsz) });
        paramn = new ut();
        paramn.dxt.userName = paramString.Fsx;
        paramn.dxt.dxv = bs.bG(paramString.Fsy, "");
        paramn.dxt.scene = 1060;
        paramn.dxt.cYP = this.owt;
        paramn.dxt.dxw = 0;
        if (paramString.Fsz > 0) {
          paramn.dxt.aBM = paramString.Fsz;
        }
        paramn.dxt.context = this.BMU;
        com.tencent.mm.sdk.b.a.GpY.l(paramn);
        this.BMV = true;
        this.BMZ = false;
        this.gox.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71555);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(71555);
          }
        }, 3000L);
        break label357;
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        euF();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.o))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.BoG;
        if (paramString == null)
        {
          ac.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.nWx;
        paramn = paramString.nWy;
        localObject1 = paramString.Exs;
        i = paramString.Ext;
        localObject2 = paramString.Exu;
        if (paramString.Exu == null) {
          break label881;
        }
        paramInt1 = paramString.Exu.LUA;
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramn, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.nWx == 0)
        {
          this.wOp.Exs = paramString.Exs;
          this.wOp.Ext = paramString.Ext;
          if (this.wOp.Exu == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.wOp.Exu.LUA;; paramInt1 = 0)
      {
        if (paramString.Exu != null)
        {
          this.wOp.Exu = paramString.Exu;
          if ((this.wOp.Exu != null) && (paramString.Exu.LUA == 4))
          {
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.wOp.Exu.LUA = paramInt1;
          }
        }
        ac.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.wOp) });
        euK();
        this.BMV = false;
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
        paramn = paramString.Boy;
        if (paramn == null)
        {
          ac.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramn.nWx;
        localObject1 = paramn.nWy;
        localObject2 = paramn.ByX;
        if (paramn.ByX != null)
        {
          paramString = paramn.ByX.Exs;
          ac.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramn.ByX == null) || (paramn.ByX.Exs == null) || (paramn.ByX.Exs.size() <= 0)) {
            break label1222;
          }
          paramString = paramn.ByX;
          localObject1 = paramn.ByX.Exu;
          if (paramn.ByX.Exu == null) {
            break label1217;
          }
          paramInt1 = paramn.ByX.Exu.LUA;
          label1082:
          ac.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.wOp.Exu != null) {
            paramInt1 = this.wOp.Exu.LUA;
          }
          this.wOp = paramn.ByX;
          if ((this.wOp.Exu != null) && (paramn.ByX.Exu != null) && (paramn.ByX.Exu.LUA == 4))
          {
            ac.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.wOp.Exu.LUA = paramInt1;
          }
          euE();
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
        euF();
        continue;
        euF();
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