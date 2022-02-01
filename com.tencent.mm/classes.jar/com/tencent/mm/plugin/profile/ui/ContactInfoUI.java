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
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
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
  implements com.tencent.mm.ak.f, f.a, com.tencent.mm.plugin.messenger.foundation.a.a.n.a, com.tencent.mm.plugin.story.api.g, k.a, n.b
{
  private an contact;
  private boolean hwM;
  private int jij;
  private com.tencent.mm.pluginsdk.ui.span.h ohO;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private c.a spA;
  private String tIA;
  private com.tencent.mm.pluginsdk.b.a xfP;
  private boolean xfQ;
  private boolean xfR;
  private byte[] xfS;
  private boolean xfT;
  String xfU;
  private String xfV;
  private PullDownListView xfW;
  private boolean xfX;
  private AbsStoryGallery xfY;
  private AbsStoryMuteView xfZ;
  private boolean xga;
  private boolean xgb;
  private int xgc;
  private long xgd;
  private View.OnClickListener xge;
  private PullDownListView.IPullDownCallback xgf;
  private View xgg;
  private View xgh;
  private boolean xgi;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.xfT = false;
    this.xfU = null;
    this.xfV = "";
    this.roomId = "";
    this.xfW = null;
    this.xfX = false;
    this.xfY = null;
    this.xfZ = null;
    this.xga = false;
    this.xgb = false;
    this.hwM = false;
    this.xgc = 0;
    this.xgd = 0L;
    this.xge = null;
    this.xgf = new ContactInfoUI.1(this);
    this.ohO = new ContactInfoUI.3(this);
    this.xgi = false;
    AppMethodBeat.o(26982);
  }
  
  private void dDN()
  {
    AppMethodBeat.i(26987);
    if ((this.xgg == null) || (!com.tencent.mm.ui.statusbar.c.KZw))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bn(this);
    c.a local4 = new c.a()
    {
      public final void ug(int paramAnonymousInt)
      {
        AppMethodBeat.i(26971);
        if (ContactInfoUI.f(ContactInfoUI.this)) {
          ContactInfoUI.g(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(26971);
      }
    };
    this.spA = local4;
    localc.a(local4);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.b(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void dDO()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void dDP()
  {
    AppMethodBeat.i(27006);
    if (this.hwM)
    {
      t.makeText(ak.getContext(), getResources().getString(2131764289), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.xga) && (this.xfW != null)) {
      this.xfW.fQZ();
    }
    AppMethodBeat.o(27006);
  }
  
  private void dDQ()
  {
    boolean bool = true;
    AppMethodBeat.i(27007);
    ae.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", new Object[] { Boolean.valueOf(this.xfX), Boolean.valueOf(this.xga) });
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    if ((this.xga) && (!this.hwM))
    {
      dDN();
      setActionbarColor(getContext().getResources().getColor(2131101053));
      setMMTitle("");
      if (this.xfW != null)
      {
        this.xfW.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969307));
        this.xfW.setSupportOverscroll(true);
      }
      if (this.xgh != null) {
        this.xgh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26968);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.m(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26968);
          }
        });
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aXe("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null) {
          if ((!this.xga) || (this.hwM)) {
            break label280;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.Q(bool, this.xgh.getHeight());
      AppMethodBeat.o(27007);
      return;
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131099650));
      setMMTitle("");
      if (this.xfW != null)
      {
        this.xfW.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969308));
        this.xfW.setSupportOverscroll(false);
      }
      if (this.xgg == null) {
        break;
      }
      this.xgg.setPadding(0, 0, 0, 0);
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
      ae.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26999);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(26999);
  }
  
  public final void a(bl parambl)
  {
    AppMethodBeat.i(186526);
    com.tencent.mm.sdk.platformtools.ar.f(new ContactInfoUI.b(this, parambl));
    AppMethodBeat.o(186526);
  }
  
  public final void a(cg paramcg)
  {
    AppMethodBeat.i(27001);
    com.tencent.mm.sdk.platformtools.ar.f(new ContactInfoUI.c(this, paramcg));
    AppMethodBeat.o(27001);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(27000);
    new com.tencent.mm.sdk.platformtools.aq().post(new ContactInfoUI.a(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public final void dDK()
  {
    AppMethodBeat.i(26983);
    ae.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.xga = false;
    if ((this.xfW != null) && (!this.xfW.isVisible))
    {
      showTitleView();
      dDO();
      this.xfW.fQY();
    }
    dDQ();
    AppMethodBeat.o(26983);
  }
  
  public final void dDL()
  {
    AppMethodBeat.i(26984);
    ae.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.xga = true;
    if ((this.xfW != null) && (this.xfW.isVisible)) {
      dDQ();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void dDM()
  {
    AppMethodBeat.i(26985);
    ae.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.xfW.fQY();
    AppMethodBeat.o(26985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.enI().emO = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.ght == 0) || (bu.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    ae.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.al.g.vz(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.al.g.Es(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.al.g.Er(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.fug())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (x.wb(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (x.Ac(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (x.Ad(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (x.AZ(this.contact.field_username))
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
    this.tIA = getIntent().getStringExtra("Verify_ticket");
    this.xfQ = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.xfR = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = bu.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = bu.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = bu.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(str1);
    this.jij = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.JeD = str1;
    }
    com.tencent.mm.plugin.profile.b.iUA.a(this.contact);
    Object localObject6 = getIntent().getStringExtra("Contact_Nick");
    int j = getIntent().getIntExtra("Contact_Sex", 0);
    String str4 = getIntent().getStringExtra("Contact_Province");
    Object localObject7 = getIntent().getStringExtra("Contact_City");
    String str5 = getIntent().getStringExtra("Contact_Signature");
    int m = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    String str6 = getIntent().getStringExtra("Contact_VUser_Info");
    String str2 = getIntent().getStringExtra("Contact_Distance");
    int n = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str7 = getIntent().getStringExtra("Contact_KWeibo");
    String str8 = getIntent().getStringExtra("Contact_KWeiboNick");
    String str3 = getIntent().getStringExtra("Contact_KFacebookName");
    long l = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.xfV = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.xfS = getIntent().getByteArrayExtra("Contact_customInfo");
    int i1 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    ae.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.roomId });
    Object localObject2;
    Object localObject8;
    label760:
    int k;
    label780:
    int i;
    label1290:
    label1346:
    boolean bool1;
    if (bool2)
    {
      ae.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.contact.c.lO(this.contact.field_type))) {
        au.a.hIG.aJ(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.ght == 0)) && (an.aUq(str1)) && (this.jij != 15))
      {
        localObject4 = bu.nullAsNil(getIntent().getStringExtra(e.c.JoX));
        localObject2 = localObject4;
        if (bu.isNullOrNil((String)localObject4)) {
          localObject2 = this.tIA;
        }
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.openim.b.h(str1, bu.nullAsNil(this.roomId), (String)localObject2), 0);
      }
      if ((this.contact != null) && ((int)this.contact.ght > 0) && ((!x.Ba(this.contact.field_username)) || ((an.aUp(this.contact.field_username)) && (!x.Am(this.contact.field_username)))))
      {
        if ((!this.contact.fuk()) || (!an.aUq(this.contact.field_username))) {
          break label2012;
        }
        localObject4 = bu.nullAsNil(getIntent().getStringExtra(e.c.JoX));
        localObject2 = localObject4;
        if (bu.isNullOrNil((String)localObject4)) {
          localObject2 = this.tIA;
        }
        localObject8 = com.tencent.mm.kernel.g.ajQ().gDv;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
          break label2000;
        }
        localObject4 = "";
        ((q)localObject8).a(new com.tencent.mm.openim.b.h(str10, (String)localObject4, (String)localObject2), 0);
      }
      getIntent().getIntExtra("Contact_verify_Scene", 9);
      getIntent().getIntExtra("key_add_contact_match_type", 0);
      localObject2 = getIntent().getStringExtra("key_add_contact_openim_appid");
      k = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
      localObject4 = getIntent().getStringExtra("key_add_contact_custom_detail");
      getIntent().getStringExtra("key_add_contact_desc_wording_id");
      getIntent().getStringExtra("key_add_contact_desc_icon");
      if ((this.contact != null) && ((int)this.contact.ght != 0) && (bu.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2251;
      }
      this.contact = new an();
      this.contact.setUsername(str1);
      this.contact.tl((String)localObject5);
      this.contact.to((String)localObject6);
      this.contact.tp(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.tq(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.kh(j);
      this.contact.tG(str4);
      this.contact.tH((String)localObject7);
      this.contact.tF(str5);
      this.contact.kd(m);
      this.contact.tK(str6);
      this.contact.tI(str2);
      this.contact.tJ(str7);
      this.contact.kc(n);
      this.contact.tr(str8);
      this.contact.qE(l);
      this.contact.tA(str3);
      this.contact.tL(str9);
      this.contact.ko(i1);
      if ((!bu.isNullOrNil(this.xfU)) && (this.jij == 15))
      {
        bc.aCg();
        localObject5 = com.tencent.mm.model.c.azG().arE(str1);
        localObject6 = new cg(str1);
        ((cg)localObject6).field_conRemark = ((cg)localObject5).field_conRemark;
        ((cg)localObject6).field_conDescription = ((cg)localObject5).field_conDescription;
        ((cg)localObject6).field_contactLabels = ((cg)localObject5).field_contactLabels;
        ((cg)localObject6).field_conPhone = this.xfU;
        bc.aCg();
        com.tencent.mm.model.c.azG().replace((com.tencent.mm.sdk.e.c)localObject6);
        this.xfU = null;
      }
      this.contact.tU((String)localObject4);
      this.contact.kp(k);
      this.contact.tx((String)localObject2);
      if ((an.aUq(this.contact.field_username)) && ((this.jij == 30) || (this.jij == 45) || (this.jij == 17)))
      {
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        localObject4 = this.contact.field_openImAppid;
        if (this.jij != 17) {
          break label2868;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.g)localObject2).f(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!bu.isNullOrNil((String)localObject1)) {
        this.contact.tu((String)localObject1);
      }
      if (this.contact != null) {
        break label2873;
      }
      ae.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.ght <= 0) && (this.contact.fug()) && ((this.jij == 17) || (this.jij == 41)))
      {
        ae.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        au.a.hIG.aJ(this.contact.field_username, "");
        com.tencent.mm.aj.c.Dv(this.contact.field_username);
      }
      if (this.contact.eRo != null) {
        break label2983;
      }
      bool1 = true;
      label1470:
      if (this.contact.eRo != null) {
        break label2989;
      }
      i = 0;
      label1482:
      if (this.contact.eRo != null) {
        break label3003;
      }
    }
    label2868:
    label2873:
    label3003:
    for (localObject1 = "";; localObject1 = bu.aSM(this.contact.eRo))
    {
      ae.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.ght <= 0) && (this.jij == 96))
      {
        ae.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        au.a.hIG.g(this.contact.field_username, 1, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.aj.c.al(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(v.aAC()))
      {
        bc.aCg();
        l = bu.getLong((String)com.tencent.mm.model.c.ajA().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.qE(l);
          localObject1 = this.contact;
          bc.aCg();
          ((an)localObject1).tA((String)com.tencent.mm.model.c.ajA().get(65826, null));
        }
        localObject1 = this.contact;
        bc.aCg();
        ((an)localObject1).tO((String)com.tencent.mm.model.c.ajA().get(286721, null));
        localObject1 = this.contact;
        bc.aCg();
        ((an)localObject1).tP((String)com.tencent.mm.model.c.ajA().get(286722, null));
        localObject1 = this.contact;
        bc.aCg();
        ((an)localObject1).tQ((String)com.tencent.mm.model.c.ajA().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(an.aUA(v.aAC()))))
      {
        localObject1 = bv.aCL();
        localObject2 = bu.nullAsNil(((bv)localObject1).getProvince());
        localObject4 = bu.nullAsNil(((bv)localObject1).getCity());
        if (!bu.isNullOrNil((String)localObject2)) {
          this.contact.tG((String)localObject2);
        }
        if (!bu.isNullOrNil((String)localObject4)) {
          this.contact.tH((String)localObject4);
        }
        if (!bu.isNullOrNil(((bv)localObject1).countryCode)) {
          this.contact.tL(RegionCodeDecoder.bg(((bv)localObject1).countryCode, ((bv)localObject1).provinceCode, ((bv)localObject1).cityCode));
        }
        i = bu.a(Integer.valueOf(((bv)localObject1).eQV), 0);
        localObject1 = bu.nullAsNil(((bv)localObject1).signature);
        this.contact.kh(i);
        this.contact.tF((String)localObject1);
      }
      if (!bu.isNullOrNil(this.contact.field_username)) {
        break label3018;
      }
      ae.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      au.a.hIG.aJ(str1, "");
      break;
      label2000:
      localObject4 = bu.nullAsNil(this.roomId);
      break label760;
      label2012:
      localObject2 = com.tencent.mm.al.g.eX(this.contact.field_username);
      if ((this.contact.fug()) && (com.tencent.mm.al.a.aFH()))
      {
        i = 1;
        label2042:
        if ((localObject2 != null) && ((!((com.tencent.mm.api.c)localObject2).Kp()) || (i != 0))) {
          break label2148;
        }
        ae.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(m) });
        localObject4 = au.a.hIG;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
          break label2139;
        }
      }
      label2139:
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((au.b)localObject4).aJ((String)localObject8, (String)localObject2);
        com.tencent.mm.aj.c.Dv(this.contact.field_username);
        break;
        i = 0;
        break label2042;
      }
      label2148:
      if ((!this.contact.fuk()) || (i != 0)) {
        break label780;
      }
      ae.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.eRm) });
      localObject4 = au.a.hIG;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {}
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((au.b)localObject4).aJ((String)localObject8, (String)localObject2);
        com.tencent.mm.aj.c.Dv(this.contact.field_username);
        break;
      }
      label2251:
      if (this.contact.eQV == 0) {
        this.contact.kh(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.tG(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.tH((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.tL(str9);
      }
      if ((bu.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.tF(str5);
      }
      if (m != 0) {
        this.contact.kd(m);
      }
      if ((bu.isNullOrNil(this.contact.eRk)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.tK(str6);
      }
      if ((bu.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.to((String)localObject6);
      }
      ae.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { bu.nullAsNil(this.xfU) });
      if ((!bu.isNullOrNil(this.xfU)) && (this.jij == 15))
      {
        j = 1;
        str4 = this.contact.eRu;
        i = j;
        if (str4 != null)
        {
          localObject7 = com.tencent.mm.contact.a.e(this.contact);
          i = j;
          if (localObject7 != null)
          {
            m = localObject7.length;
            j = 0;
          }
        }
      }
      for (;;)
      {
        i = 1;
        if (j < m)
        {
          if (localObject7[j].equals(this.xfU)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.tS(str4 + this.xfU + com.tencent.mm.contact.a.d(this.contact));
            this.xfU = null;
          }
          ae.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { bu.nullAsNil(this.contact.eRu) });
          this.contact.setSource(15);
          this.contact.tI(str2);
          this.contact.qE(l);
          this.contact.tA(str3);
          if (!com.tencent.mm.contact.c.lO(this.contact.field_type))
          {
            if (!bu.isNullOrNil((String)localObject5)) {
              this.contact.tl((String)localObject5);
            }
            if (!bu.isNullOrNil((String)localObject6)) {
              this.contact.to((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!bu.isNullOrNil((String)localObject5)) {
              this.contact.tp((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!bu.isNullOrNil((String)localObject5)) {
              this.contact.tq((String)localObject5);
            }
          }
          if ((!com.tencent.mm.contact.c.lO(this.contact.field_type)) && (!bu.isNullOrNil((String)localObject4))) {
            this.contact.tU((String)localObject4);
          }
          if ((!com.tencent.mm.contact.c.lO(this.contact.field_type)) && (k != 0)) {
            this.contact.kp(k);
          }
          if (bu.isNullOrNil((String)localObject2)) {
            break;
          }
          this.contact.tx((String)localObject2);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1290;
      if (!bu.isNullOrNil((String)localObject1))
      {
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azG().arE((String)localObject1);
        if ((localObject1 != null) && (!bu.isNullOrNil(((cg)localObject1).field_encryptUsername)))
        {
          this.contact.tm(((cg)localObject1).field_conRemark);
          break label1346;
        }
      }
      if (bu.isNullOrNil(str1)) {
        break label1346;
      }
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azG().arE(str1);
      if ((localObject1 == null) || (bu.isNullOrNil(((cg)localObject1).field_encryptUsername))) {
        break label1346;
      }
      this.contact.tm(((cg)localObject1).field_conRemark);
      break label1346;
      bool1 = false;
      break label1470;
      i = this.contact.eRo.length();
      break label1482;
    }
    label2983:
    label2989:
    label3018:
    setMMTitle("");
    Object localObject4 = this.xfV;
    if (x.Ag(this.contact.field_username))
    {
      this.xfP = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gO(this);
      localObject1 = new jj();
      ((jj)localObject1).etA = 2L;
      ((jj)localObject1).aLH();
      if (this.xfP != null)
      {
        this.xfP.a(this.screen, this.contact, this.xfQ, this.jij);
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.contact.field_username);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = bu.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).aTc()).replace(" ", "");
        }
        if ((!this.xgi) && (com.tencent.mm.contact.c.lO(this.contact.field_type)) && ((this.xfP instanceof k)))
        {
          j = com.tencent.mm.contact.a.f(this.contact);
          if (!bu.isNullOrNil((String)localObject1)) {
            break label5076;
          }
          i = 0;
          label3208:
          j = i + j;
          localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
          localObject4 = this.contact.field_username;
          if (!bu.isNullOrNil((String)localObject1)) {
            break label5081;
          }
          i = 0;
          label3236:
          if (j < 5) {
            break label5086;
          }
          j = 5;
        }
      }
    }
    label4266:
    label4310:
    label5081:
    label5086:
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject2).f(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      this.xgi = true;
      if ((!(this.xfP instanceof k)) && (!(this.xfP instanceof c)) && (!(this.xfP instanceof ContactWidgetNewBizInfo)))
      {
        bc.aCg();
        localObject1 = (String)com.tencent.mm.model.c.ajA().get(am.a.ITN, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.ITN, localObject1);
          ae.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (bu.isNullOrNil((String)localObject1)) {
            com.tencent.mm.y.c.ahI().x(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.aXe("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).Q(this.xga, this.xgh.getHeight());
        }
      }
      setBackBtn(new ContactInfoUI.6(this));
      p.aEP().Dx(this.contact.field_username);
      if (((!x.AD(this.contact.field_username)) || (!v.aBa())) && ((!x.Av(this.contact.field_username)) || (!v.aAW())) && ((!x.Ax(this.contact.field_username)) || (!v.aBg())) && ((!x.Ar(this.contact.field_username)) || (!v.aBk()))) {
        break label5089;
      }
      this.xfT = true;
      AppMethodBeat.o(26996);
      return;
      if (x.Ah(this.contact.field_username))
      {
        this.xfP = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gP(this);
        break;
      }
      if (x.Af(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "sport");
        break;
      }
      if (x.Ar(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "qqmail");
        break;
      }
      if (x.As(this.contact.field_username))
      {
        this.xfP = new e(this);
        break;
      }
      if (x.At(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "tmessage");
        break;
      }
      if (x.AF(this.contact.field_username))
      {
        this.xfP = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (x.Al(this.contact.field_username))
      {
        this.xfP = new h(this);
        break;
      }
      if (x.Az(this.contact.field_username))
      {
        this.xfP = new m(this);
        break;
      }
      if (an.Ac(this.contact.field_username))
      {
        this.xfP = new d(this);
        break;
      }
      if (x.AB(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "nearby");
        break;
      }
      if (x.AC(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "shake");
        break;
      }
      if (x.AD(this.contact.field_username))
      {
        this.xfP = new j(this);
        break;
      }
      if (x.AE(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.R(this, "readerapp", "widget_type_news");
        break;
      }
      if (x.AM(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.R(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (x.Aw(this.contact.field_username))
      {
        this.xfP = new f(this);
        break;
      }
      if (x.Ax(this.contact.field_username))
      {
        this.xfP = com.tencent.mm.br.d.ac(this, "masssend");
        break;
      }
      if (x.Ay(this.contact.field_username))
      {
        this.xfP = new g(this);
        break;
      }
      if ((this.contact.fug()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (localObject1 = null;; localObject1 = localObject2)
        {
          try
          {
            localObject2 = this.xfS;
            if (localObject2 != null) {
              break label4266;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
              continue;
              if (com.tencent.mm.al.g.Ep(localIOException))
              {
                bool1 = true;
              }
              else
              {
                if (localObject1 != null)
                {
                  localObject3 = new com.tencent.mm.api.c();
                  ((com.tencent.mm.api.c)localObject3).field_extInfo = ((aco)localObject1).jgk;
                  ((com.tencent.mm.api.c)localObject3).field_type = ((com.tencent.mm.api.c)localObject3).bX(false).getServiceType();
                  if (((com.tencent.mm.api.c)localObject3).Kt())
                  {
                    bool1 = true;
                    continue;
                  }
                  if (((com.tencent.mm.api.c)localObject3).Ks())
                  {
                    bool1 = true;
                    continue;
                  }
                }
                if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                  bool1 = true;
                } else if ((!com.tencent.mm.al.g.Es(this.contact.field_username)) && (!com.tencent.mm.al.g.Er(this.contact.field_username)) && ((int)this.contact.ght <= 0) && (this.contact.fug()) && ((this.jij == 17) || (this.jij == 41))) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            localObject1 = new c(this, (String)localObject4, (aco)localObject1);
            if (bu.isNullOrNil(this.tIA)) {
              break label4520;
            }
            ((c)localObject1).tIA = this.tIA;
            this.xfP = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          }
          localObject2 = this.contact.field_username;
          if ((!ak.fox().getBoolean("use_new_profile", true)) || (x.Bh((String)localObject2)) || (x.AA((String)localObject2)) || (x.AL((String)localObject2))) {
            break label4481;
          }
          if (!com.tencent.mm.al.g.En((String)localObject2)) {
            break label4310;
          }
          bool1 = true;
          ae.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            break label4487;
          }
          localObject1 = new ContactWidgetNewBizInfo(this, (String)localObject4, (aco)localObject1, this.xgd);
          if (!bu.isNullOrNil(this.tIA)) {
            ((ContactWidgetNewBizInfo)localObject1).tIA = this.tIA;
          }
          this.xfP = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject2 = (aco)new aco().parseFrom(this.xfS);
        }
        break;
      }
      if (x.AI(this.contact.field_username))
      {
        this.xfP = new n(this);
        break;
      }
      if (x.AJ(this.contact.field_username))
      {
        this.xfP = new i(this);
        break;
      }
      if (x.Ak(this.contact.field_username))
      {
        this.xfP = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.xfP = new com.tencent.mm.plugin.profile.a(this);
      if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (this.xfX)) {
        break;
      }
      ae.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, bu.fpN().toString() });
      this.xfX = true;
      this.xfW = ((PullDownListView)getListView());
      this.xfW.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969307));
      this.xfW.Lwa = this.xgf;
      i = -com.tencent.mm.ui.ar.ck(getContext()).y / 10;
      localObject1 = (RelativeLayout)findViewById(2131302325);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ui.ar.ck(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-com.tencent.mm.ui.ar.en(getContext()));
      if (this.contact.field_username.equals(v.aAC())) {}
      for (this.xfY = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.AZA, this.roomId);; this.xfY = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.AZB, this.roomId))
      {
        this.xfY.ekr();
        this.xfW.A(this.xfY, com.tencent.mm.cb.a.ay(getContext(), 2131166721), i);
        this.xfY.setStoryBrowseUIListener(this);
        this.xfY.setDataSeed(this.contact.field_username);
        this.xfY.a(this.xfW);
        ((RelativeLayout)localObject1).addView(this.xfY, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.ajS();
        this.xfZ = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gw(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.ay(getContext(), 2131166720), com.tencent.mm.cb.a.ay(getContext(), 2131166720));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject1).addView(this.xfZ, 0, (ViewGroup.LayoutParams)localObject3);
        this.xfW.setMuteView(this.xfZ);
        this.xfW.setNavigationBarHeight(com.tencent.mm.ui.ar.en(getContext()));
        this.xge = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26977);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.m(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26977);
          }
        };
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enI().emO = 3L;
        break;
      }
      i = 1;
      break label3208;
      i = 1;
      break label3236;
    }
    label4481:
    label4487:
    label4520:
    label5076:
    label5089:
    this.xfT = false;
    AppMethodBeat.o(26996);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26997);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
    }
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("_delete_ok_", false)))
    {
      setResult(-1, getIntent().putExtra("_delete_ok_", true));
      finish();
      AppMethodBeat.o(26997);
      return;
    }
    if (this.xfP != null) {
      this.xfP.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.xfY == null) || (!this.xfY.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1501, this.jij, this.xgd);
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.hwM = false;
    }
    for (;;)
    {
      if ((this.xfW != null) && (!this.xfW.isVisible)) {
        this.xfW.fQY();
      }
      dDQ();
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.hwM = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(bu.nullAsNil(getIntent().getStringExtra("Contact_User")));
    if (localan != null)
    {
      com.tencent.mm.kernel.g.ajS();
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localan.field_username))
      {
        this.xga = true;
        if (this.xga) {
          customfixStatusbar(true);
        }
        super.onCreate(paramBundle);
        if (getResources().getConfiguration().orientation != 2) {
          break label227;
        }
      }
    }
    label227:
    for (boolean bool = true;; bool = false)
    {
      this.hwM = bool;
      this.xgd = System.currentTimeMillis();
      this.xgg = findViewById(2131296345);
      this.xgh = this.xgg.findViewById(2131296347);
      dDQ();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      ae.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(bc.ajM()) });
      this.xfU = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.ajP().aiZ()) {
        break label232;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      this.xga = false;
      break;
    }
    label232:
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this);
    bc.aCg();
    com.tencent.mm.model.c.azG().a(this);
    bc.aCg();
    com.tencent.mm.model.c.azH().a(this);
    initView();
    hideActionbarLine();
    if ((this.xfP instanceof com.tencent.mm.pluginsdk.b.b)) {
      ((com.tencent.mm.pluginsdk.b.b)this.xfP).onCreate();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
    paramBundle = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.enI().eog = com.tencent.mm.plugin.profile.c.aH(getIntent());
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(273, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.enI().eog = 0L;
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      bc.aCg();
      com.tencent.mm.model.c.azF().b(this);
      bc.aCg();
      com.tencent.mm.model.c.azG().b(this);
      bc.aCg();
      com.tencent.mm.model.c.azH().b(this);
    }
    if (this.xfP == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.xfP != null) {
        this.xfP.ceC();
      }
      if ((this.xfP instanceof com.tencent.mm.pluginsdk.b.b)) {
        ((com.tencent.mm.pluginsdk.b.b)this.xfP).agO();
      }
      if (o.zsv != null) {
        o.zsv.aE(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(273, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(291, this);
      if (this.xfY != null) {
        this.xfY.onDestroy();
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.g.yxI.f(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), this.contact.field_username, Boolean.valueOf(this.xga), Boolean.valueOf(this.xgb), Integer.valueOf(this.contact.uin), Integer.valueOf(this.xgc) });
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
    ag.aGp().remove(this);
    super.onPause();
    bc.ajU().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26972);
        bc.aCg();
        com.tencent.mm.model.c.ajA().fuc();
        AppMethodBeat.o(26972);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.dxD();
      com.tencent.mm.plugin.newtips.a.i.aq(com.tencent.mm.plugin.newtips.a.d.wHT, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      dDO();
      if (this.xfY != null) {
        this.xfY.onPause();
      }
      if (((this.xfP instanceof c)) || ((this.xfP instanceof ContactWidgetNewBizInfo))) {
        this.xfP.ceC();
      }
      com.tencent.mm.pluginsdk.ui.span.k.b(this.ohO);
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.dxD();
        com.tencent.mm.plugin.newtips.a.i.aq(com.tencent.mm.plugin.newtips.a.d.wHR, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.xfP != null) {
      this.xfP.abx(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label140;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        dDP();
      }
      AppMethodBeat.o(26998);
      return false;
      label140:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27002);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27002);
      return;
    }
    ae.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27002);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dEp();
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
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dEo();
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.xgi = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    ag.aGp().add(this);
    super.onResume();
    Object localObject = ((ViewGroup)getContentView()).getFocusedChild();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      ae.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(((View)localObject).getId()) });
    }
    this.xfW = ((PullDownListView)getListView());
    if (this.xfY != null) {
      this.xfY.onResume();
    }
    if (this.screen != null)
    {
      localObject = (NormalProfileHeaderPreference)this.screen.aXe("contact_profile_header_normal");
      if (localObject != null) {
        ((NormalProfileHeaderPreference)localObject).Q(this.xga, this.xgh.getHeight());
      }
    }
    if (((this.xfP instanceof c)) || ((this.xfP instanceof ContactWidgetNewBizInfo))) {
      this.xfP.a(this.screen, this.contact, this.xfQ, this.jij);
    }
    com.tencent.mm.pluginsdk.ui.span.k.a(this.ohO);
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(27004);
    ae.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((273 == paramn.getType()) && (this.contact != null) && ((this.xfP instanceof com.tencent.mm.plugin.profile.a)) && (bu.lX(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramn).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramn).doj;
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      if (i == com.tencent.mm.plugin.story.i.a.eoJ())
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
        this.xgb = bool;
        this.xgc = ((com.tencent.mm.plugin.story.f.a.i)paramn).BcZ;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramn.getType()) && (this.contact != null)) {
      new com.tencent.mm.sdk.platformtools.aq().post(new ContactInfoUI.a(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.xfY != null) {
      this.xfY.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.xfY != null) {
      this.xfY.onStop();
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