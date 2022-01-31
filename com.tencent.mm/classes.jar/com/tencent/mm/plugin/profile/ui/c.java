package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.d;
import com.tencent.mm.ai.d.b.e;
import com.tencent.mm.ai.d.b.f;
import com.tencent.mm.ai.d.b.g;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.da;
import com.tencent.mm.h.a.da.b;
import com.tencent.mm.h.a.de;
import com.tencent.mm.h.a.de.b;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.bqh;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.protocal.c.cln;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.ah.f, h.a, n, com.tencent.mm.pluginsdk.b.a
{
  MMActivity bER;
  private SharedPreferences dnD = null;
  private boolean dnJ;
  com.tencent.mm.ui.base.preference.f dnn;
  ad dnp;
  private CheckBoxPreference dny;
  private List<com.tencent.mm.ai.d.a> eeV;
  private d.b eeW;
  private boolean efd = false;
  private String eff;
  private int fhj;
  boolean isDeleteCancel = false;
  String kzG;
  private boolean mVI;
  private String mVN;
  com.tencent.mm.ai.d mVy;
  private com.tencent.mm.ai.a.j mWL;
  private List<WxaAttributes.WxaEntryInfo> mWM;
  private sg mWN = null;
  private boolean mWO = false;
  private boolean mWP = false;
  boolean mWQ = false;
  private int mWR = 0;
  private String mWS;
  private boolean mWT;
  com.tencent.mm.ui.widget.a.c mWU = null;
  private Bundle mWV;
  SnsAdClick mWW = null;
  private String mWX = null;
  com.tencent.mm.ui.base.p tipDialog = null;
  
  private c(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, sg paramsg)
  {
    this(paramMMActivity);
    this.mVN = paramString;
    this.mWN = paramsg;
  }
  
  private static boolean KT(String paramString)
  {
    boolean bool2 = false;
    try
    {
      long l1 = bk.getLong(paramString, 0L);
      boolean bool1 = bool2;
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis() / 1000L;
        bool1 = bool2;
        if (l1 - l2 < 0L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void KU(String paramString)
  {
    ai.l(new c.11(this, paramString), 2000L);
  }
  
  private boolean bsA()
  {
    if (this.bER.getIntent() == null) {
      return false;
    }
    String str1 = this.bER.getIntent().getStringExtra("device_id");
    String str2 = this.bER.getIntent().getStringExtra("device_type");
    de localde = new de();
    localde.bJr.bwK = str1;
    localde.bJr.bJp = str2;
    com.tencent.mm.sdk.b.a.udP.m(localde);
    return localde.bJs.bJt;
  }
  
  private void bsC()
  {
    y.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.dnD == null) {
      this.dnD = this.bER.getSharedPreferences(this.bER.getPackageName() + "_preferences", 0);
    }
    if (this.dny != null)
    {
      if (this.dnp == null) {
        break label104;
      }
      this.dnD.edit().putBoolean("biz_placed_to_the_top", this.dnp.Bl()).commit();
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      label104:
      this.dnD.edit().putBoolean("biz_placed_to_the_top", false).commit();
    }
  }
  
  private void bsx()
  {
    awZ();
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.contact_info_pref_bizinfo);
    if (this.mWQ) {
      this.dnn.bJ("contact_info_time_expired", true);
    }
    com.tencent.mm.ai.d locald = com.tencent.mm.ai.f.kX(this.dnp.field_username);
    this.eeV = null;
    this.eeW = null;
    this.mWM = null;
    if (((locald == null) || (locald.bS(false) == null)) && (this.mWN != null))
    {
      locald = new com.tencent.mm.ai.d();
      locald.field_username = this.dnp.field_username;
      locald.field_brandFlag = this.mWN.ffv;
      locald.field_brandIconURL = this.mWN.ffy;
      locald.field_brandInfo = this.mWN.ffx;
      locald.field_extInfo = this.mWN.ffw;
    }
    label529:
    label582:
    label726:
    label1370:
    label3803:
    for (;;)
    {
      if ((locald != null) && (locald.field_brandInfo == null) && (locald.field_extInfo == null) && (this.mWN != null))
      {
        locald.field_username = this.dnp.field_username;
        locald.field_brandFlag = this.mWN.ffv;
        locald.field_brandIconURL = this.mWN.ffy;
        locald.field_brandInfo = this.mWN.ffx;
        locald.field_extInfo = this.mWN.ffw;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.dnn.add("contact_info_header_bizinfo");
      Object localObject2;
      boolean bool;
      if ((localObject1 != null) && (!bk.bl(this.dnp.field_username)))
      {
        localObject2 = this.dnp;
        ((BizInfoHeaderPreference)localObject1).mVx = this.mVN;
        ((BizInfoHeaderPreference)localObject1).mVy = locald;
        ((BizInfoHeaderPreference)localObject1).onDetach();
        au.Hx();
        com.tencent.mm.model.c.Fw().a((m.b)localObject1);
        o.JQ().d((com.tencent.mm.ag.d.a)localObject1);
        ((BizInfoHeaderPreference)localObject1).dnp = ((ad)localObject2);
        if (bk.pm(((ao)localObject2).field_username).length() > 0)
        {
          bool = true;
          Assert.assertTrue("initView: contact username is null", bool);
          ((BizInfoHeaderPreference)localObject1).initView();
          label372:
          this.dnn.bJ("biz_placed_to_the_top", true);
          this.dnn.bJ("contact_info_biz_enable", true);
          this.dnn.bJ("contact_info_biz_disable", true);
          this.dnn.bJ("contact_info_stick_biz", true);
          if (locald == null) {
            break label2329;
          }
          if (!locald.Lz()) {
            break label1967;
          }
          this.dnn.bJ("contact_info_biz_add", true);
          this.dnn.bJ("contact_info_expose_btn", true);
          this.dnn.bJ("contact_is_mute", false);
          this.dnJ = this.dnp.Bj();
          if (!locald.LA()) {
            break label1723;
          }
          this.dnn.bJ("contact_info_biz_go_chatting", true);
          localObject1 = this.dnn;
          if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
            break label1717;
          }
          bool = true;
          ((com.tencent.mm.ui.base.preference.f)localObject1).bJ("contact_info_stick_biz", bool);
          localObject1 = (CheckBoxPreference)this.dnn.add("contact_info_stick_biz");
          ((CheckBoxPreference)localObject1).rHo = this.dnp.Bl();
          ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_chat_placetop);
          bsC();
          id(this.dnJ);
          this.mVy = locald;
          this.eeV = locald.LH();
          this.eeW = locald.bS(false);
          this.mWM = this.eeW.getWxaEntryInfoList();
          if (!this.eeW.LI()) {
            break label2265;
          }
          this.dnn.add("near_field_service").setSummary(R.l.weixin_connect_wifi);
          if (this.eeW.LO() == null) {
            break label2297;
          }
          this.mWP = true;
          if (!KT(this.eeW.LO())) {
            break label2281;
          }
          this.mWO = true;
          if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
            break label2281;
          }
          y.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.dnp.field_username });
          bsy();
          if ((s.hS(this.dnp.field_username)) || (s.ic(this.dnp.field_username))) {
            bsy();
          }
          label756:
          if ((this.eeW.LL() != null) && (this.eeW.LL().length() > 0)) {
            this.eff = this.eeW.LL();
          }
          this.efd = this.eeW.LJ();
          if (bk.bl(this.eeW.LZ())) {
            break label2313;
          }
          this.dnn.bJ("contact_info_service_phone", false);
          localObject1 = this.dnn.add("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.eeW.LZ());
            ((Preference)localObject1).izu = this.bER.getResources().getColor(R.e.link_color);
          }
        }
      }
      Object localObject4;
      Object localObject6;
      int i;
      for (;;)
      {
        label1132:
        Object localObject7;
        if (!bk.bl(this.dnp.signature))
        {
          localObject2 = (KeyValuePreference)this.dnn.add("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bk.pm(this.dnp.signature).trim().length() <= 0) {
              this.dnn.bJ("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.eeW == null) || (this.eeW.LT() == null) || (bk.bl(this.eeW.LT().efQ))) {
              break label2694;
            }
            localObject4 = this.eeW.LT();
            localObject6 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2678;
            }
            ((KeyValuePreference)localObject6).cBw();
            ((KeyValuePreference)localObject6).vcS = false;
            if (!bk.bl(((d.b.d)localObject4).efR)) {
              break label2609;
            }
            i = ((d.b.d)localObject4).efP;
            switch (i)
            {
            default: 
              y.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
              localObject1 = this.bER.getResources().getString(R.l.contact_info_isnot_verify_user_title);
              ((KeyValuePreference)localObject6).uME = ((String)localObject1);
              if (am.a.dVA != null)
              {
                localObject1 = BackwardSupportUtil.b.e(am.a.dVA.hL(this.dnp.field_verifyFlag), 2.0F);
                if (localObject1 == null) {
                  break label5848;
                }
                localObject2 = new BitmapDrawable(this.bER.getResources(), (Bitmap)localObject1);
                if (localObject1 != null) {
                  break label2628;
                }
                bool = true;
                y.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
                ((KeyValuePreference)localObject6).vda = ((Drawable)localObject2);
                if (((d.b.d)localObject4).efQ == null) {
                  break label2667;
                }
                localObject7 = ((d.b.d)localObject4).efT;
                localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(this.bER, ((d.b.d)localObject4).efQ.trim());
                if (bk.bl((String)localObject7)) {
                  break label5841;
                }
              }
              break;
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
          if ((this.eeW == null) || (bk.bl(this.eeW.LN()))) {
            break label2803;
          }
          localObject2 = (KeyValuePreference)this.dnn.add("contact_info_trademark");
          if (localObject2 == null) {
            break label1464;
          }
          ((KeyValuePreference)localObject2).cBw();
          ((KeyValuePreference)localObject2).vcS = false;
          if (am.a.dVA == null) {
            break label2791;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.c.EX(R.k.biz_info_trademark_protection);
          if (localObject1 != null) {
            break label2797;
          }
          bool = true;
          y.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5835;
          }
          localObject1 = new BitmapDrawable(this.bER.getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            continue;
            continue;
            j = k;
          }
          localObject1 = null;
          break label1413;
        }
        ((KeyValuePreference)localObject2).vda = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.eeW.LN());
        y.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.eeW.LN(), this.eeW.LM() });
        if ((this.eeW == null) || (this.eeW.LP() == null) || (this.eeW.LP().size() <= 0)) {
          break label2827;
        }
        localObject2 = (KeyValuePreference)this.dnn.add("contact_info_privilege");
        ((KeyValuePreference)localObject2).cBw();
        ((KeyValuePreference)localObject2).nf(false);
        ((KeyValuePreference)localObject2).cBv();
        localObject4 = this.eeW.LP().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (d.b.f)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.bER, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.a(this.bER.getResources(), ((d.b.f)localObject7).iconUrl));
          localObject1 = ((d.b.f)localObject7).description;
          i = this.bER.getResources().getIdentifier(((d.b.f)localObject7).efY, "string", this.bER.getPackageName());
          if (i > 0) {
            localObject1 = this.bER.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).dF((View)localObject6);
        }
        bool = false;
        break;
        y.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.dnn.bJ("contact_info_header_bizinfo", true);
        break label372;
        bool = false;
        break label529;
        this.dnn.bJ("contact_info_subscribe_bizinfo", true);
        this.dnn.bJ("contact_info_biz_go_chatting", true);
        if (locald.Lq())
        {
          this.dnn.bJ("contact_info_biz_enable", true);
          this.dnn.bJ("contact_info_biz_disable", false);
          this.dnn.add("contact_info_biz_disable").setTitle(R.l.enterprise_contact_info_disable_sub);
          this.dnn.bJ("contact_is_mute", false);
          this.dnn.bJ("biz_placed_to_the_top", false);
          this.dny = ((CheckBoxPreference)this.dnn.add("biz_placed_to_the_top"));
          this.dny.setTitle(R.l.enterprise_sub_placetop);
          bsC();
          if (!locald.LB()) {
            break label582;
          }
          this.dnn.bJ("contact_info_locate", true);
          break label582;
        }
        this.dnn.bJ("contact_info_biz_enable", false);
        this.dnn.bJ("contact_info_biz_disable", true);
        this.dnn.add("contact_info_biz_enable").setTitle(R.l.enterprise_contact_info_enable_sub);
        this.dnn.bJ("contact_is_mute", true);
        this.dnn.bJ("biz_placed_to_the_top", true);
        this.dnn.bJ("contact_info_locate", true);
        break label582;
        if (locald.Ly())
        {
          this.dnn.bJ("contact_info_locate", true);
          this.dnn.bJ("contact_info_subscribe_bizinfo", false);
          this.dnn.bJ("enterprise_contact_info_enter", false);
          this.dnn.add("contact_info_biz_go_chatting").setTitle(R.l.enterprise_contact_info_enter);
          localObject1 = this.dnn;
          if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).bJ("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.dnn.add("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).rHo = this.dnp.Bl();
            ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_father_placetop);
            bsC();
            this.dnn.bJ("contact_is_mute", true);
            this.dnJ = this.dnp.Bj();
            id(this.dnJ);
            this.dnn.add("contact_is_mute").setSummary(R.l.contact_info_enterprise_father_mute_tips);
            break;
          }
        }
        localObject1 = this.dnn;
        if ((s.hx(this.dnp.field_username)) || (!com.tencent.mm.n.a.gR(this.dnp.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).bJ("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.dnn.add("contact_info_stick_biz")).rHo = this.dnp.Bl();
          this.dnn.bJ("contact_is_mute", true);
          this.dnJ = false;
          break;
        }
        this.dnn.bJ("near_field_service", true);
        break label654;
        label2281:
        this.dnn.bJ("contact_info_time_expired", true);
        break label726;
        label2297:
        this.dnn.bJ("contact_info_time_expired", true);
        break label756;
        this.dnn.bJ("contact_info_service_phone", true);
        continue;
        this.dnn.bJ("contact_info_time_expired", true);
        y.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).cBw();
        ((KeyValuePreference)localObject2).vcS = false;
        ((KeyValuePreference)localObject2).uME = this.bER.getString(R.l.contact_info_isnot_verify_user_title);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this.bER, this.dnp.signature));
        ((KeyValuePreference)localObject2).nf(false);
        if (am.a.dVA != null)
        {
          localObject1 = BackwardSupportUtil.b.e(am.a.dVA.hL(this.dnp.field_verifyFlag), 2.0F);
          label2431:
          if (localObject1 != null) {
            break label2505;
          }
          bool = true;
          y.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5854;
          }
        }
      }
      label3676:
      label5854:
      for (localObject1 = new BitmapDrawable(this.bER.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).vda = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).vcY = 8;
        break;
        localObject1 = null;
        break label2431;
        bool = false;
        break label2439;
        y.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.dnn.bJ("contact_info_user_desc", true);
        if (this.mWO) {
          break;
        }
        this.dnn.bJ("contact_info_time_expired", true);
        break;
        localObject1 = this.bER.getResources().getString(R.l.contact_info_verify_user_title);
        break label1098;
        localObject1 = this.bER.getResources().getString(R.l.brandservice_sweibo_verify);
        break label1098;
        localObject1 = this.bER.getResources().getString(R.l.brandservice_tweibo_verify);
        break label1098;
        ((KeyValuePreference)localObject6).uME = ((d.b.d)localObject4).efR;
        break label1105;
        localObject1 = null;
        break label1132;
        bool = false;
        break label1163;
        y.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1288;
        label2667:
        y.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1295;
        label2678:
        this.dnn.bJ("contact_info_verifyuser", true);
        break label1295;
        if ((this.eeW != null) && (this.eeW.LU() != null) && (!bk.bl(this.eeW.LU().efZ)))
        {
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1295;
          }
          ((KeyValuePreference)localObject1).setSummary(this.eeW.LU().efZ);
          break label1295;
        }
        y.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.dnn.bJ("contact_info_verifyuser", true);
        break label1295;
        label2791:
        localObject1 = null;
        break label1362;
        label2797:
        bool = false;
        break label1370;
        label2803:
        y.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.dnn.bJ("contact_info_trademark", true);
        break label1464;
        this.dnn.bJ("contact_info_privilege", true);
        int k = this.dnn.indexOf("contact_info_category2");
        if ((k >= 0) && (this.eeV != null) && (this.eeV.size() > 0)) {
          i = this.eeV.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.eeV.get(i) != null) && ((!this.bER.getString(R.l.contact_info_biz_participants).equals(((com.tencent.mm.ai.d.a)this.eeV.get(i)).title)) || (this.efd)) && ((!bk.bl(((com.tencent.mm.ai.d.a)this.eeV.get(i)).title)) || (!bk.bl(((com.tencent.mm.ai.d.a)this.eeV.get(i)).eeZ))))
          {
            localObject5 = new Preference(this.bER);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#" + i);
            localObject1 = ((com.tencent.mm.ai.d.a)this.eeV.get(i)).title;
            j = this.bER.getResources().getIdentifier(((com.tencent.mm.ai.d.a)this.eeV.get(i)).eeZ, "string", this.bER.getPackageName());
            if (j > 0) {
              localObject1 = this.bER.getString(j);
            }
            localObject2 = localObject1;
            if (this.mVy.Lx()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((com.tencent.mm.ai.d.a)this.eeV.get(i)).eeZ))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.bER.getString(R.l.__mp_wording__brandinfo_history_massmsg))) {}
              }
              else
              {
                localObject2 = this.bER.getString(R.l.enterprise_brand_history);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bk.bl(((com.tencent.mm.ai.d.a)this.eeV.get(i)).description)) {
              ((Preference)localObject5).setSummary(((com.tencent.mm.ai.d.a)this.eeV.get(i)).description);
            }
            if (!bk.pm(((com.tencent.mm.ai.d.a)this.eeV.get(i)).eeZ).equals("__mp_wording__brandinfo_feedback")) {
              break label5830;
            }
            j = this.dnn.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5830;
            }
            j += 1;
            this.dnn.a((Preference)localObject5, j);
            if (bk.pm(((com.tencent.mm.ai.d.a)this.eeV.get(i)).eeZ).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.bER);
              this.dnn.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          y.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.mWO) && (s.w(this.dnp)) && (this.dnp.cCE != null) && (!this.dnp.cCE.equals("")))
        {
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bk.aM(this.dnp.field_weiboNickname, "") + this.bER.getString(R.l.settings_show_weibo_field, new Object[] { s.ib(this.dnp.cCE) }));
            ((Preference)localObject1).izu = com.tencent.mm.cb.a.i(this.bER, R.e.link_color);
            ((KeyValuePreference)localObject1).nf(false);
          }
          if ((this.eeW == null) || (this.eeW.LR() == null)) {
            break label4417;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.dnn.add("contact_info_reputation");
          if (this.eeW.LR().efU <= 0) {
            break label4369;
          }
          ((BizInfoPayInfoIconPreference)localObject1).vT(this.eeW.LR().efU);
          label3553:
          localObject1 = (BizInfoPayInfoIconPreference)this.dnn.add("contact_info_guarantee_info");
          if ((this.eeW.LR().efW == null) || (this.eeW.LR().efW.size() <= 0)) {
            break label4385;
          }
          ((BizInfoPayInfoIconPreference)localObject1).bX(this.eeW.LR().efW);
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_scope_of_business");
          if (bk.bl(this.eeW.LR().efV)) {
            break label4401;
          }
          ((KeyValuePreference)localObject1).setSummary(this.eeW.LR().efV);
          ((KeyValuePreference)localObject1).vcY = 4;
          ((KeyValuePreference)localObject1).nf(false);
          if ((this.mWM == null) || (this.mWM.size() <= 0)) {
            break label4472;
          }
          this.dnn.bJ("contact_info_bindwxainfo", false);
          localObject1 = (BizBindWxaInfoPreference)this.dnn.add("contact_info_bindwxainfo");
          localObject2 = this.mVy;
          localObject5 = this.mWM;
          ((BizBindWxaInfoPreference)localObject1).mVm = true;
          ((BizBindWxaInfoPreference)localObject1).ftp = ((com.tencent.mm.ai.d)localObject2);
          if (((BizBindWxaInfoPreference)localObject1).hoi != null) {
            break label4459;
          }
          ((BizBindWxaInfoPreference)localObject1).hoi = new LinkedList();
          if ((localObject5 != null) && (!((List)localObject5).isEmpty())) {
            ((BizBindWxaInfoPreference)localObject1).hoi.addAll((Collection)localObject5);
          }
          ((BizBindWxaInfoPreference)localObject1).aeT();
          localObject2 = this.bER.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
          y.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.mWT) });
          if (!this.mWT)
          {
            this.mWS = ((String)localObject2);
            if ((this.eeW != null) && (this.eeW.Ma()) && (this.dnp != null)) {
              break label4488;
            }
            this.dnn.bJ("contact_info_kf_worker", true);
          }
          y.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.bER.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.bER.getIntent() == null) || (!this.bER.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label5170;
          }
          y.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = bsA();
          y.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.gR(this.dnp.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.n.a.gR(this.dnp.field_type)) || (!bool)) {
            break label5008;
          }
          if (locald == null) {
            break label4966;
          }
          localObject1 = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.dnn.add("contact_info_locate");
          if (!locald.LA()) {
            break label4895;
          }
          localObject5 = z.MC().bZ(locald.field_username);
          this.mWL = z.MC().bY((String)localObject5);
          if (this.mWL == null) {
            break label4884;
          }
          if (this.mWL.il(4)) {
            break label4878;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).rHo = bool;
          if (!locald.Lq()) {
            break label4924;
          }
          if ((this.eeW == null) && (locald != null)) {
            this.eeW = locald.bS(false);
          }
          if ((this.eeW == null) || (!this.eeW.LK()) || (!com.tencent.mm.br.d.SP("brandservice"))) {
            break label4908;
          }
          this.dnn.bJ("contact_info_template_recv", false);
          label4191:
          if (!locald.bS(false).Lu()) {
            break label4940;
          }
          ((CheckBoxPreference)localObject2).rHo = locald.Lr();
        }
        for (;;)
        {
          this.dnn.bJ("contact_info_biz_read_msg_online", true);
          this.dnn.bJ("contact_info_biz_add", true);
          localObject1 = this.dnp.Bq();
          if (localObject1 != null) {
            this.bER.setMMTitle((String)localObject1);
          }
          if (s.hx(this.dnp.field_username))
          {
            this.dnn.add("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
            this.bER.setMMTitle(R.l.contact_info_title);
          }
          if ((!s.hS(this.dnp.field_username)) && (this.mVy != null) && (!this.mVy.Lz())) {
            this.bER.addIconOptionMenu(0, R.g.mm_title_btn_menu, new c.17(this));
          }
          return;
          this.dnn.bJ("contact_info_verifyuser_weibo", true);
          break;
          this.dnn.bJ("contact_info_reputation", true);
          break label3553;
          this.dnn.bJ("contact_info_guarantee_info", true);
          break label3616;
          this.dnn.bJ("contact_info_scope_of_business", true);
          break label3676;
          this.dnn.bJ("contact_info_reputation", true);
          this.dnn.bJ("contact_info_guarantee_info", true);
          this.dnn.bJ("contact_info_scope_of_business", true);
          break label3676;
          label4459:
          ((BizBindWxaInfoPreference)localObject1).hoi.clear();
          break label3770;
          label4472:
          this.dnn.bJ("contact_info_bindwxainfo", true);
          break label3803;
          if (bk.bl((String)localObject2))
          {
            localObject1 = z.Mx().lh(this.dnp.field_username);
            if (localObject1 == null)
            {
              this.dnn.bJ("contact_info_kf_worker", true);
              z.Mz().a(this);
              z.Mz().al(this.dnp.field_username, q.Gj());
              this.mWT = true;
              break label3895;
            }
            y.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { ((com.tencent.mm.ai.g)localObject1).field_openId });
            this.dnn.bJ("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.dnn.add("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.ai.g)localObject1).field_nickname);
            localObject5 = com.tencent.mm.ag.b.a(((com.tencent.mm.ai.g)localObject1).field_openId, false, -1);
            if (localObject5 == null)
            {
              c((com.tencent.mm.ai.g)localObject1);
              KU(((com.tencent.mm.ai.g)localObject1).field_openId);
              break label3895;
            }
            ((IconWidgetPreference)localObject2).C((Bitmap)localObject5);
            break label3895;
          }
          localObject5 = z.Mx();
          localObject1 = ((com.tencent.mm.ai.i)localObject5).lg((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.ai.i.a((com.tencent.mm.ai.g)localObject1)))
          {
            z.Mz().a(this);
            z.Mz().am(this.dnp.field_username, (String)localObject2);
            this.mWT = true;
          }
          if (localObject1 != null) {
            break label5827;
          }
          y.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.ai.i)localObject5).lh(this.dnp.field_username);
          if (localObject1 == null)
          {
            this.dnn.bJ("contact_info_kf_worker", true);
            break label3895;
          }
          this.dnn.bJ("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.dnn.add("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.ai.g)localObject1).field_nickname);
          localObject5 = com.tencent.mm.ag.b.a(((com.tencent.mm.ai.g)localObject1).field_openId, false, -1);
          if (localObject5 == null)
          {
            c((com.tencent.mm.ai.g)localObject1);
            KU(((com.tencent.mm.ai.g)localObject1).field_openId);
          }
          for (;;)
          {
            y.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { ((com.tencent.mm.ai.g)localObject1).field_openId, ((com.tencent.mm.ai.g)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).C((Bitmap)localObject5);
          }
          bool = false;
          break label4115;
          y.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label4122;
          ((CheckBoxPreference)localObject1).rHo = locald.Lq();
          break label4122;
          this.dnn.bJ("contact_info_template_recv", true);
          break label4191;
          this.dnn.bJ("contact_info_template_recv", true);
          break label4191;
          this.dnn.bJ("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).rHo = locald.Lr();
          continue;
          label4966:
          this.dnn.bJ("contact_info_subscribe_bizinfo", true);
          this.dnn.bJ("contact_info_locate", true);
          this.dnn.bJ("contact_info_template_recv", true);
        }
        y.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.dnp.field_username });
        bsy();
        localObject1 = this.dnn.add("contact_info_biz_add");
        y.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.mWP) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(R.l.contact_info_biz_join);
          }
        }
        else if (wa(this.fhj))
        {
          if (locald != null) {
            break label5131;
          }
          y.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.bER.showOptionMenu(false);
          return;
          ((Preference)localObject1).setTitle(R.l.contact_info_biz_bind_exdevice);
          break;
          ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = locald.Lq();
          this.dnn.bJ("contact_info_subscribe_bizinfo", false);
        }
        if (com.tencent.mm.n.a.gR(this.dnp.field_type))
        {
          if (locald != null)
          {
            localObject1 = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.dnn.add("contact_info_locate");
            if (locald.LA())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_chat_receive_msg);
              localObject5 = z.MC().bZ(locald.field_username);
              this.mWL = z.MC().bY((String)localObject5);
              if (this.mWL != null) {
                if (!this.mWL.il(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).rHo = bool;
                  if (!locald.Lq()) {
                    break label5607;
                  }
                  if ((this.eeW == null) && (locald != null)) {
                    this.eeW = locald.bS(false);
                  }
                  if ((this.eeW == null) || (!this.eeW.LK()) || (!com.tencent.mm.br.d.SP("brandservice"))) {
                    break label5591;
                  }
                  this.dnn.bJ("contact_info_template_recv", false);
                  label5360:
                  if (!locald.bS(false).Lu()) {
                    break label5623;
                  }
                  ((CheckBoxPreference)localObject2).rHo = locald.Lr();
                }
              }
            }
          }
          for (;;)
          {
            this.dnn.bJ("contact_info_biz_read_msg_online", true);
            this.dnn.bJ("contact_info_biz_add", true);
            localObject1 = this.dnp.Bq();
            if (localObject1 != null) {
              this.bER.setMMTitle((String)localObject1);
            }
            if (s.hx(this.dnp.field_username))
            {
              this.dnn.add("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
              this.bER.setMMTitle(R.l.contact_info_title);
            }
            if ((s.hS(this.dnp.field_username)) || (this.mVy == null)) {
              break;
            }
            this.bER.addIconOptionMenu(0, R.g.mm_title_btn_menu, new c.18(this));
            return;
            bool = false;
            break label5284;
            y.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label5291;
            if (locald.Ly())
            {
              ((CheckBoxPreference)localObject1).setTitle(R.l.enterprise_brand_receive_msg);
              if (!z.MH().kH(locald.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).rHo = bool;
                break;
              }
            }
            ((CheckBoxPreference)localObject1).rHo = locald.Lq();
            break label5291;
            this.dnn.bJ("contact_info_template_recv", true);
            break label5360;
            label5607:
            this.dnn.bJ("contact_info_template_recv", true);
            break label5360;
            label5623:
            this.dnn.bJ("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).rHo = locald.Lr();
            continue;
            this.dnn.bJ("contact_info_subscribe_bizinfo", true);
            this.dnn.bJ("contact_info_locate", true);
            this.dnn.bJ("contact_info_template_recv", true);
          }
        }
        y.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.dnp.field_username });
        bsy();
        localObject1 = this.dnn.add("contact_info_biz_add");
        if ((localObject1 != null) && (this.mWP)) {
          ((Preference)localObject1).setTitle(R.l.contact_info_biz_join);
        }
        if (wa(this.fhj))
        {
          if (locald != null) {
            break label5783;
          }
          y.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.bER.showOptionMenu(false);
          return;
          ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = locald.Lq();
          this.dnn.bJ("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1288;
        Object localObject3 = null;
        break label1155;
      }
    }
  }
  
  private void bsy()
  {
    if ((this.dnp != null) && (com.tencent.mm.n.a.gR(this.dnp.field_type)) && (!s.hx(this.dnp.field_username)) && (!s.ic(this.dnp.field_username)))
    {
      this.dnn.bJ("contact_is_mute", false);
      this.dnn.bJ("contact_info_verifyuser_weibo", true);
      this.dnn.bJ("contact_info_subscribe_bizinfo", true);
      this.dnn.bJ("contact_info_template_recv", true);
      this.dnn.bJ("contact_info_locate", true);
      if (this.mWO) {
        break label292;
      }
      this.dnn.bJ("contact_info_time_expired", true);
      label131:
      if ((this.dnp == null) || ((!s.hS(this.dnp.field_username)) && (!s.ic(this.dnp.field_username))) || (!com.tencent.mm.n.a.gR(this.dnp.field_type))) {
        break label308;
      }
      this.dnn.bJ("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (s.ic(this.dnp.field_username)) {
        this.dnn.bJ("contact_info_user_desc", true);
      }
      return;
      this.dnn.bJ("contact_is_mute", true);
      if ((this.dnp != null) && (!com.tencent.mm.n.a.gR(this.dnp.field_type)) && (wa(this.fhj)))
      {
        this.dnn.bJ("contact_info_expose_btn", false);
        break;
      }
      this.dnn.bJ("contact_info_expose_btn", true);
      break;
      label292:
      this.dnn.bJ("contact_info_biz_add", true);
      break label131;
      label308:
      this.dnn.bJ("contact_info_biz_go_chatting", true);
    }
  }
  
  private static void c(com.tencent.mm.ai.g paramg)
  {
    long l = System.currentTimeMillis();
    com.tencent.mm.ag.i locali = o.Kh();
    if (locali.kp(paramg.field_openId) == null)
    {
      com.tencent.mm.ag.h localh = new com.tencent.mm.ag.h();
      localh.username = paramg.field_openId;
      localh.ebS = paramg.field_headImgUrl;
      localh.bK(false);
      localh.cCq = 3;
      locali.a(localh);
    }
    o.Kj().kc(paramg.field_openId);
    y.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void id(boolean paramBoolean)
  {
    if (this.dnp != null) {
      if (this.bER != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.ai.f.eW(this.dnp.field_username))) {
          break label65;
        }
        this.bER.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.rHo = paramBoolean;
      }
      return;
      label65:
      this.bER.setTitleMuteIconVisibility(8);
    }
  }
  
  private static boolean wa(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  public final String Mq()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final void a(int paramInt, com.tencent.mm.ah.m paramm)
  {
    if ((this.mVy == null) || (!this.mVy.LA())) {}
    while (paramm.getType() != 1354) {
      return;
    }
    paramm = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
    String str = z.MC().bZ(this.mVy.field_username);
    this.mWL = z.MC().bY(str);
    if (this.mWL != null)
    {
      if (!this.mWL.il(4)) {}
      for (boolean bool = true;; bool = false)
      {
        paramm.rHo = bool;
        this.dnn.notifyDataSetChanged();
        return;
      }
    }
    y.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
  }
  
  final void a(com.tencent.mm.ai.d paramd, boolean paramBoolean)
  {
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.dnn.add("contact_info_locate");
    aww localaww = new aww();
    localaww.ffv = paramd.field_brandFlag;
    localaww.hPY = this.dnp.field_username;
    if (wa(this.fhj))
    {
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new i.a(58, localaww));
    }
    for (;;)
    {
      z.My().c(paramd, new String[0]);
      localCheckBoxPreference1.rHo = paramd.Lq();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.rHo = paramd.Lr();
      }
      if (paramBoolean) {
        bsx();
      }
      return;
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new i.a(47, localaww));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label277;
      }
      bool = true;
      label28:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label283;
      }
      bool = true;
      label40:
      Assert.assertTrue(bool);
      this.dnn = paramf;
      this.dnp = paramad;
      this.mVI = paramBoolean;
      this.fhj = paramInt;
      this.mWR = this.bER.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.mWW = ((SnsAdClick)this.bER.getIntent().getParcelableExtra("KSnsAdTag"));
      this.mWV = this.bER.getIntent().getBundleExtra("Contact_Ext_Args");
      this.mWX = this.bER.getIntent().getStringExtra("key_add_contact_report_info");
      bsx();
      paramf = this.bER.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bk.bl(paramf))
      {
        this.bER.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.bER, paramf, "", this.bER.getString(R.l.app_ok), null);
      }
      if (paramad != null)
      {
        z.MK().kC(paramad.field_username);
        if (com.tencent.mm.ai.f.la(paramad.field_username))
        {
          paramf = paramad.field_username;
          if (!com.tencent.mm.ai.f.eW(paramf)) {
            break label289;
          }
          z.MG();
          com.tencent.mm.ai.a.h.a(paramf, this);
          paramf = com.tencent.mm.ai.f.kX(paramf).LG();
          if (paramf != null) {
            z.MK().kC(paramf);
          }
        }
      }
    }
    label277:
    label283:
    label289:
    do
    {
      do
      {
        return true;
        bool = false;
        break;
        bool = false;
        break label28;
        bool = false;
        break label40;
      } while (!com.tencent.mm.ai.f.lc(paramf));
      z.MH();
      com.tencent.mm.ai.c.a(paramf, this);
      z.My();
      paramf = e.kT(paramf);
    } while (paramf == null);
    z.MK().kC(paramf);
    return true;
  }
  
  public final boolean awZ()
  {
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.dnn.add("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    return true;
  }
  
  final void az(int paramInt, String paramString)
  {
    if ((this.mWV == null) || ((this.fhj != 39) && (this.fhj != 56) && (this.fhj != 35) && (this.fhj != 87) && (this.fhj != 88) && (this.fhj != 89) && (this.fhj != 85)))
    {
      y.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      return;
    }
    if (this.dnp == null)
    {
      y.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      return;
    }
    String str2 = this.mWV.getString("Contact_Ext_Args_Search_Id");
    String str3 = bk.pm(this.mWV.getString("Contact_Ext_Args_Query_String"));
    int j = this.mWV.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.fhj)
    {
    default: 
      i = 0;
      str1 = bk.pm(this.mWV.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bk.pm(this.dnp.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bk.bl(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      y.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10866, paramString);
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
  
  final void bsB()
  {
    if ((this.dnp == null) || (bk.bl(this.dnp.field_username))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.dnp.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this.bER, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  final void bsz()
  {
    if ((this.bER.getIntent() != null) && (this.bER.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.bER.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bk.bl((String)localObject1)) {
        break label151;
      }
      y.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label151:
    while (bsA())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.bER, new c.6(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.fhj));
      if (this.eff != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbI = this.eff;
      }
      if (!bk.bl(this.kzG)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).kzG = this.kzG;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbO = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.dnp.field_username, (LinkedList)localObject2, this.mWX);
      return;
    }
    y.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    au.Dk().a(536, this);
    Object localObject2 = new da();
    ((da)localObject2).bJg.bJi = ((String)localObject1);
    ((da)localObject2).bJg.opType = 1;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((da)localObject2).bJh.bJk;
    localObject2 = this.bER;
    this.bER.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.bER.getString(R.l.app_waiting), true, new c.5(this, (com.tencent.mm.ah.m)localObject1));
  }
  
  public final void e(LinkedList<cln> paramLinkedList)
  {
    z.Mz().b(this);
    if (this.dnn == null)
    {
      y.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      return;
    }
    if (this.dnp == null)
    {
      y.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      return;
    }
    if (!bk.bl(this.mWS))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cln localcln = (cln)localIterator.next();
        if ((localcln.tYK != null) && (localcln.tYK.equals(this.mWS)))
        {
          this.dnn.bJ("contact_info_kf_worker", false);
          this.dnn.add("contact_info_kf_worker").setSummary(localcln.tqh);
          return;
        }
      }
    }
    this.dnn.bJ("contact_info_kf_worker", false);
    this.dnn.add("contact_info_kf_worker").setSummary(((cln)paramLinkedList.get(0)).tqh);
  }
  
  final void ic(boolean paramBoolean)
  {
    Object localObject = this.mVy.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.a.c((String)localObject, paramBoolean);
      au.Dk().a(1394, this);
      au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      MMActivity localMMActivity = this.bER;
      this.bER.getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.bER.getString(R.l.app_waiting), true, new c.14(this, (com.tencent.mm.plugin.profile.a.c)localObject));
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.bER == null) {
      y.e("MicroMsg.ContactWidgetBizInfo", "null == context");
    }
    do
    {
      return;
      y.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    com.tencent.mm.plugin.messenger.a.g.bhI().o(str1, str2, bool);
    com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramIntent, str2);
    com.tencent.mm.ui.widget.snackbar.b.h(this.bER, this.bER.getString(R.l.finish_sent));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject1 = null;
    y.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.mWT = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramm == null) {
      y.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
    }
    label377:
    do
    {
      do
      {
        return;
        au.Dk().b(paramm.getType(), this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
          return;
        }
        y.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        if (paramm.getType() == 536)
        {
          au.Dk().b(536, this);
          bsx();
          return;
        }
        if (paramm.getType() != 1363) {
          break;
        }
        paramString = (com.tencent.mm.plugin.profile.a.b)paramm;
        if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
        for (paramString = (bqh)paramString.dmK.ecF.ecN;; paramString = null)
        {
          localObject2 = (com.tencent.mm.plugin.profile.a.b)paramm;
          paramm = (com.tencent.mm.ah.m)localObject1;
          if (((com.tencent.mm.plugin.profile.a.b)localObject2).dmK != null)
          {
            paramm = (com.tencent.mm.ah.m)localObject1;
            if (((com.tencent.mm.plugin.profile.a.b)localObject2).dmK.ecE.ecN != null) {
              paramm = (bqg)((com.tencent.mm.plugin.profile.a.b)localObject2).dmK.ecE.ecN;
            }
          }
          if ((paramString != null) && (paramString.sCU != null) && (paramString.sCU.ret == 0) && (paramString.sCR != null) && (!bk.bl(paramString.sCR.sCP))) {
            break label377;
          }
          if ((paramString == null) || (paramString.sCU == null)) {
            break;
          }
          y.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.sCU.ret) });
          return;
        }
        y.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
        return;
        if (paramString.sCR == null)
        {
          y.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
          return;
        }
        Object localObject2 = z.MC().bY(paramString.sCR.sCP);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.ai.a.j();
          ((com.tencent.mm.ai.a.j)localObject1).field_userId = paramString.sCR.sCP;
        }
        ((com.tencent.mm.ai.a.j)localObject1).field_userName = paramString.sCR.ipb;
        ((com.tencent.mm.ai.a.j)localObject1).field_brandUserName = paramm.sCO;
        ((com.tencent.mm.ai.a.j)localObject1).field_UserVersion = paramString.sCR.ver;
        ((com.tencent.mm.ai.a.j)localObject1).field_headImageUrl = paramString.sCR.sCJ;
        ((com.tencent.mm.ai.a.j)localObject1).field_profileUrl = paramString.sCR.sCX;
        ((com.tencent.mm.ai.a.j)localObject1).field_bitFlag = paramString.sCR.sCK;
        ((com.tencent.mm.ai.a.j)localObject1).field_addMemberUrl = paramString.sCR.sCN;
        ((com.tencent.mm.ai.a.j)localObject1).field_needToUpdate = false;
      } while (z.MC().b((com.tencent.mm.ai.a.j)localObject1));
      z.MC().a((com.tencent.mm.ai.a.j)localObject1);
      return;
      if (paramm.getType() == 1394)
      {
        paramString = ((com.tencent.mm.plugin.profile.a.c)paramm).bst();
        localObject1 = ((com.tencent.mm.plugin.profile.a.c)paramm).bss();
        if ((localObject1 == null) || (((bwl)localObject1).sCU == null) || (((bwl)localObject1).sCU.ret != 0))
        {
          if ((localObject1 != null) && (((bwl)localObject1).sCU != null))
          {
            y.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((bwl)localObject1).sCU.ret) });
            return;
          }
          y.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
          return;
        }
        if (!paramString.tMS)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label903;
          }
          paramString = this.mVy;
          paramString.field_brandFlag &= 0xFFFFFFFE;
          a(paramString, true);
          au.Hx();
          if (com.tencent.mm.model.c.FB().abv(paramString.field_username) == null)
          {
            paramm = new ak(paramString.field_username);
            paramm.dS(bk.pm(this.mVy.LG()));
            au.Hx();
            localObject1 = com.tencent.mm.model.c.Fy().HA(paramString.field_username);
            if (localObject1 == null) {
              break label865;
            }
            au.Hx();
            com.tencent.mm.model.c.FB().d(paramm);
            au.Hx();
            com.tencent.mm.model.c.FB().aj((bi)localObject1);
          }
        }
        for (;;)
        {
          au.Hx();
          if (com.tencent.mm.model.c.FB().abv(paramString.field_enterpriseFather) != null) {
            break label888;
          }
          paramString = new ak(paramString.field_enterpriseFather);
          paramString.cuB();
          au.Hx();
          com.tencent.mm.model.c.FB().d(paramString);
          return;
          paramInt1 = 0;
          break;
          paramm.cuB();
          au.Hx();
          com.tencent.mm.model.c.FB().d(paramm);
        }
        au.Hx();
        com.tencent.mm.model.c.FA().aaG(paramString.field_enterpriseFather);
        return;
        paramString = this.mVy;
        paramString.field_brandFlag |= 0x1;
        a(paramString, true);
        au.Hx();
        com.tencent.mm.model.c.FB().abu(paramString.field_username);
        au.Hx();
        if (com.tencent.mm.model.c.FB().abI(paramString.field_enterpriseFather) <= 0)
        {
          au.Hx();
          com.tencent.mm.model.c.FB().abu(paramString.field_enterpriseFather);
          return;
        }
        au.Hx();
        com.tencent.mm.model.c.FA().aaG(paramString.field_enterpriseFather);
        return;
      }
      if (paramm.getType() == 1343)
      {
        bsx();
        return;
      }
    } while (paramm.getType() != 1228);
    label865:
    label888:
    bsx();
    label903:
  }
  
  public final boolean xQ(String paramString)
  {
    int i = 4;
    boolean bool2 = true;
    boolean bool1;
    if (paramString == null) {
      bool1 = false;
    }
    Object localObject2;
    label1095:
    label1659:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (paramString.equals("contact_info_verifyuser_weibo"))
                  {
                    new com.tencent.mm.plugin.profile.ui.a.a(this.bER).ep(this.dnp.cCE, this.dnp.field_username);
                    return true;
                  }
                  if ("contact_info_biz_go_chatting".endsWith(paramString))
                  {
                    if (this.mWW != null)
                    {
                      paramString = new nn();
                      this.mWW.eAB = 5;
                      paramString.bXh.bXi = this.mWW;
                      com.tencent.mm.sdk.b.a.udP.m(paramString);
                    }
                    if ((this.mVy != null) && ((this.mVy.Ly()) || (this.mVy.LA())))
                    {
                      paramString = new Intent();
                      if (this.mVy.LA())
                      {
                        localObject1 = this.mVy.LG();
                        if (bk.bl((String)localObject1))
                        {
                          y.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                          return false;
                        }
                        paramString.putExtra("enterprise_biz_name", (String)localObject1);
                        paramString.putExtra("enterprise_biz_display_name", r.gV((String)localObject1));
                        paramString.addFlags(67108864);
                        com.tencent.mm.br.d.e(this.bER, ".ui.conversation.EnterpriseConversationUI", paramString);
                        this.bER.finish();
                      }
                    }
                    for (;;)
                    {
                      az(5, null);
                      return true;
                      paramString.putExtra("enterprise_biz_name", this.dnp.field_username);
                      paramString.putExtra("enterprise_biz_display_name", r.gV(this.dnp.field_username));
                      break;
                      paramString = new Intent();
                      if (this.bER.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                        paramString.setFlags(268435456);
                      }
                      if (this.mVI)
                      {
                        paramString.putExtra("Chat_User", this.dnp.field_username);
                        paramString.putExtra("Chat_Mode", 1);
                        this.bER.setResult(-1, paramString);
                      }
                      else
                      {
                        paramString.putExtra("Chat_User", this.dnp.field_username);
                        paramString.putExtra("Chat_Mode", 1);
                        paramString.putExtra("finish_direct", true);
                        com.tencent.mm.plugin.profile.a.eUR.e(paramString, this.bER);
                      }
                    }
                  }
                  if ("contact_info_biz_add".endsWith(paramString))
                  {
                    if (!com.tencent.mm.model.gdpr.c.IO()) {
                      bsz();
                    }
                    for (;;)
                    {
                      bool1 = bool2;
                      if (this.mWR == 0) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.h.nFQ.f(11263, new Object[] { Integer.valueOf(this.mWR), this.dnp.field_username });
                      return true;
                      com.tencent.mm.model.gdpr.c.a(this.bER, com.tencent.mm.model.gdpr.a.dYu, this.dnp.field_username, new c.4(this));
                    }
                  }
                  bool1 = bool2;
                } while ("contact_info_biz_read_msg_online".endsWith(paramString));
                if ("contact_info_stick_biz".equals(paramString))
                {
                  if (((CheckBoxPreference)this.dnn.add("contact_info_stick_biz")).isChecked())
                  {
                    com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { this.dnp.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0) });
                    com.tencent.mm.model.i.gz(this.dnp.field_username);
                    return true;
                  }
                  s.u(this.dnp.field_username, true);
                  com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { this.dnp.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0) });
                  return true;
                }
                if (("contact_info_guarantee_info".equals(paramString)) && (this.eeW.LR() != null) && (!bk.bl(this.eeW.LR().efX)))
                {
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("rawUrl", this.eeW.LR().efX);
                  ((Intent)localObject1).putExtra("useJs", true);
                  ((Intent)localObject1).putExtra("vertical_scroll", true);
                  ((Intent)localObject1).putExtra("geta8key_scene", 3);
                  com.tencent.mm.br.d.b(this.bER, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                }
                if (paramString.startsWith("contact_info_bizinfo_external#"))
                {
                  int j = bk.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
                  if ((j >= 0) && (j < this.eeV.size()))
                  {
                    paramString = (com.tencent.mm.ai.d.a)this.eeV.get(j);
                    localObject2 = paramString.url;
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
                    ((Intent)localObject1).putExtra("useJs", true);
                    ((Intent)localObject1).putExtra("vertical_scroll", true);
                    ((Intent)localObject1).putExtra("geta8key_scene", 3);
                    ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
                    ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
                    if (((this.mWV != null) && ((this.fhj == 39) || (this.fhj == 56) || (this.fhj == 35))) || (this.fhj == 87) || (this.fhj == 89) || (this.fhj == 85) || (this.fhj == 88))
                    {
                      y.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                      localObject2 = new Bundle();
                      ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
                      ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.mWV);
                      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
                      if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
                        break label1095;
                      }
                    }
                    for (i = 7;; i = 6)
                    {
                      j = this.bER.getResources().getIdentifier(paramString.eeZ, "string", this.bER.getPackageName());
                      paramString = paramString.title;
                      if (j > 0) {
                        paramString = this.bER.getString(j);
                      }
                      az(i, paramString);
                      com.tencent.mm.br.d.b(this.bER, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                      return true;
                    }
                  }
                }
                if ((!"contact_info_subscribe_bizinfo".endsWith(paramString)) && (!"contact_info_show_brand".endsWith(paramString)) && (!"contact_info_locate".endsWith(paramString))) {
                  break;
                }
                localObject1 = this.mVy;
                bool1 = bool2;
              } while (localObject1 == null);
              if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
                if (((com.tencent.mm.ai.d)localObject1).Lx()) {
                  if (localObject1 != null)
                  {
                    if (!((com.tencent.mm.ai.d)localObject1).LA()) {
                      break label1317;
                    }
                    au.Dk().a(1363, this);
                    if (!((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).isChecked()) {
                      break label1312;
                    }
                    i = 0;
                    paramString = new com.tencent.mm.plugin.profile.a.b(((com.tencent.mm.ai.d)localObject1).field_username, i);
                    au.Dk().a(paramString, 0);
                    localObject2 = this.bER;
                    this.bER.getString(R.l.app_tip);
                    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.bER.getString(R.l.app_waiting), true, new c.15(this, paramString));
                  }
                }
              }
              for (;;)
              {
                bool1 = bool2;
                if (((com.tencent.mm.ai.d)localObject1).LA()) {
                  break;
                }
                bool1 = bool2;
                if (((com.tencent.mm.ai.d)localObject1).Ly()) {
                  break;
                }
                a((com.tencent.mm.ai.d)localObject1, false);
                return true;
                i = 4;
                break label1210;
                if (((com.tencent.mm.ai.d)localObject1).Ly())
                {
                  paramString = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
                  z.MH();
                  localObject2 = ((com.tencent.mm.ai.d)localObject1).field_username;
                  if (!paramString.isChecked()) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    paramString = com.tencent.mm.ai.c.a((String)localObject2, bool1, this);
                    localObject2 = this.bER;
                    this.bER.getString(R.l.app_tip);
                    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.bER.getString(R.l.app_waiting), true, new c.16(this, paramString));
                    break;
                  }
                  if (((com.tencent.mm.ai.d)localObject1).Lq())
                  {
                    ((com.tencent.mm.ai.d)localObject1).field_brandFlag |= 0x1;
                    if ((this.eeW == null) && (localObject1 != null)) {
                      this.eeW = ((com.tencent.mm.ai.d)localObject1).bS(false);
                    }
                    if ((this.eeW != null) && (this.eeW.LK()) && (com.tencent.mm.br.d.SP("brandservice"))) {
                      this.dnn.bJ("contact_info_template_recv", false);
                    }
                  }
                  for (;;)
                  {
                    paramString = com.tencent.mm.plugin.report.service.h.nFQ;
                    localObject2 = ((com.tencent.mm.ai.d)localObject1).field_username;
                    if (((com.tencent.mm.ai.d)localObject1).Lq()) {
                      i = 3;
                    }
                    paramString.f(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
                    break;
                    this.dnn.bJ("contact_info_template_recv", true);
                    continue;
                    ((com.tencent.mm.ai.d)localObject1).field_brandFlag &= 0xFFFFFFFE;
                    this.dnn.bJ("contact_info_template_recv", true);
                  }
                  if ("contact_info_show_brand".endsWith(paramString))
                  {
                    if ((((com.tencent.mm.ai.d)localObject1).field_brandFlag & 0x2) == 0) {}
                    for (i = 1;; i = 0)
                    {
                      if (i == 0) {
                        break label1659;
                      }
                      ((com.tencent.mm.ai.d)localObject1).field_brandFlag |= 0x2;
                      break;
                    }
                    ((com.tencent.mm.ai.d)localObject1).field_brandFlag &= 0xFFFFFFFD;
                  }
                  else if ("contact_info_locate".endsWith(paramString))
                  {
                    if (((com.tencent.mm.ai.d)localObject1).Lr()) {
                      ((com.tencent.mm.ai.d)localObject1).field_brandFlag &= 0xFFFFFFFB;
                    } else {
                      this.mWU = com.tencent.mm.ui.base.h.a(this.bER, this.bER.getString(R.l.chatting_biz_report_location_confirm, new Object[] { this.dnp.Bq() }), this.bER.getString(R.l.app_tip), new DialogInterface.OnClickListener()new c.12
                      {
                        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                        {
                          this.byp.field_hadAlert = 1;
                          this.byp.field_brandFlag |= 0x4;
                          c.this.a(this.byp, true);
                        }
                      }, new c.12(this, (com.tencent.mm.ai.d)localObject1));
                    }
                  }
                }
              }
              if (!"contact_info_verifyuser".endsWith(paramString)) {
                break;
              }
              paramString = this.mVy;
              bool1 = bool2;
            } while (paramString == null);
            localObject2 = paramString.bS(false);
            bool1 = bool2;
          } while (localObject2 == null);
          localObject1 = null;
          if ((((d.b)localObject2).LT() != null) && (!bk.bl(((d.b)localObject2).LT().efS))) {
            paramString = ((d.b)localObject2).LT().efS;
          }
          for (;;)
          {
            bool1 = bool2;
            if (bk.bl(paramString)) {
              break;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramString);
            ((Intent)localObject1).putExtra("useJs", true);
            ((Intent)localObject1).putExtra("vertical_scroll", true);
            ((Intent)localObject1).putExtra("geta8key_scene", 3);
            com.tencent.mm.br.d.b(this.bER, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
            return true;
            paramString = (String)localObject1;
            if (((d.b)localObject2).LU() != null)
            {
              paramString = (String)localObject1;
              if (!bk.bl(((d.b)localObject2).LU().ega)) {
                paramString = ((d.b)localObject2).LU().ega;
              }
            }
          }
          if (!"contact_info_trademark".endsWith(paramString)) {
            break;
          }
          paramString = this.mVy;
          bool1 = bool2;
        } while (paramString == null);
        bool1 = bool2;
      } while (paramString.bS(false) == null);
      bool1 = bool2;
    } while (bk.bl(paramString.bS(false).LM()));
    label1210:
    Object localObject1 = new Intent();
    label1312:
    label1317:
    ((Intent)localObject1).putExtra("rawUrl", paramString.bS(false).LM());
    ((Intent)localObject1).putExtra("useJs", true);
    ((Intent)localObject1).putExtra("vertical_scroll", true);
    ((Intent)localObject1).putExtra("geta8key_scene", 3);
    com.tencent.mm.br.d.b(this.bER, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    return true;
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.dnJ)
      {
        bool1 = true;
        label2113:
        this.dnJ = bool1;
        if (!this.dnJ) {
          break label2573;
        }
        s.o(this.dnp);
        label2133:
        id(this.dnJ);
      }
    }
    else if ("enterprise_contact_info_enter".equals(paramString))
    {
      if (this.bER != null) {
        break label2583;
      }
      y.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
    }
    for (;;)
    {
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.bER.getString(R.l.enterprise_contact_info_disable_sub_confirm);
        localObject2 = this.bER.getString(R.l.enterprise_contact_info_disable_sub);
        com.tencent.mm.ui.base.h.a(this.bER, (String)localObject1, "", (String)localObject2, this.bER.getString(R.l.app_cancel), new c.13(this), null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        ic(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.mVy.field_username);
        com.tencent.mm.br.d.b(this.bER, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.dnn.add("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bk.bl(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.bER, true, (String)localObject1, "", this.bER.getString(R.l.contact_info_dial), this.bER.getString(R.l.app_cancel), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        bsB();
      }
      bool1 = bool2;
      if (!paramString.equals("biz_placed_to_the_top")) {
        break;
      }
      y.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
      if (this.dnD == null) {
        this.dnD = this.bER.getSharedPreferences(this.bER.getPackageName() + "_preferences", 0);
      }
      bool1 = bool2;
      if (this.dnp == null) {
        break;
      }
      if (!this.dnp.Bl()) {
        break label2653;
      }
      y.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.dnp.field_username });
      s.u(this.dnp.field_username, true);
      this.dnD.edit().putBoolean("biz_placed_to_the_top", false).commit();
      return true;
      bool1 = false;
      break label2113;
      label2573:
      s.p(this.dnp);
      break label2133;
      label2583:
      if (this.mVy == null)
      {
        y.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.mVy.field_username);
        ((Intent)localObject1).addFlags(67108864);
        com.tencent.mm.br.d.b(this.bER, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      }
    }
    label2653:
    com.tencent.mm.model.i.gz(this.dnp.field_username);
    y.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.dnp.field_username });
    this.dnD.edit().putBoolean("biz_placed_to_the_top", true).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */