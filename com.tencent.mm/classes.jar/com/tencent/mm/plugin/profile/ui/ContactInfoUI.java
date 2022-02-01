package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import java.io.IOException;

@com.tencent.mm.kernel.i
public class ContactInfoUI
  extends MMPreference
  implements com.tencent.mm.al.g, m.a, com.tencent.mm.plugin.story.api.g, k.a, n.b
{
  private com.tencent.mm.storage.af contact;
  private boolean gBu;
  private int ima;
  private com.tencent.mm.pluginsdk.ui.span.h mYs;
  private c.a qAM;
  private String roomId;
  private String rso;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean uAa;
  private byte[] uAb;
  private boolean uAc;
  String uAd;
  private String uAe;
  private PullDownListView uAf;
  private boolean uAg;
  private AbsStoryGallery uAh;
  private AbsStoryMuteView uAi;
  private boolean uAj;
  private boolean uAk;
  private int uAl;
  private View.OnClickListener uAm;
  private PullDownListView.IPullDownCallback uAn;
  private View uAo;
  private View uAp;
  private boolean uAq;
  private com.tencent.mm.pluginsdk.b.a uzY;
  private boolean uzZ;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.uAc = false;
    this.uAd = null;
    this.uAe = "";
    this.roomId = "";
    this.uAf = null;
    this.uAg = false;
    this.uAh = null;
    this.uAi = null;
    this.uAj = false;
    this.uAk = false;
    this.gBu = false;
    this.uAl = 0;
    this.uAm = null;
    this.uAn = new ContactInfoUI.1(this);
    this.mYs = new ContactInfoUI.3(this);
    this.uAq = false;
    AppMethodBeat.o(26982);
  }
  
  private void dcl()
  {
    AppMethodBeat.i(26987);
    if ((this.uAo == null) || (!com.tencent.mm.ui.statusbar.c.HlA))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bj(this);
    c.a local4 = new c.a()
    {
      public final void sG(int paramAnonymousInt)
      {
        AppMethodBeat.i(26971);
        if (ContactInfoUI.f(ContactInfoUI.this)) {
          ContactInfoUI.g(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(26971);
      }
    };
    this.qAM = local4;
    localc.a(local4);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.b(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void dcm()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void dcn()
  {
    AppMethodBeat.i(27006);
    if (this.gBu)
    {
      t.makeText(aj.getContext(), getResources().getString(2131764289), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.uAj) && (this.uAf != null)) {
      this.uAf.ffS();
    }
    AppMethodBeat.o(27006);
  }
  
  private void dco()
  {
    boolean bool = true;
    AppMethodBeat.i(27007);
    ad.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", new Object[] { Boolean.valueOf(this.uAg), Boolean.valueOf(this.uAj) });
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    if ((this.uAj) && (!this.gBu))
    {
      dcl();
      setActionbarColor(getContext().getResources().getColor(2131101053));
      setMMTitle("");
      if (this.uAf != null)
      {
        this.uAf.setBackground(ao.aC(getContext(), 2130969307));
        this.uAf.setSupportOverscroll(true);
      }
      if (this.uAp != null) {
        this.uAp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26968);
            ad.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.k(ContactInfoUI.this);
            AppMethodBeat.o(26968);
          }
        });
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aKk("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null) {
          if ((!this.uAj) || (this.gBu)) {
            break label280;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.K(bool, this.uAp.getHeight());
      AppMethodBeat.o(27007);
      return;
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131099650));
      setMMTitle("");
      if (this.uAf != null)
      {
        this.uAf.setBackground(ao.aC(getContext(), 2130969308));
        this.uAf.setSupportOverscroll(false);
      }
      if (this.uAo == null) {
        break;
      }
      this.uAo.setPadding(0, 0, 0, 0);
      break;
      label280:
      bool = false;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(26999);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26999);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(26999);
  }
  
  public final void a(bw parambw)
  {
    AppMethodBeat.i(27001);
    aq.f(new ContactInfoUI.b(this, parambw));
    AppMethodBeat.o(27001);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(27000);
    new com.tencent.mm.sdk.platformtools.ap().post(new ContactInfoUI.a(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public final void dci()
  {
    AppMethodBeat.i(26983);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.uAj = false;
    if ((this.uAf != null) && (!this.uAf.isVisible))
    {
      showTitleView();
      dcm();
      this.uAf.ffR();
    }
    dco();
    AppMethodBeat.o(26983);
  }
  
  public final void dcj()
  {
    AppMethodBeat.i(26984);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.uAj = true;
    if ((this.uAf != null) && (this.uAf.isVisible)) {
      dco();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void dck()
  {
    AppMethodBeat.i(26985);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.uAf.ffR();
    AppMethodBeat.o(26985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJj().dTd = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.fId == 0) || (bt.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    ad.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.am.f.pc(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.am.f.wL(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.am.f.wK(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.eKB())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (w.pF(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (w.st(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (w.su(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (w.to(this.contact.field_username))
    {
      String str = "_" + this.contact.field_username;
      AppMethodBeat.o(26995);
      return str;
    }
    AppMethodBeat.o(26995);
    return "";
  }
  
  public int getResourceId()
  {
    return 2131951665;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26996);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.rso = getIntent().getStringExtra("Verify_ticket");
    this.uzZ = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.uAa = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = bt.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = bt.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    az.arV();
    this.contact = com.tencent.mm.model.c.apM().aHY(str1);
    this.ima = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.FxJ = str1;
    }
    com.tencent.mm.plugin.profile.b.hYu.a(this.contact);
    Object localObject6 = getIntent().getStringExtra("Contact_Nick");
    int j = getIntent().getIntExtra("Contact_Sex", 0);
    String str4 = getIntent().getStringExtra("Contact_Province");
    Object localObject7 = getIntent().getStringExtra("Contact_City");
    String str5 = getIntent().getStringExtra("Contact_Signature");
    int n = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    String str6 = getIntent().getStringExtra("Contact_VUser_Info");
    String str2 = getIntent().getStringExtra("Contact_Distance");
    int i1 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str7 = getIntent().getStringExtra("Contact_KWeibo");
    String str8 = getIntent().getStringExtra("Contact_KWeiboNick");
    String str3 = getIntent().getStringExtra("Contact_KFacebookName");
    long l = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.uAe = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.uAb = getIntent().getByteArrayExtra("Contact_customInfo");
    int i2 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    ad.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.roomId });
    Object localObject4;
    Object localObject8;
    label760:
    int k;
    label780:
    int m;
    int i;
    label1300:
    label1356:
    boolean bool1;
    if (bool2)
    {
      ad.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.n.b.ls(this.contact.field_type))) {
        ar.a.gMW.aB(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.fId == 0)) && (com.tencent.mm.storage.af.aHH(str1)) && (this.ima != 15))
      {
        localObject4 = bt.nullAsNil(getIntent().getStringExtra(e.c.FHR));
        localObject3 = localObject4;
        if (bt.isNullOrNil((String)localObject4)) {
          localObject3 = this.rso;
        }
        com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.openim.b.h(str1, bt.nullAsNil(this.roomId), (String)localObject3), 0);
      }
      if ((this.contact != null) && ((int)this.contact.fId > 0) && ((!w.tp(this.contact.field_username)) || ((com.tencent.mm.storage.af.aHG(this.contact.field_username)) && (!w.sC(this.contact.field_username)))))
      {
        if ((!this.contact.eKF()) || (!com.tencent.mm.storage.af.aHH(this.contact.field_username))) {
          break label2021;
        }
        localObject4 = bt.nullAsNil(getIntent().getStringExtra(e.c.FHR));
        localObject3 = localObject4;
        if (bt.isNullOrNil((String)localObject4)) {
          localObject3 = this.rso;
        }
        localObject8 = com.tencent.mm.kernel.g.afA().gcy;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
          break label2009;
        }
        localObject4 = "";
        ((q)localObject8).a(new com.tencent.mm.openim.b.h(str10, (String)localObject4, (String)localObject3), 0);
      }
      k = getIntent().getIntExtra("Contact_verify_Scene", 9);
      getIntent().getIntExtra("key_add_contact_match_type", 0);
      localObject3 = getIntent().getStringExtra("key_add_contact_openim_appid");
      m = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
      localObject4 = getIntent().getStringExtra("key_add_contact_custom_detail");
      getIntent().getStringExtra("key_add_contact_desc_wording_id");
      getIntent().getStringExtra("key_add_contact_desc_icon");
      if ((this.contact != null) && ((int)this.contact.fId != 0) && (bt.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2260;
      }
      this.contact = new com.tencent.mm.storage.af();
      this.contact.setUsername(str1);
      this.contact.na((String)localObject5);
      this.contact.nd((String)localObject6);
      this.contact.ne(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.nf(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.jJ(j);
      this.contact.nv(str4);
      this.contact.nw((String)localObject7);
      this.contact.nu(str5);
      this.contact.jF(n);
      this.contact.nz(str6);
      this.contact.nx(str2);
      this.contact.setFromType(k);
      this.contact.ny(str7);
      this.contact.jE(i1);
      this.contact.ng(str8);
      this.contact.kP(l);
      this.contact.np(str3);
      this.contact.nA(str9);
      this.contact.jQ(i2);
      if ((!bt.isNullOrNil(this.uAd)) && (this.ima == 15))
      {
        az.arV();
        localObject5 = com.tencent.mm.model.c.apN().agQ(str1);
        localObject6 = new bw(str1);
        ((bw)localObject6).field_conRemark = ((bw)localObject5).field_conRemark;
        ((bw)localObject6).field_conDescription = ((bw)localObject5).field_conDescription;
        ((bw)localObject6).field_contactLabels = ((bw)localObject5).field_contactLabels;
        ((bw)localObject6).field_conPhone = this.uAd;
        az.arV();
        com.tencent.mm.model.c.apN().replace((com.tencent.mm.sdk.e.c)localObject6);
        this.uAd = null;
      }
      this.contact.nJ((String)localObject4);
      this.contact.jR(m);
      this.contact.nm((String)localObject3);
      if ((com.tencent.mm.storage.af.aHH(this.contact.field_username)) && ((this.ima == 30) || (this.ima == 45) || (this.ima == 17)))
      {
        localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
        localObject4 = this.contact.field_openImAppid;
        if (this.ima != 17) {
          break label2887;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject3).f(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!bt.isNullOrNil((String)localObject1)) {
        this.contact.nj((String)localObject1);
      }
      if (this.contact != null) {
        break label2892;
      }
      ad.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.fId <= 0) && (this.contact.eKB()) && ((this.ima == 17) || (this.ima == 41)))
      {
        ad.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        ar.a.gMW.aB(this.contact.field_username, "");
        com.tencent.mm.ak.c.vO(this.contact.field_username);
      }
      if (this.contact.evI != null) {
        break label3002;
      }
      bool1 = true;
      label1480:
      if (this.contact.evI != null) {
        break label3008;
      }
      i = 0;
      label1492:
      if (this.contact.evI != null) {
        break label3022;
      }
    }
    label2051:
    label2887:
    label2892:
    label3022:
    for (localObject1 = "";; localObject1 = bt.aGs(this.contact.evI))
    {
      ad.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.fId <= 0) && (this.ima == 96))
      {
        ad.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        ar.a.gMW.aC(this.contact.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.ak.c.ac(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(u.aqG()))
      {
        az.arV();
        l = bt.getLong((String)com.tencent.mm.model.c.afk().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.kP(l);
          localObject1 = this.contact;
          az.arV();
          ((com.tencent.mm.storage.af)localObject1).np((String)com.tencent.mm.model.c.afk().get(65826, null));
        }
        localObject1 = this.contact;
        az.arV();
        ((com.tencent.mm.storage.af)localObject1).nD((String)com.tencent.mm.model.c.afk().get(286721, null));
        localObject1 = this.contact;
        az.arV();
        ((com.tencent.mm.storage.af)localObject1).nE((String)com.tencent.mm.model.c.afk().get(286722, null));
        localObject1 = this.contact;
        az.arV();
        ((com.tencent.mm.storage.af)localObject1).nF((String)com.tencent.mm.model.c.afk().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(com.tencent.mm.storage.af.aHM(u.aqG()))))
      {
        localObject1 = bs.asB();
        localObject3 = bt.nullAsNil(((bs)localObject1).getProvince());
        localObject4 = bt.nullAsNil(((bs)localObject1).getCity());
        if (!bt.isNullOrNil((String)localObject3)) {
          this.contact.nv((String)localObject3);
        }
        if (!bt.isNullOrNil((String)localObject4)) {
          this.contact.nw((String)localObject4);
        }
        if (!bt.isNullOrNil(((bs)localObject1).countryCode)) {
          this.contact.nA(RegionCodeDecoder.aT(((bs)localObject1).countryCode, ((bs)localObject1).provinceCode, ((bs)localObject1).cityCode));
        }
        i = bt.a(Integer.valueOf(((bs)localObject1).evp), 0);
        localObject1 = bt.nullAsNil(((bs)localObject1).signature);
        this.contact.jJ(i);
        this.contact.nu((String)localObject1);
      }
      if (!bt.isNullOrNil(this.contact.field_username)) {
        break label3037;
      }
      ad.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      ar.a.gMW.aB(str1, "");
      break;
      label2009:
      localObject4 = bt.nullAsNil(this.roomId);
      break label760;
      label2021:
      localObject3 = com.tencent.mm.am.f.ei(this.contact.field_username);
      if ((this.contact.eKB()) && (com.tencent.mm.am.a.avv()))
      {
        i = 1;
        if ((localObject3 != null) && ((!((com.tencent.mm.api.c)localObject3).IY()) || (i != 0))) {
          break label2157;
        }
        ad.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(n) });
        localObject4 = ar.a.gMW;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
          break label2148;
        }
      }
      label2148:
      for (localObject3 = "";; localObject3 = this.roomId)
      {
        ((ar.b)localObject4).aB((String)localObject8, (String)localObject3);
        com.tencent.mm.ak.c.vO(this.contact.field_username);
        break;
        i = 0;
        break label2051;
      }
      label2157:
      if ((!this.contact.eKF()) || (i != 0)) {
        break label780;
      }
      ad.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.evG) });
      localObject4 = ar.a.gMW;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.n.b.ls(this.contact.field_type)) {}
      for (localObject3 = "";; localObject3 = this.roomId)
      {
        ((ar.b)localObject4).aB((String)localObject8, (String)localObject3);
        com.tencent.mm.ak.c.vO(this.contact.field_username);
        break;
      }
      label2260:
      if (this.contact.evp == 0) {
        this.contact.jJ(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.nv(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.nw((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.nA(str9);
      }
      if ((bt.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.nu(str5);
      }
      if (n != 0) {
        this.contact.jF(n);
      }
      if ((bt.isNullOrNil(this.contact.evE)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.nz(str6);
      }
      if ((bt.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.nd((String)localObject6);
      }
      ad.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { bt.nullAsNil(this.uAd) });
      if ((!bt.isNullOrNil(this.uAd)) && (this.ima == 15))
      {
        j = 1;
        str4 = this.contact.evO;
        i = j;
        if (str4 != null)
        {
          localObject7 = com.tencent.mm.n.a.e(this.contact);
          i = j;
          if (localObject7 != null)
          {
            n = localObject7.length;
            j = 0;
          }
        }
      }
      for (;;)
      {
        i = 1;
        if (j < n)
        {
          if (localObject7[j].equals(this.uAd)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.nH(str4 + this.uAd + com.tencent.mm.n.a.d(this.contact));
            this.uAd = null;
          }
          ad.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { bt.nullAsNil(this.contact.evO) });
          this.contact.setSource(15);
          this.contact.nx(str2);
          this.contact.setFromType(k);
          this.contact.kP(l);
          this.contact.np(str3);
          if (!com.tencent.mm.n.b.ls(this.contact.field_type))
          {
            if (!bt.isNullOrNil((String)localObject5)) {
              this.contact.na((String)localObject5);
            }
            if (!bt.isNullOrNil((String)localObject6)) {
              this.contact.nd((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!bt.isNullOrNil((String)localObject5)) {
              this.contact.ne((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!bt.isNullOrNil((String)localObject5)) {
              this.contact.nf((String)localObject5);
            }
          }
          if ((!com.tencent.mm.n.b.ls(this.contact.field_type)) && (!bt.isNullOrNil((String)localObject4))) {
            this.contact.nJ((String)localObject4);
          }
          if ((!com.tencent.mm.n.b.ls(this.contact.field_type)) && (m != 0)) {
            this.contact.jR(m);
          }
          if (bt.isNullOrNil((String)localObject3)) {
            break;
          }
          this.contact.nm((String)localObject3);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1300;
      if (!bt.isNullOrNil((String)localObject1))
      {
        az.arV();
        localObject1 = com.tencent.mm.model.c.apN().agQ((String)localObject1);
        if ((localObject1 != null) && (!bt.isNullOrNil(((bw)localObject1).field_encryptUsername)))
        {
          this.contact.nb(((bw)localObject1).field_conRemark);
          break label1356;
        }
      }
      if (bt.isNullOrNil(str1)) {
        break label1356;
      }
      az.arV();
      localObject1 = com.tencent.mm.model.c.apN().agQ(str1);
      if ((localObject1 == null) || (bt.isNullOrNil(((bw)localObject1).field_encryptUsername))) {
        break label1356;
      }
      this.contact.nb(((bw)localObject1).field_conRemark);
      break label1356;
      bool1 = false;
      break label1480;
      i = this.contact.evI.length();
      break label1492;
    }
    label3002:
    label3008:
    label3037:
    setMMTitle("");
    Object localObject3 = this.uAe;
    if (w.sx(this.contact.field_username))
    {
      this.uzY = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gt(this);
      localObject1 = new gl();
      ((gl)localObject1).dZv = 2L;
      ((gl)localObject1).aBj();
      if (this.uzY != null)
      {
        this.uzY.a(this.screen, this.contact, this.uzZ, this.ima);
        localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.contact.field_username);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject3).aIA()).replace(" ", "");
        }
        if ((!this.uAq) && (com.tencent.mm.n.b.ls(this.contact.field_type)) && ((this.uzY instanceof k)))
        {
          j = com.tencent.mm.n.a.f(this.contact);
          if (!bt.isNullOrNil((String)localObject1)) {
            break label5087;
          }
          i = 0;
          label3227:
          j = i + j;
          localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
          localObject4 = this.contact.field_username;
          if (!bt.isNullOrNil((String)localObject1)) {
            break label5092;
          }
          i = 0;
          label3255:
          if (j < 5) {
            break label5097;
          }
          j = 5;
        }
      }
    }
    label5087:
    label5092:
    label5097:
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject3).f(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      this.uAq = true;
      if ((!(this.uzY instanceof k)) && (!(this.uzY instanceof c)) && (!(this.uzY instanceof ContactWidgetNewBizInfo)))
      {
        az.arV();
        localObject1 = (String)com.tencent.mm.model.c.afk().get(ae.a.Fph, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fph, localObject1);
          ad.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (bt.isNullOrNil((String)localObject1)) {
            com.tencent.mm.z.c.adr().x(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.aKk("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).K(this.uAj, this.uAp.getHeight());
        }
      }
      setBackBtn(new ContactInfoUI.6(this));
      p.auH().vQ(this.contact.field_username);
      if (((!w.sT(this.contact.field_username)) || (!u.arc())) && ((!w.sL(this.contact.field_username)) || (!u.aqY())) && ((!w.sN(this.contact.field_username)) || (!u.arh())) && ((!w.sH(this.contact.field_username)) || (!u.ark()))) {
        break label5100;
      }
      this.uAc = true;
      AppMethodBeat.o(26996);
      return;
      if (w.sy(this.contact.field_username))
      {
        this.uzY = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gu(this);
        break;
      }
      if (w.sw(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "sport");
        break;
      }
      if (w.sH(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "qqmail");
        break;
      }
      if (w.sI(this.contact.field_username))
      {
        this.uzY = new e(this);
        break;
      }
      if (w.sJ(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "tmessage");
        break;
      }
      if (w.sV(this.contact.field_username))
      {
        this.uzY = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (w.sB(this.contact.field_username))
      {
        this.uzY = new h(this);
        break;
      }
      if (w.sP(this.contact.field_username))
      {
        this.uzY = new m(this);
        break;
      }
      if (com.tencent.mm.storage.af.st(this.contact.field_username))
      {
        this.uzY = new d(this);
        break;
      }
      if (w.sR(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "nearby");
        break;
      }
      if (w.sS(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "shake");
        break;
      }
      if (w.sT(this.contact.field_username))
      {
        this.uzY = new j(this);
        break;
      }
      if (w.sU(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.P(this, "readerapp", "widget_type_news");
        break;
      }
      if (w.tc(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.P(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (w.sM(this.contact.field_username))
      {
        this.uzY = new f(this);
        break;
      }
      if (w.sN(this.contact.field_username))
      {
        this.uzY = com.tencent.mm.bs.d.aa(this, "masssend");
        break;
      }
      if (w.sO(this.contact.field_username))
      {
        this.uzY = new g(this);
        break;
      }
      if ((this.contact.eKB()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.uAb;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
            localObject2 = null;
            continue;
            if (!com.tencent.mm.am.f.wI((String)localObject4)) {
              continue;
            }
            bool1 = true;
            continue;
            if (localObject2 == null) {
              continue;
            }
            localObject4 = new com.tencent.mm.api.c();
            ((com.tencent.mm.api.c)localObject4).field_extInfo = ((zh)localObject2).ikb;
            ((com.tencent.mm.api.c)localObject4).field_type = ((com.tencent.mm.api.c)localObject4).bU(false).getServiceType();
            if (!((com.tencent.mm.api.c)localObject4).Jc()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!((com.tencent.mm.api.c)localObject4).Jb()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
              continue;
            }
            bool1 = true;
            continue;
            if ((com.tencent.mm.am.f.wL(this.contact.field_username)) || (com.tencent.mm.am.f.wK(this.contact.field_username)) || ((int)this.contact.fId > 0) || (!this.contact.eKB()) || ((this.ima != 17) && (this.ima != 41))) {
              continue;
            }
            bool1 = true;
            continue;
            bool1 = false;
            continue;
            localObject2 = new c(this, (String)localObject3, (zh)localObject2);
            if (bt.isNullOrNil(this.rso)) {
              continue;
            }
            ((c)localObject2).rso = this.rso;
            this.uzY = ((com.tencent.mm.pluginsdk.b.a)localObject2);
          }
          localObject4 = this.contact.field_username;
          if ((!aj.eFE().getBoolean("use_new_profile", true)) || (w.tw((String)localObject4)) || (w.sQ((String)localObject4)) || (w.tb((String)localObject4))) {
            continue;
          }
          if (!com.tencent.mm.am.f.wG((String)localObject4)) {
            continue;
          }
          bool1 = true;
          ad.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            continue;
          }
          localObject1 = new ContactWidgetNewBizInfo(this, (String)localObject3, (zh)localObject1);
          if (!bt.isNullOrNil(this.rso)) {
            ((ContactWidgetNewBizInfo)localObject1).rso = this.rso;
          }
          this.uzY = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject1 = (zh)new zh().parseFrom(this.uAb);
        }
        break;
      }
      if (w.sY(this.contact.field_username))
      {
        this.uzY = new n(this);
        break;
      }
      if (w.sZ(this.contact.field_username))
      {
        this.uzY = new i(this);
        break;
      }
      if (w.sA(this.contact.field_username))
      {
        this.uzY = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.uzY = new com.tencent.mm.plugin.profile.a(this);
      if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (this.uAg)) {
        break;
      }
      ad.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, bt.eGN().toString() });
      this.uAg = true;
      this.uAf = ((PullDownListView)getListView());
      this.uAf.setBackground(ao.aC(getContext(), 2130969307));
      this.uAf.HHP = this.uAn;
      i = -com.tencent.mm.ui.ap.cf(getContext()).y / 10;
      Object localObject2 = (RelativeLayout)findViewById(2131302325);
      localObject3 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ui.ap.cf(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-com.tencent.mm.ui.ap.eb(getContext()));
      if (this.contact.field_username.equals(u.aqG())) {}
      for (this.uAh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, n.a.ydd, this.roomId);; this.uAh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, n.a.yde, this.roomId))
      {
        this.uAh.dFU();
        this.uAf.A(this.uAh, com.tencent.mm.cd.a.ap(getContext(), 2131166721), i);
        this.uAh.setStoryBrowseUIListener(this);
        this.uAh.setDataSeed(this.contact.field_username);
        this.uAh.a(this.uAf);
        ((RelativeLayout)localObject2).addView(this.uAh, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.afC();
        this.uAi = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gc(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cd.a.ap(getContext(), 2131166720), com.tencent.mm.cd.a.ap(getContext(), 2131166720));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject2).addView(this.uAi, 0, (ViewGroup.LayoutParams)localObject3);
        this.uAf.setMuteView(this.uAi);
        this.uAf.setNavigationBarHeight(com.tencent.mm.ui.ap.eb(getContext()));
        this.uAm = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26977);
            ad.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.k(ContactInfoUI.this);
            AppMethodBeat.o(26977);
          }
        };
        localObject2 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJj().dTd = 3L;
        break;
      }
      i = 1;
      break label3227;
      i = 1;
      break label3255;
    }
    label5100:
    this.uAc = false;
    AppMethodBeat.o(26996);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26997);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
    }
    if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("_delete_ok_", false)))
    {
      setResult(-1, getIntent().putExtra("_delete_ok_", true));
      finish();
      AppMethodBeat.o(26997);
      return;
    }
    if (this.uzY != null) {
      this.uzY.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.uAh == null) || (!this.uAh.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.gBu = false;
    }
    for (;;)
    {
      if ((this.uAf != null) && (!this.uAf.isVisible)) {
        this.uAf.ffR();
      }
      dco();
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.gBu = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    az.arV();
    com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(bt.nullAsNil(getIntent().getStringExtra("Contact_User")));
    if (localaf != null)
    {
      com.tencent.mm.kernel.g.afC();
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localaf.field_username))
      {
        this.uAj = true;
        if (this.uAj) {
          customfixStatusbar(true);
        }
        super.onCreate(paramBundle);
        if (getResources().getConfiguration().orientation != 2) {
          break label220;
        }
      }
    }
    label220:
    for (boolean bool = true;; bool = false)
    {
      this.gBu = bool;
      this.uAo = findViewById(2131296345);
      this.uAp = this.uAo.findViewById(2131296347);
      dco();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      ad.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(az.afw()) });
      this.uAd = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.afz().aeI()) {
        break label225;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      this.uAj = false;
      break;
    }
    label225:
    az.arV();
    com.tencent.mm.model.c.apM().a(this);
    az.arV();
    com.tencent.mm.model.c.apN().a(this);
    initView();
    hideActionbarLine();
    if ((this.uzY instanceof com.tencent.mm.pluginsdk.b.b)) {
      ((com.tencent.mm.pluginsdk.b.b)this.uzY).onCreate();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
    paramBundle = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJj().dUv = com.tencent.mm.plugin.profile.c.aA(getIntent());
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(273, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJj().dUv = 0L;
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      az.arV();
      com.tencent.mm.model.c.apM().b(this);
      az.arV();
      com.tencent.mm.model.c.apN().b(this);
    }
    if (this.uzY == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.uzY != null) {
        this.uzY.bRu();
      }
      if ((this.uzY instanceof com.tencent.mm.pluginsdk.b.b)) {
        ((com.tencent.mm.pluginsdk.b.b)this.uzY).acO();
      }
      if (o.wzG != null) {
        o.wzG.az(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(273, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(291, this);
      if (this.uAh != null) {
        this.uAh.onDestroy();
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.h.vKh.f(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), this.contact.field_username, Boolean.valueOf(this.uAj), Boolean.valueOf(this.uAk), Integer.valueOf(this.contact.uin), Integer.valueOf(this.uAl) });
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.c(4, "ContactInfoUI" + getIdentString(), hashCode());
    com.tencent.mm.am.af.awe().remove(this);
    super.onPause();
    az.afE().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26972);
        az.arV();
        com.tencent.mm.model.c.afk().eKy();
        AppMethodBeat.o(26972);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.cWs();
      com.tencent.mm.plugin.newtips.a.i.an(com.tencent.mm.plugin.newtips.a.d.udT, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      dcm();
      if (this.uAh != null) {
        this.uAh.onPause();
      }
      if (((this.uzY instanceof c)) || ((this.uzY instanceof ContactWidgetNewBizInfo))) {
        this.uzY.bRu();
      }
      com.tencent.mm.pluginsdk.ui.span.k.b(this.mYs);
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.cWs();
        com.tencent.mm.plugin.newtips.a.i.an(com.tencent.mm.plugin.newtips.a.d.udR, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.uzY != null) {
      this.uzY.SN(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label140;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        dcn();
      }
      AppMethodBeat.o(26998);
      return false;
      label140:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27002);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27002);
      return;
    }
    ad.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27002);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dcN();
        }
        AppMethodBeat.o(27002);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26974);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = ContactInfoUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(26974);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26975);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(26975);
            }
          });
        }
        AppMethodBeat.o(27002);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dcM();
        }
        AppMethodBeat.o(27002);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26976);
          paramAnonymousDialogInterface = ContactInfoUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(26976);
        }
      }, null);
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(26992);
    super.onRestart();
    this.uAq = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.c(3, "ContactInfoUI" + getIdentString(), hashCode());
    com.tencent.mm.am.af.awe().add(this);
    super.onResume();
    Object localObject = ((ViewGroup)getContentView()).getFocusedChild();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      ad.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(((View)localObject).getId()) });
    }
    this.uAf = ((PullDownListView)getListView());
    if (this.uAh != null) {
      this.uAh.onResume();
    }
    if (this.screen != null)
    {
      localObject = (NormalProfileHeaderPreference)this.screen.aKk("contact_profile_header_normal");
      if (localObject != null) {
        ((NormalProfileHeaderPreference)localObject).K(this.uAj, this.uAp.getHeight());
      }
    }
    if (((this.uzY instanceof c)) || ((this.uzY instanceof ContactWidgetNewBizInfo))) {
      this.uzY.a(this.screen, this.contact, this.uzZ, this.ima);
    }
    com.tencent.mm.pluginsdk.ui.span.k.a(this.mYs);
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(27004);
    ad.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((273 == paramn.getType()) && (this.contact != null) && ((this.uzY instanceof com.tencent.mm.plugin.profile.a)) && (bt.kU(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramn).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramn).dep;
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      if (i == com.tencent.mm.plugin.story.i.a.dKk())
      {
        i = 1;
        if (i != 0) {
          if (((paramInt1 != 0) && (paramInt1 != 4)) || (paramInt2 == 315)) {
            break label176;
          }
        }
      }
      label176:
      for (boolean bool = true;; bool = false)
      {
        this.uAk = bool;
        this.uAl = ((com.tencent.mm.plugin.story.f.a.i)paramn).ygC;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramn.getType()) && (this.contact != null)) {
      new com.tencent.mm.sdk.platformtools.ap().post(new ContactInfoUI.a(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.uAh != null) {
      this.uAh.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.uAh != null) {
      this.uAh.onStop();
    }
    AppMethodBeat.o(26994);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */