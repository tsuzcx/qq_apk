package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.lifecycle.r;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ScanCodeSheetItemLogic
  implements androidx.lifecycle.k
{
  private r<cei> EiN;
  private cei IFM;
  private final cei IFN;
  private a IFO;
  private b IFP;
  private e IFQ;
  private HashMap<String, cei> IFR;
  private int IFS;
  private boolean IFT;
  public Context mContext;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.IFM = null;
    this.IFN = new cei();
    this.IFR = new HashMap();
    this.EiN = new r();
    this.IFT = false;
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.IFM = null;
    this.IFN = new cei();
    this.IFR = new HashMap();
    this.EiN = new r();
    this.IFT = false;
    this.mContext = paramContext;
    this.IFO = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.IFM = null;
    this.IFN = new cei();
    this.IFR = new HashMap();
    this.EiN = new r();
    this.IFT = false;
    this.mContext = paramContext;
    this.IFP = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (k.bY(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.g.actionsheet_default_appbrand_icon);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_app_brand_in_pic));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (k.bZ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_brand_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.d.scan_default_avatar_icon);
      }
      else if (k.ca(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_personal_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.b.BW_BG_95);
      }
      else if (k.cb(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_group_chat_brand_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.g.default_chatroom);
      }
      else if (k.cc(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_wechat_work_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.b.BW_BG_95);
      }
      else if (k.cf(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_payment_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(au.o(this.mContext, c.g.icons_outlined_wallet, this.mContext.getResources().getColor(c.b.Brand_100)));
      }
      else if (k.ce(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_reward_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(au.o(this.mContext, c.g.icon_scan_code_reward, this.mContext.getResources().getColor(c.b.Yellow)));
      }
      else
      {
        if (!k.ch(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(c.h.scan_go_finder_finder_in_pic));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(c.d.scan_default_avatar_icon);
      }
    }
    paramString = this.mContext.getString(c.h.scan_pic_qr_code);
    if (!e.d.apt(paramInt)) {
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
    AppMethodBeat.i(232042);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.e("MicroMsg.ScanCodeSheetItemLogic", "createQRCodeMenuItemDefault return null,  list is null or empty");
      AppMethodBeat.o(232042);
      return null;
    }
    if (paramImageQBarDataBean != null)
    {
      paramOnClickListener = a(paramOnClickListener, paramImageQBarDataBean.fys, paramImageQBarDataBean.IAH);
      AppMethodBeat.o(232042);
      return paramOnClickListener;
    }
    if (paramList.size() == 1)
    {
      paramList = (ImageQBarDataBean)paramList.get(0);
      paramOnClickListener = a(paramOnClickListener, paramList.fys, paramList.IAH);
      AppMethodBeat.o(232042);
      return paramOnClickListener;
    }
    paramList = hb(paramList);
    paramImageQBarDataBean = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
    paramImageQBarDataBean.setOnClickListener(paramOnClickListener);
    paramImageQBarDataBean.setTitle(paramList);
    AppMethodBeat.o(232042);
    return paramImageQBarDataBean;
  }
  
  @SuppressLint({"ResourceType"})
  private View e(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151576);
    ViewTitleWithAnimation localViewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
    localViewTitleWithAnimation.hideLoading();
    if ((this.IFM.CqV != 0) || (Util.isNullOrNil(this.IFM.UserName)))
    {
      localViewTitleWithAnimation.iad();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.IFM.UserName);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.lRC = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.IFM.TlV == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_app_brand_in_pic));
      paramOnClickListener.lRP = c.g.actionsheet_default_appbrand_icon;
      paramOnClickListener.kPz = true;
      com.tencent.mm.ay.a.a.bms().a(this.IFM.TlW, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bmL());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.IFM.TlV == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_brand_brand_in_pic));
        paramOnClickListener.lRP = c.d.scan_default_avatar_icon;
        paramOnClickListener.kPz = true;
        com.tencent.mm.ay.a.a.bms().a(this.IFM.TlW, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bmL());
      }
      else if (this.IFM.TlV == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_personal_brand_in_pic));
        paramOnClickListener.lRP = c.b.BW_BG_95;
        com.tencent.mm.ay.a.a.bms().a(this.IFM.TlW, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bmL());
      }
      else if (this.IFM.TlV == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_group_chat_brand_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageResource(c.g.default_chatroom);
      }
      else if (this.IFM.TlV == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_wechat_work_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!Util.isNullOrNil(this.IFM.TlX)) {
          localViewTitleWithAnimation.setCompanyText(Util.safeFormatString("@%s", new Object[] { this.IFM.TlX }));
        }
        paramOnClickListener.lRP = c.b.BW_BG_95;
        com.tencent.mm.ay.a.a.bms().a(this.IFM.TlW, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bmL());
      }
      else if (this.IFM.TlV == 6)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(c.h.scan_pay_to_someone), new Object[] { this.IFM.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_payment_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(au.o(this.mContext, c.g.icons_outlined_wallet, this.mContext.getResources().getColor(c.b.Brand)));
      }
      else if (this.IFM.TlV == 5)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(c.h.scan_reward_to_someone), new Object[] { this.IFM.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_reward_in_pic));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(au.o(this.mContext, c.g.icon_scan_code_reward, this.mContext.getResources().getColor(c.b.Yellow)));
      }
      else if (this.IFM.TlV == 9)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(c.h.scan_go_finder_finder_in_pic));
        paramOnClickListener.lRP = c.d.scan_default_avatar_icon;
        paramOnClickListener.kPz = true;
        com.tencent.mm.ay.a.a.bms().a(this.IFM.TlW, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bmL());
      }
      else
      {
        localViewTitleWithAnimation.iad();
      }
    }
  }
  
  public static String hb(List<ImageQBarDataBean> paramList)
  {
    int n = 1;
    AppMethodBeat.i(232030);
    int m = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (m < paramList.size())
    {
      String str = ((ImageQBarDataBean)paramList.get(m)).IAH;
      int i1 = ((ImageQBarDataBean)paramList.get(m)).fys;
      if (k.bY(i1, str)) {
        j = 1;
      }
      for (;;)
      {
        m += 1;
        break;
        if (!e.d.apt(i1)) {
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
        AppMethodBeat.o(232030);
        return paramList;
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.IFS = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.6(this, paramInt2, paramOnClickListener);
    if (this.IFM == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = e(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, List<ImageQBarDataBean> paramList, ImageQBarDataBean paramImageQBarDataBean, int paramInt)
  {
    AppMethodBeat.i(232041);
    this.IFS = paramInt;
    paramOnClickListener = new ScanCodeSheetItemLogic.7(this, paramInt, paramOnClickListener);
    if (this.IFM != null)
    {
      paramOnClickListener = e(paramOnClickListener);
      AppMethodBeat.o(232041);
      return paramOnClickListener;
    }
    paramOnClickListener = a(paramOnClickListener, paramList, paramImageQBarDataBean);
    AppMethodBeat.o(232041);
    return paramOnClickListener;
  }
  
  public final void a(int paramInt, final String paramString, final a parama)
  {
    AppMethodBeat.i(232031);
    this.IFM = null;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(232031);
      return;
    }
    if (this.IFQ == null) {
      this.IFQ = new e();
    }
    if (k.ci(paramInt, paramString)) {
      this.IFQ.bX(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(232031);
  }
  
  public final void a(int paramInt, String paramString, com.tencent.mm.ui.widget.a.e parame, o paramo)
  {
    AppMethodBeat.i(232039);
    if ((this.IFM == null) || ((!Util.isEqual(this.IFM.SZL, paramString)) && (this.IFM != this.IFN)))
    {
      if (k.ci(paramInt, paramString))
      {
        paramString = new p(paramo.mContext, 3, 0);
        paramString.HhK = true;
        paramo.WkP.add(paramString);
        AppMethodBeat.o(232039);
        return;
      }
      paramo.b(3, adg(paramInt), c.g.icons_outlined_qr_code);
      AppMethodBeat.o(232039);
      return;
    }
    if ((this.IFM.CqV != 0) || (Util.isNullOrNil(this.IFM.UserName)))
    {
      if ((k.bZ(paramInt, paramString)) || (k.cb(paramInt, paramString)) || (k.ca(paramInt, paramString)) || (k.cc(paramInt, paramString)))
      {
        paramo.a(3, this.mContext.getString(c.h.scan_identify_qr_code), c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(232039);
        return;
      }
      if (k.bY(paramInt, paramString))
      {
        paramo.a(3, this.mContext.getString(c.h.scan_identify_we_app_code), c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(232039);
        return;
      }
      if (k.cf(paramInt, paramString))
      {
        paramo.a(3, this.mContext.getString(c.h.scan_identify_pay_code), c.g.icons_outlined_wechatpay, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(232039);
        return;
      }
      if (k.ce(paramInt, paramString))
      {
        paramo.a(3, this.mContext.getString(c.h.scan_identify_reward_code), c.g.icons_outlined_pay_reward_code, this.mContext.getResources().getColor(c.b.FG_0));
        AppMethodBeat.o(232039);
        return;
      }
      paramString = this.mContext.getString(c.h.scan_identify_qr_code);
      if (!e.d.apt(paramInt)) {
        paramString = this.mContext.getString(c.h.scan_identify_dimens_code);
      }
      paramo.a(3, paramString, c.g.icons_outlined_qr_code, this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(232039);
      return;
    }
    paramString = this.IFM.UserName;
    Object localObject = new q.b()
    {
      @SuppressLint({"ResourceType"})
      public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198675);
        if (paramAnonymousMenuItem.getItemId() == 7)
        {
          paramAnonymousImageView.setImageDrawable(au.o(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), c.g.icons_outlined_translate, ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this).getResources().getColor(c.b.FG_0)));
          AppMethodBeat.o(198675);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() != this.IFY)
        {
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) == null)
        {
          AppMethodBeat.o(198675);
          return;
        }
        paramAnonymousMenuItem = new c.a();
        paramAnonymousMenuItem.lRC = true;
        paramAnonymousImageView.setBackground(null);
        paramAnonymousImageView.setImageDrawable(null);
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 4)
        {
          paramAnonymousMenuItem.lRP = c.g.actionsheet_default_appbrand_icon;
          paramAnonymousMenuItem.kPz = true;
          com.tencent.mm.ay.a.a.bms().a(ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlW, paramAnonymousImageView, paramAnonymousMenuItem.bmL());
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 3)
        {
          paramAnonymousMenuItem.lRP = c.g.default_avatar_round;
          paramAnonymousMenuItem.kPz = true;
          com.tencent.mm.ay.a.a.bms().a(ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlW, paramAnonymousImageView, paramAnonymousMenuItem.bmL());
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 1)
        {
          paramAnonymousMenuItem.kPz = true;
          paramAnonymousMenuItem.lRW = com.tencent.mm.ci.a.fromDPToPix(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), 4);
          paramAnonymousMenuItem.lRP = c.g.default_avatar;
          com.tencent.mm.ay.a.a.bms().a(ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlW, paramAnonymousImageView, paramAnonymousMenuItem.bmL());
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 2)
        {
          paramAnonymousImageView.setImageDrawable(au.o(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), c.g.icons_outlined_group_detail, ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this).getResources().getColor(c.b.FG_0)));
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 7)
        {
          paramAnonymousMenuItem.kPz = true;
          paramAnonymousMenuItem.lRW = com.tencent.mm.ci.a.fromDPToPix(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), 4);
          paramAnonymousMenuItem.lRP = c.g.default_avatar;
          com.tencent.mm.ay.a.a.bms().a(ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlW, paramAnonymousImageView, paramAnonymousMenuItem.bmL());
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 6)
        {
          paramAnonymousImageView.setImageDrawable(au.o(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), c.g.icons_outlined_wechatpay, ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this).getResources().getColor(c.b.FG_0)));
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 5)
        {
          paramAnonymousImageView.setImageDrawable(au.o(ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this), c.g.icons_outlined_pay_reward_code, ScanCodeSheetItemLogic.g(ScanCodeSheetItemLogic.this).getResources().getColor(c.b.FG_0)));
          AppMethodBeat.o(198675);
          return;
        }
        if (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlV == 9)
        {
          paramAnonymousMenuItem.lRP = c.g.default_avatar_round;
          paramAnonymousMenuItem.kPz = true;
          com.tencent.mm.ay.a.a.bms().a(ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this).TlW, paramAnonymousImageView, paramAnonymousMenuItem.bmL());
        }
        AppMethodBeat.o(198675);
      }
    };
    parame.YmG = ((q.b)localObject);
    parame.YmF = ((q.b)localObject);
    if (this.IFM.TlV == 4)
    {
      paramo.b(3, paramString, this.mContext.getString(c.h.scan_app_brand_code), 0);
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 3)
    {
      paramo.b(3, paramString, this.mContext.getString(c.h.scan_biz_brand_code), 0);
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 1)
    {
      paramo.b(3, paramString, this.mContext.getString(c.h.scan_personal_code), 0);
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 2)
    {
      paramo.b(3, paramString, this.mContext.getString(c.h.scan_group_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 7)
    {
      parame = new SpannableStringBuilder();
      paramString = paramString + " ";
      parame.append(paramString);
      localObject = "@" + this.IFM.TlX;
      parame.append((CharSequence)localObject);
      parame.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(c.b.Orange)), paramString.length(), paramString.length() + ((String)localObject).length(), 33);
      paramo.b(3, parame, this.mContext.getString(c.h.scan_wework_code), 0);
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 6)
    {
      paramo.b(3, Util.safeFormatString(this.mContext.getString(c.h.scan_pay_to_someone), new Object[] { this.IFM.UserName }), this.mContext.getString(c.h.scan_pay_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 5)
    {
      paramo.b(3, Util.safeFormatString(this.mContext.getString(c.h.scan_reward_to_someone), new Object[] { this.IFM.UserName }), this.mContext.getString(c.h.scan_reward_code), this.mContext.getResources().getColor(c.b.FG_0));
      AppMethodBeat.o(232039);
      return;
    }
    if (this.IFM.TlV == 9) {
      paramo.b(3, paramString, this.mContext.getString(c.h.scan_finder_code), 0);
    }
    AppMethodBeat.o(232039);
  }
  
  public final String adg(int paramInt)
  {
    AppMethodBeat.i(232029);
    String str = this.mContext.getString(c.h.scan_identify_qr_code);
    if (!e.d.apt(paramInt)) {
      str = this.mContext.getString(c.h.scan_identify_dimens_code);
    }
    AppMethodBeat.o(232029);
    return str;
  }
  
  public final void ck(int paramInt, final String paramString)
  {
    AppMethodBeat.i(232032);
    this.IFT = true;
    this.IFM = null;
    h.ZvG.bDh("MicroMsg.ScanCodeSheetItemLogic");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(232032);
      return;
    }
    if (this.IFQ == null) {
      this.IFQ = new e();
    }
    if (k.ci(paramInt, paramString))
    {
      if (1000L > 0L)
      {
        h.ZvG.bDh("MicroMsg.ScanCodeSheetItemLogic");
        h.ZvG.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204110);
            h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219884);
                if ((ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != null) && (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this)))
                {
                  AppMethodBeat.o(219884);
                  return;
                }
                ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this));
                ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this));
                if (ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this) != null) {
                  ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this).bPS();
                }
                if (ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this) != null)
                {
                  ScanCodeSheetItemLogic.b localb = ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this);
                  String str = ScanCodeSheetItemLogic.4.this.IFU;
                  ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this);
                  localb.aAx(str);
                }
                AppMethodBeat.o(219884);
              }
            });
            AppMethodBeat.o(204110);
          }
        }, 1000L, "MicroMsg.ScanCodeSheetItemLogic");
      }
      this.IFQ.bX(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(232032);
  }
  
  public final void cl(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.IFM = null;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.IFQ == null) {
      this.IFQ = new e();
    }
    if (k.ci(paramInt, paramString)) {
      this.IFQ.bX(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(232043);
    h.ZvG.bDh("MicroMsg.ScanCodeSheetItemLogic");
    this.IFM = null;
    this.IFT = false;
    AppMethodBeat.o(232043);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    cei localcei = new cei();
    if ((paramInt == 0) && (!Util.isNullOrNil(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localcei.parseFrom(paramArrayOfByte);
        if ((Util.isNullOrNil(localcei.TlW)) && (Util.isNullOrNil(localcei.UserName))) {
          localcei.CqV = -1;
        }
        this.IFM = localcei;
        if (this.IFO != null) {
          this.IFO.bPS();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localcei.CqV = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bPS();
  }
  
  public static abstract interface b
  {
    public abstract void aAx(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */