package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.xweb.util.d;
import d.a.a.b;
import d.a.a.g;
import d.a.a.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget
  extends FrameLayout
{
  private static final String uxL;
  private ak faV;
  private TextView gve;
  private TextView hsI;
  private CdnImageView kAK;
  private String kMN;
  private ViewGroup owk;
  private boolean qBd;
  private d.a.a.c qnc;
  private boolean ubz;
  private ImageView uxA;
  private ImageView uxB;
  private WalletScratchShakeView uxC;
  private WalletAwardShakeAnimView uxD;
  private i uxE;
  private WalletBaseUI uxF;
  private boolean uxG;
  private boolean uxH;
  private boolean uxI;
  private d.a.a.a uxJ;
  private boolean uxK;
  private Button uxz;
  
  static
  {
    AppMethodBeat.i(47982);
    uxL = com.tencent.mm.compatible.util.e.eQz + "wallet/images/";
    AppMethodBeat.o(47982);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47958);
    this.uxG = false;
    this.uxH = false;
    this.qBd = true;
    this.uxI = false;
    this.uxJ = null;
    this.faV = new ak(Looper.getMainLooper());
    this.uxK = false;
    init(paramContext);
    AppMethodBeat.o(47958);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47959);
    this.uxG = false;
    this.uxH = false;
    this.qBd = true;
    this.uxI = false;
    this.uxJ = null;
    this.faV = new ak(Looper.getMainLooper());
    this.uxK = false;
    init(paramContext);
    AppMethodBeat.o(47959);
  }
  
  public static boolean a(d.a.a.c paramc)
  {
    AppMethodBeat.i(47957);
    if ((paramc != null) && (((paramc.wQZ != null) && (paramc.wQZ.size() > 0)) || (paramc.CLu != null)))
    {
      AppMethodBeat.o(47957);
      return true;
    }
    AppMethodBeat.o(47957);
    return false;
  }
  
  private static String afQ(String paramString)
  {
    AppMethodBeat.i(47971);
    if (!bo.Q(new String[0]))
    {
      com.tencent.mm.vfs.e.um(uxL);
      String str = uxL + d.w(paramString.getBytes());
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
      AppMethodBeat.o(47971);
      return str;
    }
    AppMethodBeat.o(47971);
    return null;
  }
  
  private static String b(d.a.a.c paramc)
  {
    AppMethodBeat.i(47976);
    if (paramc != null)
    {
      JSONObject localJSONObject1;
      Object localObject2;
      try
      {
        localJSONObject1 = new JSONObject();
        localObject1 = new JSONArray();
        if ((paramc.wQZ != null) && (paramc.wQZ.size() > 0))
        {
          localObject2 = paramc.wQZ.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i locali = (i)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", locali.pvi);
            localJSONObject2.put("award_name", locali.CLT);
            localJSONObject2.put("award_description", locali.CLU);
            localJSONObject2.put("background_img", locali.CLV);
            localJSONObject2.put("award_name_color", locali.CLW);
            localJSONObject2.put("award_description_color", locali.CLX);
            ((JSONArray)localObject1).put(localJSONObject2);
          }
        }
        localJSONObject1.put("single_exposure_info_list", localObject1);
      }
      catch (Exception paramc)
      {
        AppMethodBeat.o(47976);
        return "";
      }
      localJSONObject1.put("is_query_others", paramc.CLp);
      localJSONObject1.put("draw_lottery_params", paramc.wPV);
      localJSONObject1.put("is_show_btn", paramc.wRa);
      Object localObject1 = new JSONObject();
      if (paramc.wRb != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.wRb.CLh);
        ((JSONObject)localObject1).put("btn_color", paramc.wRb.CLi);
        ((JSONObject)localObject1).put("btn_op_type", paramc.wRb.CLj);
        ((JSONObject)localObject1).put("url", paramc.wRb.url);
        localObject2 = new JSONObject();
        if (paramc.wRb.CLk != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.wRb.CLk.xzC);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.wRb.CLk.xzD);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.wRb.CLk.xzE);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.wRb.xcU);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.wQY);
      localJSONObject1.put("user_opertaion_type", paramc.CLq);
      localJSONObject1.put("is_show_layer", paramc.CLr);
      localJSONObject1.put("background_img_whole", paramc.CLt);
      if (paramc.CLu != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.CLu.CLl);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.CLu.CLm);
        ((JSONObject)localObject1).put("url", paramc.CLu.url);
        ((JSONObject)localObject1).put("op_type", paramc.CLu.xWC);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.CLu.CLn);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.CLu.CLo);
        localObject2 = new JSONObject();
        if (paramc.CLu.CLk != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.CLu.CLk.xzC);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.CLu.CLk.xzD);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.CLu.CLk.xzE);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        localJSONObject1.put("draw_lottery_info", localObject1);
      }
      paramc = localJSONObject1.toString();
      AppMethodBeat.o(47976);
      return paramc;
    }
    AppMethodBeat.o(47976);
    return "";
  }
  
  private void cWP()
  {
    int i = 2;
    AppMethodBeat.i(47962);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.qnc), Boolean.valueOf(this.qBd) });
    if (this.qnc == null)
    {
      ab.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
      AppMethodBeat.o(47962);
      return;
    }
    ab.b("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.qnc.CLq), Integer.valueOf(this.qnc.wQZ.size()), Boolean.valueOf(this.uxG) });
    if ((this.qnc.CLq <= 0) || (this.qnc.CLq > 5))
    {
      AppMethodBeat.o(47962);
      return;
    }
    if (!a(this.qnc))
    {
      AppMethodBeat.o(47962);
      return;
    }
    h localh;
    if (this.qnc.CLq == 4)
    {
      cWT();
      if ((this.qBd) || (this.uxG))
      {
        localh = h.qsU;
        if (!this.uxG) {
          break label293;
        }
      }
    }
    for (;;)
    {
      localh.e(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
      this.qBd = false;
      AppMethodBeat.o(47962);
      return;
      if ((this.qnc.CLq == 1) || (this.qnc.CLq == 2) || (this.qnc.CLq == 3))
      {
        cWS();
        break;
      }
      if (this.qnc.CLq != 5) {
        break;
      }
      cWU();
      break;
      label293:
      i = 1;
    }
  }
  
  private void cWQ()
  {
    AppMethodBeat.i(47963);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.gve.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.hsI.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.gve.setLayoutParams(localLayoutParams1);
    this.hsI.setLayoutParams(localLayoutParams2);
    this.gve.setVisibility(0);
    this.hsI.setVisibility(8);
    this.gve.setText(2131305662);
    this.gve.setTextColor(Color.parseColor("#353535"));
    this.hsI.setTextColor(Color.parseColor("#B2B2B2"));
    this.uxA.setVisibility(8);
    findViewById(2131825332).setVisibility(0);
    findViewById(2131827210).setVisibility(0);
    this.uxz.setVisibility(8);
    this.kAK.setVisibility(0);
    this.kAK.setImageResource(2130840868);
    this.uxC.setVisibility(8);
    this.uxC.onDestroy();
    this.uxD.setVisibility(8);
    this.uxD.destroy();
    AppMethodBeat.o(47963);
  }
  
  private void cWR()
  {
    AppMethodBeat.i(47967);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.qnc.CLu != null) && (this.qnc.CLu.xWC != 1))
    {
      this.uxC.setVisibility(8);
      this.uxC.onDestroy();
      this.uxD.setVisibility(8);
      this.uxD.destroy();
    }
    cWW();
    AppMethodBeat.o(47967);
  }
  
  private void cWS()
  {
    AppMethodBeat.i(47968);
    cWV();
    if (this.uxD.getVisibility() != 8)
    {
      this.uxD.setVisibility(8);
      this.uxD.destroy();
    }
    if (this.uxC.getVisibility() != 0)
    {
      this.uxC.setVisibility(0);
      this.uxC.post(new WalletSuccPageAwardWidget.1(this));
    }
    AppMethodBeat.o(47968);
  }
  
  private void cWT()
  {
    AppMethodBeat.i(47969);
    cWV();
    if (this.uxC.getVisibility() != 8)
    {
      this.uxC.setVisibility(8);
      this.uxC.onDestroy();
    }
    if (this.uxD.getVisibility() != 8)
    {
      this.uxD.setVisibility(8);
      this.uxD.destroy();
    }
    AppMethodBeat.o(47969);
  }
  
  private void cWU()
  {
    AppMethodBeat.i(47970);
    cWV();
    if (this.uxC.getVisibility() != 8)
    {
      this.uxC.setVisibility(8);
      this.uxC.onDestroy();
    }
    if (this.qnc.CLu != null)
    {
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.qnc.CLu.xWC) });
      switch (this.qnc.CLu.xWC)
      {
      default: 
        this.uxD.setVisibility(8);
        this.uxD.destroy();
        AppMethodBeat.o(47970);
        return;
      case 1: 
        if (this.uxD.getVisibility() != 0)
        {
          this.uxD.setVisibility(0);
          this.uxD.post(new WalletSuccPageAwardWidget.4(this));
        }
        this.uxD.destroy();
        if (!bo.isNullOrNil(this.qnc.CLu.CLl))
        {
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.qnc.CLu.CLl });
          this.uxD.setShakeHintWording(this.qnc.CLu.CLl);
        }
        if (!bo.isNullOrNil(this.qnc.CLu.CLm)) {}
        try
        {
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.qnc.CLu.CLm });
          this.uxD.setShakeHintWordingColor(Color.parseColor(this.qnc.CLu.CLm));
          if (!bo.isNullOrNil(this.qnc.CLu.CLn))
          {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.qnc.CLu.CLn });
            this.uxD.setAfterHintWording(this.qnc.CLu.CLn);
          }
          if (!bo.isNullOrNil(this.qnc.CLu.CLo)) {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.qnc.CLu.CLo });
          }
        }
        catch (Exception localException1)
        {
          try
          {
            this.uxD.setAfterHintWordingColor(Color.parseColor(this.qnc.CLu.CLo));
            this.uxD.setShakeOrClickCallback(new WalletAwardShakeAnimView.a()
            {
              public final void nV(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(47945);
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) });
                if (paramAnonymousBoolean)
                {
                  localh = h.qsU;
                  if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                  for (i = 2;; i = 1)
                  {
                    localh.e(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(2131305663));
                    WalletSuccPageAwardWidget.d(WalletSuccPageAwardWidget.this).setShakeHintWordingColor(Color.parseColor("#9C9C9C"));
                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                    WalletSuccPageAwardWidget.f(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(47945);
                    return;
                  }
                }
                h localh = h.qsU;
                if (WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {}
                for (int i = 2;; i = 1)
                {
                  localh.e(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
                  break;
                }
              }
            });
            this.uxD.cWF();
            AppMethodBeat.o(47970);
            return;
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.qnc.CLu.CLm, localException1.getMessage() });
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.qnc.CLu.CLo, localException2.getMessage() });
            }
          }
        }
      case 2: 
        g localg = this.qnc.CLu.CLk;
        if (localg == null) {
          break label829;
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localg.xzC, localg.xzD, Integer.valueOf(localg.xzE) });
        so localso = new so();
        localso.cIQ.userName = localg.xzC;
        localso.cIQ.cIS = bo.bf(localg.xzD, "");
        localso.cIQ.scene = 1060;
        localso.cIQ.cmF = this.kMN;
        localso.cIQ.cIT = 0;
        if (localg.xzE > 0) {
          localso.cIQ.bDc = localg.xzE;
        }
        localso.cIQ.context = this.uxF;
        com.tencent.mm.sdk.b.a.ymk.l(localso);
        this.uxG = true;
        this.uxK = false;
        this.faV.postDelayed(new WalletSuccPageAwardWidget.6(this), 3000L);
        AppMethodBeat.o(47970);
        return;
      case 3: 
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.qnc.CLu.url });
        com.tencent.mm.wallet_core.ui.e.m(this.uxF, this.qnc.CLu.url, false);
        this.uxG = true;
        this.uxK = false;
        this.faV.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47947);
            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.o(47947);
          }
        }, 3000L);
        AppMethodBeat.o(47970);
        return;
      }
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.uxC.setVisibility(8);
      this.uxC.onDestroy();
    }
    this.uxD.setVisibility(8);
    this.uxD.destroy();
    label829:
    AppMethodBeat.o(47970);
  }
  
  private void cWV()
  {
    AppMethodBeat.i(47972);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.qnc.wQZ;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.uxE = ((i)((List)localObject1).get(0));
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.uxE.CLT, this.uxE.CLU, this.uxE.pvi });
        this.kAK.setUrl(this.uxE.pvi);
        if (!bo.isNullOrNil(this.uxE.pvi)) {
          this.kAK.setVisibility(0);
        }
        if (bo.isNullOrNil(this.uxE.CLT)) {
          break label1223;
        }
        this.gve.setText(this.uxE.CLT);
        this.gve.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bo.isNullOrNil(this.uxE.CLW)) {
          this.gve.setTextColor(Color.parseColor(this.uxE.CLW));
        }
        i = 1;
        if (!bo.isNullOrNil(this.uxE.CLU))
        {
          this.hsI.setText(this.uxE.CLU);
          this.hsI.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bo.isNullOrNil(this.uxE.CLX)) {
            this.hsI.setTextColor(Color.parseColor(this.uxE.CLX));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.gve.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.hsI.getLayoutParams();
            if ((!bo.isNullOrNil(this.uxE.CLT)) && (bo.isNullOrNil(this.uxE.CLU)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.gve.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.hsI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.gve.setVisibility(0);
              this.hsI.setVisibility(8);
            }
          }
          else
          {
            if (bo.isNullOrNil(this.uxE.CLV)) {
              continue;
            }
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.uxE.CLV });
            localObject1 = new c.a();
            ((c.a)localObject1).eNM = true;
            ((c.a)localObject1).eNL = true;
            ((c.a)localObject1).eNO = afQ(this.uxE.CLV);
            localObject1 = ((c.a)localObject1).ahY();
            o.ahG().a(this.uxE.CLV, null, (com.tencent.mm.at.a.a.c)localObject1, new WalletSuccPageAwardWidget.8(this));
            i = this.qnc.wRa;
            localObject3 = this.qnc.wRb;
            if (this.qnc.wRb == null) {
              continue;
            }
            localObject1 = this.qnc.wRb.CLh;
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.qnc.wRa != 0) && (this.qnc.wRb != null) && (!bo.isNullOrNil(this.qnc.wRb.CLh))) {
              continue;
            }
            this.uxz.setVisibility(8);
            if (this.gve.getVisibility() == 0)
            {
              this.gve.setSingleLine();
              this.gve.post(new WalletSuccPageAwardWidget.10(this));
            }
            if (this.uxz.getVisibility() != 0) {
              this.gve.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.qnc.CLr != 0) {
              ab.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.qnc.CLr) });
            }
            if (!bo.isNullOrNil(this.qnc.CLt))
            {
              ab.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.qnc.CLt });
              if (this.uxB != null)
              {
                this.uxB.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).eNM = true;
                ((c.a)localObject1).eNL = true;
                ((c.a)localObject1).eNO = afQ(this.qnc.CLt);
                localObject1 = ((c.a)localObject1).ahY();
                o.ahG().a(this.qnc.CLt, null, (com.tencent.mm.at.a.a.c)localObject1, new WalletSuccPageAwardWidget.11(this));
              }
            }
            AppMethodBeat.o(47972);
            return;
            i = 0;
            break;
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((bo.isNullOrNil(this.uxE.CLT)) && (!bo.isNullOrNil(this.uxE.CLU)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.gve.setLayoutParams(localException2);
            this.hsI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.gve.setVisibility(8);
            this.hsI.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.gve.setLayoutParams(localException2);
          this.hsI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.gve.setVisibility(0);
          this.hsI.setVisibility(0);
          continue;
          this.uxA.setVisibility(8);
          findViewById(2131825332).setVisibility(0);
          findViewById(2131827210).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.qnc.wRb;
          if (localObject2 == null) {
            continue;
          }
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((d.a.a.a)localObject2).CLh, Integer.valueOf(((d.a.a.a)localObject2).CLj), ((d.a.a.a)localObject2).CLi, ((d.a.a.a)localObject2).url });
          this.uxz.setText(((d.a.a.a)localObject2).CLh);
          if (!bo.isNullOrNil(((d.a.a.a)localObject2).CLi))
          {
            localObject3 = getContext().getResources().getDrawable(2130838045);
            ((Drawable)localObject3).setColorFilter(Color.parseColor(((d.a.a.a)localObject2).CLi), PorterDuff.Mode.SRC);
            this.uxz.setBackground((Drawable)localObject3);
          }
          this.uxz.setOnClickListener(new WalletSuccPageAwardWidget.9(this));
          this.uxz.setVisibility(0);
          if ((!this.qBd) && (!this.uxG)) {
            continue;
          }
          localObject2 = h.qsU;
          if (!this.uxG) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((h)localObject2).e(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1223:
      i = 0;
    }
  }
  
  private void cWW()
  {
    AppMethodBeat.i(47973);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.uxG) });
    if (this.uxG)
    {
      com.tencent.mm.plugin.wallet_core.c.m localm = new com.tencent.mm.plugin.wallet_core.c.m(this.qnc.wQY, this.ubz);
      this.uxF.doSceneProgress(localm, false);
    }
    AppMethodBeat.o(47973);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(47960);
    w.hM(paramContext).inflate(2130971254, this, true);
    this.owk = ((ViewGroup)findViewById(2131821724));
    this.kAK = ((CdnImageView)findViewById(2131829401));
    this.gve = ((TextView)findViewById(2131821254));
    this.hsI = ((TextView)findViewById(2131821007));
    this.uxz = ((Button)findViewById(2131820875));
    this.uxC = ((WalletScratchShakeView)findViewById(2131829402));
    this.uxA = ((ImageView)findViewById(2131824152));
    this.uxD = ((WalletAwardShakeAnimView)findViewById(2131829403));
    this.kAK.setRoundCorner(true);
    this.kAK.setUseSdcardCache(true);
    AppMethodBeat.o(47960);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, d.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47961);
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.CLs == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label129;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.uxG), Boolean.valueOf(paramBoolean) });
      this.uxF = paramWalletBaseUI;
      this.qnc = paramc;
      this.ubz = paramBoolean;
      this.kMN = paramString;
      this.uxB = paramImageView;
      cWP();
      AppMethodBeat.o(47961);
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
    AppMethodBeat.i(47975);
    if ((this.uxC != null) && (this.uxC.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.uxC != null)
      {
        localWalletScratchShakeView = this.uxC;
        if (localWalletScratchShakeView.uwY == null) {
          break label131;
        }
        bool1 = localWalletScratchShakeView.uwY.O(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.uxC;
        if (localWalletScratchShakeView.uwY == null) {
          break label136;
        }
      }
      label131:
      label136:
      for (bool1 = localWalletScratchShakeView.uwY.uxs;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.uxC.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.owk == null) || (bool2)) {
          break label141;
        }
        bool1 = this.owk.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(47975);
        return bool1;
        bool1 = false;
        break;
      }
    }
    label141:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(47975);
    return bool1;
  }
  
  public final void init()
  {
    AppMethodBeat.i(47964);
    if (this.uxF != null)
    {
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.uxF.addSceneEndListener(1859);
      this.uxF.addSceneEndListener(2547);
      this.uxF.addSceneEndListener(2803);
      this.uxF.addSceneEndListener(2508);
      this.uxF.addSceneEndListener(2529);
      this.uxF.addSceneEndListener(2888);
    }
    AppMethodBeat.o(47964);
  }
  
  public final void onDestroy()
  {
    int i = 2;
    AppMethodBeat.i(47965);
    Object localObject;
    if (this.uxF != null)
    {
      this.uxF.removeSceneEndListener(1859);
      this.uxF.removeSceneEndListener(2547);
      this.uxF.removeSceneEndListener(2803);
      this.uxF.removeSceneEndListener(2508);
      this.uxF.removeSceneEndListener(2529);
      this.uxF.removeSceneEndListener(2888);
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.uxH), Boolean.valueOf(this.uxI) });
      if ((!this.uxH) && (!this.uxI))
      {
        localObject = h.qsU;
        if (!this.uxG) {
          break label230;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).e(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new j(this.qnc.wPV, 4, this.ubz);
      this.uxF.doSceneProgress((com.tencent.mm.ai.m)localObject, false);
      if (this.uxC != null) {
        this.uxC.onDestroy();
      }
      if (this.uxD != null) {
        this.uxD.destroy();
      }
      AppMethodBeat.o(47965);
      return;
      label230:
      i = 1;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47966);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.uxG), b(this.qnc), Boolean.valueOf(this.uxK) });
    if (!this.uxK)
    {
      this.uxK = true;
      cWR();
    }
    AppMethodBeat.o(47966);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(47974);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.ubE;
        if (paramString == null)
        {
          ab.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          AppMethodBeat.o(47974);
          return true;
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.koj), paramString.kok, paramString.wZi, paramString.ukr });
        if (paramString.koj == 0)
        {
          if (!bo.isNullOrNil(paramString.wZi))
          {
            Toast.makeText(getContext(), paramString.wZi, 1).show();
            AppMethodBeat.o(47974);
            return true;
          }
          if (paramString.ukr != null)
          {
            if (this.qnc.wRb != null)
            {
              paramInt1 = this.qnc.wRb.CLj;
              this.qnc = paramString.ukr;
              if ((paramString.ukr.wRb != null) && (this.qnc.wRb != null))
              {
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.ukr.wRb.CLj) });
                if (paramString.ukr.wRb.CLj == 4)
                {
                  ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                  this.qnc.wRb.CLj = paramInt1;
                }
              }
              ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
              cWP();
            }
          }
          else
          {
            if ((this.uxJ != null) && (this.uxI))
            {
              if (this.uxJ.CLj != 8) {
                break label375;
              }
              ab.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
              com.tencent.mm.wallet_core.ui.e.m(this.uxF, this.uxJ.url, false);
              this.uxG = true;
            }
            label357:
            this.uxJ = null;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(47974);
        return true;
        paramInt1 = 0;
        break;
        label375:
        if (this.uxJ.CLj != 9) {
          break label357;
        }
        paramString = this.uxJ.CLk;
        if (paramString == null) {
          break label357;
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.xzC, paramString.xzD, Integer.valueOf(paramString.xzE) });
        paramm = new so();
        paramm.cIQ.userName = paramString.xzC;
        paramm.cIQ.cIS = bo.bf(paramString.xzD, "");
        paramm.cIQ.scene = 1060;
        paramm.cIQ.cmF = this.kMN;
        paramm.cIQ.cIT = 0;
        if (paramString.xzE > 0) {
          paramm.cIQ.bDc = paramString.xzE;
        }
        paramm.cIQ.context = this.uxF;
        com.tencent.mm.sdk.b.a.ymk.l(paramm);
        this.uxG = true;
        this.uxK = false;
        this.faV.postDelayed(new WalletSuccPageAwardWidget.3(this), 3000L);
        break label357;
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        cWQ();
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.m))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.m)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.ubG;
        if (paramString == null)
        {
          ab.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
          AppMethodBeat.o(47974);
          return true;
        }
        paramInt2 = paramString.koj;
        paramm = paramString.kok;
        localObject1 = paramString.wQZ;
        i = paramString.wRa;
        localObject2 = paramString.wRb;
        if (paramString.wRb == null) {
          break label881;
        }
        paramInt1 = paramString.wRb.CLj;
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramm, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
        if (paramString.koj == 0)
        {
          this.qnc.wQZ = paramString.wQZ;
          this.qnc.wRa = paramString.wRa;
          if (this.qnc.wRb == null) {
            break label886;
          }
        }
      }
      label881:
      label886:
      for (paramInt1 = this.qnc.wRb.CLj;; paramInt1 = 0)
      {
        if (paramString.wRb != null)
        {
          this.qnc.wRb = paramString.wRb;
          if ((this.qnc.wRb != null) && (paramString.wRb.CLj == 4))
          {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.qnc.wRb.CLj = paramInt1;
          }
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.qnc) });
        cWV();
        this.uxG = false;
        AppMethodBeat.o(47974);
        return true;
        paramInt1 = 0;
        break;
      }
    }
    if ((paramm instanceof j))
    {
      paramString = (j)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = paramString.uby;
        if (paramm == null)
        {
          ab.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
          AppMethodBeat.o(47974);
          return true;
        }
        paramInt1 = paramm.koj;
        localObject1 = paramm.kok;
        localObject2 = paramm.ukr;
        if (paramm.ukr != null)
        {
          paramString = paramm.ukr.wQZ;
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
          if ((paramm.ukr == null) || (paramm.ukr.wQZ == null) || (paramm.ukr.wQZ.size() <= 0)) {
            break label1222;
          }
          paramString = paramm.ukr;
          localObject1 = paramm.ukr.wRb;
          if (paramm.ukr.wRb == null) {
            break label1217;
          }
          paramInt1 = paramm.ukr.wRb.CLj;
          label1082:
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
          paramInt1 = i;
          if (this.qnc.wRb != null) {
            paramInt1 = this.qnc.wRb.CLj;
          }
          this.qnc = paramm.ukr;
          if ((this.qnc.wRb != null) && (paramm.ukr.wRb != null) && (paramm.ukr.wRb.CLj == 4))
          {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
            this.qnc.wRb.CLj = paramInt1;
          }
          cWP();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(47974);
        return true;
        paramString = "";
        break;
        label1217:
        paramInt1 = 0;
        break label1082;
        label1222:
        cWQ();
        continue;
        cWQ();
      }
    }
    AppMethodBeat.o(47974);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget
 * JD-Core Version:    0.7.0.1
 */