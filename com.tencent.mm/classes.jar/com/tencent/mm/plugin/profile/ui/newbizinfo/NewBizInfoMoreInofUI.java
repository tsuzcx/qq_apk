package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.af;
import com.tencent.mm.al.g;
import com.tencent.mm.al.h.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.c;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI
  extends MMPreference
  implements h.b
{
  private List<c.a> cFl;
  private c.b cFm;
  private boolean cFt = false;
  private com.tencent.mm.storage.ai contact;
  private int iMg;
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.api.c vIG;
  private aaf vKk;
  private String vKp;
  private boolean vKq;
  private Bundle vKs;
  
  private void apE(String paramString)
  {
    AppMethodBeat.i(27553);
    ap.n(new NewBizInfoMoreInofUI.3(this, paramString), 2000L);
    AppMethodBeat.o(27553);
  }
  
  private void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.vKs == null) || ((this.iMg != 39) && (this.iMg != 56) && (this.iMg != 35) && (this.iMg != 87) && (this.iMg != 88) && (this.iMg != 89) && (this.iMg != 85)))
    {
      ac.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27556);
      return;
    }
    if (this.contact == null)
    {
      ac.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(27556);
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
      ac.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10866, paramString);
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
  
  private static void c(g paramg)
  {
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    j localj = p.aBw();
    if (localj.Ak(paramg.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramg.field_openId;
      locali.huE = paramg.field_headImgUrl;
      locali.ez(false);
      locali.exK = 3;
      localj.b(locali);
    }
    p.aBy().zW(paramg.field_openId);
    ac.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private c.a dqR()
  {
    AppMethodBeat.i(27551);
    if ((this.cFl == null) || (this.cFl.size() < 0))
    {
      ac.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.cFl.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.cFp.equals("__mp_wording__brandinfo_location")) || (getString(2131757621).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    ac.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String aCI()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<dzk> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    af.aCX().b(this);
    if (this.screen == null)
    {
      ac.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (this.contact == null)
    {
      ac.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27554);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (!bs.isNullOrNil(this.vKp))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dzk localdzk = (dzk)localIterator.next();
        if ((localdzk.GfE != null) && (localdzk.GfE.equals(this.vKp)))
        {
          this.screen.cK("contact_info_kf_worker", false);
          this.screen.aPN("contact_info_kf_worker").setSummary(localdzk.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.cK("contact_info_kf_worker", false);
    this.screen.aPN("contact_info_kf_worker").setSummary(((dzk)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return 2131951697;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.cK("biz_placed_to_the_top", true);
    Object localObject2 = com.tencent.mm.al.f.dX(this.contact.field_username);
    this.cFl = null;
    this.cFm = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).bV(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.vKk != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.vKk.iKh;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.vKk.iKk;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.vKk.iKj;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.vKk.iKi;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bV(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.vKk != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.vKk.iKh;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.vKk.iKk;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.vKk.iKj;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.vKk.iKi;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bV(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.vIG = ((com.tencent.mm.api.c)localObject1);
      this.cFl = ((com.tencent.mm.api.c)localObject1).IW();
      this.cFm = ((com.tencent.mm.api.c)localObject1).bV(false);
      this.cFt = this.cFm.IY();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (b.ln(this.contact.field_type)) {
      if (this.vIG == null)
      {
        bool = true;
        if (!bool) {
          break label1230;
        }
        localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_wechat_account");
        if (bs.isNullOrNil(this.contact.Tl())) {
          break label1125;
        }
        this.screen.cK("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(k.c(this, this.contact.Tl()));
        ((Preference)localObject1).HFE = new Preference.c()
        {
          public final boolean dqS()
          {
            AppMethodBeat.i(27546);
            ClipboardManager localClipboardManager = (ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
            try
            {
              localClipboardManager.setText(this.vOS.getSummary());
              com.tencent.mm.ui.base.h.cg(NewBizInfoMoreInofUI.this.getContext(), NewBizInfoMoreInofUI.this.getContext().getString(2131755702));
              AppMethodBeat.o(27546);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
              }
            }
          }
        };
        if ((this.cFm == null) || (this.cFm.Ji() == null) || (bs.isNullOrNil(this.cFm.Ji().cGj))) {
          break label1378;
        }
        localObject4 = this.cFm.Ji();
        localObject6 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1361;
        }
        ((KeyValuePreference)localObject6).fjq();
        ((KeyValuePreference)localObject6).HET = false;
        if (!bs.isNullOrNil(((c.b.e)localObject4).cGk)) {
          break label1292;
        }
        i = ((c.b.e)localObject4).cGi;
        switch (i)
        {
        default: 
          ac.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(2131757694);
          label551:
          ((KeyValuePreference)localObject6).Hnl = ((String)localObject1);
          label558:
          if (ar.a.hny != null)
          {
            localObject1 = BackwardSupportUtil.b.n(ar.a.hny.nR(this.contact.field_verifyFlag), 2.0F);
            label585:
            if (localObject1 == null) {
              break label3225;
            }
            localObject2 = com.tencent.mm.sdk.platformtools.f.Yo(2131690933);
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
        ac.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).HFa = ((Drawable)localObject2);
        if (((c.b.e)localObject4).cGj == null) {
          break label1350;
        }
        str = ((c.b.e)localObject4).cGm;
        localObject2 = k.c(this, ((c.b.e)localObject4).cGj.trim());
        if (bs.isNullOrNil(str)) {
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
          if ((this.cFm == null) || (bs.isNullOrNil(this.cFm.Jc()))) {
            break label1488;
          }
          localObject2 = (KeyValuePreference)this.screen.aPN("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).fjq();
          ((KeyValuePreference)localObject2).HET = false;
          if (ar.a.hny == null) {
            break label1476;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.f.Yo(2131690937);
          if (localObject1 != null) {
            break label1482;
          }
          bool = true;
          ac.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
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
        ((KeyValuePreference)localObject2).HFa = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cFm.Jc());
        ac.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.cFm.Jc(), this.cFm.Jb() });
        if ((this.cFm != null) && (this.cFm.Je() != null) && (this.cFm.Je().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_privilege");
          ((KeyValuePreference)localObject1).fjq();
          ((KeyValuePreference)localObject1).wV(false);
          ((KeyValuePreference)localObject1).fjp();
          localObject2 = this.cFm.Je().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1527;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).cGr, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText(str);
          ((KeyValuePreference)localObject1).fT((View)localObject6);
          continue;
          bool = this.vIG.IT();
          break;
          if ((!com.tencent.mm.storage.ai.aNf(this.contact.field_username)) && (!w.wF(this.contact.field_username)))
          {
            this.screen.cK("contact_info_wechat_account", false);
            localObject2 = bs.nullAsNil(this.contact.aaT());
            ((KeyValuePreference)localObject1).setSummary(getContext().getString(2131755760) + (String)localObject2);
            break label385;
          }
          this.screen.cK("contact_info_wechat_account", true);
          break label385;
          this.screen.cK("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(2131757895);
          break label551;
          localObject1 = getResources().getString(2131757613);
          break label551;
          localObject1 = getResources().getString(2131757614);
          break label551;
          ((KeyValuePreference)localObject6).Hnl = ((c.b.e)localObject4).cGk;
          break label558;
          localObject1 = null;
          break label585;
          bool = false;
          break label621;
          ac.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1350:
          ac.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1361:
          this.screen.cK("contact_info_verifyuser", true);
          continue;
          label1378:
          if ((this.cFm != null) && (this.cFm.Jk() != null) && (!bs.isNullOrNil(this.cFm.Jk().cGs)))
          {
            localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.cFm.Jk().cGs);
            continue;
          }
          ac.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.cK("contact_info_verifyuser", true);
          continue;
          label1476:
          localObject1 = null;
          continue;
          label1482:
          bool = false;
          continue;
          label1488:
          ac.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.cK("contact_info_trademark", true);
          continue;
        }
        this.screen.cK("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        ac.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.vKq) });
        if (!this.vKq)
        {
          this.vKp = ((String)localObject2);
          if ((this.cFm == null) || (!this.cFm.Jp()) || (this.contact == null)) {
            this.screen.cK("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.cFm == null) || (bs.isNullOrNil(this.cFm.Jo()))) {
            break label3013;
          }
          this.screen.cK("contact_info_service_phone", false);
          localObject1 = this.screen.aPN("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.cFm.Jo());
            ((Preference)localObject1).omy = getResources().getColor(2131100547);
          }
          label1697:
          if ((this.cFm == null) || (this.cFm.Jg() == null)) {
            break label3081;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aPN("contact_info_reputation");
          if (this.cFm.Jg().cGn <= 0) {
            break label3030;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Lf(this.cFm.Jg().cGn);
          label1759:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aPN("contact_info_guarantee_info");
          if ((this.cFm.Jg().cGp == null) || (this.cFm.Jg().cGp.size() <= 0)) {
            break label3047;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eB(this.cFm.Jg().cGp);
          label1822:
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_scope_of_business");
          if (bs.isNullOrNil(this.cFm.Jg().cGo)) {
            break label3064;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cFm.Jg().cGo);
          ((KeyValuePreference)localObject1).HEY = 4;
          ((KeyValuePreference)localObject1).wV(false);
          label1882:
          if ((!w.C(this.contact)) || (this.contact.exZ == null) || (this.contact.exZ.equals(""))) {
            break label3126;
          }
          localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bs.bG(this.contact.field_weiboNickname, "") + getString(2131763406, new Object[] { w.xy(this.contact.exZ) }));
            ((Preference)localObject1).omy = com.tencent.mm.cc.a.n(this, 2131100547);
            ((KeyValuePreference)localObject1).wV(false);
          }
          label2016:
          if ((this.cFm == null) || (!this.cFm.IX())) {
            break label3143;
          }
          this.screen.aPN("near_field_service").setSummary(2131766197);
          if (dqR() == null) {
            break label3160;
          }
          this.screen.cK("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.indexOf("contact_info_category2");
          if ((k < 0) || (this.cFl == null) || (this.cFl.size() <= 0)) {
            break label3184;
          }
          i = this.cFl.size() - 1;
          while (i >= 0)
          {
            if ((this.cFl.get(i) != null) && ((!getString(2131757619).equals(((c.a)this.cFl.get(i)).title)) || (this.cFt)) && ((!bs.isNullOrNil(((c.a)this.cFl.get(i)).title)) || (!bs.isNullOrNil(((c.a)this.cFl.get(i)).cFp))) && (!((c.a)this.cFl.get(i)).cFp.equals("__mp_wording__brandinfo_location")) && (!getString(2131757621).equals(((c.a)this.cFl.get(i)).title)) && (!((c.a)this.cFl.get(i)).cFp.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.cFl.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.cFl.get(i)).cFp, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.vIG.IM()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cFl.get(i)).cFp))
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
              if (!bs.isNullOrNil(((c.a)this.cFl.get(i)).description)) {
                ((Preference)localObject5).setSummary(((c.a)this.cFl.get(i)).description);
              }
              if (!bs.nullAsNil(((c.a)this.cFl.get(i)).cFp).equals("__mp_wording__brandinfo_feedback")) {
                break label3204;
              }
              j = this.screen.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3204;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (bs.nullAsNil(((c.a)this.cFl.get(i)).cFp).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (bs.isNullOrNil((String)localObject2))
          {
            localObject1 = af.aCV().AY(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.cK("contact_info_kf_worker", true);
              af.aCX().a(this);
              af.aCX().aZ(this.contact.field_username, u.axw());
              this.vKq = true;
              break;
            }
            ac.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((g)localObject1).field_openId });
            this.screen.cK("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.aPN("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
            localObject5 = com.tencent.mm.aj.c.a(((g)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((g)localObject1);
              apE(((g)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).Z((Bitmap)localObject5);
            break;
          }
          Object localObject5 = af.aCV();
          localObject1 = ((com.tencent.mm.al.i)localObject5).AX((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.al.i.a((g)localObject1)))
          {
            af.aCX().a(this);
            af.aCX().l(this.contact.field_username, (String)localObject2, 1);
            this.vKq = true;
          }
          if (localObject1 != null) {
            break label3209;
          }
          ac.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.al.i)localObject5).AY(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.cK("contact_info_kf_worker", true);
            break;
          }
          this.screen.cK("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.aPN("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
          localObject5 = com.tencent.mm.aj.c.a(((g)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((g)localObject1);
            apE(((g)localObject1).field_openId);
          }
          for (;;)
          {
            ac.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((g)localObject1).field_openId, ((g)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).Z((Bitmap)localObject5);
          }
          label3013:
          this.screen.cK("contact_info_service_phone", true);
          break label1697;
          label3030:
          this.screen.cK("contact_info_reputation", true);
          break label1759;
          label3047:
          this.screen.cK("contact_info_guarantee_info", true);
          break label1822;
          this.screen.cK("contact_info_scope_of_business", true);
          break label1882;
          this.screen.cK("contact_info_reputation", true);
          this.screen.cK("contact_info_guarantee_info", true);
          this.screen.cK("contact_info_scope_of_business", true);
          break label1882;
          label3126:
          this.screen.cK("contact_info_verifyuser_weibo", true);
          break label2016;
          label3143:
          this.screen.cK("near_field_service", true);
          break label2051;
          label3160:
          this.screen.cK("contact_info_see_locate", true);
        }
        AppMethodBeat.o(27550);
        return;
        label3184:
        ac.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
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
    paramBundle = bs.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = bs.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(paramBundle);
    if ((this.contact == null) || ((int)this.contact.fLJ == 0) || (bs.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new com.tencent.mm.storage.ai();
      this.contact.setUsername(paramBundle);
      this.contact.qg(str1);
      this.contact.jD(i);
      this.contact.qE(str2);
      this.contact.jC(j);
      this.contact.qm(str3);
    }
    for (;;)
    {
      this.vIG = com.tencent.mm.al.f.dX(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.vKk = paramBundle;
          this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
          this.vKs = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.jD(i);
          break;
          paramBundle = (aaf)new aaf().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    ac.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = dqR();
      if (paramf == null)
      {
        ac.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
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
      if (((this.vKs != null) && ((this.iMg == 39) || (this.iMg == 56) || (this.iMg == 35))) || (this.iMg == 87) || (this.iMg == 89) || (this.iMg == 85) || (this.iMg == 88))
      {
        ac.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.vKs);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!b.ln(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.cFp, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        bw(i, paramf);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.vIG;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.bV(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).Ji() != null) && (!bs.isNullOrNil(((c.b)localObject).Ji().cGl))) {
        paramf = ((c.b)localObject).Ji().cGl;
      }
      for (;;)
      {
        if (!bs.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 1200, this.iMg);
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).Jk() != null)
        {
          paramf = paramPreference;
          if (!bs.isNullOrNil(((c.b)localObject).Jk().cGt)) {
            paramf = ((c.b)localObject).Jk().cGt;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.vIG;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.bV(false) != null) && (!bs.isNullOrNil(paramf.bV(false).Jb())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.bV(false).Jb());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.aPN("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!bs.isNullOrNil(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(2131757643), getString(2131755691), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = bs.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.cFl.size()))
      {
        paramf = (c.a)this.cFl.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.vKs != null) && ((this.iMg == 39) || (this.iMg == 56) || (this.iMg == 35))) || (this.iMg == 87) || (this.iMg == 89) || (this.iMg == 85) || (this.iMg == 88))
        {
          ac.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.vKs);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (b.ln(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.cFp, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          bw(i, paramf);
        }
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).iq(this.contact.exZ, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.cFm.Jg() != null) && (!bs.isNullOrNil(this.cFm.Jg().cGq)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.cFm.Jg().cGq);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (bs.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
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