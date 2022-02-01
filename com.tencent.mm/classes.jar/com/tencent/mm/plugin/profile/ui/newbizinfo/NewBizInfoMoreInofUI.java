package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.al.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI
  extends MMPreference
  implements i.b
{
  private static final String Bff;
  private com.tencent.mm.api.c Bdk;
  private aeq BeX;
  private String Bfc;
  private boolean Bfd;
  private Bundle Bfg;
  private as contact;
  private boolean dhC = false;
  private List<c.a> dhu;
  private c.b dhv;
  private int kgm;
  private f screen;
  
  static
  {
    AppMethodBeat.i(231957);
    Bff = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(231957);
  }
  
  private void aKr(String paramString)
  {
    AppMethodBeat.i(27553);
    MMHandlerThread.postToMainThreadDelayed(new NewBizInfoMoreInofUI.3(this, paramString), 2000L);
    AppMethodBeat.o(27553);
  }
  
  private void bP(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.Bfg == null) || ((this.kgm != 39) && (this.kgm != 56) && (this.kgm != 35) && (this.kgm != 87) && (this.kgm != 88) && (this.kgm != 89) && (this.kgm != 85)))
    {
      Log.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27556);
      return;
    }
    if (this.contact == null)
    {
      Log.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(27556);
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
      Log.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10866, paramString);
      AppMethodBeat.o(27556);
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
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    com.tencent.mm.aj.j localj = p.aYB();
    if (localj.Mx(paramh.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramh.field_openId;
      locali.iKW = paramh.field_headImgUrl;
      locali.fv(false);
      locali.fuz = 3;
      localj.b(locali);
    }
    p.aYD().Mh(paramh.field_openId);
    Log.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private c.a eFg()
  {
    AppMethodBeat.i(27551);
    if ((this.dhu == null) || (this.dhu.size() < 0))
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.dhu.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.dhy.equals("__mp_wording__brandinfo_location")) || (getString(2131757849).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String aZT()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<fbw> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    ag.bai().b(this);
    if (this.screen == null)
    {
      Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (this.contact == null)
    {
      Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27554);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (!Util.isNullOrNil(this.Bfc))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        fbw localfbw = (fbw)localIterator.next();
        if ((localfbw.NxV != null) && (localfbw.NxV.equals(this.Bfc)))
        {
          this.screen.jdMethod_do("contact_info_kf_worker", false);
          this.screen.bmg("contact_info_kf_worker").setSummary(localfbw.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.jdMethod_do("contact_info_kf_worker", false);
    this.screen.bmg("contact_info_kf_worker").setSummary(((fbw)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return 2132017241;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.jdMethod_do("biz_placed_to_the_top", true);
    Object localObject2 = g.fJ(this.contact.field_username);
    this.dhu = null;
    this.dhv = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).cG(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.BeX != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.BeX.kem;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.BeX.kep;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.BeX.keo;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.BeX.ken;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).cG(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.BeX != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.BeX.kem;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.BeX.kep;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.BeX.keo;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.BeX.ken;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).cG(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.Bdk = ((com.tencent.mm.api.c)localObject1);
      this.dhu = ((com.tencent.mm.api.c)localObject1).UO();
      this.dhv = ((com.tencent.mm.api.c)localObject1).cG(false);
      this.dhC = this.dhv.UQ();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
      if (this.Bdk == null)
      {
        bool = true;
        if (!bool) {
          break label1244;
        }
        localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_wechat_account");
        if (Util.isNullOrNil(this.contact.ajx())) {
          break label1125;
        }
        this.screen.jdMethod_do("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(l.c(this, this.contact.ajx()));
        ((Preference)localObject1).OZq = new NewBizInfoMoreInofUI.2(this, (KeyValuePreference)localObject1);
        if ((this.dhv == null) || (this.dhv.Va() == null) || (Util.isNullOrNil(this.dhv.Va().diq))) {
          break label1392;
        }
        localObject4 = this.dhv.Va();
        localObject6 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1375;
        }
        ((KeyValuePreference)localObject6).gLK();
        ((KeyValuePreference)localObject6).OYB = false;
        if (!Util.isNullOrNil(((c.b.e)localObject4).dis)) {
          break label1306;
        }
        i = ((c.b.e)localObject4).dip;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(2131757925);
          label551:
          ((KeyValuePreference)localObject6).OFU = ((String)localObject1);
          label558:
          if (ay.a.iDs != null)
          {
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(this.contact.field_verifyFlag), 2.0F);
            label585:
            if (localObject1 == null) {
              break label3239;
            }
            localObject2 = BitmapUtil.getBitmapNative(2131691230);
          }
          break;
        }
      }
    }
    label621:
    label1392:
    label3061:
    label3198:
    Object localObject3;
    label1306:
    label3226:
    label3232:
    label3239:
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        Log.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).OYI = ((Drawable)localObject2);
        if (((c.b.e)localObject4).diq == null) {
          break label1364;
        }
        str = ((c.b.e)localObject4).diu;
        localObject2 = l.c(this, ((c.b.e)localObject4).diq.trim());
        if (Util.isNullOrNil(str)) {
          break label3232;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new SpannableString(str + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          label1125:
          localObject1 = localObject2;
          label1244:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.dhv == null) || (Util.isNullOrNil(this.dhv.UU()))) {
            break label1502;
          }
          localObject2 = (KeyValuePreference)this.screen.bmg("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).gLK();
          ((KeyValuePreference)localObject2).OYB = false;
          if (ay.a.iDs == null) {
            break label1490;
          }
          localObject1 = BitmapUtil.getBitmapNative(2131691234);
          if (localObject1 != null) {
            break label1496;
          }
          bool = true;
          Log.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3226;
          }
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            int k;
            continue;
            int j = k;
          }
          localObject1 = null;
          continue;
        }
        ((KeyValuePreference)localObject2).OYI = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.dhv.UU());
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.dhv.UU(), this.dhv.UT() });
        if ((this.dhv != null) && (this.dhv.UW() != null) && (this.dhv.UW().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_privilege");
          ((KeyValuePreference)localObject1).gLK();
          ((KeyValuePreference)localObject1).BC(false);
          ((KeyValuePreference)localObject1).gLJ();
          localObject2 = this.dhv.UW().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1541;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, 2131495128, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131302573)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).diz, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(2131308767)).setText(str);
          ((KeyValuePreference)localObject1).gz((View)localObject6);
          continue;
          bool = this.Bdk.UL();
          break;
          if ((!as.bjx(this.contact.field_username)) && (!ab.IR(this.contact.field_username)))
          {
            this.screen.jdMethod_do("contact_info_wechat_account", false);
            localObject2 = Util.nullAsNil(this.contact.arK());
            ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.plugin.profile.c.br(getContext(), this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, (String)localObject2));
            break label385;
          }
          this.screen.jdMethod_do("contact_info_wechat_account", true);
          break label385;
          this.screen.jdMethod_do("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(2131758135);
          break label551;
          localObject1 = getResources().getString(2131757841);
          break label551;
          localObject1 = getResources().getString(2131757842);
          break label551;
          ((KeyValuePreference)localObject6).OFU = ((c.b.e)localObject4).dis;
          break label558;
          localObject1 = null;
          break label585;
          bool = false;
          break label621;
          Log.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1364:
          Log.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1375:
          this.screen.jdMethod_do("contact_info_verifyuser", true);
          continue;
          if ((this.dhv != null) && (this.dhv.Vb() != null) && (!Util.isNullOrNil(this.dhv.Vb().diA)))
          {
            localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.dhv.Vb().diA);
            continue;
          }
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.jdMethod_do("contact_info_verifyuser", true);
          continue;
          label1490:
          localObject1 = null;
          continue;
          label1496:
          bool = false;
          continue;
          label1502:
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.jdMethod_do("contact_info_trademark", true);
          continue;
        }
        this.screen.jdMethod_do("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.Bfd) });
        if (!this.Bfd)
        {
          this.Bfc = ((String)localObject2);
          if ((this.dhv == null) || (!this.dhv.Vg()) || (this.contact == null)) {
            this.screen.jdMethod_do("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.dhv == null) || (Util.isNullOrNil(this.dhv.Vf()))) {
            break label3027;
          }
          this.screen.jdMethod_do("contact_info_service_phone", false);
          localObject1 = this.screen.bmg("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.dhv.Vf());
            ((Preference)localObject1).qlp = getResources().getColor(2131100685);
          }
          label1711:
          if ((this.dhv == null) || (this.dhv.UY() == null)) {
            break label3095;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bmg("contact_info_reputation");
          if (this.dhv.UY().div <= 0) {
            break label3044;
          }
          ((BizInfoPayInfoIconPreference)localObject1).UA(this.dhv.UY().div);
          label1773:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bmg("contact_info_guarantee_info");
          if ((this.dhv.UY().dix == null) || (this.dhv.UY().dix.size() <= 0)) {
            break label3061;
          }
          ((BizInfoPayInfoIconPreference)localObject1).fR(this.dhv.UY().dix);
          label1836:
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.dhv.UY().diw)) {
            break label3078;
          }
          ((KeyValuePreference)localObject1).setSummary(this.dhv.UY().diw);
          ((KeyValuePreference)localObject1).OYG = 4;
          ((KeyValuePreference)localObject1).BC(false);
          label1896:
          if ((!ab.J(this.contact)) || (this.contact.fuM == null) || (this.contact.fuM.equals(""))) {
            break label3140;
          }
          localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(Util.nullAs(this.contact.field_weiboNickname, "") + getString(2131765588, new Object[] { ab.JL(this.contact.fuM) }));
            ((Preference)localObject1).qlp = com.tencent.mm.cb.a.n(this, 2131100685);
            ((KeyValuePreference)localObject1).BC(false);
          }
          label2030:
          if ((this.dhv == null) || (!this.dhv.UP())) {
            break label3157;
          }
          this.screen.bmg("near_field_service").setSummary(2131768705);
          if (eFg() == null) {
            break label3174;
          }
          this.screen.jdMethod_do("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.indexOf("contact_info_category2");
          if ((k < 0) || (this.dhu == null) || (this.dhu.size() <= 0)) {
            break label3198;
          }
          i = this.dhu.size() - 1;
          while (i >= 0)
          {
            if ((this.dhu.get(i) != null) && ((!getString(2131757847).equals(((c.a)this.dhu.get(i)).title)) || (this.dhC)) && ((!Util.isNullOrNil(((c.a)this.dhu.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.dhu.get(i)).dhy))) && (!((c.a)this.dhu.get(i)).dhy.equals("__mp_wording__brandinfo_location")) && (!getString(2131757849).equals(((c.a)this.dhu.get(i)).title)) && (!((c.a)this.dhu.get(i)).dhy.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.dhu.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.dhu.get(i)).dhy, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.Bdk.UE()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.dhu.get(i)).dhy))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(2131755017))) {}
                }
                else
                {
                  localObject2 = getString(2131758725);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!Util.isNullOrNil(((c.a)this.dhu.get(i)).description)) {
                ((Preference)localObject5).setSummary(((c.a)this.dhu.get(i)).description);
              }
              if (!Util.nullAsNil(((c.a)this.dhu.get(i)).dhy).equals("__mp_wording__brandinfo_feedback")) {
                break label3218;
              }
              j = this.screen.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3218;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (Util.nullAsNil(((c.a)this.dhu.get(i)).dhy).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = ag.bag().Nn(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.jdMethod_do("contact_info_kf_worker", true);
              ag.bai().a(this);
              ag.bai().be(this.contact.field_username, z.aTY());
              this.Bfd = true;
              break;
            }
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((com.tencent.mm.al.h)localObject1).field_openId });
            this.screen.jdMethod_do("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.bmg("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.al.h)localObject1).field_nickname);
            localObject5 = com.tencent.mm.aj.c.a(((com.tencent.mm.al.h)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((com.tencent.mm.al.h)localObject1);
              aKr(((com.tencent.mm.al.h)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).al((Bitmap)localObject5);
            break;
          }
          Object localObject5 = ag.bag();
          localObject1 = ((com.tencent.mm.al.j)localObject5).Nm((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.al.j.a((com.tencent.mm.al.h)localObject1)))
          {
            ag.bai().a(this);
            ag.bai().j(this.contact.field_username, (String)localObject2, 1);
            this.Bfd = true;
          }
          if (localObject1 != null) {
            break label3223;
          }
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.al.j)localObject5).Nn(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.jdMethod_do("contact_info_kf_worker", true);
            break;
          }
          this.screen.jdMethod_do("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.bmg("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.al.h)localObject1).field_nickname);
          localObject5 = com.tencent.mm.aj.c.a(((com.tencent.mm.al.h)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((com.tencent.mm.al.h)localObject1);
            aKr(((com.tencent.mm.al.h)localObject1).field_openId);
          }
          for (;;)
          {
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((com.tencent.mm.al.h)localObject1).field_openId, ((com.tencent.mm.al.h)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).al((Bitmap)localObject5);
          }
          label3027:
          this.screen.jdMethod_do("contact_info_service_phone", true);
          break label1711;
          label3044:
          this.screen.jdMethod_do("contact_info_reputation", true);
          break label1773;
          this.screen.jdMethod_do("contact_info_guarantee_info", true);
          break label1836;
          this.screen.jdMethod_do("contact_info_scope_of_business", true);
          break label1896;
          this.screen.jdMethod_do("contact_info_reputation", true);
          this.screen.jdMethod_do("contact_info_guarantee_info", true);
          this.screen.jdMethod_do("contact_info_scope_of_business", true);
          break label1896;
          label3140:
          this.screen.jdMethod_do("contact_info_verifyuser_weibo", true);
          break label2030;
          label3157:
          this.screen.jdMethod_do("near_field_service", true);
          break label2065;
          label3174:
          this.screen.jdMethod_do("contact_info_see_locate", true);
        }
        AppMethodBeat.o(27550);
        return;
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
        AppMethodBeat.o(27550);
        return;
        localObject1 = localIndexOutOfBoundsException1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27549);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setActionbarColor(getContext().getResources().getColor(2131100898));
    setMMTitle(2131757834);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new NewBizInfoMoreInofUI.1(this));
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(paramBundle);
    if ((this.contact == null) || ((int)this.contact.gMZ == 0) || (Util.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new as();
      this.contact.setUsername(paramBundle);
      this.contact.BC(str1);
      this.contact.nf(i);
      this.contact.BZ(str2);
      this.contact.ne(j);
      this.contact.BH(str3);
    }
    for (;;)
    {
      this.Bdk = g.fJ(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.BeX = paramBundle;
          this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
          this.Bfg = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.nf(i);
          break;
          paramBundle = (aeq)new aeq().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = eFg();
      if (paramf == null)
      {
        Log.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
        AppMethodBeat.o(27555);
        return false;
      }
      localObject = paramf.url;
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", (String)localObject);
      paramPreference.putExtra("useJs", true);
      paramPreference.putExtra("vertical_scroll", true);
      paramPreference.putExtra("geta8key_scene", 3);
      paramPreference.putExtra("KPublisherId", "brand_profile");
      paramPreference.putExtra("prePublishId", "brand_profile");
      if (((this.Bfg != null) && ((this.kgm == 39) || (this.kgm == 56) || (this.kgm == 35))) || (this.kgm == 87) || (this.kgm == 89) || (this.kgm == 85) || (this.kgm == 88))
      {
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.Bfg);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.dhy, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        bP(i, paramf);
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.Bdk;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.cG(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).Va() != null) && (!Util.isNullOrNil(((c.b)localObject).Va().dit))) {
        paramf = ((c.b)localObject).Va().dit;
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1200, this.kgm, 0L);
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).Vb() != null)
        {
          paramf = paramPreference;
          if (!Util.isNullOrNil(((c.b)localObject).Vb().diB)) {
            paramf = ((c.b)localObject).Vb().diB;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.Bdk;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.cG(false) != null) && (!Util.isNullOrNil(paramf.cG(false).UT())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.cG(false).UT());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.bmg("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!Util.isNullOrNil(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(2131757871), getString(2131755761), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = Util.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.dhu.size()))
      {
        paramf = (c.a)this.dhu.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.Bfg != null) && ((this.kgm == 39) || (this.kgm == 56) || (this.kgm == 35))) || (this.kgm == 87) || (this.kgm == 89) || (this.kgm == 85) || (this.kgm == 88))
        {
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.Bfg);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.dhy, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          bP(i, paramf);
        }
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).jx(this.contact.fuM, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.dhv.UY() != null) && (!Util.isNullOrNil(this.dhv.UY().diy)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.dhv.UY().diy);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (Util.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format(Bff, new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI
 * JD-Core Version:    0.7.0.1
 */