package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ar;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.sdk.platformtools.f(cqs={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.ah.f, h.a, com.tencent.mm.pluginsdk.b.a
{
  String bGR = null;
  Activity bMV;
  private int bMp = 0;
  u dnL;
  private com.tencent.mm.ui.base.preference.f dnn;
  ad dnp;
  String dpj;
  int fhj;
  private String kzG;
  private String liF;
  private boolean mVI;
  private boolean mVJ;
  String mXA;
  com.tencent.mm.sdk.b.c<ar> mXB = new k.4(this);
  private int mXi;
  private but mXo = new but();
  private boolean mXp;
  private String mXq = "";
  private int mXr = -1;
  private boolean mXs = false;
  private boolean mXt = false;
  private String mXu;
  private boolean mXv = false;
  private boolean mXw = false;
  private String mXx = null;
  private String mXy = null;
  private int mXz;
  
  public k(Activity paramActivity)
  {
    this.bMV = paramActivity;
  }
  
  private void bsx()
  {
    Object localObject5 = null;
    awZ();
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.contact_info_pref_normal);
    if (n.omH != null) {
      n.omH.a(3, this.dnp.field_username, this);
    }
    au.Dk().a(30, this);
    au.Dk().a(453, this);
    this.mXA = "";
    y.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.dnp.Bm() });
    Object localObject1;
    Object localObject6;
    Object localObject3;
    if (!this.dnp.Bm())
    {
      localObject1 = this.bMV.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject6 = this.bMV.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bk.bl((String)localObject1)) || (!bk.bl((String)localObject6))) {
        break label753;
      }
      if (bk.bl(this.dnp.field_username)) {
        break label4864;
      }
      localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.dnp.field_username);
      localObject6 = this.dnp.field_username;
      if (localObject3 != null) {
        break label745;
      }
      localObject1 = "true";
      y.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject6, localObject1 });
      localObject1 = localObject3;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wv())))
      {
        this.mXA = bk.pm(((com.tencent.mm.plugin.account.friend.a.a)localObject1).WD()).replace(" ", "");
        y.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.dnp.field_username, this.mXA });
      }
      localObject6 = (NormalUserHeaderPreference)this.dnn.add("contact_info_header_normal");
      Object localObject8;
      label439:
      int j;
      if (localObject6 != null)
      {
        localObject1 = this.dnp;
        i = this.fhj;
        localObject3 = this.kzG;
        localObject7 = this.mXA;
        localObject8 = this.dnp.cCP;
        ((NormalUserHeaderPreference)localObject6).saA = ((String)localObject7);
        ((NormalUserHeaderPreference)localObject6).saB = ((String)localObject8);
        ((NormalUserHeaderPreference)localObject6).a((ad)localObject1, i, (String)localObject3);
        ((NormalUserHeaderPreference)localObject6).bB(this.dnp.field_username, this.mXs);
        ((NormalUserHeaderPreference)localObject6).siX = new k.1(this);
        if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
          this.mXt = false;
        }
        ((NormalUserHeaderPreference)localObject6).bC(this.dnp.field_username, this.mXt);
        if ((!ad.aaU(this.dnp.field_username)) || (this.dnp.cCT == 0)) {
          break label1189;
        }
        j = this.dnn.indexOf("contact_info_category_1");
        localObject1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).c(this.dnp.field_openImAppid, "openim_custom_info_header", b.a.ePI);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = new PreferenceTitleCategory(this.bMV);
          ((Preference)localObject3).setTitle((CharSequence)localObject1);
          this.dnn.a((Preference)localObject3, j);
          ((Preference)localObject3).vdC = new k.5(this);
        }
        localObject1 = new com.tencent.mm.openim.a.c();
        ((com.tencent.mm.openim.a.c)localObject1).oT(this.dnp.cCU);
        localObject1 = ((com.tencent.mm.openim.a.c)localObject1).ePL.iterator();
        label591:
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (c.a)((Iterator)localObject1).next();
          localObject7 = ((c.a)localObject3).ePM.iterator();
          i = j;
        }
      }
      else
      {
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject7).hasNext()) {
            break label591;
          }
          localObject8 = (c.b)((Iterator)localObject7).next();
          j = i + 1;
          k.6 local6 = new k.6(this, this.bMV, (c.b)localObject8);
          local6.uME = ((c.a)localObject3).title;
          local6.setSummary(j.b(this.bMV, ((c.b)localObject8).oU(this.dnp.field_openImAppid)));
          this.dnn.a(local6, j);
          if ((((c.b)localObject8).action == 0) || (((c.b)localObject8).action == 1))
          {
            local6.setEnabled(true);
            i = j;
            continue;
            label745:
            localObject1 = "false";
            break;
            label753:
            if ((bk.bl((String)localObject1)) && (bk.bl((String)localObject6))) {
              break label4864;
            }
            y.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.dnp.field_username, localObject1, localObject6 });
            localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject1);
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              if (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject3).Wv())) {}
            }
            else
            {
              localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject6);
            }
            localObject6 = this.dnp.field_username;
            if (localObject1 == null) {}
            for (localObject3 = "true";; localObject3 = "false")
            {
              y.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject6, localObject3 });
              break;
            }
            this.dnn.c((Preference)localObject6);
            break label439;
          }
          if (((c.b)localObject8).action == 2)
          {
            local6.vdC = new k.7(this, (c.b)localObject8, (c.a)localObject3);
            i = j;
          }
          else if (((c.b)localObject8).action == 3)
          {
            local6.vdC = new k.8(this, (c.b)localObject8, (c.a)localObject3);
            i = j;
          }
          else if (((c.b)localObject8).action == 4)
          {
            local6.vdC = new k.9(this, (c.b)localObject8, (c.a)localObject3);
            i = j;
          }
          else
          {
            i = j;
            if (((c.b)localObject8).action == 5)
            {
              local6.vdC = new k.10(this, (c.b)localObject8, (c.a)localObject3);
              i = j;
            }
          }
        }
      }
      int i = j + 1;
      this.dnn.a(new PreferenceSmallCategory(this.bMV), i);
      localObject1 = new KeyValuePreference(this.bMV);
      ((KeyValuePreference)localObject1).setTitle(R.l.contact_info_enterprise_from);
      localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).c(this.dnp.field_openImAppid, "openim_intro_desc", b.a.ePI);
      ((KeyValuePreference)localObject1).setSummary(j.b(this.bMV, (CharSequence)localObject3));
      Object localObject7 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).c(this.dnp.field_openImAppid, "openim_intro_url", b.a.ePJ);
      if (!TextUtils.isEmpty((CharSequence)localObject7)) {
        ((Preference)localObject1).vdC = new k.11(this, (String)localObject7, (String)localObject3);
      }
      this.dnn.a((Preference)localObject1, i + 1);
      label1189:
      label1454:
      label1530:
      long l;
      if (!bk.bl(this.dnp.getProvince()))
      {
        localObject3 = (KeyValuePreference)this.dnn.add("contact_info_district");
        if (localObject3 != null)
        {
          ((KeyValuePreference)localObject3).setTitle(this.bMV.getString(R.l.contact_info_district));
          localObject7 = new StringBuilder().append(r.gX(this.dnp.getProvince()));
          if (bk.bl(this.dnp.getCity()))
          {
            localObject1 = "";
            ((KeyValuePreference)localObject3).setSummary((String)localObject1);
            ((KeyValuePreference)localObject3).nf(false);
            ((KeyValuePreference)localObject3).setEnabled(false);
          }
        }
        else
        {
          label1305:
          if ((this.dnp.signature == null) || (this.dnp.signature.trim().equals("")) || (com.tencent.mm.n.a.gR(this.dnp.field_type))) {
            break label2357;
          }
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_signature");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).vcS = false;
            ((KeyValuePreference)localObject1).setTitle(this.bMV.getString(R.l.contact_info_signature));
            ((KeyValuePreference)localObject1).setSummary(j.b(this.bMV, this.dnp.signature));
            ((KeyValuePreference)localObject1).nf(false);
          }
          label1414:
          this.dnn.add("contact_info_facebook");
          this.dnn.ade("contact_info_facebook");
          if ((this.mXo.ffs & 0x1) <= 0) {
            break label2373;
          }
          i = 1;
          if (((i & com.tencent.mm.br.d.SP("sns")) == 0) || (ad.aaS(this.dnp.field_username)) || (this.dnp.Bg())) {
            break label2378;
          }
          localObject1 = (com.tencent.mm.ui.base.preference.g)this.dnn.add("contact_info_sns");
          if ((localObject1 != null) && (n.omD != null)) {
            ((com.tencent.mm.ui.base.preference.g)localObject1).WP(this.dnp.field_username);
          }
          this.dnn.ade("contact_info_verifyuser");
          if (this.fhj == 96) {
            this.dnn.ade("contact_info_footer_normal");
          }
          if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
            break label2512;
          }
          localObject3 = new int[7];
          localObject7 = (ContactMoreInfoPreference)this.dnn.add("contact_info_more");
          if (localObject7 != null)
          {
            l = this.bMV.getIntent().getLongExtra("Contact_Uin", 0L);
            if ((l == -1L) || (new o(l).longValue() <= 0L)) {
              break label2394;
            }
            ((ContactMoreInfoPreference)localObject7).vV(0);
            localObject3[0] = 0;
            label1656:
            if ((bk.bl(this.liF)) || (bk.bl(this.mXu))) {
              break label2410;
            }
            ((ContactMoreInfoPreference)localObject7).vX(0);
            localObject3[1] = 0;
            label1687:
            localObject1 = com.tencent.mm.m.g.AA().getValue("LinkedinPluginClose");
            if ((!bk.bl((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
              break label2426;
            }
            i = 1;
            label1719:
            if ((i == 0) || (bk.bl(this.dnp.cCL))) {
              break label2431;
            }
            ((ContactMoreInfoPreference)localObject7).vW(0);
            localObject3[2] = 0;
            label1747:
            if (!q.Gj().equals(this.dnp.field_username)) {
              break label2447;
            }
            au.Hx();
            localObject1 = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqI, null);
            label1782:
            if (bk.bl((String)localObject1)) {
              break label2474;
            }
          }
        }
      }
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          localObject1 = new JSONObject((String)localObject1).optString("ShopUrl");
          if (bk.bl((String)localObject1)) {
            break label2480;
          }
          ((ContactMoreInfoPreference)localObject7).vY(0);
          localObject3[3] = 0;
          if (!bk.bl(this.dnp.signature)) {
            break label2496;
          }
          localObject3[4] = 8;
          if (this.dnp.getSource() > 0) {
            break label2504;
          }
          localObject3[5] = 8;
          localObject3[6] = 8;
          this.dnn.bJ("contact_info_more", false);
          this.dnn.ade("contact_info_social");
          if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
            break label3011;
          }
          this.dnn.ade("contact_info_source");
          this.dnn.bJ("contact_info_invite_source", true);
          if (this.dnL != null) {
            break label4575;
          }
          bool1 = this.bMV.getIntent().getBooleanExtra("Is_RoomOwner", false);
          if ((this.fhj == 14) && (bool1) && (this.dnL != null) && (!this.dnp.field_username.equals(this.dnL.field_roomowner))) {
            break label4593;
          }
          i = this.fhj;
          if (this.dnL != null) {
            break label4587;
          }
          bool2 = true;
          y.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          this.dnn.bJ("contact_info_invite_source", true);
          localObject1 = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
          bool1 = this.bMV.getIntent().getBooleanExtra("User_From_Fmessage", false);
          bool2 = this.bMV.getIntent().getBooleanExtra("Contact_FMessageCard", false);
          this.bMV.getIntent().getBooleanExtra("Contact_KHideExpose", false);
          l = this.bMV.getIntent().getLongExtra("Contact_Uin", -1L);
          if ((this.fhj == 30) || (this.fhj == 45)) {
            this.mXp = false;
          }
          if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.dnp, this.kzG, this.mVI, this.mVJ, this.mXp, this.fhj, this.mXi, bool2, bool1, l, this.mXq))) {
            break label4848;
          }
          ((NormalUserFooterPreference)localObject1).ebu.removeAll();
          ((NormalUserFooterPreference)localObject1).ebu.a(new k.12(this, (NormalUserHeaderPreference)localObject6), Looper.getMainLooper());
          i = this.dnp.cCD;
          this.dnn.ade("clear_lbs_info");
          if (this.mXw)
          {
            this.dnn.removeAll();
            if (localObject6 != null) {
              this.dnn.a((Preference)localObject6);
            }
            if (localObject1 != null) {
              this.dnn.a((Preference)localObject1);
            }
          }
          return;
        }
        catch (JSONException localJSONException1)
        {
          y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException1, "", new Object[0]);
        }
        localObject1 = "  " + this.dnp.getCity();
        break;
        this.dnn.ade("contact_info_district");
        break label1305;
        label2357:
        this.dnn.ade("contact_info_signature");
        break label1414;
        label2373:
        i = 0;
        break label1454;
        label2378:
        this.dnn.ade("contact_info_sns");
        break label1530;
        label2394:
        ((ContactMoreInfoPreference)localObject7).vV(8);
        localObject3[0] = 8;
        break label1656;
        label2410:
        ((ContactMoreInfoPreference)localObject7).vX(8);
        localObject3[1] = 8;
        break label1687;
        label2426:
        i = 0;
        break label1719;
        label2431:
        ((ContactMoreInfoPreference)localObject7).vW(8);
        localObject3[2] = 8;
        break label1747;
        label2447:
        localObject1 = this.dnp.cCO;
        break label1782;
        label2474:
        localObject2 = null;
        continue;
        label2480:
        ((ContactMoreInfoPreference)localObject7).vY(8);
        localObject3[3] = 8;
        continue;
        label2496:
        localObject3[4] = 0;
        continue;
        label2504:
        localObject3[5] = 0;
        continue;
        label2512:
        localObject7 = (ContactSocialInfoPreference)this.dnn.add("contact_info_social");
        if (localObject7 != null)
        {
          if (bk.bl(this.mXA)) {
            break label2923;
          }
          ((ContactSocialInfoPreference)localObject7).vZ(0);
          this.mXz = 1;
          label2555:
          au.Hx();
          i = bk.g((Integer)com.tencent.mm.model.c.Dz().get(9, null));
          l = this.bMV.getIntent().getLongExtra("Contact_Uin", 0L);
          localObject2 = this.bMV.getIntent().getStringExtra("Contact_QQNick");
          if ((l != 0L) && (i != 0))
          {
            if ((localObject2 == null) || (((String)localObject2).length() == 0))
            {
              localObject3 = com.tencent.mm.plugin.account.b.getQQListStg().cr(l);
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = null;
              }
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.account.friend.a.ao)localObject2).getDisplayName();
              }
            }
            if ((l == -1L) || (new o(l).longValue() <= 0L)) {
              break label2933;
            }
            ((ContactSocialInfoPreference)localObject7).vV(0);
            this.mXz = 1;
          }
          label2695:
          if ((bk.bl(this.liF)) || (bk.bl(this.mXu))) {
            break label2943;
          }
          ((ContactSocialInfoPreference)localObject7).vX(0);
          this.mXz = 1;
          label2726:
          localObject2 = com.tencent.mm.m.g.AA().getValue("LinkedinPluginClose");
          if ((!bk.bl((String)localObject2)) && (Integer.valueOf((String)localObject2).intValue() != 0)) {
            break label2953;
          }
          i = 1;
          label2758:
          if ((i == 0) || (bk.bl(this.dnp.cCL))) {
            break label2958;
          }
          ((ContactSocialInfoPreference)localObject7).vW(0);
          this.mXz = 1;
          label2786:
          if (!q.Gj().equals(this.dnp.field_username)) {
            break label2968;
          }
          au.Hx();
          localObject2 = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqI, null);
          label2821:
          if (bk.bl((String)localObject2)) {
            break label2995;
          }
        }
        label2923:
        label2933:
        label2943:
        Object localObject4;
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2).optString("ShopUrl");
            y.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject2, localObject3 });
            if (bk.bl((String)localObject3)) {
              break label3001;
            }
            ((ContactSocialInfoPreference)localObject7).vY(0);
            this.mXz = 1;
            if (this.mXz == 0) {
              this.dnn.ade("contact_info_social");
            }
            this.dnn.ade("contact_info_more");
          }
          catch (JSONException localJSONException2)
          {
            label2953:
            label2958:
            label2968:
            y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException2, "", new Object[0]);
          }
          ((ContactSocialInfoPreference)localObject7).vZ(8);
          break label2555;
          ((ContactSocialInfoPreference)localObject7).vV(8);
          break label2695;
          ((ContactSocialInfoPreference)localObject7).vX(8);
          break label2726;
          i = 0;
          break label2758;
          ((ContactSocialInfoPreference)localObject7).vW(8);
          break label2786;
          localObject2 = this.dnp.cCO;
          break label2821;
          label2995:
          localObject4 = null;
          continue;
          label3001:
          ((ContactSocialInfoPreference)localObject7).vY(8);
        }
        label3011:
        i = this.bMV.getIntent().getIntExtra("Contact_Source_FMessage", 0);
        y.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.dnp.getSource() + ", sourceFMessage = " + i);
        if (i != 0)
        {
          localObject7 = (KeyValuePreference)this.dnn.add("contact_info_source");
          if (!this.mVJ)
          {
            if (localObject7 != null) {
              if (i == 10)
              {
                ((KeyValuePreference)localObject7).vcS = false;
                ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
                ((KeyValuePreference)localObject7).setSummary(this.bMV.getString(R.l.fmessage_come_from_mobile));
                ((KeyValuePreference)localObject7).nf(false);
              }
              else
              {
                this.dnn.c((Preference)localObject7);
              }
            }
          }
          else {
            switch (i)
            {
            default: 
              this.dnn.c((Preference)localObject7);
              break;
            case 1: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_search_qq_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 3: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_search_wechat_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 17: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              localObject4 = r.gV(this.bMV.getIntent().getStringExtra("source_from_user_name"));
              localObject2 = localObject4;
              if (bk.bl((String)localObject4)) {
                localObject2 = this.bMV.getIntent().getStringExtra("source_from_nick_name");
              }
              if (bk.bl((String)localObject2)) {
                ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_card_passive);
              }
              for (;;)
              {
                ((KeyValuePreference)localObject7).nf(false);
                break;
                ((KeyValuePreference)localObject7).setSummary(j.b(this.bMV, this.bMV.getString(R.l.contact_info_source_by_card_before_verify_passive, new Object[] { localObject2 })));
              }
            case 8: 
            case 14: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              localObject2 = com.tencent.mm.bh.d.RX().abT(this.dnp.field_username);
              au.Hx();
              localObject4 = com.tencent.mm.model.c.Fw();
              if (localObject2 == null)
              {
                localObject2 = "";
                localObject4 = ((bd)localObject4).abl((String)localObject2);
                localObject2 = localObject5;
                if (localObject4 != null) {
                  localObject2 = ((com.tencent.mm.h.c.ao)localObject4).field_nickname;
                }
                if (bk.bl((String)localObject2)) {
                  break label3680;
                }
                ((KeyValuePreference)localObject7).setSummary(this.bMV.getString(R.l.contact_info_source_by_chatroom_to_add_passive, new Object[] { localObject2 }));
              }
              for (;;)
              {
                ((KeyValuePreference)localObject7).nf(false);
                break;
                localObject2 = ((ax)localObject2).field_chatroomName;
                break label3602;
                ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_chatroom_passive);
              }
            case 4: 
            case 12: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(this.bMV.getString(R.l.fmessage_come_from_qq));
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 10: 
            case 13: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_view_address_book_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 25: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_bottle_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 30: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_qrcode_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 58: 
            case 59: 
            case 60: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(this.bMV.getString(R.l.gcontact_from_source));
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 48: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(this.bMV.getString(R.l.contact_info_source_by_raddar));
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 15: 
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_search_mobile_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            case 18: 
              label3602:
              label3680:
              if (localObject7 == null) {
                continue;
              }
              ((KeyValuePreference)localObject7).vcS = false;
              ((KeyValuePreference)localObject7).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject7).setSummary(R.l.contact_info_source_by_lbs_passive);
              ((KeyValuePreference)localObject7).nf(false);
              break;
            }
          }
        }
        else
        {
          localObject2 = (KeyValuePreference)this.dnn.add("contact_info_source");
          if (this.mVJ)
          {
            switch (this.dnp.getSource())
            {
            default: 
              this.dnn.c((Preference)localObject2);
              break;
            case 18: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(R.l.contact_info_source_by_lbs_passive);
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 30: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(R.l.contact_info_source_by_qrcode_passive);
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 48: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(this.bMV.getString(R.l.contact_info_source_by_raddar));
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 22: 
            case 23: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(R.l.contact_info_source_by_shake_passive);
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 34: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(this.bMV.getString(R.l.contact_info_source_brandqa));
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 58: 
            case 59: 
            case 60: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(this.bMV.getString(R.l.gcontact_from_source));
              ((KeyValuePreference)localObject2).nf(false);
              break;
            case 76: 
              if (localObject2 == null) {
                continue;
              }
              ((KeyValuePreference)localObject2).vcS = false;
              ((KeyValuePreference)localObject2).setTitle(this.bMV.getString(R.l.contact_info_source_title));
              ((KeyValuePreference)localObject2).setSummary(this.bMV.getString(R.l.contact_info_source_by_linkedin));
              ((KeyValuePreference)localObject2).nf(false);
              break;
            }
          }
          else
          {
            this.dnn.c((Preference)localObject2);
            continue;
            label4575:
            bool1 = this.dnL.xw();
            continue;
            label4587:
            bool2 = false;
            continue;
            label4593:
            this.bGR = this.bMV.getIntent().getStringExtra("inviteer");
            if (bk.bl(this.bGR))
            {
              localObject2 = this.dnL.aaL(this.dnp.field_username);
              if (localObject2 != null) {
                break label4756;
              }
            }
            label4756:
            for (localObject2 = "";; localObject2 = bk.aM(((com.tencent.mm.k.a.a.b)localObject2).dtM, ""))
            {
              this.bGR = ((String)localObject2);
              if (bk.bl(this.bGR)) {
                this.bGR = com.tencent.mm.model.m.O(this.dnp.field_username, this.dpj);
              }
              if (!bk.bl(this.bGR)) {
                break label4771;
              }
              y.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.dpj, this.dnp.field_username });
              this.mXB.cqo();
              am.a.dVy.a(this.dnp.field_username, this.dpj, new k.2(this));
              break;
            }
            label4771:
            this.bMV.getIntent().putExtra("inviteer", this.bGR);
            localObject2 = gV(this.bGR);
            if (bk.bl((String)localObject2))
            {
              am.a.dVy.a(this.dnp.field_username, "", new k.3(this));
            }
            else
            {
              eo(this.bGR, (String)localObject2);
              continue;
              label4848:
              this.dnn.ade("contact_info_footer_normal");
            }
          }
        }
      }
      label4864:
      Object localObject2 = null;
    }
  }
  
  final void KV(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.fhj);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.dnp.field_username);
    paramString.putExtra("Contact_Nick", this.dnp.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.dnp.field_conRemark);
    com.tencent.mm.plugin.profile.a.eUR.o(paramString, this.bMV);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong)
  {
    paramString = (com.tencent.mm.ui.base.preference.g)this.dnn.add("contact_info_sns");
    if ((paramString != null) && (n.omD != null)) {
      paramString.WP(this.dnp.field_username);
    }
    this.mXo = n.omD.b(this.dnp.field_username, this.mXo);
    this.dnn.notifyDataSetChanged();
    if (paramBoolean3)
    {
      y.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (n.omH != null) {
        n.omH.MP(this.dnp.field_username);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    boolean bool;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label588;
      }
      bool = true;
      label31:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label594;
      }
      bool = true;
      label43:
      Assert.assertTrue(bool);
      this.dnn = paramf;
      this.dnp = paramad;
      this.mVI = paramBoolean;
      this.fhj = paramInt;
      this.mVJ = this.bMV.getIntent().getBooleanExtra("User_Verify", false);
      this.kzG = bk.pm(this.bMV.getIntent().getStringExtra("Verify_ticket"));
      this.mXp = this.bMV.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.mXi = this.bMV.getIntent().getIntExtra("Kdel_from", -1);
      this.mXq = this.bMV.getIntent().getStringExtra("Contact_RemarkName");
      this.bMp = this.bMV.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.mXs = this.bMV.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.mXt = this.bMV.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.mXr = this.bMV.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.bMV.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bk.aM(this.bMV.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.liF = bk.aM(this.bMV.getIntent().getStringExtra("verify_gmail"), "");
      this.mXu = bk.aM(this.bMV.getIntent().getStringExtra("profileName"), bk.aab(this.liF));
      this.mXo.ffs = this.mXr;
      this.mXo.ffu = l;
      this.mXo.fft = paramf;
      this.mXx = this.bMV.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.mXy = this.bMV.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (n.omD != null) {
        this.mXo = n.omD.b(paramad.field_username, this.mXo);
      }
      this.dpj = this.bMV.getIntent().getStringExtra("room_name");
      au.Hx();
      this.dnL = com.tencent.mm.model.c.FF().in(this.dpj);
      if (paramad.field_deleteFlag != 1) {
        break label600;
      }
    }
    label588:
    label594:
    label600:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mXw = paramBoolean;
      bsx();
      au.Hx();
      com.tencent.mm.model.c.Fw().abg(paramad.field_username);
      paramBoolean = q.Gj().equals(paramad.field_username);
      y.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.mXo.ffs) });
      paramInt = i;
      if ((this.mXo.ffs & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramad.Bg()) && (!ad.aaS(paramad.field_username)) && (paramInt != 0) && (n.omH != null)) {
        n.omH.a(2, paramad.field_username, paramBoolean, this.bMp);
      }
      return true;
      bool = false;
      break;
      bool = false;
      break label31;
      bool = false;
      break label43;
    }
  }
  
  public final boolean awZ()
  {
    if (n.omH != null) {
      n.omH.a(this, 3);
    }
    au.Dk().b(30, this);
    au.Dk().b(453, this);
    Object localObject = (NormalUserHeaderPreference)this.dnn.add("contact_info_header_normal");
    if (localObject != null) {
      ((NormalUserHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).awZ();
    }
    localObject = (FriendPreference)this.dnn.add("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).awZ();
    }
    localObject = (FriendPreference)this.dnn.add("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).awZ();
    }
    localObject = (FriendPreference)this.dnn.add("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).awZ();
    }
    this.dnn.add("contact_info_sns");
    return true;
  }
  
  final void eo(String paramString1, String paramString2)
  {
    y.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.dnn.add("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.dnn.add("contact_info_hint");
    this.dnn.bJ("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(j.b(this.bMV, this.bMV.getResources().getString(R.l.contact_info_invite_source, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.bMV.getResources().getColor(R.e.green_text_color)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.bMV.getIntent().putExtra("inviteer", paramString1);
    if ((this.dnL != null) && (!this.dnL.MN().contains(this.dnp.field_username)))
    {
      this.dnn.bJ("contact_info_footer_normal", true);
      localTextPreference.O(j.b(this.bMV, this.bMV.getResources().getString(R.l.contact_info_not_in_room, new Object[] { gV(this.dnp.field_username) })));
      return;
    }
    this.dnn.bJ("contact_info_footer_normal", false);
  }
  
  final String gV(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.dnL == null) {
      paramString = (String)localObject1;
    }
    ad localad;
    do
    {
      do
      {
        return paramString;
        au.Hx();
        localad = com.tencent.mm.model.c.Fw().abl(paramString);
        localObject1 = localObject2;
        if (localad != null)
        {
          localObject1 = localObject2;
          if ((int)localad.dBe > 0) {
            localObject1 = localad.field_conRemark;
          }
        }
        localObject2 = localObject1;
        if (bk.bl((String)localObject1)) {
          localObject2 = this.dnL.gV(paramString);
        }
        paramString = (String)localObject2;
      } while (!bk.bl((String)localObject2));
      paramString = (String)localObject2;
    } while (localad == null);
    return localad.Bp();
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    com.tencent.mm.plugin.messenger.a.g.bhI().o(str1, str2, bool);
    com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramIntent, str2);
    com.tencent.mm.ui.widget.snackbar.b.h(this.bMV, this.bMV.getString(R.l.finish_sent));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm.getType() != 30) && (paramm.getType() != 458)) {
      y.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramm.getType());
    }
    label268:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label268;
          }
          if (paramm.getType() != 30) {
            break;
          }
          paramString = (com.tencent.mm.pluginsdk.model.m)paramm;
        } while (((paramString.bNb != 1) && (paramString.bNb != 3)) || ((paramString.rTv != null) && (!paramString.rTv.contains(this.dnp.field_username))));
        paramString = (NormalUserHeaderPreference)this.dnn.add("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.mYB))
        {
          y.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.mXs = false;
          this.mXt = false;
          paramString.bB(this.dnp.field_username, false);
          paramString.bC(this.dnp.field_username, false);
          paramString.kk(this.dnp.field_username);
          this.bMV.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.mXs);
          this.bMV.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.mXt);
        }
      } while (paramm.getType() != 453);
      bsx();
      return;
    } while ((paramInt1 != 4) || (paramInt2 != -24) || (bk.bl(paramString)));
    Toast.makeText(this.bMV, paramString, 1).show();
  }
  
  public final boolean xQ(String paramString)
  {
    if (paramString.equals("contact_info_sns"))
    {
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        s.gM(this.bMV);
      }
    }
    do
    {
      do
      {
        return true;
        localObject2 = this.bMV.getIntent();
        ((Intent)localObject2).putExtra("sns_source", this.bMp);
        ((Intent)localObject2).putExtra("sns_signature", this.dnp.signature);
        ((Intent)localObject2).putExtra("sns_nickName", this.dnp.Bp());
        ((Intent)localObject2).putExtra("sns_title", this.dnp.Bq());
        localObject1 = localObject2;
        if (n.omH != null) {
          localObject1 = n.omH.e((Intent)localObject2, this.dnp.field_username);
        }
        if (localObject1 == null) {
          ((MMActivity)this.bMV).finish();
        }
        long l;
        while (paramString.equals("contact_info_more"))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(this.bMV, ContactMoreInfoUI.class);
          ((Intent)localObject2).putExtra("Is_RoomOwner", this.bMV.getIntent().getBooleanExtra("Is_RoomOwner", false));
          ((Intent)localObject2).putExtra("Contact_User", this.dnp.field_username);
          ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.mXx);
          ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.mXy);
          localObject1 = this.bMV.getIntent().getStringExtra("room_name");
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = this.bMV.getIntent().getStringExtra("Contact_ChatRoomId");
          }
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
          ((Intent)localObject2).putExtra("verify_gmail", this.liF);
          ((Intent)localObject2).putExtra("profileName", this.mXu);
          l = this.bMV.getIntent().getLongExtra("Contact_Uin", 0L);
          paramString = this.bMV.getIntent().getStringExtra("Contact_QQNick");
          ((Intent)localObject2).putExtra("Contact_Uin", l);
          ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
          this.bMV.startActivity((Intent)localObject2);
          return true;
          com.tencent.mm.br.d.b(this.bMV, "sns", ".ui.SnsUserUI", (Intent)localObject1);
          if ((((Intent)localObject1).getFlags() & 0x4000000) != 0) {
            ((MMActivity)this.bMV).finish();
          }
        }
        if (paramString.equals("contact_info_social"))
        {
          paramString = new Intent();
          paramString.setClass(this.bMV, ContactSocialInfoUI.class);
          paramString.putExtra("Contact_User", this.dnp.field_username);
          l = this.bMV.getIntent().getLongExtra("Contact_Uin", 0L);
          localObject1 = this.bMV.getIntent().getStringExtra("Contact_QQNick");
          paramString.putExtra("Contact_Uin", l);
          paramString.putExtra("Contact_QQNick", (String)localObject1);
          paramString.putExtra("profileName", this.mXu);
          paramString.putExtra("verify_gmail", this.liF);
          localObject1 = this.bMV.getIntent().getStringExtra("Contact_Mobile_MD5");
          localObject2 = this.bMV.getIntent().getStringExtra("Contact_full_Mobile_MD5");
          paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
          paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
          this.bMV.startActivity(paramString);
          return true;
        }
      } while (!paramString.equals("contact_info_invite_source"));
      paramString = ((KeyValuePreference)this.dnn.add("contact_info_invite_source")).getExtras().getString("inviteer");
    } while (bk.bl(paramString));
    Object localObject1 = gV(paramString);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Contact_User", paramString);
    ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
    ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
    ((Intent)localObject2).putExtra("Contact_RoomMember", true);
    ((Intent)localObject2).putExtra("room_name", this.dpj);
    au.Hx();
    ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.Fw().abl(paramString).field_nickname);
    ((Intent)localObject2).putExtra("Contact_Scene", 14);
    ((Intent)localObject2).putExtra("Is_RoomOwner", true);
    ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.dpj);
    com.tencent.mm.plugin.profile.a.eUR.d((Intent)localObject2, this.bMV);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */