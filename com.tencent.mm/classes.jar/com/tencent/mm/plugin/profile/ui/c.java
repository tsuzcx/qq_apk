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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.ae;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.i.b;
import com.tencent.mm.ao.p;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.f.a.dy;
import com.tencent.mm.f.a.dy.b;
import com.tencent.mm.f.a.ec;
import com.tencent.mm.f.a.ec.b;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.protocal.protobuf.fmr;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.an.i, i.b, p, com.tencent.mm.pluginsdk.c.a
{
  private static final String GZd;
  String BLy;
  private String GXB;
  private com.tencent.mm.api.c GXj;
  private boolean GXw;
  private com.tencent.mm.ao.a.k GYT;
  private List<WxaAttributes.WxaEntryInfo> GYU;
  private aez GYV = null;
  private boolean GYW = false;
  private boolean GYX = false;
  private boolean GYY = false;
  private int GYZ = 0;
  private String GZa;
  private boolean GZb;
  com.tencent.mm.ui.widget.a.d GZc = null;
  private Bundle GZe;
  private SnsAdClick GZf = null;
  private String GZg = null;
  private as contact;
  private List<c.a> eZb;
  private c.b eZc;
  private boolean eZj = false;
  private String eZl;
  private MMActivity iXq;
  private CheckBoxPreference iYi;
  private boolean iYs;
  private boolean isDeleteCancel = false;
  private int mXL;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  private s tipDialog = null;
  
  static
  {
    AppMethodBeat.i(268790);
    GZd = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(268790);
  }
  
  private c(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, aez paramaez)
  {
    this(paramMMActivity);
    this.GXB = paramString;
    this.GYV = paramaez;
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.byG("contact_info_locate");
    cxu localcxu = new cxu();
    localcxu.mVM = paramc.field_brandFlag;
    localcxu.UserName = this.contact.field_username;
    if (abs(this.mXL))
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(58, localcxu));
    }
    for (;;)
    {
      af.bjv().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.YP());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.YQ());
      }
      if (paramBoolean) {
        fqh();
      }
      AppMethodBeat.o(27092);
      return;
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(47, localcxu));
    }
  }
  
  private static boolean aUO(String paramString)
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
  
  private void aUP(String paramString)
  {
    AppMethodBeat.i(27105);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.GZb) });
    if (this.GZb)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.GZa = paramString;
    if ((this.eZc == null) || (!this.eZc.Zy()) || (this.contact == null))
    {
      this.screen.dz("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      paramString = af.bju().UJ(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.dz("contact_info_kf_worker", true);
        af.bjw().a(this);
        af.bjw().bj(this.contact.field_username, z.bcZ());
        this.GZb = true;
        AppMethodBeat.o(27105);
        return;
      }
      Log.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.dz("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.byG("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).aF(paramString.field_nickname);
      localObject2 = com.tencent.mm.am.d.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aUQ(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).ai((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = af.bju();
    Object localObject1 = ((com.tencent.mm.ao.j)localObject2).UI(paramString);
    if ((localObject1 == null) || (com.tencent.mm.ao.j.a((com.tencent.mm.ao.h)localObject1)))
    {
      af.bjw().a(this);
      af.bjw().j(this.contact.field_username, paramString, 1);
      this.GZb = true;
    }
    if (localObject1 == null) {
      Log.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.ao.j)localObject2).UJ(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.dz("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.dz("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.byG("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).aF(paramString.field_nickname);
      localObject2 = com.tencent.mm.am.d.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aUQ(paramString.field_openId);
      }
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).ai((Bitmap)localObject2);
      }
    }
  }
  
  private void aUQ(String paramString)
  {
    AppMethodBeat.i(27106);
    MMHandlerThread.postToMainThreadDelayed(new c.11(this, paramString), 2000L);
    AppMethodBeat.o(27106);
  }
  
  private String abr(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.iXq.getResources().getString(R.l.eyC);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.iXq.getResources().getString(R.l.contact_info_verify_user_title);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.iXq.getResources().getString(R.l.ety);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.iXq.getResources().getString(R.l.etz);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean abs(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.GZe == null) || ((this.mXL != 39) && (this.mXL != 56) && (this.mXL != 35) && (this.mXL != 87) && (this.mXL != 88) && (this.mXL != 89) && (this.mXL != 85)))
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
    String str2 = this.GZe.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Args_Query_String"));
    int j = this.GZe.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.mXL)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      Log.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10866, paramString);
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
  
  private static void c(com.tencent.mm.ao.h paramh)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.am.k localk = com.tencent.mm.am.q.bhP();
    if (localk.TS(paramh.field_openId) == null)
    {
      com.tencent.mm.am.j localj = new com.tencent.mm.am.j();
      localj.username = paramh.field_openId;
      localj.lBd = paramh.field_headImgUrl;
      localj.gg(false);
      localj.hDc = 3;
      localk.b(localj);
    }
    com.tencent.mm.am.q.bhR().Rv(paramh.field_openId);
    Log.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void fqh()
  {
    AppMethodBeat.i(27094);
    cQX();
    this.screen.removeAll();
    this.screen.auC(R.o.eXi);
    if (this.GYY) {
      this.screen.dz("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.ao.g.gu(this.contact.field_username);
    this.eZb = null;
    this.eZc = null;
    this.GYU = null;
    if (((localc == null) || (localc.dc(false) == null)) && (this.GYV != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.GYV.mVM;
      localc.field_brandIconURL = this.GYV.mVP;
      localc.field_brandInfo = this.GYV.mVO;
      localc.field_extInfo = this.GYV.mVN;
    }
    label474:
    label1246:
    label1254:
    label2408:
    label4712:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.GYV != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.GYV.mVM;
        localc.field_brandIconURL = this.GYV.mVP;
        localc.field_brandInfo = this.GYV.mVO;
        localc.field_extInfo = this.GYV.mVN;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.byG("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!Util.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.GXB, localc);
        this.screen.dz("biz_placed_to_the_top", true);
        this.screen.dz("contact_info_biz_enable", true);
        this.screen.dz("contact_info_biz_disable", true);
        this.screen.dz("contact_info_stick_biz", true);
        if (localc == null) {
          break label2309;
        }
        if (!localc.YY()) {
          break label1882;
        }
        this.screen.dz("contact_info_biz_add", true);
        this.screen.dz("contact_info_expose_btn", true);
        this.screen.dz("contact_is_mute", false);
        this.iYs = this.contact.aeg();
        if (!localc.YZ()) {
          break label1600;
        }
        this.screen.dz("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {
          break label1594;
        }
        bool = true;
        ((com.tencent.mm.ui.base.preference.f)localObject1).dz("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.byG("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).setChecked(this.contact.ayn());
        ((CheckBoxPreference)localObject1).setTitle(R.l.eCk);
        fqm();
        vX(this.iYs);
        this.GXj = localc;
        this.eZb = localc.Zg();
        this.eZc = localc.dc(false);
        this.GYU = this.eZc.getWxaEntryInfoList();
        if (!this.eZc.Zh()) {
          break label2193;
        }
        this.screen.byG("near_field_service").auI(R.l.eVR);
        if (this.eZc.Zn() == null) {
          break label2275;
        }
        this.GYX = true;
        if (aUO(this.eZc.Zn())) {
          break label2210;
        }
        this.screen.dz("contact_info_time_expired", true);
        if ((ab.QT(this.contact.field_username)) || (ab.Rf(this.contact.field_username))) {
          fqi();
        }
        if ((this.eZc.Zk() != null) && (this.eZc.Zk().length() > 0)) {
          this.eZl = this.eZc.Zk();
        }
        this.eZj = this.eZc.Zi();
        if (Util.isNullOrNil(this.eZc.Zx())) {
          break label2292;
        }
        this.screen.dz("contact_info_service_phone", false);
        localObject1 = this.screen.byG("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).aF(this.eZc.Zx());
          ((Preference)localObject1).tHk = this.iXq.getResources().getColor(R.e.link_color);
        }
      }
      Object localObject2;
      Object localObject4;
      Object localObject6;
      label1006:
      label1014:
      label1147:
      int i;
      for (;;)
      {
        Object localObject7;
        if (!Util.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.byG("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (Util.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.dz("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.eZc == null) || (this.eZc.Zs() == null) || (Util.isNullOrNil(this.eZc.Zs().eZX))) {
              break label2668;
            }
            localObject4 = this.eZc.Zs();
            localObject6 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2651;
            }
            ((KeyValuePreference)localObject6).WrK = false;
            if (!Util.isNullOrNil(((c.b.e)localObject4).eZY)) {
              break label2580;
            }
            ((KeyValuePreference)localObject6).DJc = abr(((c.b.e)localObject4).eZW);
            if (az.a.ltt == null) {
              break label2593;
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5479;
            }
            localObject2 = new BitmapDrawable(this.iXq.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2599;
            }
            bool = true;
            Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).WrR = ((Drawable)localObject2);
            if (((c.b.e)localObject4).eZX == null) {
              break label2639;
            }
            localObject7 = ((c.b.e)localObject4).faa;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, ((c.b.e)localObject4).eZX.trim());
            if (Util.isNullOrNil((String)localObject7)) {
              break label5472;
            }
          }
        }
        try
        {
          localObject1 = new SpannableString((String)localObject7 + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          label1140:
          localObject1 = localObject2;
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, ((String)localObject7).length(), 17);
          ((KeyValuePreference)localObject6).aF((CharSequence)localObject1);
          if ((ab.PN(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
          {
            ((KeyValuePreference)localObject6).aF(cs.Sg("OfficialEntity"));
            ((KeyValuePreference)localObject6).auO(8);
          }
          if ((this.eZc == null) || (Util.isNullOrNil(this.eZc.Zm()))) {
            break label2823;
          }
          localObject2 = (KeyValuePreference)this.screen.byG("contact_info_trademark");
          if (localObject2 == null) {
            break label1350;
          }
          ((KeyValuePreference)localObject2).WrK = false;
          if (az.a.ltt == null) {
            break label2811;
          }
          localObject1 = BitmapUtil.getBitmapNative(R.k.biz_info_trademark_protection);
          if (localObject1 != null) {
            break label2817;
          }
          bool = true;
          Log.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5466;
          }
          localObject1 = new BitmapDrawable(this.iXq.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            j = k;
          }
          localObject1 = null;
          break label1298;
        }
        ((KeyValuePreference)localObject2).WrR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).aF(this.eZc.Zm());
        Log.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.eZc.Zm(), this.eZc.Zl() });
        if ((this.eZc == null) || (this.eZc.Zo() == null) || (this.eZc.Zo().size() <= 0)) {
          break label2849;
        }
        localObject2 = (KeyValuePreference)this.screen.byG("contact_info_privilege");
        ((KeyValuePreference)localObject2).FU(false);
        ((KeyValuePreference)localObject2).hKN();
        localObject4 = this.eZc.Zo().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.iXq, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.iXq.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.iXq.getResources().getIdentifier(((c.b.g)localObject7).faf, "string", this.iXq.getPackageName());
          if (i > 0) {
            localObject1 = this.iXq.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).hK((View)localObject6);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.dz("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.dz("contact_info_subscribe_bizinfo", true);
        this.screen.dz("contact_info_biz_go_chatting", true);
        if (localc.YP())
        {
          this.screen.dz("contact_info_biz_enable", true);
          this.screen.dz("contact_info_biz_disable", false);
          this.screen.byG("contact_info_biz_disable").setTitle(R.l.eCm);
          this.screen.dz("contact_is_mute", false);
          this.screen.dz("biz_placed_to_the_top", false);
          this.iYi = ((CheckBoxPreference)this.screen.byG("biz_placed_to_the_top"));
          this.iYi.setTitle(R.l.eCx);
          fqm();
          if (!localc.Za()) {
            break label528;
          }
          this.screen.dz("contact_info_locate", true);
          break label528;
        }
        this.screen.dz("contact_info_biz_enable", false);
        this.screen.dz("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.byG("contact_info_biz_enable")).hG(this.iXq.getResources().getString(R.l.eCo), this.iXq.getResources().getColor(R.e.brand_text_color));
        this.screen.dz("contact_is_mute", true);
        this.screen.dz("biz_placed_to_the_top", true);
        this.screen.dz("contact_info_locate", true);
        break label528;
        if (localc.YX())
        {
          this.screen.dz("contact_info_locate", true);
          this.screen.dz("contact_info_subscribe_bizinfo", false);
          this.screen.dz("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.byG("contact_info_biz_go_chatting")).hG(this.iXq.getResources().getString(R.l.eCp), this.iXq.getResources().getColor(R.e.brand_text_color));
          localObject1 = this.screen;
          if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).dz("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.byG("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).setChecked(this.contact.ayn());
            ((CheckBoxPreference)localObject1).setTitle(R.l.eCr);
            fqm();
            this.screen.dz("contact_is_mute", false);
            this.iYs = this.contact.aeg();
            vX(this.iYs);
            break;
          }
        }
        localObject1 = this.screen;
        if ((ab.Qy(this.contact.field_username)) || (!com.tencent.mm.contact.d.rk(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).dz("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.byG("contact_info_stick_biz")).setChecked(this.contact.ayn());
          this.screen.dz("contact_is_mute", true);
          this.iYs = false;
          break;
        }
        this.screen.dz("near_field_service", true);
        break label600;
        this.GYW = true;
        if (!com.tencent.mm.contact.d.rk(this.contact.field_type))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          fqi();
          break label642;
        }
        this.screen.dz("contact_info_time_expired", true);
        break label642;
        this.screen.dz("contact_info_time_expired", true);
        break label672;
        label2292:
        this.screen.dz("contact_info_service_phone", true);
        continue;
        this.screen.dz("contact_info_time_expired", true);
        Log.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).WrK = false;
        ((KeyValuePreference)localObject2).DJc = this.iXq.getString(R.l.eyC);
        ((KeyValuePreference)localObject2).aF(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.contact.signature));
        ((KeyValuePreference)localObject2).FU(false);
        if (az.a.ltt != null)
        {
          localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(this.contact.field_verifyFlag), 2.0F);
          if (localObject1 != null) {
            break label2527;
          }
          bool = true;
          label2416:
          Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5485;
          }
        }
      }
      label2668:
      label5485:
      for (localObject1 = new BitmapDrawable(this.iXq.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).WrR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).WrP = 8;
        ((KeyValuePreference)localObject2).auO(8);
        if ((!ab.PN(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
          break;
        }
        ((KeyValuePreference)localObject2).aF(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, cs.Sg("BRAND_Team")));
        break;
        localObject1 = null;
        break label2408;
        bool = false;
        break label2416;
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.dz("contact_info_user_desc", true);
        if (this.GYW) {
          break;
        }
        this.screen.dz("contact_info_time_expired", true);
        break;
        ((KeyValuePreference)localObject6).DJc = ((c.b.e)localObject4).eZY;
        break label956;
        localObject1 = null;
        break label983;
        bool = false;
        break label1014;
        Log.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1140;
        Log.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1147;
        this.screen.dz("contact_info_verifyuser", true);
        break label1184;
        if ((this.eZc != null) && (this.eZc.Zt() != null) && (!Util.isNullOrNil(this.eZc.Zt().fag)))
        {
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1184;
          }
          ((KeyValuePreference)localObject1).aF(this.eZc.Zt().fag);
          if ((!ab.PN(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
            break label1184;
          }
          ((KeyValuePreference)localObject1).aF(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, cs.Sg("OfficialEntity")));
          ((KeyValuePreference)localObject1).auO(8);
          break label1184;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.dz("contact_info_verifyuser", true);
        break label1184;
        label2811:
        localObject1 = null;
        break label1246;
        bool = false;
        break label1254;
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.dz("contact_info_trademark", true);
        break label1350;
        this.screen.dz("contact_info_privilege", true);
        int k = this.screen.bf("contact_info_category2");
        if ((k >= 0) && (this.eZb != null) && (this.eZb.size() > 0)) {
          i = this.eZb.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.eZb.get(i) != null) && ((!this.iXq.getString(R.l.eyh).equals(((c.a)this.eZb.get(i)).title)) || (this.eZj)) && ((!Util.isNullOrNil(((c.a)this.eZb.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.eZb.get(i)).eZf))))
          {
            localObject5 = new Preference(this.iXq);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.eZb.get(i)).title;
            j = this.iXq.getResources().getIdentifier(((c.a)this.eZb.get(i)).eZf, "string", this.iXq.getPackageName());
            if (j > 0) {
              localObject1 = this.iXq.getString(j);
            }
            if ((ab.PN(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) && (((String)localObject1).equals(this.iXq.getString(R.l.emq)))) {
              this.screen.dz(((Preference)localObject5).mKey, true);
            }
            localObject2 = localObject1;
            if (this.GXj.YW()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.eZb.get(i)).eZf))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.iXq.getString(R.l.emq))) {}
              }
              else
              {
                localObject2 = this.iXq.getString(R.l.eCj);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!Util.isNullOrNil(((c.a)this.eZb.get(i)).description)) {
              ((Preference)localObject5).aF(((c.a)this.eZb.get(i)).description);
            }
            if (!Util.nullAsNil(((c.a)this.eZb.get(i)).eZf).equals("__mp_wording__brandinfo_feedback")) {
              break label5461;
            }
            j = this.screen.bf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5461;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (Util.nullAsNil(((c.a)this.eZb.get(i)).eZf).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.iXq);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          Log.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.GYW) && (ab.Q(this.contact)) && (this.contact.hDm != null) && (!this.contact.hDm.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).aF(Util.nullAs(this.contact.field_weiboNickname, "") + this.iXq.getString(R.l.settings_show_weibo_field, new Object[] { ab.Re(this.contact.hDm) }));
            ((Preference)localObject1).tHk = com.tencent.mm.ci.a.w(this.iXq, R.e.link_color);
            ((KeyValuePreference)localObject1).FU(false);
          }
          if ((this.eZc == null) || (this.eZc.Zq() == null)) {
            break label4384;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.byG("contact_info_reputation");
          if (this.eZc.Zq().fab <= 0) {
            break label4333;
          }
          ((BizInfoPayInfoIconPreference)localObject1).abm(this.eZc.Zq().fab);
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.byG("contact_info_guarantee_info");
          if ((this.eZc.Zq().fad == null) || (this.eZc.Zq().fad.size() <= 0)) {
            break label4350;
          }
          ((BizInfoPayInfoIconPreference)localObject1).gv(this.eZc.Zq().fad);
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.eZc.Zq().fac)) {
            break label4367;
          }
          ((KeyValuePreference)localObject1).aF(this.eZc.Zq().fac);
          ((KeyValuePreference)localObject1).WrP = 4;
          ((KeyValuePreference)localObject1).FU(false);
          if ((this.GYU == null) || (this.GYU.size() <= 0)) {
            break label4429;
          }
          this.screen.dz("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.byG("contact_info_bindwxainfo")).a(this.GXj, this.GYU);
          aUP(this.iXq.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          Log.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.iXq.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.iXq.getIntent() == null) || (!this.iXq.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4750;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = fqk();
          Log.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rk(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.contact.d.rk(this.contact.field_type)) || (!bool)) {
            break label4580;
          }
          if (localc == null) {
            break label4537;
          }
          localObject1 = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.byG("contact_info_locate");
          if (!localc.YZ()) {
            break label4464;
          }
          localObject5 = af.bjz().gn(localc.field_username);
          this.GYT = af.bjz().gm((String)localObject5);
          if (this.GYT == null) {
            break label4452;
          }
          if (this.GYT.jQ(4)) {
            break label4446;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).setChecked(bool);
          if (!localc.YP()) {
            break label4494;
          }
          if ((this.eZc == null) && (localc != null)) {
            this.eZc = localc.dc(false);
          }
          if ((this.eZc == null) || (!this.eZc.Zj()) || (!com.tencent.mm.by.c.blP("brandservice"))) {
            break label4477;
          }
          this.screen.dz("contact_info_template_recv", false);
          if (!localc.dc(false).YT()) {
            break label4511;
          }
          ((CheckBoxPreference)localObject2).setChecked(localc.YQ());
        }
        for (;;)
        {
          this.screen.dz("contact_info_biz_read_msg_online", true);
          this.screen.dz("contact_info_biz_add", true);
          localObject1 = this.contact.ays();
          if (localObject1 != null) {
            this.iXq.setMMTitle((String)localObject1);
          }
          if (ab.Qy(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.byG("contact_info_biz_go_chatting")).hG(this.iXq.getResources().getString(R.l.ezf), this.iXq.getResources().getColor(R.e.brand_text_color));
            this.iXq.setMMTitle(R.l.eAi);
          }
          if ((!ab.QT(this.contact.field_username)) && (this.GXj != null) && (!this.GXj.YY())) {
            this.iXq.addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(27087);
                c.b(c.this);
                AppMethodBeat.o(27087);
                return true;
              }
            });
          }
          AppMethodBeat.o(27094);
          return;
          this.screen.dz("contact_info_verifyuser_weibo", true);
          break;
          label4333:
          this.screen.dz("contact_info_reputation", true);
          break label3623;
          label4350:
          this.screen.dz("contact_info_guarantee_info", true);
          break label3686;
          this.screen.dz("contact_info_scope_of_business", true);
          break label3746;
          this.screen.dz("contact_info_reputation", true);
          this.screen.dz("contact_info_guarantee_info", true);
          this.screen.dz("contact_info_scope_of_business", true);
          break label3746;
          this.screen.dz("contact_info_bindwxainfo", true);
          break label3805;
          bool = false;
          break label4043;
          Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label4050;
          label4464:
          ((CheckBoxPreference)localObject1).setChecked(localc.YP());
          break label4050;
          label4477:
          this.screen.dz("contact_info_template_recv", true);
          break label4120;
          this.screen.dz("contact_info_template_recv", true);
          break label4120;
          this.screen.dz("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).setChecked(localc.YQ());
          continue;
          this.screen.dz("contact_info_subscribe_bizinfo", true);
          this.screen.dz("contact_info_locate", true);
          this.screen.dz("contact_info_template_recv", true);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        fqi();
        localObject1 = this.screen.byG("contact_info_biz_add");
        Log.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.GYX) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(R.l.exY);
          }
        }
        else if (abs(this.mXL))
        {
          if (localc != null) {
            break label4712;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.iXq.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(R.l.exU);
          break;
          ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(localc.YP());
          this.screen.dz("contact_info_subscribe_bizinfo", false);
        }
        if (com.tencent.mm.contact.d.rk(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.byG("contact_info_locate");
            if (localc.YZ())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.eCl);
              localObject5 = af.bjz().gn(localc.field_username);
              this.GYT = af.bjz().gm((String)localObject5);
              if (this.GYT != null) {
                if (!this.GYT.jQ(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).setChecked(bool);
                  if (!localc.YP()) {
                    break label5232;
                  }
                  if ((this.eZc == null) && (localc != null)) {
                    this.eZc = localc.dc(false);
                  }
                  if ((this.eZc == null) || (!this.eZc.Zj()) || (!com.tencent.mm.by.c.blP("brandservice"))) {
                    break label5215;
                  }
                  this.screen.dz("contact_info_template_recv", false);
                  if (!localc.dc(false).YT()) {
                    break label5249;
                  }
                  ((CheckBoxPreference)localObject2).setChecked(localc.YQ());
                }
              }
            }
          }
          for (;;)
          {
            this.screen.dz("contact_info_biz_read_msg_online", true);
            this.screen.dz("contact_info_biz_add", true);
            localObject1 = this.contact.ays();
            if (localObject1 != null) {
              this.iXq.setMMTitle((String)localObject1);
            }
            if (ab.Qy(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.byG("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).yfJ = true;
              ((ButtonPreference)localObject1).hG(this.iXq.getResources().getString(R.l.ezf), this.iXq.getResources().getColor(R.e.brand_text_color));
              this.iXq.setMMTitle(R.l.eAi);
            }
            if ((!ab.QT(this.contact.field_username)) && (this.GXj != null)) {
              this.iXq.addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(27088);
                  c.b(c.this);
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
            break label4869;
            if (localc.YX())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.eCs);
              if (!af.bjF().Un(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).setChecked(bool);
                break;
              }
            }
            ((CheckBoxPreference)localObject1).setChecked(localc.YP());
            break label4869;
            this.screen.dz("contact_info_template_recv", true);
            break label4939;
            label5232:
            this.screen.dz("contact_info_template_recv", true);
            break label4939;
            this.screen.dz("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).setChecked(localc.YQ());
            continue;
            this.screen.dz("contact_info_subscribe_bizinfo", true);
            this.screen.dz("contact_info_locate", true);
            this.screen.dz("contact_info_template_recv", true);
          }
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        fqi();
        localObject1 = this.screen.byG("contact_info_biz_add");
        if ((localObject1 != null) && (this.GYX)) {
          ((Preference)localObject1).setTitle(R.l.exY);
        }
        if (abs(this.mXL))
        {
          if (localc != null) {
            break label5418;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.iXq.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(localc.YP());
          this.screen.dz("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1140;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void fqi()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.contact.d.rk(this.contact.field_type)) && (!ab.Qy(this.contact.field_username)) && (!ab.Rf(this.contact.field_username)))
    {
      this.screen.dz("contact_is_mute", false);
      this.screen.dz("contact_info_verifyuser_weibo", true);
      this.screen.dz("contact_info_subscribe_bizinfo", true);
      this.screen.dz("contact_info_template_recv", true);
      this.screen.dz("contact_info_locate", true);
      if (this.GYW) {
        break label313;
      }
      this.screen.dz("contact_info_time_expired", true);
      label141:
      if ((this.contact == null) || ((!ab.QT(this.contact.field_username)) && (!ab.Rf(this.contact.field_username))) || (!com.tencent.mm.contact.d.rk(this.contact.field_type))) {
        break label330;
      }
      this.screen.dz("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (ab.Rf(this.contact.field_username)) {
        this.screen.dz("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.dz("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.contact.d.rk(this.contact.field_type)) && (abs(this.mXL)))
      {
        this.screen.dz("contact_info_expose_btn", false);
        break;
      }
      this.screen.dz("contact_info_expose_btn", true);
      break;
      label313:
      this.screen.dz("contact_info_biz_add", true);
      break label141;
      label330:
      this.screen.dz("contact_info_biz_go_chatting", true);
    }
  }
  
  private void fqj()
  {
    AppMethodBeat.i(27101);
    if ((this.iXq.getIntent() != null) && (this.iXq.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.iXq.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label164;
      }
      Log.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label164:
    while (fqk())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.iXq, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(27077);
          as localas;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cO(c.f(c.this), c.f(c.this).getString(R.l.exS));
            c.l(c.this).dz("contact_info_time_expired", true);
            localas = c.d(c.this);
            if ((localas != null) && (!Util.isNullOrNil(paramAnonymousString1))) {
              break label390;
            }
            Log.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localas);
            c.m(c.this);
            if (c.n(c.this) != null)
            {
              paramAnonymousString1 = new sr();
              c.n(c.this).maV = 4;
              paramAnonymousString1.fSb.fSc = c.n(c.this);
              EventCenter.instance.publish(paramAnonymousString1);
            }
            paramAnonymousString1 = af.bjv().Uo(c.d(c.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!Util.isNullOrNil(paramAnonymousString1.field_extInfo)) || (Util.isNullOrNil(paramAnonymousString1.field_username)) || (c.c(c.this) == null) || (!paramAnonymousString1.field_username.equals(Util.nullAsNil(c.c(c.this).field_username)))) {
              break label678;
            }
            af.bjv().h(c.c(c.this));
            label250:
            paramAnonymousBoolean1 = c.f(c.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = c.f(c.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.YX()) {
              break label689;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", c.d(c.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", aa.PJ(c.d(c.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.by.c.f(c.f(c.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
          }
          label390:
          label678:
          label689:
          for (;;)
          {
            label365:
            c.f(c.this).finish();
            label619:
            do
            {
              c.a(c.this, 3);
              AppMethodBeat.o(27077);
              return;
              paramAnonymousString2 = null;
              if (ab.Qk(localas.field_username))
              {
                String str = Util.nullAsNil(localas.field_username);
                paramAnonymousString2 = com.tencent.mm.ao.g.gu(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                af.bjv().Up(str);
                localas.Iy(str);
              }
              localas.setUsername(paramAnonymousString1);
              if ((int)localas.jxt == 0)
              {
                bh.beI();
                com.tencent.mm.model.c.bbL().aw(localas);
              }
              if ((int)localas.jxt <= 0)
              {
                Log.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                break;
              }
              ab.H(localas);
              bh.beI();
              paramAnonymousString1 = com.tencent.mm.model.c.bbL().RG(localas.field_username);
              if (paramAnonymousString2 != null)
              {
                af.bjv().g(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.ao.g.gu(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.hxX()) && (com.tencent.mm.ao.a.biP())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.YR()) || (i != 0))) {
                  break label619;
                }
                Log.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                az.a.ltq.aP(paramAnonymousString1.field_username, "");
                com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.hyb()) || (i != 0)) {
                break;
              }
              Log.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.hDo) });
              az.a.ltq.aP(paramAnonymousString1.field_username, "");
              com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
              break;
              af.bjv().h(paramAnonymousString1);
              break label250;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", c.d(c.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              com.tencent.mm.plugin.profile.b.mIG.d(paramAnonymousString1, c.f(c.this));
              if (paramAnonymousBoolean1) {
                break label365;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.mXL));
      if (this.eZl != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BAU = this.eZl;
      }
      if (!Util.isNullOrNil(this.BLy)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BLy = this.BLy;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReN = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.GZg);
      AppMethodBeat.o(27101);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bh.aGY().a(536, this);
    Object localObject2 = new dy();
    ((dy)localObject2).fzv.fzx = ((String)localObject1);
    ((dy)localObject2).fzv.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dy)localObject2).fzw.fzz;
    localObject2 = this.iXq;
    this.iXq.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.iXq.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(27076);
        bh.aGY().b(536, c.this);
        paramAnonymousDialogInterface = new dy();
        paramAnonymousDialogInterface.fzv.opType = 2;
        paramAnonymousDialogInterface.fzv.fzz = this.ftz;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(27076);
      }
    });
    AppMethodBeat.o(27101);
  }
  
  private boolean fqk()
  {
    AppMethodBeat.i(27102);
    if (this.iXq.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.iXq.getIntent().getStringExtra("device_id");
    String str2 = this.iXq.getIntent().getStringExtra("device_type");
    ec localec = new ec();
    localec.fzH.fzB = str1;
    localec.fzH.fzF = str2;
    EventCenter.instance.publish(localec);
    boolean bool = localec.fzI.fzJ;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void fql()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format(GZd, new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.by.c.b(this.iXq, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  private void fqm()
  {
    AppMethodBeat.i(27111);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.iXq.getSharedPreferences(this.iXq.getPackageName() + "_preferences", 0);
    }
    if (this.iYi != null)
    {
      if (this.contact == null) {
        break label120;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.ayn()).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(27111);
      return;
      label120:
      this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
    }
  }
  
  private void vW(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.GXj.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      bh.aGY().a(1394, this);
      bh.aGY().a((com.tencent.mm.an.q)localObject, 0);
      MMActivity localMMActivity = this.iXq;
      this.iXq.getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a(localMMActivity, this.iXq.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          bh.aGY().a(this.syo);
          bh.aGY().b(1394, c.this);
          AppMethodBeat.o(27084);
        }
      });
      AppMethodBeat.o(27091);
      return;
    }
  }
  
  private void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.iXq != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.ao.g.KI(this.contact.field_username))) {
          break label77;
        }
        this.iXq.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.byG("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.setChecked(paramBoolean);
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.iXq.setTitleMuteIconVisibility(8);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(27110);
    if ((this.GXj == null) || (!this.GXj.YZ()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramq.getType() == 1354)
    {
      paramq = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
      String str = af.bjz().gn(this.GXj.field_username);
      this.GYT = af.bjz().gm(str);
      if (this.GYT != null)
      {
        if (!this.GYT.jQ(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramq.setChecked(bool);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(27110);
          return;
        }
      }
      Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(27110);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      this.contact = paramas;
      this.GXw = paramBoolean;
      this.mXL = paramInt;
      this.GYZ = this.iXq.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.GZf = ((SnsAdClick)this.iXq.getIntent().getParcelableExtra("KSnsAdTag"));
      this.GZe = this.iXq.getIntent().getBundleExtra("Contact_Ext_Args");
      this.GZg = this.iXq.getIntent().getStringExtra("key_add_contact_report_info");
      fqh();
      paramf = this.iXq.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.iXq.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.iXq, paramf, "", this.iXq.getString(R.l.app_ok), null);
      }
      if (paramas != null)
      {
        af.bjI().Ui(paramas.field_username);
        if (com.tencent.mm.ao.g.UA(paramas.field_username))
        {
          paramf = paramas.field_username;
          if (!com.tencent.mm.ao.g.KI(paramf)) {
            break label301;
          }
          af.bjE();
          com.tencent.mm.ao.a.h.a(paramf, this);
          paramf = com.tencent.mm.ao.g.gu(paramf).Zf();
          if (paramf != null) {
            af.bjI().Ui(paramf);
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
      if (com.tencent.mm.ao.g.UC(paramf))
      {
        af.bjF();
        com.tencent.mm.ao.e.a(paramf, this);
        af.bjv();
        paramf = com.tencent.mm.ao.f.Ut(paramf);
        if (paramf != null) {
          af.bjI().Ui(paramf);
        }
      }
    }
  }
  
  public final boolean atw(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.iXq).jI(this.contact.hDm, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.GZf != null)
      {
        paramString = new sr();
        this.GZf.maV = 5;
        paramString.fSb.fSc = this.GZf;
        EventCenter.instance.publish(paramString);
      }
      if ((this.GXj != null) && ((this.GXj.YX()) || (this.GXj.YZ())))
      {
        paramString = new Intent();
        if (this.GXj.YZ())
        {
          localObject1 = this.GXj.Zf();
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", aa.PJ((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.by.c.f(this.iXq, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.iXq.finish();
        }
      }
      for (;;)
      {
        bN(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", aa.PJ(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.iXq.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.GXw)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.iXq.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.mIG.d(paramString, this.iXq);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.bgq()) {
        fqj();
      }
      for (;;)
      {
        if (this.GYZ != 0) {
          com.tencent.mm.plugin.report.service.h.IzE.a(11263, new Object[] { Integer.valueOf(this.GYZ), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.iXq, com.tencent.mm.model.gdpr.a.lwP, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void vu(int paramAnonymousInt)
          {
            AppMethodBeat.i(27075);
            if (paramAnonymousInt == 0) {
              c.k(c.this);
            }
            AppMethodBeat.o(27075);
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
      if (((CheckBoxPreference)this.screen.byG("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.mXL) });
        com.tencent.mm.model.j.Pd(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        ab.H(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.mXL) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.eZc.Zq() != null) && (!Util.isNullOrNil(this.eZc.Zq().fae)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.eZc.Zq().fae);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.by.c.b(this.iXq, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = Util.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.eZb.size()))
      {
        paramString = (c.a)this.eZb.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.GZe != null) && ((this.mXL == 39) || (this.mXL == 56) || (this.mXL == 35))) || (this.mXL == 87) || (this.mXL == 89) || (this.mXL == 85) || (this.mXL == 88))
        {
          Log.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.GZe);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
            break label1171;
          }
        }
        label1171:
        for (i = 7;; i = 6)
        {
          int j = this.iXq.getResources().getIdentifier(paramString.eZf, "string", this.iXq.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.iXq.getString(j);
          }
          bN(i, paramString);
          com.tencent.mm.by.c.b(this.iXq, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(27090);
          return true;
        }
      }
    }
    label1386:
    label1391:
    boolean bool;
    if (("contact_info_subscribe_bizinfo".endsWith(paramString)) || ("contact_info_show_brand".endsWith(paramString)) || ("contact_info_locate".endsWith(paramString)))
    {
      localObject1 = this.GXj;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).YW()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).YZ()) {
              break label1391;
            }
            bh.aGY().a(1363, this);
            if (!((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1386;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            bh.aGY().a(paramString, 0);
            localObject2 = this.iXq;
            this.iXq.getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.iXq.getString(R.l.app_waiting), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).YZ()) && (!((com.tencent.mm.api.c)localObject1).YX())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).YX())
        {
          paramString = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
          af.bjF();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.ao.e.a((String)localObject2, bool, this);
            localObject2 = this.iXq;
            this.iXq.getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.iXq.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                af.bjF();
                com.tencent.mm.ao.e.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).YP())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.eZc == null) && (localObject1 != null)) {
              this.eZc = ((com.tencent.mm.api.c)localObject1).dc(false);
            }
            if ((this.eZc != null) && (this.eZc.Zj()) && (com.tencent.mm.by.c.blP("brandservice")))
            {
              this.screen.dz("contact_info_template_recv", false);
              label1581:
              paramString = com.tencent.mm.plugin.report.service.h.IzE;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).YP()) {
                break label1706;
              }
            }
          }
          label1706:
          for (i = 3;; i = 4)
          {
            paramString.a(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.mXL) });
            break;
            this.screen.dz("contact_info_template_recv", true);
            break label1581;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.dz("contact_info_template_recv", true);
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
            if (((com.tencent.mm.api.c)localObject1).YQ()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.GZc = com.tencent.mm.ui.base.h.a(this.iXq, this.iXq.getString(R.l.euy, new Object[] { this.contact.ays() }), this.iXq.getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.fgG.field_hadAlert = 1;
                  this.fgG.field_brandFlag |= 0x4;
                  c.a(c.this, this.fgG, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.fgG.field_hadAlert = 1;
                  c.a(c.this, this.fgG, false);
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
      if ((ab.PN(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
      {
        AppMethodBeat.o(27090);
        return true;
      }
      paramString = this.GXj;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.dc(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((c.b)localObject2).Zs() != null) && (!Util.isNullOrNil(((c.b)localObject2).Zs().eZZ))) {
        paramString = ((c.b)localObject2).Zs().eZZ;
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
          com.tencent.mm.by.c.b(this.iXq, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).Zt() != null)
        {
          paramString = (String)localObject1;
          if (!Util.isNullOrNil(((c.b)localObject2).Zt().fah)) {
            paramString = ((c.b)localObject2).Zt().fah;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.GXj;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.dc(false) != null) && (!Util.isNullOrNil(paramString.dc(false).Zl())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.dc(false).Zl());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.by.c.b(this.iXq, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.iYs)
      {
        bool = true;
        this.iYs = bool;
        if (!this.iYs) {
          break label2713;
        }
        ab.F(this.contact);
        label2269:
        vX(this.iYs);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.iXq != null) {
          break label2723;
        }
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2303:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.iXq.getString(R.l.eCn);
        localObject2 = this.iXq.getString(R.l.eCm);
        com.tencent.mm.ui.base.h.c(this.iXq, (String)localObject1, "", (String)localObject2, this.iXq.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            c.a(c.this);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        vW(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.GXj.field_username);
        com.tencent.mm.by.c.b(this.iXq, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.byG("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).fqw() != null) && (!Util.isNullOrNil(((Preference)localObject1).fqw().toString())))
        {
          localObject1 = ((Preference)localObject1).fqw().toString();
          com.tencent.mm.ui.base.h.a(this.iXq, true, (String)localObject1, "", this.iXq.getString(R.l.contact_info_dial), this.iXq.getString(R.l.app_cancel), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        fql();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.iXq.getSharedPreferences(this.iXq.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.ayn()) {
            break label2794;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          ab.H(this.contact.field_username, true);
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
      label2713:
      ab.G(this.contact);
      break label2269;
      label2723:
      if (this.GXj == null)
      {
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2303;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.GXj.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.by.c.b(this.iXq, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2303;
      label2794:
      com.tencent.mm.model.j.Pd(this.contact.field_username);
      Log.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final String bjj()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.byG("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  public final void e(LinkedList<fmr> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    af.bjw().b(this);
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
    if (!Util.isNullOrNil(this.GZa))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fmr localfmr = (fmr)((Iterator)localObject).next();
        if ((localfmr.ULp != null) && (localfmr.ULp.equals(this.GZa)))
        {
          this.screen.dz("contact_info_kf_worker", false);
          this.screen.byG("contact_info_kf_worker").aF(localfmr.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.dz("contact_info_kf_worker", false);
    Object localObject = this.screen.byG("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).aF(((fmr)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.iXq == null)
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
      com.tencent.mm.plugin.messenger.a.g.eRW().u(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eRW().iQ(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.iXq, this.iXq.getString(R.l.finish_sent));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    Log.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.GZb = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    bh.aGY().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bh.aGY().b(536, this);
      fqh();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (egb)d.c.b(paramString.rr.lBS);; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramq;
        paramq = (com.tencent.mm.an.q)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramq = (com.tencent.mm.an.q)localObject1;
          if (d.b.b(((com.tencent.mm.plugin.profile.b.c)localObject2).rr.lBR) != null) {
            paramq = (ega)d.b.b(((com.tencent.mm.plugin.profile.b.c)localObject2).rr.lBR);
          }
        }
        if ((paramString != null) && (paramString.RUv != null) && (paramString.RUv.ret == 0) && (paramString.RUs != null) && (!Util.isNullOrNil(paramString.RUs.RUq))) {
          break label419;
        }
        if ((paramString == null) || (paramString.RUv == null)) {
          break;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.RUv.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label419:
      if (paramString.RUs == null)
      {
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = af.bjz().gm(paramString.RUs.RUq);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.ao.a.k();
        ((com.tencent.mm.ao.a.k)localObject1).field_userId = paramString.RUs.RUq;
      }
      ((com.tencent.mm.ao.a.k)localObject1).field_userName = paramString.RUs.tsk;
      ((com.tencent.mm.ao.a.k)localObject1).field_brandUserName = paramq.RUp;
      ((com.tencent.mm.ao.a.k)localObject1).field_UserVersion = paramString.RUs.ver;
      ((com.tencent.mm.ao.a.k)localObject1).field_headImageUrl = paramString.RUs.RUj;
      ((com.tencent.mm.ao.a.k)localObject1).field_profileUrl = paramString.RUs.jEj;
      ((com.tencent.mm.ao.a.k)localObject1).field_bitFlag = paramString.RUs.RUk;
      ((com.tencent.mm.ao.a.k)localObject1).field_addMemberUrl = paramString.RUs.RUn;
      ((com.tencent.mm.ao.a.k)localObject1).field_needToUpdate = false;
      if (!af.bjz().b((com.tencent.mm.ao.a.k)localObject1)) {
        af.bjz().a((com.tencent.mm.ao.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).fpS();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramq).fpR();
      if ((localObject1 == null) || (((epp)localObject1).RUv == null) || (((epp)localObject1).RUv.ret != 0))
      {
        if ((localObject1 != null) && (((epp)localObject1).RUv != null))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((epp)localObject1).RUv.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.qfB)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label984;
        }
        paramString = this.GXj;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        bh.beI();
        if (com.tencent.mm.model.c.bbR().bwx(paramString.field_username) == null)
        {
          paramq = new az(paramString.field_username);
          paramq.Jc(Util.nullAsNil(this.GXj.Zf()));
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aOH(paramString.field_username);
          if (localObject1 == null) {
            break label940;
          }
          bh.beI();
          com.tencent.mm.model.c.bbR().e(paramq);
          bh.beI();
          com.tencent.mm.model.c.bbR().br((ca)localObject1);
        }
      }
      for (;;)
      {
        bh.beI();
        if (com.tencent.mm.model.c.bbR().bwx(paramString.field_enterpriseFather) != null) {
          break label963;
        }
        paramString = new az(paramString.field_enterpriseFather);
        paramString.hyE();
        bh.beI();
        com.tencent.mm.model.c.bbR().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label940:
        paramq.hyE();
        bh.beI();
        com.tencent.mm.model.c.bbR().e(paramq);
      }
      label963:
      bh.beI();
      com.tencent.mm.model.c.bbQ().bvi(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label984:
      paramString = this.GXj;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      bh.beI();
      com.tencent.mm.model.c.bbR().bwv(paramString.field_username);
      bh.beI();
      if (com.tencent.mm.model.c.bbR().bwI(paramString.field_enterpriseFather) <= 0)
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bwv(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      bh.beI();
      com.tencent.mm.model.c.bbQ().bvi(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1343)
    {
      fqh();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1228) {
      fqh();
    }
    AppMethodBeat.o(27108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */