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
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
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
  private boolean COc;
  private e.a.a.c CsF;
  private boolean HPM;
  private ImageView InX;
  private ImageView InY;
  private WalletScratchShakeView InZ;
  private WalletAwardShakeAnimView Ioa;
  private i Iob;
  private WalletBaseUI Ioc;
  private boolean Iod;
  private boolean Ioe;
  private boolean Iof;
  private e.a.a.a Iog;
  private boolean Ioh;
  private TextView gxs;
  private MMHandler hAk;
  private TextView hPW;
  private CdnImageView qgQ;
  private String qvD;
  private Button ubX;
  private ViewGroup zhm;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71570);
    this.Iod = false;
    this.Ioe = false;
    this.COc = true;
    this.Iof = false;
    this.Iog = null;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.Ioh = false;
    init(paramContext);
    AppMethodBeat.o(71570);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71571);
    this.Iod = false;
    this.Ioe = false;
    this.COc = true;
    this.Iof = false;
    this.Iog = null;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.Ioh = false;
    init(paramContext);
    AppMethodBeat.o(71571);
  }
  
  public static boolean a(e.a.a.c paramc)
  {
    AppMethodBeat.i(71569);
    if ((paramc != null) && (((paramc.Ltm != null) && (paramc.Ltm.size() > 0)) || (paramc.Ubm != null)))
    {
      AppMethodBeat.o(71569);
      return true;
    }
    AppMethodBeat.o(71569);
    return false;
  }
  
  private String aVX(String paramString)
  {
    AppMethodBeat.i(71583);
    if (!Util.isNullOrNil(new String[0]))
    {
      s.boN(getAccImagesPath());
      String str = getAccImagesPath() + d.getMessageDigest(paramString.getBytes());
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
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
        if ((paramc.Ltm != null) && (paramc.Ltm.size() > 0))
        {
          localObject2 = paramc.Ltm.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i locali = (i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.Bah);
            localJSONObject2.put("award_name", locali.UbK);
            localJSONObject2.put("award_description", locali.UbL);
            localJSONObject2.put("background_img", locali.UbM);
            localJSONObject2.put("award_name_color", locali.UbN);
            localJSONObject2.put("award_description_color", locali.UbO);
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
      localJSONObject1.put("is_query_others", paramc.Ubh);
      localJSONObject1.put("draw_lottery_params", paramc.LrG);
      localJSONObject1.put("is_show_btn", paramc.Ltn);
      Object localObject1 = new JSONObject();
      if (paramc.Lto != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.Lto.UaZ);
        ((JSONObject)localObject1).put("btn_color", paramc.Lto.Uba);
        ((JSONObject)localObject1).put("btn_op_type", paramc.Lto.Ubb);
        ((JSONObject)localObject1).put("url", paramc.Lto.url);
        localObject2 = new JSONObject();
        if (paramc.Lto.Ubc != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Lto.Ubc.MFd);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Lto.Ubc.MFe);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Lto.Ubc.MFf);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.Lto.LXU);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.Ltl);
      localJSONObject1.put("user_opertaion_type", paramc.Ubi);
      localJSONObject1.put("is_show_layer", paramc.Ubj);
      localJSONObject1.put("background_img_whole", paramc.Ubl);
      if (paramc.Ubm != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.Ubm.Ubd);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.Ubm.Ube);
        ((JSONObject)localObject1).put("url", paramc.Ubm.url);
        ((JSONObject)localObject1).put("op_type", paramc.Ubm.NkQ);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.Ubm.Ubf);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.Ubm.Ubg);
        localObject2 = new JSONObject();
        if (paramc.Ubm.Ubc != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.Ubm.Ubc.MFd);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.Ubm.Ubc.MFe);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.Ubm.Ubc.MFf);
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
  
  private void fTZ()
  {
    int i = 2;
    AppMethodBeat.i(71574);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.CsF), Boolean.valueOf(this.COc) });
    if (this.CsF == null)
    {
      Log.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(71574);
      return;
    }
    Log.printInfoStack("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.CsF.Ubi), Integer.valueOf(this.CsF.Ltm.size()), Boolean.valueOf(this.Iod) });
    if ((this.CsF.Ubi <= 0) || (this.CsF.Ubi > 5))
    {
      AppMethodBeat.o(71574);
      return;
    }
    if (!a(this.CsF))
    {
      AppMethodBeat.o(71574);
      return;
    }
    h localh;
    if (this.CsF.Ubi == 4)
    {
      fUd();
      if ((this.COc) || (this.Iod))
      {
        localh = h.CyF;
        if (!this.Iod) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.a(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.COc = false;
      AppMethodBeat.o(71574);
      return;
      if ((this.CsF.Ubi == 1) || (this.CsF.Ubi == 2) || (this.CsF.Ubi == 3))
      {
        fUc();
        break;
      }
      if (this.CsF.Ubi != 5) {
        break;
      }
      fUe();
      break;
      label293:
      i = 1;
    }
  }
  
  private void fUa()
  {
    AppMethodBeat.i(71575);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.gxs.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.hPW.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.gxs.setLayoutParams(localLayoutParams1);
    this.hPW.setLayoutParams(localLayoutParams2);
    this.gxs.setVisibility(0);
    this.hPW.setVisibility(8);
    this.gxs.setText(2131768334);
    this.gxs.setTextColor(getResources().getColor(2131100904));
    this.hPW.setTextColor(getResources().getColor(2131100594));
    this.InX.setVisibility(8);
    findViewById(2131305668).setVisibility(0);
    findViewById(2131305669).setVisibility(0);
    this.ubX.setVisibility(8);
    this.qgQ.setVisibility(0);
    this.qgQ.setImageResource(2131235658);
    this.InZ.setVisibility(8);
    this.InZ.onDestroy();
    this.Ioa.setVisibility(8);
    this.Ioa.destroy();
    AppMethodBeat.o(71575);
  }
  
  private void fUb()
  {
    AppMethodBeat.i(71579);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.CsF.Ubm != null) && (this.CsF.Ubm.NkQ != 1))
    {
      this.InZ.setVisibility(8);
      this.InZ.onDestroy();
      this.Ioa.setVisibility(8);
      this.Ioa.destroy();
    }
    fUg();
    AppMethodBeat.o(71579);
  }
  
  private void fUc()
  {
    AppMethodBeat.i(71580);
    fUf();
    if (this.Ioa.getVisibility() != 8)
    {
      this.Ioa.setVisibility(8);
      this.Ioa.destroy();
    }
    if (this.InZ.getVisibility() != 0)
    {
      this.InZ.setVisibility(0);
      this.InZ.post(new Runnable()
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
  
  private void fUd()
  {
    AppMethodBeat.i(71581);
    fUf();
    if (this.InZ.getVisibility() != 8)
    {
      this.InZ.setVisibility(8);
      this.InZ.onDestroy();
    }
    if (this.Ioa.getVisibility() != 8)
    {
      this.Ioa.setVisibility(8);
      this.Ioa.destroy();
    }
    AppMethodBeat.o(71581);
  }
  
  private void fUe()
  {
    AppMethodBeat.i(71582);
    fUf();
    if (this.InZ.getVisibility() != 8)
    {
      this.InZ.setVisibility(8);
      this.InZ.onDestroy();
    }
    if (this.CsF.Ubm != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.CsF.Ubm.NkQ) });
      switch (this.CsF.Ubm.NkQ)
      {
      default: 
        this.Ioa.setVisibility(8);
        this.Ioa.destroy();
        AppMethodBeat.o(71582);
        return;
      case 1: 
        if (this.Ioa.getVisibility() != 0)
        {
          this.Ioa.setVisibility(0);
          this.Ioa.post(new Runnable()
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
        this.Ioa.destroy();
        if (!Util.isNullOrNil(this.CsF.Ubm.Ubd))
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.CsF.Ubm.Ubd });
          this.Ioa.setShakeHintWording(this.CsF.Ubm.Ubd);
        }
        if (!Util.isNullOrNil(this.CsF.Ubm.Ube)) {}
        try
        {
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.CsF.Ubm.Ube });
          this.Ioa.setShakeHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubm.Ube, true));
          if (!Util.isNullOrNil(this.CsF.Ubm.Ubf))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.CsF.Ubm.Ubf });
            this.Ioa.setAfterHintWording(this.CsF.Ubm.Ubf);
          }
          if (!Util.isNullOrNil(this.CsF.Ubm.Ubg)) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.CsF.Ubm.Ubg });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.Ioa.setAfterHintWordingColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubm.Ubg, true));
            this.Ioa.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void yx(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(71557);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.CyF;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localh.a(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(2131768335));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(2131100245));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71557);
                    return;
                  }
                }
                h localh = h.CyF;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.a(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.Ioa.fTP();
            AppMethodBeat.o(71582);
            return;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.CsF.Ubm.Ube, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.CsF.Ubm.Ubg, localException2.getMessage() });
            }
          }
        }
      case 2: 
        e.a.a.g localg = this.CsF.Ubm.Ubc;
        if (localg == null) {
          break label831;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.MFd, localg.MFe, Integer.valueOf(localg.MFf) });
        wq localwq = new wq();
        localwq.ecI.userName = localg.MFd;
        localwq.ecI.ecK = Util.nullAs(localg.MFe, "");
        localwq.ecI.scene = 1060;
        localwq.ecI.dCw = this.qvD;
        localwq.ecI.ecL = 0;
        if (localg.MFf > 0) {
          localwq.ecI.appVersion = localg.MFf;
        }
        localwq.ecI.context = this.Ioc;
        EventCenter.instance.publish(localwq);
        this.Iod = true;
        this.Ioh = false;
        this.hAk.postDelayed(new Runnable()
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
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.CsF.Ubm.url });
        f.p(this.Ioc, this.CsF.Ubm.url, false);
        this.Iod = true;
        this.Ioh = false;
        this.hAk.postDelayed(new Runnable()
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
      this.InZ.setVisibility(8);
      this.InZ.onDestroy();
    }
    this.Ioa.setVisibility(8);
    this.Ioa.destroy();
    label831:
    AppMethodBeat.o(71582);
  }
  
  private void fUf()
  {
    AppMethodBeat.i(71584);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.CsF.Ltm;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.Iob = ((i)((List)localObject1).get(0));
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.Iob.UbK, this.Iob.UbL, this.Iob.Bah });
        this.qgQ.setUrl(this.Iob.Bah);
        if (!Util.isNullOrNil(this.Iob.Bah)) {
          this.qgQ.setVisibility(0);
        }
        if (Util.isNullOrNil(this.Iob.UbK)) {
          break label1228;
        }
        this.gxs.setText(this.Iob.UbK);
        this.gxs.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!Util.isNullOrNil(this.Iob.UbN)) {
          this.gxs.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.Iob.UbN, true));
        }
        i = 1;
        if (!Util.isNullOrNil(this.Iob.UbL))
        {
          this.hPW.setText(this.Iob.UbL);
          this.hPW.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!Util.isNullOrNil(this.Iob.UbO)) {
            this.hPW.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.Iob.UbO, true));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.gxs.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.hPW.getLayoutParams();
            if ((!Util.isNullOrNil(this.Iob.UbK)) && (Util.isNullOrNil(this.Iob.UbL)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.gxs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.hPW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.gxs.setVisibility(0);
              this.hPW.setVisibility(8);
            }
          }
          else
          {
            if (Util.isNullOrNil(this.Iob.UbM)) {
              continue;
            }
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.Iob.UbM });
            localObject1 = new c.a();
            ((c.a)localObject1).jbf = true;
            ((c.a)localObject1).jbe = true;
            ((c.a)localObject1).fullPath = aVX(this.Iob.UbM);
            localObject1 = ((c.a)localObject1).bdv();
            com.tencent.mm.av.q.bcV().a(this.Iob.UbM, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
            {
              public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(71562);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).UbM)) && (WalletSuccPageAwardWidget.h(WalletSuccPageAwardWidget.this).UbM.equals(paramAnonymousString)))
                {
                  paramAnonymousString = new NinePatch(paramAnonymousBitmap, WalletSuccPageAwardWidget.aE(paramAnonymousBitmap), "widget_bg");
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(71561);
                      WalletSuccPageAwardWidget.i(WalletSuccPageAwardWidget.this).setImageDrawable(this.Ioj);
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
                          WalletSuccPageAwardWidget.this.findViewById(2131305668).setVisibility(8);
                          WalletSuccPageAwardWidget.this.findViewById(2131305669).setVisibility(8);
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
            i = this.CsF.Ltn;
            localObject3 = this.CsF.Lto;
            if (this.CsF.Lto == null) {
              continue;
            }
            localObject1 = this.CsF.Lto.UaZ;
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.CsF.Ltn != 0) && (this.CsF.Lto != null) && (!Util.isNullOrNil(this.CsF.Lto.UaZ))) {
              continue;
            }
            this.ubX.setVisibility(8);
            if (this.gxs.getVisibility() == 0)
            {
              this.gxs.setSingleLine();
              this.gxs.post(new Runnable()
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
            if (this.ubX.getVisibility() != 0) {
              this.gxs.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.CsF.Ubj != 0) {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.CsF.Ubj) });
            }
            if (!Util.isNullOrNil(this.CsF.Ubl))
            {
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.CsF.Ubl });
              if (this.InY != null)
              {
                this.InY.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).jbf = true;
                ((c.a)localObject1).jbe = true;
                ((c.a)localObject1).fullPath = aVX(this.CsF.Ubl);
                localObject1 = ((c.a)localObject1).bdv();
                com.tencent.mm.av.q.bcV().a(this.CsF.Ubl, null, (com.tencent.mm.av.a.a.c)localObject1, new k()
                {
                  public final void a(String paramAnonymousString, View paramAnonymousView, final Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
                  {
                    AppMethodBeat.i(71568);
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramAnonymousString, paramAnonymousBitmap });
                    if ((paramAnonymousBitmap != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (!Util.isNullOrNil(WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Ubl)) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Ubl.equals(paramAnonymousString))) {
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
          if ((Util.isNullOrNil(this.Iob.UbK)) && (!Util.isNullOrNil(this.Iob.UbL)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.gxs.setLayoutParams(localException2);
            this.hPW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.gxs.setVisibility(8);
            this.hPW.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.gxs.setLayoutParams(localException2);
          this.hPW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.gxs.setVisibility(0);
          this.hPW.setVisibility(0);
          continue;
          this.InX.setVisibility(8);
          findViewById(2131305668).setVisibility(0);
          findViewById(2131305669).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.CsF.Lto;
          if (localObject2 == null) {
            continue;
          }
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((e.a.a.a)localObject2).UaZ, Integer.valueOf(((e.a.a.a)localObject2).Ubb), ((e.a.a.a)localObject2).Uba, ((e.a.a.a)localObject2).url });
          this.ubX.setText(((e.a.a.a)localObject2).UaZ);
          if (!Util.isNullOrNil(((e.a.a.a)localObject2).Uba))
          {
            localObject3 = getContext().getResources().getDrawable(2131231429);
            ((Drawable)localObject3).setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cI(((e.a.a.a)localObject2).Uba, false), PorterDuff.Mode.SRC);
            this.ubX.setBackground((Drawable)localObject3);
          }
          this.ubX.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71565);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Lto != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).Lto);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb != 1) {
                  break label282;
                }
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
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
                paramAnonymousView = h.CyF;
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubc;
                  if (paramAnonymousView != null)
                  {
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.MFd, paramAnonymousView.MFe, Integer.valueOf(paramAnonymousView.MFf) });
                    localObject = new wq();
                    ((wq)localObject).ecI.userName = paramAnonymousView.MFd;
                    ((wq)localObject).ecI.ecK = Util.nullAs(paramAnonymousView.MFe, "");
                    ((wq)localObject).ecI.scene = 1060;
                    ((wq)localObject).ecI.dCw = WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this);
                    ((wq)localObject).ecI.ecL = 0;
                    if (paramAnonymousView.MFf > 0) {
                      ((wq)localObject).ecI.appVersion = paramAnonymousView.MFf;
                    }
                    ((wq)localObject).ecI.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
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
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 3)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 5)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 6)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 7)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).Ubb != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
              }
            }
          });
          this.ubX.setVisibility(0);
          if ((!this.COc) && (!this.Iod)) {
            continue;
          }
          localObject2 = h.CyF;
          if (!this.Iod) {}
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
  
  private void fUg()
  {
    AppMethodBeat.i(71585);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.Iod) });
    if (this.Iod)
    {
      o localo = new o(this.CsF.Ltl, this.HPM);
      this.Ioc.doSceneProgress(localo, false);
    }
    AppMethodBeat.o(71585);
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(71589);
    String str = com.tencent.mm.loader.j.b.aKJ() + "wallet/images/";
    AppMethodBeat.o(71589);
    return str;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71572);
    aa.jQ(paramContext).inflate(2131497011, this, true);
    this.zhm = ((ViewGroup)findViewById(2131299205));
    this.qgQ = ((CdnImageView)findViewById(2131303817));
    this.gxs = ((TextView)findViewById(2131305220));
    this.hPW = ((TextView)findViewById(2131299510));
    this.ubX = ((Button)findViewById(2131297893));
    this.InZ = ((WalletScratchShakeView)findViewById(2131307299));
    this.InX = ((ImageView)findViewById(2131297171));
    this.Ioa = ((WalletAwardShakeAnimView)findViewById(2131307793));
    this.qgQ.setRoundCorner(true);
    this.qgQ.setUseSdcardCache(true);
    AppMethodBeat.o(71572);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, e.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71573);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.Ubk == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.Iod), Boolean.valueOf(paramBoolean) });
      this.Ioc = paramWalletBaseUI;
      this.CsF = paramc;
      this.HPM = paramBoolean;
      this.qvD = paramString;
      this.InY = paramImageView;
      fTZ();
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
    if ((this.InZ != null) && (this.InZ.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.InZ != null)
      {
        localWalletScratchShakeView = this.InZ;
        if (localWalletScratchShakeView.Inx == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.Inx.ae(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.InZ;
        if (localWalletScratchShakeView.Inx == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.Inx.InR;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.InZ.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.zhm == null) || (bool2)) {
          break label141;
        }
        bool1 = this.zhm.dispatchTouchEvent(paramMotionEvent);
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
    if (this.Ioc != null)
    {
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.Ioc.addSceneEndListener(1859);
      this.Ioc.addSceneEndListener(2547);
      this.Ioc.addSceneEndListener(2803);
      this.Ioc.addSceneEndListener(2508);
      this.Ioc.addSceneEndListener(2529);
      this.Ioc.addSceneEndListener(2888);
    }
    AppMethodBeat.o(71576);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(71577);
    Object localObject;
    if (this.Ioc != null)
    {
      this.Ioc.removeSceneEndListener(1859);
      this.Ioc.removeSceneEndListener(2547);
      this.Ioc.removeSceneEndListener(2803);
      this.Ioc.removeSceneEndListener(2508);
      this.Ioc.removeSceneEndListener(2529);
      this.Ioc.removeSceneEndListener(2888);
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.Ioe), Boolean.valueOf(this.Iof) });
      if ((!this.Ioe) && (!this.Iof))
      {
        localObject = h.CyF;
        if (!this.Iod) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).a(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      Log.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new l(this.CsF.LrG, 4, this.HPM);
      this.Ioc.doSceneProgress((com.tencent.mm.ak.q)localObject, false);
      if (this.InZ != null) {
        this.InZ.onDestroy();
      }
      if (this.Ioa != null) {
        this.Ioa.destroy();
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
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.Iod), b(this.CsF), Boolean.valueOf(this.Ioh) });
    if (!this.Ioh)
    {
      this.Ioh = true;
      fUb();
    }
    AppMethodBeat.o(71578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(71586);
    Log.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof n))
    {
      paramString = (n)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.HPQ;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.pTZ), paramString.pUa, paramString.LSG, paramString.Iah });
        if (paramString.pTZ == 0)
        {
          if (!Util.isNullOrNil(paramString.LSG))
          {
            Toast.makeText(getContext(), paramString.LSG, 1).show();
            AppMethodBeat.o(71586);
            return true;
          }
          if (paramString.Iah != null)
          {
            if (this.CsF.Lto != null)
            {
              paramInt1 = this.CsF.Lto.Ubb;
              this.CsF = paramString.Iah;
              if ((paramString.Iah.Lto != null) && (this.CsF.Lto != null))
              {
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.Iah.Lto.Ubb) });
                if (paramString.Iah.Lto.Ubb == 4)
                {
                  Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.CsF.Lto.Ubb = paramInt1;
                }
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              fTZ();
            }
          }
          else
          {
            if ((this.Iog != null) && (this.Iof))
            {
              if (this.Iog.Ubb != 8) {
                break label375;
              }
              Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              f.p(this.Ioc, this.Iog.url, false);
              this.Iod = true;
            }
            label357:
            this.Iog = null;
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
        if (this.Iog.Ubb != 9) {
          break label357;
        }
        paramString = this.Iog.Ubc;
        if (paramString == null) {
          break label357;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.MFd, paramString.MFe, Integer.valueOf(paramString.MFf) });
        paramq = new wq();
        paramq.ecI.userName = paramString.MFd;
        paramq.ecI.ecK = Util.nullAs(paramString.MFe, "");
        paramq.ecI.scene = 1060;
        paramq.ecI.dCw = this.qvD;
        paramq.ecI.ecL = 0;
        if (paramString.MFf > 0) {
          paramq.ecI.appVersion = paramString.MFf;
        }
        paramq.ecI.context = this.Ioc;
        EventCenter.instance.publish(paramq);
        this.Iod = true;
        this.Ioh = false;
        this.hAk.postDelayed(new Runnable()
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
        fUa();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof o))
    {
      paramString = (o)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.HPS;
        if (paramString == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt2 = paramString.pTZ;
        paramq = paramString.pUa;
        localObject1 = paramString.Ltm;
        i = paramString.Ltn;
        localObject2 = paramString.Lto;
        if (paramString.Lto == null) {
          break label881;
        }
        paramInt1 = paramString.Lto.Ubb;
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramq, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.pTZ == 0)
        {
          this.CsF.Ltm = paramString.Ltm;
          this.CsF.Ltn = paramString.Ltn;
          if (this.CsF.Lto == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.CsF.Lto.Ubb;; paramInt1 = 0)
      {
        if (paramString.Lto != null)
        {
          this.CsF.Lto = paramString.Lto;
          if ((this.CsF.Lto != null) && (paramString.Lto.Ubb == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.CsF.Lto.Ubb = paramInt1;
          }
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.CsF) });
        fUf();
        this.Iod = false;
        AppMethodBeat.o(71586);
        return true;
        paramInt1 = 0;
        break;
      }
    }
    if ((paramq instanceof l))
    {
      paramString = (l)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = paramString.HPL;
        if (paramq == null)
        {
          Log.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(71586);
          return true;
        }
        paramInt1 = paramq.pTZ;
        localObject1 = paramq.pUa;
        localObject2 = paramq.Iah;
        if (paramq.Iah != null)
        {
          paramString = paramq.Iah.Ltm;
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramq.Iah == null) || (paramq.Iah.Ltm == null) || (paramq.Iah.Ltm.size() <= 0)) {
            break label1222;
          }
          paramString = paramq.Iah;
          localObject1 = paramq.Iah.Lto;
          if (paramq.Iah.Lto == null) {
            break label1217;
          }
          paramInt1 = paramq.Iah.Lto.Ubb;
          label1082:
          Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.CsF.Lto != null) {
            paramInt1 = this.CsF.Lto.Ubb;
          }
          this.CsF = paramq.Iah;
          if ((this.CsF.Lto != null) && (paramq.Iah.Lto != null) && (paramq.Iah.Lto.Ubb == 4))
          {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.CsF.Lto.Ubb = paramInt1;
          }
          fTZ();
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
        fUa();
        continue;
        fUa();
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