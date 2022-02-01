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
import com.tencent.mm.ak.p;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private List<c.a> cQq;
  private c.b cQr;
  private boolean cQy = false;
  private am contact;
  private int jfq;
  private f screen;
  private com.tencent.mm.api.c wPN;
  private Bundle wRB;
  private acf wRt;
  private String wRy;
  private boolean wRz;
  
  private void auK(String paramString)
  {
    AppMethodBeat.i(27553);
    aq.o(new NewBizInfoMoreInofUI.3(this, paramString), 2000L);
    AppMethodBeat.o(27553);
  }
  
  private void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.wRB == null) || ((this.jfq != 39) && (this.jfq != 56) && (this.jfq != 35) && (this.jfq != 87) && (this.jfq != 88) && (this.jfq != 89) && (this.jfq != 85)))
    {
      ad.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27556);
      return;
    }
    if (this.contact == null)
    {
      ad.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(27556);
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
      ad.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10866, paramString);
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
  
  private static void c(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    com.tencent.mm.ak.j localj = p.aEx();
    if (localj.Dj(paramh.field_openId) == null)
    {
      com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
      locali.username = paramh.field_openId;
      locali.hMW = paramh.field_headImgUrl;
      locali.eB(false);
      locali.ePj = 3;
      localj.b(locali);
    }
    p.aEz().CV(paramh.field_openId);
    ad.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private c.a dBt()
  {
    AppMethodBeat.i(27551);
    if ((this.cQq == null) || (this.cQq.size() < 0))
    {
      ad.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.cQq.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.cQu.equals("__mp_wording__brandinfo_location")) || (getString(2131757621).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    ad.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String aFL()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<efo> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    ag.aGa().b(this);
    if (this.screen == null)
    {
      ad.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (this.contact == null)
    {
      ad.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27554);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (!bt.isNullOrNil(this.wRy))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        efo localefo = (efo)localIterator.next();
        if ((localefo.HQN != null) && (localefo.HQN.equals(this.wRy)))
        {
          this.screen.cP("contact_info_kf_worker", false);
          this.screen.aVD("contact_info_kf_worker").setSummary(localefo.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.cP("contact_info_kf_worker", false);
    this.screen.aVD("contact_info_kf_worker").setSummary(((efo)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return 2131951697;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.cP("biz_placed_to_the_top", true);
    Object localObject2 = com.tencent.mm.am.g.eS(this.contact.field_username);
    this.cQq = null;
    this.cQr = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).bX(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.wRt != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.wRt.jdq;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.wRt.jdt;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.wRt.jds;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.wRt.jdr;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bX(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.wRt != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.wRt.jdq;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.wRt.jdt;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.wRt.jds;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.wRt.jdr;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bX(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.wPN = ((com.tencent.mm.api.c)localObject1);
      this.cQq = ((com.tencent.mm.api.c)localObject1).Kw();
      this.cQr = ((com.tencent.mm.api.c)localObject1).bX(false);
      this.cQy = this.cQr.Ky();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (b.lM(this.contact.field_type)) {
      if (this.wPN == null)
      {
        bool = true;
        if (!bool) {
          break label1230;
        }
        localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_wechat_account");
        if (bt.isNullOrNil(this.contact.VA())) {
          break label1125;
        }
        this.screen.cP("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(k.c(this, this.contact.VA()));
        ((Preference)localObject1).Jtv = new NewBizInfoMoreInofUI.2(this, (KeyValuePreference)localObject1);
        if ((this.cQr == null) || (this.cQr.KI() == null) || (bt.isNullOrNil(this.cQr.KI().cRn))) {
          break label1378;
        }
        localObject4 = this.cQr.KI();
        localObject6 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1361;
        }
        ((KeyValuePreference)localObject6).fzF();
        ((KeyValuePreference)localObject6).JsK = false;
        if (!bt.isNullOrNil(((c.b.e)localObject4).cRo)) {
          break label1292;
        }
        i = ((c.b.e)localObject4).cRm;
        switch (i)
        {
        default: 
          ad.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(2131757694);
          label551:
          ((KeyValuePreference)localObject6).JaR = ((String)localObject1);
          label558:
          if (as.a.hFQ != null)
          {
            localObject1 = BackwardSupportUtil.b.o(as.a.hFQ.or(this.contact.field_verifyFlag), 2.0F);
            label585:
            if (localObject1 == null) {
              break label3225;
            }
            localObject2 = com.tencent.mm.sdk.platformtools.g.aat(2131690933);
          }
          break;
        }
      }
    }
    label621:
    label1527:
    label3064:
    Object localObject3;
    label1292:
    label3212:
    label3218:
    label3225:
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        ad.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).JsR = ((Drawable)localObject2);
        if (((c.b.e)localObject4).cRn == null) {
          break label1350;
        }
        str = ((c.b.e)localObject4).cRq;
        localObject2 = k.c(this, ((c.b.e)localObject4).cRn.trim());
        if (bt.isNullOrNil(str)) {
          break label3218;
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
          label1230:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.cQr == null) || (bt.isNullOrNil(this.cQr.KC()))) {
            break label1488;
          }
          localObject2 = (KeyValuePreference)this.screen.aVD("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).fzF();
          ((KeyValuePreference)localObject2).JsK = false;
          if (as.a.hFQ == null) {
            break label1476;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.g.aat(2131690937);
          if (localObject1 != null) {
            break label1482;
          }
          bool = true;
          ad.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3212;
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
        ((KeyValuePreference)localObject2).JsR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cQr.KC());
        ad.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.cQr.KC(), this.cQr.KB() });
        if ((this.cQr != null) && (this.cQr.KE() != null) && (this.cQr.KE().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_privilege");
          ((KeyValuePreference)localObject1).fzF();
          ((KeyValuePreference)localObject1).xG(false);
          ((KeyValuePreference)localObject1).fzE();
          localObject2 = this.cQr.KE().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1527;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).cRv, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText(str);
          ((KeyValuePreference)localObject1).gi((View)localObject6);
          continue;
          bool = this.wPN.Kt();
          break;
          if ((!am.aSX(this.contact.field_username)) && (!w.zC(this.contact.field_username)))
          {
            this.screen.cP("contact_info_wechat_account", false);
            localObject2 = bt.nullAsNil(this.contact.adw());
            ((KeyValuePreference)localObject1).setSummary(getContext().getString(2131755760) + (String)localObject2);
            break label385;
          }
          this.screen.cP("contact_info_wechat_account", true);
          break label385;
          this.screen.cP("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(2131757895);
          break label551;
          localObject1 = getResources().getString(2131757613);
          break label551;
          localObject1 = getResources().getString(2131757614);
          break label551;
          ((KeyValuePreference)localObject6).JaR = ((c.b.e)localObject4).cRo;
          break label558;
          localObject1 = null;
          break label585;
          bool = false;
          break label621;
          ad.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1350:
          ad.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1361:
          this.screen.cP("contact_info_verifyuser", true);
          continue;
          label1378:
          if ((this.cQr != null) && (this.cQr.KJ() != null) && (!bt.isNullOrNil(this.cQr.KJ().cRw)))
          {
            localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.cQr.KJ().cRw);
            continue;
          }
          ad.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.cP("contact_info_verifyuser", true);
          continue;
          label1476:
          localObject1 = null;
          continue;
          label1482:
          bool = false;
          continue;
          label1488:
          ad.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.cP("contact_info_trademark", true);
          continue;
        }
        this.screen.cP("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        ad.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.wRz) });
        if (!this.wRz)
        {
          this.wRy = ((String)localObject2);
          if ((this.cQr == null) || (!this.cQr.KO()) || (this.contact == null)) {
            this.screen.cP("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.cQr == null) || (bt.isNullOrNil(this.cQr.KN()))) {
            break label3013;
          }
          this.screen.cP("contact_info_service_phone", false);
          localObject1 = this.screen.aVD("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.cQr.KN());
            ((Preference)localObject1).oPT = getResources().getColor(2131100547);
          }
          label1697:
          if ((this.cQr == null) || (this.cQr.KG() == null)) {
            break label3081;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aVD("contact_info_reputation");
          if (this.cQr.KG().cRr <= 0) {
            break label3030;
          }
          ((BizInfoPayInfoIconPreference)localObject1).MH(this.cQr.KG().cRr);
          label1759:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aVD("contact_info_guarantee_info");
          if ((this.cQr.KG().cRt == null) || (this.cQr.KG().cRt.size() <= 0)) {
            break label3047;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eO(this.cQr.KG().cRt);
          label1822:
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_scope_of_business");
          if (bt.isNullOrNil(this.cQr.KG().cRs)) {
            break label3064;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cQr.KG().cRs);
          ((KeyValuePreference)localObject1).JsP = 4;
          ((KeyValuePreference)localObject1).xG(false);
          label1882:
          if ((!w.C(this.contact)) || (this.contact.ePy == null) || (this.contact.ePy.equals(""))) {
            break label3126;
          }
          localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bt.bI(this.contact.field_weiboNickname, "") + getString(2131763406, new Object[] { w.Aw(this.contact.ePy) }));
            ((Preference)localObject1).oPT = com.tencent.mm.cc.a.n(this, 2131100547);
            ((KeyValuePreference)localObject1).xG(false);
          }
          label2016:
          if ((this.cQr == null) || (!this.cQr.Kx())) {
            break label3143;
          }
          this.screen.aVD("near_field_service").setSummary(2131766197);
          if (dBt() == null) {
            break label3160;
          }
          this.screen.cP("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.indexOf("contact_info_category2");
          if ((k < 0) || (this.cQq == null) || (this.cQq.size() <= 0)) {
            break label3184;
          }
          i = this.cQq.size() - 1;
          while (i >= 0)
          {
            if ((this.cQq.get(i) != null) && ((!getString(2131757619).equals(((c.a)this.cQq.get(i)).title)) || (this.cQy)) && ((!bt.isNullOrNil(((c.a)this.cQq.get(i)).title)) || (!bt.isNullOrNil(((c.a)this.cQq.get(i)).cQu))) && (!((c.a)this.cQq.get(i)).cQu.equals("__mp_wording__brandinfo_location")) && (!getString(2131757621).equals(((c.a)this.cQq.get(i)).title)) && (!((c.a)this.cQq.get(i)).cQu.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.cQq.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.cQq.get(i)).cQu, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.wPN.Km()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cQq.get(i)).cQu))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(2131755016))) {}
                }
                else
                {
                  localObject2 = getString(2131758428);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!bt.isNullOrNil(((c.a)this.cQq.get(i)).description)) {
                ((Preference)localObject5).setSummary(((c.a)this.cQq.get(i)).description);
              }
              if (!bt.nullAsNil(((c.a)this.cQq.get(i)).cQu).equals("__mp_wording__brandinfo_feedback")) {
                break label3204;
              }
              j = this.screen.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3204;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (bt.nullAsNil(((c.a)this.cQq.get(i)).cQu).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (bt.isNullOrNil((String)localObject2))
          {
            localObject1 = ag.aFY().DX(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.cP("contact_info_kf_worker", true);
              ag.aGa().a(this);
              ag.aGa().ba(this.contact.field_username, u.aAm());
              this.wRz = true;
              break;
            }
            ad.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((com.tencent.mm.am.h)localObject1).field_openId });
            this.screen.cP("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.aVD("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.am.h)localObject1).field_nickname);
            localObject5 = com.tencent.mm.ak.c.a(((com.tencent.mm.am.h)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((com.tencent.mm.am.h)localObject1);
              auK(((com.tencent.mm.am.h)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).Z((Bitmap)localObject5);
            break;
          }
          Object localObject5 = ag.aFY();
          localObject1 = ((com.tencent.mm.am.j)localObject5).DW((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.am.j.a((com.tencent.mm.am.h)localObject1)))
          {
            ag.aGa().a(this);
            ag.aGa().k(this.contact.field_username, (String)localObject2, 1);
            this.wRz = true;
          }
          if (localObject1 != null) {
            break label3209;
          }
          ad.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.am.j)localObject5).DX(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.cP("contact_info_kf_worker", true);
            break;
          }
          this.screen.cP("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.aVD("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.am.h)localObject1).field_nickname);
          localObject5 = com.tencent.mm.ak.c.a(((com.tencent.mm.am.h)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((com.tencent.mm.am.h)localObject1);
            auK(((com.tencent.mm.am.h)localObject1).field_openId);
          }
          for (;;)
          {
            ad.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((com.tencent.mm.am.h)localObject1).field_openId, ((com.tencent.mm.am.h)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).Z((Bitmap)localObject5);
          }
          label3013:
          this.screen.cP("contact_info_service_phone", true);
          break label1697;
          label3030:
          this.screen.cP("contact_info_reputation", true);
          break label1759;
          label3047:
          this.screen.cP("contact_info_guarantee_info", true);
          break label1822;
          this.screen.cP("contact_info_scope_of_business", true);
          break label1882;
          this.screen.cP("contact_info_reputation", true);
          this.screen.cP("contact_info_guarantee_info", true);
          this.screen.cP("contact_info_scope_of_business", true);
          break label1882;
          label3126:
          this.screen.cP("contact_info_verifyuser_weibo", true);
          break label2016;
          label3143:
          this.screen.cP("near_field_service", true);
          break label2051;
          label3160:
          this.screen.cP("contact_info_see_locate", true);
        }
        AppMethodBeat.o(27550);
        return;
        label3184:
        ad.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
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
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setMMTitle(2131757606);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new NewBizInfoMoreInofUI.1(this));
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = bt.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(paramBundle);
    if ((this.contact == null) || ((int)this.contact.gfj == 0) || (bt.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new am();
      this.contact.setUsername(paramBundle);
      this.contact.sQ(str1);
      this.contact.kb(i);
      this.contact.to(str2);
      this.contact.ka(j);
      this.contact.sW(str3);
    }
    for (;;)
    {
      this.wPN = com.tencent.mm.am.g.eS(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.wRt = paramBundle;
          this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
          this.wRB = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.kb(i);
          break;
          paramBundle = (acf)new acf().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    ad.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = dBt();
      if (paramf == null)
      {
        ad.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
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
      if (((this.wRB != null) && ((this.jfq == 39) || (this.jfq == 56) || (this.jfq == 35))) || (this.jfq == 87) || (this.jfq == 89) || (this.jfq == 85) || (this.jfq == 88))
      {
        ad.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.wRB);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!b.lM(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.cQu, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        bB(i, paramf);
        com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.wPN;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.bX(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).KI() != null) && (!bt.isNullOrNil(((c.b)localObject).KI().cRp))) {
        paramf = ((c.b)localObject).KI().cRp;
      }
      for (;;)
      {
        if (!bt.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1200, this.jfq, 0L);
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).KJ() != null)
        {
          paramf = paramPreference;
          if (!bt.isNullOrNil(((c.b)localObject).KJ().cRx)) {
            paramf = ((c.b)localObject).KJ().cRx;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.wPN;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.bX(false) != null) && (!bt.isNullOrNil(paramf.bX(false).KB())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.bX(false).KB());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.aVD("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!bt.isNullOrNil(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(2131757643), getString(2131755691), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = bt.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.cQq.size()))
      {
        paramf = (c.a)this.cQq.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.wRB != null) && ((this.jfq == 39) || (this.jfq == 56) || (this.jfq == 35))) || (this.jfq == 87) || (this.jfq == 89) || (this.jfq == 85) || (this.jfq == 88))
        {
          ad.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.wRB);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (b.lM(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.cQu, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          bB(i, paramf);
        }
        com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).iE(this.contact.ePy, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.cQr.KG() != null) && (!bt.isNullOrNil(this.cQr.KG().cRu)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.cQr.KG().cRu);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (bt.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI
 * JD-Core Version:    0.7.0.1
 */