package com.tencent.mm.plugin.scanner;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScanCodeSheetItemLogic
  implements p
{
  private x<cuk> MnI;
  private cuk OLV;
  private final cuk OLW;
  private a OLX;
  private b OLY;
  private e OLZ;
  private HashMap<String, cuk> OMa;
  private int OMb;
  private boolean OMc;
  public Context mContext;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.OLV = null;
    this.OLW = new cuk();
    this.OMa = new HashMap();
    this.MnI = new x();
    this.OMc = false;
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.OLV = null;
    this.OLW = new cuk();
    this.OMa = new HashMap();
    this.MnI = new x();
    this.OMc = false;
    this.mContext = paramContext;
    this.OLX = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.OLV = null;
    this.OLW = new cuk();
    this.OMa = new HashMap();
    this.MnI = new x();
    this.OMc = false;
    this.mContext = paramContext;
    this.OLY = paramb;
    AppMethodBeat.o(151571);
  }
  
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (k.cK(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.g.actionsheet_default_appbrand_icon);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_app_brand_in_pic));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (k.cL(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_brand_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.d.scan_default_avatar_icon);
      }
      else if (k.cM(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_personal_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.b.BW_BG_95);
      }
      else if (k.cN(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_group_chat_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.g.default_chatroom);
      }
      else if (k.cO(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_wechat_work_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.b.BW_BG_95);
      }
      else if (k.cR(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_payment_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(bb.m(this.mContext, c.g.icons_outlined_wallet, this.mContext.getResources().getColor(c.b.Brand_100)));
      }
      else if (k.cQ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_reward_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(bb.m(this.mContext, c.g.icon_scan_code_reward, this.mContext.getResources().getColor(c.b.Yellow)));
      }
      else
      {
        if (!k.cT(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_finder_finder_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.d.scan_default_avatar_icon);
      }
    }
    paramString = this.mContext.getString(c.h.scan_pic_qr_code);
    if (!e.e.avx(paramInt)) {
      paramString = this.mContext.getString(c.h.scan_pic_bar_code);
    }
    localObject = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setOnClickListener(paramOnClickListener);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setTitle(paramString);
    AppMethodBeat.o(151577);
    return localObject;
  }
  
  private View a(View.OnClickListener paramOnClickListener, List<ImageQBarDataBean> paramList, ImageQBarDataBean paramImageQBarDataBean)
  {
    AppMethodBeat.i(315092);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.e("MicroMsg.ScanCodeSheetItemLogic", "createQRCodeMenuItemDefault return null,  list is null or empty");
      AppMethodBeat.o(315092);
      return null;
    }
    if (paramImageQBarDataBean != null)
    {
      paramOnClickListener = a(paramOnClickListener, paramImageQBarDataBean.hDb, paramImageQBarDataBean.OGQ);
      AppMethodBeat.o(315092);
      return paramOnClickListener;
    }
    if (paramList.size() == 1)
    {
      paramList = (ImageQBarDataBean)paramList.get(0);
      paramOnClickListener = a(paramOnClickListener, paramList.hDb, paramList.OGQ);
      AppMethodBeat.o(315092);
      return paramOnClickListener;
    }
    paramList = kc(paramList);
    paramImageQBarDataBean = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
    paramImageQBarDataBean.setOnClickListener(paramOnClickListener);
    paramImageQBarDataBean.setTitle(paramList);
    AppMethodBeat.o(315092);
    return paramImageQBarDataBean;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, s params)
  {
    AppMethodBeat.i(315038);
    if (k.cU(paramInt1, paramString))
    {
      params.aAV(paramInt2);
      AppMethodBeat.o(315038);
      return;
    }
    params.a(paramInt2, ahD(paramInt1), c.g.icons_outlined_qr_code);
    AppMethodBeat.o(315038);
  }
  
  private void a(int paramInt1, String paramString, f paramf, s params, int paramInt2)
  {
    AppMethodBeat.i(315034);
    if ((this.OLV == null) || ((!Util.isEqual(this.OLV.aamI, paramString)) && (this.OLV != this.OLW)))
    {
      a(paramInt1, paramString, paramInt2, params);
      AppMethodBeat.o(315034);
      return;
    }
    b(paramInt1, paramString, paramf, params, paramInt2);
    AppMethodBeat.o(315034);
  }
  
  private void b(int paramInt1, String paramString, f paramf, s params, int paramInt2)
  {
    AppMethodBeat.i(315063);
    if (gPo())
    {
      Log.e("MicroMsg.ScanCodeSheetItemLogic", "qrcode banned: %s, remove menu: %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      params.removeItem(paramInt2);
      AppMethodBeat.o(315063);
      return;
    }
    if ((this.OLV.Idd != 0) || (Util.isNullOrNil(this.OLV.UserName)))
    {
      if ((k.cL(paramInt1, paramString)) || (k.cN(paramInt1, paramString)) || (k.cM(paramInt1, paramString)) || (k.cO(paramInt1, paramString)))
      {
        params.a(paramInt2, this.mContext.getString(c.h.scan_identify_qr_code), c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(315063);
        return;
      }
      if (k.cK(paramInt1, paramString))
      {
        params.a(paramInt2, this.mContext.getString(c.h.scan_identify_we_app_code), c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(315063);
        return;
      }
      if (k.cR(paramInt1, paramString))
      {
        params.a(paramInt2, this.mContext.getString(c.h.scan_identify_pay_code), c.g.icons_outlined_wechatpay, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(315063);
        return;
      }
      if (k.cQ(paramInt1, paramString))
      {
        params.a(paramInt2, this.mContext.getString(c.h.scan_identify_reward_code), c.g.icons_outlined_pay_reward_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(315063);
        return;
      }
      paramString = this.mContext.getString(c.h.scan_identify_qr_code);
      if (!e.e.avx(paramInt1)) {
        paramString = this.mContext.getString(c.h.scan_identify_dimens_code);
      }
      params.a(paramInt2, paramString, c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(315063);
      return;
    }
    paramString = this.OLV.UserName;
    Object localObject = new ScanCodeSheetItemLogic.5(this, paramInt2);
    paramf.ageu = ((u.b)localObject);
    paramf.aget = ((u.b)localObject);
    if (this.OLV.aazR == 4)
    {
      params.b(paramInt2, paramString, this.mContext.getString(c.h.scan_app_brand_code), 0);
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 3)
    {
      params.b(paramInt2, paramString, this.mContext.getString(c.h.scan_biz_brand_code), 0);
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 1)
    {
      params.b(paramInt2, paramString, this.mContext.getString(c.h.scan_personal_code), 0);
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 2)
    {
      params.b(paramInt2, paramString, this.mContext.getString(c.h.scan_group_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 7)
    {
      paramf = new SpannableStringBuilder();
      paramString = paramString + " ";
      paramf.append(paramString);
      localObject = "@" + this.OLV.aazW;
      paramf.append((CharSequence)localObject);
      paramf.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(c.b.Orange)), paramString.length(), paramString.length() + ((String)localObject).length(), 33);
      params.b(paramInt2, paramf, this.mContext.getString(c.h.scan_wework_code), 0);
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 6)
    {
      params.b(paramInt2, Util.safeFormatString(this.mContext.getString(c.h.scan_pay_to_someone), new Object[] { this.OLV.UserName }), this.mContext.getString(c.h.scan_pay_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 5)
    {
      params.b(paramInt2, Util.safeFormatString(this.mContext.getString(c.h.scan_reward_to_someone), new Object[] { this.OLV.UserName }), this.mContext.getString(c.h.scan_reward_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(315063);
      return;
    }
    if (this.OLV.aazR == 9) {
      params.b(paramInt2, paramString, this.mContext.getString(c.h.scan_finder_code), 0);
    }
    AppMethodBeat.o(315063);
  }
  
  private View e(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151576);
    if (gPo())
    {
      Log.e("MicroMsg.ScanCodeSheetItemLogic", "qrcode banned, remove menu");
      AppMethodBeat.o(151576);
      return null;
    }
    ViewTitleWithAnimation localViewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
    localViewTitleWithAnimation.hideLoading();
    if ((this.OLV.Idd != 0) || (Util.isNullOrNil(this.OLV.UserName)))
    {
      localViewTitleWithAnimation.jFk();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.OLV.UserName);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.oKo = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.OLV.aazR == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_app_brand_in_pic));
      paramOnClickListener.oKB = c.g.actionsheet_default_appbrand_icon;
      paramOnClickListener.nrc = true;
      com.tencent.mm.modelimage.loader.a.bKl().a(this.OLV.aazV, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bKx());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.OLV.aazR == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_brand_brand_in_pic));
        paramOnClickListener.oKB = c.d.scan_default_avatar_icon;
        paramOnClickListener.nrc = true;
        com.tencent.mm.modelimage.loader.a.bKl().a(this.OLV.aazV, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bKx());
      }
      else if (this.OLV.aazR == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_personal_brand_in_pic));
        paramOnClickListener.oKB = c.b.BW_BG_95;
        com.tencent.mm.modelimage.loader.a.bKl().a(this.OLV.aazV, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bKx());
      }
      else if (this.OLV.aazR == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_group_chat_brand_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageResource(c.g.default_chatroom);
      }
      else if (this.OLV.aazR == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_wechat_work_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!Util.isNullOrNil(this.OLV.aazW)) {
          localViewTitleWithAnimation.setCompanyText(Util.safeFormatString("@%s", new Object[] { this.OLV.aazW }));
        }
        paramOnClickListener.oKB = c.b.BW_BG_95;
        com.tencent.mm.modelimage.loader.a.bKl().a(this.OLV.aazV, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bKx());
      }
      else if (this.OLV.aazR == 6)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(c.h.scan_pay_to_someone), new Object[] { this.OLV.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_payment_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(bb.m(this.mContext, c.g.icons_outlined_wallet, this.mContext.getResources().getColor(c.b.Brand)));
      }
      else if (this.OLV.aazR == 5)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(c.h.scan_reward_to_someone), new Object[] { this.OLV.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_reward_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(bb.m(this.mContext, c.g.icon_scan_code_reward, this.mContext.getResources().getColor(c.b.Yellow)));
      }
      else if (this.OLV.aazR == 9)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_finder_finder_in_pic));
        paramOnClickListener.oKB = c.d.scan_default_avatar_icon;
        paramOnClickListener.nrc = true;
        com.tencent.mm.modelimage.loader.a.bKl().a(this.OLV.aazV, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bKx());
      }
      else
      {
        localViewTitleWithAnimation.jFk();
      }
    }
  }
  
  private boolean gPo()
  {
    return (this.OLV != null) && ((this.OLV.aamo & 0x1) != 0);
  }
  
  public static String kc(List<ImageQBarDataBean> paramList)
  {
    int n = 1;
    AppMethodBeat.i(315025);
    int m = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (m < paramList.size())
    {
      String str = ((ImageQBarDataBean)paramList.get(m)).OGQ;
      int i1 = ((ImageQBarDataBean)paramList.get(m)).hDb;
      if (k.cK(i1, str)) {
        j = 1;
      }
      for (;;)
      {
        m += 1;
        break;
        if (!e.e.avx(i1)) {
          k = 1;
        } else {
          i = 1;
        }
      }
    }
    paramList = new StringBuilder("识别图中");
    if (i != 0) {
      paramList.append("二维码");
    }
    for (i = 1;; i = 0)
    {
      if (k != 0)
      {
        if (i != 0) {
          paramList.append(" / ");
        }
        paramList.append("条码");
        i = n;
      }
      for (;;)
      {
        if (j != 0)
        {
          if (i != 0) {
            paramList.append(" / ");
          }
          paramList.append("小程序码");
        }
        paramList = paramList.toString();
        AppMethodBeat.o(315025);
        return paramList;
      }
    }
  }
  
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.OMb = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.6(this, paramInt2, paramOnClickListener);
    if (this.OLV == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = e(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  public final View a(View.OnClickListener paramOnClickListener, List<ImageQBarDataBean> paramList, ImageQBarDataBean paramImageQBarDataBean, int paramInt)
  {
    AppMethodBeat.i(315137);
    this.OMb = paramInt;
    paramOnClickListener = new ScanCodeSheetItemLogic.7(this, paramInt, paramOnClickListener);
    if (this.OLV != null)
    {
      paramOnClickListener = e(paramOnClickListener);
      AppMethodBeat.o(315137);
      return paramOnClickListener;
    }
    paramOnClickListener = a(paramOnClickListener, paramList, paramImageQBarDataBean);
    AppMethodBeat.o(315137);
    return paramOnClickListener;
  }
  
  public final void a(int paramInt, e.a parama, final a parama1)
  {
    AppMethodBeat.i(315131);
    this.OLV = null;
    final String str = parama.OGM;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(315131);
      return;
    }
    if (this.OLZ == null) {
      this.OLZ = new e();
    }
    if (k.cU(paramInt, str)) {
      this.OLZ.a(paramInt, parama).a(new d.b() {});
    }
    AppMethodBeat.o(315131);
  }
  
  public final void a(ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, f paramf, s params, int paramInt)
  {
    AppMethodBeat.i(315135);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(315135);
      return;
    }
    if (paramArrayList.size() > 1)
    {
      if (paramImageQBarDataBean != null)
      {
        a(paramImageQBarDataBean.hDb, paramImageQBarDataBean.OGQ, paramf, params, paramInt);
        AppMethodBeat.o(315135);
        return;
      }
      params.a(paramInt, kc(paramArrayList), c.g.icons_outlined_qr_code);
      AppMethodBeat.o(315135);
      return;
    }
    a(((ImageQBarDataBean)paramArrayList.get(0)).hDb, ((ImageQBarDataBean)paramArrayList.get(0)).OGQ, paramf, params, paramInt);
    AppMethodBeat.o(315135);
  }
  
  public final String ahD(int paramInt)
  {
    AppMethodBeat.i(315130);
    String str = this.mContext.getString(c.h.scan_identify_qr_code);
    if (!e.e.avx(paramInt)) {
      str = this.mContext.getString(c.h.scan_identify_dimens_code);
    }
    AppMethodBeat.o(315130);
    return str;
  }
  
  public final void b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(315132);
    this.OMc = true;
    this.OLV = null;
    h.ahAA.bFQ("MicroMsg.ScanCodeSheetItemLogic");
    final String str = parama.OGM;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(315132);
      return;
    }
    if (this.OLZ == null) {
      this.OLZ = new e();
    }
    if (k.cU(paramInt, str))
    {
      if (1000L > 0L)
      {
        h.ahAA.bFQ("MicroMsg.ScanCodeSheetItemLogic");
        h.ahAA.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(313293);
            h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(313319);
                if ((ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != null) && (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this)))
                {
                  AppMethodBeat.o(313319);
                  return;
                }
                ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this));
                ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this));
                if (ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this) != null) {
                  ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this).onFetchedCodeInfo();
                }
                if (ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this) != null)
                {
                  ScanCodeSheetItemLogic.b localb = ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this);
                  String str = ScanCodeSheetItemLogic.4.this.OMd;
                  ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this);
                  localb.auF(str);
                }
                AppMethodBeat.o(313319);
              }
            });
            AppMethodBeat.o(313293);
          }
        }, 1000L, "MicroMsg.ScanCodeSheetItemLogic");
      }
      this.OLZ.a(paramInt, parama).a(new d.b() {});
    }
    AppMethodBeat.o(315132);
  }
  
  public final void c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(315133);
    this.OLV = null;
    final String str = parama.OGM;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(315133);
      return;
    }
    if (this.OLZ == null) {
      this.OLZ = new e();
    }
    if (k.cU(paramInt, str)) {
      this.OLZ.a(paramInt, parama).a(new d.b() {});
    }
    AppMethodBeat.o(315133);
  }
  
  public final void cW(int paramInt, String paramString)
  {
    AppMethodBeat.i(151573);
    c(paramInt, new e.a(paramString));
    AppMethodBeat.o(151573);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(315141);
    h.ahAA.bFQ("MicroMsg.ScanCodeSheetItemLogic");
    this.OLV = null;
    this.OMc = false;
    AppMethodBeat.o(315141);
  }
  
  public final void s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    cuk localcuk = new cuk();
    if ((paramInt == 0) && (!Util.isNullOrNil(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localcuk.parseFrom(paramArrayOfByte);
        if ((Util.isNullOrNil(localcuk.aazV)) && (Util.isNullOrNil(localcuk.UserName))) {
          localcuk.Idd = -1;
        }
        this.OLV = localcuk;
        if (this.OLX != null) {
          this.OLX.onFetchedCodeInfo();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localcuk.Idd = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFetchedCodeInfo();
  }
  
  public static abstract interface b
  {
    public abstract void auF(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */