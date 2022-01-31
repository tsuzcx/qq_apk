package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.kernel.i
public class ContactInfoUI
  extends MMPreference
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.messenger.foundation.a.a.m.a, com.tencent.mm.plugin.story.api.g, k.a, n.b
{
  private ad contact;
  private String eeu;
  private boolean fcx;
  private int gyR;
  private String mVw;
  private boolean pyA;
  private int pyB;
  private View.OnClickListener pyC;
  private PullDownListView.IPullDownCallback pyD;
  private View pyE;
  private View pyF;
  private c.a pyG;
  private boolean pyH;
  private com.tencent.mm.pluginsdk.b.a pyo;
  private boolean pyp;
  private boolean pyq;
  private byte[] pyr;
  private boolean pys;
  String pyt;
  private String pyu;
  private PullDownListView pyv;
  private boolean pyw;
  private AbsStoryGallery pyx;
  private AbsStoryMuteView pyy;
  private boolean pyz;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(23358);
    this.pys = false;
    this.pyt = null;
    this.pyu = "";
    this.eeu = "";
    this.pyv = null;
    this.pyw = false;
    this.pyx = null;
    this.pyy = null;
    this.pyz = false;
    this.pyA = false;
    this.fcx = false;
    this.pyB = 0;
    this.pyC = null;
    this.pyD = new ContactInfoUI.1(this);
    this.pyH = false;
    AppMethodBeat.o(23358);
  }
  
  private void cbU()
  {
    AppMethodBeat.i(23363);
    if ((this.pyE == null) || (!com.tencent.mm.ui.statusbar.c.ApJ))
    {
      AppMethodBeat.o(23363);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.aH(this);
    ContactInfoUI.2 local2 = new ContactInfoUI.2(this);
    this.pyG = local2;
    localc.a(local2);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.a(getWindow());
    AppMethodBeat.o(23363);
  }
  
  private void cbV()
  {
    AppMethodBeat.i(23382);
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(23382);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(23382);
  }
  
  private void cbW()
  {
    AppMethodBeat.i(23386);
    if (this.fcx)
    {
      com.tencent.mm.ui.base.t.makeText(ah.getContext(), getResources().getString(2131304178), 0).show();
      AppMethodBeat.o(23386);
      return;
    }
    if ((this.pyz) && (this.pyv != null)) {
      this.pyv.dPj();
    }
    AppMethodBeat.o(23386);
  }
  
  private void cbX()
  {
    boolean bool = true;
    AppMethodBeat.i(23387);
    ab.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", new Object[] { Boolean.valueOf(this.pyw), Boolean.valueOf(this.pyz) });
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    if ((this.pyz) && (!this.fcx))
    {
      cbU();
      setActionbarColor(getContext().getResources().getColor(2131690605));
      setMMTitle("");
      if (this.pyv != null)
      {
        this.pyv.setBackgroundResource(2130839609);
        this.pyv.setSupportOverscroll(true);
      }
      if (this.pyF != null) {
        this.pyF.setOnClickListener(new ContactInfoUI.9(this));
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.atx("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null) {
          if ((!this.pyz) || (this.fcx)) {
            break label264;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.B(bool, this.pyF.getHeight());
      AppMethodBeat.o(23387);
      return;
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131689615));
      setMMTitle("");
      if (this.pyv != null)
      {
        this.pyv.setBackgroundResource(2130839611);
        this.pyv.setSupportOverscroll(false);
      }
      if (this.pyE == null) {
        break;
      }
      this.pyE.setPadding(0, 0, 0, 0);
      break;
      label264:
      bool = false;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(23377);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(23377);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(23377);
  }
  
  public final void a(bv parambv)
  {
    AppMethodBeat.i(23379);
    al.d(new ContactInfoUI.b(this, parambv));
    AppMethodBeat.o(23379);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(23378);
    new ak().post(new ContactInfoUI.a(this, paramString));
    AppMethodBeat.o(23378);
  }
  
  public final void cbR()
  {
    AppMethodBeat.i(23359);
    ab.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.pyz = false;
    if ((this.pyv != null) && (!this.pyv.isVisible))
    {
      showTitleView();
      cbV();
      this.pyv.dPi();
    }
    cbX();
    AppMethodBeat.o(23359);
  }
  
  public final void cbS()
  {
    AppMethodBeat.i(23360);
    ab.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.pyz = true;
    if ((this.pyv != null) && (this.pyv.isVisible)) {
      cbX();
    }
    AppMethodBeat.o(23360);
  }
  
  public final void cbT()
  {
    AppMethodBeat.i(23361);
    ab.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.pyv.dPi();
    AppMethodBeat.o(23361);
  }
  
  public void finish()
  {
    AppMethodBeat.i(23388);
    com.tencent.mm.plugin.story.g.i locali = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDo().cVa = 0L;
    super.finish();
    AppMethodBeat.o(23388);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(23371);
    if ((this.contact == null) || ((int)this.contact.euF == 0) || (bo.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(23371);
      return "";
    }
    ab.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.aj.f.lg(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.aj.f.rX(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.aj.f.rW(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.dwz())
    {
      AppMethodBeat.o(23371);
      return "_bizContact";
    }
    if (com.tencent.mm.model.t.lA(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_chatroom";
    }
    if (com.tencent.mm.model.t.nM(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_bottle";
    }
    if (com.tencent.mm.model.t.nN(this.contact.field_username))
    {
      AppMethodBeat.o(23371);
      return "_QQ";
    }
    if (com.tencent.mm.model.t.oD(this.contact.field_username))
    {
      String str = "_" + this.contact.field_username;
      AppMethodBeat.o(23371);
      return str;
    }
    AppMethodBeat.o(23371);
    return "";
  }
  
  public int getResourceId()
  {
    return 2131165229;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23372);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.mVw = getIntent().getStringExtra("Verify_ticket");
    this.pyp = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.pyq = getIntent().getBooleanExtra("User_Verify", false);
    this.eeu = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = bo.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(str1);
    this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.yMc = str1;
    }
    com.tencent.mm.plugin.profile.b.gmP.a(this.contact);
    Object localObject6 = getIntent().getStringExtra("Contact_Nick");
    int j = getIntent().getIntExtra("Contact_Sex", 0);
    String str4 = getIntent().getStringExtra("Contact_Province");
    Object localObject7 = getIntent().getStringExtra("Contact_City");
    String str5 = getIntent().getStringExtra("Contact_Signature");
    int k = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    String str6 = getIntent().getStringExtra("Contact_VUser_Info");
    String str2 = getIntent().getStringExtra("Contact_Distance");
    int i1 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str7 = getIntent().getStringExtra("Contact_KWeibo");
    String str8 = getIntent().getStringExtra("Contact_KWeiboNick");
    String str3 = getIntent().getStringExtra("Contact_KFacebookName");
    long l = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.pyu = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.pyr = getIntent().getByteArrayExtra("Contact_customInfo");
    int i2 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    ab.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.eeu });
    Object localObject4;
    Object localObject8;
    label759:
    int m;
    label779:
    int n;
    label1235:
    int i;
    label1300:
    label1356:
    boolean bool1;
    if (bool2)
    {
      ab.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.n.a.je(this.contact.field_type))) {
        ao.a.flI.am(str1, this.eeu);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.euF == 0)) && (ad.arf(str1)) && (this.gyR != 15))
      {
        localObject4 = bo.nullAsNil(getIntent().getStringExtra(e.b.yUZ));
        localObject3 = localObject4;
        if (bo.isNullOrNil((String)localObject4)) {
          localObject3 = this.mVw;
        }
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.openim.b.h(str1, bo.nullAsNil(this.eeu), (String)localObject3), 0);
      }
      if ((this.contact != null) && ((int)this.contact.euF > 0) && ((!com.tencent.mm.model.t.oE(this.contact.field_username)) || ((ad.are(this.contact.field_username)) && (!com.tencent.mm.model.t.nS(this.contact.field_username)))))
      {
        if ((!this.contact.dwC()) || (!ad.arf(this.contact.field_username))) {
          break label2021;
        }
        localObject4 = bo.nullAsNil(getIntent().getStringExtra(e.b.yUZ));
        localObject3 = localObject4;
        if (bo.isNullOrNil((String)localObject4)) {
          localObject3 = this.mVw;
        }
        localObject8 = com.tencent.mm.kernel.g.RK().eHt;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label2009;
        }
        localObject4 = "";
        ((p)localObject8).a(new com.tencent.mm.openim.b.h(str10, (String)localObject4, (String)localObject3), 0);
      }
      m = getIntent().getIntExtra("Contact_verify_Scene", 9);
      getIntent().getIntExtra("key_add_contact_match_type", 0);
      localObject3 = getIntent().getStringExtra("key_add_contact_openim_appid");
      n = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
      localObject4 = getIntent().getStringExtra("key_add_contact_custom_detail");
      getIntent().getStringExtra("key_add_contact_desc_wording_id");
      getIntent().getStringExtra("key_add_contact_desc_icon");
      if ((this.contact != null) && ((int)this.contact.euF != 0) && (bo.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2259;
      }
      this.contact = new ad();
      this.contact.setUsername(str1);
      this.contact.jm((String)localObject5);
      this.contact.jp((String)localObject6);
      this.contact.jq(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.jr(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.hy(j);
      this.contact.jG(str4);
      this.contact.jH((String)localObject7);
      this.contact.jF(str5);
      this.contact.hu(k);
      this.contact.jK(str6);
      this.contact.jI(str2);
      this.contact.hD(m);
      this.contact.jJ(str7);
      this.contact.ht(i1);
      this.contact.js(str8);
      this.contact.fJ(l);
      this.contact.jA(str3);
      this.contact.jL(str9);
      this.contact.hG(i2);
      if ((!bo.isNullOrNil(this.pyt)) && (this.gyR == 15))
      {
        aw.aaz();
        localObject5 = com.tencent.mm.model.c.YB().TM(str1);
        localObject6 = new bv(str1);
        ((bv)localObject6).field_conRemark = ((bv)localObject5).field_conRemark;
        ((bv)localObject6).field_conDescription = ((bv)localObject5).field_conDescription;
        ((bv)localObject6).field_contactLabels = ((bv)localObject5).field_contactLabels;
        ((bv)localObject6).field_conPhone = this.pyt;
        aw.aaz();
        com.tencent.mm.model.c.YB().replace((com.tencent.mm.sdk.e.c)localObject6);
        this.pyt = null;
      }
      this.contact.jU((String)localObject4);
      this.contact.hH(n);
      this.contact.jy((String)localObject3);
      if ((ad.arf(this.contact.field_username)) && ((this.gyR == 30) || (this.gyR == 45) || (this.gyR == 17)))
      {
        localObject3 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject4 = this.contact.field_openImAppid;
        if (this.gyR != 17) {
          break label2885;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject3).e(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!bo.isNullOrNil((String)localObject1)) {
        this.contact.jv((String)localObject1);
      }
      if (this.contact != null) {
        break label2890;
      }
      ab.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.euF <= 0) && (this.contact.dwz()) && ((this.gyR == 17) || (this.gyR == 41)))
      {
        ab.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        ao.a.flI.am(this.contact.field_username, "");
        com.tencent.mm.ah.b.qT(this.contact.field_username);
      }
      if (this.contact.dqT != null) {
        break label3000;
      }
      bool1 = true;
      label1480:
      if (this.contact.dqT != null) {
        break label3006;
      }
      i = 0;
      label1492:
      if (this.contact.dqT != null) {
        break label3020;
      }
    }
    label2051:
    label2885:
    label2890:
    label3020:
    for (localObject1 = "";; localObject1 = bo.aqg(this.contact.dqT))
    {
      ab.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.euF <= 0) && (this.gyR == 96))
      {
        ab.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        ao.a.flI.an(this.contact.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.ah.b.U(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(r.Zn()))
      {
        aw.aaz();
        l = bo.getLong((String)com.tencent.mm.model.c.Ru().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.fJ(l);
          localObject1 = this.contact;
          aw.aaz();
          ((ad)localObject1).jA((String)com.tencent.mm.model.c.Ru().get(65826, null));
        }
        localObject1 = this.contact;
        aw.aaz();
        ((ad)localObject1).jO((String)com.tencent.mm.model.c.Ru().get(286721, null));
        localObject1 = this.contact;
        aw.aaz();
        ((ad)localObject1).jP((String)com.tencent.mm.model.c.Ru().get(286722, null));
        localObject1 = this.contact;
        aw.aaz();
        ((ad)localObject1).jQ((String)com.tencent.mm.model.c.Ru().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(ad.ark(r.Zn()))))
      {
        localObject1 = bp.aba();
        localObject3 = bo.nullAsNil(((bp)localObject1).getProvince());
        localObject4 = bo.nullAsNil(((bp)localObject1).getCity());
        if (!bo.isNullOrNil((String)localObject3)) {
          this.contact.jG((String)localObject3);
        }
        if (!bo.isNullOrNil((String)localObject4)) {
          this.contact.jH((String)localObject4);
        }
        if (!bo.isNullOrNil(((bp)localObject1).countryCode)) {
          this.contact.jL(RegionCodeDecoder.aF(((bp)localObject1).countryCode, ((bp)localObject1).fnC, ((bp)localObject1).fnB));
        }
        i = bo.a(Integer.valueOf(((bp)localObject1).dqC), 0);
        localObject1 = bo.nullAsNil(((bp)localObject1).signature);
        this.contact.hy(i);
        this.contact.jF((String)localObject1);
      }
      if (!bo.isNullOrNil(this.contact.field_username)) {
        break label3035;
      }
      ab.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(23372);
      return;
      ao.a.flI.am(str1, "");
      break;
      label2009:
      localObject4 = bo.nullAsNil(this.eeu);
      break label759;
      label2021:
      localObject3 = com.tencent.mm.aj.f.rS(this.contact.field_username);
      if ((this.contact.dwz()) && (com.tencent.mm.aj.a.adX()))
      {
        i = 1;
        if ((localObject3 != null) && ((!((com.tencent.mm.aj.d)localObject3).aea()) || (i != 0))) {
          break label2156;
        }
        ab.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(k) });
        localObject4 = ao.a.flI;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label2147;
        }
      }
      label2147:
      for (localObject3 = "";; localObject3 = this.eeu)
      {
        ((ao.b)localObject4).am((String)localObject8, (String)localObject3);
        com.tencent.mm.ah.b.qT(this.contact.field_username);
        break;
        i = 0;
        break label2051;
      }
      label2156:
      if ((!this.contact.dwC()) || (i != 0)) {
        break label779;
      }
      ab.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.dqR) });
      localObject4 = ao.a.flI;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.n.a.je(this.contact.field_type)) {}
      for (localObject3 = "";; localObject3 = this.eeu)
      {
        ((ao.b)localObject4).am((String)localObject8, (String)localObject3);
        com.tencent.mm.ah.b.qT(this.contact.field_username);
        break;
      }
      label2259:
      if (this.contact.dqC == 0) {
        this.contact.hy(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.jG(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.jH((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.jL(str9);
      }
      if ((bo.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.jF(str5);
      }
      if (k != 0) {
        this.contact.hu(k);
      }
      if ((bo.isNullOrNil(this.contact.dqP)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.jK(str6);
      }
      if ((bo.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.jp((String)localObject6);
      }
      ab.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { bo.nullAsNil(this.pyt) });
      if ((!bo.isNullOrNil(this.pyt)) && (this.gyR == 15))
      {
        i = 1;
        k = 1;
        str4 = this.contact.dqZ;
        if (str4 != null)
        {
          localObject7 = this.contact.dqZ.split(",");
          i1 = localObject7.length;
          j = 0;
          i = k;
          if (j < i1)
          {
            if (localObject7[j].equals(this.pyt)) {}
            for (i = 0;; i = 1)
            {
              j += 1;
              break;
            }
          }
        }
        if (i != 0)
        {
          this.contact.jS(str4 + this.pyt + ",");
          this.pyt = null;
        }
        ab.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { bo.nullAsNil(this.contact.dqZ) });
        this.contact.setSource(15);
      }
      this.contact.jI(str2);
      this.contact.hD(m);
      this.contact.fJ(l);
      this.contact.jA(str3);
      if (!com.tencent.mm.n.a.je(this.contact.field_type))
      {
        if (!bo.isNullOrNil((String)localObject5)) {
          this.contact.jm((String)localObject5);
        }
        if (!bo.isNullOrNil((String)localObject6)) {
          this.contact.jp((String)localObject6);
        }
        localObject5 = getIntent().getStringExtra("Contact_PyInitial");
        if (!bo.isNullOrNil((String)localObject5)) {
          this.contact.jq((String)localObject5);
        }
        localObject5 = getIntent().getStringExtra("Contact_QuanPin");
        if (!bo.isNullOrNil((String)localObject5)) {
          this.contact.jr((String)localObject5);
        }
      }
      if ((!com.tencent.mm.n.a.je(this.contact.field_type)) && (!bo.isNullOrNil((String)localObject4))) {
        this.contact.jU((String)localObject4);
      }
      if ((!com.tencent.mm.n.a.je(this.contact.field_type)) && (n != 0)) {
        this.contact.hH(n);
      }
      if (bo.isNullOrNil((String)localObject3)) {
        break label1235;
      }
      this.contact.jy((String)localObject3);
      break label1235;
      i = 1;
      break label1300;
      if (!bo.isNullOrNil((String)localObject1))
      {
        aw.aaz();
        localObject1 = com.tencent.mm.model.c.YB().TM((String)localObject1);
        if ((localObject1 != null) && (!bo.isNullOrNil(((bv)localObject1).field_encryptUsername)))
        {
          this.contact.jn(((bv)localObject1).field_conRemark);
          break label1356;
        }
      }
      if (bo.isNullOrNil(str1)) {
        break label1356;
      }
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YB().TM(str1);
      if ((localObject1 == null) || (bo.isNullOrNil(((bv)localObject1).field_encryptUsername))) {
        break label1356;
      }
      this.contact.jn(((bv)localObject1).field_conRemark);
      break label1356;
      bool1 = false;
      break label1480;
      i = this.contact.dqT.length();
      break label1492;
    }
    label3000:
    label3006:
    label3035:
    setMMTitle("");
    Object localObject3 = this.pyu;
    if (com.tencent.mm.model.t.nP(this.contact.field_username))
    {
      this.pyo = com.tencent.mm.bq.d.ab(this, "sport");
      if (this.pyo != null)
      {
        this.pyo.a(this.screen, this.contact, this.pyp, this.gyR);
        localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.contact.field_username);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = bo.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject3).aqf()).replace(" ", "");
        }
        if ((!this.pyH) && (com.tencent.mm.n.a.je(this.contact.field_type)) && ((this.pyo instanceof k)))
        {
          if (!bo.isNullOrNil(this.contact.dqZ)) {
            break label5005;
          }
          i = 0;
          label3191:
          if (!bo.isNullOrNil((String)localObject1)) {
            break label5023;
          }
          j = 0;
          label3201:
          j = i + j;
          localObject3 = com.tencent.mm.plugin.report.service.h.qsU;
          localObject4 = this.contact.field_username;
          if (!bo.isNullOrNil((String)localObject1)) {
            break label5028;
          }
          i = 0;
          label3229:
          if (j < 5) {
            break label5033;
          }
          j = 5;
        }
      }
    }
    label5005:
    label5023:
    label5028:
    label5033:
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject3).e(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      this.pyH = true;
      if ((!(this.pyo instanceof k)) && (!(this.pyo instanceof c)) && (!(this.pyo instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b)))
      {
        aw.aaz();
        localObject1 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yGy, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yGy, localObject1);
          ab.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (bo.isNullOrNil((String)localObject1)) {
            com.tencent.mm.x.c.PJ().y(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.atx("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).B(this.pyz, this.pyF.getHeight());
        }
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(23352);
          if (((com.tencent.mm.model.t.oj(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!r.ZI())) || ((com.tencent.mm.model.t.ob(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!r.ZE())) || ((com.tencent.mm.model.t.od(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!r.ZN())) || ((com.tencent.mm.model.t.nX(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!r.ZQ())))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.addFlags(67108864);
            com.tencent.mm.plugin.profile.b.gmO.p(paramAnonymousMenuItem, ContactInfoUI.this);
          }
          ContactInfoUI.this.finish();
          AppMethodBeat.o(23352);
          return true;
        }
      });
      o.adi().qV(this.contact.field_username);
      if (((!com.tencent.mm.model.t.oj(this.contact.field_username)) || (!r.ZI())) && ((!com.tencent.mm.model.t.ob(this.contact.field_username)) || (!r.ZE())) && ((!com.tencent.mm.model.t.od(this.contact.field_username)) || (!r.ZN())) && ((!com.tencent.mm.model.t.nX(this.contact.field_username)) || (!r.ZQ()))) {
        break label5036;
      }
      this.pys = true;
      AppMethodBeat.o(23372);
      return;
      if (com.tencent.mm.model.t.nX(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.ab(this, "qqmail");
        break;
      }
      if (com.tencent.mm.model.t.nY(this.contact.field_username))
      {
        this.pyo = new e(this);
        break;
      }
      if (com.tencent.mm.model.t.nZ(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.ab(this, "tmessage");
        break;
      }
      if (com.tencent.mm.model.t.ol(this.contact.field_username))
      {
        this.pyo = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (com.tencent.mm.model.t.nR(this.contact.field_username))
      {
        this.pyo = new h(this);
        break;
      }
      if (com.tencent.mm.model.t.of(this.contact.field_username))
      {
        this.pyo = new m(this);
        break;
      }
      if (ad.nM(this.contact.field_username))
      {
        this.pyo = new d(this);
        break;
      }
      if (com.tencent.mm.model.t.oh(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.ab(this, "nearby");
        break;
      }
      if (com.tencent.mm.model.t.oi(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.ab(this, "shake");
        break;
      }
      if (com.tencent.mm.model.t.oj(this.contact.field_username))
      {
        this.pyo = new j(this);
        break;
      }
      if (com.tencent.mm.model.t.ok(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.I(this, "readerapp", "widget_type_news");
        break;
      }
      if (com.tencent.mm.model.t.os(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.I(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (com.tencent.mm.model.t.oc(this.contact.field_username))
      {
        this.pyo = new f(this);
        break;
      }
      if (com.tencent.mm.model.t.od(this.contact.field_username))
      {
        this.pyo = com.tencent.mm.bq.d.ab(this, "masssend");
        break;
      }
      if (com.tencent.mm.model.t.oe(this.contact.field_username))
      {
        this.pyo = new g(this);
        break;
      }
      if ((this.contact.dwz()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.pyr;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            ab.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
            localObject2 = null;
            continue;
            if (!com.tencent.mm.aj.f.rU((String)localObject4)) {
              continue;
            }
            bool1 = true;
            continue;
            if (localObject2 == null) {
              continue;
            }
            localObject4 = new com.tencent.mm.aj.d();
            ((com.tencent.mm.aj.d)localObject4).field_extInfo = ((wc)localObject2).gxe;
            ab.i("MicroMsg.ContactInfoUI", "update extInfo=%s", new Object[] { ((com.tencent.mm.aj.d)localObject4).field_extInfo });
            ((com.tencent.mm.aj.d)localObject4).field_type = ((com.tencent.mm.aj.d)localObject4).cU(false).getServiceType();
            if (!((com.tencent.mm.aj.d)localObject4).aee()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!((com.tencent.mm.aj.d)localObject4).aed()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
              continue;
            }
            bool1 = true;
            continue;
            if ((com.tencent.mm.aj.f.rX(this.contact.field_username)) || (com.tencent.mm.aj.f.rW(this.contact.field_username)) || ((int)this.contact.euF > 0) || (!this.contact.dwz()) || ((this.gyR != 17) && (this.gyR != 41))) {
              continue;
            }
            bool1 = true;
            continue;
            bool1 = false;
            continue;
            localObject2 = new c(this, (String)localObject3, (wc)localObject2);
            if (bo.isNullOrNil(this.mVw)) {
              continue;
            }
            ((c)localObject2).mVw = this.mVw;
            this.pyo = ((com.tencent.mm.pluginsdk.b.a)localObject2);
          }
          localObject4 = this.contact.field_username;
          if ((!ah.dsQ().getBoolean("use_new_profile", true)) || (com.tencent.mm.model.t.oL((String)localObject4)) || (com.tencent.mm.model.t.og((String)localObject4)) || (com.tencent.mm.model.t.or((String)localObject4))) {
            continue;
          }
          if (!com.tencent.mm.aj.f.rT((String)localObject4)) {
            continue;
          }
          bool1 = true;
          ab.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            continue;
          }
          localObject1 = new com.tencent.mm.plugin.profile.ui.newbizinfo.b(this, (String)localObject3, (wc)localObject1);
          if (!bo.isNullOrNil(this.mVw)) {
            ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject1).mVw = this.mVw;
          }
          this.pyo = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject1 = (wc)new wc().parseFrom(this.pyr);
        }
        break;
      }
      if (com.tencent.mm.model.t.oo(this.contact.field_username))
      {
        this.pyo = new n(this);
        break;
      }
      if (com.tencent.mm.model.t.op(this.contact.field_username))
      {
        this.pyo = new i(this);
        break;
      }
      if (com.tencent.mm.model.t.nQ(this.contact.field_username))
      {
        this.pyo = new com.tencent.mm.plugin.downloader_app.e.a(this);
        break;
      }
      this.pyo = new com.tencent.mm.plugin.profile.a(this);
      if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (this.pyw)) {
        break;
      }
      ab.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, bo.dtY().toString() });
      this.pyw = true;
      this.pyv = ((PullDownListView)getListView());
      this.pyv.setBackgroundResource(2130839608);
      this.pyv.AIa = this.pyD;
      i = -am.hQ(getContext()).y / 10;
      Object localObject2 = (RelativeLayout)findViewById(2131826246);
      localObject3 = new RelativeLayout.LayoutParams(-1, am.hQ(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-am.fx(getContext()));
      if (this.contact.field_username.equals(r.Zn())) {}
      for (this.pyx = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.m.a.sqQ, this.eeu);; this.pyx = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.m.a.sqR, this.eeu))
      {
        this.pyv.y(this.pyx, com.tencent.mm.cb.a.ap(getContext(), 2131428634), i);
        this.pyx.setStoryBrowseUIListener(this);
        this.pyx.setDataSeed(this.contact.field_username);
        this.pyx.a(this.pyv);
        ((RelativeLayout)localObject2).addView(this.pyx, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.RM();
        this.pyy = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fb(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.ap(getContext(), 2131428633), com.tencent.mm.cb.a.ap(getContext(), 2131428633));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject2).addView(this.pyy, 0, (ViewGroup.LayoutParams)localObject3);
        this.pyv.setMuteView(this.pyy);
        this.pyv.setNavigationBarHeight(am.fx(getContext()));
        this.pyC = new ContactInfoUI.8(this);
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDo().cVa = 3L;
        break;
      }
      i = this.contact.dqZ.split(",").length;
      break label3191;
      j = 1;
      break label3201;
      i = 1;
      break label3229;
    }
    label5036:
    this.pys = false;
    AppMethodBeat.o(23372);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23375);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
    }
    if (this.pyo != null) {
      this.pyo.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(23375);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23385);
    if (((this.pyx == null) || (!this.pyx.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    AppMethodBeat.o(23385);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(23364);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.fcx = false;
    }
    for (;;)
    {
      if ((this.pyv != null) && (!this.pyv.isVisible)) {
        this.pyv.dPi();
      }
      cbX();
      AppMethodBeat.o(23364);
      return;
      if (paramConfiguration.orientation == 2) {
        this.fcx = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23362);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YA().arw(bo.nullAsNil(getIntent().getStringExtra("Contact_User")));
    if (localObject != null)
    {
      com.tencent.mm.kernel.g.RM();
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(((aq)localObject).field_username))
      {
        this.pyz = true;
        if (this.pyz) {
          customfixStatusbar(true);
        }
        super.onCreate(paramBundle);
        if (getResources().getConfiguration().orientation != 2) {
          break label225;
        }
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      this.fcx = bool;
      this.pyE = findViewById(2131820956);
      this.pyF = this.pyE.findViewById(2131820952);
      cbX();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      ab.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(aw.RG()) });
      this.pyt = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.RJ().QU()) {
        break label231;
      }
      finish();
      AppMethodBeat.o(23362);
      return;
      this.pyz = false;
      break;
    }
    label231:
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this);
    aw.aaz();
    com.tencent.mm.model.c.YB().a(this);
    initView();
    hideActionbarLine();
    if ((this.pyo instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))
    {
      paramBundle = (com.tencent.mm.plugin.profile.ui.newbizinfo.b)this.pyo;
      if ((paramBundle.contact == null) || (paramBundle.pyd == null)) {
        ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      }
    }
    else
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
      paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDo().cWp = com.tencent.mm.plugin.profile.c.al(getIntent());
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(273, this);
      AppMethodBeat.o(23362);
      return;
    }
    paramBundle.eaj = System.currentTimeMillis();
    localObject = paramBundle.contact.field_username;
    int j = paramBundle.gyR;
    int k = paramBundle.pyd.field_type;
    long l = paramBundle.eaj;
    if (com.tencent.mm.n.a.je(paramBundle.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a((String)localObject, j, k, l, i);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23365);
    Object localObject = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDo().cWp = 0L;
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      aw.aaz();
      com.tencent.mm.model.c.YA().b(this);
      aw.aaz();
      com.tencent.mm.model.c.YB().b(this);
    }
    if (this.pyo != null) {
      this.pyo.bkb();
    }
    if ((this.pyo instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))
    {
      localObject = (com.tencent.mm.plugin.profile.ui.newbizinfo.b)this.pyo;
      if ((((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).contact == null) || (((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pyd == null) || (((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf == null) || (((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzI == null) || (((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzH == null)) {
        ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      }
    }
    else
    {
      if (com.tencent.mm.plugin.sns.b.n.raQ != null) {
        com.tencent.mm.plugin.sns.b.n.raQ.ah(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(273, this);
      if (this.pyx != null) {
        this.pyx.onDestroy();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.h.qsU.e(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), this.contact.field_username, Boolean.valueOf(this.pyz), Boolean.valueOf(this.pyA), Integer.valueOf(this.contact.uin), Integer.valueOf(this.pyB) });
      AppMethodBeat.o(23365);
      return;
    }
    ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).endTime = System.currentTimeMillis();
    String str = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).contact.field_username;
    int k = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).gyR;
    int m = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pyd.field_type;
    long l1 = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).eaj;
    long l2 = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).endTime;
    int i;
    label396:
    int n;
    int i1;
    if (com.tencent.mm.n.a.je(((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).contact.field_type))
    {
      i = 1;
      n = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzI.wxQ;
      i1 = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzI.wxR;
      if (((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pzH == null) {
        break label500;
      }
    }
    label500:
    for (int j = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pzH.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzJ), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzM), ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject).pDf.wzH.jJA);
      break;
      i = 0;
      break label396;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23369);
    com.tencent.mm.modelstat.d.b(4, "ContactInfoUI" + getIdentString(), hashCode());
    com.tencent.mm.aj.z.afi().remove(this);
    super.onPause();
    aw.RO().ad(new ContactInfoUI.3(this));
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.r.a.bWS();
      com.tencent.mm.ax.d.w(com.tencent.mm.ax.b.fKU, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      cbV();
      if (this.pyx != null) {
        this.pyx.onPause();
      }
      if (((this.pyo instanceof c)) || ((this.pyo instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))) {
        this.pyo.bkb();
      }
      AppMethodBeat.o(23369);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.r.a.bWS();
        com.tencent.mm.ax.d.w(com.tencent.mm.ax.b.fKS, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(23376);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.pyo != null) {
      this.pyo.Ke(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label140;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        cbW();
      }
      AppMethodBeat.o(23376);
      return false;
      label140:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(23381);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(23381);
      return;
    }
    ab.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23381);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.ccw();
        }
        AppMethodBeat.o(23381);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131297837), false, new ContactInfoUI.5(this), new ContactInfoUI.6(this));
        }
        AppMethodBeat.o(23381);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.ccv();
        }
        AppMethodBeat.o(23381);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new ContactInfoUI.7(this), null);
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(23368);
    super.onRestart();
    this.pyH = false;
    AppMethodBeat.o(23368);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23366);
    com.tencent.mm.modelstat.d.b(3, "ContactInfoUI" + getIdentString(), hashCode());
    com.tencent.mm.aj.z.afi().add(this);
    super.onResume();
    Object localObject = ((ViewGroup)getContentView()).getFocusedChild();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      ab.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(((View)localObject).getId()) });
    }
    this.pyv = ((PullDownListView)getListView());
    if (this.pyx != null) {
      this.pyx.onResume();
    }
    if (this.screen != null)
    {
      localObject = (NormalProfileHeaderPreference)this.screen.atx("contact_profile_header_normal");
      if (localObject != null) {
        ((NormalProfileHeaderPreference)localObject).B(this.pyz, this.pyF.getHeight());
      }
    }
    if (((this.pyo instanceof c)) || ((this.pyo instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))) {
      this.pyo.a(this.screen, this.contact, this.pyp, this.gyR);
    }
    AppMethodBeat.o(23366);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(23384);
    ab.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    int i;
    if ((273 == paramm.getType()) && (this.contact != null) && ((this.pyo instanceof com.tencent.mm.plugin.profile.a)) && (bo.isEqual(this.contact.field_username, ((com.tencent.mm.plugin.story.model.a.j)paramm).userName)))
    {
      i = ((com.tencent.mm.plugin.story.model.a.j)paramm).cpt;
      paramString = com.tencent.mm.plugin.story.h.a.sFV;
      if (i != com.tencent.mm.plugin.story.h.a.cEv()) {
        break label170;
      }
      i = 1;
      if (i != 0) {
        if (((paramInt1 != 0) && (paramInt1 != 4)) || (paramInt2 == 315)) {
          break label176;
        }
      }
    }
    label170:
    label176:
    for (boolean bool = true;; bool = false)
    {
      this.pyA = bool;
      this.pyB = ((com.tencent.mm.plugin.story.model.a.j)paramm).sxs;
      AppMethodBeat.o(23384);
      return;
      i = 0;
      break;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(23367);
    super.onStart();
    if (this.pyx != null) {
      this.pyx.onStart();
    }
    AppMethodBeat.o(23367);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23370);
    super.onStop();
    if (this.pyx != null) {
      this.pyx.onStop();
    }
    AppMethodBeat.o(23370);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */