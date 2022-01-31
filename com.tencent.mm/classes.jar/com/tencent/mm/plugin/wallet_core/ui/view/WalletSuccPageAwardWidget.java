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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.b;
import b.a.a.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget
  extends FrameLayout
{
  private static final String qJd = com.tencent.mm.compatible.util.e.bkH + "wallet/images/";
  private ah dPi = new ah(Looper.getMainLooper());
  private TextView fdt;
  private TextView gaI;
  private Button hZu;
  private String iGK;
  private b.a.a.c nBp;
  private boolean nNs = true;
  private CdnImageView qFg;
  private ViewGroup qIO;
  private ImageView qIS;
  private ImageView qIT;
  private WalletScratchShakeView qIU;
  private WalletAwardShakeAnimView qIV;
  private b.a.a.g qIW;
  private WalletBaseUI qIX;
  private boolean qIY = false;
  private boolean qIZ = false;
  private boolean qJa = false;
  private b.a.a.a qJb = null;
  private boolean qJc = false;
  private boolean qqD;
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WalletSuccPageAwardWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private static String QS(String paramString)
  {
    if (!bk.H(new String[0]))
    {
      com.tencent.mm.vfs.e.nb(qJd);
      String str = qJd + com.tencent.xweb.util.c.o(paramString.getBytes());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[] { paramString, str });
      return str;
    }
    return null;
  }
  
  public static boolean a(b.a.a.c paramc)
  {
    return (paramc != null) && (((paramc.sTf != null) && (paramc.sTf.size() > 0)) || (paramc.xps != null));
  }
  
  private static String b(b.a.a.c paramc)
  {
    if (paramc != null)
    {
      JSONObject localJSONObject1;
      Object localObject2;
      try
      {
        localJSONObject1 = new JSONObject();
        localObject1 = new JSONArray();
        if ((paramc.sTf != null) && (paramc.sTf.size() > 0))
        {
          localObject2 = paramc.sTf.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            b.a.a.g localg = (b.a.a.g)((Iterator)localObject2).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("logo", localg.mTc);
            localJSONObject2.put("award_name", localg.xpC);
            localJSONObject2.put("award_description", localg.xpD);
            localJSONObject2.put("background_img", localg.xpE);
            localJSONObject2.put("award_name_color", localg.xpF);
            localJSONObject2.put("award_description_color", localg.xpG);
            ((JSONArray)localObject1).put(localJSONObject2);
          }
        }
        localJSONObject1.put("single_exposure_info_list", localObject1);
      }
      catch (Exception paramc)
      {
        return "";
      }
      localJSONObject1.put("is_query_others", paramc.xpn);
      localJSONObject1.put("draw_lottery_params", paramc.sRh);
      localJSONObject1.put("is_show_btn", paramc.sTg);
      Object localObject1 = new JSONObject();
      if (paramc.sTh != null)
      {
        ((JSONObject)localObject1).put("btn_words", paramc.sTh.xpf);
        ((JSONObject)localObject1).put("btn_color", paramc.sTh.xpg);
        ((JSONObject)localObject1).put("btn_op_type", paramc.sTh.xph);
        ((JSONObject)localObject1).put("url", paramc.sTh.url);
        localObject2 = new JSONObject();
        if (paramc.sTh.xpi != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.sTh.xpi.tyu);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.sTh.xpi.tyv);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.sTh.xpi.tyw);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        ((JSONObject)localObject1).put("get_lottery_params", paramc.sTh.teX);
      }
      localJSONObject1.put("btn_info", localObject1);
      localJSONObject1.put("exposure_info_modify_params", paramc.sTe);
      localJSONObject1.put("user_opertaion_type", paramc.xpo);
      localJSONObject1.put("is_show_layer", paramc.xpp);
      localJSONObject1.put("background_img_whole", paramc.xpr);
      if (paramc.xps != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("animation_wording", paramc.xps.xpj);
        ((JSONObject)localObject1).put("animation_wording_color", paramc.xps.xpk);
        ((JSONObject)localObject1).put("url", paramc.xps.url);
        ((JSONObject)localObject1).put("op_type", paramc.xps.tPH);
        ((JSONObject)localObject1).put("after_animation_wording", paramc.xps.xpl);
        ((JSONObject)localObject1).put("after_animation_wording_color", paramc.xps.xpm);
        localObject2 = new JSONObject();
        if (paramc.xps.xpi != null)
        {
          ((JSONObject)localObject2).put("activity_tinyapp_username", paramc.xps.xpi.tyu);
          ((JSONObject)localObject2).put("activity_tinyapp_path", paramc.xps.xpi.tyv);
          ((JSONObject)localObject2).put("activity_tinyapp_version", paramc.xps.xpi.tyw);
        }
        ((JSONObject)localObject1).put("mini_app_info", localObject2);
        localJSONObject1.put("draw_lottery_info", localObject1);
      }
      paramc = localJSONObject1.toString();
      return paramc;
    }
    return "";
  }
  
  private void bXo()
  {
    int i = 2;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[] { b(this.nBp), Boolean.valueOf(this.nNs) });
    if (this.nBp == null) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
    }
    do
    {
      return;
      com.tencent.mm.sdk.platformtools.y.l("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[] { Integer.valueOf(this.nBp.xpo), Integer.valueOf(this.nBp.sTf.size()), Boolean.valueOf(this.qIY) });
    } while ((this.nBp.xpo <= 0) || (this.nBp.xpo > 5) || (!a(this.nBp)));
    Object localObject;
    if (this.nBp.xpo == 4)
    {
      bXr();
      if (this.qIU.getVisibility() != 8)
      {
        this.qIU.setVisibility(8);
        this.qIU.onDestroy();
      }
      if (this.qIV.getVisibility() != 8)
      {
        this.qIV.setVisibility(8);
        this.qIV.destroy();
      }
      if ((this.nNs) || (this.qIY))
      {
        localObject = h.nFQ;
        if (!this.qIY) {
          break label1233;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((h)localObject).f(15225, new Object[] { Integer.valueOf(3), Integer.valueOf(i) });
        this.nNs = false;
        return;
        if ((this.nBp.xpo == 1) || (this.nBp.xpo == 2) || (this.nBp.xpo == 3))
        {
          bXr();
          if (this.qIV.getVisibility() != 8)
          {
            this.qIV.setVisibility(8);
            this.qIV.destroy();
          }
          if (this.qIU.getVisibility() == 0) {
            break;
          }
          this.qIU.setVisibility(0);
          this.qIU.post(new WalletSuccPageAwardWidget.1(this));
          break;
        }
        if (this.nBp.xpo != 5) {
          break;
        }
        bXr();
        if (this.qIU.getVisibility() != 8)
        {
          this.qIU.setVisibility(8);
          this.qIU.onDestroy();
        }
        if (this.nBp.xps == null) {
          break label1214;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[] { Integer.valueOf(this.nBp.xps.tPH) });
        switch (this.nBp.xps.tPH)
        {
        default: 
          this.qIV.setVisibility(8);
          this.qIV.destroy();
          break;
        case 1: 
          if (this.qIV.getVisibility() != 0)
          {
            this.qIV.setVisibility(0);
            this.qIV.post(new WalletSuccPageAwardWidget.3(this));
          }
          this.qIV.destroy();
          if (!bk.bl(this.nBp.xps.xpj))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[] { this.nBp.xps.xpj });
            this.qIV.setShakeHintWording(this.nBp.xps.xpj);
          }
          if (!bk.bl(this.nBp.xps.xpk)) {}
          try
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[] { this.nBp.xps.xpk });
            this.qIV.setShakeHintWordingColor(Color.parseColor(this.nBp.xps.xpk));
            if (!bk.bl(this.nBp.xps.xpl))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[] { this.nBp.xps.xpl });
              this.qIV.setAfterHintWording(this.nBp.xps.xpl);
            }
            if (!bk.bl(this.nBp.xps.xpm)) {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[] { this.nBp.xps.xpm });
            }
          }
          catch (Exception localException1)
          {
            try
            {
              this.qIV.setAfterHintWordingColor(Color.parseColor(this.nBp.xps.xpm));
              this.qIV.setShakeOrClickCallback(new WalletSuccPageAwardWidget.4(this));
              localObject = this.qIV;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
              ((WalletAwardShakeAnimView)localObject).mBT = new com.tencent.mm.pluginsdk.i.c(((WalletAwardShakeAnimView)localObject).getContext());
              ((WalletAwardShakeAnimView)localObject).mBT.a(new WalletAwardShakeAnimView.2((WalletAwardShakeAnimView)localObject));
              ((WalletAwardShakeAnimView)localObject).iam = bk.UZ();
              ((WalletAwardShakeAnimView)localObject).setOnClickListener(new WalletAwardShakeAnimView.3((WalletAwardShakeAnimView)localObject));
              ai.S(((WalletAwardShakeAnimView)localObject).qIf);
              ai.l(((WalletAwardShakeAnimView)localObject).qIf, 3000L);
              break;
              localException1 = localException1;
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse animation_wording_color %s error %s", new Object[] { this.nBp.xps.xpk, localException1.getMessage() });
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse after_animation_wording_color %s error %s", new Object[] { this.nBp.xps.xpm, localException2.getMessage() });
              }
            }
          }
        }
      }
      f localf = this.nBp.xps.xpi;
      if (localf == null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { localf.tyu, localf.tyv, Integer.valueOf(localf.tyw) });
      rc localrc = new rc();
      localrc.caq.userName = localf.tyu;
      localrc.caq.cas = bk.aM(localf.tyv, "");
      localrc.caq.scene = 1060;
      localrc.caq.bFv = this.iGK;
      localrc.caq.cat = 0;
      if (localf.tyw > 0) {
        localrc.caq.cau = localf.tyw;
      }
      localrc.caq.context = this.qIX;
      com.tencent.mm.sdk.b.a.udP.m(localrc);
      this.qIY = true;
      this.qJc = false;
      this.dPi.postDelayed(new WalletSuccPageAwardWidget.5(this), 3000L);
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[] { this.nBp.xps.url });
      com.tencent.mm.wallet_core.ui.e.l(this.qIX, this.nBp.xps.url, false);
      this.qIY = true;
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
      this.qIU.setVisibility(8);
      this.qIU.onDestroy();
      label1214:
      this.qIV.setVisibility(8);
      this.qIV.destroy();
      break;
      label1233:
      i = 1;
    }
  }
  
  private void bXp()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.fdt.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.gaI.getLayoutParams();
    localLayoutParams1.addRule(15, -1);
    localLayoutParams2.addRule(15, 0);
    this.fdt.setLayoutParams(localLayoutParams1);
    this.gaI.setLayoutParams(localLayoutParams2);
    this.fdt.setVisibility(0);
    this.gaI.setVisibility(8);
    this.fdt.setText(a.i.wallet_shake_award_net_failed);
    this.fdt.setTextColor(Color.parseColor("#353535"));
    this.gaI.setTextColor(Color.parseColor("#B2B2B2"));
    this.qIS.setVisibility(8);
    findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
    findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
    this.hZu.setVisibility(8);
    this.qFg.setVisibility(0);
    this.qFg.setImageResource(a.e.wallet_pay_shake_award_net_failed_logo);
    this.qIU.setVisibility(8);
    this.qIU.onDestroy();
    this.qIV.setVisibility(8);
    this.qIV.destroy();
  }
  
  private void bXq()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
    if ((this.nBp.xps != null) && (this.nBp.xps.tPH != 1))
    {
      this.qIU.setVisibility(8);
      this.qIU.onDestroy();
      this.qIV.setVisibility(8);
      this.qIV.destroy();
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(this.qIY) });
    if (this.qIY)
    {
      j localj = new j(this.nBp.sTe, this.qqD);
      this.qIX.a(localj, false, false);
    }
  }
  
  private void bXr()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
    Object localObject1 = this.nBp.sTf;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", new Object[] { localObject1, Integer.valueOf(i) });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.qIW = ((b.a.a.g)((List)localObject1).get(0));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[] { Integer.valueOf(0), this.qIW.xpC, this.qIW.xpD, this.qIW.mTc });
        this.qFg.setUrl(this.qIW.mTc);
        if (!bk.bl(this.qIW.mTc)) {
          this.qFg.setVisibility(0);
        }
        if (bk.bl(this.qIW.xpC)) {
          break label1211;
        }
        this.fdt.setText(this.qIW.xpC);
        this.fdt.setVisibility(0);
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!bk.bl(this.qIW.xpF)) {
          this.fdt.setTextColor(Color.parseColor(this.qIW.xpF));
        }
        i = 1;
        if (!bk.bl(this.qIW.xpD))
        {
          this.gaI.setText(this.qIW.xpD);
          this.gaI.setVisibility(0);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!bk.bl(this.qIW.xpG)) {
            this.gaI.setTextColor(Color.parseColor(this.qIW.xpG));
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = (RelativeLayout.LayoutParams)this.fdt.getLayoutParams();
            localObject3 = (RelativeLayout.LayoutParams)this.gaI.getLayoutParams();
            if ((!bk.bl(this.qIW.xpC)) && (bk.bl(this.qIW.xpD)))
            {
              ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
              this.fdt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              this.gaI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.fdt.setVisibility(0);
              this.gaI.setVisibility(8);
            }
          }
          else
          {
            if (bk.bl(this.qIW.xpE)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[] { this.qIW.xpE });
            localObject1 = new c.a();
            ((c.a)localObject1).erf = true;
            ((c.a)localObject1).ere = true;
            ((c.a)localObject1).erh = QS(this.qIW.xpE);
            localObject1 = ((c.a)localObject1).OV();
            o.ON().a(this.qIW.xpE, null, (com.tencent.mm.as.a.a.c)localObject1, new WalletSuccPageAwardWidget.6(this));
            i = this.nBp.sTg;
            localObject3 = this.nBp.sTh;
            if (this.nBp.sTh == null) {
              continue;
            }
            localObject1 = this.nBp.sTh.xpf;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", new Object[] { Integer.valueOf(i), localObject3, localObject1 });
            if ((this.nBp.sTg != 0) && (this.nBp.sTh != null) && (!bk.bl(this.nBp.sTh.xpf))) {
              continue;
            }
            this.hZu.setVisibility(8);
            if (this.fdt.getVisibility() == 0)
            {
              this.fdt.setSingleLine();
              this.fdt.post(new WalletSuccPageAwardWidget.8(this));
            }
            if (this.hZu.getVisibility() != 0) {
              this.fdt.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (this.nBp.xpp != 0) {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[] { Integer.valueOf(this.nBp.xpp) });
            }
            if (!bk.bl(this.nBp.xpr))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[] { this.nBp.xpr });
              if (this.qIT != null)
              {
                this.qIT.setVisibility(0);
                localObject1 = new c.a();
                ((c.a)localObject1).erf = true;
                ((c.a)localObject1).ere = true;
                ((c.a)localObject1).erh = QS(this.nBp.xpr);
                localObject1 = ((c.a)localObject1).OV();
                o.ON().a(this.nBp.xpr, null, (com.tencent.mm.as.a.a.c)localObject1, new WalletSuccPageAwardWidget.9(this));
              }
            }
            return;
            i = 0;
            break;
            localException1 = localException1;
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException1, "parse award_name_color error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException2, "parse award_description_color error: %s", new Object[] { localException2.getMessage() });
          continue;
          if ((bk.bl(this.qIW.xpC)) && (!bk.bl(this.qIW.xpD)))
          {
            localException2.addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            this.fdt.setLayoutParams(localException2);
            this.gaI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.fdt.setVisibility(8);
            this.gaI.setVisibility(0);
            continue;
          }
          localException2.addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, 0);
          this.fdt.setLayoutParams(localException2);
          this.gaI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.fdt.setVisibility(0);
          this.gaI.setVisibility(0);
          continue;
          this.qIS.setVisibility(8);
          findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(0);
          findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(0);
          continue;
          localObject2 = "";
          continue;
          localObject2 = this.nBp.sTh;
          if (localObject2 == null) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[] { ((b.a.a.a)localObject2).xpf, Integer.valueOf(((b.a.a.a)localObject2).xph), ((b.a.a.a)localObject2).xpg, ((b.a.a.a)localObject2).url });
          this.hZu.setText(((b.a.a.a)localObject2).xpf);
          if (!bk.bl(((b.a.a.a)localObject2).xpg))
          {
            localObject3 = getContext().getResources().getDrawable(a.e.btn_solid_green);
            ((Drawable)localObject3).setColorFilter(Color.parseColor(((b.a.a.a)localObject2).xpg), PorterDuff.Mode.SRC);
            this.hZu.setBackground((Drawable)localObject3);
          }
          this.hZu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              int i = 2;
              if ((WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this) != null) && (WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).sTh != null))
              {
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, WalletSuccPageAwardWidget.j(WalletSuccPageAwardWidget.this).sTh);
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph) });
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph != 1) {
                  break label201;
                }
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                com.tencent.mm.wallet_core.ui.e.l(WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url, false);
                WalletSuccPageAwardWidget.m(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                paramAnonymousView = h.nFQ;
                if (!WalletSuccPageAwardWidget.e(WalletSuccPageAwardWidget.this)) {
                  break label665;
                }
              }
              for (;;)
              {
                paramAnonymousView.f(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
                return;
                label201:
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 2)
                {
                  paramAnonymousView = WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xpi;
                  if (paramAnonymousView != null)
                  {
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramAnonymousView.tyu, paramAnonymousView.tyv, Integer.valueOf(paramAnonymousView.tyw) });
                    rc localrc = new rc();
                    localrc.caq.userName = paramAnonymousView.tyu;
                    localrc.caq.cas = bk.aM(paramAnonymousView.tyv, "");
                    localrc.caq.scene = 1060;
                    localrc.caq.bFv = WalletSuccPageAwardWidget.o(WalletSuccPageAwardWidget.this);
                    localrc.caq.cat = 0;
                    if (paramAnonymousView.tyw > 0) {
                      localrc.caq.cau = paramAnonymousView.tyw;
                    }
                    localrc.caq.context = WalletSuccPageAwardWidget.l(WalletSuccPageAwardWidget.this);
                    com.tencent.mm.sdk.b.a.udP.m(localrc);
                    WalletSuccPageAwardWidget.m(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.p(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.q(WalletSuccPageAwardWidget.this).postDelayed(new WalletSuccPageAwardWidget.7.1(this), 3000L);
                  }
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 3)
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 5)
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 6)
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 7)
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                  WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph == 8)
                {
                  WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph), WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).url });
                  WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                  break;
                }
                if (WalletSuccPageAwardWidget.k(WalletSuccPageAwardWidget.this).xph != 9) {
                  break;
                }
                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                WalletSuccPageAwardWidget.n(WalletSuccPageAwardWidget.this);
                break;
                label665:
                i = 1;
              }
            }
          });
          this.hZu.setVisibility(0);
          if ((!this.nNs) && (!this.qIY)) {
            continue;
          }
          localObject2 = h.nFQ;
          if (!this.qIY) {}
        }
      }
      for (i = 2;; i = 1)
      {
        ((h)localObject2).f(15225, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        break;
      }
      label1211:
      i = 0;
    }
  }
  
  private void init(Context paramContext)
  {
    com.tencent.mm.ui.y.gt(paramContext).inflate(a.g.wallet_succ_page_award_widget, this, true);
    this.qIO = ((ViewGroup)findViewById(a.f.content_layout));
    this.qFg = ((CdnImageView)findViewById(a.f.logo_iv));
    this.fdt = ((TextView)findViewById(a.f.name_tv));
    this.gaI = ((TextView)findViewById(a.f.desc_tv));
    this.hZu = ((Button)findViewById(a.f.button));
    this.qIU = ((WalletScratchShakeView)findViewById(a.f.scratch_shake_view));
    this.qIS = ((ImageView)findViewById(a.f.background));
    this.qIV = ((WalletAwardShakeAnimView)findViewById(a.f.shake_view));
    this.qFg.setRoundCorner(true);
    this.qFg.setUseSdcardCache(true);
  }
  
  public final void a(WalletBaseUI paramWalletBaseUI, b.a.a.c paramc, String paramString, boolean paramBoolean, ImageView paramImageView)
  {
    boolean bool2 = true;
    String str = b(paramc);
    boolean bool1;
    if ((paramc == null) || (paramc.xpq == null))
    {
      bool1 = true;
      if (paramImageView != null) {
        break label117;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.qIY), Boolean.valueOf(paramBoolean) });
      this.qIX = paramWalletBaseUI;
      this.nBp = paramc;
      this.qqD = paramBoolean;
      this.iGK = paramString;
      this.qIT = paramImageView;
      bXo();
      return;
      bool1 = false;
      break;
      label117:
      bool2 = false;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    boolean bool = false;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof i))
    {
      paramString = (i)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.qqI;
        if (paramString == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
          bool = true;
        }
      }
    }
    label346:
    label358:
    Object localObject1;
    Object localObject2;
    label852:
    label857:
    do
    {
      return bool;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[] { Integer.valueOf(paramString.ino), paramString.inp, paramString.taS, paramString.qxJ });
      if (paramString.ino == 0)
      {
        if (!bk.bl(paramString.taS))
        {
          Toast.makeText(getContext(), paramString.taS, 1).show();
          return true;
        }
        if (paramString.qxJ != null)
        {
          if (this.nBp.sTh != null)
          {
            paramInt1 = this.nBp.sTh.xph;
            this.nBp = paramString.qxJ;
            if ((paramString.qxJ.sTh != null) && (this.nBp.sTh != null))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[] { Integer.valueOf(paramString.qxJ.sTh.xph) });
              if (paramString.qxJ.sTh.xph == 4)
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                this.nBp.sTh.xph = paramInt1;
              }
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
            bXo();
          }
        }
        else
        {
          if ((this.qJb != null) && (this.qJa))
          {
            if (this.qJb.xph != 8) {
              break label358;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
            com.tencent.mm.wallet_core.ui.e.l(this.qIX, this.qJb.url, false);
            this.qIY = true;
          }
          this.qJb = null;
        }
      }
      for (;;)
      {
        return true;
        paramInt1 = 0;
        break;
        if (this.qJb.xph != 9) {
          break label346;
        }
        paramString = this.qJb.xpi;
        if (paramString == null) {
          break label346;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramString.tyu, paramString.tyv, Integer.valueOf(paramString.tyw) });
        paramm = new rc();
        paramm.caq.userName = paramString.tyu;
        paramm.caq.cas = bk.aM(paramString.tyv, "");
        paramm.caq.scene = 1060;
        paramm.caq.bFv = this.iGK;
        paramm.caq.cat = 0;
        if (paramString.tyw > 0) {
          paramm.caq.cau = paramString.tyw;
        }
        paramm.caq.context = this.qIX;
        com.tencent.mm.sdk.b.a.udP.m(paramm);
        this.qIY = true;
        this.qJc = false;
        this.dPi.postDelayed(new WalletSuccPageAwardWidget.2(this), 3000L);
        break label346;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
        bXp();
      }
      if ((paramm instanceof j))
      {
        paramString = (j)paramm;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = paramString.qqK;
          if (paramString == null)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
            return true;
          }
          paramInt2 = paramString.ino;
          paramm = paramString.inp;
          localObject1 = paramString.sTf;
          i = paramString.sTg;
          localObject2 = paramString.sTh;
          if (paramString.sTh == null) {
            break label852;
          }
          paramInt1 = paramString.sTh.xph;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", new Object[] { Integer.valueOf(paramInt2), paramm, localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(paramInt1) });
          if (paramString.ino == 0)
          {
            this.nBp.sTf = paramString.sTf;
            this.nBp.sTg = paramString.sTg;
            if (this.nBp.sTh == null) {
              break label857;
            }
          }
        }
        for (paramInt1 = this.nBp.sTh.xph;; paramInt1 = 0)
        {
          if (paramString.sTh != null)
          {
            this.nBp.sTh = paramString.sTh;
            if ((this.nBp.sTh != null) && (paramString.sTh.xph == 4))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
              this.nBp.sTh.xph = paramInt1;
            }
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[] { b(this.nBp) });
          bXr();
          this.qIY = false;
          return true;
          paramInt1 = 0;
          break;
        }
      }
    } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.g));
    paramString = (com.tencent.mm.plugin.wallet_core.c.g)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = paramString.qqC;
      if (paramm == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
        return true;
      }
      paramInt1 = paramm.ino;
      localObject1 = paramm.inp;
      localObject2 = paramm.qxJ;
      if (paramm.qxJ != null)
      {
        paramString = paramm.qxJ.sTf;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramString });
        if ((paramm.qxJ == null) || (paramm.qxJ.sTf == null) || (paramm.qxJ.sTf.size() <= 0)) {
          break label1181;
        }
        paramString = paramm.qxJ;
        localObject1 = paramm.qxJ.sTh;
        if (paramm.qxJ.sTh == null) {
          break label1176;
        }
        paramInt1 = paramm.qxJ.sTh.xph;
        label1047:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", new Object[] { paramString, localObject1, Integer.valueOf(paramInt1) });
        paramInt1 = i;
        if (this.nBp.sTh != null) {
          paramInt1 = this.nBp.sTh.xph;
        }
        this.nBp = paramm.qxJ;
        if ((this.nBp.sTh != null) && (paramm.qxJ.sTh != null) && (paramm.qxJ.sTh.xph == 4))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
          this.nBp.sTh.xph = paramInt1;
        }
        bXo();
      }
    }
    for (;;)
    {
      return true;
      paramString = "";
      break;
      label1176:
      paramInt1 = 0;
      break label1047;
      label1181:
      bXp();
      continue;
      bXp();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    if ((this.qIU != null) && (this.qIU.getVisibility() == 0))
    {
      boolean bool2 = bool3;
      WalletScratchShakeView localWalletScratchShakeView;
      if (this.qIU != null)
      {
        localWalletScratchShakeView = this.qIU;
        if (localWalletScratchShakeView.qIq == null) {
          break label117;
        }
        bool1 = localWalletScratchShakeView.qIq.F(paramMotionEvent);
        if (bool1) {}
        localWalletScratchShakeView = this.qIU;
        if (localWalletScratchShakeView.qIq == null) {
          break label122;
        }
      }
      label117:
      label122:
      for (boolean bool1 = localWalletScratchShakeView.qIq.qIK;; bool1 = true)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = this.qIU.dispatchTouchEvent(paramMotionEvent);
        }
        if ((this.qIO == null) || (bool2)) {
          break label127;
        }
        return this.qIO.dispatchTouchEvent(paramMotionEvent);
        bool1 = false;
        break;
      }
    }
    label127:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void init()
  {
    if (this.qIX != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "init");
      this.qIX.kh(1859);
      this.qIX.kh(2547);
      this.qIX.kh(2803);
      this.qIX.kh(2508);
      this.qIX.kh(2529);
      this.qIX.kh(2888);
    }
  }
  
  public final void onDestroy()
  {
    int i = 2;
    Object localObject;
    if (this.qIX != null)
    {
      this.qIX.ki(1859);
      this.qIX.ki(2547);
      this.qIX.ki(2803);
      this.qIX.ki(2508);
      this.qIX.ki(2529);
      this.qIX.ki(2888);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[] { Boolean.valueOf(this.qIZ), Boolean.valueOf(this.qJa) });
      if ((!this.qIZ) && (!this.qJa))
      {
        localObject = h.nFQ;
        if (!this.qIY) {
          break label219;
        }
      }
    }
    for (;;)
    {
      ((h)localObject).f(15225, new Object[] { Integer.valueOf(6), Integer.valueOf(i) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
      localObject = new com.tencent.mm.plugin.wallet_core.c.g(this.nBp.sRh, 4, this.qqD);
      this.qIX.a((m)localObject, false, false);
      if (this.qIU != null) {
        this.qIU.onDestroy();
      }
      if (this.qIV != null) {
        this.qIV.destroy();
      }
      return;
      label219:
      i = 1;
    }
  }
  
  public final void onResume()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", new Object[] { Boolean.valueOf(this.qIY), b(this.nBp), Boolean.valueOf(this.qJc) });
    if (!this.qJc)
    {
      this.qJc = true;
      bXq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget
 * JD-Core Version:    0.7.0.1
 */