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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ae;
import com.tencent.mm.al.af;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.o;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  implements com.tencent.mm.ak.g, h.b, o, com.tencent.mm.pluginsdk.b.a
{
  private List<c.a> cFl;
  private c.b cFm;
  private boolean cFt = false;
  private String cFv;
  ai contact;
  private CheckBoxPreference ftD;
  private boolean ftN;
  MMActivity iMV;
  private int iMg;
  boolean isDeleteCancel = false;
  String sBi;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  com.tencent.mm.ui.base.p tipDialog = null;
  com.tencent.mm.api.c vIG;
  private boolean vIS;
  private String vIX;
  private com.tencent.mm.al.a.k vKi;
  private List<WxaAttributes.WxaEntryInfo> vKj;
  private aaf vKk = null;
  private boolean vKl = false;
  private boolean vKm = false;
  boolean vKn = false;
  private int vKo = 0;
  private String vKp;
  private boolean vKq;
  com.tencent.mm.ui.widget.a.d vKr = null;
  private Bundle vKs;
  SnsAdClick vKt = null;
  private String vKu = null;
  
  private c(MMActivity paramMMActivity)
  {
    this.iMV = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, aaf paramaaf)
  {
    this(paramMMActivity);
    this.vIX = paramString;
    this.vKk = paramaaf;
  }
  
  private String Lp(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      ac.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.iMV.getResources().getString(2131757694);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.iMV.getResources().getString(2131757895);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.iMV.getResources().getString(2131756745);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.iMV.getResources().getString(2131756746);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean Lq(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static boolean apC(String paramString)
  {
    AppMethodBeat.i(27099);
    try
    {
      long l = bs.getLong(paramString, 0L);
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
  
  private void apD(String paramString)
  {
    AppMethodBeat.i(27105);
    ac.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.vKq) });
    if (this.vKq)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.vKp = paramString;
    if ((this.cFm == null) || (!this.cFm.Jp()) || (this.contact == null))
    {
      this.screen.cK("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      paramString = af.aCV().AY(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.cK("contact_info_kf_worker", true);
        af.aCX().a(this);
        af.aCX().aZ(this.contact.field_username, u.axw());
        this.vKq = true;
        AppMethodBeat.o(27105);
        return;
      }
      ac.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.cK("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aPN("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        apE(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).Z((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = af.aCV();
    Object localObject1 = ((com.tencent.mm.al.i)localObject2).AX(paramString);
    if ((localObject1 == null) || (com.tencent.mm.al.i.a((com.tencent.mm.al.g)localObject1)))
    {
      af.aCX().a(this);
      af.aCX().l(this.contact.field_username, paramString, 1);
      this.vKq = true;
    }
    if (localObject1 == null) {
      ac.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.al.i)localObject2).AY(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.cK("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.cK("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aPN("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        apE(paramString.field_openId);
      }
      for (;;)
      {
        ac.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).Z((Bitmap)localObject2);
      }
    }
  }
  
  private void apE(String paramString)
  {
    AppMethodBeat.i(27106);
    com.tencent.mm.sdk.platformtools.ap.n(new c.11(this, paramString), 2000L);
    AppMethodBeat.o(27106);
  }
  
  private static void c(com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.aj.j localj = com.tencent.mm.aj.p.aBw();
    if (localj.Ak(paramg.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramg.field_openId;
      locali.huE = paramg.field_headImgUrl;
      locali.ez(false);
      locali.exK = 3;
      localj.b(locali);
    }
    com.tencent.mm.aj.p.aBy().zW(paramg.field_openId);
    ac.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void dqc()
  {
    AppMethodBeat.i(27094);
    bYJ();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951636);
    if (this.vKn) {
      this.screen.cK("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.al.f.dX(this.contact.field_username);
    this.cFl = null;
    this.cFm = null;
    this.vKj = null;
    if (((localc == null) || (localc.bV(false) == null)) && (this.vKk != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.vKk.iKh;
      localc.field_brandIconURL = this.vKk.iKk;
      localc.field_brandInfo = this.vKk.iKj;
      localc.field_extInfo = this.vKk.iKi;
    }
    label528:
    label672:
    label1844:
    label5303:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.vKk != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.vKk.iKh;
        localc.field_brandIconURL = this.vKk.iKk;
        localc.field_brandInfo = this.vKk.iKj;
        localc.field_extInfo = this.vKk.iKi;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.aPN("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!bs.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.vIX, localc);
        this.screen.cK("biz_placed_to_the_top", true);
        this.screen.cK("contact_info_biz_enable", true);
        this.screen.cK("contact_info_biz_disable", true);
        this.screen.cK("contact_info_stick_biz", true);
        if (localc == null) {
          break label2272;
        }
        if (!localc.IO()) {
          break label1844;
        }
        this.screen.cK("contact_info_biz_add", true);
        this.screen.cK("contact_info_expose_btn", true);
        this.screen.cK("contact_is_mute", false);
        this.ftN = this.contact.Nw();
        if (!localc.IP()) {
          break label1559;
        }
        this.screen.cK("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.n.b.ln(this.contact.field_type)) {
          break label1553;
        }
        bool = true;
        label474:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cK("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.aPN("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).mF = this.contact.aaN();
        ((CheckBoxPreference)localObject1).setTitle(2131758432);
        dqh();
        oR(this.ftN);
        this.vIG = localc;
        this.cFl = localc.IW();
        this.cFm = localc.bV(false);
        this.vKj = this.cFm.getWxaEntryInfoList();
        if (!this.cFm.IX()) {
          break label2157;
        }
        this.screen.aPN("near_field_service").setSummary(2131766197);
        label600:
        if (this.cFm.Jd() == null) {
          break label2238;
        }
        this.vKm = true;
        if (apC(this.cFm.Jd())) {
          break label2174;
        }
        this.screen.cK("contact_info_time_expired", true);
        if ((w.xo(this.contact.field_username)) || (w.xz(this.contact.field_username))) {
          dqd();
        }
        if ((this.cFm.Ja() != null) && (this.cFm.Ja().length() > 0)) {
          this.cFv = this.cFm.Ja();
        }
        this.cFt = this.cFm.IY();
        if (bs.isNullOrNil(this.cFm.Jo())) {
          break label2255;
        }
        this.screen.cK("contact_info_service_phone", false);
        localObject1 = this.screen.aPN("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.cFm.Jo());
          ((Preference)localObject1).omy = this.iMV.getResources().getColor(2131100547);
        }
      }
      Object localObject2;
      Object localObject4;
      Object localObject6;
      label956:
      label983:
      label1006:
      label1014:
      label1146:
      int i;
      for (;;)
      {
        Object localObject7;
        if (!bs.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.aPN("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bs.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.cK("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.cFm == null) || (this.cFm.Ji() == null) || (bs.isNullOrNil(this.cFm.Ji().cGj))) {
              break label2588;
            }
            localObject4 = this.cFm.Ji();
            localObject6 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2571;
            }
            ((KeyValuePreference)localObject6).HET = false;
            if (!bs.isNullOrNil(((c.b.e)localObject4).cGk)) {
              break label2502;
            }
            ((KeyValuePreference)localObject6).Hnl = Lp(((c.b.e)localObject4).cGi);
            if (ar.a.hny == null) {
              break label2515;
            }
            localObject1 = BackwardSupportUtil.b.n(ar.a.hny.nR(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5303;
            }
            localObject2 = new BitmapDrawable(this.iMV.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2521;
            }
            bool = true;
            ac.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).HFa = ((Drawable)localObject2);
            if (((c.b.e)localObject4).cGj == null) {
              break label2560;
            }
            localObject7 = ((c.b.e)localObject4).cGm;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, ((c.b.e)localObject4).cGj.trim());
            if (bs.isNullOrNil((String)localObject7)) {
              break label5296;
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
          label1208:
          label1216:
          label1259:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, ((String)localObject7).length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.cFm == null) || (bs.isNullOrNil(this.cFm.Jc()))) {
            break label2698;
          }
          localObject2 = (KeyValuePreference)this.screen.aPN("contact_info_trademark");
          if (localObject2 == null) {
            break label1310;
          }
          ((KeyValuePreference)localObject2).HET = false;
          if (ar.a.hny == null) {
            break label2686;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.f.Yo(2131689767);
          if (localObject1 != null) {
            break label2692;
          }
          bool = true;
          ac.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5290;
          }
          localObject1 = new BitmapDrawable(this.iMV.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            j = k;
          }
          localObject1 = null;
          break label1259;
        }
        ((KeyValuePreference)localObject2).HFa = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cFm.Jc());
        ac.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.cFm.Jc(), this.cFm.Jb() });
        if ((this.cFm == null) || (this.cFm.Je() == null) || (this.cFm.Je().size() <= 0)) {
          break label2723;
        }
        localObject2 = (KeyValuePreference)this.screen.aPN("contact_info_privilege");
        ((KeyValuePreference)localObject2).wV(false);
        ((KeyValuePreference)localObject2).fjp();
        localObject4 = this.cFm.Je().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.iMV, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.iMV.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.iMV.getResources().getIdentifier(((c.b.g)localObject7).cGr, "string", this.iMV.getPackageName());
          if (i > 0) {
            localObject1 = this.iMV.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).fT((View)localObject6);
        }
        ac.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.cK("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.cK("contact_info_subscribe_bizinfo", true);
        this.screen.cK("contact_info_biz_go_chatting", true);
        if (localc.IF())
        {
          this.screen.cK("contact_info_biz_enable", true);
          this.screen.cK("contact_info_biz_disable", false);
          this.screen.aPN("contact_info_biz_disable").setTitle(2131758434);
          this.screen.cK("contact_is_mute", false);
          this.screen.cK("biz_placed_to_the_top", false);
          this.ftD = ((CheckBoxPreference)this.screen.aPN("biz_placed_to_the_top"));
          this.ftD.setTitle(2131758450);
          dqh();
          if (!localc.IQ()) {
            break label528;
          }
          this.screen.cK("contact_info_locate", true);
          break label528;
        }
        this.screen.cK("contact_info_biz_enable", false);
        this.screen.cK("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.aPN("contact_info_biz_enable")).fY(this.iMV.getResources().getString(2131758436), this.iMV.getResources().getColor(2131100035));
        this.screen.cK("contact_is_mute", true);
        this.screen.cK("biz_placed_to_the_top", true);
        this.screen.cK("contact_info_locate", true);
        break label528;
        if (localc.IN())
        {
          this.screen.cK("contact_info_locate", true);
          this.screen.cK("contact_info_subscribe_bizinfo", false);
          this.screen.cK("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.aPN("contact_info_biz_go_chatting")).fY(this.iMV.getResources().getString(2131758437), this.iMV.getResources().getColor(2131100035));
          localObject1 = this.screen;
          if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).cK("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.aPN("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).mF = this.contact.aaN();
            ((CheckBoxPreference)localObject1).setTitle(2131758440);
            dqh();
            this.screen.cK("contact_is_mute", false);
            this.ftN = this.contact.Nw();
            oR(this.ftN);
            break;
          }
        }
        localObject1 = this.screen;
        if ((w.wT(this.contact.field_username)) || (!com.tencent.mm.n.b.ln(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).cK("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.aPN("contact_info_stick_biz")).mF = this.contact.aaN();
          this.screen.cK("contact_is_mute", true);
          this.ftN = false;
          break;
        }
        label2157:
        this.screen.cK("near_field_service", true);
        break label600;
        label2174:
        this.vKl = true;
        if (!com.tencent.mm.n.b.ln(this.contact.field_type))
        {
          ac.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          dqd();
          break label642;
        }
        this.screen.cK("contact_info_time_expired", true);
        break label642;
        label2238:
        this.screen.cK("contact_info_time_expired", true);
        break label672;
        label2255:
        this.screen.cK("contact_info_service_phone", true);
        continue;
        label2272:
        this.screen.cK("contact_info_time_expired", true);
        ac.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).HET = false;
        ((KeyValuePreference)localObject2).Hnl = this.iMV.getString(2131757694);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, this.contact.signature));
        ((KeyValuePreference)localObject2).wV(false);
        if (ar.a.hny != null)
        {
          localObject1 = BackwardSupportUtil.b.n(ar.a.hny.nR(this.contact.field_verifyFlag), 2.0F);
          label2369:
          if (localObject1 != null) {
            break label2450;
          }
          bool = true;
          label2377:
          ac.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5309;
          }
        }
      }
      label4152:
      label4282:
      label5309:
      for (localObject1 = new BitmapDrawable(this.iMV.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).HFa = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).HEY = 8;
        ((KeyValuePreference)localObject2).aam(8);
        break;
        localObject1 = null;
        break label2369;
        bool = false;
        break label2377;
        ac.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.cK("contact_info_user_desc", true);
        if (this.vKl) {
          break;
        }
        this.screen.cK("contact_info_time_expired", true);
        break;
        label2502:
        ((KeyValuePreference)localObject6).Hnl = ((c.b.e)localObject4).cGk;
        break label956;
        label2515:
        localObject1 = null;
        break label983;
        label2521:
        bool = false;
        break label1014;
        ac.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1139;
        ac.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1146;
        this.screen.cK("contact_info_verifyuser", true);
        break label1146;
        if ((this.cFm != null) && (this.cFm.Jk() != null) && (!bs.isNullOrNil(this.cFm.Jk().cGs)))
        {
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1146;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cFm.Jk().cGs);
          break label1146;
        }
        ac.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.cK("contact_info_verifyuser", true);
        break label1146;
        label2686:
        localObject1 = null;
        break label1208;
        bool = false;
        break label1216;
        ac.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.cK("contact_info_trademark", true);
        break label1310;
        this.screen.cK("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.cFl != null) && (this.cFl.size() > 0)) {
          i = this.cFl.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.cFl.get(i) != null) && ((!this.iMV.getString(2131757619).equals(((c.a)this.cFl.get(i)).title)) || (this.cFt)) && ((!bs.isNullOrNil(((c.a)this.cFl.get(i)).title)) || (!bs.isNullOrNil(((c.a)this.cFl.get(i)).cFp))))
          {
            localObject5 = new Preference(this.iMV);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.cFl.get(i)).title;
            j = this.iMV.getResources().getIdentifier(((c.a)this.cFl.get(i)).cFp, "string", this.iMV.getPackageName());
            if (j > 0) {
              localObject1 = this.iMV.getString(j);
            }
            localObject2 = localObject1;
            if (this.vIG.IM()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cFl.get(i)).cFp))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.iMV.getString(2131755016))) {}
              }
              else
              {
                localObject2 = this.iMV.getString(2131758428);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bs.isNullOrNil(((c.a)this.cFl.get(i)).description)) {
              ((Preference)localObject5).setSummary(((c.a)this.cFl.get(i)).description);
            }
            if (!bs.nullAsNil(((c.a)this.cFl.get(i)).cFp).equals("__mp_wording__brandinfo_feedback")) {
              break label5285;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5285;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (bs.nullAsNil(((c.a)this.cFl.get(i)).cFp).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.iMV);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          ac.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.vKl) && (w.C(this.contact)) && (this.contact.exZ != null) && (!this.contact.exZ.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bs.bG(this.contact.field_weiboNickname, "") + this.iMV.getString(2131763406, new Object[] { w.xy(this.contact.exZ) }));
            ((Preference)localObject1).omy = com.tencent.mm.cc.a.n(this.iMV, 2131100547);
            ((KeyValuePreference)localObject1).wV(false);
          }
          if ((this.cFm == null) || (this.cFm.Jg() == null)) {
            break label4203;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aPN("contact_info_reputation");
          if (this.cFm.Jg().cGn <= 0) {
            break label4152;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Lf(this.cFm.Jg().cGn);
          label3443:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aPN("contact_info_guarantee_info");
          if ((this.cFm.Jg().cGp == null) || (this.cFm.Jg().cGp.size() <= 0)) {
            break label4169;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eB(this.cFm.Jg().cGp);
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_scope_of_business");
          if (bs.isNullOrNil(this.cFm.Jg().cGo)) {
            break label4186;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cFm.Jg().cGo);
          ((KeyValuePreference)localObject1).HEY = 4;
          ((KeyValuePreference)localObject1).wV(false);
          label3566:
          if ((this.vKj == null) || (this.vKj.size() <= 0)) {
            break label4248;
          }
          this.screen.cK("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.aPN("contact_info_bindwxainfo")).a(this.vIG, this.vKj);
          apD(this.iMV.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          ac.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.iMV.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.iMV.getIntent() == null) || (!this.iMV.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4570;
          }
          ac.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = dqf();
          ac.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ln(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.n.b.ln(this.contact.field_type)) || (!bool)) {
            break label4401;
          }
          if (localc == null) {
            break label4356;
          }
          localObject1 = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
          if (!localc.IP()) {
            break label4282;
          }
          localObject5 = af.aDa().dQ(localc.field_username);
          this.vKi = af.aDa().dP((String)localObject5);
          if (this.vKi == null) {
            break label4271;
          }
          if (this.vKi.hc(4)) {
            break label4265;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).mF = bool;
          if (!localc.IF()) {
            break label4312;
          }
          if ((this.cFm == null) && (localc != null)) {
            this.cFm = localc.bV(false);
          }
          if ((this.cFm == null) || (!this.cFm.IZ()) || (!com.tencent.mm.br.d.aCT("brandservice"))) {
            break label4295;
          }
          this.screen.cK("contact_info_template_recv", false);
          label3939:
          if (!localc.bV(false).IJ()) {
            break label4329;
          }
          ((CheckBoxPreference)localObject2).mF = localc.IG();
        }
        for (;;)
        {
          this.screen.cK("contact_info_biz_read_msg_online", true);
          this.screen.cK("contact_info_biz_add", true);
          localObject1 = this.contact.aaS();
          if (localObject1 != null) {
            this.iMV.setMMTitle((String)localObject1);
          }
          if (w.wT(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.aPN("contact_info_biz_go_chatting")).fY(this.iMV.getResources().getString(2131757806), this.iMV.getResources().getColor(2131100035));
            this.iMV.setMMTitle(2131757883);
          }
          if ((!w.xo(this.contact.field_username)) && (this.vIG != null) && (!this.vIG.IO())) {
            this.iMV.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(27087);
                c.a(c.this);
                AppMethodBeat.o(27087);
                return true;
              }
            });
          }
          AppMethodBeat.o(27094);
          return;
          this.screen.cK("contact_info_verifyuser_weibo", true);
          break;
          this.screen.cK("contact_info_reputation", true);
          break label3443;
          label4169:
          this.screen.cK("contact_info_guarantee_info", true);
          break label3506;
          label4186:
          this.screen.cK("contact_info_scope_of_business", true);
          break label3566;
          label4203:
          this.screen.cK("contact_info_reputation", true);
          this.screen.cK("contact_info_guarantee_info", true);
          this.screen.cK("contact_info_scope_of_business", true);
          break label3566;
          this.screen.cK("contact_info_bindwxainfo", true);
          break label3625;
          bool = false;
          break label3862;
          ac.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label3869;
          ((CheckBoxPreference)localObject1).mF = localc.IF();
          break label3869;
          label4295:
          this.screen.cK("contact_info_template_recv", true);
          break label3939;
          label4312:
          this.screen.cK("contact_info_template_recv", true);
          break label3939;
          label4329:
          this.screen.cK("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).mF = localc.IG();
          continue;
          this.screen.cK("contact_info_subscribe_bizinfo", true);
          this.screen.cK("contact_info_locate", true);
          this.screen.cK("contact_info_template_recv", true);
        }
        ac.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        dqd();
        localObject1 = this.screen.aPN("contact_info_biz_add");
        ac.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.vKm) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131757603);
          }
        }
        else if (Lq(this.iMg))
        {
          if (localc != null) {
            break label4530;
          }
          ac.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.iMV.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(2131757596);
          break;
          ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = localc.IF();
          this.screen.cK("contact_info_subscribe_bizinfo", false);
        }
        label4570:
        if (com.tencent.mm.n.b.ln(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
            if (localc.IP())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758433);
              localObject5 = af.aDa().dQ(localc.field_username);
              this.vKi = af.aDa().dP((String)localObject5);
              if (this.vKi != null) {
                if (!this.vKi.hc(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).mF = bool;
                  if (!localc.IF()) {
                    break label5053;
                  }
                  if ((this.cFm == null) && (localc != null)) {
                    this.cFm = localc.bV(false);
                  }
                  if ((this.cFm == null) || (!this.cFm.IZ()) || (!com.tencent.mm.br.d.aCT("brandservice"))) {
                    break label5036;
                  }
                  this.screen.cK("contact_info_template_recv", false);
                  if (!localc.bV(false).IJ()) {
                    break label5070;
                  }
                  ((CheckBoxPreference)localObject2).mF = localc.IG();
                }
              }
            }
          }
          for (;;)
          {
            this.screen.cK("contact_info_biz_read_msg_online", true);
            this.screen.cK("contact_info_biz_add", true);
            localObject1 = this.contact.aaS();
            if (localObject1 != null) {
              this.iMV.setMMTitle((String)localObject1);
            }
            if (w.wT(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.aPN("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).HDK = true;
              ((ButtonPreference)localObject1).fY(this.iMV.getResources().getString(2131757806), this.iMV.getResources().getColor(2131100035));
              this.iMV.setMMTitle(2131757883);
            }
            if ((!w.xo(this.contact.field_username)) && (this.vIG != null)) {
              this.iMV.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(27088);
                  c.a(c.this);
                  AppMethodBeat.o(27088);
                  return true;
                }
              });
            }
            AppMethodBeat.o(27094);
            return;
            bool = false;
            break;
            ac.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label4691;
            if (localc.IN())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131761483);
              if (!af.aDf().AD(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).mF = bool;
                break;
              }
            }
            ((CheckBoxPreference)localObject1).mF = localc.IF();
            break label4691;
            this.screen.cK("contact_info_template_recv", true);
            break label4761;
            this.screen.cK("contact_info_template_recv", true);
            break label4761;
            this.screen.cK("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).mF = localc.IG();
            continue;
            this.screen.cK("contact_info_subscribe_bizinfo", true);
            this.screen.cK("contact_info_locate", true);
            this.screen.cK("contact_info_template_recv", true);
          }
        }
        label4691:
        ac.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        label5053:
        label5070:
        dqd();
        localObject1 = this.screen.aPN("contact_info_biz_add");
        if ((localObject1 != null) && (this.vKm)) {
          ((Preference)localObject1).setTitle(2131757603);
        }
        if (Lq(this.iMg))
        {
          if (localc != null) {
            break label5240;
          }
          ac.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.iMV.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          label5240:
          ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = localc.IF();
          this.screen.cK("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1139;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void dqd()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.n.b.ln(this.contact.field_type)) && (!w.wT(this.contact.field_username)) && (!w.xz(this.contact.field_username)))
    {
      this.screen.cK("contact_is_mute", false);
      this.screen.cK("contact_info_verifyuser_weibo", true);
      this.screen.cK("contact_info_subscribe_bizinfo", true);
      this.screen.cK("contact_info_template_recv", true);
      this.screen.cK("contact_info_locate", true);
      if (this.vKl) {
        break label315;
      }
      this.screen.cK("contact_info_time_expired", true);
      label143:
      if ((this.contact == null) || ((!w.xo(this.contact.field_username)) && (!w.xz(this.contact.field_username))) || (!com.tencent.mm.n.b.ln(this.contact.field_type))) {
        break label332;
      }
      this.screen.cK("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (w.xz(this.contact.field_username)) {
        this.screen.cK("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.cK("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.n.b.ln(this.contact.field_type)) && (Lq(this.iMg)))
      {
        this.screen.cK("contact_info_expose_btn", false);
        break;
      }
      this.screen.cK("contact_info_expose_btn", true);
      break;
      label315:
      this.screen.cK("contact_info_biz_add", true);
      break label143;
      label332:
      this.screen.cK("contact_info_biz_go_chatting", true);
    }
  }
  
  private boolean dqf()
  {
    AppMethodBeat.i(27102);
    if (this.iMV.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.iMV.getIntent().getStringExtra("device_id");
    String str2 = this.iMV.getIntent().getStringExtra("device_type");
    do localdo = new do();
    localdo.ddc.cIZ = str1;
    localdo.ddc.dda = str2;
    com.tencent.mm.sdk.b.a.GpY.l(localdo);
    boolean bool = localdo.ddd.dde;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void dqh()
  {
    AppMethodBeat.i(27111);
    ac.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.iMV.getSharedPreferences(this.iMV.getPackageName() + "_preferences", 0);
    }
    if (this.ftD != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.aaN()).commit();
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
  
  private void oR(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.iMV != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.al.f.so(this.contact.field_username))) {
          break label77;
        }
        this.iMV.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aPN("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.mF = paramBoolean;
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.iMV.setTitleMuteIconVisibility(8);
    }
  }
  
  public final boolean WZ(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.iMV).iq(this.contact.exZ, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.vKt != null)
      {
        paramString = new ql();
        this.vKt.hTz = 5;
        paramString.dtt.dtu = this.vKt;
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
      }
      if ((this.vIG != null) && ((this.vIG.IN()) || (this.vIG.IP())))
      {
        paramString = new Intent();
        if (this.vIG.IP())
        {
          localObject1 = this.vIG.IV();
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", v.wk((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.br.d.e(this.iMV, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.iMV.finish();
        }
      }
      for (;;)
      {
        bw(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", v.wk(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.iMV.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.vIS)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.iMV.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.iyx.d(paramString, this.iMV);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aAe()) {
        dqe();
      }
      for (;;)
      {
        if (this.vKo != 0) {
          com.tencent.mm.plugin.report.service.h.wUl.f(11263, new Object[] { Integer.valueOf(this.vKo), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.iMV, com.tencent.mm.model.gdpr.a.hqA, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void og(int paramAnonymousInt)
          {
            AppMethodBeat.i(27075);
            if (paramAnonymousInt == 0) {
              c.this.dqe();
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
      if (((CheckBoxPreference)this.screen.aPN("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.iMg) });
        com.tencent.mm.model.j.vL(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        w.E(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.iMg) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.cFm.Jg() != null) && (!bs.isNullOrNil(this.cFm.Jg().cGq)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.cFm.Jg().cGq);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.br.d.b(this.iMV, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = bs.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.cFl.size()))
      {
        paramString = (c.a)this.cFl.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.vKs != null) && ((this.iMg == 39) || (this.iMg == 56) || (this.iMg == 35))) || (this.iMg == 87) || (this.iMg == 89) || (this.iMg == 85) || (this.iMg == 88))
        {
          ac.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.vKs);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
            break label1169;
          }
        }
        label1169:
        for (i = 7;; i = 6)
        {
          int j = this.iMV.getResources().getIdentifier(paramString.cFp, "string", this.iMV.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.iMV.getString(j);
          }
          bw(i, paramString);
          com.tencent.mm.br.d.b(this.iMV, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(27090);
          return true;
        }
      }
    }
    label1388:
    label1393:
    boolean bool;
    if (("contact_info_subscribe_bizinfo".endsWith(paramString)) || ("contact_info_show_brand".endsWith(paramString)) || ("contact_info_locate".endsWith(paramString)))
    {
      localObject1 = this.vIG;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).IM()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).IP()) {
              break label1393;
            }
            az.agi().a(1363, this);
            if (!((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1388;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            az.agi().a(paramString, 0);
            localObject2 = this.iMV;
            this.iMV.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.iMV.getString(2131755936), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).IP()) && (!((com.tencent.mm.api.c)localObject1).IN())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).IN())
        {
          paramString = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
          af.aDf();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.al.d.a((String)localObject2, bool, this);
            localObject2 = this.iMV;
            this.iMV.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.iMV.getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                af.aDf();
                com.tencent.mm.al.d.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).IF())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.cFm == null) && (localObject1 != null)) {
              this.cFm = ((com.tencent.mm.api.c)localObject1).bV(false);
            }
            if ((this.cFm != null) && (this.cFm.IZ()) && (com.tencent.mm.br.d.aCT("brandservice")))
            {
              this.screen.cK("contact_info_template_recv", false);
              label1584:
              paramString = com.tencent.mm.plugin.report.service.h.wUl;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).IF()) {
                break label1709;
              }
            }
          }
          label1709:
          for (i = 3;; i = 4)
          {
            paramString.f(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.iMg) });
            break;
            this.screen.cK("contact_info_template_recv", true);
            break label1584;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.cK("contact_info_template_recv", true);
            break label1584;
          }
          if ("contact_info_show_brand".endsWith(paramString))
          {
            if ((((com.tencent.mm.api.c)localObject1).field_brandFlag & 0x2) == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1760;
              }
              ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x2;
              break;
            }
            label1760:
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFD;
          }
          else if ("contact_info_locate".endsWith(paramString))
          {
            if (((com.tencent.mm.api.c)localObject1).IG()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.vKr = com.tencent.mm.ui.base.h.a(this.iMV, this.iMV.getString(2131757139, new Object[] { this.contact.aaS() }), this.iMV.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.cLq.field_hadAlert = 1;
                  this.cLq.field_brandFlag |= 0x4;
                  c.this.a(this.cLq, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.cLq.field_hadAlert = 1;
                  c.this.a(this.cLq, false);
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
      paramString = this.vIG;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.bV(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((c.b)localObject2).Ji() != null) && (!bs.isNullOrNil(((c.b)localObject2).Ji().cGl))) {
        paramString = ((c.b)localObject2).Ji().cGl;
      }
      for (;;)
      {
        if (!bs.isNullOrNil(paramString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramString);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          ((Intent)localObject1).putExtra("geta8key_scene", 3);
          com.tencent.mm.br.d.b(this.iMV, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).Jk() != null)
        {
          paramString = (String)localObject1;
          if (!bs.isNullOrNil(((c.b)localObject2).Jk().cGt)) {
            paramString = ((c.b)localObject2).Jk().cGt;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.vIG;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.bV(false) != null) && (!bs.isNullOrNil(paramString.bV(false).Jb())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.bV(false).Jb());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.br.d.b(this.iMV, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.ftN)
      {
        bool = true;
        this.ftN = bool;
        if (!this.ftN) {
          break label2687;
        }
        w.s(this.contact);
        label2246:
        oR(this.ftN);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.iMV != null) {
          break label2697;
        }
        ac.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2279:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.iMV.getString(2131758435);
        localObject2 = this.iMV.getString(2131758434);
        com.tencent.mm.ui.base.h.d(this.iMV, (String)localObject1, "", (String)localObject2, this.iMV.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            c.this.oQ(false);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        oQ(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.vIG.field_username);
        com.tencent.mm.br.d.b(this.iMV, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.aPN("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bs.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.iMV, true, (String)localObject1, "", this.iMV.getString(2131757643), this.iMV.getString(2131755691), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        dqg();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        ac.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.iMV.getSharedPreferences(this.iMV.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.aaN()) {
            break label2767;
          }
          ac.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          w.E(this.contact.field_username, true);
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
      label2687:
      w.t(this.contact);
      break label2246;
      label2697:
      if (this.vIG == null)
      {
        ac.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2279;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.vIG.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.d.b(this.iMV, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2279;
      label2767:
      com.tencent.mm.model.j.vL(this.contact.field_username);
      ac.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(27110);
    if ((this.vIG == null) || (!this.vIG.IP()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramn.getType() == 1354)
    {
      paramn = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
      String str = af.aDa().dQ(this.vIG.field_username);
      this.vKi = af.aDa().dP(str);
      if (this.vKi != null)
      {
        if (!this.vKi.hc(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramn.mF = bool;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(27110);
          return;
        }
      }
      ac.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(27110);
  }
  
  final void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
    but localbut = new but();
    localbut.iKh = paramc.field_brandFlag;
    localbut.ncR = this.contact.field_username;
    if (Lq(this.iMg))
    {
      az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(58, localbut));
    }
    for (;;)
    {
      af.aCW().update(paramc, new String[0]);
      localCheckBoxPreference1.mF = paramc.IF();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.mF = paramc.IG();
      }
      if (paramBoolean) {
        dqc();
      }
      AppMethodBeat.o(27092);
      return;
      az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(47, localbut));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
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
      this.contact = paramai;
      this.vIS = paramBoolean;
      this.iMg = paramInt;
      this.vKo = this.iMV.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.vKt = ((SnsAdClick)this.iMV.getIntent().getParcelableExtra("KSnsAdTag"));
      this.vKs = this.iMV.getIntent().getBundleExtra("Contact_Ext_Args");
      this.vKu = this.iMV.getIntent().getStringExtra("key_add_contact_report_info");
      dqc();
      paramf = this.iMV.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bs.isNullOrNil(paramf))
      {
        this.iMV.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.iMV, paramf, "", this.iMV.getString(2131755835), null);
      }
      if (paramai != null)
      {
        af.aDi().Ay(paramai.field_username);
        if (com.tencent.mm.al.f.AP(paramai.field_username))
        {
          paramf = paramai.field_username;
          if (!com.tencent.mm.al.f.so(paramf)) {
            break label301;
          }
          af.aDe();
          com.tencent.mm.al.a.h.a(paramf, this);
          paramf = com.tencent.mm.al.f.dX(paramf).IV();
          if (paramf != null) {
            af.aDi().Ay(paramf);
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
      if (com.tencent.mm.al.f.AR(paramf))
      {
        af.aDf();
        com.tencent.mm.al.d.a(paramf, this);
        af.aCW();
        paramf = com.tencent.mm.al.e.AI(paramf);
        if (paramf != null) {
          af.aDi().Ay(paramf);
        }
      }
    }
  }
  
  public final String aCI()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.aPN("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  final void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.vKs == null) || ((this.iMg != 39) && (this.iMg != 56) && (this.iMg != 35) && (this.iMg != 87) && (this.iMg != 88) && (this.iMg != 89) && (this.iMg != 85)))
    {
      ac.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27100);
      return;
    }
    if (this.contact == null)
    {
      ac.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      AppMethodBeat.o(27100);
      return;
    }
    String str2 = this.vKs.getString("Contact_Ext_Args_Search_Id");
    String str3 = bs.nullAsNil(this.vKs.getString("Contact_Ext_Args_Query_String"));
    int j = this.vKs.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.iMg)
    {
    default: 
      i = 0;
      str1 = bs.nullAsNil(this.vKs.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bs.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bs.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ac.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10866, paramString);
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
  
  final void dqe()
  {
    AppMethodBeat.i(27101);
    if ((this.iMV.getIntent() != null) && (this.iMV.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.iMV.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bs.isNullOrNil((String)localObject1)) {
        break label163;
      }
      ac.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (dqf())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.iMV, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(27077);
          ai localai;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cg(c.this.iMV, c.this.iMV.getString(2131757590));
            c.this.screen.cK("contact_info_time_expired", true);
            localai = c.this.contact;
            if ((localai == null) || (bs.isNullOrNil(paramAnonymousString1)))
            {
              ac.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localai);
              c.this.vKn = true;
              if (c.this.vKt != null)
              {
                paramAnonymousString1 = new ql();
                c.this.vKt.hTz = 4;
                paramAnonymousString1.dtt.dtu = c.this.vKt;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString1);
              }
              paramAnonymousString1 = af.aCW().AE(c.this.contact.field_username);
              paramAnonymousString1.field_status = 1;
              if ((!bs.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bs.isNullOrNil(paramAnonymousString1.field_username)) || (c.this.vIG == null) || (!paramAnonymousString1.field_username.equals(bs.nullAsNil(c.this.vIG.field_username)))) {
                break label675;
              }
              af.aCW().g(c.this.vIG);
              label249:
              paramAnonymousBoolean1 = c.this.iMV.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
              paramAnonymousBoolean2 = c.this.iMV.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
              if (!paramAnonymousString1.IN()) {
                break label686;
              }
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("enterprise_biz_name", c.this.contact.field_username);
              paramAnonymousString1.putExtra("enterprise_biz_display_name", v.wk(c.this.contact.field_username));
              paramAnonymousString1.putExtra("enterprise_from_scene", 7);
              paramAnonymousString1.addFlags(67108864);
              com.tencent.mm.br.d.e(c.this.iMV, ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
              label364:
              c.this.iMV.finish();
              label374:
              c.this.bw(3, null);
            }
          }
          else
          {
            AppMethodBeat.o(27077);
            return;
          }
          if (w.wF(localai.field_username))
          {
            String str = bs.nullAsNil(localai.field_username);
            paramAnonymousString2 = com.tencent.mm.al.f.dX(str);
            if (paramAnonymousString2 != null) {
              paramAnonymousString2.field_username = paramAnonymousString1;
            }
            af.aCW().delete(str);
            localai.qp(str);
          }
          for (;;)
          {
            localai.setUsername(paramAnonymousString1);
            if ((int)localai.fLJ == 0)
            {
              az.ayM();
              com.tencent.mm.model.c.awB().ah(localai);
            }
            if ((int)localai.fLJ <= 0)
            {
              ac.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
              break;
            }
            w.u(localai);
            az.ayM();
            paramAnonymousString1 = com.tencent.mm.model.c.awB().aNt(localai.field_username);
            if (paramAnonymousString2 != null)
            {
              af.aCW().f(paramAnonymousString2);
              break;
            }
            paramAnonymousString2 = com.tencent.mm.al.f.dX(paramAnonymousString1.field_username);
            if ((paramAnonymousString1.fad()) && (com.tencent.mm.al.a.aCo())) {}
            for (int i = 1;; i = 0)
            {
              if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.IH()) || (i != 0))) {
                break label616;
              }
              ac.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
              ar.a.hnw.aJ(paramAnonymousString1.field_username, "");
              com.tencent.mm.aj.c.zU(paramAnonymousString1.field_username);
              break;
            }
            label616:
            if ((!paramAnonymousString1.fah()) || (i != 0)) {
              break;
            }
            ac.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.eyc) });
            ar.a.hnw.aJ(paramAnonymousString1.field_username, "");
            com.tencent.mm.aj.c.zU(paramAnonymousString1.field_username);
            break;
            label675:
            af.aCW().g(paramAnonymousString1);
            break label249;
            label686:
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("Chat_User", c.this.contact.field_username);
            paramAnonymousString1.putExtra("key_has_add_contact", true);
            paramAnonymousString1.putExtra("finish_direct", true);
            if (paramAnonymousBoolean2) {
              paramAnonymousString1.addFlags(268435456);
            }
            com.tencent.mm.plugin.profile.b.iyx.d(paramAnonymousString1, c.this.iMV);
            if (paramAnonymousBoolean1) {
              break label364;
            }
            if (!paramAnonymousBoolean2) {
              break label374;
            }
            break label364;
            paramAnonymousString2 = null;
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.iMg));
      if (this.cFv != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpL = this.cFv;
      }
      if (!bs.isNullOrNil(this.sBi)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sBi = this.sBi;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpR = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.vKu);
      AppMethodBeat.o(27101);
      return;
    }
    ac.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    az.agi().a(536, this);
    Object localObject2 = new dk();
    ((dk)localObject2).dcR.dcT = ((String)localObject1);
    ((dk)localObject2).dcR.opType = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dk)localObject2).dcS.dcV;
    localObject2 = this.iMV;
    this.iMV.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.iMV.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(27076);
        az.agi().b(536, c.this);
        paramAnonymousDialogInterface = new dk();
        paramAnonymousDialogInterface.dcR.opType = 2;
        paramAnonymousDialogInterface.dcR.dcV = this.cXh;
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(27076);
      }
    });
    AppMethodBeat.o(27101);
  }
  
  final void dqg()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (bs.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this.iMV, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  public final void e(LinkedList<dzk> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    af.aCX().b(this);
    if (this.screen == null)
    {
      ac.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (this.contact == null)
    {
      ac.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27109);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (!bs.isNullOrNil(this.vKp))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dzk localdzk = (dzk)((Iterator)localObject).next();
        if ((localdzk.GfE != null) && (localdzk.GfE.equals(this.vKp)))
        {
          this.screen.cK("contact_info_kf_worker", false);
          this.screen.aPN("contact_info_kf_worker").setSummary(localdzk.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.cK("contact_info_kf_worker", false);
    Object localObject = this.screen.aPN("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((dzk)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  final void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.vIG.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      az.agi().a(1394, this);
      az.agi().a((n)localObject, 0);
      MMActivity localMMActivity = this.iMV;
      this.iMV.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.iMV.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          az.agi().a(this.nxk);
          az.agi().b(1394, c.this);
          AppMethodBeat.o(27084);
        }
      });
      AppMethodBeat.o(27091);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.iMV == null)
    {
      ac.e("MicroMsg.ContactWidgetBizInfo", "null == context");
      AppMethodBeat.o(27098);
      return;
    }
    ac.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.j.dck().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.j.dck().hF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.iMV, this.iMV.getString(2131759420));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    ac.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.vKq = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ac.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    az.agi().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    ac.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      az.agi().b(536, this);
      dqc();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (cwo)paramString.rr.hvs.hvw;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramn;
        paramn = (n)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramn = (n)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hvr.hvw != null) {
            paramn = (cwn)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hvr.hvw;
          }
        }
        if ((paramString != null) && (paramString.Eby != null) && (paramString.Eby.ret == 0) && (paramString.Ebv != null) && (!bs.isNullOrNil(paramString.Ebv.Ebt))) {
          break label413;
        }
        if ((paramString == null) || (paramString.Eby == null)) {
          break;
        }
        ac.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.Eby.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      ac.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.Ebv == null)
      {
        ac.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = af.aDa().dP(paramString.Ebv.Ebt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.al.a.k();
        ((com.tencent.mm.al.a.k)localObject1).field_userId = paramString.Ebv.Ebt;
      }
      ((com.tencent.mm.al.a.k)localObject1).field_userName = paramString.Ebv.nYC;
      ((com.tencent.mm.al.a.k)localObject1).field_brandUserName = paramn.Ebs;
      ((com.tencent.mm.al.a.k)localObject1).field_UserVersion = paramString.Ebv.ver;
      ((com.tencent.mm.al.a.k)localObject1).field_headImageUrl = paramString.Ebv.Ebm;
      ((com.tencent.mm.al.a.k)localObject1).field_profileUrl = paramString.Ebv.EbB;
      ((com.tencent.mm.al.a.k)localObject1).field_bitFlag = paramString.Ebv.Ebn;
      ((com.tencent.mm.al.a.k)localObject1).field_addMemberUrl = paramString.Ebv.Ebq;
      ((com.tencent.mm.al.a.k)localObject1).field_needToUpdate = false;
      if (!af.aDa().b((com.tencent.mm.al.a.k)localObject1)) {
        af.aDa().a((com.tencent.mm.al.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dpO();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramn).dpN();
      if ((localObject1 == null) || (((dfq)localObject1).Eby == null) || (((dfq)localObject1).Eby.ret != 0))
      {
        if ((localObject1 != null) && (((dfq)localObject1).Eby != null))
        {
          ac.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dfq)localObject1).Eby.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        ac.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.ltx)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.vIG;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        az.ayM();
        if (com.tencent.mm.model.c.awG().aNI(paramString.field_username) == null)
        {
          paramn = new com.tencent.mm.storage.ap(paramString.field_username);
          paramn.qT(bs.nullAsNil(this.vIG.IV()));
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alk(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          az.ayM();
          com.tencent.mm.model.c.awG().e(paramn);
          az.ayM();
          com.tencent.mm.model.c.awG().aJ((bo)localObject1);
        }
      }
      for (;;)
      {
        az.ayM();
        if (com.tencent.mm.model.c.awG().aNI(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new com.tencent.mm.storage.ap(paramString.field_enterpriseFather);
        paramString.faH();
        az.ayM();
        com.tencent.mm.model.c.awG().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramn.faH();
        az.ayM();
        com.tencent.mm.model.c.awG().e(paramn);
      }
      label954:
      az.ayM();
      com.tencent.mm.model.c.awF().aMJ(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.vIG;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      az.ayM();
      com.tencent.mm.model.c.awG().aNG(paramString.field_username);
      az.ayM();
      if (com.tencent.mm.model.c.awG().aNU(paramString.field_enterpriseFather) <= 0)
      {
        az.ayM();
        com.tencent.mm.model.c.awG().aNG(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      az.ayM();
      com.tencent.mm.model.c.awF().aMJ(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1343)
    {
      dqc();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1228) {
      dqc();
    }
    AppMethodBeat.o(27108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */