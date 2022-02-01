package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.c.c;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.ae;
import com.tencent.mm.an.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.autogen.a.ei;
import com.tencent.mm.autogen.a.ei.b;
import com.tencent.mm.autogen.a.em;
import com.tencent.mm.autogen.a.em.b;
import com.tencent.mm.autogen.a.ug;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.ct;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.ezt;
import com.tencent.mm.protocal.protobuf.ezu;
import com.tencent.mm.protocal.protobuf.fkn;
import com.tencent.mm.protocal.protobuf.fko;
import com.tencent.mm.protocal.protobuf.gjj;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements com.tencent.mm.am.h, i.b, com.tencent.mm.an.p, com.tencent.mm.pluginsdk.c.a
{
  private static final String MXg;
  private com.tencent.mm.api.c MVg;
  private boolean MVt;
  private String MVy;
  private com.tencent.mm.an.a.k MWW;
  private List<WxaAttributes.WxaEntryInfo> MWX;
  private ahl MWY = null;
  private boolean MWZ = false;
  private boolean MXa = false;
  private boolean MXb = false;
  private int MXc = 0;
  private String MXd;
  private boolean MXe;
  com.tencent.mm.ui.widget.a.e MXf = null;
  private Bundle MXh;
  private SnsAdClick MXi = null;
  private String MXj = null;
  private au contact;
  private List<c.a> hcB;
  private com.tencent.mm.api.c.b hcC;
  private boolean hcJ = false;
  private String hcL;
  private boolean isDeleteCancel = false;
  private CheckBoxPreference lAb;
  private boolean lAj;
  private MMActivity lzt;
  String pPi;
  private int pUt;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  private w tipDialog = null;
  
  static
  {
    AppMethodBeat.i(305781);
    MXg = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(305781);
  }
  
  private d(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public d(MMActivity paramMMActivity, String paramString, ahl paramahl)
  {
    this(paramMMActivity);
    this.MVy = paramString;
    this.MWY = paramahl;
  }
  
  private void As(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.MVg.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.a.d((String)localObject, paramBoolean);
      bh.aZW().a(1394, this);
      bh.aZW().a((com.tencent.mm.am.p)localObject, 0);
      MMActivity localMMActivity = this.lzt;
      this.lzt.getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.k.a(localMMActivity, this.lzt.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          bh.aZW().a(this.vDV);
          bh.aZW().b(1394, d.this);
          AppMethodBeat.o(27084);
        }
      });
      AppMethodBeat.o(27091);
      return;
    }
  }
  
  private void At(boolean paramBoolean)
  {
    AppMethodBeat.i(305683);
    if (!this.contact.iZC())
    {
      AppMethodBeat.o(305683);
      return;
    }
    try
    {
      Object localObject = (FrameLayout)this.lzt.findViewById(R.h.preference_bottom);
      if (localObject == null) {
        break label211;
      }
      if (paramBoolean)
      {
        localObject = ((FrameLayout)localObject).findViewById(R.h.fBM);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        AppMethodBeat.o(305683);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "isShowExposeBtn Exception: " + localException.getMessage());
      AppMethodBeat.o(305683);
      return;
    }
    if (localException.findViewById(R.h.fBM) == null)
    {
      LinearLayout localLinearLayout = (LinearLayout)com.tencent.mm.ui.af.mU(this.lzt).inflate(R.i.ghK, null);
      TextView localTextView = (TextView)localLinearLayout.findViewById(R.h.fCn);
      localTextView.setText(this.lzt.getResources().getString(R.l.contact_info_expose));
      localTextView.setTextColor(this.lzt.getResources().getColor(R.e.brand_text_color));
      localTextView.setOnClickListener(new d.20(this));
      localException.addView(localLinearLayout);
    }
    localException.setVisibility(0);
    this.screen.eh("contact_info_expose_btn", true);
    label211:
    AppMethodBeat.o(305683);
  }
  
  private void Au(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.lzt != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.an.g.Dn(this.contact.field_username))) {
          break label77;
        }
        this.lzt.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.setChecked(paramBoolean);
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.lzt.setTitleMuteIconVisibility(8);
    }
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
    doz localdoz = new doz();
    localdoz.pSt = paramc.field_brandFlag;
    localdoz.UserName = this.contact.field_username;
    if (afM(this.pUt))
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(58, localdoz));
    }
    for (;;)
    {
      com.tencent.mm.an.af.bHf().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.aAH());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.aAI());
      }
      if (paramBoolean) {
        gBx();
      }
      AppMethodBeat.o(27092);
      return;
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(47, localdoz));
    }
  }
  
  private static boolean aRW(String paramString)
  {
    AppMethodBeat.i(27099);
    try
    {
      long l = Util.getLong(paramString, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L))
      {
        AppMethodBeat.o(27099);
        return true;
      }
      AppMethodBeat.o(27099);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(27099);
    }
    return false;
  }
  
  private void aRX(String paramString)
  {
    AppMethodBeat.i(27105);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.MXe) });
    if (this.MXe)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.MXd = paramString;
    if ((this.hcC == null) || (!this.hcC.aBq()) || (this.contact == null))
    {
      this.screen.eh("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.an.af.bHe().MI(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.eh("contact_info_kf_worker", true);
        com.tencent.mm.an.af.bHg().a(this);
        com.tencent.mm.an.af.bHg().bu(this.contact.field_username, z.bAM());
        this.MXe = true;
        AppMethodBeat.o(27105);
        return;
      }
      Log.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.eh("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.bAi("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).aS(paramString.field_nickname);
      localObject2 = com.tencent.mm.modelavatar.d.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aRY(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).av((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = com.tencent.mm.an.af.bHe();
    Object localObject1 = ((com.tencent.mm.an.j)localObject2).MH(paramString);
    if ((localObject1 == null) || (com.tencent.mm.an.j.a((com.tencent.mm.an.h)localObject1)))
    {
      com.tencent.mm.an.af.bHg().a(this);
      com.tencent.mm.an.af.bHg().m(this.contact.field_username, paramString, 1);
      this.MXe = true;
    }
    if (localObject1 == null) {
      Log.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.an.j)localObject2).MI(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.eh("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.eh("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.bAi("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).aS(paramString.field_nickname);
      localObject2 = com.tencent.mm.modelavatar.d.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aRY(paramString.field_openId);
      }
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).av((Bitmap)localObject2);
      }
    }
  }
  
  private void aRY(final String paramString)
  {
    AppMethodBeat.i(27106);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305528);
        if (d.l(d.this) == null)
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
          AppMethodBeat.o(305528);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)d.l(d.this).bAi("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (d.l(d.this) != null))
        {
          Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
          if (localBitmap != null)
          {
            Log.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.av(localBitmap);
            d.l(d.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(305528);
      }
    }, 2000L);
    AppMethodBeat.o(27106);
  }
  
  private String afL(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.lzt.getResources().getString(R.l.gBu);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.lzt.getResources().getString(R.l.contact_info_verify_user_title);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.lzt.getResources().getString(R.l.gvU);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.lzt.getResources().getString(R.l.gvV);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean afM(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static void c(com.tencent.mm.an.h paramh)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.modelavatar.k localk = q.bFE();
    if (localk.LS(paramh.field_openId) == null)
    {
      com.tencent.mm.modelavatar.j localj = new com.tencent.mm.modelavatar.j();
      localj.username = paramh.field_openId;
      localj.osM = paramh.field_headImgUrl;
      localj.gX(false);
      localj.jZY = 3;
      localk.b(localj);
    }
    q.bFG().LC(paramh.field_openId);
    Log.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.MXh == null) || ((this.pUt != 39) && (this.pUt != 56) && (this.pUt != 35) && (this.pUt != 87) && (this.pUt != 88) && (this.pUt != 89) && (this.pUt != 85)))
    {
      Log.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27100);
      return;
    }
    if (this.contact == null)
    {
      Log.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      AppMethodBeat.o(27100);
      return;
    }
    String str2 = this.MXh.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.MXh.getString("Contact_Ext_Args_Query_String"));
    int j = this.MXh.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.pUt)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.MXh.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      Log.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10866, paramString);
      AppMethodBeat.o(27100);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
    }
  }
  
  private boolean gBA()
  {
    AppMethodBeat.i(27102);
    if (this.lzt.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.lzt.getIntent().getStringExtra("device_id");
    String str2 = this.lzt.getIntent().getStringExtra("device_type");
    em localem = new em();
    localem.hEt.hEl = str1;
    localem.hEt.hEr = str2;
    localem.publish();
    boolean bool = localem.hEu.hEv;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void gBB()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format(MXg, new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.c.b(this.lzt, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  private void gBC()
  {
    AppMethodBeat.i(27111);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.lzt.getSharedPreferences(this.lzt.getPackageName() + "_preferences", 0);
    }
    if (this.lAb != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.aSQ()).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(27111);
      return;
      label119:
      this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
    }
  }
  
  private void gBx()
  {
    AppMethodBeat.i(27094);
    dvq();
    this.screen.removeAll();
    this.screen.aBe(R.o.haK);
    if (this.MXb) {
      this.screen.eh("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.an.g.hU(this.contact.field_username);
    this.hcB = null;
    this.hcC = null;
    this.MWX = null;
    if (((localc == null) || (localc.dO(false) == null)) && (this.MWY != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.MWY.pSt;
      localc.field_brandIconURL = this.MWY.pSw;
      localc.field_brandInfo = this.MWY.pSv;
      localc.field_extInfo = this.MWY.pSu;
    }
    label484:
    label2278:
    label2295:
    label5495:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.MWY != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.MWY.pSt;
        localc.field_brandIconURL = this.MWY.pSw;
        localc.field_brandInfo = this.MWY.pSv;
        localc.field_extInfo = this.MWY.pSu;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.bAi("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!Util.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.MVy, localc);
        this.screen.eh("biz_placed_to_the_top", true);
        this.screen.eh("contact_info_biz_enable", true);
        this.screen.eh("contact_info_biz_disable", true);
        this.screen.eh("contact_info_stick_biz", true);
        At(false);
        if (localc == null) {
          break label2295;
        }
        if (!localc.aAQ()) {
          break label1867;
        }
        this.screen.eh("contact_info_biz_add", true);
        this.screen.eh("contact_info_expose_btn", true);
        At(true);
        this.screen.eh("contact_is_mute", false);
        this.lAj = this.contact.aGe();
        if (!localc.aAR()) {
          break label1582;
        }
        this.screen.eh("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.contact.d.rs(this.contact.field_type)) {
          break label1576;
        }
        bool = true;
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.bAi("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).setChecked(this.contact.aSQ());
        ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_chat_placetop);
        gBC();
        Au(this.lAj);
        this.MVg = localc;
        this.hcB = localc.aAY();
        this.hcC = localc.dO(false);
        this.MWX = this.hcC.getWxaEntryInfoList();
        if (!this.hcC.aAZ()) {
          break label2180;
        }
        this.screen.bAi("near_field_service").aBk(R.l.weixin_connect_wifi);
        if (this.hcC.aBf() == null) {
          break label2261;
        }
        this.MXa = true;
        if (aRW(this.hcC.aBf())) {
          break label2197;
        }
        this.screen.eh("contact_info_time_expired", true);
        if ((au.bwx(this.contact.field_username)) || (ab.Jd(this.contact.field_username))) {
          gBy();
        }
        if ((this.hcC.aBc() != null) && (this.hcC.aBc().length() > 0)) {
          this.hcL = this.hcC.aBc();
        }
        this.hcJ = this.hcC.aBa();
        if (Util.isNullOrNil(this.hcC.aBp())) {
          break label2278;
        }
        this.screen.eh("contact_info_service_phone", false);
        localObject1 = this.screen.bAi("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).aS(this.hcC.aBp());
          ((Preference)localObject1).wKL = this.lzt.getResources().getColor(R.e.link_color);
        }
      }
      Object localObject2;
      Object localObject4;
      Object localObject6;
      label1016:
      label1149:
      int i;
      for (;;)
      {
        Object localObject7;
        if (!Util.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.bAi("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (Util.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.eh("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.hcC == null) || (this.hcC.aBk() == null) || (Util.isNullOrNil(this.hcC.aBk().hdy))) {
              break label2689;
            }
            localObject4 = this.hcC.aBk();
            localObject6 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2672;
            }
            ((KeyValuePreference)localObject6).adZa = false;
            if (!Util.isNullOrNil(((c.b.e)localObject4).hdz)) {
              break label2563;
            }
            ((KeyValuePreference)localObject6).JAf = afL(((c.b.e)localObject4).hdx);
            if (az.a.okR == null) {
              break label2576;
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5495;
            }
            localObject2 = new BitmapDrawable(this.lzt.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2582;
            }
            bool = true;
            Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).adZh = ((Drawable)localObject2);
            if (((c.b.e)localObject4).hdy == null) {
              break label2621;
            }
            localObject7 = ((c.b.e)localObject4).hdB;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, ((c.b.e)localObject4).hdy.trim());
            if (Util.isNullOrNil((String)localObject7)) {
              break label5488;
            }
          }
        }
        try
        {
          localObject1 = new SpannableString((String)localObject7 + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          localObject1 = localObject2;
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, ((String)localObject7).length(), 17);
          ((KeyValuePreference)localObject6).aS((CharSequence)localObject1);
          if (!ab.bBX()) {
            break label2632;
          }
          ((KeyValuePreference)localObject6).aBq(8);
          if ((this.hcC == null) || (Util.isNullOrNil(this.hcC.aBe()))) {
            break label2843;
          }
          localObject2 = (KeyValuePreference)this.screen.bAi("contact_info_trademark");
          if (localObject2 == null) {
            break label1333;
          }
          ((KeyValuePreference)localObject2).adZa = false;
          if (az.a.okR == null) {
            break label2831;
          }
          localObject1 = BitmapUtil.getBitmapNative(R.k.biz_info_trademark_protection);
          if (localObject1 != null) {
            break label2837;
          }
          bool = true;
          Log.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5482;
          }
          localObject1 = new BitmapDrawable(this.lzt.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            j = k;
          }
          localObject1 = null;
          break label1282;
        }
        ((KeyValuePreference)localObject2).adZh = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).aS(this.hcC.aBe());
        Log.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.hcC.aBe(), this.hcC.aBd() });
        if ((this.hcC == null) || (this.hcC.aBg() == null) || (this.hcC.aBg().size() <= 0)) {
          break label2868;
        }
        localObject2 = (KeyValuePreference)this.screen.bAi("contact_info_privilege");
        ((KeyValuePreference)localObject2).LG(false);
        ((KeyValuePreference)localObject2).jnq();
        localObject4 = this.hcC.aBg().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.lzt, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.c.c(this.lzt.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.lzt.getResources().getIdentifier(((c.b.g)localObject7).hdG, "string", this.lzt.getPackageName());
          if (i > 0) {
            localObject1 = this.lzt.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).lh((View)localObject6);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.eh("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label484;
        this.screen.eh("contact_info_subscribe_bizinfo", true);
        this.screen.eh("contact_info_biz_go_chatting", true);
        if (localc.aAH())
        {
          this.screen.eh("contact_info_biz_enable", true);
          this.screen.eh("contact_info_biz_disable", false);
          this.screen.bAi("contact_info_biz_disable").setTitle(R.l.enterprise_contact_info_disable_sub);
          this.screen.eh("contact_is_mute", false);
          this.screen.eh("biz_placed_to_the_top", false);
          this.lAb = ((CheckBoxPreference)this.screen.bAi("biz_placed_to_the_top"));
          this.lAb.setTitle(R.l.enterprise_sub_placetop);
          gBC();
          if (!localc.aAS()) {
            break label538;
          }
          this.screen.eh("contact_info_locate", true);
          break label538;
        }
        this.screen.eh("contact_info_biz_enable", false);
        this.screen.eh("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.bAi("contact_info_biz_enable")).iN(this.lzt.getResources().getString(R.l.enterprise_contact_info_enable_sub), this.lzt.getResources().getColor(R.e.brand_text_color));
        this.screen.eh("contact_is_mute", true);
        this.screen.eh("biz_placed_to_the_top", true);
        this.screen.eh("contact_info_locate", true);
        break label538;
        if (localc.aAP())
        {
          this.screen.eh("contact_info_locate", true);
          this.screen.eh("contact_info_subscribe_bizinfo", false);
          this.screen.eh("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.bAi("contact_info_biz_go_chatting")).iN(this.lzt.getResources().getString(R.l.enterprise_contact_info_enter), this.lzt.getResources().getColor(R.e.brand_text_color));
          localObject1 = this.screen;
          if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.bAi("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).setChecked(this.contact.aSQ());
            ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_father_placetop);
            gBC();
            this.screen.eh("contact_is_mute", false);
            this.lAj = this.contact.aGe();
            Au(this.lAj);
            break;
          }
        }
        localObject1 = this.screen;
        if ((au.bwc(this.contact.field_username)) || (!com.tencent.mm.contact.d.rs(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.bAi("contact_info_stick_biz")).setChecked(this.contact.aSQ());
          this.screen.eh("contact_is_mute", true);
          this.lAj = false;
          break;
        }
        this.screen.eh("near_field_service", true);
        break label610;
        this.MWZ = true;
        if (!com.tencent.mm.contact.d.rs(this.contact.field_type))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          gBy();
          break label652;
        }
        this.screen.eh("contact_info_time_expired", true);
        break label652;
        this.screen.eh("contact_info_time_expired", true);
        break label682;
        this.screen.eh("contact_info_service_phone", true);
        continue;
        this.screen.eh("contact_info_time_expired", true);
        Log.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).adZa = false;
        ((KeyValuePreference)localObject2).JAf = this.lzt.getString(R.l.gBu);
        ((KeyValuePreference)localObject2).aS(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, this.contact.signature));
        ((KeyValuePreference)localObject2).LG(false);
        if (az.a.okR != null)
        {
          localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(this.contact.field_verifyFlag), 2.0F);
          if (localObject1 != null) {
            break label2511;
          }
          bool = true;
          Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5501;
          }
        }
      }
      label4344:
      label4474:
      label5501:
      for (localObject1 = new BitmapDrawable(this.lzt.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).adZh = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).adZf = 8;
        ((KeyValuePreference)localObject2).aBq(8);
        if ((!au.bwJ(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
          break;
        }
        ((KeyValuePreference)localObject2).aS(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, ct.Ki("BRAND_Team")));
        break;
        localObject1 = null;
        break label2393;
        bool = false;
        break label2401;
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.eh("contact_info_user_desc", true);
        if (this.MWZ) {
          break;
        }
        this.screen.eh("contact_info_time_expired", true);
        break;
        ((KeyValuePreference)localObject6).JAf = ((c.b.e)localObject4).hdz;
        break label966;
        localObject1 = null;
        break label993;
        bool = false;
        break label1024;
        Log.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1149;
        Log.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1156;
        if ((!au.bwJ(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
          break label1169;
        }
        ((KeyValuePreference)localObject6).aS(ct.Ki("OfficialEntity"));
        ((KeyValuePreference)localObject6).aBq(8);
        break label1169;
        this.screen.eh("contact_info_verifyuser", true);
        break label1169;
        if ((this.hcC != null) && (this.hcC.aBl() != null) && (!Util.isNullOrNil(this.hcC.aBl().hdH)))
        {
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1169;
          }
          ((KeyValuePreference)localObject1).aS(this.hcC.aBl().hdH);
          if ((!au.bwJ(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
            break label1169;
          }
          ((KeyValuePreference)localObject1).aS(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, ct.Ki("OfficialEntity")));
          ((KeyValuePreference)localObject1).aBq(8);
          break label1169;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.eh("contact_info_verifyuser", true);
        break label1169;
        localObject1 = null;
        break label1231;
        bool = false;
        break label1239;
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.eh("contact_info_trademark", true);
        break label1333;
        this.screen.eh("contact_info_privilege", true);
        int k = this.screen.cs("contact_info_category2");
        if ((k >= 0) && (this.hcB != null) && (this.hcB.size() > 0)) {
          i = this.hcB.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.hcB.get(i) != null) && ((!this.lzt.getString(R.l.gAZ).equals(((c.a)this.hcB.get(i)).title)) || (this.hcJ)) && ((!Util.isNullOrNil(((c.a)this.hcB.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.hcB.get(i)).hcF))))
          {
            localObject5 = new Preference(this.lzt);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.hcB.get(i)).title;
            j = this.lzt.getResources().getIdentifier(((c.a)this.hcB.get(i)).hcF, "string", this.lzt.getPackageName());
            if (j > 0) {
              localObject1 = this.lzt.getString(j);
            }
            if ((au.bwJ(this.contact.field_username)) && (((String)localObject1).equals(this.lzt.getString(R.l.gpt)))) {
              this.screen.eh(((Preference)localObject5).mKey, true);
            }
            localObject2 = localObject1;
            if (this.MVg.aAO()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.hcB.get(i)).hcF))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.lzt.getString(R.l.gpt))) {}
              }
              else
              {
                localObject2 = this.lzt.getString(R.l.enterprise_brand_history);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!Util.isNullOrNil(((c.a)this.hcB.get(i)).description)) {
              ((Preference)localObject5).aS(((c.a)this.hcB.get(i)).description);
            }
            if (!Util.nullAsNil(((c.a)this.hcB.get(i)).hcF).equals("__mp_wording__brandinfo_feedback")) {
              break label5477;
            }
            j = this.screen.cs("contact_info_scope_of_business");
            if (j <= 0) {
              break label5477;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (Util.nullAsNil(((c.a)this.hcB.get(i)).hcF).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.lzt);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          Log.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.MWZ) && (ab.R(this.contact)) && (this.contact.kai != null) && (!this.contact.kai.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).aS(Util.nullAs(this.contact.field_weiboNickname, "") + this.lzt.getString(R.l.settings_show_weibo_field, new Object[] { ab.Jc(this.contact.kai) }));
            ((Preference)localObject1).wKL = com.tencent.mm.cd.a.w(this.lzt, R.e.link_color);
            ((KeyValuePreference)localObject1).LG(false);
          }
          if ((this.hcC == null) || (this.hcC.aBi() == null)) {
            break label4395;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bAi("contact_info_reputation");
          if (this.hcC.aBi().hdC <= 0) {
            break label4344;
          }
          ((BizInfoPayInfoIconPreference)localObject1).afF(this.hcC.aBi().hdC);
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bAi("contact_info_guarantee_info");
          if ((this.hcC.aBi().hdE == null) || (this.hcC.aBi().hdE.size() <= 0)) {
            break label4361;
          }
          ((BizInfoPayInfoIconPreference)localObject1).jv(this.hcC.aBi().hdE);
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.hcC.aBi().hdD)) {
            break label4378;
          }
          ((KeyValuePreference)localObject1).aS(this.hcC.aBi().hdD);
          ((KeyValuePreference)localObject1).adZf = 4;
          ((KeyValuePreference)localObject1).LG(false);
          if ((this.MWX == null) || (this.MWX.size() <= 0)) {
            break label4440;
          }
          this.screen.eh("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.bAi("contact_info_bindwxainfo")).a(this.MVg, this.MWX);
          aRX(this.lzt.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          Log.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.lzt.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.lzt.getIntent() == null) || (!this.lzt.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4762;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = gBA();
          Log.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rs(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.contact.d.rs(this.contact.field_type)) || (!bool)) {
            break label4593;
          }
          if (localc == null) {
            break label4548;
          }
          localObject1 = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
          if (!localc.aAR()) {
            break label4474;
          }
          localObject5 = com.tencent.mm.an.af.bHj().hN(localc.field_username);
          this.MWW = com.tencent.mm.an.af.bHj().hM((String)localObject5);
          if (this.MWW == null) {
            break label4463;
          }
          if (this.MWW.nG(4)) {
            break label4457;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).setChecked(bool);
          if (!localc.aAH()) {
            break label4504;
          }
          if ((this.hcC == null) && (localc != null)) {
            this.hcC = localc.dO(false);
          }
          if ((this.hcC == null) || (!this.hcC.aBb()) || (!com.tencent.mm.br.c.blq("brandservice"))) {
            break label4487;
          }
          this.screen.eh("contact_info_template_recv", false);
          if (!localc.dO(false).aAL()) {
            break label4521;
          }
          ((CheckBoxPreference)localObject2).setChecked(localc.aAI());
        }
        for (;;)
        {
          this.screen.eh("contact_info_biz_read_msg_online", true);
          this.screen.eh("contact_info_biz_add", true);
          localObject1 = this.contact.aSV();
          if (localObject1 != null) {
            this.lzt.setMMTitle((String)localObject1);
          }
          if (au.bwc(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.bAi("contact_info_biz_go_chatting")).iN(this.lzt.getResources().getString(R.l.gBV), this.lzt.getResources().getColor(R.e.brand_text_color));
            this.lzt.setMMTitle(R.l.gCY);
          }
          if ((!au.bwx(this.contact.field_username)) && (this.MVg != null) && (!this.MVg.aAQ())) {
            this.lzt.addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(27087);
                d.b(d.this);
                AppMethodBeat.o(27087);
                return true;
              }
            });
          }
          AppMethodBeat.o(27094);
          return;
          this.screen.eh("contact_info_verifyuser_weibo", true);
          break;
          this.screen.eh("contact_info_reputation", true);
          break label3635;
          this.screen.eh("contact_info_guarantee_info", true);
          break label3698;
          this.screen.eh("contact_info_scope_of_business", true);
          break label3758;
          this.screen.eh("contact_info_reputation", true);
          this.screen.eh("contact_info_guarantee_info", true);
          this.screen.eh("contact_info_scope_of_business", true);
          break label3758;
          this.screen.eh("contact_info_bindwxainfo", true);
          break label3817;
          bool = false;
          break label4054;
          Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label4061;
          ((CheckBoxPreference)localObject1).setChecked(localc.aAH());
          break label4061;
          this.screen.eh("contact_info_template_recv", true);
          break label4131;
          this.screen.eh("contact_info_template_recv", true);
          break label4131;
          this.screen.eh("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).setChecked(localc.aAI());
          continue;
          this.screen.eh("contact_info_subscribe_bizinfo", true);
          this.screen.eh("contact_info_locate", true);
          this.screen.eh("contact_info_template_recv", true);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        gBy();
        localObject1 = this.screen.bAi("contact_info_biz_add");
        Log.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.MXa) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(R.l.gAP);
          }
        }
        else if (afM(this.pUt))
        {
          if (localc != null) {
            break label4722;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.lzt.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(R.l.gAI);
          break;
          ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(localc.aAH());
          this.screen.eh("contact_info_subscribe_bizinfo", false);
        }
        if (com.tencent.mm.contact.d.rs(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
            if (localc.aAR())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_chat_receive_msg);
              localObject5 = com.tencent.mm.an.af.bHj().hN(localc.field_username);
              this.MWW = com.tencent.mm.an.af.bHj().hM((String)localObject5);
              if (this.MWW != null) {
                if (!this.MWW.nG(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).setChecked(bool);
                  if (!localc.aAH()) {
                    break label5245;
                  }
                  if ((this.hcC == null) && (localc != null)) {
                    this.hcC = localc.dO(false);
                  }
                  if ((this.hcC == null) || (!this.hcC.aBb()) || (!com.tencent.mm.br.c.blq("brandservice"))) {
                    break label5228;
                  }
                  this.screen.eh("contact_info_template_recv", false);
                  if (!localc.dO(false).aAL()) {
                    break label5262;
                  }
                  ((CheckBoxPreference)localObject2).setChecked(localc.aAI());
                }
              }
            }
          }
          for (;;)
          {
            this.screen.eh("contact_info_biz_read_msg_online", true);
            this.screen.eh("contact_info_biz_add", true);
            localObject1 = this.contact.aSV();
            if (localObject1 != null) {
              this.lzt.setMMTitle((String)localObject1);
            }
            if (au.bwc(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.bAi("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).DWD = true;
              ((ButtonPreference)localObject1).iN(this.lzt.getResources().getString(R.l.gBV), this.lzt.getResources().getColor(R.e.brand_text_color));
              this.lzt.setMMTitle(R.l.gCY);
            }
            if ((!au.bwx(this.contact.field_username)) && (this.MVg != null)) {
              this.lzt.addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(27088);
                  d.b(d.this);
                  AppMethodBeat.o(27088);
                  return true;
                }
              });
            }
            AppMethodBeat.o(27094);
            return;
            bool = false;
            break;
            Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label4883;
            if (localc.aAP())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_father_receive_msg);
              if (!com.tencent.mm.an.af.bHq().Mm(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).setChecked(bool);
                break;
              }
            }
            ((CheckBoxPreference)localObject1).setChecked(localc.aAH());
            break label4883;
            this.screen.eh("contact_info_template_recv", true);
            break label4953;
            label5245:
            this.screen.eh("contact_info_template_recv", true);
            break label4953;
            this.screen.eh("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).setChecked(localc.aAI());
            continue;
            this.screen.eh("contact_info_subscribe_bizinfo", true);
            this.screen.eh("contact_info_locate", true);
            this.screen.eh("contact_info_template_recv", true);
          }
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        gBy();
        localObject1 = this.screen.bAi("contact_info_biz_add");
        if ((localObject1 != null) && (this.MXa)) {
          ((Preference)localObject1).setTitle(R.l.gAP);
        }
        if (afM(this.pUt))
        {
          if (localc != null) {
            break label5432;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.lzt.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(localc.aAH());
          this.screen.eh("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1149;
        Object localObject3 = null;
        break label1016;
      }
    }
  }
  
  private void gBy()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.contact.d.rs(this.contact.field_type)) && (!au.bwc(this.contact.field_username)) && (!ab.Jd(this.contact.field_username)))
    {
      this.screen.eh("contact_is_mute", false);
      this.screen.eh("contact_info_verifyuser_weibo", true);
      this.screen.eh("contact_info_subscribe_bizinfo", true);
      this.screen.eh("contact_info_template_recv", true);
      this.screen.eh("contact_info_locate", true);
      if (this.MWZ) {
        break label325;
      }
      this.screen.eh("contact_info_time_expired", true);
      label143:
      if ((this.contact == null) || ((!au.bwx(this.contact.field_username)) && (!ab.Jd(this.contact.field_username))) || (!com.tencent.mm.contact.d.rs(this.contact.field_type))) {
        break label342;
      }
      this.screen.eh("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (ab.Jd(this.contact.field_username)) {
        this.screen.eh("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.eh("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.contact.d.rs(this.contact.field_type)) && (afM(this.pUt)))
      {
        this.screen.eh("contact_info_expose_btn", false);
        At(false);
        break;
      }
      this.screen.eh("contact_info_expose_btn", true);
      At(true);
      break;
      label325:
      this.screen.eh("contact_info_biz_add", true);
      break label143;
      label342:
      this.screen.eh("contact_info_biz_go_chatting", true);
    }
  }
  
  private void gBz()
  {
    AppMethodBeat.i(27101);
    if ((this.lzt.getIntent() != null) && (this.lzt.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.lzt.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label163;
      }
      Log.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (gBA())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.lzt, new d.7(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.pUt));
      if (this.hcL != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).His = this.hcL;
      }
      if (!Util.isNullOrNil(this.pPi)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).pPi = this.pPi;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).YaS = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.MXj);
      AppMethodBeat.o(27101);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bh.aZW().a(536, this);
    Object localObject2 = new ei();
    ((ei)localObject2).hEe.hEg = ((String)localObject1);
    ((ei)localObject2).hEe.opType = 1;
    ((ei)localObject2).publish();
    Object localObject1 = ((ei)localObject2).hEf.hEi;
    localObject2 = this.lzt;
    this.lzt.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject2, this.lzt.getString(R.l.app_waiting), true, new d.6(this, (com.tencent.mm.am.p)localObject1));
    AppMethodBeat.o(27101);
  }
  
  public final void a(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(27110);
    if ((this.MVg == null) || (!this.MVg.aAR()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramp.getType() == 1354)
    {
      paramp = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
      String str = com.tencent.mm.an.af.bHj().hN(this.MVg.field_username);
      this.MWW = com.tencent.mm.an.af.bHj().hM(str);
      if (this.MWW != null)
      {
        if (!this.MWW.nG(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramp.setChecked(bool);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(27110);
          return;
        }
      }
      Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(27110);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
        break label289;
      }
      bool = true;
      label34:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label295;
      }
      bool = true;
      label46:
      Assert.assertTrue(bool);
      this.screen = paramf;
      this.contact = paramau;
      this.MVt = paramBoolean;
      this.pUt = paramInt;
      this.MXc = this.lzt.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.MXi = ((SnsAdClick)this.lzt.getIntent().getParcelableExtra("KSnsAdTag"));
      this.MXh = this.lzt.getIntent().getBundleExtra("Contact_Ext_Args");
      this.MXj = this.lzt.getIntent().getStringExtra("key_add_contact_report_info");
      gBx();
      paramf = this.lzt.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.lzt.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.k.a(this.lzt, paramf, "", this.lzt.getString(R.l.app_ok), null);
      }
      if (paramau != null)
      {
        com.tencent.mm.an.af.bHt().Mh(paramau.field_username);
        if (com.tencent.mm.an.g.Mz(paramau.field_username))
        {
          paramf = paramau.field_username;
          if (!com.tencent.mm.an.g.Dn(paramf)) {
            break label301;
          }
          com.tencent.mm.an.af.bHp();
          com.tencent.mm.an.a.h.a(paramf, this);
          paramf = com.tencent.mm.an.g.hU(paramf).aAX();
          if (paramf != null) {
            com.tencent.mm.an.af.bHt().Mh(paramf);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27093);
      return true;
      bool = false;
      break;
      label289:
      bool = false;
      break label34;
      label295:
      bool = false;
      break label46;
      label301:
      if (com.tencent.mm.an.g.MB(paramf))
      {
        com.tencent.mm.an.af.bHq();
        com.tencent.mm.an.e.a(paramf, this);
        com.tencent.mm.an.af.bHf();
        paramf = com.tencent.mm.an.f.Ms(paramf);
        if (paramf != null) {
          com.tencent.mm.an.af.bHt().Mh(paramf);
        }
      }
    }
  }
  
  public final boolean anl(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.b.a(this.lzt).ld(this.contact.kai, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.MXi != null)
      {
        paramString = new ug();
        this.MXi.oTP = 5;
        paramString.hXY.hXZ = this.MXi;
        paramString.publish();
      }
      if ((this.MVg != null) && ((this.MVg.aAP()) || (this.MVg.aAR())))
      {
        paramString = new Intent();
        if (this.MVg.aAR())
        {
          localObject1 = this.MVg.aAX();
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", aa.getDisplayName((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.br.c.g(this.lzt, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.lzt.finish();
        }
      }
      for (;;)
      {
        cv(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", aa.getDisplayName(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.lzt.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.MVt)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.lzt.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.pFn.d(paramString, this.lzt);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.bEh()) {
        gBz();
      }
      for (;;)
      {
        if (this.MXc != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.b(11263, new Object[] { Integer.valueOf(this.MXc), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.lzt, com.tencent.mm.model.gdpr.a.ooo, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void onPermissionReturn(int paramAnonymousInt)
          {
            AppMethodBeat.i(305644);
            if (paramAnonymousInt == 0) {
              d.k(d.this);
            }
            AppMethodBeat.o(305644);
          }
        });
      }
    }
    if ("contact_info_biz_read_msg_online".endsWith(paramString))
    {
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_info_stick_biz".equals(paramString))
    {
      if (((CheckBoxPreference)this.screen.bAi("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.pUt) });
        com.tencent.mm.model.j.HW(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        ab.L(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.pUt) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.hcC.aBi() != null) && (!Util.isNullOrNil(this.hcC.aBi().hdF)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.hcC.aBi().hdF);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.br.c.b(this.lzt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = Util.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.hcB.size()))
      {
        paramString = (c.a)this.hcB.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.MXh != null) && ((this.pUt == 39) || (this.pUt == 56) || (this.pUt == 35))) || (this.pUt == 87) || (this.pUt == 89) || (this.pUt == 85) || (this.pUt == 88))
        {
          Log.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.MXh);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
            break label1166;
          }
        }
        label1166:
        for (i = 7;; i = 6)
        {
          int j = this.lzt.getResources().getIdentifier(paramString.hcF, "string", this.lzt.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.lzt.getString(j);
          }
          cv(i, paramString);
          com.tencent.mm.br.c.b(this.lzt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(27090);
          return true;
        }
      }
    }
    label1385:
    label1390:
    boolean bool;
    if (("contact_info_subscribe_bizinfo".endsWith(paramString)) || ("contact_info_show_brand".endsWith(paramString)) || ("contact_info_locate".endsWith(paramString)))
    {
      localObject1 = this.MVg;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).aAO()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).aAR()) {
              break label1390;
            }
            bh.aZW().a(1363, this);
            if (!((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1385;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.a.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            bh.aZW().a(paramString, 0);
            localObject2 = this.lzt;
            this.lzt.getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject2, this.lzt.getString(R.l.app_waiting), true, new d.16(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).aAR()) && (!((com.tencent.mm.api.c)localObject1).aAP())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).aAP())
        {
          paramString = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
          com.tencent.mm.an.af.bHq();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.an.e.a((String)localObject2, bool, this);
            localObject2 = this.lzt;
            this.lzt.getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject2, this.lzt.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                com.tencent.mm.an.af.bHq();
                com.tencent.mm.an.e.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).aAH())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.hcC == null) && (localObject1 != null)) {
              this.hcC = ((com.tencent.mm.api.c)localObject1).dO(false);
            }
            if ((this.hcC != null) && (this.hcC.aBb()) && (com.tencent.mm.br.c.blq("brandservice")))
            {
              this.screen.eh("contact_info_template_recv", false);
              label1581:
              paramString = com.tencent.mm.plugin.report.service.h.OAn;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).aAH()) {
                break label1706;
              }
            }
          }
          label1706:
          for (i = 3;; i = 4)
          {
            paramString.b(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.pUt) });
            break;
            this.screen.eh("contact_info_template_recv", true);
            break label1581;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.eh("contact_info_template_recv", true);
            break label1581;
          }
          if ("contact_info_show_brand".endsWith(paramString))
          {
            if ((((com.tencent.mm.api.c)localObject1).field_brandFlag & 0x2) == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1757;
              }
              ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x2;
              break;
            }
            label1757:
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFD;
          }
          else if ("contact_info_locate".endsWith(paramString))
          {
            if (((com.tencent.mm.api.c)localObject1).aAI()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.MXf = com.tencent.mm.ui.base.k.a(this.lzt, this.lzt.getString(R.l.gwW, new Object[] { this.contact.aSV() }), this.lzt.getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.hkQ.field_hadAlert = 1;
                  this.hkQ.field_brandFlag |= 0x4;
                  d.a(d.this, this.hkQ, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.hkQ.field_hadAlert = 1;
                  d.a(d.this, this.hkQ, false);
                  AppMethodBeat.o(27082);
                }
              });
            }
          }
        }
      }
    }
    if ("contact_info_verifyuser".endsWith(paramString))
    {
      if ((au.bwJ(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if (ab.bBX())
      {
        Log.i("MicroMsg.ContactWidgetBizInfo", "contact_info_verifyuser no click isWeChatUser.");
        AppMethodBeat.o(27090);
        return true;
      }
      paramString = this.MVg;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.dO(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((com.tencent.mm.api.c.b)localObject2).aBk() != null) && (!Util.isNullOrNil(((com.tencent.mm.api.c.b)localObject2).aBk().hdA))) {
        paramString = ((com.tencent.mm.api.c.b)localObject2).aBk().hdA;
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramString);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          ((Intent)localObject1).putExtra("geta8key_scene", 3);
          com.tencent.mm.br.c.b(this.lzt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((com.tencent.mm.api.c.b)localObject2).aBl() != null)
        {
          paramString = (String)localObject1;
          if (!Util.isNullOrNil(((com.tencent.mm.api.c.b)localObject2).aBl().hdI)) {
            paramString = ((com.tencent.mm.api.c.b)localObject2).aBl().hdI;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.MVg;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.dO(false) != null) && (!Util.isNullOrNil(paramString.dO(false).aBd())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.dO(false).aBd());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(this.lzt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.lAj)
      {
        bool = true;
        this.lAj = bool;
        if (!this.lAj) {
          break label2733;
        }
        ab.G(this.contact);
        label2292:
        Au(this.lAj);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.lzt != null) {
          break label2743;
        }
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2325:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.lzt.getString(R.l.enterprise_contact_info_disable_sub_confirm);
        localObject2 = this.lzt.getString(R.l.enterprise_contact_info_disable_sub);
        com.tencent.mm.ui.base.k.b(this.lzt, (String)localObject1, "", (String)localObject2, this.lzt.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            d.a(d.this);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        As(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.MVg.field_username);
        com.tencent.mm.br.c.b(this.lzt, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.bAi("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).gBR() != null) && (!Util.isNullOrNil(((Preference)localObject1).gBR().toString())))
        {
          localObject1 = ((Preference)localObject1).gBR().toString();
          com.tencent.mm.ui.base.k.a(this.lzt, true, (String)localObject1, "", this.lzt.getString(R.l.contact_info_dial), this.lzt.getString(R.l.app_cancel), new d.8(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        gBB();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.lzt.getSharedPreferences(this.lzt.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.aSQ()) {
            break label2813;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          ab.L(this.contact.field_username, true);
          this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27090);
      return true;
      bool = false;
      break;
      label2733:
      ab.H(this.contact);
      break label2292;
      label2743:
      if (this.MVg == null)
      {
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2325;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.MVg.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.c.b(this.lzt, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2325;
      label2813:
      com.tencent.mm.model.j.HW(this.contact.field_username);
      Log.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final String bGT()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.bAi("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  public final void e(LinkedList<gjj> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    com.tencent.mm.an.af.bHg().b(this);
    if (this.screen == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (this.contact == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27109);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (!Util.isNullOrNil(this.MXd))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        gjj localgjj = (gjj)((Iterator)localObject).next();
        if ((localgjj.acfC != null) && (localgjj.acfC.equals(this.MXd)))
        {
          this.screen.eh("contact_info_kf_worker", false);
          this.screen.bAi("contact_info_kf_worker").aS(localgjj.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.eh("contact_info_kf_worker", false);
    Object localObject = this.screen.bAi("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).aS(((gjj)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.lzt == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "null == context");
      AppMethodBeat.o(27098);
      return;
    }
    Log.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(27098);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.gaI().B(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.u(this.lzt, this.lzt.getString(R.l.finish_sent));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    Log.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.MXe = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramp == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    bh.aZW().b(paramp.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 536)
    {
      bh.aZW().b(536, this);
      gBx();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramp.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.a.c)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (ezu)c.c.b(paramString.rr.otC);; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.a.c)paramp;
        paramp = (com.tencent.mm.am.p)localObject1;
        if (((com.tencent.mm.plugin.profile.a.c)localObject2).rr != null)
        {
          paramp = (com.tencent.mm.am.p)localObject1;
          if (com.tencent.mm.am.c.b.b(((com.tencent.mm.plugin.profile.a.c)localObject2).rr.otB) != null) {
            paramp = (ezt)com.tencent.mm.am.c.b.b(((com.tencent.mm.plugin.profile.a.c)localObject2).rr.otB);
          }
        }
        if ((paramString != null) && (paramString.YRW != null) && (paramString.YRW.ret == 0) && (paramString.YRT != null) && (!Util.isNullOrNil(paramString.YRT.YRR))) {
          break label413;
        }
        if ((paramString == null) || (paramString.YRW == null)) {
          break;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.YRW.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.YRT == null)
      {
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = com.tencent.mm.an.af.bHj().hM(paramString.YRT.YRR);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.an.a.k();
        ((com.tencent.mm.an.a.k)localObject1).field_userId = paramString.YRT.YRR;
      }
      ((com.tencent.mm.an.a.k)localObject1).field_userName = paramString.YRT.wwH;
      ((com.tencent.mm.an.a.k)localObject1).field_brandUserName = paramp.YRQ;
      ((com.tencent.mm.an.a.k)localObject1).field_UserVersion = paramString.YRT.ver;
      ((com.tencent.mm.an.a.k)localObject1).field_headImageUrl = paramString.YRT.YRK;
      ((com.tencent.mm.an.a.k)localObject1).field_profileUrl = paramString.YRT.mef;
      ((com.tencent.mm.an.a.k)localObject1).field_bitFlag = paramString.YRT.YRL;
      ((com.tencent.mm.an.a.k)localObject1).field_addMemberUrl = paramString.YRT.YRO;
      ((com.tencent.mm.an.a.k)localObject1).field_needToUpdate = false;
      if (!com.tencent.mm.an.af.bHj().b((com.tencent.mm.an.a.k)localObject1)) {
        com.tencent.mm.an.af.bHj().a((com.tencent.mm.an.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramp.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.a.d)paramp).gBg();
      localObject1 = ((com.tencent.mm.plugin.profile.a.d)paramp).gBf();
      if ((localObject1 == null) || (((fko)localObject1).YRW == null) || (((fko)localObject1).YRW.ret != 0))
      {
        if ((localObject1 != null) && (((fko)localObject1).YRW != null))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(((fko)localObject1).YRW.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramp.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.disable)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.MVg;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        bh.bCz();
        if (com.tencent.mm.model.c.bzG().bxM(paramString.field_username) == null)
        {
          paramp = new bb(paramString.field_username);
          paramp.BH(Util.nullAsNil(this.MVg.aAX()));
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLG(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          bh.bCz();
          com.tencent.mm.model.c.bzG().h(paramp);
          bh.bCz();
          com.tencent.mm.model.c.bzG().bH((cc)localObject1);
        }
      }
      for (;;)
      {
        bh.bCz();
        if (com.tencent.mm.model.c.bzG().bxM(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new bb(paramString.field_enterpriseFather);
        paramString.jaJ();
        bh.bCz();
        com.tencent.mm.model.c.bzG().h(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramp.jaJ();
        bh.bCz();
        com.tencent.mm.model.c.bzG().h(paramp);
      }
      label954:
      bh.bCz();
      com.tencent.mm.model.c.bzF().bvq(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.MVg;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxK(paramString.field_username);
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().byb(paramString.field_enterpriseFather) <= 0)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxK(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      bh.bCz();
      com.tencent.mm.model.c.bzF().bvq(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramp.getType() == 1343)
    {
      gBx();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramp.getType() == 1228) {
      gBx();
    }
    AppMethodBeat.o(27108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */