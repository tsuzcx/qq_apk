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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.sdk.platformtools.h(dsp={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.ai.f, h.a, com.tencent.mm.pluginsdk.b.a
{
  MMActivity cmc;
  String cog;
  ad contact;
  private int ctK;
  u efi;
  String egF;
  int gyR;
  private String mVw;
  private int pAe;
  private cfj pAk;
  private boolean pAl;
  private String pAm;
  private int pAn;
  private boolean pAo;
  private boolean pAp;
  private String pAq;
  private boolean pAr;
  private String pAs;
  private String pAt;
  private int pAu;
  String pAv;
  com.tencent.mm.sdk.b.c<au> pAw;
  private boolean pyp;
  private boolean pyq;
  private String pzj;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void BG(int paramInt)
  {
    AppMethodBeat.i(23584);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.atx("contact_info_source");
    if (!this.pyq)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.zrr = false;
          localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
          localKeyValuePreference.setSummary(this.cmc.getString(2131300000));
          localKeyValuePreference.qJ(false);
          AppMethodBeat.o(23584);
          return;
        }
        this.screen.d(localKeyValuePreference);
      }
      AppMethodBeat.o(23584);
      return;
    }
    switch (paramInt)
    {
    default: 
      this.screen.d(localKeyValuePreference);
    case 1: 
    case 3: 
    case 17: 
    case 8: 
    case 14: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(23584);
              return;
            } while (localKeyValuePreference == null);
            localKeyValuePreference.zrr = false;
            localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
            localKeyValuePreference.setSummary(2131298799);
            localKeyValuePreference.qJ(false);
            AppMethodBeat.o(23584);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.zrr = false;
          localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
          localKeyValuePreference.setSummary(2131298802);
          localKeyValuePreference.qJ(false);
          AppMethodBeat.o(23584);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localObject2 = s.nE(this.cmc.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2)) {
          localObject1 = this.cmc.getIntent().getStringExtra("source_from_nick_name");
        }
        if (bo.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131298779);
        }
        for (;;)
        {
          localKeyValuePreference.qJ(false);
          AppMethodBeat.o(23584);
          return;
          localKeyValuePreference.setSummary(j.b(this.cmc, this.cmc.getString(2131298778, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localObject1 = com.tencent.mm.bi.d.alh().asd(this.contact.field_username);
      aw.aaz();
      Object localObject2 = com.tencent.mm.model.c.YA();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bd)localObject2).arw((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((aq)localObject1).field_nickname;; localObject1 = null)
    {
      if (!bo.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.cmc.getString(2131298785, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23584);
        return;
        localObject1 = ((ax)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131298783);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(this.cmc.getString(2131300001));
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(2131298808);
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(2131298774);
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(2131298792);
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(this.cmc.getString(2131300486));
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(this.cmc.getString(2131298794));
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(2131298796);
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.zrr = false;
      localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
      localKeyValuePreference.setSummary(2131298787);
      localKeyValuePreference.qJ(false);
      AppMethodBeat.o(23584);
      return;
    }
  }
  
  private void ccd()
  {
    AppMethodBeat.i(23579);
    bkb();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165214);
    if (com.tencent.mm.plugin.sns.b.n.raV != null) {
      com.tencent.mm.plugin.sns.b.n.raV.a(3, this.contact.field_username, this);
    }
    aw.Rc().a(30, this);
    aw.Rc().a(453, this);
    this.pAv = "";
    ab.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.Ob() });
    if (!this.contact.Ob())
    {
      localObject1 = null;
      localObject2 = this.cmc.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.cmc.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bo.isNullOrNil((String)localObject2)) || (!bo.isNullOrNil((String)localObject3))) {
        break label737;
      }
      if (!bo.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label729;
        }
        localObject1 = "true";
        ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label245:
      if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Al())))
      {
        this.pAv = bo.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aqf()).replace(" ", "");
        ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.pAv });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.atx("contact_info_header_normal");
    label423:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.gyR, this.mVw, this.pAv, this.contact.dqZ);
      ((NormalUserHeaderPreference)localObject2).cd(this.contact.field_username, this.pAo);
      ((NormalUserHeaderPreference)localObject2).wby = new k.1(this);
      if (com.tencent.mm.n.a.je(this.contact.field_type)) {
        this.pAp = false;
      }
      ((NormalUserHeaderPreference)localObject2).ce(this.contact.field_username, this.pAp);
      if ((!ad.arf(this.contact.field_username)) || (this.contact.drd == 0)) {
        break label1175;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", b.a.gfD);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.cmc);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).zsc = new k.4(this);
      }
      localObject1 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject1).wl(this.contact.dre);
      localObject1 = ((com.tencent.mm.openim.a.c)localObject1).gfG.iterator();
      label575:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (c.a)((Iterator)localObject1).next();
        localObject4 = ((c.a)localObject3).gfH.iterator();
        i = j;
      }
    }
    else
    {
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject4).hasNext()) {
          break label575;
        }
        c.b localb = (c.b)((Iterator)localObject4).next();
        j = i + 1;
        k.5 local5 = new k.5(this, this.cmc, localb);
        local5.zaD = ((c.a)localObject3).title;
        local5.setSummary(j.b(this.cmc, localb.wm(this.contact.field_openImAppid)));
        this.screen.a(local5, j);
        if ((localb.action == 0) || (localb.action == 1))
        {
          local5.setEnabled(true);
          i = j;
          continue;
          label729:
          localObject1 = "false";
          break;
          label737:
          if ((bo.isNullOrNil((String)localObject2)) && (bo.isNullOrNil((String)localObject3))) {
            break label245;
          }
          ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Al())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.d((Preference)localObject2);
          break label423;
        }
        if (localb.action == 2)
        {
          local5.zsc = new k.6(this, localb, (c.a)localObject3);
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.zsc = new k.7(this, localb, (c.a)localObject3);
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.zsc = new k.8(this, localb, (c.a)localObject3);
          i = j;
        }
        else
        {
          i = j;
          if (localb.action == 5)
          {
            local5.zsc = new k.9(this, localb, (c.a)localObject3);
            i = j;
          }
        }
      }
    }
    int i = j + 1;
    this.screen.a(new PreferenceSmallCategory(this.cmc), i);
    Object localObject1 = new KeyValuePreference(this.cmc);
    ((KeyValuePreference)localObject1).setTitle(2131298589);
    Object localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_desc", b.a.gfD);
    ((KeyValuePreference)localObject1).setSummary(j.b(this.cmc, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_url", b.a.gfE);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).zsc = new k.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1175:
    if (!bo.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.atx("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.cmc.getString(2131298587));
        localObject4 = new StringBuilder().append(s.nG(this.contact.getProvince()));
        if (bo.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).qJ(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.n.a.je(this.contact.field_type))) {
          break label1913;
        }
        localObject1 = (KeyValuePreference)this.screen.atx("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).zrr = false;
          ((KeyValuePreference)localObject1).setTitle(this.cmc.getString(2131298759));
          ((KeyValuePreference)localObject1).setSummary(j.b(this.cmc, this.contact.signature));
          ((KeyValuePreference)localObject1).qJ(false);
        }
        label1400:
        this.screen.atx("contact_info_facebook");
        this.screen.aty("contact_info_facebook");
        if ((this.pAk.gxa & 0x1) <= 0) {
          break label1929;
        }
        i = 1;
        label1440:
        if (((i & com.tencent.mm.bq.d.ahR("sns")) == 0) || (ad.ard(this.contact.field_username)) || (this.contact.NW())) {
          break label1934;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.atx("contact_info_sns");
        if ((localObject1 != null) && (com.tencent.mm.plugin.sns.b.n.raR != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).amx(this.contact.field_username);
        }
        label1516:
        this.screen.aty("contact_info_verifyuser");
        this.screen.aty("contact_info_footer_normal");
        new com.tencent.mm.plugin.profile.a.b(this.cmc, this.contact).bMz();
        if (this.gyR == 96) {
          this.screen.aty("contact_info_footer_normal");
        }
        if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label1950;
        }
        ccp();
        this.screen.aty("contact_info_social");
        label1612:
        ccn();
        cco();
        localObject1 = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
        boolean bool1 = this.cmc.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.cmc.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.cmc.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.cmc.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.gyR == 30) || (this.gyR == 45)) {
          this.pAl = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.mVw, this.pyp, this.pyq, this.pAl, this.gyR, this.pAe, bool2, bool1, l, this.pAm))) {
          break label1970;
        }
        ((NormalUserFooterPreference)localObject1).frK.removeAll();
        ((NormalUserFooterPreference)localObject1).frK.a(new k.11(this), Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1291:
      this.screen.aty("clear_lbs_info");
      if (this.pAr)
      {
        this.screen.removeAll();
        if (localObject2 != null) {
          this.screen.b((Preference)localObject2);
        }
        if (localObject1 != null) {
          this.screen.b((Preference)localObject1);
        }
      }
      AppMethodBeat.o(23579);
      return;
      localObject1 = "  " + this.contact.getCity();
      break;
      this.screen.aty("contact_info_district");
      break label1291;
      label1913:
      this.screen.aty("contact_info_signature");
      break label1400;
      label1929:
      i = 0;
      break label1440;
      label1934:
      this.screen.aty("contact_info_sns");
      break label1516;
      label1950:
      ccm();
      this.screen.aty("contact_info_more");
      break label1612;
      label1970:
      this.screen.aty("contact_info_footer_normal");
    }
  }
  
  private void ccm()
  {
    Object localObject4 = null;
    AppMethodBeat.i(23577);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.atx("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (bo.isNullOrNil(this.pAv)) {
        break label415;
      }
      localContactSocialInfoPreference.BC(0);
      this.pAu = 1;
    }
    for (;;)
    {
      aw.aaz();
      int i = bo.g((Integer)com.tencent.mm.model.c.Ru().get(9, null));
      long l = this.cmc.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.cmc.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().hn(l);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = null;
          }
          if (localObject1 != null) {
            ((ao)localObject1).getDisplayName();
          }
        }
        if ((l != -1L) && (new com.tencent.mm.a.p(l).longValue() > 0L))
        {
          localContactSocialInfoPreference.By(0);
          this.pAu = 1;
        }
      }
      else
      {
        label192:
        if ((bo.isNullOrNil(this.pzj)) || (bo.isNullOrNil(this.pAq))) {
          break label435;
        }
        localContactSocialInfoPreference.BA(0);
        this.pAu = 1;
        label223:
        localObject1 = com.tencent.mm.m.g.Nq().getValue("LinkedinPluginClose");
        if ((!bo.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
          break label445;
        }
        i = 1;
        label255:
        if ((i == 0) || (bo.isNullOrNil(this.contact.dqV))) {
          break label450;
        }
        localContactSocialInfoPreference.Bz(0);
        this.pAu = 1;
        label283:
        if (!r.Zn().equals(this.contact.field_username)) {
          break label460;
        }
        aw.aaz();
        localObject1 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAI, null);
        localObject2 = localObject4;
        if (bo.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        ab.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!bo.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.BB(0);
          this.pAu = 1;
          if (this.pAu == 0) {
            this.screen.aty("contact_info_social");
          }
          AppMethodBeat.o(23577);
          return;
          label415:
          localContactSocialInfoPreference.BC(8);
          continue;
          localContactSocialInfoPreference.By(8);
          break label192;
          label435:
          localContactSocialInfoPreference.BA(8);
          break label223;
          label445:
          i = 0;
          break label255;
          label450:
          localContactSocialInfoPreference.Bz(8);
          break label283;
          label460:
          localObject1 = this.contact.dqY;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.BB(8);
        }
      }
    }
  }
  
  private void ccn()
  {
    AppMethodBeat.i(23580);
    if (com.tencent.mm.n.a.je(this.contact.field_type))
    {
      this.screen.aty("contact_info_source");
      AppMethodBeat.o(23580);
      return;
    }
    int i = this.cmc.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    ab.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      BG(i);
      AppMethodBeat.o(23580);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.atx("contact_info_source");
    if (this.pyq) {
      switch (this.contact.getSource())
      {
      default: 
        this.screen.d(localKeyValuePreference);
        AppMethodBeat.o(23580);
        return;
      case 18: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(2131298787);
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(2131298792);
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(this.cmc.getString(2131298794));
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 22: 
      case 23: 
      case 24: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(2131298805);
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(this.cmc.getString(2131298771));
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(this.cmc.getString(2131300486));
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.zrr = false;
        localKeyValuePreference.setTitle(this.cmc.getString(2131298811));
        localKeyValuePreference.setSummary(this.cmc.getString(2131298789));
        localKeyValuePreference.qJ(false);
        AppMethodBeat.o(23580);
        return;
      }
    } else {
      this.screen.d(localKeyValuePreference);
    }
    AppMethodBeat.o(23580);
  }
  
  private void cco()
  {
    AppMethodBeat.i(23581);
    this.screen.cl("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.efi == null)
    {
      bool1 = this.cmc.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.gyR == 14) && (bool1) && (this.efi != null) && (!this.contact.field_username.equals(this.efi.field_roomowner))) {
        break label164;
      }
      i = this.gyR;
      if (this.efi != null) {
        break label159;
      }
    }
    label159:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.cl("contact_info_invite_source", true);
      AppMethodBeat.o(23581);
      return;
      bool1 = this.efi.JP();
      break;
    }
    label164:
    this.cog = this.cmc.getIntent().getStringExtra("inviteer");
    if (bo.isNullOrNil(this.cog)) {
      this.cog = this.efi.aqX(this.contact.field_username);
    }
    if (bo.isNullOrNil(this.cog)) {
      this.cog = com.tencent.mm.model.n.ad(this.contact.field_username, this.egF);
    }
    if (bo.isNullOrNil(this.cog))
    {
      ab.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.egF, this.contact.field_username });
      this.pAw.alive();
      ao.a.flI.a(this.contact.field_username, this.egF, new k.2(this));
      AppMethodBeat.o(23581);
      return;
    }
    this.cmc.getIntent().putExtra("inviteer", this.cog);
    String str = nE(this.cog);
    if (bo.isNullOrNil(str))
    {
      ao.a.flI.a(this.contact.field_username, "", new k.3(this));
      AppMethodBeat.o(23581);
      return;
    }
    fM(this.cog, str);
    AppMethodBeat.o(23581);
  }
  
  private void ccp()
  {
    int j = 1;
    AppMethodBeat.i(23585);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.atx("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.cmc.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new com.tencent.mm.a.p(l).longValue() <= 0L)) {
        break label320;
      }
      localContactMoreInfoPreference.By(0);
      arrayOfInt[0] = 0;
      if ((bo.isNullOrNil(this.pzj)) || (bo.isNullOrNil(this.pAq))) {
        break label336;
      }
      localContactMoreInfoPreference.BA(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.m.g.Nq().getValue("LinkedinPluginClose");
      i = j;
      if (!bo.isNullOrNil(str))
      {
        if (Integer.valueOf(str).intValue() != 0) {
          break label352;
        }
        i = j;
      }
      label151:
      if ((i == 0) || (bo.isNullOrNil(this.contact.dqV))) {
        break label357;
      }
      localContactMoreInfoPreference.Bz(0);
      arrayOfInt[2] = 0;
      label179:
      if (!r.Zn().equals(this.contact.field_username)) {
        break label373;
      }
      aw.aaz();
      str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAI, null);
      label214:
      if (bo.isNullOrNil(str)) {
        break label400;
      }
    }
    for (;;)
    {
      try
      {
        str = new JSONObject(str).optString("ShopUrl");
        if (bo.isNullOrNil(str)) {
          break label406;
        }
        localContactMoreInfoPreference.BB(0);
        arrayOfInt[3] = 0;
        if (!bo.isNullOrNil(this.contact.signature)) {
          break label422;
        }
        arrayOfInt[4] = 8;
        if (this.contact.getSource() > 0) {
          break label430;
        }
        arrayOfInt[5] = 8;
        arrayOfInt[6] = 8;
        this.screen.cl("contact_info_more", false);
        AppMethodBeat.o(23585);
        return;
      }
      catch (JSONException localJSONException)
      {
        label320:
        label336:
        label352:
        label357:
        label373:
        ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
      }
      localContactMoreInfoPreference.By(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.BA(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label151;
      localContactMoreInfoPreference.Bz(8);
      arrayOfInt[2] = 8;
      break label179;
      str = this.contact.dqY;
      break label214;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.BB(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private String nE(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(23583);
    if (this.efi == null)
    {
      AppMethodBeat.o(23583);
      return null;
    }
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(paramString);
    Object localObject1 = localObject2;
    if (localad != null)
    {
      localObject1 = localObject2;
      if ((int)localad.euF > 0) {
        localObject1 = localad.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1)) {
      localObject2 = this.efi.nE(paramString);
    }
    paramString = (String)localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localad != null) {
        paramString = localad.Oe();
      }
    }
    AppMethodBeat.o(23583);
    return paramString;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23575);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.ii(this.cmc);
        AppMethodBeat.o(23575);
        return true;
      }
      localObject2 = this.cmc.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.ctK);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.Oe());
      ((Intent)localObject2).putExtra("sns_title", this.contact.Of());
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.b.n.raV != null) {
        localObject1 = com.tencent.mm.plugin.sns.b.n.raV.e((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.cmc.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label435;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.cmc, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.cmc.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.pAs);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.pAt);
      localObject1 = this.cmc.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.cmc.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.pzj);
      ((Intent)localObject2).putExtra("profileName", this.pAq);
      l = this.cmc.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.cmc.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      this.cmc.startActivity((Intent)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(23575);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.bq.d.b(this.cmc, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.cmc.finish();
      break;
      label435:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.cmc, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.cmc.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.cmc.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.pAq);
        paramString.putExtra("verify_gmail", this.pzj);
        localObject1 = this.cmc.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.cmc.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        this.cmc.startActivity(paramString);
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.atx("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!bo.isNullOrNil(paramString))
        {
          localObject1 = nE(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.egF);
          aw.aaz();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.YA().arw(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.egF);
          com.tencent.mm.plugin.profile.b.gmO.c((Intent)localObject2, this.cmc);
        }
      }
    }
  }
  
  final void Xf(String paramString)
  {
    AppMethodBeat.i(23576);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(23576);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.gyR);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.gmO.n(paramString, this.cmc);
    AppMethodBeat.o(23576);
  }
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(23588);
    paramString1 = (com.tencent.mm.ui.base.preference.g)this.screen.atx("contact_info_sns");
    if ((paramString1 != null) && (com.tencent.mm.plugin.sns.b.n.raR != null)) {
      paramString1.amx(this.contact.field_username);
    }
    this.pAk = com.tencent.mm.plugin.sns.b.n.raR.b(this.contact.field_username, this.pAk);
    this.screen.notifyDataSetChanged();
    if (paramBoolean3)
    {
      ab.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (com.tencent.mm.plugin.sns.b.n.raV != null) {
        com.tencent.mm.plugin.sns.b.n.raV.Zw(this.contact.field_username);
      }
    }
    AppMethodBeat.o(23588);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(23578);
    boolean bool;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
        break label600;
      }
      bool = true;
      label37:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label606;
      }
      bool = true;
      label49:
      Assert.assertTrue(bool);
      this.screen = paramf;
      this.contact = paramad;
      this.pyp = paramBoolean;
      this.gyR = paramInt;
      this.pyq = this.cmc.getIntent().getBooleanExtra("User_Verify", false);
      this.mVw = bo.nullAsNil(this.cmc.getIntent().getStringExtra("Verify_ticket"));
      this.pAl = this.cmc.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.pAe = this.cmc.getIntent().getIntExtra("Kdel_from", -1);
      this.pAm = this.cmc.getIntent().getStringExtra("Contact_RemarkName");
      this.ctK = this.cmc.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.pAo = this.cmc.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.pAp = this.cmc.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.pAn = this.cmc.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.cmc.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bo.bf(this.cmc.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.pzj = bo.bf(this.cmc.getIntent().getStringExtra("verify_gmail"), "");
      this.pAq = bo.bf(this.cmc.getIntent().getStringExtra("profileName"), bo.aqf(this.pzj));
      this.pAk.gxa = this.pAn;
      this.pAk.gxc = l;
      this.pAk.gxb = paramf;
      this.pAs = this.cmc.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.pAt = this.cmc.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (com.tencent.mm.plugin.sns.b.n.raR != null) {
        this.pAk = com.tencent.mm.plugin.sns.b.n.raR.b(paramad.field_username, this.pAk);
      }
      this.egF = this.cmc.getIntent().getStringExtra("room_name");
      aw.aaz();
      this.efi = com.tencent.mm.model.c.YJ().oU(this.egF);
      if (paramad.field_deleteFlag != 1) {
        break label612;
      }
    }
    label600:
    label606:
    label612:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.pAr = paramBoolean;
      ccd();
      aw.aaz();
      com.tencent.mm.model.c.YA().arr(paramad.field_username);
      paramBoolean = r.Zn().equals(paramad.field_username);
      ab.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.pAk.gxa) });
      paramInt = i;
      if ((this.pAk.gxa & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramad.NW()) && (!ad.ard(paramad.field_username)) && (paramInt != 0) && (com.tencent.mm.plugin.sns.b.n.raV != null)) {
        com.tencent.mm.plugin.sns.b.n.raV.a(2, paramad.field_username, paramBoolean, this.ctK);
      }
      AppMethodBeat.o(23578);
      return true;
      bool = false;
      break;
      bool = false;
      break label37;
      bool = false;
      break label49;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23586);
    if (com.tencent.mm.plugin.sns.b.n.raV != null) {
      com.tencent.mm.plugin.sns.b.n.raV.a(this, 3);
    }
    aw.Rc().b(30, this);
    aw.Rc().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.atx("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).bkb();
    }
    localObject = (FriendPreference)this.screen.atx("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).bkb();
    }
    localObject = (FriendPreference)this.screen.atx("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).bkb();
    }
    localObject = (FriendPreference)this.screen.atx("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).bkb();
    }
    this.screen.atx("contact_info_sns");
    AppMethodBeat.o(23586);
    return true;
  }
  
  final void fM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23582);
    ab.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.atx("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.atx("contact_info_hint");
    this.screen.cl("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(j.b(this.cmc, this.cmc.getResources().getString(2131298631, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.cmc.getResources().getColor(2131689778)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.cmc.getIntent().putExtra("inviteer", paramString1);
    if ((this.efi != null) && (!this.efi.afx().contains(this.contact.field_username)))
    {
      this.screen.cl("contact_info_footer_normal", true);
      localTextPreference.ac(j.b(this.cmc, this.cmc.getResources().getString(2131298684, new Object[] { nE(this.contact.field_username) })));
      AppMethodBeat.o(23582);
      return;
    }
    this.screen.cl("contact_info_footer_normal", false);
    AppMethodBeat.o(23582);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(23587);
    if ((paramm.getType() != 30) && (paramm.getType() != 458))
    {
      ab.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramm.getType());
      AppMethodBeat.o(23587);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.m)paramm;
        if ((paramString.cut != 1) && (paramString.cut != 3))
        {
          AppMethodBeat.o(23587);
          return;
        }
        if ((paramString.vKs != null) && (!paramString.vKs.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(23587);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.atx("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.pCd))
        {
          ab.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.pAo = false;
          this.pAp = false;
          paramString.cd(this.contact.field_username, false);
          paramString.ce(this.contact.field_username, false);
          paramString.re(this.contact.field_username);
          this.cmc.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.pAo);
          this.cmc.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.pAp);
        }
      }
      if (paramm.getType() == 453)
      {
        ccd();
        AppMethodBeat.o(23587);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString)))
    {
      Toast.makeText(this.cmc, paramString, 1).show();
    }
    AppMethodBeat.o(23587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */