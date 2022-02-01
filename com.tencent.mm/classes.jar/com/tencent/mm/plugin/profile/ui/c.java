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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.af;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.b;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.cr;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.protocal.protobuf.oa;
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
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.ak.i, i.b, com.tencent.mm.al.p, com.tencent.mm.pluginsdk.b.a
{
  private static final String Bff;
  private String BdC;
  private com.tencent.mm.api.c Bdk;
  private boolean Bdx;
  private k BeV;
  private List<WxaAttributes.WxaEntryInfo> BeW;
  private aeq BeX = null;
  private boolean BeY = false;
  private boolean BeZ = false;
  private boolean Bfa = false;
  private int Bfb = 0;
  private String Bfc;
  private boolean Bfd;
  com.tencent.mm.ui.widget.a.d Bfe = null;
  private Bundle Bfg;
  private SnsAdClick Bfh = null;
  private String Bfi = null;
  private as contact;
  private boolean dhC = false;
  private String dhE;
  private List<c.a> dhu;
  private c.b dhv;
  private CheckBoxPreference gtX;
  private MMActivity gte;
  private boolean guh;
  private boolean isDeleteCancel = false;
  private int kgm;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  private com.tencent.mm.ui.base.q tipDialog = null;
  String wZz;
  
  static
  {
    AppMethodBeat.i(231863);
    Bff = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(231863);
  }
  
  private c(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, aeq paramaeq)
  {
    this(paramMMActivity);
    this.BdC = paramString;
    this.BeX = paramaeq;
  }
  
  private String UK(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.gte.getResources().getString(2131757925);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.gte.getResources().getString(2131758135);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.gte.getResources().getString(2131756907);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.gte.getResources().getString(2131756908);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean UL(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
    cpe localcpe = new cpe();
    localcpe.kem = paramc.field_brandFlag;
    localcpe.UserName = this.contact.field_username;
    if (UL(this.kgm))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(58, localcpe));
    }
    for (;;)
    {
      ag.bah().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.Ux());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.Uy());
      }
      if (paramBoolean) {
        eEp();
      }
      AppMethodBeat.o(27092);
      return;
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(47, localcpe));
    }
  }
  
  private static boolean aKp(String paramString)
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
  
  private void aKq(String paramString)
  {
    AppMethodBeat.i(27105);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.Bfd) });
    if (this.Bfd)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.Bfc = paramString;
    if ((this.dhv == null) || (!this.dhv.Vg()) || (this.contact == null))
    {
      this.screen.jdMethod_do("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      paramString = ag.bag().Nn(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.jdMethod_do("contact_info_kf_worker", true);
        ag.bai().a(this);
        ag.bai().be(this.contact.field_username, z.aTY());
        this.Bfd = true;
        AppMethodBeat.o(27105);
        return;
      }
      Log.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.jdMethod_do("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.bmg("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aKr(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).al((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = ag.bag();
    Object localObject1 = ((com.tencent.mm.al.j)localObject2).Nm(paramString);
    if ((localObject1 == null) || (com.tencent.mm.al.j.a((com.tencent.mm.al.h)localObject1)))
    {
      ag.bai().a(this);
      ag.bai().j(this.contact.field_username, paramString, 1);
      this.Bfd = true;
    }
    if (localObject1 == null) {
      Log.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.al.j)localObject2).Nn(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.jdMethod_do("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.jdMethod_do("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.bmg("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        aKr(paramString.field_openId);
      }
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).al((Bitmap)localObject2);
      }
    }
  }
  
  private void aKr(String paramString)
  {
    AppMethodBeat.i(27106);
    MMHandlerThread.postToMainThreadDelayed(new c.11(this, paramString), 2000L);
    AppMethodBeat.o(27106);
  }
  
  private void bP(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.Bfg == null) || ((this.kgm != 39) && (this.kgm != 56) && (this.kgm != 35) && (this.kgm != 87) && (this.kgm != 88) && (this.kgm != 89) && (this.kgm != 85)))
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
    String str2 = this.Bfg.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Args_Query_String"));
    int j = this.Bfg.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.kgm)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      Log.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10866, paramString);
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
  
  private static void c(com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.aj.j localj = com.tencent.mm.aj.p.aYB();
    if (localj.Mx(paramh.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramh.field_openId;
      locali.iKW = paramh.field_headImgUrl;
      locali.fv(false);
      locali.fuz = 3;
      localj.b(locali);
    }
    com.tencent.mm.aj.p.aYD().Mh(paramh.field_openId);
    Log.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void eEp()
  {
    AppMethodBeat.i(27094);
    cCs();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017173);
    if (this.Bfa) {
      this.screen.jdMethod_do("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.al.g.fJ(this.contact.field_username);
    this.dhu = null;
    this.dhv = null;
    this.BeW = null;
    if (((localc == null) || (localc.cG(false) == null)) && (this.BeX != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.BeX.kem;
      localc.field_brandIconURL = this.BeX.kep;
      localc.field_brandInfo = this.BeX.keo;
      localc.field_extInfo = this.BeX.ken;
    }
    label528:
    label672:
    label956:
    label1347:
    label2629:
    label2640:
    label4562:
    label4691:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.BeX != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.BeX.kem;
        localc.field_brandIconURL = this.BeX.kep;
        localc.field_brandInfo = this.BeX.keo;
        localc.field_extInfo = this.BeX.ken;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.bmg("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!Util.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.BdC, localc);
        this.screen.jdMethod_do("biz_placed_to_the_top", true);
        this.screen.jdMethod_do("contact_info_biz_enable", true);
        this.screen.jdMethod_do("contact_info_biz_disable", true);
        this.screen.jdMethod_do("contact_info_stick_biz", true);
        if (localc == null) {
          break label2304;
        }
        if (!localc.UG()) {
          break label1878;
        }
        this.screen.jdMethod_do("contact_info_biz_add", true);
        this.screen.jdMethod_do("contact_info_expose_btn", true);
        this.screen.jdMethod_do("contact_is_mute", false);
        this.guh = this.contact.Zx();
        if (!localc.UH()) {
          break label1596;
        }
        this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
          break label1590;
        }
        bool = true;
        label474:
        ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.bmg("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).setChecked(this.contact.arE());
        ((CheckBoxPreference)localObject1).setTitle(2131758729);
        eEu();
        sG(this.guh);
        this.Bdk = localc;
        this.dhu = localc.UO();
        this.dhv = localc.cG(false);
        this.BeW = this.dhv.getWxaEntryInfoList();
        if (!this.dhv.UP()) {
          break label2189;
        }
        this.screen.bmg("near_field_service").setSummary(2131768705);
        label600:
        if (this.dhv.UV() == null) {
          break label2270;
        }
        this.BeZ = true;
        if (aKp(this.dhv.UV())) {
          break label2206;
        }
        this.screen.jdMethod_do("contact_info_time_expired", true);
        if ((ab.JA(this.contact.field_username)) || (ab.JM(this.contact.field_username))) {
          eEq();
        }
        if ((this.dhv.US() != null) && (this.dhv.US().length() > 0)) {
          this.dhE = this.dhv.US();
        }
        this.dhC = this.dhv.UQ();
        if (Util.isNullOrNil(this.dhv.Vf())) {
          break label2287;
        }
        this.screen.jdMethod_do("contact_info_service_phone", false);
        localObject1 = this.screen.bmg("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.dhv.Vf());
          ((Preference)localObject1).qlp = this.gte.getResources().getColor(2131100685);
        }
      }
      Object localObject2;
      Object localObject4;
      Object localObject6;
      label983:
      label1006:
      label1014:
      label1146:
      int i;
      for (;;)
      {
        Object localObject7;
        if (!Util.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.bmg("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (Util.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.jdMethod_do("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.dhv == null) || (this.dhv.Va() == null) || (Util.isNullOrNil(this.dhv.Va().diq))) {
              break label2657;
            }
            localObject4 = this.dhv.Va();
            localObject6 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2640;
            }
            ((KeyValuePreference)localObject6).OYB = false;
            if (!Util.isNullOrNil(((c.b.e)localObject4).dis)) {
              break label2571;
            }
            ((KeyValuePreference)localObject6).OFU = UK(((c.b.e)localObject4).dip);
            if (ay.a.iDs == null) {
              break label2584;
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5455;
            }
            localObject2 = new BitmapDrawable(this.gte.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2590;
            }
            bool = true;
            Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).OYI = ((Drawable)localObject2);
            if (((c.b.e)localObject4).diq == null) {
              break label2629;
            }
            localObject7 = ((c.b.e)localObject4).diu;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, ((c.b.e)localObject4).diq.trim());
            if (Util.isNullOrNil((String)localObject7)) {
              break label5448;
            }
          }
        }
        try
        {
          localObject1 = new SpannableString((String)localObject7 + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          label1139:
          localObject1 = localObject2;
          label1245:
          label1253:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, ((String)localObject7).length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((ab.Iv(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
          {
            ((KeyValuePreference)localObject6).setSummary(cr.KN("OfficialEntity"));
            ((KeyValuePreference)localObject6).alO(8);
          }
          if ((this.dhv == null) || (Util.isNullOrNil(this.dhv.UU()))) {
            break label2811;
          }
          localObject2 = (KeyValuePreference)this.screen.bmg("contact_info_trademark");
          if (localObject2 == null) {
            break label1347;
          }
          ((KeyValuePreference)localObject2).OYB = false;
          if (ay.a.iDs == null) {
            break label2799;
          }
          localObject1 = BitmapUtil.getBitmapNative(2131689777);
          if (localObject1 != null) {
            break label2805;
          }
          bool = true;
          Log.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5442;
          }
          localObject1 = new BitmapDrawable(this.gte.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            j = k;
          }
          localObject1 = null;
          break label1296;
        }
        ((KeyValuePreference)localObject2).OYI = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.dhv.UU());
        Log.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.dhv.UU(), this.dhv.UT() });
        if ((this.dhv == null) || (this.dhv.UW() == null) || (this.dhv.UW().size() <= 0)) {
          break label2836;
        }
        localObject2 = (KeyValuePreference)this.screen.bmg("contact_info_privilege");
        ((KeyValuePreference)localObject2).BC(false);
        ((KeyValuePreference)localObject2).gLJ();
        localObject4 = this.dhv.UW().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.gte, 2131495128, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131302573)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.gte.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.gte.getResources().getIdentifier(((c.b.g)localObject7).diz, "string", this.gte.getPackageName());
          if (i > 0) {
            localObject1 = this.gte.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131308767)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).gz((View)localObject6);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.jdMethod_do("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
        this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
        if (localc.Ux())
        {
          this.screen.jdMethod_do("contact_info_biz_enable", true);
          this.screen.jdMethod_do("contact_info_biz_disable", false);
          this.screen.bmg("contact_info_biz_disable").setTitle(2131758731);
          this.screen.jdMethod_do("contact_is_mute", false);
          this.screen.jdMethod_do("biz_placed_to_the_top", false);
          this.gtX = ((CheckBoxPreference)this.screen.bmg("biz_placed_to_the_top"));
          this.gtX.setTitle(2131758748);
          eEu();
          if (!localc.UI()) {
            break label528;
          }
          this.screen.jdMethod_do("contact_info_locate", true);
          break label528;
        }
        this.screen.jdMethod_do("contact_info_biz_enable", false);
        this.screen.jdMethod_do("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.bmg("contact_info_biz_enable")).gX(this.gte.getResources().getString(2131758733), this.gte.getResources().getColor(2131100063));
        this.screen.jdMethod_do("contact_is_mute", true);
        this.screen.jdMethod_do("biz_placed_to_the_top", true);
        this.screen.jdMethod_do("contact_info_locate", true);
        break label528;
        label1878:
        if (localc.UF())
        {
          this.screen.jdMethod_do("contact_info_locate", true);
          this.screen.jdMethod_do("contact_info_subscribe_bizinfo", false);
          this.screen.jdMethod_do("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.bmg("contact_info_biz_go_chatting")).gX(this.gte.getResources().getString(2131758734), this.gte.getResources().getColor(2131100063));
          localObject1 = this.screen;
          if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.bmg("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).setChecked(this.contact.arE());
            ((CheckBoxPreference)localObject1).setTitle(2131758737);
            eEu();
            this.screen.jdMethod_do("contact_is_mute", false);
            this.guh = this.contact.Zx();
            sG(this.guh);
            break;
          }
        }
        localObject1 = this.screen;
        if ((ab.Jf(this.contact.field_username)) || (!com.tencent.mm.contact.c.oR(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.bmg("contact_info_stick_biz")).setChecked(this.contact.arE());
          this.screen.jdMethod_do("contact_is_mute", true);
          this.guh = false;
          break;
        }
        this.screen.jdMethod_do("near_field_service", true);
        break label600;
        this.BeY = true;
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          eEq();
          break label642;
        }
        this.screen.jdMethod_do("contact_info_time_expired", true);
        break label642;
        label2270:
        this.screen.jdMethod_do("contact_info_time_expired", true);
        break label672;
        label2287:
        this.screen.jdMethod_do("contact_info_service_phone", true);
        continue;
        this.screen.jdMethod_do("contact_info_time_expired", true);
        Log.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).OYB = false;
        ((KeyValuePreference)localObject2).OFU = this.gte.getString(2131757925);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.contact.signature));
        ((KeyValuePreference)localObject2).BC(false);
        if (ay.a.iDs != null)
        {
          localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(this.contact.field_verifyFlag), 2.0F);
          label2401:
          if (localObject1 != null) {
            break label2519;
          }
          bool = true;
          label2409:
          Log.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5461;
          }
        }
      }
      label4435:
      label5461:
      for (localObject1 = new BitmapDrawable(this.gte.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).OYI = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).OYG = 8;
        ((KeyValuePreference)localObject2).alO(8);
        if ((!ab.Iv(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
          break;
        }
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, cr.KN("BRAND_Team")));
        break;
        localObject1 = null;
        break label2401;
        label2519:
        bool = false;
        break label2409;
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.jdMethod_do("contact_info_user_desc", true);
        if (this.BeY) {
          break;
        }
        this.screen.jdMethod_do("contact_info_time_expired", true);
        break;
        ((KeyValuePreference)localObject6).OFU = ((c.b.e)localObject4).dis;
        break label956;
        localObject1 = null;
        break label983;
        bool = false;
        break label1014;
        Log.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1139;
        Log.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1146;
        this.screen.jdMethod_do("contact_info_verifyuser", true);
        break label1183;
        label2657:
        if ((this.dhv != null) && (this.dhv.Vb() != null) && (!Util.isNullOrNil(this.dhv.Vb().diA)))
        {
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1183;
          }
          ((KeyValuePreference)localObject1).setSummary(this.dhv.Vb().diA);
          if ((!ab.Iv(this.contact.field_username)) || (!WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam())) {
            break label1183;
          }
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, cr.KN("OfficialEntity")));
          ((KeyValuePreference)localObject1).alO(8);
          break label1183;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.jdMethod_do("contact_info_verifyuser", true);
        break label1183;
        label2799:
        localObject1 = null;
        break label1245;
        label2805:
        bool = false;
        break label1253;
        label2811:
        Log.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.jdMethod_do("contact_info_trademark", true);
        break label1347;
        this.screen.jdMethod_do("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.dhu != null) && (this.dhu.size() > 0)) {
          i = this.dhu.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.dhu.get(i) != null) && ((!this.gte.getString(2131757847).equals(((c.a)this.dhu.get(i)).title)) || (this.dhC)) && ((!Util.isNullOrNil(((c.a)this.dhu.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.dhu.get(i)).dhy))))
          {
            localObject5 = new Preference(this.gte);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.dhu.get(i)).title;
            j = this.gte.getResources().getIdentifier(((c.a)this.dhu.get(i)).dhy, "string", this.gte.getPackageName());
            if (j > 0) {
              localObject1 = this.gte.getString(j);
            }
            if ((ab.Iv(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) && (((String)localObject1).equals(this.gte.getString(2131755017)))) {
              this.screen.jdMethod_do(((Preference)localObject5).mKey, true);
            }
            localObject2 = localObject1;
            if (this.Bdk.UE()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.dhu.get(i)).dhy))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.gte.getString(2131755017))) {}
              }
              else
              {
                localObject2 = this.gte.getString(2131758725);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!Util.isNullOrNil(((c.a)this.dhu.get(i)).description)) {
              ((Preference)localObject5).setSummary(((c.a)this.dhu.get(i)).description);
            }
            if (!Util.nullAsNil(((c.a)this.dhu.get(i)).dhy).equals("__mp_wording__brandinfo_feedback")) {
              break label5437;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5437;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (Util.nullAsNil(((c.a)this.dhu.get(i)).dhy).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.gte);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          Log.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.BeY) && (ab.J(this.contact)) && (this.contact.fuM != null) && (!this.contact.fuM.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(Util.nullAs(this.contact.field_weiboNickname, "") + this.gte.getString(2131765588, new Object[] { ab.JL(this.contact.fuM) }));
            ((Preference)localObject1).qlp = com.tencent.mm.cb.a.n(this.gte, 2131100685);
            ((KeyValuePreference)localObject1).BC(false);
          }
          if ((this.dhv == null) || (this.dhv.UY() == null)) {
            break label4367;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bmg("contact_info_reputation");
          if (this.dhv.UY().div <= 0) {
            break label4316;
          }
          ((BizInfoPayInfoIconPreference)localObject1).UA(this.dhv.UY().div);
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bmg("contact_info_guarantee_info");
          if ((this.dhv.UY().dix == null) || (this.dhv.UY().dix.size() <= 0)) {
            break label4333;
          }
          ((BizInfoPayInfoIconPreference)localObject1).fR(this.dhv.UY().dix);
          label3672:
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.dhv.UY().diw)) {
            break label4350;
          }
          ((KeyValuePreference)localObject1).setSummary(this.dhv.UY().diw);
          ((KeyValuePreference)localObject1).OYG = 4;
          ((KeyValuePreference)localObject1).BC(false);
          if ((this.BeW == null) || (this.BeW.size() <= 0)) {
            break label4412;
          }
          this.screen.jdMethod_do("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.bmg("contact_info_bindwxainfo")).a(this.Bdk, this.BeW);
          aKq(this.gte.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          Log.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.gte.getIntent() == null) || (!this.gte.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4729;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = eEs();
          Log.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.contact.c.oR(this.contact.field_type)) || (!bool)) {
            break label4562;
          }
          if (localc == null) {
            break label4519;
          }
          localObject1 = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
          if (!localc.UH()) {
            break label4446;
          }
          localObject5 = ag.bal().fC(localc.field_username);
          this.BeV = ag.bal().fB((String)localObject5);
          if (this.BeV == null) {
            break label4435;
          }
          if (this.BeV.iE(4)) {
            break label4429;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).setChecked(bool);
          if (!localc.Ux()) {
            break label4476;
          }
          if ((this.dhv == null) && (localc != null)) {
            this.dhv = localc.cG(false);
          }
          if ((this.dhv == null) || (!this.dhv.UR()) || (!com.tencent.mm.br.c.aZU("brandservice"))) {
            break label4459;
          }
          this.screen.jdMethod_do("contact_info_template_recv", false);
          if (!localc.cG(false).UB()) {
            break label4493;
          }
          ((CheckBoxPreference)localObject2).setChecked(localc.Uy());
        }
        for (;;)
        {
          this.screen.jdMethod_do("contact_info_biz_read_msg_online", true);
          this.screen.jdMethod_do("contact_info_biz_add", true);
          localObject1 = this.contact.arJ();
          if (localObject1 != null) {
            this.gte.setMMTitle((String)localObject1);
          }
          if (ab.Jf(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.bmg("contact_info_biz_go_chatting")).gX(this.gte.getResources().getString(2131758046), this.gte.getResources().getColor(2131100063));
            this.gte.setMMTitle(2131758123);
          }
          if ((!ab.JA(this.contact.field_username)) && (this.Bdk != null) && (!this.Bdk.UG())) {
            this.gte.addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
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
          this.screen.jdMethod_do("contact_info_verifyuser_weibo", true);
          break;
          label4316:
          this.screen.jdMethod_do("contact_info_reputation", true);
          break label3609;
          label4333:
          this.screen.jdMethod_do("contact_info_guarantee_info", true);
          break label3672;
          label4350:
          this.screen.jdMethod_do("contact_info_scope_of_business", true);
          break label3732;
          this.screen.jdMethod_do("contact_info_reputation", true);
          this.screen.jdMethod_do("contact_info_guarantee_info", true);
          this.screen.jdMethod_do("contact_info_scope_of_business", true);
          break label3732;
          this.screen.jdMethod_do("contact_info_bindwxainfo", true);
          break label3791;
          bool = false;
          break label4026;
          Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label4033;
          label4446:
          ((CheckBoxPreference)localObject1).setChecked(localc.Ux());
          break label4033;
          label4459:
          this.screen.jdMethod_do("contact_info_template_recv", true);
          break label4103;
          label4476:
          this.screen.jdMethod_do("contact_info_template_recv", true);
          break label4103;
          this.screen.jdMethod_do("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).setChecked(localc.Uy());
          continue;
          this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
          this.screen.jdMethod_do("contact_info_locate", true);
          this.screen.jdMethod_do("contact_info_template_recv", true);
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        eEq();
        localObject1 = this.screen.bmg("contact_info_biz_add");
        Log.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.BeZ) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131757831);
          }
        }
        else if (UL(this.kgm))
        {
          if (localc != null) {
            break label4691;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.gte.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(2131757823);
          break;
          ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(localc.Ux());
          this.screen.jdMethod_do("contact_info_subscribe_bizinfo", false);
        }
        label4729:
        if (com.tencent.mm.contact.c.oR(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
            if (localc.UH())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758730);
              localObject5 = ag.bal().fC(localc.field_username);
              this.BeV = ag.bal().fB((String)localObject5);
              if (this.BeV != null) {
                if (!this.BeV.iE(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).setChecked(bool);
                  if (!localc.Ux()) {
                    break label5210;
                  }
                  if ((this.dhv == null) && (localc != null)) {
                    this.dhv = localc.cG(false);
                  }
                  if ((this.dhv == null) || (!this.dhv.UR()) || (!com.tencent.mm.br.c.aZU("brandservice"))) {
                    break label5193;
                  }
                  this.screen.jdMethod_do("contact_info_template_recv", false);
                  if (!localc.cG(false).UB()) {
                    break label5227;
                  }
                  ((CheckBoxPreference)localObject2).setChecked(localc.Uy());
                }
              }
            }
          }
          for (;;)
          {
            this.screen.jdMethod_do("contact_info_biz_read_msg_online", true);
            this.screen.jdMethod_do("contact_info_biz_add", true);
            localObject1 = this.contact.arJ();
            if (localObject1 != null) {
              this.gte.setMMTitle((String)localObject1);
            }
            if (ab.Jf(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.bmg("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).OXm = true;
              ((ButtonPreference)localObject1).gX(this.gte.getResources().getString(2131758046), this.gte.getResources().getColor(2131100063));
              this.gte.setMMTitle(2131758123);
            }
            if ((!ab.JA(this.contact.field_username)) && (this.Bdk != null)) {
              this.gte.addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
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
            break label4848;
            if (localc.UF())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758738);
              if (!ag.bar().MS(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).setChecked(bool);
                break;
              }
            }
            ((CheckBoxPreference)localObject1).setChecked(localc.Ux());
            break label4848;
            this.screen.jdMethod_do("contact_info_template_recv", true);
            break label4918;
            this.screen.jdMethod_do("contact_info_template_recv", true);
            break label4918;
            this.screen.jdMethod_do("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).setChecked(localc.Uy());
            continue;
            this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
            this.screen.jdMethod_do("contact_info_locate", true);
            this.screen.jdMethod_do("contact_info_template_recv", true);
          }
        }
        label4848:
        Log.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        label5210:
        label5227:
        eEq();
        localObject1 = this.screen.bmg("contact_info_biz_add");
        if ((localObject1 != null) && (this.BeZ)) {
          ((Preference)localObject1).setTitle(2131757831);
        }
        if (UL(this.kgm))
        {
          if (localc != null) {
            break label5394;
          }
          Log.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.gte.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(localc.Ux());
          this.screen.jdMethod_do("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1139;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void eEq()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (!ab.Jf(this.contact.field_username)) && (!ab.JM(this.contact.field_username)))
    {
      this.screen.jdMethod_do("contact_is_mute", false);
      this.screen.jdMethod_do("contact_info_verifyuser_weibo", true);
      this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
      this.screen.jdMethod_do("contact_info_template_recv", true);
      this.screen.jdMethod_do("contact_info_locate", true);
      if (this.BeY) {
        break label313;
      }
      this.screen.jdMethod_do("contact_info_time_expired", true);
      label141:
      if ((this.contact == null) || ((!ab.JA(this.contact.field_username)) && (!ab.JM(this.contact.field_username))) || (!com.tencent.mm.contact.c.oR(this.contact.field_type))) {
        break label330;
      }
      this.screen.jdMethod_do("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (ab.JM(this.contact.field_username)) {
        this.screen.jdMethod_do("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.jdMethod_do("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.contact.c.oR(this.contact.field_type)) && (UL(this.kgm)))
      {
        this.screen.jdMethod_do("contact_info_expose_btn", false);
        break;
      }
      this.screen.jdMethod_do("contact_info_expose_btn", true);
      break;
      label313:
      this.screen.jdMethod_do("contact_info_biz_add", true);
      break label141;
      label330:
      this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
    }
  }
  
  private void eEr()
  {
    AppMethodBeat.i(27101);
    if ((this.gte.getIntent() != null) && (this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.gte.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label163;
      }
      Log.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (eEs())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.gte, new c.6(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.kgm));
      if (this.dhE != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wHV = this.dhE;
      }
      if (!Util.isNullOrNil(this.wZz)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wZz = this.wZz;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Keg = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.Bfi);
      AppMethodBeat.o(27101);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bg.azz().a(536, this);
    Object localObject2 = new dr();
    ((dr)localObject2).dGF.dGH = ((String)localObject1);
    ((dr)localObject2).dGF.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dr)localObject2).dGG.dGJ;
    localObject2 = this.gte;
    this.gte.getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.gte.getString(2131756029), true, new c.5(this, (com.tencent.mm.ak.q)localObject1));
    AppMethodBeat.o(27101);
  }
  
  private boolean eEs()
  {
    AppMethodBeat.i(27102);
    if (this.gte.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.gte.getIntent().getStringExtra("device_id");
    String str2 = this.gte.getIntent().getStringExtra("device_type");
    dv localdv = new dv();
    localdv.dGR.dGL = str1;
    localdv.dGR.dGP = str2;
    EventCenter.instance.publish(localdv);
    boolean bool = localdv.dGS.dGT;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void eEt()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format(Bff, new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  private void eEu()
  {
    AppMethodBeat.i(27111);
    Log.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.gte.getSharedPreferences(this.gte.getPackageName() + "_preferences", 0);
    }
    if (this.gtX != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.arE()).commit();
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
  
  private void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.Bdk.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      bg.azz().a(1394, this);
      bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
      MMActivity localMMActivity = this.gte;
      this.gte.getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a(localMMActivity, this.gte.getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          bg.azz().a(this.ppp);
          bg.azz().b(1394, c.this);
          AppMethodBeat.o(27084);
        }
      });
      AppMethodBeat.o(27091);
      return;
    }
  }
  
  private void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.gte != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.al.g.DQ(this.contact.field_username))) {
          break label77;
        }
        this.gte.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.setChecked(paramBoolean);
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.gte.setTitleMuteIconVisibility(8);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(27110);
    if ((this.Bdk == null) || (!this.Bdk.UH()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramq.getType() == 1354)
    {
      paramq = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
      String str = ag.bal().fC(this.Bdk.field_username);
      this.BeV = ag.bal().fB(str);
      if (this.BeV != null)
      {
        if (!this.BeV.iE(4)) {}
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
      this.Bdx = paramBoolean;
      this.kgm = paramInt;
      this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.Bfh = ((SnsAdClick)this.gte.getIntent().getParcelableExtra("KSnsAdTag"));
      this.Bfg = this.gte.getIntent().getBundleExtra("Contact_Ext_Args");
      this.Bfi = this.gte.getIntent().getStringExtra("key_add_contact_report_info");
      eEp();
      paramf = this.gte.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.gte.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.gte, paramf, "", this.gte.getString(2131755921), null);
      }
      if (paramas != null)
      {
        ag.bau().MN(paramas.field_username);
        if (com.tencent.mm.al.g.Ne(paramas.field_username))
        {
          paramf = paramas.field_username;
          if (!com.tencent.mm.al.g.DQ(paramf)) {
            break label301;
          }
          ag.baq();
          com.tencent.mm.al.a.h.a(paramf, this);
          paramf = com.tencent.mm.al.g.fJ(paramf).UN();
          if (paramf != null) {
            ag.bau().MN(paramf);
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
      if (com.tencent.mm.al.g.Ng(paramf))
      {
        ag.bar();
        e.a(paramf, this);
        ag.bah();
        paramf = com.tencent.mm.al.f.MX(paramf);
        if (paramf != null) {
          ag.bau().MN(paramf);
        }
      }
    }
  }
  
  public final String aZT()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean alD(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.gte).jx(this.contact.fuM, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.Bfh != null)
      {
        paramString = new rr();
        this.Bfh.jkU = 5;
        paramString.dYk.dYl = this.Bfh;
        EventCenter.instance.publish(paramString);
      }
      if ((this.Bdk != null) && ((this.Bdk.UF()) || (this.Bdk.UH())))
      {
        paramString = new Intent();
        if (this.Bdk.UH())
        {
          localObject1 = this.Bdk.UN();
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", aa.getDisplayName((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.br.c.f(this.gte, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.gte.finish();
        }
      }
      for (;;)
      {
        bP(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", aa.getDisplayName(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.gte.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.Bdx)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.gte.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.jRt.d(paramString, this.gte);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aXj()) {
        eEr();
      }
      for (;;)
      {
        if (this.Bfb != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11263, new Object[] { Integer.valueOf(this.Bfb), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.gte, com.tencent.mm.model.gdpr.a.iGN, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void sx(int paramAnonymousInt)
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
      if (((CheckBoxPreference)this.screen.bmg("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.kgm) });
        com.tencent.mm.model.j.HO(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        ab.F(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.kgm) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.dhv.UY() != null) && (!Util.isNullOrNil(this.dhv.UY().diy)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.dhv.UY().diy);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = Util.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.dhu.size()))
      {
        paramString = (c.a)this.dhu.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.Bfg != null) && ((this.kgm == 39) || (this.kgm == 56) || (this.kgm == 35))) || (this.kgm == 87) || (this.kgm == 89) || (this.kgm == 85) || (this.kgm == 88))
        {
          Log.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.Bfg);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            break label1169;
          }
        }
        label1169:
        for (i = 7;; i = 6)
        {
          int j = this.gte.getResources().getIdentifier(paramString.dhy, "string", this.gte.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.gte.getString(j);
          }
          bP(i, paramString);
          com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(27090);
          return true;
        }
      }
    }
    label1384:
    label1389:
    boolean bool;
    if (("contact_info_subscribe_bizinfo".endsWith(paramString)) || ("contact_info_show_brand".endsWith(paramString)) || ("contact_info_locate".endsWith(paramString)))
    {
      localObject1 = this.Bdk;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).UE()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).UH()) {
              break label1389;
            }
            bg.azz().a(1363, this);
            if (!((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1384;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            bg.azz().a(paramString, 0);
            localObject2 = this.gte;
            this.gte.getString(2131755998);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.gte.getString(2131756029), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).UH()) && (!((com.tencent.mm.api.c)localObject1).UF())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).UF())
        {
          paramString = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
          ag.bar();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = e.a((String)localObject2, bool, this);
            localObject2 = this.gte;
            this.gte.getString(2131755998);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.gte.getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                ag.bar();
                e.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).Ux())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.dhv == null) && (localObject1 != null)) {
              this.dhv = ((com.tencent.mm.api.c)localObject1).cG(false);
            }
            if ((this.dhv != null) && (this.dhv.UR()) && (com.tencent.mm.br.c.aZU("brandservice")))
            {
              this.screen.jdMethod_do("contact_info_template_recv", false);
              label1579:
              paramString = com.tencent.mm.plugin.report.service.h.CyF;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).Ux()) {
                break label1704;
              }
            }
          }
          label1704:
          for (i = 3;; i = 4)
          {
            paramString.a(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.kgm) });
            break;
            this.screen.jdMethod_do("contact_info_template_recv", true);
            break label1579;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.jdMethod_do("contact_info_template_recv", true);
            break label1579;
          }
          if ("contact_info_show_brand".endsWith(paramString))
          {
            if ((((com.tencent.mm.api.c)localObject1).field_brandFlag & 0x2) == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1755;
              }
              ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x2;
              break;
            }
            label1755:
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFD;
          }
          else if ("contact_info_locate".endsWith(paramString))
          {
            if (((com.tencent.mm.api.c)localObject1).Uy()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.Bfe = com.tencent.mm.ui.base.h.a(this.gte, this.gte.getString(2131757343, new Object[] { this.contact.arJ() }), this.gte.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.dob.field_hadAlert = 1;
                  this.dob.field_brandFlag |= 0x4;
                  c.a(c.this, this.dob, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.dob.field_hadAlert = 1;
                  c.a(c.this, this.dob, false);
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
      if ((ab.Iv(this.contact.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
      {
        AppMethodBeat.o(27090);
        return true;
      }
      paramString = this.Bdk;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.cG(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((c.b)localObject2).Va() != null) && (!Util.isNullOrNil(((c.b)localObject2).Va().dit))) {
        paramString = ((c.b)localObject2).Va().dit;
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
          com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).Vb() != null)
        {
          paramString = (String)localObject1;
          if (!Util.isNullOrNil(((c.b)localObject2).Vb().diB)) {
            paramString = ((c.b)localObject2).Vb().diB;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.Bdk;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.cG(false) != null) && (!Util.isNullOrNil(paramString.cG(false).UT())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.cG(false).UT());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.guh)
      {
        bool = true;
        this.guh = bool;
        if (!this.guh) {
          break label2708;
        }
        ab.z(this.contact);
        label2267:
        sG(this.guh);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.gte != null) {
          break label2718;
        }
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2300:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.gte.getString(2131758732);
        localObject2 = this.gte.getString(2131758731);
        com.tencent.mm.ui.base.h.c(this.gte, (String)localObject1, "", (String)localObject2, this.gte.getString(2131755761), new DialogInterface.OnClickListener()
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
        sF(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.Bdk.field_username);
        com.tencent.mm.br.c.b(this.gte, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.bmg("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!Util.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.gte, true, (String)localObject1, "", this.gte.getString(2131757871), this.gte.getString(2131755761), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        eEt();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.gte.getSharedPreferences(this.gte.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.arE()) {
            break label2788;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          ab.F(this.contact.field_username, true);
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
      label2708:
      ab.A(this.contact);
      break label2267;
      label2718:
      if (this.Bdk == null)
      {
        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2300;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.Bdk.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.c.b(this.gte, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2300;
      label2788:
      com.tencent.mm.model.j.HO(this.contact.field_username);
      Log.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.bmg("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  public final void e(LinkedList<fbw> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    ag.bai().b(this);
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
    if (!Util.isNullOrNil(this.Bfc))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fbw localfbw = (fbw)((Iterator)localObject).next();
        if ((localfbw.NxV != null) && (localfbw.NxV.equals(this.Bfc)))
        {
          this.screen.jdMethod_do("contact_info_kf_worker", false);
          this.screen.bmg("contact_info_kf_worker").setSummary(localfbw.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.jdMethod_do("contact_info_kf_worker", false);
    Object localObject = this.screen.bmg("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((fbw)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.gte == null)
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
      com.tencent.mm.plugin.messenger.a.g.eir().s(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.gte, this.gte.getString(2131760708));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    Log.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.Bfd = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    bg.azz().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    Log.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bg.azz().b(536, this);
      eEp();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (paramString = (dvz)paramString.rr.iLL.iLR;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramq;
        paramq = (com.tencent.mm.ak.q)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramq = (com.tencent.mm.ak.q)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.iLK.iLR != null) {
            paramq = (dvy)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.iLK.iLR;
          }
        }
        if ((paramString != null) && (paramString.KTz != null) && (paramString.KTz.ret == 0) && (paramString.KTw != null) && (!Util.isNullOrNil(paramString.KTw.KTu))) {
          break label413;
        }
        if ((paramString == null) || (paramString.KTz == null)) {
          break;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.KTz.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.KTw == null)
      {
        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = ag.bal().fB(paramString.KTw.KTu);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new k();
        ((k)localObject1).field_userId = paramString.KTw.KTu;
      }
      ((k)localObject1).field_userName = paramString.KTw.pWm;
      ((k)localObject1).field_brandUserName = paramq.KTt;
      ((k)localObject1).field_UserVersion = paramString.KTw.ver;
      ((k)localObject1).field_headImageUrl = paramString.KTw.KTm;
      ((k)localObject1).field_profileUrl = paramString.KTw.gTH;
      ((k)localObject1).field_bitFlag = paramString.KTw.KTn;
      ((k)localObject1).field_addMemberUrl = paramString.KTw.KTr;
      ((k)localObject1).field_needToUpdate = false;
      if (!ag.bal().b((k)localObject1)) {
        ag.bal().a((k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).eDZ();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramq).eDY();
      if ((localObject1 == null) || (((efn)localObject1).KTz == null) || (((efn)localObject1).KTz.ret != 0))
      {
        if ((localObject1 != null) && (((efn)localObject1).KTz != null))
        {
          Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((efn)localObject1).KTz.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.neT)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.Bdk;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        bg.aVF();
        if (com.tencent.mm.model.c.aST().bjY(paramString.field_username) == null)
        {
          paramq = new az(paramString.field_username);
          paramq.Co(Util.nullAsNil(this.Bdk.UN()));
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aEx(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          bg.aVF();
          com.tencent.mm.model.c.aST().e(paramq);
          bg.aVF();
          com.tencent.mm.model.c.aST().aY((ca)localObject1);
        }
      }
      for (;;)
      {
        bg.aVF();
        if (com.tencent.mm.model.c.aST().bjY(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new az(paramString.field_enterpriseFather);
        paramString.gCr();
        bg.aVF();
        com.tencent.mm.model.c.aST().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramq.gCr();
        bg.aVF();
        com.tencent.mm.model.c.aST().e(paramq);
      }
      label954:
      bg.aVF();
      com.tencent.mm.model.c.aSS().biO(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.Bdk;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      bg.aVF();
      com.tencent.mm.model.c.aST().bjW(paramString.field_username);
      bg.aVF();
      if (com.tencent.mm.model.c.aST().bkk(paramString.field_enterpriseFather) <= 0)
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      bg.aVF();
      com.tencent.mm.model.c.aSS().biO(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1343)
    {
      eEp();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramq.getType() == 1228) {
      eEp();
    }
    AppMethodBeat.o(27108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */