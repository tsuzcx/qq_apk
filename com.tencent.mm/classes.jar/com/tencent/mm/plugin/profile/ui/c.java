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
import com.tencent.mm.al.q;
import com.tencent.mm.am.af;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  implements com.tencent.mm.al.f, i.b, com.tencent.mm.am.p, com.tencent.mm.pluginsdk.b.a
{
  private String cQA;
  private List<c.a> cQq;
  private c.b cQr;
  private boolean cQy = false;
  am contact;
  MMActivity fLP;
  private CheckBoxPreference fMF;
  private boolean fMP;
  boolean isDeleteCancel = false;
  private int jfq;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  com.tencent.mm.ui.base.p tipDialog = null;
  String txJ;
  com.tencent.mm.api.c wPN;
  private boolean wPZ;
  private String wQe;
  com.tencent.mm.ui.widget.a.d wRA = null;
  private Bundle wRB;
  SnsAdClick wRC = null;
  private String wRD = null;
  private com.tencent.mm.am.a.k wRr;
  private List<WxaAttributes.WxaEntryInfo> wRs;
  private acf wRt = null;
  private boolean wRu = false;
  private boolean wRv = false;
  boolean wRw = false;
  private int wRx = 0;
  private String wRy;
  private boolean wRz;
  
  private c(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, acf paramacf)
  {
    this(paramMMActivity);
    this.wQe = paramString;
    this.wRt = paramacf;
  }
  
  private String MR(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      ad.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.fLP.getResources().getString(2131757694);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.fLP.getResources().getString(2131757895);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.fLP.getResources().getString(2131756745);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.fLP.getResources().getString(2131756746);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean MS(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static boolean auI(String paramString)
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
  
  private void auJ(String paramString)
  {
    AppMethodBeat.i(27105);
    ad.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.wRz) });
    if (this.wRz)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.wRy = paramString;
    if ((this.cQr == null) || (!this.cQr.KO()) || (this.contact == null))
    {
      this.screen.cP("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      paramString = ag.aFY().DX(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.cP("contact_info_kf_worker", true);
        ag.aGa().a(this);
        ag.aGa().ba(this.contact.field_username, u.aAm());
        this.wRz = true;
        AppMethodBeat.o(27105);
        return;
      }
      ad.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.cP("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aVD("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ak.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        auK(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).Z((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = ag.aFY();
    Object localObject1 = ((com.tencent.mm.am.j)localObject2).DW(paramString);
    if ((localObject1 == null) || (com.tencent.mm.am.j.a((com.tencent.mm.am.h)localObject1)))
    {
      ag.aGa().a(this);
      ag.aGa().k(this.contact.field_username, paramString, 1);
      this.wRz = true;
    }
    if (localObject1 == null) {
      ad.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.am.j)localObject2).DX(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.cP("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.cP("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aVD("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.ak.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        auK(paramString.field_openId);
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
  
  private void auK(String paramString)
  {
    AppMethodBeat.i(27106);
    aq.o(new c.11(this, paramString), 2000L);
    AppMethodBeat.o(27106);
  }
  
  private static void c(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.ak.j localj = com.tencent.mm.ak.p.aEx();
    if (localj.Dj(paramh.field_openId) == null)
    {
      com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
      locali.username = paramh.field_openId;
      locali.hMW = paramh.field_headImgUrl;
      locali.eB(false);
      locali.ePj = 3;
      localj.b(locali);
    }
    com.tencent.mm.ak.p.aEz().CV(paramh.field_openId);
    ad.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void dAF()
  {
    AppMethodBeat.i(27094);
    cdn();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951636);
    if (this.wRw) {
      this.screen.cP("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.am.g.eS(this.contact.field_username);
    this.cQq = null;
    this.cQr = null;
    this.wRs = null;
    if (((localc == null) || (localc.bX(false) == null)) && (this.wRt != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.wRt.jdq;
      localc.field_brandIconURL = this.wRt.jdt;
      localc.field_brandInfo = this.wRt.jds;
      localc.field_extInfo = this.wRt.jdr;
    }
    label528:
    label672:
    label1844:
    label5303:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.wRt != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.wRt.jdq;
        localc.field_brandIconURL = this.wRt.jdt;
        localc.field_brandInfo = this.wRt.jds;
        localc.field_extInfo = this.wRt.jdr;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.aVD("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!bt.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.wQe, localc);
        this.screen.cP("biz_placed_to_the_top", true);
        this.screen.cP("contact_info_biz_enable", true);
        this.screen.cP("contact_info_biz_disable", true);
        this.screen.cP("contact_info_stick_biz", true);
        if (localc == null) {
          break label2272;
        }
        if (!localc.Ko()) {
          break label1844;
        }
        this.screen.cP("contact_info_biz_add", true);
        this.screen.cP("contact_info_expose_btn", true);
        this.screen.cP("contact_is_mute", false);
        this.fMP = this.contact.Pf();
        if (!localc.Kp()) {
          break label1559;
        }
        this.screen.cP("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.o.b.lM(this.contact.field_type)) {
          break label1553;
        }
        bool = true;
        label474:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cP("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.aVD("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).oB = this.contact.adq();
        ((CheckBoxPreference)localObject1).setTitle(2131758432);
        dAK();
        pq(this.fMP);
        this.wPN = localc;
        this.cQq = localc.Kw();
        this.cQr = localc.bX(false);
        this.wRs = this.cQr.getWxaEntryInfoList();
        if (!this.cQr.Kx()) {
          break label2157;
        }
        this.screen.aVD("near_field_service").setSummary(2131766197);
        label600:
        if (this.cQr.KD() == null) {
          break label2238;
        }
        this.wRv = true;
        if (auI(this.cQr.KD())) {
          break label2174;
        }
        this.screen.cP("contact_info_time_expired", true);
        if ((w.Al(this.contact.field_username)) || (w.Ax(this.contact.field_username))) {
          dAG();
        }
        if ((this.cQr.KA() != null) && (this.cQr.KA().length() > 0)) {
          this.cQA = this.cQr.KA();
        }
        this.cQy = this.cQr.Ky();
        if (bt.isNullOrNil(this.cQr.KN())) {
          break label2255;
        }
        this.screen.cP("contact_info_service_phone", false);
        localObject1 = this.screen.aVD("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.cQr.KN());
          ((Preference)localObject1).oPT = this.fLP.getResources().getColor(2131100547);
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
          localObject2 = (KeyValuePreference)this.screen.aVD("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bt.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.cP("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.cQr == null) || (this.cQr.KI() == null) || (bt.isNullOrNil(this.cQr.KI().cRn))) {
              break label2588;
            }
            localObject4 = this.cQr.KI();
            localObject6 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2571;
            }
            ((KeyValuePreference)localObject6).JsK = false;
            if (!bt.isNullOrNil(((c.b.e)localObject4).cRo)) {
              break label2502;
            }
            ((KeyValuePreference)localObject6).JaR = MR(((c.b.e)localObject4).cRm);
            if (as.a.hFQ == null) {
              break label2515;
            }
            localObject1 = BackwardSupportUtil.b.o(as.a.hFQ.or(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5303;
            }
            localObject2 = new BitmapDrawable(this.fLP.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2521;
            }
            bool = true;
            ad.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).JsR = ((Drawable)localObject2);
            if (((c.b.e)localObject4).cRn == null) {
              break label2560;
            }
            localObject7 = ((c.b.e)localObject4).cRq;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, ((c.b.e)localObject4).cRn.trim());
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
          if ((this.cQr == null) || (bt.isNullOrNil(this.cQr.KC()))) {
            break label2698;
          }
          localObject2 = (KeyValuePreference)this.screen.aVD("contact_info_trademark");
          if (localObject2 == null) {
            break label1310;
          }
          ((KeyValuePreference)localObject2).JsK = false;
          if (as.a.hFQ == null) {
            break label2686;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.g.aat(2131689767);
          if (localObject1 != null) {
            break label2692;
          }
          bool = true;
          ad.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5290;
          }
          localObject1 = new BitmapDrawable(this.fLP.getResources(), (Bitmap)localObject1);
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
        ((KeyValuePreference)localObject2).JsR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cQr.KC());
        ad.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.cQr.KC(), this.cQr.KB() });
        if ((this.cQr == null) || (this.cQr.KE() == null) || (this.cQr.KE().size() <= 0)) {
          break label2723;
        }
        localObject2 = (KeyValuePreference)this.screen.aVD("contact_info_privilege");
        ((KeyValuePreference)localObject2).xG(false);
        ((KeyValuePreference)localObject2).fzE();
        localObject4 = this.cQr.KE().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.fLP, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.fLP.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.fLP.getResources().getIdentifier(((c.b.g)localObject7).cRv, "string", this.fLP.getPackageName());
          if (i > 0) {
            localObject1 = this.fLP.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).gi((View)localObject6);
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.cP("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.cP("contact_info_subscribe_bizinfo", true);
        this.screen.cP("contact_info_biz_go_chatting", true);
        if (localc.Kf())
        {
          this.screen.cP("contact_info_biz_enable", true);
          this.screen.cP("contact_info_biz_disable", false);
          this.screen.aVD("contact_info_biz_disable").setTitle(2131758434);
          this.screen.cP("contact_is_mute", false);
          this.screen.cP("biz_placed_to_the_top", false);
          this.fMF = ((CheckBoxPreference)this.screen.aVD("biz_placed_to_the_top"));
          this.fMF.setTitle(2131758450);
          dAK();
          if (!localc.Kq()) {
            break label528;
          }
          this.screen.cP("contact_info_locate", true);
          break label528;
        }
        this.screen.cP("contact_info_biz_enable", false);
        this.screen.cP("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.aVD("contact_info_biz_enable")).gv(this.fLP.getResources().getString(2131758436), this.fLP.getResources().getColor(2131100035));
        this.screen.cP("contact_is_mute", true);
        this.screen.cP("biz_placed_to_the_top", true);
        this.screen.cP("contact_info_locate", true);
        break label528;
        if (localc.Kn())
        {
          this.screen.cP("contact_info_locate", true);
          this.screen.cP("contact_info_subscribe_bizinfo", false);
          this.screen.cP("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.aVD("contact_info_biz_go_chatting")).gv(this.fLP.getResources().getString(2131758437), this.fLP.getResources().getColor(2131100035));
          localObject1 = this.screen;
          if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).cP("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.aVD("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).oB = this.contact.adq();
            ((CheckBoxPreference)localObject1).setTitle(2131758440);
            dAK();
            this.screen.cP("contact_is_mute", false);
            this.fMP = this.contact.Pf();
            pq(this.fMP);
            break;
          }
        }
        localObject1 = this.screen;
        if ((w.zQ(this.contact.field_username)) || (!com.tencent.mm.o.b.lM(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).cP("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.aVD("contact_info_stick_biz")).oB = this.contact.adq();
          this.screen.cP("contact_is_mute", true);
          this.fMP = false;
          break;
        }
        label2157:
        this.screen.cP("near_field_service", true);
        break label600;
        label2174:
        this.wRu = true;
        if (!com.tencent.mm.o.b.lM(this.contact.field_type))
        {
          ad.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          dAG();
          break label642;
        }
        this.screen.cP("contact_info_time_expired", true);
        break label642;
        label2238:
        this.screen.cP("contact_info_time_expired", true);
        break label672;
        label2255:
        this.screen.cP("contact_info_service_phone", true);
        continue;
        label2272:
        this.screen.cP("contact_info_time_expired", true);
        ad.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).JsK = false;
        ((KeyValuePreference)localObject2).JaR = this.fLP.getString(2131757694);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, this.contact.signature));
        ((KeyValuePreference)localObject2).xG(false);
        if (as.a.hFQ != null)
        {
          localObject1 = BackwardSupportUtil.b.o(as.a.hFQ.or(this.contact.field_verifyFlag), 2.0F);
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
      for (localObject1 = new BitmapDrawable(this.fLP.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).JsR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).JsP = 8;
        ((KeyValuePreference)localObject2).acw(8);
        break;
        localObject1 = null;
        break label2369;
        bool = false;
        break label2377;
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.cP("contact_info_user_desc", true);
        if (this.wRu) {
          break;
        }
        this.screen.cP("contact_info_time_expired", true);
        break;
        label2502:
        ((KeyValuePreference)localObject6).JaR = ((c.b.e)localObject4).cRo;
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
        this.screen.cP("contact_info_verifyuser", true);
        break label1146;
        if ((this.cQr != null) && (this.cQr.KJ() != null) && (!bt.isNullOrNil(this.cQr.KJ().cRw)))
        {
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1146;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cQr.KJ().cRw);
          break label1146;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.cP("contact_info_verifyuser", true);
        break label1146;
        label2686:
        localObject1 = null;
        break label1208;
        bool = false;
        break label1216;
        ad.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.cP("contact_info_trademark", true);
        break label1310;
        this.screen.cP("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.cQq != null) && (this.cQq.size() > 0)) {
          i = this.cQq.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.cQq.get(i) != null) && ((!this.fLP.getString(2131757619).equals(((c.a)this.cQq.get(i)).title)) || (this.cQy)) && ((!bt.isNullOrNil(((c.a)this.cQq.get(i)).title)) || (!bt.isNullOrNil(((c.a)this.cQq.get(i)).cQu))))
          {
            localObject5 = new Preference(this.fLP);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.cQq.get(i)).title;
            j = this.fLP.getResources().getIdentifier(((c.a)this.cQq.get(i)).cQu, "string", this.fLP.getPackageName());
            if (j > 0) {
              localObject1 = this.fLP.getString(j);
            }
            localObject2 = localObject1;
            if (this.wPN.Km()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cQq.get(i)).cQu))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.fLP.getString(2131755016))) {}
              }
              else
              {
                localObject2 = this.fLP.getString(2131758428);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bt.isNullOrNil(((c.a)this.cQq.get(i)).description)) {
              ((Preference)localObject5).setSummary(((c.a)this.cQq.get(i)).description);
            }
            if (!bt.nullAsNil(((c.a)this.cQq.get(i)).cQu).equals("__mp_wording__brandinfo_feedback")) {
              break label5285;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5285;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (bt.nullAsNil(((c.a)this.cQq.get(i)).cQu).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.fLP);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          ad.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.wRu) && (w.C(this.contact)) && (this.contact.ePy != null) && (!this.contact.ePy.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bt.bI(this.contact.field_weiboNickname, "") + this.fLP.getString(2131763406, new Object[] { w.Aw(this.contact.ePy) }));
            ((Preference)localObject1).oPT = com.tencent.mm.cc.a.n(this.fLP, 2131100547);
            ((KeyValuePreference)localObject1).xG(false);
          }
          if ((this.cQr == null) || (this.cQr.KG() == null)) {
            break label4203;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aVD("contact_info_reputation");
          if (this.cQr.KG().cRr <= 0) {
            break label4152;
          }
          ((BizInfoPayInfoIconPreference)localObject1).MH(this.cQr.KG().cRr);
          label3443:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aVD("contact_info_guarantee_info");
          if ((this.cQr.KG().cRt == null) || (this.cQr.KG().cRt.size() <= 0)) {
            break label4169;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eO(this.cQr.KG().cRt);
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_scope_of_business");
          if (bt.isNullOrNil(this.cQr.KG().cRs)) {
            break label4186;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cQr.KG().cRs);
          ((KeyValuePreference)localObject1).JsP = 4;
          ((KeyValuePreference)localObject1).xG(false);
          label3566:
          if ((this.wRs == null) || (this.wRs.size() <= 0)) {
            break label4248;
          }
          this.screen.cP("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.aVD("contact_info_bindwxainfo")).a(this.wPN, this.wRs);
          auJ(this.fLP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          ad.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.fLP.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.fLP.getIntent() == null) || (!this.fLP.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4570;
          }
          ad.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = dAI();
          ad.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.o.b.lM(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.o.b.lM(this.contact.field_type)) || (!bool)) {
            break label4401;
          }
          if (localc == null) {
            break label4356;
          }
          localObject1 = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
          if (!localc.Kp()) {
            break label4282;
          }
          localObject5 = ag.aGd().eL(localc.field_username);
          this.wRr = ag.aGd().eK((String)localObject5);
          if (this.wRr == null) {
            break label4271;
          }
          if (this.wRr.hj(4)) {
            break label4265;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).oB = bool;
          if (!localc.Kf()) {
            break label4312;
          }
          if ((this.cQr == null) && (localc != null)) {
            this.cQr = localc.bX(false);
          }
          if ((this.cQr == null) || (!this.cQr.Kz()) || (!com.tencent.mm.bs.d.aIu("brandservice"))) {
            break label4295;
          }
          this.screen.cP("contact_info_template_recv", false);
          label3939:
          if (!localc.bX(false).Kj()) {
            break label4329;
          }
          ((CheckBoxPreference)localObject2).oB = localc.Kg();
        }
        for (;;)
        {
          this.screen.cP("contact_info_biz_read_msg_online", true);
          this.screen.cP("contact_info_biz_add", true);
          localObject1 = this.contact.adv();
          if (localObject1 != null) {
            this.fLP.setMMTitle((String)localObject1);
          }
          if (w.zQ(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.aVD("contact_info_biz_go_chatting")).gv(this.fLP.getResources().getString(2131757806), this.fLP.getResources().getColor(2131100035));
            this.fLP.setMMTitle(2131757883);
          }
          if ((!w.Al(this.contact.field_username)) && (this.wPN != null) && (!this.wPN.Ko())) {
            this.fLP.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
          this.screen.cP("contact_info_verifyuser_weibo", true);
          break;
          this.screen.cP("contact_info_reputation", true);
          break label3443;
          label4169:
          this.screen.cP("contact_info_guarantee_info", true);
          break label3506;
          label4186:
          this.screen.cP("contact_info_scope_of_business", true);
          break label3566;
          label4203:
          this.screen.cP("contact_info_reputation", true);
          this.screen.cP("contact_info_guarantee_info", true);
          this.screen.cP("contact_info_scope_of_business", true);
          break label3566;
          this.screen.cP("contact_info_bindwxainfo", true);
          break label3625;
          bool = false;
          break label3862;
          ad.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label3869;
          ((CheckBoxPreference)localObject1).oB = localc.Kf();
          break label3869;
          label4295:
          this.screen.cP("contact_info_template_recv", true);
          break label3939;
          label4312:
          this.screen.cP("contact_info_template_recv", true);
          break label3939;
          label4329:
          this.screen.cP("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).oB = localc.Kg();
          continue;
          this.screen.cP("contact_info_subscribe_bizinfo", true);
          this.screen.cP("contact_info_locate", true);
          this.screen.cP("contact_info_template_recv", true);
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        dAG();
        localObject1 = this.screen.aVD("contact_info_biz_add");
        ad.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.wRv) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131757603);
          }
        }
        else if (MS(this.jfq))
        {
          if (localc != null) {
            break label4530;
          }
          ad.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.fLP.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(2131757596);
          break;
          ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = localc.Kf();
          this.screen.cP("contact_info_subscribe_bizinfo", false);
        }
        label4570:
        if (com.tencent.mm.o.b.lM(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
            if (localc.Kp())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758433);
              localObject5 = ag.aGd().eL(localc.field_username);
              this.wRr = ag.aGd().eK((String)localObject5);
              if (this.wRr != null) {
                if (!this.wRr.hj(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).oB = bool;
                  if (!localc.Kf()) {
                    break label5053;
                  }
                  if ((this.cQr == null) && (localc != null)) {
                    this.cQr = localc.bX(false);
                  }
                  if ((this.cQr == null) || (!this.cQr.Kz()) || (!com.tencent.mm.bs.d.aIu("brandservice"))) {
                    break label5036;
                  }
                  this.screen.cP("contact_info_template_recv", false);
                  if (!localc.bX(false).Kj()) {
                    break label5070;
                  }
                  ((CheckBoxPreference)localObject2).oB = localc.Kg();
                }
              }
            }
          }
          for (;;)
          {
            this.screen.cP("contact_info_biz_read_msg_online", true);
            this.screen.cP("contact_info_biz_add", true);
            localObject1 = this.contact.adv();
            if (localObject1 != null) {
              this.fLP.setMMTitle((String)localObject1);
            }
            if (w.zQ(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.aVD("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).JrA = true;
              ((ButtonPreference)localObject1).gv(this.fLP.getResources().getString(2131757806), this.fLP.getResources().getColor(2131100035));
              this.fLP.setMMTitle(2131757883);
            }
            if ((!w.Al(this.contact.field_username)) && (this.wPN != null)) {
              this.fLP.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
            if (localc.Kn())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131761483);
              if (!ag.aGi().DC(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).oB = bool;
                break;
              }
            }
            ((CheckBoxPreference)localObject1).oB = localc.Kf();
            break label4691;
            this.screen.cP("contact_info_template_recv", true);
            break label4761;
            this.screen.cP("contact_info_template_recv", true);
            break label4761;
            this.screen.cP("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).oB = localc.Kg();
            continue;
            this.screen.cP("contact_info_subscribe_bizinfo", true);
            this.screen.cP("contact_info_locate", true);
            this.screen.cP("contact_info_template_recv", true);
          }
        }
        label4691:
        ad.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        label5053:
        label5070:
        dAG();
        localObject1 = this.screen.aVD("contact_info_biz_add");
        if ((localObject1 != null) && (this.wRv)) {
          ((Preference)localObject1).setTitle(2131757603);
        }
        if (MS(this.jfq))
        {
          if (localc != null) {
            break label5240;
          }
          ad.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.fLP.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          label5240:
          ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = localc.Kf();
          this.screen.cP("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1139;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void dAG()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.o.b.lM(this.contact.field_type)) && (!w.zQ(this.contact.field_username)) && (!w.Ax(this.contact.field_username)))
    {
      this.screen.cP("contact_is_mute", false);
      this.screen.cP("contact_info_verifyuser_weibo", true);
      this.screen.cP("contact_info_subscribe_bizinfo", true);
      this.screen.cP("contact_info_template_recv", true);
      this.screen.cP("contact_info_locate", true);
      if (this.wRu) {
        break label315;
      }
      this.screen.cP("contact_info_time_expired", true);
      label143:
      if ((this.contact == null) || ((!w.Al(this.contact.field_username)) && (!w.Ax(this.contact.field_username))) || (!com.tencent.mm.o.b.lM(this.contact.field_type))) {
        break label332;
      }
      this.screen.cP("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (w.Ax(this.contact.field_username)) {
        this.screen.cP("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.cP("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.o.b.lM(this.contact.field_type)) && (MS(this.jfq)))
      {
        this.screen.cP("contact_info_expose_btn", false);
        break;
      }
      this.screen.cP("contact_info_expose_btn", true);
      break;
      label315:
      this.screen.cP("contact_info_biz_add", true);
      break label143;
      label332:
      this.screen.cP("contact_info_biz_go_chatting", true);
    }
  }
  
  private boolean dAI()
  {
    AppMethodBeat.i(27102);
    if (this.fLP.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.fLP.getIntent().getStringExtra("device_id");
    String str2 = this.fLP.getIntent().getStringExtra("device_type");
    dr localdr = new dr();
    localdr.doy.cUi = str1;
    localdr.doy.dow = str2;
    com.tencent.mm.sdk.b.a.IbL.l(localdr);
    boolean bool = localdr.doz.doA;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void dAK()
  {
    AppMethodBeat.i(27111);
    ad.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.fLP.getSharedPreferences(this.fLP.getPackageName() + "_preferences", 0);
    }
    if (this.fMF != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.adq()).commit();
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
  
  private void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.fLP != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.am.g.vd(this.contact.field_username))) {
          break label77;
        }
        this.fLP.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aVD("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.oB = paramBoolean;
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.fLP.setTitleMuteIconVisibility(8);
    }
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(27110);
    if ((this.wPN == null) || (!this.wPN.Kp()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramn.getType() == 1354)
    {
      paramn = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
      String str = ag.aGd().eL(this.wPN.field_username);
      this.wRr = ag.aGd().eK(str);
      if (this.wRr != null)
      {
        if (!this.wRr.hj(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramn.oB = bool;
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
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
    bzi localbzi = new bzi();
    localbzi.jdq = paramc.field_brandFlag;
    localbzi.nDo = this.contact.field_username;
    if (MS(this.jfq))
    {
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(58, localbzi));
    }
    for (;;)
    {
      ag.aFZ().update(paramc, new String[0]);
      localCheckBoxPreference1.oB = paramc.Kf();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.oB = paramc.Kg();
      }
      if (paramBoolean) {
        dAF();
      }
      AppMethodBeat.o(27092);
      return;
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(47, localbzi));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
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
      this.contact = paramam;
      this.wPZ = paramBoolean;
      this.jfq = paramInt;
      this.wRx = this.fLP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.wRC = ((SnsAdClick)this.fLP.getIntent().getParcelableExtra("KSnsAdTag"));
      this.wRB = this.fLP.getIntent().getBundleExtra("Contact_Ext_Args");
      this.wRD = this.fLP.getIntent().getStringExtra("key_add_contact_report_info");
      dAF();
      paramf = this.fLP.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bt.isNullOrNil(paramf))
      {
        this.fLP.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.fLP, paramf, "", this.fLP.getString(2131755835), null);
      }
      if (paramam != null)
      {
        ag.aGl().Dx(paramam.field_username);
        if (com.tencent.mm.am.g.DO(paramam.field_username))
        {
          paramf = paramam.field_username;
          if (!com.tencent.mm.am.g.vd(paramf)) {
            break label301;
          }
          ag.aGh();
          com.tencent.mm.am.a.h.a(paramf, this);
          paramf = com.tencent.mm.am.g.eS(paramf).Kv();
          if (paramf != null) {
            ag.aGl().Dx(paramf);
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
      if (com.tencent.mm.am.g.DQ(paramf))
      {
        ag.aGi();
        com.tencent.mm.am.e.a(paramf, this);
        ag.aFZ();
        paramf = com.tencent.mm.am.f.DH(paramf);
        if (paramf != null) {
          ag.aGl().Dx(paramf);
        }
      }
    }
  }
  
  public final String aFL()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean aaG(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.fLP).iE(this.contact.ePy, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.wRC != null)
      {
        paramString = new qw();
        this.wRC.imT = 5;
        paramString.dFu.dFv = this.wRC;
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
      }
      if ((this.wPN != null) && ((this.wPN.Kn()) || (this.wPN.Kp())))
      {
        paramString = new Intent();
        if (this.wPN.Kp())
        {
          localObject1 = this.wPN.Kv();
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", v.zf((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.bs.d.f(this.fLP, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.fLP.finish();
        }
      }
      for (;;)
      {
        bB(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", v.zf(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.fLP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.wPZ)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.fLP.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.iRG.d(paramString, this.fLP);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aDh()) {
        dAH();
      }
      for (;;)
      {
        if (this.wRx != 0) {
          com.tencent.mm.plugin.report.service.g.yhR.f(11263, new Object[] { Integer.valueOf(this.wRx), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.fLP, com.tencent.mm.model.gdpr.a.hIS, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void oG(int paramAnonymousInt)
          {
            AppMethodBeat.i(27075);
            if (paramAnonymousInt == 0) {
              c.this.dAH();
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
      if (((CheckBoxPreference)this.screen.aVD("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.jfq) });
        com.tencent.mm.model.j.yC(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        w.E(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.jfq) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.cQr.KG() != null) && (!bt.isNullOrNil(this.cQr.KG().cRu)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.cQr.KG().cRu);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.bs.d.b(this.fLP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = bt.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.cQq.size()))
      {
        paramString = (c.a)this.cQq.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.wRB != null) && ((this.jfq == 39) || (this.jfq == 56) || (this.jfq == 35))) || (this.jfq == 87) || (this.jfq == 89) || (this.jfq == 85) || (this.jfq == 88))
        {
          ad.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.wRB);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
            break label1169;
          }
        }
        label1169:
        for (i = 7;; i = 6)
        {
          int j = this.fLP.getResources().getIdentifier(paramString.cQu, "string", this.fLP.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.fLP.getString(j);
          }
          bB(i, paramString);
          com.tencent.mm.bs.d.b(this.fLP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
      localObject1 = this.wPN;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).Km()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).Kp()) {
              break label1393;
            }
            ba.aiU().a(1363, this);
            if (!((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1388;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            ba.aiU().a(paramString, 0);
            localObject2 = this.fLP;
            this.fLP.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fLP.getString(2131755936), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).Kp()) && (!((com.tencent.mm.api.c)localObject1).Kn())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).Kn())
        {
          paramString = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
          ag.aGi();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.am.e.a((String)localObject2, bool, this);
            localObject2 = this.fLP;
            this.fLP.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fLP.getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                ag.aGi();
                com.tencent.mm.am.e.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).Kf())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.cQr == null) && (localObject1 != null)) {
              this.cQr = ((com.tencent.mm.api.c)localObject1).bX(false);
            }
            if ((this.cQr != null) && (this.cQr.Kz()) && (com.tencent.mm.bs.d.aIu("brandservice")))
            {
              this.screen.cP("contact_info_template_recv", false);
              label1584:
              paramString = com.tencent.mm.plugin.report.service.g.yhR;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).Kf()) {
                break label1709;
              }
            }
          }
          label1709:
          for (i = 3;; i = 4)
          {
            paramString.f(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.jfq) });
            break;
            this.screen.cP("contact_info_template_recv", true);
            break label1584;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.cP("contact_info_template_recv", true);
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
            if (((com.tencent.mm.api.c)localObject1).Kg()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.wRA = com.tencent.mm.ui.base.h.a(this.fLP, this.fLP.getString(2131757139, new Object[] { this.contact.adv() }), this.fLP.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.cWD.field_hadAlert = 1;
                  this.cWD.field_brandFlag |= 0x4;
                  c.this.a(this.cWD, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.cWD.field_hadAlert = 1;
                  c.this.a(this.cWD, false);
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
      paramString = this.wPN;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject2 = paramString.bX(false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      localObject1 = null;
      if ((((c.b)localObject2).KI() != null) && (!bt.isNullOrNil(((c.b)localObject2).KI().cRp))) {
        paramString = ((c.b)localObject2).KI().cRp;
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
          com.tencent.mm.bs.d.b(this.fLP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).KJ() != null)
        {
          paramString = (String)localObject1;
          if (!bt.isNullOrNil(((c.b)localObject2).KJ().cRx)) {
            paramString = ((c.b)localObject2).KJ().cRx;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.wPN;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.bX(false) != null) && (!bt.isNullOrNil(paramString.bX(false).KB())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.bX(false).KB());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.bs.d.b(this.fLP, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.fMP)
      {
        bool = true;
        this.fMP = bool;
        if (!this.fMP) {
          break label2687;
        }
        w.s(this.contact);
        label2246:
        pq(this.fMP);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.fLP != null) {
          break label2697;
        }
        ad.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2279:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.fLP.getString(2131758435);
        localObject2 = this.fLP.getString(2131758434);
        com.tencent.mm.ui.base.h.e(this.fLP, (String)localObject1, "", (String)localObject2, this.fLP.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            c.this.pp(false);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        pp(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.wPN.field_username);
        com.tencent.mm.bs.d.b(this.fLP, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.aVD("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bt.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.fLP, true, (String)localObject1, "", this.fLP.getString(2131757643), this.fLP.getString(2131755691), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        dAJ();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        ad.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.fLP.getSharedPreferences(this.fLP.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.adq()) {
            break label2767;
          }
          ad.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
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
      if (this.wPN == null)
      {
        ad.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2279;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.wPN.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bs.d.b(this.fLP, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2279;
      label2767:
      com.tencent.mm.model.j.yC(this.contact.field_username);
      ad.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  final void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.wRB == null) || ((this.jfq != 39) && (this.jfq != 56) && (this.jfq != 35) && (this.jfq != 87) && (this.jfq != 88) && (this.jfq != 89) && (this.jfq != 85)))
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
    String str2 = this.wRB.getString("Contact_Ext_Args_Search_Id");
    String str3 = bt.nullAsNil(this.wRB.getString("Contact_Ext_Args_Query_String"));
    int j = this.wRB.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.jfq)
    {
    default: 
      i = 0;
      str1 = bt.nullAsNil(this.wRB.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bt.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bt.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ad.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10866, paramString);
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
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.aVD("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  final void dAH()
  {
    AppMethodBeat.i(27101);
    if ((this.fLP.getIntent() != null) && (this.fLP.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.fLP.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bt.isNullOrNil((String)localObject1)) {
        break label163;
      }
      ad.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (dAI())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.fLP, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(27077);
          am localam;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cl(c.this.fLP, c.this.fLP.getString(2131757590));
            c.this.screen.cP("contact_info_time_expired", true);
            localam = c.this.contact;
            if ((localam == null) || (bt.isNullOrNil(paramAnonymousString1)))
            {
              ad.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localam);
              c.this.wRw = true;
              if (c.this.wRC != null)
              {
                paramAnonymousString1 = new qw();
                c.this.wRC.imT = 4;
                paramAnonymousString1.dFu.dFv = c.this.wRC;
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString1);
              }
              paramAnonymousString1 = ag.aFZ().DD(c.this.contact.field_username);
              paramAnonymousString1.field_status = 1;
              if ((!bt.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bt.isNullOrNil(paramAnonymousString1.field_username)) || (c.this.wPN == null) || (!paramAnonymousString1.field_username.equals(bt.nullAsNil(c.this.wPN.field_username)))) {
                break label675;
              }
              ag.aFZ().g(c.this.wPN);
              label249:
              paramAnonymousBoolean1 = c.this.fLP.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
              paramAnonymousBoolean2 = c.this.fLP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
              if (!paramAnonymousString1.Kn()) {
                break label686;
              }
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("enterprise_biz_name", c.this.contact.field_username);
              paramAnonymousString1.putExtra("enterprise_biz_display_name", v.zf(c.this.contact.field_username));
              paramAnonymousString1.putExtra("enterprise_from_scene", 7);
              paramAnonymousString1.addFlags(67108864);
              com.tencent.mm.bs.d.f(c.this.fLP, ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
              label364:
              c.this.fLP.finish();
              label374:
              c.this.bB(3, null);
            }
          }
          else
          {
            AppMethodBeat.o(27077);
            return;
          }
          if (w.zC(localam.field_username))
          {
            String str = bt.nullAsNil(localam.field_username);
            paramAnonymousString2 = com.tencent.mm.am.g.eS(str);
            if (paramAnonymousString2 != null) {
              paramAnonymousString2.field_username = paramAnonymousString1;
            }
            ag.aFZ().delete(str);
            localam.sZ(str);
          }
          for (;;)
          {
            localam.setUsername(paramAnonymousString1);
            if ((int)localam.gfj == 0)
            {
              ba.aBQ();
              com.tencent.mm.model.c.azp().ah(localam);
            }
            if ((int)localam.gfj <= 0)
            {
              ad.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
              break;
            }
            w.u(localam);
            ba.aBQ();
            paramAnonymousString1 = com.tencent.mm.model.c.azp().Bf(localam.field_username);
            if (paramAnonymousString2 != null)
            {
              ag.aFZ().f(paramAnonymousString2);
              break;
            }
            paramAnonymousString2 = com.tencent.mm.am.g.eS(paramAnonymousString1.field_username);
            if ((paramAnonymousString1.fqg()) && (com.tencent.mm.am.a.aFr())) {}
            for (int i = 1;; i = 0)
            {
              if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.Kh()) || (i != 0))) {
                break label616;
              }
              ad.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
              as.a.hFO.aI(paramAnonymousString1.field_username, "");
              com.tencent.mm.ak.c.CT(paramAnonymousString1.field_username);
              break;
            }
            label616:
            if ((!paramAnonymousString1.fqk()) || (i != 0)) {
              break;
            }
            ad.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.ePB) });
            as.a.hFO.aI(paramAnonymousString1.field_username, "");
            com.tencent.mm.ak.c.CT(paramAnonymousString1.field_username);
            break;
            label675:
            ag.aFZ().g(paramAnonymousString1);
            break label249;
            label686:
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("Chat_User", c.this.contact.field_username);
            paramAnonymousString1.putExtra("key_has_add_contact", true);
            paramAnonymousString1.putExtra("finish_direct", true);
            if (paramAnonymousBoolean2) {
              paramAnonymousString1.addFlags(268435456);
            }
            com.tencent.mm.plugin.profile.b.iRG.d(paramAnonymousString1, c.this.fLP);
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
      ((LinkedList)localObject2).add(Integer.valueOf(this.jfq));
      if (this.cQA != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUP = this.cQA;
      }
      if (!bt.isNullOrNil(this.txJ)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).txJ = this.txJ;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUV = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.wRD);
      AppMethodBeat.o(27101);
      return;
    }
    ad.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    ba.aiU().a(536, this);
    Object localObject2 = new dn();
    ((dn)localObject2).don.dop = ((String)localObject1);
    ((dn)localObject2).don.opType = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dn)localObject2).doo.dor;
    localObject2 = this.fLP;
    this.fLP.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fLP.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(27076);
        ba.aiU().b(536, c.this);
        paramAnonymousDialogInterface = new dn();
        paramAnonymousDialogInterface.don.opType = 2;
        paramAnonymousDialogInterface.don.dor = this.diy;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(27076);
      }
    });
    AppMethodBeat.o(27101);
  }
  
  final void dAJ()
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
    com.tencent.mm.bs.d.b(this.fLP, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  public final void e(LinkedList<efo> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    ag.aGa().b(this);
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
    if (!bt.isNullOrNil(this.wRy))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        efo localefo = (efo)((Iterator)localObject).next();
        if ((localefo.HQN != null) && (localefo.HQN.equals(this.wRy)))
        {
          this.screen.cP("contact_info_kf_worker", false);
          this.screen.aVD("contact_info_kf_worker").setSummary(localefo.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.cP("contact_info_kf_worker", false);
    Object localObject = this.screen.aVD("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((efo)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.fLP == null)
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
      com.tencent.mm.plugin.messenger.a.g.dlD().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.fLP, this.fLP.getString(2131759420));
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
    this.wRz = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    ba.aiU().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    ad.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      ba.aiU().b(536, this);
      dAF();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (dcb)paramString.rr.hNL.hNQ;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramn;
        paramn = (n)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramn = (n)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hNK.hNQ != null) {
            paramn = (dca)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hNK.hNQ;
          }
        }
        if ((paramString != null) && (paramString.FHh != null) && (paramString.FHh.ret == 0) && (paramString.FHe != null) && (!bt.isNullOrNil(paramString.FHe.FHc))) {
          break label413;
        }
        if ((paramString == null) || (paramString.FHh == null)) {
          break;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.FHh.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.FHe == null)
      {
        ad.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = ag.aGd().eK(paramString.FHe.FHc);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.am.a.k();
        ((com.tencent.mm.am.a.k)localObject1).field_userId = paramString.FHe.FHc;
      }
      ((com.tencent.mm.am.a.k)localObject1).field_userName = paramString.FHe.oBW;
      ((com.tencent.mm.am.a.k)localObject1).field_brandUserName = paramn.FHb;
      ((com.tencent.mm.am.a.k)localObject1).field_UserVersion = paramString.FHe.ver;
      ((com.tencent.mm.am.a.k)localObject1).field_headImageUrl = paramString.FHe.FGV;
      ((com.tencent.mm.am.a.k)localObject1).field_profileUrl = paramString.FHe.FHk;
      ((com.tencent.mm.am.a.k)localObject1).field_bitFlag = paramString.FHe.FGW;
      ((com.tencent.mm.am.a.k)localObject1).field_addMemberUrl = paramString.FHe.FGZ;
      ((com.tencent.mm.am.a.k)localObject1).field_needToUpdate = false;
      if (!ag.aGd().b((com.tencent.mm.am.a.k)localObject1)) {
        ag.aGd().a((com.tencent.mm.am.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dAr();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramn).dAq();
      if ((localObject1 == null) || (((dld)localObject1).FHh == null) || (((dld)localObject1).FHh.ret != 0))
      {
        if ((localObject1 != null) && (((dld)localObject1).FHh != null))
        {
          ad.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dld)localObject1).FHh.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        ad.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.lSG)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.wPN;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        ba.aBQ();
        if (com.tencent.mm.model.c.azv().aTz(paramString.field_username) == null)
        {
          paramn = new at(paramString.field_username);
          paramn.tD(bt.nullAsNil(this.wPN.Kv()));
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().apX(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          ba.aBQ();
          com.tencent.mm.model.c.azv().e(paramn);
          ba.aBQ();
          com.tencent.mm.model.c.azv().aM((bu)localObject1);
        }
      }
      for (;;)
      {
        ba.aBQ();
        if (com.tencent.mm.model.c.azv().aTz(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new at(paramString.field_enterpriseFather);
        paramString.fqK();
        ba.aBQ();
        com.tencent.mm.model.c.azv().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramn.fqK();
        ba.aBQ();
        com.tencent.mm.model.c.azv().e(paramn);
      }
      label954:
      ba.aBQ();
      com.tencent.mm.model.c.azu().aSv(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.wPN;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTx(paramString.field_username);
      ba.aBQ();
      if (com.tencent.mm.model.c.azv().aTL(paramString.field_enterpriseFather) <= 0)
      {
        ba.aBQ();
        com.tencent.mm.model.c.azv().aTx(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      ba.aBQ();
      com.tencent.mm.model.c.azu().aSv(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1343)
    {
      dAF();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1228) {
      dAF();
    }
    AppMethodBeat.o(27108);
  }
  
  final void pp(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.wPN.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      ba.aiU().a(1394, this);
      ba.aiU().a((n)localObject, 0);
      MMActivity localMMActivity = this.fLP;
      this.fLP.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.fLP.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          ba.aiU().a(this.nYI);
          ba.aiU().b(1394, c.this);
          AppMethodBeat.o(27084);
        }
      });
      AppMethodBeat.o(27091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */