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
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ds.b;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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
  implements com.tencent.mm.ak.f, i.b, com.tencent.mm.al.p, com.tencent.mm.pluginsdk.b.a
{
  private List<c.a> cRa;
  private c.b cRb;
  private boolean cRi = false;
  private String cRk;
  an contact;
  MMActivity fNT;
  private CheckBoxPreference fON;
  private boolean fOX;
  boolean isDeleteCancel = false;
  private int jij;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  String tIA;
  com.tencent.mm.ui.base.p tipDialog = null;
  com.tencent.mm.api.c xfE;
  private boolean xfQ;
  private String xfV;
  private com.tencent.mm.al.a.k xhi;
  private List<WxaAttributes.WxaEntryInfo> xhj;
  private aco xhk = null;
  private boolean xhl = false;
  private boolean xhm = false;
  boolean xhn = false;
  private int xho = 0;
  private String xhp;
  private boolean xhq;
  com.tencent.mm.ui.widget.a.d xhr = null;
  private Bundle xhs;
  SnsAdClick xht = null;
  private String xhu = null;
  
  private c(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public c(MMActivity paramMMActivity, String paramString, aco paramaco)
  {
    this(paramMMActivity);
    this.xfV = paramString;
    this.xhk = paramaco;
  }
  
  private String Nx(int paramInt)
  {
    AppMethodBeat.i(27095);
    switch (paramInt)
    {
    default: 
      ae.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(paramInt) });
      str = this.fNT.getResources().getString(2131757694);
      AppMethodBeat.o(27095);
      return str;
    case 0: 
      str = this.fNT.getResources().getString(2131757895);
      AppMethodBeat.o(27095);
      return str;
    case 1: 
      str = this.fNT.getResources().getString(2131756745);
      AppMethodBeat.o(27095);
      return str;
    }
    String str = this.fNT.getResources().getString(2131756746);
    AppMethodBeat.o(27095);
    return str;
  }
  
  private static boolean Ny(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private static boolean avX(String paramString)
  {
    AppMethodBeat.i(27099);
    try
    {
      long l = bu.getLong(paramString, 0L);
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
  
  private void avY(String paramString)
  {
    AppMethodBeat.i(27105);
    ae.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[] { paramString, Boolean.valueOf(this.xhq) });
    if (this.xhq)
    {
      AppMethodBeat.o(27105);
      return;
    }
    this.xhp = paramString;
    if ((this.cRb == null) || (!this.cRb.KW()) || (this.contact == null))
    {
      this.screen.cT("contact_info_kf_worker", true);
      AppMethodBeat.o(27105);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      paramString = ag.aGo().Ez(this.contact.field_username);
      if (paramString == null)
      {
        this.screen.cT("contact_info_kf_worker", true);
        ag.aGq().a(this);
        ag.aGq().ba(this.contact.field_username, v.aAC());
        this.xhq = true;
        AppMethodBeat.o(27105);
        return;
      }
      ae.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[] { paramString.field_openId });
      this.screen.cT("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aXe("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        avZ(paramString.field_openId);
        AppMethodBeat.o(27105);
        return;
      }
      ((IconWidgetPreference)localObject1).aa((Bitmap)localObject2);
      AppMethodBeat.o(27105);
      return;
    }
    Object localObject2 = ag.aGo();
    Object localObject1 = ((com.tencent.mm.al.j)localObject2).Ey(paramString);
    if ((localObject1 == null) || (com.tencent.mm.al.j.a((com.tencent.mm.al.h)localObject1)))
    {
      ag.aGq().a(this);
      ag.aGq().k(this.contact.field_username, paramString, 1);
      this.xhq = true;
    }
    if (localObject1 == null) {
      ae.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
    }
    for (paramString = ((com.tencent.mm.al.j)localObject2).Ez(this.contact.field_username);; paramString = (String)localObject1)
    {
      if (paramString == null)
      {
        this.screen.cT("contact_info_kf_worker", true);
        AppMethodBeat.o(27105);
        return;
      }
      this.screen.cT("contact_info_kf_worker", false);
      localObject1 = (IconWidgetPreference)this.screen.aXe("contact_info_kf_worker");
      ((IconWidgetPreference)localObject1).setSummary(paramString.field_nickname);
      localObject2 = com.tencent.mm.aj.c.a(paramString.field_openId, false, -1, null);
      if (localObject2 == null)
      {
        c(paramString);
        avZ(paramString.field_openId);
      }
      for (;;)
      {
        ae.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[] { paramString.field_openId, paramString.field_nickname });
        AppMethodBeat.o(27105);
        return;
        ((IconWidgetPreference)localObject1).aa((Bitmap)localObject2);
      }
    }
  }
  
  private void avZ(final String paramString)
  {
    AppMethodBeat.i(27106);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27081);
        if (c.this.screen == null)
        {
          ae.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
          AppMethodBeat.o(27081);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)c.this.screen.aXe("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (c.this.screen != null))
        {
          Bitmap localBitmap = com.tencent.mm.aj.c.a(paramString, false, -1, null);
          if (localBitmap != null)
          {
            ae.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.aa(localBitmap);
            c.this.screen.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(27081);
      }
    }, 2000L);
    AppMethodBeat.o(27106);
  }
  
  private static void c(com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(27107);
    long l = System.currentTimeMillis();
    com.tencent.mm.aj.j localj = com.tencent.mm.aj.p.aEN();
    if (localj.DL(paramh.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramh.field_openId;
      locali.hPP = paramh.field_headImgUrl;
      locali.eD(false);
      locali.eQU = 3;
      localj.b(locali);
    }
    com.tencent.mm.aj.p.aEP().Dx(paramh.field_openId);
    ae.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27107);
  }
  
  private void dDW()
  {
    AppMethodBeat.i(27094);
    ceC();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951636);
    if (this.xhn) {
      this.screen.cT("contact_info_time_expired", true);
    }
    com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(this.contact.field_username);
    this.cRa = null;
    this.cRb = null;
    this.xhj = null;
    if (((localc == null) || (localc.bX(false) == null)) && (this.xhk != null))
    {
      localc = new com.tencent.mm.api.c();
      localc.field_username = this.contact.field_username;
      localc.field_brandFlag = this.xhk.jgj;
      localc.field_brandIconURL = this.xhk.jgm;
      localc.field_brandInfo = this.xhk.jgl;
      localc.field_extInfo = this.xhk.jgk;
    }
    label528:
    label672:
    label1844:
    label5303:
    for (;;)
    {
      if ((localc != null) && (localc.field_brandInfo == null) && (localc.field_extInfo == null) && (this.xhk != null))
      {
        localc.field_username = this.contact.field_username;
        localc.field_brandFlag = this.xhk.jgj;
        localc.field_brandIconURL = this.xhk.jgm;
        localc.field_brandInfo = this.xhk.jgl;
        localc.field_extInfo = this.xhk.jgk;
      }
      Object localObject1 = (BizInfoHeaderPreference)this.screen.aXe("contact_info_header_bizinfo");
      boolean bool;
      if ((localObject1 != null) && (!bu.isNullOrNil(this.contact.field_username)))
      {
        ((BizInfoHeaderPreference)localObject1).a(this.contact, this.xfV, localc);
        this.screen.cT("biz_placed_to_the_top", true);
        this.screen.cT("contact_info_biz_enable", true);
        this.screen.cT("contact_info_biz_disable", true);
        this.screen.cT("contact_info_stick_biz", true);
        if (localc == null) {
          break label2272;
        }
        if (!localc.Kw()) {
          break label1844;
        }
        this.screen.cT("contact_info_biz_add", true);
        this.screen.cT("contact_info_expose_btn", true);
        this.screen.cT("contact_is_mute", false);
        this.fOX = this.contact.Pd();
        if (!localc.Kx()) {
          break label1559;
        }
        this.screen.cT("contact_info_biz_go_chatting", true);
        localObject1 = this.screen;
        if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {
          break label1553;
        }
        bool = true;
        label474:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cT("contact_info_stick_biz", bool);
        localObject1 = (CheckBoxPreference)this.screen.aXe("contact_info_stick_biz");
        ((CheckBoxPreference)localObject1).setChecked(this.contact.adB());
        ((CheckBoxPreference)localObject1).setTitle(2131758432);
        dEb();
        py(this.fOX);
        this.xfE = localc;
        this.cRa = localc.KE();
        this.cRb = localc.bX(false);
        this.xhj = this.cRb.getWxaEntryInfoList();
        if (!this.cRb.KF()) {
          break label2157;
        }
        this.screen.aXe("near_field_service").setSummary(2131766197);
        label600:
        if (this.cRb.KL() == null) {
          break label2238;
        }
        this.xhm = true;
        if (avX(this.cRb.KL())) {
          break label2174;
        }
        this.screen.cT("contact_info_time_expired", true);
        if ((x.AV(this.contact.field_username)) || (x.Bh(this.contact.field_username))) {
          dDX();
        }
        if ((this.cRb.KI() != null) && (this.cRb.KI().length() > 0)) {
          this.cRk = this.cRb.KI();
        }
        this.cRi = this.cRb.KG();
        if (bu.isNullOrNil(this.cRb.KV())) {
          break label2255;
        }
        this.screen.cT("contact_info_service_phone", false);
        localObject1 = this.screen.aXe("contact_info_service_phone");
        if (localObject1 != null)
        {
          ((Preference)localObject1).setSummary(this.cRb.KV());
          ((Preference)localObject1).oWv = this.fNT.getResources().getColor(2131100547);
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
        if (!bu.isNullOrNil(this.contact.signature))
        {
          localObject2 = (KeyValuePreference)this.screen.aXe("contact_info_user_desc");
          if (localObject2 != null)
          {
            if (bu.nullAsNil(this.contact.signature).trim().length() <= 0) {
              this.screen.cT("contact_info_user_desc", true);
            }
          }
          else
          {
            if ((this.cRb == null) || (this.cRb.KQ() == null) || (bu.isNullOrNil(this.cRb.KQ().cRX))) {
              break label2588;
            }
            localObject4 = this.cRb.KQ();
            localObject6 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser");
            if (localObject6 == null) {
              break label2571;
            }
            ((KeyValuePreference)localObject6).JNz = false;
            if (!bu.isNullOrNil(((c.b.e)localObject4).cRY)) {
              break label2502;
            }
            ((KeyValuePreference)localObject6).Jvz = Nx(((c.b.e)localObject4).cRW);
            if (au.a.hII == null) {
              break label2515;
            }
            localObject1 = BackwardSupportUtil.b.p(au.a.hII.ou(this.contact.field_verifyFlag), 2.0F);
            if (localObject1 == null) {
              break label5303;
            }
            localObject2 = new BitmapDrawable(this.fNT.getResources(), (Bitmap)localObject1);
            if (localObject1 != null) {
              break label2521;
            }
            bool = true;
            ae.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
            ((KeyValuePreference)localObject6).JNG = ((Drawable)localObject2);
            if (((c.b.e)localObject4).cRX == null) {
              break label2560;
            }
            localObject7 = ((c.b.e)localObject4).cSa;
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, ((c.b.e)localObject4).cRX.trim());
            if (bu.isNullOrNil((String)localObject7)) {
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
          if ((this.cRb == null) || (bu.isNullOrNil(this.cRb.KK()))) {
            break label2698;
          }
          localObject2 = (KeyValuePreference)this.screen.aXe("contact_info_trademark");
          if (localObject2 == null) {
            break label1310;
          }
          ((KeyValuePreference)localObject2).JNz = false;
          if (au.a.hII == null) {
            break label2686;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.h.aaZ(2131689767);
          if (localObject1 != null) {
            break label2692;
          }
          bool = true;
          ae.i("MicroMsg.ContactWidgetBizInfo", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5290;
          }
          localObject1 = new BitmapDrawable(this.fNT.getResources(), (Bitmap)localObject1);
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
        ((KeyValuePreference)localObject2).JNG = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cRb.KK());
        ae.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[] { this.cRb.KK(), this.cRb.KJ() });
        if ((this.cRb == null) || (this.cRb.KM() == null) || (this.cRb.KM().size() <= 0)) {
          break label2723;
        }
        localObject2 = (KeyValuePreference)this.screen.aXe("contact_info_privilege");
        ((KeyValuePreference)localObject2).xN(false);
        ((KeyValuePreference)localObject2).fDG();
        localObject4 = this.cRb.KM().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject7 = (c.b.g)((Iterator)localObject4).next();
          localObject6 = (LinearLayout)View.inflate(this.fNT, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.fNT.getResources(), ((c.b.g)localObject7).iconUrl));
          localObject1 = ((c.b.g)localObject7).description;
          i = this.fNT.getResources().getIdentifier(((c.b.g)localObject7).cSf, "string", this.fNT.getPackageName());
          if (i > 0) {
            localObject1 = this.fNT.getString(i);
          }
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText((CharSequence)localObject1);
          ((KeyValuePreference)localObject2).gh((View)localObject6);
        }
        ae.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
        this.screen.cT("contact_info_header_bizinfo", true);
        break;
        bool = false;
        break label474;
        this.screen.cT("contact_info_subscribe_bizinfo", true);
        this.screen.cT("contact_info_biz_go_chatting", true);
        if (localc.Kn())
        {
          this.screen.cT("contact_info_biz_enable", true);
          this.screen.cT("contact_info_biz_disable", false);
          this.screen.aXe("contact_info_biz_disable").setTitle(2131758434);
          this.screen.cT("contact_is_mute", false);
          this.screen.cT("biz_placed_to_the_top", false);
          this.fON = ((CheckBoxPreference)this.screen.aXe("biz_placed_to_the_top"));
          this.fON.setTitle(2131758450);
          dEb();
          if (!localc.Ky()) {
            break label528;
          }
          this.screen.cT("contact_info_locate", true);
          break label528;
        }
        this.screen.cT("contact_info_biz_enable", false);
        this.screen.cT("contact_info_biz_disable", true);
        ((ButtonPreference)this.screen.aXe("contact_info_biz_enable")).gE(this.fNT.getResources().getString(2131758436), this.fNT.getResources().getColor(2131100035));
        this.screen.cT("contact_is_mute", true);
        this.screen.cT("biz_placed_to_the_top", true);
        this.screen.cT("contact_info_locate", true);
        break label528;
        if (localc.Kv())
        {
          this.screen.cT("contact_info_locate", true);
          this.screen.cT("contact_info_subscribe_bizinfo", false);
          this.screen.cT("enterprise_contact_info_enter", false);
          ((ButtonPreference)this.screen.aXe("contact_info_biz_go_chatting")).gE(this.fNT.getResources().getString(2131758437), this.fNT.getResources().getColor(2131100035));
          localObject1 = this.screen;
          if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.preference.f)localObject1).cT("contact_info_stick_biz", bool);
            localObject1 = (CheckBoxPreference)this.screen.aXe("contact_info_stick_biz");
            ((CheckBoxPreference)localObject1).setChecked(this.contact.adB());
            ((CheckBoxPreference)localObject1).setTitle(2131758440);
            dEb();
            this.screen.cT("contact_is_mute", false);
            this.fOX = this.contact.Pd();
            py(this.fOX);
            break;
          }
        }
        localObject1 = this.screen;
        if ((x.AA(this.contact.field_username)) || (!com.tencent.mm.contact.c.lO(this.contact.field_type))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject1).cT("contact_info_stick_biz", bool);
          ((CheckBoxPreference)this.screen.aXe("contact_info_stick_biz")).setChecked(this.contact.adB());
          this.screen.cT("contact_is_mute", true);
          this.fOX = false;
          break;
        }
        label2157:
        this.screen.cT("near_field_service", true);
        break label600;
        label2174:
        this.xhl = true;
        if (!com.tencent.mm.contact.c.lO(this.contact.field_type))
        {
          ae.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[] { this.contact.field_username });
          dDX();
          break label642;
        }
        this.screen.cT("contact_info_time_expired", true);
        break label642;
        label2238:
        this.screen.cT("contact_info_time_expired", true);
        break label672;
        label2255:
        this.screen.cT("contact_info_service_phone", true);
        continue;
        label2272:
        this.screen.cT("contact_info_time_expired", true);
        ae.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        continue;
        ((KeyValuePreference)localObject2).JNz = false;
        ((KeyValuePreference)localObject2).Jvz = this.fNT.getString(2131757694);
        ((KeyValuePreference)localObject2).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, this.contact.signature));
        ((KeyValuePreference)localObject2).xN(false);
        if (au.a.hII != null)
        {
          localObject1 = BackwardSupportUtil.b.p(au.a.hII.ou(this.contact.field_verifyFlag), 2.0F);
          label2369:
          if (localObject1 != null) {
            break label2450;
          }
          bool = true;
          label2377:
          ae.i("MicroMsg.ContactWidgetBizInfo", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label5309;
          }
        }
      }
      label4152:
      label4282:
      label5309:
      for (localObject1 = new BitmapDrawable(this.fNT.getResources(), (Bitmap)localObject1);; localObject1 = null)
      {
        ((KeyValuePreference)localObject2).JNG = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).JNE = 8;
        ((KeyValuePreference)localObject2).ade(8);
        break;
        localObject1 = null;
        break label2369;
        bool = false;
        break label2377;
        ae.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
        this.screen.cT("contact_info_user_desc", true);
        if (this.xhl) {
          break;
        }
        this.screen.cT("contact_info_time_expired", true);
        break;
        label2502:
        ((KeyValuePreference)localObject6).Jvz = ((c.b.e)localObject4).cRY;
        break label956;
        label2515:
        localObject1 = null;
        break label983;
        label2521:
        bool = false;
        break label1014;
        ae.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
        break label1139;
        ae.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
        break label1146;
        this.screen.cT("contact_info_verifyuser", true);
        break label1146;
        if ((this.cRb != null) && (this.cRb.KR() != null) && (!bu.isNullOrNil(this.cRb.KR().cSg)))
        {
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser");
          if (localObject1 == null) {
            break label1146;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cRb.KR().cSg);
          break label1146;
        }
        ae.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
        this.screen.cT("contact_info_verifyuser", true);
        break label1146;
        label2686:
        localObject1 = null;
        break label1208;
        bool = false;
        break label1216;
        ae.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
        this.screen.cT("contact_info_trademark", true);
        break label1310;
        this.screen.cT("contact_info_privilege", true);
        int k = this.screen.indexOf("contact_info_category2");
        if ((k >= 0) && (this.cRa != null) && (this.cRa.size() > 0)) {
          i = this.cRa.size() - 1;
        }
        Object localObject5;
        int j;
        while (i >= 0)
        {
          if ((this.cRa.get(i) != null) && ((!this.fNT.getString(2131757619).equals(((c.a)this.cRa.get(i)).title)) || (this.cRi)) && ((!bu.isNullOrNil(((c.a)this.cRa.get(i)).title)) || (!bu.isNullOrNil(((c.a)this.cRa.get(i)).cRe))))
          {
            localObject5 = new Preference(this.fNT);
            ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
            localObject1 = ((c.a)this.cRa.get(i)).title;
            j = this.fNT.getResources().getIdentifier(((c.a)this.cRa.get(i)).cRe, "string", this.fNT.getPackageName());
            if (j > 0) {
              localObject1 = this.fNT.getString(j);
            }
            localObject2 = localObject1;
            if (this.xfE.Ku()) {
              if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cRa.get(i)).cRe))
              {
                localObject2 = localObject1;
                if (!((String)localObject1).equals(this.fNT.getString(2131755016))) {}
              }
              else
              {
                localObject2 = this.fNT.getString(2131758428);
              }
            }
            ((Preference)localObject5).setTitle((CharSequence)localObject2);
            if (!bu.isNullOrNil(((c.a)this.cRa.get(i)).description)) {
              ((Preference)localObject5).setSummary(((c.a)this.cRa.get(i)).description);
            }
            if (!bu.nullAsNil(((c.a)this.cRa.get(i)).cRe).equals("__mp_wording__brandinfo_feedback")) {
              break label5285;
            }
            j = this.screen.indexOf("contact_info_scope_of_business");
            if (j <= 0) {
              break label5285;
            }
            j += 1;
            this.screen.a((Preference)localObject5, j);
            if (bu.nullAsNil(((c.a)this.cRa.get(i)).cRe).equals("__mp_wording__brandinfo_biz_detail"))
            {
              localObject1 = new PreferenceSmallCategory(this.fNT);
              this.screen.a((Preference)localObject1, j);
            }
          }
          i -= 1;
          continue;
          ae.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        }
        if ((!this.xhl) && (x.J(this.contact)) && (this.contact.eRj != null) && (!this.contact.eRj.equals("")))
        {
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bu.bI(this.contact.field_weiboNickname, "") + this.fNT.getString(2131763406, new Object[] { x.Bg(this.contact.eRj) }));
            ((Preference)localObject1).oWv = com.tencent.mm.cb.a.n(this.fNT, 2131100547);
            ((KeyValuePreference)localObject1).xN(false);
          }
          if ((this.cRb == null) || (this.cRb.KO() == null)) {
            break label4203;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aXe("contact_info_reputation");
          if (this.cRb.KO().cSb <= 0) {
            break label4152;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Nn(this.cRb.KO().cSb);
          label3443:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aXe("contact_info_guarantee_info");
          if ((this.cRb.KO().cSd == null) || (this.cRb.KO().cSd.size() <= 0)) {
            break label4169;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eW(this.cRb.KO().cSd);
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_scope_of_business");
          if (bu.isNullOrNil(this.cRb.KO().cSc)) {
            break label4186;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cRb.KO().cSc);
          ((KeyValuePreference)localObject1).JNE = 4;
          ((KeyValuePreference)localObject1).xN(false);
          label3566:
          if ((this.xhj == null) || (this.xhj.size() <= 0)) {
            break label4248;
          }
          this.screen.cT("contact_info_bindwxainfo", false);
          ((BizBindWxaInfoPreference)this.screen.aXe("contact_info_bindwxainfo")).a(this.xfE, this.xhj);
          avY(this.fNT.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
          ae.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.fNT.getIntent().getBooleanExtra("KIsHardDevice", false)) });
          if ((this.fNT.getIntent() == null) || (!this.fNT.getIntent().getBooleanExtra("KIsHardDevice", false))) {
            break label4570;
          }
          ae.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
          bool = dDZ();
          ae.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.lO(this.contact.field_type)), Boolean.valueOf(bool) });
          if ((!com.tencent.mm.contact.c.lO(this.contact.field_type)) || (!bool)) {
            break label4401;
          }
          if (localc == null) {
            break label4356;
          }
          localObject1 = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
          localObject2 = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
          if (!localc.Kx()) {
            break label4282;
          }
          localObject5 = ag.aGt().eQ(localc.field_username);
          this.xhi = ag.aGt().eP((String)localObject5);
          if (this.xhi == null) {
            break label4271;
          }
          if (this.xhi.hk(4)) {
            break label4265;
          }
          bool = true;
          ((CheckBoxPreference)localObject1).setChecked(bool);
          if (!localc.Kn()) {
            break label4312;
          }
          if ((this.cRb == null) && (localc != null)) {
            this.cRb = localc.bX(false);
          }
          if ((this.cRb == null) || (!this.cRb.KH()) || (!com.tencent.mm.br.d.aJN("brandservice"))) {
            break label4295;
          }
          this.screen.cT("contact_info_template_recv", false);
          label3939:
          if (!localc.bX(false).Kr()) {
            break label4329;
          }
          ((CheckBoxPreference)localObject2).setChecked(localc.Ko());
        }
        for (;;)
        {
          this.screen.cT("contact_info_biz_read_msg_online", true);
          this.screen.cT("contact_info_biz_add", true);
          localObject1 = this.contact.adG();
          if (localObject1 != null) {
            this.fNT.setMMTitle((String)localObject1);
          }
          if (x.AA(this.contact.field_username))
          {
            ((ButtonPreference)this.screen.aXe("contact_info_biz_go_chatting")).gE(this.fNT.getResources().getString(2131757806), this.fNT.getResources().getColor(2131100035));
            this.fNT.setMMTitle(2131757883);
          }
          if ((!x.AV(this.contact.field_username)) && (this.xfE != null) && (!this.xfE.Kw())) {
            this.fNT.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
          this.screen.cT("contact_info_verifyuser_weibo", true);
          break;
          this.screen.cT("contact_info_reputation", true);
          break label3443;
          label4169:
          this.screen.cT("contact_info_guarantee_info", true);
          break label3506;
          label4186:
          this.screen.cT("contact_info_scope_of_business", true);
          break label3566;
          label4203:
          this.screen.cT("contact_info_reputation", true);
          this.screen.cT("contact_info_guarantee_info", true);
          this.screen.cT("contact_info_scope_of_business", true);
          break label3566;
          this.screen.cT("contact_info_bindwxainfo", true);
          break label3625;
          bool = false;
          break label3862;
          ae.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
          break label3869;
          ((CheckBoxPreference)localObject1).setChecked(localc.Kn());
          break label3869;
          label4295:
          this.screen.cT("contact_info_template_recv", true);
          break label3939;
          label4312:
          this.screen.cT("contact_info_template_recv", true);
          break label3939;
          label4329:
          this.screen.cT("contact_info_locate", true);
          ((CheckBoxPreference)localObject2).setChecked(localc.Ko());
          continue;
          this.screen.cT("contact_info_subscribe_bizinfo", true);
          this.screen.cT("contact_info_locate", true);
          this.screen.cT("contact_info_template_recv", true);
        }
        ae.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
        dDX();
        localObject1 = this.screen.aXe("contact_info_biz_add");
        ae.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[] { Boolean.valueOf(this.xhm) });
        if (localObject1 != null)
        {
          if (bool) {
            ((Preference)localObject1).setTitle(2131757603);
          }
        }
        else if (Ny(this.jij))
        {
          if (localc != null) {
            break label4530;
          }
          ae.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.fNT.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          ((Preference)localObject1).setTitle(2131757596);
          break;
          ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(localc.Kn());
          this.screen.cT("contact_info_subscribe_bizinfo", false);
        }
        label4570:
        if (com.tencent.mm.contact.c.lO(this.contact.field_type))
        {
          if (localc != null)
          {
            localObject1 = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
            localObject2 = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
            if (localc.Kx())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131758433);
              localObject5 = ag.aGt().eQ(localc.field_username);
              this.xhi = ag.aGt().eP((String)localObject5);
              if (this.xhi != null) {
                if (!this.xhi.hk(4))
                {
                  bool = true;
                  ((CheckBoxPreference)localObject1).setChecked(bool);
                  if (!localc.Kn()) {
                    break label5053;
                  }
                  if ((this.cRb == null) && (localc != null)) {
                    this.cRb = localc.bX(false);
                  }
                  if ((this.cRb == null) || (!this.cRb.KH()) || (!com.tencent.mm.br.d.aJN("brandservice"))) {
                    break label5036;
                  }
                  this.screen.cT("contact_info_template_recv", false);
                  if (!localc.bX(false).Kr()) {
                    break label5070;
                  }
                  ((CheckBoxPreference)localObject2).setChecked(localc.Ko());
                }
              }
            }
          }
          for (;;)
          {
            this.screen.cT("contact_info_biz_read_msg_online", true);
            this.screen.cT("contact_info_biz_add", true);
            localObject1 = this.contact.adG();
            if (localObject1 != null) {
              this.fNT.setMMTitle((String)localObject1);
            }
            if (x.AA(this.contact.field_username))
            {
              localObject1 = (ButtonPreference)this.screen.aXe("contact_info_biz_go_chatting");
              ((ButtonPreference)localObject1).JMp = true;
              ((ButtonPreference)localObject1).gE(this.fNT.getResources().getString(2131757806), this.fNT.getResources().getColor(2131100035));
              this.fNT.setMMTitle(2131757883);
            }
            if ((!x.AV(this.contact.field_username)) && (this.xfE != null)) {
              this.fNT.addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
            ae.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
            break label4691;
            if (localc.Kv())
            {
              ((CheckBoxPreference)localObject1).setTitle(2131761483);
              if (!ag.aGy().Ee(localc.field_username)) {}
              for (bool = true;; bool = false)
              {
                ((CheckBoxPreference)localObject1).setChecked(bool);
                break;
              }
            }
            ((CheckBoxPreference)localObject1).setChecked(localc.Kn());
            break label4691;
            this.screen.cT("contact_info_template_recv", true);
            break label4761;
            this.screen.cT("contact_info_template_recv", true);
            break label4761;
            this.screen.cT("contact_info_locate", true);
            ((CheckBoxPreference)localObject2).setChecked(localc.Ko());
            continue;
            this.screen.cT("contact_info_subscribe_bizinfo", true);
            this.screen.cT("contact_info_locate", true);
            this.screen.cT("contact_info_template_recv", true);
          }
        }
        label4691:
        ae.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[] { this.contact.field_username });
        label5053:
        label5070:
        dDX();
        localObject1 = this.screen.aXe("contact_info_biz_add");
        if ((localObject1 != null) && (this.xhm)) {
          ((Preference)localObject1).setTitle(2131757603);
        }
        if (Ny(this.jij))
        {
          if (localc != null) {
            break label5240;
          }
          ae.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
        }
        for (;;)
        {
          this.fNT.showOptionMenu(false);
          AppMethodBeat.o(27094);
          return;
          label5240:
          ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(localc.Kn());
          this.screen.cT("contact_info_subscribe_bizinfo", false);
        }
        localObject1 = localIndexOutOfBoundsException1;
        break label1139;
        Object localObject3 = null;
        break label1006;
      }
    }
  }
  
  private void dDX()
  {
    AppMethodBeat.i(27096);
    if ((this.contact != null) && (com.tencent.mm.contact.c.lO(this.contact.field_type)) && (!x.AA(this.contact.field_username)) && (!x.Bh(this.contact.field_username)))
    {
      this.screen.cT("contact_is_mute", false);
      this.screen.cT("contact_info_verifyuser_weibo", true);
      this.screen.cT("contact_info_subscribe_bizinfo", true);
      this.screen.cT("contact_info_template_recv", true);
      this.screen.cT("contact_info_locate", true);
      if (this.xhl) {
        break label315;
      }
      this.screen.cT("contact_info_time_expired", true);
      label143:
      if ((this.contact == null) || ((!x.AV(this.contact.field_username)) && (!x.Bh(this.contact.field_username))) || (!com.tencent.mm.contact.c.lO(this.contact.field_type))) {
        break label332;
      }
      this.screen.cT("contact_info_biz_go_chatting", false);
    }
    for (;;)
    {
      if (x.Bh(this.contact.field_username)) {
        this.screen.cT("contact_info_user_desc", true);
      }
      AppMethodBeat.o(27096);
      return;
      this.screen.cT("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.contact.c.lO(this.contact.field_type)) && (Ny(this.jij)))
      {
        this.screen.cT("contact_info_expose_btn", false);
        break;
      }
      this.screen.cT("contact_info_expose_btn", true);
      break;
      label315:
      this.screen.cT("contact_info_biz_add", true);
      break label143;
      label332:
      this.screen.cT("contact_info_biz_go_chatting", true);
    }
  }
  
  private boolean dDZ()
  {
    AppMethodBeat.i(27102);
    if (this.fNT.getIntent() == null)
    {
      AppMethodBeat.o(27102);
      return false;
    }
    String str1 = this.fNT.getIntent().getStringExtra("device_id");
    String str2 = this.fNT.getIntent().getStringExtra("device_type");
    ds localds = new ds();
    localds.dpD.cVh = str1;
    localds.dpD.dpB = str2;
    com.tencent.mm.sdk.b.a.IvT.l(localds);
    boolean bool = localds.dpE.dpF;
    AppMethodBeat.o(27102);
    return bool;
  }
  
  private void dEb()
  {
    AppMethodBeat.i(27111);
    ae.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
    if (this.sp == null) {
      this.sp = this.fNT.getSharedPreferences(this.fNT.getPackageName() + "_preferences", 0);
    }
    if (this.fON != null)
    {
      if (this.contact == null) {
        break label119;
      }
      this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.adB()).commit();
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
  
  private void py(boolean paramBoolean)
  {
    AppMethodBeat.i(27104);
    if (this.contact != null) {
      if (this.fNT != null)
      {
        if ((!paramBoolean) || (com.tencent.mm.al.g.vz(this.contact.field_username))) {
          break label77;
        }
        this.fNT.setTitleMuteIconVisibility(0);
      }
    }
    for (;;)
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aXe("contact_is_mute");
      if (localCheckBoxPreference != null) {
        localCheckBoxPreference.setChecked(paramBoolean);
      }
      AppMethodBeat.o(27104);
      return;
      label77:
      this.fNT.setTitleMuteIconVisibility(8);
    }
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(27110);
    if ((this.xfE == null) || (!this.xfE.Kx()))
    {
      AppMethodBeat.o(27110);
      return;
    }
    if (paramn.getType() == 1354)
    {
      paramn = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
      String str = ag.aGt().eQ(this.xfE.field_username);
      this.xhi = ag.aGt().eP(str);
      if (this.xhi != null)
      {
        if (!this.xhi.hk(4)) {}
        for (boolean bool = true;; bool = false)
        {
          paramn.setChecked(bool);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(27110);
          return;
        }
      }
      ae.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
    }
    AppMethodBeat.o(27110);
  }
  
  final void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27092);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
    cac localcac = new cac();
    localcac.jgj = paramc.field_brandFlag;
    localcac.nIJ = this.contact.field_username;
    if (Ny(this.jij))
    {
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(58, localcac));
    }
    for (;;)
    {
      ag.aGp().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.Kn());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.Ko());
      }
      if (paramBoolean) {
        dDW();
      }
      AppMethodBeat.o(27092);
      return;
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(47, localcac));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27093);
    boolean bool;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
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
      this.contact = paraman;
      this.xfQ = paramBoolean;
      this.jij = paramInt;
      this.xho = this.fNT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.xht = ((SnsAdClick)this.fNT.getIntent().getParcelableExtra("KSnsAdTag"));
      this.xhs = this.fNT.getIntent().getBundleExtra("Contact_Ext_Args");
      this.xhu = this.fNT.getIntent().getStringExtra("key_add_contact_report_info");
      dDW();
      paramf = this.fNT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bu.isNullOrNil(paramf))
      {
        this.fNT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.fNT, paramf, "", this.fNT.getString(2131755835), null);
      }
      if (paraman != null)
      {
        ag.aGB().DZ(paraman.field_username);
        if (com.tencent.mm.al.g.Eq(paraman.field_username))
        {
          paramf = paraman.field_username;
          if (!com.tencent.mm.al.g.vz(paramf)) {
            break label301;
          }
          ag.aGx();
          com.tencent.mm.al.a.h.a(paramf, this);
          paramf = com.tencent.mm.al.g.eX(paramf).KD();
          if (paramf != null) {
            ag.aGB().DZ(paramf);
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
      if (com.tencent.mm.al.g.Es(paramf))
      {
        ag.aGy();
        com.tencent.mm.al.e.a(paramf, this);
        ag.aGp();
        paramf = com.tencent.mm.al.f.Ej(paramf);
        if (paramf != null) {
          ag.aGB().DZ(paramf);
        }
      }
    }
  }
  
  public final String aGb()
  {
    return "MicroMsg.ContactWidgetBizInfo";
  }
  
  public final boolean abx(final String paramString)
  {
    AppMethodBeat.i(27090);
    if (paramString == null)
    {
      AppMethodBeat.o(27090);
      return false;
    }
    if (paramString.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this.fNT).iK(this.contact.eRj, this.contact.field_username);
      AppMethodBeat.o(27090);
      return true;
    }
    Object localObject1;
    if ("contact_info_biz_go_chatting".endsWith(paramString))
    {
      if (this.xht != null)
      {
        paramString = new qx();
        this.xht.ipN = 5;
        paramString.dGz.dGA = this.xht;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
      if ((this.xfE != null) && ((this.xfE.Kv()) || (this.xfE.Kx())))
      {
        paramString = new Intent();
        if (this.xfE.Kx())
        {
          localObject1 = this.xfE.KD();
          if (bu.isNullOrNil((String)localObject1))
          {
            ae.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
            AppMethodBeat.o(27090);
            return false;
          }
          paramString.putExtra("enterprise_biz_name", (String)localObject1);
          paramString.putExtra("enterprise_biz_display_name", w.zP((String)localObject1));
          paramString.addFlags(67108864);
          com.tencent.mm.br.d.f(this.fNT, ".ui.conversation.EnterpriseConversationUI", paramString);
          this.fNT.finish();
        }
      }
      for (;;)
      {
        bB(5, null);
        AppMethodBeat.o(27090);
        return true;
        paramString.putExtra("enterprise_biz_name", this.contact.field_username);
        paramString.putExtra("enterprise_biz_display_name", w.zP(this.contact.field_username));
        break;
        paramString = new Intent();
        if (this.fNT.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
          paramString.setFlags(268435456);
        }
        if (this.xfQ)
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          this.fNT.setResult(-1, paramString);
        }
        else
        {
          paramString.putExtra("Chat_User", this.contact.field_username);
          paramString.putExtra("Chat_Mode", 1);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.profile.b.iUz.d(paramString, this.fNT);
        }
      }
    }
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aDx()) {
        dDY();
      }
      for (;;)
      {
        if (this.xho != 0) {
          com.tencent.mm.plugin.report.service.g.yxI.f(11263, new Object[] { Integer.valueOf(this.xho), this.contact.field_username });
        }
        AppMethodBeat.o(27090);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.fNT, com.tencent.mm.model.gdpr.a.hLL, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void oJ(int paramAnonymousInt)
          {
            AppMethodBeat.i(27075);
            if (paramAnonymousInt == 0) {
              c.this.dDY();
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
      if (((CheckBoxPreference)this.screen.aXe("contact_info_stick_biz")).isChecked())
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(this.jij) });
        com.tencent.mm.model.j.zm(this.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(27090);
        return true;
        x.E(this.contact.field_username, true);
        com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { this.contact.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(this.jij) });
      }
    }
    if (("contact_info_guarantee_info".equals(paramString)) && (this.cRb.KO() != null) && (!bu.isNullOrNil(this.cRb.KO().cSe)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", this.cRb.KO().cSe);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      com.tencent.mm.br.d.b(this.fNT, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    int i;
    Object localObject2;
    if (paramString.startsWith("contact_info_bizinfo_external#"))
    {
      i = bu.getInt(paramString.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.cRa.size()))
      {
        paramString = (c.a)this.cRa.get(i);
        localObject2 = paramString.url;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        if (((this.xhs != null) && ((this.jij == 39) || (this.jij == 56) || (this.jij == 35))) || (this.jij == 87) || (this.jij == 89) || (this.jij == 85) || (this.jij == 88))
        {
          ae.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject2).putBundle("KBizSearchExtArgs", this.xhs);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
          if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
            break label1169;
          }
        }
        label1169:
        for (i = 7;; i = 6)
        {
          int j = this.fNT.getResources().getIdentifier(paramString.cRe, "string", this.fNT.getPackageName());
          paramString = paramString.title;
          if (j > 0) {
            paramString = this.fNT.getString(j);
          }
          bB(i, paramString);
          com.tencent.mm.br.d.b(this.fNT, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
      localObject1 = this.xfE;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ("contact_info_subscribe_bizinfo".endsWith(paramString)) {
        if (((com.tencent.mm.api.c)localObject1).Ku()) {
          if (localObject1 != null)
          {
            if (!((com.tencent.mm.api.c)localObject1).Kx()) {
              break label1393;
            }
            bc.ajj().a(1363, this);
            if (!((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).isChecked()) {
              break label1388;
            }
            i = 0;
            paramString = new com.tencent.mm.plugin.profile.b.c(((com.tencent.mm.api.c)localObject1).field_username, i);
            bc.ajj().a(paramString, 0);
            localObject2 = this.fNT;
            this.fNT.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fNT.getString(2131755936), true, new c.15(this, paramString));
          }
        }
      }
      for (;;)
      {
        if ((!((com.tencent.mm.api.c)localObject1).Kx()) && (!((com.tencent.mm.api.c)localObject1).Kv())) {
          a((com.tencent.mm.api.c)localObject1, false);
        }
        AppMethodBeat.o(27090);
        return true;
        i = 4;
        break;
        if (((com.tencent.mm.api.c)localObject1).Kv())
        {
          paramString = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
          ag.aGy();
          localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
          if (!paramString.isChecked()) {}
          for (bool = true;; bool = false)
          {
            paramString = com.tencent.mm.al.e.a((String)localObject2, bool, this);
            localObject2 = this.fNT;
            this.fNT.getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fNT.getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(27086);
                ag.aGy();
                com.tencent.mm.al.e.a(paramString);
                AppMethodBeat.o(27086);
              }
            });
            break;
          }
          if (((com.tencent.mm.api.c)localObject1).Kn())
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag |= 0x1;
            if ((this.cRb == null) && (localObject1 != null)) {
              this.cRb = ((com.tencent.mm.api.c)localObject1).bX(false);
            }
            if ((this.cRb != null) && (this.cRb.KH()) && (com.tencent.mm.br.d.aJN("brandservice")))
            {
              this.screen.cT("contact_info_template_recv", false);
              label1584:
              paramString = com.tencent.mm.plugin.report.service.g.yxI;
              localObject2 = ((com.tencent.mm.api.c)localObject1).field_username;
              if (!((com.tencent.mm.api.c)localObject1).Kn()) {
                break label1709;
              }
            }
          }
          label1709:
          for (i = 3;; i = 4)
          {
            paramString.f(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), "", Integer.valueOf(this.jij) });
            break;
            this.screen.cT("contact_info_template_recv", true);
            break label1584;
            ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFE;
            this.screen.cT("contact_info_template_recv", true);
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
            if (((com.tencent.mm.api.c)localObject1).Ko()) {
              ((com.tencent.mm.api.c)localObject1).field_brandFlag &= 0xFFFFFFFB;
            } else {
              this.xhr = com.tencent.mm.ui.base.h.a(this.fNT, this.fNT.getString(2131757139, new Object[] { this.contact.adG() }), this.fNT.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27071);
                  this.cXA.field_hadAlert = 1;
                  this.cXA.field_brandFlag |= 0x4;
                  c.this.a(this.cXA, true);
                  AppMethodBeat.o(27071);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(27082);
                  this.cXA.field_hadAlert = 1;
                  c.this.a(this.cXA, false);
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
      paramString = this.xfE;
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
      if ((((c.b)localObject2).KQ() != null) && (!bu.isNullOrNil(((c.b)localObject2).KQ().cRZ))) {
        paramString = ((c.b)localObject2).KQ().cRZ;
      }
      for (;;)
      {
        if (!bu.isNullOrNil(paramString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramString);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          ((Intent)localObject1).putExtra("geta8key_scene", 3);
          com.tencent.mm.br.d.b(this.fNT, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        AppMethodBeat.o(27090);
        return true;
        paramString = (String)localObject1;
        if (((c.b)localObject2).KR() != null)
        {
          paramString = (String)localObject1;
          if (!bu.isNullOrNil(((c.b)localObject2).KR().cSh)) {
            paramString = ((c.b)localObject2).KR().cSh;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramString))
    {
      paramString = this.xfE;
      if (paramString == null)
      {
        AppMethodBeat.o(27090);
        return true;
      }
      if ((paramString.bX(false) != null) && (!bu.isNullOrNil(paramString.bX(false).KJ())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString.bX(false).KJ());
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        com.tencent.mm.br.d.b(this.fNT, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(27090);
      return true;
    }
    if ("contact_is_mute".endsWith(paramString))
    {
      if (!this.fOX)
      {
        bool = true;
        this.fOX = bool;
        if (!this.fOX) {
          break label2687;
        }
        x.z(this.contact);
        label2246:
        py(this.fOX);
      }
    }
    else
    {
      if ("enterprise_contact_info_enter".equals(paramString))
      {
        if (this.fNT != null) {
          break label2697;
        }
        ae.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
      }
      label2279:
      if ("contact_info_biz_disable".equals(paramString))
      {
        localObject1 = this.fNT.getString(2131758435);
        localObject2 = this.fNT.getString(2131758434);
        com.tencent.mm.ui.base.h.e(this.fNT, (String)localObject1, "", (String)localObject2, this.fNT.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27083);
            c.this.px(false);
            AppMethodBeat.o(27083);
          }
        }, null);
      }
      if ("contact_info_biz_enable".equals(paramString)) {
        px(true);
      }
      if ("contact_info_template_recv".equals(paramString))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enterprise_biz_name", this.xfE.field_username);
        com.tencent.mm.br.d.b(this.fNT, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject1);
      }
      if ("contact_info_service_phone".equals(paramString))
      {
        localObject1 = this.screen.aXe("contact_info_service_phone");
        if ((localObject1 != null) && (((Preference)localObject1).getSummary() != null) && (!bu.isNullOrNil(((Preference)localObject1).getSummary().toString())))
        {
          localObject1 = ((Preference)localObject1).getSummary().toString();
          com.tencent.mm.ui.base.h.a(this.fNT, true, (String)localObject1, "", this.fNT.getString(2131757643), this.fNT.getString(2131755691), new c.7(this, (String)localObject1), null);
        }
      }
      if ("contact_info_expose_btn".equals(paramString)) {
        dEa();
      }
      if (paramString.equals("biz_placed_to_the_top"))
      {
        ae.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
        if (this.sp == null) {
          this.sp = this.fNT.getSharedPreferences(this.fNT.getPackageName() + "_preferences", 0);
        }
        if (this.contact != null)
        {
          if (!this.contact.adB()) {
            break label2767;
          }
          ae.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[] { this.contact.field_username });
          x.E(this.contact.field_username, true);
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
      x.A(this.contact);
      break label2246;
      label2697:
      if (this.xfE == null)
      {
        ae.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
        break label2279;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("enterprise_biz_name", this.xfE.field_username);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.d.b(this.fNT, "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject1);
      break label2279;
      label2767:
      com.tencent.mm.model.j.zm(this.contact.field_username);
      ae.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[] { this.contact.field_username });
      this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
    }
  }
  
  final void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(27100);
    if ((this.xhs == null) || ((this.jij != 39) && (this.jij != 56) && (this.jij != 35) && (this.jij != 87) && (this.jij != 88) && (this.jij != 89) && (this.jij != 85)))
    {
      ae.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27100);
      return;
    }
    if (this.contact == null)
    {
      ae.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
      AppMethodBeat.o(27100);
      return;
    }
    String str2 = this.xhs.getString("Contact_Ext_Args_Search_Id");
    String str3 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Args_Query_String"));
    int j = this.xhs.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.jij)
    {
    default: 
      i = 0;
      str1 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bu.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bu.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ae.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10866, paramString);
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
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27097);
    BizInfoHeaderPreference localBizInfoHeaderPreference = (BizInfoHeaderPreference)this.screen.aXe("contact_info_header_bizinfo");
    if (localBizInfoHeaderPreference != null) {
      localBizInfoHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27097);
    return true;
  }
  
  final void dDY()
  {
    AppMethodBeat.i(27101);
    if ((this.fNT.getIntent() != null) && (this.fNT.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.fNT.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bu.isNullOrNil((String)localObject1)) {
        break label163;
      }
      ae.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label163:
    while (dDZ())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.fNT, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(27077);
          an localan;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cm(c.this.fNT, c.this.fNT.getString(2131757590));
            c.this.screen.cT("contact_info_time_expired", true);
            localan = c.this.contact;
            if ((localan == null) || (bu.isNullOrNil(paramAnonymousString1)))
            {
              ae.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localan);
              c.this.xhn = true;
              if (c.this.xht != null)
              {
                paramAnonymousString1 = new qx();
                c.this.xht.ipN = 4;
                paramAnonymousString1.dGz.dGA = c.this.xht;
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString1);
              }
              paramAnonymousString1 = ag.aGp().Ef(c.this.contact.field_username);
              paramAnonymousString1.field_status = 1;
              if ((!bu.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bu.isNullOrNil(paramAnonymousString1.field_username)) || (c.this.xfE == null) || (!paramAnonymousString1.field_username.equals(bu.nullAsNil(c.this.xfE.field_username)))) {
                break label675;
              }
              ag.aGp().g(c.this.xfE);
              label249:
              paramAnonymousBoolean1 = c.this.fNT.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
              paramAnonymousBoolean2 = c.this.fNT.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
              if (!paramAnonymousString1.Kv()) {
                break label686;
              }
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("enterprise_biz_name", c.this.contact.field_username);
              paramAnonymousString1.putExtra("enterprise_biz_display_name", w.zP(c.this.contact.field_username));
              paramAnonymousString1.putExtra("enterprise_from_scene", 7);
              paramAnonymousString1.addFlags(67108864);
              com.tencent.mm.br.d.f(c.this.fNT, ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
              label364:
              c.this.fNT.finish();
              label374:
              c.this.bB(3, null);
            }
          }
          else
          {
            AppMethodBeat.o(27077);
            return;
          }
          if (x.Am(localan.field_username))
          {
            String str = bu.nullAsNil(localan.field_username);
            paramAnonymousString2 = com.tencent.mm.al.g.eX(str);
            if (paramAnonymousString2 != null) {
              paramAnonymousString2.field_username = paramAnonymousString1;
            }
            ag.aGp().delete(str);
            localan.tu(str);
          }
          for (;;)
          {
            localan.setUsername(paramAnonymousString1);
            if ((int)localan.ght == 0)
            {
              bc.aCg();
              com.tencent.mm.model.c.azF().ao(localan);
            }
            if ((int)localan.ght <= 0)
            {
              ae.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
              break;
            }
            x.B(localan);
            bc.aCg();
            paramAnonymousString1 = com.tencent.mm.model.c.azF().BH(localan.field_username);
            if (paramAnonymousString2 != null)
            {
              ag.aGp().f(paramAnonymousString2);
              break;
            }
            paramAnonymousString2 = com.tencent.mm.al.g.eX(paramAnonymousString1.field_username);
            if ((paramAnonymousString1.fug()) && (com.tencent.mm.al.a.aFH())) {}
            for (int i = 1;; i = 0)
            {
              if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.Kp()) || (i != 0))) {
                break label616;
              }
              ae.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
              au.a.hIG.aJ(paramAnonymousString1.field_username, "");
              com.tencent.mm.aj.c.Dv(paramAnonymousString1.field_username);
              break;
            }
            label616:
            if ((!paramAnonymousString1.fuk()) || (i != 0)) {
              break;
            }
            ae.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.eRm) });
            au.a.hIG.aJ(paramAnonymousString1.field_username, "");
            com.tencent.mm.aj.c.Dv(paramAnonymousString1.field_username);
            break;
            label675:
            ag.aGp().g(paramAnonymousString1);
            break label249;
            label686:
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("Chat_User", c.this.contact.field_username);
            paramAnonymousString1.putExtra("key_has_add_contact", true);
            paramAnonymousString1.putExtra("finish_direct", true);
            if (paramAnonymousBoolean2) {
              paramAnonymousString1.addFlags(268435456);
            }
            com.tencent.mm.plugin.profile.b.iUz.d(paramAnonymousString1, c.this.fNT);
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
      ((LinkedList)localObject2).add(Integer.valueOf(this.jij));
      if (this.cRk != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fnk = this.cRk;
      }
      if (!bu.isNullOrNil(this.tIA)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).tIA = this.tIA;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fnq = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.xhu);
      AppMethodBeat.o(27101);
      return;
    }
    ae.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bc.ajj().a(536, this);
    Object localObject2 = new do();
    ((do)localObject2).dps.dpu = ((String)localObject1);
    ((do)localObject2).dps.opType = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((do)localObject2).dpt.dpw;
    localObject2 = this.fNT;
    this.fNT.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.fNT.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(27076);
        bc.ajj().b(536, c.this);
        paramAnonymousDialogInterface = new do();
        paramAnonymousDialogInterface.dps.opType = 2;
        paramAnonymousDialogInterface.dps.dpw = this.djA;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(27076);
      }
    });
    AppMethodBeat.o(27101);
  }
  
  final void dEa()
  {
    AppMethodBeat.i(27103);
    if ((this.contact == null) || (bu.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(27103);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this.fNT, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27103);
  }
  
  public final void e(LinkedList<ehf> paramLinkedList)
  {
    AppMethodBeat.i(27109);
    ag.aGq().b(this);
    if (this.screen == null)
    {
      ae.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (this.contact == null)
    {
      ae.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27109);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27109);
      return;
    }
    if (!bu.isNullOrNil(this.xhp))
    {
      localObject = paramLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ehf localehf = (ehf)((Iterator)localObject).next();
        if ((localehf.IkU != null) && (localehf.IkU.equals(this.xhp)))
        {
          this.screen.cT("contact_info_kf_worker", false);
          this.screen.aXe("contact_info_kf_worker").setSummary(localehf.Nickname);
          AppMethodBeat.o(27109);
          return;
        }
      }
    }
    this.screen.cT("contact_info_kf_worker", false);
    Object localObject = this.screen.aXe("contact_info_kf_worker");
    if ((localObject != null) && (paramLinkedList != null) && (paramLinkedList.get(0) != null)) {
      ((Preference)localObject).setSummary(((ehf)paramLinkedList.get(0)).Nickname);
    }
    AppMethodBeat.o(27109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27098);
    if (this.fNT == null)
    {
      ae.e("MicroMsg.ContactWidgetBizInfo", "null == context");
      AppMethodBeat.o(27098);
      return;
    }
    ae.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.g.doC().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.fNT, this.fNT.getString(2131759420));
      AppMethodBeat.o(27098);
      return;
    }
    AppMethodBeat.o(27098);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27108);
    ae.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.xhq = false;
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ae.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
      AppMethodBeat.o(27108);
      return;
    }
    bc.ajj().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27108);
      return;
    }
    ae.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      bc.ajj().b(536, this);
      dDW();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1363)
    {
      paramString = (com.tencent.mm.plugin.profile.b.c)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (paramString = (dcv)paramString.rr.hQE.hQJ;; paramString = null)
      {
        localObject2 = (com.tencent.mm.plugin.profile.b.c)paramn;
        paramn = (n)localObject1;
        if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr != null)
        {
          paramn = (n)localObject1;
          if (((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hQD.hQJ != null) {
            paramn = (dcu)((com.tencent.mm.plugin.profile.b.c)localObject2).rr.hQD.hQJ;
          }
        }
        if ((paramString != null) && (paramString.FZD != null) && (paramString.FZD.ret == 0) && (paramString.FZA != null) && (!bu.isNullOrNil(paramString.FZA.FZy))) {
          break label413;
        }
        if ((paramString == null) || (paramString.FZD == null)) {
          break;
        }
        ae.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramString.FZD.ret) });
        AppMethodBeat.o(27108);
        return;
      }
      ae.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(27108);
      return;
      label413:
      if (paramString.FZA == null)
      {
        ae.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
        AppMethodBeat.o(27108);
        return;
      }
      Object localObject2 = ag.aGt().eP(paramString.FZA.FZy);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new com.tencent.mm.al.a.k();
        ((com.tencent.mm.al.a.k)localObject1).field_userId = paramString.FZA.FZy;
      }
      ((com.tencent.mm.al.a.k)localObject1).field_userName = paramString.FZA.oIy;
      ((com.tencent.mm.al.a.k)localObject1).field_brandUserName = paramn.FZx;
      ((com.tencent.mm.al.a.k)localObject1).field_UserVersion = paramString.FZA.ver;
      ((com.tencent.mm.al.a.k)localObject1).field_headImageUrl = paramString.FZA.FZr;
      ((com.tencent.mm.al.a.k)localObject1).field_profileUrl = paramString.FZA.FZG;
      ((com.tencent.mm.al.a.k)localObject1).field_bitFlag = paramString.FZA.FZs;
      ((com.tencent.mm.al.a.k)localObject1).field_addMemberUrl = paramString.FZA.FZv;
      ((com.tencent.mm.al.a.k)localObject1).field_needToUpdate = false;
      if (!ag.aGt().b((com.tencent.mm.al.a.k)localObject1)) {
        ag.aGt().a((com.tencent.mm.al.a.k)localObject1);
      }
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dDI();
      localObject1 = ((com.tencent.mm.plugin.profile.b.d)paramn).dDH();
      if ((localObject1 == null) || (((dma)localObject1).FZD == null) || (((dma)localObject1).FZD.ret != 0))
      {
        if ((localObject1 != null) && (((dma)localObject1).FZD != null))
        {
          ae.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dma)localObject1).FZD.ret) });
          AppMethodBeat.o(27108);
          return;
        }
        ae.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(27108);
        return;
      }
      if (!paramString.lXh)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label975;
        }
        paramString = this.xfE;
        paramString.field_brandFlag &= 0xFFFFFFFE;
        a(paramString, true);
        bc.aCg();
        if (com.tencent.mm.model.c.azL().aVa(paramString.field_username) == null)
        {
          paramn = new au(paramString.field_username);
          paramn.tY(bu.nullAsNil(this.xfE.KD()));
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().arc(paramString.field_username);
          if (localObject1 == null) {
            break label931;
          }
          bc.aCg();
          com.tencent.mm.model.c.azL().e(paramn);
          bc.aCg();
          com.tencent.mm.model.c.azL().aL((bv)localObject1);
        }
      }
      for (;;)
      {
        bc.aCg();
        if (com.tencent.mm.model.c.azL().aVa(paramString.field_enterpriseFather) != null) {
          break label954;
        }
        paramString = new au(paramString.field_enterpriseFather);
        paramString.fuK();
        bc.aCg();
        com.tencent.mm.model.c.azL().e(paramString);
        AppMethodBeat.o(27108);
        return;
        paramInt1 = 0;
        break;
        label931:
        paramn.fuK();
        bc.aCg();
        com.tencent.mm.model.c.azL().e(paramn);
      }
      label954:
      bc.aCg();
      com.tencent.mm.model.c.azK().aTS(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
      label975:
      paramString = this.xfE;
      paramString.field_brandFlag |= 0x1;
      a(paramString, true);
      bc.aCg();
      com.tencent.mm.model.c.azL().aUY(paramString.field_username);
      bc.aCg();
      if (com.tencent.mm.model.c.azL().aVm(paramString.field_enterpriseFather) <= 0)
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aUY(paramString.field_enterpriseFather);
        AppMethodBeat.o(27108);
        return;
      }
      bc.aCg();
      com.tencent.mm.model.c.azK().aTS(paramString.field_enterpriseFather);
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1343)
    {
      dDW();
      AppMethodBeat.o(27108);
      return;
    }
    if (paramn.getType() == 1228) {
      dDW();
    }
    AppMethodBeat.o(27108);
  }
  
  final void px(boolean paramBoolean)
  {
    AppMethodBeat.i(27091);
    Object localObject = this.xfE.field_username;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = new com.tencent.mm.plugin.profile.b.d((String)localObject, paramBoolean);
      bc.ajj().a(1394, this);
      bc.ajj().a((n)localObject, 0);
      MMActivity localMMActivity = this.fNT;
      this.fNT.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localMMActivity, this.fNT.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(27084);
          bc.ajj().a(this.oer);
          bc.ajj().b(1394, c.this);
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