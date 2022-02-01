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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ae;
import com.tencent.mm.am.h.b;
import com.tencent.mm.am.o;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dj.b;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
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
  implements com.tencent.mm.al.g, h.b, o, com.tencent.mm.pluginsdk.b.a
{
  private List<c.a> cIe;
  private c.b cIf;
  private boolean cIm = false;
  private String cIo;
  com.tencent.mm.storage.af contact;
  private CheckBoxPreference fpZ;
  private boolean fqj;
  MMActivity imP;
  private int ima;
  boolean isDeleteCancel = false;
  String rso;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  com.tencent.mm.ui.base.p tipDialog = null;
  private String uAe;
  SnsAdClick uBA = null;
  private String uBB = null;
  private com.tencent.mm.am.a.k uBp;
  private List<WxaAttributes.WxaEntryInfo> uBq;
  private zh uBr = null;
  private boolean uBs = false;
  private boolean uBt = false;
  boolean uBu = false;
  private int uBv = 0;
  private String uBw;
  private boolean uBx;
  com.tencent.mm.ui.widget.a.d uBy = null;
  private Bundle uBz;
  com.tencent.mm.api.c uzN;
  private boolean uzZ;
  
  private c(MMActivity paramMMActivity)
  {
    this.imP = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, zh paramzh)
  {
    this(paramMMActivity);
    this.uAe = paramString;
    this.uBr = paramzh;
  }
  
  private String Jq(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      ad.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.imP.getResources().getString(2131757694);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.imP.getResources().getString(2131757895);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.imP.getResources().getString(2131756745);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.imP.getResources().getString(2131756746);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean Jr(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static boolean akD(String paramString)
  {
    AppMethodBeat.i(27099);
    try
    {
      long l = bt.getLong(paramString, 0L);
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
  
  private void akE(String paramString)
  {
    AppMethodBeat.i(27105);
    ad.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.uBx) });
    if (this.uBx)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.uBw = paramString;
    if ((this.cIf == null) || (!this.cIf.JG()) || (this.contact == null))
    {
      this.screen.cE("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.am.af.awd().wS(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.cE("contact_info_kf_worker", true);
        com.tencent.mm.am.af.awf().a(this);
        com.tencent.mm.am.af.awf().aR(this.contact.field_username, u.aqG());
        this.uBx = true;
        AppMethodBeat.o(27105);
        return;
      }
      ad.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.cE("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aKk("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ak.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        akF(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).Z((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = com.tencent.mm.am.af.awd();
    Object localObject1 = ((com.tencent.mm.am.i)localObject2).wR(paramString);
    if ((localObject1 == null) || (com.tencent.mm.am.i.a((com.tencent.mm.am.g)localObject1)))
    {
      com.tencent.mm.am.af.awf().a(this);
      com.tencent.mm.am.af.awf().k(this.contact.field_username, paramString, 1);
      this.uBx = true;
    }
    if (localObject1 == null) {
      ad.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.am.i)localObject2).wS(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.cE("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.cE("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aKk("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ak.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        akF(paramString.field_openId);
      }
      for (;;)
      {
        ad.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).Z((Bitmap)localObject2);
      }
    }
  }
  
  private void akF(String paramString)
  {
    AppMethodBeat.i(27106);
    aq.n(new c.11(this, paramString), 2000L);
    AppMethodBeat.o(27106);
  }
  
  private static void c(com.tencent.mm.am.g paramg)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.ak.j localj = com.tencent.mm.ak.p.auF();
    if (localj.we(paramg.field_openId) == null)
    {
      com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
      locali.username = paramg.field_openId;
      locali.gUf = paramg.field_headImgUrl;
      locali.ee(false);
      locali.evo = 3;
      localj.b(locali);
    }
    com.tencent.mm.ak.p.auH().vQ(paramg.field_openId);
    ad.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void dcu()
  {
    AppMethodBeat.i(27094);
    bRu();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951636);
    if (this.uBu) {
      this.screen.cE("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.am.f.ei(this.contact.field_username);
    this.cIe = null;
    this.cIf = null;
    this.uBq = null;
    if (((localc == null) || (localc.bU(false) == null)) && (this.uBr != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.uBr.ika;
      localc.field_brandIconURL = this.uBr.ikd;
      localc.field_brandInfo = this.uBr.ikc;
      localc.field_extInfo = this.uBr.ikb;
    }
    label528:
    label672:
    label1844:
    label5303:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.uBr != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.uBr.ika;
        localc.field_brandIconURL = this.uBr.ikd;
        localc.field_brandInfo = this.uBr.ikc;
        localc.field_extInfo = this.uBr.ikb;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.aKk("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!bt.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.uAe, localc);
        this.screen.cE("biz_placed_to_the_top", true);
        this.screen.cE("contact_info_biz_enable", true);
        this.screen.cE("contact_info_biz_disable", true);
        this.screen.cE("contact_info_stick_biz", true);
        if (localc == null) {
          break label2272;
        }
        if (!localc.Jf()) {
          break label1844;
        }
        this.screen.cE("contact_info_biz_add", true);
        this.screen.cE("contact_info_expose_btn", true);
        this.screen.cE("contact_is_mute", false);
        this.fqj = this.contact.Ny();
        if (!localc.Jg()) {
          break label1559;
        }
        this.screen.cE("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.n.b.ls(this.contact.field_type)) {
          break label1553;
        }
        bool = true;
        label474:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cE("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.aKk("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).lG = this.contact.ZS();
        ((CheckBoxPreference)localObject1).setTitle(2131758432);
        dcz();
        nX(this.fqj);
        this.uzN = localc;
        this.cIe = localc.Jn();
        this.cIf = localc.bU(false);
        this.uBq = this.cIf.getWxaEntryInfoList();
        if (!this.cIf.Jo()) {
          break label2157;
        }
        this.screen.aKk("near_field_service").setSummary(2131766197);
        label600:
        if (this.cIf.Ju() == null) {
          break label2238;
        }
        this.uBt = true;
        if (akD(this.cIf.Ju())) {
          break label2174;
        }
        this.screen.cE("contact_info_time_expired", true);
        if ((w.tl(this.contact.field_username)) || (w.tw(this.contact.field_username))) {
          dcv();
        }
        if ((this.cIf.Jr() != null) && (this.cIf.Jr().length() > 0)) {
          this.cIo = this.cIf.Jr();
        }
        this.cIm = this.cIf.Jp();
        if (bt.isNullOrNil(this.cIf.JF())) {
          break label2255;
        }
        this.screen.cE("contact_info_service_phone", false);
        localObject1 = this.screen.aKk("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.cIf.JF());
          ((Preference)localObject1).nJy = this.imP.getResources().getColor(2131100547);
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
        if (!bt.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.aKk("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bt.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.cE("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.cIf == null) || (this.cIf.Jz() == null) || (bt.isNullOrNil(this.cIf.Jz().cJc))) {
              break label2588;
            }
            localObject4 = this.cIf.Jz();
            localObject6 = (KeyValuePreference)this.screen.aKk("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2571;
            }
            ((KeyValuePreference)localObject6).Gfe = false;
            if (!bt.isNullOrNil(((c.b.e)localObject4).cJd)) {
              break label2502;
            }
            ((KeyValuePreference)localObject6).FNA = Jq(((c.b.e)localObject4).cJb);
            if (ar.a.gMY == null) {
              break label2515;
            }
            localObject1 = BackwardSupportUtil.b.n(ar.a.gMY.nd(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5303;
            }
            localObject2 = new BitmapDrawable(this.imP.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2521;
            }
            bool = true;
            ad.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).Gfl = ((Drawable)localObject2);
            if (((c.b.e)localObject4).cJc == null) {
              break label2560;
            }
            localObject7 = ((c.b.e)localObject4).cJf;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, ((c.b.e)localObject4).cJc.trim());
            if (bt.isNullOrNil((String)localObject7)) {
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
          if ((this.cIf == null) || (bt.isNullOrNil(this.cIf.Jt()))) {
            break label2698;
          }
          localObject2 = (KeyValuePreference)this.screen.aKk("contact_info_trademark");
          if (localObject2 == null) {
            break label1310;
          }
          ((KeyValuePreference)localObject2).Gfe = false;
          if (ar.a.gMY == null) {
            break label2686;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.f.Wf(2131689767);
          if (localObject1 != null) {
            break label2692;
          }
          bool = true;
          ad.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5290;
          }
          localObject1 = new BitmapDrawable(this.imP.getResources(), (Bitmap)localObject1);
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
        ((KeyValuePreference)localObject2).Gfl = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cIf.Jt());
        ad.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.cIf.Jt(), this.cIf.Js() });
        if ((this.cIf == null) || (this.cIf.Jv() == null) || (this.cIf.Jv().size() <= 0)) {
          break label2723;
        }
        localObject2 = (KeyValuePreference)this.screen.aKk("contact_info_privilege");
        ((KeyValuePreference)localObject2).vR(false);
        ((KeyValuePreference)localObject2).eTD();
        localObject4 = this.cIf.Jv().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.imP, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.imP.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.imP.getResources().getIdentifier(((c.b.g)localObject7).cJk, "string", this.imP.getPackageName());
          if (i > 0) {
            localObject1 = this.imP.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).fG((View)localObject6);
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.cE("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.cE("contact_info_subscribe_bizinfo", true);
        this.screen.cE("contact_info_biz_go_chatting", true);
        if (localc.IW())
        {
          this.screen.cE("contact_info_biz_enable", true);
          this.screen.cE("contact_info_biz_disable", false);
          this.screen.aKk("contact_info_biz_disable").setTitle(2131758434);
          this.screen.cE("contact_is_mute", false);
          this.screen.cE("biz_placed_to_the_top", false);
          this.fpZ = ((CheckBoxPreference)this.screen.aKk("biz_placed_to_the_top"));
          this.fpZ.setTitle(2131758450);
          dcz();
          if (!localc.Jh()) {
            break label528;
          }
          this.screen.cE("contact_info_locate", true);
          break label528;
        }
        this.screen.cE("contact_info_biz_enable", false);
        this.screen.cE("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.aKk("contact_info_biz_enable")).fU(this.imP.getResources().getString(2131758436), this.imP.getResources().getColor(2131100035));
        this.screen.cE("contact_is_mute", true);
        this.screen.cE("biz_placed_to_the_top", true);
        this.screen.cE("contact_info_locate", true);
        break label528;
        if (localc.Je())
        {
          this.screen.cE("contact_info_locate", true);
          this.screen.cE("contact_info_subscribe_bizinfo", false);
          this.screen.cE("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.aKk("contact_info_biz_go_chatting")).fU(this.imP.getResources().getString(2131758437), this.imP.getResources().getColor(2131100035));
          localObject1 = this.screen;
          if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).cE("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.aKk("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).lG = this.contact.ZS();
            ((CheckBoxPreference)localObject1).setTitle(2131758440);
            dcz();
            this.screen.cE("contact_is_mute", false);
            this.fqj = this.contact.Ny();
            nX(this.fqj);
            break;
          }
        }
        localObject1 = this.screen;
        if ((w.sQ(this.contact.field_username)) || (!com.tencent.mm.n.b.ls(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).cE("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.aKk("contact_info_stick_biz")).lG = this.contact.ZS();
          this.screen.cE("contact_is_mute", true);
          this.fqj = false;
          break;
        }
        label2157:
        this.screen.cE("near_field_service", true);
        break label600;
        label2174:
        this.uBs = true;
        if (!com.tencent.mm.n.b.ls(this.contact.field_type))
        {
          ad.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          dcv();
          break label642;
        }
        this.screen.cE("contact_info_time_expired", true);
        break label642;
        label2238:
        this.screen.cE("contact_info_time_expired", true);
        break label672;
        label2255:
        this.screen.cE("contact_info_service_phone", true);
        continue;
        label2272:
        this.screen.cE("contact_info_time_expired", true);
        ad.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).Gfe = false;
        ((KeyValuePreference)localObject2).FNA = this.imP.getString(2131757694);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, this.contact.signature));
        ((KeyValuePreference)localObject2).vR(false);
        if (ar.a.gMY != null)
        {
          localObject1 = BackwardSupportUtil.b.n(ar.a.gMY.nd(this.contact.field_verifyFlag), 2.0F);
          label2369:
          if (localObject1 != null) {
            break label2450;
          }
          bool = true;
          label2377:
          ad.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5309;
          }
        }
      }
      label4152:
      label4282:
      label5309:
      for (localObject1 = new BitmapDrawable(this.imP.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).Gfl = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).Gfj = 8;
        ((KeyValuePreference)localObject2).Yb(8);
        break;
        localObject1 = null;
        break label2369;
        bool = false;
        break label2377;
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.cE("contact_info_user_desc", true);
        if (this.uBs) {
          break;
        }
        this.screen.cE("contact_info_time_expired", true);
        break;
        label2502:
        ((KeyValuePreference)localObject6).FNA = ((c.b.e)localObject4).cJd;
        break label956;
        label2515:
        localObject1 = null;
        break label983;
        label2521:
        bool = false;
        break label1014;
        ad.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1139;
        ad.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1146;
        this.screen.cE("contact_info_verifyuser", true);
        break label1146;
        if ((this.cIf != null) && (this.cIf.JB() != null) && (!bt.isNullOrNil(this.cIf.JB().cJl)))
        {
          localObject1 = (KeyValuePreference)this.screen.aKk("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1146;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cIf.JB().cJl);
          break label1146;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.cE("contact_info_verifyuser", true);
        break label1146;
        label2686:
        localObject1 = null;
        break label1208;
        bool = false;
        break label1216;
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.cE("contact_info_trademark", true);
        break label1310;
        this.screen.cE("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.cIe != null) && (this.cIe.size() > 0)) {
          i = this.cIe.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.cIe.get(i) != null) && ((!this.imP.getString(2131757619).equals(((c.a)this.cIe.get(i)).title)) || (this.cIm)) && ((!bt.isNullOrNil(((c.a)this.cIe.get(i)).title)) || (!bt.isNullOrNil(((c.a)this.cIe.get(i)).cIi))))
          {
            localObject5 = new Preference(this.imP);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.cIe.get(i)).title;
            j = this.imP.getResources().getIdentifier(((c.a)this.cIe.get(i)).cIi, "string", this.imP.getPackageName());
            if (j > 0) {
              localObject1 = this.imP.getString(j);
            }
            localObject2 = localObject1;
            if (this.uzN.Jd()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cIe.get(i)).cIi))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.imP.getString(2131755016))) {}
              }
              else
              {
                localObject2 = this.imP.getString(2131758428);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bt.isNullOrNil(((c.a)this.cIe.get(i)).description)) {
              ((Preference)localObject5).setSummary(((c.a)this.cIe.get(i)).description);
            }
            if (!bt.nullAsNil(((c.a)this.cIe.get(i)).cIi).equals("__mp_wording__brandinfo_feedback")) {
              break label5285;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5285;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (bt.nullAsNil(((c.a)this.cIe.get(i)).cIi).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.imP);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          ad.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.uBs) && (w.C(this.contact)) && (this.contact.evD != null) && (!this.contact.evD.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.aKk("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bt.by(this.contact.field_weiboNickname, "") + this.imP.getString(2131763406, new Object[] { w.tv(this.contact.evD) }));
            ((Preference)localObject1).nJy = com.tencent.mm.cd.a.n(this.imP, 2131100547);
            ((KeyValuePreference)localObject1).vR(false);
          }
          if ((this.cIf == null) || (this.cIf.Jx() == null)) {
            break label4203;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aKk("contact_info_reputation");
          if (this.cIf.Jx().cJg <= 0) {
            break label4152;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Jg(this.cIf.Jx().cJg);
          label3443:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aKk("contact_info_guarantee_info");
          if ((this.cIf.Jx().cJi == null) || (this.cIf.Jx().cJi.size() <= 0)) {
            break label4169;
          }
          ((BizInfoPayInfoIconPreference)localObject1).ex(this.cIf.Jx().cJi);
          localObject1 = (KeyValuePreference)this.screen.aKk("contact_info_scope_of_business");
          if (bt.isNullOrNil(this.cIf.Jx().cJh)) {
            break label4186;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cIf.Jx().cJh);
          ((KeyValuePreference)localObject1).Gfj = 4;
          ((KeyValuePreference)localObject1).vR(false);
          label3566:
          if ((this.uBq == null) || (this.uBq.size() <= 0)) {
            break label4248;
          }
          this.screen.cE("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.aKk("contact_info_bindwxainfo")).a(this.uzN, this.uBq);
          akE(this.imP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          ad.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.imP.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.imP.getIntent() == null) || (!this.imP.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4570;
          }
          ad.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = dcx();
          ad.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ls(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.n.b.ls(this.contact.field_type)) || (!bool)) {
            break label4401;
          }
          if (localc == null) {
            break label4356;
          }
          localObject1 = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
          if (!localc.Jg()) {
            break label4282;
          }
          localObject5 = com.tencent.mm.am.af.awi().eb(localc.field_username);
          this.uBp = com.tencent.mm.am.af.awi().ea((String)localObject5);
          if (this.uBp == null) {
            break label4271;
          }
          if (this.uBp.ht(4)) {
            break label4265;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).lG = bool;
          if (!localc.IW()) {
            break label4312;
          }
          if ((this.cIf == null) && (localc != null)) {
            this.cIf = localc.bU(false);
          }
          if ((this.cIf == null) || (!this.cIf.Jq()) || (!com.tencent.mm.bs.d.axB("brandservice"))) {
            break label4295;
          }
          this.screen.cE("contact_info_template_recv", false);
          label3939:
          if (!localc.bU(false).Ja()) {
            break label4329;
          }
          ((CheckBoxPreference)localObject2).lG = localc.IX();
        }
        for (;;)
        {
          this.screen.cE("contact_info_biz_read_msg_online", true);
          this.screen.cE("contact_info_biz_add", true);
          localObject1 = this.contact.ZX();
          if (localObject1 != null) {
            this.imP.setMMTitle((String)localObject1);
          }
          if (w.sQ(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.aKk("contact_info_biz_go_chatting")).fU(this.imP.getResources().getString(2131757806), this.imP.getResources().getColor(2131100035));
            this.imP.setMMTitle(2131757883);
          }
          if ((!w.tl(this.contact.field_username)) && (this.uzN != null) && (!this.uzN.Jf())) {
            this.imP.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
          this.screen.cE("contact_info_verifyuser_weibo", true);
          break;
          this.screen.cE("contact_info_reputation", true);
          break label3443;
          label4169:
          this.screen.cE("contact_info_guarantee_info", true);
          break label3506;
          label4186:
          this.screen.cE("contact_info_scope_of_business", true);
          break label3566;
          label4203:
          this.screen.cE("contact_info_reputation", true);
          this.screen.cE("contact_info_guarantee_info", true);
          this.screen.cE("contact_info_scope_of_business", true);
          break label3566;
          this.screen.cE("contact_info_bindwxainfo", true);
          break label3625;
          bool = false;
          break label3862;
          ad.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label3869;
          ((CheckBoxPreference)localObject1).lG = localc.IW();
          break label3869;
          label4295:
          this.screen.cE("contact_info_template_recv", true);
          break label3939;
          label4312:
          this.screen.cE("contact_info_template_recv", true);
          break label3939;
          label4329:
          this.screen.cE("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).lG = localc.IX();
          continue;
          this.screen.cE("contact_info_subscribe_bizinfo", true);
          this.screen.cE("contact_info_locate", true);
          this.screen.cE("contact_info_template_recv", true);
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        dcv();
        localObject1 = this.screen.aKk("contact_info_biz_add");
        ad.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.uBt) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131757603);
          }
        }
        else if (Jr(this.ima))
        {
          if (localc != null) {
            break label4530;
          }
          ad.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.imP.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(2131757596);
          break;
          ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = localc.IW();
          this.screen.cE("contact_info_subscribe_bizinfo", false);
        }
        label4570:
        if (com.tencent.mm.n.b.ls(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
            if (localc.Jg())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758433);
              localObject5 = com.tencent.mm.am.af.awi().eb(localc.field_username);
              this.uBp = com.tencent.mm.am.af.awi().ea((String)localObject5);
              if (this.uBp != null) {
                if (!this.uBp.ht(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).lG = bool;
                  if (!localc.IW()) {
                    break label5053;
                  }
                  if ((this.cIf == null) && (localc != null)) {
                    this.cIf = localc.bU(false);
                  }
                  if ((this.cIf == null) || (!this.cIf.Jq()) || (!com.tencent.mm.bs.d.axB("brandservice"))) {
                    break label5036;
                  }
                  this.screen.cE("contact_info_template_recv", false);
                  if (!localc.bU(false).Ja()) {
                    break label5070;
                  }
                  ((CheckBoxPreference)localObject2).lG = localc.IX();
                }
              }
            }
          }
          for (;;)
          {
            this.screen.cE("contact_info_biz_read_msg_online", true);
            this.screen.cE("contact_info_biz_add", true);
            localObject1 = this.contact.ZX();
            if (localObject1 != null) {
              this.imP.setMMTitle((String)localObject1);
            }
            if (w.sQ(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.aKk("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).GdV = true;
              ((ButtonPreference)localObject1).fU(this.imP.getResources().getString(2131757806), this.imP.getResources().getColor(2131100035));
              this.imP.setMMTitle(2131757883);
            }
            if ((!w.tl(this.contact.field_username)) && (this.uzN != null)) {
              this.imP.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
            ad.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label4691;
            if (localc.Je())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131761483);
              if (!com.tencent.mm.am.af.awn().wx(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).lG = bool;
                break;
              }
            }
            ((CheckBoxPreference)localObject1).lG = localc.IW();
            break label4691;
            this.screen.cE("contact_info_template_recv", true);
            break label4761;
            this.screen.cE("contact_info_template_recv", true);
            break label4761;
            this.screen.cE("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).lG = localc.IX();
            continue;
            this.screen.cE("contact_info_subscribe_bizinfo", true);
            this.screen.cE("contact_info_locate", true);
            this.screen.cE("contact_info_template_recv", true);
          }
        }
        label4691:
        ad.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        label5053:
        label5070:
        dcv();
        localObject1 = this.screen.aKk("contact_info_biz_add");
        if ((localObject1 != null) && (this.uBt)) {
          ((Preference)localObject1).setTitle(2131757603);
        }
        if (Jr(this.ima))
        {
          if (localc != null) {
            break label5240;
          }
          ad.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.imP.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          label5240:
          ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = localc.IW();
          this.screen.cE("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1139;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void dcv()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.n.b.ls(this.contact.field_type)) && (!w.sQ(this.contact.field_username)) && (!w.tw(this.contact.field_username)))
    {
      this.screen.cE("contact_is_mute", false);
      this.screen.cE("contact_info_verifyuser_weibo", true);
      this.screen.cE("contact_info_subscribe_bizinfo", true);
      this.screen.cE("contact_info_template_recv", true);
      this.screen.cE("contact_info_locate", true);
      if (this.uBs) {
        break label315;
      }
      this.screen.cE("contact_info_time_expired", true);
      label143:
      if ((this.contact == null) || ((!w.tl(this.contact.field_username)) && (!w.tw(this.contact.field_username))) || (!com.tencent.mm.n.b.ls(this.contact.field_type))) {
        break label332;
      }
      this.screen.cE("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (w.tw(this.contact.field_username)) {
        this.screen.cE("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.cE("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.n.b.ls(this.contact.field_type)) && (Jr(this.ima)))
      {
        this.screen.cE("contact_info_expose_btn", false);
        break;
      }
      this.screen.cE("contact_info_expose_btn", true);
      break;
      label315:
      this.screen.cE("contact_info_biz_add", true);
      break label143;
      label332:
      this.screen.cE("contact_info_biz_go_chatting", true);
    }
  }
  
  private boolean dcx()
  {
    AppMethodBeat.i(27102);
    if (this.imP.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.imP.getIntent().getStringExtra("device_id");
    String str2 = this.imP.getIntent().getStringExtra("device_type");
    dn localdn = new dn();
    localdn.dfH.cLR = str1;
    localdn.dfH.dfF = str2;
    com.tencent.mm.sdk.b.a.ESL.l(localdn);
    boolean bool = localdn.dfI.dfJ;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void dcz()
  {
    AppMethodBeat.i(27111);
    ad.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.imP.getSharedPreferences(this.imP.getPackageName() + "_preferences", 0);
    }
    if (this.fpZ != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.ZS()).commit();
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
  
  private void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.imP != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.am.f.pc(this.contact.field_username))) {
          break label77;
        }
        this.imP.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aKk("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.lG = paramBoolean;
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.imP.setTitleMuteIconVisibility(8);
    }
  }
  
  public final boolean SN(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.imP).hX(this.contact.evD, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.uBA != null)
      {
        paramString = new qc();
        this.uBA.hsX = 5;
        paramString.dvG.dvH = this.uBA;
        com.tencent.mm.sdk.b.a.ESL.l(paramString);
      }
      if ((this.uzN != null) && ((this.uzN.Je()) || (this.uzN.Jg())))
      {
        paramString = new Intent();
        if (this.uzN.Jg())
        {
          localObject1 = this.uzN.Jm();
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", v.sh((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.bs.d.e(this.imP, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.imP.finish();
        }
      }
      for (;;)
      {
        br(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", v.sh(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.imP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.uzZ)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.imP.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.hYt.d(paramString, this.imP);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.atn()) {
        dcw();
      }
      for (;;)
      {
        if (this.uBv != 0) {
          com.tencent.mm.plugin.report.service.h.vKh.f(11263, new Object[] { Integer.valueOf(this.uBv), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.imP, com.tencent.mm.model.gdpr.a.gQa, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void ns(int paramAnonymousInt)
          {
            AppMethodBeat.i(27075);
            if (paramAnonymousInt == 0) {
              c.this.dcw();
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
      if (((CheckBoxPreference)this.screen.aKk("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.ima) });
        com.tencent.mm.model.j.rI(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        w.D(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.ima) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.cIf.Jx() != null) && (!bt.isNullOrNil(this.cIf.Jx().cJj)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.cIf.Jx().cJj);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.bs.d.b(this.imP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = bt.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.cIe.size()))
      {
        paramString = (c.a)this.cIe.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.uBz != null) && ((this.ima == 39) || (this.ima == 56) || (this.ima == 35))) || (this.ima == 87) || (this.ima == 89) || (this.ima == 85) || (this.ima == 88))
        {
          ad.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.uBz);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
            break label1169;
          }
        }
        label1169:
        for (i = 7;; i = 6)
        {
          int j = this.imP.getResources().getIdentifier(paramString.cIi, "string", this.imP.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.imP.getString(j);
          }
          br(i, paramString);
          com.tencent.mm.bs.d.b(this.imP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
      localObject1 = this.uzN;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).Jd()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).Jg()) {
              break label1393;
            }
            az.aeS().a(1363, this);
            if (!((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1388;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            az.aeS().a(paramString, 0);
            localObject2 = this.imP;
            this.imP.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.imP.getString(2131755936), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).Jg()) && (!((com.tencent.mm.api.c)localObject1).Je())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).Je())
        {
          paramString = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
          com.tencent.mm.am.af.awn();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.am.d.a((String)localObject2, bool, this);
            localObject2 = this.imP;
            this.imP.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.imP.getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                com.tencent.mm.am.af.awn();
                com.tencent.mm.am.d.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).IW())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.cIf == null) && (localObject1 != null)) {
              this.cIf = ((com.tencent.mm.api.c)localObject1).bU(false);
            }
            if ((this.cIf != null) && (this.cIf.Jq()) && (com.tencent.mm.bs.d.axB("brandservice")))
            {
              this.screen.cE("contact_info_template_recv", false);
              label1584:
              paramString = com.tencent.mm.plugin.report.service.h.vKh;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).IW()) {
                break label1709;
              }
            }
          }
          label1709:
          for (i = 3;; i = 4)
          {
            paramString.f(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.ima) });
            break;
            this.screen.cE("contact_info_template_recv", true);
            break label1584;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.cE("contact_info_template_recv", true);
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
            if (((com.tencent.mm.api.c)localObject1).IX()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.uBy = com.tencent.mm.ui.base.h.a(this.imP, this.imP.getString(2131757139, new Object[] { this.contact.ZX() }), this.imP.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.cNV.field_hadAlert = 1;
                  this.cNV.field_brandFlag |= 0x4;
                  c.this.a(this.cNV, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.cNV.field_hadAlert = 1;
                  c.this.a(this.cNV, false);
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
      paramString = this.uzN;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.bU(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((c.b)localObject2).Jz() != null) && (!bt.isNullOrNil(((c.b)localObject2).Jz().cJe))) {
        paramString = ((c.b)localObject2).Jz().cJe;
      }
      for (;;)
      {
        if (!bt.isNullOrNil(paramString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramString);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          ((Intent)localObject1).putExtra("geta8key_scene", 3);
          com.tencent.mm.bs.d.b(this.imP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).JB() != null)
        {
          paramString = (String)localObject1;
          if (!bt.isNullOrNil(((c.b)localObject2).JB().cJm)) {
            paramString = ((c.b)localObject2).JB().cJm;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.uzN;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.bU(false) != null) && (!bt.isNullOrNil(paramString.bU(false).Js())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.bU(false).Js());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.bs.d.b(this.imP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.fqj)
      {
        bool = true;
        this.fqj = bool;
        if (!this.fqj) {
          break label2687;
        }
        w.s(this.contact);
        label2246:
        nX(this.fqj);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.imP != null) {
          break label2697;
        }
        ad.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2279:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.imP.getString(2131758435);
        localObject2 = this.imP.getString(2131758434);
        com.tencent.mm.ui.base.h.d(this.imP, (String)localObject1, "", (String)localObject2, this.imP.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            c.this.nW(false);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        nW(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.uzN.field_username);
        com.tencent.mm.bs.d.b(this.imP, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.aKk("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bt.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.imP, true, (String)localObject1, "", this.imP.getString(2131757643), this.imP.getString(2131755691), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        dcy();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        ad.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.imP.getSharedPreferences(this.imP.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.ZS()) {
            break label2767;
          }
          ad.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          w.D(this.contact.field_username, true);
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
      if (this.uzN == null)
      {
        ad.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2279;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.uzN.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bs.d.b(this.imP, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2279;
      label2767:
      com.tencent.mm.model.j.rI(this.contact.field_username);
      ad.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(27110);
    if ((this.uzN == null) || (!this.uzN.Jg()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramn.getType() == 1354)
    {
      paramn = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
      String str = com.tencent.mm.am.af.awi().eb(this.uzN.field_username);
      this.uBp = com.tencent.mm.am.af.awi().ea(str);
      if (this.uBp != null)
      {
        if (!this.uBp.ht(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramn.lG = bool;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(27110);
          return;
        }
      }
      ad.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(27110);
  }
  
  final void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
    bqc localbqc = new bqc();
    localbqc.ika = paramc.field_brandFlag;
    localbqc.mAQ = this.contact.field_username;
    if (Jr(this.ima))
    {
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(58, localbqc));
    }
    for (;;)
    {
      com.tencent.mm.am.af.awe().update(paramc, new String[0]);
      localCheckBoxPreference1.lG = paramc.IW();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.lG = paramc.IX();
      }
      if (paramBoolean) {
        dcu();
      }
      AppMethodBeat.o(27092);
      return;
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(47, localbqc));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
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
      this.contact = paramaf;
      this.uzZ = paramBoolean;
      this.ima = paramInt;
      this.uBv = this.imP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.uBA = ((SnsAdClick)this.imP.getIntent().getParcelableExtra("KSnsAdTag"));
      this.uBz = this.imP.getIntent().getBundleExtra("Contact_Ext_Args");
      this.uBB = this.imP.getIntent().getStringExtra("key_add_contact_report_info");
      dcu();
      paramf = this.imP.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bt.isNullOrNil(paramf))
      {
        this.imP.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.imP, paramf, "", this.imP.getString(2131755835), null);
      }
      if (paramaf != null)
      {
        com.tencent.mm.am.af.awq().ws(paramaf.field_username);
        if (com.tencent.mm.am.f.wJ(paramaf.field_username))
        {
          paramf = paramaf.field_username;
          if (!com.tencent.mm.am.f.pc(paramf)) {
            break label301;
          }
          com.tencent.mm.am.af.awm();
          com.tencent.mm.am.a.h.a(paramf, this);
          paramf = com.tencent.mm.am.f.ei(paramf).Jm();
          if (paramf != null) {
            com.tencent.mm.am.af.awq().ws(paramf);
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
      if (com.tencent.mm.am.f.wL(paramf))
      {
        com.tencent.mm.am.af.awn();
        com.tencent.mm.am.d.a(paramf, this);
        com.tencent.mm.am.af.awe();
        paramf = com.tencent.mm.am.e.wC(paramf);
        if (paramf != null) {
          com.tencent.mm.am.af.awq().ws(paramf);
        }
      }
    }
  }
  
  public final String avQ()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.aKk("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  final void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.uBz == null) || ((this.ima != 39) && (this.ima != 56) && (this.ima != 35) && (this.ima != 87) && (this.ima != 88) && (this.ima != 89) && (this.ima != 85)))
    {
      ad.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27100);
      return;
    }
    if (this.contact == null)
    {
      ad.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      AppMethodBeat.o(27100);
      return;
    }
    String str2 = this.uBz.getString("Contact_Ext_Args_Search_Id");
    String str3 = bt.nullAsNil(this.uBz.getString("Contact_Ext_Args_Query_String"));
    int j = this.uBz.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.ima)
    {
    default: 
      i = 0;
      str1 = bt.nullAsNil(this.uBz.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bt.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bt.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ad.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10866, paramString);
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
  
  final void dcw()
  {
    AppMethodBeat.i(27101);
    if ((this.imP.getIntent() != null) && (this.imP.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.imP.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bt.isNullOrNil((String)localObject1)) {
        break label163;
      }
      ad.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (dcx())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.imP, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(27077);
          com.tencent.mm.storage.af localaf;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cf(c.this.imP, c.this.imP.getString(2131757590));
            c.this.screen.cE("contact_info_time_expired", true);
            localaf = c.this.contact;
            if ((localaf == null) || (bt.isNullOrNil(paramAnonymousString1)))
            {
              ad.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localaf);
              c.this.uBu = true;
              if (c.this.uBA != null)
              {
                paramAnonymousString1 = new qc();
                c.this.uBA.hsX = 4;
                paramAnonymousString1.dvG.dvH = c.this.uBA;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString1);
              }
              paramAnonymousString1 = com.tencent.mm.am.af.awe().wy(c.this.contact.field_username);
              paramAnonymousString1.field_status = 1;
              if ((!bt.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bt.isNullOrNil(paramAnonymousString1.field_username)) || (c.this.uzN == null) || (!paramAnonymousString1.field_username.equals(bt.nullAsNil(c.this.uzN.field_username)))) {
                break label675;
              }
              com.tencent.mm.am.af.awe().g(c.this.uzN);
              label249:
              paramAnonymousBoolean1 = c.this.imP.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
              paramAnonymousBoolean2 = c.this.imP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
              if (!paramAnonymousString1.Je()) {
                break label686;
              }
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("enterprise_biz_name", c.this.contact.field_username);
              paramAnonymousString1.putExtra("enterprise_biz_display_name", v.sh(c.this.contact.field_username));
              paramAnonymousString1.putExtra("enterprise_from_scene", 7);
              paramAnonymousString1.addFlags(67108864);
              com.tencent.mm.bs.d.e(c.this.imP, ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
              label364:
              c.this.imP.finish();
              label374:
              c.this.br(3, null);
            }
          }
          else
          {
            AppMethodBeat.o(27077);
            return;
          }
          if (w.sC(localaf.field_username))
          {
            String str = bt.nullAsNil(localaf.field_username);
            paramAnonymousString2 = com.tencent.mm.am.f.ei(str);
            if (paramAnonymousString2 != null) {
              paramAnonymousString2.field_username = paramAnonymousString1;
            }
            com.tencent.mm.am.af.awe().delete(str);
            localaf.nj(str);
          }
          for (;;)
          {
            localaf.setUsername(paramAnonymousString1);
            if ((int)localaf.fId == 0)
            {
              az.arV();
              com.tencent.mm.model.c.apM().ag(localaf);
            }
            if ((int)localaf.fId <= 0)
            {
              ad.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
              break;
            }
            w.u(localaf);
            az.arV();
            paramAnonymousString1 = com.tencent.mm.model.c.apM().aHY(localaf.field_username);
            if (paramAnonymousString2 != null)
            {
              com.tencent.mm.am.af.awe().f(paramAnonymousString2);
              break;
            }
            paramAnonymousString2 = com.tencent.mm.am.f.ei(paramAnonymousString1.field_username);
            if ((paramAnonymousString1.eKB()) && (com.tencent.mm.am.a.avv())) {}
            for (int i = 1;; i = 0)
            {
              if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.IY()) || (i != 0))) {
                break label616;
              }
              ad.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
              ar.a.gMW.aB(paramAnonymousString1.field_username, "");
              com.tencent.mm.ak.c.vO(paramAnonymousString1.field_username);
              break;
            }
            label616:
            if ((!paramAnonymousString1.eKF()) || (i != 0)) {
              break;
            }
            ad.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.evG) });
            ar.a.gMW.aB(paramAnonymousString1.field_username, "");
            com.tencent.mm.ak.c.vO(paramAnonymousString1.field_username);
            break;
            label675:
            com.tencent.mm.am.af.awe().g(paramAnonymousString1);
            break label249;
            label686:
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("Chat_User", c.this.contact.field_username);
            paramAnonymousString1.putExtra("key_has_add_contact", true);
            paramAnonymousString1.putExtra("finish_direct", true);
            if (paramAnonymousBoolean2) {
              paramAnonymousString1.addFlags(268435456);
            }
            com.tencent.mm.plugin.profile.b.hYt.d(paramAnonymousString1, c.this.imP);
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
      ((LinkedList)localObject2).add(Integer.valueOf(this.ima));
      if (this.cIo != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXu = this.cIo;
      }
      if (!bt.isNullOrNil(this.rso)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).rso = this.rso;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXA = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.uBB);
      AppMethodBeat.o(27101);
      return;
    }
    ad.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    az.aeS().a(536, this);
    Object localObject2 = new dj();
    ((dj)localObject2).dfw.dfy = ((String)localObject1);
    ((dj)localObject2).dfw.opType = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dj)localObject2).dfx.dfA;
    localObject2 = this.imP;
    this.imP.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.imP.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(27076);
        az.aeS().b(536, c.this);
        paramAnonymousDialogInterface = new dj();
        paramAnonymousDialogInterface.dfw.opType = 2;
        paramAnonymousDialogInterface.dfw.dfA = this.cZL;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(27076);
      }
    });
    AppMethodBeat.o(27101);
  }
  
  final void dcy()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (bt.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.bs.d.b(this.imP, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  public final void e(LinkedList<dtt> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    com.tencent.mm.am.af.awf().b(this);
    if (this.screen == null)
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (this.contact == null)
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27109);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (!bt.isNullOrNil(this.uBw))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dtt localdtt = (dtt)((Iterator)localObject).next();
        if ((localdtt.EIs != null) && (localdtt.EIs.equals(this.uBw)))
        {
          this.screen.cE("contact_info_kf_worker", false);
          this.screen.aKk("contact_info_kf_worker").setSummary(localdtt.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.cE("contact_info_kf_worker", false);
    Object localObject = this.screen.aKk("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((dtt)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  final void nW(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.uzN.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      az.aeS().a(1394, this);
      az.aeS().a((n)localObject, 0);
      MMActivity localMMActivity = this.imP;
      this.imP.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.imP.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          az.aeS().a(this.mUL);
          az.aeS().b(1394, c.this);
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
    if (this.imP == null)
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "null == context");
      AppMethodBeat.o(27098);
      return;
    }
    ad.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.j.cOB().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.j.cOB().hm(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.imP, this.imP.getString(2131759420));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    ad.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.uBx = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    az.aeS().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    ad.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      az.aeS().b(536, this);
      dcu();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (crf)paramString.rr.gUT.gUX;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramn;
        paramn = (n)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramn = (n)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.gUS.gUX != null) {
            paramn = (cre)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.gUS.gUX;
          }
        }
        if ((paramString != null) && (paramString.CIW != null) && (paramString.CIW.ret == 0) && (paramString.CIT != null) && (!bt.isNullOrNil(paramString.CIT.CIR))) {
          break label413;
        }
        if ((paramString == null) || (paramString.CIW == null)) {
          break;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.CIW.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.CIT == null)
      {
        ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = com.tencent.mm.am.af.awi().ea(paramString.CIT.CIR);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.am.a.k();
        ((com.tencent.mm.am.a.k)localObject1).field_userId = paramString.CIT.CIR;
      }
      ((com.tencent.mm.am.a.k)localObject1).field_userName = paramString.CIT.nvC;
      ((com.tencent.mm.am.a.k)localObject1).field_brandUserName = paramn.CIQ;
      ((com.tencent.mm.am.a.k)localObject1).field_UserVersion = paramString.CIT.ver;
      ((com.tencent.mm.am.a.k)localObject1).field_headImageUrl = paramString.CIT.CIK;
      ((com.tencent.mm.am.a.k)localObject1).field_profileUrl = paramString.CIT.CIZ;
      ((com.tencent.mm.am.a.k)localObject1).field_bitFlag = paramString.CIT.CIL;
      ((com.tencent.mm.am.a.k)localObject1).field_addMemberUrl = paramString.CIT.CIO;
      ((com.tencent.mm.am.a.k)localObject1).field_needToUpdate = false;
      if (!com.tencent.mm.am.af.awi().b((com.tencent.mm.am.a.k)localObject1)) {
        com.tencent.mm.am.af.awi().a((com.tencent.mm.am.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dcg();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramn).dcf();
      if ((localObject1 == null) || (((dae)localObject1).CIW == null) || (((dae)localObject1).CIW.ret != 0))
      {
        if ((localObject1 != null) && (((dae)localObject1).CIW != null))
        {
          ad.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dae)localObject1).CIW.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.kRX)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.uzN;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        az.arV();
        if (com.tencent.mm.model.c.apR().aIn(paramString.field_username) == null)
        {
          paramn = new am(paramString.field_username);
          paramn.nN(bt.nullAsNil(this.uzN.Jm()));
          az.arV();
          localObject1 = com.tencent.mm.model.c.apO().agq(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          az.arV();
          com.tencent.mm.model.c.apR().e(paramn);
          az.arV();
          com.tencent.mm.model.c.apR().aH((bl)localObject1);
        }
      }
      for (;;)
      {
        az.arV();
        if (com.tencent.mm.model.c.apR().aIn(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new am(paramString.field_enterpriseFather);
        paramString.eLf();
        az.arV();
        com.tencent.mm.model.c.apR().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramn.eLf();
        az.arV();
        com.tencent.mm.model.c.apR().e(paramn);
      }
      label954:
      az.arV();
      com.tencent.mm.model.c.apQ().aHp(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.uzN;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      az.arV();
      com.tencent.mm.model.c.apR().aIl(paramString.field_username);
      az.arV();
      if (com.tencent.mm.model.c.apR().aIy(paramString.field_enterpriseFather) <= 0)
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIl(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      az.arV();
      com.tencent.mm.model.c.apQ().aHp(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1343)
    {
      dcu();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1228) {
      dcu();
    }
    AppMethodBeat.o(27108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */