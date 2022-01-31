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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.d.a;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.d;
import com.tencent.mm.aj.d.b.e;
import com.tencent.mm.aj.d.b.f;
import com.tencent.mm.aj.d.b.g;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.h.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.dd.b;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
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
  implements com.tencent.mm.ai.f, h.a, com.tencent.mm.aj.n, com.tencent.mm.pluginsdk.b.a
{
  MMActivity cmc;
  ad contact;
  private CheckBoxPreference eeX;
  private boolean efg;
  private List<d.a> fuX;
  private d.b fuY;
  private boolean fvf = false;
  private String fvh;
  private int gyR;
  boolean isDeleteCancel = false;
  String mVw;
  com.tencent.mm.aj.d pyd;
  private boolean pyp;
  private String pyu;
  private com.tencent.mm.aj.a.j pzG;
  private List<WxaAttributes.WxaEntryInfo> pzH;
  private wc pzI = null;
  private boolean pzJ = false;
  private boolean pzK = false;
  boolean pzL = false;
  private int pzM = 0;
  private String pzN;
  private boolean pzO;
  com.tencent.mm.ui.widget.b.c pzP = null;
  private Bundle pzQ;
  SnsAdClick pzR = null;
  private String pzS = null;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  com.tencent.mm.ui.base.p tipDialog = null;
  
  private c(MMActivity paramMMActivity)
  {
    this.cmc = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, wc paramwc)
  {
    this(paramMMActivity);
    this.pyu = paramString;
    this.pzI = paramwc;
  }
  
  private String BD(int paramInt)
  {
    AppMethodBeat.i(23480);
    switch (paramInt)
    {
    default: 
      ab.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.cmc.getResources().getString(2131298633);
      AppMethodBeat.o(23480);
      return str;
    case 0: 
      str = this.cmc.getResources().getString(2131298827);
      AppMethodBeat.o(23480);
      return str;
    case 1: 
      str = this.cmc.getResources().getString(2131297819);
      AppMethodBeat.o(23480);
      return str;
    }
    String str = this.cmc.getResources().getString(2131297820);
    AppMethodBeat.o(23480);
    return str;
  }
  
  private static boolean BE(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static boolean Xc(String paramString)
  {
    AppMethodBeat.i(23484);
    try
    {
      long l = bo.getLong(paramString, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L))
      {
        AppMethodBeat.o(23484);
        return true;
      }
      AppMethodBeat.o(23484);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(23484);
    }
    return false;
  }
  
  private void Xd(String paramString)
  {
    AppMethodBeat.i(23490);
    ab.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.pzO) });
    if (this.pzO)
    {
      AppMethodBeat.o(23490);
      return;
    }
    this.pzN = paramString;
    if ((this.fuY == null) || (!this.fuY.aeH()) || (this.contact == null))
    {
      this.screen.cl("contact_info_kf_worker", true);
      AppMethodBeat.o(23490);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      paramString = z.afh().sc(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.cl("contact_info_kf_worker", true);
        z.afj().a(this);
        z.afj().aB(this.contact.field_username, r.Zn());
        this.pzO = true;
        AppMethodBeat.o(23490);
        return;
      }
      ab.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.cl("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.atx("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ah.b.b(paramString.field_openId, false, -1);
      if (localObject2 == null)
      {
        c(paramString);
        Xe(paramString.field_openId);
        AppMethodBeat.o(23490);
        return;
      }
      ((IconWidgetPreference)localObject1).M((Bitmap)localObject2);
      AppMethodBeat.o(23490);
      return;
    }
    Object localObject2 = z.afh();
    Object localObject1 = ((com.tencent.mm.aj.i)localObject2).sb(paramString);
    if ((localObject1 == null) || (com.tencent.mm.aj.i.a((com.tencent.mm.aj.g)localObject1)))
    {
      z.afj().a(this);
      z.afj().aC(this.contact.field_username, paramString);
      this.pzO = true;
    }
    if (localObject1 == null) {
      ab.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.aj.i)localObject2).sc(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.cl("contact_info_kf_worker", true);
        AppMethodBeat.o(23490);
        return;
      }
      this.screen.cl("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.atx("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ah.b.b(paramString.field_openId, false, -1);
      if (localObject2 == null)
      {
        c(paramString);
        Xe(paramString.field_openId);
      }
      for (;;)
      {
        ab.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(23490);
        return;
        ((IconWidgetPreference)localObject1).M((Bitmap)localObject2);
      }
    }
  }
  
  private void Xe(final String paramString)
  {
    AppMethodBeat.i(23491);
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23466);
        if (c.this.screen == null)
        {
          ab.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
          AppMethodBeat.o(23466);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)c.this.screen.atx("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (c.this.screen != null))
        {
          Bitmap localBitmap = com.tencent.mm.ah.b.b(paramString, false, -1);
          if (localBitmap != null)
          {
            ab.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.M(localBitmap);
            c.this.screen.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(23466);
      }
    }, 2000L);
    AppMethodBeat.o(23491);
  }
  
  private static void c(com.tencent.mm.aj.g paramg)
  {
    AppMethodBeat.i(23492);
    long l = System.currentTimeMillis();
    com.tencent.mm.ah.i locali = o.adg();
    if (locali.rj(paramg.field_openId) == null)
    {
      com.tencent.mm.ah.h localh = new com.tencent.mm.ah.h();
      localh.username = paramg.field_openId;
      localh.fsk = paramg.field_headImgUrl;
      localh.cM(false);
      localh.dqB = 3;
      locali.b(localh);
    }
    o.adi().qV(paramg.field_openId);
    ab.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(23492);
  }
  
  private void ccd()
  {
    AppMethodBeat.i(23479);
    bkb();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165202);
    if (this.pzL) {
      this.screen.cl("contact_info_time_expired", true);
    }
    com.tencent.mm.aj.d locald = com.tencent.mm.aj.f.rS(this.contact.field_username);
    this.fuX = null;
    this.fuY = null;
    this.pzH = null;
    if (((locald == null) || (locald.cU(false) == null)) && (this.pzI != null))
    {
      locald = new com.tencent.mm.aj.d();
      locald.field_username = this.contact.field_username;
      locald.field_brandFlag = this.pzI.gxd;
      locald.field_brandIconURL = this.pzI.gxg;
      locald.field_brandInfo = this.pzI.gxf;
      locald.field_extInfo = this.pzI.gxe;
    }
    label465:
    label1001:
    label2414:
    label3826:
    label4211:
    for (;;)
    {
      if ((locald != null) && (locald.field_brandInfo == null) && (locald.field_extInfo == null) && (this.pzI != null))
      {
        locald.field_username = this.contact.field_username;
        locald.field_brandFlag = this.pzI.gxd;
        locald.field_brandIconURL = this.pzI.gxg;
        locald.field_brandInfo = this.pzI.gxf;
        locald.field_extInfo = this.pzI.gxe;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.atx("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!bo.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.pyu, locald);
        this.screen.cl("biz_placed_to_the_top", true);
        this.screen.cl("contact_info_biz_enable", true);
        this.screen.cl("contact_info_biz_disable", true);
        this.screen.cl("contact_info_stick_biz", true);
        if (locald == null) {
          break label2237;
        }
        if (!locald.aeh()) {
          break label1849;
        }
        this.screen.cl("contact_info_biz_add", true);
        this.screen.cl("contact_info_expose_btn", true);
        this.screen.cl("contact_is_mute", false);
        this.efg = this.contact.DP();
        if (!locald.aei()) {
          break label1576;
        }
        this.screen.cl("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label1570;
        }
        bool = true;
        ((com.tencent.mm.ui.base.preference.f)localObject1).cl("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.atx("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).vxW = this.contact.Oa();
        ((CheckBoxPreference)localObject1).setTitle(2131299305);
        cci();
        kc(this.efg);
        this.pyd = locald;
        this.fuX = locald.aep();
        this.fuY = locald.cU(false);
        this.pzH = this.fuY.getWxaEntryInfoList();
        if (!this.fuY.aeq()) {
          break label2173;
        }
        this.screen.atx("near_field_service").setSummary(2131305950);
        if (this.fuY.aew() == null) {
          break label2205;
        }
        this.pzK = true;
        if (!Xc(this.fuY.aew())) {
          break label2189;
        }
        this.pzJ = true;
        if (com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label2189;
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
        cce();
        if ((t.oB(this.contact.field_username)) || (t.oL(this.contact.field_username))) {
          cce();
        }
        if ((this.fuY.aet() != null) && (this.fuY.aet().length() > 0)) {
          this.fvh = this.fuY.aet();
        }
        this.fvf = this.fuY.aer();
        if (bo.isNullOrNil(this.fuY.aeG())) {
          break label2221;
        }
        this.screen.cl("contact_info_service_phone", false);
        localObject1 = this.screen.atx("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.fuY.aeG());
          ((Preference)localObject1).kCA = this.cmc.getResources().getColor(2131690214);
        }
      }
      Object localObject2;
      Object localObject4;
      Object localObject6;
      label1277:
      int i;
      for (;;)
      {
        Object localObject7;
        if (!bo.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.atx("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bo.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.cl("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.fuY == null) || (this.fuY.aeB() == null) || (bo.isNullOrNil(this.fuY.aeB().fvS))) {
              break label2549;
            }
            localObject4 = this.fuY.aeB();
            localObject6 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2533;
            }
            ((KeyValuePreference)localObject6).zrr = false;
            if (!bo.isNullOrNil(((d.b.d)localObject4).fvT)) {
              break label2464;
            }
            ((KeyValuePreference)localObject6).zaD = BD(((d.b.d)localObject4).fvR);
            if (ao.a.flK == null) {
              break label2477;
            }
            localObject1 = BackwardSupportUtil.b.k(ao.a.flK.kx(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5232;
            }
            localObject2 = new BitmapDrawable(this.cmc.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2483;
            }
            bool = true;
            ab.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).zrz = ((Drawable)localObject2);
            if (((d.b.d)localObject4).fvS == null) {
              break label2522;
            }
            localObject7 = ((d.b.d)localObject4).fvV;
            localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(this.cmc, ((d.b.d)localObject4).fvS.trim());
            if (bo.isNullOrNil((String)localObject7)) {
              break label5225;
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
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.fuY == null) || (bo.isNullOrNil(this.fuY.aev()))) {
            break label2658;
          }
          localObject2 = (KeyValuePreference)this.screen.atx("contact_info_trademark");
          if (localObject2 == null) {
            break label1328;
          }
          ((KeyValuePreference)localObject2).zrr = false;
          if (ao.a.flK == null) {
            break label2646;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.d.Na(2131230985);
          if (localObject1 != null) {
            break label2652;
          }
          bool = true;
          ab.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5219;
          }
          localObject1 = new BitmapDrawable(this.cmc.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            j = k;
          }
          localObject1 = null;
          break label1277;
        }
        ((KeyValuePreference)localObject2).zrz = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.fuY.aev());
        ab.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.fuY.aev(), this.fuY.aeu() });
        if ((this.fuY == null) || (this.fuY.aex() == null) || (this.fuY.aex().size() <= 0)) {
          break label2682;
        }
        localObject2 = (KeyValuePreference)this.screen.atx("contact_info_privilege");
        ((KeyValuePreference)localObject2).qJ(false);
        ((KeyValuePreference)localObject2).dEN();
        localObject4 = this.fuY.aex().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (d.b.f)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.cmc, 2130969952, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131822243)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.cmc.getResources(), ((d.b.f)localObject7).iconUrl));
          localObject1 = ((d.b.f)localObject7).description;
          i = this.cmc.getResources().getIdentifier(((d.b.f)localObject7).fwa, "string", this.cmc.getPackageName());
          if (i > 0) {
            localObject1 = this.cmc.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131821890)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).eO((View)localObject6);
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.cl("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label465;
        this.screen.cl("contact_info_subscribe_bizinfo", true);
        this.screen.cl("contact_info_biz_go_chatting", true);
        if (locald.adY())
        {
          this.screen.cl("contact_info_biz_enable", true);
          this.screen.cl("contact_info_biz_disable", false);
          this.screen.atx("contact_info_biz_disable").setTitle(2131299307);
          this.screen.cl("contact_is_mute", false);
          this.screen.cl("biz_placed_to_the_top", false);
          this.eeX = ((CheckBoxPreference)this.screen.atx("biz_placed_to_the_top"));
          this.eeX.setTitle(2131299323);
          cci();
          if (!locald.aej()) {
            break label518;
          }
          this.screen.cl("contact_info_locate", true);
          break label518;
        }
        this.screen.cl("contact_info_biz_enable", false);
        this.screen.cl("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.atx("contact_info_biz_enable")).eM(this.cmc.getResources().getString(2131299309), this.cmc.getResources().getColor(2131689778));
        this.screen.cl("contact_is_mute", true);
        this.screen.cl("biz_placed_to_the_top", true);
        this.screen.cl("contact_info_locate", true);
        break label518;
        if (locald.aeg())
        {
          this.screen.cl("contact_info_locate", true);
          this.screen.cl("contact_info_subscribe_bizinfo", false);
          this.screen.cl("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.atx("contact_info_biz_go_chatting")).eM(this.cmc.getResources().getString(2131299310), this.cmc.getResources().getColor(2131689778));
          localObject1 = this.screen;
          if (!com.tencent.mm.n.a.je(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).cl("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.atx("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).vxW = this.contact.Oa();
            ((CheckBoxPreference)localObject1).setTitle(2131299313);
            cci();
            this.screen.cl("contact_is_mute", true);
            this.efg = this.contact.DP();
            kc(this.efg);
            this.screen.atx("contact_is_mute").setSummary(2131298588);
            break;
          }
        }
        localObject1 = this.screen;
        if ((t.og(this.contact.field_username)) || (!com.tencent.mm.n.a.je(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).cl("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.atx("contact_info_stick_biz")).vxW = this.contact.Oa();
          this.screen.cl("contact_is_mute", true);
          this.efg = false;
          break;
        }
        label2173:
        this.screen.cl("near_field_service", true);
        break label590;
        this.screen.cl("contact_info_time_expired", true);
        break label662;
        this.screen.cl("contact_info_time_expired", true);
        break label692;
        this.screen.cl("contact_info_service_phone", true);
        continue;
        this.screen.cl("contact_info_time_expired", true);
        ab.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).zrr = false;
        ((KeyValuePreference)localObject2).zaD = this.cmc.getString(2131298633);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this.cmc, this.contact.signature));
        ((KeyValuePreference)localObject2).qJ(false);
        if (ao.a.flK != null)
        {
          localObject1 = BackwardSupportUtil.b.k(ao.a.flK.kx(this.contact.field_verifyFlag), 2.0F);
          if (localObject1 != null) {
            break label2414;
          }
          bool = true;
          ab.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5238;
          }
        }
      }
      label2549:
      label4341:
      label5238:
      for (localObject1 = new BitmapDrawable(this.cmc.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).zrz = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).zrx = 8;
        ((KeyValuePreference)localObject2).OW(8);
        break;
        localObject1 = null;
        break label2333;
        bool = false;
        break label2341;
        ab.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.cl("contact_info_user_desc", true);
        if (this.pzJ) {
          break;
        }
        this.screen.cl("contact_info_time_expired", true);
        break;
        ((KeyValuePreference)localObject6).zaD = ((d.b.d)localObject4).fvT;
        break label974;
        localObject1 = null;
        break label1001;
        bool = false;
        break label1032;
        ab.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1157;
        ab.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1164;
        this.screen.cl("contact_info_verifyuser", true);
        break label1164;
        if ((this.fuY != null) && (this.fuY.aeC() != null) && (!bo.isNullOrNil(this.fuY.aeC().fwb)))
        {
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1164;
          }
          ((KeyValuePreference)localObject1).setSummary(this.fuY.aeC().fwb);
          break label1164;
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.cl("contact_info_verifyuser", true);
        break label1164;
        localObject1 = null;
        break label1226;
        bool = false;
        break label1234;
        ab.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.cl("contact_info_trademark", true);
        break label1328;
        label2682:
        this.screen.cl("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.fuX != null) && (this.fuX.size() > 0)) {
          i = this.fuX.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.fuX.get(i) != null) && ((!this.cmc.getString(2131298560).equals(((d.a)this.fuX.get(i)).title)) || (this.fvf)) && ((!bo.isNullOrNil(((d.a)this.fuX.get(i)).title)) || (!bo.isNullOrNil(((d.a)this.fuX.get(i)).fvb))))
          {
            localObject5 = new Preference(this.cmc);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((d.a)this.fuX.get(i)).title;
            j = this.cmc.getResources().getIdentifier(((d.a)this.fuX.get(i)).fvb, "string", this.cmc.getPackageName());
            if (j > 0) {
              localObject1 = this.cmc.getString(j);
            }
            localObject2 = localObject1;
            if (this.pyd.aef()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((d.a)this.fuX.get(i)).fvb))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.cmc.getString(2131296336))) {}
              }
              else
              {
                localObject2 = this.cmc.getString(2131299301);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bo.isNullOrNil(((d.a)this.fuX.get(i)).description)) {
              ((Preference)localObject5).setSummary(((d.a)this.fuX.get(i)).description);
            }
            if (!bo.nullAsNil(((d.a)this.fuX.get(i)).fvb).equals("__mp_wording__brandinfo_feedback")) {
              break label5214;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5214;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (bo.nullAsNil(((d.a)this.fuX.get(i)).fvb).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.cmc);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          ab.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.pzJ) && (t.w(this.contact)) && (this.contact.dqO != null) && (!this.contact.dqO.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bo.bf(this.contact.field_weiboNickname, "") + this.cmc.getString(2131303424, new Object[] { t.oK(this.contact.dqO) }));
            ((Preference)localObject1).kCA = com.tencent.mm.cb.a.m(this.cmc, 2131690214);
            ((KeyValuePreference)localObject1).qJ(false);
          }
          if ((this.fuY == null) || (this.fuY.aez() == null)) {
            break label4153;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.atx("contact_info_reputation");
          if (this.fuY.aez().fvW <= 0) {
            break label4105;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Bt(this.fuY.aez().fvW);
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.atx("contact_info_guarantee_info");
          if ((this.fuY.aez().fvY == null) || (this.fuY.aez().fvY.size() <= 0)) {
            break label4121;
          }
          ((BizInfoPayInfoIconPreference)localObject1).cA(this.fuY.aez().fvY);
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_scope_of_business");
          if (bo.isNullOrNil(this.fuY.aez().fvX)) {
            break label4137;
          }
          ((KeyValuePreference)localObject1).setSummary(this.fuY.aez().fvX);
          ((KeyValuePreference)localObject1).zrx = 4;
          ((KeyValuePreference)localObject1).qJ(false);
          if ((this.pzH == null) || (this.pzH.size() <= 0)) {
            break label4195;
          }
          this.screen.cl("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.atx("contact_info_bindwxainfo")).a(this.pyd, this.pzH);
          label3582:
          Xd(this.cmc.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          ab.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.cmc.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.cmc.getIntent() == null) || (!this.cmc.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4509;
          }
          ab.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = ccg();
          ab.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.je(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.n.a.je(this.contact.field_type)) || (!bool)) {
            break label4341;
          }
          if (locald == null) {
            break label4299;
          }
          localObject1 = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.atx("contact_info_locate");
          if (!locald.aei()) {
            break label4228;
          }
          localObject5 = z.afm().dg(locald.field_username);
          this.pzG = z.afm().df((String)localObject5);
          if (this.pzG == null) {
            break label4217;
          }
          if (this.pzG.kY(4)) {
            break label4211;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).vxW = bool;
          if (!locald.adY()) {
            break label4257;
          }
          if ((this.fuY == null) && (locald != null)) {
            this.fuY = locald.cU(false);
          }
          if ((this.fuY == null) || (!this.fuY.aes()) || (!com.tencent.mm.bq.d.ahR("brandservice"))) {
            break label4241;
          }
          this.screen.cl("contact_info_template_recv", false);
          if (!locald.cU(false).aec()) {
            break label4273;
          }
          ((CheckBoxPreference)localObject2).vxW = locald.adZ();
        }
        for (;;)
        {
          this.screen.cl("contact_info_biz_read_msg_online", true);
          this.screen.cl("contact_info_biz_add", true);
          localObject1 = this.contact.Of();
          if (localObject1 != null) {
            this.cmc.setMMTitle((String)localObject1);
          }
          if (t.og(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.atx("contact_info_biz_go_chatting")).eM(this.cmc.getResources().getString(2131298743), this.cmc.getResources().getColor(2131689778));
            this.cmc.setMMTitle(2131298818);
          }
          if ((!t.oB(this.contact.field_username)) && (this.pyd != null) && (!this.pyd.aeh())) {
            this.cmc.addIconOptionMenu(0, 2130839668, new c.17(this));
          }
          AppMethodBeat.o(23479);
          return;
          this.screen.cl("contact_info_verifyuser_weibo", true);
          break;
          this.screen.cl("contact_info_reputation", true);
          break label3401;
          this.screen.cl("contact_info_guarantee_info", true);
          break label3464;
          this.screen.cl("contact_info_scope_of_business", true);
          break label3524;
          this.screen.cl("contact_info_reputation", true);
          this.screen.cl("contact_info_guarantee_info", true);
          this.screen.cl("contact_info_scope_of_business", true);
          break label3524;
          this.screen.cl("contact_info_bindwxainfo", true);
          break label3582;
          bool = false;
          break label3819;
          label4217:
          ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label3826;
          ((CheckBoxPreference)localObject1).vxW = locald.adY();
          break label3826;
          this.screen.cl("contact_info_template_recv", true);
          break label3895;
          this.screen.cl("contact_info_template_recv", true);
          break label3895;
          this.screen.cl("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).vxW = locald.adZ();
          continue;
          this.screen.cl("contact_info_subscribe_bizinfo", true);
          this.screen.cl("contact_info_locate", true);
          this.screen.cl("contact_info_template_recv", true);
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        cce();
        localObject1 = this.screen.atx("contact_info_biz_add");
        ab.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.pzK) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131298544);
          }
        }
        else if (BE(this.gyR))
        {
          if (locald != null) {
            break label4470;
          }
          ab.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.cmc.showOptionMenu(false);
          AppMethodBeat.o(23479);
          return;
          ((Preference)localObject1).setTitle(2131298537);
          break;
          label4470:
          ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = locald.adY();
          this.screen.cl("contact_info_subscribe_bizinfo", false);
        }
        if (com.tencent.mm.n.a.je(this.contact.field_type))
        {
          if (locald != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.atx("contact_info_locate");
            if (locald.aei())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131299306);
              localObject5 = z.afm().dg(locald.field_username);
              this.pzG = z.afm().df((String)localObject5);
              if (this.pzG != null) {
                if (!this.pzG.kY(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).vxW = bool;
                  if (!locald.adY()) {
                    break label4988;
                  }
                  if ((this.fuY == null) && (locald != null)) {
                    this.fuY = locald.cU(false);
                  }
                  if ((this.fuY == null) || (!this.fuY.aes()) || (!com.tencent.mm.bq.d.ahR("brandservice"))) {
                    break label4972;
                  }
                  this.screen.cl("contact_info_template_recv", false);
                  if (!locald.cU(false).aec()) {
                    break label5004;
                  }
                  ((CheckBoxPreference)localObject2).vxW = locald.adZ();
                }
              }
            }
          }
          for (;;)
          {
            this.screen.cl("contact_info_biz_read_msg_online", true);
            this.screen.cl("contact_info_biz_add", true);
            localObject1 = this.contact.Of();
            if (localObject1 != null) {
              this.cmc.setMMTitle((String)localObject1);
            }
            if (t.og(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.atx("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).zqu = true;
              ((ButtonPreference)localObject1).eM(this.cmc.getResources().getString(2131298743), this.cmc.getResources().getColor(2131689778));
              this.cmc.setMMTitle(2131298818);
            }
            if ((!t.oB(this.contact.field_username)) && (this.pyd != null)) {
              this.cmc.addIconOptionMenu(0, 2130839668, new c.18(this));
            }
            AppMethodBeat.o(23479);
            return;
            bool = false;
            break;
            ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label4630;
            if (locald.aeg())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131299302);
              if (!z.afr().rB(locald.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).vxW = bool;
                break;
              }
            }
            ((CheckBoxPreference)localObject1).vxW = locald.adY();
            break label4630;
            this.screen.cl("contact_info_template_recv", true);
            break label4699;
            label4988:
            this.screen.cl("contact_info_template_recv", true);
            break label4699;
            this.screen.cl("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).vxW = locald.adZ();
            continue;
            this.screen.cl("contact_info_subscribe_bizinfo", true);
            this.screen.cl("contact_info_locate", true);
            this.screen.cl("contact_info_template_recv", true);
          }
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        cce();
        localObject1 = this.screen.atx("contact_info_biz_add");
        if ((localObject1 != null) && (this.pzK)) {
          ((Preference)localObject1).setTitle(2131298544);
        }
        if (BE(this.gyR))
        {
          if (locald != null) {
            break label5170;
          }
          ab.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.cmc.showOptionMenu(false);
          AppMethodBeat.o(23479);
          return;
          ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = locald.adY();
          this.screen.cl("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1157;
        Object localObject3 = null;
        break label1024;
      }
    }
  }
  
  private void cce()
  {
    AppMethodBeat.i(23481);
    if ((this.contact != null) && (com.tencent.mm.n.a.je(this.contact.field_type)) && (!t.og(this.contact.field_username)) && (!t.oL(this.contact.field_username)))
    {
      this.screen.cl("contact_is_mute", false);
      this.screen.cl("contact_info_verifyuser_weibo", true);
      this.screen.cl("contact_info_subscribe_bizinfo", true);
      this.screen.cl("contact_info_template_recv", true);
      this.screen.cl("contact_info_locate", true);
      if (this.pzJ) {
        break label304;
      }
      this.screen.cl("contact_info_time_expired", true);
      label137:
      if ((this.contact == null) || ((!t.oB(this.contact.field_username)) && (!t.oL(this.contact.field_username))) || (!com.tencent.mm.n.a.je(this.contact.field_type))) {
        break label320;
      }
      this.screen.cl("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (t.oL(this.contact.field_username)) {
        this.screen.cl("contact_info_user_desc", true);
      }
      AppMethodBeat.o(23481);
      return;
      this.screen.cl("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.n.a.je(this.contact.field_type)) && (BE(this.gyR)))
      {
        this.screen.cl("contact_info_expose_btn", false);
        break;
      }
      this.screen.cl("contact_info_expose_btn", true);
      break;
      label304:
      this.screen.cl("contact_info_biz_add", true);
      break label137;
      label320:
      this.screen.cl("contact_info_biz_go_chatting", true);
    }
  }
  
  private boolean ccg()
  {
    AppMethodBeat.i(23487);
    if (this.cmc.getIntent() == null)
    {
      AppMethodBeat.o(23487);
      return false;
    }
    String str1 = this.cmc.getIntent().getStringExtra("device_id");
    String str2 = this.cmc.getIntent().getStringExtra("device_type");
    dh localdh = new dh();
    localdh.cqL.bYu = str1;
    localdh.cqL.cqJ = str2;
    com.tencent.mm.sdk.b.a.ymk.l(localdh);
    boolean bool = localdh.cqM.cqN;
    AppMethodBeat.o(23487);
    return bool;
  }
  
  private void cci()
  {
    AppMethodBeat.i(23496);
    ab.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.cmc.getSharedPreferences(this.cmc.getPackageName() + "_preferences", 0);
    }
    if (this.eeX != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.Oa()).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(23496);
      return;
      label119:
      this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
    }
  }
  
  private void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(23489);
    if (this.contact != null) {
      if (this.cmc != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.aj.f.lg(this.contact.field_username))) {
          break label77;
        }
        this.cmc.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.vxW = paramBoolean;
      }
      AppMethodBeat.o(23489);
      return;
      label77:
      this.cmc.setTitleMuteIconVisibility(8);
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23475);
    if (paramString == null)
    {
      AppMethodBeat.o(23475);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.cmc).fN(this.contact.dqO, this.contact.field_username);
      AppMethodBeat.o(23475);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.pzR != null)
      {
        paramString = new om();
        this.pzR.fQt = 5;
        paramString.cFa.cFb = this.pzR;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
      if ((this.pyd != null) && ((this.pyd.aeg()) || (this.pyd.aei())))
      {
        paramString = new Intent();
        if (this.pyd.aei())
        {
          localObject1 = this.pyd.aeo();
          if (bo.isNullOrNil((String)localObject1))
          {
            ab.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(23475);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", s.nE((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.bq.d.f(this.cmc, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.cmc.finish();
        }
      }
      for (;;)
      {
        aV(5, null);
        AppMethodBeat.o(23475);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", s.nE(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.cmc.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.pyp)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.cmc.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.gmO.d(paramString, this.cmc);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.abL()) {
        ccf();
      }
      for (;;)
      {
        if (this.pzM != 0) {
          com.tencent.mm.plugin.report.service.h.qsU.e(11263, new Object[] { Integer.valueOf(this.pzM), this.contact.field_username });
        }
        AppMethodBeat.o(23475);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.cmc, com.tencent.mm.model.gdpr.a.foz, this.contact.field_username, new c.4(this));
      }
    }
    if ("contact_info_biz_read_msg_online".endsWith(paramString))
    {
      AppMethodBeat.o(23475);
      return true;
    }
    if ("contact_info_stick_biz".equals(paramString))
    {
      if (((CheckBoxPreference)this.screen.atx("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0) });
        com.tencent.mm.model.i.nh(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(23475);
        return true;
        t.y(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.fuY.aez() != null) && (!bo.isNullOrNil(this.fuY.aez().fvZ)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.fuY.aez().fvZ);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.bq.d.b(this.cmc, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = bo.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.fuX.size()))
      {
        paramString = (d.a)this.fuX.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.pzQ != null) && ((this.gyR == 39) || (this.gyR == 56) || (this.gyR == 35))) || (this.gyR == 87) || (this.gyR == 89) || (this.gyR == 85) || (this.gyR == 88))
        {
          ab.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.pzQ);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
            break label1135;
          }
        }
        label1135:
        for (i = 7;; i = 6)
        {
          int j = this.cmc.getResources().getIdentifier(paramString.fvb, "string", this.cmc.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.cmc.getString(j);
          }
          aV(i, paramString);
          com.tencent.mm.bq.d.b(this.cmc, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(23475);
          return true;
        }
      }
    }
    label1354:
    label1359:
    boolean bool;
    if (("contact_info_subscribe_bizinfo".endsWith(paramString)) || ("contact_info_show_brand".endsWith(paramString)) || ("contact_info_locate".endsWith(paramString)))
    {
      localObject1 = this.pyd;
      if (localObject1 == null)
      {
        AppMethodBeat.o(23475);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.aj.d)localObject1).aef()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.aj.d)localObject1).aei()) {
              break label1359;
            }
            aw.Rc().a(1363, this);
            if (!((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1354;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.aj.d)localObject1).field_username, i);
            aw.Rc().a(paramString, 0);
            localObject2 = this.cmc;
            this.cmc.getString(2131297087);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.cmc.getString(2131297112), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.aj.d)localObject1).aei()) && (!((com.tencent.mm.aj.d)localObject1).aeg())) {
          a((com.tencent.mm.aj.d)localObject1, false);
        }
        AppMethodBeat.o(23475);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.aj.d)localObject1).aeg())
        {
          paramString = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
          z.afr();
          localObject2 = ((com.tencent.mm.aj.d)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.aj.c.a((String)localObject2, bool, this);
            localObject2 = this.cmc;
            this.cmc.getString(2131297087);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.cmc.getString(2131297112), true, new c.16(this, paramString));
            break;
          }
          if (((com.tencent.mm.aj.d)localObject1).adY())
          {
            ((com.tencent.mm.aj.d)localObject1).field_brandFlag |= 0x1;
            if ((this.fuY == null) && (localObject1 != null)) {
              this.fuY = ((com.tencent.mm.aj.d)localObject1).cU(false);
            }
            if ((this.fuY != null) && (this.fuY.aes()) && (com.tencent.mm.bq.d.ahR("brandservice")))
            {
              this.screen.cl("contact_info_template_recv", false);
              label1549:
              paramString = com.tencent.mm.plugin.report.service.h.qsU;
              localObject2 = ((com.tencent.mm.aj.d)localObject1).field_username;
              if (!((com.tencent.mm.aj.d)localObject1).adY()) {
                break label1655;
              }
            }
          }
          label1655:
          for (i = 3;; i = 4)
          {
            paramString.e(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
            break;
            this.screen.cl("contact_info_template_recv", true);
            break label1549;
            ((com.tencent.mm.aj.d)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.cl("contact_info_template_recv", true);
            break label1549;
          }
          if ("contact_info_show_brand".endsWith(paramString))
          {
            if ((((com.tencent.mm.aj.d)localObject1).field_brandFlag & 0x2) == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1706;
              }
              ((com.tencent.mm.aj.d)localObject1).field_brandFlag |= 0x2;
              break;
            }
            label1706:
            ((com.tencent.mm.aj.d)localObject1).field_brandFlag &= 0xFFFFFFFD;
          }
          else if ("contact_info_locate".endsWith(paramString))
          {
            if (((com.tencent.mm.aj.d)localObject1).adZ()) {
              ((com.tencent.mm.aj.d)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.pzP = com.tencent.mm.ui.base.h.a(this.cmc, this.cmc.getString(2131298150, new Object[] { this.contact.Of() }), this.cmc.getString(2131297087), new c.1(this, (com.tencent.mm.aj.d)localObject1), new c.12(this, (com.tencent.mm.aj.d)localObject1));
            }
          }
        }
      }
    }
    if ("contact_info_verifyuser".endsWith(paramString))
    {
      paramString = this.pyd;
      if (paramString == null)
      {
        AppMethodBeat.o(23475);
        return true;
      }
      localObject2 = paramString.cU(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(23475);
        return true;
      }
      localObject1 = null;
      if ((((d.b)localObject2).aeB() != null) && (!bo.isNullOrNil(((d.b)localObject2).aeB().fvU))) {
        paramString = ((d.b)localObject2).aeB().fvU;
      }
      for (;;)
      {
        if (!bo.isNullOrNil(paramString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramString);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          ((Intent)localObject1).putExtra("geta8key_scene", 3);
          com.tencent.mm.bq.d.b(this.cmc, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(23475);
        return true;
        paramString = (String)localObject1;
        if (((d.b)localObject2).aeC() != null)
        {
          paramString = (String)localObject1;
          if (!bo.isNullOrNil(((d.b)localObject2).aeC().fwc)) {
            paramString = ((d.b)localObject2).aeC().fwc;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.pyd;
      if (paramString == null)
      {
        AppMethodBeat.o(23475);
        return true;
      }
      if ((paramString.cU(false) != null) && (!bo.isNullOrNil(paramString.cU(false).aeu())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.cU(false).aeu());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.bq.d.b(this.cmc, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(23475);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.efg)
      {
        bool = true;
        this.efg = bool;
        if (!this.efg) {
          break label2633;
        }
        t.o(this.contact);
        label2192:
        kc(this.efg);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.cmc != null) {
          break label2643;
        }
        ab.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2225:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.cmc.getString(2131299308);
        localObject2 = this.cmc.getString(2131299307);
        com.tencent.mm.ui.base.h.d(this.cmc, (String)localObject1, "", (String)localObject2, this.cmc.getString(2131296888), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(23468);
            c.this.kb(false);
            AppMethodBeat.o(23468);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        kb(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.pyd.field_username);
        com.tencent.mm.bq.d.b(this.cmc, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.atx("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bo.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.cmc, true, (String)localObject1, "", this.cmc.getString(2131298584), this.cmc.getString(2131296888), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        cch();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        ab.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.cmc.getSharedPreferences(this.cmc.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.Oa()) {
            break label2713;
          }
          ab.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          t.y(this.contact.field_username, true);
          this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23475);
      return true;
      bool = false;
      break;
      label2633:
      t.p(this.contact);
      break label2192;
      label2643:
      if (this.pyd == null)
      {
        ab.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2225;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.pyd.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bq.d.b(this.cmc, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2225;
      label2713:
      com.tencent.mm.model.i.nh(this.contact.field_username);
      ab.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(23495);
    if ((this.pyd == null) || (!this.pyd.aei()))
    {
      AppMethodBeat.o(23495);
      return;
    }
    if (paramm.getType() == 1354)
    {
      paramm = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
      String str = z.afm().dg(this.pyd.field_username);
      this.pzG = z.afm().df(str);
      if (this.pzG != null)
      {
        if (!this.pzG.kY(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramm.vxW = bool;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(23495);
          return;
        }
      }
      ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(23495);
  }
  
  final void a(com.tencent.mm.aj.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23477);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.atx("contact_info_locate");
    bdm localbdm = new bdm();
    localbdm.gxd = paramd.field_brandFlag;
    localbdm.jJA = this.contact.field_username;
    if (BE(this.gyR))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new j.a(58, localbdm));
    }
    for (;;)
    {
      z.afi().update(paramd, new String[0]);
      localCheckBoxPreference1.vxW = paramd.adY();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.vxW = paramd.adZ();
      }
      if (paramBoolean) {
        ccd();
      }
      AppMethodBeat.o(23477);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new j.a(47, localbdm));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23478);
    boolean bool;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
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
      this.contact = paramad;
      this.pyp = paramBoolean;
      this.gyR = paramInt;
      this.pzM = this.cmc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.pzR = ((SnsAdClick)this.cmc.getIntent().getParcelableExtra("KSnsAdTag"));
      this.pzQ = this.cmc.getIntent().getBundleExtra("Contact_Ext_Args");
      this.pzS = this.cmc.getIntent().getStringExtra("key_add_contact_report_info");
      ccd();
      paramf = this.cmc.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bo.isNullOrNil(paramf))
      {
        this.cmc.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.cmc, paramf, "", this.cmc.getString(2131297018), null);
      }
      if (paramad != null)
      {
        z.afu().rw(paramad.field_username);
        if (com.tencent.mm.aj.f.rV(paramad.field_username))
        {
          paramf = paramad.field_username;
          if (!com.tencent.mm.aj.f.lg(paramf)) {
            break label301;
          }
          z.afq();
          com.tencent.mm.aj.a.h.a(paramf, this);
          paramf = com.tencent.mm.aj.f.rS(paramf).aeo();
          if (paramf != null) {
            z.afu().rw(paramf);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23478);
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
      if (com.tencent.mm.aj.f.rX(paramf))
      {
        z.afr();
        com.tencent.mm.aj.c.a(paramf, this);
        z.afi();
        paramf = e.rO(paramf);
        if (paramf != null) {
          z.afu().rw(paramf);
        }
      }
    }
  }
  
  final void aV(int paramInt, String paramString)
  {
    AppMethodBeat.i(23485);
    if ((this.pzQ == null) || ((this.gyR != 39) && (this.gyR != 56) && (this.gyR != 35) && (this.gyR != 87) && (this.gyR != 88) && (this.gyR != 89) && (this.gyR != 85)))
    {
      ab.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(23485);
      return;
    }
    if (this.contact == null)
    {
      ab.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      AppMethodBeat.o(23485);
      return;
    }
    String str2 = this.pzQ.getString("Contact_Ext_Args_Search_Id");
    String str3 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Args_Query_String"));
    int j = this.pzQ.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.gyR)
    {
    default: 
      i = 0;
      str1 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bo.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bo.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ab.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10866, paramString);
      AppMethodBeat.o(23485);
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
  
  public final String aeZ()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23482);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.atx("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(23482);
    return true;
  }
  
  final void ccf()
  {
    AppMethodBeat.i(23486);
    if ((this.cmc.getIntent() != null) && (this.cmc.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.cmc.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bo.isNullOrNil((String)localObject1)) {
        break label163;
      }
      ab.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (ccg())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.cmc, new c.6(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.gyR));
      if (this.fvh != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSP = this.fvh;
      }
      if (!bo.isNullOrNil(this.mVw)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).mVw = this.mVw;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSV = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.pzS);
      AppMethodBeat.o(23486);
      return;
    }
    ab.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    aw.Rc().a(536, this);
    Object localObject2 = new dd();
    ((dd)localObject2).cqA.cqC = ((String)localObject1);
    ((dd)localObject2).cqA.opType = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dd)localObject2).cqB.cqE;
    localObject2 = this.cmc;
    this.cmc.getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.cmc.getString(2131297112), true, new c.5(this, (m)localObject1));
    AppMethodBeat.o(23486);
  }
  
  final void cch()
  {
    AppMethodBeat.i(23488);
    if ((this.contact == null) || (bo.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(23488);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.bq.d.b(this.cmc, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(23488);
  }
  
  public final void e(LinkedList<czd> paramLinkedList)
  {
    AppMethodBeat.i(23494);
    z.afj().b(this);
    if (this.screen == null)
    {
      ab.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(23494);
      return;
    }
    if (this.contact == null)
    {
      ab.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(23494);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(23494);
      return;
    }
    if (!bo.isNullOrNil(this.pzN))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        czd localczd = (czd)((Iterator)localObject).next();
        if ((localczd.ygd != null) && (localczd.ygd.equals(this.pzN)))
        {
          this.screen.cl("contact_info_kf_worker", false);
          this.screen.atx("contact_info_kf_worker").setSummary(localczd.Nickname);
          AppMethodBeat.o(23494);
          return;
        }
      }
    }
    this.screen.cl("contact_info_kf_worker", false);
    Object localObject = this.screen.atx("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((czd)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(23494);
  }
  
  final void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(23476);
    Object localObject = this.pyd.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      aw.Rc().a(1394, this);
      aw.Rc().a((m)localObject, 0);
      MMActivity localMMActivity = this.cmc;
      this.cmc.getString(2131297087);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.cmc.getString(2131297112), true, new c.14(this, (com.tencent.mm.plugin.profile.b.d)localObject));
      AppMethodBeat.o(23476);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23483);
    if (this.cmc == null)
    {
      ab.e("MicroMsg.ContactWidgetBizInfo", "null == context");
      AppMethodBeat.o(23483);
      return;
    }
    ab.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(23483);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.bPJ().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.bPJ().fh(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.l(this.cmc, this.cmc.getString(2131299979));
      AppMethodBeat.o(23483);
      return;
    }
    AppMethodBeat.o(23483);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject1 = null;
    AppMethodBeat.i(23493);
    ab.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.pzO = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramm == null)
    {
      ab.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(23493);
      return;
    }
    aw.Rc().b(paramm.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      AppMethodBeat.o(23493);
      return;
    }
    ab.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 536)
    {
      aw.Rc().b(536, this);
      ccd();
      AppMethodBeat.o(23493);
      return;
    }
    if (paramm.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (cap)paramString.rr.fsW.fta;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramm;
        paramm = (m)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramm = (m)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.fsV.fta != null) {
            paramm = (cao)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.fsV.fta;
          }
        }
        if ((paramString != null) && (paramString.wyn != null) && (paramString.wyn.ret == 0) && (paramString.wyk != null) && (!bo.isNullOrNil(paramString.wyk.wyi))) {
          break label413;
        }
        if ((paramString == null) || (paramString.wyn == null)) {
          break;
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.wyn.ret) });
        AppMethodBeat.o(23493);
        return;
      }
      ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(23493);
      return;
      label413:
      if (paramString.wyk == null)
      {
        ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(23493);
        return;
      }
      Object localObject2 = z.afm().df(paramString.wyk.wyi);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.aj.a.j();
        ((com.tencent.mm.aj.a.j)localObject1).field_userId = paramString.wyk.wyi;
      }
      ((com.tencent.mm.aj.a.j)localObject1).field_userName = paramString.wyk.kqi;
      ((com.tencent.mm.aj.a.j)localObject1).field_brandUserName = paramm.wyh;
      ((com.tencent.mm.aj.a.j)localObject1).field_UserVersion = paramString.wyk.ver;
      ((com.tencent.mm.aj.a.j)localObject1).field_headImageUrl = paramString.wyk.wyc;
      ((com.tencent.mm.aj.a.j)localObject1).field_profileUrl = paramString.wyk.wyq;
      ((com.tencent.mm.aj.a.j)localObject1).field_bitFlag = paramString.wyk.wyd;
      ((com.tencent.mm.aj.a.j)localObject1).field_addMemberUrl = paramString.wyk.wyg;
      ((com.tencent.mm.aj.a.j)localObject1).field_needToUpdate = false;
      if (!z.afm().b((com.tencent.mm.aj.a.j)localObject1)) {
        z.afm().a((com.tencent.mm.aj.a.j)localObject1);
      }
      AppMethodBeat.o(23493);
      return;
    }
    if (paramm.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramm).cbP();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramm).cbO();
      if ((localObject1 == null) || (((cit)localObject1).wyn == null) || (((cit)localObject1).wyn.ret != 0))
      {
        if ((localObject1 != null) && (((cit)localObject1).wyn != null))
        {
          ab.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((cit)localObject1).wyn.ret) });
          AppMethodBeat.o(23493);
          return;
        }
        ab.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
        AppMethodBeat.o(23493);
        return;
      }
      if (!paramString.xTc)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.pyd;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        aw.aaz();
        if (com.tencent.mm.model.c.YF().arH(paramString.field_username) == null)
        {
          paramm = new ak(paramString.field_username);
          paramm.jY(bo.nullAsNil(this.pyd.aeo()));
          aw.aaz();
          localObject1 = com.tencent.mm.model.c.YC().Tm(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          aw.aaz();
          com.tencent.mm.model.c.YF().d(paramm);
          aw.aaz();
          com.tencent.mm.model.c.YF().ar((bi)localObject1);
        }
      }
      for (;;)
      {
        aw.aaz();
        if (com.tencent.mm.model.c.YF().arH(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new ak(paramString.field_enterpriseFather);
        paramString.dxc();
        aw.aaz();
        com.tencent.mm.model.c.YF().d(paramString);
        AppMethodBeat.o(23493);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramm.dxc();
        aw.aaz();
        com.tencent.mm.model.c.YF().d(paramm);
      }
      label954:
      aw.aaz();
      com.tencent.mm.model.c.YE().aqR(paramString.field_enterpriseFather);
      AppMethodBeat.o(23493);
      return;
      label975:
      paramString = this.pyd;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      aw.aaz();
      com.tencent.mm.model.c.YF().arF(paramString.field_username);
      aw.aaz();
      if (com.tencent.mm.model.c.YF().arS(paramString.field_enterpriseFather) <= 0)
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arF(paramString.field_enterpriseFather);
        AppMethodBeat.o(23493);
        return;
      }
      aw.aaz();
      com.tencent.mm.model.c.YE().aqR(paramString.field_enterpriseFather);
      AppMethodBeat.o(23493);
      return;
    }
    if (paramm.getType() == 1343)
    {
      ccd();
      AppMethodBeat.o(23493);
      return;
    }
    if (paramm.getType() == 1228) {
      ccd();
    }
    AppMethodBeat.o(23493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */